package com.lsl.mapper;

import com.lsl.entity.Tasklog;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
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

    @Insert("insert into tasklog (operator_id,task_id,type,time,note)"+
            "values"+
            "(#{operatorid},#{taskid},#{type},current_timestamp,#{note})"
    )
    void insertTaskLog(Tasklog tasklog);

    @Delete("delete from tasklog where id=#{id}")
    void deleteTaskLog();





}
