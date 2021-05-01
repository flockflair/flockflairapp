package com.example.flockflairapp;

import android.animation.Animator;
import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Vibrator;
import android.util.Log;
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
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class DisplayQuestions extends AppCompatActivity {

    private final String TAG = "DisplayQuestions";
    public static final int MAX_BOOKMARKS = 10;
    //instance of firebase
    FirebaseDatabase db = FirebaseDatabase.getInstance();
    DatabaseReference dbRef = db.getReference();
    //bookmarkRef
    DatabaseReference dbBookmarks = db.getReference("user");
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
    int count = 0;

    private List<QuestionModel> BookMarkList;
    //random number for question
    Random rand = new Random();
    int position= rand.nextInt(20-2)+2;
    //for user id
     String uuid = FirebaseAuth.getInstance().getCurrentUser().getUid();

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

        BookMarkList = new ArrayList<>();

        dbBookmarks.child(uuid).child("Bookmarks").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot ds:snapshot.getChildren()){
                    BookMarkList.add(ds.getValue(QuestionModel.class));
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.d(TAG, error.getMessage());
            }
        });

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
                //bookmark & unbookmark
                if (modelMatch()){
                    bookMarks.setImageDrawable(getDrawable(R.drawable.bookmark));
                    //Query for removing bookmarks for displayQuestion activity
                    Query displayQueryUnBookmark = dbBookmarks.child(uuid).child("Bookmarks").orderByChild("question").equalTo(list.get(position).getQuestion());

                    displayQueryUnBookmark.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            for (DataSnapshot dataSnapshot:snapshot.getChildren()){
                                dataSnapshot.getRef().removeValue();
                                Toast.makeText(DisplayQuestions.this, "Bookmark removed", Toast.LENGTH_SHORT).show();
                            }
                        }
                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {
                            Log.d(TAG, "error" + error.getMessage());
                        }
                    });
                }else{
                    //limit for bookmark size
                    if (BookMarkList.size() < MAX_BOOKMARKS){
                        //save bookmark in database
                        QuestionModel questionModel = new QuestionModel(list.get(position).getQuestion(), list.get(position).getOptionA(),
                                list.get(position).getOptionB(), list.get(position).getOptionC(), list.get(position).getOptionD(), list.get(position).getCorrectAnswer()
                                ,list.get(position).getExplaination(), list.get(position).getDifficulty(), list.get(position).getChapterName(),list.get(position).getIndex());

                        bookMarks.setImageDrawable(getDrawable(R.drawable.bookmarked));
                        dbBookmarks.child(uuid).child("Bookmarks").push().setValue(questionModel);
                        BookMarkList.add(questionModel);
                        Toast.makeText(DisplayQuestions.this, "Bookmarked", Toast.LENGTH_SHORT).show();
                        //vibration
                        vibrator.vibrate(50);
                    }
                }
            }
        });

        pg = new ProgressDialog(this);
        pg.setTitle("Please wait...");
        pg.setMessage("Loading Questions...");

        //creating list
        list = new ArrayList<>();

        //Explaination Enabled
        explanation_btn.setEnabled(false);
        explanation_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAboutDialog();
            }
        });

        //question from bookmarkAdapter
        String Qpos = getIntent().getStringExtra("Qpos");
        
        int chapter1 = getIntent().getIntExtra("chapter1", 0);
        if (chapter1 == 1){
            //databsae question fetch
            databaseConnection("Diversity In The Living World","What is living","questions");
        }else {
                dbRef.child("Diversity In The Living World").child("What is living").child("questions").addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        String DDpos = getIntent().getStringExtra("DDpos");
                        for (DataSnapshot dataSnapshot:snapshot.getChildren()){
                            list.add(dataSnapshot.getValue(QuestionModel.class));
                        }
                        for (int i = 0; i < 4; i++){
                            //clickListener on option button
                            linearLayout.getChildAt(i).setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    //method to compare options with correctAnswer
                                    BookcheckAnswer((Button) view);
                                }
                            });
                        }
                        Bookanimation(tvQuestions,0,Qpos);
                        difficulty.setText(DDpos);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        Log.d("Bookmark Question", error.getMessage());
                    }
                });
            }
        }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(this, ExpandableModule1.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        startActivity(intent);
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
                        if (modelMatch()){
                            bookMarks.setImageDrawable(getDrawable(R.drawable.bookmarked));
                        }else {
                            bookMarks.setImageDrawable(getDrawable(R.drawable.bookmark));
                        }
                        tvTotal.setText(position+1+"/"+list.size());
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
    int index;
    int matchedQuestionPosition;
    private boolean modelMatch() {
        for (QuestionModel model:BookMarkList){
            if (model.getQuestion().equals(list.get(position).getQuestion())){
                matched = true;
                matchedQuestionPosition = index;
                break;
            }else{
                index++;
                matched = false;
            }
        }
        return matched;
    }
    
    private void enableOption(boolean enable) {
        for (int i = 0; i < 4; i++){
            linearLayout.getChildAt(i).setEnabled(enable);

            if (enable){
                linearLayout.getChildAt(i).setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#bdc3c7")));
            }
        }
    }
    public void QuestionLoader(){
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
                    position= rand.nextInt(20);

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

    //databaseFuction
    public void databaseConnection(String Module, String Sub,String Questions){
        //progressDialog
        pg.show();
            //database fetch child
            dbRef.child(Module).child(Sub).child(Questions).orderByChild("index").limitToFirst(20).addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    //data cache
                    //for each loop get value
                    for (DataSnapshot snapshot1 : snapshot.getChildren()) {
                        list.add(snapshot1.getValue(QuestionModel.class));
                    }
                    //difficulty.setText(list.get(position).getDifficulty());
                    QuestionLoader();
                }
                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                    Toast.makeText(DisplayQuestions.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                    finish();
                }
            });
    }

    //animation for loading new question
    private void Bookanimation(final View view, final int value, final String data){

        String OApos = getIntent().getStringExtra("OApos");
        String OBpos = getIntent().getStringExtra("OBpos");
        String OCpos = getIntent().getStringExtra("OCpos");
        String ODpos = getIntent().getStringExtra("ODpos");

        view.animate().alpha(value).scaleX(value).scaleY(value).setDuration(500).setStartDelay(100)
                .setInterpolator(new DecelerateInterpolator()).setListener(new Animator.AnimatorListener() {
            @Override
            //checking value and view count to start animation
            public void onAnimationStart(Animator animator) {
                if (value == 0 && count < 4){
                    String option = ""; //check all option at location count value

                    if (count == 0){
                        option = OApos;
                    }else if (count == 1){
                        option = OBpos;
                    }
                    else if (count == 2){
                        option = OCpos;
                    }else if (count == 3){
                        option = ODpos;
                    }
                    Bookanimation(linearLayout.getChildAt(count),0,option);
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
                        if (modelMatch()){
                            bookMarks.setImageDrawable(getDrawable(R.drawable.bookmarked));
                        }
                    }catch (ClassCastException e){
                        ((Button)view).setText(data);
                    }
                    view.setTag(data);
                    Bookanimation(view, 1,data);
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
    private void BookcheckAnswer(final Button selectOption) {
        String CApos = getIntent().getStringExtra("CApos");
        enableOption(false);
        explanation_btn.setEnabled(true);

        if (selectOption.getText().toString().equals(CApos)){
            //correct Answer
            selectOption.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2ecc71")));

        }else{
            //incorrect Answer
            vibrator.vibrate(100);
            selectOption.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#e74c3c")));

            Button correctOption = linearLayout.findViewWithTag(CApos);
            correctOption.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2ecc71")));

        }
    }
}