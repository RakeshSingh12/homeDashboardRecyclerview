package com.example.myapplication.model;

/**
 * This class is a model for a dashboard item content.
 */
public class HomeDashboardItem {
    private int logo;
    private String title;
    private String url;

    public HomeDashboardItem(int logo, String title, String url) {
        this.logo = logo;
        this.title = title;
        this.url = url;
    }

    public int getLogo() {
        return logo;
    }

    public void setLogo(int logo) {
        this.logo = logo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
