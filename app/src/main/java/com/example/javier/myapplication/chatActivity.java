package com.example.javier.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

public class chatActivity extends Activity {

    cMensaje a = new cMensaje("Hola Pepe",2017, 8, 21,"Andrés");
    cMensaje b = new cMensaje("Hola RATA",2017, 8, 22,"Comercial");
    cMensaje c = new cMensaje("Hola Pepe",2017, 8, 23,"Jose");
    cMensaje d = new cMensaje("Hola Pepe",2017, 8, 24,"Pepe");

    cMensaje[] arrCMensajes ={a,b,c,d};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chat);
        LinearLayout lay_smg =findViewById(R.id.Lay_mensajes);
        TextView txtv = null;
        for(int i = 0; i< arrCMensajes.length; i++){
            txtv= new TextView(this);
            txtv.setText(arrCMensajes[i].mensaje+"\n"+arrCMensajes[i].fechahora.toString()+"\n"+arrCMensajes[i].remitente+"\n");
            lay_smg.addView(txtv);
        }
    }

}
