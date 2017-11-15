package com.example.javier.myapplication.activities;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import com.example.javier.myapplication.R;
import com.example.javier.myapplication.adapters.AdaptadorMensajes;
import com.example.javier.myapplication.classauxiliares.MensajeClass;
import com.example.javier.myapplication.servicios.ServicioDataBase;

import java.util.ArrayList;

public class ChatIndividual extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chatindividual);
        Intent intent = getIntent();
        String telefono = intent.getStringExtra("id_telefono");
        ServicioDataBase agendaBBDD = new ServicioDataBase(this, "agendaBBDD", null, 1);
        SQLiteDatabase db = agendaBBDD.getWritableDatabase();
        ArrayList<MensajeClass> listamensajesaconstruir = new ArrayList<MensajeClass>();
        if (db != null) {
            Cursor c = db.rawQuery("SELECT mensaje, fecha, destinatarioTelefono, remitenteTelefono FROM Mensajes WHERE remitenteTelefono='"+telefono+"'", null);
            String textomensaje;
            String fechahora;
            String remitente;
            String tel;

            MensajeClass mensaje = null;
            if (c.moveToFirst()) {
                //Recorremos el cursor hasta que no haya más registros
                do {
                    textomensaje = c.getString(0);
                    fechahora = c.getString(1);
                    remitente = c.getString(2);
                    tel = c.getString(3);

                    mensaje = new MensajeClass(textomensaje,fechahora,remitente,tel);
                    listamensajesaconstruir.add(mensaje);
                } while (c.moveToNext());
                c.close();

                ListView mensajitos = (ListView) this.findViewById(R.id.Lay_mensajes);
                AdaptadorMensajes adapter = new AdaptadorMensajes(this, listamensajesaconstruir);
                mensajitos.setAdapter(adapter);
            }
        }
    }

    public void OnClicbutton(View v) {
        /*EditText edit= findViewById(R.id.editText);
        MensajeClass a = new MensajeClass(edit.getText().toString(), "tel1", "tel2");
        arraymensajes.add(a);
        mostrarmensajes(arraymensajes.size()-1);*/

    }

    protected void mostrarmensajes(int indexmensajes) {
        /*LinearLayout lay_smg = findViewById(R.id.Lay_mensajes);
        TextView txtv = null;
        for (int i = indexmensajes; i < arraymensajes.size(); i++) {
            txtv = new TextView(this);
            txtv.setText(arraymensajes.get(i).getMensaje() + "\n" + arraymensajes.get(i).getHora() + "\n" + arraymensajes.get(i).getRemitente() + "\n");
            lay_smg.addView(txtv);
         }*/
    }
}

