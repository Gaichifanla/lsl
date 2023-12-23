package com.lsl.service.impl;

import com.lsl.entity.Tasklog;
import com.lsl.mapper.TasklogMapper;
import com.lsl.service.TasklogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service
public class TasklogServiceImpl implements TasklogService {
    @Resource
    TasklogMapper tasklogMapper;
    @Override
    public void insertTaskLog(Tasklog tasklog) {
        tasklogMapper.insertTaskLog(tasklog);
    }
}
