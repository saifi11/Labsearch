package com.example.pathalogyapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class user_mri extends AppCompatActivity {

    RecyclerView recyclerView;
    DatabaseReference database;
    MyAdapter3 myAdapter3;
    ArrayList<com.example.pathalogyapp.mri_> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_mri);

        // mri test

        recyclerView = findViewById(R.id.user_mri);
        database = FirebaseDatabase.getInstance().getReference("X-ray");
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        list = new ArrayList<>();
        myAdapter3 = new MyAdapter3(this,list);
        recyclerView.setAdapter(myAdapter3);

        database .addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren())
                {
                    com.example.pathalogyapp.mri_ mri = dataSnapshot.getValue(com.example.pathalogyapp.mri_.class);
                    list.add(mri);
                }
                myAdapter3.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}