package com.davidholas.julie.service;

import com.davidholas.julie.persistence.model.Event;
import com.davidholas.julie.persistence.repository.EventRepository;
import com.davidholas.julie_api.models.EventDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventServiceImpl {

    //private String TIME_FORMAT = "dd.mm.yyyy HH:mm";

    private EventRepository eventRepository;

    public EventServiceImpl(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public List<Event> getEvents() {
        return eventRepository.findAll();
    }

    public Event getEvent(Long eventId) {
        return eventRepository.getById(eventId);
    }

    public Event createEvent(EventDto eventDto) {

        Event event = new Event();
        event.setCategory(eventDto.getCategory());
        event.setTime(eventDto.getTime());
        event.setTitle(eventDto.getTitle());
        event.setDescription(eventDto.getDescription());

        return eventRepository.save(event);
    }

    public void deleteEvent(Long eventId) {

        eventRepository.deleteById(eventId);
    }
}
