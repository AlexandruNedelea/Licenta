package com.example.licenta2022.models.Network;

public class RoomDetails {
    private String id;
    private String name;

    public RoomDetails() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public RoomDetails(String id, String name) {
        this.id = id;
        this.name = name;
    }
}
