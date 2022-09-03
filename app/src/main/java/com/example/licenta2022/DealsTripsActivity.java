package com.example.licenta2022;

import android.os.Bundle;

import androidx.annotation.NonNull;

import com.example.licenta2022.ItemType.TripsActivityItemType;
import com.example.licenta2022.activities.BaseActivity;
import com.example.licenta2022.adapters.DealsTripsAdapter;
import com.example.licenta2022.databinding.ActivityDealsTripsBinding;
import com.example.licenta2022.helpers.DataConverterHelper;
import com.example.licenta2022.models.DealsTripsUI;
import com.example.licenta2022.models.network.TripsModel;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class DealsTripsActivity extends BaseActivity<ActivityDealsTripsBinding> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        dataBinding = ActivityDealsTripsBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        //sendTripToServer();
        setTripTypeFromIntent();
    }

    private void sendTripToServer() {
        var uiModel = new DealsTripsUI(100,"", "Price: Una Lira","Name:BOAT1","Age:70+","Where:Ghedu","Duration:3 hours","Description:Descrierea urmeaza sa o pun dar mai intai vreau sa ma asigur ca functioneaza cum trebuie");
        var modelToSendToServer = new TripsModel(uiModel);
        FirebaseHelper.getInstance().getTripsDatabaseReference()
                .child(TripsActivityItemType.SURF)
                .push()
                .setValue(modelToSendToServer)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {

                    }
                });
    }


    private void setTripTypeFromIntent() {
        var tripType = getIntent().getStringExtra(TripsActivity.TRIP_TYPE_ID);
        if (tripType == null || tripType.isEmpty()) {
            return;
        }
        getTripsByTripType(tripType);
    }

    private void getTripsByTripType(String tripType) {
        FirebaseHelper.getInstance().getTripsDatabaseReference().child(tripType).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                var tripsList = new ArrayList<TripsModel>();
                for (var dataSnapshot : snapshot.getChildren()){
                    var trip = dataSnapshot.getValue(TripsModel.class);
                    if(trip != null){
                        tripsList.add(trip);
                    }
                }
                var uiList= DataConverterHelper.getInstance().dealTripsUIFromServerModels(tripsList);
                setRecyclerView(uiList);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void setRecyclerView(List<DealsTripsUI> dealsTripsUIS) {
        DealsTripsAdapter dealsTripsAdapter = new DealsTripsAdapter(dealsTripsUIS, null);
        dataBinding.rvDealsTripsBoat.setAdapter(dealsTripsAdapter);
    }
}