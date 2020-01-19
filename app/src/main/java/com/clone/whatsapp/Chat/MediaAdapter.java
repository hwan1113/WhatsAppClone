package com.clone.whatsapp.Chat;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.clone.whatsapp.R;

import java.util.ArrayList;
//63. Create an Media Adpater and extend ViewHolder
public class MediaAdapter extends RecyclerView.Adapter<MediaAdapter.MediaVIewHolder>{
    //Change the URI --> String or vice versa here.

    ArrayList<String> mediaList;
    Context context;

    public MediaAdapter(Context context, ArrayList<String> mediaList) {
        this.context = context;
        this.mediaList = mediaList;
    }

    //65. Create a Layout and view
    @NonNull
    @Override
    public MediaVIewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_media, null, false);
        MediaVIewHolder mediaVIewHolder = new MediaVIewHolder(layoutView);
        return mediaVIewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MediaVIewHolder holder, int position) {
        Glide.with(context).load(Uri.parse(mediaList.get(position))).into(holder.mMedia);




    }

    @Override
    public int getItemCount() {
        return mediaList.size();
    }
//64. Create a View holder and this will provide function that must be implemented at adapter.
    public class MediaVIewHolder extends RecyclerView.ViewHolder {

        ImageView mMedia;

        public MediaVIewHolder(@NonNull View itemView) {
            super(itemView);
            mMedia = itemView.findViewById(R.id.media);
        }


    }







}
