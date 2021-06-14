package com.egnyte.blog.server.support;

import com.egnyte.blog.server.DTO.*;
import com.egnyte.blog.server.domain.Blog;
import com.egnyte.blog.server.domain.SubscriptionEntity;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.Null;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ObjectsMaperTest {

    @Test
    void toBlog() {
        //given
        ArrayList<String> tag = new ArrayList<String>();
        tag.add("tag1");
        BlogRequest blogRequestTest = new BlogRequest("authorName", "subject", "authorUserName", "content", tag);
        ObjectsMaper objectsMaper = new ObjectsMaper();
        //when
        Blog blogActual = objectsMaper.toBlog(blogRequestTest);
        //then
        assertEquals(blogRequestTest.getId(),blogActual.getId());
        assertEquals(blogRequestTest.getAuthorName(),blogActual.getAuthorName());
        assertEquals(blogRequestTest.getAuthorUserName(),blogActual.getAuthorUserName());
        assertEquals(blogRequestTest.getContent(),blogActual.getContent());
        assertEquals(blogRequestTest.getModificationDate(),blogActual.getModificationDate());
        assertEquals(blogRequestTest.getSubject(),blogActual.getSubject());
        assertEquals(blogRequestTest.getTags(),blogActual.getTags());
    }

    @Test
    void toBlogResponseShouldMappingProperData() {
        //given
        ArrayList<String> tag = new ArrayList<String>();
        tag.add("tag1");
      Blog blogTest = new Blog("authorName", "subject", "authorUserName", "content", "modificationDate",tag);
      blogTest.setId(1L);
      ObjectsMaper objectsMaper = new ObjectsMaper();
      BlogResponse blogResponseTestExpected = new BlogResponse(1L,"authorName", "subject", "authorUserName", "content", "modificationDate",tag);
        //when
      BlogResponse blogResponseTest = objectsMaper.toBlogResponse(blogTest);
        //then


        assertEquals(blogResponseTestExpected.getId(),blogResponseTest.getId());
        assertEquals(blogResponseTestExpected.getAuthorName(),blogResponseTest.getAuthorName());
        assertEquals(blogResponseTestExpected.getAuthorUserName(),blogResponseTest.getAuthorUserName());
        assertEquals(blogResponseTestExpected.getContent(),blogResponseTest.getContent());
        assertEquals(blogResponseTestExpected.getModificationDate(),blogResponseTest.getModificationDate());
        assertEquals(blogResponseTestExpected.getSubject(),blogResponseTest.getSubject());
        assertEquals(blogResponseTestExpected.getTags(),blogResponseTest.getTags());

    }

    @Test
    void toSupscriptionResponseShouldSetId() {
        //given
        Long id = 1L;
        ObjectsMaper objectsMaper = new ObjectsMaper();
        SubscriptionEntity subscriptionEntityTest = new SubscriptionEntity(102L,"AuthorName");
        subscriptionEntityTest.setId(id);
        //when
        SubscriptionResponse subscriptionResponse = objectsMaper.toSupscriptionResponse(subscriptionEntityTest);
        //then
        assertEquals(id,subscriptionResponse.getId());
    }




        @Test
    void toSubstriptionShouldProperMappingSubscriptionEntity() {
        //given
        Long userId = 200L;
        String authoUserName = "authorName";
        ObjectsMaper objectsMaper = new ObjectsMaper();
        SubscriptionRequest subscriptionRequest = new SubscriptionRequest(userId,authoUserName);
        //when
        SubscriptionEntity subscriptionEntityTest = objectsMaper.toSubstription(subscriptionRequest);
        //then
        assertEquals(null, subscriptionEntityTest.getId());
        assertEquals(userId, subscriptionEntityTest.getUserId());
        assertEquals(authoUserName, subscriptionEntityTest.getAuthorUserName());
    }




    @Test
    void toMessageResposeShouldReturnProperMessage() {
        //given
        Long userId = 103L;
        String message = "authorName";
        ObjectsMaper objectsMaper = new ObjectsMaper();
        MessageResponse messageResponseTest = new MessageResponse(103L,"Twój ulubiony autor opublikował post authorName");

        //when
        MessageResponse messageResponse = objectsMaper.toMessageRespose(userId,message);

        //then
       assertEquals(messageResponseTest.userId, messageResponse.userId);
       assertEquals(messageResponseTest.message,messageResponse.message);



    }
}

