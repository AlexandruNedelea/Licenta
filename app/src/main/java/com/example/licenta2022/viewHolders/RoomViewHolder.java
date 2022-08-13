package com.example.licenta2022.viewHolders;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.licenta2022.R;
import com.example.licenta2022.adapters.BalconyAdapter;
import com.example.licenta2022.adapters.RoomAdapter;
import com.example.licenta2022.databinding.RowBalconyBinding;
import com.example.licenta2022.databinding.RowRoomMenuBinding;
import com.example.licenta2022.models.BalconyModelUI;
import com.example.licenta2022.models.RoomModelUI;

public class RoomViewHolder extends RecyclerView.ViewHolder {
    private RowRoomMenuBinding dataBinding;
    private RoomModelUI itemModel;

    public RoomViewHolder(RowRoomMenuBinding dataBinding, RoomAdapter.RoomMenuClickListener onClickListener) {
        super(dataBinding.getRoot());
        this.dataBinding=dataBinding;
        dataBinding.getRoot().setOnClickListener(view -> {
            if (onClickListener != null) {
                onClickListener.onMenuClick(itemModel);
            }
        });
    }

    public void bind(RoomModelUI model){
        itemModel = model;
        dataBinding.setModel(model);
        dataBinding.executePendingBindings();
    }

    public static RoomViewHolder create(ViewGroup parent, RoomAdapter.RoomMenuClickListener onClickListener){
        final RowRoomMenuBinding dataBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.row_room_menu, parent, false);
        return new RoomViewHolder(dataBinding, onClickListener);


    }
}
