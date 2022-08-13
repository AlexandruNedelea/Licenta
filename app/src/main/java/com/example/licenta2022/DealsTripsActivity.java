package com.example.licenta2022;

import android.content.Intent;
import android.os.Bundle;

import com.example.licenta2022.ItemType.TripsActivityItemType;
import com.example.licenta2022.activities.BaseActivity;
import com.example.licenta2022.adapters.DealsTripsAdapter;
import com.example.licenta2022.databinding.ActivityDealsTripsBinding;
import com.example.licenta2022.models.DealsTripsUI;

import java.util.ArrayList;

public class DealsTripsActivity extends BaseActivity<ActivityDealsTripsBinding> {
    public static String TEST_INTENT = "intent_key";
    private DealsTripsAdapter dealsTripsAdapter;
    private int selectedCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        dataBinding = ActivityDealsTripsBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        selectedCategory = getIntent().getIntExtra(TripsActivity.TEST_INTENT, 0);
        setRecyclerView();
    }

    private void setRecyclerView() {
        ArrayList<DealsTripsUI> listToDisplay = setMenuItems(selectedCategory);
        dealsTripsAdapter = new DealsTripsAdapter(listToDisplay, new DealsTripsAdapter.DealsTripsClickListener() {
            @Override
            public void onMenuClick(DealsTripsUI item) { }
        });
        dataBinding.rvDealsTripsBoat.setAdapter(dealsTripsAdapter);
    }

    private ArrayList<DealsTripsUI> setMenuItems(int id) {
        switch(id) {
            case TripsActivityItemType.PARAPANTA:
                return showListParapanta();
            case TripsActivityItemType.SCUBADIVING:
                showListScubadiving();
            case TripsActivityItemType.SURF:
                return showListSurf();
            case TripsActivityItemType.BOAT:
                showListBoat();
            default:
                return showListParapanta();

        }
    }

    private ArrayList<DealsTripsUI> showListSurf() {
        ArrayList<DealsTripsUI> dealsTripsUIArrayList = new ArrayList<>();
        dealsTripsUIArrayList.add(new DealsTripsUI(7,"Price: Una Lira","Name:SURF1","Age:70+","Where:Ghedu","Duration:3 hours","Description:Descrierea urmeaza sa o pun dar mai intai vreau sa ma asigur ca functioneaza cum trebuie"));
        dealsTripsUIArrayList.add(new DealsTripsUI(8,"Price: Una Lira","Name:SURF2","Age:70+","Where:Ghedu","Duration:3 hours","Description:Descrierea urmeaza sa o pun dar mai intai vreau sa ma asigur ca functioneaza cum trebuie"));
        dealsTripsUIArrayList.add(new DealsTripsUI(9,"Price: Una Lira","Name:SURF3","Age:70+","Where:Ghedu","Duration:3 hours","Description:Descrierea urmeaza sa o pun dar mai intai vreau sa ma asigur ca functioneaza cum trebuie"));
        return dealsTripsUIArrayList;
    }

    private ArrayList<DealsTripsUI> showListScubadiving() {
        ArrayList<DealsTripsUI> dealsTripsUIArrayList = new ArrayList<>();
        dealsTripsUIArrayList.add(new DealsTripsUI(4,"Price: Una Lira","Name:SCUBA1","Age:70+","Where:Ghedu","Duration:3 hours","Description:Descrierea urmeaza sa o pun dar mai intai vreau sa ma asigur ca functioneaza cum trebuie"));
        dealsTripsUIArrayList.add(new DealsTripsUI(5,"Price: Una Lira","Name:SCUBA2","Age:70+","Where:Ghedu","Duration:3 hours","Description:Descrierea urmeaza sa o pun dar mai intai vreau sa ma asigur ca functioneaza cum trebuie"));
        dealsTripsUIArrayList.add(new DealsTripsUI(6,"Price: Una Lira","Name:SCUBA3","Age:70+","Where:Ghedu","Duration:3 hours","Description:Descrierea urmeaza sa o pun dar mai intai vreau sa ma asigur ca functioneaza cum trebuie"));
    return dealsTripsUIArrayList;
    }

    private ArrayList<DealsTripsUI> showListParapanta() {
        ArrayList<DealsTripsUI> dealsTripsUIArrayList = new ArrayList<>();
        dealsTripsUIArrayList.add(new DealsTripsUI(1,"Price: Una Lira","Name:PARAPANTA1","Age:70+","Where:Ghedu","Duration:3 hours","Description:Descrierea urmeaza sa o pun dar mai intai vreau sa ma asigur ca functioneaza cum trebuie"));
        dealsTripsUIArrayList.add(new DealsTripsUI(2,"Price: Una Lira","Name:PARAPANTA2","Age:70+","Where:Ghedu","Duration:3 hours","Description:Descrierea urmeaza sa o pun dar mai intai vreau sa ma asigur ca functioneaza cum trebuie"));
        dealsTripsUIArrayList.add(new DealsTripsUI(3,"Price: Una Lira","Name:PARAPANTA3","Age:70+","Where:Ghedu","Duration:3 hours","Description:Descrierea urmeaza sa o pun dar mai intai vreau sa ma asigur ca functioneaza cum trebuie"));
        return dealsTripsUIArrayList;
    }

    private ArrayList<DealsTripsUI> showListBoat() {
        ArrayList<DealsTripsUI> dealsTripsUIArrayList = new ArrayList<>();
        dealsTripsUIArrayList.add(new DealsTripsUI(10,"Price: Una Lira","Name:BOAT1","Age:70+","Where:Ghedu","Duration:3 hours","Description:Descrierea urmeaza sa o pun dar mai intai vreau sa ma asigur ca functioneaza cum trebuie"));
        dealsTripsUIArrayList.add(new DealsTripsUI(11,"Price: Una Lira","Name:BOAT2","Age:70+","Where:Ghedu","Duration:3 hours","Description:Descrierea urmeaza sa o pun dar mai intai vreau sa ma asigur ca functioneaza cum trebuie"));
        dealsTripsUIArrayList.add(new DealsTripsUI(12,"Price: Una Lira","Name:BOAT3","Age:70+","Where:Ghedu","Duration:3 hours","Description:Descrierea urmeaza sa o pun dar mai intai vreau sa ma asigur ca functioneaza cum trebuie"));
        return dealsTripsUIArrayList;
    }

}