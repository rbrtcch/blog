package com.egnyte.blog.server.DTO;

import lombok.Getter;

@Getter
public class SubscriptionRequest {
    public Long userId;
    public String authorUserName;

    public SubscriptionRequest(Long userId, String authorUserName) {
        this.userId = userId;
        this.authorUserName = authorUserName;
}
}
