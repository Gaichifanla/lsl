package com.lsl.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.lsl.entity.User;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class WxUserMsgUtil {
    public static User getWxUser(String access_token,String open_id,String session_key){
        String userInfoUrl = "https://api.weixin.qq.com/sns/userinfo";

        Map<String,String> map=new HashMap<>();
//        System.out.println(access_token);
        map.put("access_token",access_token);
        map.put("openid",open_id);
        map.put("session_key",session_key);
        System.out.println("1");
        System.out.println(HttpClientUtil.doGet(userInfoUrl,map));
        System.out.println("2");
        System.out.println(access_token);
        return null;
    }
    public static String getAccessToken(String wxAppId,String wxAppSecret){
        Map<String,String> map=new HashMap<>();
        map.put("appid",wxAppId);
        map.put("secret",wxAppSecret);

        String url="https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential";

//        String url="https://api.weixin.qq.com/cgi-bin/stable_token?grant_type=client_credential&";
        JSONObject jsonObject= JSON.parseObject(HttpClientUtil.doGet(url,map));

        return jsonObject.getString("access_token");
    }

}
