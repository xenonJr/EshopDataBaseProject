package com.example.sqlitepractice.Ativities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.sqlitepractice.Database.DatabaseHelper;
import com.example.sqlitepractice.GlobalClass.GlobalClass;
import com.example.sqlitepractice.R;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper databaseHelper;
    ImageView imageView;
    Button add, view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//        databaseHelper = new DatabaseHelper(this);
//
//        SQLiteDatabase sqLiteDatabase = databaseHelper.getWritableDatabase();

        GlobalClass.setDatabase(getApplicationContext());

        add = findViewById(R.id.add_product_button);
        view = findViewById(R.id.view_product);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),AddProductActivity.class));
            }
        });

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),VIewProdcts.class));
            }
        });










    }
}
