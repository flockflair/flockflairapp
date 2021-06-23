package com.eosphorus.flockflairapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class listviewimg extends AppCompatActivity {

    ListView lvProgram;
    ImageView backbutton;
    TextView name1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listviewimg);
        name1 = findViewById(R.id.name_sub);
        backbutton = (ImageView)findViewById(R.id.backbuttonimglist);
        backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
            }
        });
        Intent intent = getIntent();
        overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
        String[] subchaptername = intent.getStringArrayExtra("subchaptername");
        int[] subchapImages = intent.getIntArrayExtra("subchapImages");
        String name = intent.getStringExtra("name"); //get text from put intent
        name1.setText(name);

        lvProgram = findViewById(R.id.lvProgram);
        ProgramAdapter programAdapter = new ProgramAdapter(this, subchaptername,subchapImages); //set image and sub chap name
        lvProgram.setAdapter(programAdapter);



        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.home);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId())
                {
                    case R.id.dashboard:
                        startActivity(new Intent(getApplicationContext(),BookmarkActivity.class));
                        overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
                        return true;
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
                        return true;
                    case R.id.about:
                        startActivity(new Intent(getApplicationContext(),UpdateProfile.class));
                        overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
                        return true;
                }return false;

            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);

    }
}