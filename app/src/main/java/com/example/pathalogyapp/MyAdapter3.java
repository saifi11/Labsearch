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

public class MyAdapter3  extends RecyclerView.Adapter<MyAdapter3.MYViewHolder3> {

    public MyAdapter3(Context context, ArrayList<com.example.pathalogyapp.mri_> list) {
        this.context = context;
        this.list = list;
    }

    Context context;
    ArrayList<com.example.pathalogyapp.mri_> list;
    @NonNull
    @Override
    public MYViewHolder3 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.singlerow_mri,parent,false);
        return new MYViewHolder3(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MYViewHolder3 holder, int position) {
        com.example.pathalogyapp.mri_ mri = list.get(position);
        holder.xray_price.setText(mri.getXray_price());
        holder.xray_name.setText(mri.getXray_name());

        // click on the name

        holder.xray_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, com.example.pathalogyapp.mritestbooking.class);
                intent.putExtra("xray_name",mri.getXray_name());
                intent.putExtra("xray_price",mri.getXray_price());
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {

        return list.size();
    }

    public static class MYViewHolder3 extends RecyclerView.ViewHolder
    {

        TextView  xray_name , xray_price;

        public MYViewHolder3(@NonNull View itemView) {
            super(itemView);
            xray_name = itemView.findViewById(R.id.test_name_mri);
            xray_price = itemView.findViewById(R.id.test_price_mri);

        }
    }
}
