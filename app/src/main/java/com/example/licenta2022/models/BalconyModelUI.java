package com.example.licenta2022.models;

public class BalconyModelUI {
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BalconyModelUI(int id, String name) {
        this.id = id;
        this.name = name;
    }
}