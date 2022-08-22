package com.davidholas.julie.service.Impl;

import com.davidholas.julie.persistence.model.Event;
import com.davidholas.julie.persistence.model.RepeatableTask;
import com.davidholas.julie.persistence.model.Task;
import com.davidholas.julie.persistence.model.TaskState;
import com.davidholas.julie.persistence.model.enumerations.EventCategory;
import com.davidholas.julie.persistence.model.enumerations.TaskType;
import com.davidholas.julie.persistence.repository.RepeatableTaskRepository;
import com.davidholas.julie.persistence.repository.TaskRepository;
import com.davidholas.julie.persistence.repository.TaskStateRepository;
import com.davidholas.julie.service.CronService;
import com.davidholas.julie.service.Impl.EventServiceImpl;
import com.davidholas.julie.service.RepeatableTaskService;
import com.davidholas.julie.service.TaskService;
import com.davidholas.julie.utils.DateTimeUtils;
import com.davidholas.julie_api.models.TaskDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static com.davidholas.julie.persistence.model.enumerations.TaskType.DAILY;

@Service
public class CronServiceImpl implements CronService {

    @Autowired
    private EventServiceImpl eventService;

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private RepeatableTaskRepository repeatableTaskRepository;

    @Autowired
    private TaskStateRepository taskStateRepository;

    @Scheduled(cron = "0 20 21 * * *")
    public void createDailyTasks() {
        List<RepeatableTask> dailyTasks = repeatableTaskRepository.findAllByFrequency(DAILY);

        for (RepeatableTask dailyTask : dailyTasks) {
            int hour = dailyTask.getTimeDue().getHour();
            int minute = dailyTask.getTimeDue().getMinute();

            Task task = new Task();
            task.setTitle(dailyTask.getTitle());
            task.setDescription(dailyTask.getDescription());
            task.setPersonId(dailyTask.getPersonId());
            task.setTaskStateId(dailyTask.getTaskStateId());
            task.setTimeDue(LocalDate.now().atTime(hour, minute));
            task.setTaskType(TaskType.DAILY);
            taskRepository.save(task);
        }
    }

    @Scheduled(cron = "0 59 23 * * *")
    public void failUncompleteDailyTasks() {
        List<Task> failedTasks = taskRepository.findAllByTaskTypeAndCompletedAt(TaskType.DAILY, null);
        TaskState stateFailed = taskStateRepository.findById(3L).get();

        for (Task task : failedTasks) {
            task.setTaskState(stateFailed);
            taskRepository.save(task);
        }
    }

    @Scheduled(cron = "0 0 9 * * *")
    public void checkTodaysEvents() {
        //List<Event> todaysEvents = eventService.getEvents();

        //if(!todaysEvents.isEmpty()) {
            // Založit Julince messenger účet a poslat mi zprávu o dnešních plánech
        //}
    }

    @Scheduled(cron = "0 0 9 * * *")
    public void checkTodaysBirthdays() {
        //List<Event> todaysBirthdays = eventService.getEventsByCategory(EventCategory.BIRTHDAY.name());

        //if(!todaysBirthdays.isEmpty()) {
            // Založit Julince messenger účet a poslat mi zprávu o dnešních narozeninách
        //}
    }
}
