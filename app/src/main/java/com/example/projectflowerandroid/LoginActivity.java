package com.example.projectflowerandroid;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import android.os.Bundle;

public class LoginActivity extends AppCompatActivity {
    Button btn_lregister, btn_llogin;
    EditText et_lusername, et_lpassword;

    //DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //databaseHelper = new DatabaseHelper(this);

        et_lusername = (EditText)findViewById(R.id.et_lusername);
        et_lpassword = (EditText)findViewById(R.id.et_lpassword);

        btn_llogin = (Button)findViewById(R.id.btn_llogin);
        btn_lregister = (Button)findViewById(R.id.btn_lregister);

        btn_lregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        btn_llogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = et_lusername.getText().toString();
                String password = et_lpassword.getText().toString();

                //Boolean checklogin = databaseHelper.CheckLogin(username, password);
                if(username.equals("admin") && password.equals("password")){
                    Log.d("MAIN_ACTIVITY", "PASSWORD IS CORRECT");
                    moveToLoginActivity(username);
                    Toast.makeText(LoginActivity.this, "Password is correct", Toast.LENGTH_SHORT).show();
                }else{
                    Log.d("MAIN_ACTIVITY", "PASSWORD IS FALSE");
                    Toast.makeText(LoginActivity.this, "Password is false", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void moveToLoginActivity(String username){
        Intent intent = new Intent(this, LoginResultActivity.class);

        Bundle extras = new Bundle();
        extras.putString("username", username);

        intent.putExtras(extras);

        startActivity(intent);
    }
}