package com.example.licenta2022.adapters;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.licenta2022.enums.ListItemGenericType;
import com.example.licenta2022.models.ListHeaderModelUI;
import com.example.licenta2022.models.ListItemBaseModelUI;
import com.example.licenta2022.models.RoomServiceModelUI;
import com.example.licenta2022.viewHolders.RoomServiceViewHolder;
import com.example.licenta2022.viewHolders.RoomTitleViewHolder;

import java.util.List;

public class RoomServiceAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<ListItemBaseModelUI> modelsList;
    private RoomServiceClickListener roomServiceClickListener;

    public RoomServiceAdapter(List<ListItemBaseModelUI> modelsList, RoomServiceClickListener roomServiceClickListener){
        this.modelsList=modelsList;
        this.roomServiceClickListener=roomServiceClickListener;
    }

    public void addItem(ListItemBaseModelUI newItem) {
        modelsList.add(newItem);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == ListItemGenericType.HEADER) {
            return RoomTitleViewHolder.create(parent);
        }
        return RoomServiceViewHolder.create(parent, roomServiceClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof RoomServiceViewHolder) {
            ((RoomServiceViewHolder) holder).bind((RoomServiceModelUI) modelsList.get(position));
        } else if (holder instanceof RoomTitleViewHolder) {
            ((RoomTitleViewHolder) holder).bind((ListHeaderModelUI) modelsList.get(position));
        }
    }

    @Override
    public int getItemViewType(int position) {
        return modelsList.get(position).getType();
    }

    @Override
    public int getItemCount() {return modelsList.size(); }

    public interface RoomServiceClickListener{
        void onMenuClick(ListItemBaseModelUI item);
    }
}
