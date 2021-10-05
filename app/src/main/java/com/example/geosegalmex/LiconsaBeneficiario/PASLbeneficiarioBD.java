package com.example.geosegalmex.LiconsaBeneficiario;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class PASLbeneficiarioBD extends SQLiteOpenHelper {

    public static final String DB_NAME  = "PASLbeneficiario";
    public static final int DB_VERSION = 1;

    public PASLbeneficiarioBD(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(pasl_beneficiario_bd.CREAR_TABLA_PASL_BENEFICIARIO);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ pasl_beneficiario_bd.TABLA_BD);
    }

    public boolean addPASLbeneficiario(Pasl_b_Model model){

        SQLiteDatabase db           = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(pasl_beneficiario_bd.COLUMN_RESPONDE, model.getResponde());
        contentValues.put(pasl_beneficiario_bd.COLUMN_BENEFICIARIOS, model.getBeneficiarios());
        contentValues.put(pasl_beneficiario_bd.COLUMN_UNO, model.getUno());
        contentValues.put(pasl_beneficiario_bd.COLUMN_DOS, model.getDos());
        contentValues.put(pasl_beneficiario_bd.COLUMN_TRES, model.getTres());
        contentValues.put(pasl_beneficiario_bd.COLUMN_CUATRO, model.getCuatro());
        contentValues.put(pasl_beneficiario_bd.COLUMN_CINCO, model.getCinco());
        contentValues.put(pasl_beneficiario_bd.COLUMN_SEIS, model.getSeis());
        contentValues.put(pasl_beneficiario_bd.COLUMN_SIETE, model.getSiete());
        contentValues.put(pasl_beneficiario_bd.COLUMN_OCHO, model.getOcho());
        contentValues.put(pasl_beneficiario_bd.COLUMN_NUEVE, model.getNueve());
        contentValues.put(pasl_beneficiario_bd.COLUMN_DIEZ, model.getDiez());
        contentValues.put(pasl_beneficiario_bd.COLUMN_ONCE, model.getOnce());
        contentValues.put(pasl_beneficiario_bd.COLUMN_DOCE, model.getDoce());
        contentValues.put(pasl_beneficiario_bd.COLUMN_TRECE, model.getTrece());
        contentValues.put(pasl_beneficiario_bd.COLUMN_CATORCE, model.getCatorce());
        contentValues.put(pasl_beneficiario_bd.COLUMN_CATORCE_ESPE, model.getCatorceotrasespecificacion());
        contentValues.put(pasl_beneficiario_bd.COLUMN_QUINCE, model.getQuince());
        contentValues.put(pasl_beneficiario_bd.COLUMN_DIECISEIS, model.getDieciseis());
        contentValues.put(pasl_beneficiario_bd.COLUMN_FOTO1, model.getFoto1());
        contentValues.put(pasl_beneficiario_bd.COLUMN_FOTO2, model.getFoto2());
        contentValues.put(pasl_beneficiario_bd.COLUMN_LONGITUD, model.getLongitudGeo());
        contentValues.put(pasl_beneficiario_bd.COLUMN_LATITUD, model.getLatitudGeo());

        long result = db.insert(pasl_beneficiario_bd.TABLA_BD, null, contentValues);
        db.close();

        if(result == -1) {
            return false;
        }else{
            return true;
        }

    }

}
