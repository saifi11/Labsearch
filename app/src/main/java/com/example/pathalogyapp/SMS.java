package com.example.pathalogyapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SMS extends AppCompatActivity {

    TextView username , date , phonenumber ,Testname ;

    String Message="@Lab Search! Your Appointment has been Booked . Thank You For Your Interest";
    Button SMS;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);

        username = findViewById(R.id.name);
        date = findViewById(R.id.Date);
        phonenumber = findViewById(R.id.phone_number);
        Testname = findViewById(R.id.Testname);
        SMS = findViewById(R.id.SMS);


        username.setText(getIntent().getStringExtra("Username"));
        date.setText(getIntent().getStringExtra("Date"));
        phonenumber.setText(getIntent().getStringExtra("phonenumber"));
        Testname.setText(getIntent().getStringExtra("Testname"));


        SMS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(com.example.pathalogyapp.SMS.this, Manifest.permission.SEND_SMS)
                == PackageManager.PERMISSION_GRANTED)
                {
                    sendsms(Message);
                }else
                {
                    ActivityCompat.requestPermissions(com.example.pathalogyapp.SMS.this,new String[]{Manifest.permission.SEND_SMS},100);

                }
            }
            
        });

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        // check conditions

        if (requestCode == 100 && grantResults.length > 0  && grantResults[0] == PackageManager.PERMISSION_GRANTED)
        {
            // permission is granted
            sendsms(Message);
        }else
        {
            // when permission is denied
            Toast.makeText(this, "Permission Denied!", Toast.LENGTH_SHORT).show();
        }
    }

    private void sendsms(String message) {
        String Phone = phonenumber.getText().toString();
        String message_ = Message.toString();

        SmsManager smsManager = SmsManager.getDefault();
        //send message
        smsManager.sendTextMessage(Phone,null,message_,null,null);
        //dispaly Toast message
        Toast.makeText(this, "SMS Sent Successfully", Toast.LENGTH_SHORT).show();

    }
}