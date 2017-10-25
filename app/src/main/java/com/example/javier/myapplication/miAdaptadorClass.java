package com.example.javier.myapplication;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by alumno on 25/10/17.
 */

public class miAdaptadorClass extends BaseAdapter{

    private Context cont;
    private List<ContactoClass> listacontactos;

    public miAdaptadorClass(Context cont, List<ContactoClass> listacontactos) {
        this.cont = cont;
        this.listacontactos = listacontactos;
    }

    public Context getCont() {
        return cont;
    }

    public void setCont(Context cont) {
        this.cont = cont;
    }

    public List<ContactoClass> getListacontactos() {
        return listacontactos;
    }

    public void setListacontactos(List<ContactoClass> listacontactos) {
        this.listacontactos = listacontactos;
    }

    @Override
    public int getCount() {
        return listacontactos.size();
    }

    @Override
    public Object getItem(int i) {
        return listacontactos.get(i);
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
            LayoutInflater inflater=LayoutInflater.from(cont);
            convertView = inflater.inflate(R.layout.plantillacontacto, null);
        }
        ImageView fotocontacto = (ImageView) convertView.findViewById(R.id.imagencontacto);
        TextView tvFecha_pub = (TextView) convertView.findViewById(R.id.textocontacto);
        tvFecha_pub.setText(listacontactos.get(i).getNombre());
        fotocontacto.setBackgroundResource(listacontactos.get(i).getFoto());
        return convertView;
    }
}
