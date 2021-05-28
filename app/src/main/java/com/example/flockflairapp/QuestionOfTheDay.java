package com.example.flockflairapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class QuestionOfTheDay extends AppCompatActivity {

    private static final String TAG = "QuestionOfTheDay";
    private TextView difficulty, tvQuestions;
    private LinearLayout linearLayout;
    private Button explanation_btn;
    //list of question
    private List<QuestionModel> list;
    int count = 0;
    //random number for question
    Random rand = new Random();
    int position= rand.nextInt(20-2)+2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_of_the_day);

        tvQuestions = findViewById(R.id.tvQuestions);
        linearLayout = findViewById(R.id.linearLayout);
        difficulty = findViewById(R.id.difficulty);
        explanation_btn = findViewById(R.id.buttonExplain);

        list = new ArrayList<>();


        String[] ModuleOne = {"The Living World", "Biological Classification", "Plant Kingdom", "Animal Kingdom"};
        String[] subchaptername = {"What is living?","Diversity in the living","Taxonomic categories","Taxonomic Aids",
                                    "Introduction ","Kingdom Monera","Kingdom Protista","Kingdom Fungi","Kingdom Plantae and Kingdom Animalia",
                                    "Virus, viroids, prions, lichens","Introduction Plantae","Division Thallophyta(Algae)","Division Bryophyta",
                                    "Division Pteridophyta","Division Gymnospermae","Division Angiospermae","Plant life cycle and alternation of generation",
                                    "Basis of classification","Phylum Porifera","Phylum Coelenterata(Cnidaria)","Phylum platyhelminthes","Phylum Aschelminthes",
                                    "Phylum Annelida","Phylum Arthropoda","Phylum Mollusca","Phylum Echinodermata","Phylum Hemichordata","Phylum Chordata","Super Class Pisces",
                                    "Super Class Tetrapoda"};


        String[] ModuleTwo = {"Morphology of Flowering Plants", "Anatomy of Flowering Plants", "Structural Organisation in Animals"};
        String[] subchaptername4 = {"The Root","The Stem","The Leaf","The inflorescence and The Flower","The Fruit and The seed",
                                    "Description of a typical flowering plant and some important families","Meristematic tissue",
                                    "Permanent tissue","The tissue system","Anatomy of Dicotyledonous and Monocotyledonous Plants","Secondary growth",
                                    "Epithelial Tissue","Connective Tissue","Muscular Tissue","Nervous Tissue","Earthworm","Cockroach","Frog"};



        String[] ModuleThree = {"Cell:The Unit of Life", "Biomolecules", "Cell Cycle"};



        String[] ModuleFour = {"Transport in Plants", "Mineral Nutrition", "Photosynthesis in Higher Plants","Respiration in Plants", "Plant Growth and Development"};


        String[] ModuleFive = {"Digestion and Absorption", "Breathing and Exchange of Gases", "Body Fluids and Circulation", "Excretory Products and their Elimination",
                                "Locomotion and Movement", "Neural Control and Coordination", "Chemical Coordination and Integration"};

        DisplayQuestions questions = new DisplayQuestions();

        //questions.databaseConnection(ModuleOne[position], ,subchaptername[position], "question");

        //questions.databaseConnection(ModuleTwo[position], ,subchaptername4[position], "question");

       // questions.databaseConnection(ModuleThree[position], subchaptername[position], "question");

       // questions.databaseConnection(ModuleFour[position], subchaptername[position], "question");

       // questions.databaseConnection(ModuleFive[position], subchaptername[position], "question");

    }

}