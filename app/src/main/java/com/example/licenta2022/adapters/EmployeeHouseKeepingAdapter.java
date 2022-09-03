package com.example.licenta2022.adapters;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.licenta2022.models.HotelMenuModelUI;
import com.example.licenta2022.models.UserDetailsModel;
import com.example.licenta2022.models.network.HouseKeepingModel;
import com.example.licenta2022.viewHolders.EmployeeHouseKeepingViewHolder;
import com.example.licenta2022.viewHolders.UserDetailsViewHolder;

import java.util.List;

public class EmployeeHouseKeepingAdapter extends RecyclerView.Adapter<EmployeeHouseKeepingViewHolder> {
    private List<HouseKeepingModel> modelsList;
    private EmployeeHouseKeepingAdapter.EmployeeHouseKeepingClickListener employeeHouseKeepingClickListener;

    public EmployeeHouseKeepingAdapter(List<HouseKeepingModel> modelsList, EmployeeHouseKeepingAdapter.EmployeeHouseKeepingClickListener employeeHouseKeepingClickListener){
        this.modelsList = modelsList;
        this.employeeHouseKeepingClickListener=employeeHouseKeepingClickListener;
    }

    public void addItem(HouseKeepingModel newItem) {
        modelsList.add(newItem);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public EmployeeHouseKeepingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return EmployeeHouseKeepingViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull EmployeeHouseKeepingViewHolder holder, int position) {
        HouseKeepingModel model =modelsList.get(position);
        holder.bind(model);
    }

    @Override
    public int getItemCount() {return modelsList.size(); }

    public interface EmployeeHouseKeepingClickListener{
        void onMenuClick(HouseKeepingModel item);
    }
}
