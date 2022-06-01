package com.lilongjian.dao;

import com.lilongjian.domain.Bidding;
import com.lilongjian.domain.Tender;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface TenderMapper {

    Tender getTenderById(int id);
    Tender getTenderByNumber(String number);
    List<Tender> getAllTenders();
    List<Tender> getTendersByAnnouncer(String email);//得到所有当前发布者发布的招标信息
    List<Bidding> getBiddingBuNumber(String number);//得到招标编号下的投标列表
    int setTenderStatus(Map<String,Object> map);//更改当前招标状态
    int setStatusById(Map<String,Integer> map);
    int update(Tender tender);//更新信息
    int deleteByNumber(String number);
    int deleteById(int id);
    int addNewTender(Tender tender);



}
