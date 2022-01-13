package com.example.projectflowerandroid;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public abstract class NavigationTemplateActivity extends AppCompatActivity {

    @Override
    protected void onResume() {
        super.onResume();

        BottomNavigationView bnv = findViewById(R.id.bottom_navigation);
        bnv.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();

                switch (id){
                    case R.id.home_page:
                        Intent i = new Intent(NavigationTemplateActivity.this, MainActivity2.class);
                        startActivity(i);
                        NavigationTemplateActivity.this.finish();
                        overridePendingTransition(0, 0);
                        break;
                    case R.id.shop_page:
                        Intent i2 = new Intent(NavigationTemplateActivity.this, LocationDataActivity.class);
                        startActivity(i2);
                        NavigationTemplateActivity.this.finish();
                        overridePendingTransition(0, 0);
                        break;
                    case R.id.explore_page:
                        Intent i3 = new Intent(NavigationTemplateActivity.this, LocationDataActivity.class);
                        startActivity(i3);
                        NavigationTemplateActivity.this.finish();
                        overridePendingTransition(0, 0);
                        break;
                    case R.id.profile_page:
                        Intent i4 = new Intent(NavigationTemplateActivity.this, LocationDataActivity.class);
                        startActivity(i4);
                        NavigationTemplateActivity.this.finish();
                        overridePendingTransition(0, 0);
                        break;
                }

//                Toast.makeText(NavigationTemplateActivity.this, "id " + id, Toast.LENGTH_SHORT).show();
                return true;
            }
        });

    }
}