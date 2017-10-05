package com.example.javier.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

public class chatActivity extends Activity {

    String[] charla={"HOLA","KE","ASE","LOKO"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chat);;
        LinearLayout lay_smg =findViewById(R.id.Lay_mensajes);
        TextView txtv = null;
        for(int i = 0; i<charla.length;i++){
            txtv= new TextView(this);
            txtv.setText(charla[i]);
            lay_smg.addView(txtv);
        }
    }

}
