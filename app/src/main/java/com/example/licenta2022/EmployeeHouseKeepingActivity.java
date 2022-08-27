package com.example.licenta2022;

import android.os.Bundle;

import androidx.annotation.NonNull;

import com.example.licenta2022.activities.BaseActivity;
import com.example.licenta2022.adapters.EmployeeHouseKeepingAdapter;
import com.example.licenta2022.databinding.ActivityEmployeeHouseKeepingBinding;
import com.example.licenta2022.models.network.HouseKeepingModel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Map;

public class EmployeeHouseKeepingActivity extends BaseActivity<ActivityEmployeeHouseKeepingBinding> {
    private ArrayList<String> roomNumbersList = new ArrayList<>();
    private ArrayList<HouseKeepingModel> houseKeepingModelArrayList = new ArrayList<>();
    private EmployeeHouseKeepingAdapter employeeHouseKeepingAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        dataBinding = ActivityEmployeeHouseKeepingBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);

        getDataFromServer();
        setRecyclerView();
    }

    private void setRecyclerView() {
        employeeHouseKeepingAdapter = new EmployeeHouseKeepingAdapter(new ArrayList<>(), new EmployeeHouseKeepingAdapter.EmployeeHouseKeepingClickListener() {
            @Override
            public void onMenuClick(HouseKeepingModel item) {
                onItemMenuClick(item);
            }
        });
        dataBinding.rvHotelMenu.setAdapter(employeeHouseKeepingAdapter);
    }

    private void onItemMenuClick(HouseKeepingModel item) {
    }

    private void getDataFromServer() {
        FirebaseHelper.getInstance().getHousekeepingDatabaseReference().addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()){
                    var genericTypeIndicator = new GenericTypeIndicator<Map<String, HouseKeepingModel>>() {};
                    var hashMap = dataSnapshot1.getValue(genericTypeIndicator);
                    getDataFromHashMap(hashMap);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
    }

    private void getDataFromHashMap(Map<String, HouseKeepingModel> hashMap) {
        for (var mapElement : hashMap.entrySet()) {
            String key = mapElement.getKey();
            var housekeeping = hashMap.get(key);
            employeeHouseKeepingAdapter.addItem(housekeeping);
        }
    }
}