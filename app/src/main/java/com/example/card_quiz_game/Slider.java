package com.example.card_quiz_game;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import androidx.viewpager.widget.ViewPager;

public class Slider {
    ViewPager viewPager;
    Button btnNext;
    int[] layouts;
    Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_slider);

        viewPager = findViewByld(R.id.pager);
        btnNext = findViewByld(R.id.nextBtn);

        layouts = new int[] {
        R.layout.slider1,
        R.layout.slider2,
        R.layout.slider3
        };

        adapter = new Adapter(this.layouts);
        viewPager.setAdapter(adapter);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (viewPager.getCurrentItem() + 1 < layouts.length) {
                    viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
                } else {
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                }
            }
        }}};

        ViewPager.OnPageChangeListener viewPagerChangeListener = new
                ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

        }
            @Override
            public void onPageSelected(int i){
        if(i==layouts.length-1){
        btnNext.setText("Continue");
        }else{
        btnNext.setText("Next");
        }
        }
    @Override
    public void onPageScrollStateChanged(int i) {
        }
    };
        }



