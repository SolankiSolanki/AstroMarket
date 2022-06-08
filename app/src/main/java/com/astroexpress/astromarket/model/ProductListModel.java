package com.astroexpress.astromarket.model;

public class ProductListModel {
    private String title_order_list;
    private int imageUrl_order_list;
    private String title_16_order_list;
    private String title_strik_order_list;
    private String title_rupee_order_list;

    public ProductListModel(String title_order_list, int imageUrl_order_list, String title_16_order_list, String title_strik_order_list, String title_rupee_order_list) {
        this.title_order_list = title_order_list;
        this.imageUrl_order_list = imageUrl_order_list;
        this.title_16_order_list = title_16_order_list;
        this.title_strik_order_list = title_strik_order_list;
        this.title_rupee_order_list = title_rupee_order_list;
    }

    public String getTitle_strik_order_list() {
        return title_strik_order_list;
    }

    public void setTitle_order_list(String title_order_list) {
        this.title_order_list = title_order_list;
    }

    public void setImageUrl_order_list(int imageUrl_order_list) {
        this.imageUrl_order_list = imageUrl_order_list;
    }

    public void setTitle_16_order_list(String title_16_order_list) {
        this.title_16_order_list = title_16_order_list;
    }

    public void setTitle_rupee_order_list(String title_rupee_order_list) {
        this.title_rupee_order_list = title_rupee_order_list;
    }

    public String getTitle_order_list() {
        return title_order_list;
    }

    public int getImageUrl_order_list() {
        return imageUrl_order_list;
    }

    public String getTitle_16_order_list() {
        return title_16_order_list;
    }

    public String getTitle_rupee_order_list() {
        return title_rupee_order_list;
    }

}
