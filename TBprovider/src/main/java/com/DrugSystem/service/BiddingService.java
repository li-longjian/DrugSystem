package com.DrugSystem.service;

import com.DrugSystem.domain.Bidding;

import java.util.List;

public interface BiddingService {
    Bidding getBiddingById(int id);
    Bidding getBiddingBuNumber(String number);
    List<Bidding> getAllBidding();
    List<Bidding> getBiddingByAnnouncer(String email);
    Bidding setBiddingStatus(String number,int status);
    Bidding setStatusById(int id,int status);
    Bidding update(Bidding bidding);
    int deleteByNumber(String number);
    int deleteById(int id);
    Bidding addBidding(Bidding bidding);
}
