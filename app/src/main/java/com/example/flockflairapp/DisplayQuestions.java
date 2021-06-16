package com.example.flockflairapp;

import android.animation.Animator;
import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Vibrator;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class DisplayQuestions extends AppCompatActivity {

    private final String TAG = "DisplayQuestions";
    public static final int MAX_BOOKMARKS = 50;
    //instance of firebase
    FirebaseDatabase db = FirebaseDatabase.getInstance();
    DatabaseReference dbRef = db.getReference();
    //bookmarkRef
    DatabaseReference dbBookmarks = db.getReference("user");
    //haptic for wrong option
    private Vibrator vibrator;
    //progressDailog
    private ProgressDialog pg;
    //textview
    private TextView tvQuestions, difficulty;
    //private TextView tvTotal;
    private LinearLayout linearLayout;
    //Bookmarks
    private FloatingActionButton bookMarks;
    //next button
    private Button next_btn,prev_btn;
    private Button explanation_btn;
    //question model list
    private List<QuestionModel> list;
    int count = 0;

    private List<QuestionModel> BookMarkList;
    //random number for question
    //Random rand = new Random();
    //int position= rand.nextInt(20-2)+2;
    int position = 0;
    //for user id
     String uuid = FirebaseAuth.getInstance().getCurrentUser().getUid();

    String[] ModuleOneChapterName = {"The Living World", "Biological Classification", "Plant Kingdom", "Animal Kingdom"};
    String[] ModuleTwoChapterName = {"Morphology of Flowering Plants", "Anatomy of Flowering Plants", "Structural Organisation in Animals"};
    String[] ModuleThreeChapterName = {"Cell:The Unit of Life", "Biomolecules", "Cell Cycle"};
    String[] ModuleFourChapterName = {"Transport in Plants", "Mineral Nutrition", "Photosynthesis in Higher Plants","Respiration in Plants", "Plant Growth and Development"};
    String[] ModuleFiveChapterName = {"Digestion and Absorption", "Breathing and Exchange of Gases", "Body Fluids and Circulation", "Excretory Products and their Elimination",
                                        "Locomotion and Movement", "Neural Control and Coordination", "Chemical Coordination and Integration"};

    String[] ModuleName = {"Diversity In The Living World","Structural Organisation in Plants and Animals","Structure and Functions","Plant Physiology","Human Physiology"};


    String[] ModuleOneChapterName12 = {"Reproduction in Organism", "Sexual Reproduction in Flowering Plants", "Human Reproduction", "Reproductive Health"};
    String[] ModuleTwoChapterName12 = {"Principles of Inheritance and Variation", "Molecular Basis of Inheritance", "Evolution"};
    String[] ModuleThreeChapterName12 = {"Human Health and Disease", "Stratergies for Enhancement in Food Production", "Microbes in Human Welfare"};
    String[] ModuleFourChapterName12 = {"Biotechnology:Principles and Processes", "Biotechnology and its Applications"};
    String[] ModuleFiveChapterName12 = {"Organisms and Population", "Ecosystem", "Biodiversity and Conservation", "Environmental Issues"};

    String[] ModuleName12 = {"Reproduction","Genetics and Evolution","Biology in Human Welfare","Biotechnology","Ecology"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_questions);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE,WindowManager.LayoutParams.FLAG_SECURE);

        tvQuestions = findViewById(R.id.tvQuestions);
        //tvTotal = findViewById(R.id.tvTotal);
        linearLayout = findViewById(R.id.linearLayout);
        bookMarks = findViewById(R.id.floatingActionButton5);
        next_btn = findViewById(R.id.buttonNext);
        prev_btn = findViewById(R.id.buttonPrev);
        vibrator = (Vibrator) this.getSystemService(VIBRATOR_SERVICE);
        difficulty = (TextView)findViewById(R.id.difficulty);
        explanation_btn = findViewById(R.id.buttonExplain);

        next_btn.setAlpha(0.7f);
        explanation_btn.setAlpha(0.7f);


        BookMarkList = new ArrayList<>();

        dbBookmarks.child(uuid).child("Bookmarks").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot ds:snapshot.getChildren()){
                    BookMarkList.add(ds.getValue(QuestionModel.class));
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.d(TAG, error.getMessage());
            }
        });

        //prevent screenCapture
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE,WindowManager.LayoutParams.FLAG_SECURE);

        //bookmark button on displayQuestion
        bookMarks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //bookmark & unbookmark
                if (modelMatch()){
                    bookMarks.setImageDrawable(getDrawable(R.drawable.ic_baseline_bookmark_border_24));
                    //Query for removing bookmarks for displayQuestion activity
                    Query displayQueryUnBookmark = dbBookmarks.child(uuid).child("Bookmarks").orderByChild("question").equalTo(list.get(position).getQuestion());

                    displayQueryUnBookmark.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            for (DataSnapshot dataSnapshot:snapshot.getChildren()){
                                dataSnapshot.getRef().removeValue();
                                Toast.makeText(DisplayQuestions.this, "Bookmark removed", Toast.LENGTH_SHORT).show();
                            }
                        }
                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {
                            Log.d(TAG, "error" + error.getMessage());
                        }
                    });
                }else{
                    //limit for bookmark size
                    if (BookMarkList.size() < MAX_BOOKMARKS){
                        //save bookmark in database
                        QuestionModel questionModel = new QuestionModel(list.get(position).getQuestion(), list.get(position).getOptionA(),
                                list.get(position).getOptionB(), list.get(position).getOptionC(), list.get(position).getOptionD(), list.get(position).getCorrectAnswer()
                                ,list.get(position).getExplaination(), list.get(position).getDifficulty(), list.get(position).getChapterName(),list.get(position).getIndex());

                        bookMarks.setImageDrawable(getDrawable(R.drawable.bookmarknew));
                        dbBookmarks.child(uuid).child("Bookmarks").push().setValue(questionModel);
                        BookMarkList.add(questionModel);
                        Toast.makeText(DisplayQuestions.this, "Bookmarked", Toast.LENGTH_SHORT).show();
                        //vibration
                        vibrator.vibrate(50);
                    }
                }
            }
        });

        pg = new ProgressDialog(this);
        pg.setTitle("Please wait...");
        pg.setMessage("Loading Questions...");

        //creating list
        list = new ArrayList<>();

        //Explaination Enabled
        explanation_btn.setEnabled(false);
        explanation_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAboutDialog(DisplayQuestions.this,list,position);
            }
        });

        String subChapName = getIntent().getStringExtra("subChapName");
        switch (subChapName)
        {
            case "What is living world?":
                databaseConnection(ModuleName[0], ModuleOneChapterName[0], "What is living world?");
                break;
            case "Diversity in the living world":
                databaseConnection(ModuleName[0], ModuleOneChapterName[0], "Diversity in the living world");
                break;
            case "Taxonomic categories":
                databaseConnection(ModuleName[0], ModuleOneChapterName[0], "Taxonomic categories");
                break;
            case "Taxonomic Aids":
                databaseConnection(ModuleName[0], ModuleOneChapterName[0], "Taxonomic Aids");
            case "Introduction Biological Classification":
                databaseConnection(ModuleName[0], ModuleOneChapterName[1], "Introduction Biological Classification");
                break;
            case "Kingdom Fungi":
                databaseConnection(ModuleName[0], ModuleOneChapterName[1], "Kingdom Fungi");
                break;
            case "Kingdom Monera":
                databaseConnection(ModuleName[0], ModuleOneChapterName[1], "Kingdom Monera");
                break;
            case "Kingdom Plantae and Kingdom Animalia":
                databaseConnection(ModuleName[0], ModuleOneChapterName[1], "Kingdom Plantae and Kingdom Animalia");
                break;
            case "Kingdom Protista":
                databaseConnection(ModuleName[0], ModuleOneChapterName[1], "Kingdom Protista");
                break;
            case "Virus, viroids, prions, lichens":
                databaseConnection(ModuleName[0], ModuleOneChapterName[1], "Virus, viroids, prions, lichens");
                break;
            case "Division Angiospermae":
                databaseConnection(ModuleName[0], ModuleOneChapterName[2], "Division Angiospermae");
                break;
            case "Division Bryophyta":
                databaseConnection(ModuleName[0], ModuleOneChapterName[2], "Division Bryophyta");
                break;
            case "Division Gymnospermae":
                databaseConnection(ModuleName[0], ModuleOneChapterName[2], "Division Gymnospermae");
                break;
            case "Division Pteridophyta":
                databaseConnection(ModuleName[0], ModuleOneChapterName[2], "Division Pteridophyta");
                break;
            case "Division Thallophyta(Algae)":
                databaseConnection(ModuleName[0], ModuleOneChapterName[2], "Division Thallophyta(Algae)");
                break;
            case "Introduction Plantae":
                databaseConnection(ModuleName[0], ModuleOneChapterName[2], "Introduction Plantae");
                break;
            case "Plant life cycle and alternation of generation":
                databaseConnection(ModuleName[0], ModuleOneChapterName[2], "Plant life cycle and alternation of generation");
                break;
            case "Basis of classification":
                databaseConnection(ModuleName[0], ModuleOneChapterName[3], "Basis of classification");
                break;
            case "Phylum Porifera":
                databaseConnection(ModuleName[0],ModuleOneChapterName[3],"Phylum Porifera");
                break;
            case "Phylum Coelenterata(Cnidaria)":
                databaseConnection(ModuleName[0],ModuleOneChapterName[3],"Phylum Coelenterata(Cnidaria)");
                break;
            case "Phylum platyhelminthes":
                databaseConnection(ModuleName[0],ModuleOneChapterName[3],"Phylum platyhelminthes");
                break;
            case "Phylum Aschelminthes":
                databaseConnection(ModuleName[0],ModuleOneChapterName[3],"Phylum Aschelminthes");
                break;
            case "Phylum Annelida":
                databaseConnection(ModuleName[0],ModuleOneChapterName[3],"Phylum Annelida");
                break;
            case "Phylum Arthropoda":
                databaseConnection(ModuleName[0],ModuleOneChapterName[3],"Phylum Arthropoda");
                break;
            case "Phylum Mollusca":
                databaseConnection(ModuleName[0],ModuleOneChapterName[3],"Phylum Mollusca");
                break;
            case "Phylum Echinodermata":
                databaseConnection(ModuleName[0],ModuleOneChapterName[3],"Phylum Echinodermata");
                break;
            case "Phylum Hemichordata":
                databaseConnection(ModuleName[0],ModuleOneChapterName[3],"Phylum Hemichordata");
                break;
            case "Phylum Chordata":
                databaseConnection(ModuleName[0],ModuleOneChapterName[3],"Phylum Chordata");
                break;
            case "Super Class Pisces":
                databaseConnection(ModuleName[0],ModuleOneChapterName[3],"Super Class Pisces");
                break;
            case "Super Class Tetrapoda":
                databaseConnection(ModuleName[0],ModuleOneChapterName[3],"Super Class Tetrapoda");
                break;
            case "The Root":
                databaseConnection(ModuleName[1],ModuleTwoChapterName[0],"The Root");
                break;
            case "The Stem":
                databaseConnection(ModuleName[1],ModuleTwoChapterName[0],"The Stem");
                break;
            case "The Leaf":
                databaseConnection(ModuleName[1],ModuleTwoChapterName[0],"The Leaf");
                break;
            case "The inflorescence and The Flower":
                databaseConnection(ModuleName[1],ModuleTwoChapterName[0],"The inflorescence and The Flower");
                break;
            case "The Fruit and The seed":
                databaseConnection(ModuleName[1],ModuleTwoChapterName[0],"The Fruit and The seed");
                break;
            case "Description of a typical flowering plant and some important families":
                databaseConnection(ModuleName[1],ModuleTwoChapterName[0],"Description of a typical flowering plant and some important families");
                break;
            case "Meristematic tissue":
                databaseConnection(ModuleName[1],ModuleTwoChapterName[1],"Meristematic tissue");
                break;
            case "Permanent tissue":
                databaseConnection(ModuleName[1],ModuleTwoChapterName[1],"Permanent tissue");
                break;
            case "The tissue system":
                databaseConnection(ModuleName[1],ModuleTwoChapterName[1],"The tissue system");
                break;
            case "Anatomy of Dicotyledonous and Monocotyledonous Plants":
                databaseConnection(ModuleName[1],ModuleTwoChapterName[1],"Anatomy of Dicotyledonous and Monocotyledonous Plants");
                break;
            case "Secondary growth":
                databaseConnection(ModuleName[1],ModuleTwoChapterName[1],"Secondary growth");
                break;
            case "Epithelial Tissue":
                databaseConnection(ModuleName[1],ModuleTwoChapterName[2],"Epithelial Tissue");
                break;
            case "Connective Tissue":
                databaseConnection(ModuleName[1],ModuleTwoChapterName[2],"Connective Tissue");
                break;
            case "Muscular Tissue":
                databaseConnection(ModuleName[1],ModuleTwoChapterName[2],"Muscular Tissue");
                break;
            case "Nervous Tissue":
                databaseConnection(ModuleName[1],ModuleTwoChapterName[2],"Nervous Tissue");
                break;
            case "Earthworm":
                databaseConnection(ModuleName[1],ModuleTwoChapterName[2],"Earthworm");
                break;
            case "Cockroach":
                databaseConnection(ModuleName[1],ModuleTwoChapterName[2],"Cockroach");
                break;
            case "Frog":
                databaseConnection(ModuleName[1],ModuleTwoChapterName[2],"Frog");
                break;
            case "Cell theory, an overview of cell":
                databaseConnection(ModuleName[2],ModuleThreeChapterName[0],"Cell theory, an overview of cell");
                break;
            case "Prokaryotic cell":
                databaseConnection(ModuleName[2],ModuleThreeChapterName[0],"Prokaryotic cell");
                break;
            case "Eukaryotic cell- Cell membrane, Cell wall, Endomembrane system":
                databaseConnection(ModuleName[2],ModuleThreeChapterName[0],"Eukaryotic cell- Cell membrane, Cell wall, Endomembrane system");
                break;
            case "Eukaryotic cell- Mitochondria, Plastids, Ribosomes, Cytoskeleton":
                databaseConnection(ModuleName[2],ModuleThreeChapterName[0],"Eukaryotic cell- Mitochondria, Plastids, Ribosomes, Cytoskeleton");
                break;
            case "Eukaryotic cell- Cilia and Flagella, Centrosome and Centrioles, Nucleus, Microbodies":
                databaseConnection(ModuleName[2],ModuleThreeChapterName[0],"Eukaryotic cell- Cilia and Flagella, Centrosome and Centrioles, Nucleus, Microbodies");
                break;
            case "How to analyse Chemical Composition?":
                databaseConnection(ModuleName[2],ModuleThreeChapterName[1],"How to analyse Chemical Composition?");
                break;
            case "Primary and Secondary Metabolites, Biomacromolecules":
                databaseConnection(ModuleName[2],ModuleThreeChapterName[1],"Primary and Secondary Metabolites, Biomacromolecules");
                break;
            case "Proteins and Structure of Proteins":
                databaseConnection(ModuleName[2],ModuleThreeChapterName[1],"Proteins and Structure of Proteins");
                break;
            case "Polysaccharides":
                databaseConnection(ModuleName[2],ModuleThreeChapterName[1],"Polysaccharides");
                break;
            case "Nucleic Acids":
                databaseConnection(ModuleName[2],ModuleThreeChapterName[1],"Nucleic Acids");
                break;
            case "Nature of bond linking Monomers in a Polymer and Dynamic State of body constituents- Concepts of Metabolism":
                databaseConnection(ModuleName[2],ModuleThreeChapterName[1],"Nature of bond linking Monomers in a Polymer and Dynamic State of body constituents- Concepts of Metabolism");
                break;
            case "Metabolic Basis for living and The Living State":
                databaseConnection(ModuleName[2],ModuleThreeChapterName[1],"Metabolic Basis for living and The Living State");
                break;
            case "Enzymes and co-factors":
                databaseConnection(ModuleName[2],ModuleThreeChapterName[1],"Enzymes and co-factors");
                break;
            case "Cell Cycle":
                databaseConnection(ModuleName[2],ModuleThreeChapterName[2],"Cell Cycle");
                break;
            case "Prophase":
                databaseConnection(ModuleName[2],ModuleThreeChapterName[2],"Prophase");
                break;
            case "Metaphase":
                databaseConnection(ModuleName[2],ModuleThreeChapterName[2],"Metaphase");
                break;
            case "Anaphase":
                databaseConnection(ModuleName[2],ModuleThreeChapterName[2],"Anaphase");
                break;
            case "Telophase, cytokinesis and significance of Mitosis":
                databaseConnection(ModuleName[2],ModuleThreeChapterName[2],"Telophase, cytokinesis and significance of Mitosis");
                break;
            case "Meiosis":
                databaseConnection(ModuleName[2],ModuleThreeChapterName[2],"Meiosis");
                break;
            case "Meiosis-1":
                databaseConnection(ModuleName[2],ModuleThreeChapterName[2],"Meiosis-1");
                break;
            case "Meiosis- 2 and significance of Meiosis":
                databaseConnection(ModuleName[2],ModuleThreeChapterName[2],"Meiosis- 2 and significance of Meiosis");
                break;
            case "Means of Transport":
                databaseConnection(ModuleName[3],ModuleFourChapterName[0],"Means of Transport");
                break;
            case "Plant water Relation":
                databaseConnection(ModuleName[3],ModuleFourChapterName[0],"Plant water Relation");
                break;
            case "Long Distance Transport of Water":
                databaseConnection(ModuleName[3],ModuleFourChapterName[0],"Long Distance Transport of Water");
                break;
            case "Transpiration":
                databaseConnection(ModuleName[3],ModuleFourChapterName[0],"Transpiration");
                break;
            case "Uptake and Transport of Mineral Nutrients, Phloem Transport":
                databaseConnection(ModuleName[3],ModuleFourChapterName[0],"Uptake and Transport of Mineral Nutrients, Phloem Transport");
                break;
            case "Methods to study the mineral requirements of Plants":
                databaseConnection(ModuleName[3],ModuleFourChapterName[1],"Methods to study the mineral requirements of Plants");
                break;
            case "Essential Mineral Elements":
                databaseConnection(ModuleName[3],ModuleFourChapterName[1],"Essential Mineral Elements");
                break;
            case "Mechanism of Absorption of Elements, Translocation of salutes, Soil as Reservoir":
                databaseConnection(ModuleName[3],ModuleFourChapterName[1],"Mechanism of Absorption of Elements, Translocation of salutes, Soil as Reservoir");
                break;
            case "Nitrogen cycle and Biological Nitrogen Fixation":
                databaseConnection(ModuleName[3],ModuleFourChapterName[1],"Nitrogen cycle and Biological Nitrogen Fixation");
                break;
            case "Introduction and Early Experiments":
                databaseConnection(ModuleName[3],ModuleFourChapterName[2],"Introduction and Early Experiments");
                break;
            case "Where does Photosynthesis take place?":
                databaseConnection(ModuleName[3],ModuleFourChapterName[2],"Where does Photosynthesis take place?");
                break;
            case "How many Types of Pigments are involved in Photosynthesis?":
                databaseConnection(ModuleName[3],ModuleFourChapterName[2],"How many Types of Pigments are involved in Photosynthesis?");
                break;
            case "What is Light Reaction?":
                databaseConnection(ModuleName[3],ModuleFourChapterName[2],"What is Light Reaction?");
                break;
            case "The Electron Transport":
                databaseConnection(ModuleName[3],ModuleFourChapterName[2],"The Electron Transport");
                break;
            case "Where are the ATP and NADPH used?":
                databaseConnection(ModuleName[3],ModuleFourChapterName[2],"Where are the ATP and NADPH used?");
                break;
            case "The Calvin Cycle":
                databaseConnection(ModuleName[3],ModuleFourChapterName[2],"The Calvin Cycle");
                break;
            case "The C4 pathway":
                databaseConnection(ModuleName[3],ModuleFourChapterName[2],"The C4 pathway");
                break;
            case "Photorespiration":
                databaseConnection(ModuleName[3],ModuleFourChapterName[2],"Photorespiration");
                break;
            case "Factors affecting Photosynthesis":
                databaseConnection(ModuleName[3],ModuleFourChapterName[2],"Factors affecting Photosynthesis");
                break;
            case "Introduction Respiration in Plants":
                databaseConnection(ModuleName[3],ModuleFourChapterName[3],"Introduction Respiration in Plants");
                break;
            case "Glycolysis":
                databaseConnection(ModuleName[3],ModuleFourChapterName[3],"Glycolysis");
                break;
            case "Fermentation":
                databaseConnection(ModuleName[3],ModuleFourChapterName[3],"Fermentation");
                break;
            case "Aerobic Respiration":
                databaseConnection(ModuleName[3],ModuleFourChapterName[3],"Aerobic Respiration");
                break;
            case "Tricarboxylic Acid Cycle":
                databaseConnection(ModuleName[3],ModuleFourChapterName[3],"Tricarboxylic Acid Cycle");
                break;
            case "Electron Transport System (ETS) and oxidative Phosphorylation":
                databaseConnection(ModuleName[3],ModuleFourChapterName[3],"Electron Transport System (ETS) and oxidative Phosphorylation");
                break;
            case "The Respiratory Balance Sheet,  Amphibolic Pathway and Respiratory Quotient":
                databaseConnection(ModuleName[3],ModuleFourChapterName[3],"The Respiratory Balance Sheet,  Amphibolic Pathway and Respiratory Quotient");
                break;
            case "Growth":
                databaseConnection(ModuleName[3],ModuleFourChapterName[4],"Growth");
                break;
            case "Phases of growth, Growth Rate, Conditions for Growth":
                databaseConnection(ModuleName[3],ModuleFourChapterName[4],"Phases of growth, Growth Rate, Conditions for Growth");
                break;
            case "Differentiation, Dedifferentiation and Redifferentiation":
                databaseConnection(ModuleName[3],ModuleFourChapterName[4],"Differentiation, Dedifferentiation and Redifferentiation");
                break;
            case "Development":
                databaseConnection(ModuleName[3],ModuleFourChapterName[4],"Development");
                break;
            case "Plant Growth Regulators- Introduction":
                databaseConnection(ModuleName[3],ModuleFourChapterName[4],"Plant Growth Regulators- Introduction");
                break;
            case "Auxin":
                databaseConnection(ModuleName[3],ModuleFourChapterName[4],"Auxin");
                break;
            case "Gibberllins":
                databaseConnection(ModuleName[3],ModuleFourChapterName[4],"Gibberllins");
                break;
            case "Cytokinins":
                databaseConnection(ModuleName[3],ModuleFourChapterName[4],"Cytokinins");
                break;
            case "Ethylene":
                databaseConnection(ModuleName[3],ModuleFourChapterName[4],"Ethylene");
                break;
            case "Abscisic Acid":
                databaseConnection(ModuleName[3],ModuleFourChapterName[4],"Abscisic Acid");
                break;
            case "Photoperiodism":
                databaseConnection(ModuleName[3],ModuleFourChapterName[4],"Photoperiodism");
                break;
            case "Vernalisation and Seed Dormancy":
                databaseConnection(ModuleName[3],ModuleFourChapterName[4],"Vernalisation and Seed Dormancy");
                break;
            case "Alimentary canal":
                databaseConnection(ModuleName[4],ModuleFiveChapterName[0],"Alimentary canal");
                break;
            case "Digestive Glands":
                databaseConnection(ModuleName[4],ModuleFiveChapterName[0],"Digestive Glands");
                break;
            case "Digestion of Food":
                databaseConnection(ModuleName[4],ModuleFiveChapterName[0],"Digestion of Food");
                break;
            case "Absorption of Digested Products":
                databaseConnection(ModuleName[4],ModuleFiveChapterName[0],"Absorption of Digested Products");
                break;
            case "Disorders of Digestive System":
                databaseConnection(ModuleName[4],ModuleFiveChapterName[0],"Disorders of Digestive System");
                break;
            case "Introduction Breathing and Exchange of Gases":
                databaseConnection(ModuleName[4],ModuleFiveChapterName[1],"Introduction Breathing and Exchange of Gases");
                break;
            case "Human Respiratory system":
                databaseConnection(ModuleName[4],ModuleFiveChapterName[1],"Human Respiratory system");
                break;
            case "Mechanism of Breathing":
                databaseConnection(ModuleName[4],ModuleFiveChapterName[1],"Mechanism of Breathing");
                break;
            case "Exchange of Gases":
                databaseConnection(ModuleName[4],ModuleFiveChapterName[1],"Exchange of Gases");
                break;
            case "Transport of Gases":
                databaseConnection(ModuleName[4],ModuleFiveChapterName[1],"Transport of Gases");
                break;
            case "Regulation of respiration and Disorders of Respiratory System":
                databaseConnection(ModuleName[4],ModuleFiveChapterName[1],"Regulation of respiration and Disorders of Respiratory System");
                break;
            case "Blood":
                databaseConnection(ModuleName[4],ModuleFiveChapterName[2],"Blood");
                break;
            case "Blood Groups":
                databaseConnection(ModuleName[4],ModuleFiveChapterName[2],"Blood Groups");
                break;
            case "Coagulation of Blood":
                databaseConnection(ModuleName[4],ModuleFiveChapterName[2],"Coagulation of Blood");
                break;
            case "Lymph":
                databaseConnection(ModuleName[4],ModuleFiveChapterName[2],"Lymph");
                break;
            case "Circulatory Pathway":
                databaseConnection(ModuleName[4],ModuleFiveChapterName[2],"Circulatory Pathway");
                break;
            case "Human Circulatory System":
                databaseConnection(ModuleName[4],ModuleFiveChapterName[2],"Human Circulatory System");
                break;
            case "Cardiac cycle":
                databaseConnection(ModuleName[4],ModuleFiveChapterName[2],"Cardiac cycle");
                break;
            case "Electrocardiograph (ECG)":
                databaseConnection(ModuleName[4],ModuleFiveChapterName[2],"Electrocardiograph (ECG)");
                break;
            case "Double Circulation":
                databaseConnection(ModuleName[4],ModuleFiveChapterName[2],"Double Circulation");
                break;
            case "Regulation of Cardiac Activity and Disorders of Circulatory System":
                databaseConnection(ModuleName[4],ModuleFiveChapterName[2],"Regulation of Cardiac Activity and Disorders of Circulatory System");
                break;
            case "Introduction Excretory Products and their Elimination":
                databaseConnection(ModuleName[4],ModuleFiveChapterName[3],"Introduction Excretory Products and their Elimination");
                break;
            case "Human Excretory System":
                databaseConnection(ModuleName[4],ModuleFiveChapterName[3],"Human Excretory System");
                break;
            case "Urine Formation":
                databaseConnection(ModuleName[4],ModuleFiveChapterName[3],"Urine Formation");
                break;
            case "Function of the Tubules":
                databaseConnection(ModuleName[4],ModuleFiveChapterName[3],"Function of the Tubules");
                break;
            case "Mechanism of Concentration of the Filtrate":
                databaseConnection(ModuleName[4],ModuleFiveChapterName[3],"Mechanism of Concentration of the Filtrate");
                break;
            case "Regulation of Kidney Function and Micturition":
                databaseConnection(ModuleName[4],ModuleFiveChapterName[3],"Regulation of Kidney Function and  Micturition");
                break;
            case "Role of other organs in Excretion and Disorders of the Excretory System":
                databaseConnection(ModuleName[4],ModuleFiveChapterName[3],"Role of other organs in Excretion and Disorders of the Excretory System");
                break;
            case "Types of Movement":
                databaseConnection(ModuleName[4],ModuleFiveChapterName[4],"Types of Movement");
                break;
            case "Muscle":
                databaseConnection(ModuleName[4],ModuleFiveChapterName[4],"Muscle");
                break;
            case "Structure of contractile Proteins and Mechanism of Muscle Contraction":
                databaseConnection(ModuleName[4],ModuleFiveChapterName[4],"Structure of contractile Proteins and Mechanism of Muscle Contraction");
                break;
            case "Skeletal System- Axial skeleton":
                databaseConnection(ModuleName[4],ModuleFiveChapterName[4],"Skeletal System- Axial skeleton");
                break;
            case "Skeletal System- Appendicular skeleton":
                databaseConnection(ModuleName[4],ModuleFiveChapterName[4],"Skeletal System- Appendicular skeleton");
                break;
            case "Joints":
                databaseConnection(ModuleName[4],ModuleFiveChapterName[4],"Joints");
                break;
            case "Disorders of Muscular and Skeleton System":
                databaseConnection(ModuleName[4],ModuleFiveChapterName[4],"Disorders of Muscular and Skeleton System");
                break;
            case "Introduction Neural Control and Coordination":
                databaseConnection(ModuleName[4],ModuleFiveChapterName[5],"Introduction Neural Control and Coordination");
                break;
            case "Human Neural System":
                databaseConnection(ModuleName[4],ModuleFiveChapterName[5],"Human Neural System");
                break;
            case "Neuron as Structural and Functional Unit of Neural System":
                databaseConnection(ModuleName[4],ModuleFiveChapterName[5],"Neuron as Structural and Functional Unit of Neural System");
                break;
            case "Generation and Conduction of Nerve Impulse":
                databaseConnection(ModuleName[4],ModuleFiveChapterName[5],"Generation and Conduction of Nerve Impulse");
                break;
            case "Transmission of Impulses":
                databaseConnection(ModuleName[4],ModuleFiveChapterName[5],"Transmission of Impulses");
                break;
            case "Central Neural System":
                databaseConnection(ModuleName[4],ModuleFiveChapterName[5],"Central Neural System");
                break;
            case "Reflex Action and Reflex Arc":
                databaseConnection(ModuleName[4],ModuleFiveChapterName[5],"Reflex Action and Reflex Arc");
                break;
            case "Sensory Reception ans Processing":
                databaseConnection(ModuleName[4],ModuleFiveChapterName[5],"Sensory Reception ans Processing");
                break;
            case "Eye":
                databaseConnection(ModuleName[4],ModuleFiveChapterName[5],"Eye");
                break;
            case "The Ear":
                databaseConnection(ModuleName[4],ModuleFiveChapterName[5],"The Ear");
                break;
            case "Human Endocrine System":
                databaseConnection(ModuleName[4],ModuleFiveChapterName[6],"Human Endocrine System");
                break;
            case "The Hypothalamus":
                databaseConnection(ModuleName[4],ModuleFiveChapterName[6],"The Hypothalamus");
                break;
            case "The Pituitary Gland":
                databaseConnection(ModuleName[4],ModuleFiveChapterName[6],"The Pituitary Gland");
                break;
            case "The Pineal Gland":
                databaseConnection(ModuleName[4],ModuleFiveChapterName[6],"The Pineal Gland");
                break;
            case "Thyroid Gland":
                databaseConnection(ModuleName[4],ModuleFiveChapterName[6],"Thyroid Gland");
                break;
            case "Parathyroid Gland":
                databaseConnection(ModuleName[4],ModuleFiveChapterName[6],"Parathyroid Gland");
                break;
            case "Thymus":
                databaseConnection(ModuleName[4],ModuleFiveChapterName[6],"Thymus");
                break;
            case "Adrenal Gland":
                databaseConnection(ModuleName[4],ModuleFiveChapterName[6],"Adrenal Gland");
                break;
            case "Pancreas":
                databaseConnection(ModuleName[4],ModuleFiveChapterName[6],"Pancreas");
                break;
            case "Testis":
                databaseConnection(ModuleName[4],ModuleFiveChapterName[6],"Testis");
                break;
            case "Ovary":
                databaseConnection(ModuleName[4],ModuleFiveChapterName[6],"Ovary");
                break;
            case "Hormones of Heart, Kidney, Gastrointestinal tract and Mechanism of Hormone Action":
                databaseConnection(ModuleName[4],ModuleFiveChapterName[6],"Hormones of Heart, Kidney, Gastrointestinal tract and Mechanism of Hormone Action");
                break;
            case "Introduction Reproduction in Organism":
                databaseConnection(ModuleName12[0],ModuleOneChapterName12[0],"Introduction Reproduction in Organism");
                break;
            case "Asexual Reproduction":
                databaseConnection(ModuleName12[0],ModuleOneChapterName12[0],"Asexual Reproduction");
                break;
            case "Sexual Reproduction":
                databaseConnection(ModuleName12[0],ModuleOneChapterName12[0],"Sexual Reproduction");
                break;
            case "Pre- fertilization Events":
                databaseConnection(ModuleName12[0],ModuleOneChapterName12[0],"Pre- fertilization Events");
                break;
            case "Fertilization":
                databaseConnection(ModuleName12[0],ModuleOneChapterName12[0],"Fertilization");
                break;
            case "Post fertilization Events":
                databaseConnection(ModuleName12[0],ModuleOneChapterName12[0],"Post fertilization Events");
                break;
            case "Flower":
                databaseConnection(ModuleName12[0],ModuleOneChapterName12[1],"Flower");
                break;
            case "Pre- fertilization: Structure and events":
                databaseConnection(ModuleName12[0],ModuleOneChapterName12[1],"Pre- fertilization: Structure and events");
                break;
            case "The pistil, megasporangium, and embryo sac":
                databaseConnection(ModuleName12[0],ModuleOneChapterName12[1],"The pistil, megasporangium, and embryo sac");
                break;
            case "Pollination":
                databaseConnection(ModuleName12[0],ModuleOneChapterName12[1],"Pollination");
                break;
            case "Double Fertilization":
                databaseConnection(ModuleName12[0],ModuleOneChapterName12[1],"Double Fertilization");
                break;
            case "Post- fertilization: structure and events":
                databaseConnection(ModuleName12[0],ModuleOneChapterName12[1],"Post- fertilization: structure and events");
                break;
            case "Embryo":
                databaseConnection(ModuleName12[0],ModuleOneChapterName12[1],"Embryo");
                break;
            case "Seed":
                databaseConnection(ModuleName12[0],ModuleOneChapterName12[1],"Seed");
                break;
            case "Apomixis and polyembryony":
                databaseConnection(ModuleName12[0],ModuleOneChapterName12[1],"Apomixis and polyembryony");
                break;
            case "The Male Reproductive system":
                databaseConnection(ModuleName12[0],ModuleOneChapterName12[2],"The Male Reproductive system");
                break;
            case "The Female Reproductive system":
                databaseConnection(ModuleName12[0],ModuleOneChapterName12[2],"The Female Reproductive system");
                break;
            case "Gametogenesis":
                databaseConnection(ModuleName12[0],ModuleOneChapterName12[2],"Gametogenesis");
                break;
            case "Menstrual cycle":
                databaseConnection(ModuleName12[0],ModuleOneChapterName12[2],"Menstrual cycle");
                break;
            case "Fertilization and Implantation":
                databaseConnection(ModuleName12[0],ModuleOneChapterName12[2],"Fertilization and Implantation");
                break;
            case "Pregnancy and Embryonic Development":
                databaseConnection(ModuleName12[0],ModuleOneChapterName12[2],"Pregnancy and Embryonic Development");
                break;
            case "Parturition and Lactation":
                databaseConnection(ModuleName12[0],ModuleOneChapterName12[2],"Parturition and Lactation");
                break;
            case "Reproductive health- problems and strategies":
                databaseConnection(ModuleName12[0],ModuleOneChapterName12[3],"Reproductive health- problems and strategies");
                break;
            case "Population Explosion and Birth Control":
                databaseConnection(ModuleName12[0],ModuleOneChapterName12[3],"Population Explosion and Birth Control");
                break;
            case "Medical Termination of Pregnancy":
                databaseConnection(ModuleName12[0],ModuleOneChapterName12[3],"Medical Termination of Pregnancy");
                break;
            case "Sexually Transmitted Infections":
                databaseConnection(ModuleName12[0],ModuleOneChapterName12[3],"Sexually Transmitted Infections");
                break;
            case "Infertility":
                databaseConnection(ModuleName12[0],ModuleOneChapterName12[3],"Infertility");
                break;
            case "Mendel's law of Inheritance":
                databaseConnection(ModuleName12[1],ModuleTwoChapterName12[0],"Mendel's law of Inheritance");
                break;
            case "Inheritance if one gene":
                databaseConnection(ModuleName12[1],ModuleTwoChapterName12[0],"Inheritance if one gene");
                break;
            case "Incomplete Dominance":
                databaseConnection(ModuleName12[1],ModuleTwoChapterName12[0],"Incomplete Dominance");
                break;
            case "Co- dominance":
                databaseConnection(ModuleName12[1],ModuleTwoChapterName12[0],"Co- dominance");
                break;
            case "Inheritance of two genes":
                databaseConnection(ModuleName12[1],ModuleTwoChapterName12[0],"Inheritance of two genes");
                break;
            case "Chromosomal theory of Inheritance":
                databaseConnection(ModuleName12[1],ModuleTwoChapterName12[0],"Chromosomal theory of Inheritance");
                break;
            case "Linkage and Recombination":
                databaseConnection(ModuleName12[1],ModuleTwoChapterName12[0],"Linkage and Recombination");
                break;
            case "Polygenic Inheritance and Pleiotrophy":
                databaseConnection(ModuleName12[1],ModuleTwoChapterName12[0],"Polygenic Inheritance and Pleiotrophy");
                break;
            case "Sex determination":
                databaseConnection(ModuleName12[1],ModuleTwoChapterName12[0],"Sex determination");
                break;
            case "Mutation and Genetic disorders":
                databaseConnection(ModuleName12[1],ModuleTwoChapterName12[0],"Mutation and Genetic disorders");
                break;
            case "The DNA":
                databaseConnection(ModuleName12[1],ModuleTwoChapterName12[1],"The DNA");
                break;
            case "Packaging of DNA helix":
                databaseConnection(ModuleName12[1],ModuleTwoChapterName12[1],"Packaging of DNA helix");
                break;
            case "The search for genetic material":
                databaseConnection(ModuleName12[1],ModuleTwoChapterName12[1],"The search for genetic material");
                break;
            case "Properties of genetic material and RNA world":
                databaseConnection(ModuleName12[1],ModuleTwoChapterName12[1],"Properties of genetic material and RNA world");
                break;
            case "Replication":
                databaseConnection(ModuleName12[1],ModuleTwoChapterName12[1],"Replication");
                break;
            case "Transcription":
                databaseConnection(ModuleName12[1],ModuleTwoChapterName12[1],"Transcription");
                break;
            case "Genetic code":
                databaseConnection(ModuleName12[1],ModuleTwoChapterName12[1],"Genetic code");
                break;
            case "Translation":
                databaseConnection(ModuleName12[1],ModuleTwoChapterName12[1],"Translation");
                break;
            case "Regulation of gene Expression":
                databaseConnection(ModuleName12[1],ModuleTwoChapterName12[1],"Regulation of gene Expression");
                break;
            case "Human genome project":
                databaseConnection(ModuleName12[1],ModuleTwoChapterName12[1],"Human genome project");
                break;
            case "DNA Fingerprinting":
                databaseConnection(ModuleName12[1],ModuleTwoChapterName12[1],"DNA Fingerprinting");
                break;
            case "Origin of Life":
                databaseConnection(ModuleName12[1],ModuleTwoChapterName12[2],"Origin of Life");
                break;
            case "Evolution of life forms- A theory":
                databaseConnection(ModuleName12[1],ModuleTwoChapterName12[2],"Evolution of life forms- A theory");
                break;
            case "What are the evidences for Evolution?":
                databaseConnection(ModuleName12[1],ModuleTwoChapterName12[2],"What are the evidences for Evolution?");
                break;
            case "What is adaptive Radiation?":
                databaseConnection(ModuleName12[1],ModuleTwoChapterName12[2],"What is adaptive Radiation?");
                break;
            case "Biological Evidence":
                databaseConnection(ModuleName12[1],ModuleTwoChapterName12[2],"Biological Evidence");
                break;
            case "Mechanism of Evolution and Hardy Weinberg Principle":
                databaseConnection(ModuleName12[1],ModuleTwoChapterName12[2],"Mechanism of Evolution and Hardy Weinberg Principle");
                break;
            case "A Brief account of Evolution":
                databaseConnection(ModuleName12[1],ModuleTwoChapterName12[2],"A Brief account of Evolution");
                break;
            case "Origin and Evolution of Man":
                databaseConnection(ModuleName12[1],ModuleTwoChapterName12[2],"Origin and Evolution of Man");
                break;
            case "Introduction Human Health and Disease":
                databaseConnection(ModuleName12[2],ModuleThreeChapterName12[0],"Introduction Human Health and Disease");
                break;
            case "Common Diseases in Humans":
                databaseConnection(ModuleName12[2],ModuleThreeChapterName12[0],"Common Diseases in Humans");
                break;
            case "Immunity":
                databaseConnection(ModuleName12[2],ModuleThreeChapterName12[0],"Immunity");
                break;
            case "AIDS":
                databaseConnection(ModuleName12[2],ModuleThreeChapterName12[0],"AIDS");
                break;
            case "Cancer":
                databaseConnection(ModuleName12[2],ModuleThreeChapterName12[0],"Cancer");
                break;
            case "Drugs and Alcohol abuse":
                databaseConnection(ModuleName12[2],ModuleThreeChapterName12[0],"Drugs and Alcohol abuse");
                break;
            case "Dairy and Poultry Farm management":
                databaseConnection(ModuleName12[2],ModuleThreeChapterName12[1],"Dairy and Poultry Farm management");
                break;
            case "Animal Breeding":
                databaseConnection(ModuleName12[2],ModuleThreeChapterName12[1],"Animal Breeding");
                break;
            case "Bee- keeping and Fisheries":
                databaseConnection(ModuleName12[2],ModuleThreeChapterName12[1],"Bee- keeping and Fisheries");
                break;
            case "What is Plant breeding":
                databaseConnection(ModuleName12[2],ModuleThreeChapterName12[1],"What is Plant breeding");
                break;
            case "Plant breeding for Disease Resistance":
                databaseConnection(ModuleName12[2],ModuleThreeChapterName12[1],"Plant breeding for Disease Resistance");
                break;
            case "Plant breeding for developing Resistance to Insect Pests":
                databaseConnection(ModuleName12[2],ModuleThreeChapterName12[1],"Plant breeding for developing Resistance to Insect Pests");
                break;
            case "Plant breeding for Improved Food Quality":
                databaseConnection(ModuleName12[2],ModuleThreeChapterName12[1],"Plant breeding for Improved Food Quality");
                break;
            case "Single Cell protein":
                databaseConnection(ModuleName12[2],ModuleThreeChapterName12[1],"Single Cell protein");
                break;
            case "Tissue Culture":
                databaseConnection(ModuleName12[2],ModuleThreeChapterName12[1],"Tissue Culture");
                break;
            case "Introduction Microbes in Human Welfare":
                databaseConnection(ModuleName12[2],ModuleThreeChapterName12[2],"Introduction Microbes in Human Welfare");
                break;
            case "Microbes in Household Products":
                databaseConnection(ModuleName12[2],ModuleThreeChapterName12[2],"Microbes in Household Products");
                break;
            case "Microbes in Industrial Products":
                databaseConnection(ModuleName12[2],ModuleThreeChapterName12[2],"Microbes in Industrial Products");
                break;
            case "Microbes in Sewage treatment":
                databaseConnection(ModuleName12[2],ModuleThreeChapterName12[2],"Microbes in Sewage treatment");
                break;
            case "Microbes in production of Biogas":
                databaseConnection(ModuleName12[2],ModuleThreeChapterName12[2],"Microbes in production of Biogas");
                break;
            case "Microbes as Biocontrol Agents":
                databaseConnection(ModuleName12[2],ModuleThreeChapterName12[2],"Microbes as Biocontrol Agents");
                break;
            case "Microbes as Biofertilizers":
                databaseConnection(ModuleName12[2],ModuleThreeChapterName12[2],"Microbes as Biofertilizers");
                break;
            case "Principles of Biotechnology":
                databaseConnection(ModuleName12[3],ModuleFourChapterName12[0],"Principles of Biotechnology");
                break;
            case "Tools of Recombinant DNA technology- Restriction Enzymes":
                databaseConnection(ModuleName12[3],ModuleFourChapterName12[0],"Tools of Recombinant DNA technology- Restriction Enzymes");
                break;
            case "Cloning Vectors":
                databaseConnection(ModuleName12[3],ModuleFourChapterName12[0],"Cloning Vectors");
                break;
            case "Competent Host (For Transformation with Recombinant DNA)":
                databaseConnection(ModuleName12[3],ModuleFourChapterName12[0],"Competent Host (For Transformation with Recombinant DNA)");
                break;
            case "Processes of Recombinant DNA Technology":
                databaseConnection(ModuleName12[3],ModuleFourChapterName12[0],"Processes of Recombinant DNA Technology");
                break;
            case "Biotechnological applications in Agriculture":
                databaseConnection(ModuleName12[3],ModuleFourChapterName12[1],"Biotechnological applications in Agriculture");
                break;
            case "Biotechnological applications in Medicine":
                databaseConnection(ModuleName12[3],ModuleFourChapterName12[1],"Biotechnological applications in Medicine");
                break;
            case "Transgenic Animals":
                databaseConnection(ModuleName12[3],ModuleFourChapterName12[1],"Transgenic Animals");
                break;
            case "Ethical Issues":
                databaseConnection(ModuleName12[3],ModuleFourChapterName12[1],"Ethical Issues");
                break;
            case "Organisms and its environment":
                databaseConnection(ModuleName12[4],ModuleFiveChapterName12[0],"Organisms and its environment");
                break;
            case "Responses to Abiotic Factors and Adaptations":
                databaseConnection(ModuleName12[4],ModuleFiveChapterName12[0],"Responses to Abiotic Factors and Adaptations");
                break;
            case "Population":
                databaseConnection(ModuleName12[4],ModuleFiveChapterName12[0],"Population");
                break;
            case "Population Growth":
                databaseConnection(ModuleName12[4],ModuleFiveChapterName12[0],"Population Growth");
                break;
            case "Population Interactions":
                databaseConnection(ModuleName12[4],ModuleFiveChapterName12[0],"Population Interactions");
                break;
            case "Ecosystem- Structure and Function":
                databaseConnection(ModuleName12[4],ModuleFiveChapterName12[1],"Ecosystem- Structure and Function");
                break;
            case "Productivity":
                databaseConnection(ModuleName12[4],ModuleFiveChapterName12[1],"Productivity");
                break;
            case "Decomposition":
                databaseConnection(ModuleName12[4],ModuleFiveChapterName12[1],"Decomposition");
                break;
            case "Energy Flow":
                databaseConnection(ModuleName12[4],ModuleFiveChapterName12[1],"Energy Flow");
                break;
            case "Ecological Pyramids":
                databaseConnection(ModuleName12[4],ModuleFiveChapterName12[1],"Ecological Pyramids");
                break;
            case "Ecological Succession":
                databaseConnection(ModuleName12[4],ModuleFiveChapterName12[1],"Ecological Succession");
                break;
            case "Nutrient Cycling":
                databaseConnection(ModuleName12[4],ModuleFiveChapterName12[1],"Nutrient Cycling");
                break;
            case "Ecosystem Services":
                databaseConnection(ModuleName12[4],ModuleFiveChapterName12[1],"Ecosystem Services");
                break;
            case "Biodiversity":
                databaseConnection(ModuleName12[4],ModuleFiveChapterName12[2],"Biodiversity");
                break;
            case "Patterns of Biodiversity":
                databaseConnection(ModuleName12[4],ModuleFiveChapterName12[2],"Patterns of Biodiversity");
                break;
            case "The Importance of Species Diversity to the Ecosystem":
                databaseConnection(ModuleName12[4],ModuleFiveChapterName12[2],"The Importance of Species Diversity to the Ecosystem");
                break;
            case "Loss of Biodiversity":
                databaseConnection(ModuleName12[4],ModuleFiveChapterName12[2],"Loss of Biodiversity");
                break;
            case "Biodiversity Conservation":
                databaseConnection(ModuleName12[4],ModuleFiveChapterName12[2],"Biodiversity Conservation");
                break;
            case "Air Pollution and its control":
                databaseConnection(ModuleName12[4],ModuleFiveChapterName12[3],"Air Pollution and its control");
                break;
            case "Water Pollution and its control":
                databaseConnection(ModuleName12[4],ModuleFiveChapterName12[3],"Water Pollution and its control");
                break;
            case "Solid wastes":
                databaseConnection(ModuleName12[4],ModuleFiveChapterName12[3],"Solid wastes");
                break;
            case "Agro- chemicals and their effects":
                databaseConnection(ModuleName12[4],ModuleFiveChapterName12[3],"Agro- chemicals and their effects");
                break;
            case "Radioactive waste, Greenhouse Effect and Global Warming":
                databaseConnection(ModuleName12[4],ModuleFiveChapterName12[3],"Radioactive waste, Greenhouse Effect and Global Warming");
                break;
            case "Ozone Depletion in the Stratosphere":
                databaseConnection(ModuleName12[4],ModuleFiveChapterName12[3],"Ozone Depletion in the Stratosphere");
                break;
            case "Degradation by improper Resource Utilization and maintenance":
                databaseConnection(ModuleName12[4],ModuleFiveChapterName12[3],"Degradation by improper Resource Utilization and maintenance");
                break;
            case "Deforestation":
                databaseConnection(ModuleName12[4],ModuleFiveChapterName12[3],"Deforestation");
                break;
        }
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }

    //animation for loading new question
    private void animation(final View view, final int value, final String data){

        view.animate().alpha(value).scaleX(value).scaleY(value).setDuration(500).setStartDelay(100)
                .setInterpolator(new DecelerateInterpolator()).setListener(new Animator.AnimatorListener() {
            @Override
            //checking value and view count to start animation
            public void onAnimationStart(Animator animator) {
                if (value == 0 && count < 4){
                    String option = ""; //check all option at location count value

                    if (count == 0){
                        option = list.get(position).getOptionA();
                    }else if (count == 1){
                        option = list.get(position).getOptionB();
                    }
                    else if (count == 2){
                        option = list.get(position).getOptionC();
                    }else if (count == 3){
                        option = list.get(position).getOptionD();
                    }
                    animation(linearLayout.getChildAt(count),0,option);
                    count++;
                }
            }

            @SuppressLint("SetTextI18n")
            @Override
            public void onAnimationEnd(Animator animator) {
                //on question data changes
                if (value == 0){
                    try {
                        ((TextView)view).setText(data);
                        if (modelMatch()){
                            bookMarks.setImageDrawable(getDrawable(R.drawable.bookmarknew));
                        }else {
                            bookMarks.setImageDrawable(getDrawable(R.drawable.ic_baseline_bookmark_border_24));
                        }
                       //tvTotal.setText(position+1+"/"+list.size());
                    }catch (ClassCastException e){
                        ((Button)view).setText(data);
                    }
                    view.setTag(data);
                    animation(view, 1,data);
                }
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });
    }
    public void checkAnswer(final Button selectOption) {
        enableOption(false);
        next_btn.setEnabled(true);
        prev_btn.setEnabled(true);
        explanation_btn.setEnabled(true);
        next_btn.setAlpha(1);
        explanation_btn.setAlpha(1);

        if (selectOption.getText().toString().equals(list.get(position).getCorrectAnswer())){
            //correct Answer
            //selectOption.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2ecc71")));
            selectOption.setBackgroundDrawable(getDrawable(R.drawable.rounded_buttons_in_display_questions_correct_answer));

        }else{
            //incorrect Answer
            vibrator.vibrate(100);
            //selectOption.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#e74c3c")));
            selectOption.setBackgroundDrawable(getDrawable(R.drawable.rounded_buttons_in_display_questions_wroung_answer));

            Button correctOption = linearLayout.findViewWithTag(list.get(position).getCorrectAnswer());
            //correctOption.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2ecc71")));
            correctOption.setBackgroundDrawable(getDrawable(R.drawable.rounded_buttons_in_display_questions_correct_answer));
            //correctOption.setTextColor(ColorStateList.valueOf(Color.parseColor("#ffffff")));

        }
    }

    //MatchModel for Bookmark
    boolean matched = false;
    int index;
    int matchedQuestionPosition;
    public boolean modelMatch() {
        for (QuestionModel model:BookMarkList){
            if (model.getQuestion().equals(list.get(position).getQuestion())){
                matched = true;
                matchedQuestionPosition = index;
                break;
            }else{
                index++;
                matched = false;
            }
        }
        return matched;
    }
    
    private void enableOption(boolean enable) {
        for (int i = 0; i < 4; i++){
            linearLayout.getChildAt(i).setEnabled(enable);

            if (enable){
                //linearLayout.getChildAt(i).setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#ffffff")));
                linearLayout.getChildAt(i).setBackgroundDrawable(getDrawable(R.drawable.rounded_buttons_in_display_questions));
            }
        }
    }
    public void QuestionLoader(){
        //check if list is greater than zero
        if (list.size()>0){
            for (int i = 0; i < 4; i++){
                //clickListener on option button
                pg.dismiss();
                linearLayout.getChildAt(i).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //method to compare options with correctAnswer
                        checkAnswer((Button) view);
                    }
                });
            }
            //loading first question
            animation(difficulty, 0, list.get(position).getDifficulty());
            //animation for bookmarkBtn before NextBtn click
            Animation an = AnimationUtils.loadAnimation(DisplayQuestions.this, R.anim.slide_in_right);
            an.setDuration(1500);
            an.setInterpolator(new DecelerateInterpolator());
            bookMarks.startAnimation(an);

            animation(tvQuestions, 0, list.get(position).getQuestion());
            //to load next questions
            next_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    next_btn.setEnabled(false);
                    explanation_btn.setEnabled(false);
                    explanation_btn.setAlpha(0.7f);
                    next_btn.setAlpha(0.7f);
                    enableOption(true);
                    //position= rand.nextInt(20);
                    position++;
                    if (position == list.size()){
                        String subChapName = getIntent().getStringExtra("subChapName");
                        //end of question index
                        Toast.makeText(DisplayQuestions.this, subChapName+" Finished", Toast.LENGTH_SHORT).show();
                        finish();
                    }else{
                        //before calling animation variable count initialize to 0
                        count = 0;
                        animation(difficulty, 0, list.get(position).getDifficulty());
                        //animation for BookmarkBtn After Nextbtn click
                        bookMarks.startAnimation(an);
                        animation(tvQuestions, 0,list.get(position).getQuestion());
                    }
                }
            });
            prev_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    enableOption(true);
                    position--;
                    if (position==-1){
                        Toast.makeText(DisplayQuestions.this, "No previous Questions available", Toast.LENGTH_SHORT).show();
                        position = 0;
                    }else{
                        count=0;
                        animation(difficulty, 0, list.get(position).getDifficulty());
                        animation(tvQuestions, 0, list.get(position).getQuestion());
                        bookMarks.startAnimation(an);

                        explanation_btn.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                showAboutDialog(DisplayQuestions.this, list, position);
                            }
                        });
                    }
                }
            });
        }else {
            pg.dismiss();
            Toast.makeText(DisplayQuestions.this, "Empty Questions", Toast.LENGTH_SHORT).show();
            finish();
        }
    }

    public static void showAboutDialog(Context context,List<QuestionModel> list, int position) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context,R.style.CustomDialogTheme);
        builder.setTitle("Explanation");
        builder.setMessage(list.get(position).getExplaination());
        builder.setNegativeButton("Close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                // dismiss dialog
                dialogInterface.dismiss();
            }
        });
        builder.show();
    }
    //databaseFuction
    public void databaseConnection(String Module, String ChapName, String Sub){
        //progressDialog
        pg.show();
            //database fetch child
            dbRef.child(Module).child(ChapName).child(Sub).child("questions").orderByChild("index").limitToFirst(20).addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    list.clear();
                    for (DataSnapshot snapshot1 : snapshot.getChildren()) {
                        list.add(snapshot1.getValue(QuestionModel.class));
                    }
                    QuestionLoader();
                }
                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                    Toast.makeText(DisplayQuestions.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                    finish();
                }
            });
    }
}