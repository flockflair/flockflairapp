package com.example.flockflairapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class phonenumber extends AppCompatActivity {

    EditText editText;
    Button buttonContinue;
    DatabaseReference databaseReference;
    DatabaseReference userReference;
    String phoneNum = null;
    TextView SignUp;
    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phonenumber);

        editText = findViewById(R.id.editTextMobile);
        buttonContinue = findViewById(R.id.buttonContinue);
        SignUp = findViewById(R.id.SignUp);


        databaseReference = FirebaseDatabase.getInstance().getReference();
        userReference = databaseReference.child("user");
        Log.d("Error", String.valueOf(databaseReference));

        buttonContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String regexStr = "^(?:(?:\\+|0{0,2})91(\\s*[\\-]\\s*)?|[0]?)?[789]\\d{9}$";
                phoneNum = editText.getText().toString();
                Log.d("Phone", String.valueOf(phoneNum));
                if (phoneNum.length() != 10 || !phoneNum.matches(regexStr)) {
                    editText.setError("Enter the proper number");
                    editText.requestFocus();
                    return;
                }

                final Query queryRef = userReference.orderByChild("phone").equalTo(phoneNum);
                Log.d("Error", String.valueOf(queryRef));

                if(phoneNum != null){
                    Toast.makeText(getApplicationContext(), phoneNum, Toast.LENGTH_SHORT).show();
                    queryRef.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            Log.d("Snapshot", String.valueOf(snapshot));

                            if(snapshot.exists()){
                                Toast.makeText(phonenumber.this, "Correct Number", Toast.LENGTH_LONG).show();
                                Intent intent = new Intent(getApplicationContext(), OtpActivity.class);
                                intent.putExtra("phoneNum", phoneNum);
                                startActivity(intent);
                                finish();
                            }
                            else{
                                Toast.makeText(phonenumber.this, "Number does not exist", Toast.LENGTH_LONG).show();
                                editText.setText("");
                                editText.requestFocus();
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                }
            }
        });

      /*  SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SignUp.class);
                startActivity(intent);
                finish();
            }
        });*/
    }
    @Override
    protected void onStart() {
        super.onStart();
        if (user != null){
            Intent mainIntent = new Intent(phonenumber.this,MainActivity.class);
            mainIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(mainIntent);
        }
    }
}