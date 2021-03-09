package com.example.flockflairapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class RecyclerActivity extends AppCompatActivity
{
    //main activity
    RecyclerView recyclerView;
    RecyclerAdap adapter;
    //String[] chapternames = {"The Living World","Biological Classification","Plant Kingdom","Animal Kingdom"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);
        getSupportActionBar().hide();

        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        FirebaseRecyclerOptions<model> options = null;


        options = new FirebaseRecyclerOptions.Builder<model>()
                .setQuery(FirebaseDatabase.getInstance().getReference().child("HSC"), model.class)
                .build();
        adapter = new RecyclerAdap(options);
        recyclerView.setAdapter(adapter);

    }
    @Override
    protected void onStart()
    {
        super.onStart();
        adapter.startListening();
    }
    @Override
    protected void onStop()
    {
        super.onStop();
        adapter.stopListening();
    }




}
