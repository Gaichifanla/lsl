package com.lsl.mapper;

import com.lsl.entity.FriendShips;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author acer
* @description 针对表【friendships】的数据库操作Mapper
* @createDate 2024-01-11 22:16:28
* @Entity .Friendships
*/
@Mapper
public interface FriendshipsMapper{
    public List<FriendShips> query(FriendShips friendShips);

}
