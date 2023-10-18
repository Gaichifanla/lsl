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
public class Task {
    private int taskid;

    private String taskname;

    private String description;

    private String state;

    //优先级
    private String priority;
    private int projectid;
    private int leaderid;
    private  int creatorid;
    private Date creattime;
    private  Date endtime;
}
