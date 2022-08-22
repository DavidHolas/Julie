package com.davidholas.julie.web.mapping;

import com.davidholas.julie.persistence.model.RepeatableTask;
import com.davidholas.julie_api.models.TaskDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RepeatableTaskMapper {

    TaskDto mapToDto(RepeatableTask task);

    RepeatableTask mapToEntity(TaskDto dto);

    List<TaskDto> mapToDtoList(List<RepeatableTask> tasks);
}
