package com.software.pitagora_app_201;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.software.pitagora_app_201.model.Persona;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class RegisterActivity extends AppCompatActivity {

    EditText nomP, appP,correoP,passwordP, numP;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        nomP = findViewById(R.id.text_Nombre);
        appP = findViewById(R.id.text_Apellido);
        numP = findViewById(R.id.text_Numero);
        correoP = findViewById(R.id.text_correo_registro);
        passwordP = findViewById(R.id.text_contraseña_registro);

        inicializarFirebase();
    }

    private void inicializarFirebase() {
        FirebaseApp.initializeApp(this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
    }

    private void cargarDatosFirebase(String nombre, String apellido, String telefono, String direccion) {
        inicializarFirebase();

        Map<String, Object> datosUsuario = new HashMap<>();
        datosUsuario.put("nombre", nombre);
        datosUsuario.put("apellido", apellido);
        datosUsuario.put("telefono", telefono);
        datosUsuario.put("direccion", direccion);

        databaseReference.child("users").push().setValue(datosUsuario);
    }

    private void limpiarCajas() {
        nomP.setText("");
        correoP.setText("");
        passwordP.setText("");
        numP.setText("");
        appP.setText("");
    }

    public void onClick(View v) {

        switch(v.getId()){

            case R.id.btn_register:

                String nombre = nomP.getText().toString();
                String apellido = appP.getText().toString();
                String telefono = numP.getText().toString();
                String direccion = correoP.getText().toString();
                cargarDatosFirebase(nombre, apellido, telefono, direccion);
                Toast.makeText(this, "Agregado", Toast.LENGTH_LONG).show();
                limpiarCajas();
                break;
        }

    }

    //LO QUE HICIMOS AYER 

    /*
    package com.software.pitagora_app_201;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.software.pitagora_app_201.model.Persona;

import java.util.UUID;

public class RegisterActivity extends AppCompatActivity {

    EditText nomP, appP,correoP,passwordP, numP;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        nomP = findViewById(R.id.text_Nombre);
        appP = findViewById(R.id.text_Apellido);
        numP = findViewById(R.id.text_Numero);
        correoP = findViewById(R.id.text_correo_registro);
        passwordP = findViewById(R.id.text_contraseña_registro);

    }

    private void inicializarFirebase() {
        FirebaseApp.initializeApp(this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
    }

    public void registro(View view) {
        inicializarFirebase();

        String nombre = nomP.getText().toString();
        String correo = correoP.getText().toString();
        String password = passwordP.getText().toString();
        String numero = numP.getText().toString();
        String app = appP.getText().toString();


        if (nombre.equals("") || correo.equals("") || password.equals("") || app.equals("")) {
            validacion();
        } else {
            Persona p = new Persona();
            p.setLocalid(UUID.randomUUID().toString());
            p.setNombre(nombre);
            p.setApellido(app);
            p.setNumero(numero);
            p.setCorreo(correo);
            p.setPassword(password);
            validacionBD(p);
        }
    }

    private void limpiarCajas() {
        nomP.setText("");
        correoP.setText("");
        passwordP.setText("");
        numP.setText("");
        appP.setText("");
    }

    private void validacionBD(Persona p){
        databaseReference.child("users").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot objSnaptshot : dataSnapshot.getChildren()){
                   Persona persona = objSnaptshot.getValue(Persona.class);
                   if(persona.getCorreo().equals(p.getCorreo())){
                       //Toast.makeText(this, "Correo ya registrado", Toast.LENGTH_LONG).show();
                       limpiarCajas();
                   }else{
                       if(persona.getNumero().equals(p.getNumero())){
                           //Toast.makeText(this, "Numero ya registrado", Toast.LENGTH_LONG).show();
                           limpiarCajas();
                       }
                   }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {}
        });

        if (p.getNombre().equals("")){
        }else if( p.getCorreo().equals("")){
        }else if( p.getNumero().equals("")){
        }else{
            databaseReference.child("users").push().setValue(p);
            Toast.makeText(this, "Agregado", Toast.LENGTH_LONG).show();
            limpiarCajas();
        }
    }

    private void validacion() {
        String nombre = nomP.getText().toString();
        String correo = correoP.getText().toString();
        String password = passwordP.getText().toString();
        String numero = numP.getText().toString();
        String app = appP.getText().toString();
        if (nombre.equals("")){
            nomP.setError("Required");
        }
        if (nombre.equals("")){
            numP.setError("Required");
        }
        else if (app.equals("")){
            appP.setError("Required");
        }
        else if (correo.equals("")){
            correoP.setError("Required");
        }
        else if(numero.equals("")){
            numP.setError("Required");
        }
        else if (password.equals("")){
            passwordP.setError("Required");
        }
    }
}
     */
}