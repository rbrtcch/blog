package com.egnyte.blog.server.DTO;

import lombok.Getter;


@Getter
public class SubscriptionResponse {

     public Long id;

     public SubscriptionResponse(Long id){
        this.id = id;
    }
    public SubscriptionResponse(){}
}
