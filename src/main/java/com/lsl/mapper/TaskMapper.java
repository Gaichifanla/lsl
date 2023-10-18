package com.lsl.mapper;

import com.lsl.entity.Task;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TaskMapper {

    @Select("select * from task")
    List<Task> getAll();

    @Select("select * from task where task_name=#{taskname})")
    Task getTaskByTaskName(String taskname);

    @Select("select * from task where project_id=#{projectid}")
    Task getTaskByProjectId(int projectid);

    @Select("select * from task where leader_id=#{leaderid}")
    Task getTaskByLeaderId();

    @Select("select * from task where creator_id=#{creatorid}")
    Task getTaskByCreatorId();
    //时间顺序
    @Select("select * from task order by creat_time desc ")
    Task getTaskByOrderCreatTime();
    //时间倒序
    @Select("select * from task order by creat_time desc ")
    Task getTaskByReverseOrderCreatTime();

    @Insert("insert into task (task_name,description,state,priority,project_id,leader_id,creater_id,creat_time,end_time)" +
            "values"+
            "(#{taskname},#{description},#{state},#{priority},#{projectid},#{leaderid},#{creatorid},current_timestamp,#{endtime})")
    void insertTask(Task task);

    @Update("update task set task_name=#{taskname},description=#{description},state=#{state},priority=#{priority} where task_id=#{taskid}}")
    void updateTask(Task task);
    @Delete("delete from task where task_id=#{taskid}")
    void deleteTask(int taskid);



}
