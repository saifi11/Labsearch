package com.example.pathalogyapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class centrepasswdupdatemessage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_centrepasswdupdatemessage);
    }

    public void logintbn2(View view) {
        startActivity(new Intent(getApplicationContext(), com.example.pathalogyapp.centreloginpage.class));
        finish();
    }
}