package com.lsl.service.impl;

import com.lsl.entity.FriendShips;
import com.lsl.mapper.FriendshipsMapper;
import com.lsl.service.FriendshipsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author acer
* @description 针对表【friendships】的数据库操作Service实现
* @createDate 2024-01-11 22:16:28
*/
@Service
public class FriendshipsServiceImpl implements FriendshipsService {
    @Autowired
    private FriendshipsMapper friendshipsMapper;
    public List<FriendShips> query(FriendShips friendShips){
        return friendshipsMapper.query(friendShips);
    }

}
