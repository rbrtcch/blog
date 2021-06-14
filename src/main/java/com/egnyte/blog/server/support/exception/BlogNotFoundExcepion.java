package com.egnyte.blog.server.support.exception;

public class BlogNotFoundExcepion extends RuntimeException{
    public BlogNotFoundExcepion(Long id){
        super(String.format("Blog with %d not found: ", id ));
}
}