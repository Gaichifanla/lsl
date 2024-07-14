package com.lsl.mapper;


import com.lsl.entity.TaskScore;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author acer
* @description 针对表【task_score】的数据库操作Mapper
* @createDate 2024-06-17 21:07:46
* @Entity .com.lsl.entity.TaskScore
*/
@Mapper
public interface TaskScoreMapper extends BaseMapper<TaskScore> {

    public Double getAverageByType(Integer taskCompleterId,Integer taskTypeId);


}
