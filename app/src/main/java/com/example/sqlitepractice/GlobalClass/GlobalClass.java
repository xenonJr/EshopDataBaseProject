package com.example.sqlitepractice.GlobalClass;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.sqlitepractice.Database.DatabaseHelper;

public class GlobalClass {
    public static DatabaseHelper databaseHelper;
    public static void setDatabase(Context context){
        databaseHelper = new DatabaseHelper(context);
        SQLiteDatabase sqLiteDatabase = databaseHelper.getWritableDatabase();
    }
}
