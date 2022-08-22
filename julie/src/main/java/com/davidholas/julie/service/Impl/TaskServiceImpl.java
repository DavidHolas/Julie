package com.davidholas.julie.service.Impl;

import com.davidholas.julie.persistence.model.Task;
import com.davidholas.julie.persistence.model.TaskState;
import com.davidholas.julie.persistence.repository.TaskRepository;
import com.davidholas.julie.persistence.repository.TaskStateRepository;
import com.davidholas.julie.service.TaskService;
import com.davidholas.julie.web.mapping.TaskMapper;
import com.davidholas.julie_api.models.TaskDto;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    private TaskRepository taskRepository;

    private TaskStateRepository taskStateRepository;

    private TaskMapper taskMapper;

    public TaskServiceImpl(TaskRepository taskRepository,
                           TaskStateRepository taskStateRepository,
                           TaskMapper taskMapper) { 
        this.taskRepository = taskRepository;
        this.taskStateRepository = taskStateRepository;
        this.taskMapper = taskMapper;
    }

    @Override
    public List<Task> getTasks() {
        return taskRepository.findAllByOrderByTimeDueAsc();
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
    public Task completeTask(TaskDto taskDto) {
        Task task = taskRepository.findById(taskDto.getId()).get();
        TaskState stateCompleted = taskStateRepository.getById(2L);

        task.setTaskState(stateCompleted);
        task.setCompletedAt(LocalDateTime.now());

        Task completedTask = taskRepository.save(task);
        return completedTask;
    }

    @Override
    public void updateTaskState(Long taskId, Long taskStateId) {
        Task task = taskRepository.findById(taskId).get();

        task.setTaskStateId(taskStateId);


    }

}
