package com.lsl.entity;

import lombok.Data;

@Data
public class Priority {
    /**
     * 任务等级id
     */
    private Integer priorityId;
    /**
     * 等级描述
     */
    private String description;
}
