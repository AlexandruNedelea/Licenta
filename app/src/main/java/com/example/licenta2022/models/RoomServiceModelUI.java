package com.example.licenta2022.models;

import androidx.databinding.Bindable;

import com.example.licenta2022.BR;
import com.example.licenta2022.enums.ListItemGenericType;
import com.example.licenta2022.models.network.RoomServiceModel;

public class RoomServiceModelUI extends ListItemBaseModelUI {
    private int id;
    private String foodname;
    private int price;
    private String amount;
    //private String allergens;
    private String description;
    private int quantity;
    private boolean selected;

    public RoomServiceModelUI(int type, int id, String foodname, int price, String amount, String description) {
        super(type);
        this.id = id;
        this.foodname = foodname;
        this.price = price;
        this.amount = amount;
        //this.allergens = allergens;
        this.description = description;
    }

    public RoomServiceModelUI(RoomServiceModel serverModel) {
        super(ListItemGenericType.ITEM);
        this.id = serverModel.getId();
        this.foodname = serverModel.getFoodname();
        this.price = serverModel.getPrice();
        this.amount = serverModel.getAmount();
        //this.allergens = serverModel.getAllergens();
        this.description = serverModel.getDescription();
        this.quantity = serverModel.getQuantity();
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

   // public void setAllergens(String allergens) {this.allergens = allergens;}

    public String getDescription() {return description;}

    public void setDescription(String description) {this.description = description;}

    @Bindable
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
        notifyPropertyChanged(BR.quantity);
    }

    @Bindable
    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
        notifyPropertyChanged(BR.selected);
    }

    public void increaseQuantity() {
        quantity++;
        notifyPropertyChanged(BR.quantity);
    }

    public void decreaseQuantity() {
        if (quantity <= 0) {
            return;
        }
        quantity--;
        notifyPropertyChanged(BR.quantity);
    }
}
