package com.example.sqlitepractice.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import com.example.sqlitepractice.Models.User;

import java.util.List;

public class OrderDatabase extends SQLiteOpenHelper {
    //global vars
    private static final int VERSION_NUMBER = 11;


    //database of product
    private static final String DATABASE_NAME = "Orders.db";
    private static final String TABLE_NAME = "Order_Details";
    private static final String TABLE_LIST = "MyListItem";
    private static final String USER_FULL_NAME = "Name";
    private static final String USERNAME = "Username";
    private static final String ADDRESS = "Address";
    private static final String EMAIL = "Email";
    private static final String PASSWORD = "Password";
    private static final String ID = "id";

    // Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_ListItem = "listitem";

    String CREATE_LIST_TABLE = "CREATE TABLE " + TABLE_LIST + "(" + KEY_ID
            + " INTEGER," + KEY_ListItem + " TEXT" +ID+ "INTEGER PRIMARY KEY AUTOINCREMENT,"+USER_FULL_NAME+" VARCHAR(255)" +
            ", "+USERNAME+" VARCHAR(255) " +
            ","+ADDRESS+" VARCHAR(255) "+
            ","+EMAIL+" VARCHAR(255) "+
            ","+PASSWORD+" VARCHAR(255) )";





    private static final String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_LIST;
    private static final String SELECT_ALL = "SELECT * FROM " + TABLE_LIST;


    private Context context;


    public OrderDatabase(Context context) {
        super(context,DATABASE_NAME,null,VERSION_NUMBER);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        try {
            Toast.makeText(context,"on create",Toast.LENGTH_LONG).show();
          //  db.execSQL("create Table "+TABLE_NAME+"("+ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"+products_name+" VARCHAR(255), "+description+" VARCHAR(255) ,"+price+" INTEGER)");
            db.execSQL(CREATE_LIST_TABLE);



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



    public void insertData(List<String> listItem, User user){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        for (int i = 0; i < listItem.size(); i++) {

            Log.e("vlaue inserting==", "" + listItem.get(i));
            values.put(KEY_ListItem, listItem.get(i));
            db.insert(TABLE_LIST, null, values);

        }

        values.put(USER_FULL_NAME, user.getName());
        values.put(USERNAME, user.getUsername());
        values.put(ADDRESS, user.getAddress());
        values.put(EMAIL, user.getMail());
        values.put(PASSWORD, user.getPass());


         db.insert(TABLE_LIST,null,values);

    }




    public Integer deleteData(String id){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        return sqLiteDatabase.delete(TABLE_NAME,ID+" = ?",new String[]{id});
    }
}
