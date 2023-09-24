package com.lsl.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Record {
    private Long taskId;
    private Long userId;
    private Long teamId;
    private int taskScore;
}
