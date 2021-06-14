package com.egnyte.blog.server.support.exception;

public class BadRequestException extends RuntimeException {
    public BadRequestException() {
        super(String.format("Bad request data "));
    }
}