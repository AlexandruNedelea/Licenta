package com.example.licenta2022;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.licenta2022.activities.BaseActivity;
import com.example.licenta2022.databinding.ActivityMainBinding;

public class MainActivity extends BaseActivity<ActivityMainBinding> {
    public static String TEST_INTENT = "intent_key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        dataBinding= ActivityMainBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setOnClickListener();
    }

    @Override
    protected void onResume() {
        super.onResume();
        dataBinding.editSecondActivity.setText("");
    }

    private void setOnClickListener() {
        dataBinding.btnToSecondActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigateToSecondActivity();

            }
        });
        dataBinding.btnhotel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigateToQRActivity();
            }
        });
    }

    private void navigateToQRActivity(){
        Intent i=new Intent(this, HotelActivity.class);
        startActivity(i);
    }

    private void navigateToSecondActivity() {
        String editSecondActivity=dataBinding.editSecondActivity.getText().toString();
        Intent i = new Intent(this, ListeActivity.class);
        i.putExtra(TEST_INTENT, editSecondActivity);
        startActivity(i);
    }

    private void navigateToHotelActivity() {
        Intent i = new Intent(this, HotelActivity.class);
        startActivity(i);
    }
}