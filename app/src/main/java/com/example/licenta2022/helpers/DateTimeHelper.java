package com.example.licenta2022.helpers;

import androidx.annotation.Nullable;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DateTimeHelper {
    private static DateTimeHelper instance = null;
    public static final String SERVER_DATE_TIME_FORMAT_FULL = "yyyy-MM-dd HH:mm";

    public static synchronized DateTimeHelper getInstance() {
        if (instance == null)
            instance = new DateTimeHelper();

        return instance;
    }

    public DateTimeHelper() {
    }

    public String getCurrentDateTimeInString() {
        LocalDateTime localDate = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(SERVER_DATE_TIME_FORMAT_FULL);
        return localDate.format(formatter);
    }

    public String timeToString(LocalTime time) {
        if (time == null) {
            return "";
        }
        return String.format(Locale.getDefault(), "%02d:%02d", time.getHour(), time.getMinute());
    }

    public @Nullable
    String toServerFormat(@Nullable LocalDate date, LocalTime time) {
        if (date == null) {
            return null;
        }
        if (time == null) {
            time = LocalTime.MIN;
        }

        var localDateTime = LocalDateTime.of(date, time);
        var dateTimeFormatter = DateTimeFormatter.ofPattern(SERVER_DATE_TIME_FORMAT_FULL);
        return dateTimeFormatter.format(localDateTime);
    }
}
