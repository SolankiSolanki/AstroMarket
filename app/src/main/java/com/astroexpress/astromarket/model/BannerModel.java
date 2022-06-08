package com.astroexpress.astromarket.model;

public class BannerModel {
    String imageUrl;

    public BannerModel(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
