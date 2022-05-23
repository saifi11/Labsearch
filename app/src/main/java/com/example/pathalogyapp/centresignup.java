package com.example.pathalogyapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class centresignup extends AppCompatActivity {

    TextInputLayout centerphone , centerregno , centreemail , centrepasswd ,centername , centerpin;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference reference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_centresignup);
    }



    public void signbtn(View view) {
        centername = findViewById(R.id.centrename);
        centerphone = findViewById(R.id.centrephone);
        centerregno = findViewById(R.id.centreregno);
        centreemail = findViewById(R.id.centreemail);
        centrepasswd = findViewById(R.id.centrepassword);
        centerpin = findViewById(R.id.centrepincode);

        String centername_ = centername.getEditText().getText().toString();
        String centerphone_ = centerphone.getEditText().getText().toString();
        String centerregno_ = centerregno.getEditText().getText().toString();
        String centreemail_ = centreemail.getEditText().getText().toString();
        String centrepasswd_ = centrepasswd.getEditText().getText().toString();
        String centerpin_ = centerpin.getEditText().getText().toString();


        if (!centername_.isEmpty())
        {
            centername.setError(null);
            centername.setErrorEnabled(false);
            if (!centerphone_.isEmpty())
            {
                centerphone.setError(null);
                centerphone.setErrorEnabled(false);
                if (!centerregno_.isEmpty())
                {
                    centerregno.setError(null);
                    centerregno.setErrorEnabled(false);
                    if (!centreemail_.isEmpty())
                    {
                        centreemail.setError(null);
                        centreemail.setErrorEnabled(false);
                        if (!centrepasswd_.isEmpty())
                        {
                            centrepasswd.setError(null);
                            centrepasswd.setErrorEnabled(false);
                            if (centreemail_.matches("^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$"))
                            {
                                if (!centerpin_.isEmpty())
                                {
                                    centerpin.setError(null);
                                    centerpin.setErrorEnabled(false);


                                    //fire base
                                    firebaseDatabase = FirebaseDatabase.getInstance();
                                    reference = firebaseDatabase.getReference("datacentre");

                                    String centername_s = centername.getEditText().getText().toString();
                                    String centerphone_s = centerphone.getEditText().getText().toString();
                                    String centerregno_s = centerregno.getEditText().getText().toString();
                                    String centreemail_s = centreemail.getEditText().getText().toString();
                                    String centrepasswd_s = centrepasswd.getEditText().getText().toString();
                                    String centerpin_s = centerpin.getEditText().getText().toString();

                                    com.example.pathalogyapp.centrestore centrestores = new com.example.pathalogyapp.centrestore(centername_s,centerphone_s,centerregno_s,centreemail_s,centrepasswd_s,centerpin_s);

                                    reference.child(centerregno_s).setValue(centrestores);

                                    Toast.makeText(getApplicationContext(),"Register Successfully ",Toast.LENGTH_LONG).show();
                                    Intent intent =new Intent(getApplicationContext(), com.example.pathalogyapp.uploadimage.class);
                                    startActivity(intent);
                                    finish();
                                }
                                else
                                {
                                    centerpin.setError("Please Enter The Postal code");
                                }

                            }else
                            {
                                centreemail.setError("Email is Invalid ");
                            }
                        }else
                        {
                            centrepasswd.setError("Please Entre the Password ");

                        }

                    }else
                    {
                        centreemail.setError("Please Enter the Email ID");
                    }
                }else
                {
                    centerregno.setError("Please Entre the Centre Registration Number");
                }

            }else
            {
                centerphone.setError("Please Entre the Phone Number");
            }

        }else
        {
            centername.setError("Please Entre the name");
        }





    }
    public void CentreAlreadyAccount(View view) {
        Intent intent = new Intent( getApplicationContext(), centreloginpage.class);
        startActivity(intent);
    }

}