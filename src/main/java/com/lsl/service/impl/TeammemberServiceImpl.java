package com.lsl.service.impl;

import com.lsl.entity.Teammember;
import com.lsl.mapper.TeammemberMapper;
import com.lsl.service.TeammemberService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TeammemberServiceImpl implements TeammemberService {
    @Resource
    private TeammemberMapper teammemberMapper;


    @Override
    public Teammember getTeamMemberByUserId(int userId) {
        return teammemberMapper.getTeamMemberByUserId(userId);
    }

    public List<Teammember> getTeamMemberTeamId(int teamId){
        return teammemberMapper.getAllTeamMemberByTeamId(teamId);
    }

    @Override
    public void insertTeamMember(Teammember teammember) {
        teammemberMapper.insertTeamMember(teammember);
    }

}
