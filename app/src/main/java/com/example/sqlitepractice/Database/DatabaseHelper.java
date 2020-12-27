package com.example.sqlitepractice.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "Products.db";
    private static final String TABLE_NAME = "Products_Details";
    private static final int VERSION_NUMBER = 11;
    private static final String products_name = "Name";
    private static final String ID = "id";
    private static final String description = "Description";
    private static final String price = "Price";
    private static final String PRODUCT_MODEL = "Model";


   // private static final String CREATE_TABLE = "CREATE TABLE "+TABLE_NAME+"("+id+"INTEGER PRIMARY KEY AUTOINCREMENT,"+products_name+" VARCHAR(255), "+description+" VARCHAR(255) ,"+price+" INTEGER)";
  //  private static final String CREATE_TABLE2 = "create Table "+TABLE_NAME+"("+id+"INTEGER PRIMARY KEY AUTOINCREMENT,"+products_name+" VARCHAR(255), "+description+" VARCHAR(255) ,"+price+" INTEGER)";

    private static final String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;
    private static final String SELECT_ALL = "SELECT * FROM " + TABLE_NAME;

  private Context context;


    public DatabaseHelper( Context context) {
        super(context,DATABASE_NAME,null,VERSION_NUMBER);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        try {
            Toast.makeText(context,"on create",Toast.LENGTH_LONG).show();
           // db.execSQL(CREATE_TABLE);
          //  db.execSQL("create Table "+TABLE_NAME+"(\"+id+\"INTEGER PRIMARY KEY AUTOINCREMENT,"+products_name+" VARCHAR(255), "+description+" VARCHAR(255) ,"+price+" INTEGER)");
            db.execSQL("create Table "+TABLE_NAME+"("+ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"+products_name+" VARCHAR(255), "+description+" VARCHAR(255) ,"+price+" INTEGER)");
           // db.execSQL("create Table "+TABLE_NAME+"(\"+id+\"INTEGER PRIMARY KEY AUTOINCREMENT,"+products_name+" VARCHAR(255), "+description+" VARCHAR(255) ,"+price+" INTEGER,"+PRODUCT_MODEL+" VARCHAR(255) PRIMARY KEY)");

        }catch (Exception e){
            System.out.println(e);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        try{
            Toast.makeText(context,"on Upgrade",Toast.LENGTH_LONG).show();
            db.execSQL(DROP_TABLE);
            onCreate(db);
        }catch (Exception e){
            Toast.makeText(context,"sdsa +"+e,Toast.LENGTH_LONG).show();
        }

    }


    public Cursor displayData(){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        Cursor cursor =  sqLiteDatabase.rawQuery(SELECT_ALL,null);
        return  cursor;

    }



    public long insertData(String name, String description, int price){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(this.products_name, name);
        contentValues.put(this.description, description);
        contentValues.put(this.price, price);


        long rowId = sqLiteDatabase.insert(TABLE_NAME,null,contentValues);
        return rowId;

    }


    public boolean updateData(String name, String description, int price,String id){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(this.products_name, name);
        contentValues.put(this.description, description);
        contentValues.put(this.price, price);
        contentValues.put(this.ID, id);
        sqLiteDatabase.update(TABLE_NAME,contentValues,ID +" = ?",new String[]{id});
         return true;
    }



    
}
