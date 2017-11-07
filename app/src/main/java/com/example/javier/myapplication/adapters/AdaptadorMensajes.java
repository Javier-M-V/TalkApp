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
        Date fechahora;
        String remitente;
        String usuario;
        ArrayList<MensajeClass> listamensajesaconstruir=new ArrayList<MensajeClass>();
        MensajeClass a = null;
        if (cursor.moveToFirst()) {
            //Recorremos el cursor hasta que no haya más registros
            do {
                mensaje = cursor.getString(0);
                fechahora = toDate(cursor.getString(1));
                remitente = cursor.getString(2);
                usuario = cursor.getString(3);

                a = new MensajeClass(mensaje, fechahora, remitente, usuario);
                listamensajesaconstruir.add(a);
            } while (cursor.moveToNext());
        }
        return listamensajesaconstruir;
    }

    public Date toDate(String fechastring){

        StringTokenizer str=new StringTokenizer(fechastring,"/");
        int dia=Integer.parseInt(str.nextToken());
        int hora=Integer.parseInt(str.nextToken());
        int año=Integer.parseInt(str.nextToken());
        Date a= new Date(dia,hora,año);
        return a;
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
            convertView = inflater.inflate(R.layout.listadechats_plantillacontacto, null);
        }
        ImageView fotocontacto = (ImageView) convertView.findViewById(R.id.imagencontacto);
        TextView tvFecha_pub = (TextView) convertView.findViewById(R.id.textocontacto);
        tvFecha_pub.setText(listacontactos.get(i).getNombre());
        fotocontacto.setBackgroundResource(listacontactos.get(i).getFoto());
        return convertView;
    }
}
