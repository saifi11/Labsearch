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

public class MyAdapter1 extends RecyclerView.Adapter<MyAdapter1.MyViewHolder1> {


    Context context;
    ArrayList<com.example.pathalogyapp.blood_> list;
    public MyAdapter1(Context context, ArrayList<com.example.pathalogyapp.blood_> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder1 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.singlerow1,parent,false);
        return new MyViewHolder1(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder1 holder, int position) {
        com.example.pathalogyapp.blood_ blood = list.get(position);
        holder.test_name.setText(blood.getBlood_name());
        holder.test_price.setText(blood.getBlood_price());
        holder.test_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, com.example.pathalogyapp.bloodtestbooking.class);
                intent.putExtra("testname",blood.getBlood_name());
                intent.putExtra("testprice",blood.getBlood_price());
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public static class MyViewHolder1 extends RecyclerView.ViewHolder
    {

        TextView test_name , test_price;
        public MyViewHolder1(@NonNull View itemView) {
            super(itemView);
            test_name=itemView.findViewById(R.id.test_name);
            test_price=itemView.findViewById(R.id.test_price);

        }
    }
}
