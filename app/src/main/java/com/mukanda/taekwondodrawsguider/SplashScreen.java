package com.mukanda.taekwondodrawsguider;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import com.google.firebase.auth.FirebaseAuth;

public class SplashScreen extends AppCompatActivity {

    private Handler handler;
    private Runnable runnable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        SharedPreferences sharedPreferences=this.getSharedPreferences("STORAGE",MODE_PRIVATE);
        if(sharedPreferences.getBoolean("IS_DARKMODE_ENABLED",false)){
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        }else{
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }
        handler=new Handler();
        runnable=new Runnable() {
            @Override
            public void run() {
                if(FirebaseAuth.getInstance().getCurrentUser()!=null && sharedPreferences.getString("USER_TYPE","NON").trim().equals("ATHLETE")){
                    SplashScreen.this.startActivity(new Intent(SplashScreen.this,AskOfficialPlayer.class));
                    SplashScreen.this.overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
                    SplashScreen.this.finish();
                }else if(FirebaseAuth.getInstance().getCurrentUser()!=null && sharedPreferences.getString("USER_TYPE","NON").trim().equals("COACH")){
                    SplashScreen.this.startActivity(new Intent(SplashScreen.this,AskOfficialPlayer.class));
                    SplashScreen.this.overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
                    SplashScreen.this.finish();
                }else{
                    SplashScreen.this.startActivity(new Intent(SplashScreen.this,AskOfficialPlayer.class));
                    SplashScreen.this.overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
                    SplashScreen.this.finish();
                }
            }
        };
        handler.postDelayed(runnable,2000);
    }

    @Override
    protected void onDestroy() {
        handler.removeCallbacks(runnable);
        super.onDestroy();
    }
}
