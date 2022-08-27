package com.example.licenta2022;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.licenta2022.activities.BaseActivity;
import com.example.licenta2022.adapters.RoomServiceAdapter;
import com.example.licenta2022.databinding.ActivityRoomServiceBinding;
import com.example.licenta2022.enums.ListItemGenericType;
import com.example.licenta2022.helpers.DataStorageHelper;
import com.example.licenta2022.helpers.DateTimeHelper;
import com.example.licenta2022.models.ListHeaderModelUI;
import com.example.licenta2022.models.ListItemBaseModelUI;
import com.example.licenta2022.models.RoomServiceModelUI;
import com.example.licenta2022.models.network.HouseKeepingModel;
import com.example.licenta2022.models.network.RoomServiceModel;
import com.google.android.gms.tasks.OnSuccessListener;

import java.util.ArrayList;

public class RoomServiceActivity extends BaseActivity<ActivityRoomServiceBinding> {
    private final ArrayList<ListItemBaseModelUI> roomServiceModelUIArrayList = new ArrayList<>();

    private int orderedItemsSentToServer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        dataBinding = ActivityRoomServiceBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);

        setRecyclerView();
        setListeners();
    }

    private void setListeners() {
        dataBinding.btnRoomServiceOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getOrderedItems();
            }
        });
    }

    private void getOrderedItems() {
        var orderedItems = new ArrayList<RoomServiceModel>();
        for (var menuItem : roomServiceModelUIArrayList) {
            if (menuItem instanceof RoomServiceModelUI) {
                if (((RoomServiceModelUI) menuItem).getQuantity() > 0) {
                    orderedItems.add(new RoomServiceModel((RoomServiceModelUI)menuItem));
                }
            }
        }
        if (orderedItems.size() > 1) {
            sendOrdersToServer(orderedItems);
        }
    }

    private void sendOrdersToServer(ArrayList<RoomServiceModel> orderedItems) {
        var currentDateTime = DateTimeHelper.getInstance().getCurrentDateTimeInString();
        for (var item : orderedItems) {
            sendIndividualOrderToServer(item, orderedItems.size(), currentDateTime);
        }
    }

    private void sendIndividualOrderToServer(RoomServiceModel item, int size, String currentDateTime) {
        FirebaseHelper.getInstance().getRoomServiceDatabaseReference()
                .child(DataStorageHelper.getInstance().getRoomNumber())
                .child(currentDateTime)
                .push()
                .setValue(item)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        checkIfAllProblemsSent(size);
                    }
                });
    }

    private void checkIfAllProblemsSent(int totalProblems) {
        if (++orderedItemsSentToServer == totalProblems) {
            Toast.makeText(this, "Order completed", Toast.LENGTH_SHORT).show();
            finish();
        }
    }

    private void setRecyclerView() {
        roomServiceModelUIArrayList.add(new ListHeaderModelUI(ListItemGenericType.HEADER,"Mic dejun"));
        roomServiceModelUIArrayList.add(new RoomServiceModelUI(ListItemGenericType.ITEM,1,"fre",246,"50kg","aici sunt alergeni","Aici trebuie sa fie descriere"));
        roomServiceModelUIArrayList.add(new RoomServiceModelUI(ListItemGenericType.ITEM,2,"fre",246,"50kg","aici sunt alergeni","Aici trebuie sa fie descriere"));
        roomServiceModelUIArrayList.add(new RoomServiceModelUI(ListItemGenericType.ITEM,3,"fre",246,"50kg","aici sunt alergeni","Aici trebuie sa fie descriere"));
        roomServiceModelUIArrayList.add(new RoomServiceModelUI(ListItemGenericType.ITEM,4,"fre",246,"50kg","aici sunt alergeni","Aici trebuie sa fie descriere"));
        roomServiceModelUIArrayList.add(new RoomServiceModelUI(ListItemGenericType.ITEM,5,"fre",246,"50kg","aici sunt alergeni","Aici trebuie sa fie descriere"));
        roomServiceModelUIArrayList.add(new ListHeaderModelUI(ListItemGenericType.HEADER,"Pranz"));
        roomServiceModelUIArrayList.add(new RoomServiceModelUI(ListItemGenericType.ITEM,6,"fre",246,"50kg","aici sunt alergeni","Aici trebuie sa fie descriere"));
        roomServiceModelUIArrayList.add(new RoomServiceModelUI(ListItemGenericType.ITEM,7,"fre",246,"50kg","aici sunt alergeni","Aici trebuie sa fie descriere"));
        roomServiceModelUIArrayList.add(new RoomServiceModelUI(ListItemGenericType.ITEM,8,"fre",246,"50kg","aici sunt alergeni","Aici trebuie sa fie descriere"));
        roomServiceModelUIArrayList.add(new RoomServiceModelUI(ListItemGenericType.ITEM,9,"fre",246,"50kg","aici sunt alergeni","Aici trebuie sa fie descriere"));
        roomServiceModelUIArrayList.add(new RoomServiceModelUI(ListItemGenericType.ITEM,10,"fre",246,"50kg","aici sunt alergeni","Aici trebuie sa fie descriere"));
        roomServiceModelUIArrayList.add(new ListHeaderModelUI(ListItemGenericType.HEADER,"Cina"));
        roomServiceModelUIArrayList.add(new RoomServiceModelUI(ListItemGenericType.ITEM,11,"fre",246,"50kg","aici sunt alergeni","Aici trebuie sa fie descriere"));
        roomServiceModelUIArrayList.add(new RoomServiceModelUI(ListItemGenericType.ITEM,12,"fre",246,"50kg","aici sunt alergeni","Aici trebuie sa fie descriere"));
        roomServiceModelUIArrayList.add(new RoomServiceModelUI(ListItemGenericType.ITEM,13,"fre",246,"50kg","aici sunt alergeni","Aici trebuie sa fie descriere"));
        roomServiceModelUIArrayList.add(new RoomServiceModelUI(ListItemGenericType.ITEM,14,"fre",246,"50kg","aici sunt alergeni","Aici trebuie sa fie descriere"));
        roomServiceModelUIArrayList.add(new RoomServiceModelUI(ListItemGenericType.ITEM,15,"fre",246,"50kg","aici sunt alergeni","Aici trebuie sa fie descriere"));
        var roomServiceAdapter = new RoomServiceAdapter(roomServiceModelUIArrayList, new RoomServiceAdapter.RoomServiceClickListener() {
            @Override
            public void onMenuClick(ListItemBaseModelUI item) {
                if (item instanceof RoomServiceModelUI) {
                    ((RoomServiceModelUI) item).setSelected(!((RoomServiceModelUI) item).isSelected());
                }
            }
        });
        dataBinding.rvRowRoom.setAdapter(roomServiceAdapter);
    }
}