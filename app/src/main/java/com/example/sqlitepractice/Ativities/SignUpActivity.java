package com.example.sqlitepractice.Ativities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sqlitepractice.GlobalClass.GlobalClass;
import com.example.sqlitepractice.R;

import static com.example.sqlitepractice.GlobalClass.GlobalClass.productDatabase;
import static com.example.sqlitepractice.GlobalClass.GlobalClass.userDatabase;

public class SignUpActivity extends AppCompatActivity {



    EditText name,userName,address,mail,pass;
    Button gotoSIgnIn,signUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        GlobalClass.setUserDatabase(this);

        name = findViewById(R.id.name_sign_up);
        userName = findViewById(R.id.username_sign_up);
        address = findViewById(R.id.address_sign_up);
        mail = findViewById(R.id.email_sign_up);
        pass = findViewById(R.id.password_sign_in);
        gotoSIgnIn = findViewById(R.id.cancel_sign_in);
        signUp = findViewById(R.id.sign_in_button);


        gotoSIgnIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),SignInActivity.class));
            }
        });

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String given_name = name.getText().toString();
                String given_username = userName.getText().toString();
                String given_add = address.getText().toString();
                String given_mail = mail.getText().toString();
                String given_pass = pass.getText().toString();

                long rowId = userDatabase.insertData(given_name,given_add, given_username,given_mail,given_pass);
                if(rowId ==-1){
                    Toast.makeText(SignUpActivity.this, "Failed", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(SignUpActivity.this, given_name+" Added Successfully", Toast.LENGTH_SHORT).show();

                }

                startActivity(new Intent(getApplicationContext(), ControlPanel.class));
            }
        });



    }
}