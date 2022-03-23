package com.example.card_quiz_game;

import android.os.Handler;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

public class Splash extends AppCompatActivity {
    LuncherManager luncherManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManger.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
                setContentView(R.layout.activity_splash);

                luncherManager = new LuncherManger(this);

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if(luncherManager.isFirstTime()){
                            luncherManager.setFirstLunch(false);
                            startActivity(onNewIntent(getApplicationContext(),Slider.class)));
                        }else{
                            startActivity(newIntent(getApplicationContext(),MainActivity.class));
                        }
                    }
                }
    }

    }




