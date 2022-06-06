package com.DrugSystem.service.impl;

import com.DrugSystem.dao.BiddingMapper;
import com.DrugSystem.domain.Bidding;
import com.DrugSystem.service.BiddingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Service
public class BiddingServiceImpl implements BiddingService {
    @Autowired
    private BiddingMapper biddingMapper;

    @Override
    public Bidding getBiddingById(int id) {

        return biddingMapper.getBiddingById(id);
    }

    @Override
    public Bidding getBiddingBuNumber(String number) {
        if (number == null) return null;
        return biddingMapper.getBiddingBuNumber(number);
    }

    @Override
    public List<Bidding> getAllBidding() {
        return biddingMapper.getAllBidding();
    }

    @Override
    public List<Bidding> getBiddingByAnnouncer(String email) {
        if (email == null) return null;
        return biddingMapper.getBiddingByAnnouncer(email);
    }

    @Override
    public Bidding setBiddingStatus(String number, int status) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("number", number);
        map.put("status", status);
        int i = biddingMapper.setBiddingStatus(map);
        if (i <= 0) return null;
        return biddingMapper.getBiddingBuNumber(number);
    }

    @Override
    public Bidding setStatusById(int id, int status) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("id", id);
        map.put("status", status);
        int i = biddingMapper.setStatusById(map);
        if (i <= 0) return null;
        return biddingMapper.getBiddingById(id);
    }

    @Override
    public Bidding update(Bidding bidding) {
        if(bidding == null) return null;
        int i = biddingMapper.update(bidding);
        if(i<=0) return null;
        return biddingMapper.getBiddingBuNumber(bidding.getNumber());
    }

    @Override
    public int deleteByNumber(String number) {
        if(number == null) return -1;

        return biddingMapper.deleteByNumber(number);
    }

    @Override
    public int deleteById(int id) {
        return biddingMapper.deleteById(id);
    }

    @Override
    public Bidding addBidding(Bidding bidding) {
        if(bidding == null) return null;
        bidding.setDate(new Date());
        String s = UUID.randomUUID().toString().replace("-", "");
        String number = "TB-" + s;//产生唯一的投标编号
        bidding.setNumber(number);
        int i = biddingMapper.addBidding(bidding);
        if(i<=0) return null;
        return bidding;
    }
}
