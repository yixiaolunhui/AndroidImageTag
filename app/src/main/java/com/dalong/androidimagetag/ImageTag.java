package com.dalong.androidimagetag;

/**
 * Created by zhouweilong on 2016/11/4.
 */

public class ImageTag {
    String name;
    String price;
    String imageUrl;
    int tagBg;

    public ImageTag() {
    }

    public int getTagBg() {
        return tagBg;
    }

    public void setTagBg(int tagBg) {
        this.tagBg = tagBg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
