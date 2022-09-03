package com.example.licenta2022.models;

import com.example.licenta2022.models.network.TripsModel;

public class DealsTripsUI {
    private int id;
    private String imageUrl;
    private String price;
    private String nameActivity;
    private String age;
    private String location;
    private String duration;
    private String description;

    public DealsTripsUI(int id, String imageUrl, String price, String nameActivity, String age, String location, String duration, String description) {
        this.id = id;
        this.imageUrl = imageUrl;
        this.price = price;
        this.nameActivity = nameActivity;
        this.age = age;
        this.location = location;
        this.duration = duration;
        this.description = description;

    }



    public DealsTripsUI() {
    }

    public DealsTripsUI(TripsModel serverModel) {
        id = serverModel.getId();
        imageUrl = serverModel.getImageUrl();
        price = serverModel.getPrice();
        nameActivity = serverModel.getActivityName();
        age = serverModel.getMinimumAge();
        location = serverModel.getLocation();
        duration = serverModel.getDuration();
        description = serverModel.getDescription();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
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


}
