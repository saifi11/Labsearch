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

public class userforgetpassword extends AppCompatActivity {

    TextInputLayout username_forget , userNewpassword_forget;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userforgetpassword);
    }


    public void centrebtnloginbtn(View view) {

        username_forget = findViewById(R.id.username_forget);
        userNewpassword_forget = findViewById(R.id.usernewpassword_forget);

        String username_forget_ = username_forget.getEditText().getText().toString();
        String userNewpassword_forget_ = userNewpassword_forget.getEditText().getText().toString();

        if (!username_forget_.isEmpty())
        {
            username_forget.setError(null);
            username_forget.setErrorEnabled(false);

            if (!userNewpassword_forget_.isEmpty())
            {
                userNewpassword_forget.setError(null);
                userNewpassword_forget.setErrorEnabled(false);

                updatedata(username_forget_,userNewpassword_forget_);

            }else
            {
                userNewpassword_forget.setError("Please Entre the New Password");
            }

        }else
        {
            username_forget.setError("Please Entre the Valid Username ");
        }


    }

    private void updatedata(String username_forget_, String userNewpassword_forget_) {
        HashMap User = new HashMap();
        User.put("password",userNewpassword_forget_);

        databaseReference= FirebaseDatabase.getInstance().getReference("datauser");
        databaseReference.child(username_forget_).updateChildren(User).addOnCompleteListener(new OnCompleteListener() {
            @Override
            public void onComplete(@NonNull Task task) {

                if (task.isSuccessful())
                {
                    username_forget.getEditText().setText("");
                    userNewpassword_forget.getEditText().setText("");
                    Toast.makeText(getApplicationContext(), "Password Updated Successfully", Toast.LENGTH_SHORT).show();

                }else
                {
                    Toast.makeText(getApplicationContext(), "Faild to Update", Toast.LENGTH_SHORT).show();
                }
            }
        });
        Intent intent =new Intent(getApplicationContext(),userpasswdupdatemessage.class);
        startActivity(intent);
        finish();
    }
}