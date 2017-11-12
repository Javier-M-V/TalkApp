package com.example.javier.myapplication.activities;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.javier.myapplication.R;
import com.example.javier.myapplication.adapters.AdaptadorContacto;
import com.example.javier.myapplication.adapters.AdaptadorMensajes;
import com.example.javier.myapplication.classauxiliares.MensajeClass;
import com.example.javier.myapplication.servicios.ServicioDataBase;

import java.util.ArrayList;
import java.util.Date;

/*TODO: meter database e implementar el modo en que funcionen los mensajitos

* */
public class ChatIndividual extends Activity {

    ArrayList<MensajeClass> arraymensajes= null;
    ServicioDataBase  agendaBBDD=null;
    SQLiteDatabase db=null;

    protected void onCreate (Bundle savedInstanceState){
        agendaBBDD=new ServicioDataBase(this, "agendaBBDD", null, 1);
        db= agendaBBDD.getWritableDatabase();
        Cursor a = db.rawQuery("SELECT mensaje, fecha ,remitente, usuario FROM Mensajes", null);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chatindividual);
        ListView mensajes = (ListView)this.findViewById(R.id.Lay_mensajes);
        AdaptadorMensajes adapter= new AdaptadorMensajes(this, a);
        mensajes.setAdapter(adapter);
    }
    public void OnClicbutton(View v) {
        /*EditText edit= findViewById(R.id.editText);
        MensajeClass a = new MensajeClass(edit.getText().toString(), "Andrés", "JavierM");
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



