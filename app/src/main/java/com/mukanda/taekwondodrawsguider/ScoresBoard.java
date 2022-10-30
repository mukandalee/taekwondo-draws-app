package com.mukanda.taekwondodrawsguider;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ScoresBoard extends AppCompatActivity {
    public int counter;
     String period;
    Button button1, button2,player1,player2 ,timer,sround;
    int ScoreTeamA=0, ScoreTeamB=0,Round=1,Timer=0;
    int Foul=0;
    int Foul1=0;
    Button btn1,btn_new,btn_new2;

    TextView text1, text12 ,round,chaw,how;
    EditText stimer,CHANG,HONG;
    Button button;
    Intent intent=null, chooser=null;
    LinearLayout BLUE ,RED,Main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.score_board);
        //Resources.Theme.App


         setTitle("               Scores Board");
        button1=findViewById(R.id.teama);
       // btn_new=(Button) findViewById(R.id.new_game);
        HONG=findViewById(R.id.playerh);
        Main=findViewById(R.id.main);
        CHANG=findViewById(R.id.playerc);
        btn_new=findViewById(R.id.new_game1);
        btn_new2=findViewById(R.id.new_game2);
        chaw=findViewById(R.id.changw);
        how=findViewById(R.id.hongw);
        BLUE=findViewById(R.id.chang);
        RED=findViewById(R.id.hong);
        button2=findViewById(R.id.teamb);
        btn1=findViewById(R.id.TEAMA1);
        text1=findViewById(R.id.play1);
        round=findViewById(R.id.round);
        timer=findViewById(R.id.timer);
        stimer=findViewById(R.id.timer_show);
        sround=findViewById(R.id.round_show);

        text12=findViewById(R.id.play12);
        player1=findViewById(R.id.player1);

        player2=findViewById(R.id.player2);
        button=findViewById(R.id.end_game);
        period=stimer.getText().toString().trim();
        btn_new2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Main.setVisibility(View.VISIBLE);
                startActivity(new Intent(ScoresBoard.this,ScoresBoard.class));
            }
        });
        btn_new.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Main.setVisibility(View.VISIBLE);
                startActivity(new Intent(ScoresBoard.this,ScoresBoard.class));
            }
        });

        timer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new CountDownTimer( 1000,1000)
                {
                    @Override
                    public void onTick(long l) {
                        stimer.setText(String.valueOf(period));
                        counter--;
                    }

                    @Override
                    public void onFinish() {
                        stimer.setText("END");
                        addround();
                    }
                }.start();
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                endgame();

//
            }
        });
        text1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String player1=CHANG.getText().toString().trim();
                String player2=HONG.getText().toString().trim();
                if(Foul<9)
                {
                    addOne("teamB", "one");
                }
                else if (Foul==9)
                {
                    chaw.setText(player1);
                    BLUE.setVisibility(View.VISIBLE);
                }
                else
                {

                }
                addOneFoul();


            }
        });

        text12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String player1=CHANG.getText().toString().trim();
                String player2=HONG.getText().toString().trim();
                if(Foul1<9)
                {
                    addOne("teamA", "one");
                }
                else if(Foul1==9)
                {
                    how.setText(player2);
                    RED.setVisibility(View.VISIBLE);
                }
                else
                {

                }
                addOneFoul1();


            }
        });

    }

    public void teama1(View v) {
        addOne("teamA", "one");
        Toast.makeText(ScoresBoard.this,"punch",Toast.LENGTH_LONG).show();

    }

    public void teama2(View v) {
        addtwo("teamA", "two");
        //Toast.makeText(MainActivity.this,"Team A2 clicked",Toast.LENGTH_SHORT).show();

    }

    public void teama3(View v) {
        addthree("teamA", "three");
        //Toast.makeText(MainActivity.this,"Team A3 clicked",Toast.LENGTH_SHORT).show();

    }

    public void teama4(View v) {
        addfour("teamA", "four");
        //Toast.makeText(MainActivity.this,"Team A3 clicked",Toast.LENGTH_SHORT).show();

    }

    public void teama5(View v) {
        addfive("teamA", "five");
        //Toast.makeText(MainActivity.this,"Team A3 clicked",Toast.LENGTH_SHORT).show();

    }

    public void teamb1(View v) {
        addOne("teamB", "one");
        Toast.makeText(ScoresBoard.this,"punch",Toast.LENGTH_LONG).show();
    }

    public void teamb2(View v) {
        addtwo("teamB", "two");


    }

    public void teamb3(View v) {
        addthree("teamB", "three");
        //Toast.makeText(MainActivity.this,"Team B3 clicked",Toast.LENGTH_SHORT).show();

    }
    public void teamb4(View v) {
        addfour("teamB", "four");
        //Toast.makeText(MainActivity.this,"Team B3 clicked",Toast.LENGTH_SHORT).show();

    }
    public void teamb5(View v) {
        addfive("teamB", "five");
        //Toast.makeText(MainActivity.this,"Team B3 clicked",Toast.LENGTH_SHORT).show();

    }
    public void addround() {
        Round=Round + 1;

            sround.setText(Round + "");
        }

    public void addOne(String team1, String score1) {
        String team=team1;
        String score=score1;
        ScoreTeamA=ScoreTeamA + 1;
        if (team == "teamA" && score == "one") {

            button1.setText(ScoreTeamA + "");

        } else if (team == "teamB" && score == "one") {
            ScoreTeamB=ScoreTeamB + 1;
            button2.setText(ScoreTeamB + "");
        } else {

        }

    }

    public void addtwo(String team2, String score2) {
        String team=team2;
        String score=score2;
        ScoreTeamA=ScoreTeamA + 2;
        if (team == "teamA" && score == "two") {
            Toast.makeText(ScoresBoard.this,"Trunk",Toast.LENGTH_LONG).show();


            button1.setText(ScoreTeamA + "");
        } else if (team == "teamB" && score == "two") {
            ScoreTeamB=ScoreTeamB + 2;
            Toast.makeText(ScoresBoard.this,"Trunk",Toast.LENGTH_LONG).show();
            button2.setText(ScoreTeamB + "");
        } else {

        }

    }

    public void addthree(String team3, String score3) {
        String team=team3;
        String score=score3;
        ScoreTeamA=ScoreTeamA + 3;
        if (team == "teamA" && score == "three") {
            Toast.makeText(ScoresBoard.this,"Headshot!",Toast.LENGTH_LONG).show();


            button1.setText(ScoreTeamA + "");
        } else if (team == "teamB" && score == "three") {
            ScoreTeamB=ScoreTeamB + 3;
            Toast.makeText(ScoresBoard.this,"Headshot!",Toast.LENGTH_LONG).show();
            button2.setText(ScoreTeamB + "");
        } else {

        }

    }

    public void addfour(String team4, String score4) {
        String team=team4;
        String score=score4;
        ScoreTeamA=ScoreTeamA + 4;
        if (team == "teamA" && score == "four") {
            Toast.makeText(ScoresBoard.this,"Headshot!",Toast.LENGTH_LONG).show();


            button1.setText(ScoreTeamA + "");
        } else if (team == "teamB" && score == "four") {
            ScoreTeamB=ScoreTeamB + 4;
            Toast.makeText(ScoresBoard.this,"Headshot!",Toast.LENGTH_LONG).show();
            button2.setText(ScoreTeamB + "");
        } else {

        }

    }

    public void addfive(String team5, String score5) {
        String team=team5;
        String score=score5;
        ScoreTeamA=ScoreTeamA + 5;
        if (team == "teamA" && score == "five") {
            Toast.makeText(ScoresBoard.this,"Headshot!",Toast.LENGTH_LONG).show();


            button1.setText(ScoreTeamA + "");
        } else if (team == "teamB" && score == "five") {
            ScoreTeamB=ScoreTeamB + 5;
            Toast.makeText(ScoresBoard.this,"Headshot!",Toast.LENGTH_LONG).show();
            button2.setText(ScoreTeamB + "");
        } else {

        }

    }

    public  void endgame()
    {
       String player1=CHANG.getText().toString().trim();
       String player2=HONG.getText().toString().trim();

            if (ScoreTeamB == ScoreTeamA) {
                Toast.makeText(ScoresBoard.this,"No winner",Toast.LENGTH_LONG).show();

            }
            else{

            }
            if (ScoreTeamA > ScoreTeamB)
            {
                chaw.setText(player1);
                BLUE.setVisibility(View.VISIBLE);
            }
            else {
               how.setText(player2);
                RED.setVisibility(View.VISIBLE);
            }
    }

    public void addOneFoul() {

        Foul=Foul + 1;


        if (Foul < 11)
        {

            player1.setText(Foul + "");
        }

        else
        {

        }


    }

    public void addOneFoul1() {

        Foul1=Foul1 + 1;


        if (Foul1 < 11)
        {

            player2.setText(Foul1 + "");
        }

        else
        {

        }


    }

}
