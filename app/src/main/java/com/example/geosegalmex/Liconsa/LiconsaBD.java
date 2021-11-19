package com.example.geosegalmex.Liconsa;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;

import com.example.geosegalmex.General;
import com.example.geosegalmex.Gps.UtilidadesTrayectoria;
import com.example.geosegalmex.LiconsaBeneficiario.pasl_beneficiario_bd;

import java.io.File;

public class LiconsaBD extends SQLiteOpenHelper {

    public static final String DB_NAME  = "RNPLProductor";
    public static final int DB_VERSION = 15;

    public LiconsaBD(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Liconsa_bd.CREAR_TABLA_RNPL_PRODUCTOR);
        db.execSQL(UtilidadesTrayectoria.CREAR_TABLA_TRAYECTORIA);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ Liconsa_bd.TABLA_BD);
        db.execSQL("DROP TABLE IF EXISTS "+ UtilidadesTrayectoria.TABLA_TRAYECTORIA);
        onCreate(db);

    }

    public boolean addRNPLProductor(Liconsa_Model model){

        SQLiteDatabase db           = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(Liconsa_bd.COLUMN_FOLIO, model.getFol());
        contentValues.put(Liconsa_bd.COLUMN_NOM        , model.getNom());
        contentValues.put(Liconsa_bd.COLUMN_PATERNO    , model.getApp());
        contentValues.put(Liconsa_bd.COLUMN_MATERNO    , model.getApm());
        contentValues.put(Liconsa_bd.COLUMN_NACIMIENTO , model.getNac());
        contentValues.put(Liconsa_bd.COLUMN_SEXO       , model.getSexo());
        contentValues.put(Liconsa_bd.COLUMN_NACION     , model.getNacion());
        contentValues.put(Liconsa_bd.COLUMN_CURP       , model.getCurp());
        contentValues.put(Liconsa_bd.COLUMN_RFC        , model.getRfc());
        contentValues.put(Liconsa_bd.COLUMN_TIPOIDE    , model.getTipoide());
        contentValues.put(Liconsa_bd.COLUMN_NUMIDE     , model.getNumide());
        contentValues.put(Liconsa_bd.COLUMN_EMAIL      , model.getEmail());
        contentValues.put(Liconsa_bd.COLUMN_TEL        , model.getTel());
        contentValues.put(Liconsa_bd.COLUMN_TIPOTEL    , model.getTipotel());
        contentValues.put(Liconsa_bd.COLUMN_CALLE      , model.getCalle());
        contentValues.put(Liconsa_bd.COLUMN_EXT        , model.getExt());
        contentValues.put(Liconsa_bd.COLUMN_INT        , model.getInte());
        contentValues.put(Liconsa_bd.COLUMN_CP         , model.getCp());
        contentValues.put(Liconsa_bd.COLUMN_CVEEDO     , model.getCveEdo());
        contentValues.put(Liconsa_bd.COLUMN_ENTIDAD    , model.getEdo());
        contentValues.put(Liconsa_bd.COLUMN_CVEMUN     , model.getCveMun());
        contentValues.put(Liconsa_bd.COLUMN_MUN        , model.getMun());
        contentValues.put(Liconsa_bd.COLUMN_CVELOC     , model.getCveLoc());
        contentValues.put(Liconsa_bd.COLUMN_LOC        , model.getLoc());
        contentValues.put(Liconsa_bd.COLUMN_COL        , model.getColonia());
        contentValues.put(Liconsa_bd.COLUMN_TIPOASEN   , model.getTipoasen());
        contentValues.put(Liconsa_bd.COLUMN_NOMASEN    , model.getNomasen());
        contentValues.put(Liconsa_bd.COLUMN_CVEASEN    , model.getCveasen());
        contentValues.put(Liconsa_bd.COLUMN_VIALIDAD   , model.getVialidad());
        contentValues.put(Liconsa_bd.COLUMN_TIPOVIA    , model.getTipovialidad());
        contentValues.put(Liconsa_bd.COLUMN_CALLEUP     ,model.getCalleup());
        contentValues.put(Liconsa_bd.COLUMN_EXTUP     ,model.getExtup());
        contentValues.put(Liconsa_bd.COLUMN_INTUP     ,model.getIntup());
        contentValues.put(Liconsa_bd.COLUMN_CVELOCUP     ,model.getCveLocup());
        contentValues.put(Liconsa_bd.COLUMN_LOCUP     ,model.getDesclocup());
        contentValues.put(Liconsa_bd.COLUMN_COLUP     ,model.getColup());
        contentValues.put(Liconsa_bd.COLUMN_CPUP     ,model.getCpup());
        contentValues.put(Liconsa_bd.COLUMN_CVEEDOUP     ,model.getCveEdoup());
        contentValues.put(Liconsa_bd.COLUMN_ENTIDADUP     ,model.getEdoup());
        contentValues.put(Liconsa_bd.COLUMN_CVEMUNUP     ,model.getCveMunup());
        contentValues.put(Liconsa_bd.COLUMN_MUNUP     ,model.getMunup());
        contentValues.put(Liconsa_bd.COLUMN_ASOC       , model.getAsociacion());
        contentValues.put(Liconsa_bd.COLUMN_NOMASOC    , model.getNomaso());
        contentValues.put(Liconsa_bd.COLUMN_REGIMEN    , model.getRegimen());
        contentValues.put(Liconsa_bd.COLUMN_DISC       , model.getDiscapacidad());
        contentValues.put(Liconsa_bd.COLUMN_NOMDISC    , model.getNomdiscapacidad());
        contentValues.put(Liconsa_bd.COLUMN_INDI       , model.getIndigena());
        contentValues.put(Liconsa_bd.COLUMN_DECINDI    , model.getDeclaindigena());
        contentValues.put(Liconsa_bd.COLUMN_ESTATUS    , model.getEstatus());
        contentValues.put(Liconsa_bd.COLUMN_UPP        , model.getUpp());
        contentValues.put(Liconsa_bd.COLUMN_P1         , model.getP1());
        contentValues.put(Liconsa_bd.COLUMN_P2         , model.getP2());
        contentValues.put(Liconsa_bd.COLUMN_P3         , model.getP3());
        contentValues.put(Liconsa_bd.COLUMN_P4         , model.getP4());
        contentValues.put(Liconsa_bd.COLUMN_P5         , model.getP5());
        contentValues.put(Liconsa_bd.COLUMN_P6         , model.getP6());
        contentValues.put(Liconsa_bd.COLUMN_P7         , model.getP7());
        contentValues.put(Liconsa_bd.COLUMN_P8         , model.getP8());
        contentValues.put(Liconsa_bd.COLUMN_P9         , model.getP9());
        contentValues.put(Liconsa_bd.COLUMN_P9_1       , model.getP9_1());
        contentValues.put(Liconsa_bd.COLUMN_P9_2       , model.getP9_2());
        contentValues.put(Liconsa_bd.COLUMN_P10        , model.getP10());
        contentValues.put(Liconsa_bd.COLUMN_P10_1      , model.getP10_1());
        contentValues.put(Liconsa_bd.COLUMN_P11        , model.getP11());
        contentValues.put(Liconsa_bd.COLUMN_P12_1      , model.getP12_1());
        contentValues.put(Liconsa_bd.COLUMN_P12_2      , model.getP12_2());
        contentValues.put(Liconsa_bd.COLUMN_P12_3      , model.getP12_3());
        contentValues.put(Liconsa_bd.COLUMN_P12_4      , model.getP12_4());
        contentValues.put(Liconsa_bd.COLUMN_P12_4OTROS , model.getP12_4otros());
        contentValues.put(Liconsa_bd.COLUMN_P13        , model.getP13());
        contentValues.put(Liconsa_bd.COLUMN_P13_1      , model.getP13_1());
        contentValues.put(Liconsa_bd.COLUMN_P13_2      , model.getP13_2());
        contentValues.put(Liconsa_bd.COLUMN_P13_3      , model.getP13_3());
        contentValues.put(Liconsa_bd.COLUMN_P13_4      , model.getP13_4());
        contentValues.put(Liconsa_bd.COLUMN_P13_5      , model.getP13_5());
        contentValues.put(Liconsa_bd.COLUMN_P14        , model.getP14());
        contentValues.put(Liconsa_bd.COLUMN_P14_1      , model.getP14_1());
        contentValues.put(Liconsa_bd.COLUMN_P14_2      , model.getP14_2());
        contentValues.put(Liconsa_bd.COLUMN_P14_3      , model.getP14_3());
        contentValues.put(Liconsa_bd.COLUMN_P14_4      , model.getP14_4());
        contentValues.put(Liconsa_bd.COLUMN_P14_5      , model.getP14_5());
        contentValues.put(Liconsa_bd.COLUMN_P15_1      , model.getP15_1());
        contentValues.put(Liconsa_bd.COLUMN_P15_2      , model.getP15_2());
        contentValues.put(Liconsa_bd.COLUMN_P15_3      , model.getP15_3());
        contentValues.put(Liconsa_bd.COLUMN_P15_4      , model.getP15_4());
        contentValues.put(Liconsa_bd.COLUMN_P15_4OTROS , model.getP15_4otros());
        contentValues.put(Liconsa_bd.COLUMN_P16        , model.getP16());
        contentValues.put(Liconsa_bd.COLUMN_P16REGIS   , model.getP16_registro());
        contentValues.put(Liconsa_bd.COLUMN_P17        , model.getP17());
        contentValues.put(Liconsa_bd.COLUMN_P17REGIS   , model.getP17_registro());
        contentValues.put(Liconsa_bd.COLUMN_P18        , model.getP18());
        contentValues.put(Liconsa_bd.COLUMN_P19        , model.getP19());
        contentValues.put(Liconsa_bd.COLUMN_P20        , model.getP20());
        contentValues.put(Liconsa_bd.COLUMN_OBSERV     , model.getObservaciones());
        contentValues.put(Liconsa_bd.COLUMN_FOTO1, model.getFoto1());
        contentValues.put(Liconsa_bd.COLUMN_FOTO2, model.getFoto2());
        contentValues.put(Liconsa_bd.COLUMN_FOTO3, model.getFoto3());
        contentValues.put(Liconsa_bd.COLUMN_LONGITUD, model.getLongitudGeo());
        contentValues.put(Liconsa_bd.COLUMN_LATITUD, model.getLatitudGeo());

        long result = db.insert(Liconsa_bd.TABLA_BD, null, contentValues);
        db.close();

        if(result == -1) {
            return false;
        }else{
            return true;
        }
    }

    public void deleteRNPLProductor(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DROP TABLE IF EXISTS "+ Liconsa_bd.TABLA_BD);
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
