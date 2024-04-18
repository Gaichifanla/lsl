package com.lsl.service.impl;


import com.lsl.entity.ChatRecords;
import com.lsl.mapper.ChatRecordsMapper;
import com.lsl.service.ChatRecordsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
* @author acer
* @description 针对表【chat_records】的数据库操作Service实现
* @createDate 2024-01-11 20:50:25
*/
@Service
public class ChatRecordsServiceImpl implements ChatRecordsService {
    @Resource
    private ChatRecordsMapper chatRecordsMapper;

    @Override
    public List<ChatRecords> getChatRecordsBySARId(Integer senderId, Integer receiverId) {
        return chatRecordsMapper.getChatRecordsBySARId(senderId,receiverId);
    }

    @Override
    public void insertChatRecords(ChatRecords chatRecords) {
        chatRecordsMapper.insertChatRecords(chatRecords);
    }

    @Override
    public List<ChatRecords> getChatRecordsBySenderId(Integer senderId) {
        return chatRecordsMapper.getChatRecordsBySenderId(senderId);
    }
}
