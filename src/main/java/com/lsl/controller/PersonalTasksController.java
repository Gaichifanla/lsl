package com.lsl.controller;

import com.lsl.entity.PersonalTasks;
import com.lsl.result.Result;
import com.lsl.service.PersonalTasksService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping()
@Slf4j
public class PersonalTasksController {
    @Resource
    private PersonalTasksService personalTasksService;

    @GetMapping()
    public Result getAllTasksByUserId(int userId){
        log.info("查询id为"+userId+"的任务列表");
        return Result.success(personalTasksService.getAllTasksByUserId(userId));
    }
    @GetMapping()
    public Result insertPersonalTask(PersonalTasks personalTasks){
        personalTasksService.insertPersonalTask(personalTasks);
        return Result.success(personalTasks);
    }
}
