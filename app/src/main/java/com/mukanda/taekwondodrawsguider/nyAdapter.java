package com.mukanda.taekwondodrawsguider;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class nyAdapter extends RecyclerView.Adapter<nyAdapter.myViewHolder> {
    Context context;
    ArrayList<USER> list;

    public nyAdapter(Context context, ArrayList<USER> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.item_list,parent,false);
        return  new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        USER user =list.get(position);
        holder.email.setText(user.getEmail());
        holder.firstname.setText(user.getFirstName());
        holder.lastname.setText(user.getLastName());
        holder.age.setText(user.getPhone_No());
        holder.user.setText(user.getUser_type());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class myViewHolder extends RecyclerView.ViewHolder {
        TextView email,firstname,lastname,age,user;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            email=itemView.findViewById(R.id.tvemail);
            firstname=itemView.findViewById(R.id.tvfirstname);
            lastname=itemView.findViewById(R.id.tvlastname);
            age=itemView.findViewById(R.id.tvage);
            user=itemView.findViewById(R.id.tvuser);
        }
    }
}
