package com.example.my_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.my_app.Adapter.WeatherAdapter;
import com.example.my_app.Bean.Weather_bean;

import java.util.ArrayList;
import java.util.List;

public class WeatherActivity extends AppCompatActivity {

    private List<Weather_bean> weatherList = new ArrayList<>();//存储实例化的数据

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);


        //返回
        findViewById(R.id.back_button).setOnClickListener(new View.OnClickListener() {
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

}