package com.example.geosegalmex.PGBeneficiarioGranos;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;

import com.example.geosegalmex.General;
import com.example.geosegalmex.Gps.UtilidadesTrayectoria;
import com.example.geosegalmex.Liconsa2.LiconsaVerificacion_bd;

public class PGBgranosBD extends SQLiteOpenHelper {

    public static final String DB_NAME = "PGBeneficiarioGranos";
    public static final int DB_VERSION = 15;

    public PGBgranosBD(Context context) {super(context, DB_NAME, null, DB_VERSION);}

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(PGB_granos_bd.CREAR_TABLA_PGBENEFICIARIO_GRANOS);
        db.execSQL(UtilidadesTrayectoria.CREAR_TABLA_TRAYECTORIA);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ PGB_granos_bd.TABLA_BD);
        db.execSQL("DROP TABLE IF EXISTS "+ UtilidadesTrayectoria.TABLA_TRAYECTORIA);
        onCreate(db);
    }

    public boolean addPGBeneficiarioGranos(PGB_granos_model model){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(PGB_granos_bd.COLUMN_FOLIO, model.getFolio());
        contentValues.put(PGB_granos_bd.COLUMN_FECHAENC, model.getFechaenc());
        contentValues.put(PGB_granos_bd.COLUMN_PGBTT2, model.getPgbtt2());
        contentValues.put(PGB_granos_bd.COLUMN_PGBTT3, model.getPgbtt3());
        contentValues.put(PGB_granos_bd.COLUMN_PGBTT4, model.getPgbtt4());
        contentValues.put(PGB_granos_bd.COLUMN_PGBTT5, model.getPgbtt5());
        contentValues.put(PGB_granos_bd.COLUMN_PGBTT6, model.getPgbtt6());
        contentValues.put(PGB_granos_bd.COLUMN_PGBTT7, model.getPgbtt7());
        contentValues.put(PGB_granos_bd.COLUMN_PGBTT8, model.getPgbtt8());
        contentValues.put(PGB_granos_bd.COLUMN_PGBTT9, model.getPgbtt9());
        contentValues.put(PGB_granos_bd.COLUMN_PGBTT10, model.getPgbtt10());
        contentValues.put(PGB_granos_bd.COLUMN_NOMEDO, model.getNomedo());
        contentValues.put(PGB_granos_bd.COLUMN_CVEEDO, model.getCveedo());
        contentValues.put(PGB_granos_bd.COLUMN_NOMMUN, model.getNommun());
        contentValues.put(PGB_granos_bd.COLUMN_CVEMUN, model.getCvemun());
        contentValues.put(PGB_granos_bd.COLUMN_PGBTT13, model.getPgbtt13());
        contentValues.put(PGB_granos_bd.COLUMN_PGBTT14, model.getPgbtt14());
        contentValues.put(PGB_granos_bd.COLUMN_PGBTT15, model.getPgbtt15());
        contentValues.put(PGB_granos_bd.COLUMN_PGBTT16, model.getPgbtt16());
        contentValues.put(PGB_granos_bd.COLUMN_PGBTT17, model.getPgbtt17());
        contentValues.put(PGB_granos_bd.COLUMN_NOMEDO2, model.getNomedo2());
        contentValues.put(PGB_granos_bd.COLUMN_CVEEDO2, model.getCveedo2());
        contentValues.put(PGB_granos_bd.COLUMN_NOMMUN2, model.getNommun2());
        contentValues.put(PGB_granos_bd.COLUMN_CVEMUN2, model.getCvemun2());
        contentValues.put(PGB_granos_bd.COLUMN_PGR1, model.getPgr1());
        contentValues.put(PGB_granos_bd.COLUMN_PGBTT20, model.getPgbtt20());
        contentValues.put(PGB_granos_bd.COLUMN_PGR2, model.getPgr2());
        contentValues.put(PGB_granos_bd.COLUMN_PGR3, model.getPgr3());
        contentValues.put(PGB_granos_bd.COLUMN_PGBTT21, model.getPgbtt21());
        contentValues.put(PGB_granos_bd.COLUMN_PGR4, model.getPgr4());
        contentValues.put(PGB_granos_bd.COLUMN_PGBTT22, model.getPgbtt22());
        contentValues.put(PGB_granos_bd.COLUMN_PGBTT23, model.getPgbtt23());
        contentValues.put(PGB_granos_bd.COLUMN_PGBTT24, model.getPgbtt24());
        contentValues.put(PGB_granos_bd.COLUMN_PGAPOYO1, model.getPgapoyo1());
        contentValues.put(PGB_granos_bd.COLUMN_PGAPOYO2, model.getPgapoyo2());
        contentValues.put(PGB_granos_bd.COLUMN_PGAPOYO3, model.getPgapoyo3());
        contentValues.put(PGB_granos_bd.COLUMN_PGAPOYO4, model.getPgapoyo4());
        contentValues.put(PGB_granos_bd.COLUMN_PGAPOYO5, model.getPgapoyo5());
        contentValues.put(PGB_granos_bd.COLUMN_PGAPOYO6, model.getPgapoyo6());
        contentValues.put(PGB_granos_bd.COLUMN_PGAPOYO7, model.getPgapoyo7());
        contentValues.put(PGB_granos_bd.COLUMN_PGAPOYO8, model.getPgapoyo8());
        contentValues.put(PGB_granos_bd.COLUMN_PGAPOYO9, model.getPgapoyo9());
        contentValues.put(PGB_granos_bd.COLUMN_PGAPOYO10, model.getPgapoyo10());
        contentValues.put(PGB_granos_bd.COLUMN_PGR5, model.getPgr5());
        contentValues.put(PGB_granos_bd.COLUMN_PGR6, model.getPgr6());
        contentValues.put(PGB_granos_bd.COLUMN_PGR7, model.getPgr7());
        contentValues.put(PGB_granos_bd.COLUMN_PGR8, model.getPgr8());
        contentValues.put(PGB_granos_bd.COLUMN_PGR9, model.getPgr9());
        contentValues.put(PGB_granos_bd.COLUMN_PGR10, model.getPgr10());
        contentValues.put(PGB_granos_bd.COLUMN_PGR11, model.getPgr11());
        contentValues.put(PGB_granos_bd.COLUMN_PGR12, model.getPgr12());
        contentValues.put(PGB_granos_bd.COLUMN_PGR13, model.getPgr13());
        contentValues.put(PGB_granos_bd.COLUMN_PGR14, model.getPgr14());
        contentValues.put(PGB_granos_bd.COLUMN_PGR15, model.getPgr15());
        contentValues.put(PGB_granos_bd.COLUMN_PGR16, model.getPgr16());
        contentValues.put(PGB_granos_bd.COLUMN_PGR17, model.getPgr17());
        contentValues.put(PGB_granos_bd.COLUMN_PGR18, model.getPgr18());
        contentValues.put(PGB_granos_bd.COLUMN_PGR19, model.getPgr19());
        contentValues.put(PGB_granos_bd.COLUMN_PGR20, model.getPgr20());
        contentValues.put(PGB_granos_bd.COLUMN_PGR26, model.getPgr26());
        contentValues.put(PGB_granos_bd.COLUMN_PGR27, model.getPgr27());
        contentValues.put(PGB_granos_bd.COLUMN_PGR28, model.getPgr28());
        contentValues.put(PGB_granos_bd.COLUMN_PGR29, model.getPgr29());
        contentValues.put(PGB_granos_bd.COLUMN_PGR30, model.getPgr30());
        contentValues.put(PGB_granos_bd.COLUMN_PGR31, model.getPgr31());
        contentValues.put(PGB_granos_bd.COLUMN_PGR32, model.getPgr32());
        contentValues.put(PGB_granos_bd.COLUMN_PGRE1, model.getPgre1());
        contentValues.put(PGB_granos_bd.COLUMN_PGRE2, model.getPgre2());
        contentValues.put(PGB_granos_bd.COLUMN_PGRE3, model.getPgre3());
        contentValues.put(PGB_granos_bd.COLUMN_PGRE4, model.getPgre4());
        contentValues.put(PGB_granos_bd.COLUMN_PGRE5, model.getPgre5());
        contentValues.put(PGB_granos_bd.COLUMN_PGRE6, model.getPgre6());
        contentValues.put(PGB_granos_bd.COLUMN_PGRE7, model.getPgre7());
        contentValues.put(PGB_granos_bd.COLUMN_PGRE8, model.getPgre8());
        contentValues.put(PGB_granos_bd.COLUMN_PGRE9, model.getPgre9());
        contentValues.put(PGB_granos_bd.COLUMN_PGGBTT25, model.getPgbtt25());
        contentValues.put(PGB_granos_bd.COLUMN_PGGBTT26, model.getPgbtt26());
        contentValues.put(PGB_granos_bd.COLUMN_PGGBTT27, model.getPgbtt27());
        contentValues.put(PGB_granos_bd.COLUMN_PGGBTT28, model.getPgbtt28());
        contentValues.put(PGB_granos_bd.COLUMN_PGGBTT29, model.getPgbtt29());
        contentValues.put(PGB_granos_bd.COLUMN_FOTO1, model.getFoto1());
        contentValues.put(PGB_granos_bd.COLUMN_FOTO2, model.getFoto2());
        contentValues.put(PGB_granos_bd.COLUMN_LONGITUDGEO, model.getLongitudGeo());
        contentValues.put(PGB_granos_bd.COLUMN_LATITUDGEO, model.getLatitudGeo());

        long result = db.insert(PGB_granos_bd.TABLA_BD, null, contentValues);
        db.close();

        if(result == -1){
            return false;
        }else{
            return true;
        }

    }

    public void deletePGBeneficiarioGranos(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DROP TABLE IF EXISTS "+ PGB_granos_bd.TABLA_BD);
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