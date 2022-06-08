package com.astroexpress.astromarket.model;

public class RecentViewItemModel {
    private String titlesixteen;
    private String titletext;
    private String titlenumber;
    private String titlestrik;
    private int imageUrl;

    public RecentViewItemModel(String titlesixteen, String titletext, String titlenumber, String titlestrik, int imageUrl) {
        this.titlesixteen = titlesixteen;
        this.titletext = titletext;
        this.titlenumber = titlenumber;
        this.titlestrik = titlestrik;
        this.imageUrl = imageUrl;
    }

    public void setTitlesixteen(String titlesixteen) {
        this.titlesixteen = titlesixteen;
    }

    public void setTitletext(String titletext) {
        this.titletext = titletext;
    }

    public void setTitlenumber(String titlenumber) {
        this.titlenumber = titlenumber;
    }

    public void setTitlestrik(String titlestrik) {
        this.titlestrik = titlestrik;
    }

    public void setImageUrl(int imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getTitlesixteen() {
        return titlesixteen;
    }

    public String getTitletext() {
        return titletext;
    }

    public String getTitlenumber() {
        return titlenumber;
    }

    public String getTitlestrik() {
        return titlestrik;
    }

    public int getImageUrl() {
        return imageUrl;
    }

}
