package com.example.licenta2022.adapters;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.licenta2022.models.DealsTripsUI;
import com.example.licenta2022.models.HotelMenuModelUI;
import com.example.licenta2022.viewHolders.DealsTripsViewHolder;
import com.example.licenta2022.viewHolders.HotelMenuViewHolder;

import java.util.List;

public class DealsTripsAdapter extends RecyclerView.Adapter<DealsTripsViewHolder> {
    private List<DealsTripsUI> modelsList;
    private DealsTripsClickListener dealsTripsClickListener;

    public DealsTripsAdapter(List<DealsTripsUI> modelsList, DealsTripsClickListener dealsTripsClickListener){
        this.modelsList=modelsList;
        this.dealsTripsClickListener=dealsTripsClickListener;
    }

    public void addItem(DealsTripsUI newItem) {
        modelsList.add(newItem);
        notifyDataSetChanged();
    }

    public void updateList(List<DealsTripsUI> newItems) {
        modelsList.addAll(newItems);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public DealsTripsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return DealsTripsViewHolder.create(parent, dealsTripsClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull DealsTripsViewHolder holder, int position) {
        holder.bind(modelsList.get(position));
    }

    @Override
    public int getItemCount() {return modelsList.size(); }

    public interface DealsTripsClickListener{
        void onMenuClick(DealsTripsUI item);
    }
}
