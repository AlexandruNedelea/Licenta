package com.example.licenta2022;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.licenta2022.activities.BaseActivity;
import com.example.licenta2022.databinding.ActivityUserSelectorBinding;

public class UserSelectorActivity extends BaseActivity<ActivityUserSelectorBinding> {
    public static String TEST_INTENT = "intent_key";
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        dataBinding= ActivityUserSelectorBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setOnClickListener();
    }

    private void setOnClickListener() {
        dataBinding.btnGuest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigateToQRCodeActivity();
            }

        });
        dataBinding.btnEmployee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigateToEmployeeActivity();
            }
        });
    }

    private void navigateToEmployeeActivity() {
        Intent i=new Intent(this, EmployeeActivity.class);
        startActivity(i);
    }

    private void navigateToQRCodeActivity() {
        Intent i=new Intent(this, QRCodeActivity.class);
        startActivity(i);
    }
}
