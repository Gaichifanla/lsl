package com.lsl.mapper;


import com.lsl.entity.ChatRecords;
import com.lsl.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
* @author acer
* @description 针对表【chat_records】的数据库操作Mapper
* @createDate 2024-01-11 20:50:25
* @Entity .com.lsl.entity.ChatRecords
*/
@Mapper
public interface ChatRecordsMapper{
    @Select("select * from chat_records where sender_id=#{senderId} and receiver_id=#{receiverId}")
    List<ChatRecords> getChatRecordsBySARId(Integer senderId,Integer receiverId);

    @Insert("insert into chat_records (timestamp,sender_id,receiver_id,message) values (current_time,#{senderId},#{receiverId},#{message}) ")
    void insertChatRecords(ChatRecords chatRecords);

    @Select("select * from chat_records where sender_id=#{senderId}")
    List<ChatRecords> getChatRecordsBySenderId(Integer senderId);
}
