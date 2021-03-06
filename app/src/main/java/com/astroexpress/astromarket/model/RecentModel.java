package com.astroexpress.astromarket.model;

public class RecentModel {
    private String product_offers;
    private int product_images;
    private String product_name;
    private String product_price;
    private String product_discount;

    public RecentModel(String product_offers, int product_images, String product_name, String product_price, String product_discount) {
        this.product_offers = product_offers;
        this.product_images = product_images;
        this.product_name = product_name;
        this.product_price = product_price;
        this.product_discount = product_discount;
    }


    public void setProduct_offers(String product_offers){
        this.product_offers = product_offers;
    }

    public void setProduct_images(int product_images) {
        this.product_images = product_images;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public void setProduct_price(String product_price) {
        this.product_price = product_price;
    }

    public void setProduct_discount(String product_discount) {
        this.product_discount = product_discount;
    }

    public String getProduct_price() {
        return product_price;
    }

    public String getProduct_offers() {
        return product_offers;
    }

    public int getProduct_images() {
        return product_images;
    }

    public String getProduct_name() {
        return product_name;
    }

    public String getProduct_discount() {
        return product_discount;
    }
}