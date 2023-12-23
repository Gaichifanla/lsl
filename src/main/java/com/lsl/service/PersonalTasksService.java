package com.lsl.service;

import com.lsl.entity.PersonalTasks;

import java.util.List;

public interface PersonalTasksService {
    List<PersonalTasks> getAllTasksByUserId(int userId);

    void insertPersonalTask(PersonalTasks personalTasks);

    void updatePersonalTasksContent(String content);

    void updatePersonalTasksState(Integer id,Integer state);

    void deletePersonalTaskById(int id);

}
