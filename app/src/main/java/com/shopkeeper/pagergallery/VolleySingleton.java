package com.shopkeeper.pagergallery;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

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
