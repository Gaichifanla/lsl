package com.lsl.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Teammember {
    private int id;
    private String teamname;
    private int creatorid;

    //权限
    private String permission;

}
