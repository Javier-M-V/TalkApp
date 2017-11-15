package com.example.javier.myapplication.servicios;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.javier.myapplication.R;

public class ServicioDataBase extends SQLiteOpenHelper {
    //Sentencia SQL para crear la tabla de Contactos
    /*ojo con el formato de fecha que ha de entrar de manera auto: "MM/dd/yyyy HH:mm:ss"*/
    String sqlCreate = "CREATE TABLE Contactos (nombre TEXT, estado TEXT, telefono INTEGER, foto INTEGER)";
    String sqlCreate2 = "CREATE TABLE Mensajes (mensaje TEXT, fecha TEXT, destinatarioTelefono TEXT, remitenteTelefono TEXT)";

    public ServicioDataBase(Context contexto, String nombre, SQLiteDatabase.CursorFactory factory, int version)
    {
        super(contexto, nombre, factory, version);
    }

    public void onCreate(SQLiteDatabase db)
    {
        //Se ejecuta la sentencia SQL de creación de la tabla
        db.execSQL(sqlCreate);
        db.execSQL(sqlCreate2);
        if(db != null)
        {
            //Insertamos los datos en la tabla Contactos
            db.execSQL("INSERT INTO Contactos (nombre, estado,telefono,foto) VALUES ('Luis','hola', 66534541,"+R.drawable.fotoa+")");
            db.execSQL("INSERT INTO Contactos (nombre, estado,telefono,foto) VALUES ('Julia','hola',66213232,"+R.drawable.fotoa+")");
            db.execSQL("INSERT INTO Contactos (nombre, estado,telefono,foto) VALUES ('Juan','hola',66543213,"+ R.drawable.fotoa+")");
            db.execSQL("INSERT INTO Mensajes (mensaje, fecha,destinatarioTelefono,remitenteTelefono) VALUES ('Maldita','05/25/2016 20:33:01','722740774','66213232')");
            db.execSQL("INSERT INTO Mensajes (mensaje, fecha,destinatarioTelefono,remitenteTelefono) VALUES ('RATA','05/25/2016 20:33:01','722740774','66213232')");
            db.execSQL("INSERT INTO Mensajes (mensaje, fecha,destinatarioTelefono,remitenteTelefono) VALUES ('jajaja','05/25/2016 20:33:01','722740774','66534541')");

        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldversion, int newversion) {

        {
            //NOTA: Por simplicidad del ejemplo aquí utilizamos directamente la opción de
            //      eliminar la tabla anterior y crearla de nuevo vacía con el nuevo formato.
            //      Sin embargo lo normal será que haya que migrar datos de la tabla antigua
            //      a la nueva, por lo que este método debería ser más elaborado.

            //Se elimina la versión anterior de la tabla
            db.execSQL("DROP TABLE IF EXISTS Contactos");

            //Se crea la nueva versión de la tabla
            db.execSQL(sqlCreate);
            db.execSQL(sqlCreate2);
        }

    }
}
