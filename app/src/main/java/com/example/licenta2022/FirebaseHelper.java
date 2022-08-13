package com.example.licenta2022;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FirebaseHelper {
    private static FirebaseHelper firebaseHelper;
    private final DatabaseReference roomDatabaseReference = FirebaseDatabase.getInstance().getReference().child("Room");
    private final DatabaseReference roomProblemsDatabaseReference = FirebaseDatabase.getInstance().getReference().child("room_problems");
    private final DatabaseReference tripsDatabaseReference = FirebaseDatabase.getInstance().getReference().child("trips");

    public FirebaseHelper(){
    }

    public static FirebaseHelper getInstance(){
        if(firebaseHelper == null)
        {
            firebaseHelper = new FirebaseHelper();
        }
        return firebaseHelper;
    }

    public DatabaseReference getRoomDatabaseReference() {
        return roomDatabaseReference;
    }

    public DatabaseReference getRoomProblemsDatabaseReference() {
        return roomProblemsDatabaseReference;
    }

    public DatabaseReference getTripsDatabaseReference() {
        return tripsDatabaseReference;
    }
}
