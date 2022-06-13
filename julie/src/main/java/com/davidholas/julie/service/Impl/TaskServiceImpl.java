package com.davidholas.julie.service.Impl;

import com.davidholas.julie.dto.TaskDto;
import com.davidholas.julie.persistence.model.Task;
import com.davidholas.julie.persistence.repository.TaskRepository;
import com.davidholas.julie.service.TaskService;
import com.davidholas.julie.web.mapping.TaskMapper;
import org.springframework.stereotype.Service;

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
    public Task getTask(Long taskId) {
        return taskRepository.getById(taskId);
    }

    @Override
    public void createTask(TaskDto taskDto) {
         taskRepository.save(taskMapper.mapToEntity(taskDto));
    }

    @Override
    public void deleteTask(Long taskId) {
        taskRepository.deleteById(taskId);
    }

    @Override
    public void completeTask(Long taskId) {
        taskRepository.completeTask(taskId);
    }

}
