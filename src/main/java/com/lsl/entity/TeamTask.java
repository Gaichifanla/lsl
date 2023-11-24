package com.lsl.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TeamTask {
    private int taskId;

    private String taskName;

    private String description;

    private String state;

    //优先级
    private String priority;
    private int projectId;
    private int leaderId;
    private  int creatorId;
    private String startTime;
    private String creatTime;
    private  String endTime;
}
