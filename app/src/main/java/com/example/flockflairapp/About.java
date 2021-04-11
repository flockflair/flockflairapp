package com.example.flockflairapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static android.widget.Toast.LENGTH_SHORT;

public class About extends AppCompatActivity
{
    //Button Update,
    Button logout;
    Button Update,Update1;
    Button edit;
    Button save;
    private String user;
    private DatabaseReference reference;
    private String userID;
    FirebaseAuth firebaseAuth;
    AwesomeValidation awesomeValidation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);



        firebaseAuth = FirebaseAuth.getInstance();
        edit = (Button)findViewById(R.id.buttonedit);
       // awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);
       // awesomeValidation.addValidation(this, R.id.EditName, "[a-zA-Z\\s]+", R.string.invalid_name);
        logout = (Button)findViewById(R.id.button_logout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firebaseAuth.signOut();
                finish();
                startActivity(new Intent(getApplicationContext(),phonenumber.class));

            }
        });

        edit = (Button)findViewById(R.id.buttonedit);
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 TextInputEditText et_name = findViewById(R.id.nameinputbox);
                 et_name.setFocusableInTouchMode(true);
                 et_name.isCursorVisible();

            }
        });





        user = FirebaseAuth.getInstance().getCurrentUser().getUid();
        reference = FirebaseDatabase.getInstance().getReference("user");
        final TextView et_greet = (TextView)findViewById(R.id.greeting);
        final TextInputEditText et_name = findViewById(R.id.nameinputbox);
        final TextView et_phone =findViewById(R.id.phoneinputbox);
        reference.child(user).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                HashMap<String,String> hash = new HashMap<>();
                hash.put("name",snapshot.child("name").getValue(String.class));
                hash.put("phone",snapshot.child("phone").getValue(String.class));
                et_greet.setText("Welcome "+hash.get("name") + " !");
                et_name.setText(hash.get("name"));
                et_phone.setText(hash.get("phone"));
                reference.keepSynced(true);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getApplicationContext(),"Something went wrong",LENGTH_SHORT).show();

            }
        });

        save = (Button)findViewById(R.id.save_button);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {

                TextInputEditText et_name = findViewById(R.id.nameinputbox);
                et_name.setFocusableInTouchMode(false);
                if(awesomeValidation.validate()) {
                    Toast.makeText(getApplicationContext(),"success", LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"invalid name", LENGTH_SHORT).show();
                }


            }





        });




        /*Update = (ImageButton)findViewById(R.id.imageButton_update);
        Update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //startActivity(new Intent(getApplicationContext() ,UpdateProfile.class));
                //finish();
                openUpdateProfile();
            }
        });

        Update1 = (ImageButton)findViewById(R.id.imageButton_update1);
        Update1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //startActivity(new Intent(getApplicationContext() ,UpdateProfile.class));
                //finish();
                openUpdateProfile();
            }
        });*/

        Update = (Button)findViewById(R.id.button_update);

        Update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //startActivity(new Intent(getApplicationContext() ,UpdateProfile.class));
                //finish();
                openUpdateProfile();
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

    private void openUpdateProfile()
    {
        Intent intent = new Intent(this, UpdateProfile.class);
        startActivity(intent);
    }


}
