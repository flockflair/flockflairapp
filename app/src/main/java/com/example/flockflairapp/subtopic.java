package com.example.flockflairapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class subtopic extends AppCompatActivity {

    ListView listView;
    String[] subtopics = {"What is living?","Diversity in the living","Taxonomic categories","Taxonomic Aids"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subtopic);
        listView = findViewById(R.id.list);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(subtopic.this , android.R.layout.simple_dropdown_item_1line,subtopics);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(subtopic.this,"Selected " + subtopics[position] , Toast.LENGTH_SHORT).show();

                if(position==0)
                {
                    Intent intent = new Intent(getApplicationContext(), DisplayQuestions.class);
                    intent.putExtra("chapter1", 1);
                    startActivity(intent);
                }


            }
        });


    }
}