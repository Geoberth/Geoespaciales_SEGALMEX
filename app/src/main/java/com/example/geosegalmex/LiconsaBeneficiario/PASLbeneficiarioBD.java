package com.example.geosegalmex.LiconsaBeneficiario;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;

import com.example.geosegalmex.General;
import com.example.geosegalmex.Gps.UtilidadesTrayectoria;
import com.example.geosegalmex.LiconsaVentanilla.pasl_operativo_bd;


public class PASLbeneficiarioBD extends SQLiteOpenHelper {

    public static final String DB_NAME  = "PASLBeneficiario";
    public static final int DB_VERSION = 13;

    public PASLbeneficiarioBD(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(pasl_beneficiario_bd.CREAR_TABLA_PASL_BENEFICIARIO);
        db.execSQL(UtilidadesTrayectoria.CREAR_TABLA_TRAYECTORIA);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ pasl_beneficiario_bd.TABLA_BD);
        db.execSQL("DROP TABLE IF EXISTS "+ UtilidadesTrayectoria.TABLA_TRAYECTORIA);
        onCreate(db);
    }

    public boolean addPASLbeneficiario(Pasl_b_Model model){

        SQLiteDatabase db           = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(pasl_beneficiario_bd.COLUMN_FOLIOPE, model.getFoliope());
        contentValues.put(pasl_beneficiario_bd.COLUMN_FOLIO, model.getFolio());
        contentValues.put(pasl_beneficiario_bd.COLUMN_RES, model.getRes());
        contentValues.put(pasl_beneficiario_bd.COLUMN_OBENEFI, model.getObene());
        contentValues.put(pasl_beneficiario_bd.COLUMN_BENEFI, model.getBene());
        contentValues.put(pasl_beneficiario_bd.COLUMN_UNO, model.getUno());
        contentValues.put(pasl_beneficiario_bd.COLUMN_DOS, model.getDos());
        contentValues.put(pasl_beneficiario_bd.COLUMN_TRES, model.getTres());
        contentValues.put(pasl_beneficiario_bd.COLUMN_CUATRO, model.getCuatro());
        contentValues.put(pasl_beneficiario_bd.COLUMN_CUATROCO, model.getCuatroco());
        contentValues.put(pasl_beneficiario_bd.COLUMN_CINCO, model.getCinco());
        contentValues.put(pasl_beneficiario_bd.COLUMN_CINCOCO, model.getCincoco());
        contentValues.put(pasl_beneficiario_bd.COLUMN_SEIS, model.getSeis());
        contentValues.put(pasl_beneficiario_bd.COLUMN_SEISCO, model.getSeisco());
        contentValues.put(pasl_beneficiario_bd.COLUMN_SIETE, model.getSiete());
        contentValues.put(pasl_beneficiario_bd.COLUMN_SIETECO, model.getSieteco());
        contentValues.put(pasl_beneficiario_bd.COLUMN_OCHO, model.getOcho());
        contentValues.put(pasl_beneficiario_bd.COLUMN_OCHOCO, model.getOchoco());
        contentValues.put(pasl_beneficiario_bd.COLUMN_NUEVE, model.getNueve());
        contentValues.put(pasl_beneficiario_bd.COLUMN_NUEVECO, model.getNueveco());
        contentValues.put(pasl_beneficiario_bd.COLUMN_DIEZ, model.getDiez());
        contentValues.put(pasl_beneficiario_bd.COLUMN_DIEZCO, model.getDiezco());
        contentValues.put(pasl_beneficiario_bd.COLUMN_ONCE, model.getOnce());
        contentValues.put(pasl_beneficiario_bd.COLUMN_ONCECO, model.getOnceco());
        contentValues.put(pasl_beneficiario_bd.COLUMN_DOCE, model.getDoce());
        contentValues.put(pasl_beneficiario_bd.COLUMN_DOCECO, model.getDoceco());
        contentValues.put(pasl_beneficiario_bd.COLUMN_TRECE, model.getTrece());
        contentValues.put(pasl_beneficiario_bd.COLUMN_TRECECO, model.getTrececo());
        contentValues.put(pasl_beneficiario_bd.COLUMN_CATORCE, model.getCatorce());
        contentValues.put(pasl_beneficiario_bd.COLUMN_CATORCECO, model.getCatorceco());
        contentValues.put(pasl_beneficiario_bd.COLUMN_QUINCE, model.getQuince());
        contentValues.put(pasl_beneficiario_bd.COLUMN_QUINCECO, model.getQuinceco());
        contentValues.put(pasl_beneficiario_bd.COLUMN_DIECISEIS, model.getDieciseiss());
        contentValues.put(pasl_beneficiario_bd.COLUMN_DIECISIETE, model.getDiecisietes());
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

    public void deletePASLbeneficiario(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DROP TABLE IF EXISTS "+ pasl_beneficiario_bd.TABLA_BD);
        db.execSQL("DROP TABLE IF EXISTS "+ UtilidadesTrayectoria.TABLA_TRAYECTORIA);
        onCreate(db);
        if (android.os.Build.VERSION.SDK_INT == Build.VERSION_CODES.P){
            db.close();
        }
    }

    public boolean addTrayectoriaS(String folioPro, String folioBrig, String longGpsSave, String latiGpsSave, String horaActl, String fechaActl){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        //contentValues.put(UtilidadesTrayectoria.COLUMN_FOLIO,folioPro);
        contentValues.put(UtilidadesTrayectoria.COLUMN_FOLIO, General.Foliocuestion);
        //contentValues.put(UtilidadesTrayectoria.COLUMN_FOLIO_TECNICO,Principal.userId);
        contentValues.put(UtilidadesTrayectoria.COLUMN_LONGITUD_TRAY,latiGpsSave);
        contentValues.put(UtilidadesTrayectoria.COLUMN_LATITUD_TRAY,longGpsSave);
        contentValues.put(UtilidadesTrayectoria.COLUMN_HRACTUAL_TRAY,horaActl);
        contentValues.put(UtilidadesTrayectoria.COLUMN_FCACTUAL_TRAY,fechaActl);

        long result = db.insert(UtilidadesTrayectoria.TABLA_TRAYECTORIA, null, contentValues);
        db.close();
        if(result == -1) {
            return false;
        }else{
            return true;
        }
    }

}
