package com.example.javier.myapplication.classauxiliares;

public class ContactoClass {
    String nombre;
    String estado;
    int tel;
    int foto;

    public ContactoClass(String nombre, String estado, int tel, int foto) {
        this.nombre = nombre;
        this.tel = tel;
        this.foto = foto;
        this.estado=estado;
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
