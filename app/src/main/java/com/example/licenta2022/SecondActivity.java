package com.example.licenta2022;


import android.os.Bundle;

import com.example.licenta2022.activities.BaseActivity;
import com.example.licenta2022.databinding.ActivitySecondBinding;

public class SecondActivity extends BaseActivity<ActivitySecondBinding> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        dataBinding= ActivitySecondBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        String intentInfo=getIntent().getStringExtra(MainActivity.TEST_INTENT);
        dataBinding.tvSecondActivity.setText(intentInfo);
    }
}