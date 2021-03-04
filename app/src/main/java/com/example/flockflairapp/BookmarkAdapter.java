package com.example.flockflairapp;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;



public class BookmarkAdapter extends RecyclerView.Adapter<BookmarkAdapter.Viewholder> {

    private static final String TAG = "DeleteBookmark";
    private List<QuestionModel> list;
    //instance of firebase
    FirebaseDatabase db = FirebaseDatabase.getInstance();
    DatabaseReference dbBookmarks = db.getReference();
    String uuid = FirebaseAuth.getInstance().getCurrentUser().getUid();
    public static String pushKey = "";
    public static List<String> keyList = new ArrayList<>();

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
        holder.setData(list.get(position).getQuestion(),list.get(position).getChapterName(),position);
    }
    @Override
    public int getItemCount() {
        return list.size();
    }

    class Viewholder extends RecyclerView.ViewHolder {

        private ImageButton delete;
        private TextView question,chapterName;
        private LinearLayout linearLayout;
        //private TextView answer;

        public Viewholder(@NonNull View itemView) {
            super(itemView);

            question = itemView.findViewById(R.id.questionBookmark);
            //answer = itemView.findViewById(R.id.answerBookmark);
            chapterName = itemView.findViewById(R.id.chapterName);
            delete = itemView.findViewById(R.id.deleteBookmarkBtn);
            linearLayout = itemView.findViewById(R.id.linearLayoutBookmark);

        }
        private void setData(String question, String chapterName, int position){
            this.question.setText(question);
            this.chapterName.setText(chapterName);

            linearLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(view.getContext(), DisplayQuestions.class);
                    view.getContext().startActivity(intent);
                }
            });



            delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //for getting pushed Id and delete bookmark from database
                    dbBookmarks.child("user").child(uuid).orderByKey().addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            for (DataSnapshot dss : snapshot.getChildren()) {
                                pushKey = dss.getKey();
                                keyList.add(pushKey);
                            }
                            dbBookmarks.child("user").child(uuid).child(keyList.get(position)).removeValue();
                            dbBookmarks.keepSynced(true);
                            notifyDataSetChanged();
                            keyList = new ArrayList<>();
                            list.remove(position);
                            notifyItemRemoved(position);
                        }
                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {
                            Log.i(TAG, error.getMessage());
                        }
                    });
                }
            });
        }
    }
}
