package com.example.enghatoun.aqwas.Preview_Images;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.example.enghatoun.aqwas.R;
import com.squareup.picasso.Picasso;

public class ImageAdapter extends BaseAdapter {
    public String[] image;
    public Context mContext;

    // Constructor
    public ImageAdapter(Context c, String[] Images){
        mContext = c;
        image = new String[Images.length];
        for (int i=0; i<Images.length ; i++){
            image[i]=Images[i] ;
        }



    }

    @Override
    public int getCount() {
        return image.length;
    }

    @Override
    public Object getItem(int position) {
        return image[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView = new ImageView(mContext);
        Picasso.with(mContext).load(image[position]).into(imageView);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setLayoutParams(new GridView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 600));
        return imageView;
    }


}