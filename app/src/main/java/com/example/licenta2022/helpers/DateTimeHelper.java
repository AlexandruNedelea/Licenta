package com.example.licenta2022.helpers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeHelper {
    private static DateTimeHelper instance = null;

    public static synchronized DateTimeHelper getInstance() {
        if (instance == null)
            instance = new DateTimeHelper();

        return instance;
    }

    public DateTimeHelper() {
    }

    public String getCurrentDateTimeInString() {
        LocalDateTime localDate = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return localDate.format(formatter);
    }
}
