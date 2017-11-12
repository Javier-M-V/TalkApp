package com.example.javier.myapplication.activities;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.javier.myapplication.R;
import com.example.javier.myapplication.adapters.AdaptadorContacto;
import com.example.javier.myapplication.adapters.AdaptadorMensajes2;
import com.example.javier.myapplication.classauxiliares.ContactoClass;
import com.example.javier.myapplication.classauxiliares.MensajeClass;
import com.example.javier.myapplication.servicios.ServicioDataBase;

import java.util.ArrayList;

public class ChatIndividual2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chatindividual);
        super.onCreate(savedInstanceState);
        ServicioDataBase agendaBBDD = new ServicioDataBase(this, "agendaBBDD", null, 1);
        SQLiteDatabase db = agendaBBDD.getWritableDatabase();
        ArrayList<MensajeClass> listamensajesaconstruir = new ArrayList<MensajeClass>();
        if (db != null) {
            Cursor c = db.rawQuery("SELECT mensaje, fecha ,remitente, usuario FROM Mensajes", null);
            String textomensaje;
            String fechahora;
            String remitente;
            String usuario;

            MensajeClass mensaje = null;
            if (c.moveToFirst()) {
                //Recorremos el cursor hasta que no haya más registros
                do {
                    textomensaje = c.getString(0);
                    fechahora = c.getString(1);
                    remitente = c.getString(2);
                    usuario = c.getString(3);

                    mensaje = new MensajeClass(textomensaje,fechahora,remitente,usuario);
                    listamensajesaconstruir.add(mensaje);
                } while (c.moveToNext());
                c.close();

                ListView mensajitos = (ListView) this.findViewById(R.id.Lay_mensajes);
                AdaptadorMensajes2 adapter = new AdaptadorMensajes2(this, listamensajesaconstruir);
                mensajitos.setAdapter(adapter);
            }
        }
    }
}

