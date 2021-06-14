package com.egnyte.blog.server.support;

import com.egnyte.blog.server.ErrorMessageResponse;
import com.egnyte.blog.server.support.exception.BlogNotFoundExcepion;

import com.egnyte.blog.server.support.exception.SubscriptionNotFoundExcepion;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class BlogExceptionAdvisor {
    private static final Logger LOG = LoggerFactory.getLogger(BlogExceptionAdvisor.class);
    @ExceptionHandler(BlogNotFoundExcepion.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ErrorMessageResponse blogNotFound(Exception exception) {
        LOG.error(exception.getMessage(), exception);
        return new ErrorMessageResponse(exception.getLocalizedMessage() );
    }
    @ExceptionHandler(SubscriptionNotFoundExcepion.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ErrorMessageResponse subscriptionNotFound(Exception exception) {
        LOG.error(exception.getMessage(), exception);
        return new ErrorMessageResponse(exception.getLocalizedMessage() );
    }

}
