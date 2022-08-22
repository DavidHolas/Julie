package com.davidholas.julie.service;

public interface CronService {

    void createDailyTasks();

    void failUncompleteDailyTasks();

    void checkTodaysEvents();

    void checkTodaysBirthdays();
}
