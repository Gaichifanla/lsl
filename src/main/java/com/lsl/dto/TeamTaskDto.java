package com.lsl.dto;

import java.util.Date;

public class TeamTaskDto {
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
     * 创建者id
     */
    private Integer userId;

    /**
     *
     */
    private Date startTime;

    /**
     *
     */
    private Date endTime;

    /**
     *
     */
    private Date createTime;

    /**
     * 任务类型
     */
    private Integer taskType;
}
