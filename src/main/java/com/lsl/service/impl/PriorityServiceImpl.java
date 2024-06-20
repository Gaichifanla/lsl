package com.lsl.service.impl;

import com.lsl.entity.Priority;
import com.lsl.mapper.PriorityMapper;
import com.lsl.service.PriorityService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class PriorityServiceImpl implements PriorityService {
    @Resource
    private PriorityMapper priorityMapper;
    /**
     * 查询所有任务等级
     *
     * @return
     */
    @Override
    public List<Priority> list() {
        return priorityMapper.list();
    }
}
