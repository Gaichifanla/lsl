package com.lsl.mapper;

import com.lsl.entity.Team;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface TeamMapper {
    @Select("select * from team")
    List<Team> getAllTeam();
    @Select("select * from team where team.team_id=#{teamid}")
    Team getOneTeamById(int teamid);
    @Select("select * from team where team.team_name=#{teamname}")
    Team getOneByTeamname(String teamname);
    @Insert("insert into team (team_id,team_name,creator_id,cteat_time)" +
            "values "+"(#{teamid},#{teamname},#{creatorid},#{creattime})")
    void addTeam(Team team);
    /*@Update("")
    void*/
}
