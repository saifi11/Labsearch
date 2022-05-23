package com.example.pathalogyapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.pathalogyapp.databinding.ActivityCentreOtpVerifyBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.database.annotations.NotNull;

public class centreOtpVerifyActivity extends AppCompatActivity {

    private ActivityCentreOtpVerifyBinding binding;
    private String verificationId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       binding = ActivityCentreOtpVerifyBinding.inflate(getLayoutInflater());
       setContentView(binding.getRoot());

        editTextInput();
        binding.tvMobile2.setText(String.format(
                "+91-%s", getIntent().getStringExtra("phone")
        ));

        verificationId = getIntent().getStringExtra("verificationId");

        binding.tvResendBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(centreOtpVerifyActivity.this, "OTP Send Successfully.", Toast.LENGTH_SHORT).show();
            }
        });
        binding.btnVerify2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.progressBarVerify2.setVisibility(View.VISIBLE);
                binding.btnVerify2.setVisibility(View.INVISIBLE);
                if (binding.etC12.getText().toString().trim().isEmpty() ||
                        binding.etC22.getText().toString().trim().isEmpty() ||
                        binding.etC32.getText().toString().trim().isEmpty() ||
                        binding.etC42.getText().toString().trim().isEmpty() ||
                        binding.etC52.getText().toString().trim().isEmpty() ||
                        binding.etC62.getText().toString().trim().isEmpty()) {
                    Toast.makeText(centreOtpVerifyActivity.this, "OTP is not Valid!", Toast.LENGTH_SHORT).show();
                } else {
                    if (verificationId != null) {
                        String code = binding.etC12.getText().toString().trim() +
                                binding.etC22.getText().toString().trim() +
                                binding.etC32.getText().toString().trim() +
                                binding.etC42.getText().toString().trim() +
                                binding.etC52.getText().toString().trim() +
                                binding.etC62.getText().toString().trim();

                        PhoneAuthCredential credential = PhoneAuthProvider.getCredential(verificationId, code);
                        FirebaseAuth
                                .getInstance()
                                .signInWithCredential(credential)
                                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                    @Override
                                    public void onComplete(@NonNull @NotNull Task<AuthResult> task) {
                                        if (task.isSuccessful()) {
                                            binding.progressBarVerify2.setVisibility(View.VISIBLE);
                                            binding.btnVerify2.setVisibility(View.INVISIBLE);
                                            Toast.makeText(centreOtpVerifyActivity.this, "Number verified", Toast.LENGTH_SHORT).show();
                                            Intent intent = new Intent(centreOtpVerifyActivity.this, com.example.pathalogyapp.centreforgetpassword.class);
                                            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                                            startActivity(intent);
                                        } else {
                                            binding.progressBarVerify2.setVisibility(View.GONE);
                                            binding.btnVerify2.setVisibility(View.VISIBLE);
                                            Toast.makeText(centreOtpVerifyActivity.this, "OTP is not Valid!", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                });
                    }
                }
            }
        });

    }

    private void editTextInput() {
        binding.etC12.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                binding.etC22.requestFocus();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        binding.etC22.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                binding.etC32.requestFocus();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        binding.etC32.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                binding.etC42.requestFocus();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        binding.etC42.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                binding.etC52.requestFocus();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        binding.etC52.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                binding.etC62.requestFocus();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }
}