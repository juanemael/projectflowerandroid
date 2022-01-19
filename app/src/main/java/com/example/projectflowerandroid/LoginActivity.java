package com.example.projectflowerandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import android.os.Bundle;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkError;
import com.android.volley.NoConnectionError;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity {
    Button btn_lregister, btn_llogin;
    EditText et_lusername, et_lpassword;
    SharedPreferences sp;
    ArrayList<UserModel> userModels = new ArrayList<>();

    //DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        sp = getSharedPreferences("userData", Context.MODE_PRIVATE);

        //databaseHelper = new DatabaseHelper(this);

        et_lusername = (EditText)findViewById(R.id.et_lusername);
        et_lpassword = (EditText)findViewById(R.id.et_lpassword);

        btn_llogin = (Button)findViewById(R.id.btn_llogin);
        btn_lregister = (Button)findViewById(R.id.btn_lregister);

        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "http://192.168.0.54:3000/api/login_user";

        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>(){

            @Override
            public void onResponse(String response) {
                Log.d("RESULT", response);

                try {
                    JSONArray userLoginJSONArray = new JSONArray(response);
                    for (int i = 0; i < userLoginJSONArray.length(); i++) {
                        JSONObject userDataJSONObject = userLoginJSONArray.getJSONObject((i));
                        UserModel userModel = new UserModel(
                                userDataJSONObject.getString("username"),
                                userDataJSONObject.getString("email"),
                                userDataJSONObject.getString("password"),
                                userDataJSONObject.getString("phone")
                        );
                        userModels.add(userModel);
                    }
                } catch (JSONException e){
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("TAG", "Failed with error msg:\t" + error.getMessage());
                Log.e("TAG", "Error StackTrace: \t" + error.getStackTrace());
                // edited here"
                try {
                    byte[] htmlBodyBytes = error.networkResponse.data;
                    Log.e("TAG", new String(htmlBodyBytes), error);
                } catch (NullPointerException e) {
                    e.printStackTrace();
                }
                if (error.getMessage() == null){
//                            createUser();

                }
            }
        });
        queue.add(stringRequest);


        btn_lregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, MainActivity2.class);
                startActivity(intent);
            }
        });


        btn_llogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = et_lusername.getText().toString();
                String password = et_lpassword.getText().toString();
                SharedPreferences.Editor editor = sp.edit();

                for (UserModel um: userModels) {
                    if(username.equals(um.getUsername()) && password.equals(um.getPassword())){
                        Log.d("MAIN_ACTIVITY", "PASSWORD IS CORRECT");
                        editor.putString("username", um.getUsername());
                        editor.putString("email", um.getEmail());
                        editor.putString("phone", um.getPhone());
                        moveToLoginActivity(username);
                        Toast.makeText(LoginActivity.this, "Password is correct", Toast.LENGTH_SHORT).show();
                        finish();
                        break;
                    }else{
//                        Log.d("MAIN_ACTIVITY", "PASSWORD IS FALSE");
//                        Toast.makeText(LoginActivity.this, "Password is false", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }

    private void moveToLoginActivity(String username){
        Intent intent = new Intent(this, MainActivity2.class);

        startActivity(intent);
    }
}