package com.example.enghatoun.aqwas.Preview_Images;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.enghatoun.aqwas.Preview_Images.FullImageActivity;
import com.example.enghatoun.aqwas.Preview_Images.ImageAdapter;
import com.example.enghatoun.aqwas.R;


public class Images extends AppCompatActivity {
    Toolbar toolbar;
    GridView gridView;
    String[] ResturantImages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.images);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Intent info = getIntent();
        Bundle b = info.getExtras();

        if (b != null) {
           ResturantImages = (String[]) b.get("images");

        }
        gridView = (GridView) findViewById(R.id.grid_view);
        gridView.setAdapter(new ImageAdapter(this, ResturantImages));
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {

                // Sending image id to FullScreenActivity
                Intent i = new Intent(getApplicationContext(), FullImageActivity.class);
                i.putExtra("id", position);
                i.putExtra("images",ResturantImages);
                startActivity(i);
            }
        });
    }
    }



