package com.shopkeeper.pagergallery;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class PagerPhotoFragment extends Fragment {

    ViewPager2 viewPager2;
    PagerPhotoListAdapter pagerPhotoListAdapter;
    ArrayList<PhotoItem> photoList;
    TextView photoTag;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_pager_photo, container, false);
        viewPager2=view.findViewById(R.id.viewPager2);
        photoTag=view.findViewById(R.id.photeTag);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        photoList=getArguments().getParcelableArrayList("PHOTO_LIST");
        pagerPhotoListAdapter=new PagerPhotoListAdapter();
        viewPager2.setAdapter(pagerPhotoListAdapter);
        pagerPhotoListAdapter.submitList(photoList);

        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                photoTag.setText(position+1+"/"+photoList.size());
            }
        });

        viewPager2.setCurrentItem(getArguments().getInt("PHOTO_POSITION"),true);//平滑移动
    }
}