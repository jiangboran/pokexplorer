package com.example.my_app;

import com.example.my_app.Bean.News_bean;
import com.example.my_app.Bean.Video_bean;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class JsonParse {
    private static JsonParse instance;

    private JsonParse() {
    }

    public static JsonParse getInstance() {
        if (instance == null) {
            instance = new JsonParse();

        }
        return instance;
    }

    public List<News_bean> getNewsList(String json) {
        Gson gson = new Gson(); // 使用gson库解析JSON数据

        // 创建一个TypeToken的匿名子类对象，并调用对象的getType()方法

        Type listType = new TypeToken<List<News_bean>>() {
        }.getType();

        // 把获取到的信息集合存到shopList中

        List<News_bean> newsList = gson.fromJson(json.trim(), listType);
        return newsList;

    }

    public List<Video_bean> getVideoList(String json) {
        Gson gson = new Gson(); // 使用gson库解析JSON数据

        // 创建一个TypeToken的匿名子类对象，并调用对象的getType()方法

        Type listType = new TypeToken<List<Video_bean>>() {
        }.getType();

        // 把获取到的信息集合存到shopList中

        List<Video_bean> videoList = gson.fromJson(json.trim(), listType);
        System.out.print(videoList);
        return videoList;

    }

}
