package com.example.licenta2022;


import android.content.Intent;
import android.os.Bundle;

import androidx.recyclerview.widget.GridLayoutManager;

import com.example.licenta2022.ItemType.HotelItemType;
import com.example.licenta2022.activities.BaseActivity;
import com.example.licenta2022.adapters.HotelMenuAdapter;
import com.example.licenta2022.databinding.ActivityEmployeeBinding;
import com.example.licenta2022.models.HotelMenuModelUI;

import java.util.ArrayList;

public class EmployeeActivity extends BaseActivity<ActivityEmployeeBinding> {
    public static String TEST_INTENT = "intent_key";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        dataBinding= ActivityEmployeeBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setRecyclerView();
    }

    private void setRecyclerView() {
        ArrayList<HotelMenuModelUI> hotelMenuModelUIArrayList = new ArrayList<>();
        hotelMenuModelUIArrayList.add(new HotelMenuModelUI(1, "Room"));
        hotelMenuModelUIArrayList.add(new HotelMenuModelUI(2, "Room Service"));
        hotelMenuModelUIArrayList.add(new HotelMenuModelUI(3, "Maid"));

        HotelMenuAdapter hotelMenuAdapter= new HotelMenuAdapter(hotelMenuModelUIArrayList, new HotelMenuAdapter.HotelMenuClickListener() {
            @Override
            public void onMenuClick(HotelMenuModelUI item) {
                onItemMenuClick(item);
            }
        });
        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
        dataBinding.rvHotelMenu.setLayoutManager(layoutManager);
        dataBinding.rvHotelMenu.setAdapter(hotelMenuAdapter);
    }

    private void onItemMenuClick(HotelMenuModelUI item) {
        switch (item.getId()) {
            case HotelItemType.ROOM:
                onEmployeeMenuRoomClick();
                break;
            case HotelItemType.ROOM_SERVICE:
                onEmployeeMenuRoomServiceClick();
                break;
            case HotelItemType.MENAGERIE:
                onEmployeeMaidClicked(item);
                break;
            default:
                break;

        }
    }

    private void onEmployeeMaidClicked(HotelMenuModelUI item) {startActivity(new Intent(this, EmployeeHouseKeepingActivity.class));}

    private void onEmployeeMenuRoomServiceClick() {startActivity(new Intent(this, EmployeeRoomServiceActivity.class));}

    private void onEmployeeMenuRoomClick() {startActivity(new Intent(this, EmployeeRoomProblemsActivity.class));}
}