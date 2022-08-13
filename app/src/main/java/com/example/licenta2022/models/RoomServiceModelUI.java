package com.example.licenta2022.models;

public class RoomServiceModelUI extends ListItemBaseModelUI{
    private int id;
    private String foodname;
    private int price;
    private String amount;
    private String allergens;
    private String description;

    public RoomServiceModelUI(int type, int id, String foodname, int price, String amount, String allergens, String description) {
        super(type);
        this.id = id;
        this.foodname = foodname;
        this.price = price;
        this.amount = amount;
        this.allergens = allergens;
        this.description = description;
    }

    public RoomServiceModelUI(int id, String foodname, int price, String amount, String allergens, String description) {
        this.id = id;
        this.foodname = foodname;
        this.price = price;
        this.amount = amount;
        this.allergens = allergens;
        this.description = description;
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

    public String getAllergens() {
        return allergens;
    }

    public void setAllergens(String allergens) {
        this.allergens = allergens;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
