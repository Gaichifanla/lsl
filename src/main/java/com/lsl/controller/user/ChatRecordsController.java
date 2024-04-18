package com.lsl.controller.user;

import com.lsl.entity.ChatRecords;
import com.lsl.entity.User;
import com.lsl.result.Result;
import com.lsl.service.ChatRecordsService;
import com.lsl.service.UserService;
import com.lsl.vo.ChatFriendsVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/ChatRecords")
@Slf4j
public class ChatRecordsController {
    @Resource
    private ChatRecordsService chatRecordsService;
    @Resource
    private UserService userService;
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

    /**
     * 先获取聊天好友，后期聊天应用信息再添加,与聊天记录分开获取，聊天记录需要时刻更新，(暂时不写按最新聊天时间排序)
     * @param senderId
     * @return
     */
    @GetMapping("/getChatFriendsList")
    Result getChatFriendsList(Integer senderId){
        log.info("获取聊天对象列表");
        List<ChatRecords> list = chatRecordsService.getChatRecordsBySenderId(senderId);


        List<ChatFriendsVo> chatFriendsVoList = new ArrayList<>();
        for (ChatRecords c:
             list) {
            //放在循环内
            ChatFriendsVo chatFriendsVo = new ChatFriendsVo();
            User user = userService.getOneByAccount(c.getReceiverId());
            BeanUtils.copyProperties(user,chatFriendsVo);
            System.out.println(chatFriendsVo);
            chatFriendsVoList.add(chatFriendsVo);
        }
        System.out.println(chatFriendsVoList);
        return Result.success(chatFriendsVoList);
    }
}
