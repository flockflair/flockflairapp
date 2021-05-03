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

public class ExpandableModule1 extends AppCompatActivity {
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
        super.onCreate(savedInstanceState);
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
                    case "The Living World":
                        String[] subchaptername = {"What is living?","Diversity in the living","Taxonomic categories","Taxonomic Aids"};
                        int[] subchapImages = {R.drawable.android_1,R.drawable.angular,R.drawable.paint,R.drawable.atom,R.drawable.android_1,R.drawable.paint,R.drawable.angular};
                        intent = new Intent(getApplicationContext(), listviewimg.class);
                        intent.putExtra("subchaptername",subchaptername);
                        intent.putExtra("subchapImages",subchapImages);
                        //intent.putExtra("sub1","sub1");
                        startActivity(intent);
                        break;
                    case "Biological Classification":
                        String[] subchaptername1 = {"Introduction","Kingdom Monera","Kingdom Protista","Kingdom Fungi","Kingdom Plantae and Kingdom Animalia","Virus, viroids, prions, lichens"};
                        int[] subchapImages1 = {R.drawable.android_1,R.drawable.angular,R.drawable.paint,R.drawable.atom,R.drawable.android_1,R.drawable.paint,R.drawable.angular};
                        intent = new Intent(getApplicationContext(), listviewimg.class);
                        intent.putExtra("subchaptername",subchaptername1);
                        intent.putExtra("subchapImages",subchapImages1);
                        //intent.putExtra("sub1","sub1");
                        startActivity(intent);
                        break;
                    case "Plant Kingdom":
                        String[] subchaptername2 = {"Introduction Plantae","Division Thallophyta(Algae)","Division Bryophyta","Division Pteridophyta","Division Gymnospermae","Division Angiospermae","Plant life cycle and alternation of generation"};
                        int[] subchapImages2 = {R.drawable.android_1,R.drawable.angular,R.drawable.paint,R.drawable.atom,R.drawable.android_1,R.drawable.paint,R.drawable.angular,R.drawable.atom};
                        intent = new Intent(getApplicationContext(), listviewimg.class);
                        intent.putExtra("subchaptername",subchaptername2);
                        intent.putExtra("subchapImages",subchapImages2);
                        //intent.putExtra("sub1","sub1");
                        startActivity(intent);
                        break;

                    case "Animal Kingdom":
                        String[] subchaptername3 = {"Basis of classification","Phylum Porifera","Phylum Coelenterata(Cnidaria)","Phylum platyhelminthes","Phylum Aschelminthes","Phylum Annelida","Phylum Arthropoda","Phylum Mollusca","Phylum Echinodermata","Phylum Hemichordata","Phylum Chordata","Super Class Pisces","Super Class Tetrapoda"};
                        int[] subchapImages3 = {R.drawable.angular,R.drawable.paint,R.drawable.atom,R.drawable.android_1,R.drawable.paint,R.drawable.angular,R.drawable.android_1,R.drawable.angular,R.drawable.paint,R.drawable.atom,R.drawable.android_1,R.drawable.atom,R.drawable.android_1};
                        intent = new Intent(getApplicationContext(), listviewimg.class);
                        intent.putExtra("subchaptername",subchaptername3);
                        intent.putExtra("subchapImages",subchapImages3);
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
        String[] ModuleOne = {"The Living World", "Biological Classification", "Plant Kingdom", "Animal Kingdom"};
        String[] ModuleTwo = {"Morphology of Flowering Plants", "Anatomy of Flowering Plants ", "Structural Organisation in Animals"};
        String[] ModuleThree = {"Cell:The Unit of Life", "Biomolecules", "Cell Cycle"};
        String[] ModuleFour = {"Transport in Plants", "Mineral Nutrition", "Photosynthesis in Higher Plants", "Plant Growth and Development"};
        String[] ModuleFive = {"Digestion and Absorption", "Breathing and Exchange of Gases", "Body Fluids and Circulation", "Excretory Products and their Elimination", "Locomotion and Movement", "Neural Control and Coordination", "Chemical Coordination and Integration"};
        moduleCollection = new HashMap<String, List<String>>();
        for (String group : moduleList) {
            if (group.equals("Diversity in the living world")) {
                loadChild(ModuleOne);

            } else if (group.equals("Structural Organisation in Plants and Animals")) {
                loadChild(ModuleTwo);

            } else if (group.equals("Structure and Functions")) {
                loadChild(ModuleThree);

            } else if (group.equals("Plant Physiology")) {
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
        moduleList.add("Diversity in the living world");
        moduleList.add("Structural Organisation in Plants and Animals");
        moduleList.add("Structure and Functions");
        moduleList.add("Plant Physiology");
        moduleList.add("Human Physiology");
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


