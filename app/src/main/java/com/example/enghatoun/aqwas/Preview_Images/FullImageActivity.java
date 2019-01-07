package com.example.enghatoun.aqwas.Preview_Images;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.enghatoun.aqwas.R;
import com.squareup.picasso.Picasso;

public class FullImageActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.full_image);

        Intent i = getIntent();
        int position = i.getExtras().getInt("id");
        String[] images= (String[]) i.getExtras().get("images");
        ImageAdapter imageAdapter = new ImageAdapter(this,images);

        ImageView imageView = (ImageView) findViewById(R.id.full_image_view);
        Picasso.with(imageAdapter.mContext).load(imageAdapter.image[position]).into(imageView);
    }

}