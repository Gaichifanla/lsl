package com.lsl.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ChatFriendsVo {
    //微信用户唯一标识
    private Long account;
    //姓名
    private String username;
    private String sex;
    //头像
    private String avatar;
    private String email;
    //手机号
    private String phone;
    private int status;
}
