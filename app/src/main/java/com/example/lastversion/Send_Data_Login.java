package com.example.lastversion;

import android.widget.EditText;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

class Send_Data_Login extends StringRequest {
    private static final String SEND_DATA_URL ="";
    private Map<String,String> MapData;



    public Send_Data_Login(String Login_name, String Login_password, Response.Listener<String> listener) {
        super(Method.POST, SEND_DATA_URL, listener, null);
        MapData =new HashMap<>();
        MapData.put("Login_name",Login_name);
        MapData.put("Login_password",Login_password);
    }

    public Send_Data_Login(EditText Login_name, EditText  Login_password, Response.Listener<String> responseListener) {
        super(Method.POST,SEND_DATA_URL, responseListener, null);
    }

    public Map<String,String> getparams(){return MapData;}
}
