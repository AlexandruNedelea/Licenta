package com.example.licenta2022.adapters;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.licenta2022.models.UserDetailsModel;
import com.example.licenta2022.viewHolders.UserDetailsViewHolder;

import java.util.List;

public class UserDetailsAdapter extends RecyclerView.Adapter<UserDetailsViewHolder> {
    private List<UserDetailsModel> modelsList;

    public UserDetailsAdapter(List<UserDetailsModel> modelsList){
        this.modelsList=modelsList;
    }

    public void addItem(UserDetailsModel newItem) {
        modelsList.add(newItem);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public UserDetailsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return UserDetailsViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull UserDetailsViewHolder holder, int position) {
        UserDetailsModel model =modelsList.get(position);
        holder.bind(model);
    }

    @Override
    public int getItemCount() {return modelsList.size(); }
}
