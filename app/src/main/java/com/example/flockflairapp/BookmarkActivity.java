package com.example.flockflairapp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class BookmarkActivity extends AppCompatActivity implements View.OnLongClickListener {

    boolean isActionMode = false;
    private Toolbar toolbar;
    private TextView text_toolbar,text_title;
    private RecyclerView rv_bookmark;
    RecyclerView.Adapter adapter;
    private TextView noBookmarksTv;
    List<QuestionModel> list;
    List<QuestionModel> selectionList = new ArrayList<>();
    int counter = 0;
    private String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();

    FirebaseDatabase db = FirebaseDatabase.getInstance();
    DatabaseReference dbR = db.getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookmark);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        //prevent screenCapture
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE,WindowManager.LayoutParams.FLAG_SECURE);

        rv_bookmark = findViewById(R.id.rv_bookmarks);
        noBookmarksTv = findViewById(R.id.noBookmarks);

        rv_bookmark.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setReverseLayout(true);
        layoutManager.setStackFromEnd(true);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        rv_bookmark.setLayoutManager(layoutManager);

        text_toolbar = findViewById(R.id.text_toolbar);
        text_toolbar.setVisibility(View.GONE);
        text_title = findViewById(R.id.text_title);
        text_title.setVisibility(View.VISIBLE);

        list = new ArrayList<>();

        adapter = new BookmarkAdapter(list,BookmarkActivity.this);
        rv_bookmark.setAdapter(adapter);

        dbR.child("user").child(uid).child("Bookmarks").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot:snapshot.getChildren()) {
                    list.add(dataSnapshot.getValue(QuestionModel.class));
                    dbR.keepSynced(true);
                }
                if (list.size()>0){
                    adapter.notifyDataSetChanged();
                }else {
                    noBookmarksTv.setText("No bookmarks found");
                    noBookmarksTv.setVisibility(View.VISIBLE);
                    Toast.makeText(BookmarkActivity.this,"No Bookmarks",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(BookmarkActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                finish();
            }
        });

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.about);
        bottomNavigationView.setOnNavigationItemSelectedListener(menuItem -> {
            switch (menuItem.getItemId()) {
                case R.id.dashboard:
                    startActivity(new Intent(getApplicationContext(), BookmarkActivity.class));
                    overridePendingTransition(0, 0);
                    return true;
                case R.id.home:
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                    overridePendingTransition(0, 0);
                    return true;

                case R.id.about:
                    startActivity(new Intent(getApplicationContext(), About.class));
                    overridePendingTransition(0, 0);
                    return true;
            }
            return false;
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_activity_bookmark, menu);
        return true;
    }

    @Override
    public boolean onLongClick(View view) {
        toolbar.getMenu().clear();
        text_title.setVisibility(View.GONE);
        toolbar.inflateMenu(R.menu.menu_action_mode);
        text_toolbar.setVisibility(View.VISIBLE);
        isActionMode = true;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        adapter.notifyDataSetChanged();
        return true;
    }

    public void prepareSelection(View view, int position){
        if (((CheckBox)view).isChecked()){
            selectionList.add(list.get(position));
            counter++;
            updateCounter(counter);
        }
        else{
            selectionList.remove(list.get(position));
            counter--;
            updateCounter(counter);
        }
    }

    public void updateCounter(int counter){
        if (counter==0){
            text_toolbar.setText("0 item selected");
        }
        else{
           text_toolbar.setText(counter+" itmes selected");
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.item_delete) {
            if (selectionList.isEmpty()){
                Toast.makeText(BookmarkActivity.this, "No bookmark selected",Toast.LENGTH_SHORT).show();
            }else{
                AlertDialog.Builder builder = new AlertDialog.Builder(BookmarkActivity.this);
                builder.setTitle("you are deleting "+counter +" Bookmark?");
                builder.setPositiveButton("Yes", (dialog, which) -> {
                    Toast.makeText(getApplicationContext(), counter+" Bookmark deleted", Toast.LENGTH_LONG).show();
                    BookmarkAdapter BookmarkAdapter = (BookmarkAdapter) adapter;
                    BookmarkAdapter.updateAdapter((ArrayList<QuestionModel>) selectionList);
                    clearActionMode();
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        isActionMode = false;
                    }
                });
                builder.show();
            }
        }
        else if (item.getItemId()==android.R.id.home){
            clearActionMode();
            updateCounter(0);
            adapter.notifyDataSetChanged();
        }
        else if (item.getItemId()==R.id.item_selectAll){
            selectAll_or_unSelectALL();
        }
        else if (item.getItemId()==R.id.item_search){
            Toast.makeText(BookmarkActivity.this, item+" clicked",Toast.LENGTH_SHORT).show();
        }
        return true;
    }

    public void clearActionMode(){
        isActionMode = false;
        toolbar.getMenu().clear();
        toolbar.inflateMenu(R.menu.menu_activity_bookmark);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        text_toolbar.setVisibility(View.GONE);
        text_title.setVisibility(View.VISIBLE);
        counter = 0;
        selectionList.clear();
    }

    @Override
    public void onBackPressed() {
        if (isActionMode){
            clearActionMode();
            adapter.notifyDataSetChanged();
        }else{
            super.onBackPressed();
            finish();
        }
    }
    //selectAll bookmarks or unselectAll bookmarks
    public void selectAll_or_unSelectALL(){
        if (selectionList.isEmpty()){
            selectionList.clear();
            counter=0;
            for (int i = 0; i<list.size();i++){
                //checkbox bug
                selectionList.add(list.get(i));
                counter++;
                updateCounter(counter);
                adapter.notifyDataSetChanged();
            }
        }else{
            selectionList.clear();
            for (int j = 0; j < list.size();j++){
                selectionList.remove(list.get(j));
                counter--;
                updateCounter(0);
                adapter.notifyDataSetChanged();
            }
        }
    }
}