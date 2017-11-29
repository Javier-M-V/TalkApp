package com.example.javier.myapplication.adapters;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.javier.myapplication.R;
import com.example.javier.myapplication.classauxiliares.MensajeClass;

import java.util.ArrayList;

/**
 * Created by javier on 12/11/17.
 */

public class AdaptadorMensajes extends BaseAdapter{

    private Context contexto;
    private ArrayList<MensajeClass> listamensajes;

    public AdaptadorMensajes(Context cont, ArrayList <MensajeClass> array) {
        this.contexto = cont;
        this.listamensajes = array;

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

        if (convertView == null)
        {
            LayoutInflater inflater=LayoutInflater.from(contexto);
            convertView = inflater.inflate(R.layout.chatindividual_plantillamensaje, null);
        }
        TextView mensaje = (TextView) convertView.findViewById(R.id.mensaje);
        mensaje.setText(listamensajes.get(i).getMensaje());
        TextView fecha = (TextView)convertView.findViewById(R.id.fecha);
        fecha.setText(listamensajes.get(i).getFecha());
        return convertView;
    }
}
