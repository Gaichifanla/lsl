package com.lsl.service;

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
     * @return
     */
    Result listAll();
}
