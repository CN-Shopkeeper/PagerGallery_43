package com.shopkeeper.gallery;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GalleryViewModel extends AndroidViewModel {
    private MutableLiveData<List<PhotoItem>> photoListLive= new MutableLiveData<>();
    private ArrayList<String> keyWords=new ArrayList<>();
    public GalleryViewModel(@NonNull Application application) {
        super(application);
        keyWords.add("cat");
        keyWords.add("dog");
        keyWords.add("car");
        keyWords.add("beauty");
        keyWords.add("phone");
        keyWords.add("computer");
        keyWords.add("flower");
        keyWords.add("animal");
    }

    public void fetchData(){
        StringRequest stringRequest=new StringRequest
                (Request.Method.GET,
                        getUrl(),
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                Gson gson=new Gson();
                                Pixabay pixabay=gson.fromJson(response,Pixabay.class);
                                photoListLive.setValue(pixabay.getHits());
                                Log.i("GalleryViewModel",pixabay.getHits().toString());
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Log.i("GalleryViewModel",error.toString());
                            }
                        });
        VolleySingleton.getInstance(getApplication()).getRequestQueue().add(stringRequest);
    }

    private String getUrl(){
        return "https://pixabay.com/api/?key=18976664-784daca1700270b238f252820&q="+keyWords.get(new Random().nextInt(keyWords.size()))+"&per_page=100";
    }

    public MutableLiveData<List<PhotoItem>> getPhotoListLive() {
        return photoListLive;
    }
}
