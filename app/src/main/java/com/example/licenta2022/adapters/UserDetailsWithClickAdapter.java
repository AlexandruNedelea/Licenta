package com.example.licenta2022.adapters;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.licenta2022.models.UserDetailsModel;
import com.example.licenta2022.viewHolders.UserDetailsViewHolder;
import com.example.licenta2022.viewHolders.UserDetailsWithClickViewHolder;

import java.util.List;

public class UserDetailsWithClickAdapter extends RecyclerView.Adapter<UserDetailsWithClickViewHolder> {
    private List<UserDetailsModel> modelsList;
    private OnClickListener onClickListener;

    public UserDetailsWithClickAdapter(List<UserDetailsModel> modelsList, OnClickListener onClickListener){
        this.modelsList=modelsList;
        this.onClickListener=onClickListener;
    }

    public void addItem(UserDetailsModel newItem) {
        modelsList.add(newItem);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public UserDetailsWithClickViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return UserDetailsWithClickViewHolder.create(parent, onClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull UserDetailsWithClickViewHolder holder, int position) {
        UserDetailsModel model =modelsList.get(position);
        holder.bind(model);
    }

    @Override
    public int getItemCount() {return modelsList.size(); }

    public interface OnClickListener {
        void onUserClick(UserDetailsModel model);
    }
}
