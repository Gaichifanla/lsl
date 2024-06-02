package com.lsl.service.impl;

import com.lsl.dto.TeamTaskDto;
import com.lsl.entity.TeamTask;
import com.lsl.mapper.TeamTaskMapper;
import com.lsl.result.Result;
import com.lsl.service.TeamTaskService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
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
     * 任务状态:0 未开始,1 进行中,2 已完成
     * 任务类型:0 个人,1 团队
     * @return
     */
    @Override
    public Result listAll(TeamTaskDto dto) {
        //校验任务类型
        if (dto.getTaskType() != null){
            if (dto.getTaskType() != 0 && dto.getTaskType() != 1){
                dto.setTaskType(null);
            }
        }
        return Result.success(taskMapper.listAll(dto));
    }
}
