package com.example.flockflairapp;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.common.util.Strings;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;
;


public class BookmarkAdapter extends RecyclerView.Adapter<BookmarkAdapter.Viewholder> {

    private List<QuestionModel> list;
    FirebaseDatabase db = FirebaseDatabase.getInstance();
    DatabaseReference dbBookmarks = db.getReference();
    String uuid = FirebaseAuth.getInstance().getCurrentUser().getUid();

    public BookmarkAdapter(List<QuestionModel> list) {
        this.list = list;
    }
    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.bookmrk_single_item_layout,parent,false);
        return new Viewholder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
        holder.setData(list.get(position).getQuestion(),list.get(position).getCorrectAnswer(),position);
    }
    @Override
    public int getItemCount() {
        return list.size();
    }

    class Viewholder extends RecyclerView.ViewHolder{

        private ImageButton delete;
        private TextView question,answer;
        private LinearLayout linearLayout;

        public Viewholder(@NonNull View itemView) {
            super(itemView);

            linearLayout = itemView.findViewById(R.id.linearLayout);

            question = itemView.findViewById(R.id.questionBookmark);
            answer = itemView.findViewById(R.id.answerBookmark);

            delete = itemView.findViewById(R.id.deleteBookmarkBtn);
        }
        private void setData(String question, String answer, int position){
            this.question.setText(question);
            this.answer.setText(answer);

            //for jumping to DisplayQuestion at which bookmark question is
            /*linearLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });*/

            delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String pushkey = dbBookmarks.child("user").child(uuid).child("BookMarkQuestion").push().getKey();
                    if (pushkey != null){
                        dbBookmarks.child("user").child(uuid).child("BookMarkQuestion").child(pushkey).removeValue();
                        list.remove(position);
                        notifyItemRemoved(position);
                    }
                }
            });
        }
    }
}
