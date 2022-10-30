package com.mukanda.taekwondodrawsguider;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Date;
import java.util.HashMap;

public class middle_heavy extends AppCompatActivity {
    private TextInputLayout FullNAameTB,AgeTB,ClubTB,WeightTB,RankTB;
    private AppCompatButton Submit;
    private ProgressDialog progressDialog;
    private HashMap<String,String> hashMap;
    private int d = 0,m=0,y=0,min=0,h=0;
    double weight= 0;
    RadioGroup radioGroup;
    RadioButton radioButton1,radioButton2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_club_registration);
        FullNAameTB=findViewById(R.id.fullnmaeTB);
        AgeTB=findViewById(R.id.ageTB);
        radioButton1=findViewById(R.id.radioMale);
        radioButton2=findViewById(R.id.radioFemale);
        radioGroup=findViewById(R.id.radiogroup);
        ClubTB=findViewById(R.id.clubTB);
        WeightTB=findViewById(R.id.weightTB);
        RankTB=findViewById(R.id.rankTB);
        Submit=findViewById(R.id.register);
        progressDialog = new ProgressDialog(this);
        progressDialog.setCanceledOnTouchOutside(true);
        progressDialog.setCancelable(true);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.radioMale:
                                               Toast.makeText(middle_heavy.this,"male",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.radioFemale:
                        Toast.makeText(middle_heavy.this,"female",Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String FullName = FullNAameTB.getEditText().getText().toString().trim();
                String Age = AgeTB.getEditText().getText().toString().trim();
                String ClubName = ClubTB.getEditText().getText().toString().trim();
                String Weight = WeightTB.getEditText().getText().toString().trim();
                String Rank = RankTB.getEditText().getText().toString().trim();
                String gender = WeightTB.getEditText().getText().toString().trim();
                progressDialog.setMessage("Registering, please wait...");
                progressDialog.show();

                FirebaseDatabase.getInstance().getReference().child("middle_men").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).setValue(hashMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()){
                            progressDialog.show();
                            hashMap=new HashMap<>();
                            hashMap.put("FullName",FullName);
                            hashMap.put("Age",Age);
                            hashMap.put("ClubName",ClubName);
                            hashMap.put("Rank",Rank);
                            hashMap.put("Weight",Weight);
                            hashMap.put("Gender",gender);

                            FirebaseDatabase.getInstance().getReference().child("middle_heavy").setValue(hashMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if(task.isSuccessful()){
                                        progressDialog.dismiss();
                                        ReusableFunctionsAndObjects.showMessageAlert(middle_heavy.this, "Completed", "Mr "+FullName+" You have successfully Registered for this Championship "+". Check status about your draw after some time.", "OK",(byte)1);
                                    }else{
                                        progressDialog.dismiss();
                                        ReusableFunctionsAndObjects.showMessageAlert(middle_heavy.this, "Completed", "Mr "+FullName+" You have successfully Registered for this Championship "+". Check status about your draw after some time.", "OK",(byte)1);

                                    }
                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    progressDialog.dismiss();
                                    ReusableFunctionsAndObjects.showMessageAlert(middle_heavy.this, "Network Error", "Make sure you are connected to internet.", "OK",(byte)0);
                                }
                            });
                        }else{
                            progressDialog.dismiss();
                            ReusableFunctionsAndObjects.showMessageAlert(middle_heavy.this, "Network Error", "Make sure you are connected to internet.", "OK",(byte)0);
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        progressDialog.dismiss();
                        ReusableFunctionsAndObjects.showMessageAlert(middle_heavy.this, "Network Error", "Make sure you are connected to internet.", "OK",(byte)0);
                    }
                });



            }
        });

    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(middle_heavy.this,PlayerLoginRegisterChoice.class));
        overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right);
        finish();
    }
}

