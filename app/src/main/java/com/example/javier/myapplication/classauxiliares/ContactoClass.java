package com.example.javier.myapplication.classauxiliares;

public class ContactoClass {
    String nombre;
    String estado;
    int tel;
    int foto;
    String ultimoMensaje [] = new String[2];

    public ContactoClass(String nombre, String estado, int tel, int foto, String [] ultimoMensaje) {
        this.nombre = nombre;
        this.tel = tel;
        this.foto = foto;
        this.estado = estado;
        this.ultimoMensaje = ultimoMensaje;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNombre() {

        return nombre;
    }
    public String [] getUltimoMensaje(){

        return ultimoMensaje;
    }

    public void setNombre(String nombre) {

        this.nombre = nombre;
    }

    public int getTel() {

        return tel;
    }

    public void setTel(int tel) {

        this.tel = tel;
    }

    public int getFoto() {

        return foto;
    }

    public int setFoto(int foto) {

        return this.foto = foto;
    }
}
