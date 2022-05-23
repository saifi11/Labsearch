package com.example.pathalogyapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class aftermain extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aftermain);

    }

    // user sign up means register page
    public void signup(View view) {
        Intent intent = new Intent(getApplicationContext(), com.example.pathalogyapp.signpageuser.class);
        startActivity(intent);

    }

    //user sign in means login page
    public void signin(View view) {
        Intent intent1 = new Intent(getApplicationContext(),loginpageuser.class);
        startActivity(intent1);

    }
}