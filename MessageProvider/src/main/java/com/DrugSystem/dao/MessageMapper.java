package com.DrugSystem.dao;

import com.DrugSystem.domain.Message;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface MessageMapper {
    List<Message> getAllMessage();
    List<Message> getMessageByAnnouncer(String announcer);
    int addMessage(Message message);
    int update(Message message);
    int deleteMessage(int id);
    int setMessageStatus(Map<String,Integer> map);
}
