package com.lsl.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;
@Data
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
     *加注解防止传到前段变成数组
     */

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime startTime;

    /**
     *
     */

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime endTime;

    /**
     *
     */

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    /**
     * 任务类型
     */
    private Integer taskType;
}
