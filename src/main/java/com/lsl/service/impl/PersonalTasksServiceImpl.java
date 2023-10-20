package com.lsl.service.impl;

import com.lsl.entity.PersonalTasks;
import com.lsl.mapper.PersonalTasksMapper;
import com.lsl.service.PersonalTasksService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PersonalTasksServiceImpl implements PersonalTasksService {
    @Resource
    private PersonalTasksMapper personalTasksMapper;
    @Override
    public List<PersonalTasks> getAllTasksByUserId(int userId) {
        return personalTasksMapper.getAllTasksByUserId(userId);
    }

    @Override
    public void insertPersonalTask(PersonalTasks personalTasks) {
        personalTasksMapper.insertPersonalTask(personalTasks);
    }

    @Override
    public void updatePersonalTasksContent(String content) {
        personalTasksMapper.updatePersonalTasksContent(content);
    }

    @Override
    public void deletePersonalTaskById(int id) {
        personalTasksMapper.deletePersonalTaskById(id);
    }
}
