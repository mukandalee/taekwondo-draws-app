package com.mukanda.taekwondodrawsguider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Userlist extends AppCompatActivity {
    RecyclerView recyclerView;
    DatabaseReference database;
    nyAdapter myAdapter;
    ArrayList<USER>list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userlist);
        recyclerView=findViewById(R.id.rView);
        database= FirebaseDatabase.getInstance().getReference("UserDetails");
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        list=new ArrayList<>();
        myAdapter=new nyAdapter(this,list);
        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    USER user = dataSnapshot.getValue(USER.class);
                    list.add(user);
                }
                myAdapter.notifyDataSetChanged();
            }

//                public void onCancelled(;DatabaseError error) {
//
//            }
//        }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }


            });

    }
};
