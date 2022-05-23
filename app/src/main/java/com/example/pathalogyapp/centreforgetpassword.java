package com.example.pathalogyapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class centreforgetpassword extends AppCompatActivity {
    TextInputLayout centrename_forget , centreNewpassword_forget;
    DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_centreforgetpassword);
    }

    public void centrebtnloginbtn1(View view) {
        centrename_forget = findViewById(R.id.centreregno_forget);
        centreNewpassword_forget = findViewById(R.id.centrepassword_forget);
        String centrename_forget_ = centrename_forget.getEditText().getText().toString();
        String centreNewpassword_forget_ = centreNewpassword_forget.getEditText().getText().toString();

        if (!centrename_forget_.isEmpty())
        {
            centrename_forget.setError(null);
            centrename_forget.setErrorEnabled(false);

            if (!centreNewpassword_forget_.isEmpty())
            {
              centreNewpassword_forget.setError(null);
              centreNewpassword_forget.setErrorEnabled(false);

                updatedata(centrename_forget_,centreNewpassword_forget_);

            }else
            {

                centreNewpassword_forget.setError("Please Entre the New Password");
            }

        }else
        {
            centrename_forget.setError("Please Enter the Centre Registration Number");
        }



    }

    private void updatedata(String centrename_forget_, String centreNewpassword_forget_) {
        HashMap Centre = new HashMap();
        Centre.put("centre_passwd",centreNewpassword_forget_);

        databaseReference = FirebaseDatabase.getInstance().getReference("datacentre");
        databaseReference.child(centrename_forget_).updateChildren(Centre).addOnCompleteListener(new OnCompleteListener() {
            @Override
            public void onComplete(@NonNull Task task) {
                if (task.isSuccessful())
                {
                    centrename_forget.getEditText().setText("");
                    centreNewpassword_forget.getEditText().setText("");
                    Toast.makeText(getApplicationContext(), "Password Update Successfully", Toast.LENGTH_SHORT).show();
                }else
                {
                    Toast.makeText(getApplicationContext(), "Faild to Update", Toast.LENGTH_SHORT).show();
                }
            }
        });
        Intent intent = new Intent(getApplicationContext(), com.example.pathalogyapp.centrepasswdupdatemessage.class);
        startActivity(intent);
        finish();
    }
}