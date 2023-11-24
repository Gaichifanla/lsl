package com.lsl.service.impl;

import com.lsl.entity.Team;
import com.lsl.mapper.TeamMapper;
import com.lsl.service.TeamService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TeamServiceImpl implements TeamService {
    @Resource
    private TeamMapper teamMapper;
    @Override
    public List<Team> getAllTeam() {
        return teamMapper.getAllTeam();
    }

    @Override
    public Team getOneTeamById(int teamid) {
        return teamMapper.getOneTeamById(teamid);
    }

    @Override
    public Team getOneByTeamname(String teamname) {
        return teamMapper.getOneByTeamname(teamname);
    }

    @Override
    public void addTeam(Team team) {
        teamMapper.addTeam(team);
    }
}
