package com.lsl.mapper;

import com.lsl.entity.TeamTask;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TaskMapper {

    @Select("select * from team_task")
    List<TeamTask> getAll();

    @Select("select * from team_task where task_name=#{taskname})")
    TeamTask getTaskByTaskName(String taskname);

    @Select("select * from team_task where project_id=#{projectid}")
    TeamTask getTaskByProjectId(int projectid);

    @Select("select * from team_task where leader_id=#{leaderid}")
    TeamTask getTaskByLeaderId();

    @Select("select * from team_task where creator_id=#{creatorid}")
    TeamTask getTaskByCreatorId();
    //时间顺序
    @Select("select * from team_task order by creat_time desc ")
    TeamTask getTaskByOrderCreatTime();
    //时间倒序
    @Select("select * from team_task order by creat_time desc ")
    TeamTask getTaskByReverseOrderCreatTime();

    @Insert("insert into team_task (task_name,description,state,priority,project_id,leader_id,creater_id,creat_time,end_time)" +
            "values"+
            "(#{taskname},#{description},#{state},#{priority},#{projectid},#{leaderid},#{creatorid},current_timestamp,#{endtime})")
    void insertTask(TeamTask teamTask);

    @Update("update team_task set task_name=#{taskname},description=#{description},state=#{state},priority=#{priority} where task_id=#{taskid}}")
    void updateTask(TeamTask teamTask);
    @Delete("delete from team_task where task_id=#{taskid}")
    void deleteTask(int taskid);

}
