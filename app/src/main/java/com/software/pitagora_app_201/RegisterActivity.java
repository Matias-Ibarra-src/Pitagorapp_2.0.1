package com.software.pitagora_app_201;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.software.pitagora_app_201.model.Persona;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class RegisterActivity extends AppCompatActivity {

    private List<Persona> listPerson = new ArrayList<Persona>();
    ArrayAdapter<Persona> arrayAdapterPersona;

    EditText nomP, appP,correoP,passwordP, numP;
    ListView listV_personas;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    Persona personaSelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nomP = findViewById(R.id.text_Nombre);
        appP = findViewById(R.id.text_Apellido);
        numP = findViewById(R.id.text_Numero);
        correoP = findViewById(R.id.text_correo_registro);
        passwordP = findViewById(R.id.text_contraseña_registro);

        //listV_personas = findViewById(R.id.lv_datosPersonas);
        inicializarFirebase();
        //listarDatos();
        /*listV_personas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                personaSelected = (Persona) parent.getItemAtPosition(position);
                nomP.setText(personaSelected.getNombre());
                appP.setText(personaSelected.getApellido());
                correoP.setText(personaSelected.getCorreo());
                passwordP.setText(personaSelected.getPassword());
            }
        });*/
    }

    private void inicializarFirebase() {
        FirebaseApp.initializeApp(this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
    }

    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return super.onCreateOptionsMenu(menu);
    }*/


    public void registro(View view) {
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
       /* @Override
        public boolean onOptionsItemSelected (MenuItem item){

            String nombre = nomP.getText().toString();
            String correo = correoP.getText().toString();
            String password = passwordP.getText().toString();
            String app = appP.getText().toString();

            switch (item.getItemId()) {
                case R.id.btn_register: {

                    if (nombre.equals("") || correo.equals("") || password.equals("") || app.equals("")) {
                        validacion();
                    } else {
                        Persona p = new Persona();
                        p.setLocalid(UUID.randomUUID().toString());
                        p.setNombre(nombre);
                        p.setApellido(app);
                        p.setCorreo(correo);
                        p.setPassword(password);
                        databaseReference.child("Persona").child(p.getLocalid()).setValue(p);
                        Toast.makeText(this, "Agregado", Toast.LENGTH_LONG).show();
                        limpiarCajas();
                    }
                    break;
                }*/
            /*case R.id.icon_save:{
                Persona p = new Persona();
                p.setUid(personaSelected.getUid());
                p.setNombre(nomP.getText().toString().trim());
                p.setApellido(appP.getText().toString().trim());
                p.setCorreo(correoP.getText().toString().trim());
                p.setPassword(passwordP.getText().toString().trim());
                databaseReference.child("Persona").child(p.getUid()).setValue(p);
                Toast.makeText(this,"Actualizado", Toast.LENGTH_LONG).show();
                limpiarCajas();
                break;
            }
            case R.id.icon_delete:{
                Persona p= new Persona();
                p.setUid(personaSelected.getUid());
                databaseReference.child("Persona").child(p.getUid()).removeValue();
                Toast.makeText(this,"Eliminado", Toast.LENGTH_LONG).show();
                limpiarCajas();
                break;
            }
                default:
                    break;
            }
            return true;
        }*/

    private void limpiarCajas() {
        nomP.setText("");
        correoP.setText("");
        passwordP.setText("");
        appP.setText("");
    }
    /*private void listarDatos() {
        databaseReference.child("Persona").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                listPerson.clear();
                for (DataSnapshot objSnaptshot : dataSnapshot.getChildren()){
                    Persona p = objSnaptshot.getValue(Persona.class);
                    listPerson.add(p);

                    arrayAdapterPersona = new ArrayAdapter<Persona>(MainActivity.this, android.R.layout.simple_list_item_1, listPerson);
                    listV_personas.setAdapter(arrayAdapterPersona);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }*/
    private void validacionBD(Persona p){

       databaseReference.child("users").addValueEventListener(new ValueEventListener() {
           @Override
           public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
               for (DataSnapshot objSnaptshot : dataSnapshot.getChildren()){
                   Persona persona = objSnaptshot.getValue(Persona.class);
                   if(persona.getCorreo().equals(p.getCorreo())){
                       Toast.makeText(this, "Correo ya registrado", Toast.LENGTH_LONG).show();
                        limpiarCajas();
                   }else{
                       if(persona.getNumero().equals(p.getNumero())){
                           Toast.makeText(this, "Numero ya registrado", Toast.LENGTH_LONG).show();
                             limpiarCajas();
                       }

                   }
               }

           }

           @Override
           public void onCancelled(@NonNull DatabaseError error) {

           }

       });
        if (p.getNombre().equals("")){

        }else{
            if(p)
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
        else if (password.equals("")){
            passwordP.setError("Required");
        }
        databaseReference.child("Persona").child(p.getLocalid()).setValue(p);
        Toast.makeText(this, "Agregado", Toast.LENGTH_LONG).show();
        limpiarCajas();

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
        else if (password.equals("")){
            passwordP.setError("Required");
        }
    }
}