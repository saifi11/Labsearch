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

public class Userbooked extends AppCompatActivity {

    RecyclerView recyclerView;
    DatabaseReference database;
    MyAdaper2 myAdaper;
    ArrayList<patient_> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userbooked);

        //user booking data

        recyclerView = findViewById(R.id.petientditeal);
        database = FirebaseDatabase.getInstance().getReference("patientdetile");
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        list = new ArrayList<>();
        myAdaper = new MyAdaper2(this,list);
        recyclerView.setAdapter(myAdaper);

        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for  (DataSnapshot dataSnapshot : snapshot.getChildren())
                {
                    patient_ patient = dataSnapshot.getValue(patient_.class);
                    list.add(patient);
                }
                myAdaper.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}