package com.lilongjian.interfae;

import com.lilongjian.domain.Bidding;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@FeignClient(value = "TBprovider")
public interface BiddingInterface {

    @GetMapping("/tb/get/{id}")
    public Bidding getBiddingById(@PathVariable("id") int id);

    @GetMapping("/tb/get/num")
    public Bidding getBiddingBuNumber(@RequestParam("number") String number);

    @GetMapping("/tb/get/ema")
    public List<Bidding> getBiddingByAnnouncer(@RequestParam("email") String email) ;

    @GetMapping("/tb/getAll")
    public List<Bidding> getAllBidding();

    @PostMapping("/tb/set")
    Map<String, Object> setBiddingStatus(@RequestParam("number") String number, @RequestParam("status") int status);


    @GetMapping("/tb/set")
    public Map<String, Object> setBiddingStatusById(@RequestParam("id") int id,@RequestParam("status") int status);

    @PostMapping("/tb/update")
    public Map<String, Object> update(@RequestBody Bidding bidding);

    @PostMapping("/tb/add")
    public Map<String,Object> addBidding(@RequestBody Bidding bidding) ;

    @GetMapping("/tb/del/{id}")
    public Map<String, Object> deleteById(@PathVariable("id") int id);
    @GetMapping("/tb/del/num")
    public Map<String, Object> deleteByNumber(@RequestParam("number") String number);
}
