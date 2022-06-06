package com.DrugSystem.service;

import com.DrugSystem.domain.Message;

import java.util.List;

public interface MessageService {
    List<Message> getAllMessage();
    List<Message> getMessageByAnnouncer(String announcer);
    int addMessage(Message message);
    int update(Message message);
    int deleteMessage(int id);
    List<Message> getMessageByPage(int page,int pageSize);
    int setStatus(int id,int status);
}
