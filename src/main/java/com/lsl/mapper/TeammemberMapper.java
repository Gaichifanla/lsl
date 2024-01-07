package com.lsl.mapper;

import com.lsl.entity.Team;
import com.lsl.entity.Teammember;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TeammemberMapper {
    @Select("select * from teammember where user_id=#{userId}")
    Teammember getTeamMemberByUserId(int userId);
    @Select("select * from teammember where team_id=#{teamId}")
    List<Teammember> getAllTeamMemberByTeamId(int teamId);
    @Select("select team_id from teammember where user_id=#{userId}")
    int getTeamIdByUserId(int userId);

    @Insert("insert into teammember(user_id,team_id,permission)"+
            "values "+"(#{userId},#{teamId},#{permission})")
    void insertTeamMember(Teammember teammember);

    @Delete("delete from teammember where user_id=#{userId} and team_id=#{teamId} ")
    void deleteTeamMember();


}
