package com.example.lastversion;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class profile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        //initializ

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        //set home selected

        bottomNavigationView.setSelectedItemId(R.id.profile);


        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {


                switch (menuItem.getItemId()){

                    case R.id.dashbord:

                        startActivity(new Intent(getApplicationContext(),dashboard.class));
                        overridePendingTransition(0,0);
                        return  true;

                    case R.id.profile:
                        return  true;

                    case R.id.About:
                        startActivity(new Intent(getApplicationContext(),About.class));
                        overridePendingTransition(0,0);
                        return  true;
                }

                return false;
            }
        });


    }
}
