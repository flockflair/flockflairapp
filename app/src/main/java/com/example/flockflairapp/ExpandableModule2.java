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
    List<Integer> groupList;
    List<Integer> childList;
    List<String> moduleList;
    List<String> chapterList;
    Map<Integer,List<Integer>> imageCollection;
    Map<String, List<String>> moduleCollection;
    ExpandableListView expandableListView;
    ExpandableListAdapter expandableListAdapter;
    FirebaseAuth firebaseAuth;
    ImageView back,questionofdayimg;

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

        questionofdayimg = findViewById(R.id.questionofdayimg);
        questionofdayimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent qtd = new Intent(ExpandableModule2.this, QuestionOfTheDay.class);
                startActivity(qtd);
            }
        });


        createmoduleList();
        createCollection();
        creategroupList();
        createchildList();
        expandableListView = findViewById(R.id.Modules);
        expandableListAdapter = new MyExpandableListAdapter(this, moduleList, moduleCollection,groupList,imageCollection);
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
                        String[] subchaptername = {"Introduction Reproduction in Organism","Asexual Reproduction","Sexual Reproduction","Pre- fertilization Events","Fertilization","Post fertilization Events"};
                        int[] subchapImages = {R.drawable.reproductioninorganism,R.drawable.reproductioninorganism,R.drawable.reproductioninorganism,R.drawable.reproductioninorganism,R.drawable.reproductioninorganism,R.drawable.reproductioninorganism};
                        intent = new Intent(getApplicationContext(), listviewimg.class);
                        intent.putExtra("subchaptername",subchaptername);
                        intent.putExtra("subchapImages",subchapImages);
                        String name = selected;
                        intent.putExtra("name",name);
                        startActivity(intent);
                        break;
                    case "Sexual Reproduction in Flowering Plants":
                        String[] subchaptername1 = {"Flower","Pre- fertilization: Structure and events","The pistil, megasporangium, and embryo sac","Pollination","Double Fertilization","Post- fertilization: structure and events","Embryo","Seed","Apomixis and polyembryony"};
                        int[] subchapImages1 = {R.drawable.sexualreproductioninflower,R.drawable.sexualreproductioninflower,R.drawable.sexualreproductioninflower,R.drawable.sexualreproductioninflower,R.drawable.sexualreproductioninflower,R.drawable.sexualreproductioninflower,R.drawable.sexualreproductioninflower,R.drawable.sexualreproductioninflower,R.drawable.sexualreproductioninflower};
                        intent = new Intent(getApplicationContext(), listviewimg.class);
                        intent.putExtra("subchaptername",subchaptername1);
                        intent.putExtra("subchapImages",subchapImages1);
                        String name1 = selected;
                        intent.putExtra("name",name1);
                        startActivity(intent);
                        break;
                    case "Human Reproduction":
                        String[] subchaptername2 = {"The Male Reproductive system","The Female Reproductive system","Gametogenesis","Menstrual cycle","Fertilization and Implantation","Pregnancy and Embryonic Development","Parturition and Lactation"};
                        int[] subchapImages2 = {R.drawable.humanreproduction,R.drawable.humanreproduction,R.drawable.humanreproduction,R.drawable.humanreproduction,R.drawable.humanreproduction,R.drawable.humanreproduction,R.drawable.humanreproduction};
                        intent = new Intent(getApplicationContext(), listviewimg.class);
                        intent.putExtra("subchaptername",subchaptername2);
                        intent.putExtra("subchapImages",subchapImages2);
                        String name2 = selected;
                        intent.putExtra("name",name2);
                        startActivity(intent);
                        break;
                    case "Reproductive Health":
                        String[] subchaptername3 = {"Reproductive health- problems and strategies","Population Explosion and Birth Control","Medical Termination of Pregnancy","Sexually Transmitted Infections","Infertility"};
                        int[] subchapImages3 = {R.drawable.reproductivehealth,R.drawable.reproductivehealth,R.drawable.reproductivehealth,R.drawable.reproductivehealth,R.drawable.reproductivehealth};
                        intent = new Intent(getApplicationContext(), listviewimg.class);
                        intent.putExtra("subchaptername",subchaptername3);
                        intent.putExtra("subchapImages",subchapImages3);
                        String name3 = selected;
                        intent.putExtra("name",name3);
                        startActivity(intent);
                        break;
                    case "Principles of Inheritance and Variation":
                        String[] subchaptername4 = {"Mendel's law of Inheritance","Inheritance if one gene","Incomplete Dominance","Co- dominance","Inheritance of two genes","Chromosomal theory of Inheritance","Linkage and Recombination","Polygenic Inheritance and Pleiotrophy","Sex determination","Mutation and Genetic disorders"};
                        int[] subchapImages4 = {R.drawable.principlesofinheritance,R.drawable.principlesofinheritance,R.drawable.principlesofinheritance,R.drawable.principlesofinheritance,R.drawable.principlesofinheritance,R.drawable.principlesofinheritance,R.drawable.principlesofinheritance,R.drawable.principlesofinheritance,R.drawable.principlesofinheritance,R.drawable.principlesofinheritance};
                        intent = new Intent(getApplicationContext(), listviewimg.class);
                        intent.putExtra("subchaptername",subchaptername4);
                        intent.putExtra("subchapImages",subchapImages4);
                        String name4 = selected;
                        intent.putExtra("name",name4);
                        startActivity(intent);
                        break;
                    case "Molecular Basis of Inheritance":
                        String[] subchaptername5 = {"The DNA","Packaging of DNA helix","The search for genetic material","Properties of genetic material and RNA world","Replication","Transcription","Genetic code","Translation","Regulation of gene Expression","Human genome project","DNA Fingerprinting"};
                        int[] subchapImages5 = {R.drawable.molecularbasis,R.drawable.molecularbasis,R.drawable.molecularbasis,R.drawable.molecularbasis,R.drawable.molecularbasis,R.drawable.molecularbasis,R.drawable.molecularbasis,R.drawable.molecularbasis,R.drawable.molecularbasis,R.drawable.molecularbasis,R.drawable.molecularbasis};
                        intent = new Intent(getApplicationContext(), listviewimg.class);
                        intent.putExtra("subchaptername",subchaptername5);
                        intent.putExtra("subchapImages",subchapImages5);
                        String name5 = selected;
                        intent.putExtra("name",name5);
                        startActivity(intent);
                        break;
                    case "Evolution":
                        String[] subchaptername6 = {"Origin of Life","Evolution of life forms- A theory","What are the evidences for Evolution?","What is adaptive Radiation?","Biological Evidence","Mechanism of Evolution and Hardy Weinberg Principle","A Brief account of Evolution","Origin and Evolution of Man"};
                        int[] subchapImages6 = {R.drawable.evolution,R.drawable.evolution,R.drawable.evolution,R.drawable.evolution,R.drawable.evolution,R.drawable.evolution,R.drawable.evolution,R.drawable.evolution};
                        intent = new Intent(getApplicationContext(), listviewimg.class);
                        intent.putExtra("subchaptername",subchaptername6);
                        intent.putExtra("subchapImages",subchapImages6);
                        String name6 = selected;
                        intent.putExtra("name",name6);
                        startActivity(intent);
                        break;
                    case "Human Health and Disease":
                        String[] subchaptername7 = {"Introduction Human Health and Disease","Common Diseases in Humans","Immunity","AIDS","Cancer","Drugs and Alcohol abuse"};
                        int[] subchapImages7 = {R.drawable.humanhealthdiseases,R.drawable.humanhealthdiseases,R.drawable.humanhealthdiseases,R.drawable.humanhealthdiseases,R.drawable.humanhealthdiseases,R.drawable.humanhealthdiseases};
                        intent = new Intent(getApplicationContext(), listviewimg.class);
                        intent.putExtra("subchaptername",subchaptername7);
                        intent.putExtra("subchapImages",subchapImages7);
                        String name7 = selected;
                        intent.putExtra("name",name7);
                        startActivity(intent);
                        break;
                    case "Stratergies for Enhancement in Food Production":
                        String[] subchaptername8 = {"Dairy and Poultry Farm management","Animal Breeding","Bee- keeping and Fisheries","What is Plant breeding","Plant breeding for Disease Resistance","Plant breeding for developing Resistance to Insect Pests","Plant breeding for Improved Food Quality","Single Cell protein","Tissue Culture"};
                        int[] subchapImages8 = {R.drawable.stratergiesenchancement,R.drawable.stratergiesenchancement,R.drawable.stratergiesenchancement,R.drawable.stratergiesenchancement,R.drawable.stratergiesenchancement,R.drawable.stratergiesenchancement,R.drawable.stratergiesenchancement,R.drawable.stratergiesenchancement,R.drawable.stratergiesenchancement};
                        intent = new Intent(getApplicationContext(), listviewimg.class);
                        intent.putExtra("subchaptername",subchaptername8);
                        intent.putExtra("subchapImages",subchapImages8);
                        String name8 = selected;
                        intent.putExtra("name",name8);
                        startActivity(intent);
                        break;
                    case "Microbes in Human Welfare":
                        String[] subchaptername9 = {"Introduction Microbes in Human Welfare","Microbes in Household Products","Microbes in Industrial Products","Microbes in Sewage treatment","Microbes in production of Biogas","Microbes as Biocontrol Agents","Microbes as Biofertilizers"};
                        int[] subchapImages9 = {R.drawable.microbesinwelfare,R.drawable.microbesinwelfare,R.drawable.microbesinwelfare,R.drawable.microbesinwelfare,R.drawable.microbesinwelfare,R.drawable.microbesinwelfare,R.drawable.microbesinwelfare};
                        intent = new Intent(getApplicationContext(), listviewimg.class);
                        intent.putExtra("subchaptername",subchaptername9);
                        intent.putExtra("subchapImages",subchapImages9);
                        String name9 = selected;
                        intent.putExtra("name",name9);
                        startActivity(intent);
                        break;
                    case "Biotechnology:Principles and Processes":
                        String[] subchaptername10 = {"Principles of Biotechnology","Tools of Recombinant DNA technology- Restriction Enzymes","Cloning Vectors","Competent Host (For Transformation with Recombinant DNA)","Processes of Recombinant DNA Technology"};
                        int[] subchapImages10 = {R.drawable.biotechnology,R.drawable.biotechnology,R.drawable.biotechnology,R.drawable.biotechnology,R.drawable.biotechnology};
                        intent = new Intent(getApplicationContext(), listviewimg.class);
                        intent.putExtra("subchaptername",subchaptername10);
                        intent.putExtra("subchapImages",subchapImages10);
                        String name10 = selected;
                        intent.putExtra("name",name10);
                        startActivity(intent);
                        break;
                    case "Biotechnology and its Applications":
                        String[] subchaptername11 = {"Biotechnological applications in Agriculture","Biotechnological applications in Medicine","Transgenic Animals","Ethical Issues"};
                        int[] subchapImages11 = {R.drawable.bioapplications,R.drawable.bioapplications,R.drawable.bioapplications,R.drawable.bioapplications};
                        intent = new Intent(getApplicationContext(), listviewimg.class);
                        intent.putExtra("subchaptername",subchaptername11);
                        intent.putExtra("subchapImages",subchapImages11);
                        String name11 = selected;
                        intent.putExtra("name",name11);
                        startActivity(intent);
                        break;
                    case "Organisms and Population":
                        String[] subchaptername12 = {"Organisms and its environment","Responses to Abiotic Factors and Adaptations","Population","Population Growth","Population Interactions"};
                        int[] subchapImages12 = {R.drawable.population,R.drawable.population,R.drawable.population,R.drawable.population,R.drawable.population};
                        intent = new Intent(getApplicationContext(), listviewimg.class);
                        intent.putExtra("subchaptername",subchaptername12);
                        intent.putExtra("subchapImages",subchapImages12);
                        String name12 = selected;
                        intent.putExtra("name",name12);
                        startActivity(intent);
                        break;
                    case "Ecosystem":
                        String[] subchaptername13 = {"Ecosystem- Structure and Function","Productivity","Decomposition","Energy Flow","Ecological Pyramids","Ecological Succession","Nutrient Cycling","Ecosystem Services"};
                        int[] subchapImages13 = {R.drawable.ecosystem,R.drawable.ecosystem,R.drawable.ecosystem,R.drawable.ecosystem,R.drawable.ecosystem,R.drawable.ecosystem,R.drawable.ecosystem,R.drawable.ecosystem};
                        intent = new Intent(getApplicationContext(), listviewimg.class);
                        intent.putExtra("subchaptername",subchaptername13);
                        intent.putExtra("subchapImages",subchapImages13);
                        String name13 = selected;
                        intent.putExtra("name",name13);
                        startActivity(intent);
                        break;
                    case "Biodiversity and Conservation":
                        String[] subchaptername14 = {"Biodiversity","Patterns of Biodiversity","The Importance of Species Diversity to the Ecosystem","Loss of Biodiversity","Biodiversity Conservation"};
                        int[] subchapImages14 = {R.drawable.biodiversity,R.drawable.biodiversity,R.drawable.biodiversity,R.drawable.biodiversity,R.drawable.biodiversity};
                        intent = new Intent(getApplicationContext(), listviewimg.class);
                        intent.putExtra("subchaptername",subchaptername14);
                        intent.putExtra("subchapImages",subchapImages14);
                        String name14 = selected;
                        intent.putExtra("name",name14);
                        startActivity(intent);
                        break;
                    case "Environmental Issues":
                        String[] subchaptername15 = {"Air Pollution and its control","Water Pollution and its control","Solid wastes","Agro- chemicals and their effects","Radioactive waste, Greenhouse Effect and Global Warming","Ozone Depletion in the Stratosphere","Degradation by improper Resource Utilization and maintenance","Deforestation"};
                        int[] subchapImages15 = {R.drawable.environmentalsys,R.drawable.environmentalsys,R.drawable.environmentalsys,R.drawable.environmentalsys,R.drawable.environmentalsys,R.drawable.environmentalsys,R.drawable.environmentalsys,R.drawable.environmentalsys};
                        intent = new Intent(getApplicationContext(), listviewimg.class);
                        intent.putExtra("subchaptername",subchaptername15);
                        intent.putExtra("subchapImages",subchapImages15);
                        String name15 = selected;
                        intent.putExtra("name",name15);
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
        String[] ModuleOne = {"Reproduction in Organism", "Sexual Reproduction in Flowering Plants", "Human Reproduction", "Reproductive Health"};
        String[] ModuleTwo = {"Principles of Inheritance and Variation", "Molecular Basis of Inheritance", "Evolution"};
        String[] ModuleThree = {"Human Health and Disease", "Stratergies for Enhancement in Food Production", "Microbes in Human Welfare"};
        String[] ModuleFour = {"Biotechnology:Principles and Processes", "Biotechnology and its Applications"};
        String[] ModuleFive = {"Organisms and Population", "Ecosystem", "Biodiversity and Conservation", "Environmental Issues"};
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


    private void createchildList()
    {
        Integer[] ChapterOne ={R.drawable.reproductioninorganism,R.drawable.sexualreproductioninflower,R.drawable.humanreproduction,R.drawable.reproductivehealth};
        Integer[] ChapterTwo ={R.drawable.principlesofinheritance,R.drawable.molecularbasis,R.drawable.evolution};
        Integer[] ChapterThree ={R.drawable.humanhealthdiseases,R.drawable.stratergiesenchancement,R.drawable.microbesinwelfare};
        Integer[] ChapterFour ={R.drawable.biotechnology,R.drawable.bioapplications};
        Integer[] ChapterFive ={R.drawable.population,R.drawable.ecosystem,R.drawable.biodiversity,R.drawable.environmentalsys};
        imageCollection = new HashMap<Integer, List<Integer>>();
        for(Integer group1 : groupList)
        {
            if(group1.equals(R.drawable.atom))
            {
                loadChild1(ChapterOne);
            }
            else if(group1.equals(R.drawable.angular))
            {
                loadChild1(ChapterTwo);
            }
            else if(group1.equals(R.drawable.paint))
            {
                loadChild1(ChapterThree);
            }
            else if(group1.equals(R.drawable.android_1))
            {
                loadChild1(ChapterFour);
            }
            else
            {
                loadChild1(ChapterFive);
            }
            imageCollection.put(group1,childList);

        }
    }

    private void loadChild1(Integer[] Chapter) {
        childList = new ArrayList<>();
        for (int chapter : Chapter) {
            childList.add(chapter);

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

    private void creategroupList() {
        groupList = new ArrayList<>();
        groupList.add(R.drawable.atom);
        groupList.add(R.drawable.angular);
        groupList.add(R.drawable.paint);
        groupList.add(R.drawable.android_1);
        groupList.add(R.drawable.android4);
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


