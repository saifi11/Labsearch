package com.example.pathalogyapp;

import static com.example.pathalogyapp.R.id.cancel;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;

public class UserHomepage extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    SliderView slider;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    RecyclerView recyclerView;
    DatabaseReference database;
    MyAdapter  myAdapter;
    ArrayList<User> list;
    TextView username ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_homepage);

        username = findViewById(R.id.username_home_page);

        username.setText(getIntent().getStringExtra("username"));

        //menu

        drawerLayout = findViewById(R.id.drawerlayout);
        navigationView = findViewById(R.id.navigationview);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout,toolbar, R.string.navigation_open, R.string.navigation_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);

        //-----------------------------------------

        //for slider image
        slider=findViewById(R.id.slider_view);
        int [] images={R.drawable.slider1, R.drawable.slider2, R.drawable.slider3};
        String [] caption={"" ,"Blood","Sonography"};
        SliderAdapter adapter=new SliderAdapter(images , caption);
        slider.setSliderAdapter(adapter);
        slider.setSliderTransformAnimation(SliderAnimations.CUBEINDEPTHTRANSFORMATION);
        slider.startAutoCycle();

        //-------------------------------------

        //center data
        recyclerView = findViewById(R.id.centrelist);
        database = FirebaseDatabase.getInstance().getReference("datacentre");
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        list = new ArrayList<>();
        myAdapter = new MyAdapter(this,list);
        recyclerView.setAdapter(myAdapter);

        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                    User user = dataSnapshot.getValue(User.class);
                    list.add(user);
                }
                myAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        //--------------------------------------------------


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.usersearchbar,menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
       int id = item.getItemId();
       if (id == R.id.cancel)
       {
           Intent intent = new Intent(getApplicationContext(),usercancel.class);
           startActivity(intent);
       }
       if (id==R.id.Search);
        {
//            SearchView searchView = (SearchView) item.getActionView();
//            searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//                @Override
//                public boolean onQueryTextSubmit(String query) {
//                    return false;
//                }
//
//                @Override
//                public boolean onQueryTextChange(String newText) {
//                    myAdapter.getFilter().filter(newText.toString());
//                    return false;
//                }
//            });
        }
       return true;
    }
    //---------------------------------------------
    //for menu


    @Override
    public void onBackPressed() {

        if (drawerLayout.isDrawerOpen(GravityCompat.START))
        {
            drawerLayout.closeDrawer(GravityCompat.START);
        }else
        {
            super.onBackPressed();
        }

    }

    //navigation onclick
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId())
        {
            case R.id.home_menu:
               Intent intent = new Intent(getApplicationContext(),UserHomepage.class);
               startActivity(intent);
                break;
            case R.id.login_menu:

                Intent intent1 = new Intent(getApplicationContext(),loginpageuser.class);
                startActivity(intent1);
                finish();
                break;
            case R.id.Feedback:
                Intent intent2 = new Intent(getApplicationContext(),complainttocentre.class);
                startActivity(intent2);
                break;
//            case R.id.appo:
//                Intent intent3 = new Intent(getApplicationContext(),myappointment.class);
//                startActivity(intent3);

        }
        return true;
    }
}