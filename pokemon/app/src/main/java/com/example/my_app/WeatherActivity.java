package com.example.my_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.my_app.Adapter.WeatherAdapter;
import com.example.my_app.Bean.Weather_bean;
import com.example.my_app.Fragment.Frag_home;
import com.example.my_app.Fragment.Frag_user;
import com.example.my_app.Fragment.Frag_video;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class WeatherActivity extends AppCompatActivity {

    private List<Weather_bean> weatherList = new ArrayList<>();//存储实例化的数据
    private ImageView home;
    private ImageView video;
    private ImageView user;
    private ImageView weather;
    private Bundle bundle;
    public int frag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        home = findViewById(R.id.home);
        video = findViewById(R.id.video);
        user = findViewById(R.id.user);
        weather =findViewById(R.id.weather);

        //返回
        findViewById(R.id.back_button).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(WeatherActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.home).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(WeatherActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.video).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(WeatherActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.user).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(WeatherActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        addWeather();//添加weather信息
        RecyclerView recyclerView = findViewById(R.id.hour_wea);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);//添加布局管理器
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);  //设置为横向水平滚动
        recyclerView.setLayoutManager(layoutManager);//设置布局管理器
        WeatherAdapter adapter = new WeatherAdapter(weatherList);
        recyclerView.setAdapter(adapter);

    }

    private void addWeather() {
        Weather_bean now = new Weather_bean("现在", R.drawable.clear);
        weatherList.add(now);
        int wea[] = {R.drawable.clear,R.drawable.clear,R.drawable.rainy,R.drawable.cloudy};
        for (int i = 1; i < 12; i++) {
            Weather_bean last = new Weather_bean(i + "时", wea[i%4]);
            weatherList.add(last);
        }

    }
    public void turn_frag(View v) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        Frag_home f1 = new Frag_home();
        Frag_video f2 = new Frag_video();
        Frag_user f3 = new Frag_user();
        switch (v.getId()) {
            case R.id.home:
                if(frag != 1) {
                    ft.replace(R.id.frag, f1);
                    frag = 1;
                }
                break;
            case R.id.video:
                if(frag != 2) {
                    ft.replace(R.id.frag, f2);
                    frag = 2;
                }
                break;
            case R.id.user:
                if(frag != 3) {
                    ft.replace(R.id.frag, f3);
                    frag = 3;
                }
                break;
        }
        ft.commit();
    }

}