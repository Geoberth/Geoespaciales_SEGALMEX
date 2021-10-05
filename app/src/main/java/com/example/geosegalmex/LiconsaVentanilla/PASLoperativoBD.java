package com.example.geosegalmex.LiconsaVentanilla;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class PASLoperativoBD extends SQLiteOpenHelper {

    public static final String DB_NAME  = "PASLoperativo";
    public static final int DB_VERSION = 1;

    public PASLoperativoBD(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(pasl_operativo_bd.CREAR_TABLA_PASL_OPERATIVO);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ pasl_operativo_bd.TABLA_BD);
    }

    public boolean addPASLoperativo(Pasl_o_Model model){

        SQLiteDatabase db           = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(pasl_operativo_bd.COLUMN_FOLIO, model.getFolio());
        contentValues.put(pasl_operativo_bd.COLUMN_FECHA, model.getFecha());
        contentValues.put(pasl_operativo_bd.COLUMN_ESTADO, model.getEstado());
        contentValues.put(pasl_operativo_bd.COLUMN_MUNICIPIO, model.getMunicipio());
        contentValues.put(pasl_operativo_bd.COLUMN_LOCALIDAD, model.getLocalidad());
        contentValues.put(pasl_operativo_bd.COLUMN_NOMBRE, model.getNombre());
        contentValues.put(pasl_operativo_bd.COLUMN_APATERNO, model.getApaterno());
        contentValues.put(pasl_operativo_bd.COLUMN_AMATERNO, model.getAmaterno());
        contentValues.put(pasl_operativo_bd.COLUMN_SEXO, model.getSexo());
        contentValues.put(pasl_operativo_bd.COLUMN_EDAD, model.getEdad());
        contentValues.put(pasl_operativo_bd.COLUMN_TIEMPO, model.getTiempo());
        contentValues.put(pasl_operativo_bd.COLUMN_UNO, model.getUno());
        contentValues.put(pasl_operativo_bd.COLUMN_DOS, model.getDos());
        contentValues.put(pasl_operativo_bd.COLUMN_TRES, model.getTres());
        contentValues.put(pasl_operativo_bd.COLUMN_CUATRO, model.getCuatro());
        contentValues.put(pasl_operativo_bd.COLUMN_CINCO, model.getCinco());
        contentValues.put(pasl_operativo_bd.COLUMN_SEIS, model.getSeis());
        contentValues.put(pasl_operativo_bd.COLUMN_SIETE, model.getSiete());
        contentValues.put(pasl_operativo_bd.COLUMN_OCHO, model.getOcho());
        contentValues.put(pasl_operativo_bd.COLUMN_NUEVE, model.getNueve());
        contentValues.put(pasl_operativo_bd.COLUMN_DIEZ, model.getDiez());
        contentValues.put(pasl_operativo_bd.COLUMN_ONCE, model.getOnce());
        contentValues.put(pasl_operativo_bd.COLUMN_DOCE, model.getDoce());
        contentValues.put(pasl_operativo_bd.COLUMN_DOCEOBSERVACIONES, model.getDoce_bservaciones());
        contentValues.put(pasl_operativo_bd.COLUMN_TRECE, model.getTrece());
        contentValues.put(pasl_operativo_bd.COLUMN_FOTO1, model.getFoto1());
        contentValues.put(pasl_operativo_bd.COLUMN_FOTO2, model.getFoto2());
        contentValues.put(pasl_operativo_bd.COLUMN_LONGITUD, model.getLongitudGeo());
        contentValues.put(pasl_operativo_bd.COLUMN_LATITUD, model.getLatitudGeo());

        long result = db.insert(pasl_operativo_bd.TABLA_BD, null, contentValues);
        db.close();

        if(result == -1) {
            return false;
        }else{
            return true;
        }

    }
}
