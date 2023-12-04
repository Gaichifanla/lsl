package com.lsl.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @TableName weight
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Weight implements Serializable {
    /**
     * 
     */
    private Long userId;

    /**
     * 
     */
    private Integer taskType;

    /**
     * 
     */
    private Integer taskNumber;

    /**
     * 
     */
    private Integer userState;

    /**
     * 
     */
    private Integer taskWeight;

    /**
     * 
     */
    private Integer userWeight;

    /**
     * 
     */
    private Integer teamId;

    private static final long serialVersionUID = 1L;
}