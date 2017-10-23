package com.example.javier.myapplication;

import java.util.Date;



public class cMensaje {
    public String mensaje;
    public Date fechahora;
    public String remitente;
    public String usuario;

    cMensaje(String mensaje, int ano, int mes, int dia,  String remitente, String user){
        this.mensaje = mensaje;
        fechahora = new Date(ano, mes, dia);
        this.remitente = remitente;
        this. usuario= user;
    }

    public String getHora() {

        String hora = fechahora.toString();


        return hora;
    }
    public String getDia(){

        String dia =fechahora.toString();

        return dia;
    }
}

