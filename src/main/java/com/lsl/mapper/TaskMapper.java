package com.lsl.mapper;

import com.lsl.entity.TeamTask;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TaskMapper {

    @Select("select * from team_task")
    List<TeamTask> getAll();

    @Select("select * from team_task where task_name=#{taskname})")
    List<TeamTask> getTaskByTaskName(String taskname);

    @Select("select * from team_task where project_id=#{projectid}")
    List<TeamTask> getTaskByProjectId(int projectid);

    @Select("select * from team_task where leader_id=#{leaderid}")
    List<TeamTask> getTaskByLeaderId();

    @Select("select * from team_task where creator_id=#{creatorid}")
    List<TeamTask> getTaskByCreatorId();
    //时间顺序
    @Select("select * from team_task order by creat_time desc ")
    List<TeamTask> getTaskByOrderCreatTime();
    //时间倒序
    @Select("select * from team_task order by creat_time desc ")
    List<TeamTask> getTaskByReverseOrderCreatTime();

    @Insert("insert into team_task (task_name,description,state,priority,project_id,leader_id,creater_id,start_time,end_time,create_time)" +
            "values"+
            "(#{taskName},#{description},#{state},#{priority},#{projectId},#{leaderId},#{creatorId},#{startTime},#{endTime},current_timestamp)")
    void insertTask(TeamTask teamTask);

    @Update("update team_task set task_name=#{taskname},description=#{description},state=#{state},priority=#{priority} where task_id=#{taskid}}")
    void updateTask(TeamTask teamTask);
    @Delete("delete from team_task where task_id=#{taskid}")
    void deleteTask(int taskId);

}
