package com.example.lastversion;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.LinearLayoutCompat;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import  org.json.JSONObject;
import  org.json.JSONException;
import  org.json.JSONArray;


import com.example.lastversion.R;

public class LoginActivity extends AppCompatActivity {
LinearLayoutCompat ly_Login;
AppCompatEditText Login_name,Login_Password;

    private Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        register = findViewById(R.id.registerBTN);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, profile.class));
            }
        });


    }
    public void btn_login(View view){
        ly_Login.setVisibility(View.VISIBLE);
    }
    public void Login_btn_login(View view){

        String Log_in_name = Login_name.getText().toString().trim();
        String Log_in_password = Login_Password.getText().toString().trim();
        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try{
                    JSONObject jsonResponse =new JSONObject(response);
                    boolean success = jsonResponse.getBoolean("success");
                    if(success) {
                     Toast.makeText(LoginActivity.this,"تم تسجيل الدخول ", Toast.LENGTH_SHORT).show();
                    ly_Login.setVisibility(View.INVISIBLE);
                    startActivity(new Intent(LoginActivity.this,profile.class));
                }
                else{
                    Toast.makeText(LoginActivity.this,"البيانات غير صحيحة" ,Toast.LENGTH_SHORT).show();
                }
        }catch (JSONException e){
                e.printStackTrace();

                }
            }
    };

 Send_Data_Login send_Data =new Send_Data_Login(Log_in_name,Log_in_password,responseListener);
        RequestQueue queue= Volley.newRequestQueue(LoginActivity.this);
        queue.add(send_Data);
    }

}
