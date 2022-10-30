package com.mukanda.taekwondodrawsguider;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    FrameLayout frameLayout;
    TextView textView1,textView2,textView3,textView4,textView;
    CardView cardView1,cardView2,cardView3,cardView4;
    BottomNavigationView bottom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("              Taekwondo Draws");
        frameLayout=(FrameLayout) findViewById(R.id.framelayout);
        bottom=(BottomNavigationView) findViewById(R.id.bottom);
        textView1=findViewById(R.id.registeredClub);
        textView2=findViewById(R.id.register);
        textView3=findViewById(R.id.viewDraw);
        textView4=findViewById(R.id.results);
        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,Userlist.class));
            }
        });
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,Weight_choice.class));
            }
        });
        textView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,ScoresBoard.class));
            }
        });
        textView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,DrawGenerator.class));
            }
        });


        frameLayout.setBackgroundResource(R.color.material);
        bottom.setOnNavigationItemReselectedListener(naviCustomListView);

    }

    private BottomNavigationView.OnNavigationItemReselectedListener naviCustomListView=new BottomNavigationView.OnNavigationItemReselectedListener() {
        @Override
        public void onNavigationItemReselected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.home:
                    textView.setText("Home");
                    frameLayout.setBackgroundResource(R.color.material);
                    break;
                case R.id.favorite:
                    textView.setText("Favorite");
                    frameLayout.setBackgroundResource(R.color.white);
                    break;
                case R.id.notification:
                    textView.setText("Notification");
                    frameLayout.setBackgroundResource(R.color.green);
                    break;
            }
        }
    };
}