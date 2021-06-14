package com.egnyte.blog.server.DTO;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;


@Getter
public class BlogResponse {
    private Long id;
    private String authorName;
    private String subject;
    private String authorUserName;
    private String content;
    private String modificationDate;
    private List<String> tags;

    public BlogResponse(Long id, String authorName, String subject, String authorUserName, String content, String modificationDate, ArrayList<String> tags) {
        this.id = id;
        this.authorName = authorName;
        this.subject = subject;
        this.authorUserName = authorUserName;
        this.content = content;
        this.modificationDate = modificationDate;
        this.tags = tags;

    }


}
