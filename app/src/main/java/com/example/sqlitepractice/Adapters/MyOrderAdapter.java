package com.example.sqlitepractice.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sqlitepractice.GlobalClass.GlobalClass;
import com.example.sqlitepractice.Models.Order;
import com.example.sqlitepractice.Models.Product;
import com.example.sqlitepractice.Models.User;
import com.example.sqlitepractice.R;

import java.util.List;

public class MyOrderAdapter extends RecyclerView.Adapter<MyOrderAdapter.ViewHolder> {


    Context context;
    List<Order> orderList;


    public MyOrderAdapter(Context context, List<Order> orderList) {
        this.context = context;
        this.orderList = orderList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(context);
        View view= layoutInflater.inflate(R.layout.order_list,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyOrderAdapter.ViewHolder holder, int position) {
      Toast.makeText(context, "i am here tooooo", Toast.LENGTH_SHORT).show();
      holder.orderNo.setText("Order No : ");
      holder.userInfo.setText("User Name :"+orderList.get(position).getUser().getName() +"\n Address: "+orderList.get(position).getUser().getAddress());
      MyAdapter myAdapter = new MyAdapter(context,orderList.get(position).getOrderedProduct());
      holder.recyclerView.setLayoutManager(new LinearLayoutManager(context));
      holder.recyclerView.setAdapter(myAdapter);

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView orderNo,userInfo;
        RecyclerView recyclerView;
        public ViewHolder(@NonNull View itemView) {
           super(itemView);
           orderNo = itemView.findViewById(R.id.order_no);
           userInfo = itemView.findViewById(R.id.user_info);
           recyclerView = itemView.findViewById(R.id.productlist);

        }
    }
}