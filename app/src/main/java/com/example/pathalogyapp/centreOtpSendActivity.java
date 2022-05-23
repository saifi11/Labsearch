package com.example.pathalogyapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.pathalogyapp.databinding.ActivityCentreOtpSendBinding;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class centreOtpSendActivity extends AppCompatActivity {

    private ActivityCentreOtpSendBinding binding;
    private FirebaseAuth mAuth;
    private PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCentreOtpSendBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        mAuth = FirebaseAuth.getInstance();
        binding.btnSend1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (binding.etPhone1.getText().toString().trim().isEmpty())
                {
                    Toast.makeText(centreOtpSendActivity.this, "Invalid Phone Number", Toast.LENGTH_SHORT).show();
                }else if (binding.etPhone1.getText().toString().trim().length() !=10)
                {
                    Toast.makeText(centreOtpSendActivity.this, "Type valid Phone Number", Toast.LENGTH_SHORT).show();
                }else
                {
                    otpSend();
                }
            }
        });
    }

    private void otpSend() {
        binding.progressBar1.setVisibility(View.VISIBLE);
        binding.btnSend1.setVisibility(View.INVISIBLE);
        mCallbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
            @Override
            public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {

            }

            @Override
            public void onVerificationFailed(@NonNull FirebaseException e) {
                binding.progressBar1.setVisibility(View.GONE);
                binding.btnSend1.setVisibility(View.VISIBLE);
                Toast.makeText(centreOtpSendActivity.this, e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();

            }
            public void onCodeSent(@NonNull String verificationId,
                                   @NonNull PhoneAuthProvider.ForceResendingToken token) {
                binding.progressBar1.setVisibility(View.GONE);
                binding.btnSend1.setVisibility(View.VISIBLE);
                Toast.makeText(centreOtpSendActivity.this, "OTP is successfully send.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(centreOtpSendActivity.this, centreOtpVerifyActivity.class);
                intent.putExtra("phone", binding.etPhone1.getText().toString().trim());
                intent.putExtra("verificationId", verificationId);
                startActivity(intent);
            }

        };
        PhoneAuthOptions options =
                PhoneAuthOptions.newBuilder(mAuth)
                        .setPhoneNumber("+91" + binding.etPhone1.getText().toString().trim())
                        .setTimeout(60L, TimeUnit.SECONDS)
                        .setActivity(this)
                        .setCallbacks(mCallbacks)
                        .build();
        PhoneAuthProvider.verifyPhoneNumber(options);
    }
}