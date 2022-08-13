package com.example.licenta2022.viewHolders;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.licenta2022.R;
import com.example.licenta2022.adapters.HotelMenuAdapter;
import com.example.licenta2022.databinding.RowHotelMenuBinding;
import com.example.licenta2022.models.HotelMenuModelUI;

public class HotelMenuViewHolder extends RecyclerView.ViewHolder {
    private RowHotelMenuBinding dataBinding;
    private HotelMenuModelUI itemModel;

    public HotelMenuViewHolder(RowHotelMenuBinding dataBinding, HotelMenuAdapter.HotelMenuClickListener onClickListener) {
        super(dataBinding.getRoot());
        this.dataBinding=dataBinding;
        dataBinding.getRoot().setOnClickListener(view -> {
            if (onClickListener != null) {
                onClickListener.onMenuClick(itemModel);
            }
        });
    }

    public void bind(HotelMenuModelUI model){
        itemModel = model;
        dataBinding.setModel(model);
        dataBinding.executePendingBindings();
    }

    public static HotelMenuViewHolder create(ViewGroup parent, HotelMenuAdapter.HotelMenuClickListener onClickListener){
        final RowHotelMenuBinding dataBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.row_hotel_menu, parent, false);
        return new HotelMenuViewHolder(dataBinding, onClickListener);


    }
}
