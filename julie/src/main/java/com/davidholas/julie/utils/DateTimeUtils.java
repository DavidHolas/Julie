package com.davidholas.julie.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeUtils {

    private static DateTimeFormatter dateformatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    private static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:MM:SS");

    public static LocalDate dateFromString(String date) {
        return LocalDate.parse(date, dateformatter);
    }

    public static LocalDateTime dateTimeFromString(String datetime) {
        return LocalDateTime.parse(datetime, dateTimeFormatter);
    }
}
