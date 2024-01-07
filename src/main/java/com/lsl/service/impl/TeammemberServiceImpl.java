package com.lsl.service.impl;

import com.lsl.dto.TeamAndMemberDTO;
import com.lsl.dto.TeamMemberDTO;
import com.lsl.entity.Team;
import com.lsl.entity.Teammember;
import com.lsl.mapper.TeamMapper;
import com.lsl.mapper.TeammemberMapper;
import com.lsl.service.TeammemberService;
import com.lsl.vo.TeamAndMemberVo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TeammemberServiceImpl implements TeammemberService {
    @Resource
    private TeammemberMapper teammemberMapper;

    /**
     * 用userID查询团队和成员
     * @param userId
     * @return
     */
    @Override
    public Teammember getTeamMemberByUserId(int userId) {
        return teammemberMapper.getTeamMemberByUserId(userId);
    }

    public List<Teammember> getTeamMemberTeamId(int teamId){
        return teammemberMapper.getAllTeamMemberByTeamId(teamId);
    }

    @Override
    public int getTeamIdByUserId(int userId) {
        return teammemberMapper.getTeamIdByUserId(userId);
    }

    @Override
    public void insertTeamMember(Teammember teammember) {
        teammemberMapper.insertTeamMember(teammember);
    }

}
