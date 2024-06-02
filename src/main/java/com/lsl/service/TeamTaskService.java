package com.lsl.service;

import com.lsl.dto.TeamTaskDto;
import com.lsl.entity.TeamTask;
import com.lsl.result.Result;

import java.util.List;

public interface TeamTaskService {
    List<TeamTask> getAllTask();


    void createTask(TeamTask teamTask);

    void updateTask(TeamTask teamTask);

    void deleteTask(int taskId);

    /**
     * 动态sql查询所有符合条件的任务
     * 任务状态:0 未开始,1 进行中,2 已完成
     * 任务类型:0 个人,1 团队
     * @return
     */
    Result listAll(TeamTaskDto dto);
}
