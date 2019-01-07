package com.example.enghatoun.aqwas.Main;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import com.example.enghatoun.aqwas.Main.First.FirstFragment;
import com.example.enghatoun.aqwas.Main.Second.SecondFragment;
import com.example.enghatoun.aqwas.R;

public class MainActivity extends AppCompatActivity implements MainActivityVP.View {
    DrawerLayout dLayout;
    Toolbar toolbar;
String previous="null";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        CreateFragment(new FirstFragment());
        initListeners();
        setNavigationDrawer(); // call method

    }

    private void initListeners() {
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dLayout.openDrawer(Gravity.LEFT);
            }
        });
    }

    //check for best code
    private void setNavigationDrawer() {
        dLayout = (DrawerLayout) findViewById(R.id.drawer_layout); // initiate a DrawerLayout
        NavigationView navView = (NavigationView) findViewById(R.id.navigation); // initiate a Navigation View
        // implement setNavigationItemSelectedListener event on NavigationView
        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                int itemId = menuItem.getItemId(); // get selected menu item's id
                // check selected menu item's id and replace a Fragment Accordingly
                if (itemId == R.id.first) {
                    CreateFragment(new FirstFragment());
                } else if (itemId == R.id.second) {
                    CreateFragment(new SecondFragment());
                }
                dLayout.closeDrawers(); // close the all open Drawer Views
                    return true;
                //return false;
            }
        });
    }

    private void CreateFragment(Fragment frag){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame, frag); // replace a Fragment with Frame Layout
        transaction.commit(); // commit the changes
    }

    @Override
    public void setFragment(FirstFragment fragment) {

    }

}