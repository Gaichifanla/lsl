package com.lsl.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lsl.dto.TeamTaskDto;
import com.lsl.entity.Team;
import com.lsl.entity.TeamTask;
import com.lsl.entity.Teammember;
import com.lsl.mapper.TeamMapper;
import com.lsl.mapper.TeamTaskMapper;
import com.lsl.mapper.TeammemberMapper;
import com.lsl.result.Result;
import com.lsl.service.TaskScoreService;
import com.lsl.service.TeamTaskService;
import com.lsl.service.TeammemberService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.*;

@Service
public class TeamTaskServiceImpl extends ServiceImpl<TeamTaskMapper, TeamTask> implements TeamTaskService {
    @Resource
    private TeamTaskMapper taskMapper;
    @Resource
    private TeamMapper teamMapper;
    @Resource
    private TeammemberMapper teammemberMapper;
    @Resource
    private TaskScoreService taskScoreService;
    @Override
    public List<TeamTask> getAllTask() {
        return taskMapper.getAll();
    }


    /**
     * 创建任务并据情况执行分配
     * @param teamTask
     */
    @Override
    public void createTask(TeamTask teamTask) {
        //1.校验参数
        //2.按需分配人员
        //根据leaderId查询团队Id
        System.out.println(teamTask);
        Team team = teamMapper.selectOne(Wrappers.<Team>lambdaQuery().eq(Team::getCreatorId, teamTask.getLeaderId()));
        //分配函数
        Integer userId = distribution(team.getTeamId(), teamTask.getTaskType());

        teamTask.setUserId(userId);
        //3.保存数据
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

    /**
     * 分配函数
     * @return
     */
    public Integer distribution(Integer teamId,Integer taskTypeId){
        //根据teamId查询团队成员
        List<Teammember> teammembers = teammemberMapper.selectList(Wrappers.<Teammember>lambdaQuery().eq(Teammember::getTeamId, teamId));
        //遍历团队成员，判断是否已有任务，并取空闲状态成员
        //用户ID，平均分
        Map<Integer,Double> map = new HashMap<>();
        for (Teammember teammember : teammembers) {
            if(teammember.getMemberState() == 0){
                Double score = taskScoreService.getAverageByType(teammember.getUserId(), taskTypeId);
                map.put(teammember.getUserId(),score);
            }
        }
        //遍历map得到最高分对象
        Integer userId = 0;
        Double maxValue = 0.0;
        for (Map.Entry <Integer, Double>  entry : map.entrySet()) {
            if (entry.getValue() == null) {
                continue;


            }
            if (entry.getValue() > maxValue){
                maxValue = entry.getValue();
                userId = entry.getKey();
            }

        }
        if (!map.isEmpty()){
            map.clear();
            map.put(userId,maxValue);
        }

        //匹配当前任务类型和成员，取该任务类型评分最高者
        return userId;

    }
}
