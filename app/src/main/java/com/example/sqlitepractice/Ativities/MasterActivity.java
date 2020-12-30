package com.example.sqlitepractice.Ativities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.sqlitepractice.GlobalClass.GlobalClass;
import com.example.sqlitepractice.R;

public class MasterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_master);
        Button ad = findViewById(R.id.admin_button);
        Button cu = findViewById(R.id.customer_button);

        GlobalClass.setProductDatabase(getApplicationContext());

        GlobalClass.setUserDatabase(this);


        ad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),ControlPanel.class));
            }
        });

        cu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),SignUpActivity.class));
            }
        });
    }
}