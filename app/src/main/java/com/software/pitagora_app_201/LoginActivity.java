package com.software.pitagora_app_201;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoginActivity extends AppCompatActivity {
    //modificacion 2
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        //Boton registro
        final Button button1 = (Button) findViewById(R.id.button3);
        final Button button2 = (Button) findViewById(R.id.button2);

        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent button1 = new Intent(LoginActivity.this,MainActivity.class);
                startActivity(button1);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent button2 = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(button2);
            }
        });
    }
}