package com.example.pathalogyapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class sendmail extends AppCompatActivity {

    EditText sendmail , sendmessage ,sendsubject;
    Button sendmailbtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sendmail);

        sendmail = findViewById(R.id.Emailid_mail);
        sendsubject = findViewById(R.id.Entresub_mail);
        sendmessage = findViewById(R.id.message_mail);





    }

    public void  processmail(View view)
    {
        String to = sendmail.getText().toString();
        String SUB = sendsubject.getText().toString();
        String mess = sendmessage.getText().toString();

        Intent email = new Intent(Intent.ACTION_SEND);
        email.putExtra(Intent.EXTRA_EMAIL,new String[]{to});
        email.putExtra(Intent.EXTRA_SUBJECT,SUB);
        email.putExtra(Intent.EXTRA_TEXT,mess);

        email.setType("message/rfc822");
        startActivity(Intent.createChooser(email,"send email...."));

    }
}