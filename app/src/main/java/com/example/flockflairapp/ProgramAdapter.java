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


                if(name[position].equals("What is living?"))
                {
                    //Toast.makeText(getContext(),"You clicked here",Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(v.getContext(),landing.class);
                    String subchap = "What is living";
                    String subchapd = "Lorem ipsum dolor sit amet, consectetuer adipiscing elit enim.";
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
                    String subchapd = "Lorem ipsum dolor sit amet, consectetuer adipiscing elit enim.";
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
                    String subchapd = "Lorem ipsum dolor sit amet, consectetuer adipiscing elit enim.";
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
                    String subchapd = "Lorem ipsum dolor sit amet, consectetuer adipiscing elit enim.";
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
                    String subchapd = "Lorem ipsum dolor sit amet, consectetuer adipiscing elit enim.";
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
                    String subchapd = "Lorem ipsum dolor sit amet, consectetuer adipiscing elit enim.";
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
                    String subchapd = "Lorem ipsum dolor sit amet, consectetuer adipiscing elit enim.";
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
                    String subchapd = "Lorem ipsum dolor sit amet, consectetuer adipiscing elit enim.";
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
                    String subchapd = "Lorem ipsum dolor sit amet, consectetuer adipiscing elit enim.";
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
                    String subchapd = "Lorem ipsum dolor sit amet, consectetuer adipiscing elit enim.";
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
                    String subchapd = "Lorem ipsum dolor sit amet, consectetuer adipiscing elit enim.";
                    int subimage = R.drawable.plantkingdom;
                    i.putExtra("sub_chap_name",subchap);
                    i.putExtra("sub_chap_desc",subchapd);
                    i.putExtra("sub_chap_img",subimage);
                    v.getContext().startActivity(i);
                }
                if(name[position].equals("Basis of classification"))
                {
                    //Toast.makeText(getContext(),"You clicked here",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent();
                    //intent = new Intent(context.getApplicationContext(),DisplayQuestions.class);
                    v.getContext().startActivity(new Intent(v.getContext(),DisplayQuestions.class));
                }



            }
        });
        return singleItem;
    }
}
