package com.lsl.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @TableName personal_tasks
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PersonalTasks implements Serializable {
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
    private String content;

    /**
     * 
     */
    private Integer state;

    /**
     * 
     */
    private String startTime;

    /**
     * 
     */
    private String endTime;

    /**
     *
     */
    private Date creatTime;

    private static final long serialVersionUID = 1L;
}