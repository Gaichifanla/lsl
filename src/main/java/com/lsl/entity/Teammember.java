package com.lsl.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName teammember
 */
@Data
public class Teammember implements Serializable {
    /**
     * 
     */
    private Integer id;

    /**
     * 
     */
    private Integer userId;

    /**
     * 
     */
    private Integer teamId;

    /**
     * 
     */
    private Integer permission;

    /**
     * 0 空闲 1 已分配任务 2 正在完成任务
     */
    private Integer memberState;

    private static final long serialVersionUID = 1L;
}