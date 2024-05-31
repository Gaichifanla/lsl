package com.lsl.controller.user;

import com.lsl.dto.TeamTaskDto;
import com.lsl.entity.TeamTask;
import com.lsl.result.Result;
import com.lsl.service.TeamTaskService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/teamTask")
@Slf4j
public class TeamTaskController {
    @Resource
    private TeamTaskService taskService;

    /**
     * 创建任务
     * task_type: 0 个人任务 1 团队任务
     * @param teamTask
     * @return
     */
    @GetMapping("/createTeamWork")
    public Result createTeamWork(TeamTask teamTask){
        taskService.createTask(teamTask);
        log.info("调用createTeamWork函数创建团队任务");
        return Result.success(teamTask);
    }

    /**
     * 查询任务
     * 接受参数userid+其他
     * @param dto
     * @return
     */
    @GetMapping("/listAll")
    public Result listAll(TeamTaskDto dto){

        return taskService.listAll();

    }
}
