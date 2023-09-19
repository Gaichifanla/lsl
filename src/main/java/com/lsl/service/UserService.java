package com.lsl.service;

import com.lsl.entity.User;

import java.util.List;

public interface UserService {
    List<User> getAllUser();
    User getOneByName(String username);
    User getOneByOpenid(int openid);
    void addUser(User user);

}
