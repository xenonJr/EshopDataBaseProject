package com.example.sqlitepractice.Ativities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sqlitepractice.R;

import static com.example.sqlitepractice.GlobalClass.GlobalClass.databaseHelper;

public class UpdateProducts extends AppCompatActivity {


    EditText name, id_text, description, price;
    Button update_product;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_products);


        name = findViewById(R.id.name);
        id_text = findViewById(R.id.id_input);
        description = findViewById(R.id.description);
        price = findViewById(R.id.price);
        update_product = findViewById(R.id.add_product);


        update_product.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String given_name = name.getText().toString();
                String given_description = description.getText().toString();
                String id = id_text.getText().toString();
                int given_price = 6;
                int id_no = 99;

                try{
                    given_price = Integer.parseInt(price.getText().toString());
                    id_no = Integer.parseInt(id_text.getText().toString());
                } catch(NumberFormatException ex){ // handle your exception

                }


                int finalGiven_price = given_price;
                int finalid_No = id_no;

                boolean is_Updated = databaseHelper.updateData(given_name,given_description, finalGiven_price,id);

                if(is_Updated == true){
                    Toast.makeText(UpdateProducts.this, "Product Updated", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(UpdateProducts.this, "Failed", Toast.LENGTH_SHORT).show();
                }




            }
        });


    }
}