package com.lilongjian.controller;

import com.lilongjian.domain.Bidding;
import com.lilongjian.domain.Tender;
import com.lilongjian.interfae.TenderInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/zb")
public class TenderController {
    @Autowired
    private TenderInterface tenderClient;

    @GetMapping("/get/{id}")
    Tender getTenderById(@PathVariable(value = "id") int id) {
        return tenderClient.getTenderById(id);
    }

    @GetMapping("/get/num")
    Tender getTenderByNumber(String number) {
        return tenderClient.getTenderByNumber(number);
    }

    @GetMapping("/get/ema")
    List<Tender> getTendersByAnnouncer(String email) {
        return tenderClient.getTendersByAnnouncer(email);
    }

    @GetMapping("/getAll")
    List<Tender> getAllTenders() {
        return tenderClient.getAllTenders();
    }

    @GetMapping("/get/bids")
    List<Bidding> getBiddingByZBNumber(String number){
        return tenderClient.getBiddingByZBNumber(number);
    }

    @PostMapping("/set")
    Map<String, Object> setTenderStatus(String number,int status) {
        return tenderClient.setTenderStatus(number, status);
    }

    @GetMapping("/set")
    Map<String, Object> setTenderStatusById(int id,int status) {
        return tenderClient.setTenderStatusById(id, status);
    }

    @PostMapping("/update")
    Map<String, Object> UpdateTender(Tender tender) {
        return tenderClient.UpdateTender(tender);
    }


    @PostMapping("/add")
    public Map<String, Object> addNewTender(Tender tender) {
        return tenderClient.addNewTender(tender);
    }


    @GetMapping("/del/{id}")
    public Map<String,Object> deleteById(@PathVariable("id") int id) {
        return tenderClient.deleteById(id);
    }

    @GetMapping("/del/num")
    public Map<String,Object> deleteByNumber(String number) {
        return tenderClient.deleteByNumber(number);
    }

    @GetMapping("/find")
    public List<Tender> searchTender(String name){
        return tenderClient.searchTender(name);
    }
}
