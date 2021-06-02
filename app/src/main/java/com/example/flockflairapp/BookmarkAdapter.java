package com.example.flockflairapp;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class BookmarkAdapter extends RecyclerView.Adapter<BookmarkAdapter.Viewholder> {

    BookmarkActivity bookmarkActivity;
    Context context;
    private static final String TAG = "DeleteBookmark";
    public static List<QuestionModel> booKlist;
    //instance of firebase
    FirebaseDatabase db = FirebaseDatabase.getInstance();
    DatabaseReference dbBookmarks = db.getReference();
    String uuid = FirebaseAuth.getInstance().getCurrentUser().getUid();
    public static String pushKey = "";
    public static List<String> keyList = new ArrayList<>();


    public BookmarkAdapter(List<QuestionModel> booKlist, Context context) {
        this.booKlist = booKlist;
        this.context = context;
        this.bookmarkActivity = (BookmarkActivity) context;
    }

    public void  filterList(ArrayList<QuestionModel> filterList){
        booKlist = filterList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.bookmrk_single_item_layout,parent,false);
        Viewholder viewholder = new Viewholder(view, bookmarkActivity);
        return viewholder;
    }
    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
        holder.setData(booKlist.get(position).getQuestion(),booKlist.get(position).getChapterName(),position);
    }
    @Override
    public int getItemCount() {
        return booKlist == null ? 0 : booKlist.size();
    }


    public static class Viewholder extends RecyclerView.ViewHolder {

        TextView question,chapterName;
        LinearLayout linearLayout;
        CheckBox checkBox;
        ImageButton delete;
        FirebaseDatabase db = FirebaseDatabase.getInstance();
        DatabaseReference dbBookmarks = db.getReference();
        String uuid = FirebaseAuth.getInstance().getCurrentUser().getUid();
        //private TextView answer;
        BookmarkActivity bookmarkActivity;

        public Viewholder(@NonNull View itemView, BookmarkActivity bookmarkActivity) {
            super(itemView);

            question = itemView.findViewById(R.id.questionBookmark);
            //answer = itemView.findViewById(R.id.answerBookmark);
            chapterName = itemView.findViewById(R.id.chapterName);
            delete = itemView.findViewById(R.id.deleteBookmarkBtn);
            linearLayout = itemView.findViewById(R.id.linearLayoutBookmark);
            checkBox = itemView.findViewById(R.id.CheckBox);
            this.bookmarkActivity = bookmarkActivity;


        }
        public void setData(String question, String chapterName, int position){
            this.question.setText(question);
            this.chapterName.setText(chapterName);

            linearLayout.setOnClickListener(view -> {
                Intent intent = new Intent(view.getContext(), BookMarksDisplayQuestion.class);
                intent.putExtra("position", position);
                /*intent.putExtra("Qpos", String.valueOf(booKlist.get(position).getQuestion()));
                intent.putExtra("OApos", String.valueOf(booKlist.get(position).getOptionA()));
                intent.putExtra("OBpos", String.valueOf(booKlist.get(position).getOptionB()));
                intent.putExtra("OCpos", String.valueOf(booKlist.get(position).getOptionC()));
                intent.putExtra("ODpos", String.valueOf(booKlist.get(position).getOptionD()));
                intent.putExtra("DDpos", String.valueOf(booKlist.get(position).getDifficulty()));
                intent.putExtra("CApos", String.valueOf(booKlist.get(position).getCorrectAnswer()));
                intent.putExtra("Expos", String.valueOf(booKlist.get(position).getExplaination()));*/
                view.getContext().startActivity(intent);
            });

            delete.setOnClickListener(view -> {
                //for getting pushed Id and delete bookmark from database
                dbBookmarks.child("user").child(uuid).child("Bookmarks").orderByKey().addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        keyList.clear();
                        for (DataSnapshot dss : snapshot.getChildren()) {
                            pushKey = dss.getKey();
                            keyList.add(pushKey);
                        }
                        AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                        builder.setTitle("you are deleting Bookmark?");
                        builder.setPositiveButton("Yes", (dialog, which) -> {
                            dbBookmarks.child("user").child(uuid).child("Bookmarks").child(keyList.get(position)).removeValue();
                            booKlist.remove(position);
                            bookmarkActivity.adapter.notifyDataSetChanged();
                            Toast.makeText(view.getContext(), " Bookmark deleted", Toast.LENGTH_LONG).show();
                        });
                        builder.setNegativeButton("No", (dialogInterface, i) -> {
                            Toast.makeText(view.getContext(), "Cancel", Toast.LENGTH_LONG).show();
                        });
                        builder.show();
                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        Log.i(TAG, error.getMessage());
                    }
                });
            });

            linearLayout.setOnLongClickListener(bookmarkActivity);

            if (!bookmarkActivity.isActionMode){
                delete.setVisibility(View.VISIBLE);
                checkBox.setVisibility(View.GONE);
            }else {
                delete.setVisibility(View.GONE);
                checkBox.setVisibility(View.VISIBLE);
                checkBox.setChecked(false);
            }
            //checkbox setChecked if selectAll option is selected
            if (bookmarkActivity.selectionList.size()==booKlist.size()){
                checkBox.setChecked(true);
            }else {
                checkBox.setChecked(false);
            }

            checkBox.setOnClickListener(view -> {
                bookmarkActivity.prepareSelection(view, getAdapterPosition());
            });


        }
    }

    //delete selected
    public void updateAdapter(ArrayList<QuestionModel> list){
        for (QuestionModel questionModel:list){

            Query deleteMultiQuery = dbBookmarks.child("user").child(uuid).child("Bookmarks").orderByChild("question").equalTo(questionModel.getQuestion());

            deleteMultiQuery.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    for (DataSnapshot dataSnapshot:snapshot.getChildren()){
                        dataSnapshot.getRef().removeValue();
                    }
                }
                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                    Log.d("BookmarkAdapter", error.getMessage());
                }
            });
            booKlist.remove(questionModel);
        }
        notifyDataSetChanged();
    }
}
