package com.example.javier.myapplication.classauxiliares;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MensajeClass {
    private String mensaje;
    private String fechahora;
    private String destinatarioTelefono;
    private String remitenteTelefono;

    public MensajeClass(String mensaje, String fechahora,
                        String ValordestinatarioTelefono, String ValorremitenteTelefono){

        this.mensaje = mensaje;
        this.fechahora = fechahora;
        this.destinatarioTelefono = ValordestinatarioTelefono;
        this.remitenteTelefono = ValorremitenteTelefono;
    }
    /*normalmente usado para que la fecha sea automática,
    con el día y la hora del momento, cuando se crea el mensaje*/

    public MensajeClass(String mensaje, String ValordestinatarioTelefono,
                        String ValorremitenteTelefono){
        this.mensaje = mensaje;
        Date hoy = new Date();
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        this.fechahora = df.format(hoy).toString();
        this.destinatarioTelefono = ValordestinatarioTelefono;
        this.remitenteTelefono = ValorremitenteTelefono;
    }
    //normalmente usado para leer de DDBB

    public String getFecha(){

        return fechahora;
    }

    public String getMensaje() {

        return mensaje;
    }

    public String getRemitenteTelefono() {

        return remitenteTelefono;
    }

    public String getDestinatarioTelefono() {

        return destinatarioTelefono;
    }
}

