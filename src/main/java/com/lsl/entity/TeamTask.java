package com.lsl.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

/**
 * 
 * @TableName team_task
 */
@Data
public class TeamTask implements Serializable {
    /**
     * 
     */
    private Integer taskId;

    /**
     * 任务名称
     */
    private String taskName;

    /**
     * 任务描述
     */
    private String description;

    /**
     * 任务状态
     */
    private Integer state;

    /**
     * 任务权重
     */
    private Integer priority;

    /**
     * 项目id
     */
    private Integer projectId;

    /**
     * 项目leader的id
     */
    private Integer leaderId;

    /**
     * 创建者id
     */
    private Integer userId;

    /**
     * 注解防止传到前端数据变为数组
     */

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime startTime;

    /**
     * 
     */

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime endTime;

    /**
     * 
     */

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime createTime;

    /**
     * 任务类型
     */
    private Integer taskType;

    private static final long serialVersionUID = 1L;
}