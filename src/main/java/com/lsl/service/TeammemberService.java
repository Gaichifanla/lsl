package com.lsl.service;

import com.lsl.entity.Teammember;

import java.util.List;

public interface TeammemberService {

    public Teammember getTeamMemberByUserId(int userId);
    public List<Teammember> getTeamMemberTeamId(int teamId);

    public void insertTeamMember(Teammember teammember);
}
