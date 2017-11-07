package com.example.javier.myapplication.classauxiliares;

import java.util.Date;
//TODO: trabajar con SimpleDateFormat
public class MensajeClass {
    private String mensaje;
    private Date fechahora;
    private String remitente;
    private String usuario;

    public MensajeClass(String mensaje, Date fechahora, String remitente, String user){
        this.mensaje = mensaje;
        this.fechahora = new Date();
        this.remitente = remitente;
        this. usuario = user;
    }
    public MensajeClass(String mensaje, int dia, int mes, int ano,String remitente, String user){
        this.mensaje = mensaje;
        this.fechahora = new Date(dia,mes,ano);
        this.remitente = remitente;
        this. usuario = user;
    }

    public String getHora() {

        String hora = fechahora.toString();
        return hora;
    }
    public String getDia(){

        String dia =fechahora.toString();

        return dia;
    }

    public String getMensaje() {

        return mensaje;
    }

    public void setMensaje(String mensaje) {

        this.mensaje = mensaje;
    }

    public String getRemitente() {

        return remitente;
    }
}

