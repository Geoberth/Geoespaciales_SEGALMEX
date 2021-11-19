package com.example.geosegalmex.Liconsa2;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;

import com.example.geosegalmex.General;
import com.example.geosegalmex.Gps.UtilidadesTrayectoria;
import com.example.geosegalmex.Liconsa.Liconsa_bd;

public class LiconsaVerificacionBD extends SQLiteOpenHelper {

    public static final String DB_NAME  = "RNPLExpediente";
    public static final int DB_VERSION = 14;

    public LiconsaVerificacionBD(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(LiconsaVerificacion_bd.CREAR_TABLA_RNPL_EXPEDIENTE);
        db.execSQL(UtilidadesTrayectoria.CREAR_TABLA_TRAYECTORIA);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ LiconsaVerificacion_bd.TABLA_BD);
        db.execSQL("DROP TABLE IF EXISTS "+ UtilidadesTrayectoria.TABLA_TRAYECTORIA);
        onCreate(db);
    }

    public boolean addRNPLExpediente(LiconsaVerificacion_Model model){

        SQLiteDatabase db           = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(LiconsaVerificacion_bd.COLUMN_FOLIO, model.getFol());
        contentValues.put(LiconsaVerificacion_bd.COLUMN_NOM        , model.getNom());
        contentValues.put(LiconsaVerificacion_bd.COLUMN_PATERNO    , model.getApp());
        contentValues.put(LiconsaVerificacion_bd.COLUMN_MATERNO    , model.getApm());
        contentValues.put(LiconsaVerificacion_bd.COLUMN_P21        , model.getP21());
        contentValues.put(LiconsaVerificacion_bd.COLUMN_P21CUAL    , model.getP21cual());
        contentValues.put(LiconsaVerificacion_bd.COLUMN_P22RFC     , model.getP22rfc());
        contentValues.put(LiconsaVerificacion_bd.COLUMN_P22CURP    , model.getP22curp());
        contentValues.put(LiconsaVerificacion_bd.COLUMN_P22CLABE   , model.getP22clabe());
        contentValues.put(LiconsaVerificacion_bd.COLUMN_CLABE      , model.getClabe());
        contentValues.put(LiconsaVerificacion_bd.COLUMN_P22DOM     , model.getP22dom());
        contentValues.put(LiconsaVerificacion_bd.COLUMN_DOM        , model.getDom());
        contentValues.put(LiconsaVerificacion_bd.COLUMN_P22ART50   , model.getP22art50());
        contentValues.put(LiconsaVerificacion_bd.COLUMN_P22ART32   , model.getP22art32());
        contentValues.put(LiconsaVerificacion_bd.COLUMN_P22CARTA   , model.getP22carta());
        contentValues.put(LiconsaVerificacion_bd.COLUMN_P22COD     , model.getP22cod());
        contentValues.put(LiconsaVerificacion_bd.COLUMN_COD        , model.getCod());
        contentValues.put(LiconsaVerificacion_bd.COLUMN_P22GER     , model.getP22ger());
        contentValues.put(LiconsaVerificacion_bd.COLUMN_GER        , model.getGer());
        contentValues.put(LiconsaVerificacion_bd.COLUMN_PRODUCTOR  , model.getProductor());
        contentValues.put(LiconsaVerificacion_bd.COLUMN_NOMPROD    , model.getNomproductor());
        contentValues.put(LiconsaVerificacion_bd.COLUMN_TIPOPROD   , model.getTipoproductor());
        contentValues.put(LiconsaVerificacion_bd.COLUMN_OBSERV     , model.getObs());
        contentValues.put(LiconsaVerificacion_bd.COLUMN_LONGITUD, model.getLongitudGeo());
        contentValues.put(LiconsaVerificacion_bd.COLUMN_LATITUD, model.getLatitudGeo());

        long result = db.insert(LiconsaVerificacion_bd.TABLA_BD, null, contentValues);
        db.close();

        if(result == -1) {
            return false;
        }else{
            return true;
        }
    }

    public void deleteRNPLExpediente(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DROP TABLE IF EXISTS "+ LiconsaVerificacion_bd.TABLA_BD);
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
