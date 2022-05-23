package com.example.pathalogyapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class usercancel extends AppCompatActivity {

    TextInputLayout phonenumber , testname , reason;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference reference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usercancel);

    }

    public void cancel(View view) {
        phonenumber = findViewById(R.id.userphone);
        testname =findViewById(R.id.testname);
        reason = findViewById(R.id.reason);

        String phonenumber_ = phonenumber.getEditText().getText().toString();
        String testname_ = testname.getEditText().getText().toString();
        String reason_ = reason.getEditText().getText().toString();

        if (!phonenumber_.isEmpty()) //phonenumber
        {
            phonenumber.setError(null);
            phonenumber.setErrorEnabled(false);

            if (!testname_.isEmpty()) //testname
            {
                testname.setError(null);
                testname.setErrorEnabled(false);

                if (!reason_.isEmpty()) //reason
                {
                    reason.setError(null);
                    reason.setErrorEnabled(false);

                    //firebase

                    firebaseDatabase = FirebaseDatabase.getInstance();
                    reference = firebaseDatabase.getReference("cancelrequest");
                    String phonenumber_s = phonenumber.getEditText().getText().toString();
                    String testname_s = testname.getEditText().getText().toString();
                    String reason_s = reason.getEditText().getText().toString();

                    reasonstore reasonstores = new reasonstore(phonenumber_s,testname_s,reason_s);

                    reference.child(phonenumber_s).setValue(reasonstores);
                    Toast.makeText(getApplicationContext(), "Request Sent ", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(getApplicationContext(), com.example.pathalogyapp.UserHomepage.class);
                    startActivity(intent);
                    finish();

                }
                else   //reason
                {
                    reason.setError("please Entre the Reason");
                }
            }else   //testname
            {
                testname.setError("Please Entre the test name");
            }


        }else //phonenumber
        {
            phonenumber.setError("Please Entre the Phone Number ");
        }
    }
}