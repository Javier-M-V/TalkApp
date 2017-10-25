package com.example.javier.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alumno on 25/10/17.
 */

public class ChatsContactosClass extends Activity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chats);

        ArrayList<ContactoClass> listacontactos=new ArrayList<ContactoClass>();
        ContactoClass a = new ContactoClass("Pepe", 545678765,R.drawable.fotoa);
        ContactoClass b = new ContactoClass("Jose", 545678765,R.drawable.fotoa);
        ContactoClass c = new ContactoClass("Pedro", 545678765,R.drawable.fotoa);
        ContactoClass d = new ContactoClass("Luisa", 545678765,R.drawable.fotoa);
        listacontactos.add(a);
        listacontactos.add(b);
        listacontactos.add(c);
        listacontactos.add(d);



        ListView mensajes = (ListView)this.findViewById(R.id.listacontactos);

        miAdaptadorClass adapter= new miAdaptadorClass(this, listacontactos);
        mensajes.setAdapter(adapter);

    }
}
