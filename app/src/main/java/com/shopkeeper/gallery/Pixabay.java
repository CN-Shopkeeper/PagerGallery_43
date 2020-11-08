package com.shopkeeper.gallery;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Pixabay {
    private int totalHits;
    private int total;
    private ArrayList<PhotoItem> hits=new ArrayList<>();


    public int getTotalHits() {
        return totalHits;
    }

    public void setTotalHits(int totalHits) {
        this.totalHits = totalHits;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public ArrayList<PhotoItem> getHits() {
        return hits;
    }

    public void setHits(ArrayList<PhotoItem> hits) {
        this.hits = hits;
    }
}

class PhotoItem implements Parcelable {
    @SerializedName("webformatURL")
    private String preViewURL;
    @SerializedName("largeImageURL")
    private String fullURL;
    @SerializedName("id")
    private int photoId;

    protected PhotoItem(Parcel in) {
        preViewURL = in.readString();
        fullURL = in.readString();
        photoId = in.readInt();
    }

    public static final Creator<PhotoItem> CREATOR = new Creator<PhotoItem>() {
        @Override
        public PhotoItem createFromParcel(Parcel in) {
            return new PhotoItem(in);
        }

        @Override
        public PhotoItem[] newArray(int size) {
            return new PhotoItem[size];
        }
    };

    public String getPreViewURL() {
        return preViewURL;
    }

    public void setPreViewURL(String preViewURL) {
        this.preViewURL = preViewURL;
    }

    public String getFullURL() {
        return fullURL;
    }

    public void setFullURL(String fullURL) {
        this.fullURL = fullURL;
    }

    public int getPhotoId() {
        return photoId;
    }

    public void setPhotoId(int photoId) {
        this.photoId = photoId;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(preViewURL);
        parcel.writeString(fullURL);
        parcel.writeInt(photoId);
    }
}
