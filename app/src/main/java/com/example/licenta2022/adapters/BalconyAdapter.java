package com.example.licenta2022.adapters;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.licenta2022.models.BalconyModelUI;
import com.example.licenta2022.viewHolders.BalconyViewHolder;

import java.util.List;

public class BalconyAdapter extends RecyclerView.Adapter<BalconyViewHolder> {
    private List<BalconyModelUI> modelsList;
    private BalconyMenuClickListener balconyMenuClickListener;

    public BalconyAdapter(List<BalconyModelUI> modelsList, BalconyMenuClickListener hotelMenuClickListener){
        this.modelsList=modelsList;
        this.balconyMenuClickListener=balconyMenuClickListener;
    }

    public void addItem(BalconyModelUI newItem) {
        modelsList.add(newItem);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public BalconyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return BalconyViewHolder.create(parent, balconyMenuClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull BalconyViewHolder holder, int position) {
        holder.bind(modelsList.get(position));
    }

    @Override
    public int getItemCount() {return modelsList.size(); }

    public interface BalconyMenuClickListener{
        void onMenuClick(BalconyModelUI item);
    }
}
