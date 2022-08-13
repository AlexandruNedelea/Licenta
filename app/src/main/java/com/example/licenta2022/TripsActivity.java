package com.example.licenta2022;

import androidx.recyclerview.widget.GridLayoutManager;

import android.content.Intent;
import android.os.Bundle;

import com.example.licenta2022.ItemType.TripsActivityItemType;
import com.example.licenta2022.activities.BaseActivity;
import com.example.licenta2022.adapters.TripsMenuAdapter;
import com.example.licenta2022.databinding.ActivityTripsBinding;
import com.example.licenta2022.models.TripsModelUI;

import java.util.ArrayList;

public class TripsActivity extends BaseActivity<ActivityTripsBinding> {
    public static String TEST_INTENT = "intent_key";
    private TripsMenuAdapter tripsMenuAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        dataBinding = ActivityTripsBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setRecyclerView();

    }


    private void setRecyclerView() {
        ArrayList<TripsModelUI> tripsMenuModelUIArrayList = new ArrayList<>();
        tripsMenuModelUIArrayList.add(new TripsModelUI(TripsActivityItemType.PARAPANTA, "Parapanta"));
        tripsMenuModelUIArrayList.add(new TripsModelUI(TripsActivityItemType.SCUBADIVING, "Scubadiving"));
        tripsMenuModelUIArrayList.add(new TripsModelUI(TripsActivityItemType.SURF, "Surf"));
        tripsMenuModelUIArrayList.add(new TripsModelUI(TripsActivityItemType.BOAT, "Boat"));

        tripsMenuAdapter = new TripsMenuAdapter(tripsMenuModelUIArrayList, new TripsMenuAdapter.TripsMenuClickListener() {
            @Override
            public void onMenuClick(TripsModelUI item) {
                onItemMenuClick(item);
            }
        });
        GridLayoutManager layoutManager = new GridLayoutManager(this,2);
        dataBinding.rvTripsMenu.setLayoutManager(layoutManager);
        dataBinding.rvTripsMenu.setAdapter(tripsMenuAdapter);
    }

    private void onItemMenuClick(TripsModelUI item) {
        onDealsTripsParapantaClick(item.getId());

//        switch (item.getId()) {
//            case TripsActivityItemType.PARAPANTA:
//                onDealsTripsParapantaClick();
//                break;
//            case TripsActivityItemType.SCUBADIVING:
//                onDealsTripsScubadivingClick();
//                break;
//            case TripsActivityItemType.SURF:
//                onDealsTripsSurfClick();
//                break;
//            case TripsActivityItemType.BOAT:
//                onDealsTripsBoatClick();
//                break;
//            default:
//                break;
//
//        }
    }

    private void onDealsTripsParapantaClick(int id) {
        Intent intent= new Intent(this, DealsTripsActivity.class);
        intent.putExtra(TEST_INTENT, id);
        startActivity(intent);
    }

}
