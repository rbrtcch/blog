package com.egnyte.blog.server.DAO;


import com.egnyte.blog.server.domain.SubscriptionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface SubscriptionDAO extends JpaRepository<SubscriptionEntity, Long> {
   public List<SubscriptionEntity> findByauthorName(String authorUserName);
   public List<Long> findUserIdByauthorName(String authorUserName);

}