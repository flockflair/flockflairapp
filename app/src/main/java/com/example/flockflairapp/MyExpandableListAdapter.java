package com.example.flockflairapp;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.Map;

public class MyExpandableListAdapter extends BaseExpandableListAdapter {

    private Context context;
    private Map<String , List<String>> moduleCollection;
    private List<String> moduleList;

    public MyExpandableListAdapter(Context context, List<String> moduleList, Map<String, List<String>> moduleCollection){
        this.context = context;
        this.moduleCollection = moduleCollection;
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
        ImageView star_fav = view.findViewById(R.id.star_fav);
        ImageView star = view.findViewById(R.id.star);
        star.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"added to fav",Toast.LENGTH_SHORT).show();
                star_fav.setVisibility(View.VISIBLE);
                star.setVisibility(View.INVISIBLE);
            }
        });
        star_fav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"removed from fav",Toast.LENGTH_SHORT).show();
                star_fav.setVisibility(View.INVISIBLE);
                star.setVisibility(View.VISIBLE);
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
