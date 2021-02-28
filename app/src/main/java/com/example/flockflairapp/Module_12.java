package com.example.flockflairapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Module_12 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_module_12);

        Button button_1 = (Button) findViewById(R.id.module_1);
        button_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openChapter_Module_1();

            }
        });

        Button button_2 = (Button) findViewById(R.id.module_2);
        button_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openChapter_Module_2();

            }
        });

        Button button_3 = (Button) findViewById(R.id.module_3);
        button_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openChapter_Module_3();

            }
        });

        Button button_4 = (Button) findViewById(R.id.module_4);
        button_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openChapter_Module_4();

            }
        });

        Button button_5 = (Button) findViewById(R.id.module_5);
        button_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openChapter_Module_5();

            }
        });

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.home);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId())
                {
                    case R.id.dashboard:
                        startActivity(new Intent(getApplicationContext(),BookmarkActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.about:
                        startActivity(new Intent(getApplicationContext(),About.class));
                        overridePendingTransition(0,0);
                        return true;
                }return false;

            }
        });

    }

    public void openChapter_Module_1(){
        Intent intent = new Intent(this, Chapter_Module_1_12.class);
        startActivity(intent);
    }
    public void openChapter_Module_2(){
        Intent intent = new Intent(this, Chapter_Module_2_12.class);
        startActivity(intent);
    }
    public void openChapter_Module_3(){
        Intent intent = new Intent(this, Chapter_Module_3_12.class);
        startActivity(intent);
    }
    public void openChapter_Module_4(){
        Intent intent = new Intent(this, Chapter_Module_4_12.class);
        startActivity(intent);
    }
    public void openChapter_Module_5() {
        Intent intent = new Intent(this, Chapter_Module_5_12.class);
        startActivity(intent);
    }
}