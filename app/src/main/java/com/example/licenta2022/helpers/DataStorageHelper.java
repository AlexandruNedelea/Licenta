package com.example.licenta2022.helpers;

import android.content.Context;
import android.util.DisplayMetrics;

public class DataStorageHelper {
    private static DataStorageHelper instance = null;
    private String roomNumber;

    public static synchronized DataStorageHelper getInstance() {
        if (instance == null)
            instance = new DataStorageHelper();

        return instance;
    }

    public DataStorageHelper() {
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }
}
