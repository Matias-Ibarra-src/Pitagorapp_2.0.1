package com.software.pitagora_app_201;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CambioContraActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cambio_contra);

        final Button cambio = (Button) findViewById(R.id.btn_cambiar_contra);

        cambio.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent button1 = new Intent(CambioContraActivity.this,MainActivity.class);
                startActivity(button1);
            }
        });
    }
}