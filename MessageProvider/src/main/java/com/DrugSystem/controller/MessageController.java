package com.DrugSystem.controller;

import com.DrugSystem.domain.Message;
import com.DrugSystem.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public int addMessage(@RequestBody Message message) {
        return messageService.addMessage(message);
    }

    @PostMapping("/update")
    public int update(@RequestBody Message message) {
        return messageService.update(message);
    }

}
