package com.lsl.service.impl;

import com.lsl.entity.TeamTask;
import com.lsl.mapper.TaskMapper;
import com.lsl.service.TaskService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class TaskServiceImpl implements TaskService {
    @Resource
    private TaskMapper taskMapper;
    @Override
    public List<TeamTask> getAllTask() {
        return taskMapper.getAll();
    }

    @Override
    public List<TeamTask> getTaskByCreatorId() {
        return taskMapper.getTaskByCreatorId();
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
}
