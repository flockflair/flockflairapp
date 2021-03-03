package com.example.flockflairapp;

import android.animation.Animator;
import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Vibrator;
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
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


public class DisplayQuestions extends AppCompatActivity {

    public static final String FILE_NAME = "FLOCKFLAIR";
    public static final String KEY_NAME = "QUESTIONS";
    private static final String TAG = "BookmarkRemoved";

    //instance of firebase
    FirebaseDatabase db = FirebaseDatabase.getInstance();
    //rootRef
    DatabaseReference dbRef = db.getReference();
    //bookmarkRef
    DatabaseReference dbBookmarks = db.getReference();
    //haptic for wrong option
    private Vibrator vibrator;
    //progressDailog
    private ProgressDialog pg;
    //textview
    private TextView tvQuestions, tvTotal,difficulty;
    private LinearLayout linearLayout;
    //Bookmarks
    private FloatingActionButton bookMarks;
    //next button
    private Button next_btn;
    private Button explanation_btn;
    //question model list
    private List<QuestionModel> list;
    //bookmarklist
    private List<QuestionModel> bookMarklist;
    int count = 0;
    int position = 0;
    //for user id
    String uuid = FirebaseAuth.getInstance().getCurrentUser().getUid();
    //matchedQuestionPosition
    private int matchedQuestionPosition;
    private List<QuestionModel> bookMarkListSharedPreferences;
    //for sharedPreferences
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;
    private Gson gson;

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
        difficulty = (TextView)findViewById(R.id.difficulty);
        preferences = getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
        editor= preferences.edit();
        gson = new Gson();

        getBookMarks();

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
                if (modelMatch()){
                    bookMarklist.remove(matchedQuestionPosition);
                    bookMarks.setImageDrawable(getDrawable(R.drawable.bookmark));
                    Toast.makeText(DisplayQuestions.this,"Bookmark Removed", Toast.LENGTH_SHORT).show();

                }else{
                    bookMarklist.add(list.get(position));
                    bookMarks.setImageDrawable(getDrawable(R.drawable.bookmarked));
                    //save bookmark in database
                    dbBookmarks.child("user").child(uuid).push().setValue(new QuestionModel(list.get(position).getQuestion(), list.get(position).getCorrectAnswer()));
                    //for toast msg
                    Toast.makeText(DisplayQuestions.this,"Bookmarked", Toast.LENGTH_SHORT).show();
                    //for vibration
                    vibrator.vibrate(50);
                }
                //bookmark image change to flled
                /*bookMarks.setImageDrawable(getDrawable(R.drawable.bookmarked));
                bookMarks.setEnabled(false);*/
            }
        });
        //longpress direct to bookmarks
        bookMarks.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Intent bookmarkIntent = new Intent(getApplicationContext(),BookmarkActivity.class);
                startActivity(bookmarkIntent);
                return true;
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
                difficulty.setText(list.get(position).getDifficulty());
                McqAlgo();
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(DisplayQuestions.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        storebBookmarks();
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
                    //to get difficulty onloading question
                    difficulty.setText(list.get(position).getDifficulty());
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
    private boolean modelMatch() {
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
                //bookMarks.setEnabled(true);
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

    private void getBookMarks(){
        String json = preferences.getString(KEY_NAME,"");

        Type type = new TypeToken<List<QuestionModel>>(){}.getType();
        bookMarklist = gson.fromJson(json, type);
        if (bookMarklist == null){
            bookMarklist = new ArrayList<>();
        }
    }

    private void storebBookmarks(){
        String json = gson.toJson(bookMarklist);
        editor.putString(KEY_NAME, json);
        editor.commit();
    }
}