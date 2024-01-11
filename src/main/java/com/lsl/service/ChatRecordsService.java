package com.lsl.service;


import com.lsl.entity.ChatRecords;

import java.util.List;

/**
* @author acer
* @description 针对表【chat_records】的数据库操作Service
* @createDate 2024-01-11 20:50:25
*/
public interface ChatRecordsService{
    List<ChatRecords> getChatRecordsBySARId(Integer senderId, Integer receiverId);
    void insertChatRecords(ChatRecords chatRecords);

}
