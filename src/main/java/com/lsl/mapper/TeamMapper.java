package com.lsl.mapper;

import com.lsl.entity.Team;
import com.lsl.entity.Teammember;
import org.apache.ibatis.annotations.*;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

@Mapper
public interface TeamMapper extends BaseMapper<Team> {
    @Select("select * from team")
    List<Team> getAllTeam();
    @Select("select * from team where team.team_id=#{teamid}")
    Team getOneTeamById(int teamid);
    @Select("select * from team where team.team_name=#{teamname}")
    Team getOneByTeamname(String teamname);
    @Insert("insert into team (team_id,team_name,creator_id,cteat_time)" +
            "values "+"(#{teamId},#{teamName},#{creatorId},current_timestamp)")
    void addTeam(Team team);
    @Update("update team set team_name=#{teamName},creator_id=#{creatorId} where team_id=#{teamId}")
    void updata(Team team);
    @Delete("delete from team where team_id=#{teamid}")
    void deleteTeam(int teamid);
}
