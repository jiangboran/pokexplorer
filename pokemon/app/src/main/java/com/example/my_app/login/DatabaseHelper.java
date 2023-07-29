package com.example.my_app.login;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String name="user.db";//自定义的数据库名
    private static final int dbVersion=1;//版本号
    public DatabaseHelper(Context context) {
        super(context, name, null, dbVersion);
    }
    //该方法会自动调用，首先系统会检查该程序中是否存在数据库名为‘user’的数据库，如果存在则不会执行该方法，如果不存在则会执行该方法。
    public void onCreate(SQLiteDatabase db) {
        String sql="create table user(" +
                "id integer primary key autoincrement," +
                "username varchar(20)," +
                "password varchar(20)," +
                "age integer," +
                "phone varchar(20)," +
                "photo varchar(100)," +
                "sex varchar(2))";
        db.execSQL(sql);
    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
