package com.example.javier.myapplication.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.javier.myapplication.R;
import com.example.javier.myapplication.classauxiliares.MensajeClass;

import java.util.ArrayList;
import java.util.Date;

/*TODO: meter database e implementar el modo en que funcionen los mensajitos
ServicioDataBase agendaBBDD=new ServicioDataBase(this, "agendaBBDD", null, 1);
SQLiteDatabase db = agendaBBDD.getWritableDatabase();
* */
public class ChatIndividual extends Activity {

    ArrayList<MensajeClass> arraymensajes= null;

    //@Override
    protected void onCreate (Bundle savedInstanceState){
        arraymensajes = new ArrayList<>();
        MensajeClass z = new MensajeClass("Hola Pepe", "Andrés", "JavierM");
        arraymensajes.add(z);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chatindividual);
        mostrarmensajes(0);
    }
    public void OnClicbutton(View v) {
        EditText edit= findViewById(R.id.editText);
        MensajeClass a = new MensajeClass(edit.getText().toString(), "Andrés", "JavierM");
        arraymensajes.add(a);
        mostrarmensajes(arraymensajes.size()-1);

    }

    protected void mostrarmensajes(int indexmensajes) {
        LinearLayout lay_smg = findViewById(R.id.Lay_mensajes);
        TextView txtv = null;
        for (int i = indexmensajes; i < arraymensajes.size(); i++) {
            txtv = new TextView(this);
            txtv.setText(arraymensajes.get(i).getMensaje() + "\n" + arraymensajes.get(i).getHora() + "\n" + arraymensajes.get(i).getRemitente() + "\n");
            lay_smg.addView(txtv);
        }
    }
}


