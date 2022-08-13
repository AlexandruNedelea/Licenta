package com.example.licenta2022;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import android.os.Bundle;

import com.example.licenta2022.ItemType.BalconyItemType;
import com.example.licenta2022.ItemType.HotelItemType;
import com.example.licenta2022.activities.BaseActivity;
import com.example.licenta2022.adapters.BalconyAdapter;
import com.example.licenta2022.adapters.HotelMenuAdapter;
import com.example.licenta2022.databinding.ActivityBalconyBinding;
import com.example.licenta2022.models.BalconyModelUI;
import com.example.licenta2022.models.HotelMenuModelUI;

import java.util.ArrayList;

public class BalconyActivity extends BaseActivity<ActivityBalconyBinding> {
    public static String TEST_INTENT = "intent_key";
    private BalconyAdapter balconyAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        dataBinding = ActivityBalconyBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setRecyclerView();
    }

    private void setRecyclerView() {
        ArrayList<BalconyModelUI> balconyModelUIArrayList = new ArrayList<>();
        balconyModelUIArrayList.add(new BalconyModelUI(BalconyItemType.ENTRY_1,"nume1"));
        balconyModelUIArrayList.add(new BalconyModelUI(BalconyItemType.ENTRY_2,"nume2"));
        balconyModelUIArrayList.add(new BalconyModelUI(BalconyItemType.ENTRY_3,"nume3"));
        balconyModelUIArrayList.add(new BalconyModelUI(BalconyItemType.ENTRY_4,"nume4"));
        balconyModelUIArrayList.add(new BalconyModelUI(BalconyItemType.ENTRY_5,"nume5"));
        balconyModelUIArrayList.add(new BalconyModelUI(BalconyItemType.ENTRY_6,"nume6"));
        balconyModelUIArrayList.add(new BalconyModelUI(BalconyItemType.ENTRY_7,"nume7"));
        balconyModelUIArrayList.add(new BalconyModelUI(BalconyItemType.ENTRY_8,"nume8"));
        balconyModelUIArrayList.add(new BalconyModelUI(BalconyItemType.ENTRY_9,"nume9"));

        balconyAdapter = new BalconyAdapter(balconyModelUIArrayList, new BalconyAdapter.BalconyMenuClickListener() {
            @Override
            public void onMenuClick(BalconyModelUI item) {
                onItemMenuClick(item);
            }
        });
        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
        dataBinding.rvRowBalcony.setLayoutManager(layoutManager);
        dataBinding.rvRowBalcony.setAdapter(balconyAdapter);
    }

    private void onItemMenuClick(BalconyModelUI item) {
        switch (item.getId()) {
            case BalconyItemType.ENTRY_1:
                //onEntryOneClick(item);
                break;
            case BalconyItemType.ENTRY_2:
                break;
            case BalconyItemType.ENTRY_3:
                break;
            case BalconyItemType.ENTRY_4:
                break;
            case BalconyItemType.ENTRY_5:
                break;
            case BalconyItemType.ENTRY_6:
                break;
            case BalconyItemType.ENTRY_7:
                break;
            case BalconyItemType.ENTRY_8:
                break;
            case BalconyItemType.ENTRY_9:
                break;

            default:
                break;

        }
    }
}
