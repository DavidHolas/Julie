package com.davidholas.julie.service.Impl;

import com.davidholas.julie.persistence.model.RepeatableTask;
import com.davidholas.julie.persistence.model.enumerations.TaskType;
import com.davidholas.julie.persistence.repository.RepeatableTaskRepository;
import com.davidholas.julie.service.RepeatableTaskService;
import com.davidholas.julie.web.mapping.RepeatableTaskMapper;
import com.davidholas.julie_api.models.TaskDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RepeatableTaskServiceImpl implements RepeatableTaskService {

    private RepeatableTaskRepository repository;
    private RepeatableTaskMapper mapper;

    public RepeatableTaskServiceImpl(RepeatableTaskRepository repository,
                                     RepeatableTaskMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<RepeatableTask> getRepeatableTasks() {
        return repository.findAll();
    }

    @Override
    public RepeatableTask getRepeatableTaskBy(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public RepeatableTask createRepeatableTask(TaskDto taskDto) {
        return repository.save(mapper.mapToEntity(taskDto));
    }

    @Override
    public void deleteRepeatableTask(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<RepeatableTask> getRepeatableTasksByFrequency(TaskType frequency) {
        return repository.findAllByFrequency(frequency);
    }
}
