package com.example.flockflairapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import static androidx.core.content.ContextCompat.startActivities;
import static androidx.core.content.ContextCompat.startActivity;

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


                if(name[position].equals("Introduction"))
                {
                    //Toast.makeText(getContext(),"You clicked here",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent();
                    //intent = new Intent(context.getApplicationContext(),DisplayQuestions.class);
                    v.getContext().startActivity(new Intent(v.getContext(),DisplayQuestions.class));
                }

                if(name[position].equals("Introduction Plantae"))
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
