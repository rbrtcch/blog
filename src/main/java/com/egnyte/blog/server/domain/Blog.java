package com.egnyte.blog.server.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
//@AllArgsConstructor
@Entity
@Table(name = "blogs")
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false) public Long id;
    @Column(name = "autor") private String authorName;
    @Column(name = "subject") private String subject;
    @Column(name = "authorusername") private String authorUserName;
    @Column(name = "content") private String content;
    @Column(name = "modificationdate") private String modificationDate;
//    @Column(name = "tags") private  String tags;
    @Column(name = "tags") private ArrayList<String> tags;

//String modificationDate,
    public Blog( String authorName, String subject, String authorUserName, String content, String modificationDate, ArrayList<String> tags) {


        this.authorName = authorName;
        this.subject = subject;
        this.authorUserName = authorUserName;
        this.content = content;
        this.modificationDate = modificationDate;
        this.tags = tags;
    }
    public Blog(){

    };

}
