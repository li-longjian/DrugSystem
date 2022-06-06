package com.DrugSystem.service.impl;

import com.DrugSystem.dao.MessageMapper;
import com.DrugSystem.domain.Message;
import com.DrugSystem.service.MessageService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageMapper messageMapper;

    @Override
    public List<Message> getAllMessage() {
        return messageMapper.getAllMessage();
    }

    @Override
    public List<Message> getMessageByAnnouncer(String announcer) {
        return messageMapper.getMessageByAnnouncer(announcer);
    }

    @Override
    public int addMessage(Message message) {
        if(message == null) return -1;
        Date date = new Date();
        message.setDate(date);
        message.setStatus(0);
        return messageMapper.addMessage(message);
    }

    @Override
    public int update(Message message) {
        return messageMapper.update(message);
    }

    @Override
    public int deleteMessage(int id) {
        return messageMapper.deleteMessage(id);
    }

    @Override
    public List<Message> getMessageByPage(int page, int pageSize) {
        PageHelper.startPage(page, pageSize);
        List<Message> allMessage = messageMapper.getAllMessage();
        return allMessage;
    }

    @Override
    public int setStatus(int id, int status) {
        HashMap<String,Integer> map = new HashMap<>();
        map.put("id",id);
        map.put("status",status);
        return messageMapper.setMessageStatus(map);
    }
}
