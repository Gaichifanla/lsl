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

    public List<Teammember> getTeamMemberTeamId(int teamId){
        return teammemberMapper.getAllTeamMemberByTeamId(teamId);
    }

}
