package com.example.licenta2022;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.licenta2022.activities.BaseActivity;
import com.example.licenta2022.databinding.ActivityEmployeeRoomProblemsBinding;

public class EmployeeRoomProblemsActivity extends BaseActivity<ActivityEmployeeRoomProblemsBinding> {
    public static String TEST_INTENT = "intent_key";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        dataBinding= ActivityEmployeeRoomProblemsBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
    }
}