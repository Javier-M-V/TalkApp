package com.example.javier.myapplication.activities;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.javier.myapplication.R;
import com.example.javier.myapplication.adapters.AdaptadorMensajes;
import com.example.javier.myapplication.classauxiliares.MensajeClass;
import com.example.javier.myapplication.servicios.ServicioDataBase;

import java.util.ArrayList;

public class ChatIndividual extends Activity {

    private String telefono  = null;
    private ArrayList<MensajeClass> listamensajesaconstruir = new ArrayList<MensajeClass>();
    AdaptadorMensajes adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chatindividual);
        Intent intent = getIntent();
        telefono = intent.getStringExtra("id_telefono");
        ArrayList<MensajeClass> listamensajesaconstruir = new ArrayList<MensajeClass>();
        ServicioDataBase agendaBBDD = new ServicioDataBase(this, "agendaBBDD", null, 1);
        SQLiteDatabase db = agendaBBDD.getWritableDatabase();
        Cursor a = db.rawQuery("SELECT foto, nombre FROM Contactos WHERE telefono="+telefono, null);
        a.moveToFirst();
        int foto = a.getInt(0);
        ImageView view = (ImageView) findViewById(R.id.imageViewFotocontacto);
        view.setImageResource(foto);
        TextView nombrecontacto = (TextView)findViewById(R.id.NombrecontactoChatIndividual);
        nombrecontacto.setText(a.getString(1));
        mostrarmensajes();
    }

    public void OnClicbutton(View v) {
        EditText edit= (EditText) findViewById(R.id.editText);
        MensajeClass mensajenuevo = new MensajeClass(edit.getText().toString(),new java.util.Date().toString(),telefono,"722740774");
        //AdaptadorMensajes adapter = new AdaptadorMensajes(this, listamensajesaconstruir);
        adapter.anyadirmensaje(mensajenuevo);

    }

    protected void mostrarmensajes() {
        ServicioDataBase agendaBBDD = new ServicioDataBase(this, "agendaBBDD", null, 1);
        SQLiteDatabase db = agendaBBDD.getWritableDatabase();
        if (db != null) {
            Cursor c = db.rawQuery("SELECT mensaje, fecha, destinatarioTelefono, remitenteTelefono FROM Mensajes WHERE remitenteTelefono='"+telefono+"' AND destinatarioTelefono = '722740774' OR destinatarioTelefono = '"+telefono+"' AND remitenteTelefono='722740774' ORDER BY fecha", null);
            String textomensaje;
            String fechahora;
            String remitente;
            String tel;

            MensajeClass mensaje = null;
            if (c.moveToFirst()) {
                do {
                    textomensaje = c.getString(0);
                    fechahora = c.getString(1);
                    remitente = c.getString(2);
                    tel = c.getString(3);

                    mensaje = new MensajeClass(textomensaje,fechahora,remitente,tel);
                    listamensajesaconstruir.add(mensaje);
                } while (c.moveToNext());
                c.close();


                if(remitente.equals("722740774")){

                }

            }
        }
        db.close();
        ListView mensajitos = (ListView) this.findViewById(R.id.Lay_mensajes);
        adapter = new AdaptadorMensajes(this, listamensajesaconstruir);
        mensajitos.setAdapter(adapter);
    }

}

