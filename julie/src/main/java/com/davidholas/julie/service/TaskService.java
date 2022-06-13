package com.davidholas.julie.service;

import com.davidholas.julie.dto.TaskDto;
import com.davidholas.julie.persistence.model.Task;

import java.util.List;

public interface TaskService {

    List<Task> getTasks();

    Task getTask(Long taskId);

    void createTask(TaskDto taskDto);

    void deleteTask(Long taskId);
}
