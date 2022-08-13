package com.example.licenta2022.viewHolders;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.example.licenta2022.R;
import com.example.licenta2022.adapters.TripsMenuAdapter;
import com.example.licenta2022.databinding.RowTripsMenuBinding;

import com.example.licenta2022.models.TripsModelUI;

public class TripsMenuViewHolder extends RecyclerView.ViewHolder {
    private RowTripsMenuBinding dataBinding;
    private TripsModelUI itemModel;

    public TripsMenuViewHolder(RowTripsMenuBinding dataBinding, TripsMenuAdapter.TripsMenuClickListener onClickListener) {
        super(dataBinding.getRoot());
        this.dataBinding=dataBinding;
        dataBinding.getRoot().setOnClickListener(view -> {
            if (onClickListener != null) {
                onClickListener.onMenuClick(itemModel);
            }
        });
    }

    public void bind(TripsModelUI model){
        itemModel = model;
        dataBinding.setModel(model);
        dataBinding.executePendingBindings();
    }

    public static TripsMenuViewHolder create(ViewGroup parent, TripsMenuAdapter.TripsMenuClickListener onClickListener){
        final RowTripsMenuBinding dataBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.row_trips_menu, parent, false);
        return new TripsMenuViewHolder(dataBinding, onClickListener);

    }
}
