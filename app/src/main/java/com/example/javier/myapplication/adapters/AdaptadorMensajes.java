package com.example.javier.myapplication.adapters;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.javier.myapplication.R;
import com.example.javier.myapplication.activities.ChatIndividual;
import com.example.javier.myapplication.classauxiliares.MensajeClass;
import com.example.javier.myapplication.servicios.ServicioDataBase;

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
    public void anyadirmensaje(MensajeClass mensajeanyadir){

        ServicioDataBase agendaBBDD = new ServicioDataBase(contexto, "agendaBBDD", null, 1);
        SQLiteDatabase db = agendaBBDD.getWritableDatabase();
        String sql = "INSERT INTO Mensajes (mensaje, fecha,destinatarioTelefono,remitenteTelefono) VALUES ('"+mensajeanyadir.getMensaje()+"','"+new java.util.Date().toString()+"','"+mensajeanyadir.getDestinatarioTelefono()+"','"+mensajeanyadir.getRemitenteTelefono()+"')";
        Log.e("KKKKKK",sql);
        db.execSQL(sql);
        db.close();
        Log.e("KKKKKK", Integer.toString(listamensajes.size()));
        listamensajes.add(mensajeanyadir);
        Log.e("KKKKKK", Integer.toString(listamensajes.size()));
        //
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {

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

