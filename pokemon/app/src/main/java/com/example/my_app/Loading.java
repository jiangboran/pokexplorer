package com.example.my_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

public class Loading extends AppCompatActivity {


    private ImageView loading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);
        //加载动画
        RotateAnimation animaRotate = new RotateAnimation(0f, 360f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        loading = (ImageView) findViewById(R.id.loading_img);
        animaRotate.setDuration(500);    //持续时间
        loading.startAnimation(animaRotate);

        handler.sendEmptyMessageDelayed(0, 500);
        Intent intent = new Intent(Loading.this, MainActivity.class);
//        startActivity(intent);


    }

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            Intent intent = new Intent(Loading.this, WeatherActivity.class);
            startActivity(intent);
            finish();
            super.handleMessage(msg);
        }
    };
}