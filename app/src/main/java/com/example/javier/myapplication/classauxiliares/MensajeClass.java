package com.example.javier.myapplication.classauxiliares;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;

public class MensajeClass {
    private String mensaje;
    private String fechahora;
    private String remitente;
    private String usuario;

    //normalmente usado para que la fecha sea automática, con el día y la hora del momento, cuando se crea el mensaje
    public MensajeClass(String mensaje, String remitente, String user){
        this.mensaje = mensaje;
        Date hoy = Calendar.getInstance().getTime();
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        this.fechahora = df.format(hoy);
        this.remitente = remitente;
        this. usuario = user;
    }
    //normalmente usado para leer de DDBB
    public MensajeClass(String mensaje, String fechahora, String remitente, String user){
        this.mensaje = mensaje;
        this.fechahora = fechahora;
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

