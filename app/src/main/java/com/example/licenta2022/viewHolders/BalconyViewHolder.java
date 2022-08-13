package com.example.licenta2022.viewHolders;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.licenta2022.R;
import com.example.licenta2022.adapters.BalconyAdapter;
import com.example.licenta2022.adapters.HotelMenuAdapter;
import com.example.licenta2022.databinding.RowBalconyBinding;
import com.example.licenta2022.databinding.RowHotelMenuBinding;
import com.example.licenta2022.models.BalconyModelUI;
import com.example.licenta2022.models.HotelMenuModelUI;

public class BalconyViewHolder extends RecyclerView.ViewHolder {
    private RowBalconyBinding dataBinding;
    private BalconyModelUI itemModel;

    public BalconyViewHolder(RowBalconyBinding dataBinding, BalconyAdapter.BalconyMenuClickListener onClickListener) {
        super(dataBinding.getRoot());
        this.dataBinding=dataBinding;
        dataBinding.getRoot().setOnClickListener(view -> {
            if (onClickListener != null) {
                onClickListener.onMenuClick(itemModel);
            }
        });
    }

    public void bind(BalconyModelUI model){
        itemModel = model;
        dataBinding.setModel(model);
        dataBinding.executePendingBindings();
    }

    public static BalconyViewHolder create(ViewGroup parent, BalconyAdapter.BalconyMenuClickListener onClickListener){
        final RowBalconyBinding dataBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.row_balcony, parent, false);
        return new BalconyViewHolder(dataBinding, onClickListener);


    }
}
