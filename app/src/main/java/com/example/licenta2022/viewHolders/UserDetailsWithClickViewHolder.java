package com.example.licenta2022.viewHolders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.licenta2022.R;
import com.example.licenta2022.adapters.UserDetailsWithClickAdapter;
import com.example.licenta2022.databinding.RowUserDetailsBinding;
import com.example.licenta2022.models.UserDetailsModel;

public class UserDetailsWithClickViewHolder extends RecyclerView.ViewHolder {
    private RowUserDetailsBinding dataBinding;
    private UserDetailsModel itemModel;

    public UserDetailsWithClickViewHolder(RowUserDetailsBinding dataBinding, UserDetailsWithClickAdapter.OnClickListener onClickListener) {
        super(dataBinding.getRoot());
        this.dataBinding=dataBinding;
        dataBinding.getRoot().setOnClickListener(view -> {
            if (onClickListener != null) {
                onClickListener.onUserClick(itemModel);
            }
        });
    }

    public void bind(UserDetailsModel model){
        itemModel = model;
        dataBinding.setModel(model);
        dataBinding.executePendingBindings();
    }

    public static UserDetailsWithClickViewHolder create(ViewGroup parent, UserDetailsWithClickAdapter.OnClickListener onClickListener){
        final RowUserDetailsBinding dataBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.row_user_details, parent, false);
        return new UserDetailsWithClickViewHolder(dataBinding, onClickListener);

    }
}
