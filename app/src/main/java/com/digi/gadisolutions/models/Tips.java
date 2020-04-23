package com.digi.gadisolutions.models;

import java.io.Serializable;

public class Tips implements Serializable {
    private int id;
    private String tips_title;
    private String tips;
    private String image;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTips_title() {
        return tips_title;
    }

    public void setTips_title(String tips_title) {
        this.tips_title = tips_title;
    }

    public String getTips() {
        return tips;
    }

    public void setTips(String tips) {
        this.tips = tips;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [id = "+id+", tips_title = "+tips_title+ ",tips = "+tips+ ",image = "+image+"]";
    }
}
