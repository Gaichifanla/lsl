package com.lsl.controller;

import com.lsl.entity.User;
import com.lsl.mapper.UserMapper;
import com.lsl.result.Result;
import com.lsl.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import lombok.extern.slf4j.Slf4j;


@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {
    @Resource
    UserMapper userMapper;
    @Resource
    UserService userService;
    @GetMapping
    public Result getAllUser(){
        List<User> user=userMapper.getAllUser();
        log.info("查询全部用户");
        System.out.println(user);
        return Result.success(user);
    }
    @GetMapping("/getOneByName")//路径不能相同
    public Result getOneByName(String username){
        User user=userMapper.getOneByName(username);
        return Result.success(user);
    }
    @PostMapping("/getOneByOpenid")
    public Result getOneByOpenid(int id){
        User user=userMapper.getOneByOpenid(id);
        return Result.success(user);
    }
    @PostMapping("/addUser")
    public void addUser(User user){
        userMapper.addUser(user);
    }
}
