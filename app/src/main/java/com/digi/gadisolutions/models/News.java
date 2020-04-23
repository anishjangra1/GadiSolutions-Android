package com.digi.gadisolutions.models;

import java.io.Serializable;

public class News implements Serializable {
    private int id;
    private String news_title;
    private String news;
    private String image;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNews_title() {
        return news_title;
    }

    public void setNews_title(String news_title) {
        this.news_title = news_title;
    }

    public String getNews() {
        return news;
    }

    public void setNews(String news) {
        this.news = news;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [id = "+id+", news_title = "+news_title+ ",news = "+news+ ",image = "+image+"]";
    }
}
