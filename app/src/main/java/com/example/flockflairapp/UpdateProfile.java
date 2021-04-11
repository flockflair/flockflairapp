package com.example.flockflairapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static android.widget.Toast.LENGTH_SHORT;

public class UpdateProfile extends AppCompatActivity {
    //private FirebaseAuth firebaseAuth;
    private TextInputEditText Ename;
    private TextView Ephone;
    private Button save;
    private Button logout;
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
        Ephone = (TextView) findViewById(R.id.EditPhone);
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
                Toast.makeText(getApplicationContext(),"Something went wrong",LENGTH_SHORT).show();

            }
        });

        //}


        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save = (Button) findViewById(R.id.save);
                save.setVisibility(View.VISIBLE);
                TextInputEditText Ename = findViewById(R.id.EditName);
                Ename.setFocusableInTouchMode(true);
                Ename.isCursorVisible();

            }
        });







       save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if(awesomeValidation.validate()) {
                    Toast.makeText(getApplicationContext(),"success", LENGTH_SHORT).show();
                    uploadData();
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"invalid name", LENGTH_SHORT).show();
                }

                Button save = (Button) v ;
                save.setVisibility(View.INVISIBLE);


            }



            private void uploadData()
            {


                if(!TextUtils.isEmpty(Ename.getText().toString()) || !TextUtils.isEmpty(Ephone.getText().toString()))
                {
                    Java_SignUp obj = new Java_SignUp(Ename.getText().toString(),Ephone.getText().toString());
                    Map<String,Object > profile = new HashMap<>();
                    profile.put("name",obj.getName());
                    reference.child(userID).updateChildren(profile);
                    Toast.makeText(getApplicationContext(),"Updated", Toast.LENGTH_SHORT).show();

                }
                else
                    {
                        Toast.makeText(getApplicationContext(),"pls fill data", Toast.LENGTH_SHORT).show();

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
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        overridePendingTransition(0, 0);
                        return true;

                    case R.id.about:
                        startActivity(new Intent(getApplicationContext(), UpdateProfile.class));
                        overridePendingTransition(0, 0);
                        return true;

                }
                return false;

            }

        });


    }
}









