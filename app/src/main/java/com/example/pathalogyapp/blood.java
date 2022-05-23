package com.example.pathalogyapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.UUID;

public class blood extends AppCompatActivity {
    TextInputLayout bloodtestname , bloodtestprice ,regno;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blood);
    }

    public void addservice(View view) {
        bloodtestname = findViewById(R.id.bloodtest);
        bloodtestprice =findViewById(R.id.bloodprice);
        regno = findViewById(R.id.regno);

        String bloodtestname_ = bloodtestname.getEditText().getText().toString();
        String bloodtestprice_ = bloodtestprice.getEditText().getText().toString();
        String regno_ = regno.getEditText().getText().toString();

        if (!bloodtestname_.isEmpty())//test name
        {
            bloodtestname.setError(null);
            bloodtestname.setErrorEnabled(false);
            if (!bloodtestprice_.isEmpty())//test price
            {
                bloodtestprice.setError(null);
                bloodtestprice.setErrorEnabled(false);
                if (!regno_.isEmpty())//regno for centre
                {
                    regno.setError(null);
                    regno.setErrorEnabled(false);
                    //firebase
                    firebaseDatabase = FirebaseDatabase.getInstance();
                    reference = firebaseDatabase.getReference("Blood");
                    String bloodtestname_s = bloodtestname.getEditText().getText().toString();
                    String bloodtestprice_s = bloodtestprice.getEditText().getText().toString();
                    String regno_s = regno.getEditText().getText().toString();

                    com.example.pathalogyapp.bloodstore bloodteststores = new com.example.pathalogyapp.bloodstore(bloodtestname_s,bloodtestprice_s,regno_s);
                    reference.child(UUID.randomUUID().toString()).setValue(bloodteststores);

                    Toast.makeText(getApplicationContext(), "Service Added Successfully", Toast.LENGTH_SHORT).show();

                }else
                {
                    regno.setError("Please Entre the Centre Registration Number");

                }
            }else
            {
                bloodtestprice.setError("Please Entre the Test price");
            }
        }else
        {
            bloodtestname.setError("Please Entre the Test name");

        }
    }
}