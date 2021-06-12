package com.example.flockflairapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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
                            //intent.putExtra("sub1","sub1");
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
                            //intent.putExtra("sub1","sub1");
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


                    }
                }
            });
        }
    }
}
