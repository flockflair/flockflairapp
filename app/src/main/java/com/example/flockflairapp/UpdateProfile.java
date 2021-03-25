package com.example.flockflairapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class UpdateProfile extends AppCompatActivity {
    //private FirebaseAuth firebaseAuth;
    private EditText Ename, Ephone;
    private Button save;
    private FirebaseAuth fAuth;
    FirebaseUser user;
    FirebaseDatabase database;
    DatabaseReference reference;

    String userID;
    List<String> list = new ArrayList<>();
    String userstring = "";
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
        //member = new All_UserMember();


        // EditName= (EditText)findViewById(R.id.EditName);
        //EditPhone =(EditText)findViewById(R.id.EditPhone);
        save = (Button) findViewById(R.id.save);
        Ename = (EditText) findViewById(R.id.EditName);
        Ephone = (EditText) findViewById(R.id.EditPhone);
        //firebaseAuth = FirebaseAuth.getInstance();

        user = fAuth.getInstance().getCurrentUser();
        reference = database.getInstance().getReference("user");
        userID = user.getUid();


        //TextView greetingTextView = (TextView) findViewById(R.id.greeting);
        // EditText EditName = (EditText) findViewById(R.id.EditName);
        //EditText EditPhone = (EditText) findViewById(R.id.EditPhone);
        //TextView phoneTextView = (TextView) findViewById(R.id.phoneinputbox);


        //if(user.equals(list.get(position))) {


        reference.child(userID).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                snapshot.getValue(Java_SignUp.class);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        //}







      /*  save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                uploadData();

            }

            private void uploadData()
            {
                String name  = EditName.getText().toString();
                String phone  = EditPhone.getText().toString();

                if(!TextUtils.isEmpty(name) || TextUtils.isEmpty(phone))
                {
                    Map<String,String > profile = new HashMap<>();
                    profile.put("name",name);
                    profile.put("phone",phone);

                    member.setName(name);
                    member.setPhone(phone);
                    databaseReference.child(userstring).setValue(member);
                    documentReference.set(profile)
                            .addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {
                                 Toast.makeText(getApplicationContext(),"updated",Toast.LENGTH_SHORT).show();
                                }
                            });








                }
                else
                    {
                        Toast.makeText(getApplicationContext(),"pls fill data", Toast.LENGTH_SHORT).show();

                }

            }
        });*/


        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.about);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.dashboard:
                        startActivity(new Intent(getApplicationContext(), DashBoard.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        overridePendingTransition(0, 0);
                        return true;

                    case R.id.about:
                        startActivity(new Intent(getApplicationContext(), About.class));
                        overridePendingTransition(0, 0);
                        return true;

                }
                return false;

            }

        });


    }
}









