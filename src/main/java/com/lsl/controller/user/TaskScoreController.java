package com.lsl.controller.user;

import com.lsl.entity.TaskScore;
import com.lsl.result.Result;
import com.lsl.service.TaskScoreService;
import com.lsl.service.impl.TaskScoreServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/TaskScoreController")
public class TaskScoreController {
    @Autowired
    private TaskScoreService taskScoreService;
    /**
     * 评分
     * @param taskScore
     * @return
     */
    public Result addTaskScore(TaskScore taskScore){
        return null;
    }
    /**
     * 动态查询
     * @param taskScore
     * @return
     */
    public List<TaskScore> list(TaskScore taskScore){
        return null;
    }
    /**
     * 查询某个任务类型评分最高的组员id
     * @param taskCompleterId
     * @param taskTypeId
     * @return
     */
    @GetMapping("/getAverageByType")
    public Result getAverageByType(@RequestHeader Integer taskCompleterId,@RequestHeader Integer taskTypeId){
        System.out.println(taskCompleterId+"  "+taskTypeId);
        Double averageByType = taskScoreService.getAverageByType(taskCompleterId, taskTypeId);
        return Result.success(averageByType);
    }

}
