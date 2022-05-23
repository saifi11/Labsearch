package com.example.pathalogyapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.security.PublicKey;
import java.util.UUID;

public class patientdetail extends AppCompatActivity  {

    TextInputLayout patient_name , patient_phone,patient_age,patient_gender, patient_Email, refer_doc,patient_Address;
    TextView testname , testprice;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference reference;
    DatePicker datePicker;
    Button button;
    EditText editText;
    RadioGroup radioGroup;
    RadioButton radioButton;
    TextView textView;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patientdetail);



        radioGroup= findViewById(R.id.radio);
        textView = findViewById(R.id.view);
        String gender = textView.getText().toString();
        Button button_radio = findViewById(R.id.Apply);
        button_radio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int radioid = radioGroup.getCheckedRadioButtonId();
                radioButton= findViewById(radioid);
                textView.setText(radioButton.getText());


            }
        });
        testname = findViewById( R.id.testname_p);
        testprice = findViewById(R.id.testprice_p);
        datePicker = findViewById(R.id.date_picker);
        button = findViewById(R.id.button_date);
        editText = findViewById(R.id.edit_date);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int day = datePicker.getDayOfMonth();
                int month = (datePicker.getMonth()+1);
                int year = datePicker.getYear();

                editText.setText(day+ "/"+month+"/"+year);

            }
        });


        testname.setText(getIntent().getStringExtra("testname"));
        testprice.setText(getIntent().getStringExtra("testprice"));



        String testname_ = testname.getText().toString();
        String testprice_ = testprice.getText().toString();




    }

    public void Patientsdetails(View view) {

        patient_name = findViewById(R.id.patient_name);
        patient_phone = findViewById(R.id.patient_phone);
        patient_age = findViewById(R.id.patient_age);
//        patient_gender = findViewById(R.id.patient_Gender);
        patient_Email = findViewById(R.id.patient_Email);
        refer_doc = findViewById(R.id.Doc_detail);
        patient_Address = findViewById(R.id.Address_p);


        String patient_name_ = patient_name.getEditText().getText().toString();
        String patient_phone_ = patient_phone.getEditText().getText().toString();
        String patient_age_ = patient_age.getEditText().getText().toString();
//        String patient_gender_ = patient_gender.getEditText().getText().toString();
        String gender_ = textView.getText().toString();
        String patient_Email_ = patient_Email.getEditText().getText().toString();
        String refer_doc_ = refer_doc.getEditText().getText().toString();
        String patient_Address_ = patient_Address.getEditText().getText().toString();
        String date = editText.getText().toString();


        if(!patient_name_.isEmpty()) //patient_name
        {
            patient_name.setError(null);
            patient_name.setErrorEnabled(false);

            if(!patient_phone_.isEmpty() && patient_phone_.length() ==10 ) //patient_phone
            {
                patient_phone.setError(null);
                patient_phone.setErrorEnabled(false);

                if (!patient_age_.isEmpty() && patient_age_.length()<=100) //patient_age
                {
                    patient_age.setError(null);
                    patient_age.setErrorEnabled(false);



                        if (!patient_Email_.isEmpty()) //patient_Email
                        {
                            patient_Email.setError(null);
                            patient_Email.setErrorEnabled(false);
                            if(patient_Email_.matches("^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$"))
                            {

                                if (!refer_doc_.isEmpty())  //refer_doc
                                {
                                    refer_doc.setError(null);
                                    refer_doc.setErrorEnabled(false);


                                        if (!patient_Address_.isEmpty())
                                        {
                                            patient_Address.setError(null);
                                            patient_Address.setErrorEnabled(false);

                                            //firebase
                                            firebaseDatabase = FirebaseDatabase.getInstance();
                                            reference = firebaseDatabase.getReference("patientdetile");
                                            String patient_name_s = patient_name.getEditText().getText().toString();
                                            String patient_phone_s = patient_phone.getEditText().getText().toString();
                                            String patient_age_s= patient_age.getEditText().getText().toString();
//                                            String patient_gender_s = patient_gender.getEditText().getText().toString();
                                            String gender_s = textView.getText().toString();
                                            String patient_Email_s = patient_Email.getEditText().getText().toString();
                                            String refer_doc_s = refer_doc.getEditText().getText().toString();
                                            String testname_s = testname.getText().toString();
                                            String testprice_s = testprice.getText().toString();
                                            String patient_Address_s = patient_Address.getEditText().getText().toString();
                                            String date_ = editText.getText().toString();



                                            patientstore patientstores = new patientstore(patient_name_s,patient_phone_s,patient_age_s,gender_s,patient_Email_s,refer_doc_s,testname_s,testprice_s,patient_Address_s,date_);
                                            reference.child(UUID.randomUUID().toString()).setValue(patientstores);

                                            Toast.makeText(getApplicationContext(), "Added Successfully", Toast.LENGTH_SHORT).show();
                                            Intent intent = new Intent(getApplicationContext(),Prescriptionupload.class);
                                            startActivity(intent);
                                            finish();
                                        }else
                                        {
                                            patient_Address.setError("Enter the Address");
                                        }



                                }else  //refer_doc
                                {
                                    refer_doc.setError("Please Entre the value");
                                }
                            }else //email check
                            {
                                patient_Email.setError("Enter the Valid Email");
                            }

                        }else //patient_Email
                        {
                            patient_Email.setError("Please Entre the Patient Email");

                        }

                    }else //gender
                    {
                        patient_gender.setError("Please Entre the Patient Gender");

                    }

                }else //patient_age
                {
                    patient_age.setError("Please Entre the Patient Age");

                }

            }else //patient_phone
            {
                patient_phone.setError("Please Entre the Patient Phone Number");

            }

        }


    public void checkButton(View view) {
        int radioid = radioGroup.getCheckedRadioButtonId();
        radioButton= findViewById(radioid);


    }
}