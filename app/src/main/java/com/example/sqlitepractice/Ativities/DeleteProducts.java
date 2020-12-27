package com.example.sqlitepractice.Ativities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sqlitepractice.R;

import static com.example.sqlitepractice.GlobalClass.GlobalClass.productDatabase;

public class DeleteProducts extends AppCompatActivity {

    EditText  id_text;
    Button delete;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_products);

        id_text = findViewById(R.id.id_to_delete);
        delete = findViewById(R.id.Delete_Product_button);

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = id_text.getText().toString();
                int is_deleted = productDatabase.deleteData(id);

                if(is_deleted>0){
                    Toast.makeText(DeleteProducts.this, "Product Deleted", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(DeleteProducts.this, "Product Not Deleted", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}