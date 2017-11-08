package com.example.javier.myapplication.adapters;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.javier.myapplication.R;
import com.example.javier.myapplication.classauxiliares.ContactoClass;
import com.example.javier.myapplication.classauxiliares.MensajeClass;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.SimpleTimeZone;
import java.util.StringTokenizer;
import java.text.SimpleDateFormat;

/**
 * Created by alumno on 6/11/17.
 */

public class AdaptadorMensajes extends BaseAdapter {


    private Context contexto;
    private List<MensajeClass> listamensajes;
    private Cursor cursor;

    public AdaptadorMensajes(Context cont, Cursor cursor) {
        this.contexto = cont;
        this.listamensajes = constructormensajes();
        this.cursor = cursor;
    }

    protected List<MensajeClass> constructormensajes() {
        String mensaje;
        String fechahora;
        String remitente;
        String usuario;
        ArrayList<MensajeClass> listamensajesaconstruir=new ArrayList<MensajeClass>();
        MensajeClass a = null;
        if (cursor.moveToFirst()) {
            //Recorremos el cursor hasta que no haya más registros
            do {
                mensaje = cursor.getString(0);
                fechahora = cursor.getString(1);
                remitente = cursor.getString(2);
                usuario = cursor.getString(3);

                a = new MensajeClass(mensaje, fechahora, remitente, usuario);
                listamensajesaconstruir.add(a);
            } while (cursor.moveToNext());
        }
        return listamensajesaconstruir;
    }

    public Context getContexto(){

        return contexto;
    }
    
    @Override
    public int getCount() {

        return listamensajes.size();
    }

    @Override
    public Object getItem(int i) {

        return listamensajes.get(i);
    }

    @Override
    public long getItemId(int i) {

        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {//TODO: crear el metodo para esta vista

        //Es la primera vez que se va a usar la vista
        if (convertView == null)
        {
            LayoutInflater inflater=LayoutInflater.from(contexto);
            convertView = inflater.inflate(R.layout.chatindividual_plantillamensaje, null);
        }
        TextView mensaje = (TextView) convertView.findViewById(R.id.mensaje);
        mensaje.setText(listamensajes.get(i).getMensaje());
        //arreglar la fecha
        TextView fecha = (TextView)convertView.findViewById(R.id.fecha);
        fecha.setText(listamensajes.get(i).getFecha());
        return convertView;
    }

    /*
    // Create an instance of SimpleDateFormat used for formatting
    // the string representation of date (month/day/year)
    DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");

    // Get the date today using Calendar object.
    Date today = Calendar.getInstance().getTime();
    // Using DateFormat format method we can create a string
    // representation of a date with the defined format.
    String reportDate = df.format(today);

    // Print what date is today!
    System.out.println("Report Date: " + reportDate);

    https://stackoverflow.com/questions/5683728/convert-java-util-date-to-string


    * */
}
