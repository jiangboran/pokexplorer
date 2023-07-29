package com.example.my_app.login;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.HashMap;
import java.util.Map;


public class UserService {
    private DatabaseHelper dbHelper;

    public UserService(Context context) {
        dbHelper = new DatabaseHelper(context);
    }

    public boolean login(String username, String password) {
        SQLiteDatabase sdb = dbHelper.getReadableDatabase();
        String sql = "select * from user where username=? and password=?";
        Cursor cursor = sdb.rawQuery(sql, new String[]{username, password});
        if (cursor.moveToFirst() == true) {
            cursor.close();
            sdb.close();
            return true;
        }
        return false;
    }

    public boolean register(User user) {
        SQLiteDatabase sdb = dbHelper.getReadableDatabase();
        String sql = "insert into user(username,password,age,phone,sex,photo) values(?,?,?,?,?,?)";
        Object obj[] = {user.getUsername(), user.getPassword(), user.getAge(), user.getPhone(), user.getSex(), user.getPhoto()};
        sdb.execSQL(sql, obj);
        sdb.close();
        return true;
    }

    //用户名查重
    public boolean check(String username) {
        SQLiteDatabase sdb = dbHelper.getReadableDatabase();
        String sql = "select * from user where username=?";
        Cursor cursor = sdb.rawQuery(sql, new String[]{username});
        if (cursor.moveToFirst() == true) {
            cursor.close();
            sdb.close();
            return true;
        }
        return false;
    }

    //查询性别
    public String gender() {
        SQLiteDatabase sdb = dbHelper.getReadableDatabase();
        String sql = "select sex from user where username=?";
        Cursor cursor = sdb.rawQuery(sql, new String[]{LoginActivity.name});
        cursor.moveToFirst();
        String gender = cursor.getString(0);
        cursor.close();
        sdb.close();
        return gender;
    }

    //查询年龄
    public String age() {
        SQLiteDatabase sdb = dbHelper.getReadableDatabase();
        String sql = "select age from user where username=?";
        Cursor cursor = sdb.rawQuery(sql, new String[]{LoginActivity.name});
        cursor.moveToFirst();
        String age = cursor.getString(0);
        cursor.close();
        sdb.close();
        return age;
    }

    //获取用户信息
    public Map get_userinfo(String username) {
        String sex;
        String phone;
        String photo;
        int age;
        Map<String, String> info = new HashMap<>();
        SQLiteDatabase sdb = dbHelper.getReadableDatabase();
        String sql = "select * from user where username=?";
        Cursor cursor = sdb.rawQuery(sql, new String[]{username});
        cursor.moveToFirst();
        age = cursor.getInt(cursor.getColumnIndexOrThrow("age"));
        sex = cursor.getString(cursor.getColumnIndexOrThrow("sex"));
        phone = cursor.getString(cursor.getColumnIndexOrThrow("phone"));
        photo = cursor.getString(cursor.getColumnIndexOrThrow("photo"));
        info.put("username", username);
        info.put("age", Integer.toString(age));
        info.put("sex", sex);
        info.put("phone", phone);
        info.put("photo", photo);
        cursor.close();
        sdb.close();
        return info;
    }

    //修改头像
    public void update_photo(String username, String value) {
        SQLiteDatabase sdb = dbHelper.getReadableDatabase();
        String sql = "update  user  set photo = ? where username = ?";
        sdb.execSQL(sql,new String[]{value,username} );
        sdb.close();
    }


}
