package com.software.pitagora_app_201;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class GlosarioInicioActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.glosario_inicio);

        Button btn_1 = (Button) findViewById(R.id.btn_numeros);
        Button btn_2 = (Button) findViewById(R.id.btn_geometria);
        Button btn_3 = (Button) findViewById(R.id.btn_algebra);
        Button btn_4 = (Button) findViewById(R.id.btn_Probabilidad);

        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), SubcategoriasScreenGlosarioActivity.class);
                intent.putExtra("id","btn_numeros");
                startActivityForResult(intent, 0);
            }
        });

        btn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), SubcategoriasScreenGlosarioActivity.class);
                intent.putExtra("id","btn_geometria");
                startActivityForResult(intent, 0);
            }
        });

        btn_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), SubcategoriasScreenGlosarioActivity.class);
                intent.putExtra("id","btn_algebra");
                startActivityForResult(intent, 0);
            }
        });

        btn_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), SubcategoriasScreenGlosarioActivity.class);
                intent.putExtra("id","btn_probabilidad");
                startActivityForResult(intent, 0);
            }
        });
    }
}