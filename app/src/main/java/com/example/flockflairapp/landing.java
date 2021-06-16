package com.example.flockflairapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class landing extends AppCompatActivity {

    ImageView back;
    ImageView subchapterimage;
    TextView subchaptername;
    TextView subchapterdesc;
    Button startquiz;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);
        back = (ImageView)findViewById(R.id.landingback);
        subchaptername=(TextView)findViewById(R.id.subchaptername);
        subchapterimage=(ImageView)findViewById(R.id.subchapterimage);
        subchapterdesc=(TextView)findViewById(R.id.subchapterdescription);
        subchapterdesc.setMovementMethod(new ScrollingMovementMethod());
        startquiz=(Button)findViewById(R.id.startquiz);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

       Bundle extras;
       extras = getIntent().getExtras();
       String chap1 = extras.getString("sub_chap_name");
       String chapd1 = extras.getString("sub_chap_desc");
       int chapimg1 = extras.getInt("sub_chap_img");
       subchaptername.setText(chap1);
       subchapterdesc.setText(chapd1);
       subchapterimage.setImageResource(chapimg1);

        startquiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //String subChapName = "What is living";
                Intent i1 = new Intent(getApplicationContext(),DisplayQuestions.class);
                i1.putExtra("subChapName", chap1);
                startActivity(i1);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

            }
        });

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.about);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.dashboard:
                        startActivity(new Intent(getApplicationContext(), BookmarkActivity.class));
                        overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
                        return true;
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
                        return true;

                    case R.id.about:
                        startActivity(new Intent(getApplicationContext(),UpdateProfile.class));
                        overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
                        return true;

                }
                return false;

            }

        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);

    }
}