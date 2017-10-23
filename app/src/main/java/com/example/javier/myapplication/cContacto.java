package com.example.javier.myapplication;

public class cContacto {
    String nombre;
    int tel;
    int foto;

    public cContacto(String nombre, int tel, int foto) {
        this.nombre = nombre;
        this.tel = tel;
        this.foto = foto;
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

    public void setFoto(int foto) {
        this.foto = foto;
    }
}
