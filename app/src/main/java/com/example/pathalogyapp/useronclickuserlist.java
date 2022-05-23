package com.example.pathalogyapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class useronclickuserlist extends AppCompatActivity {
    TextView centre_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_useronclickuserlist);
        centre_name = findViewById(R.id.centrename_aftercard);
        centre_name.setText(getIntent().getStringExtra("title"));
    }

    //Blood click
    public void user_blood(View view) {
        Intent intent = new Intent(getApplicationContext(),user_blood.class);
        startActivity(intent);
    }

    //mri click
    public void MRI(View view) {

//        Intent intent = new Intent(getApplicationContext(),user_mri.class);
//        startActivity(intent);
        Toast.makeText(getApplicationContext(), "Service will Display Soon", Toast.LENGTH_SHORT).show();
    }
}