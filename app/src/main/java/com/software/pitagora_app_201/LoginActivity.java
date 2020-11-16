package com.software.pitagora_app_201;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoginActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        final Button login = (Button) findViewById(R.id.btn_login);
        final Button to_register = (Button) findViewById(R.id.btn_to_register);
        final Button recuperar = (Button) findViewById(R.id.btn_olvide_contra);

        login.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent button1 = new Intent(LoginActivity.this,MainActivity.class);
                startActivity(button1);
            }
        });

        to_register.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent button2 = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(button2);
            }
        });

        recuperar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent button2 = new Intent(LoginActivity.this, RecuperarContraActivity.class);
                startActivity(button2);
            }
        });
    }
}