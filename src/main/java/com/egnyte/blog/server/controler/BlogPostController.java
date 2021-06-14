package com.egnyte.blog.server.controler;

import com.egnyte.blog.server.DAO.SubscriptionDAO;
import com.egnyte.blog.server.DTO.*;
import com.egnyte.blog.server.service.BlogService;
import com.egnyte.blog.server.support.ObjectsMaper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/")
public class BlogPostController<response> {
    private final BlogService blogService;
    private SubscriptionDAO subscriptionDAO;
    private final Logger log = LogManager.getLogger(getClass());


    public BlogPostController(BlogService blogService, SubscriptionDAO subscriptionDAO) {
        this.blogService = blogService;
        this.subscriptionDAO = subscriptionDAO;

          }


    @PostMapping("/subscription")
    public ResponseEntity<SubscriptionResponse> createSubscription(@RequestBody SubscriptionRequest subscriptionRequest)  {
        SubscriptionResponse subscriptionResponse = blogService.createSubscription(subscriptionRequest);
        return new ResponseEntity<>(subscriptionResponse, HttpStatus.CREATED);
    }
    @DeleteMapping("/subscription/{subscriptionId}")
    public ResponseEntity<Void> deleteSubscription(@PathVariable Long subscriptionId ) {
        blogService.deleteSubscriptionId(subscriptionId);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
    @PostMapping("/blogPostCreate")
    public ResponseEntity<BlogResponse> create(@RequestBody BlogRequest blogRequest) {
        BlogResponse blogResponse = blogService.create(blogRequest);
        ObjectsMaper objectsMaper = new ObjectsMaper();
        try{blogService.CreateNotification(blogRequest);}
        catch(Exception e){log.error("Connection to notification service problem  for " + blogRequest.getAuthorUserName());}
//        blogService.callPost();
        return new ResponseEntity<>(blogResponse, HttpStatus.OK);
    }


    @GetMapping("/blogPostGet")
    public ResponseEntity<BlogResponse> find(@RequestParam Long postId){
        BlogResponse blogResponse = blogService.find(postId);
        return new ResponseEntity<>(blogResponse, HttpStatus.OK);
    }



}
