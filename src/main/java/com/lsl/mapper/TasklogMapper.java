package com.lsl.mapper;

import com.lsl.entity.Task;
import com.lsl.entity.Tasklog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TasklogMapper {
    @Select("select * from tasklog")
    List<Tasklog> getAll();

    @Select("select * from tasklog where id=#{id}")
    Tasklog getTaskById(int id);

    @Select("select * from tasklog where task_id=#{taskid}")
    Tasklog getTaskByTaskId(int taskid);

    @Select("select * from tasklog where operator_id=#{operatorid}")
    Tasklog getTaskByOperatorId(int operatorid);





}
