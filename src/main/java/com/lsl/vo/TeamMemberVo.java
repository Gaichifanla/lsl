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
public class TeamMemberVo {
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
    private int teamId;
    //权限
    private String permission;
}
