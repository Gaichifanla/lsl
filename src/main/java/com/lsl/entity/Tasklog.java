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
public class Tasklog {
    private int id;
    private int taskid;
    private int operatorid;
    //表名
    private String type;
    private Date time;
    private String note;
}