package com.example.licenta2022.adapters;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.licenta2022.models.ListHeaderModelUI;
import com.example.licenta2022.models.RoomModelUI;
import com.example.licenta2022.viewHolders.RoomViewHolder;

import java.util.List;

public class RoomAdapter extends RecyclerView.Adapter<RoomViewHolder> {
    private List<RoomModelUI> modelsList;
    private RoomMenuClickListener roomMenuClickListener;
    private List<ListHeaderModelUI> modelsListTitle;
    public RoomAdapter(List<RoomModelUI> modelsList, RoomMenuClickListener roomMenuClickListener){
        this.modelsList=modelsList;
        this.roomMenuClickListener=roomMenuClickListener;
    }

    public void addItem(RoomModelUI newItem) {
        modelsList.add(newItem);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RoomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return RoomViewHolder.create(parent, roomMenuClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull RoomViewHolder holder, int position) {
        holder.bind(modelsList.get(position));
    }

    @Override
    public int getItemCount() {return modelsList.size(); }

    public interface RoomMenuClickListener{
        void onMenuClick(RoomModelUI item);
    }
}
