package com.example.licenta2022.viewHolders;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.licenta2022.R;
import com.example.licenta2022.databinding.RowEmployeeHouseKeepingBinding;
import com.example.licenta2022.models.network.HouseKeepingModel;

public class EmployeeHouseKeepingViewHolder extends RecyclerView.ViewHolder {
    private RowEmployeeHouseKeepingBinding dataBinding;

    public EmployeeHouseKeepingViewHolder(RowEmployeeHouseKeepingBinding dataBinding) {
        super(dataBinding.getRoot());
        this.dataBinding=dataBinding;
    }

    public void bind(HouseKeepingModel model) {
        dataBinding.setModel(model);
        dataBinding.executePendingBindings();
    }

    public static EmployeeHouseKeepingViewHolder create (ViewGroup parent){
        final RowEmployeeHouseKeepingBinding dataBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.row_employee_house_keeping, parent, false);
        return new EmployeeHouseKeepingViewHolder(dataBinding);
    }
}
