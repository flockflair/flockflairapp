package com.example.flockflairapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.graphics.Matrix;

public class SplashScreen extends AppCompatActivity {

    public static int SPLASH_SCREEN = 3000;
    //variables
    //Animation topAnim,bottomAnim;
    ImageView physics , bacteria , testube ,dna , injection , logo;
    TextView name;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
        setContentView(R.layout.activity_splash_screen);
        //Animations

        //topAnim= AnimationUtils.loadAnimation(this,R.anim.top_animation);
        //bottomAnim= AnimationUtils.loadAnimation(this,R.anim.bottom_animation);

        //Hooks
        physics = findViewById(R.id.physics);
        bacteria = findViewById(R.id.bacteria2);
        testube = findViewById(R.id.testube);
        dna = findViewById(R.id.dna);
        injection = findViewById(R.id.injection);
        name = findViewById(R.id.appname);
        logo = findViewById(R.id.logo);






        //image = findViewById(R.id.logomain);
        //logo = findViewById(R.id.appname);

        //image.setAnimation(topAnim);
        //logo.setAnimation(bottomAnim);

       new Handler().postDelayed(new Runnable() {
           @Override
           public void run() {
               Intent intent=new Intent(SplashScreen.this,phonenumber.class);
               startActivity(intent);
               finish();
           }
       },SPLASH_SCREEN);






    }
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            getWindow().getDecorView().setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);

    }
}
