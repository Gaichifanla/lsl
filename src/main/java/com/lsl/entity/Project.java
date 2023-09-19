package com.lsl.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@Builder
@NoArgsConstructor//无参构造方法
@AllArgsConstructor//全参构造方法
public class Project {
    private int projectid;
    private String projectname;
    private String description;
    private int teamid;
    private int creatorid;
    private Date creattime;
    private Date endtime;

}
