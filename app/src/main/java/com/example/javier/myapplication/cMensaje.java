package com.example.javier.myapplication;

import java.util.Date;



public class cMensaje {
    public String mensaje;
    public Date fechahora;
    public String remitente;

    cMensaje(String mensaje, int ano, int mes, int dia,  String remitente){
        this.mensaje = mensaje;
        fechahora = new Date(ano, mes, dia);
        this.remitente = remitente;
    }
}

