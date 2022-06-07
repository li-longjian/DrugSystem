package com.lilongjian.interfae;

import com.lilongjian.domain.Bidding;
import com.lilongjian.domain.Tender;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@FeignClient(value = "ZBprovider")
public interface TenderInterface {
    @GetMapping("/zb/get/page")
    List<Tender> getTenderByPage(@RequestParam("page") int page,@RequestParam("pageSize") int pageSize);

    @GetMapping("/zb/get/{id}")
    Tender getTenderById(@PathVariable(value = "id") int id);

    @GetMapping("/zb/get/num")
    Tender getTenderByNumber(@RequestParam("number") String number);

    @GetMapping("/zb/get/ema")
    List<Tender> getTendersByAnnouncer(@RequestParam("email") String email);

    @GetMapping("/zb/getAll")
    List<Tender> getAllTenders();

    @GetMapping("/zb/get/bids")
    List<Bidding> getBiddingByZBNumber(@RequestParam("number") String number);

    @PostMapping("/zb/set")
    Map<String, Object> setTenderStatus(@RequestParam("number") String number, @RequestParam("status") int status) ;
    @GetMapping("/zb/set")
    Map<String, Object> setTenderStatusById(@RequestParam("id") int id,@RequestParam("status") int status) ;
    @PostMapping("/zb/update")
    Map<String, Object> UpdateTender(@RequestBody Tender tender) ;

    @PostMapping("/zb/add")
    public Map<String, Object> addNewTender(@RequestBody Tender tender) ;

    @GetMapping("/zb/del/{id}")
    public Map<String, Object> deleteById(@PathVariable("id") int id) ;

    @GetMapping("/zb/del/num")
    public Map<String, Object> deleteByNumber(@RequestParam("number") String number) ;
    @GetMapping("/zb/find")
    List<Tender> searchTender(@RequestParam("name") String name);
}
