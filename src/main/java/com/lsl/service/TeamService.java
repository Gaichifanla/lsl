package com.lsl.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lsl.entity.Team;
import com.lsl.entity.TeamTask;

import java.util.List;

public interface TeamService extends IService<Team> {
    List<Team> getAllTeam();

    Team getOneTeamById(int teamid);

    Team getOneByTeamname(String teamname);

    void addTeam(Team team);

}
