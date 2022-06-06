package com.DrugSystem.controller;

import com.DrugSystem.domain.Message;
import com.DrugSystem.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/msg")
public class MessageController {
    @Autowired
    private MessageService messageService;

    @GetMapping("/getAll")
    public List<Message> getAll(){
        return messageService.getAllMessage();
    }

    @GetMapping("/get/num")
    public List<Message> getMessageByAnnouncer(@RequestParam("announcer") String announcer) {
        return messageService.getMessageByAnnouncer(announcer);
    }
    @GetMapping("/get/page")
    public List<Message> getMessageByPage(@RequestParam(value = "page",defaultValue = "1") int page,@RequestParam(value = "pageSize",defaultValue = "5") int pageSize){
        return messageService.getMessageByPage(page, pageSize);
    }
    @PostMapping("/add")
    public Map<String,Object> addMessage(@RequestBody Message message) {
        Map<String,Object> map = new HashMap<>();
        int i = messageService.addMessage(message);
        if(i <= 0) {
            map.put("msg","发布失败");
            return map;
        }
        map.put("msg","发布成功");
        return map;
    }

    @PostMapping("/update")
    public Map<String,Object> update(@RequestBody Message message) {
        Map<String,Object> map = new HashMap<>();
        int i = messageService.update(message);
        if(i <= 0) {
            map.put("msg","更新失败");
            return map;
        }
        map.put("msg","更新成功");
        return map;
    }

    @GetMapping("/del/{id}")
    public Map<String,Object> deleteMessage(@PathVariable("id") int id){
        Map<String,Object> map = new HashMap<>();
        int i = messageService.deleteMessage(id);
        if(i <= 0) {
            map.put("msg","删除失败");
            return map;
        }
        map.put("msg","删除成功");
        return map;
    }

    @PostMapping("/set")
    public Map<String,Object> setMessageStatus(@RequestParam("id") int id,@RequestParam("status") int status){
        Map<String,Object> map = new HashMap<>();
        int i = messageService.setStatus(id, status);
        if(i <= 0) {
            map.put("msg","更新失败");
            return map;
        }
        map.put("msg","更新成功");
        return map;
    }

}
