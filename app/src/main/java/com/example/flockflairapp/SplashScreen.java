package com.example.flockflairapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashScreen extends AppCompatActivity {

    public static int SPLASH_SCREEN = 3000;

    //variables
    Animation topAnim,bottomAnim;
    ImageView image;
    TextView logo;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_screen);
        //Animations

        //topAnim= AnimationUtils.loadAnimation(this,R.anim.top_animation);
        //bottomAnim= AnimationUtils.loadAnimation(this,R.anim.bottom_animation);

        //Hooks
        image = findViewById(R.id.logomain);
        logo = findViewById(R.id.appname);

        //image.setAnimation(topAnim);
        //logo.setAnimation(bottomAnim);

        Intent intent = new Intent(getApplicationContext(),phonenumber.class);
        startActivity(intent);
        finish();






    }
}
