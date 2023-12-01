package com.lsl.controller;

import com.alibaba.fastjson.JSONObject;
import com.lsl.entity.User;
import com.lsl.mapper.UserMapper;
import com.lsl.result.Result;
import com.lsl.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

import lombok.extern.slf4j.Slf4j;


@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {
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
    @GetMapping("/getOneNameByAccount")
    public Result getOneNameByAccount(int account){
        log.info("调用getOneNameByAccount函数");
        return Result.success(userService.getOneByAccount(account).getUsername());
    }
    @GetMapping("/getOneByAccount")
    public Result getOneByAccount(int account){
        log.info("调用getOneByAccount函数");
        return Result.success(userService.getOneByAccount(account));
    }
    @PostMapping("/getOneByOpenid")
    public Result getOneByOpenid(@RequestBody HashMap<String,String> requestBody){
        log.info("调用getOneByOpenid函数");
        String openid=requestBody.get("openid");
        User user=userService.getOneByOpenid(openid);
        return Result.success(user);
    }
    @PostMapping("/register")
    public JSONObject register(@RequestBody HashMap<String,String> requestBody){
        log.info("调用register函数");
//        System.out.println(requestBody);
        String code=requestBody.get("code");
        String avatarUrl=requestBody.get("avatarUrl");
        String nickName=requestBody.get("nickName");
//        System.out.println(code);

        return userService.regist(code,avatarUrl,nickName);
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
