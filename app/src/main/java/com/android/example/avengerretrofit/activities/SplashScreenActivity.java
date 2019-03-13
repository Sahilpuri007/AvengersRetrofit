package com.android.example.avengerretrofit.activities;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.android.example.avengerretrofit.R;

public class SplashScreenActivity extends AppCompatActivity {


    public static final long SPLASH_TIME= 5000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);



        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreenActivity.this,ShowActivity.class);
                startActivity(intent);
                finish();
            }
        },SPLASH_TIME);
    }
}
