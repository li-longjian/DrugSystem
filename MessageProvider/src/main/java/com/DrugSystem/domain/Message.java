package com.DrugSystem.domain;

import java.util.Date;

public class Message {
    private int id;
    private String announcer;
    private String describe;
    private int status;
    private String companyName;
    private Date date;

    public Message() {
    }

    public Message(int id, String announcer, String describe, int status, String companyName, Date date) {
        this.id = id;
        this.announcer = announcer;
        this.describe = describe;
        this.status = status;
        this.companyName = companyName;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAnnouncer() {
        return announcer;
    }

    public void setAnnouncer(String announcer) {
        this.announcer = announcer;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
