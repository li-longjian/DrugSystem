package com.lilongjian.controller;

import com.lilongjian.domain.Message;
import com.lilongjian.interfae.MessageInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/msg")
public class MessageController {
    @Autowired
    private MessageInterface messageClient;

    @GetMapping("/getAll")
    public List<Message> getAll(){
        return messageClient.getAll();
    }

    @GetMapping("/get/num")
    public List<Message> getMessageByAnnouncer(String announcer) {
        return messageClient.getMessageByAnnouncer(announcer);
    }
    @GetMapping("/get/page")
    public List<Message> getMessageByPage(int page, int pageSize){
        return messageClient.getMessageByPage(page, pageSize);
    }
    @PostMapping("/add")
    public Map<String,Object> addMessage(Message message) {
        return messageClient.addMessage(message);
    }

    @PostMapping("/update")
    public Map<String,Object> update(Message message) {
        return messageClient.update(message);
    }

    @GetMapping("/del/{id}")
    public Map<String,Object> deleteMessage(@PathVariable("id") int id){
        return messageClient.deleteMessage(id);
    }

    @PostMapping("/set")
    public Map<String,Object> setMessageStatus(int id,int status){
        return messageClient.setMessageStatus(id,status);
    }
}
