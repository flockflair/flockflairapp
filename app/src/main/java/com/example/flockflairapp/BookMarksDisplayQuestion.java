package com.example.flockflairapp;

import android.animation.Animator;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class BookMarksDisplayQuestion extends AppCompatActivity {

    TextView tvQuestions, difficulty,tvTotal;
    Button explain,next,prev;
    LinearLayout linearLayout;
    int position = 0;

    //instance of firebase
    FirebaseDatabase db = FirebaseDatabase.getInstance();
    DatabaseReference dbRef = db.getReference("user");
    String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();

    List<QuestionModel> bookmarkList = new ArrayList<>();
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_marks_display_question);

        explain = findViewById(R.id.buttonExplainInB);
        tvQuestions = findViewById(R.id.tvQuestionsInB);
        difficulty = findViewById(R.id.difficultyInB);
        tvTotal = findViewById(R.id.BookmarkTotalTv);
        linearLayout = findViewById(R.id.linearLayoutQTD);
        next = findViewById(R.id.btnNext);
        prev = findViewById(R.id.btnPrev);



        /*optionA = findViewById(R.id.buttonOption1A);
        optionB = findViewById(R.id.buttonOption2B);
        optionC = findViewById(R.id.buttonOption3C);
        optionD = findViewById(R.id.buttonOption4D);*/


        dbRef.child(uid).child("Bookmarks").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot:snapshot.getChildren()){
                    bookmarkList.add(dataSnapshot.getValue(QuestionModel.class));
                }
                QuestionLoader();
                /*fade(bookmarkList.get(position).getDifficulty());

                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade);

                tvQuestions.startAnimation(animation);
                optionA.startAnimation(animation);
                optionB.startAnimation(animation);
                optionC.startAnimation(animation);
                optionD.startAnimation(animation);
                explain.startAnimation(animation);

                tvQuestions.setText(bookmarkList.get(position).getQuestion());
                optionA.setText(bookmarkList.get(position).getOptionA());
                optionB.setText(bookmarkList.get(position).getOptionB());
                optionC.setText(bookmarkList.get(position).getOptionC());
                optionD.setText(bookmarkList.get(position).getOptionD());

                tvTotal.setText(position+1+"/"+bookmarkList.size());*/

                /*explain.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        DisplayQuestions.showAboutDialog(BookMarksDisplayQuestion.this, bookmarkList, position);
                    }
                });*/
            }

            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError error) {

            }
        });

        /*//animation
        fade(difficulty);
        fade(tvQuestions);
        fadeBtn(optionA);
        CorrectAnswer();
        explainButton();*/
    }

    /*public void fade(String data ){
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade);
        difficulty.startAnimation(animation);
        difficulty.setText(data);
    }*/


    private void bookMarkAnim(final View view, final  int value, final String data){

        view.animate().alpha(value).scaleX(value).scaleY(value).setDuration(500).setStartDelay(100)
                .setInterpolator(new DecelerateInterpolator()).setListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {
                if (value == 0 && count < 4){
                    String option = ""; //check all option at location count value

                    if (count == 0){
                        option = bookmarkList.get(position).getOptionA();
                    }else if (count == 1){
                        option = bookmarkList.get(position).getOptionB();
                    }
                    else if (count == 2){
                        option = bookmarkList.get(position).getOptionC();
                    }else if (count == 3){
                        option = bookmarkList.get(position).getOptionD();
                    }
                    bookMarkAnim(linearLayout.getChildAt(count),0,option);
                    count++;
                }
            }

            @Override
            public void onAnimationEnd(Animator animator) {
                if (value == 0){
                    try {
                        ((TextView)view).setText(data);
                        tvTotal.setText(position+1+"/"+bookmarkList.size());
                    }catch (ClassCastException e){
                        ((Button)view).setText(data);
                    }
                    view.setTag(data);
                    bookMarkAnim(view, 1, data);
                }
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });
    }

    public void QuestionLoader(){
        int pos = getIntent().getIntExtra("position", 0);
        if (bookmarkList.size()>0){
            for (int i=0;i<4;i++){
                if (bookmarkList.get(position).getCorrectAnswer().equalsIgnoreCase(linearLayout.getChildAt(i).toString())){
                    linearLayout.getChildAt(i).setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2ecc71")));
                }
            }
            //load data first time
            bookMarkAnim(difficulty, 0, bookmarkList.get(pos).getDifficulty());
            bookMarkAnim(tvQuestions, 0, bookmarkList.get(pos).getQuestion());
            explain.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    DisplayQuestions.showAboutDialog(BookMarksDisplayQuestion.this, bookmarkList, position);
                }
            });

            //position value is pass from intent value
            position = pos;

            next.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    position++;
                    if (position==bookmarkList.size()){
                        Toast.makeText(BookMarksDisplayQuestion.this, "No Next Bookmark available", Toast.LENGTH_SHORT).show();
                        position = bookmarkList.size()-1;
                    }else{
                        count=0;
                        bookMarkAnim(difficulty, 0, bookmarkList.get(position).getDifficulty());
                        bookMarkAnim(tvQuestions, 0, bookmarkList.get(position).getQuestion());

                        explain.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                DisplayQuestions.showAboutDialog(BookMarksDisplayQuestion.this, bookmarkList, position);
                            }
                        });
                    }
                }
            });

            prev.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    position--;
                    if (position==-1){
                        Toast.makeText(BookMarksDisplayQuestion.this, "No previous Bookmark available", Toast.LENGTH_SHORT).show();
                        position = 0;
                    }else{
                        count=0;
                        bookMarkAnim(difficulty, 0, bookmarkList.get(position).getDifficulty());
                        bookMarkAnim(tvQuestions, 0, bookmarkList.get(position).getQuestion());

                        explain.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                DisplayQuestions.showAboutDialog(BookMarksDisplayQuestion.this, bookmarkList, position);
                            }
                        });
                    }
                }
            });
        }
    }

    /*public void checkAnswer(final Button selectOption) {
        if (selectOption.getText().toString().equals(bookmarkList.get(position).getCorrectAnswer())){
            //correct Answer
            selectOption.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2ecc71")));

        }else{
            //incorrect Answer
            selectOption.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#e74c3c")));

            Button correctOption = linearLayout.findViewWithTag(bookmarkList.get(position).getCorrectAnswer());
            correctOption.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2ecc71")));
            //correctOption.setTextColor(ColorStateList.valueOf(Color.parseColor("#ffffff")));

        }
    }*/

    
    /*public void fade(View view ){
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
    }*/
}