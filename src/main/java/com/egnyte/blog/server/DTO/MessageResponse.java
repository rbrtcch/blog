package com.egnyte.blog.server.DTO;



public class MessageResponse {
    public Long userId;
    public String message;

    public MessageResponse(Long userId, String message) {
        this.userId = userId;
        this.message = message;
    }
}
