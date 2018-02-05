package com.example.javier.myapplication.activities;

import android.app.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.javier.myapplication.R;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainpage);
    }


    public void toAbout(View v){
        Intent about = new Intent(getApplicationContext(), AboutActivity.class);
        startActivity(about);

    }
    public void OnClicbuttonTalk(View v){

        Intent listachats = new Intent(getApplicationContext(), ListaDeChats.class);
        startActivity(listachats);

    }
}


