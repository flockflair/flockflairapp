package com.example.flockflairapp;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
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
    List<Integer> groupList; //image list for modules
    List<Integer> childList; //image list for chapters
    List<String> moduleList; //list of modules
    List<String> chapterList; // list of chapters
    Map<Integer,List<Integer>> imageCollection;
    Map<String, List<String>> moduleCollection;
    ExpandableListView expandableListView;
    ExpandableListAdapter expandableListAdapter;
    FirebaseAuth firebaseAuth;
    ImageView back,questionofdayimg;
    TextView item;
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        firebaseAuth = FirebaseAuth.getInstance();
        user = FirebaseAuth.getInstance().getCurrentUser().getUid(); //get user
        reference = FirebaseDatabase.getInstance().getReference("user"); //user refrence
        final TextView greet =findViewById(R.id.StudentName);
        item = (TextView)findViewById(R.id.modules);
        reference.child(user).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                final TextView greet =findViewById(R.id.StudentName);
                HashMap<String,String> hash = new HashMap<>();
                hash.put("name",snapshot.child("name").getValue(String.class));
                greet.setText("Welcome "+hash.get("name") +"!");  //welcome text
                reference.keepSynced(true);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getApplicationContext(),"Something went wrong",LENGTH_SHORT).show();

            }
        });
        setContentView(R.layout.expandablemodule);
        questionofdayimg = findViewById(R.id.questionofdayimg);

        questionofdayimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent qtd = new Intent(ExpandableModule1.this, QuestionOfTheDay.class);
                qtd.putExtra("STD11",11);
                startActivity(qtd);
            }
        });

        createmoduleList();
        createCollection();
        creategroupList();
        createchildList();
        expandableListView = findViewById(R.id.Modules);
        expandableListAdapter = new MyExpandableListAdapter(this, moduleList, moduleCollection,groupList,imageCollection); //set adapter
        expandableListView.setAdapter(expandableListAdapter); //set adapter
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
                Intent intent;
                //chapter names

                switch (selected) {
                    case "The Living World": //chapter name
                        String name = selected; //string name
                        String[] subchaptername = {"What is living world?","Diversity in the living","Taxonomic categories","Taxonomic Aids"}; //sub chapters
                        int[] subchapImages = {R.drawable.livingworld,R.drawable.livingworld,R.drawable.livingworld,R.drawable.livingworld,R.drawable.livingworld,R.drawable.livingworld,R.drawable.livingworld}; //sub chapter images
                        intent = new Intent(getApplicationContext(), listviewimg.class);
                        intent.putExtra("subchaptername",subchaptername);
                        intent.putExtra("subchapImages",subchapImages);
                        intent.putExtra("name",name);
                        startActivity(intent);
                        break;
                    case "Biological Classification":
                        String[] subchaptername1 = {"Introduction Biological Classification","Kingdom Monera","Kingdom Protista","Kingdom Fungi","Kingdom Plantae and Kingdom Animalia","Virus, viroids, prions, lichens"};
                        int[] subchapImages1 = {R.drawable.biologicalclassification,R.drawable.biologicalclassification,R.drawable.biologicalclassification,R.drawable.biologicalclassification,R.drawable.biologicalclassification,R.drawable.biologicalclassification,R.drawable.biologicalclassification};
                        intent = new Intent(getApplicationContext(), listviewimg.class);
                        intent.putExtra("subchaptername",subchaptername1);
                        intent.putExtra("subchapImages",subchapImages1);
                        String name1 = selected;
                        intent.putExtra("name",name1);
                        startActivity(intent);
                        break;
                    case "Plant Kingdom":

                        String[] subchaptername2 = {"Introduction Plantae","Division Thallophyta(Algae)","Division Bryophyta","Division Pteridophyta","Division Gymnospermae","Division Angiospermae","Plant life cycle and alternation of generation"};
                        int[] subchapImages2 = {R.drawable.plantkingdom,R.drawable.plantkingdom,R.drawable.plantkingdom,R.drawable.plantkingdom,R.drawable.plantkingdom,R.drawable.plantkingdom,R.drawable.plantkingdom,R.drawable.plantkingdom};
                        intent = new Intent(getApplicationContext(), listviewimg.class);
                        intent.putExtra("subchaptername",subchaptername2);
                        intent.putExtra("subchapImages",subchapImages2);
                        String name2 = selected;
                        intent.putExtra("name",name2);
                        startActivity(intent);
                        break;

                    case "Animal Kingdom":
                        String[] subchaptername3 = {"Basis of classification","Phylum Porifera","Phylum Coelenterata(Cnidaria)","Phylum platyhelminthes","Phylum Aschelminthes","Phylum Annelida","Phylum Arthropoda","Phylum Mollusca","Phylum Echinodermata","Phylum Hemichordata","Phylum Chordata","Super Class Pisces","Super Class Tetrapoda"};
                        int[] subchapImages3 = {R.drawable.animalkingdom,R.drawable.animalkingdom,R.drawable.animalkingdom,R.drawable.animalkingdom,R.drawable.animalkingdom,R.drawable.animalkingdom,R.drawable.animalkingdom,R.drawable.animalkingdom,R.drawable.animalkingdom,R.drawable.animalkingdom,R.drawable.animalkingdom,R.drawable.animalkingdom,R.drawable.animalkingdom};
                        intent = new Intent(getApplicationContext(), listviewimg.class);
                        intent.putExtra("subchaptername",subchaptername3);
                        intent.putExtra("subchapImages",subchapImages3);
                        String name3 = selected;
                        intent.putExtra("name",name3);
                        startActivity(intent);
                        break;
                    case "Morphology of Flowering Plants":
                        String[] subchaptername4 = {"The Root","The Stem","The Leaf","The inflorescence and The Flower","The Fruit and The seed","Description of a typical flowering plant and some important families"};
                        int[] subchapImages4 = {R.drawable.morphologyoffloweringplants,R.drawable.morphologyoffloweringplants,R.drawable.morphologyoffloweringplants,R.drawable.morphologyoffloweringplants,R.drawable.morphologyoffloweringplants,R.drawable.morphologyoffloweringplants};
                        intent = new Intent(getApplicationContext(), listviewimg.class);
                        intent.putExtra("subchaptername",subchaptername4);
                        intent.putExtra("subchapImages",subchapImages4);
                        String name4 = selected;
                        intent.putExtra("name",name4);
                        startActivity(intent);
                        break;
                    case "Anatomy of Flowering Plants":
                        String[] subchaptername5 = {"Meristematic tissue","Permanent tissue","The tissue system","Anatomy of Dicotyledonous and Monocotyledonous Plants","Secondary growth"};
                        int[] subchapImages5 = {R.drawable.anatomyoffloweringplants,R.drawable.anatomyoffloweringplants,R.drawable.anatomyoffloweringplants,R.drawable.anatomyoffloweringplants,R.drawable.anatomyoffloweringplants};
                        intent = new Intent(getApplicationContext(), listviewimg.class);
                        intent.putExtra("subchaptername",subchaptername5);
                        intent.putExtra("subchapImages",subchapImages5);
                        String name5 = selected;
                        intent.putExtra("name",name5);
                        startActivity(intent);
                        break;
                    case "Structural Organisation in Animals":
                        String[] subchaptername6 = {"Epithelial Tissue","Connective Tissue","Muscular Tissue","Nervous Tissue","Earthworm","Cockroach","Frog"};
                        int[] subchapImages6 = {R.drawable.structuralorganisation,R.drawable.structuralorganisation,R.drawable.structuralorganisation,R.drawable.structuralorganisation,R.drawable.structuralorganisation,R.drawable.structuralorganisation,R.drawable.structuralorganisation};
                        intent = new Intent(getApplicationContext(), listviewimg.class);
                        intent.putExtra("subchaptername",subchaptername6);
                        intent.putExtra("subchapImages",subchapImages6);
                        String name6 = selected;
                        intent.putExtra("name",name6);
                        startActivity(intent);
                        break;
                    case "Cell:The Unit of Life":
                        String[] subchaptername7 = {"Cell theory, an overview of cell","Prokaryotic cell","Eukaryotic cell- Cell membrane, Cell wall, Endomembrane system","Eukaryotic cell- Mitochondria, Plastids, Ribosomes, Cytoskeleton","Eukaryotic cell- Cilia and Flagella, Centrosome and Centrioles, Nucleus, Microbodies"};
                        int[] subchapImages7 = {R.drawable.cellunitoflife,R.drawable.cellunitoflife,R.drawable.cellunitoflife,R.drawable.cellunitoflife,R.drawable.cellunitoflife};
                        intent = new Intent(getApplicationContext(), listviewimg.class);
                        intent.putExtra("subchaptername",subchaptername7);
                        intent.putExtra("subchapImages",subchapImages7);
                        String name7 = selected;
                        intent.putExtra("name",name7);
                        startActivity(intent);
                        break;
                    case "Biomolecules":
                        String[] subchaptername8 = {"How to analyse Chemical Composition?","Primary and Secondary Metabolites, Biomacromolecules","Proteins and Structure of Proteins","Polysaccharides","Nucleic Acids","Nature of bond linking Monomers in a Polymer and Dynamic State of body constituents- Concepts of Metabolism","Metabolic Basis for living and The Living State","Enzymes and co-factors"};
                        int[] subchapImages8 = {R.drawable.biomolecules,R.drawable.biomolecules,R.drawable.biomolecules,R.drawable.biomolecules,R.drawable.biomolecules,R.drawable.biomolecules,R.drawable.biomolecules,R.drawable.biomolecules};
                        intent = new Intent(getApplicationContext(), listviewimg.class);
                        intent.putExtra("subchaptername",subchaptername8);
                        intent.putExtra("subchapImages",subchapImages8);
                        String name8 = selected;
                        intent.putExtra("name",name8);
                        startActivity(intent);
                        break;
                    case "Cell Cycle":
                        String[] subchaptername9 = {"Cell Cycle","Prophase","Metaphase","Anaphase","Telophase, cytokinesis and significance of Mitosis","Meiosis","Meiosis-1","Meiosis- 2 and significance of Meiosis"};
                        int[] subchapImages9 = {R.drawable.cellcycle,R.drawable.cellcycle,R.drawable.cellcycle,R.drawable.cellcycle,R.drawable.cellcycle,R.drawable.cellcycle,R.drawable.cellcycle,R.drawable.cellcycle};
                        intent = new Intent(getApplicationContext(), listviewimg.class);
                        intent.putExtra("subchaptername",subchaptername9);
                        intent.putExtra("subchapImages",subchapImages9);
                        String name9 = selected;
                        intent.putExtra("name",name9);
                        startActivity(intent);
                        break;
                    case "Transport in Plants":
                        String[] subchaptername10 = {"Means of Transport","Plant water Relation","Long Distance Transport of Water","Transpiration","Uptake and Transport of Mineral Nutrients, Phloem Transport"};
                        int[] subchapImages10 = {R.drawable.transportinplants,R.drawable.transportinplants,R.drawable.transportinplants,R.drawable.transportinplants,R.drawable.transportinplants};
                        intent = new Intent(getApplicationContext(), listviewimg.class);
                        intent.putExtra("subchaptername",subchaptername10);
                        intent.putExtra("subchapImages",subchapImages10);
                        String name10 = selected;
                        intent.putExtra("name",name10);
                        startActivity(intent);
                        break;
                    case "Mineral Nutrition":
                        String[] subchaptername11 = {"Methods to study the mineral requirements of Plants","Essential Mineral Elements","Mechanism of Absorption of Elements, Translocation of salutes, Soil as Reservoir","Nitrogen cycle and Biological Nitrogen Fixation"};
                        int[] subchapImages11 = {R.drawable.mineralnutrition,R.drawable.mineralnutrition,R.drawable.mineralnutrition,R.drawable.mineralnutrition};
                        intent = new Intent(getApplicationContext(), listviewimg.class);
                        intent.putExtra("subchaptername",subchaptername11);
                        intent.putExtra("subchapImages",subchapImages11);
                        String name11 = selected;
                        intent.putExtra("name",name11);
                        startActivity(intent);
                        break;
                    case "Photosynthesis in Higher Plants":
                        String[] subchaptername12 = {"Introduction and Early Experiments","Where does Photosynthesis take place?","How many Types of Pigments are involved in Photosynthesis?","What is Light Reaction?","The Electron Transport","Where are the ATP and NADPH used?","The Calvin Cycle","The C4 pathway","Photorespiration","Factors affecting Photosynthesis"};
                        int[] subchapImages12 = {R.drawable.photosynthesisinhigherplants,R.drawable.photosynthesisinhigherplants,R.drawable.photosynthesisinhigherplants,R.drawable.photosynthesisinhigherplants,R.drawable.photosynthesisinhigherplants,R.drawable.photosynthesisinhigherplants,R.drawable.photosynthesisinhigherplants,R.drawable.photosynthesisinhigherplants,R.drawable.photosynthesisinhigherplants,R.drawable.photosynthesisinhigherplants};
                        intent = new Intent(getApplicationContext(), listviewimg.class);
                        intent.putExtra("subchaptername",subchaptername12);
                        intent.putExtra("subchapImages",subchapImages12);
                        String name12 = selected;
                        intent.putExtra("name",name12);
                        startActivity(intent);
                        break;
                    case "Respiration in Plants":
                        String[] subchaptername13 = {"Introduction Respiration in Plants","Glycolysis","Fermentation","Aerobic Respiration","Tricarboxylic Acid Cycle","Electron Transport System (ETS) and oxidative Phosphorylation","The Respiratory Balance Sheet,  Amphibolic Pathway and Respiratory Quotient"};
                        int[] subchapImages13 = {R.drawable.respiration,R.drawable.respiration,R.drawable.respiration,R.drawable.respiration,R.drawable.respiration,R.drawable.respiration,R.drawable.respiration};
                        intent = new Intent(getApplicationContext(), listviewimg.class);
                        intent.putExtra("subchaptername",subchaptername13);
                        intent.putExtra("subchapImages",subchapImages13);
                        String name13 = selected;
                        intent.putExtra("name",name13);
                        startActivity(intent);
                        break;
                    case "Plant Growth and Development":
                        String[] subchaptername14 = {"Growth","Phases of growth, Growth Rate, Conditions for Growth","Differentiation, Dedifferentiation and Redifferentiation","Development","Plant Growth Regulators- Introduction","Auxin","Gibberllins","Cytokinins","Ethylene","Abscisic Acid","Photoperiodism","Vernalisation and Seed Dormancy"};
                        int[] subchapImages14 = {R.drawable.plantgrowth,R.drawable.plantgrowth,R.drawable.plantgrowth,R.drawable.plantgrowth,R.drawable.plantgrowth,R.drawable.plantgrowth,R.drawable.plantgrowth,R.drawable.plantgrowth,R.drawable.plantgrowth,R.drawable.plantgrowth,R.drawable.plantgrowth,R.drawable.plantgrowth};
                        intent = new Intent(getApplicationContext(), listviewimg.class);
                        intent.putExtra("subchaptername",subchaptername14);
                        intent.putExtra("subchapImages",subchapImages14);
                        String name14 = selected;
                        intent.putExtra("name",name14);
                        startActivity(intent);
                        break;
                    case "Digestion and Absorption":
                        String[] subchaptername15 = {"Alimentary canal","Digestive Glands","Digestion of Food","Absorption of Digested Products","Disorders of Digestive System"};
                        int[] subchapImages15 = {R.drawable.digestionandabsorption,R.drawable.digestionandabsorption,R.drawable.digestionandabsorption,R.drawable.digestionandabsorption,R.drawable.digestionandabsorption};
                        intent = new Intent(getApplicationContext(), listviewimg.class);
                        intent.putExtra("subchaptername",subchaptername15);
                        intent.putExtra("subchapImages",subchapImages15);
                        String name15 = selected;
                        intent.putExtra("name",name15);
                        startActivity(intent);
                        break;
                    case "Breathing and Exchange of Gases":
                        String[] subchaptername16 = {"Introduction Breathing and Exchange of Gases","Human Respiratory system","Mechanism of Breathing","Exchange of Gases","Transport of Gases","Regulation of respiration and Disorders of Respiratory System"};
                        int[] subchapImages16 = {R.drawable.breathing,R.drawable.breathing,R.drawable.breathing,R.drawable.breathing,R.drawable.breathing,R.drawable.breathing};
                        intent = new Intent(getApplicationContext(), listviewimg.class);
                        intent.putExtra("subchaptername",subchaptername16);
                        intent.putExtra("subchapImages",subchapImages16);
                        String name16 = selected;
                        intent.putExtra("name",name16);
                        startActivity(intent);
                        break;
                    case "Body Fluids and Circulation":
                        String[] subchaptername17 = {"Blood","Blood Groups","Coagulation of Blood","Lymph","Circulatory Pathway","Human Circulatory System","Cardiac cycle","Electrocardiograph (ECG)","Double Circulation","Regulation of Cardiac Activity and Disorders of Circulatory System"};
                        int[] subchapImages17 = {R.drawable.bodyfluids,R.drawable.bodyfluids,R.drawable.bodyfluids,R.drawable.bodyfluids,R.drawable.bodyfluids,R.drawable.bodyfluids,R.drawable.bodyfluids,R.drawable.bodyfluids,R.drawable.bodyfluids,R.drawable.bodyfluids};
                        intent = new Intent(getApplicationContext(), listviewimg.class);
                        intent.putExtra("subchaptername",subchaptername17);
                        intent.putExtra("subchapImages",subchapImages17);
                        String name17 = selected;
                        intent.putExtra("name",name17);
                        startActivity(intent);
                        break;
                    case "Excretory Products and their Elimination":
                        String[] subchaptername18 = {"Introduction Excretory Products and their Elimination","Human Excretory System","Urine Formation","Function of the Tubules","Mechanism of Concentration of the Filtrate","Regulation of Kidney Function and  Micturition","Role of other organs in Excretion and Disorders of the Excretory System"};
                        int[] subchapImages18 = {R.drawable.excretoryproducts,R.drawable.excretoryproducts,R.drawable.excretoryproducts,R.drawable.excretoryproducts,R.drawable.excretoryproducts,R.drawable.excretoryproducts,R.drawable.excretoryproducts};
                        intent = new Intent(getApplicationContext(), listviewimg.class);
                        intent.putExtra("subchaptername",subchaptername18);
                        intent.putExtra("subchapImages",subchapImages18);
                        String name18 = selected;
                        intent.putExtra("name",name18);
                        startActivity(intent);
                        break;
                    case "Locomotion and Movement":
                        String[] subchaptername19 = {"Types of Movement","Muscle","Structure of contractile Proteins and Mechanism of Muscle Contraction","Skeletal System- Axial skeleton","Skeletal System- Appendicular skeleton","Joints","Disorders of Muscular and Skeleton System"};
                        int[] subchapImages19 = {R.drawable.locomotion,R.drawable.locomotion,R.drawable.locomotion,R.drawable.locomotion,R.drawable.locomotion,R.drawable.locomotion,R.drawable.locomotion};
                        intent = new Intent(getApplicationContext(), listviewimg.class);
                        intent.putExtra("subchaptername",subchaptername19);
                        intent.putExtra("subchapImages",subchapImages19);
                        String name19 = selected;
                        intent.putExtra("name",name19);
                        startActivity(intent);
                        break;
                    case "Neural Control and Coordination":
                        String[] subchaptername20 = {"Introduction Neural Control and Coordination","Human Neural System","Neuron as Structural and Functional Unit of Neural System","Generation and Conduction of Nerve Impulse","Transmission of Impulses","Central Neural System","Reflex Action and Reflex Arc","Sensory Reception ans Processing","Eye","The Ear"};
                        int[] subchapImages20 = {R.drawable.neuralcontrol,R.drawable.neuralcontrol,R.drawable.neuralcontrol,R.drawable.neuralcontrol,R.drawable.neuralcontrol,R.drawable.neuralcontrol,R.drawable.neuralcontrol,R.drawable.neuralcontrol,R.drawable.neuralcontrol,R.drawable.neuralcontrol};
                        intent = new Intent(getApplicationContext(), listviewimg.class);
                        intent.putExtra("subchaptername",subchaptername20);
                        intent.putExtra("subchapImages",subchapImages20);
                        String name20 = selected;
                        intent.putExtra("name",name20);
                        startActivity(intent);
                        break;
                    case "Chemical Coordination and Integration":
                        String[] subchaptername21 = {"Human Endocrine System","The Hypothalamus","The Pituitary Gland","The Pineal Gland","Thyroid Gland","Parathyroid Gland","Thymus","Adrenal Gland","Pancreas","Testis","Ovary","Hormones of Heart, Kidney, Gastrointestinal tract and Mechanism of Hormone Action"};
                        int[] subchapImages21 = {R.drawable.chemicalcordination,R.drawable.chemicalcordination,R.drawable.chemicalcordination,R.drawable.chemicalcordination,R.drawable.chemicalcordination,R.drawable.chemicalcordination,R.drawable.chemicalcordination,R.drawable.chemicalcordination,R.drawable.chemicalcordination,R.drawable.chemicalcordination,R.drawable.chemicalcordination,R.drawable.chemicalcordination};
                        intent = new Intent(getApplicationContext(), listviewimg.class);
                        intent.putExtra("subchaptername",subchaptername21);
                        intent.putExtra("subchapImages",subchapImages21);
                        String name21 = selected;
                        intent.putExtra("name",name21);
                        startActivity(intent);
                        break;
                }
                return true;
            }
        });
        back = (ImageView)findViewById(R.id.backbuttonimg); //back button
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
            }
        });
        //bottom nav
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.home);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId())
                {
                    case R.id.dashboard: //bookmark
                        startActivity(new Intent(getApplicationContext(),BookmarkActivity.class));
                        overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
                        return true;
                    case R.id.home:  //home
                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
                        return true;
                    case R.id.about:  //profile
                        startActivity(new Intent(getApplicationContext(),UpdateProfile.class));
                        overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
                        return true;
                }return false;

            }
        });

    }


    private void createCollection() {
        //chapter name list
        String[] ModuleOne = {"The Living World", "Biological Classification", "Plant Kingdom", "Animal Kingdom"};
        String[] ModuleTwo = {"Morphology of Flowering Plants", "Anatomy of Flowering Plants", "Structural Organisation in Animals"};
        String[] ModuleThree = {"Cell:The Unit of Life", "Biomolecules", "Cell Cycle"};
        String[] ModuleFour = {"Transport in Plants", "Mineral Nutrition", "Photosynthesis in Higher Plants","Respiration in Plants", "Plant Growth and Development"};
        String[] ModuleFive = {"Digestion and Absorption", "Breathing and Exchange of Gases", "Body Fluids and Circulation", "Excretory Products and their Elimination", "Locomotion and Movement", "Neural Control and Coordination", "Chemical Coordination and Integration"};
        moduleCollection = new HashMap<String, List<String>>();
        for (String group : moduleList) {
            //module list
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
    private void createchildList()
    {
        //chapter images
        Integer[] ChapterOne ={R.drawable.livingworld,R.drawable.biologicalclassification,R.drawable.plantkingdom,R.drawable.animalkingdom};
        Integer[] ChapterTwo ={R.drawable.morphologyoffloweringplants,R.drawable.anatomyoffloweringplants,R.drawable.structuralorganisation};
        Integer[] ChapterThree ={R.drawable.cellunitoflife,R.drawable.biomolecules,R.drawable.cellcycle};
        Integer[] ChapterFour ={R.drawable.transportinplants,R.drawable.mineralnutrition,R.drawable.photosynthesisinhigherplants,R.drawable.respiration,R.drawable.plantgrowth};
        Integer[] ChapterFive ={R.drawable.digestionandabsorption,R.drawable.breathing,R.drawable.bodyfluids,R.drawable.excretoryproducts,R.drawable.locomotion,R.drawable.neuralcontrol,R.drawable.chemicalcordination};
        imageCollection = new HashMap<Integer, List<Integer>>();
        for(Integer group1 : groupList)
        {
            //module images
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

    private void loadChild(String[] Module) {
        chapterList = new ArrayList<>();
        for (String model : Module) {
            chapterList.add(model);

        }

    }

    private void loadChild1(Integer[] Chapter) {
        childList = new ArrayList<>();
        for (int chapter : Chapter) {
            childList.add(chapter);

        }

    }

    private void createmoduleList() {
        //module list
        moduleList = new ArrayList<>();
        moduleList.add("Diversity in the living world");
        moduleList.add("Structural Organisation in Plants and Animals");
        moduleList.add("Structure and Functions");
        moduleList.add("Plant Physiology");
        moduleList.add("Human Physiology");
    }

    private void creategroupList() {
        //module images to bind with chapters
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


