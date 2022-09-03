package com.example.licenta2022.models.network;

import com.example.licenta2022.models.RoomServiceModelUI;

public class RoomServiceModel {
    private int id;
    private String foodname;
    private int price;
    private String amount;
   // private String allergens;
    private String description;
    private int quantity;

    public RoomServiceModel() {
    }

    public RoomServiceModel(RoomServiceModelUI uiModel) {
        this.id = uiModel.getId();
        this.foodname = uiModel.getFoodname();
        this.price = uiModel.getPrice();
        this.amount = uiModel.getAmount();
        //this.allergens = uiModel.getAllergens();
        this.description = uiModel.getDescription();
        this.quantity = uiModel.getQuantity();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFoodname() {
        return foodname;
    }

    public void setFoodname(String foodname) {
        this.foodname = foodname;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    //public String getAllergens() {return allergens;}

    //public void setAllergens(String allergens) {this.allergens = allergens;}

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
