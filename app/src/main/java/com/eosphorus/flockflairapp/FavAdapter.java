package com.eosphorus.flockflairapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FavAdapter extends RecyclerView.Adapter<FavAdapter.ViewHolder> {

    ArrayList<FavModel> favModels;
    Context context;

    public FavAdapter(Context context, ArrayList<FavModel> favModels){
        this.context = context;
        this.favModels = favModels;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Create View

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fav_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.imageView.setImageResource(favModels.get(position).getFavLogo());
        holder.textView.setText(favModels.get(position).getFavModule());
    }

    @Override
    public int getItemCount() {
        return favModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        //Initialize Variable
        ImageView imageView;
        TextView textView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            //assign variable
            imageView = itemView.findViewById(R.id.image_fav);
            textView = itemView.findViewById(R.id.name_fav);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v)
                {
                    if (getAdapterPosition()== getAdapterPosition())
                    {
                        String message = favModels.get(getAdapterPosition()).getFavModule();
                        //Toast.makeText(v.getContext(), message, Toast.LENGTH_SHORT).show();
                        Intent intent;
                        if(message.equals("The Living World")){
                        String name = "The Living World";
                        String[] subchaptername = {"What is living world?","Diversity in the living","Taxonomic categories","Taxonomic Aids"};
                        int[] subchapImages = {R.drawable.livingworld,R.drawable.livingworld,R.drawable.livingworld,R.drawable.livingworld,R.drawable.livingworld,R.drawable.livingworld,R.drawable.livingworld};
                        intent = new Intent(context.getApplicationContext(), listviewimg.class);
                        intent.putExtra("subchaptername",subchaptername);
                        intent.putExtra("subchapImages",subchapImages);
                        intent.putExtra("name",name);
                        //intent.putExtra("sub1","sub1");
                        context.startActivity(intent);
                        }

                        if(message.equals("Biological Classification")){
                            String name = "Biological Classification";
                            String[] subchaptername1 = {"Introduction Biological Classification","Kingdom Monera","Kingdom Protista","Kingdom Fungi","Kingdom Plantae and Kingdom Animalia","Virus, viroids, prions, lichens"};
                            int[] subchapImages1 = {R.drawable.biologicalclassification,R.drawable.biologicalclassification,R.drawable.biologicalclassification,R.drawable.biologicalclassification,R.drawable.biologicalclassification,R.drawable.biologicalclassification,R.drawable.biologicalclassification};
                            intent = new Intent(context.getApplicationContext(), listviewimg.class);
                            intent.putExtra("subchaptername",subchaptername1);
                            intent.putExtra("subchapImages",subchapImages1);
                            intent.putExtra("name",name);
                            context.startActivity(intent);
                        }

                        if(message.equals("Plant Kingdom")){
                            String name = "Plant Kingdom";
                            String[] subchaptername2 = {"Introduction Plantae","Division Thallophyta(Algae)","Division Bryophyta","Division Pteridophyta","Division Gymnospermae","Division Angiospermae","Plant life cycle and alternation of generation"};
                            int[] subchapImages2 = {R.drawable.plantkingdom,R.drawable.plantkingdom,R.drawable.plantkingdom,R.drawable.plantkingdom,R.drawable.plantkingdom,R.drawable.plantkingdom,R.drawable.plantkingdom,R.drawable.plantkingdom};
                            intent = new Intent(context.getApplicationContext(), listviewimg.class);
                            intent.putExtra("subchaptername",subchaptername2);
                            intent.putExtra("subchapImages",subchapImages2);
                            intent.putExtra("name",name);
                            context.startActivity(intent);
                        }

                        if(message.equals("Animal Kingdom")){
                            String[] subchaptername3 = {"Basis of classification","Phylum Porifera","Phylum Coelenterata(Cnidaria)","Phylum platyhelminthes","Phylum Aschelminthes","Phylum Annelida","Phylum Arthropoda","Phylum Mollusca","Phylum Echinodermata","Phylum Hemichordata","Phylum Chordata","Super Class Pisces","Super Class Tetrapoda"};
                            int[] subchapImages3 = {R.drawable.animalkingdom,R.drawable.animalkingdom,R.drawable.animalkingdom,R.drawable.animalkingdom,R.drawable.animalkingdom,R.drawable.animalkingdom,R.drawable.animalkingdom,R.drawable.animalkingdom,R.drawable.animalkingdom,R.drawable.animalkingdom,R.drawable.animalkingdom,R.drawable.animalkingdom,R.drawable.animalkingdom};
                            intent = new Intent(context.getApplicationContext(), listviewimg.class);
                            intent.putExtra("subchaptername",subchaptername3);
                            intent.putExtra("subchapImages",subchapImages3);
                            String name3 = "Animal Kingdom";
                            intent.putExtra("name",name3);
                            context.startActivity(intent);
                        }

                        if(message.equals("Morphology of Flowering Plants")){
                            String[] subchaptername4 = {"The Root","The Stem","The Leaf","The inflorescence and The Flower","The Fruit and The seed","Description of a typical flowering plant and some important families"};
                            int[] subchapImages4 = {R.drawable.morphologyoffloweringplants,R.drawable.morphologyoffloweringplants,R.drawable.morphologyoffloweringplants,R.drawable.morphologyoffloweringplants,R.drawable.morphologyoffloweringplants,R.drawable.morphologyoffloweringplants};
                            intent = new Intent(context.getApplicationContext(), listviewimg.class);
                            intent.putExtra("subchaptername",subchaptername4);
                            intent.putExtra("subchapImages",subchapImages4);
                            String name4 = "Morphology of Flowering Plants";
                            intent.putExtra("name",name4);
                            context.startActivity(intent);
                        }

                        if(message.equals("Anatomy of Flowering Plants")){
                            String[] subchaptername5 = {"Meristematic tissue","Permanent tissue","The tissue system","Anatomy of Dicotyledonous and Monocotyledonous Plants","Secondary growth"};
                            int[] subchapImages5 = {R.drawable.anatomyoffloweringplants,R.drawable.anatomyoffloweringplants,R.drawable.anatomyoffloweringplants,R.drawable.anatomyoffloweringplants,R.drawable.anatomyoffloweringplants};
                            intent = new Intent(context.getApplicationContext(), listviewimg.class);
                            intent.putExtra("subchaptername",subchaptername5);
                            intent.putExtra("subchapImages",subchapImages5);
                            String name5 = "Anatomy of Flowering Plants";
                            intent.putExtra("name",name5);
                            context.startActivity(intent);
                        }

                        if(message.equals("Structural Organisation in Animals")){
                            String[] subchaptername6 = {"Epithelial Tissue","Connective Tissue","Muscular Tissue","Nervous Tissue","Earthworm","Cockroach","Frog"};
                            int[] subchapImages6 = {R.drawable.structuralorganisation,R.drawable.structuralorganisation,R.drawable.structuralorganisation,R.drawable.structuralorganisation,R.drawable.structuralorganisation,R.drawable.structuralorganisation,R.drawable.structuralorganisation};
                            intent = new Intent(context.getApplicationContext(), listviewimg.class);
                            intent.putExtra("subchaptername",subchaptername6);
                            intent.putExtra("subchapImages",subchapImages6);
                            String name6 = "Structural Organisation in Animals";
                            intent.putExtra("name",name6);
                            context.startActivity(intent);
                        }

                        if(message.equals("Cell:The Unit of Life")){
                            String[] subchaptername7 = {"Cell theory, an overview of cell","Prokaryotic cell","Eukaryotic cell- Cell membrane, Cell wall, Endomembrane system","Eukaryotic cell- Mitochondria, Plastids, Ribosomes, Cytoskeleton","Eukaryotic cell- Cilia and Flagella, Centrosome and Centrioles, Nucleus, Microbodies"};
                            int[] subchapImages7 = {R.drawable.cellunitoflife,R.drawable.cellunitoflife,R.drawable.cellunitoflife,R.drawable.cellunitoflife,R.drawable.cellunitoflife};
                            intent = new Intent(context.getApplicationContext(), listviewimg.class);
                            intent.putExtra("subchaptername",subchaptername7);
                            intent.putExtra("subchapImages",subchapImages7);
                            String name7 = "Cell:The Unit of Life";
                            intent.putExtra("name",name7);
                            context.startActivity(intent);
                        }

                        if(message.equals("Biomolecules")){
                            String[] subchaptername8 = {"How to analyse Chemical Composition?","Primary and Secondary Metabolites, Biomacromolecules","Proteins and Structure of Proteins","Polysaccharides","Nucleic Acids","Nature of bond linking Monomers in a Polymer and Dynamic State of body constituents- Concepts of Metabolism","Metabolic Basis for living and The Living State","Enzymes and co-factors"};
                            int[] subchapImages8 = {R.drawable.biomolecules,R.drawable.biomolecules,R.drawable.biomolecules,R.drawable.biomolecules,R.drawable.biomolecules,R.drawable.biomolecules,R.drawable.biomolecules,R.drawable.biomolecules};
                            intent = new Intent(context.getApplicationContext(), listviewimg.class);
                            intent.putExtra("subchaptername",subchaptername8);
                            intent.putExtra("subchapImages",subchapImages8);
                            String name8 = "Biomolecules";
                            intent.putExtra("name",name8);
                            context.startActivity(intent);
                        }

                        if(message.equals("Cell Cycle")){
                            String[] subchaptername9 = {"Cell Cycle","Prophase","Metaphase","Anaphase","Telophase, cytokinesis and significance of Mitosis","Meiosis","Meiosis-1","Meiosis- 2 and significance of Meiosis"};
                            int[] subchapImages9 = {R.drawable.cellcycle,R.drawable.cellcycle,R.drawable.cellcycle,R.drawable.cellcycle,R.drawable.cellcycle,R.drawable.cellcycle,R.drawable.cellcycle,R.drawable.cellcycle};
                            intent = new Intent(context.getApplicationContext(), listviewimg.class);
                            intent.putExtra("subchaptername",subchaptername9);
                            intent.putExtra("subchapImages",subchapImages9);
                            String name9 = "Cell Cycle";
                            intent.putExtra("name",name9);
                            context.startActivity(intent);
                        }

                        if(message.equals("Transport in Plants")){
                            String[] subchaptername10 = {"Means of Transport","Plant water Relation","Long Distance Transport of Water","Transpiration","Uptake and Transport of Mineral Nutrients, Phloem Transport"};
                            int[] subchapImages10 = {R.drawable.transportinplants,R.drawable.transportinplants,R.drawable.transportinplants,R.drawable.transportinplants,R.drawable.transportinplants};
                            intent = new Intent(context.getApplicationContext(), listviewimg.class);
                            intent.putExtra("subchaptername",subchaptername10);
                            intent.putExtra("subchapImages",subchapImages10);
                            String name10 = "Transport in Plants";
                            intent.putExtra("name",name10);
                            context.startActivity(intent);
                        }

                        if(message.equals("Mineral Nutrition")){
                            String[] subchaptername11 = {"Methods to study the mineral requirements of Plants","Essential Mineral Elements","Mechanism of Absorption of Elements, Translocation of salutes, Soil as Reservoir","Nitrogen cycle and Biological Nitrogen Fixation"};
                            int[] subchapImages11 = {R.drawable.mineralnutrition,R.drawable.mineralnutrition,R.drawable.mineralnutrition,R.drawable.mineralnutrition};
                            intent = new Intent(context.getApplicationContext(), listviewimg.class);
                            intent.putExtra("subchaptername",subchaptername11);
                            intent.putExtra("subchapImages",subchapImages11);
                            String name11 = "Mineral Nutrition";
                            intent.putExtra("name",name11);
                            context.startActivity(intent);
                        }

                        if(message.equals("Photosynthesis in Higher Plants")){
                            String[] subchaptername12 = {"Introduction and Early Experiments","Where does Photosynthesis take place?","How many Types of Pigments are involved in Photosynthesis?","What is Light Reaction?","The Electron Transport","Where are the ATP and NADPH used?","The Calvin Cycle","The C4 pathway","Photorespiration","Factors affecting Photosynthesis"};
                            int[] subchapImages12 = {R.drawable.photosynthesisinhigherplants,R.drawable.photosynthesisinhigherplants,R.drawable.photosynthesisinhigherplants,R.drawable.photosynthesisinhigherplants,R.drawable.photosynthesisinhigherplants,R.drawable.photosynthesisinhigherplants,R.drawable.photosynthesisinhigherplants,R.drawable.photosynthesisinhigherplants,R.drawable.photosynthesisinhigherplants,R.drawable.photosynthesisinhigherplants};
                            intent = new Intent(context.getApplicationContext(), listviewimg.class);
                            intent.putExtra("subchaptername",subchaptername12);
                            intent.putExtra("subchapImages",subchapImages12);
                            String name12 = "Photosynthesis in Higher Plants";
                            intent.putExtra("name",name12);
                            context.startActivity(intent);
                        }

                        if(message.equals("Respiration in Plants")){
                            String[] subchaptername13 = {"Introduction Respiration in Plants ","Glycolysis","Fermentation","Aerobic Respiration","Tricarboxylic Acid Cycle","Electron Transport System (ETS) and oxidative Phosphorylation","The Respiratory Balance Sheet,  Amphibolic Pathway and Respiratory Quotient"};
                            int[] subchapImages13 = {R.drawable.respiration,R.drawable.respiration,R.drawable.respiration,R.drawable.respiration,R.drawable.respiration,R.drawable.respiration,R.drawable.respiration};
                            intent = new Intent(context.getApplicationContext(), listviewimg.class);
                            intent.putExtra("subchaptername",subchaptername13);
                            intent.putExtra("subchapImages",subchapImages13);
                            String name13 = "Respiration in Plants";
                            intent.putExtra("name",name13);
                            context.startActivity(intent);
                        }

                        if(message.equals("Plant Growth and Development")){
                            String[] subchaptername14 = {"Growth","Phases of growth, Growth Rate, Conditions for Growth","Differentiation, Dedifferentiation and Redifferentiation","Development","Plant Growth Regulators- Introduction","Auxin","Gibberllins","Cytokinins","Ethylene","Abscisic Acid","Photoperiodism","Vernalisation and Seed Dormancy"};
                            int[] subchapImages14 = {R.drawable.plantgrowth,R.drawable.plantgrowth,R.drawable.plantgrowth,R.drawable.plantgrowth,R.drawable.plantgrowth,R.drawable.plantgrowth,R.drawable.plantgrowth,R.drawable.plantgrowth,R.drawable.plantgrowth,R.drawable.plantgrowth,R.drawable.plantgrowth,R.drawable.plantgrowth};
                            intent = new Intent(context.getApplicationContext(), listviewimg.class);
                            intent.putExtra("subchaptername",subchaptername14);
                            intent.putExtra("subchapImages",subchapImages14);
                            String name14 = "Plant Growth and Development";
                            intent.putExtra("name",name14);
                            context.startActivity(intent);
                        }

                        if (message.equals("Digestion and Absorption")){
                            String[] subchaptername15 = {"Alimentary canal","Digestive Glands","Digestion of Food","Absorption of Digested Products","Disorders of Digestive System"};
                            int[] subchapImages15 = {R.drawable.digestionandabsorption,R.drawable.digestionandabsorption,R.drawable.digestionandabsorption,R.drawable.digestionandabsorption,R.drawable.digestionandabsorption};
                            intent = new Intent(context.getApplicationContext(), listviewimg.class);
                            intent.putExtra("subchaptername",subchaptername15);
                            intent.putExtra("subchapImages",subchapImages15);
                            String name15 = "Digestion and Absorption";
                            intent.putExtra("name",name15);
                            context.startActivity(intent);
                        }

                        if(message.equals("Breathing and Exchange of Gases")){
                            String[] subchaptername16 = {"Introduction Breathing and Exchange of Gases","Human Respiratory system","Mechanism of Breathing","Exchange of Gases","Transport of Gases","Regulation of respiration and Disorders of Respiratory System"};
                            int[] subchapImages16 = {R.drawable.breathing,R.drawable.breathing,R.drawable.breathing,R.drawable.breathing,R.drawable.breathing,R.drawable.breathing};
                            intent = new Intent(context.getApplicationContext(), listviewimg.class);
                            intent.putExtra("subchaptername",subchaptername16);
                            intent.putExtra("subchapImages",subchapImages16);
                            String name16 = "Breathing and Exchange of Gases";
                            intent.putExtra("name",name16);
                            context.startActivity(intent);
                        }

                        if(message.equals("Body Fluids and Circulation")){
                            String[] subchaptername17 = {"Blood","Blood Groups","Coagulation of Blood","Lymph","Circulatory Pathway","Human Circulatory System","Cardiac cycle","Electrocardiograph (ECG)","Double Circulation","Regulation of Cardiac Activity and Disorders of Circulatory System"};
                            int[] subchapImages17 = {R.drawable.bodyfluids,R.drawable.bodyfluids,R.drawable.bodyfluids,R.drawable.bodyfluids,R.drawable.bodyfluids,R.drawable.bodyfluids,R.drawable.bodyfluids,R.drawable.bodyfluids,R.drawable.bodyfluids,R.drawable.bodyfluids};
                            intent = new Intent(context.getApplicationContext(), listviewimg.class);
                            intent.putExtra("subchaptername",subchaptername17);
                            intent.putExtra("subchapImages",subchapImages17);
                            String name17 = "Body Fluids and Circulation";
                            intent.putExtra("name",name17);
                            context.startActivity(intent);
                        }

                        if(message.equals("Excretory Products and their Elimination")){
                            String[] subchaptername18 = {"Introduction Excretory Products and their Elimination","Human Excretory System","Urine Formation","Function of the Tubules","Mechanism of Concentration of the Filtrate","Regulation of Kidney Function and  Micturition","Role of other organs in Excretion and Disorders of the Excretory System"};
                            int[] subchapImages18 = {R.drawable.excretoryproducts,R.drawable.excretoryproducts,R.drawable.excretoryproducts,R.drawable.excretoryproducts,R.drawable.excretoryproducts,R.drawable.excretoryproducts,R.drawable.excretoryproducts};
                            intent = new Intent(context.getApplicationContext(), listviewimg.class);
                            intent.putExtra("subchaptername",subchaptername18);
                            intent.putExtra("subchapImages",subchapImages18);
                            String name18 = "Excretory Products and their Elimination";
                            intent.putExtra("name",name18);
                            context.startActivity(intent);
                        }

                        if(message.equals("Locomotion and Movement")){
                            String[] subchaptername19 = {"Types of Movement","Muscle","Structure of contractile Proteins and Mechanism of Muscle Contraction","Skeletal System- Axial skeleton","Skeletal System- Appendicular skeleton","Joints","Disorders of Muscular and Skeleton System"};
                            int[] subchapImages19 = {R.drawable.locomotion,R.drawable.locomotion,R.drawable.locomotion,R.drawable.locomotion,R.drawable.locomotion,R.drawable.locomotion,R.drawable.locomotion};
                            intent = new Intent(context.getApplicationContext(), listviewimg.class);
                            intent.putExtra("subchaptername",subchaptername19);
                            intent.putExtra("subchapImages",subchapImages19);
                            String name19 = "Locomotion and Movement";
                            intent.putExtra("name",name19);
                            context.startActivity(intent);
                        }

                        if(message.equals("Neural Control and Coordination")){
                            String[] subchaptername20 = {"Introduction Neural Control and Coordination","Human Neural System","Neuron as Structural and Functional Unit of Neural System","Generation and Conduction of Nerve Impulse","Transmission of Impulses","Central Neural System","Reflex Action and Reflex Arc","Sensory Reception ans Processing","Eye","The Ear"};
                            int[] subchapImages20 = {R.drawable.neuralcontrol,R.drawable.neuralcontrol,R.drawable.neuralcontrol,R.drawable.neuralcontrol,R.drawable.neuralcontrol,R.drawable.neuralcontrol,R.drawable.neuralcontrol,R.drawable.neuralcontrol,R.drawable.neuralcontrol,R.drawable.neuralcontrol};
                            intent = new Intent(context.getApplicationContext(), listviewimg.class);
                            intent.putExtra("subchaptername",subchaptername20);
                            intent.putExtra("subchapImages",subchapImages20);
                            String name20 = "Neural Control and Coordination";
                            intent.putExtra("name",name20);
                            context.startActivity(intent);
                        }

                        if(message.equals("Chemical Coordination and Integration")){
                            String[] subchaptername21 = {"Human Endocrine System","The Hypothalamus","The Pituitary Gland","The Pineal Gland","Thyroid Gland","Parathyroid Gland","Thymus","Adrenal Gland","Pancreas","Testis","Ovary","Hormones of Heart, Kidney, Gastrointestinal tract and Mechanism of Hormone Action"};
                            int[] subchapImages21 = {R.drawable.chemicalcordination,R.drawable.chemicalcordination,R.drawable.chemicalcordination,R.drawable.chemicalcordination,R.drawable.chemicalcordination,R.drawable.chemicalcordination,R.drawable.chemicalcordination,R.drawable.chemicalcordination,R.drawable.chemicalcordination,R.drawable.chemicalcordination,R.drawable.chemicalcordination,R.drawable.chemicalcordination};
                            intent = new Intent(context.getApplicationContext(), listviewimg.class);
                            intent.putExtra("subchaptername",subchaptername21);
                            intent.putExtra("subchapImages",subchapImages21);
                            String name21 = "Chemical Coordination and Integration";
                            intent.putExtra("name",name21);
                            context.startActivity(intent);
                        }

                        if(message.equals("Reproduction in Organism")){
                            String[] subchaptername = {"Introduction Reproduction in Organism","Asexual Reproduction","Sexual Reproduction","Pre- fertilization Events","Fertilization","Post fertilization Events"};
                            int[] subchapImages = {R.drawable.reproductioninorganism,R.drawable.reproductioninorganism,R.drawable.reproductioninorganism,R.drawable.reproductioninorganism,R.drawable.reproductioninorganism,R.drawable.reproductioninorganism};
                            intent = new Intent(context.getApplicationContext(), listviewimg.class);
                            intent.putExtra("subchaptername",subchaptername);
                            intent.putExtra("subchapImages",subchapImages);
                            String name = "Reproduction in Organism";
                            intent.putExtra("name",name);
                            context.startActivity(intent);
                        }

                        if(message.equals("Sexual Reproduction in Flowering Plants")){
                            String[] subchaptername1 = {"Flower","Pre- fertilization: Structure and events","The pistil, megasporangium, and embryo sac","Pollination","Double Fertilization","Post- fertilization: structure and events","Embryo","Seed","Apomixis and polyembryony"};
                            int[] subchapImages1 = {R.drawable.sexualreproductioninflower,R.drawable.sexualreproductioninflower,R.drawable.sexualreproductioninflower,R.drawable.sexualreproductioninflower,R.drawable.sexualreproductioninflower,R.drawable.sexualreproductioninflower,R.drawable.sexualreproductioninflower,R.drawable.sexualreproductioninflower,R.drawable.sexualreproductioninflower};
                            intent = new Intent(context.getApplicationContext(), listviewimg.class);
                            intent.putExtra("subchaptername",subchaptername1);
                            intent.putExtra("subchapImages",subchapImages1);
                            String name1 = "Sexual Reproduction in Flowering Plants";
                            intent.putExtra("name",name1);
                            context.startActivity(intent);
                        }

                        if(message.equals("Human Reproduction")){
                            String[] subchaptername2 = {"The Male Reproductive system","The Female Reproductive system","Gametogenesis","Menstrual cycle","Fertilization and Implantation","Pregnancy and Embryonic Development","Parturition and Lactation"};
                            int[] subchapImages2 = {R.drawable.humanreproduction,R.drawable.humanreproduction,R.drawable.humanreproduction,R.drawable.humanreproduction,R.drawable.humanreproduction,R.drawable.humanreproduction,R.drawable.humanreproduction};
                            intent = new Intent(context.getApplicationContext(), listviewimg.class);
                            intent.putExtra("subchaptername",subchaptername2);
                            intent.putExtra("subchapImages",subchapImages2);
                            String name2 = "Human Reproduction";
                            intent.putExtra("name",name2);
                            context.startActivity(intent);
                        }

                        if (message.equals("Reproductive Health")){
                            String[] subchaptername3 = {"Reproductive health- problems and strategies","Population Explosion and Birth Control","Medical Termination of Pregnancy","Sexually Transmitted Infections","Infertility"};
                            int[] subchapImages3 = {R.drawable.reproductivehealth,R.drawable.reproductivehealth,R.drawable.reproductivehealth,R.drawable.reproductivehealth,R.drawable.reproductivehealth};
                            intent = new Intent(context.getApplicationContext(), listviewimg.class);
                            intent.putExtra("subchaptername",subchaptername3);
                            intent.putExtra("subchapImages",subchapImages3);
                            String name3 = "Reproductive Health";
                            intent.putExtra("name",name3);
                            context.startActivity(intent);
                        }

                        if(message.equals("Principles of Inheritance and Variation")){
                            String[] subchaptername4 = {"Mendel's law of Inheritance","Inheritance if one gene","Incomplete Dominance","Co- dominance","Inheritance of two genes","Chromosomal theory of Inheritance","Linkage and Recombination","Polygenic Inheritance and Pleiotrophy","Sex determination","Mutation and Genetic disorders"};
                            int[] subchapImages4 = {R.drawable.principlesofinheritance,R.drawable.principlesofinheritance,R.drawable.principlesofinheritance,R.drawable.principlesofinheritance,R.drawable.principlesofinheritance,R.drawable.principlesofinheritance,R.drawable.principlesofinheritance,R.drawable.principlesofinheritance,R.drawable.principlesofinheritance,R.drawable.principlesofinheritance};
                            intent = new Intent(context.getApplicationContext(), listviewimg.class);
                            intent.putExtra("subchaptername",subchaptername4);
                            intent.putExtra("subchapImages",subchapImages4);
                            String name4 = "Principles of Inheritance and Variation";
                            intent.putExtra("name",name4);
                            context.startActivity(intent);
                        }

                        if(message.equals("Molecular Basis of Inheritance")){
                            String[] subchaptername5 = {"The DNA","Packaging of DNA helix","The search for genetic material","Properties of genetic material and RNA world","Replication","Transcription","Genetic code","Translation","Regulation of gene Expression","Human genome project","DNA Fingerprinting"};
                            int[] subchapImages5 = {R.drawable.molecularbasis,R.drawable.molecularbasis,R.drawable.molecularbasis,R.drawable.molecularbasis,R.drawable.molecularbasis,R.drawable.molecularbasis,R.drawable.molecularbasis,R.drawable.molecularbasis,R.drawable.molecularbasis,R.drawable.molecularbasis,R.drawable.molecularbasis};
                            intent = new Intent(context.getApplicationContext(), listviewimg.class);
                            intent.putExtra("subchaptername",subchaptername5);
                            intent.putExtra("subchapImages",subchapImages5);
                            String name5 = "Molecular Basis of Inheritance";
                            intent.putExtra("name",name5);
                            context.startActivity(intent);
                        }

                        if(message.equals("Evolution")){
                            String[] subchaptername6 = {"Origin of Life","Evolution of life forms- A theory","What are the evidences for Evolution?","What is adaptive Radiation?","Biological Evidence","Mechanism of Evolution and Hardy Weinberg Principle","A Brief account of Evolution","Origin and Evolution of Man"};
                            int[] subchapImages6 = {R.drawable.evolution,R.drawable.evolution,R.drawable.evolution,R.drawable.evolution,R.drawable.evolution,R.drawable.evolution,R.drawable.evolution,R.drawable.evolution};
                            intent = new Intent(context.getApplicationContext(), listviewimg.class);
                            intent.putExtra("subchaptername",subchaptername6);
                            intent.putExtra("subchapImages",subchapImages6);
                            String name6 = "Evolution";
                            intent.putExtra("name",name6);
                            context.startActivity(intent);
                        }

                        if(message.equals("Human Health and Disease")){
                            String[] subchaptername7 = {"Introduction Human Health and Disease","Common Diseases in Humans","Immunity","AIDS","Cancer","Drugs and Alcohol abuse"};
                            int[] subchapImages7 = {R.drawable.humanhealthdiseases,R.drawable.humanhealthdiseases,R.drawable.humanhealthdiseases,R.drawable.humanhealthdiseases,R.drawable.humanhealthdiseases,R.drawable.humanhealthdiseases};
                            intent = new Intent(context.getApplicationContext(), listviewimg.class);
                            intent.putExtra("subchaptername",subchaptername7);
                            intent.putExtra("subchapImages",subchapImages7);
                            String name7 = "Human Health and Disease";
                            intent.putExtra("name",name7);
                            context.startActivity(intent);
                        }

                        if(message.equals("Stratergies for Enhancement in Food Production")){
                            String[] subchaptername8 = {"Dairy and Poultry Farm management","Animal Breeding","Bee- keeping and Fisheries","What is Plant breeding","Plant breeding for Disease Resistance","Plant breeding for developing Resistance to Insect Pests","Plant breeding for Improved Food Quality","Single Cell protein","Tissue Culture"};
                            int[] subchapImages8 = {R.drawable.stratergiesenchancement,R.drawable.stratergiesenchancement,R.drawable.stratergiesenchancement,R.drawable.stratergiesenchancement,R.drawable.stratergiesenchancement,R.drawable.stratergiesenchancement,R.drawable.stratergiesenchancement,R.drawable.stratergiesenchancement,R.drawable.stratergiesenchancement};
                            intent = new Intent(context.getApplicationContext(), listviewimg.class);
                            intent.putExtra("subchaptername",subchaptername8);
                            intent.putExtra("subchapImages",subchapImages8);
                            String name8 = "Stratergies for Enhancement in Food Production";
                            intent.putExtra("name",name8);
                            context.startActivity(intent);
                        }

                        if(message.equals("Microbes in Human Welfare")){
                            String[] subchaptername9 = {"Introduction Microbes in Human Welfare","Microbes in Household Products","Microbes in Industrial Products","Microbes in Sewage treatment","Microbes in production of Biogas","Microbes as Biocontrol Agents","Microbes as Biofertilizers"};
                            int[] subchapImages9 = {R.drawable.microbesinwelfare,R.drawable.microbesinwelfare,R.drawable.microbesinwelfare,R.drawable.microbesinwelfare,R.drawable.microbesinwelfare,R.drawable.microbesinwelfare,R.drawable.microbesinwelfare};
                            intent = new Intent(context.getApplicationContext(), listviewimg.class);
                            intent.putExtra("subchaptername",subchaptername9);
                            intent.putExtra("subchapImages",subchapImages9);
                            String name9 = "Microbes in Human Welfare";
                            intent.putExtra("name",name9);
                            context.startActivity(intent);
                        }

                        if(message.equals("Biotechnology and its Applications")){
                            String[] subchaptername10 = {"Principles of Biotechnology","Tools of Recombinant DNA technology- Restriction Enzymes","Cloning Vectors","Competent Host (For Transformation with Recombinant DNA)","Processes of Recombinant DNA Technology"};
                            int[] subchapImages10 = {R.drawable.biotechnology,R.drawable.biotechnology,R.drawable.biotechnology,R.drawable.biotechnology,R.drawable.biotechnology};
                            intent = new Intent(context.getApplicationContext(), listviewimg.class);
                            intent.putExtra("subchaptername",subchaptername10);
                            intent.putExtra("subchapImages",subchapImages10);
                            String name10 = "Biotechnology and its Applications";
                            intent.putExtra("name",name10);
                            context.startActivity(intent);
                        }

                        if(message.equals("Organisms and Population")){
                            String[] subchaptername12 = {"Organisms and its environment","Responses to Abiotic Factors and Adaptations","Population","Population Growth","Population Interactions"};
                            int[] subchapImages12 = {R.drawable.population,R.drawable.population,R.drawable.population,R.drawable.population,R.drawable.population};
                            intent = new Intent(context.getApplicationContext(), listviewimg.class);
                            intent.putExtra("subchaptername",subchaptername12);
                            intent.putExtra("subchapImages",subchapImages12);
                            String name12 = "Organisms and Population";
                            intent.putExtra("name",name12);
                            context.startActivity(intent);
                        }

                       if(message.equals("Ecosystem")){
                           String[] subchaptername13 = {"Ecosystem- Structure and Function","Productivity","Decomposition","Energy Flow","Ecological Pyramids","Ecological Succession","Nutrient Cycling","Ecosystem Services"};
                           int[] subchapImages13 = {R.drawable.ecosystem,R.drawable.ecosystem,R.drawable.ecosystem,R.drawable.ecosystem,R.drawable.ecosystem,R.drawable.ecosystem,R.drawable.ecosystem,R.drawable.ecosystem};
                           intent = new Intent(context.getApplicationContext(), listviewimg.class);
                           intent.putExtra("subchaptername",subchaptername13);
                           intent.putExtra("subchapImages",subchapImages13);
                           String name13 = "Ecosystem";
                           intent.putExtra("name",name13);
                           context.startActivity(intent);
                       }

                       if(message.equals("Biodiversity and Conservation")){
                           String[] subchaptername14 = {"Biodiversity","Patterns of Biodiversity","The Importance of Species Diversity to the Ecosystem","Loss of Biodiversity","Biodiversity Conservation"};
                           int[] subchapImages14 = {R.drawable.biodiversity,R.drawable.biodiversity,R.drawable.biodiversity,R.drawable.biodiversity,R.drawable.biodiversity};
                           intent = new Intent(context.getApplicationContext(), listviewimg.class);
                           intent.putExtra("subchaptername",subchaptername14);
                           intent.putExtra("subchapImages",subchapImages14);
                           String name14 = "Biodiversity and Conservation";
                           intent.putExtra("name",name14);
                           context.startActivity(intent);
                       }

                       if(message.equals("Environmental Issues")){
                           String[] subchaptername15 = {"Air Pollution and its control","Water Pollution and its control","Solid wastes","Agro- chemicals and their effects","Radioactive waste, Greenhouse Effect and Global Warming","Ozone Depletion in the Stratosphere","Degradation by improper Resource Utilization and maintenance","Deforestation"};
                           int[] subchapImages15 = {R.drawable.environmentalsys,R.drawable.environmentalsys,R.drawable.environmentalsys,R.drawable.environmentalsys,R.drawable.environmentalsys,R.drawable.environmentalsys,R.drawable.environmentalsys,R.drawable.environmentalsys};
                           intent = new Intent(context.getApplicationContext(), listviewimg.class);
                           intent.putExtra("subchaptername",subchaptername15);
                           intent.putExtra("subchapImages",subchapImages15);
                           String name15 = "Environmental Issues";
                           intent.putExtra("name",name15);
                           context.startActivity(intent);
                       }

                       if(message.equals("Biotechnology:Principles and Processes")){
                           String[] subchaptername10 = {"Principles of Biotechnology","Tools of Recombinant DNA technology- Restriction Enzymes","Cloning Vectors","Competent Host (For Transformation with Recombinant DNA)","Processes of Recombinant DNA Technology"};
                           int[] subchapImages10 = {R.drawable.biotechnology,R.drawable.biotechnology,R.drawable.biotechnology,R.drawable.biotechnology,R.drawable.biotechnology};
                           intent = new Intent(context.getApplicationContext(), listviewimg.class);
                           intent.putExtra("subchaptername",subchaptername10);
                           intent.putExtra("subchapImages",subchapImages10);
                           String name10 = "Biotechnology:Principles and Processes";
                           intent.putExtra("name",name10);
                           context.startActivity(intent);
                       }


                    }
                }
            });
        }
    }
}
