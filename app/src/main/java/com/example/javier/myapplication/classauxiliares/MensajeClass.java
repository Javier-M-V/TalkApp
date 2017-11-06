package com.example.javier.myapplication.classauxiliares;

import java.util.Date;
//TODO: cambiar DATE a SimpleDateFormat
public class MensajeClass {
    private String mensaje;
    private Date fechahora;
    private String remitente;
    private String usuario;

    public MensajeClass(String mensaje, int ano, int mes, int dia, String remitente, String user){
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

