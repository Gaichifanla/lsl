package com.lsl.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.JsonObject;
import com.lsl.constant.JwtClaimsConstant;
import com.lsl.constant.MessageConstant;
import com.lsl.entity.User;
import com.lsl.exception.LoginFailedException;
import com.lsl.mapper.UserMapper;
import com.lsl.properties.JwtProperties;
import com.lsl.properties.WeChatProperties;
import com.lsl.result.Result;
import com.lsl.service.UserService;
import com.lsl.utils.HttpClientUtil;
import com.lsl.utils.JwtUtil;
import com.lsl.utils.WxUserMsgUtil;
import com.lsl.vo.UserLoginVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    private final String url = "https://api.weixin.qq.com/sns/jscode2session";
    @Resource
    private UserMapper userMapper;
    @Autowired
    private WeChatProperties weChatProperties;
    @Autowired
    private JwtProperties jwtProperties;

    @Override
    public JSONObject regist(String code,String avatarUrl,String nickName){
        JSONObject jsonObject= new JSONObject();
        String openid = getOpenId(code);

        //判断openid是否为空
        if (openid == null){
            throw new LoginFailedException(MessageConstant.LOGIN_FAILED);
        }

        //注册/登录用户
        User user1=userMapper.getOneByOpenid(openid);
        if (user1!=null){
            //登录的时候用户可能换了头像和昵称，把头像昵称重新扔进去一遍
            userMapper.updateAvatarAndUsername(avatarUrl,nickName,openid);

            jsonObject.put("openid",openid);
            jsonObject.put("nickName",nickName);
            jsonObject.put("avatarUrl",avatarUrl);
        }else {
            User user=User.builder()
                    .username(nickName)
                    .avatar(avatarUrl)
                    .openid(openid)
                    .build();
            userMapper.addUser(user);
            jsonObject.put("openid",openid);
            jsonObject.put("nickName",nickName);
            jsonObject.put("avatarUrl",avatarUrl);
        }
        jsonObject.put(JwtClaimsConstant.USER_ID,user1.getId());
        String token = JwtUtil.createJWT(jwtProperties.getUserSecretKey(),nickName, jwtProperties.getUserTtl(),jsonObject);
        jsonObject.put("token",token);
        return jsonObject;
    }

    /**
     * 获取openid
     * @param code
     * @return
     */
    private String getOpenId(String code){
        //获取openid
        HashMap<String, String> map = new HashMap<>();
        map.put("appid",weChatProperties.getAppid());
        map.put("secret",weChatProperties.getSecret());
        map.put("js_code",code);
        map.put("grant_type","authorization_code");
        String json = HttpClientUtil.doGet(url, map);
        System.out.println(json);

        JSONObject jsonObject = JSON.parseObject(json);
        String openid = jsonObject.getString("openid");
        return openid;
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
                token= JwtUtil.createJWT(String.valueOf(user.getOpenid()),user.getUsername(),0L,claims);
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
    public void deleteUserById(Long openid) {
        userMapper.deleteUserById(openid);
    }
}
