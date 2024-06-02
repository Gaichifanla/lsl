package com.lsl.mapper;

import com.lsl.dto.TeamTaskDto;
import com.lsl.entity.TeamTask;
import com.lsl.result.Result;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TeamTaskMapper {

    @Select("select * from team_task")
    List<TeamTask> getAll();


    @Insert("insert into team_task (task_name,description,state,priority,project_id,leader_id,creator_id,start_time,end_time,create_time)" +
            "values"+
            "(#{taskName},#{description},#{state},#{priority},#{projectId},#{leaderId},#{creatorId},#{startTime},#{endTime},current_timestamp)")
    void insertTask(TeamTask teamTask);

    @Update("update team_task set task_name=#{taskname},description=#{description},state=#{state},priority=#{priority} where task_id=#{taskid}")
    void updateTask(TeamTask teamTask);
    @Delete("delete from team_task where task_id=#{taskid}")
    void deleteTask(int taskId);

    List<TeamTask> listAll(TeamTaskDto dto);
}
