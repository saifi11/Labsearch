package com.example.pathalogyapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class paymentdone extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paymentdone);
    }

    public void backtohome(View view) {
        Intent intent = new Intent( getApplicationContext(), com.example.pathalogyapp.UserHomepage.class);
        startActivity(intent);
        finish();
    }
}