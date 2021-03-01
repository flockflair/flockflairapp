package com.example.flockflairapp;

import android.animation.Animator;
import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.ArrayList;
import java.util.List;


public class DisplayQuestions extends AppCompatActivity {

    //instance of firebase
    FirebaseDatabase db = FirebaseDatabase.getInstance();
    DatabaseReference dbRef = db.getReference();

    DatabaseReference dbBookmarks = db.getReference();

    //haptic for wrong option
    private Vibrator vibrator;

    //progressDailog
    private ProgressDialog pg;
    //textview
    private TextView tvQuestions, tvTotal;

    private LinearLayout linearLayout;
    //Bookmarks
    private FloatingActionButton bookMarks;
    //next button
    private Button next_btn;
    private Button explanation_btn;
    //question model list
    private List<QuestionModel> list;
    private List<QuestionModel> bookMarklist;
    int count = 0;
    int position = 0;
    //for user id
    String uuid = FirebaseAuth.getInstance().getCurrentUser().getUid();
    //matchedQuestionPosition
    private int matchedQuestionPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_questions);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE,WindowManager.LayoutParams.FLAG_SECURE);

        tvQuestions = findViewById(R.id.tvQuestions);
        tvTotal = findViewById(R.id.tvTotal);
        linearLayout = findViewById(R.id.linearLayout);
        bookMarks = findViewById(R.id.floatingActionButton5);
        next_btn = findViewById(R.id.buttonNext);
        vibrator = (Vibrator) this.getSystemService(VIBRATOR_SERVICE);

        //prevent screenCapture
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE,WindowManager.LayoutParams.FLAG_SECURE);


        //explanation
        explanation_btn = findViewById(R.id.buttonExplain);
        //builder
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(R.layout.explain);

        //bookmark button on displayQuestion
        bookMarks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //save bookmark in database
                setBookmarks();
                //bookmark image change to flled
                bookMarks.setImageDrawable(getDrawable(R.drawable.bookmarked));
                bookMarks.setEnabled(false);
                //for toast msg
                Toast.makeText(DisplayQuestions.this,"Bookmarked", Toast.LENGTH_SHORT).show();
                //for vibration
                vibrator.vibrate(50);
            }
        });

        pg = new ProgressDialog(this);
        pg.setTitle("Please wait...");
        pg.setMessage("Loading Questions...");

        //creating list
        list = new ArrayList<>();
        //list for bookmarks
        bookMarklist = new ArrayList<>();

        //Explaination Enabled
        explanation_btn.setEnabled(false);
        explanation_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAboutDialog();
            }
        });

        //progressDialog
        pg.show();
        //database fetch child
        dbRef.child("Diversity In The Living World").child("questions").orderByChild("index").limitToFirst(10).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                //data cache
                dbRef.keepSynced(true);
                //for each loop get value
                for (DataSnapshot snapshot1 : snapshot.getChildren()){
                    list.add(snapshot1.getValue(QuestionModel.class));
                }
                McqAlgo();
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(DisplayQuestions.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }

    //function to store Bookmarks to database
    public void setBookmarks() {
        //for retrieve data in question model
        QuestionModel questionModel = new QuestionModel(list.get(position).getQuestion(),list.get(position).getCorrectAnswer());
        //to save mcq at user profile
        dbBookmarks.child("user").child(uuid).push().setValue(questionModel);
        String pushKey = dbBookmarks.child("user").child(uuid).push().getKey();
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
                        tvTotal.setText(position+1+"/"+list.size());
                        if (modelMatch()){
                            bookMarks.setImageDrawable(getDrawable(R.drawable.bookmarked));
                        }else {
                            bookMarks.setImageDrawable(getDrawable(R.drawable.bookmark));
                        }
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
    private void checkAnswer(final Button selectOption) {
        enableOption(false);
        next_btn.setEnabled(true);
        explanation_btn.setEnabled(true);
        next_btn.setAlpha(1);

        if (selectOption.getText().toString().equals(list.get(position).getCorrectAnswer())){
            //correct Answer
            //selectOption.setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(this,R.drawable.correct), null,null, null);
            selectOption.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2ecc71")));

        }else{
            //incorrect Answer
            vibrator.vibrate(100);
            selectOption.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#e74c3c")));

            Button correctOption = linearLayout.findViewWithTag(list.get(position).getCorrectAnswer());
            correctOption.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2ecc71")));

        }
    }

    //MatchModel for Bookmark
    boolean matched = false;
    int index = 0;
    private boolean modelMatch(){
        int index = 0;
        for (QuestionModel model:bookMarklist){
            if (model.getQuestion().equals(list.get(position).getQuestion()) && model.getCorrectAnswer()
                    .equals(list.get(position).getCorrectAnswer())){
                matched = true;
                matchedQuestionPosition = index;
            }
            index++;
        }
        return matched;
    }

    private void enableOption(boolean enable) {
        for (int i = 0; i < 4; i++){
            linearLayout.getChildAt(i).setEnabled(enable);

            if (enable){
                linearLayout.getChildAt(i).setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#bdc3c7")));
                bookMarks.setEnabled(true);
            }
        }
    }
    public void McqAlgo(){
        //check if list is greater than zero
        if (list.size()>0){
            for (int i = 0; i < 4; i++){
                //clickListener on option button
                pg.dismiss();
                linearLayout.getChildAt(i).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //method to compare options with correctAnswer
                        checkAnswer((Button) view);
                    }
                });
            }
            //loading first question
            animation(tvQuestions, 0, list.get(position).getQuestion());
            //to load next questions
            next_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    next_btn.setEnabled(false);
                    explanation_btn.setEnabled(false);
                    next_btn.setAlpha(0.7f);
                    enableOption(true);
                    position++;

                    if (position == list.size()){
                        //end of question index
                        Toast.makeText(DisplayQuestions.this, "for more question please buy premium version", Toast.LENGTH_SHORT).show();
                        finish();
                        return;
                    }
                    //before calling animation variable count initialize to 0
                    count = 0;
                    animation(tvQuestions, 0,list.get(position).getQuestion());
                }
            });
        }else {
            pg.dismiss();
            Toast.makeText(DisplayQuestions.this, "Empty Questions", Toast.LENGTH_SHORT).show();
            finish();
        }
    }

    private void showAboutDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Explanation");
        builder.setMessage(list.get(position).getExplaination());
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
}