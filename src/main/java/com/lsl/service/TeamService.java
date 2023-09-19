package com.lsl.service;

import com.lsl.entity.Team;

import java.util.List;

public interface TeamService {
    List<Team> getAllTeam();

    Team getOneTeamById(int teamid);

    Team getOneByTeamname(String teamname);

    void addTeam(Team team);

}
