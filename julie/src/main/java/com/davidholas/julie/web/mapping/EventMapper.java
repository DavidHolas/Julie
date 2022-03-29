package com.davidholas.julie.web.mapping;

import com.davidholas.julie.persistence.model.Event;
import com.davidholas.julie_api.models.EventDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EventMapper {

    EventDto mapToDto(Event event);

    List<EventDto> mapToDtoList(List<Event> events);
}
