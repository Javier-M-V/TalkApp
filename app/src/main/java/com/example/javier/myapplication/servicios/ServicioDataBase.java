package com.example.javier.myapplication.servicios;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.javier.myapplication.R;

public class ServicioDataBase extends SQLiteOpenHelper {

    //Sentencia SQL para crear la tabla de Contactos
    String sqlCreate = "CREATE TABLE Contactos (nombre TEXT,estado INT,telefono INTEGER, foto INTEGER)";

    public ServicioDataBase(Context contexto, String nombre, SQLiteDatabase.CursorFactory factory, int version)
    {
        super(contexto, nombre, factory, version);
    }

    public void onCreate(SQLiteDatabase db)
    {
        //Se ejecuta la sentencia SQL de creación de la tabla
        db.execSQL(sqlCreate);
        if(db != null)
        {
            //Insertamos los datos en la tabla Contactos
            db.execSQL("INSERT INTO Contactos (nombre, estado,telefono,foto) VALUES ('Luis','hola', 6653454,"+R.drawable.fotoa+")");
            db.execSQL("INSERT INTO Contactos (nombre, estado,telefono,foto) VALUES ('Julia','hola',6621323,"+R.drawable.fotoa+")");
            db.execSQL("INSERT INTO Contactos (nombre, estado,telefono,foto) VALUES ('Juan','hola',6654321,"+ R.drawable.fotoa+")");
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
        }

    }
}
