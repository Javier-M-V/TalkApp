package com.example.javier.myapplication.activities;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.javier.myapplication.R;
import com.example.javier.myapplication.classauxiliares.ContactoClass;

import java.util.ArrayList;

public class ListaDeChats extends Activity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listadechats);

        ArrayList<ContactoClass> listacontactos=new ArrayList<ContactoClass>();
        ContactoClass a = new ContactoClass("Pepe","", 545678765,R.drawable.fotoa);
        ContactoClass b = new ContactoClass("Jose", "",545678765,R.drawable.fotoa);
        ContactoClass c = new ContactoClass("Pedro", "",545678765,R.drawable.fotoa);
        ContactoClass d = new ContactoClass("Luisa", "",545678765,R.drawable.fotoa);
        listacontactos.add(a);
        listacontactos.add(b);
        listacontactos.add(c);
        listacontactos.add(d);

        ListView mensajes = (ListView)this.findViewById(R.id.listacontactos);

        MiAdaptadorClass adapter= new MiAdaptadorClass(this, listacontactos);
        mensajes.setAdapter(adapter);

    }
}
