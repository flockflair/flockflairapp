package com.eosphorus.flockflairapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
//myadapter
public class RecyclerAdap extends FirebaseRecyclerAdapter<model,RecyclerAdap.myviewholder>
{
    public RecyclerAdap(@NonNull FirebaseRecyclerOptions<model> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myviewholder holder, int position, @NonNull model model)
    {
        holder.chaptername.setText(model.getChaptername());

    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_design,parent,false);
        return new myviewholder(view);
    }

    class myviewholder extends RecyclerView.ViewHolder
    {
        TextView chaptername;
        public myviewholder(@NonNull View itemView) {
            super(itemView);
            chaptername=(TextView)itemView.findViewById(R.id.textid1);

        }
    }

}
