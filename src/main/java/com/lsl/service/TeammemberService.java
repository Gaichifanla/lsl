package com.lsl.service;

import com.lsl.entity.Teammember;

import java.util.List;

public interface TeammemberService {
    public List<Teammember> getTeamMemberTeamId(int teamId);
}
