package com.lsl.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.JsonObject;
import com.lsl.entity.User;
import com.lsl.mapper.UserMapper;
import com.lsl.result.Result;
import com.lsl.service.UserService;
import com.lsl.utils.HttpClientUtil;
import com.lsl.utils.JwtTokenUtils;
import com.lsl.utils.WxUserMsgUtil;
import com.lsl.vo.UserLoginVo;
import org.apache.http.impl.client.CloseableHttpClient;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;
    @Resource
    JwtTokenUtils jwtTokenUtils;
    @Override
    public List<User> getAllUser() {
        return userMapper.getAllUser();
    }

    @Override
    public User getOneByName(String username) {
        return userMapper.getOneByName(username);
    }

    @Override
    public User getOneByAccount(int account) {
        return userMapper.getOneByAccount(account);
    }

    @Override
    public User getOneByOpenid(String openid) {
        return userMapper.getOneByOpenid(openid);
    }

    @Override
    public JSONObject regist(String code,String avatarUrl,String nickName){
        String wxAppId="wx7631816728458fb0";
        String wxAppSecret="f2c92074a5176a65631290fd47d8d74b";
        String code1=code;

        String url = "https://api.weixin.qq.com/sns/jscode2session";

        HttpClientUtil httpClientUtil=new HttpClientUtil();
        Map<String,String> map=new HashMap<>();
        map.put("appid",wxAppId);
        map.put("secret",wxAppSecret);
        map.put("js_code",code);
//        System.out.println(code);
        map.put("grant_type","authorization_code");

//        System.out.println(httpClientUtil.doGet(url,map));
        JSONObject jsonObject= JSON.parseObject(httpClientUtil.doGet(url,map));

        String openid= jsonObject.getString("openid");
        String session_key=jsonObject.getString("session_key");

        //注册/登录用户
        User user1=userMapper.getOneByOpenid(openid);
        if (user1!=null){
            //登录的时候用户可能换了头像和昵称，把头像昵称重新扔进去一遍
            userMapper.updateAvatarAndUsername(avatarUrl,nickName,openid);

            jsonObject.put("nickName",nickName);
            jsonObject.put("avatarUrl",avatarUrl);
        }else {
            User user=User.builder()
                    .username(nickName)
                    .avatar(avatarUrl)
                    .openid(openid)
                    .build();
            userMapper.addUser(user);
            jsonObject.put("nickName",nickName);
            jsonObject.put("avatarUrl",avatarUrl);
        }



//        System.out.println(jsonObject);

//        System.out.println(access_token+"111");
        String access_token=WxUserMsgUtil.getAccessToken(wxAppId,wxAppSecret);

//        System.out.println(access_token);
//        System.out.println(session_key);
        WxUserMsgUtil.getWxUser(access_token,openid,session_key);

//        System.out.println(openid);
        return jsonObject;
    }

    @Override
    public Result<UserLoginVo> userLogin(User user) {
        /*String username=user.getUsername();
        String password=user.getPassword();
        User user1=userMapper.getOneByName(username);逐个校验可以返回准确信息*/
        String token=null;

        HashMap<String, Object> claims = new HashMap<>();
        claims.put("name", user.getUsername());

        if(userMapper.getUserByUsernameAndPassword(user)!=null){
            try {
                token=jwtTokenUtils.createJWT(String.valueOf(user.getOpenid()),user.getUsername(),0L,claims);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        UserLoginVo userLoginVo=UserLoginVo.builder()
                .account(user.getAccount())
                .username(user.getUsername())
                .token(token)
                .build();
        return Result.success(userLoginVo);
    }

    @Override
    public void deleteUserById(Long openid) {
        userMapper.deleteUserById(openid);
    }
}
