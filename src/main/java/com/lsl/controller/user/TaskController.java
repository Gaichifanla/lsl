package com.lsl.controller.user;

import com.lsl.entity.TeamTask;
import com.lsl.result.Result;
import com.lsl.service.TaskService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/teamTask")
@Slf4j
public class TaskController {
    @Resource
    private TaskService taskService;
    @GetMapping("/createTeamWork")
    public Result createTeamWork(TeamTask teamTask){
        taskService.createTask(teamTask);
        log.info("调用createTeamWork函数创建团队任务");
        return Result.success(teamTask);
    }
}
