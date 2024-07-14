package com.lsl.service.impl;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lsl.entity.TaskScore;
import com.lsl.mapper.TaskScoreMapper;
import com.lsl.result.Result;
import com.lsl.service.TaskScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
* @author acer
* @description 针对表【task_score】的数据库操作Service实现
* @createDate 2024-06-17 21:07:46
*/
@Service
public class TaskScoreServiceImpl extends ServiceImpl<TaskScoreMapper, TaskScore> implements TaskScoreService {
    @Resource
    private TaskScoreMapper taskScoreMapper;

    /**
     * 评分
     * @param taskScore
     * @return
     */
    public Result addTaskScore(TaskScore taskScore){
        taskScoreMapper.insert(taskScore);
        return Result.success("评分成功");
    }

    /**
     * 动态查询
     * @param taskScore
     * @return
     */
    public List<TaskScore> list(TaskScore taskScore){
        //构造查询条件
        QueryWrapper<TaskScore> queryWrapper = Wrappers.query();

        if (taskScore.getTaskCompleterId() != null) {
            queryWrapper.eq("task_completer_id",taskScore.getTaskCompleterId());
        }

        if (taskScore.getTaskTypeId() != null) {
            queryWrapper.eq("task_type_id", taskScore.getTaskTypeId());
        }

        return taskScoreMapper.selectList(queryWrapper);
    }

    /**
     * 查询某个组员某任务类型评分最高的分数
     * @param taskCompleterId
     * @param taskTypeId
     * @return
     */
    public Double getAverageByType(Integer taskCompleterId,Integer taskTypeId) {

        return taskScoreMapper.getAverageByType(taskCompleterId,taskTypeId);

    }

}
