package com.mukanda.taekwondodrawsguider;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.mukanda.taekwondodrawsguider.Drawsview;

import java.util.ArrayList;
import java.util.List;

public class PendingAppointmentFragment extends Fragment {
    private RecyclerView recyclerView;
    private ProgressDialog progressDialog;
    private List<PatientAppointmentRequest> appointmentRequestList;
    private PendingAppointmentAdapter adapter;
    private SearchView searchView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_common,container,false);
        setHasOptionsMenu(true);
        recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        appointmentRequestList=new ArrayList<>();
        progressDialog= new ProgressDialog(getContext());
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Loading...\nPlease wait...");
        progressDialog.show();
        FirebaseDatabase.getInstance().getReference().child("PendingAthleteAppointments").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                appointmentRequestList.clear();
                for(DataSnapshot childsnapshot:snapshot.getChildren()){
                    appointmentRequestList.add(childsnapshot.getValue(PatientAppointmentRequest.class));
                }
                adapter=new PendingAppointmentAdapter(getContext(),appointmentRequestList);
                recyclerView.setAdapter(adapter);
                progressDialog.dismiss();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                progressDialog.dismiss();
                ReusableFunctionsAndObjects.showMessageAlert(getContext(),"Network Error",error.getMessage(),"Ok",(byte)0);
            }
        });
        return view;
    }

    private void filter(String s){
        List<PatientAppointmentRequest> filteredlist=new ArrayList<>();
        for(PatientAppointmentRequest req: appointmentRequestList){
            if(req.getName().toLowerCase().contains(s.toLowerCase())){
                filteredlist.add(req);
            }
        }
        adapter=new PendingAppointmentAdapter(getContext(),filteredlist);
        recyclerView.setAdapter(adapter);
    }

}
