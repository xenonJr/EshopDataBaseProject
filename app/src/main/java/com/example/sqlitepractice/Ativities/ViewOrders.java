package com.example.sqlitepractice.Ativities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sqlitepractice.Adapters.MyAdapter;
import com.example.sqlitepractice.Adapters.MyOrderAdapter;
import com.example.sqlitepractice.GlobalClass.GlobalClass;
import com.example.sqlitepractice.Models.Order;
import com.example.sqlitepractice.R;

public class ViewOrders extends AppCompatActivity {


    RecyclerView recyclerView;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_list);


        TextView orderNo = findViewById(R.id.order_no);
        TextView userInfo = findViewById(R.id.user_info);
        recyclerView = findViewById(R.id.productlist);
        Order order = GlobalClass.orderList.get(0);
        orderNo.setText("Order List");
        userInfo.setText("Name: "+order.getUser().getName()+"\n Address: "+order.getUser().getAddress()+"\n Email: "+order.getUser().getMail());
        MyAdapter myAdapter = new MyAdapter(getApplicationContext(),GlobalClass.orderList.get(0).getOrderedProduct());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(myAdapter);


    }
}