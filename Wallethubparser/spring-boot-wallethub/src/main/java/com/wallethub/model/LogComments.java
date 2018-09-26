package com.wallethub.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class LogComments {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    public String logip;
    public String logComment;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getLogip() {
        return logip;
    }
    public void setLogip(String logip) {
        this.logip = logip;
    }
    public String getLogComment() {
        return logComment;
    }
    public void setLogComment(String logComment) {
        this.logComment = logComment;
    }

}