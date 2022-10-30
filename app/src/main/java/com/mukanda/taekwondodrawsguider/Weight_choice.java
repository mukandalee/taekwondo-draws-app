package com.mukanda.taekwondodrawsguider;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Weight_choice extends AppCompatActivity {
    CardView cardFin,cardFly,cardBantam,cardFeather,cardLight,cardWelter,cardMiddle,cardHeavy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight_choice);
        cardFin=findViewById(R.id.cardfin);
        cardFly=findViewById(R.id.cardfly);
        cardBantam=findViewById(R.id.cardbantam);
        cardFeather=findViewById(R.id.cardfeather);
        cardLight=findViewById(R.id.cardlight);
        cardWelter=findViewById(R.id.cardwelter);
        cardMiddle=findViewById(R.id.cardmiddle);
        cardHeavy=findViewById(R.id.cardheavy);
        cardFin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Weight_choice.this,Fin_weight.class));
            }
        });
        cardFly.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Weight_choice.this,Fly_weight.class));
            }
        });
        cardBantam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Weight_choice.this,Bantam.class));
            }
        });
        cardFeather.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Weight_choice.this,Feather.class));
            }
        });
        cardLight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Weight_choice.this,Light_weight.class));
            }
        });
        cardWelter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Weight_choice.this,Welter.class));
            }
        });
        cardMiddle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Weight_choice.this,middle_heavy.class));
            }
        });
        cardHeavy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Weight_choice.this,Heavy_weight.class));
            }
        });
    }
}