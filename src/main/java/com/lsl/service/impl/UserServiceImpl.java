package com.lsl.service.impl;

import com.lsl.entity.User;
import com.lsl.mapper.UserMapper;
import com.lsl.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;
    @Override
    public List<User> getAllUser() {
        return userMapper.getAllUser();
    }

    @Override
    public User getOneByName(String username) {
        return userMapper.getOneByName(username);
    }

    @Override
    public User getOneByOpenid(int openid) {
        return userMapper.getOneByOpenid(openid);
    }

    @Override
    public void addUser(User user) {
        userMapper.addUser(user);
    }
}
