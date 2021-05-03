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

import java.util.List;

public class Favorite {
    private FirebaseDatabase ds = FirebaseDatabase.getInstance();
    private DatabaseReference favRef = ds.getReference();
    private String uid = FirebaseAuth.getInstance().getUid();

    public void setFavorite(FavoriteModel favoriteModel){
        favRef.child("user").child(uid).child("Favorite").push().setValue(favoriteModel);
    }

    public void getFavorite(List<FavoriteModel> getFavoriteName){

        favRef.child("user").child(uid).child("Favorite").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot ds:snapshot.getChildren()){
                    getFavoriteName.add(ds.getValue(FavoriteModel.class));
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.d("getFavoriteName", error.getMessage());
            }
        });
    }

    public void removeFavorite(){
        FavoriteModel model = new FavoriteModel();

        Query removeFavorite = favRef.child("user").child(uid).child("Favorite").orderByChild("FavoriteName").equalTo(model.getFavoriteName());

        removeFavorite.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot:snapshot.getChildren()){
                    dataSnapshot.getRef().removeValue();
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.d("removeFavorite", error.getMessage());
            }
        });
    }
}
