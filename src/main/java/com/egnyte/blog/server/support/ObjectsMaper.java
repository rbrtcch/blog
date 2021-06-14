package com.egnyte.blog.server.support;

import com.egnyte.blog.server.DTO.BlogRequest;
import com.egnyte.blog.server.DTO.BlogResponse;
import com.egnyte.blog.server.DTO.SubscriptionResponse;
import com.egnyte.blog.server.domain.Blog;
import com.egnyte.blog.server.DTO.*;
import com.egnyte.blog.server.DTO.MessageResponse;
import com.egnyte.blog.server.domain.SubscriptionEntity;
import org.springframework.stereotype.Component;

import java.util.*;

//import java.util.ArrayList;

@Component

public class ObjectsMaper {
    public Blog toBlog(BlogRequest blogRequest) {
        return new Blog(blogRequest.getAuthorName(),
                blogRequest.getSubject(),
                blogRequest.getAuthorUserName(),
                blogRequest.getContent(),
                blogRequest.getModificationDate(),
                blogRequest.getTags());


    }

    public BlogResponse toBlogResponse(Blog blog) {
        return new BlogResponse(blog.getId()

                , blog.getAuthorName()
                , blog.getSubject()
                , blog.getAuthorUserName()
                , blog.getContent()
                , blog.getModificationDate()
                , blog.getTags());

    }

    public SubscriptionResponse toSupscriptionResponse(SubscriptionEntity subscriptionEntity) {
        return new SubscriptionResponse(subscriptionEntity.getSubscriptionId());
    }

    public SubscriptionEntity toSubstription(SubscriptionRequest substripionRequest) {
        return new SubscriptionEntity(substripionRequest.getUserId(),
                substripionRequest.getAuthorUserName());
    }

    public MessageResponse toMessageRespose(Long userId, String authorUserName) {
        String messageNotification = "Twój ulubiony autor opublikował post " + authorUserName;
        return new MessageResponse(userId, messageNotification);
    }

    public List<Notification> toMessageList(List<Long> userId, String authorUserName) {
        List<Notification> messageList = new ArrayList<>();
        String messageNotification = "Twój ulubiony autor opublikował post " + authorUserName;
        for (int i = 0; i <= userId.size(); i++) { messageList.add(new Notification(userId.get(i), messageNotification)); }
        return messageList;
    }
}


