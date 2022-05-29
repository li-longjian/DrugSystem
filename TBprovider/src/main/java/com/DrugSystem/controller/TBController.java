package com.DrugSystem.controller;

import com.DrugSystem.dao.BiddingMapper;
import com.DrugSystem.domain.Bidding;
import com.DrugSystem.service.BiddingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/tb")
public class TBController {
    @Autowired
    private BiddingService biddingService;

    @GetMapping("/get/{id}")
    public Bidding getBiddingById(@PathVariable("id") int id){
        return biddingService.getBiddingById(id);
    }

    @GetMapping("/get/num")
    public Bidding getBiddingBuNumber(String number){
        if(number == null) return null;
        return biddingService.getBiddingBuNumber(number);
    }

    @GetMapping("/get/ema")
    public List<Bidding> getBiddingByAnnouncer(String email) {
        return biddingService.getBiddingByAnnouncer(email);
    }

    @GetMapping("/getAll")
    public List<Bidding> getAllBidding(){
        return biddingService.getAllBidding();
    }

    @PostMapping("/set")
    Map<String, Object> setBiddingStatus(String number,int status){
        Map<String, Object> map = new HashMap<>();
        Bidding bidding = biddingService.setBiddingStatus(number, status);
        if(bidding == null) {
            map.put("msg", "修改失败");
            return map;
        }
        map.put("msg", "修改成功");
        map.put("bidding", bidding);
        return map;
    }

    @GetMapping("/set")
    public Map<String, Object> setBiddingStatusById(int id,int status) {
        Map<String, Object> map = new HashMap<>();
        Bidding bidding = biddingService.setStatusById(id, status);
        if(bidding == null) {
            map.put("msg", "修改失败");
            return map;
        }
        map.put("msg", "修改成功");
        map.put("bidding", bidding);
        return map;
    }

    @PostMapping("/update")
    public Map<String, Object> update(Bidding bidding){
        Map<String, Object> map = new HashMap<>();
        if (bidding == null) {
            map.put("msg", "参数错误");
            return map;
        }
        Bidding update = biddingService.update(bidding);
        if (update == null) {
            map.put("msg", "修改失败");
            return map;
        }
        map.put("msg", "修改成功");
        map.put("bidding", update);
        return map;
    }

    @PostMapping("/add")
    public Map<String,Object> addBidding(Bidding bidding) {
        Map<String, Object> map = new HashMap<>();
        if (bidding == null) {
            map.put("msg", "参数错误");
            return map;
        }
        Bidding bidding1 = biddingService.addBidding(bidding);
        if (bidding1 == null) {
            map.put("msg", "添加失败");
            return map;
        }
        map.put("msg", "添加成功");
        map.put("bidding", bidding1);
        return map;
    }

    @GetMapping("/del/{id}")
    public Map<String, Object> deleteById(@PathVariable("id") int id){
        Map<String, Object> map = new HashMap<>();
        int i = biddingService.deleteById(id);
        if (i <= 0) {
            map.put("msg", "删除失败");
            return map;
        }
        map.put("msg", "删除成功");
        return map;
    }
    @GetMapping("/del/num")
    public Map<String, Object> deleteByNumber(String number){
        Map<String, Object> map = new HashMap<>();
        if (number == null) {
            map.put("msg", "参数错误");
            return map;
        }
        int i = biddingService.deleteByNumber(number);
        if (i <= 0) {
            map.put("msg", "删除失败");
            return map;
        }
        map.put("msg", "删除成功");
        return map;
    }
}
