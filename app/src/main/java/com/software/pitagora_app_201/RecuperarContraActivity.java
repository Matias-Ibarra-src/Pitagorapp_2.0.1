package com.software.pitagora_app_201;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RecuperarContraActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recuperar_contra);

        final Button recuperar = (Button) findViewById(R.id.btn_recuperar);

        recuperar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent button1 = new Intent(RecuperarContraActivity.this,CambioContraActivity.class);
                startActivity(button1);
            }
        });
    }
}