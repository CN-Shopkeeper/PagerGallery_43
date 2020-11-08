package com.shopkeeper.gallery;

import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

import io.supercharge.shimmerlayout.ShimmerLayout;
import uk.co.senab.photoview.PhotoView;

public class PhotoFragment extends Fragment {
    ShimmerLayout shimmerLayout;
    PhotoView photoView;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_photo, container, false);
        shimmerLayout=view.findViewById(R.id.shimmerLayoutPhoto);
        shimmerLayout.setShimmerColor(0x55ffffff);//55表示透明度
        shimmerLayout.setShimmerAngle(0);
        shimmerLayout.startShimmerAnimation();
        photoView =view.findViewById(R.id.photoView);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        PhotoItem photoItem= getArguments() != null ? (PhotoItem) getArguments().getParcelable("PHOTO") : null;

        Glide.with(requireContext())
                .load(photoItem != null ? photoItem.getFullURL() : null)
                .placeholder(R.drawable.ic_baseline_photo_24)
                .listener(new RequestListener<Drawable>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                        shimmerLayout.stopShimmerAnimation();
                        return false;
                    }
                })
                .into(photoView);
    }
}