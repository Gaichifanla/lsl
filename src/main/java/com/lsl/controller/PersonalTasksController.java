package com.lsl.controller;

import com.lsl.entity.PersonalTasks;
import com.lsl.result.Result;
import com.lsl.service.PersonalTasksService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@RestController
@RequestMapping("/personal_list")
@Slf4j
public class PersonalTasksController {
    @Resource
    private PersonalTasksService personalTasksService;

    @GetMapping("/getAllTasksByUserId")
    public Result getAllTasksByUserId(int userId){
        log.info("查询id为"+userId+"的任务列表");
        return Result.success(personalTasksService.getAllTasksByUserId(userId));
    }

    @GetMapping("/insertPersonalTask")
    public Result insertPersonalTask(PersonalTasks personalTasks){
        log.info("调用insertPersonalTask函数");
        //log.info("调用函数");
        personalTasksService.insertPersonalTask(personalTasks);
        return Result.success(personalTasks);
    }
}
