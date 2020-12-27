package com.example.sqlitepractice.Ativities;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;

import com.example.sqlitepractice.R;

import static com.example.sqlitepractice.GlobalClass.GlobalClass.productDatabase;

public class VIewProdcts extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_v_iew_prodcts);


        Cursor cursor =  productDatabase.displayData();

        if(cursor.getCount() == 0){
            showData("Error","No Data");
            return;
        }else{
            StringBuffer stringBuffer = new StringBuffer();

            while (cursor.moveToNext()){
                stringBuffer.append("ID : "+cursor.getString(0)+"\n");
                stringBuffer.append("Name : "+cursor.getString(1)+"\n");
                stringBuffer.append("Description : "+cursor.getString(2)+"\n");
                stringBuffer.append("Price : "+cursor.getString(3)+"\n");

            }
            showData("Results",stringBuffer.toString());
        }


    }

    private void showData(String title, String resultSet) {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle(title);
        builder.setMessage(resultSet);
        builder.setCancelable(true);
        builder.show();


    }
}