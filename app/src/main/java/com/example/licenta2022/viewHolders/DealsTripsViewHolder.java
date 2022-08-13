package com.example.licenta2022.viewHolders;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.licenta2022.R;
import com.example.licenta2022.adapters.DealsTripsAdapter;
import com.example.licenta2022.databinding.RowDealsTripsBinding;
import com.example.licenta2022.models.DealsTripsUI;

public class DealsTripsViewHolder extends RecyclerView.ViewHolder {
    private RowDealsTripsBinding dataBinding;
    private DealsTripsUI itemModel;

    public DealsTripsViewHolder(RowDealsTripsBinding dataBinding, DealsTripsAdapter.DealsTripsClickListener onClickListener) {
        super(dataBinding.getRoot());
        this.dataBinding=dataBinding;
        dataBinding.getRoot().setOnClickListener(view -> {
            if (onClickListener != null) {
                onClickListener.onMenuClick(itemModel);
            }
        });
    }

    public void bind(DealsTripsUI model){
        itemModel = model;
        dataBinding.setModel(model);
        dataBinding.executePendingBindings();
    }

    public static DealsTripsViewHolder create(ViewGroup parent, DealsTripsAdapter.DealsTripsClickListener onClickListener){
        final RowDealsTripsBinding dataBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.row_deals_trips, parent, false);
        return new DealsTripsViewHolder(dataBinding, onClickListener);
    }
}
