package com.lsl.service.impl;

import com.lsl.entity.TeamTask;
import com.lsl.mapper.TeamTaskMapper;
import com.lsl.result.Result;
import com.lsl.service.TeamTaskService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class TeamTaskServiceImpl implements TeamTaskService {
    @Resource
    private TeamTaskMapper taskMapper;
    @Override
    public List<TeamTask> getAllTask() {
        return taskMapper.getAll();
    }


    @Override
    public void createTask(TeamTask teamTask) {
        taskMapper.insertTask(teamTask);
    }

    @Override
    public void updateTask(TeamTask teamTask) {
        taskMapper.updateTask(teamTask);
    }

    @Override
    public void deleteTask(int taskId) {
        taskMapper.deleteTask(taskId);
    }

    /**
     * 动态sql查询所有符合条件的任务
     *
     * @return
     */
    @Override
    public Result listAll() {
        return taskMapper.listAll();
    }
}
