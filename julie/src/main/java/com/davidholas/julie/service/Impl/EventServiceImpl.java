package com.davidholas.julie.service.Impl;

import com.davidholas.julie.persistence.model.Event;
import com.davidholas.julie.persistence.repository.EventRepository;
import com.davidholas.julie_api.models.EventDto;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class EventServiceImpl {

    private EventRepository eventRepository;

    public EventServiceImpl(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public List<Event> getEvents() {

        Sort sort = Sort.by(Sort.Direction.ASC, Event.Fields.time);
        return eventRepository.findAll(sort);
    }

    public Event getEvent(Long eventId) {
        return eventRepository.getById(eventId);
    }

    public List<Event> getEventsByCategory(String category) {
        return eventRepository.findByCategory(category);
    }

    public Event createEvent(EventDto eventDto) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        Event event = new Event();
        event.setCategory(eventDto.getCategory());
        event.setTime(LocalDateTime.parse(eventDto.getTime(), formatter));
        event.setTitle(eventDto.getTitle());
        event.setDescription(eventDto.getDescription());

        return eventRepository.save(event);
    }

    public void deleteEvent(Long eventId) {

        eventRepository.deleteById(eventId);
    }
}
