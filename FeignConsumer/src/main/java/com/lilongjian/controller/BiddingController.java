package com.lilongjian.controller;

import com.lilongjian.domain.Bidding;
import com.lilongjian.interfae.BiddingInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/zb")
public class BiddingController {
    @Autowired
    private BiddingInterface biddingClient;

    @GetMapping("/get/{id}")
    public Bidding getBiddingById(@PathVariable("id") int id){
        return biddingClient.getBiddingById(id);
    }

    @GetMapping("/get/num")
    public Bidding getBiddingBuNumber( String number){
        return biddingClient.getBiddingBuNumber(number);
    }

    @GetMapping("/get/ema")
    public List<Bidding> getBiddingByAnnouncer(String email){
        return biddingClient.getBiddingByAnnouncer(email);
    }

    @GetMapping("/getAll")
    public List<Bidding> getAllBidding(){
        return biddingClient.getAllBidding();
    }

    @PostMapping("/set")
    Map<String, Object> setBiddingStatus(String number, int status){
        return biddingClient.setBiddingStatus(number, status);
    }


    @GetMapping("/set")
    public Map<String, Object> setBiddingStatusById(int id,int status){
        return biddingClient.setBiddingStatusById(id, status);
    }

    @PostMapping("/update")
    public Map<String, Object> update(Bidding bidding){
        return biddingClient.update(bidding);
    }

    @PostMapping("/add")
    public Map<String,Object> addBidding(Bidding bidding){
        return biddingClient.addBidding(bidding);
    }

    @GetMapping("/del/{id}")
    public Map<String, Object> deleteById(@PathVariable("id") int id){
        return biddingClient.deleteById(id);
    }
    @GetMapping("/del/num")
    public Map<String, Object> deleteByNumber(String number){
        return biddingClient.deleteByNumber(number);
    }
}
