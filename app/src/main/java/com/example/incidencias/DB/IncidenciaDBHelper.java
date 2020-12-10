package com.example.incidencias.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;


import java.util.ArrayList;

public class IncidenciaDBHelper extends SQLiteOpenHelper {

    public static final int VERSION_DB = 1;
    private static final String NOMBRE_DB="incidencies.db";

    private static final String SQL_CREATE_ENTRIES = "CREATE TABLE "
            + IncidenciaContract.IncidenciaEntry.TABLE_NAME + "("
            + IncidenciaContract.IncidenciaEntry.ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + IncidenciaContract.IncidenciaEntry.COLUMN_NAME_TITLE + " TEXT)";


    public IncidenciaDBHelper(@Nullable Context context) {
        super(context, NOMBRE_DB, null, VERSION_DB);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void insertIncidencia(SQLiteDatabase db, Incidencia i) {
        //Check the bd is open
        if (db.isOpen()) {
            //Creation of the register for insert object with the content values

            ContentValues values = new ContentValues();
            values.put(IncidenciaContract.IncidenciaEntry.COLUMN_NAME_TITLE, i.getTitulo());
            values.put(IncidenciaContract.IncidenciaEntry.COLUMN_NAME_PRIORIDAD, i.getPrioridad());
        } else {
            Log.d("sql", "Database is closed");


        }
    }
    /*
    public void insertIncidencia(String texto, String prioridad){
        SQLiteDatabase db=getWritableDatabase();
        if(db!=null){
            int id=0;
            db.execSQL("INSERT INTO INCIDENCIAS VALUES('"+id+"'+'"+texto+"','"+prioridad+"')");
            db.close();
        }
    }
*/
    //Close the db when the activity onDestroy

    public ArrayList<Incidencia> mostrarincidencias(){
        SQLiteDatabase bd=getReadableDatabase();
        Cursor cursor=bd.rawQuery("SELECT * FROM INCIDENCIAS",null);
        ArrayList<Incidencia> incidenciaArrayList=new ArrayList<>();
        Incidencia incidencia;
        if(cursor.moveToFirst()){
            do{
                incidencia = new Incidencia(cursor.getString(0),cursor.getString(1));



                incidenciaArrayList.add(incidencia);
            }while (cursor.moveToNext());
        }
        cursor.close();
        return incidenciaArrayList;
    }
}
