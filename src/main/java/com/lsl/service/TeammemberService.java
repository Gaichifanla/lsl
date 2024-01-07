package com.lsl.service;

import com.lsl.dto.TeamAndMemberDTO;
import com.lsl.entity.Teammember;
import com.lsl.vo.TeamAndMemberVo;

import java.util.List;

public interface TeammemberService {

    public Teammember getTeamMemberByUserId(int userId);
    public List<Teammember> getTeamMemberTeamId(int teamId);
    int getTeamIdByUserId(int userId);

    public void insertTeamMember(Teammember teammember);
}
