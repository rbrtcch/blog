package com.egnyte.blog.server.support;

import com.egnyte.blog.server.support.exception.BlogNotFoundExcepion;
import com.egnyte.blog.server.support.exception.SubscriptionNotFoundExcepion;
import java.util.function.Supplier;

public class BlogExceptionSupplier {
    public static Supplier<BlogNotFoundExcepion>  BlogNotFound(Long id){
        return () -> new BlogNotFoundExcepion(id);
        }
    public static Supplier<SubscriptionNotFoundExcepion> SubscriptionNotFound(Long id) {return () -> new SubscriptionNotFoundExcepion(id);}

    }