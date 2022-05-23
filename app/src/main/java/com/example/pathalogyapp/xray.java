package com.example.pathalogyapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class xray extends AppCompatActivity {
    TextInputLayout xraytestname , xraytestprice , regno;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xray);
    }

    public void addservice1(View view) {
        xraytestname = findViewById(R.id.xraytest);
        xraytestprice = findViewById(R.id.xrayprice);
        regno = findViewById(R.id.regno1);
        String xraytestname_ = xraytestname.getEditText().getText().toString();
        String xraytestprice_ = xraytestname.getEditText().getText().toString();
        String regno_ = regno.getEditText().getText().toString();

        if (!regno_.isEmpty())//regno
        {
            regno.setError(null);
            regno.setErrorEnabled(false);
            if (!xraytestname_.isEmpty())//xray name
            {
                xraytestname.setError(null);
                xraytestname.setErrorEnabled(false);

                if (!xraytestprice_.isEmpty())// xray price
                {
                    xraytestprice.setError(null);
                    xraytestprice.setErrorEnabled(false);

                    // fire base

                    firebaseDatabase = FirebaseDatabase.getInstance();
                    reference = firebaseDatabase.getReference("X-ray");
                    String xraytestname_s = xraytestname.getEditText().getText().toString();
                    String xraytestprice_s = xraytestprice.getEditText().getText().toString();
                    String regno_s = regno.getEditText().getText().toString();

                    com.example.pathalogyapp.xraystore xrayteststores = new com.example.pathalogyapp.xraystore(xraytestname_s,xraytestprice_s,regno_s);
                    reference.child(xraytestname_s).setValue(xrayteststores);

                    Toast.makeText(getApplicationContext(), "Service Added Successfully",Toast.LENGTH_LONG).show();




                }else //xray price
                {
                    xraytestprice.setError("Please Enter The X-ray Test price ");
                }

            }else //xray name
            {
                xraytestname.setError("Please Enter the X-ray Test name");

            }

        }else// reg no
        {
            regno.setError("Please Entre the Registrations Number");

        }
    }
}