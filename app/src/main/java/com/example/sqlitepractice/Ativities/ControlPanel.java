package com.example.sqlitepractice.Ativities;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.sqlitepractice.Database.ProductDatabase;
import com.example.sqlitepractice.GlobalClass.GlobalClass;
import com.example.sqlitepractice.R;

import static com.example.sqlitepractice.GlobalClass.GlobalClass.productDatabase;
import static com.example.sqlitepractice.GlobalClass.GlobalClass.userDatabase;

public class ControlPanel extends AppCompatActivity {

    ProductDatabase productDatabase;
    ImageView imageView;
    Button add, view,delete,update,showUser,viewOrders,switchR;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        GlobalClass.setProductDatabase(getApplicationContext());

        add = findViewById(R.id.add_product_button);
        view = findViewById(R.id.view_product);
        delete = findViewById(R.id.deletebutton);
        update = findViewById(R.id.updateButton);
        showUser = findViewById(R.id.userDetails);
        viewOrders = findViewById(R.id.view_orders);
        switchR = findViewById(R.id.swithRole);

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


        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),UpdateProducts.class));
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),DeleteProducts.class));
            }
        });

        switchR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),MasterActivity.class));
            }
        });

        showUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Cursor cursor =  userDatabase.displayData();

                if(cursor.getCount() == 0){
                    showData("Error","No Data");
                    return;
                }else{
                    StringBuffer stringBuffer = new StringBuffer();

                    while (cursor.moveToNext()){
                        stringBuffer.append("ID : "+cursor.getString(0)+"\n");
                        stringBuffer.append(" Full Name : "+cursor.getString(1)+"\n");
                        stringBuffer.append("Username : "+cursor.getString(2)+"\n");
                        stringBuffer.append("Address : "+cursor.getString(3)+"\n");
                        stringBuffer.append("Email : "+cursor.getString(4)+"\n");
                        stringBuffer.append("Password : "+cursor.getString(5)+"\n");

                    }
                    showData("Results",stringBuffer.toString());
                }


            }
        });


        viewOrders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(getApplicationContext(),ViewOrders.class));

            }
        });



    }





    private void showData(String title, String resultSet) {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle(title);
        builder.setMessage(resultSet);
        builder.setCancelable(true);
        builder.show();


    }
}
