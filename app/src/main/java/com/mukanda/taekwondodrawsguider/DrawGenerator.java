package com.mukanda.taekwondodrawsguider;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class DrawGenerator extends AppCompatActivity {
    Button button;
    LinearLayout main,draws;
    EditText editText1,editText2,editText3,editText4,editText5,editText6,editText7,editText8,category;
    EditText editText1r,editText2r,editText3r,editText4r,editText5r,editText6r,editText7r,editText8r;
    TextView textView1,textView2,textView3,textView4,textView5,textView6,textView8,textView7,weight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_draw_generator);
        main=findViewById(R.id.main);
        draws=findViewById(R.id.draws);
        editText1=findViewById(R.id.player1);
        weight=findViewById(R.id.weight);
        category=findViewById(R.id.category);
        editText2=findViewById(R.id.player2);
        editText3=findViewById(R.id.player3);
        editText4=findViewById(R.id.player4);
        editText5=findViewById(R.id.player5);
        editText6=findViewById(R.id.player6);
        editText7=findViewById(R.id.player7);
        editText8=findViewById(R.id.player8);
        editText1r=findViewById(R.id.rank1);
        editText2r=findViewById(R.id.rank2);
        editText3r=findViewById(R.id.rank3);
        editText4r=findViewById(R.id.rank4);
        editText5r=findViewById(R.id.rank5);
        editText6r=findViewById(R.id.rank6);
        editText7r=findViewById(R.id.rank7);
        editText8r=findViewById(R.id.rank8);
        textView1=findViewById(R.id.athlete1);
        textView2=findViewById(R.id.athlete2);
        textView3=findViewById(R.id.athlete3);
        textView4=findViewById(R.id.athlete4);
        textView5=findViewById(R.id.athlete5);
        textView6=findViewById(R.id.athlete6);
        textView7=findViewById(R.id.athlete7);
        textView8=findViewById(R.id.athlete8);
        button= findViewById(R.id.generate);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String player1= editText1.getText().toString().trim();
                String player2= editText2.getText().toString().trim();
                String player3= editText3.getText().toString().trim();
                String player4= editText4.getText().toString().trim();
                String player5= editText5.getText().toString().trim();
                String player6= editText6.getText().toString().trim();
                String player7= editText7.getText().toString().trim();
                String player8= editText8.getText().toString().trim();
                String rank1= editText1r.getText().toString().trim();
                String rank2= editText2r.getText().toString().trim();
                String rank3= editText3r.getText().toString().trim();
                String rank4= editText4r.getText().toString().trim();
                String rank5= editText5r.getText().toString().trim();
                String rank6= editText6r.getText().toString().trim();
                String rank7= editText7r.getText().toString().trim();
                String rank8= editText8r.getText().toString().trim();
                String categories= category.getText().toString().trim();
                textView1.setText(player1);
                textView2.setText(player2);
                textView3.setText(player3);
                textView4.setText(player4);
                textView5.setText(player5);
                textView6.setText(player6);
                textView7.setText(player7);
                textView8.setText(player8);
                weight.setText(categories);
                draws.setVisibility(View.VISIBLE);



            }
        });
    }



}