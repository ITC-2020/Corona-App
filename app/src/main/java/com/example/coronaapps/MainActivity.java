package com.example.coronaapps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.coronaapps.detail.DetailCountry;
import com.example.coronaapps.detail.DetailCountryIndo;

public class MainActivity extends AppCompatActivity {

    private static int SPLASH_SCREEN = 4000;

    Animation topAnim, botAnim;
    ImageView image;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        topAnim = AnimationUtils.loadAnimation(this, R.anim.top_animation);
        botAnim = AnimationUtils.loadAnimation(this, R.anim.bot_animation);

        image = findViewById(R.id.imageView);
        textView = findViewById(R.id.textView);

        image.setAnimation(topAnim);
        textView.setAnimation(botAnim);


        new Handler().postDelayed(new Runnable() {
            @Override
                public void run() {
                    Intent splash = new Intent(getApplication(),MainActivity2.class);
                    startActivity(splash);
                    finish();
            }
        }, SPLASH_SCREEN);

    }
}
