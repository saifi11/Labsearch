package com.example.pathalogyapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>  {
    Context context;
    List<com.example.pathalogyapp.User> list;
    List<com.example.pathalogyapp.User> listfull=  new ArrayList<>();



    public MyAdapter(Context context, ArrayList<com.example.pathalogyapp.User> list) {
        this.context = context;
        this.list = list;
        this.listfull = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.singlerow,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        com.example.pathalogyapp.User user = list.get(position);
        holder.centre_name.setText(user.getCentre_name());
        holder.centre_Pin.setText(user.getCentre_Pin());

        holder.centre_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, com.example.pathalogyapp.useronclickuserlist.class);
                intent.putExtra("title",user.getCentre_name());
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);

            }
        });



    }

    @Override
    public int getItemCount() {

        return list.size();
    }

    //filter





//-------------------------------------------

    public static class MyViewHolder extends RecyclerView.ViewHolder
    {
        TextView centre_name,centre_Pin;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            centre_name=itemView.findViewById(R.id.centrename_card);
            centre_Pin=itemView.findViewById(R.id.centrepincode_card);

        }
    }
}
