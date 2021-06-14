package com.egnyte.blog.server.support.exception;

public class SubscriptionNotFoundExcepion extends RuntimeException{
    public SubscriptionNotFoundExcepion(Long id){
        super(String.format("Subscription with %d not found: ", id ));
}
}