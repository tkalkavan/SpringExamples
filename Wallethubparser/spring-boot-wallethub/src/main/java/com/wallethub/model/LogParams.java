package com.wallethub.model;


import com.wallethub.model.Converter.LocalDateTimeAttributeConverter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@Entity
public class LogParams {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String logip;
    private String logMethod;
    private String logResponse;
    private String logUserAgent;

    //Prefer to use hold date with LocalDateTime rahther than Date.
    @Convert(converter = LocalDateTimeAttributeConverter.class)
    private LocalDateTime logDate;

    public LogParams(){}

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
    public String getLogMethod() {
        return logMethod;
    }
    public void setLogMethod(String logMethod) {
        this.logMethod = logMethod;
    }
    public String getLogResponse() {
        return logResponse;
    }
    public void setLogResponse(String logResponse) {
        this.logResponse = logResponse;
    }
    public String getLogUserAgent() {
        return logUserAgent;
    }
    public void setLogUserAgent(String logUserAgent) {
        this.logUserAgent = logUserAgent;
    }
    public LocalDateTime getLogDate() {
        return logDate;
    }
    public void setLogDate(LocalDateTime logDate) {
        this.logDate = logDate;
    }

    public LogParams(String logDate,String logip,String logMethod,String logResponse,String logUserAgent)
    {


        this.logip=logip;
        this.logMethod=logMethod;
        this.logResponse=logResponse;
        this.logUserAgent=logUserAgent;
        this.logDate=LocalDateTime.parse(logDate, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS"));


    }



}



