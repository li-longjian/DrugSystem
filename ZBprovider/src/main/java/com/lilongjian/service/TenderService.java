package com.lilongjian.service;

import com.lilongjian.domain.Tender;
import java.util.List;
import java.util.Map;


public interface TenderService {
    Tender getTenderById(int id);
    Tender getTenderByNumber(String number);
    List<Tender> getTendersByAnnouncer(String email);//得到所有当前发布者发布的招标信息
    Tender setTenderStatus(String number,int status);//更改当前招标状态
    Tender setStatusById(int id,int status);
    Tender update(Tender tender);//更新信息
    int deleteByNumber(String number);
    int deleteById(int id);
    Tender addNewTender(Tender tender);
    List<Tender> getAllTenders();
}
