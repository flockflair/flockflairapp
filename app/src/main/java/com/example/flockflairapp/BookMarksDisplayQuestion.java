package com.example.flockflairapp;

import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class BookMarksDisplayQuestion extends AppCompatActivity {

    LinearLayout linearLayout;
    TextView tvQuestions, difficulty;
    Button optionA,optionB,optionC,optionD,explain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_marks_display_question);

        linearLayout = findViewById(R.id.linearLayoutB);
        explain = findViewById(R.id.buttonExplainInB);
        tvQuestions = findViewById(R.id.tvQuestionsInB);
        difficulty = findViewById(R.id.difficultyInB);

        optionA = findViewById(R.id.buttonOption1A);
        optionB = findViewById(R.id.buttonOption2B);
        optionC = findViewById(R.id.buttonOption3C);
        optionD = findViewById(R.id.buttonOption4D);


        //animation
        fade(difficulty);
        fade(tvQuestions);
        fadeBtn(optionA);
        CorrectAnswer();
        explainButton();
    }

    public void fade(View view ){
        String DDpos = getIntent().getStringExtra("DDpos");
        String Qpos = getIntent().getStringExtra("Qpos");
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade);
        difficulty.startAnimation(animation);
        tvQuestions.startAnimation(animation);
        difficulty.setText(DDpos);
        tvQuestions.setText(Qpos);
    }

    public void fadeBtn(View view){
        //buttons
        String OApos = getIntent().getStringExtra("OApos");
        String OBpos = getIntent().getStringExtra("OBpos");
        String OCpos = getIntent().getStringExtra("OCpos");
        String ODpos = getIntent().getStringExtra("ODpos");

        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade);

        optionA.startAnimation(animation);
        optionB.startAnimation(animation);
        optionC.startAnimation(animation);
        optionD.startAnimation(animation);
        explain.startAnimation(animation);

        optionA.setText(OApos);
        optionB.setText(OBpos);
        optionC.setText(OCpos);
        optionD.setText(ODpos);
    }

    public void CorrectAnswer(){
        String CApos = getIntent().getStringExtra("CApos");
        String OApos = getIntent().getStringExtra("OApos");
        String OBpos = getIntent().getStringExtra("OBpos");
        String OCpos = getIntent().getStringExtra("OCpos");
        String ODpos = getIntent().getStringExtra("ODpos");

        if (OApos.equalsIgnoreCase(CApos)){
            optionA.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2ecc71")));
            //optionA.setTextColor(ColorStateList.valueOf(Color.parseColor("#FFFFFF")));
        }else if (OBpos.equalsIgnoreCase(CApos)){
            optionB.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2ecc71")));
            //optionB.setTextColor(ColorStateList.valueOf(Color.parseColor("#FFFFFF")));
        }else if (OCpos.equalsIgnoreCase(CApos)){
            optionC.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2ecc71")));
            //optionC.setTextColor(ColorStateList.valueOf(Color.parseColor("#FFFFFF")));
        }else if (ODpos.equalsIgnoreCase(CApos)){
            optionD.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2ecc71")));
            //optionD.setTextColor(ColorStateList.valueOf(Color.parseColor("#FFFFFF")));
        }
    }

    public void explainButton(){
        String Expos = getIntent().getStringExtra("Expos");
        explain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(BookMarksDisplayQuestion.this);
                builder.setTitle("Explanation");
                builder.setMessage(Expos);
                //builder.setView(R.layout.explain);
                builder.setNegativeButton("Close", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // dismiss dialog
                        dialogInterface.dismiss();
                    }
                });
                builder.show();
            }
        });
    }
}