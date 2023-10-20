package com.lsl.mapper;

import com.lsl.entity.Project;
import com.lsl.entity.TeamTask;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ProjectMapper {
    @Select("select * from project")
    List<Project> getAllProject();

    @Select("select * from project where project_name=#{projectname}")
    Project getProjectByProjectName();

    @Select("select * from project where team_id=#{teamid}")
    Project getProjectByTeamId();

    @Select("select * from project where creator_id=#{creatorid}")
    Project getProjectByCreatorId();

    //时间顺序
    @Select("select * from project order by creat_time desc ")
    TeamTask getProjectByOrderCreatTime();
    //时间倒序
    @Select("select * from project order by creat_time desc ")
    TeamTask getProjectByReverseOrderCreatTime();

    @Insert("insert into project(project_name,description,team_id,creator_id,creat_time,end_time)"+
            "values"+
            "#{projectname},#{description},#{teamid},#{creatorid},current_timestamp,#{endtime}")
    void insertProject();

    @Update("update task set project_name=#{projectname},description=#{description},end_time=#{endtime} where project_id=#{projectid}}")
    void updateProject(Project project);

    @Delete("delete from project where project_id=#{projectid}")
    void deleteProject(int projectid);
}
