package com.lsl.controller.user;

import com.lsl.entity.FriendShips;
import com.lsl.result.Result;
import com.lsl.service.FriendshipsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/personal_list")
@Slf4j
public class FriendShipController {
    @Autowired
    private FriendshipsService friendshipsService;

    /**
     * 查询好友
     * @param friendShips
     * @return
     */
    public Result query(FriendShips friendShips){
        return Result.success(friendshipsService.query(friendShips));
    }
}
