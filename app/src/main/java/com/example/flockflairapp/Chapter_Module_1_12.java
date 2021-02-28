package com.example.flockflairapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class Chapter_Module_1_12 extends AppCompatActivity {

    private Button module1, module2,module3,module4,module5;
    FirebaseDatabase db = FirebaseDatabase.getInstance();
    private DatabaseReference database = db.getReference("HSC");
    private List list = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter__module_1_12);

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

        database.child("Diversity In The Living World").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
               //change child and reterive name of value
                for (DataSnapshot ds: snapshot.getChildren()) {
                    list.add(ds.getValue(String.class));
                }
                    module1.setText(list.get(0).toString());
                    module2.setText(list.get(1).toString());
                    module3.setText(list.get(2).toString());
                    module4.setText(list.get(3).toString());
                    module5.setText(list.get(4).toString());
                }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        //chapter module button
        module1 = findViewById(R.id.module_1);
        module2 = findViewById(R.id.module_2);
        module3 = findViewById(R.id.module_3);
        module4 = findViewById(R.id.module_4);
        module5 = findViewById(R.id.module_5);

        //to display question activity
        module1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent module1Intent = new Intent(Chapter_Module_1_12.this, DisplayQuestions.class);
                module1Intent.putExtra("setNo", "Module1");
                startActivity(module1Intent);
            }
        });
    }
}