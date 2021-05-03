package com.example.flockflairapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

import static android.widget.Toast.LENGTH_SHORT;

public class UpdateProfile extends AppCompatActivity {
    //private FirebaseAuth firebaseAuth;
    private TextInputEditText Ename;
    private TextInputEditText Ephone;
    //private TextView Ephone;
    private Button save;
    private Button logout;
    private Button back;
    Button edit;
    FirebaseAuth fAuth;
    FirebaseUser user;
    FirebaseDatabase database;
    DatabaseReference reference;
    AwesomeValidation awesomeValidation;

    String userID;

    //All_UserMember member;
    int position = 3;

    //FirebaseDatabase database = FirebaseDatabase.getInstance();
    //DatabaseReference databaseReference;
    //DocumentReference documentReference;
    //FirebaseFirestore db = FirebaseFirestore.getInstance();


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_profile);
        fAuth = FirebaseAuth.getInstance();

        logout = (Button)findViewById(R.id.logout_button);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fAuth.signOut();
                finish();
                startActivity(new Intent(getApplicationContext(),phonenumber.class));

            }
        });

        save = (Button) findViewById(R.id.save);
        Ename = (TextInputEditText) findViewById(R.id.EditName);
        Ephone = (TextInputEditText) findViewById(R.id.EditPhone);
        back = (Button)findViewById(R.id.button_back);
        edit = (Button)findViewById(R.id.button_edit);
        //firebaseAuth = FirebaseAuth.getInstance();
        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);
        user = fAuth.getInstance().getCurrentUser();
        reference = database.getInstance().getReference("user");
        userID = user.getUid();
       awesomeValidation.addValidation(this, R.id.EditName, "[a-zA-Z\\s]+", R.string.invalid_name);
       //awesomeValidation.addValidation(this,R.id.EditPhone, "((\\+*)((0[ -]+)*|(91 )*)(\\d{12}|\\d{10}))|\\d{5}([- ]*)\\d{6}", R.string.invalid_phone);




        reference.child(userID).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                HashMap<String,String> hash = new HashMap<>();
                hash.put("name",snapshot.child("name").getValue(String.class));
                hash.put("phone",snapshot.child("phone").getValue(String.class));
                Ename.setText(hash.get("name"));
                Ephone.setText(hash.get("phone"));
                reference.keepSynced(true);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getApplicationContext(),"Something went wrong please try again",LENGTH_SHORT).show();

            }
        });

        //}
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);

            }
        });

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save = (Button) findViewById(R.id.save);
                save.setVisibility(View.VISIBLE);
                TextInputEditText Ename = findViewById(R.id.EditName);
                Ename.setFocusableInTouchMode(true);
                Ename.setCursorVisible(true);
                Ename.isCursorVisible();

            }
        });







       save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if(awesomeValidation.validate()) {
                    Toast.makeText(getApplicationContext(),"Successful Operation", LENGTH_SHORT).show();
                    uploadData();
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Invalid Name", LENGTH_SHORT).show();
                }

                Button save = (Button) v ;
                save.setVisibility(View.INVISIBLE);
                TextInputEditText Ename = findViewById(R.id.EditName);
                Ename.setFocusableInTouchMode(false);
                Ename.setCursorVisible(false);
                Ename.setFocusable(false);






            }



            private void uploadData()
            {


                if(!TextUtils.isEmpty(Ename.getText().toString()) || !TextUtils.isEmpty(Ephone.getText().toString()))
                {
                    Java_SignUp obj = new Java_SignUp(Ename.getText().toString(),Ephone.getText().toString());
                    Map<String,Object > profile = new HashMap<>();
                    profile.put("name",obj.getName());
                    reference.child(userID).updateChildren(profile);
                    Toast.makeText(getApplicationContext(),"Your Profile is Updated", Toast.LENGTH_SHORT).show();

                }
                else
                    {
                        Toast.makeText(getApplicationContext(),"Please provide correct Information", Toast.LENGTH_SHORT).show();

                }

            }


        });


        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.about);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.dashboard:
                        startActivity(new Intent(getApplicationContext(), BookmarkActivity.class));
                        overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
                        return true;
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
                        return true;

                    case R.id.about:
                        return true;

                }
                return false;

            }

        });


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
        finishAfterTransition();
    }
}









