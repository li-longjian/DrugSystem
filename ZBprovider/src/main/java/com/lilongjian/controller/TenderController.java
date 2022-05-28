package com.lilongjian.controller;

import com.lilongjian.domain.Tender;
import com.lilongjian.service.TenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/zb")
public class TenderController {
    @Autowired
    private TenderService tenderService;

    @GetMapping("/get/{id}")
    Tender getTenderById(@PathVariable(value = "id") int id){
        return tenderService.getTenderById(id);
    }

    @GetMapping("/get/num")
    Tender getTenderByNumber(String number) {
        return tenderService.getTenderByNumber(number);
    }
    @GetMapping("/get/ema")
    List<Tender> getTendersByAnnouncer(String email) {
        return tenderService.getTendersByAnnouncer(email);
    }
    @GetMapping("/getAll")
    List<Tender> getAllTenders(){
       return tenderService.getAllTenders();
    }

    @PostMapping("/set")
    Map<String,Object> setTenderStatus(String number,int status) {
        Map<String,Object> map = new HashMap<>();
        if(number== null) {
            map.put("msg","参数错误");
            return map;
        }
        Tender tender = tenderService.setTenderStatus(number,status);
        if(tender == null){
            map.put("msg","修改失败");
            return map;
        }
        map.put("msg","修改成功");
        map.put("tender",tender);
        return map;
    }

    @GetMapping("/set")
    Map<String,Object> setTenderStatusById(int id,int status) {
        Map<String,Object> map = new HashMap<>();

        Tender tender = tenderService.setStatusById(id,status);
        if(tender == null){
            map.put("msg","修改失败");
            return map;
        }
        map.put("msg","修改成功");
        map.put("tender",tender);
        return map;
    }


    @PostMapping("/update")
    Map<String,Object> UpdateTender(Tender tender) {
        Map<String,Object> map = new HashMap<>();
        if(tender == null) {
            map.put("msg","参数错误");
            return map;
        }
        Tender update = tenderService.update(tender);
        if(update == null){
            map.put("msg","修改失败");
            return map;
        }
        map.put("msg","修改成功");
        map.put("tender",update);
        return map;
    }

    @PostMapping("/add")
    public Map<String,Object> addNewTender(Tender tender) {
        Map<String,Object> map = new HashMap<>();
        if(tender == null) {
            map.put("msg","参数错误");
            return map;
        }

        Tender newTender = tenderService.addNewTender(tender);
        if(newTender == null) {
            map.put("msg","添加失败");
            return map;
        }
        map.put("msg","添加成功");
        map.put("tender",newTender);
        return map;
    }

    @GetMapping("/del/{id}")
    public  Map<String,Object> deleteById(@PathVariable("id") int id){
        Map<String,Object> map = new HashMap<>();
        int i = tenderService.deleteById(id);
        if(i<=0){
           map.put("msg","删除失败") ;
           return map;
        }
        map.put("msg","删除成功");
        return map;
    }

    @GetMapping("/del/num")
    public Map<String,Object> deleteByNumber(String number){
        Map<String,Object> map = new HashMap<>();
        if(number == null) {
            map.put("msg","参数错误");
            return map;
        }
        int i = tenderService.deleteByNumber(number);
        if(i<=0){
            map.put("msg","删除失败") ;
            return map;
        }
        map.put("msg","删除成功");
        return map;
    }
}
