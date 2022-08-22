package com.davidholas.julie.service;

import com.davidholas.julie.persistence.model.RepeatableTask;
import com.davidholas.julie.persistence.model.enumerations.TaskType;
import com.davidholas.julie_api.models.TaskDto;

import java.util.List;

public interface RepeatableTaskService {

    List<RepeatableTask> getRepeatableTasks();

    RepeatableTask getRepeatableTaskBy(Long id);

    RepeatableTask createRepeatableTask(TaskDto taskDto);

    void deleteRepeatableTask(Long id);

    List<RepeatableTask> getRepeatableTasksByFrequency(TaskType frequency);
}
