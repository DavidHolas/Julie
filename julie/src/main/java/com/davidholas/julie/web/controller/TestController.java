package com.davidholas.julie.web.controller;

import com.davidholas.julie.persistence.model.Task;
import com.davidholas.julie.persistence.model.enumerations.TaskType;
import com.davidholas.julie.persistence.repository.TaskRepository;
import com.davidholas.julie.service.TaskService;
import com.davidholas.julie.web.mapping.TaskMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {

    private TaskRepository taskRepository;

    public TestController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @GetMapping
    public void testMethod() {
        List<Task> failedTasks = taskRepository.findAllByTaskTypeAndCompletedAt(TaskType.DAILY, null);

        for(Task task : failedTasks) {
            System.out.println(task.toString());
        }
    }
}
