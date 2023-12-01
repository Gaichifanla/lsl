package com.lsl.controller;

import com.lsl.entity.Team;
import com.lsl.result.Result;
import com.lsl.service.TeamService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/teamController")
@Slf4j
public class TeamController {
    @Resource
    private TeamService teamService;

    @GetMapping("")
    public Result getAllTeam(){
        log.info("调用getAllTeam函数");
        return Result.success(teamService.getAllTeam());
    }

}
