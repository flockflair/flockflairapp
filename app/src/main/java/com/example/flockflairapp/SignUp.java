package com.example.flockflairapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class SignUp extends AppCompatActivity {

    EditText edit_name;
    EditText edit_phone;
    DatabaseReference databaseReference;
    Button ButtonSignUp;
    Long phoneNum;
    String name;
    Java_SignUp java_signUp;
    long maxid = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        edit_name = findViewById(R.id.edit_name);
        edit_phone = findViewById(R.id.edit_phone);
        ButtonSignUp = findViewById(R.id.buttonSignUp);
        java_signUp = new Java_SignUp();

        databaseReference = FirebaseDatabase.getInstance().getReference().child("user");

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    maxid = (snapshot.getChildrenCount());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


        ButtonSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                name = edit_name.getText().toString();
                phoneNum = Long.parseLong(edit_phone.getText().toString().trim());

                java_signUp.setName(name);
                java_signUp.setPhoneNum(phoneNum);

                databaseReference.child(String.valueOf(maxid+1)).child("phone").setValue(java_signUp);
                Toast.makeText(getApplicationContext(), "Data inserted Successfully", Toast.LENGTH_LONG).show();
            }
        });
    }
}