package com.example.flockflairapp;

import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class BookmarkActivity extends AppCompatActivity {

    private RecyclerView rv_bookmark;
    private String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();

    FirebaseDatabase db = FirebaseDatabase.getInstance();
    DatabaseReference dbR = db.getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookmark);

        //prevent screenCapture
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE,WindowManager.LayoutParams.FLAG_SECURE);

        rv_bookmark = findViewById(R.id.rv_bookmarks);

        rv_bookmark.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setReverseLayout(true);
        layoutManager.setStackFromEnd(true);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        rv_bookmark.setLayoutManager(layoutManager);

        List<QuestionModel> list = new ArrayList<>();
        BookmarkAdapter adapter = new BookmarkAdapter(list);
        rv_bookmark.setAdapter(adapter);

        dbR.child("user").child(uid).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot:snapshot.getChildren()) {
                    if (snapshot.exists()){
                        list.add(dataSnapshot.getValue(QuestionModel.class));
                        dbR.keepSynced(true);
                    }
                }
                if (list.size()>0){
                    adapter.notifyDataSetChanged();
                }else {
                    Toast.makeText(BookmarkActivity.this,"No Bookmarks",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(BookmarkActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                finish();
            }
        });

    }
}