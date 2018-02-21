package com.example.javier.myapplication.servicios;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.javier.myapplication.R;

public class ServicioDataBase extends SQLiteOpenHelper {

    /*Formato de fecha : "MM/dd/yyyy HH:mm:ss"*/
    String sqlCreate = "CREATE TABLE Contactos (nombre TEXT, estado TEXT, telefono INTEGER, foto INTEGER)";
    String sqlCreate2 = "CREATE TABLE Mensajes (mensaje TEXT, fecha DATE, destinatarioTelefono TEXT, remitenteTelefono TEXT)";

    public ServicioDataBase(Context contexto, String nombre, SQLiteDatabase.CursorFactory factory, int version) {

        super(contexto, nombre, factory, version);
    }

    public void onCreate(SQLiteDatabase db) {

        db.execSQL(sqlCreate);
        db.execSQL(sqlCreate2);
        if(db != null) {

            db.execSQL("INSERT INTO Contactos (nombre, estado,telefono,foto) VALUES ('Luis','hola', 66534541,"+R.drawable.fotoa+")");
            db.execSQL("INSERT INTO Contactos (nombre, estado,telefono,foto) VALUES ('YO','PROGRAMADOR','722740774',"+R.drawable.fotoa+")");
            db.execSQL("INSERT INTO Contactos (nombre, estado,telefono,foto) VALUES ('Julia','hola',66213232,"+R.drawable.fotoa+")");
            db.execSQL("INSERT INTO Contactos (nombre, estado,telefono,foto) VALUES ('Juan','hola',66543213,"+ R.drawable.fotoa+")");
            db.execSQL("INSERT INTO Mensajes (mensaje, fecha,destinatarioTelefono,remitenteTelefono) VALUES ('Hola','2015-10-10 20:33:01','722740774','66534541')");
            db.execSQL("INSERT INTO Mensajes (mensaje, fecha,destinatarioTelefono,remitenteTelefono) VALUES ('K ASE?','2016-12-01 20:33:01','66534541','722740774')");
            db.execSQL("INSERT INTO Mensajes (mensaje, fecha,destinatarioTelefono,remitenteTelefono) VALUES ('jajaja','2016-05-25 20:33:01','722740774','66534541')");
            db.execSQL("INSERT INTO Mensajes (mensaje, fecha,destinatarioTelefono,remitenteTelefono) VALUES ('JIJIJI','2016-05-25 20:33:01','66534541','722740774')");
            db.execSQL("INSERT INTO Mensajes (mensaje, fecha,destinatarioTelefono,remitenteTelefono) VALUES ('JEJEJE','2016-05-25 20:33:01','722740774','66534541')");
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldversion, int newversion) {

        {
            db.execSQL("DROP TABLE IF EXISTS Contactos");
            db.execSQL(sqlCreate);
            db.execSQL(sqlCreate2);
        }

    }
}
