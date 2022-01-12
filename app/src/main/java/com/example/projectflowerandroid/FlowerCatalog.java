package com.example.projectflowerandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class FlowerCatalog extends AppCompatActivity {
    private String id="";
    private String name="";
    private String image="";
    private String price="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flower_catalog);
    }

    public FlowerCatalog (String id, String name, String image, String price) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.price = price;
    }

    private FlowerCatalog() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}