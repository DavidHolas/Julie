package com.davidholas.julie.web.controller;

import com.davidholas.julie.persistence.model.Task;
import com.davidholas.julie.service.TaskService;
import com.davidholas.julie.web.mapping.TaskMapper;
import com.davidholas.julie_api.api.TasksApi;
import com.davidholas.julie_api.models.TaskDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@RestController
public class TaskController implements TasksApi {

    private TaskService taskService;
    private TaskMapper taskMapper;

    public TaskController(TaskService taskService,
                          TaskMapper taskMapper) {
        this.taskService = taskService;
        this.taskMapper = taskMapper;
    }

    @Override
    public ResponseEntity<TaskDto> createTask(@Valid TaskDto taskDto) {

        Task task = taskService.createTask(taskDto);

        return ok(taskMapper.mapToDto(task));
    }

    @Override
    public ResponseEntity<Void> deleteTask(Long taskId) {

        taskService.deleteTask(taskId);

        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<TaskDto> getTask(Long taskId) {

        Task task = taskService.getTask(taskId);

        return ok(taskMapper.mapToDto(task));
    }

    @Override
    public ResponseEntity<List<TaskDto>> getTasks(@Valid Integer offset, @Valid Integer limit) {

        return ok(taskMapper.mapToDtoList(taskService.getTasks()));
    }
}
