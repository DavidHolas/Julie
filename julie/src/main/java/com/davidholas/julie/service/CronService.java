package com.davidholas.julie.service;

import com.davidholas.julie.persistence.model.Event;
import com.davidholas.julie.persistence.model.enumerations.EventCategory;
import com.davidholas.julie.persistence.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CronService {

    @Autowired
    public EventServiceImpl eventService;

    @Scheduled(cron = "0 0 9 * * *")
    public void checkTodaysEvents() {
        List<Event> todaysEvents = eventService.getEvents();

        if(!todaysEvents.isEmpty()) {
            // Založit Julince messenger účet a poslat mi zprávu o dnešních plánech
        }
    }

    @Scheduled(cron = "0 0 9 * * *")
    public void checkTodaysBirthdays() {
        List<Event> todaysBirthdays = eventService.getEventsByCategory(EventCategory.BIRTHDAY.name());

        if(!todaysBirthdays.isEmpty()) {
            // Založit Julince messenger účet a poslat mi zprávu o dnešních narozeninách
        }
    }
}
