package com.example.geosegalmex.PGOperativoGranos;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;

import com.example.geosegalmex.General;
import com.example.geosegalmex.Gps.UtilidadesTrayectoria;
import com.example.geosegalmex.Liconsa2.LiconsaVerificacion_bd;

public class PGOperativoGranosBD extends SQLiteOpenHelper {

    public static final String DB_NAME  = "PGOperativoGranos";
    public static final int DB_VERSION = 12;

    public PGOperativoGranosBD(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(PGOperativoGranos_bd.CREAR_TABLA_PG_OPERATIVO_GRANOS);
        db.execSQL(UtilidadesTrayectoria.CREAR_TABLA_TRAYECTORIA);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ PGOperativoGranos_bd.TABLA_BD);
        db.execSQL("DROP TABLE IF EXISTS "+ UtilidadesTrayectoria.TABLA_TRAYECTORIA);
        onCreate(db);
    }

    public boolean addPGOperativoGranos(PGOperativoGranos_Model model){

        SQLiteDatabase db           = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(PGOperativoGranos_bd.COLUMN_FOLIO, model.getFolio());
        contentValues.put(PGOperativoGranos_bd.COLUMN_FECHA, model.getFecha());
        contentValues.put(PGOperativoGranos_bd.COLUMN_CVEVENTANILLA, model.getCveventanilla());
        contentValues.put(PGOperativoGranos_bd.COLUMN_VENTANILLA, model.getVentanilla());
        contentValues.put(PGOperativoGranos_bd.COLUMN_CVEESTADO, model.getCveestado());
        contentValues.put(PGOperativoGranos_bd.COLUMN_ESTADO, model.getEstado());
        contentValues.put(PGOperativoGranos_bd.COLUMN_CVEMUNICIPIO, model.getCvemunicipio());
        contentValues.put(PGOperativoGranos_bd.COLUMN_MUNICIPIO, model.getMunicipio());
        contentValues.put(PGOperativoGranos_bd.COLUMN_CVELOCALIDAD, model.getCvelocalidad());
        contentValues.put(PGOperativoGranos_bd.COLUMN_LOCALIDAD, model.getLocalidad());
        contentValues.put(PGOperativoGranos_bd.COLUMN_CALLE, model.getCalle());
        contentValues.put(PGOperativoGranos_bd.COLUMN_CP, model.getCp());
        contentValues.put(PGOperativoGranos_bd.COLUMN_UNO, model.getUno());
        contentValues.put(PGOperativoGranos_bd.COLUMN_UNOOBS, model.getUnosobs());
        contentValues.put(PGOperativoGranos_bd.COLUMN_DOS, model.getDos());
        contentValues.put(PGOperativoGranos_bd.COLUMN_DOSOBS, model.getDosobs());
        contentValues.put(PGOperativoGranos_bd.COLUMN_TRES, model.getTres());
        contentValues.put(PGOperativoGranos_bd.COLUMN_TRESOBS, model.getTresobs());
        contentValues.put(PGOperativoGranos_bd.COLUMN_CUATROA, model.getCuatroa());
        contentValues.put(PGOperativoGranos_bd.COLUMN_CUATROB, model.getCuatrob());
        contentValues.put(PGOperativoGranos_bd.COLUMN_CUATROC, model.getCuatroc());
        contentValues.put(PGOperativoGranos_bd.COLUMN_CUATROD, model.getCuatrod());
        contentValues.put(PGOperativoGranos_bd.COLUMN_CINCOA, model.getCincoa());
        contentValues.put(PGOperativoGranos_bd.COLUMN_CINCOB, model.getCincob());
        contentValues.put(PGOperativoGranos_bd.COLUMN_CINCOC, model.getCincoc());
        contentValues.put(PGOperativoGranos_bd.COLUMN_CINCOD, model.getCincod());
        contentValues.put(PGOperativoGranos_bd.COLUMN_CINCOE, model.getCincoe());
        contentValues.put(PGOperativoGranos_bd.COLUMN_CINCOF, model.getCincof());
        contentValues.put(PGOperativoGranos_bd.COLUMN_CINCOOBS, model.getCincoobs());
        contentValues.put(PGOperativoGranos_bd.COLUMN_SEIS, model.getSeis());
        contentValues.put(PGOperativoGranos_bd.COLUMN_SEISOBS, model.getSeisobs());
        contentValues.put(PGOperativoGranos_bd.COLUMN_SIETE, model.getSiete());
        contentValues.put(PGOperativoGranos_bd.COLUMN_SIETEOBS, model.getSieteobs());
        contentValues.put(PGOperativoGranos_bd.COLUMN_OCHO, model.getOcho());
        contentValues.put(PGOperativoGranos_bd.COLUMN_OCHOOBS, model.getOchoobs());
        contentValues.put(PGOperativoGranos_bd.COLUMN_NUEVE, model.getNueve());
        contentValues.put(PGOperativoGranos_bd.COLUMN_NUEVEOBS, model.getNueveobs());
        contentValues.put(PGOperativoGranos_bd.COLUMN_DIEZ, model.getDiez());
        contentValues.put(PGOperativoGranos_bd.COLUMN_DIEZOBS, model.getDiezobs());
        contentValues.put(PGOperativoGranos_bd.COLUMN_ONCE, model.getOnce());
        contentValues.put(PGOperativoGranos_bd.COLUMN_ONCEOBS, model.getOnceobs());
        contentValues.put(PGOperativoGranos_bd.COLUMN_DOCE, model.getDoce());
        contentValues.put(PGOperativoGranos_bd.COLUMN_FOTO1, model.getFoto1());
        contentValues.put(PGOperativoGranos_bd.COLUMN_FOTO2, model.getFoto2());
        contentValues.put(PGOperativoGranos_bd.COLUMN_LONGITUD, model.getLongitudGeo());
        contentValues.put(PGOperativoGranos_bd.COLUMN_LATITUD, model.getLatitudGeo());

        long result = db.insert(PGOperativoGranos_bd.TABLA_BD, null, contentValues);
        db.close();

        if(result == -1) {
            return false;
        }else{
            return true;
        }
    }

    public void deletePGOperativoGranos(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DROP TABLE IF EXISTS "+ PGOperativoGranos_bd.TABLA_BD);
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
