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

public class loginpageuser extends AppCompatActivity {
    TextInputLayout username, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginpageuser);
    }


    //login page
    public void loginbtn(View view) {
        username = findViewById(R.id.text_username);
        password = findViewById(R.id.text_password);


        String username_ = username.getEditText().getText().toString();
        String password_ = password.getEditText().getText().toString();

        if (!username_.isEmpty()) {
            username.setError(null);
            username.setErrorEnabled(false);
            if (!password_.isEmpty()) {
                password.setError(null);
                password.setErrorEnabled(false);

                //for firebase

                final String username1 = username.getEditText().getText().toString();
                final String password1 = password.getEditText().getText().toString();

                    FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
                    DatabaseReference reference = firebaseDatabase.getReference("datauser");

                //check
                Query checkusername = reference.orderByChild("username").equalTo(username1);

                checkusername.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if (snapshot.exists()){
                            username.setError(null);
                            username.setErrorEnabled(false);

                            String passwordcheck = snapshot.child(username1).child("password").getValue(String.class);

                            if (passwordcheck.equals(password1)){
                                password.setError(null);
                                password.setErrorEnabled(false);
                                Toast.makeText(getApplicationContext(),"Login Successfully",Toast.LENGTH_LONG).show();
                                Intent intent = new Intent(getApplicationContext(), com.example.pathalogyapp.UserHomepage.class);
                                intent.putExtra("username",username_);
                                startActivity(intent);
                                finish();

                            }else {
                                password.setError("Wrong Password");
                            }

                        }else {
                            username.setError("User does not Exists");
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

            } else {
                password.setError("Please Enter the password");
            }
        } else {
            username.setError("Please Enter the Username");
        }
    }

    //register page
    public void registerpage(View view) {
        Intent intent = new Intent(getApplicationContext(), com.example.pathalogyapp.signpageuser.class);
        startActivity(intent);
    }
    //diagnostic centre page
    public void centrebtn(View view) {
        Intent intent = new Intent(getApplicationContext(), com.example.pathalogyapp.centreloginpage.class);
        startActivity(intent);
        finish();
    }
    //forget password
    public void fogetpassword(View view) {
        startActivity(new Intent(getApplicationContext(), com.example.pathalogyapp.OtpSendActivity.class));
    }
}