package com.example.enghatoun.aqwas.Launach_Page;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.enghatoun.aqwas.Main.First.FirstFragment;
import com.example.enghatoun.aqwas.Main.MainActivity;
import com.example.enghatoun.aqwas.R;

public class LaunachPage extends AppCompatActivity {

    private Button sugesst;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.launch_page);
        sugesst = (Button) findViewById(R.id.suggest);
        sugesst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(LaunachPage.this, MainActivity.class);
                startActivity(a);
            }
        });
    }

}

