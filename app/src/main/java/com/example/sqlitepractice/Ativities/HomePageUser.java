package com.example.sqlitepractice.Ativities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.example.sqlitepractice.Adapters.MyAdapter;
import com.example.sqlitepractice.GlobalClass.GlobalClass;
import com.example.sqlitepractice.Models.Order;
import com.example.sqlitepractice.Models.Product;
import com.example.sqlitepractice.R;

import java.util.ArrayList;
import java.util.List;

import static com.example.sqlitepractice.GlobalClass.GlobalClass.orderDatabase;
import static com.example.sqlitepractice.GlobalClass.GlobalClass.productDatabase;

public class HomePageUser extends AppCompatActivity {


    RecyclerView recyclerView;
    Button confirm,sr;
    List<Product> allProducts;
    List<String> productNames;
    MyAdapter myAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page_user);


        GlobalClass.setProductDatabase(getApplicationContext());

        GlobalClass.setUserDatabase(this);

        recyclerView = findViewById(R.id.product_Recycle_View);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        confirm = findViewById(R.id.confirm_order);
        sr = findViewById(R.id.swithRole);


        sr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),MasterActivity.class));
            }
        });

        allProducts = new ArrayList<>();
        productNames = new ArrayList<>();

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
                productNames.add(Name);
                allProducts.add(product);

            }

        }

        myAdapter = new MyAdapter(getApplicationContext(),allProducts);
        recyclerView.setAdapter(myAdapter);


        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Order order = new Order(GlobalClass.globalProductList,GlobalClass.currentUser);
                GlobalClass.orderList.add(order);
//                orderDatabase.insertData(productNames,GlobalClass.currentUser);
             //   startActivity(new Intent(getApplicationContext(),ViewOrders.class));
                Log.d("product","total order"+GlobalClass.orderList.get(0).getUser());
                Toast.makeText(HomePageUser.this, "Order Done Successfully", Toast.LENGTH_SHORT).show();
            }
        });





    }
}