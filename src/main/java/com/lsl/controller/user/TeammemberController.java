package com.lsl.controller.user;

import com.lsl.entity.Team;
import com.lsl.entity.Teammember;
import com.lsl.entity.User;
import com.lsl.result.Result;
import com.lsl.service.TeamService;
import com.lsl.service.TeammemberService;
import com.lsl.service.UserService;
import com.lsl.vo.TeamAndMemberVo;
import com.lsl.vo.TeamMemberVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/TeammemberController")
@Slf4j
public class TeammemberController {
    @Resource
    private TeammemberService teammemberService;
    @Resource
    private UserService userService;
    @Resource
    private TeamService teamService;

    @GetMapping("/getTeamMemberTeamId")
    public Result getTeamMemberTeamId(int teamId){
        log.info("调用getTeamMemberTeamId方法");

        return Result.success(teammemberService.getTeamMemberTeamId(teamId));
    }

    /**
     * 返回user同team的用户的部分信息和这个team的部分信息
     * @param userId
     * @return
     */
    @GetMapping("/getTeamMemberUserId")
    public Result getTeamMemberUserId(int userId){
        log.info("调用getTeamMemberUserId方法,查询当前用户的团队成员");
        List<TeamMemberVo> teamMemberVoList = new ArrayList<>();
        TeamAndMemberVo teamAndMemberVo = new TeamAndMemberVo();
        int teamId = teammemberService.getTeamMemberByUserId(userId).getTeamId();
        //与用户同team的所有用户List
        List<Teammember> teammemberList = teammemberService.getTeamMemberTeamId(teamId);
        for (Teammember t:teammemberList
             ) {
            TeamMemberVo teamMemberVo = new TeamMemberVo();
            User user = userService.getOneByAccount(t.getUserId());
            BeanUtils.copyProperties(user,teamMemberVo);
            teamMemberVoList.add(teamMemberVo);
        }
        teamAndMemberVo.setTeamMemberVoList(teamMemberVoList);

        Team team = teamService.getOneTeamById(teamId);
        BeanUtils.copyProperties(team,teamAndMemberVo);

        return Result.success(teamAndMemberVo);
    }


}
