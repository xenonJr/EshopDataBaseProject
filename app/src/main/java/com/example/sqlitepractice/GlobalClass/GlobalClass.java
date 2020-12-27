package com.example.sqlitepractice.GlobalClass;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.sqlitepractice.Database.ProductDatabase;
import com.example.sqlitepractice.Database.UserDatabase;

public class GlobalClass {

    //database vars
    public static ProductDatabase productDatabase;
    public static UserDatabase userDatabase;

    //setting up database
    public static void setProductDatabase(Context context){
        productDatabase = new ProductDatabase(context);
        SQLiteDatabase sqLiteDatabase = productDatabase.getWritableDatabase();
    }

    public static void setUserDatabase(Context context){
        userDatabase = new UserDatabase(context);
        SQLiteDatabase sqLiteDatabase = userDatabase.getWritableDatabase();
    }
}
