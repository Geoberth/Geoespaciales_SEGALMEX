package com.example.geosegalmex.PGOperativoLeche;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;

import com.example.geosegalmex.General;
import com.example.geosegalmex.Gps.UtilidadesTrayectoria;
import com.example.geosegalmex.Liconsa2.LiconsaVerificacion_bd;

public class PGOperativoLecheBD extends SQLiteOpenHelper {

    public static final String DB_NAME  = "PGOperativoLeche";
    public static final int DB_VERSION = 12;

    public PGOperativoLecheBD(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(PGOperativoLeche_bd.CREAR_TABLA_PG_OPERATIVO_LECHE);
        db.execSQL(UtilidadesTrayectoria.CREAR_TABLA_TRAYECTORIA);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ PGOperativoLeche_bd.TABLA_BD);
        db.execSQL("DROP TABLE IF EXISTS "+ UtilidadesTrayectoria.TABLA_TRAYECTORIA);
        onCreate(db);
    }

    public boolean addPGOperativoLeche(PGOperativoLeche_Model model){

        SQLiteDatabase db           = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(PGOperativoLeche_bd.COLUMN_FOLIO, model.getFolio());
        contentValues.put(PGOperativoLeche_bd.COLUMN_FECHA, model.getFecha());
        contentValues.put(PGOperativoLeche_bd.COLUMN_CVEVENTANILLA, model.getCveventanilla());
        contentValues.put(PGOperativoLeche_bd.COLUMN_VENTANILLA, model.getVentanilla());
        contentValues.put(PGOperativoLeche_bd.COLUMN_CVEESTADO, model.getCveestado());
        contentValues.put(PGOperativoLeche_bd.COLUMN_ESTADO, model.getEstado());
        contentValues.put(PGOperativoLeche_bd.COLUMN_CVEMUNICIPIO, model.getCvemunicipio());
        contentValues.put(PGOperativoLeche_bd.COLUMN_MUNICIPIO, model.getMunicipio());
        contentValues.put(PGOperativoLeche_bd.COLUMN_CVELOCALIDAD, model.getCvelocalidad());
        contentValues.put(PGOperativoLeche_bd.COLUMN_LOCALIDAD, model.getLocalidad());
        contentValues.put(PGOperativoLeche_bd.COLUMN_CALLE, model.getCalle());
        contentValues.put(PGOperativoLeche_bd.COLUMN_CP, model.getCp());
        contentValues.put(PGOperativoLeche_bd.COLUMN_UNO, model.getUno());
        contentValues.put(PGOperativoLeche_bd.COLUMN_UNOOBS, model.getUnosobs());
        contentValues.put(PGOperativoLeche_bd.COLUMN_DOS, model.getDos());
        contentValues.put(PGOperativoLeche_bd.COLUMN_DOSOBS, model.getDosobs());
        contentValues.put(PGOperativoLeche_bd.COLUMN_TRES, model.getTres());
        contentValues.put(PGOperativoLeche_bd.COLUMN_TRESOBS, model.getTresobs());
        contentValues.put(PGOperativoLeche_bd.COLUMN_CUATRO, model.getCuatro());
        contentValues.put(PGOperativoLeche_bd.COLUMN_CUATROOBS, model.getCuatroobs());
        contentValues.put(PGOperativoLeche_bd.COLUMN_CINCO, model.getCinco());
        contentValues.put(PGOperativoLeche_bd.COLUMN_CINCOOBS, model.getCincoobs());
        contentValues.put(PGOperativoLeche_bd.COLUMN_SEIS, model.getSeis());
        contentValues.put(PGOperativoLeche_bd.COLUMN_SEISOBS, model.getSeisobs());
        contentValues.put(PGOperativoLeche_bd.COLUMN_SIETE, model.getSiete());
        contentValues.put(PGOperativoLeche_bd.COLUMN_SIETEOBS, model.getSieteobs());
        contentValues.put(PGOperativoLeche_bd.COLUMN_OCHO, model.getOcho());
        contentValues.put(PGOperativoLeche_bd.COLUMN_OCHOOBS, model.getOchoobs());
        contentValues.put(PGOperativoLeche_bd.COLUMN_NUEVE, model.getNueve());
        contentValues.put(PGOperativoLeche_bd.COLUMN_NUEVEOBS, model.getNueveobs());
        contentValues.put(PGOperativoLeche_bd.COLUMN_DIEZA, model.getDieza());
        contentValues.put(PGOperativoLeche_bd.COLUMN_DIEZB, model.getDiezb());
        contentValues.put(PGOperativoLeche_bd.COLUMN_DIEZC, model.getDiezc());
        contentValues.put(PGOperativoLeche_bd.COLUMN_DIEZD, model.getDiezd());
        contentValues.put(PGOperativoLeche_bd.COLUMN_DIEZE, model.getDieze());
        contentValues.put(PGOperativoLeche_bd.COLUMN_DIEZF, model.getDiezf());
        contentValues.put(PGOperativoLeche_bd.COLUMN_ONCE, model.getOnce());
        contentValues.put(PGOperativoLeche_bd.COLUMN_ONCEOBS, model.getOnceobs());
        contentValues.put(PGOperativoLeche_bd.COLUMN_ONCEB, model.getOnceb());
        contentValues.put(PGOperativoLeche_bd.COLUMN_ONCEBOBS, model.getOncebobs());
        contentValues.put(PGOperativoLeche_bd.COLUMN_DOCE, model.getDoce());
        contentValues.put(PGOperativoLeche_bd.COLUMN_DOCEOBS, model.getDoceobs());
        contentValues.put(PGOperativoLeche_bd.COLUMN_TRECE, model.getTrece());
        contentValues.put(PGOperativoLeche_bd.COLUMN_FOTO1, model.getFoto1());
        contentValues.put(PGOperativoLeche_bd.COLUMN_FOTO2, model.getFoto2());
        contentValues.put(PGOperativoLeche_bd.COLUMN_LONGITUD, model.getLongitudGeo());
        contentValues.put(PGOperativoLeche_bd.COLUMN_LATITUD, model.getLatitudGeo());

        long result = db.insert(PGOperativoLeche_bd.TABLA_BD, null, contentValues);
        db.close();

        if(result == -1) {
            return false;
        }else{
            return true;
        }
    }

    public void deletePGOperativoLeche(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DROP TABLE IF EXISTS "+ PGOperativoLeche_bd.TABLA_BD);
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
