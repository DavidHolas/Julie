package com.davidholas.julie.service;

import com.davidholas.julie.persistence.model.Task;
import com.davidholas.julie_api.models.TaskDto;

import java.time.LocalDate;
import java.util.List;

public interface TaskService {

    List<Task> getTasks();

    List<Task> getTasksForUser(Long userId);

    List<Task> getTasksForDate(LocalDate date);

    Task getTask(Long taskId);

    Task createTask(TaskDto taskDto);

    void deleteTask(Long taskId);

    void updateTaskState(Long taskId);

    //get all tasks DONE
    //get all tasks for user
    //get all tasks for day

    //get task DONE
    //create task DONE
    //delete task DONE
    //update task state DONE
}
