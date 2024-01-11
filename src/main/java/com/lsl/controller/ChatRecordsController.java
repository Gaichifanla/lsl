package com.lsl.controller;

import com.lsl.entity.ChatRecords;
import com.lsl.result.Result;
import com.lsl.service.ChatRecordsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/ChatRecords")
@Slf4j
public class ChatRecordsController {
    @Resource
    private ChatRecordsService chatRecordsService;
    @GetMapping("/getChatRecordsBySARId")
    Result getChatRecordsBySARId(Integer senderId, Integer receiverId){
        log.info("调用getChatRecordsBySARId函数");
        return Result.success(chatRecordsService.getChatRecordsBySARId(senderId,receiverId));
    }
    @GetMapping("/insertChatRecords")
    void insertChatRecords(ChatRecords chatRecords){
        log.info("调用insertChatRecords函数");
        chatRecordsService.insertChatRecords(chatRecords);
    }
}
