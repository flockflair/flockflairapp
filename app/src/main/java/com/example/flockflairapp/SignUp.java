package com.example.flockflairapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUp extends AppCompatActivity {

    EditText edit_name;
    EditText edit_phone;
    DatabaseReference databaseReference;
    Button ButtonSignUp, back_button;
    String phoneNum;
    String name;
    Java_SignUp java_signUp;
    long maxid = 0;
    String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        edit_name = findViewById(R.id.edit_name);
        edit_phone = findViewById(R.id.edit_phone);
        ButtonSignUp = findViewById(R.id.buttonSignUp);
        back_button = findViewById(R.id.back_button);

        databaseReference = FirebaseDatabase.getInstance().getReference().child("user");
//
//        databaseReference.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                if(snapshot.exists()){
//                    maxid = (snapshot.getChildrenCount());
//                }
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });
        Intent intent = getIntent();
        String mobile = intent.getStringExtra("phoneNum");
        edit_phone.setText(mobile);

        ButtonSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                name = edit_name.getText().toString();
                phoneNum = edit_phone.getText().toString().trim();

                Java_SignUp n = new Java_SignUp(name, phoneNum);
                databaseReference.child(uid).setValue(n);
                Toast.makeText(getApplicationContext(), "Data inserted Successfully", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }

    @Override
    public void onBackPressed() {
        Toast.makeText(getApplicationContext(), "Back press disabled!", Toast.LENGTH_SHORT).show();
    }

    /*@Override
    protected void onStart() {
        super.onStart();
        if(uid!=null){
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
            finish();

        }
    }*/
}