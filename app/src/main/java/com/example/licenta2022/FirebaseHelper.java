package com.example.licenta2022;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FirebaseHelper {
    public static FirebaseHelper firebaseHelper;
    private final DatabaseReference roomDatabaseReference = FirebaseDatabase.getInstance().getReference().child("Room");

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


}
