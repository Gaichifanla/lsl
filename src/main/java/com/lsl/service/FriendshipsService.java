package com.lsl.service;

import com.lsl.entity.FriendShips;

import java.util.List;

/**
* @author acer
* @description 针对表【friendships】的数据库操作Service
* @createDate 2024-01-11 22:16:28
*/
public interface FriendshipsService {
    public List<FriendShips> query(FriendShips friendShips);

}
