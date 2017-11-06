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

import java.util.Date;
import java.util.List;

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
        List<MensajeClass> listamensajesaconstruir=new List<MensajeClass>();
        MensajeClass a = null;
        if (cursor.moveToFirst()) {
            //Recorremos el cursor hasta que no haya más registros
            do {
                mensaje = cursor.getString(0);
                fechahora =  cursor.;
                remitente = cursor.getString(2);
                usuario = cursor.getString(3);

                a = new ContactoClass(mensaje, fechahora, tel, usuario);
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
    public View getView(int i, View convertView, ViewGroup parent) {

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
