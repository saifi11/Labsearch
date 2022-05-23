package com.example.pathalogyapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class signpageuser extends AppCompatActivity {
    TextInputLayout fullname, username, password, email, phoneno,Address;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signpageuser);
    }
//signbtn
    public void signbtn(View view) {
        fullname = findViewById(R.id.signfullname);
        username = findViewById(R.id.signusername);
        password = findViewById(R.id.signpassword);
        email = findViewById(R.id.Emailid);
        phoneno = findViewById(R.id.signphone);
        Address = findViewById(R.id.signpincode);

        String fullname_ = fullname.getEditText().getText().toString();
        String username__ = username.getEditText().getText().toString();
        String password__ = password.getEditText().getText().toString();
        String email_ = email.getEditText().getText().toString();
        String phoneno_ = phoneno.getEditText().getText().toString();
        String address_ = Address.getEditText().getText().toString();
        if (!fullname_.isEmpty())//fullname
        {
            fullname.setError(null);
            fullname.setErrorEnabled(false);
            if (!phoneno_.isEmpty() && phoneno_.length()==10)//phone nu
            {
                phoneno.setError(null);
                phoneno.setErrorEnabled(false);
                if (!username__.isEmpty())//Username
                {
                    username.setError(null);
                    username.setErrorEnabled(false);
                    if (!email_.isEmpty())//email
                    {
                        email.setError(null);
                        email.setErrorEnabled(false);
                        if (!password__.isEmpty() && password__.length()==8)//password
                        {
                            password.setError(null);
                            password.setErrorEnabled(false);
                            if (email_.matches("^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$")){

                                if (!address_.isEmpty()) //pincode
                                {
                                    Address.setError(null);
                                    Address.setErrorEnabled(false);
                                    //firebase
                                    firebaseDatabase = FirebaseDatabase.getInstance();
                                    reference = firebaseDatabase.getReference("datauser");

                                    String fullname_s = fullname.getEditText().getText().toString();
                                    String username__s = username.getEditText().getText().toString();
                                    String password__s = password.getEditText().getText().toString();
                                    String email_s = email.getEditText().getText().toString();
                                    String phoneno_s = phoneno.getEditText().getText().toString();
                                    String address_s = Address.getEditText().getText().toString();

                                    storingdata storingdatas = new storingdata(email_s,fullname_s,password__s,phoneno_s,address_s,username__s);

                                    reference.child(username__s).setValue(storingdatas);

                                    Toast.makeText(getApplicationContext(),"Register Successfully ",Toast.LENGTH_LONG).show();
                                    Intent intent =new Intent(getApplicationContext(), com.example.pathalogyapp.UserHomepage.class);
                                    intent.putExtra("username",username__s);
                                    startActivity(intent);
                                    finish();

                                }else  //pincode
                                {
                                    Address.setError("Please Enter the Address");
                                }

                            }else // email valid
                            {
                                email.setError("Invalid Email");
                            }

                        } else //password
                        {
                            password.setError("Password must greater the 8 Character");
                        }
                    } else //email
                    {
                        email.setError("Please Enter the Email_ID");
                    }

                } else //username
                {
                    username.setError("Please Enter the Username");

                }

            } else //phone nu
            {
                phoneno.setError("Please Enter the Phone Number");

            }

        } else//fullname
        {
            fullname.setError("Please Enter the Fullname");

        }

    }
//alreadyaccount
    public void AlreadyAccount(View view) {
        Intent intent = new Intent(getApplicationContext(), loginpageuser.class);
        startActivity(intent);
        finish();
    }
}