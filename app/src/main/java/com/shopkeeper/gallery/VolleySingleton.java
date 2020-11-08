package com.shopkeeper.gallery;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.ArrayList;
import java.util.Random;

public class VolleySingleton {
    private static VolleySingleton volleySingleton=null;
    private static RequestQueue requestQueue=null;
    private Context mContext;

    public static synchronized VolleySingleton getInstance(Context context){
        if (volleySingleton==null){
            volleySingleton=new VolleySingleton(context);
        }
        return volleySingleton;
    }
    private VolleySingleton(Context context){
        mContext=context;
        requestQueue= getRequestQueue();
    }
    public RequestQueue getRequestQueue(){
        if (requestQueue==null){
            requestQueue= Volley.newRequestQueue(mContext);
        }
        return requestQueue;
    }
}
