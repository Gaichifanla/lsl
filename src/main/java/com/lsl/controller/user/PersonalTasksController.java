package com.lsl.controller.user;

import com.lsl.annotation.TaskLog;
import com.lsl.entity.PersonalTasks;
import com.lsl.result.Result;
import com.lsl.service.PersonalTasksService;
import com.lsl.vo.PTStateVo;
import jakarta.websocket.server.PathParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

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

    /**
     * 接收单个PersonalTasks数据
     * @param personalTasks
     * @return
     */
//    @TaskLog(type="personal_tasks",value="添加任务")
    @GetMapping("/insertPersonalTask")
    public Result insertPersonalTask(PersonalTasks personalTasks){
        log.info("调用insertPersonalTask函数");
        //log.info("调用函数");
        personalTasksService.insertPersonalTask(personalTasks);
        return Result.success(personalTasks);
    }

    /**
     * 按id更新状态
     * @param ptStateVo
     * @return
     */
    @TaskLog(type="personal_tasks",value = "更改任务")
    @PutMapping("/updatePersonalTasksState")
    public Result updatePersonalTasksState(@RequestBody PTStateVo ptStateVo){
        log.info("更新"+ptStateVo.getId()+"的state为:"+ptStateVo.getState());
        personalTasksService.updatePersonalTasksState(ptStateVo.getId(), ptStateVo.getState());
        return Result.success("更新成功");
    }

}
