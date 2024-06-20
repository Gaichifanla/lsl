package com.lsl.controller.user;

import com.lsl.dto.TeamTaskDto;
import com.lsl.entity.TeamTask;
import com.lsl.result.Result;
import com.lsl.service.PriorityService;
import com.lsl.service.TeamTaskService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping("/createTeamWork")
    public Result createTeamWork(@RequestBody TeamTask teamTask){
        taskService.createTask(teamTask);
        log.info("调用createTeamWork函数创建团队任务");
        return Result.success(teamTask);
    }

    /**
     * 查询任务
     * 接受参数userid+其他
     * 任务状态:0 未开始,1 进行中,2 已完成
     * 任务类型:0 个人,1 团队
     * @param dto
     * @return
     */
    @GetMapping("/listAll")
    public Result listAll(TeamTaskDto dto){
        log.info("执行listAll方法,{}",dto);
        System.out.println(taskService.listAll(dto));
        return taskService.listAll(dto);
    }
    @GetMapping("/choose")
    public Result choose(){
        return Result.success(null);
    }
}
