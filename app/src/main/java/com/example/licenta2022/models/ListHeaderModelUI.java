package com.example.licenta2022.models;

public class ListHeaderModelUI extends ListItemBaseModelUI {
    private String title;

    public ListHeaderModelUI(int type, String title) {
        super(type);
        this.title = title;
    }

    public ListHeaderModelUI(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
