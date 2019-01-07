package com.example.enghatoun.aqwas.Resturnat_Information;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.View;
import android.widget.TextView;

import com.example.enghatoun.aqwas.R;

public class ResturnatInformation extends AppCompatActivity {
    Toolbar toolbar;
    private TextView name;
    private TextView hours;
    private TextView link;
    private TextView TitleName;
    private TextView TitleHours;
    private TextView TitleLink;
    private String ResturantLink;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resturnat_information);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        name = (TextView) findViewById(R.id.name);
        name.setTextSize(TypedValue.COMPLEX_UNIT_PX,
                getResources().getDimension(R.dimen.textsize));
        hours = (TextView) findViewById(R.id.hours);
        hours.setTextSize(TypedValue.COMPLEX_UNIT_PX,
                getResources().getDimension(R.dimen.textsize));
        link = (TextView) findViewById(R.id.link);
        link.setTextSize(TypedValue.COMPLEX_UNIT_PX,
                getResources().getDimension(R.dimen.textsize));
        TitleName = (TextView) findViewById(R.id.TitleName);
        TitleName.setTextSize(TypedValue.COMPLEX_UNIT_PX,
                getResources().getDimension(R.dimen.textsize));
        TitleHours = (TextView) findViewById(R.id.TitleHours);
        TitleHours.setTextSize(TypedValue.COMPLEX_UNIT_PX,
                getResources().getDimension(R.dimen.textsize));
        TitleLink = (TextView) findViewById(R.id.TitleLink);
        TitleLink.setTextSize(TypedValue.COMPLEX_UNIT_PX,
                getResources().getDimension(R.dimen.textsize));

        Intent info = getIntent();
        Bundle b = info.getExtras();

        if (b != null) {
            String ResturantName = (String) b.get("name");
            name.setText(ResturantName);

            String ResturantHours = (String) b.get("hours");
            if (ResturantHours == "1")
                hours.setText("Open");
            else
                hours.setText("Closed");
            System.out.print(ResturantHours);
            ResturantLink = (String) b.get("link");
            link.setText(ResturantLink);
        }

        link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(ResturantLink));
                startActivity(browserIntent);
            }
        });

    }
}
