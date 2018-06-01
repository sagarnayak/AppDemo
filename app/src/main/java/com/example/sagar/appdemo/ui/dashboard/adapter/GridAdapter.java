package com.example.sagar.appdemo.ui.dashboard.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.sagar.appdemo.databinding.DashboardGridItemBinding;
import com.example.sagar.appdemo.ui.dashboard.pojo.GridItem;

import java.util.ArrayList;

/**
 * created by SAGAR KUMAR NAYAK on 31 MAY 2018.
 * Grid view adapter for dashboard
 */
public class GridAdapter extends RecyclerView.Adapter<GridAdapter.ViewHolder> {
    private ArrayList<GridItem> gridItems;

    public GridAdapter(ArrayList<GridItem> gridItems) {
        this.gridItems = gridItems;
    }

    @NonNull
    @Override
    public GridAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(
                DashboardGridItemBinding.inflate(
                        LayoutInflater.from(parent.getContext()),
                        parent,
                        false
                )
        );
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(gridItems.get(position));
    }

    @Override
    public int getItemCount() {
        return gridItems.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private DashboardGridItemBinding binding;

        ViewHolder(DashboardGridItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bind(GridItem gridItem) {
            binding.appcompatimageviewIcon.setImageResource(
                    gridItem.getIcon()
            );
            binding.textviewLabel.setText(
                    gridItem.getLabel()
            );
        }
    }
}
