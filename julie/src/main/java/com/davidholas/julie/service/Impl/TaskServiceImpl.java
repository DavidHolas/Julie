package com.davidholas.julie.service.Impl;

import com.davidholas.julie.enums.TaskStateEnum;
import com.davidholas.julie.persistence.model.Task;
import com.davidholas.julie.persistence.repository.TaskRepository;
import com.davidholas.julie.service.TaskService;
import com.davidholas.julie.web.mapping.TaskMapper;
import com.davidholas.julie_api.models.TaskDto;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    private TaskRepository taskRepository;

    private TaskMapper taskMapper;

    public TaskServiceImpl(TaskRepository taskRepository,
                           TaskMapper taskMapper) { 
        this.taskRepository = taskRepository;
        this.taskMapper = taskMapper;
    }

    @Override
    public List<Task> getTasks() {
        return taskRepository.findAll();
    }

    @Override
    public List<Task> getTasksForUser(Long personId) {
        return taskRepository.findByPersonId(personId);
    }

    @Override
    public List<Task> getTasksForDate(LocalDate date) {
        return null;
    }

    @Override
    public Task getTask(Long taskId) {
        return taskRepository.getById(taskId);
    }

    @Override
    public Task createTask(TaskDto taskDto) {
         return taskRepository.save(taskMapper.mapToEntity(taskDto));
    }

    @Override
    public void deleteTask(Long taskId) {
        taskRepository.deleteById(taskId);
    }

    @Override
    public void updateTaskState(Long taskId) {
        Task task = taskRepository.findById(taskId).get();

        task.setTaskState(TaskStateEnum.COMPLETED.name());


    }

}
