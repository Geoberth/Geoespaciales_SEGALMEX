package com.example.geosegalmex.PARBeneficiario;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;

import com.example.geosegalmex.General;
import com.example.geosegalmex.Gps.UtilidadesTrayectoria;
import com.example.geosegalmex.Liconsa2.LiconsaVerificacion_bd;

public class PARBeneficiarioBD extends SQLiteOpenHelper {

    public static final String DB_NAME  = "PARBeneficiario";
    public static final int DB_VERSION = 12;

    public PARBeneficiarioBD(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(PARBeneficiario_bd.CREAR_TABLA_PAR_BENEFICIARIO);
        db.execSQL(UtilidadesTrayectoria.CREAR_TABLA_TRAYECTORIA);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ PARBeneficiario_bd.TABLA_BD);
        db.execSQL("DROP TABLE IF EXISTS "+ UtilidadesTrayectoria.TABLA_TRAYECTORIA);
        onCreate(db);
    }

    public boolean addPARBeneficiario(PARBeneficiario_Model model){

        SQLiteDatabase db           = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(PARBeneficiario_bd.COLUMN_FOLIOPERA, model.getFolope());
        contentValues.put(PARBeneficiario_bd.COLUMN_FOLIO, model.getFol());
        contentValues.put(PARBeneficiario_bd.COLUMN_FECHA    , model.getFecha());
        contentValues.put(PARBeneficiario_bd.COLUMN_CVEEDO   , model.getCveedo());
        contentValues.put(PARBeneficiario_bd.COLUMN_ENTIDAD  , model.getEdo());
        contentValues.put(PARBeneficiario_bd.COLUMN_CVEMUN   , model.getCvemun());
        contentValues.put(PARBeneficiario_bd.COLUMN_MUNICIPIO, model.getMun());
        contentValues.put(PARBeneficiario_bd.COLUMN_CVELOC   , model.getCveloc());
        contentValues.put(PARBeneficiario_bd.COLUMN_LOCALIDAD, model.getLoc());
        contentValues.put(PARBeneficiario_bd.COLUMN_SEXO     , model.getSexo());
        contentValues.put(PARBeneficiario_bd.COLUMN_EDAD     , model.getEdad());
        contentValues.put(PARBeneficiario_bd.COLUMN_P1       , model.getP1());
        contentValues.put(PARBeneficiario_bd.COLUMN_P2       , model.getP2());
        contentValues.put(PARBeneficiario_bd.COLUMN_P3       , model.getP3());
        contentValues.put(PARBeneficiario_bd.COLUMN_P4       , model.getP4());
        contentValues.put(PARBeneficiario_bd.COLUMN_P5       , model.getP5());
        contentValues.put(PARBeneficiario_bd.COLUMN_P5CUAL   , model.getP5cuales());
        contentValues.put(PARBeneficiario_bd.COLUMN_P6       , model.getP6());
        contentValues.put(PARBeneficiario_bd.COLUMN_P7       , model.getP7());
        contentValues.put(PARBeneficiario_bd.COLUMN_P7CUAL   , model.getP7cuales());
        contentValues.put(PARBeneficiario_bd.COLUMN_P8       , model.getP8());
        contentValues.put(PARBeneficiario_bd.COLUMN_P9       , model.getP9());
        contentValues.put(PARBeneficiario_bd.COLUMN_P10      , model.getP10());
        contentValues.put(PARBeneficiario_bd.COLUMN_P11      , model.getP11());
        contentValues.put(PARBeneficiario_bd.COLUMN_P12      , model.getP12());
        contentValues.put(PARBeneficiario_bd.COLUMN_P13      , model.getP13());
        contentValues.put(PARBeneficiario_bd.COLUMN_P13CUAL  , model.getP13cuales());
        contentValues.put(PARBeneficiario_bd.COLUMN_P14      , model.getP14());
        contentValues.put(PARBeneficiario_bd.COLUMN_P15      , model.getP15());
        contentValues.put(PARBeneficiario_bd.COLUMN_P16      , model.getP16());
        contentValues.put(PARBeneficiario_bd.COLUMN_P17      , model.getP17());
        contentValues.put(PARBeneficiario_bd.COLUMN_P17CUAL  , model.getP17cuales());
        contentValues.put(PARBeneficiario_bd.COLUMN_P18      , model.getP18());
        contentValues.put(PARBeneficiario_bd.COLUMN_P19      , model.getP19());
        contentValues.put(PARBeneficiario_bd.COLUMN_P19CUAL  , model.getP19cuales());
        contentValues.put(PARBeneficiario_bd.COLUMN_P20      , model.getP20());
        contentValues.put(PARBeneficiario_bd.COLUMN_P21      , model.getP21());
        contentValues.put(PARBeneficiario_bd.COLUMN_P22      , model.getP22());
        contentValues.put(PARBeneficiario_bd.COLUMN_P23      , model.getP23());
        contentValues.put(PARBeneficiario_bd.COLUMN_P23EXP   , model.getP23explique());
        contentValues.put(PARBeneficiario_bd.COLUMN_P24   , model.getP24());
        contentValues.put(PARBeneficiario_bd.COLUMN_P25   , model.getP25());
        contentValues.put(PARBeneficiario_bd.COLUMN_P25OTRO  , model.getP25otro());
        contentValues.put(PARBeneficiario_bd.COLUMN_P26      , model.getP26());
        contentValues.put(PARBeneficiario_bd.COLUMN_P26OTRO  , model.getP26otro());
        contentValues.put(PARBeneficiario_bd.COLUMN_P27      , model.getP27());
        contentValues.put(PARBeneficiario_bd.COLUMN_FOTO1, model.getFoto1());
        contentValues.put(PARBeneficiario_bd.COLUMN_FOTO2, model.getFoto2());
        contentValues.put(PARBeneficiario_bd.COLUMN_LONGITUD, model.getLongitudGeo());
        contentValues.put(PARBeneficiario_bd.COLUMN_LATITUD, model.getLatitudGeo());

        long result = db.insert(PARBeneficiario_bd.TABLA_BD, null, contentValues);
        db.close();

        if(result == -1) {
            return false;
        }else{
            return true;
        }
    }

    public void deletePARBeneficiario(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DROP TABLE IF EXISTS "+ PARBeneficiario_bd.TABLA_BD);
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
