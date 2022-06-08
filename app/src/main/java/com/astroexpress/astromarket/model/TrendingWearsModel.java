package com.astroexpress.astromarket.model;

public class TrendingWearsModel {
    private String textsixteen_trend;
    private String titletext;
    private String textnumber_rupee;

    public TrendingWearsModel(String textsixteen_trend, String titletext, String textnumber_rupee, String titlestrik, int imageUrl_trend) {
        this.textsixteen_trend = textsixteen_trend;
        this.titletext = titletext;
        this.textnumber_rupee = textnumber_rupee;
        this.titlestrik = titlestrik;
        this.imageUrl_trend = imageUrl_trend;
    }

    private String titlestrik;
    private int imageUrl_trend;

    public void setTextsixteen_trend(String textsixteen_trend) {
        this.textsixteen_trend = textsixteen_trend;
    }

    public void setTitletext(String titletext) {
        this.titletext = titletext;
    }

    public void setTextnumber_rupee(String textnumber_rupee) {
        this.textnumber_rupee = textnumber_rupee;
    }

    public void setTitlestrik(String titlestrik) {
        this.titlestrik = titlestrik;
    }

    public void setImageUrl_trend(int imageUrl_trend) {
        this.imageUrl_trend = imageUrl_trend;
    }

    public String getTextsixteen_trend() {
        return textsixteen_trend;
    }

    public String getTitletext() {
        return titletext;
    }

    public String getTextnumber_rupee() {
        return textnumber_rupee;
    }

    public String getTitlestrik() {
        return titlestrik;
    }

    public int getImageUrl_trend() {
        return imageUrl_trend;
    }
}
