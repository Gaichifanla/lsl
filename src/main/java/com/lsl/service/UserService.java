package com.lsl.service;

import com.lsl.entity.User;
import com.lsl.result.Result;
import com.lsl.vo.UserLoginVo;

import java.util.List;

public interface UserService {
    List<User> getAllUser();
    User getOneByName(String username);
    User getOneByOpenid(int openid);
    void addUser(User user);
    Result<UserLoginVo> userLogin(User user);
    void deleteUserById(Long openid);


}
