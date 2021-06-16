package com.example.flockflairapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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
import java.util.Iterator;
import java.util.Map;

import static android.widget.Toast.LENGTH_SHORT;

public class UpdateProfile extends AppCompatActivity {

    private TextInputEditText Ename;
    private TextInputEditText Ephone;
    private TextView nofavtv;
    private Button save;
    private Button logout;
    private Button back;
    Button edit;
    FirebaseAuth fAuth;
    FirebaseUser user;
    FirebaseDatabase database;
    DatabaseReference reference;
    AwesomeValidation awesomeValidation;

    //FavRecycler
    RecyclerView recyclerView;
    ArrayList<FavModel> favModels;
    FavAdapter favAdapter;

    String userID;

    //All_UserMember member;
    int position = 3;

    //nofavholder
    int pointer = 1;

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
        nofavtv = (TextView)findViewById(R.id.nofav);
        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);
        user = fAuth.getInstance().getCurrentUser();
        reference = database.getInstance().getReference("user");
        userID = user.getUid();
       awesomeValidation.addValidation(this, R.id.EditName, "[a-zA-Z\\s]+", R.string.invalid_name);




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

        //FavPart
        recyclerView = findViewById(R.id.recycler_view);

        //ArrayList
        favModels = new ArrayList<>();

        //fetching favourite chapter names
        reference.child(userID).child("Favorite").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Iterable<DataSnapshot> snapshotIterator = dataSnapshot.getChildren();
                Iterator<DataSnapshot> iterator = snapshotIterator.iterator();

                while (iterator.hasNext()) {

                    DataSnapshot next = (DataSnapshot) iterator.next();
                    //Toast.makeText(getApplicationContext(), (String) next.child("favoriteName").getValue(),LENGTH_SHORT).show();
                    String value = (String) next.child("favoriteName").getValue();
                    //adding drawable and Favourite chapter name to FavModel
                    //pointer = 0 there is atleast one favourite chapter
                    if(value.equals("The Living World")){
                        FavModel model = new FavModel(R.drawable.livingworld,value);
                        favModels.add(model);
                        pointer = 0;
                    }
                    if(value.equals("Biological Classification")){
                        FavModel model = new FavModel(R.drawable.biologicalclassification,value);
                        favModels.add(model);
                        pointer = 0;
                    }if(value.equals("Plant Kingdom")){
                        FavModel model = new FavModel(R.drawable.plantkingdom,value);
                        favModels.add(model);
                        pointer = 0;
                    }if(value.equals("Animal Kingdom")){
                        FavModel model = new FavModel(R.drawable.animalkingdom,value);
                        favModels.add(model);
                        pointer = 0;
                    }
                    if(value.equals("Morphology of Flowering Plants")){
                        FavModel model = new FavModel(R.drawable.morphologyoffloweringplants,value);
                        favModels.add(model);
                        pointer = 0;
                    }
                    if(value.equals("Anatomy of Flowering Plants")){
                        FavModel model = new FavModel(R.drawable.anatomyoffloweringplants,value);
                        favModels.add(model);
                        pointer = 0;
                    }
                    if(value.equals("Structural Organisation in Animals")){
                        FavModel model = new FavModel(R.drawable.structuralorganisation,value);
                        favModels.add(model);
                        pointer = 0;
                    }
                    if(value.equals("Cell:The Unit of Life")){
                        FavModel model = new FavModel(R.drawable.cellunitoflife,value);
                        favModels.add(model);
                        pointer = 0;
                    }
                    if(value.equals("Biomolecules")){
                        FavModel model = new FavModel(R.drawable.biomolecules,value);
                        favModels.add(model);
                        pointer = 0;
                    }
                    if(value.equals("Cell Cycle")){
                        FavModel model = new FavModel(R.drawable.cellcycle,value);
                        favModels.add(model);
                        pointer = 0;
                    }
                    if(value.equals("Transport in Plants")){
                        FavModel model = new FavModel(R.drawable.transportinplants,value);
                        favModels.add(model);
                        pointer = 0;
                    }
                    if(value.equals("Photosynthesis in Higher Plants")){
                        FavModel model = new FavModel(R.drawable.photosynthesisinhigherplants,value);
                        favModels.add(model);
                        pointer = 0;
                    }
                    if(value.equals("Respiration in Plants")){
                        FavModel model = new FavModel(R.drawable.respiration,value);
                        favModels.add(model);
                        pointer = 0;
                    }
                    if(value.equals("Plant Growth and Development")){
                        FavModel model = new FavModel(R.drawable.plantgrowth,value);
                        favModels.add(model);
                        pointer = 0;
                    }
                    if(value.equals("Digestion and Absorption")){
                        FavModel model = new FavModel(R.drawable.digestionandabsorption,value);
                        favModels.add(model);
                        pointer = 0;
                    }
                    if(value.equals("Breathing and Exchange of Gases")){
                        FavModel model = new FavModel(R.drawable.breathing,value);
                        favModels.add(model);
                        pointer = 0;
                    }
                    if(value.equals("Body Fluids and Circulation")){
                        FavModel model = new FavModel(R.drawable.bodyfluids,value);
                        favModels.add(model);
                        pointer = 0;
                    }
                    if(value.equals("Excretory Products and their Elimination")){
                        FavModel model = new FavModel(R.drawable.excretoryproducts,value);
                        favModels.add(model);
                        pointer = 0;
                    }
                    if(value.equals("Locomotion and Movement")){
                        FavModel model = new FavModel(R.drawable.locomotion,value);
                        favModels.add(model);
                        pointer = 0;
                    }
                    if(value.equals("Neural Control and Coordination")){
                        FavModel model = new FavModel(R.drawable.neuralcontrol,value);
                        favModels.add(model);
                        pointer = 0;
                    }
                    if(value.equals("Chemical Coordination and Integration")){
                        FavModel model = new FavModel(R.drawable.chemicalcordination,value);
                        favModels.add(model);
                        pointer = 0;
                    }

                    if(value.equals("Reproduction in Organism")){
                        FavModel model = new FavModel(R.drawable.reproductioninorganism,value);
                        favModels.add(model);
                        pointer = 0;
                    }

                    if(value.equals("Sexual Reproduction in Flowering Plants")){
                        FavModel model = new FavModel(R.drawable.sexualreproductioninflower,value);
                        favModels.add(model);
                        pointer = 0;
                    }

                    if(value.equals("Human Reproduction")){
                        FavModel model = new FavModel(R.drawable.humanreproduction,value);
                        favModels.add(model);
                        pointer = 0;
                    }

                    if(value.equals("Reproductive Health")){
                        FavModel model = new FavModel(R.drawable.reproductivehealth,value);
                        favModels.add(model);
                        pointer = 0;
                    }

                    if(value.equals("Principles of Inheritance and Variation")){
                        FavModel model = new FavModel(R.drawable.principlesofinheritance,value);
                        favModels.add(model);
                        pointer = 0;
                    }

                    if(value.equals("Molecular Basis of Inheritance")){
                        FavModel model = new FavModel(R.drawable.molecularbasis,value);
                        favModels.add(model);
                        pointer = 0;
                    }


                    if(value.equals("Evolution")){
                        FavModel model = new FavModel(R.drawable.evolution,value);
                        favModels.add(model);
                        pointer = 0;
                    }

                    if(value.equals("Human Health and Disease")){
                        FavModel model = new FavModel(R.drawable.humanhealthdiseases,value);
                        favModels.add(model);
                        pointer = 0;
                    }

                    if(value.equals("Stratergies for Enhancement in Food Production")){
                        FavModel model = new FavModel(R.drawable.stratergiesenchancement,value);
                        favModels.add(model);
                        pointer = 0;
                    }

                    if(value.equals("Microbes in Human Welfare")){
                        FavModel model = new FavModel(R.drawable.microbesinwelfare,value);
                        favModels.add(model);
                        pointer = 0;
                    }

                    if(value.equals("Biotechnology:Principles and Processes")){
                        FavModel model = new FavModel(R.drawable.biotechnology,value);
                        favModels.add(model);
                        pointer = 0;
                    }

                    if(value.equals("Biotechnology and its Applications")){
                        FavModel model = new FavModel(R.drawable.bioapplications,value);
                        favModels.add(model);
                        pointer = 0;
                    }

                    if(value.equals("Organisms and Population")){
                        FavModel model = new FavModel(R.drawable.population,value);
                        favModels.add(model);
                        pointer = 0;
                    }

                    if(value.equals("Ecosystem")){
                        FavModel model = new FavModel(R.drawable.ecosystem,value);
                        favModels.add(model);
                        pointer = 0;
                    }

                    if(value.equals("Biodiversity and Conservation")){
                        FavModel model = new FavModel(R.drawable.biodiversity,value);
                        favModels.add(model);
                        pointer = 0;
                    }

                    if(value.equals("Environmental Issues")){
                        FavModel model = new FavModel(R.drawable.environmentalsys,value);
                        favModels.add(model);
                        pointer = 0;
                    }

                }

                //Initialize horizontal LinearLayout
                LinearLayoutManager layoutManager = new LinearLayoutManager(
                        UpdateProfile.this,LinearLayoutManager.HORIZONTAL,false
                );
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setItemAnimator(new DefaultItemAnimator());
                favAdapter = new FavAdapter(UpdateProfile.this, favModels);
                //Set FavAdapter
                recyclerView.setAdapter(favAdapter);

                //pointer = 1 indicates there is no chapter marked as favourite and Set nofavtv as Visible
                if(pointer == 1){
                    nofavtv.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

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









