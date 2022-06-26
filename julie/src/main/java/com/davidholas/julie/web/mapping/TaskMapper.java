package com.davidholas.julie.web.mapping;

import com.davidholas.julie.persistence.model.Task;
import com.davidholas.julie_api.models.TaskDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TaskMapper {

    TaskDto mapToDto(Task task);

    Task mapToEntity(TaskDto dto);

    List<TaskDto> mapToDtoList(List<Task> tasks);
}
