package com.example.javier.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class chatActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chat);


        TextView tx = null;
        String mensajes[] = {"Hola", "cosa feliz", "bocadillo", "de pan"};
        for (int i = 0; i < mensajes.length; i++) {
            tx = new TextView(this);
            tx.setText(mensajes[i]);
        }
    }
}
