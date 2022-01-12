package com.example.projectflowerandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.widget.TextView;

public class LoginResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_result);

        Intent originalIntent = getIntent();
        Bundle params = originalIntent.getExtras();
        if(params != null){
            TextView helloText = findViewById(R.id.activity_login_result_hello_text);
            String string = "Hello " + params.getString("username");
            helloText.setText(string);
        }
    }
}