package com.example.pathalogyapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class complainttocentre extends AppCompatActivity {

    TextInputLayout centername , report;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complainttocentre);
    }

    public void Submit(View view) {

        centername = findViewById(R.id.centrename_com);
        report = findViewById(R.id.report);

        String centername_ = centername.getEditText().getText().toString();
        String report_ = report.getEditText().getText().toString();

        if (!centername_.isEmpty()) //centername
        {
            centername.setError(null);
            centername.setErrorEnabled(false);

            if (!report_.isEmpty())  //report
            {
                report.setError(null);
                report.setErrorEnabled(false);


                // firebase

                firebaseDatabase = FirebaseDatabase.getInstance();
                reference = firebaseDatabase.getReference("Report");

                String centername_s = centername.getEditText().getText().toString();
                String report_s = report.getEditText().getText().toString();

                reportstore reportstores = new reportstore(centername_s,report_s);
                reference.child(centername_s).setValue(reportstores);

                Toast.makeText(getApplicationContext(), " Your Complaint Added", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(getApplicationContext(), com.example.pathalogyapp.UserHomepage.class);
                startActivity(intent);
                finish();


            }else  //report
            {
                report.setError("Please Entre the Report");
            }

        }else //centername
        {
            centername.setError("Please Enter the centre name");
        }

    }
}