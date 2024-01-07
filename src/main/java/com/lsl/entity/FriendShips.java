package com.lsl.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FriendShips {
    private Long friendshipId;
    private Long userAId;
    private Long userBId;
    private Integer status;
    private String createdAt;
}
