package com.geekbrains.weather;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


class TempListAdapter extends RecyclerView.Adapter<TempListAdapter.ViewHolder> {
    ArrayList<Integer> tempData;

    public TempListAdapter(ArrayList<Integer> tempData) {
        this.tempData = tempData;
    }

    @NonNull
    @Override
    public TempListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.temp_list_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull TempListAdapter.ViewHolder holder, int position) {
        holder.temp_text_view.setText(String.valueOf(tempData.get(position)));
        if (tempData.get(position) >= 0) {
            holder.temp_image.setImageResource(R.drawable.ic_lens_red_24dp);
        } else {
            holder.temp_image.setImageResource(R.drawable.ic_lens_blue_24dp);
        }

    }

    @Override
    public int getItemCount() {
        return tempData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView temp_text_view;
        ImageView temp_image;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            temp_text_view = itemView.findViewById(R.id.temp_text_view);
            temp_image = itemView.findViewById(R.id.temp_image);
        }
    }

    public void addItem(Integer newItem) {
        tempData.add(newItem);
        this.notifyItemInserted(tempData.size() - 1);
    }
}