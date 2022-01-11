package com.example.projectflowerandroid;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import android.os.Bundle;

public class NavigationHomeActivity extends NavigationTemplateActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_home);

        BottomNavigationView bnv = findViewById(R.id.bottom_navigation);
        bnv.setSelectedItemId(R.id.home_page);

    }
}