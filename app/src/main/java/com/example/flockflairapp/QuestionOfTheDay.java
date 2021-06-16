package com.example.flockflairapp;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class QuestionOfTheDay extends AppCompatActivity {

    private static final String TAG = "QuestionOfTheDay";
    private TextView difficulty, tvQuestions;
    private LinearLayout linearLayout;
    private Button explanation_btn;
    //list of question
    private List<QuestionModel> list = new ArrayList<>();
    int count = 0;
    //random number for question
    Random rand = new Random();
    int position= 0;//rand.nextInt(20-2)+2;

    //instance of firebase
    FirebaseDatabase db = FirebaseDatabase.getInstance();
    DatabaseReference dbRef = db.getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_of_the_day);

        tvQuestions = findViewById(R.id.tvQuestions);
        linearLayout = findViewById(R.id.linearLayout);
        difficulty = findViewById(R.id.difficulty);
        explanation_btn = findViewById(R.id.buttonExplain);

        int STD11 = getIntent().getIntExtra("STD11", 0);

        if (STD11 == 11){
            dbRef.child("QuestionOfTheDay").child("11").child("questions").addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                    for (DataSnapshot dataSnapshot:snapshot.getChildren()){
                        list.add(dataSnapshot.getValue(QuestionModel.class));
                    }
                    tvQuestions.setText(list.get(position).getQuestion());
                    difficulty.setText(list.get(position).getDifficulty());
                    explanation_btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            DisplayQuestions.showAboutDialog(QuestionOfTheDay.this, list, position);
                        }
                    });
                }

                @Override
                public void onCancelled(@NonNull @NotNull DatabaseError error) {
                    Log.d(TAG, "onCancelled: error "+error.getDetails());
                }
            });
        }else {
            dbRef.child("QuestionOfTheDay").child("12").child("questions").addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                    for (DataSnapshot dataSnapshot:snapshot.getChildren()){
                        list.add(dataSnapshot.getValue(QuestionModel.class));
                    }
                    tvQuestions.setText(list.get(position).getQuestion());
                    difficulty.setText(list.get(position).getDifficulty());
                    explanation_btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            DisplayQuestions.showAboutDialog(QuestionOfTheDay.this, list, position);
                        }
                    });
                }
                @Override
                public void onCancelled(@NonNull @NotNull DatabaseError error) {
                    Log.d(TAG, "onCancelled: error "+error.getDetails());
                }
            });
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        /*ActivityManager am = (ActivityManager)getSystemService(Context.ACTIVITY_SERVICE);
        if(am != null) {
            List<ActivityManager.AppTask> tasks = am.getAppTasks();
            if (tasks != null && tasks.size() > 0) {
                tasks.get(0).setExcludeFromRecents(true);
            }
        }*/
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);

    }
}