package com.astroexpress.astromarket.model;

public class GemstoneModel {
    private String title;
    private int imageUrl;
    private String title_16;
    private String title_rupee;
    private String title_strike;

    public GemstoneModel(String title, int imageUrl, String title_16, String title_rupee, String title_strike) {
        this.title = title;
        this.imageUrl = imageUrl;
        this.title_16 = title_16;
        this.title_rupee = title_rupee;
        this.title_strike = title_strike;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setImageUrl(int imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setTitle_16(String title_16) {
        this.title_16 = title_16;
    }

    public void setTitle_rupee(String title_rupee) {
        this.title_rupee = title_rupee;
    }

    public void setTitle_strike(String title_strike) {
        this.title_strike = title_strike;
    }

    public String getTitle() {
        return title;
    }

    public int getImageUrl() {
        return imageUrl;
    }

    public String getTitle_16() {
        return title_16;
    }

    public String getTitle_rupee() {
        return title_rupee;
    }

    public String getTitle_strike() {
        return title_strike;
    }
}
