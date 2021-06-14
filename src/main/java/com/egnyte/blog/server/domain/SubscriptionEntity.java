package com.egnyte.blog.server.domain;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
@Setter
@Getter
@Entity

@NamedQuery(name = "SubscriptionEntity.findByauthorName", query = "SELECT s  FROM SubscriptionEntity s WHERE LOWER(s.authorUserName) = LOWER(?1)")
@NamedQuery(name = "SubscriptionEntity.findUserIdByauthorName", query = "SELECT distinct s.userId  FROM SubscriptionEntity s WHERE LOWER(s.authorUserName) = LOWER(?1)")
@Table(name = "subscriptions")
public class SubscriptionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false) private Long id;
    @Column(name = "userId")  private Long userId;
    @Column(name = "authorUserName") private String authorUserName;
    public SubscriptionEntity() {

    }
    public SubscriptionEntity(Long userId, String authorUserName){
        this.userId = userId;
        this.authorUserName = authorUserName;
    }

    public Long getSubscriptionId() {
        return id;
    }

}
