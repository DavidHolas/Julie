package com.davidholas.julie.web.controller;

import com.davidholas.julie.service.TaskService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskController {

    private TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

}
