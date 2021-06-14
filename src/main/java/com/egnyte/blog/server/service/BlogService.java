package com.egnyte.blog.server.service;


import com.egnyte.blog.server.domain.Blog;
import com.egnyte.blog.server.DAO.BlogDAO;
import com.egnyte.blog.server.DAO.SubscriptionDAO;
import com.egnyte.blog.server.DTO.*;
import com.egnyte.blog.server.domain.SubscriptionEntity;
import com.egnyte.blog.server.support.BlogExceptionSupplier;
import com.egnyte.blog.server.support.ObjectsMaper;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service
public class BlogService {
    private BlogDAO blogDAO;
    private SubscriptionDAO subscriptionDAO;
    private final ObjectsMaper objectsMaper;


    public BlogService( BlogDAO blogDAO, ObjectsMaper objectsMaper, SubscriptionDAO subscriptionDAO) {
        this.blogDAO = blogDAO;
        this.objectsMaper = objectsMaper;
        this.subscriptionDAO = subscriptionDAO;

//
    }
    public BlogResponse create(BlogRequest blogRequest)  {
        Date date = new Date();
        Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String modificationDate = formatter.format(date);
        blogRequest.setModificationDate(modificationDate);
        Blog blog = blogDAO.save(objectsMaper.toBlog(blogRequest));
        return objectsMaper.toBlogResponse(blog);
            }

    public  BlogResponse find(Long id){
            Blog blog = blogDAO.findById(id).orElseThrow(BlogExceptionSupplier.BlogNotFound(id));
            return objectsMaper.toBlogResponse(blog);
    }

    public SubscriptionResponse createSubscription(SubscriptionRequest subscriptionRequest) {
        SubscriptionEntity subscriptionEntity = subscriptionDAO.save(objectsMaper.toSubstription(subscriptionRequest));
        return objectsMaper.toSupscriptionResponse(subscriptionEntity);
    }

    public void deleteSubscriptionId(Long subscriptionId) {
        SubscriptionEntity subscriptionEntity = subscriptionDAO.findById(subscriptionId)
                .orElseThrow(BlogExceptionSupplier.SubscriptionNotFound(subscriptionId));
        subscriptionDAO.delete(subscriptionEntity);
    }
    public void   CreateNotification(BlogRequest blogRequest){
        List<Long> userListForNotification = subscriptionDAO.findUserIdByauthorName(blogRequest.getAuthorUserName());
        if (userListForNotification.size()>0) {
            final String uri = "http://localhost:8093/sendNotification";
            List<Notification> messageList = new ArrayList<>();
            String messageNotification = "Twój ulubiony autor opublikował post " + blogRequest.getAuthorUserName();
            userListForNotification.forEach(userId -> messageList.add(new Notification(userId, messageNotification)));
            RestTemplate restTemplate = new RestTemplate();
//            restTemplate.put(uri, objectsMaper.toMessageList(userListForNotification, blogRequest.getAuthorUserName()));
            restTemplate.put(uri, messageList);
//          ResponseEntity responseEntity = new RestTemplate().postForEntity(uri, messageList, ResponseEntity.class);

        }
    }


    public void callPost() {

        RestTemplate rest = new RestTemplate();
        List<Notification> messageList = new ArrayList<>();
        messageList.add(new Notification(10L, "Przemek"));
        messageList.add( new Notification(101L, "Przemek"));
        HttpEntity<List<Notification>> httpEntity = new HttpEntity<>(messageList, new HttpHeaders());
        ResponseEntity<String> exchange = rest.exchange(
                "http://localhost:8093/sendNotification",
                HttpMethod.POST,
                httpEntity,
                String.class);

//        return exchange.getBody();
    }


}
