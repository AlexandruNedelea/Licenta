package com.example.licenta2022.models;

public class DealsTripsUI {
    private int id;
    private String price;
    private String nameActivity;
    private String age;
    private String placeToGo;
    private String duration;
    private String description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getNameActivity() {
        return nameActivity;
    }

    public void setNameActivity(String nameActivity) {
        this.nameActivity = nameActivity;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getPlaceToGo() {
        return placeToGo;
    }

    public void setPlaceToGo(String placeToGo) {
        this.placeToGo = placeToGo;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public DealsTripsUI(int id, String price, String nameActivity, String age, String placeToGo, String duration, String description) {
        this.id = id;
        this.price = price;
        this.nameActivity = nameActivity;
        this.age = age;
        this.placeToGo = placeToGo;
        this.duration = duration;
        this.description = description;
    }
}
