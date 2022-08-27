package com.example.licenta2022.viewHolders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.licenta2022.R;
import com.example.licenta2022.databinding.RowUserDetailsBinding;
import com.example.licenta2022.models.UserDetailsModel;

public class UserDetailsViewHolder extends RecyclerView.ViewHolder {
    private RowUserDetailsBinding dataBinding;


    public UserDetailsViewHolder(RowUserDetailsBinding dataBinding) {
        super(dataBinding.getRoot());
        this.dataBinding=dataBinding;
    }

    public static UserDetailsViewHolder create (ViewGroup parent){
        final RowUserDetailsBinding dataBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
        R.layout.row_user_details, parent, false);
        return new UserDetailsViewHolder(dataBinding);

    }

    public void bind(UserDetailsModel model){
        dataBinding.setModel(model);
        dataBinding.executePendingBindings();
    }
}
