package com.example.sqlitepractice.GlobalClass;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.sqlitepractice.Database.OrderDatabase;
import com.example.sqlitepractice.Database.ProductDatabase;
import com.example.sqlitepractice.Database.UserDatabase;
import com.example.sqlitepractice.Models.Product;

import java.util.ArrayList;
import java.util.List;

public class GlobalClass {

    //database vars
    public static ProductDatabase productDatabase;
    public static UserDatabase userDatabase;
    public static OrderDatabase orderDatabase;
    public static String currentUserId;
    public static List<Product> globalProductList = new ArrayList<>();

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
