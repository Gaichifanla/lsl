package com.lsl.controller;

import com.lsl.entity.User;
import com.lsl.result.Result;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;


@SpringBootTest
@RunWith(SpringRunner.class)
//@Transactional
@Rollback(value=true)
class UserControllerTest {
    @Resource
    UserController userController;
    @Test
    void getAllUser() {
        Result queryData=userController.getAllUser();
        System.out.println(queryData);
    }
    @Test
    void getOneByName(){
        Result queryData=userController.getOneByName("nihao");
        System.out.println(queryData);
    }
    @Test
    void getOneByOpenid(){
//        Result queryData=userController.getOneByOpenid();
//        System.out.println(queryData);
    }
    @Test
    void addUser(){
//        User user=new User(null,null,"aaa","bbb","女","null","luoyu_1224@163.com","00000000000",null,1,"asdhsd");
//        userController.register(user);
    }
    @Test
    void deleteUser(){
        Long openid= 1028L;
        userController.deleteUser(openid);
    }
    @Test
    void userLogin(){
        //User user=new User(35L,1035L,"aaa","ccc","女","null","luoyu_1224@163.com","00000000000",null,1);
        //System.out.println(userController.userLogin(user));
    }
}