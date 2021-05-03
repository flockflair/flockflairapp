package com.example.flockflairapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
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

public class ExpandableModule2 extends AppCompatActivity {

    private String user;
    private DatabaseReference reference;
    List<String> moduleList;
    List<String> chapterList;
    Map<String, List<String>> moduleCollection;
    ExpandableListView expandableListView;
    ExpandableListAdapter expandableListAdapter;
    FirebaseAuth firebaseAuth;
    ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        firebaseAuth = FirebaseAuth.getInstance();
        user = FirebaseAuth.getInstance().getCurrentUser().getUid();
        reference = FirebaseDatabase.getInstance().getReference("user");
        final TextView greet =findViewById(R.id.StudentName);
        reference.child(user).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                final TextView greet =findViewById(R.id.StudentName);
                HashMap<String,String> hash = new HashMap<>();
                hash.put("name",snapshot.child("name").getValue(String.class));
                //hash.put("phone",snapshot.child("phone").getValue(String.class));
                greet.setText("Welcome "+hash.get("name") +"!");
                reference.keepSynced(true);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getApplicationContext(),"Something went wrong",LENGTH_SHORT).show();

            }
        });



        super.onCreate(savedInstanceState);
        setContentView(R.layout.expandablemodule);
        createmoduleList();
        createCollection();
        expandableListView = findViewById(R.id.Modules);
        expandableListAdapter = new MyExpandableListAdapter(this, moduleList, moduleCollection);
        expandableListView.setAdapter(expandableListAdapter);
        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            int lastExpandedPosition = -1;

            @Override
            public void onGroupExpand(int i) {
                if (lastExpandedPosition != -1 && i != lastExpandedPosition) {
                    expandableListView.collapseGroup(lastExpandedPosition);
                }
                lastExpandedPosition = i;


            }
        });
        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i1, long l) {
                String selected = expandableListAdapter.getChild(i, i1).toString();
                Toast.makeText(getApplicationContext(), "Selected " + selected, Toast.LENGTH_SHORT).show();
                Intent intent;

                switch (selected) {
                    case "Reproduction in Organism":
                        intent = new Intent(getApplicationContext(), DisplayQuestions.class);
                        startActivity(intent);
                        break;


                }

                return true;
            }
        });

        back = (ImageView)findViewById(R.id.backbuttonimg);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);

            }
        });

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.home);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId())
                {
                    case R.id.dashboard:
                        startActivity(new Intent(getApplicationContext(),BookmarkActivity.class));
                        overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
                        return true;
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
                        return true;
                    case R.id.about:
                        startActivity(new Intent(getApplicationContext(),UpdateProfile.class));
                        overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
                        return true;
                }return false;

            }
        });

    }


    private void createCollection() {
        String[] ModuleOne = {"Reproduction in Organism", "Sexual Reproduction in Flowering Plants", "Human Reproduction", "Reproductive health"};
        String[] ModuleTwo = {"Principle of Inheritance and Variation", "Molecular Basis of Inheritance", "Evolution"};
        String[] ModuleThree = {"Human Health and Diseases", "Stratergies for Enhancement in Food Production", "Microbes in Human Welfare"};
        String[] ModuleFour = {"Biotechnology:Principles and Processes", "Biotechnology and its Application"};
        String[] ModuleFive = {"Organism and Populations", "Ecosystem", "Biodiversity and Conversation", "Environmental Issues"};
        moduleCollection = new HashMap<String, List<String>>();
        for (String group : moduleList) {
            if (group.equals("Reproduction")) {
                loadChild(ModuleOne);

            } else if (group.equals("Genetics and Evolution")) {
                loadChild(ModuleTwo);

            } else if (group.equals("Biology in Human Welfare")) {
                loadChild(ModuleThree);

            } else if (group.equals("Biotechnology")) {
                loadChild(ModuleFour);

            } else

                loadChild(ModuleFive);
            moduleCollection.put(group, chapterList);

        }
    }

    private void loadChild(String[] Module) {
        chapterList = new ArrayList<>();
        for (String model : Module) {
            chapterList.add(model);

        }

    }

    private void createmoduleList() {
        moduleList = new ArrayList<>();
        moduleList.add("Reproduction");
        moduleList.add("Genetics and Evolution");
        moduleList.add("Biology in Human Welfare");
        moduleList.add("Biotechnology");
        moduleList.add("Ecology");
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);

    }
}


