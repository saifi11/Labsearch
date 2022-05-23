package com.example.pathalogyapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.util.UUID;

public class Prescriptionupload extends AppCompatActivity {
    ImageView imageView;
    Button button;
    FirebaseStorage storage;
    Uri imageUri;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prescriptionupload);
        button = findViewById(R.id.uploadbtn1);
        imageView = findViewById(R.id.imageView1);
        storage = FirebaseStorage.getInstance();

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mGetContent.launch("image/*");
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uploadImage();
                Intent intent = new Intent(getApplicationContext(),paymentdone.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void uploadImage() {
        ProgressDialog dialog = new ProgressDialog(this);
        dialog.setMessage("Uploading.......");
        dialog.show();
        if (imageUri != null)
        {
            StorageReference reference = storage.getReference("Doctor_Prescription").child("Prescription"+ UUID.randomUUID().toString());
            reference.putFile(imageUri).addOnCompleteListener(new OnCompleteListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onComplete(@NonNull Task<UploadTask.TaskSnapshot> task) {
                    if (task.isSuccessful())
                    {
                        dialog.dismiss();
                        Toast.makeText(Prescriptionupload.this, "Prescription Uploaded Successfully", Toast.LENGTH_SHORT).show();

                    }else
                    {
                        dialog.dismiss();
                        Toast.makeText(Prescriptionupload.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();

                    }
                }
            });
        }
    }

    ActivityResultLauncher<String> mGetContent = registerForActivityResult(new ActivityResultContracts.GetContent(),
            new ActivityResultCallback<Uri>() {
                @Override
                public void onActivityResult(Uri result) {
                    if (result != null){
                        imageView.setImageURI(result);
                        imageUri = result;
                    }
                }
            });

    public void skip(View view) {
        Intent intent = new Intent(getApplicationContext(),paymentdone.class);
        startActivity(intent);
        finish();
    }
}