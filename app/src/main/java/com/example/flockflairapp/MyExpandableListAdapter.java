package com.example.flockflairapp;

import android.content.Context;
import android.graphics.Typeface;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.example.flockflairapp.Favorite.favRef;
import static com.example.flockflairapp.Favorite.uid;

public class MyExpandableListAdapter extends BaseExpandableListAdapter {

    private Context context;
    Map<Integer,List<Integer>> imageCollection;
    private Map<String , List<String>> moduleCollection;
    List<Integer> groupList;
    private List<String> moduleList;
    Uri name;


    public MyExpandableListAdapter(Context context, List<String> moduleList, Map<String, List<String>> moduleCollection,List<Integer> groupList,Map<Integer,List<Integer>> imageCollection){
        this.context = context;
        this.imageCollection = imageCollection;
        this.moduleCollection = moduleCollection;
        this.groupList = groupList;
        this.moduleList = moduleList;

    }


    @Override
    public int getGroupCount() {
        return moduleCollection.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return moduleCollection.get(moduleList.get(i)).size();
    }

    @Override
    public Object getGroup(int i) {
        return moduleList.get(i);
    }

    @Override
    public Object getChild(int i, int i1) {
        return moduleCollection.get(moduleList.get(i)).get(i1);
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i1) {
        return i1;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }


    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
        String Name = moduleList.get(i);
        if(view == null)
        {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.group_item, null);

        }
        ImageView imageView = view.findViewById(R.id.groupitem_image);
        int id = this.groupList.get(i);

        TextView item = view.findViewById(R.id.modules);
        item.setTypeface(null, Typeface.BOLD);
        item.setText(Name);
        return view;


    }

    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup parent) {
        String model = moduleCollection.get(moduleList.get(i)).get(i1);
        if(view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.child_item,null);
        }

        ImageView star_fav = view.findViewById(R.id.star_fav);//favorite
        ImageView star = view.findViewById(R.id.star);//unfavorite

        ImageView imageView = view.findViewById(R.id.childitem_image);
        int id = imageCollection.get(groupList.get(i)).get(i1);
        imageView.setImageResource(id);

        //Favorite favorite = new Favorite();
        FavoriteModel favoriteModel = new FavoriteModel(model);

        List<FavoriteModel> list = new ArrayList<>();

        Query check = favRef.child(uid).child("Favorite").orderByChild("favoriteName");
        check.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                for (DataSnapshot data: snapshot.getChildren()){
                    if (data.hasChild("favoriteName")){
                        list.add(data.getValue(FavoriteModel.class));
                    }
                }
                for (int k=0;k< list.size();k++){
                    if(model.equals(list.get(k).getFavoriteName())){
                        star_fav.setVisibility(View.VISIBLE);
                        star.setVisibility(View.INVISIBLE);
                        break;
                    }else {
                        star_fav.setVisibility(View.INVISIBLE);
                        star.setVisibility(View.VISIBLE);
                    }
                }
            }
            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError error) {
                Log.d("MyExpandableListAdapter", error.getDetails());
            }
        });


        star.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Favorite.setFavorite(favoriteModel);
                Toast.makeText(context,"Added to Favourite Part",Toast.LENGTH_SHORT).show();
                star_fav.setVisibility(View.VISIBLE);
                star.setVisibility(View.INVISIBLE);
                notifyDataSetChanged();
            }
        });

        star_fav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Favorite.removeFavorite(favoriteModel);
                Toast.makeText(context,"Removed from Favourite Part",Toast.LENGTH_SHORT).show();
                star_fav.setVisibility(View.INVISIBLE);
                star.setVisibility(View.VISIBLE);
                notifyDataSetChanged();
            }
        });

        TextView item = view.findViewById(R.id.model);
        item.setText(model);
        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }
}
