package com.lsl.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lsl.entity.TaskScore;
import com.lsl.result.Result;

import java.util.List;

/**
* @author acer
* @description 针对表【task_score】的数据库操作Service
* @createDate 2024-06-17 21:07:46
*/
public interface TaskScoreService extends IService<TaskScore> {
    /**
     * 评分
     * @param taskScore
     * @return
     */
    public Result addTaskScore(TaskScore taskScore);
    /**
     * 动态查询
     * @param taskScore
     * @return
     */
    public List<TaskScore> list(TaskScore taskScore);
    /**
     * 查询某个任务类型评分最高的组员id
     * @param taskCompleterId
     * @param taskTypeId
     * @return
     */
    public Double getAverageByType(Integer taskCompleterId,Integer taskTypeId);
}
