package com.astroexpress.astromarket.model;

import com.astroexpress.astromarket.R;

import java.io.Serializable;

public class BannerModel1 implements Serializable {
    int img;


    public BannerModel1(int tCard1) {
        this.img=tCard1;
    }

    public int getImg() {
        return img;
    }
    public void setImg(int img) {
        this.img = img;
    }
}
