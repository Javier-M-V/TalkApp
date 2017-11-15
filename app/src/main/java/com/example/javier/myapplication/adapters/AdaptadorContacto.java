package com.example.javier.myapplication.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.javier.myapplication.R;
import com.example.javier.myapplication.classauxiliares.ContactoClass;

import java.util.List;

public class AdaptadorContacto extends BaseAdapter{

    private Context contexto;
    private List<ContactoClass> listacontactos;

    public AdaptadorContacto(Context contextovalor, List<ContactoClass> listacontactos) {
        this.contexto = contextovalor;
        this.listacontactos = listacontactos;
    }

    public Context getCont() {

        return contexto;
    }

    public void setCont(Context contextovalor) {

        this.contexto = contextovalor;
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
