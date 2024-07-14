package com.lsl.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.lsl.entity.Team;
import com.lsl.entity.Teammember;

import java.util.List;

/**
* @author acer
* @description 针对表【teammember】的数据库操作Service
* @createDate 2024-06-17 22:07:46
*/
public interface TeammemberService extends IService<Teammember> {
    /**
     * 根据teamId查询成员
     * @param teamId
     * @return
     */
    List<Teammember> getTeamMemberTeamId(int teamId);

    Teammember getTeamMemberByUserId(int userId);
}
