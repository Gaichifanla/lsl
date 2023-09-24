package com.lsl.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Weight {
    private Long userId;
    private Long taskType;
    private Long taskNumber;
    private int userState;
    private int taskWeight;
    private int userWeight;
    private Long teamId;

}
