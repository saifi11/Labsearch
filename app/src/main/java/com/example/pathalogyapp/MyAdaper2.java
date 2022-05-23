package com.example.pathalogyapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdaper2  extends RecyclerView.Adapter<MyAdaper2.MyViewHolder2> {

    Context context;
    ArrayList<patient_> list;

    public MyAdaper2(Context context, ArrayList<patient_> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder2 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View v = LayoutInflater.from(context).inflate(R.layout.singlerow2,parent,false);
       return new MyViewHolder2(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder2 holder, int position) {
        patient_ patient = list.get(position);
        holder.patient_name.setText(patient.getPatient_name());
        holder.patient_phone.setText(patient.getPatient_phone());
        holder.patient_age.setText(patient.getPatient_age());
        holder.refer_doc.setText(patient.getRefer_doc());
        holder.testname.setText(patient.getTestname());
        holder.testprice.setText(patient.getTestprice());
        holder.date.setText(patient.getDate());
        holder.patient_gender.setText(patient.getPatient_gender());
        holder.address.setText(patient.getAddress());
        holder.patient_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, SMS.class);
                intent.putExtra("Username",patient.getPatient_name());
                intent.putExtra("phonenumber",patient.getPatient_phone());
                intent.putExtra("Date",patient.getDate());
                intent.putExtra("Testname",patient.getTestname());
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);

            }
        });



    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder2 extends RecyclerView.ViewHolder
    {

        TextView patient_name, patient_phone , patient_age , refer_doc ,testname , testprice,date,patient_gender,address;
        public MyViewHolder2(@NonNull View itemView) {
            super(itemView);

            patient_name = itemView.findViewById(R.id.Patient_Name_card);
            patient_phone = itemView.findViewById(R.id.Patient_Phone_card);
            patient_age = itemView.findViewById(R.id.Patient_Age_card);
            refer_doc = itemView.findViewById(R.id.refer_doc_card);
            testname= itemView.findViewById(R.id.testname_card);
            testprice= itemView.findViewById(R.id.testprice_card);
            date= itemView.findViewById(R.id.testdate_card);
            patient_gender= itemView.findViewById(R.id.gender_card);
            address= itemView.findViewById(R.id.Address_card);





        }
    }
}
