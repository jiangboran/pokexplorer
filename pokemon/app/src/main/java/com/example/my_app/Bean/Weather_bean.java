package com.example.my_app.Bean;

public class Weather_bean {
    private String weather;
    private int wea_img;
    public Weather_bean(String weather, int wea_img){
        this.weather = weather;
        this.wea_img = wea_img;
    }

    public String getWeather(){
        return weather;
    }

    public int getWea_img(){
        return wea_img;
    }
}
