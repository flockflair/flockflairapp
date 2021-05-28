package com.example.flockflairapp;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

public class Favorite {
    public static FirebaseDatabase ds = FirebaseDatabase.getInstance();
    public static DatabaseReference favRef = ds.getReference("user");
    public static String uid = FirebaseAuth.getInstance().getUid();
    private static final String TAG = "Favorite";

    //SetData to database working
    public static void setFavorite(FavoriteModel favoriteModel){
        favRef.child(uid).child("Favorite").push().setValue(favoriteModel);
    }


    //Favorite removed from database
    public static void removeFavorite(FavoriteModel model){
        Query dele = favRef.child(uid).child("Favorite").orderByChild("favoriteName").equalTo(model.getFavoriteName());

        dele.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot:snapshot.getChildren()){
                    if (dataSnapshot.child("favoriteName").exists()){
                        dataSnapshot.getRef().removeValue();
                    }
                }
            }
            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError error) {
                Log.d(TAG,"ExpandableListView: "+ error.getDetails());
            }
        });
    }
}
