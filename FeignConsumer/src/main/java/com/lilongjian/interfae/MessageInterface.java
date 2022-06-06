package com.lilongjian.interfae;

import com.lilongjian.domain.Message;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@FeignClient("MessageProvider")
public interface MessageInterface {
    @GetMapping("/msg/getAll")
    public List<Message> getAll();
    @GetMapping("/msg/get/num")
    public List<Message> getMessageByAnnouncer(@RequestParam("announcer") String announcer) ;
    @GetMapping("/msg/get/page")
    public List<Message> getMessageByPage(@RequestParam(value = "page",defaultValue = "1") int page,@RequestParam(value = "pageSize",defaultValue = "5") int pageSize);
    @PostMapping("/msg/add")
    public Map<String,Object> addMessage(@RequestBody Message message);

    @PostMapping("/msg/update")
    public Map<String,Object> update(@RequestBody Message message);

    @GetMapping("/msg/del/{id}")
    Map<String,Object> deleteMessage(@PathVariable("id") int id);

    @PostMapping("/msg/set")
    public Map<String,Object> setMessageStatus(@RequestParam("id") int id,@RequestParam("status") int status);
}
