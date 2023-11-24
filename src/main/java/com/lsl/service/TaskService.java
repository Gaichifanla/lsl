package com.lsl.service;

import com.lsl.entity.TeamTask;
import org.springframework.scheduling.config.Task;

import java.util.List;

public interface TaskService {
    List<TeamTask> getAllTask();

    List<TeamTask> getTaskByCreatorId();

    void createTask(TeamTask teamTask);

    void updateTask(TeamTask teamTask);

    void deleteTask(int taskId);


}
