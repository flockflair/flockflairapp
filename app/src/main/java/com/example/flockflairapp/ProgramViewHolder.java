package com.example.flockflairapp;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ProgramViewHolder {
    ImageView itemImage;
    TextView programTitle;

    ProgramViewHolder(View v)
    {
        itemImage = v.findViewById(R.id.imageView6);
        programTitle = v.findViewById(R.id.textvieww1);
    }
}
