package com.lsl.service;

import com.lsl.entity.Priority;

import java.util.List;

public interface PriorityService {
    /**
     * 查询所有任务等级
     * @return
     */
    public List<Priority> list();
}
