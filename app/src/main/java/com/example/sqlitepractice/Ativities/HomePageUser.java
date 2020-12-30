package com.example.sqlitepractice.Ativities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Button;
import android.widget.PopupMenu;

import com.example.sqlitepractice.Adapters.MyAdapter;
import com.example.sqlitepractice.Models.Product;
import com.example.sqlitepractice.R;

import java.util.ArrayList;
import java.util.List;

import static com.example.sqlitepractice.GlobalClass.GlobalClass.productDatabase;

public class HomePageUser extends AppCompatActivity {


    RecyclerView recyclerView;
    Button confirm;
    List<Product> allProducts;
    MyAdapter myAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page_user);

        recyclerView = findViewById(R.id.product_Recycle_View);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        confirm = findViewById(R.id.confirm_order);

        allProducts = new ArrayList<>();

        Cursor cursor =  productDatabase.displayData();

        if(cursor.getCount() == 0){

            return;
        }else{
            StringBuffer stringBuffer = new StringBuffer();

            while (cursor.moveToNext()){
                String ID =cursor.getString(0);
                String Name = cursor.getString(1);
                String Description = cursor.getString(2);
                String Price = cursor.getString(3);

                Product product = new Product(ID,Name,Description,Price);
                allProducts.add(product);

            }

        }

        myAdapter = new MyAdapter(getApplicationContext(),allProducts);
        recyclerView.setAdapter(myAdapter);





    }
}