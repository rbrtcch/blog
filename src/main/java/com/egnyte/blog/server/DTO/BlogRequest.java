package com.egnyte.blog.server.DTO;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;


@Getter
public class BlogRequest {
    private Long id;
    private String authorName;
    private String subject;
    private String authorUserName;
    private String content;
    private String modificationDate;
    private ArrayList<String> tags;

    @JsonCreator
    public BlogRequest(String authorName
            , String subject
            , String authorUserName
            , String content
            , ArrayList<String> tags) {
        this.authorName = authorName;
        this.subject = subject;
        this.authorUserName = authorUserName;
        this.content = content;
        this.tags = tags;
    }

    public void setModificationDate(String modificationDate) {
        this.modificationDate = modificationDate;
    }
}
