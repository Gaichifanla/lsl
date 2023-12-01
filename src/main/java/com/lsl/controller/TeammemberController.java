package com.lsl.controller;

import com.lsl.entity.Teammember;
import com.lsl.result.Result;
import com.lsl.service.TeammemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/TeammemberController")
@Slf4j
public class TeammemberController {
    @Resource
    private TeammemberService teammemberService;

    @GetMapping("/getTeamMemberTeamId")
    public Result getTeamMemberTeamId(int teamId){
        log.info("调用getTeamMemberTeamId方法");
        return Result.success(teammemberService.getTeamMemberTeamId(teamId));
    }

    @GetMapping("/getTeamMemberUserId")
    public Result getTeamMemberUserId(int userId){
        log.info("调用getTeamMemberUserId方法");
        return Result.success(teammemberService.getTeamMemberByUserId(userId));
    }


}
