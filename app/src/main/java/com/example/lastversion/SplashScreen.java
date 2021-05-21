package com.example.lastversion;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.lastversion.R;

public class SplashScreen extends AppCompatActivity {
    TextView text;
    Animation anime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        text =  (TextView) findViewById(R.id.text);
        anime = AnimationUtils.loadAnimation (this,R.anim.fade_in);
        text.setAnimation(anime);


        new Handler().postDelayed(new Runnable() {


            @Override

            public void run() {
                Intent i = new Intent(SplashScreen.this, LoginActivity.class);
                startActivity(i);
                finish();
            }
        }, 3000);
    }
}
