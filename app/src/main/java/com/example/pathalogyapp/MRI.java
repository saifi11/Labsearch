package com.example.pathalogyapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.UUID;

public class MRI extends AppCompatActivity {
    TextInputLayout mritestname , mritestprice , regno;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mri);
    }

    public void addservice2(View view) {
        mritestname = findViewById(R.id.mri);
        mritestprice = findViewById(R.id.mriprice);
        regno = findViewById(R.id.regno2);

        String mritestname_ = mritestname.getEditText().getText().toString();
        String mritestprice_ = mritestprice.getEditText().getText().toString();
        String regno_ = regno.getEditText().getText().toString();
        if (!mritestname_.isEmpty())//test name
        {
            mritestname.setError(null);
            mritestname.setErrorEnabled(false);
            if (!mritestprice_.isEmpty())//test price
            {
                mritestprice.setError(null);
                mritestprice.setErrorEnabled(false);
                if (!regno_.isEmpty()) //regno
                {
                    regno.setError(null);
                    regno.setErrorEnabled(false);

                    // firebase
                    firebaseDatabase = FirebaseDatabase.getInstance();
                    reference = firebaseDatabase.getReference("MRI");
                    String mritestname_s = mritestname.getEditText().getText().toString();
                    String mritestprice_s = mritestprice.getEditText().getText().toString();
                    String regno_s = regno.getEditText().getText().toString();

                    com.example.pathalogyapp.MRIstore mriteststores = new com.example.pathalogyapp.MRIstore(mritestname_s,mritestprice_s,regno_s);
                    reference.child(UUID.randomUUID().toString()).setValue(mriteststores);

                    Toast.makeText(getApplicationContext(), "Service Added Successfully", Toast.LENGTH_SHORT).show();

                }else //regno
                {
                    regno.setError("Pleasa Entre the Registration No");
                }
            }else//test price
            {
                mritestprice.setError("Please Enter the Test Price");
            }

        }else //test name
        {
            mritestname.setError("Please Enter the Test name ");
        }
    }
}