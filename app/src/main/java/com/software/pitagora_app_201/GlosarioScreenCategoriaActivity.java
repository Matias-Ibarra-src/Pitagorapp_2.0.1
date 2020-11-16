package com.software.pitagora_app_201;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class GlosarioScreenCategoriaActivity extends AppCompatActivity {
    TextView contenido;
    TextView titulo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.glosario_screen_categoria);
        titulo = (TextView) findViewById(R.id.titulo_selccionado);
        contenido = (TextView) findViewById(R.id.text_text);
        recogerExtras();
    }
    public void recogerExtras() {
        //Aquí recogemos y tratamos los parámetros
        Bundle extras= getIntent().getExtras();
        String datox= extras.getString("dato1");
        String datoy= extras.getString("dato2");
        titulo.setText(datoy);
        contenido.setText(datox);
    }


}