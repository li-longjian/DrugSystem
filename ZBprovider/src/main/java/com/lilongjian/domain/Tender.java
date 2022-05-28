package com.lilongjian.domain;


import java.util.Date;

public class Tender {
    private int id;
    private String number;//招标编号
    private String companyName;
    private String packaged;//包装要求
    private String total;//需求总量
    private Date expirationDate;//过期时间
    private Date date;//发布时间
    private String durgName;
    private String announcer;//发布者id
    private int status;//状态
    private String marked;//留言

    public Tender() {
    }

    public Tender(int id, String number, String companyName, String packaged, String total, Date expirationDate, Date date, String durgName, String announcer, int status, String marked) {
        this.id = id;
        this.number = number;
        this.companyName = companyName;
        this.packaged = packaged;
        this.total = total;
        this.expirationDate = expirationDate;
        this.date = date;
        this.durgName = durgName;
        this.announcer = announcer;
        this.status = status;
        this.marked = marked;
    }

    @Override
    public String toString() {
        return "Tender{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", companyName='" + companyName + '\'' +
                ", packaged='" + packaged + '\'' +
                ", total='" + total + '\'' +
                ", expirationDate=" + expirationDate +
                ", date=" + date +
                ", durgName='" + durgName + '\'' +
                ", announcer='" + announcer + '\'' +
                ", status=" + status +
                ", marked='" + marked + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getPackaged() {
        return packaged;
    }

    public void setPackaged(String packaged) {
        this.packaged = packaged;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDurgName() {
        return durgName;
    }

    public void setDurgName(String durgName) {
        this.durgName = durgName;
    }

    public String getAnnouncer() {
        return announcer;
    }

    public void setAnnouncer(String announcer) {
        this.announcer = announcer;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMarked() {
        return marked;
    }

    public void setMarked(String marked) {
        this.marked = marked;
    }
}
