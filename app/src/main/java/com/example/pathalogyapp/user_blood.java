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

public class user_blood extends AppCompatActivity {
    RecyclerView recyclerView;
    DatabaseReference database;
    com.example.pathalogyapp.MyAdapter1 myAdapter1;
    ArrayList<com.example.pathalogyapp.blood_> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_blood);

        // blood list

        recyclerView = findViewById(R.id.user_blood);
        database = FirebaseDatabase.getInstance().getReference("Blood");
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        list = new ArrayList<>();
        myAdapter1 = new com.example.pathalogyapp.MyAdapter1(this,list);
        recyclerView.setAdapter(myAdapter1);

        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren())
                {
                    com.example.pathalogyapp.blood_ blood = dataSnapshot.getValue(com.example.pathalogyapp.blood_.class);
                    list.add(blood);

                }
                myAdapter1.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}