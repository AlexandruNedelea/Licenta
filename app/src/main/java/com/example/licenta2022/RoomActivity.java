package com.example.licenta2022;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.licenta2022.activities.BaseActivity;
import com.example.licenta2022.adapters.RoomAdapter;
import com.example.licenta2022.databinding.ActivityRoomBinding;
import com.example.licenta2022.helpers.DataConverterHelper;
import com.example.licenta2022.helpers.DataStorageHelper;
import com.example.licenta2022.models.network.RoomProblemsModel;
import com.example.licenta2022.models.RoomModelUI;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class RoomActivity extends BaseActivity<ActivityRoomBinding> {
    public static String TEST_INTENT = "intent_key";
    private final ArrayList<RoomModelUI> roomProblemsListUI = new ArrayList<>();
    private int problemsSentToServer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        dataBinding = ActivityRoomBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);

        setRecyclerView();
        setListeners();
        getDataFromServer();
    }

    private void setRecyclerView() {
        roomProblemsListUI.add(new RoomModelUI(1,"Mattress problems"));
        roomProblemsListUI.add(new RoomModelUI(2,"TV is not working"));
        roomProblemsListUI.add(new RoomModelUI(3,"Air conditioning is damaged"));
        roomProblemsListUI.add(new RoomModelUI(4,"Broken table"));
        roomProblemsListUI.add(new RoomModelUI(5,"Lights are not working"));
        roomProblemsListUI.add(new RoomModelUI(6,"Shower cabin or bathub is damaged"));
        roomProblemsListUI.add(new RoomModelUI(7,"Defective door"));
        roomProblemsListUI.add(new RoomModelUI(8,"Lack of minibar items"));
        roomProblemsListUI.add(new RoomModelUI(9,"Missing keys"));
        var roomAdapter = new RoomAdapter(roomProblemsListUI, new RoomAdapter.RoomMenuClickListener() {
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
                onSendRoomProblemsToServer();
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
    private void onSendRoomProblemsToServer() {
        var problemsToSendToServer = new ArrayList<RoomProblemsModel>();
        for (var roomProblem : roomProblemsListUI) {
            if (roomProblem.isSelected()) {
                problemsToSendToServer.add(DataConverterHelper.getInstance().roomProblemsModelsFromUIModel(roomProblem));
            }
        }
        for (var problem:problemsToSendToServer) {
            sendProblemToServer(problem, problemsToSendToServer.size());
        }
    }

    private void sendProblemToServer(RoomProblemsModel problem, int totalProblems) {
        FirebaseHelper.getInstance().getRoomProblemsDatabaseReference()
                .child(DataStorageHelper.getInstance().getRoomNumber())
                .push()
                .setValue(problem)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {
                checkIfAllProblemsSent(totalProblems);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(RoomActivity.this, "Adaugare eșuată", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void checkIfAllProblemsSent(int totalProblems) {
        if (++problemsSentToServer == totalProblems) {
            Toast.makeText(RoomActivity.this, "Adaugare cu succes", Toast.LENGTH_SHORT).show();
            finish();
        }
    }

    private void getDataFromServer() {
        FirebaseHelper.getInstance().getRoomDatabaseReference().addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                ArrayList<RoomProblemsModel> roomProblemsModelArrayList = new ArrayList<>();
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()){
                    RoomProblemsModel room = dataSnapshot1.getValue(RoomProblemsModel.class);
                    if(room != null){
                        roomProblemsModelArrayList.add(room);
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
    }
}

