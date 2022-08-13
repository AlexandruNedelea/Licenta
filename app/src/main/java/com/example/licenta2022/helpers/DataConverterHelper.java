package com.example.licenta2022.helpers;

import com.example.licenta2022.models.Network.RoomProblemsModel;
import com.example.licenta2022.models.RoomModelUI;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DataConverterHelper {
    private static DataConverterHelper instance = null;
    private String roomNumber;

    public static synchronized DataConverterHelper getInstance() {
        if (instance == null)
            instance = new DataConverterHelper();

        return instance;
    }

    public DataConverterHelper() {
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public RoomProblemsModel roomProblemsModelsFromUIModel(RoomModelUI problemModel) {
        var serverModel = new RoomProblemsModel();
        serverModel.setId(String.valueOf(problemModel.getId()));
        serverModel.setName(problemModel.getName());
        serverModel.setDate(DateTimeHelper.getInstance().getCurrentDateTimeInString());
        return serverModel;
    }
}