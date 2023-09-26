package com.lsl.controller;

import com.lsl.entity.User;
import com.lsl.mapper.UserMapper;
import com.lsl.result.Result;
import com.lsl.service.UserService;
import org.springframework.web.bind.annotation.*;

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
    @RequestMapping("/springboot")
    public String startSpringBoot() {
        return "Welcome to the world of Spring Boot!";
    }
    @GetMapping
    public Result getAllUser(){
        List<User> user=userService.getAllUser();
        log.info("查询全部用户");
//        System.out.println(user);
        return Result.success(user);
    }
    @GetMapping("/getOneByName")//路径不能相同
    public Result getOneByName(String username){
        log.info("调用getOneByName函数");
        User user=userService.getOneByName(username);
        return Result.success(user);
    }
    @PostMapping("/getOneByOpenid")
    public Result getOneByOpenid(int id){
        log.info("调用getOneByOpenid函数");
        User user=userService.getOneByOpenid(id);
        return Result.success(user);
    }
    @PostMapping("/register")
    public void register(User user){
        log.info("调用register函数");
        userService.addUser(user);
    }
    @PostMapping("/userLogin")
    public Result userLogin(User user){
        //待完善，使用jwt校验
        log.info("调用userLogin函数");
        return userService.userLogin(user);
    }
    @DeleteMapping("/deleteUser")
    public Result deleteUser(long openid){
        log.info("调用deleteUser函数");
        userService.deleteUserById(openid);
        return Result.success("删除成功");
    }
}
