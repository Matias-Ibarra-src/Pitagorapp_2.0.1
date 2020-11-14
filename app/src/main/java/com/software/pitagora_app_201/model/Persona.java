package com.software.pitagora_app_201.model;

public class Persona {
    private String Localid;
    private String Nombre;
    private String Apellido;
    private String Numero;
    private String Correo;
    private String Password;

    public Persona() {
    }

    public String getNumero() {
        return Numero;
    }

    public void setNumero(String Numero) {
        this.Numero = Numero;
    }

    public String getLocalid() {
        return Localid;
    }

    public void setLocalid(String Localid) {
        this.Localid = Localid;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String correo) {
        Correo = correo;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    @Override
    public String toString() {
        return Nombre;
    }

}
