package com.davidholas.julie.web.controller;

import com.davidholas.julie.service.EventServiceImpl;
import com.davidholas.julie.web.mapping.EventMapper;
import com.davidholas.julie_api.api.EventsApi;
import com.davidholas.julie_api.models.EventDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@RestController
public class EventController implements EventsApi {

    private EventServiceImpl eventService;

    private EventMapper eventMapper;

    private EventController(EventServiceImpl eventService,
                            EventMapper eventMapper) {
        this.eventService = eventService;
        this.eventMapper = eventMapper;
    }

    @Override
    public ResponseEntity<EventDto> createEvent(@Valid EventDto eventDto) {
        return ok(eventMapper.mapToDto(eventService.createEvent(eventDto)));
    }

    @Override
    public ResponseEntity<Void> deleteEvent(Long eventId) {

        eventService.deleteEvent(eventId);
        return ok(null);
    }

    @Override
    public ResponseEntity<EventDto> getEvent(Long eventId) {
        return ok(eventMapper.mapToDto(eventService.getEvent(eventId)));
    }

    @Override
    public ResponseEntity<List<EventDto>> getEvents(@Valid Integer integer, @Valid Integer integer1) {
        return ok(eventMapper.mapToDtoList(eventService.getEvents()));
    }
}
