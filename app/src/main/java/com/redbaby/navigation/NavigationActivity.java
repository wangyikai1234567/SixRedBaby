package com.redbaby.navigation;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.redbaby.R;

public class NavigationActivity extends AppCompatActivity {
    private Handler mHandler=new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(NavigationActivity.this, BabyInfoActivity.class);
                startActivity(intent);
                finish();
            }
        }, 3000);
    }
}
