package com.lsl.dto;

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
public class TeamAndMemberDTO {
    private int teamId;
    private String teamName;
    private int creatorId;
    private Date creatTime;
    private List<TeamMemberDTO> teamMemberDTOS;
}
