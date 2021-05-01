package com.example.flockflairapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

public class listviewimg extends AppCompatActivity {

    ListView lvProgram;
    String[] subchaptername = {"Introduction","Kingdom Monera","Kingdom Protista","Kingdom Fungi","Kingdom Plantae and Kingdom Animalia",
            "Virus, viroids, prions, lichens"};
    int[] subchapImages = {R.drawable.flaskone,R.drawable.flaskone,R.drawable.flaskone,R.drawable.flaskone,R.drawable.flaskone,R.drawable.flaskone,R.drawable.flaskone};
    //Intent intent = getIntent();
    //String[] subchaptername = intent.getStringArrayExtra("array2");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listviewimg);
        lvProgram = findViewById(R.id.lvProgram);
        ProgramAdapter programAdapter = new ProgramAdapter(this, subchaptername,subchapImages);
        lvProgram.setAdapter(programAdapter);
    }
}