package com.lsl.service;

import com.alibaba.fastjson.JSONObject;
import com.lsl.entity.User;
import com.lsl.result.Result;
import com.lsl.vo.UserLoginVo;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

public interface UserService {
    List<User> getAllUser();
    User getOneByName(String username);
    User getOneByAccount(int account);
    User getOneByOpenid(String openid);
    JSONObject regist(String code,String avatarUrl,String nickName);
    Result<UserLoginVo> userLogin(User user);
    void deleteUserById(Long openid);


}
