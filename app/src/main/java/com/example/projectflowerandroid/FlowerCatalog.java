package com.example.projectflowerandroid;

//import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class FlowerCatalog {
    private String id="";
    private String title="";
    private String image="";
    private String subtitle="";

    /*@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flower_catalog);
    }*/

    public FlowerCatalog (String id, String title, String image, String subtitle) {
        this.id = id;
        this.title = title;
        this.image = image;
        this.subtitle = subtitle;
    }

    public FlowerCatalog() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }
}