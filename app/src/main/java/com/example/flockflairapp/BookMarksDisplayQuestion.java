package com.example.flockflairapp;

import android.animation.Animator;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
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
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE,WindowManager.LayoutParams.FLAG_SECURE);

        explain = findViewById(R.id.buttonExplainInB);
        tvQuestions = findViewById(R.id.tvQuestionsInB);
        difficulty = findViewById(R.id.difficultyInB);
        tvTotal = findViewById(R.id.BookmarkTotalTv);
        linearLayout = findViewById(R.id.linearLayoutQTD);
        next = findViewById(R.id.btnNext);
        prev = findViewById(R.id.btnPrev);


        dbRef.child(uid).child("Bookmarks").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot:snapshot.getChildren()){
                    bookmarkList.add(dataSnapshot.getValue(QuestionModel.class));
                }
                QuestionLoader();
            }

            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError error) {

            }
        });
    }

    private void bookMarkAnim(final View view, final  int value, final String data){

        view.animate().alpha(value).scaleX(value).scaleY(value).setDuration(500).setStartDelay(100)
                .setInterpolator(new DecelerateInterpolator()).setListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {
                if (value == 0 && count < 4){
                    String option = ""; //check all option at location count value

                    if (count == 0){
                        option = bookmarkList.get(position).getOptionA();
                        if (option.equals(bookmarkList.get(position).getCorrectAnswer())){
                            linearLayout.getChildAt(count).setBackgroundDrawable(getDrawable(R.drawable.rounded_buttons_in_display_questions_correct_answer));
                        }else{
                            linearLayout.getChildAt(count).setBackgroundDrawable(getDrawable(R.drawable.rounded_buttons_in_display_questions));
                        }
                    }else if (count == 1){
                        option = bookmarkList.get(position).getOptionB();
                        if (option.equals(bookmarkList.get(position).getCorrectAnswer())){
                            linearLayout.getChildAt(count).setBackgroundDrawable(getDrawable(R.drawable.rounded_buttons_in_display_questions_correct_answer));
                        }else{
                            linearLayout.getChildAt(count).setBackgroundDrawable(getDrawable(R.drawable.rounded_buttons_in_display_questions));
                        }
                    }
                    else if (count == 2){
                        option = bookmarkList.get(position).getOptionC();
                        if (option.equals(bookmarkList.get(position).getCorrectAnswer())){
                            linearLayout.getChildAt(count).setBackgroundDrawable(getDrawable(R.drawable.rounded_buttons_in_display_questions_correct_answer));
                        }else{
                            linearLayout.getChildAt(count).setBackgroundDrawable(getDrawable(R.drawable.rounded_buttons_in_display_questions));
                        }
                    }else if (count == 3){
                        option = bookmarkList.get(position).getOptionD();
                        if (option.equals(bookmarkList.get(position).getCorrectAnswer())){
                            linearLayout.getChildAt(count).setBackgroundDrawable(getDrawable(R.drawable.rounded_buttons_in_display_questions_correct_answer));
                        }else {
                            linearLayout.getChildAt(count).setBackgroundDrawable(getDrawable(R.drawable.rounded_buttons_in_display_questions));
                        }
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
                linearLayout.getChildAt(i).setBackgroundDrawable(getDrawable(R.drawable.rounded_buttons_in_display_questions));
            }
            //load data first time
            bookMarkAnim(difficulty, 0, bookmarkList.get(pos).getDifficulty());
            bookMarkAnim(tvQuestions, 0, bookmarkList.get(pos).getQuestion());
            bookMarkAnim(tvTotal, 0, position+1+"/"+bookmarkList.size());
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
                        bookMarkAnim(tvTotal, 0, position+1+"/"+bookmarkList.size());

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
                        bookMarkAnim(tvTotal, 0, position+1+"/"+bookmarkList.size());

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
}