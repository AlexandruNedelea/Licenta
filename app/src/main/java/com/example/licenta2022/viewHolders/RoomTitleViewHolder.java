package com.example.licenta2022.viewHolders;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.licenta2022.R;
import com.example.licenta2022.databinding.RowRoomMenuTitleBinding;
import com.example.licenta2022.models.ListHeaderModelUI;

public class RoomTitleViewHolder extends RecyclerView.ViewHolder {
    private RowRoomMenuTitleBinding dataBinding;
    private ListHeaderModelUI itemModel;

    public RoomTitleViewHolder(RowRoomMenuTitleBinding dataBinding) {
        super(dataBinding.getRoot());
        this.dataBinding=dataBinding;
    }

    public void bind(ListHeaderModelUI model){
        itemModel = model;
        dataBinding.setModel(model);
        dataBinding.executePendingBindings();
    }

    public static RoomTitleViewHolder create(ViewGroup parent){
        final RowRoomMenuTitleBinding dataBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.row_room_menu_title, parent, false);
        return new RoomTitleViewHolder(dataBinding);
    }
}
