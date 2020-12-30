package com.example.sqlitepractice.Adapters;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sqlitepractice.GlobalClass.GlobalClass;
import com.example.sqlitepractice.Models.Product;
import com.example.sqlitepractice.R;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {


    Context context;
    List<Product> products ;

    public MyAdapter(Context context, List<Product> products) {
        this.context = context;
        this.products = products;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(context);
        View view=layoutInflater.inflate(R.layout.product_card,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.textViewNAME.setText(products.get(position).getName());
        holder.product_price.setText(products.get(position).getPrice());
        holder.product_description.setText(products.get(position).getDescription());

        holder.addToCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GlobalClass.globalProductList.add(products.get(position));
                Toast.makeText(context, products.get(position).getName() +" Added to the Cart", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textViewNAME,product_description,product_price;
        ImageView addToCard;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewNAME = itemView.findViewById(R.id.product_name_card);
            addToCard = itemView.findViewById(R.id.order_now);
            product_description = itemView.findViewById(R.id.product_des_card);
            product_price=itemView.findViewById(R.id.price);

        }
    }
}
