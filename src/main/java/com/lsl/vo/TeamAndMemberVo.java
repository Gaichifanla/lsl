package com.lsl.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TeamAndMemberVo {
    private int teamId;
    private String teamName;
    private int creatorId;
    private Date creatTime;
    private List<TeamMemberVo> teamMemberVoList;

}
