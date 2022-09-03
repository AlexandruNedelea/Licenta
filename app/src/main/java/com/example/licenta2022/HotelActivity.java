package com.example.licenta2022;

import android.content.Intent;
import android.os.Bundle;

import androidx.recyclerview.widget.GridLayoutManager;

import com.example.licenta2022.ItemType.HotelItemType;
import com.example.licenta2022.activities.BaseActivity;
import com.example.licenta2022.adapters.HotelMenuAdapter;
import com.example.licenta2022.databinding.ActivityHotelBinding;
import com.example.licenta2022.dialogs.ChooseHousekeepingDialog;
import com.example.licenta2022.models.HotelMenuModelUI;

import java.util.ArrayList;

public class HotelActivity extends BaseActivity<ActivityHotelBinding> {
    public static String TEST_INTENT = "intent_key";
    private HotelMenuAdapter hotelMenuAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        dataBinding = ActivityHotelBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setRecyclerView();
    }

    private void setRecyclerView() {
        ArrayList<HotelMenuModelUI> hotelMenuModelUIArrayList = new ArrayList<>();
        hotelMenuModelUIArrayList.add(new HotelMenuModelUI(1, "Room"));
        hotelMenuModelUIArrayList.add(new HotelMenuModelUI(2, "Room Service"));
        hotelMenuModelUIArrayList.add(new HotelMenuModelUI(3, "Cleaning Staff"));
        hotelMenuModelUIArrayList.add(new HotelMenuModelUI(4, "Trips"));

        hotelMenuAdapter = new HotelMenuAdapter(hotelMenuModelUIArrayList, new HotelMenuAdapter.HotelMenuClickListener() {
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
                onMenuRoomClick();
                break;
//            case HotelItemType.BALCONY:
//                onMenuBalconyClick();
//                break;
//            case HotelItemType.BATH:
//                break;
            case HotelItemType.ROOM_SERVICE:
                onMenuRoomServiceClick();
                break;
            case HotelItemType.MENAGERIE:
                onMaidClicked(item);
                break;
            case HotelItemType.TRIPS:
                onMenuTripsClick(item);
                break;
            default:
                break;

        }
    }

    private void onMaidClicked(HotelMenuModelUI item) {
        var dialog = ChooseHousekeepingDialog.newInstance();
        dialog.show(getSupportFragmentManager(), "housekeepingDialog");
    }

    private void onMenuRoomServiceClick() {
        startActivity(new Intent(this, RoomServiceActivity.class));
    }

    private void onMenuRoomClick() { startActivity(new Intent(this, RoomActivity.class)); }

//    private void onMenuBalconyClick() { startActivity(new Intent(this, BalconyActivity.class)); }

    private void onMenuTripsClick(HotelMenuModelUI item) { startActivity(new Intent(this, TripsActivity.class)); }
}
