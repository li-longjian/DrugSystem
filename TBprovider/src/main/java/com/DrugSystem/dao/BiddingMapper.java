package com.DrugSystem.dao;

import com.DrugSystem.domain.Bidding;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface BiddingMapper {
    Bidding getBiddingById(int id);
    Bidding getBiddingBuNumber(String number);
    List<Bidding> getAllBidding();
    List<Bidding> getBiddingByAnnouncer(String email);
    int setBiddingStatus(Map<String,Object> map);
    int setStatusById(Map<String,Integer> map);
    int update(Bidding bidding);
    int deleteByNumber(String number);
    int deleteById(int id);
    int addBidding(Bidding bidding);
}
