package com.example.pathalogyapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class centreloginpage extends AppCompatActivity {
    TextInputLayout centreRegno , centrePassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_centreloginpage);
    }



    public void centrebtnloginbtn(View view) {
        centreRegno = findViewById(R.id.centre_regno);
        centrePassword = findViewById(R.id.centre_password);

        String Regno = centreRegno.getEditText().getText().toString();
        String passwd = centrePassword.getEditText().getText().toString();

        if (!Regno.isEmpty()) {
            centreRegno.setError(null);
            centreRegno.setErrorEnabled(false);
            if (!passwd.isEmpty()) {
                centrePassword.setError(null);
                centrePassword.setErrorEnabled(false);

                //for firebase

                final String Regno_ = centreRegno.getEditText().getText().toString();
                final String passwd_ = centrePassword.getEditText().getText().toString();

                FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
                DatabaseReference reference = firebaseDatabase.getReference("datacentre");

                //check
                Query checkregno = reference.orderByChild("centre_regno").equalTo(Regno_);

                checkregno.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if (snapshot.exists()){
                            centreRegno.setError(null);
                            centreRegno.setErrorEnabled(false);

                            String passwordcheck = snapshot.child(Regno_).child("centre_passwd").getValue(String.class);

                            if (passwordcheck.equals(passwd_)){
                                centrePassword.setError(null);
                                centrePassword.setErrorEnabled(false);
                                Toast.makeText(getApplicationContext(),"Login Successfully",Toast.LENGTH_LONG).show();
                                Intent intent = new Intent(getApplicationContext(), com.example.pathalogyapp.centrehomepage.class);
                                startActivity(intent);
                                finish();

                            }else {
                                centrePassword.setError("Wrong Password");
                            }

                        }else {
                            centreRegno.setError("User does not Exists");
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

            } else {
                centrePassword.setError("Please Enter the password");
            }
        } else {
            centrePassword.setError("Please Enter the Username");
        }
    }
    //register btn


    public void registerpage1(View view) {
        Intent intent = new Intent(getApplicationContext(), com.example.pathalogyapp.centresignup.class);
        startActivity(intent);
    }

    //forget password
    public void fogetpassword1(View view) {
        startActivity(new Intent(getApplicationContext(), com.example.pathalogyapp.centreOtpSendActivity.class));

    }
}