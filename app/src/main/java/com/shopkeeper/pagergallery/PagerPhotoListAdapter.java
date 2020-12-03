package com.shopkeeper.pagergallery;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

public class PagerPhotoListAdapter extends ListAdapter<PhotoItem,PagerPhotoViewHolder> {
    protected PagerPhotoListAdapter() {
        super(new DiffUtil.ItemCallback<PhotoItem>() {
            @Override
            public boolean areItemsTheSame(@NonNull PhotoItem oldItem, @NonNull PhotoItem newItem) {
                return oldItem==newItem;
            }

            @Override
            public boolean areContentsTheSame(@NonNull PhotoItem oldItem, @NonNull PhotoItem newItem) {
                return oldItem.getPhotoId()==newItem.getPhotoId();
            }
        });
    }

    @NonNull
    @Override
    public PagerPhotoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.pager_photo_view,parent,false);
        return new PagerPhotoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PagerPhotoViewHolder holder, int position) {
        ImageView imageView=holder.itemView.findViewById(R.id.pagerPhoto);
        Glide.with(holder.itemView)
                .load(getItem(position).getFullURL())
                .placeholder(R.drawable.ic_baseline_photo_24)
                .into(imageView);
    }
}

class PagerPhotoViewHolder extends RecyclerView.ViewHolder{

    public PagerPhotoViewHolder(@NonNull View itemView) {
        super(itemView);
    }
}