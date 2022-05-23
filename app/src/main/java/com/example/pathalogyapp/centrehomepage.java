package com.example.pathalogyapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class centrehomepage extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_centrehomepage);
        //centre menu
        drawerLayout = findViewById(R.id.drawerlayout1);
        navigationView = findViewById(R.id.navigationview1);
        toolbar = findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar);
        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout,toolbar, R.string.navigation_open, R.string.navigation_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id== R.id.booking)
        {
          Intent intent = new Intent(getApplicationContext(),Userbooked.class);
          startActivity(intent);
        }
        return true;
    }

    public void blood(View view) {
        Intent intent =new Intent( getApplicationContext(),blood.class);
        startActivity(intent);

    }

    public void xray(View view) {
//        Intent intent =new Intent( getApplicationContext(),xray.class);
//        startActivity(intent);
        Toast.makeText(getApplicationContext(), "Service Will display Soon", Toast.LENGTH_SHORT).show();
    }

    public void mripage(View view) {
//        Intent intent =new Intent( getApplicationContext(),MRI.class);
//        startActivity(intent);
        Toast.makeText(getApplicationContext(), "Service Will display Soon", Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId())
        {
            case R.id.home_menu_centre:
                Intent intent = new Intent(getApplicationContext(),centrehomepage.class);
                startActivity(intent);
                break;
            case R.id.Dashboard_centre:
                Intent intent1 = new Intent(getApplicationContext(),Userbooked.class);
                startActivity(intent1);
                break;
            case R.id.logout_menu_centre: // logout
                Intent intent2 = new Intent(getApplicationContext(),centreloginpage.class);
                startActivity(intent2);
                finish();
                break;
            case R.id.sendmail:
                Intent intent3 = new Intent(getApplicationContext(),sendmail.class);
                startActivity(intent3);
                break;
        }
        return true;
    }
}