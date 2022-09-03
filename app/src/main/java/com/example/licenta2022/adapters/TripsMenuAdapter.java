package com.example.licenta2022.adapters;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.licenta2022.models.TripsModelUI;
import com.example.licenta2022.viewHolders.TripsMenuViewHolder;

import java.util.List;

public class TripsMenuAdapter extends RecyclerView.Adapter<TripsMenuViewHolder> {
    private List<TripsModelUI> modelsList;
    private TripsMenuClickListener tripsMenuClickListener;

    public TripsMenuAdapter(List<TripsModelUI> modelsList, TripsMenuClickListener tripsMenuClickListener){
        this.modelsList=modelsList;
        this.tripsMenuClickListener=tripsMenuClickListener;
    }

    public void addItem(TripsModelUI newItem) {
        modelsList.add(newItem);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public TripsMenuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return TripsMenuViewHolder.create(parent, tripsMenuClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull TripsMenuViewHolder holder, int position) {
        holder.bind(modelsList.get(position));
    }

    @Override
    public int getItemCount() {return modelsList.size(); }

    public interface TripsMenuClickListener{
        void onMenuClick(TripsModelUI item);
    }
}
