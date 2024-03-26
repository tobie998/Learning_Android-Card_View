package com.example.cardview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    Context context;
    List<AppModel> appModelList;

    // Constructor
    public Adapter(Context context, List<AppModel> appModelList) {
        this.context = context;
        this.appModelList = appModelList;
    }

    // Implementing method
    // dealing with the inflation of the card layout as an item for the RecyclerView
    @NonNull
    @Override
    public Adapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_app, parent, false);
        return new MyViewHolder(itemView);
    }

    // dealing with the setting of different data and methods related to clicks on particular items of the RecyclerView
    @Override
    public void onBindViewHolder(@NonNull Adapter.MyViewHolder holder, int position) {
        AppModel appModel = appModelList.get(position);
        holder.title.setText(appModel.getName());
        holder.appDownload.setText(appModel.getNumOfDownload());

        // using Glide library
        Glide.with(context).load(appModel.getThumbnail()).into(holder.thumbnail);

    }

    @Override
    public int getItemCount() {
        return appModelList.size();
    }

    // MyViewHolder class
    public static class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView title, appDownload;
        public ImageView thumbnail;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.text_thumbnail_title);
            appDownload = itemView.findViewById(R.id.count);
            thumbnail = itemView.findViewById(R.id.image_thumbnail);
        }
    }
}
