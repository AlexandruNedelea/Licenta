package com.example.licenta2022.viewHolders;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.licenta2022.R;
import com.example.licenta2022.adapters.RoomServiceAdapter;
import com.example.licenta2022.databinding.RowHotelMenuBinding;
import com.example.licenta2022.databinding.RowMenuRoomServiceBinding;
import com.example.licenta2022.models.RoomServiceModelUI;

public class RoomServiceViewHolder extends RecyclerView.ViewHolder {
    private RowMenuRoomServiceBinding dataBinding;
    private RoomServiceModelUI itemModel;

    public RoomServiceViewHolder(RowMenuRoomServiceBinding dataBinding, RoomServiceAdapter.RoomServiceClickListener onClickListener) {
        super(dataBinding.getRoot());
        this.dataBinding=dataBinding;
        dataBinding.getRoot().setOnClickListener(view -> {
            if (onClickListener != null) {
                onClickListener.onMenuClick(itemModel);
            }
        });
    }

    public void bind(RoomServiceModelUI model){
        itemModel = model;
        dataBinding.setModel(model);
        dataBinding.executePendingBindings();
    }

    public static RoomServiceViewHolder create(ViewGroup parent, RoomServiceAdapter.RoomServiceClickListener onClickListener){
        final RowMenuRoomServiceBinding dataBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.row_menu_room_service, parent, false);
        return new RoomServiceViewHolder(dataBinding, onClickListener);
    }
}
