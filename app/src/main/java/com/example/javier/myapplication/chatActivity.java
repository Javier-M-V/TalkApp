package com.example.javier.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class chatActivity extends Activity {

    ArrayList<cMensaje> arraymensajes= null;


    //@Override
    protected void onCreate (Bundle savedInstanceState){
        arraymensajes = new ArrayList<>();
        cMensaje z = new cMensaje("Hola Pepe", 2017, 8, 21, "Andrés", "JavierM");
        arraymensajes.add(z);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chat);
        mostrarmensajes(0);
    }
    public void OnClicbutton(View v) {
        EditText edit= findViewById(R.id.editText);
        cMensaje a = new cMensaje(edit.getText().toString(),2017, 8, 21,"Andrés", "JavierM");
        arraymensajes.add(a);
        mostrarmensajes(arraymensajes.size()-1);

    }

    protected void mostrarmensajes(int indexmensajes) {
        LinearLayout lay_smg = findViewById(R.id.Lay_mensajes);
        TextView txtv = null;
        for (int i = indexmensajes; i < arraymensajes.size(); i++) {
            txtv = new TextView(this);
            txtv.setText(arraymensajes.get(i).mensaje + "\n" + arraymensajes.get(i).fechahora.toString() + "\n" + arraymensajes.get(i).remitente + "\n");
            lay_smg.addView(txtv);
        }
    }
}


