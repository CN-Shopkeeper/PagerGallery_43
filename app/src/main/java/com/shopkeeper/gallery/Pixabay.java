package com.shopkeeper.gallery;

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

class PhotoItem{
    private String webformatURL;
    private int id;
    private String largeImageURL;

    public String getWebformatURL() {
        return webformatURL;
    }

    public void setWebformatURL(String webformatURL) {
        this.webformatURL = webformatURL;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLargeImageURL() {
        return largeImageURL;
    }

    public void setLargeImageURL(String largeImageURL) {
        this.largeImageURL = largeImageURL;
    }
}
