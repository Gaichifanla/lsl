package com.lsl.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserLoginVo {
    @ApiModelProperty("主键值")
    private Long openid;

    @ApiModelProperty("用户名")
    private String username;

    @ApiModelProperty("jwt令牌")
    private String token;
}
