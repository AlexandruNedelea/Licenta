package com.example.licenta2022.models.network;

import com.example.licenta2022.models.DealsTripsUI;

public class TripsModel {
    private int id;
    private String imageUrl;
    private String price;
    private String activityName;
    private String minimumAge;
    private String location;
    private String duration;
    private String description;





    public TripsModel(int id, String imageUrl, String price, String activityName, String minimumAge, String location, String duration, String description) {
        this.id = id;
        this.imageUrl = imageUrl;
        this.price = price;
        this.activityName = activityName;
        this.minimumAge = minimumAge;
        this.location = location;
        this.duration = duration;
        this.description = description;
    }

    public TripsModel() {
    }


    public TripsModel(DealsTripsUI tripsModelUI) {
        id = tripsModelUI.getId();
        imageUrl = tripsModelUI.getImageUrl();
        price = tripsModelUI.getPrice();
        activityName = tripsModelUI.getNameActivity();
        minimumAge = tripsModelUI.getAge();
        location = tripsModelUI.getLocation();
        duration = tripsModelUI.getDuration();
        description = tripsModelUI.getDescription();
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

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public String getMinimumAge() {
        return minimumAge;
    }

    public void setMinimumAge(String minimumAge) {
        this.minimumAge = minimumAge;
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
