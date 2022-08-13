package com.example.licenta2022;

import android.os.Bundle;
import android.widget.Toast;

import com.example.licenta2022.adapters.UserDetailsAdapter;
import com.example.licenta2022.activities.BaseActivity;
import com.example.licenta2022.adapters.UserDetailsWithClickAdapter;
import com.example.licenta2022.databinding.ActivityListeBinding;
import com.example.licenta2022.models.UserDetailsModel;

import java.util.ArrayList;

public class ListeActivity extends BaseActivity<ActivityListeBinding> {
    public static String TEST_INTENT = "intent_key";

    private UserDetailsWithClickAdapter userDetailsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        dataBinding= ActivityListeBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setReciclerView();
        setListners();
    }

    private void setListners() {
        dataBinding.btnInsert.setOnClickListener(view -> onInsertInList());
    }

    private void onInsertInList() {
        String name =dataBinding.etName.getText().toString();
        String firstname =dataBinding.etFirstName.getText().toString();
        String age =dataBinding.etAge.getText().toString();
        UserDetailsModel newUser = new UserDetailsModel(name, firstname, Integer.parseInt(age));
        userDetailsAdapter.addItem(newUser);
    }

    protected void onResume() {
        super.onResume();
        dataBinding.etName.setText("");
        dataBinding.etFirstName.setText("");
        dataBinding.etAge.setText("");
    }

    private void setReciclerView() {
        ArrayList<UserDetailsModel> userDetailsList =new ArrayList<>();
        userDetailsList.add(new UserDetailsModel("Nedi", "Alex", 26));
        userDetailsList.add(new UserDetailsModel("Nedi", "Alex", 26));
        userDetailsList.add(new UserDetailsModel("Nedi", "Alex", 26));
        userDetailsList.add(new UserDetailsModel("Nedi", "Alex", 26));
        userDetailsAdapter = new UserDetailsWithClickAdapter(userDetailsList, new UserDetailsWithClickAdapter.OnClickListener() {
            @Override
            public void onUserClick(UserDetailsModel model) {
                onUserItemClick(model);
            }
        });
        dataBinding.rvUserDetails.setAdapter(userDetailsAdapter);
    }

    private void onUserItemClick(UserDetailsModel model) {
        Toast.makeText(this, model.getName(), Toast.LENGTH_SHORT).show();
    }

}
