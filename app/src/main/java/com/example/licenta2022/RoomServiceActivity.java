package com.example.licenta2022;

import android.os.Bundle;

import com.example.licenta2022.activities.BaseActivity;
import com.example.licenta2022.adapters.RoomServiceAdapter;
import com.example.licenta2022.databinding.ActivityRoomServiceBinding;
import com.example.licenta2022.enums.ListItemGenericType;
import com.example.licenta2022.models.ListHeaderModelUI;
import com.example.licenta2022.models.ListItemBaseModelUI;
import com.example.licenta2022.models.RoomServiceModelUI;

import java.util.ArrayList;

public class RoomServiceActivity extends BaseActivity<ActivityRoomServiceBinding> {
    private RoomServiceAdapter roomServiceAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        dataBinding = ActivityRoomServiceBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setRecyclerView();
    }

    private void setRecyclerView() {
        ArrayList<ListItemBaseModelUI> roomServiceModelUIArrayList = new ArrayList<>();
        roomServiceModelUIArrayList.add(new ListHeaderModelUI(ListItemGenericType.HEADER,"Primul titlu"));
        roomServiceModelUIArrayList.add(new RoomServiceModelUI(ListItemGenericType.ITEM,1,"fre",246,"50kg","aici sunt alergeni","Aici trebuie sa fie descriere"));
        roomServiceModelUIArrayList.add(new RoomServiceModelUI(ListItemGenericType.ITEM,2,"fre",246,"50kg","aici sunt alergeni","Aici trebuie sa fie descriere"));
        roomServiceModelUIArrayList.add(new RoomServiceModelUI(ListItemGenericType.ITEM,3,"fre",246,"50kg","aici sunt alergeni","Aici trebuie sa fie descriere"));
        roomServiceModelUIArrayList.add(new RoomServiceModelUI(ListItemGenericType.ITEM,4,"fre",246,"50kg","aici sunt alergeni","Aici trebuie sa fie descriere"));
        roomServiceModelUIArrayList.add(new RoomServiceModelUI(ListItemGenericType.ITEM,5,"fre",246,"50kg","aici sunt alergeni","Aici trebuie sa fie descriere"));
        roomServiceModelUIArrayList.add(new ListHeaderModelUI(ListItemGenericType.HEADER,"Primul titlu dupa primul titlu"));
        roomServiceModelUIArrayList.add(new RoomServiceModelUI(ListItemGenericType.ITEM,6,"fre",246,"50kg","aici sunt alergeni","Aici trebuie sa fie descriere"));
        roomServiceModelUIArrayList.add(new RoomServiceModelUI(ListItemGenericType.ITEM,7,"fre",246,"50kg","aici sunt alergeni","Aici trebuie sa fie descriere"));
        roomServiceModelUIArrayList.add(new RoomServiceModelUI(ListItemGenericType.ITEM,8,"fre",246,"50kg","aici sunt alergeni","Aici trebuie sa fie descriere"));
        roomServiceModelUIArrayList.add(new RoomServiceModelUI(ListItemGenericType.ITEM,9,"fre",246,"50kg","aici sunt alergeni","Aici trebuie sa fie descriere"));
        roomServiceModelUIArrayList.add(new RoomServiceModelUI(ListItemGenericType.ITEM,10,"fre",246,"50kg","aici sunt alergeni","Aici trebuie sa fie descriere"));
        roomServiceModelUIArrayList.add(new ListHeaderModelUI(ListItemGenericType.HEADER,"Primul titlu dupa primul titlu dupa primul titlu"));
        roomServiceModelUIArrayList.add(new RoomServiceModelUI(ListItemGenericType.ITEM,11,"fre",246,"50kg","aici sunt alergeni","Aici trebuie sa fie descriere"));
        roomServiceModelUIArrayList.add(new RoomServiceModelUI(ListItemGenericType.ITEM,12,"fre",246,"50kg","aici sunt alergeni","Aici trebuie sa fie descriere"));
        roomServiceModelUIArrayList.add(new RoomServiceModelUI(ListItemGenericType.ITEM,13,"fre",246,"50kg","aici sunt alergeni","Aici trebuie sa fie descriere"));
        roomServiceModelUIArrayList.add(new RoomServiceModelUI(ListItemGenericType.ITEM,14,"fre",246,"50kg","aici sunt alergeni","Aici trebuie sa fie descriere"));
        roomServiceModelUIArrayList.add(new RoomServiceModelUI(ListItemGenericType.ITEM,15,"fre",246,"50kg","aici sunt alergeni","Aici trebuie sa fie descriere"));
        roomServiceAdapter = new RoomServiceAdapter(roomServiceModelUIArrayList, new RoomServiceAdapter.RoomServiceClickListener() {
            @Override
            public void onMenuClick(ListItemBaseModelUI item) {

            }
        });
        dataBinding.rvRowRoom.setAdapter(roomServiceAdapter);
    }
}