package com.example.licenta2022.models;

import androidx.databinding.BaseObservable;

public class ListItemBaseModelUI extends BaseObservable {
    private int type;

    public ListItemBaseModelUI() {
    }

    public ListItemBaseModelUI(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
