package com.example.sqlitepractice.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import com.example.sqlitepractice.GlobalClass.GlobalClass;
import com.example.sqlitepractice.Models.User;

import static com.example.sqlitepractice.GlobalClass.GlobalClass.productDatabase;

public class UserDatabase extends SQLiteOpenHelper {

    //global vars
    private static final int VERSION_NUMBER = 11;


    //database of user
    private static final String USER_DATABASE_NAME = "User.db";
    private static final String USER_TABLE_NAME = "User_Details";
    private static final String USER_FULL_NAME = "Name";
    private static final String USERNAME = "Username";
    private static final String ADDRESS = "Address";
    private static final String EMAIL = "Email";
    private static final String PASSWORD = "Password";
    private static final String DROP_USER_TABLE = "DROP TABLE IF EXISTS " + USER_TABLE_NAME;
    private static final String SELECT_ALL_USER = "SELECT * FROM " + USER_TABLE_NAME;
    private static final String ID = "id";


    private static final String CREATE_USER_TABLE = "create Table "+USER_TABLE_NAME+"("+ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"+USER_FULL_NAME+" VARCHAR(255)" +
                                                    ", "+USERNAME+" VARCHAR(255) " +
                                                    ","+ADDRESS+" VARCHAR(255) "+
                                                    ","+EMAIL+" VARCHAR(255) "+
                                                    ","+PASSWORD+" VARCHAR(255))";


    private Context context;


    public UserDatabase(Context context) {
        super(context,USER_DATABASE_NAME,null,VERSION_NUMBER);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        try {
            Toast.makeText(context,"on create for user",Toast.LENGTH_LONG).show();
            db.execSQL(CREATE_USER_TABLE);




        }catch (Exception e){
            System.out.println(e);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        try{
            Toast.makeText(context,"on Upgrade for user",Toast.LENGTH_LONG).show();
            db.execSQL(DROP_USER_TABLE);
            onCreate(db);
        }catch (Exception e){
            Toast.makeText(context,"sdsa +"+e,Toast.LENGTH_LONG).show();
        }

    }


    public Cursor displayData(){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        Cursor cursor =  sqLiteDatabase.rawQuery(SELECT_ALL_USER,null);
        return  cursor;

    }



    public long insertData(String name, String address, String username,String email,String password){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(USER_FULL_NAME, name);
        contentValues.put(USERNAME, username);
        contentValues.put(ADDRESS, address);
        contentValues.put(EMAIL, email);
        contentValues.put(PASSWORD, password);


        long rowId = sqLiteDatabase.insert(USER_TABLE_NAME,null,contentValues);
        return rowId;

    }


    public boolean updateData(String name, String address, String username,String email,String password,String id){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(USER_FULL_NAME, name);
        contentValues.put(USERNAME, username);
        contentValues.put(ADDRESS, address);
        contentValues.put(EMAIL, email);
        contentValues.put(PASSWORD, password);
        contentValues.put(ID, id);
        sqLiteDatabase.update(USER_TABLE_NAME,contentValues,ID +" = ?",new String[]{id});
        return true;
    }

    public Integer deleteData(String id){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        return sqLiteDatabase.delete(USER_TABLE_NAME,ID+" = ?",new String[]{id});
    }


    public boolean canSignIn(String uname,String pass){
        boolean result = false;

        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor =  sqLiteDatabase.rawQuery("SELECT * FROM "+USER_TABLE_NAME,null);

        if(cursor.getCount() == 0){
            Toast.makeText(context, "No Data Found", Toast.LENGTH_SHORT).show();

        }else{
            StringBuffer stringBuffer = new StringBuffer();

            while (cursor.moveToNext()){

                String un = cursor.getString(2);
                String pa = cursor.getString(5);

                String id = cursor.getString(0);
                String  name = cursor.getString(1);
                String add = cursor.getString(3);
                String mail = cursor.getString(4);

                if(uname.equals(un) && pass.equals(pa)){
                    GlobalClass.currentUser = new User(name,un,add,mail,pa);
                    result = true;
                    break;
                }

            }

        }



        return  result;
    }


}
