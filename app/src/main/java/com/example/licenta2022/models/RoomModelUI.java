package com.example.licenta2022.models;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.example.licenta2022.BR;

public class RoomModelUI extends BaseObservable {
    private int id;
    private String name;
    private boolean selected;

    public RoomModelUI(int id, String name) {
        this.id = id;
        this.name = name;
    }

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

    @Bindable
    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
         notifyPropertyChanged(BR.selected);
    }
}
