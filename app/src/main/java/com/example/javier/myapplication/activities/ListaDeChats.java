package com.example.javier.myapplication.activities;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.javier.myapplication.R;
import com.example.javier.myapplication.adapters.AdaptadorContacto;
import com.example.javier.myapplication.classauxiliares.ContactoClass;
import com.example.javier.myapplication.servicios.ServicioDataBase;

import java.util.ArrayList;

public class ListaDeChats extends Activity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listadechats);
        ServicioDataBase agendaBBDD=new ServicioDataBase(this, "agendaBBDD", null, 1);
        SQLiteDatabase db = agendaBBDD.getWritableDatabase();
        ArrayList<ContactoClass> listacontactos=new ArrayList<ContactoClass>();
        ListView viewlista = (ListView) findViewById(R.id.listacontactos);
        viewlista.setOnItemClickListener(btn2Listener);
        if(db != null)
        {
            Cursor c = db.rawQuery("SELECT nombre,estado,telefono,foto FROM Contactos WHERE nombre <> 'YO'", null);
            String nombre="";
            String estado="";
            int tel=0;
            int foto=0;
            ContactoClass a=null;
            if (c.moveToFirst()) {
                //Recorremos el cursor hasta que no haya más registros
                do {
                    nombre = c.getString(0);
                    estado = c.getString(1);
                    tel = c.getInt(2);
                    foto = c.getInt(3);
                    a = new ContactoClass(nombre, estado, tel, foto);
                    listacontactos.add(a);
                } while (c.moveToNext());
            }
        }
        db.close();

        ListView contactos = (ListView)this.findViewById(R.id.listacontactos);
        AdaptadorContacto adapter= new AdaptadorContacto(this, listacontactos);
        contactos.setAdapter(adapter);
    }

    private AdapterView.OnItemClickListener btn2Listener = new AdapterView.OnItemClickListener()
    {
        @Override
        public void onItemClick (AdapterView<?> parent, View view, int position, long id)
        {
            ContactoClass contact = (ContactoClass) parent.getAdapter().getItem(position);
            String ide = Integer.toString(contact.getTel());
            Intent intent = new Intent(getApplicationContext(), ChatIndividual.class);//en vez de this usamos getApplication Context
            intent.putExtra("id_telefono", ide);
            startActivity(intent);
        }
    };
}
