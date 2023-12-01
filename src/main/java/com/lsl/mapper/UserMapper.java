package com.lsl.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lsl.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Mapper
public interface UserMapper {
    //查询
    @Select("select * from user")
    List<User> getAllUser();
    @Select("select * from user where user.username=#{username}")
    User getOneByName(String username);
    @Select("select * from user where user.account=#{account}")
    User getOneByAccount(int account);
    @Select("select * from user where user.openid=#{openid}")
    User getOneByOpenid(String openid);
    @Select("select * from user where username=#{username} and password=#{password}")
    User getUserByUsernameAndPassword(User user);

    //分页查询
    Page<User> pageQuery(User user);
    //更新

    //添加
    //insert下values子句不能带子查询，一张表不能有两条自增，这个resultType不能写Integer;使用@SelectKey注解来获取前一条数据的id值，然后将其加上1001作为新插入数据的openid值。
    @Insert("insert into user (account,username,password,sex,avatar,email,phone,creat_time,status,openid)" +
            "values "+
            "(#{account},#{username},#{password},#{sex},#{avatar},#{email},#{phone},current_timestamp,1,#{openid})")
    @SelectKey(statement = "SELECT IFNULL(MAX(id)+1001, 1001) as account FROM user",
            keyProperty = "account", before = true, resultType = Long.class)
    @Transactional
    void addUser(User user);
    @Update("update user set username=#{username},password=#{password},sex=#{sex},avatar=#{avatar},email=#{email},phone=#{phone} where openid=#{openid}")
    void updateUser(User user);
    @Update("update user set username=#{username},avatar=#{avatar} where openid=#{openid}")
    void updateAvatarAndUsername(String avatar,String username,String openid);
    @Delete("delete from user where openid=#{openid}")
    void deleteUserById(Long openid);


}
