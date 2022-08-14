package com.example.licenta2022.helpers;

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
        if (roomNumber == null) {
            return "423";
        }
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }
}
