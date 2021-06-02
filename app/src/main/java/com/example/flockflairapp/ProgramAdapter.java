package com.example.flockflairapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.annotation.NonNull;

public class ProgramAdapter extends ArrayAdapter<String> {
    Context context;
    int[] images;
    String[] name;
    public ProgramAdapter(Context context, String[] name,int[] images) {
        super(context, R.layout.single_item,R.id.textvieww1,name);
        this.context = context;
        this.images = images;
        this.name = name;

    }
    @NonNull
    @Override
    public View getView(int position,  View convertView, ViewGroup parent) {
        View singleItem = convertView;
        ProgramViewHolder holder = null;
        if(singleItem == null)
        {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            singleItem = layoutInflater.inflate(R.layout.single_item, parent , false);
            holder = new ProgramViewHolder(singleItem);
            singleItem.setTag(holder);
        }
        else
        {
            holder = (ProgramViewHolder) singleItem.getTag();

        }
        holder.itemImage.setImageResource(images[position]);
        holder.programTitle.setText(name[position]);
        singleItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"You clicked "+name[position],Toast.LENGTH_SHORT).show();


                if(name[position].equals("What is living world?"))
                {
                    //Toast.makeText(getContext(),"You clicked here",Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "What is living world";
                    String subchapd = "Taxonomy is a branch of biology which deals with identification, nomenclature and classification of an organism.";
                    int subimage = R.drawable.thelivingworld;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Diversity in the living"))
                {
                    //Toast.makeText(getContext(),"You clicked here",Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Diversity in the living world";
                    String subchapd = "Taxonomy is a branch of biology which deals with identification, nomenclature and classification of an organism.";
                    int subimage = R.drawable.thelivingworld;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Taxonomic categories"))
                {
                    //Toast.makeText(getContext(),"You clicked here",Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Taxonomic categories";
                    String subchapd = "Taxonomy is a branch of biology which deals with identification, nomenclature and classification of an organism.";
                    int subimage = R.drawable.thelivingworld;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Taxonomic Aids"))
                {
                    //Toast.makeText(getContext(),"You clicked here",Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Taxonomic Aids";
                    String subchapd = "Taxonomy is a branch of biology which deals with identification, nomenclature and classification of an organism.";
                    int subimage = R.drawable.thelivingworld;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }


                if(name[position].equals("Introduction Biological Classification"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Introduction Biological Classification";
                    String subchapd = "Robert Whittaker an American ecologist proposed five kingdom classification- Monera, Protista, Fungi, Plantae and Animalia";
                    int subimage = R.drawable.biologicalclassification;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Kingdom Monera"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Kingdom Monera";
                    String subchapd = "Robert Whittaker an American ecologist proposed five kingdom classification- Monera, Protista, Fungi, Plantae and Animalia";
                    int subimage = R.drawable.biologicalclassification;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Kingdom Protista"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Kingdom Protista";
                    String subchapd = "Robert Whittaker an American ecologist proposed five kingdom classification- Monera, Protista, Fungi, Plantae and Animalia";
                    int subimage = R.drawable.biologicalclassification;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Kingdom Fungi"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Kingdom Fungi";
                    String subchapd = "Robert Whittaker an American ecologist proposed five kingdom classification- Monera, Protista, Fungi, Plantae and Animalia";
                    int subimage = R.drawable.biologicalclassification;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Kingdom Plantae and Kingdom Animalia"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Kingdom Plantae and Kingdom Animalia";
                    String subchapd = "Robert Whittaker an American ecologist proposed five kingdom classification- Monera, Protista, Fungi, Plantae and Animalia";
                    int subimage = R.drawable.biologicalclassification;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Virus, viroids, prions, lichens"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Virus, viroids, prions, lichens";
                    String subchapd = "Robert Whittaker an American ecologist proposed five kingdom classification- Monera, Protista, Fungi, Plantae and Animalia";
                    int subimage = R.drawable.biologicalclassification;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Introduction Plantae"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Introduction Plantae";
                    String subchapd = "Kingdom Plantae includes all the plants. They are eukaryotic, multicellular and autotrophic organisms. The plant cell contains a rigid cell wall. Plants have chlorophyll pigment, required for photosynthesis.";
                    int subimage = R.drawable.plantkingdom_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Division Thallophyta(Algae)"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Division Thallophyta(Algae)";
                    String subchapd = "Kingdom Plantae includes all the plants. They are eukaryotic, multicellular and autotrophic organisms. The plant cell contains a rigid cell wall. Plants have chlorophyll pigment, required for photosynthesis.";
                    int subimage = R.drawable.plantkingdom_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Division Bryophyta"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Division Bryophyta";
                    String subchapd = "Kingdom Plantae includes all the plants. They are eukaryotic, multicellular and autotrophic organisms. The plant cell contains a rigid cell wall. Plants have chlorophyll pigment, required for photosynthesis.";
                    int subimage = R.drawable.plantkingdom_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Division Pteridophyta"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Division Pteridophyta";
                    String subchapd = "Kingdom Plantae includes all the plants. They are eukaryotic, multicellular and autotrophic organisms. The plant cell contains a rigid cell wall. Plants have chlorophyll pigment, required for photosynthesis.";
                    int subimage = R.drawable.plantkingdom_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Division Gymnospermae"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Division Gymnospermae";
                    String subchapd = "Kingdom Plantae includes all the plants. They are eukaryotic, multicellular and autotrophic organisms. The plant cell contains a rigid cell wall. Plants have chlorophyll pigment, required for photosynthesis.";
                    int subimage = R.drawable.plantkingdom_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Division Angiospermae"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Division Angiospermae";
                    String subchapd = "Kingdom Plantae includes all the plants. They are eukaryotic, multicellular and autotrophic organisms. The plant cell contains a rigid cell wall. Plants have chlorophyll pigment, required for photosynthesis.";
                    int subimage = R.drawable.plantkingdom_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Plant life cycle and alternation of generation"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Plant life cycle and alternation of generation";
                    String subchapd = "Kingdom Plantae includes all the plants. They are eukaryotic, multicellular and autotrophic organisms. The plant cell contains a rigid cell wall. Plants have chlorophyll pigment, required for photosynthesis.";
                    int subimage = R.drawable.plantkingdom_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Basis of classification"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Basis of classification";
                    String subchapd = "The kingdom Animalia, includes all animals. Animals are multicellular, eukaryotic organisms, which are heterotrophic. Most animals obtain nutrition by ingesting other organisms or decomposing organic material.";
                    int subimage = R.drawable.animalkingdom_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);

                }
                if(name[position].equals("Phylum Porifera"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Phylum Porifera";
                    String subchapd = "The kingdom Animalia, includes all animals. Animals are multicellular, eukaryotic organisms, which are heterotrophic. Most animals obtain nutrition by ingesting other organisms or decomposing organic material.";
                    int subimage = R.drawable.animalkingdom_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);

                }
                if(name[position].equals("Phylum Coelenterata(Cnidaria)"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Phylum Coelenterata(Cnidaria)";
                    String subchapd = "The kingdom Animalia, includes all animals. Animals are multicellular, eukaryotic organisms, which are heterotrophic. Most animals obtain nutrition by ingesting other organisms or decomposing organic material.";
                    int subimage = R.drawable.animalkingdom_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);

                }
                if(name[position].equals("Phylum platyhelminthes"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Phylum platyhelminthes";
                    String subchapd = "The kingdom Animalia, includes all animals. Animals are multicellular, eukaryotic organisms, which are heterotrophic. Most animals obtain nutrition by ingesting other organisms or decomposing organic material.";
                    int subimage = R.drawable.animalkingdom_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Phylum Aschelminthes"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Phylum Aschelminthes";
                    String subchapd = "The kingdom Animalia, includes all animals. Animals are multicellular, eukaryotic organisms, which are heterotrophic. Most animals obtain nutrition by ingesting other organisms or decomposing organic material.";
                    int subimage = R.drawable.animalkingdom_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Phylum Annelida"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Phylum Annelida";
                    String subchapd = "The kingdom Animalia, includes all animals. Animals are multicellular, eukaryotic organisms, which are heterotrophic. Most animals obtain nutrition by ingesting other organisms or decomposing organic material.";
                    int subimage = R.drawable.animalkingdom_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Phylum Arthropoda"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Phylum Arthropoda";
                    String subchapd = "The kingdom Animalia, includes all animals. Animals are multicellular, eukaryotic organisms, which are heterotrophic. Most animals obtain nutrition by ingesting other organisms or decomposing organic material.";
                    int subimage = R.drawable.animalkingdom_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Phylum Mollusca"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Phylum Mollusca";
                    String subchapd = "The kingdom Animalia, includes all animals. Animals are multicellular, eukaryotic organisms, which are heterotrophic. Most animals obtain nutrition by ingesting other organisms or decomposing organic material.";
                    int subimage = R.drawable.animalkingdom_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Phylum Echinodermata"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Phylum Echinodermata";
                    String subchapd = "The kingdom Animalia, includes all animals. Animals are multicellular, eukaryotic organisms, which are heterotrophic. Most animals obtain nutrition by ingesting other organisms or decomposing organic material.";
                    int subimage = R.drawable.animalkingdom_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Phylum Hemichordata"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Phylum Hemichordata";
                    String subchapd = "The kingdom Animalia, includes all animals. Animals are multicellular, eukaryotic organisms, which are heterotrophic. Most animals obtain nutrition by ingesting other organisms or decomposing organic material.";
                    int subimage = R.drawable.animalkingdom_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Phylum Chordata"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Phylum Chordata";
                    String subchapd = "The kingdom Animalia, includes all animals. Animals are multicellular, eukaryotic organisms, which are heterotrophic. Most animals obtain nutrition by ingesting other organisms or decomposing organic material.";
                    int subimage = R.drawable.animalkingdom_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Super Class Pisces"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Super Class Pisces";
                    String subchapd = "The kingdom Animalia, includes all animals. Animals are multicellular, eukaryotic organisms, which are heterotrophic. Most animals obtain nutrition by ingesting other organisms or decomposing organic material.";
                    int subimage = R.drawable.animalkingdom_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Super Class Tetrapoda"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Super Class Tetrapoda";
                    String subchapd = "The kingdom Animalia, includes all animals. Animals are multicellular, eukaryotic organisms, which are heterotrophic. Most animals obtain nutrition by ingesting other organisms or decomposing organic material.";
                    int subimage = R.drawable.animalkingdom_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("The Root"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "The Root";
                    String subchapd = "Morphology is the name given to the science that deals with the study of the form and structure of things. Morphology of a flowering plant includes the roots, stem, leaves, flowers, and fruits.";
                    int subimage = R.drawable.morphologyoffloweringplants_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("The Stem"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "The Stem";
                    String subchapd = "Morphology is the name given to the science that deals with the study of the form and structure of things. Morphology of a flowering plant includes the roots, stem, leaves, flowers, and fruits.";
                    int subimage = R.drawable.morphologyoffloweringplants_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("The Leaf"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "The Leaf";
                    String subchapd = "Morphology is the name given to the science that deals with the study of the form and structure of things. Morphology of a flowering plant includes the roots, stem, leaves, flowers, and fruits.";
                    int subimage = R.drawable.morphologyoffloweringplants_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("The inflorescence and The Flower"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "The inflorescence and The Flower";
                    String subchapd = "Morphology is the name given to the science that deals with the study of the form and structure of things. Morphology of a flowering plant includes the roots, stem, leaves, flowers, and fruits.";
                    int subimage = R.drawable.morphologyoffloweringplants_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("The Fruit and The seed"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "The Fruit and The seed";
                    String subchapd = "Morphology is the name given to the science that deals with the study of the form and structure of things. Morphology of a flowering plant includes the roots, stem, leaves, flowers, and fruits.";
                    int subimage = R.drawable.morphologyoffloweringplants_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Description of a typical flowering plant and some important families"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Description of a typical flowering plant and some important families";
                    String subchapd = "Morphology is the name given to the science that deals with the study of the form and structure of things. Morphology of a flowering plant includes the roots, stem, leaves, flowers, and fruits.";
                    int subimage = R.drawable.morphologyoffloweringplants_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Meristematic tissue"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Meristematic tissue";
                    String subchapd = "Study of internal structure and functional organization of an organism is defined as anatomy. It consists of simple tissues such as parenchyma, collenchyma and sclerenchyma. In leaves, the ground tissue consists cells and is called mesophyll.";
                    int subimage = R.drawable.anatomy_flower_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Permanent tissue"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Permanent tissue";
                    String subchapd = "Study of internal structure and functional organization of an organism is defined as anatomy. It consists of simple tissues such as parenchyma, collenchyma and sclerenchyma. In leaves, the ground tissue consists cells and is called mesophyll.";
                    int subimage = R.drawable.anatomy_flower_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("The tissue system"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "The tissue system";
                    String subchapd = "Study of internal structure and functional organization of an organism is defined as anatomy. It consists of simple tissues such as parenchyma, collenchyma and sclerenchyma. In leaves, the ground tissue consists cells and is called mesophyll.";
                    int subimage = R.drawable.anatomy_flower_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Anatomy of Dicotyledonous and Monocotyledonous Plants"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Anatomy of Dicotyledonous and Monocotyledonous Plants";
                    String subchapd = "Study of internal structure and functional organization of an organism is defined as anatomy. It consists of simple tissues such as parenchyma, collenchyma and sclerenchyma. In leaves, the ground tissue consists cells and is called mesophyll.";
                    int subimage = R.drawable.anatomy_flower_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Secondary growth"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Secondary growth";
                    String subchapd = "Study of internal structure and functional organization of an organism is defined as anatomy. It consists of simple tissues such as parenchyma, collenchyma and sclerenchyma. In leaves, the ground tissue consists cells and is called mesophyll.";
                    int subimage = R.drawable.anatomy_flower_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Epithelial Tissue"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Epithelial Tissue";
                    String subchapd = "Histology is the branch of biology which studies the microscopic anatomy of biological tissues. Animal tissues are grouped into four basic types: connective, muscle, nervous, and epithelial.";
                    int subimage = R.drawable.structuralorg_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Connective Tissue"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Connective Tissue";
                    String subchapd = "Histology is the branch of biology which studies the microscopic anatomy of biological tissues. Animal tissues are grouped into four basic types: connective, muscle, nervous, and epithelial.";
                    int subimage = R.drawable.structuralorg_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Muscular Tissue"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Muscular Tissue";
                    String subchapd = "Histology is the branch of biology which studies the microscopic anatomy of biological tissues. Animal tissues are grouped into four basic types: connective, muscle, nervous, and epithelial.";
                    int subimage = R.drawable.structuralorg_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Nervous Tissue"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Nervous Tissue";
                    String subchapd = "Histology is the branch of biology which studies the microscopic anatomy of biological tissues. Animal tissues are grouped into four basic types: connective, muscle, nervous, and epithelial.";
                    int subimage = R.drawable.structuralorg_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Earthworm"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Earthworm";
                    String subchapd = "Histology is the branch of biology which studies the microscopic anatomy of biological tissues. Animal tissues are grouped into four basic types: connective, muscle, nervous, and epithelial.";
                    int subimage = R.drawable.structuralorg_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Cockroach"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Cockroach";
                    String subchapd = "Histology is the branch of biology which studies the microscopic anatomy of biological tissues. Animal tissues are grouped into four basic types: connective, muscle, nervous, and epithelial.";
                    int subimage = R.drawable.structuralorg_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Frog"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Frog";
                    String subchapd = "Histology is the branch of biology which studies the microscopic anatomy of biological tissues. Animal tissues are grouped into four basic types: connective, muscle, nervous, and epithelial.";
                    int subimage = R.drawable.structuralorg_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Cell theory, an overview of cell"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Cell theory, an overview of cell";
                    String subchapd = "Cells are the smallest units of life, and hence are often referred to as the building blocks of life. The study of cells is called cell biology, cellular biology, or cytology.";
                    int subimage = R.drawable.cellunitoflife_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Prokaryotic cell"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Prokaryotic cell";
                    String subchapd = "Cells are the smallest units of life, and hence are often referred to as the building blocks of life. The study of cells is called cell biology, cellular biology, or cytology.";
                    int subimage = R.drawable.cellunitoflife_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Eukaryotic cell- Cell membrane, Cell wall, Endomembrane system"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Eukaryotic cell- Cell membrane, Cell wall, Endomembrane system";
                    String subchapd = "Cells are the smallest units of life, and hence are often referred to as the building blocks of life. The study of cells is called cell biology, cellular biology, or cytology.";
                    int subimage = R.drawable.cellunitoflife_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Eukaryotic cell- Mitochondria, Plastids, Ribosomes, Cytoskeleton"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Eukaryotic cell- Mitochondria, Plastids, Ribosomes, Cytoskeleton";
                    String subchapd = "Cells are the smallest units of life, and hence are often referred to as the building blocks of life. The study of cells is called cell biology, cellular biology, or cytology.";
                    int subimage = R.drawable.cellunitoflife_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Eukaryotic cell- Cilia and Flagella, Centrosome and Centrioles, Nucleus, Microbodies"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Eukaryotic cell- Cilia and Flagella, Centrosome and Centrioles, Nucleus, Microbodies";
                    String subchapd = "Cells are the smallest units of life, and hence are often referred to as the building blocks of life. The study of cells is called cell biology, cellular biology, or cytology.";
                    int subimage = R.drawable.cellunitoflife_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("How to analyse Chemical Composition?"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "How to analyse Chemical Composition?";
                    String subchapd = "Biomolecule, also called biological molecule, any of numerous substances that are produced by cells and living organisms. They can be Carbohydrates, Proteins, Lipids and Nucleic acid.";
                    int subimage = R.drawable.biomolecules_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Primary and Secondary Metabolites, Biomacromolecules"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Primary and Secondary Metabolites, Biomacromolecules";
                    String subchapd = "Biomolecule, also called biological molecule, any of numerous substances that are produced by cells and living organisms. They can be Carbohydrates, Proteins, Lipids and Nucleic acid.";
                    int subimage = R.drawable.biomolecules_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Proteins and Structure of Proteins"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Proteins and Structure of Proteins";
                    String subchapd = "Biomolecule, also called biological molecule, any of numerous substances that are produced by cells and living organisms. They can be Carbohydrates, Proteins, Lipids and Nucleic acid.";
                    int subimage = R.drawable.biomolecules_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Polysaccharides"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Polysaccharides";
                    String subchapd = "Biomolecule, also called biological molecule, any of numerous substances that are produced by cells and living organisms. They can be Carbohydrates, Proteins, Lipids and Nucleic acid.";
                    int subimage = R.drawable.biomolecules_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Nucleic Acids"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Nucleic Acids";
                    String subchapd = "Biomolecule, also called biological molecule, any of numerous substances that are produced by cells and living organisms. They can be Carbohydrates, Proteins, Lipids and Nucleic acid.";
                    int subimage = R.drawable.biomolecules_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Nature of bond linking Monomers in a Polymer and Dynamic State of body constituents- Concepts of Metabolism"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Nature of bond linking Monomers in a Polymer and Dynamic State of body constituents- Concepts of Metabolism";
                    String subchapd = "Biomolecule, also called biological molecule, any of numerous substances that are produced by cells and living organisms. They can be Carbohydrates, Proteins, Lipids and Nucleic acid.";
                    int subimage = R.drawable.biomolecules_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Metabolic Basis for living and The Living State"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Metabolic Basis for living and The Living State";
                    String subchapd = "Biomolecule, also called biological molecule, any of numerous substances that are produced by cells and living organisms. They can be Carbohydrates, Proteins, Lipids and Nucleic acid.";
                    int subimage = R.drawable.biomolecules_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Enzymes and co-factors"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Enzymes and co-factors";
                    String subchapd = "Biomolecule, also called biological molecule, any of numerous substances that are produced by cells and living organisms. They can be Carbohydrates, Proteins, Lipids and Nucleic acid.";
                    int subimage = R.drawable.biomolecules_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Cell Cycle"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Cell Cycle";
                    String subchapd = "The cell cycle is an ordered series of events involving cell growth and cell division that produces two new daughter cells in mitosis; while meiosis produces four daughter cells.";
                    int subimage = R.drawable.cellcyccle_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Prophase"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Prophase";
                    String subchapd = "The cell cycle is an ordered series of events involving cell growth and cell division that produces two new daughter cells in mitosis; while meiosis produces four daughter cells.";
                    int subimage = R.drawable.cellcyccle_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Metaphase"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Metaphase";
                    String subchapd = "The cell cycle is an ordered series of events involving cell growth and cell division that produces two new daughter cells in mitosis; while meiosis produces four daughter cells.";
                    int subimage = R.drawable.cellcyccle_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Anaphase"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Anaphase";
                    String subchapd = "The cell cycle is an ordered series of events involving cell growth and cell division that produces two new daughter cells in mitosis; while meiosis produces four daughter cells.";
                    int subimage = R.drawable.cellcyccle_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Telophase, cytokinesis and significance of Mitosis"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Telophase, cytokinesis and significance of Mitosis";
                    String subchapd = "The cell cycle is an ordered series of events involving cell growth and cell division that produces two new daughter cells in mitosis; while meiosis produces four daughter cells.";
                    int subimage = R.drawable.cellcyccle_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Meiosis"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Meiosis";
                    String subchapd = "The cell cycle is an ordered series of events involving cell growth and cell division that produces two new daughter cells in mitosis; while meiosis produces four daughter cells.";
                    int subimage = R.drawable.cellcyccle_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Meiosis-1"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Meiosis-1";
                    String subchapd = "The cell cycle is an ordered series of events involving cell growth and cell division that produces two new daughter cells in mitosis; while meiosis produces four daughter cells.";
                    int subimage = R.drawable.cellcyccle_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Meiosis- 2 and significance of Meiosis"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Meiosis- 2 and significance of Meiosis";
                    String subchapd = "The cell cycle is an ordered series of events involving cell growth and cell division that produces two new daughter cells in mitosis; while meiosis produces four daughter cells.";
                    int subimage = R.drawable.cellcyccle_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Means of Transport"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Means of Transport";
                    String subchapd = "Plants have tissues to transport water, nutrients and minerals. Xylem transports water and mineral salts from the roots up to other parts of the plant, while phloem transports sucrose and amino acids between the leaves and other parts of the plant.";
                    int subimage = R.drawable.transportsinplants_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Plant water Relation"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Plant water Relation";
                    String subchapd = "Plants have tissues to transport water, nutrients and minerals. Xylem transports water and mineral salts from the roots up to other parts of the plant, while phloem transports sucrose and amino acids between the leaves and other parts of the plant.";
                    int subimage = R.drawable.transportsinplants_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Long Distance Transport of Water"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Long Distance Transport of Water";
                    String subchapd = "Plants have tissues to transport water, nutrients and minerals. Xylem transports water and mineral salts from the roots up to other parts of the plant, while phloem transports sucrose and amino acids between the leaves and other parts of the plant.";
                    int subimage = R.drawable.transportsinplants_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Transpiration"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Transpiration";
                    String subchapd = "Plants have tissues to transport water, nutrients and minerals. Xylem transports water and mineral salts from the roots up to other parts of the plant, while phloem transports sucrose and amino acids between the leaves and other parts of the plant.";
                    int subimage = R.drawable.transportsinplants_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Uptake and Transport of Mineral Nutrients, Phloem Transport"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Uptake and Transport of Mineral Nutrients, Phloem Transport";
                    String subchapd = "Plants have tissues to transport water, nutrients and minerals. Xylem transports water and mineral salts from the roots up to other parts of the plant, while phloem transports sucrose and amino acids between the leaves and other parts of the plant.";
                    int subimage = R.drawable.transportsinplants_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Methods to study the mineral requirements of Plants"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Methods to study the mineral requirements of Plants";
                    String subchapd = "Roots absorb mineral nutrients in the form of their salts dissolved in soil water. The study of absorption of inorganic mineral elements and their assimilation by plants is called mineral nutrition";
                    int subimage = R.drawable.mineralnutrition_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Essential Mineral Elements"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Essential Mineral Elements";
                    String subchapd = "Roots absorb mineral nutrients in the form of their salts dissolved in soil water. The study of absorption of inorganic mineral elements and their assimilation by plants is called mineral nutrition";
                    int subimage = R.drawable.mineralnutrition_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Mechanism of Absorption of Elements, Translocation of salutes, Soil as Reservoir"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Mechanism of Absorption of Elements, Translocation of salutes, Soil as Reservoir";
                    String subchapd = "Roots absorb mineral nutrients in the form of their salts dissolved in soil water. The study of absorption of inorganic mineral elements and their assimilation by plants is called mineral nutrition";
                    int subimage = R.drawable.mineralnutrition_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Nitrogen cycle and Biological Nitrogen Fixation"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Nitrogen cycle and Biological Nitrogen Fixation";
                    String subchapd = "Roots absorb mineral nutrients in the form of their salts dissolved in soil water. The study of absorption of inorganic mineral elements and their assimilation by plants is called mineral nutrition";
                    int subimage = R.drawable.mineralnutrition_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Introduction and Early Experiments"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Introduction and Early Experiments";
                    String subchapd = "Photosynthesis is a physico-chemical process by which green plants use light energy to drive the synthesis of organic compounds. It is an enzyme regulated anabolic process.";
                    int subimage = R.drawable.photosysinhighplants_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Where does Photosynthesis take place?"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Where does Photosynthesis take place?";
                    String subchapd = "Photosynthesis is a physico-chemical process by which green plants use light energy to drive the synthesis of organic compounds. It is an enzyme regulated anabolic process.";
                    int subimage = R.drawable.photosysinhighplants_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("How many Types of Pigments are involved in Photosynthesis?"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "How many Types of Pigments are involved in Photosynthesis?";
                    String subchapd = "Photosynthesis is a physico-chemical process by which green plants use light energy to drive the synthesis of organic compounds. It is an enzyme regulated anabolic process.";
                    int subimage = R.drawable.photosysinhighplants_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("What is Light Reaction?"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "What is Light Reaction?";
                    String subchapd = "Photosynthesis is a physico-chemical process by which green plants use light energy to drive the synthesis of organic compounds. It is an enzyme regulated anabolic process.";
                    int subimage = R.drawable.photosysinhighplants_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("The Electron Transport"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "The Electron Transport";
                    String subchapd = "Photosynthesis is a physico-chemical process by which green plants use light energy to drive the synthesis of organic compounds. It is an enzyme regulated anabolic process.";
                    int subimage = R.drawable.photosysinhighplants_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Where are the ATP and NADPH used?"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Where are the ATP and NADPH used?";
                    String subchapd = "Photosynthesis is a physico-chemical process by which green plants use light energy to drive the synthesis of organic compounds. It is an enzyme regulated anabolic process.";
                    int subimage = R.drawable.photosysinhighplants_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("The Calvin Cycle"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "The Calvin Cycle";
                    String subchapd = "Photosynthesis is a physico-chemical process by which green plants use light energy to drive the synthesis of organic compounds. It is an enzyme regulated anabolic process.";
                    int subimage = R.drawable.photosysinhighplants_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("The C4 pathway"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "The C4 pathway";
                    String subchapd = "Photosynthesis is a physico-chemical process by which green plants use light energy to drive the synthesis of organic compounds. It is an enzyme regulated anabolic process.";
                    int subimage = R.drawable.photosysinhighplants_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Photorespiration"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Photorespiration";
                    String subchapd = "Photosynthesis is a physico-chemical process by which green plants use light energy to drive the synthesis of organic compounds. It is an enzyme regulated anabolic process.";
                    int subimage = R.drawable.photosysinhighplants_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Factors affecting Photosynthesis"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Factors affecting Photosynthesis";
                    String subchapd = "Photosynthesis is a physico-chemical process by which green plants use light energy to drive the synthesis of organic compounds. It is an enzyme regulated anabolic process.";
                    int subimage = R.drawable.photosysinhighplants_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Introduction Respiration in Plants "))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Introduction Respiration in Plants ";
                    String subchapd = "The process of respiration in plants involves using the sugars produced during photosynthesis plus oxygen to produce energy for plant growth.";
                    int subimage = R.drawable.respiration_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Glycolysis"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Glycolysis";
                    String subchapd = "The process of respiration in plants involves using the sugars produced during photosynthesis plus oxygen to produce energy for plant growth.";
                    int subimage = R.drawable.respiration_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Fermentation"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Fermentation";
                    String subchapd = "The process of respiration in plants involves using the sugars produced during photosynthesis plus oxygen to produce energy for plant growth.";
                    int subimage = R.drawable.respiration_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Aerobic Respiration"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Aerobic Respiration";
                    String subchapd = "The process of respiration in plants involves using the sugars produced during photosynthesis plus oxygen to produce energy for plant growth.";
                    int subimage = R.drawable.respiration_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Tricarboxylic Acid Cycle"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Tricarboxylic Acid Cycle";
                    String subchapd = "The process of respiration in plants involves using the sugars produced during photosynthesis plus oxygen to produce energy for plant growth.";
                    int subimage = R.drawable.respiration_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Electron Transport System (ETS) and oxidative Phosphorylation"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Electron Transport System (ETS) and oxidative Phosphorylation";
                    String subchapd = "The process of respiration in plants involves using the sugars produced during photosynthesis plus oxygen to produce energy for plant growth.";
                    int subimage = R.drawable.respiration_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("The Respiratory Balance Sheet,  Amphibolic Pathway and Respiratory Quotient"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "The Respiratory Balance Sheet,  Amphibolic Pathway and Respiratory Quotient";
                    String subchapd = "The process of respiration in plants involves using the sugars produced during photosynthesis plus oxygen to produce energy for plant growth.";
                    int subimage = R.drawable.respiration_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Growth"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Growth";
                    String subchapd = "Most plants continue to grow throughout their lives. Like other multicellular organisms, plants grow through a combination of cell growth and cell division. The key to continued growth and repair of plant cells is meristem.";
                    int subimage = R.drawable.plantgrowth_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Phases of growth, Growth Rate, Conditions for Growth"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Phases of growth, Growth Rate, Conditions for Growth";
                    String subchapd = "Most plants continue to grow throughout their lives. Like other multicellular organisms, plants grow through a combination of cell growth and cell division. The key to continued growth and repair of plant cells is meristem.";
                    int subimage = R.drawable.plantgrowth_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Differentiation, Dedifferentiation and Redifferentiation"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Differentiation, Dedifferentiation and Redifferentiation";
                    String subchapd = "Most plants continue to grow throughout their lives. Like other multicellular organisms, plants grow through a combination of cell growth and cell division. The key to continued growth and repair of plant cells is meristem.";
                    int subimage = R.drawable.plantgrowth_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Development"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Development";
                    String subchapd = "Most plants continue to grow throughout their lives. Like other multicellular organisms, plants grow through a combination of cell growth and cell division. The key to continued growth and repair of plant cells is meristem.";
                    int subimage = R.drawable.plantgrowth_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Plant Growth Regulators- Introduction"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Plant Growth Regulators- Introduction";
                    String subchapd = "Most plants continue to grow throughout their lives. Like other multicellular organisms, plants grow through a combination of cell growth and cell division. The key to continued growth and repair of plant cells is meristem.";
                    int subimage = R.drawable.plantgrowth_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Auxin"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Auxin";
                    String subchapd = "Most plants continue to grow throughout their lives. Like other multicellular organisms, plants grow through a combination of cell growth and cell division. The key to continued growth and repair of plant cells is meristem.";
                    int subimage = R.drawable.plantgrowth_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Gibberllins"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Gibberllins";
                    String subchapd = "Most plants continue to grow throughout their lives. Like other multicellular organisms, plants grow through a combination of cell growth and cell division. The key to continued growth and repair of plant cells is meristem.";
                    int subimage = R.drawable.plantgrowth_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Cytokinins"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Cytokinins";
                    String subchapd = "Most plants continue to grow throughout their lives. Like other multicellular organisms, plants grow through a combination of cell growth and cell division. The key to continued growth and repair of plant cells is meristem.";
                    int subimage = R.drawable.plantgrowth_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Ethylene"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Ethylene";
                    String subchapd = "Most plants continue to grow throughout their lives. Like other multicellular organisms, plants grow through a combination of cell growth and cell division. The key to continued growth and repair of plant cells is meristem.";
                    int subimage = R.drawable.plantgrowth_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Abscisic Acid"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Abscisic Acid";
                    String subchapd = "Most plants continue to grow throughout their lives. Like other multicellular organisms, plants grow through a combination of cell growth and cell division. The key to continued growth and repair of plant cells is meristem.";
                    int subimage = R.drawable.plantgrowth_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Photoperiodism"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Photoperiodism";
                    String subchapd = "Most plants continue to grow throughout their lives. Like other multicellular organisms, plants grow through a combination of cell growth and cell division. The key to continued growth and repair of plant cells is meristem.";
                    int subimage = R.drawable.plantgrowth_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Vernalisation and Seed Dormancy"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Vernalisation and Seed Dormancy";
                    String subchapd = "Most plants continue to grow throughout their lives. Like other multicellular organisms, plants grow through a combination of cell growth and cell division. The key to continued growth and repair of plant cells is meristem.";
                    int subimage = R.drawable.plantgrowth_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Alimentary canal"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Alimentary canal";
                    String subchapd = "Human nutrition deals with the provision of essential nutrients in food that are necessary to support human life and good health.";
                    int subimage = R.drawable.digestionandabsorption_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Digestive Glands"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Digestive Glands";
                    String subchapd = "Human nutrition deals with the provision of essential nutrients in food that are necessary to support human life and good health.";
                    int subimage = R.drawable.digestionandabsorption_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Digestion of Food"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Digestion of Food";
                    String subchapd = "Human nutrition deals with the provision of essential nutrients in food that are necessary to support human life and good health.";
                    int subimage = R.drawable.digestionandabsorption_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Absorption of Digested Products"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Absorption of Digested Products";
                    String subchapd = "Human nutrition deals with the provision of essential nutrients in food that are necessary to support human life and good health.";
                    int subimage = R.drawable.digestionandabsorption_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Disorders of Digestive System"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Disorders of Digestive System";
                    String subchapd = "Human nutrition deals with the provision of essential nutrients in food that are necessary to support human life and good health.";
                    int subimage = R.drawable.digestionandabsorption_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Introduction Breathing and Exchange of Gases"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Introduction Breathing and Exchange of Gases";
                    String subchapd = "The process of exchange of O2 from the atmosphere with CO2 produced by the cells is called breathing, commonly known as external respiration";
                    int subimage = R.drawable.breathing_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Human Respiratory system"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Human Respiratory system";
                    String subchapd = "The process of exchange of O2 from the atmosphere with CO2 produced by the cells is called breathing, commonly known as external respiration";
                    int subimage = R.drawable.breathing_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Mechanism of Breathing"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Mechanism of Breathing";
                    String subchapd = "The process of exchange of O2 from the atmosphere with CO2 produced by the cells is called breathing, commonly known as external respiration";
                    int subimage = R.drawable.breathing_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Exchange of Gases"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Exchange of Gases";
                    String subchapd = "The process of exchange of O2 from the atmosphere with CO2 produced by the cells is called breathing, commonly known as external respiration";
                    int subimage = R.drawable.breathing_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Transport of Gases"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Transport of Gases";
                    String subchapd = "The process of exchange of O2 from the atmosphere with CO2 produced by the cells is called breathing, commonly known as external respiration";
                    int subimage = R.drawable.breathing_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Regulation of respiration and Disorders of Respiratory System"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Regulation of respiration and Disorders of Respiratory System";
                    String subchapd = "The process of exchange of O2 from the atmosphere with CO2 produced by the cells is called breathing, commonly known as external respiration";
                    int subimage = R.drawable.breathing_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Blood"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Blood";
                    String subchapd = "The circulatory system, is an organ system that permits blood to circulate and transport nutrients, oxygen, carbon dioxide, hormones, and blood cells to and from the cells in the body.";
                    int subimage = R.drawable.bodyfluids_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Blood Groups"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Blood Groups";
                    String subchapd = "The circulatory system, is an organ system that permits blood to circulate and transport nutrients, oxygen, carbon dioxide, hormones, and blood cells to and from the cells in the body.";
                    int subimage = R.drawable.bodyfluids_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Coagulation of Blood"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Coagulation of Blood";
                    String subchapd = "The circulatory system, is an organ system that permits blood to circulate and transport nutrients, oxygen, carbon dioxide, hormones, and blood cells to and from the cells in the body.";
                    int subimage = R.drawable.bodyfluids_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Lymph"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Lymph";
                    String subchapd = "The circulatory system, is an organ system that permits blood to circulate and transport nutrients, oxygen, carbon dioxide, hormones, and blood cells to and from the cells in the body.";
                    int subimage = R.drawable.bodyfluids_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Circulatory Pathway"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Circulatory Pathway";
                    String subchapd = "The circulatory system, is an organ system that permits blood to circulate and transport nutrients, oxygen, carbon dioxide, hormones, and blood cells to and from the cells in the body.";
                    int subimage = R.drawable.bodyfluids_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Human Circulatory System"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Human Circulatory System";
                    String subchapd = "The circulatory system, is an organ system that permits blood to circulate and transport nutrients, oxygen, carbon dioxide, hormones, and blood cells to and from the cells in the body.";
                    int subimage = R.drawable.bodyfluids_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Cardiac cycle"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Cardiac cycle";
                    String subchapd = "The circulatory system, is an organ system that permits blood to circulate and transport nutrients, oxygen, carbon dioxide, hormones, and blood cells to and from the cells in the body.";
                    int subimage = R.drawable.bodyfluids_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Electrocardiograph (ECG)"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Electrocardiograph (ECG)";
                    String subchapd = "The circulatory system, is an organ system that permits blood to circulate and transport nutrients, oxygen, carbon dioxide, hormones, and blood cells to and from the cells in the body.";
                    int subimage = R.drawable.bodyfluids_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Double Circulation"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Double Circulation";
                    String subchapd = "The circulatory system, is an organ system that permits blood to circulate and transport nutrients, oxygen, carbon dioxide, hormones, and blood cells to and from the cells in the body.";
                    int subimage = R.drawable.bodyfluids_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Regulation of Cardiac Activity and Disorders of Circulatory System"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Regulation of Cardiac Activity and Disorders of Circulatory System";
                    String subchapd = "The circulatory system, is an organ system that permits blood to circulate and transport nutrients, oxygen, carbon dioxide, hormones, and blood cells to and from the cells in the body.";
                    int subimage = R.drawable.bodyfluids_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Introduction Excretory Products and their Elimination"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Introduction Excretory Products and their Elimination";
                    String subchapd = "The excretory system is a vital biological system that removes excess and waste products from the body to maintain homeostasis";
                    int subimage = R.drawable.excretoryproducts_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Human Excretory System"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Human Excretory System";
                    String subchapd = "The excretory system is a vital biological system that removes excess and waste products from the body to maintain homeostasis";
                    int subimage = R.drawable.excretoryproducts_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Urine Formation"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Urine Formation";
                    String subchapd = "The excretory system is a vital biological system that removes excess and waste products from the body to maintain homeostasis";
                    int subimage = R.drawable.excretoryproducts_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Function of the Tubules"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Function of the Tubules";
                    String subchapd = "The excretory system is a vital biological system that removes excess and waste products from the body to maintain homeostasis";
                    int subimage = R.drawable.excretoryproducts_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Mechanism of Concentration of the Filtrate"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Mechanism of Concentration of the Filtrate";
                    String subchapd = "The excretory system is a vital biological system that removes excess and waste products from the body to maintain homeostasis";
                    int subimage = R.drawable.excretoryproducts_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Regulation of Kidney Function and  Micturition"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Regulation of Kidney Function and  Micturition";
                    String subchapd = "The excretory system is a vital biological system that removes excess and waste products from the body to maintain homeostasis";
                    int subimage = R.drawable.excretoryproducts_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Role of other organs in Excretion and Disorders of the Excretory System"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Role of other organs in Excretion and Disorders of the Excretory System";
                    String subchapd = "The excretory system is a vital biological system that removes excess and waste products from the body to maintain homeostasis";
                    int subimage = R.drawable.excretoryproducts_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Types of Movement"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Types of Movement";
                    String subchapd = "The skeleton is the framework that provides structure to the rest of the body and facilitates movement.";
                    int subimage = R.drawable.locomotion_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Muscle"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Muscle";
                    String subchapd = "The skeleton is the framework that provides structure to the rest of the body and facilitates movement.";
                    int subimage = R.drawable.locomotion_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Structure of contractile Proteins and Mechanism of Muscle Contraction"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Structure of contractile Proteins and Mechanism of Muscle Contraction";
                    String subchapd = "The skeleton is the framework that provides structure to the rest of the body and facilitates movement.";
                    int subimage = R.drawable.locomotion_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Skeletal System- Axial skeleton"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Skeletal System- Axial skeleton";
                    String subchapd = "The skeleton is the framework that provides structure to the rest of the body and facilitates movement.";
                    int subimage = R.drawable.locomotion_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Skeletal System- Appendicular skeleton"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Skeletal System- Appendicular skeleton";
                    String subchapd = "The skeleton is the framework that provides structure to the rest of the body and facilitates movement.";
                    int subimage = R.drawable.locomotion_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Joints"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Joints";
                    String subchapd = "The skeleton is the framework that provides structure to the rest of the body and facilitates movement.";
                    int subimage = R.drawable.locomotion_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Disorders of Muscular and Skeleton System"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Disorders of Muscular and Skeleton System";
                    String subchapd = "The skeleton is the framework that provides structure to the rest of the body and facilitates movement.";
                    int subimage = R.drawable.locomotion_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Introduction Neural Control and Coordination"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Introduction Neural Control and Coordination";
                    String subchapd = "The nervous system is the part of an animal's body that coordinates its behavior and transmits signals between different body areas. In vertebrates it consists of, the central nervous system (CNS), peripheral nervous system (PNS) and autonomic nervous system (ANS)";
                    int subimage = R.drawable.neuralcontrol_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Human Neural System"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Human Neural System";
                    String subchapd = "The nervous system is the part of an animal's body that coordinates its behavior and transmits signals between different body areas. In vertebrates it consists of, the central nervous system (CNS), peripheral nervous system (PNS) and autonomic nervous system (ANS)";
                    int subimage = R.drawable.neuralcontrol_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Neuron as Structural and Functional Unit of Neural System"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Neuron as Structural and Functional Unit of Neural System";
                    String subchapd = "The nervous system is the part of an animal's body that coordinates its behavior and transmits signals between different body areas. In vertebrates it consists of, the central nervous system (CNS), peripheral nervous system (PNS) and autonomic nervous system (ANS)";
                    int subimage = R.drawable.neuralcontrol_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Generation and Conduction of Nerve Impulse"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Generation and Conduction of Nerve Impulse";
                    String subchapd = "The nervous system is the part of an animal's body that coordinates its behavior and transmits signals between different body areas. In vertebrates it consists of, the central nervous system (CNS), peripheral nervous system (PNS) and autonomic nervous system (ANS)";
                    int subimage = R.drawable.neuralcontrol_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Transmission of Impulses"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Transmission of Impulses";
                    String subchapd = "The nervous system is the part of an animal's body that coordinates its behavior and transmits signals between different body areas. In vertebrates it consists of, the central nervous system (CNS), peripheral nervous system (PNS) and autonomic nervous system (ANS)";
                    int subimage = R.drawable.neuralcontrol_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Central Neural System"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Central Neural System";
                    String subchapd = "The nervous system is the part of an animal's body that coordinates its behavior and transmits signals between different body areas. In vertebrates it consists of, the central nervous system (CNS), peripheral nervous system (PNS) and autonomic nervous system (ANS)";
                    int subimage = R.drawable.neuralcontrol_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Reflex Action and Reflex Arc"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Reflex Action and Reflex Arc";
                    String subchapd = "The nervous system is the part of an animal's body that coordinates its behavior and transmits signals between different body areas. In vertebrates it consists of, the central nervous system (CNS), peripheral nervous system (PNS) and autonomic nervous system (ANS)";
                    int subimage = R.drawable.neuralcontrol_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Sensory Reception ans Processing"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Sensory Reception ans Processing";
                    String subchapd = "The nervous system is the part of an animal's body that coordinates its behavior and transmits signals between different body areas. In vertebrates it consists of, the central nervous system (CNS), peripheral nervous system (PNS) and autonomic nervous system (ANS)";
                    int subimage = R.drawable.neuralcontrol_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Eye"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Eye";
                    String subchapd = "The nervous system is the part of an animal's body that coordinates its behavior and transmits signals between different body areas. In vertebrates it consists of, the central nervous system (CNS), peripheral nervous system (PNS) and autonomic nervous system (ANS)";
                    int subimage = R.drawable.neuralcontrol_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("The Ear"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "The Ear";
                    String subchapd = "The nervous system is the part of an animal's body that coordinates its behavior and transmits signals between different body areas. In vertebrates it consists of, the central nervous system (CNS), peripheral nervous system (PNS) and autonomic nervous system (ANS)";
                    int subimage = R.drawable.neuralcontrol_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Human Endocrine System"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Human Endocrine System";
                    String subchapd = "Hormone is an organic substance that functions in the regulation of physiological activities and in maintaining homeostasis.";
                    int subimage = R.drawable.chemicalcordination_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("The Hypothalamus"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "The Hypothalamus";
                    String subchapd = "Hormone is an organic substance that functions in the regulation of physiological activities and in maintaining homeostasis.";
                    int subimage = R.drawable.chemicalcordination_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("The Pituitary Gland"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "The Pituitary Gland";
                    String subchapd = "Hormone is an organic substance that functions in the regulation of physiological activities and in maintaining homeostasis.";
                    int subimage = R.drawable.chemicalcordination_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("The Pineal Gland"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "The Pineal Gland";
                    String subchapd = "Hormone is an organic substance that functions in the regulation of physiological activities and in maintaining homeostasis.";
                    int subimage = R.drawable.chemicalcordination_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Thyroid Gland"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Thyroid Gland";
                    String subchapd = "Hormone is an organic substance that functions in the regulation of physiological activities and in maintaining homeostasis.";
                    int subimage = R.drawable.chemicalcordination_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Parathyroid Gland"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Parathyroid Gland";
                    String subchapd = "Hormone is an organic substance that functions in the regulation of physiological activities and in maintaining homeostasis.";
                    int subimage = R.drawable.chemicalcordination_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Thymus"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Thymus";
                    String subchapd = "Hormone is an organic substance that functions in the regulation of physiological activities and in maintaining homeostasis.";
                    int subimage = R.drawable.chemicalcordination_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Adrenal Gland"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Adrenal Gland";
                    String subchapd = "Hormone is an organic substance that functions in the regulation of physiological activities and in maintaining homeostasis.";
                    int subimage = R.drawable.chemicalcordination_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Pancreas"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Pancreas";
                    String subchapd = "Hormone is an organic substance that functions in the regulation of physiological activities and in maintaining homeostasis.";
                    int subimage = R.drawable.chemicalcordination_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Testis"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Testis";
                    String subchapd = "Hormone is an organic substance that functions in the regulation of physiological activities and in maintaining homeostasis.";
                    int subimage = R.drawable.chemicalcordination_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Ovary"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Ovary";
                    String subchapd = "Hormone is an organic substance that functions in the regulation of physiological activities and in maintaining homeostasis.";
                    int subimage = R.drawable.chemicalcordination_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Hormones of Heart, Kidney, Gastrointestinal tract and Mechanism of Hormone Action"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Hormones of Heart, Kidney, Gastrointestinal tract and Mechanism of Hormone Action";
                    String subchapd = "Hormone is an organic substance that functions in the regulation of physiological activities and in maintaining homeostasis.";
                    int subimage = R.drawable.chemicalcordination_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Introduction Reproduction in Organism"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Introduction Reproduction in Organism";
                    String subchapd = "Reproduction is the biological process by which new individual organisms – \"offspring\" – are produced from their \"parent\" or parents. It can be done by asexual mode or sexual mode.";
                    int subimage = R.drawable.reprod_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Asexual Reproduction"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Asexual Reproduction";
                    String subchapd = "Reproduction is the biological process by which new individual organisms – \"offspring\" – are produced from their \"parent\" or parents. It can be done by asexual mode or sexual mode.";
                    int subimage = R.drawable.reprod_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Sexual Reproduction"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Sexual Reproduction";
                    String subchapd = "Reproduction is the biological process by which new individual organisms – \"offspring\" – are produced from their \"parent\" or parents. It can be done by asexual mode or sexual mode.";
                    int subimage = R.drawable.reprod_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Pre- fertilization Events"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Pre- fertilization Events";
                    String subchapd = "Reproduction is the biological process by which new individual organisms – \"offspring\" – are produced from their \"parent\" or parents. It can be done by asexual mode or sexual mode.";
                    int subimage = R.drawable.reprod_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Fertilization"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Fertilization";
                    String subchapd = "Reproduction is the biological process by which new individual organisms – \"offspring\" – are produced from their \"parent\" or parents. It can be done by asexual mode or sexual mode.";
                    int subimage = R.drawable.reprod_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Post fertilization Events"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Post fertilization Events";
                    String subchapd = "Reproduction is the biological process by which new individual organisms – \"offspring\" – are produced from their \"parent\" or parents. It can be done by asexual mode or sexual mode.";
                    int subimage = R.drawable.reprod_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Flower"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Flower";
                    String subchapd = "The organ of sexual reproduction is the flower. Male gametes are found in pollen grains and produced in the anthers of the flower. Female gametes are found in ovules and produced in the ovary of the flower.";
                    int subimage = R.drawable.sexualreproductioninflower_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Pre- fertilization: Structure and events"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Pre- fertilization: Structure and events";
                    String subchapd = "The organ of sexual reproduction is the flower. Male gametes are found in pollen grains and produced in the anthers of the flower. Female gametes are found in ovules and produced in the ovary of the flower.";
                    int subimage = R.drawable.sexualreproductioninflower_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }

                if(name[position].equals("The pistil, megasporangium, and embryo sac"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "The pistil, megasporangium, and embryo sac";
                    String subchapd = "The organ of sexual reproduction is the flower. Male gametes are found in pollen grains and produced in the anthers of the flower. Female gametes are found in ovules and produced in the ovary of the flower.";
                    int subimage = R.drawable.sexualreproductioninflower_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Pollination"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Pollination";
                    String subchapd = "The organ of sexual reproduction is the flower. Male gametes are found in pollen grains and produced in the anthers of the flower. Female gametes are found in ovules and produced in the ovary of the flower.";
                    int subimage = R.drawable.sexualreproductioninflower_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Double Fertilization"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Double Fertilization";
                    String subchapd = "The organ of sexual reproduction is the flower. Male gametes are found in pollen grains and produced in the anthers of the flower. Female gametes are found in ovules and produced in the ovary of the flower.";
                    int subimage = R.drawable.sexualreproductioninflower_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Post- fertilization: structure and events"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Post- fertilization: structure and events";
                    String subchapd = "The organ of sexual reproduction is the flower. Male gametes are found in pollen grains and produced in the anthers of the flower. Female gametes are found in ovules and produced in the ovary of the flower.";
                    int subimage = R.drawable.sexualreproductioninflower_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Embryo"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Embryo";
                    String subchapd = "The organ of sexual reproduction is the flower. Male gametes are found in pollen grains and produced in the anthers of the flower. Female gametes are found in ovules and produced in the ovary of the flower.";
                    int subimage = R.drawable.sexualreproductioninflower_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Seed"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Seed";
                    String subchapd = "The organ of sexual reproduction is the flower. Male gametes are found in pollen grains and produced in the anthers of the flower. Female gametes are found in ovules and produced in the ovary of the flower.";
                    int subimage = R.drawable.sexualreproductioninflower_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Apomixis and polyembryony"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Apomixis and polyembryony";
                    String subchapd = "The organ of sexual reproduction is the flower. Male gametes are found in pollen grains and produced in the anthers of the flower. Female gametes are found in ovules and produced in the ovary of the flower.";
                    int subimage = R.drawable.sexualreproductioninflower_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("The Male Reproductive system"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "The Male Reproductive system";
                    String subchapd = "Human reproduction is a form of sexual reproduction resulting in human fertilization. During sexual intercourse, the main event is fertilization of the woman's ovum by the man's sperm.";
                    int subimage = R.drawable.humanrepr_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("The Female Reproductive system"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "The Female Reproductive system";
                    String subchapd = "Human reproduction is a form of sexual reproduction resulting in human fertilization. During sexual intercourse, the main event is fertilization of the woman's ovum by the man's sperm.";
                    int subimage = R.drawable.humanrepr_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Gametogenesis"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Gametogenesis";
                    String subchapd = "Human reproduction is a form of sexual reproduction resulting in human fertilization. During sexual intercourse, the main event is fertilization of the woman's ovum by the man's sperm.";
                    int subimage = R.drawable.humanrepr_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Menstrual cycle"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Menstrual cycle";
                    String subchapd = "Human reproduction is a form of sexual reproduction resulting in human fertilization. During sexual intercourse, the main event is fertilization of the woman's ovum by the man's sperm.";
                    int subimage = R.drawable.humanrepr_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Fertilization and Implantation"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Fertilization and Implantation";
                    String subchapd = "Human reproduction is a form of sexual reproduction resulting in human fertilization. During sexual intercourse, the main event is fertilization of the woman's ovum by the man's sperm.";
                    int subimage = R.drawable.humanrepr_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Pregnancy and Embryonic Development"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Pregnancy and Embryonic Development";
                    String subchapd = "Human reproduction is a form of sexual reproduction resulting in human fertilization. During sexual intercourse, the main event is fertilization of the woman's ovum by the man's sperm.";
                    int subimage = R.drawable.humanrepr_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Parturition and Lactation"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Parturition and Lactation";
                    String subchapd = "Human reproduction is a form of sexual reproduction resulting in human fertilization. During sexual intercourse, the main event is fertilization of the woman's ovum by the man's sperm.";
                    int subimage = R.drawable.humanrepr_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Reproductive health- problems and strategies"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Reproductive health- problems and strategies";
                    String subchapd = "Reproductive health refers to the condition of male and female reproductive systems during all life stages.";
                    int subimage = R.drawable.reproductivehealth_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Population Explosion and Birth Control"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Population Explosion and Birth Control";
                    String subchapd = "Reproductive health refers to the condition of male and female reproductive systems during all life stages.";
                    int subimage = R.drawable.reproductivehealth_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Medical Termination of Pregnancy"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Medical Termination of Pregnancy";
                    String subchapd = "Reproductive health refers to the condition of male and female reproductive systems during all life stages.";
                    int subimage = R.drawable.reproductivehealth_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Sexually Transmitted Infections"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Sexually Transmitted Infections";
                    String subchapd = "Reproductive health refers to the condition of male and female reproductive systems during all life stages.";
                    int subimage = R.drawable.reproductivehealth_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Infertility"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Infertility";
                    String subchapd = "Reproductive health refers to the condition of male and female reproductive systems during all life stages.";
                    int subimage = R.drawable.reproductivehealth_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Mendel's law of Inheritance"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Mendel's law of Inheritance";
                    String subchapd = "The garden pea plants, were studied in the mid-1800s by an Austrian monk named Gregor Mendel. With his experiments, Mendel uncovered the secrets of heredity, or how parents pass characteristics to their offspring.";
                    int subimage = R.drawable.principleofinheritance_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Inheritance if one gene"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Inheritance if one gene";
                    String subchapd = "The garden pea plants, were studied in the mid-1800s by an Austrian monk named Gregor Mendel. With his experiments, Mendel uncovered the secrets of heredity, or how parents pass characteristics to their offspring.";
                    int subimage = R.drawable.principleofinheritance_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Incomplete Dominance"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Incomplete Dominance";
                    String subchapd = "The garden pea plants, were studied in the mid-1800s by an Austrian monk named Gregor Mendel. With his experiments, Mendel uncovered the secrets of heredity, or how parents pass characteristics to their offspring.";
                    int subimage = R.drawable.principleofinheritance_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Co- dominance"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Co- dominance";
                    String subchapd = "The garden pea plants, were studied in the mid-1800s by an Austrian monk named Gregor Mendel. With his experiments, Mendel uncovered the secrets of heredity, or how parents pass characteristics to their offspring.";
                    int subimage = R.drawable.principleofinheritance_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Inheritance of two genes"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Inheritance of two genes";
                    String subchapd = "The garden pea plants, were studied in the mid-1800s by an Austrian monk named Gregor Mendel. With his experiments, Mendel uncovered the secrets of heredity, or how parents pass characteristics to their offspring.";
                    int subimage = R.drawable.principleofinheritance_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Chromosomal theory of Inheritance"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Chromosomal theory of Inheritance";
                    String subchapd = "The garden pea plants, were studied in the mid-1800s by an Austrian monk named Gregor Mendel. With his experiments, Mendel uncovered the secrets of heredity, or how parents pass characteristics to their offspring.";
                    int subimage = R.drawable.principleofinheritance_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Linkage and Recombination"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Linkage and Recombination";
                    String subchapd = "The garden pea plants, were studied in the mid-1800s by an Austrian monk named Gregor Mendel. With his experiments, Mendel uncovered the secrets of heredity, or how parents pass characteristics to their offspring.";
                    int subimage = R.drawable.principleofinheritance_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Polygenic Inheritance and Pleiotrophy"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Polygenic Inheritance and Pleiotrophy";
                    String subchapd = "The garden pea plants, were studied in the mid-1800s by an Austrian monk named Gregor Mendel. With his experiments, Mendel uncovered the secrets of heredity, or how parents pass characteristics to their offspring.";
                    int subimage = R.drawable.principleofinheritance_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Sex determination"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Sex determination";
                    String subchapd = "The garden pea plants, were studied in the mid-1800s by an Austrian monk named Gregor Mendel. With his experiments, Mendel uncovered the secrets of heredity, or how parents pass characteristics to their offspring.";
                    int subimage = R.drawable.principleofinheritance_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Mutation and Genetic disorders"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Mutation and Genetic disorders";
                    String subchapd = "The garden pea plants, were studied in the mid-1800s by an Austrian monk named Gregor Mendel. With his experiments, Mendel uncovered the secrets of heredity, or how parents pass characteristics to their offspring.";
                    int subimage = R.drawable.principleofinheritance_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("The DNA"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "The DNA";
                    String subchapd = "Molecular basis of inheritance involves the study of genes, genetic variations and heredity. DNA, RNA and genetic code form the basis of the molecular basis of inheritance.";
                    int subimage = R.drawable.molecularbasis_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Packaging of DNA helix"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Packaging of DNA helix";
                    String subchapd = "Molecular basis of inheritance involves the study of genes, genetic variations and heredity. DNA, RNA and genetic code form the basis of the molecular basis of inheritance.";
                    int subimage = R.drawable.molecularbasis_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("The search for genetic material"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "The search for genetic material";
                    String subchapd = "Molecular basis of inheritance involves the study of genes, genetic variations and heredity. DNA, RNA and genetic code form the basis of the molecular basis of inheritance.";
                    int subimage = R.drawable.molecularbasis_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Properties of genetic material and RNA world"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Properties of genetic material and RNA world";
                    String subchapd = "Molecular basis of inheritance involves the study of genes, genetic variations and heredity. DNA, RNA and genetic code form the basis of the molecular basis of inheritance.";
                    int subimage = R.drawable.molecularbasis_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Replication"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Replication";
                    String subchapd = "Molecular basis of inheritance involves the study of genes, genetic variations and heredity. DNA, RNA and genetic code form the basis of the molecular basis of inheritance.";
                    int subimage = R.drawable.molecularbasis_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Transcription"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Transcription";
                    String subchapd = "Molecular basis of inheritance involves the study of genes, genetic variations and heredity. DNA, RNA and genetic code form the basis of the molecular basis of inheritance.";
                    int subimage = R.drawable.molecularbasis_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Genetic code"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Genetic code";
                    String subchapd = "Molecular basis of inheritance involves the study of genes, genetic variations and heredity. DNA, RNA and genetic code form the basis of the molecular basis of inheritance.";
                    int subimage = R.drawable.molecularbasis_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Translation"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Translation";
                    String subchapd = "Molecular basis of inheritance involves the study of genes, genetic variations and heredity. DNA, RNA and genetic code form the basis of the molecular basis of inheritance.";
                    int subimage = R.drawable.molecularbasis_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Regulation of gene Expression"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Regulation of gene Expression";
                    String subchapd = "Molecular basis of inheritance involves the study of genes, genetic variations and heredity. DNA, RNA and genetic code form the basis of the molecular basis of inheritance.";
                    int subimage = R.drawable.molecularbasis_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Human genome project"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Human genome project";
                    String subchapd = "Molecular basis of inheritance involves the study of genes, genetic variations and heredity. DNA, RNA and genetic code form the basis of the molecular basis of inheritance.";
                    int subimage = R.drawable.molecularbasis_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("DNA Fingerprinting"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "DNA Fingerprinting";
                    String subchapd = "Molecular basis of inheritance involves the study of genes, genetic variations and heredity. DNA, RNA and genetic code form the basis of the molecular basis of inheritance.";
                    int subimage = R.drawable.molecularbasis_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Origin of Life"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Origin of Life";
                    String subchapd = "Darwin defined evolution as \"descent with modification,\" the idea that species change over time, give rise to new species, and share a common ancestor.";
                    int subimage = R.drawable.evolution_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Evolution of life forms- A theory"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Evolution of life forms- A theory";
                    String subchapd = "Darwin defined evolution as \"descent with modification,\" the idea that species change over time, give rise to new species, and share a common ancestor.";
                    int subimage = R.drawable.evolution_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("What are the evidences for Evolution?"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "What are the evidences for Evolution?";
                    String subchapd = "Darwin defined evolution as \"descent with modification,\" the idea that species change over time, give rise to new species, and share a common ancestor.";
                    int subimage = R.drawable.evolution_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("What is adaptive Radiation?"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "What is adaptive Radiation?";
                    String subchapd = "Darwin defined evolution as \"descent with modification,\" the idea that species change over time, give rise to new species, and share a common ancestor.";
                    int subimage = R.drawable.evolution_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Biological Evidence"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Biological Evidence";
                    String subchapd = "Darwin defined evolution as \"descent with modification,\" the idea that species change over time, give rise to new species, and share a common ancestor.";
                    int subimage = R.drawable.evolution_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Mechanism of Evolution and Hardy Weinberg Principle"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Mechanism of Evolution and Hardy Weinberg Principle";
                    String subchapd = "Darwin defined evolution as \"descent with modification,\" the idea that species change over time, give rise to new species, and share a common ancestor.";
                    int subimage = R.drawable.evolution_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("A Brief account of Evolution"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "A Brief account of Evolution";
                    String subchapd = "Darwin defined evolution as \"descent with modification,\" the idea that species change over time, give rise to new species, and share a common ancestor.";
                    int subimage = R.drawable.evolution_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Origin and Evolution of Man"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Origin and Evolution of Man";
                    String subchapd = "Darwin defined evolution as \"descent with modification,\" the idea that species change over time, give rise to new species, and share a common ancestor.";
                    int subimage = R.drawable.evolution_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Introduction Human Health and Disease"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Introduction Human Health and Disease";
                    String subchapd = "In the past health has been thought of as just the absence of disease, however today it is thought of more as the state of physical, social and mental wellbeing";
                    int subimage = R.drawable.humanhealthdiseases_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Common Diseases in Humans"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Common Diseases in Humans";
                    String subchapd = "In the past health has been thought of as just the absence of disease, however today it is thought of more as the state of physical, social and mental wellbeing";
                    int subimage = R.drawable.humanhealthdiseases_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Immunity"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Immunity";
                    String subchapd = "In the past health has been thought of as just the absence of disease, however today it is thought of more as the state of physical, social and mental wellbeing";
                    int subimage = R.drawable.humanhealthdiseases_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("AIDS"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "AIDS";
                    String subchapd = "In the past health has been thought of as just the absence of disease, however today it is thought of more as the state of physical, social and mental wellbeing";
                    int subimage = R.drawable.humanhealthdiseases_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Cancer"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Cancer";
                    String subchapd = "In the past health has been thought of as just the absence of disease, however today it is thought of more as the state of physical, social and mental wellbeing";
                    int subimage = R.drawable.humanhealthdiseases_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Drugs and Alcohol abuse"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Drugs and Alcohol abuse";
                    String subchapd = "In the past health has been thought of as just the absence of disease, however today it is thought of more as the state of physical, social and mental wellbeing";
                    int subimage = R.drawable.humanhealthdiseases_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Dairy and Poultry Farm management"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Dairy and Poultry Farm management";
                    String subchapd = "With ever-increasing population of the world, enhancement of food production is a major necessity. Biological principles as applied to animal husbandry and plant breeding have a major role in our efforts to increase food production.";
                    int subimage = R.drawable.stratergiesenhancement_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Animal Breeding"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Animal Breeding";
                    String subchapd = "With ever-increasing population of the world, enhancement of food production is a major necessity. Biological principles as applied to animal husbandry and plant breeding have a major role in our efforts to increase food production.";
                    int subimage = R.drawable.stratergiesenhancement_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Bee- keeping and Fisheries"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Bee- keeping and Fisheries";
                    String subchapd = "With ever-increasing population of the world, enhancement of food production is a major necessity. Biological principles as applied to animal husbandry and plant breeding have a major role in our efforts to increase food production.";
                    int subimage = R.drawable.stratergiesenhancement_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("What is Plant breeding"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "What is Plant breeding";
                    String subchapd = "With ever-increasing population of the world, enhancement of food production is a major necessity. Biological principles as applied to animal husbandry and plant breeding have a major role in our efforts to increase food production.";
                    int subimage = R.drawable.stratergiesenhancement_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Plant breeding for Disease Resistance"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Plant breeding for Disease Resistance";
                    String subchapd = "With ever-increasing population of the world, enhancement of food production is a major necessity. Biological principles as applied to animal husbandry and plant breeding have a major role in our efforts to increase food production.";
                    int subimage = R.drawable.stratergiesenhancement_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Plant breeding for developing Resistance to Insect Pests"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Plant breeding for developing Resistance to Insect Pests";
                    String subchapd = "With ever-increasing population of the world, enhancement of food production is a major necessity. Biological principles as applied to animal husbandry and plant breeding have a major role in our efforts to increase food production.";
                    int subimage = R.drawable.stratergiesenhancement_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Plant breeding for Improved Food Quality"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Plant breeding for Improved Food Quality";
                    String subchapd = "With ever-increasing population of the world, enhancement of food production is a major necessity. Biological principles as applied to animal husbandry and plant breeding have a major role in our efforts to increase food production.";
                    int subimage = R.drawable.stratergiesenhancement_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Single Cell protein"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Single Cell protein";
                    String subchapd = "With ever-increasing population of the world, enhancement of food production is a major necessity. Biological principles as applied to animal husbandry and plant breeding have a major role in our efforts to increase food production.";
                    int subimage = R.drawable.stratergiesenhancement_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Tissue Culture"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Tissue Culture";
                    String subchapd = "With ever-increasing population of the world, enhancement of food production is a major necessity. Biological principles as applied to animal husbandry and plant breeding have a major role in our efforts to increase food production.";
                    int subimage = R.drawable.stratergiesenhancement_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Introduction Microbes in Human Welfare"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Introduction Microbes in Human Welfare";
                    String subchapd = "Microbes are diverse such that they are protozoa, bacteria, fungi and viruses,viroids and prions. Microbes cause a large number of diseases but all microbes are not harmful; several microbes are useful to man in diverse ways.";
                    int subimage = R.drawable.microbesinwelfare_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Microbes in Household Products"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Microbes in Household Products";
                    String subchapd = "Microbes are diverse such that they are protozoa, bacteria, fungi and viruses,viroids and prions. Microbes cause a large number of diseases but all microbes are not harmful; several microbes are useful to man in diverse ways.";
                    int subimage = R.drawable.microbesinwelfare_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Microbes in Industrial Products"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Microbes in Industrial Products";
                    String subchapd = "Microbes are diverse such that they are protozoa, bacteria, fungi and viruses,viroids and prions. Microbes cause a large number of diseases but all microbes are not harmful; several microbes are useful to man in diverse ways.";
                    int subimage = R.drawable.microbesinwelfare_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Microbes in Sewage treatment"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Microbes in Sewage treatment";
                    String subchapd = "Microbes are diverse such that they are protozoa, bacteria, fungi and viruses,viroids and prions. Microbes cause a large number of diseases but all microbes are not harmful; several microbes are useful to man in diverse ways.";
                    int subimage = R.drawable.microbesinwelfare_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Microbes in production of Biogas"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Microbes in production of Biogas";
                    String subchapd = "Microbes are diverse such that they are protozoa, bacteria, fungi and viruses,viroids and prions. Microbes cause a large number of diseases but all microbes are not harmful; several microbes are useful to man in diverse ways.";
                    int subimage = R.drawable.microbesinwelfare_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Microbes as Biocontrol Agents"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Microbes as Biocontrol Agents";
                    String subchapd = "Microbes are diverse such that they are protozoa, bacteria, fungi and viruses,viroids and prions. Microbes cause a large number of diseases but all microbes are not harmful; several microbes are useful to man in diverse ways.";
                    int subimage = R.drawable.microbesinwelfare_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Microbes as Biofertilizers"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Microbes as Biofertilizers";
                    String subchapd = "Microbes are diverse such that they are protozoa, bacteria, fungi and viruses,viroids and prions. Microbes cause a large number of diseases but all microbes are not harmful; several microbes are useful to man in diverse ways.";
                    int subimage = R.drawable.microbesinwelfare_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Principles of Biotechnology"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Principles of Biotechnology";
                    String subchapd = "Biotechnology is the branch of applied science that utilizes living organisms and their derivatives in order to produce products and processes for human benefit.";
                    int subimage = R.drawable.biotechnology_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Tools of Recombinant DNA technology- Restriction Enzymes"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Tools of Recombinant DNA technology- Restriction Enzymes";
                    String subchapd = "Biotechnology is the branch of applied science that utilizes living organisms and their derivatives in order to produce products and processes for human benefit.";
                    int subimage = R.drawable.biotechnology_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Cloning Vectors"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Cloning Vectors";
                    String subchapd = "Biotechnology is the branch of applied science that utilizes living organisms and their derivatives in order to produce products and processes for human benefit.";
                    int subimage = R.drawable.biotechnology_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Competent Host (For Transformation with Recombinant DNA)"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Competent Host (For Transformation with Recombinant DNA)";
                    String subchapd = "Biotechnology is the branch of applied science that utilizes living organisms and their derivatives in order to produce products and processes for human benefit.";
                    int subimage = R.drawable.biotechnology_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Processes of Recombinant DNA Technology"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Processes of Recombinant DNA Technology";
                    String subchapd = "Biotechnology is the branch of applied science that utilizes living organisms and their derivatives in order to produce products and processes for human benefit.";
                    int subimage = R.drawable.biotechnology_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Biotechnological applications in Agriculture"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Biotechnological applications in Agriculture";
                    String subchapd = "The recombinant DNA technological processes have made immense impact in the area of healthcare by enabling mass production of safe and more effective therapeutic drugs";
                    int subimage = R.drawable.bioapplications_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Biotechnological applications in Medicine"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Biotechnological applications in Medicine";
                    String subchapd = "The recombinant DNA technological processes have made immense impact in the area of healthcare by enabling mass production of safe and more effective therapeutic drugs";
                    int subimage = R.drawable.bioapplications_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Transgenic Animals"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Transgenic Animals";
                    String subchapd = "The recombinant DNA technological processes have made immense impact in the area of healthcare by enabling mass production of safe and more effective therapeutic drugs";
                    int subimage = R.drawable.bioapplications_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Ethical Issues"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Ethical Issues";
                    String subchapd = "The recombinant DNA technological processes have made immense impact in the area of healthcare by enabling mass production of safe and more effective therapeutic drugs";
                    int subimage = R.drawable.bioapplications_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Organisms and its environment"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Organisms and its environment";
                    String subchapd = "Population study, known as 'Demography', is the statistical study of human populations especially with reference to size and density, distribution, and vital statistics";
                    int subimage = R.drawable.population_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Responses to Abiotic Factors and Adaptations"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Responses to Abiotic Factors and Adaptations";
                    String subchapd = "Population study, known as 'Demography', is the statistical study of human populations especially with reference to size and density, distribution, and vital statistics";
                    int subimage = R.drawable.population_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Population"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Population";
                    String subchapd = "Population study, known as 'Demography', is the statistical study of human populations especially with reference to size and density, distribution, and vital statistics";
                    int subimage = R.drawable.population_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Population Growth"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Population Growth";
                    String subchapd = "Population study, known as 'Demography', is the statistical study of human populations especially with reference to size and density, distribution, and vital statistics";
                    int subimage = R.drawable.population_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Population Interactions"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Population Interactions";
                    String subchapd = "Population study, known as 'Demography', is the statistical study of human populations especially with reference to size and density, distribution, and vital statistics";
                    int subimage = R.drawable.population_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Ecosystem- Structure and Function"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Ecosystem- Structure and Function";
                    String subchapd = "An ecosystem is a community of living organisms in conjunction with the nonliving components of their environment, interacting as a system. These biotic and abiotic components are linked together through nutrient cycles and energy flows.";
                    int subimage = R.drawable.ecosystem_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Productivity"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Productivity";
                    String subchapd = "An ecosystem is a community of living organisms in conjunction with the nonliving components of their environment, interacting as a system. These biotic and abiotic components are linked together through nutrient cycles and energy flows.";
                    int subimage = R.drawable.ecosystem_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Decomposition"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Decomposition";
                    String subchapd = "An ecosystem is a community of living organisms in conjunction with the nonliving components of their environment, interacting as a system. These biotic and abiotic components are linked together through nutrient cycles and energy flows.";
                    int subimage = R.drawable.ecosystem_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Energy Flow"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Energy Flow";
                    String subchapd = "An ecosystem is a community of living organisms in conjunction with the nonliving components of their environment, interacting as a system. These biotic and abiotic components are linked together through nutrient cycles and energy flows.";
                    int subimage = R.drawable.ecosystem_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Ecological Pyramids"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Ecological Pyramids";
                    String subchapd = "An ecosystem is a community of living organisms in conjunction with the nonliving components of their environment, interacting as a system. These biotic and abiotic components are linked together through nutrient cycles and energy flows.";
                    int subimage = R.drawable.ecosystem_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Ecological Succession"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Ecological Succession";
                    String subchapd = "An ecosystem is a community of living organisms in conjunction with the nonliving components of their environment, interacting as a system. These biotic and abiotic components are linked together through nutrient cycles and energy flows.";
                    int subimage = R.drawable.ecosystem_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Nutrient Cycling"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Nutrient Cycling";
                    String subchapd = "An ecosystem is a community of living organisms in conjunction with the nonliving components of their environment, interacting as a system. These biotic and abiotic components are linked together through nutrient cycles and energy flows.";
                    int subimage = R.drawable.ecosystem_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Ecosystem Services"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Ecosystem Services";
                    String subchapd = "An ecosystem is a community of living organisms in conjunction with the nonliving components of their environment, interacting as a system. These biotic and abiotic components are linked together through nutrient cycles and energy flows.";
                    int subimage = R.drawable.ecosystem_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Biodiversity"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Biodiversity";
                    String subchapd = "Biodiversity conservation refers to the protection, preservation, and management of ecosystems and natural habitats and ensuring that they are healthy and functional. To protect and preserve species diversity.";
                    int subimage = R.drawable.biodiversity_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Patterns of Biodiversity"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Patterns of Biodiversity";
                    String subchapd = "Biodiversity conservation refers to the protection, preservation, and management of ecosystems and natural habitats and ensuring that they are healthy and functional. To protect and preserve species diversity.";
                    int subimage = R.drawable.biodiversity_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("The Importance of Species Diversity to the Ecosystem"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "The Importance of Species Diversity to the Ecosystem";
                    String subchapd = "Biodiversity conservation refers to the protection, preservation, and management of ecosystems and natural habitats and ensuring that they are healthy and functional. To protect and preserve species diversity.";
                    int subimage = R.drawable.biodiversity_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Loss of Biodiversity"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Loss of Biodiversity";
                    String subchapd = "Biodiversity conservation refers to the protection, preservation, and management of ecosystems and natural habitats and ensuring that they are healthy and functional. To protect and preserve species diversity.";
                    int subimage = R.drawable.biodiversity_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Biodiversity Conservation"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Biodiversity Conservation";
                    String subchapd = "Biodiversity conservation refers to the protection, preservation, and management of ecosystems and natural habitats and ensuring that they are healthy and functional. To protect and preserve species diversity.";
                    int subimage = R.drawable.biodiversity_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Air Pollution and its control"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Air Pollution and its control";
                    String subchapd = "Pollution is the introduction of contaminants into the natural environment that cause adverse change. Pollution can take the form of chemical substances or energy, such as noise, heat, or light.";
                    int subimage = R.drawable.environmentalsys_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Water Pollution and its control"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Water Pollution and its control";
                    String subchapd = "Pollution is the introduction of contaminants into the natural environment that cause adverse change. Pollution can take the form of chemical substances or energy, such as noise, heat, or light.";
                    int subimage = R.drawable.environmentalsys_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Solid wastes"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Solid wastes";
                    String subchapd = "Pollution is the introduction of contaminants into the natural environment that cause adverse change. Pollution can take the form of chemical substances or energy, such as noise, heat, or light.";
                    int subimage = R.drawable.environmentalsys_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Agro- chemicals and their effects"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Agro- chemicals and their effects";
                    String subchapd = "Pollution is the introduction of contaminants into the natural environment that cause adverse change. Pollution can take the form of chemical substances or energy, such as noise, heat, or light.";
                    int subimage = R.drawable.environmentalsys_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Radioactive waste, Greenhouse Effect and Global Warming"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Radioactive waste, Greenhouse Effect and Global Warming";
                    String subchapd = "Pollution is the introduction of contaminants into the natural environment that cause adverse change. Pollution can take the form of chemical substances or energy, such as noise, heat, or light.";
                    int subimage = R.drawable.environmentalsys_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Ozone Depletion in the Stratosphere"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Ozone Depletion in the Stratosphere";
                    String subchapd = "Pollution is the introduction of contaminants into the natural environment that cause adverse change. Pollution can take the form of chemical substances or energy, such as noise, heat, or light.";
                    int subimage = R.drawable.environmentalsys_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Degradation by improper Resource Utilization and maintenance"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Degradation by improper Resource Utilization and maintenance";
                    String subchapd = "Pollution is the introduction of contaminants into the natural environment that cause adverse change. Pollution can take the form of chemical substances or energy, such as noise, heat, or light.";
                    int subimage = R.drawable.environmentalsys_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Deforestation"))
                {
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "Deforestation";
                    String subchapd = "Pollution is the introduction of contaminants into the natural environment that cause adverse change. Pollution can take the form of chemical substances or energy, such as noise, heat, or light.";
                    int subimage = R.drawable.environmentalsys_r;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
















            }
        });
        return singleItem;
    }
}
