package com.example.licenta2022;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.licenta2022.ItemType.BalconyItemType;
import com.example.licenta2022.activities.BaseActivity;
import com.example.licenta2022.adapters.RoomAdapter;
import com.example.licenta2022.databinding.ActivityRoomBinding;
import com.example.licenta2022.models.Network.RoomDetails;
import com.example.licenta2022.models.RoomModelUI;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.UUID;

public class RoomActivity extends BaseActivity<ActivityRoomBinding> {
    public static String TEST_INTENT = "intent_key";
    private RoomAdapter roomAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        dataBinding = ActivityRoomBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);

        setRecyclerView();
        setListeners();
        getDataFromServer();
    }

    private void setRecyclerView() {
        ArrayList<RoomModelUI> roomModelUIArrayList = new ArrayList<>();
        roomModelUIArrayList.add(new RoomModelUI(1,"Pat",));
        roomModelUIArrayList.add(new RoomModelUI(2,"Saltea"));
        roomModelUIArrayList.add(new RoomModelUI(3,"Televizor"));
        roomModelUIArrayList.add(new RoomModelUI(4,"Aer conditionat"));
        roomModelUIArrayList.add(new RoomModelUI(5,"Masa"));
        roomModelUIArrayList.add(new RoomModelUI(6,"Lenjerie pat"));
        roomModelUIArrayList.add(new RoomModelUI(7,"Cada/Cabina dus"));
        roomModelUIArrayList.add(new RoomModelUI(8,"Usi defecte"));
        roomModelUIArrayList.add(new RoomModelUI(9,"Minibar"));
        roomAdapter = new RoomAdapter(roomModelUIArrayList, new RoomAdapter.RoomMenuClickListener() {
            @Override
            public void onMenuClick(RoomModelUI item) {
                onItemMenuClick(item);
            }
        });
        dataBinding.rvRowRoom.setAdapter(roomAdapter);

    }
    private void onItemMenuClick(RoomModelUI item) {
        item.setSelected(!item.isSelected());
    }

    private void setListeners() {
        dataBinding.btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onSendRoomToServer();
            }
        });

        dataBinding.btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                removeDataFromServer();
            }
        });
    }

    private void removeDataFromServer(){
        FirebaseHelper.getInstance().getRoomDatabaseReference().child("a39124d1-1001-4cfd-b4ef-96bac9523761").removeValue();

    }
    private void onSendRoomToServer() {
        String uuid = UUID.randomUUID().toString();
        RoomDetails roomDetails = new RoomDetails(uuid, "Test room");
        FirebaseHelper.getInstance().getRoomDatabaseReference().child(uuid).setValue(roomDetails).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {
                Toast.makeText(RoomActivity.this, "Adaugare cu succes", Toast.LENGTH_SHORT).show();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(RoomActivity.this, "Adaugare nu prea cu succes", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getDataFromServer() {
        FirebaseHelper.getInstance().getRoomDatabaseReference().addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                ArrayList<RoomDetails> roomDetailsArrayList = new ArrayList<>();
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()){
                    RoomDetails room = dataSnapshot1.getValue(RoomDetails.class);
                    if(room != null){
                        roomDetailsArrayList.add(room);
                    }
                }
                int a =0;
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}

