package com.example.flockflairapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Chapter_Module_1_11 extends AppCompatActivity {

    private static final String TAG = "ChapterName";
    FirebaseDatabase db = FirebaseDatabase.getInstance();
    private DatabaseReference database = db.getReference("FlockFlair");
    private List list = new ArrayList();

    private Button module1, module2,module3,module4,module5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter__module_1_11);

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

        database.child("course-11").child("modules").child("Diversity In The Living World").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                //change child and reterive name of value
                for (DataSnapshot ds: snapshot.getChildren()) {
                    list.add(ds.getKey());
                }
                module1.setText(list.get(0).toString());
                module2.setText(list.get(1).toString());
                module3.setText(list.get(2).toString());
                module4.setText(list.get(3).toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.d(TAG,error.getMessage());
            }
        });

        //chapter module button
        module1 = findViewById(R.id.module_1);
        module2 = findViewById(R.id.module_2);
        module3 = findViewById(R.id.module_3);
        module4 = findViewById(R.id.module_4);
        module5 = findViewById(R.id.module_5);

        module1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent newIntent = new Intent(Chapter_Module_1_11.this,DisplayQuestions.class);
                newIntent.putExtra("module1", "Diversity In The Living World");
                startActivity(newIntent);
            }
        });
    }
}