package com.lsl.service.impl;

import com.lsl.entity.User;
import com.lsl.mapper.UserMapper;
import com.lsl.result.Result;
import com.lsl.service.UserService;
import com.lsl.utils.JwtTokenUtils;
import com.lsl.vo.UserLoginVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

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
    public User getOneByOpenid(int openid) {
        return userMapper.getOneByOpenid(openid);
    }

    @Override
    public void addUser(User user) {
        userMapper.addUser(user);
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
                .openid(user.getOpenid())
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
