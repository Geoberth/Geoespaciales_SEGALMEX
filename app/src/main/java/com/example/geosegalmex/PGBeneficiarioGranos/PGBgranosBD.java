package com.example.geosegalmex.PGBeneficiarioGranos;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.geosegalmex.General;
import com.example.geosegalmex.Gps.UtilidadesTrayectoria;

public class PGBgranosBD extends SQLiteOpenHelper {

    public static final String DB_NAME = "PGBeneficiario_Granos";
    public static final int DB_VERSION = 1;

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
    }

    public boolean addPGBeneficiarioGranos(PGB_granos_model model){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(PGB_granos_bd.COLUMN_FOLIO, model.getFolio());
        contentValues.put(PGB_granos_bd.COLUMN_PGBTT2, model.getFolio());
        contentValues.put(PGB_granos_bd.COLUMN_PGBTT3, model.getFolio());
        contentValues.put(PGB_granos_bd.COLUMN_PGBTT4, model.getFolio());
        contentValues.put(PGB_granos_bd.COLUMN_PGBTT5, model.getFolio());
        contentValues.put(PGB_granos_bd.COLUMN_TPRODU, model.getFolio());
        contentValues.put(PGB_granos_bd.COLUMN_PGBTT6, model.getFolio());
        contentValues.put(PGB_granos_bd.COLUMN_PGBTT7, model.getFolio());
        contentValues.put(PGB_granos_bd.COLUMN_PGBTT8, model.getFolio());
        contentValues.put(PGB_granos_bd.COLUMN_PGBTT9, model.getFolio());
        contentValues.put(PGB_granos_bd.COLUMN_PGBTT10, model.getFolio());
        contentValues.put(PGB_granos_bd.COLUMN_PGBTT11, model.getFolio());
        contentValues.put(PGB_granos_bd.COLUMN_PGBTT12, model.getFolio());
        contentValues.put(PGB_granos_bd.COLUMN_PGBTT13, model.getFolio());
        contentValues.put(PGB_granos_bd.COLUMN_PGBTT14, model.getFolio());
        contentValues.put(PGB_granos_bd.COLUMN_PGBTT15, model.getFolio());
        contentValues.put(PGB_granos_bd.COLUMN_PGBTT16, model.getFolio());
        contentValues.put(PGB_granos_bd.COLUMN_PGBTT17, model.getFolio());
        contentValues.put(PGB_granos_bd.COLUMN_NOMEDO, model.getFolio());
        contentValues.put(PGB_granos_bd.COLUMN_CVEEDO, model.getFolio());
        contentValues.put(PGB_granos_bd.COLUMN_NOMMUN, model.getFolio());
        contentValues.put(PGB_granos_bd.COLUMN_CVEMUN, model.getFolio());
        contentValues.put(PGB_granos_bd.COLUMN_PGR1, model.getFolio());
        contentValues.put(PGB_granos_bd.COLUMN_PGBTT20, model.getFolio());
        contentValues.put(PGB_granos_bd.COLUMN_PGR2, model.getFolio());
        contentValues.put(PGB_granos_bd.COLUMN_PGR3, model.getFolio());
        contentValues.put(PGB_granos_bd.COLUMN_PGBTT21, model.getFolio());
        contentValues.put(PGB_granos_bd.COLUMN_PGBTT22, model.getFolio());
        contentValues.put(PGB_granos_bd.COLUMN_PGBTT23, model.getFolio());
        contentValues.put(PGB_granos_bd.COLUMN_PGBTT24, model.getFolio());
        contentValues.put(PGB_granos_bd.COLUMN_PGAPOYO1, model.getFolio());
        contentValues.put(PGB_granos_bd.COLUMN_PGAPOYO2, model.getFolio());
        contentValues.put(PGB_granos_bd.COLUMN_PGAPOYO3, model.getFolio());
        contentValues.put(PGB_granos_bd.COLUMN_PGAPOYO4, model.getFolio());
        contentValues.put(PGB_granos_bd.COLUMN_PGAPOYO5, model.getFolio());
        contentValues.put(PGB_granos_bd.COLUMN_PGAPOYO6, model.getFolio());
        contentValues.put(PGB_granos_bd.COLUMN_PGAPOYO7, model.getFolio());
        contentValues.put(PGB_granos_bd.COLUMN_PGAPOYO8, model.getFolio());
        contentValues.put(PGB_granos_bd.COLUMN_PGAPOYO9, model.getFolio());
        contentValues.put(PGB_granos_bd.COLUMN_PGAPOYO10, model.getFolio());
        contentValues.put(PGB_granos_bd.COLUMN_PGR5, model.getFolio());
        contentValues.put(PGB_granos_bd.COLUMN_PGR6, model.getFolio());
        contentValues.put(PGB_granos_bd.COLUMN_PGR7, model.getFolio());
        contentValues.put(PGB_granos_bd.COLUMN_PGR8, model.getFolio());
        contentValues.put(PGB_granos_bd.COLUMN_PGR9, model.getFolio());
        contentValues.put(PGB_granos_bd.COLUMN_PGR10, model.getFolio());
        contentValues.put(PGB_granos_bd.COLUMN_PGR11, model.getFolio());
        contentValues.put(PGB_granos_bd.COLUMN_PGR12, model.getFolio());
        contentValues.put(PGB_granos_bd.COLUMN_PGR13, model.getFolio());
        contentValues.put(PGB_granos_bd.COLUMN_PGR14, model.getFolio());
        contentValues.put(PGB_granos_bd.COLUMN_PGR15, model.getFolio());
        contentValues.put(PGB_granos_bd.COLUMN_PGR16, model.getFolio());
        contentValues.put(PGB_granos_bd.COLUMN_PGR17, model.getFolio());
        contentValues.put(PGB_granos_bd.COLUMN_PGR18, model.getFolio());
        contentValues.put(PGB_granos_bd.COLUMN_PGR19, model.getFolio());
        contentValues.put(PGB_granos_bd.COLUMN_PGR20, model.getFolio());
        contentValues.put(PGB_granos_bd.COLUMN_PGR21, model.getFolio());
        contentValues.put(PGB_granos_bd.COLUMN_PGR22, model.getFolio());
        contentValues.put(PGB_granos_bd.COLUMN_PGR23, model.getFolio());
        contentValues.put(PGB_granos_bd.COLUMN_PGR24, model.getFolio());
        contentValues.put(PGB_granos_bd.COLUMN_PGR25, model.getFolio());
        contentValues.put(PGB_granos_bd.COLUMN_PGR26, model.getFolio());
        contentValues.put(PGB_granos_bd.COLUMN_PGR27, model.getFolio());
        contentValues.put(PGB_granos_bd.COLUMN_PGR28, model.getFolio());
        contentValues.put(PGB_granos_bd.COLUMN_PGR29, model.getFolio());
        contentValues.put(PGB_granos_bd.COLUMN_PGR30, model.getFolio());
        contentValues.put(PGB_granos_bd.COLUMN_PGR31, model.getFolio());
        contentValues.put(PGB_granos_bd.COLUMN_PGR32, model.getFolio());
        contentValues.put(PGB_granos_bd.COLUMN_PGRE1, model.getFolio());
        contentValues.put(PGB_granos_bd.COLUMN_PGRE2, model.getFolio());
        contentValues.put(PGB_granos_bd.COLUMN_PGRE3, model.getFolio());
        contentValues.put(PGB_granos_bd.COLUMN_PGRE4, model.getFolio());
        contentValues.put(PGB_granos_bd.COLUMN_PGRE5, model.getFolio());
        contentValues.put(PGB_granos_bd.COLUMN_PGRE6, model.getFolio());
        contentValues.put(PGB_granos_bd.COLUMN_PGRE7, model.getFolio());
        contentValues.put(PGB_granos_bd.COLUMN_PGRE8, model.getFolio());
        contentValues.put(PGB_granos_bd.COLUMN_PGRE9, model.getFolio());
        contentValues.put(PGB_granos_bd.COLUMN_PGGBTT25, model.getFolio());
        contentValues.put(PGB_granos_bd.COLUMN_PGGBTT26, model.getFolio());
        contentValues.put(PGB_granos_bd.COLUMN_PGGBTT27, model.getFolio());
        contentValues.put(PGB_granos_bd.COLUMN_PGGBTT28, model.getFolio());
        contentValues.put(PGB_granos_bd.COLUMN_PGGBTT29, model.getFolio());
        contentValues.put(PGB_granos_bd.COLUMN_FOTO1, model.getFolio());
        contentValues.put(PGB_granos_bd.COLUMN_FOTO2, model.getFolio());
        contentValues.put(PGB_granos_bd.COLUMN_LONGITUDGEO, model.getFolio());
        contentValues.put(PGB_granos_bd.COLUMN_LATITUDGEO, model.getFolio());

        long result = db.insert(PGB_granos_bd.TABLA_BD, null, contentValues);
        db.close();

        if(result == -1){
            return false;
        }else{
            return true;
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
