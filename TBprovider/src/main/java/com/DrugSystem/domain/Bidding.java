package com.DrugSystem.domain;

import java.util.Date;

public class Bidding {
    private int id;
    private String legalName;
    private String phone;
    private String zbnumber;
    private String number;
    private String companName;
    private String bailTotal;
    private String announcer;
    private Date date;
    private int status;

    public Bidding() {
    }

    public Bidding(int id, String legalName, String phone, String zbnumber, String number, String companName, String bailTotal, String announcer, Date date, int status) {
        this.id = id;
        this.legalName = legalName;
        this.phone = phone;
        this.zbnumber = zbnumber;
        this.number = number;
        this.companName = companName;
        this.bailTotal = bailTotal;
        this.announcer = announcer;
        this.date = date;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Bidding{" +
                "id=" + id +
                ", legalName='" + legalName + '\'' +
                ", phone='" + phone + '\'' +
                ", zbnumber='" + zbnumber + '\'' +
                ", number='" + number + '\'' +
                ", companName='" + companName + '\'' +
                ", bailTotal='" + bailTotal + '\'' +
                ", announcer='" + announcer + '\'' +
                ", date=" + date +
                ", status=" + status +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLegalName() {
        return legalName;
    }

    public void setLegalName(String legalName) {
        this.legalName = legalName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getZbnumber() {
        return zbnumber;
    }

    public void setZbnumber(String zbnumber) {
        this.zbnumber = zbnumber;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCompanName() {
        return companName;
    }

    public void setCompanName(String companName) {
        this.companName = companName;
    }

    public String getBailTotal() {
        return bailTotal;
    }

    public void setBailTotal(String bailTotal) {
        this.bailTotal = bailTotal;
    }

    public String getAnnouncer() {
        return announcer;
    }

    public void setAnnouncer(String announcer) {
        this.announcer = announcer;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
