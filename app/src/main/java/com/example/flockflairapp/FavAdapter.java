package com.example.flockflairapp;

import android.content.Context;
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
                        Toast.makeText(v.getContext(), message, Toast.LENGTH_SHORT).show();

                    }
                }
            });
        }
    }
}
