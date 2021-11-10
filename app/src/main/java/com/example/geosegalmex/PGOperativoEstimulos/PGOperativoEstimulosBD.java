package com.example.geosegalmex.PGOperativoEstimulos;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;

import com.example.geosegalmex.General;
import com.example.geosegalmex.Gps.UtilidadesTrayectoria;
import com.example.geosegalmex.Liconsa2.LiconsaVerificacion_bd;


public class PGOperativoEstimulosBD extends SQLiteOpenHelper {

    public static final String DB_NAME  = "PGOperativoEstimulos";
    public static final int DB_VERSION = 13;

    public PGOperativoEstimulosBD(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(PGOperativoEstimulos_bd.CREAR_TABLA_PG_OPERATIVO_ESTIMULOS);
        db.execSQL(UtilidadesTrayectoria.CREAR_TABLA_TRAYECTORIA);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ PGOperativoEstimulos_bd.TABLA_BD);
        db.execSQL("DROP TABLE IF EXISTS "+ UtilidadesTrayectoria.TABLA_TRAYECTORIA);
        onCreate(db);
    }

    public boolean addPGOperativoEstimulos(PGOperativoEstimulos_Model model){

        SQLiteDatabase db           = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(PGOperativoEstimulos_bd.COLUMN_FOLIO, model.getFolio());
        contentValues.put(PGOperativoEstimulos_bd.COLUMN_FECHA, model.getFecha());

        contentValues.put(PGOperativoEstimulos_bd.COLUMN_VENTANILLA, model.getVentanilla());
        contentValues.put(PGOperativoEstimulos_bd.COLUMN_CVEESTADO, model.getCveestado());
        contentValues.put(PGOperativoEstimulos_bd.COLUMN_ESTADO, model.getEstado());
        contentValues.put(PGOperativoEstimulos_bd.COLUMN_CVEMUNICIPIO, model.getCvemunicipio());
        contentValues.put(PGOperativoEstimulos_bd.COLUMN_MUNICIPIO, model.getMunicipio());
        contentValues.put(PGOperativoEstimulos_bd.COLUMN_CVELOCALIDAD, model.getCvelocalidad());
        contentValues.put(PGOperativoEstimulos_bd.COLUMN_LOCALIDAD, model.getLocalidad());
        contentValues.put(PGOperativoEstimulos_bd.COLUMN_CALLE, model.getCalle());
        contentValues.put(PGOperativoEstimulos_bd.COLUMN_CP, model.getCp());
        contentValues.put(PGOperativoEstimulos_bd.COLUMN_UNO, model.getUno());
        contentValues.put(PGOperativoEstimulos_bd.COLUMN_DOS, model.getDos());
        contentValues.put(PGOperativoEstimulos_bd.COLUMN_TRES, model.getTres());
        contentValues.put(PGOperativoEstimulos_bd.COLUMN_CUATRO, model.getCuatro());
        contentValues.put(PGOperativoEstimulos_bd.COLUMN_CINCO, model.getCinco());
        contentValues.put(PGOperativoEstimulos_bd.COLUMN_SEIS, model.getSeis());
        contentValues.put(PGOperativoEstimulos_bd.COLUMN_SIETE, model.getSiete());
        contentValues.put(PGOperativoEstimulos_bd.COLUMN_OCHO, model.getOcho());

        contentValues.put(PGOperativoEstimulos_bd.COLUMN_FOTO1, model.getFoto1());
        contentValues.put(PGOperativoEstimulos_bd.COLUMN_FOTO2, model.getFoto2());
        contentValues.put(PGOperativoEstimulos_bd.COLUMN_LONGITUD, model.getLongitudGeo());
        contentValues.put(PGOperativoEstimulos_bd.COLUMN_LATITUD, model.getLatitudGeo());

        long result = db.insert(PGOperativoEstimulos_bd.TABLA_BD, null, contentValues);
        db.close();

        if(result == -1) {
            return false;
        }else{
            return true;
        }
    }

    public void deletePGOperativoEstimulos(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DROP TABLE IF EXISTS "+ PGOperativoEstimulos_bd.TABLA_BD);
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
