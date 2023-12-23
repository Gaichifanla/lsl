package com.lsl.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PTStateVo {
    private Integer id;

    private Integer state;

    private Integer userId;
}
