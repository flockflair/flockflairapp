package com.example.flockflairapp;

import android.animation.Animator;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.HapticFeedbackConstants;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.DecelerateInterpolator;
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
    int position= 0;
    private Vibrator vibrator;


    //instance of firebase
    FirebaseDatabase db = FirebaseDatabase.getInstance();
    DatabaseReference dbRef = db.getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_of_the_day);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE,WindowManager.LayoutParams.FLAG_SECURE);
        vibrator = (Vibrator) this.getSystemService(VIBRATOR_SERVICE);

        tvQuestions = findViewById(R.id.tvQuestions);
        linearLayout = findViewById(R.id.linearLayout);
        difficulty = findViewById(R.id.difficulty);
        explanation_btn = findViewById(R.id.buttonExplain);
        tvQuestions.setMovementMethod(new ScrollingMovementMethod());

        int STD11 = getIntent().getIntExtra("STD11", 0);

        if (STD11 == 11){
            dbRef.child("QuestionOfTheDay").child("Q11").addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                    for (DataSnapshot dataSnapshot:snapshot.getChildren()){
                        list.add(dataSnapshot.getValue(QuestionModel.class));
                    }
                    loader();
                }

                @Override
                public void onCancelled(@NonNull @NotNull DatabaseError error) {
                    Log.d(TAG, "onCancelled: error "+error.getDetails());
                }
            });
        }else {
            dbRef.child("QuestionOfTheDay").child("Q12").addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                    for (DataSnapshot dataSnapshot:snapshot.getChildren()){
                        list.add(dataSnapshot.getValue(QuestionModel.class));
                    }
                    loader();
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

    //animation for loading new question
    private void animation(final View view, final int value, final String data){
        view.animate().alpha(value).scaleX(value).scaleY(value).setDuration(500).setStartDelay(100)
                .setInterpolator(new DecelerateInterpolator()).setListener(new Animator.AnimatorListener() {
            @Override
            //checking value and view count to start animation
            public void onAnimationStart(Animator animator) {
                if (value == 0 && count < 4){
                    String option = ""; //check all option at location count value

                    if (count == 0){
                        option = list.get(position).getOptionA();
                    }else if (count == 1){
                        option = list.get(position).getOptionB();
                    }
                    else if (count == 2){
                        option = list.get(position).getOptionC();
                    }else if (count == 3){
                        option = list.get(position).getOptionD();
                    }
                    animation(linearLayout.getChildAt(count),0,option);
                    count++;
                }
            }

            @SuppressLint("SetTextI18n")
            @Override
            public void onAnimationEnd(Animator animator) {
                //on question data changes
                if (value == 0){
                    try {
                        ((TextView)view).setText(data);
                    }catch (ClassCastException e){
                        ((Button)view).setText(data);
                    }
                    view.setTag(data);
                    animation(view, 1,data);
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

    public void checkAnswer(final Button selectOption) {
        DisplayQuestions.enableOption(false, linearLayout);
        if (selectOption.getText().toString().equals(list.get(position).getCorrectAnswer())){
            //correct Answer
            selectOption.setBackgroundDrawable(getDrawable(R.drawable.rounded_buttons_in_display_questions_correct_answer));

        }else{
            vibrator.vibrate(100);
            //incorrect Answer
            selectOption.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);
            selectOption.setBackgroundDrawable(getDrawable(R.drawable.rounded_buttons_in_display_questions_wroung_answer));

            Button correctOption = linearLayout.findViewWithTag(list.get(position).getCorrectAnswer());

            correctOption.setBackgroundDrawable(getDrawable(R.drawable.rounded_buttons_in_display_questions_correct_answer));
        }
    }

    public void loader(){
        if (list.size()>0) {
            for (int i = 0; i < 4; i++) {
                //clickListener on option button
                linearLayout.getChildAt(i).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //method to compare options with correctAnswer
                        checkAnswer((Button) view);
                    }
                });
            }
            position = rand.nextInt(list.size());
            animation(difficulty, 0, list.get(position).getDifficulty());
            animation(tvQuestions, 0, list.get(position).getQuestion());
            explanation_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    DisplayQuestions.showAboutDialog(QuestionOfTheDay.this, list, position);
                }
            });
        }
    }

}