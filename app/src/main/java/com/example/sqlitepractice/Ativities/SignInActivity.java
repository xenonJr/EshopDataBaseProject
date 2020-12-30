package com.example.sqlitepractice.Ativities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sqlitepractice.R;

import static com.example.sqlitepractice.GlobalClass.GlobalClass.userDatabase;

public class SignInActivity extends AppCompatActivity {

    EditText username,pass;
    Button back,signIn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        username = findViewById(R.id.username_sign_up);
        pass = findViewById(R.id.password_sign_in);
        back = findViewById(R.id.cancel_sign_in);
        signIn = findViewById(R.id.sign_in_button);


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),SignUpActivity.class));
            }
        });

        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String given_username = username.getText().toString();
                String given_pass = pass.getText().toString();

                boolean canSignIn = userDatabase.canSignIn(given_username,given_pass);

                if(canSignIn==true){
                    startActivity(new Intent(getApplicationContext(),HomePageUser.class));
                }else {
                    Toast.makeText(SignInActivity.this, "Wrong username or password", Toast.LENGTH_SHORT).show();
                }

            }
        });



    }
}