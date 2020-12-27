package com.example.sqlitepractice.Ativities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sqlitepractice.R;

import static com.example.sqlitepractice.GlobalClass.GlobalClass.productDatabase;

public class AddProductActivity extends AppCompatActivity {

    //variables

   // DatabaseHelper databaseHelper;
    EditText name, id, description, price;
    Button add_prodct;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);

        //initializing components
        name = findViewById(R.id.id_to_delete);
        id = findViewById(R.id.id);
        description = findViewById(R.id.description);
        price = findViewById(R.id.price);
        add_prodct = findViewById(R.id.add_product);



        add_prodct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String given_name = name.getText().toString();
                String given_description = description.getText().toString();
                int given_price = 6;

                try{
                    given_price = Integer.parseInt(price.getText().toString());
                } catch(NumberFormatException ex){ // handle your exception

                }


                int finalGiven_price = given_price;


                long rowId = productDatabase.insertData(given_name,given_description, finalGiven_price);
                if(rowId ==-1){
                    Toast.makeText(AddProductActivity.this, "Failed", Toast.LENGTH_SHORT).show();
                }else {
                    Log.d("info",given_name);
                    Log.d("info",given_description);
                    Toast.makeText(AddProductActivity.this, given_name+" Added Successfully", Toast.LENGTH_SHORT).show();

                }


            }
        });




    }
}