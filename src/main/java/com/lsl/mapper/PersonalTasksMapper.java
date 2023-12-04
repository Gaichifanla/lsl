package com.lsl.mapper;

import com.lsl.entity.PersonalTasks;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
* @author acer
* @description 针对表【personal_tasks】的数据库操作Mapper
* @createDate 2023-10-20 14:42:07
* @Entity .com.lsl.entity.PersonalTasks
*/
@Mapper
public interface PersonalTasksMapper {
    @Select("select * from personal_tasks where user_id=#{userId}")
    List<PersonalTasks> getAllTasksByUserId(int userId);

    @Insert("insert into personal_tasks(user_id,content,state,start_time,end_time,creat_time)"+
            "values"+
            "(#{userId},#{content},#{state},#{startTime},#{endTime},current_timestamp)")
    void insertPersonalTask(PersonalTasks personalTasks);

    @Update("update personal_tasks set content=#{content}")
    void updatePersonalTasksContent(String content);

    @Delete("delete from personal_tasks where id=#{id}")
    void deletePersonalTaskById(int id);

}
