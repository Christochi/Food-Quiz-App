package com.example.android.foodquiz;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Splash1Activity extends AppCompatActivity {

    // Field variable for splash screen 2
    private static int SPLASH_TIME_OUT2 = 4000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash1);

        // splash screen 2 handler
        new Handler().postDelayed(new Runnable()
        {
            @Override
            public void run()
            {
                Intent homeIntent2 = new Intent(Splash1Activity.this, Quiz1Activity.class);
                startActivity(homeIntent2);
                finish();
            }
        },SPLASH_TIME_OUT2);

    }
}
