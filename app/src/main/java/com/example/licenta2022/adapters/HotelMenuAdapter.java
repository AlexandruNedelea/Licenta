package com.example.licenta2022.adapters;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.licenta2022.models.HotelMenuModelUI;
import com.example.licenta2022.viewHolders.HotelMenuViewHolder;

import java.util.List;

public class HotelMenuAdapter extends RecyclerView.Adapter<HotelMenuViewHolder> {
    private List<HotelMenuModelUI> modelsList;
    private HotelMenuClickListener hotelMenuClickListener;

    public HotelMenuAdapter(List<HotelMenuModelUI> modelsList, HotelMenuClickListener hotelMenuClickListener){
        this.modelsList=modelsList;
        this.hotelMenuClickListener=hotelMenuClickListener;
    }

    public void addItem(HotelMenuModelUI newItem) {
        modelsList.add(newItem);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public HotelMenuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return HotelMenuViewHolder.create(parent, hotelMenuClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull HotelMenuViewHolder holder, int position) {
        holder.bind(modelsList.get(position));
    }

    @Override
    public int getItemCount() {return modelsList.size(); }

    public interface HotelMenuClickListener{
        void onMenuClick(HotelMenuModelUI item);
    }
}
