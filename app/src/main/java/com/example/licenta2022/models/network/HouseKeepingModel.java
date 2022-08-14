package com.example.licenta2022.models.network;

public class HouseKeepingModel {
    private String roomNumber;
    private String cleaningDate;

    public HouseKeepingModel(String roomNumber, String cleaningDate) {
        this.roomNumber = roomNumber;
        this.cleaningDate = cleaningDate;
    }

    public HouseKeepingModel() {
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getCleaningDate() {
        return cleaningDate;
    }

    public void setCleaningDate(String cleaningDate) {
        this.cleaningDate = cleaningDate;
    }
}
