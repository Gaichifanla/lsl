package com.lsl.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName task_score
 */
@Data
public class TaskScore implements Serializable {
    /**
     * 评分id
     */
    private Integer id;

    /**
     * 评分任务类型id
     */
    private Integer taskTypeId;

    /**
     * 评分 1-10
     */
    private Integer score;

    /**
     * 评分者
     */
    private Integer scorer;

    /**
     * 任务id
     */
    private Integer taskId;

    /**
     * 任务完成者id
     */
    private Integer taskCompleterId;

    private static final long serialVersionUID = 1L;
}