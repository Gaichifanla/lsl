package com.lsl.utils;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
//@RunWith(SpringRunner.class)
class JwtTokenUtilsTest {
    @Resource
    JwtTokenUtils jwtTokenUtils;
    @Test
    void createJWT() throws Exception {

        HashMap<String, Object> claims = new HashMap<>();
        claims.put("name", "刘臣星的小奥迪");

        String token = jwtTokenUtils.createJWT("1234","刘臣星",0L,claims);
        System.out.println(token);
        System.out.println(jwtTokenUtils.parseJWT(token));
    }

    @Test
    void parseJWT() {
    }
}