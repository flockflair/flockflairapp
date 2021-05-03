package com.example.flockflairapp;

import androidx.annotation.NonNull;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Favorite {
    private FirebaseDatabase ds = FirebaseDatabase.getInstance();
    private DatabaseReference d = ds.getReference();
    private String uid = FirebaseAuth.getInstance().getUid();

    public void setFavorite(){
        FavoriteModel favoriteModel = new FavoriteModel();
        d.child("user").child(uid).child("Favorite").push().setValue(favoriteModel);
    }

    public void getFavorite(final String pushKey){
        FavoriteModel model = new FavoriteModel();
        List<String> FavkeyList = new ArrayList<>();

        d.child("user").child(uid).child("Favorite").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String key = pushKey;
                for (DataSnapshot ds:snapshot.getChildren()){
                    key = ds.getKey();
                    FavkeyList.add(key);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}
