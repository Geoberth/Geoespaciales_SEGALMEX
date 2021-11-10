package com.example.geosegalmex.PGBeneficiarioLeche;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;

import com.example.geosegalmex.General;
import com.example.geosegalmex.Gps.UtilidadesTrayectoria;
import com.example.geosegalmex.Liconsa2.LiconsaVerificacion_bd;

public class PGBeneficiarioLecheBD extends SQLiteOpenHelper {

    public static final String DB_NAME  = "PGBeneficiarioLeche";
    public static final int DB_VERSION = 12;

    public PGBeneficiarioLecheBD(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(PGBeneficiarioLeche_bd.CREAR_TABLA_PG_BENEFICIARIO_LECHE);
        db.execSQL(UtilidadesTrayectoria.CREAR_TABLA_TRAYECTORIA);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ PGBeneficiarioLeche_bd.TABLA_BD);
        db.execSQL("DROP TABLE IF EXISTS "+ UtilidadesTrayectoria.TABLA_TRAYECTORIA);
        onCreate(db);
    }

    public boolean addPGBeneficiarioLeche(PGBeneficiarioLeche_Model model){

        SQLiteDatabase db           = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(PGBeneficiarioLeche_bd.COLUMN_FOLIO, model.getFolio());
        contentValues.put(PGBeneficiarioLeche_bd.COLUMN_FECHA, model.getFecha());
        contentValues.put(PGBeneficiarioLeche_bd.COLUMN_NOMBRE, model.getNombre());
        contentValues.put(PGBeneficiarioLeche_bd.COLUMN_PATERNO, model.getPaterno());
        contentValues.put(PGBeneficiarioLeche_bd.COLUMN_MATERNO, model.getMaterno());
        contentValues.put(PGBeneficiarioLeche_bd.COLUMN_CURP, model.getCurp());
        contentValues.put(PGBeneficiarioLeche_bd.COLUMN_CALLE, model.getCalle());
        contentValues.put(PGBeneficiarioLeche_bd.COLUMN_EXTERIOR, model.getExt());
        contentValues.put(PGBeneficiarioLeche_bd.COLUMN_INTERIOR, model.getInterior());
        contentValues.put(PGBeneficiarioLeche_bd.COLUMN_CVEESTADO, model.getCveestado());
        contentValues.put(PGBeneficiarioLeche_bd.COLUMN_ESTADO, model.getEstado());
        contentValues.put(PGBeneficiarioLeche_bd.COLUMN_CVEMUNICIPIO, model.getCvemunicipio());
        contentValues.put(PGBeneficiarioLeche_bd.COLUMN_MUNICIPIO, model.getMunicipio());
        contentValues.put(PGBeneficiarioLeche_bd.COLUMN_CVELOCALIDAD, model.getCvelocalidad());
        contentValues.put(PGBeneficiarioLeche_bd.COLUMN_LOCALIDAD, model.getLocalidad());
        contentValues.put(PGBeneficiarioLeche_bd.COLUMN_CP, model.getCp());
        contentValues.put(PGBeneficiarioLeche_bd.COLUMN_SEXO, model.getSexo());
        contentValues.put(PGBeneficiarioLeche_bd.COLUMN_EDAD, model.getEdad());
        contentValues.put(PGBeneficiarioLeche_bd.COLUMN_LYE, model.getLye());
        contentValues.put(PGBeneficiarioLeche_bd.COLUMN_NIVEL, model.getNivel());
        contentValues.put(PGBeneficiarioLeche_bd.COLUMN_NIVELOTRO, model.getNivelotro());
        contentValues.put(PGBeneficiarioLeche_bd.COLUMN_PRODUCTO, model.getProducto());
        contentValues.put(PGBeneficiarioLeche_bd.COLUMN_VOLUMEN, model.getVolumen());
        contentValues.put(PGBeneficiarioLeche_bd.COLUMN_CABEZAS, model.getCabezas());
        contentValues.put(PGBeneficiarioLeche_bd.COLUMN_VACAS, model.getVacas());
        contentValues.put(PGBeneficiarioLeche_bd.COLUMN_APOYOA, model.getApoyoa());
        contentValues.put(PGBeneficiarioLeche_bd.COLUMN_APOYOB, model.getApoyob());
        contentValues.put(PGBeneficiarioLeche_bd.COLUMN_APOYOC, model.getApoyoc());
        contentValues.put(PGBeneficiarioLeche_bd.COLUMN_APOYOD, model.getApoyod());
        contentValues.put(PGBeneficiarioLeche_bd.COLUMN_APOYOE, model.getApoyoe());
        contentValues.put(PGBeneficiarioLeche_bd.COLUMN_APOYOF, model.getApoyof());
        contentValues.put(PGBeneficiarioLeche_bd.COLUMN_APOYOG, model.getApoyog());
        contentValues.put(PGBeneficiarioLeche_bd.COLUMN_APOYOH, model.getApoyoh());
        contentValues.put(PGBeneficiarioLeche_bd.COLUMN_DOCINE, model.getDocine());
        contentValues.put(PGBeneficiarioLeche_bd.COLUMN_DOCCURP, model.getDoccurp());
        contentValues.put(PGBeneficiarioLeche_bd.COLUMN_DOCCLABE, model.getDocclabe());
        contentValues.put(PGBeneficiarioLeche_bd.COLUMN_DOCFOLIO, model.getDocfolio());
        contentValues.put(PGBeneficiarioLeche_bd.COLUMN_OP1, model.getOp1());
        contentValues.put(PGBeneficiarioLeche_bd.COLUMN_OP2, model.getOp2());
        contentValues.put(PGBeneficiarioLeche_bd.COLUMN_OP3, model.getOp3());
        contentValues.put(PGBeneficiarioLeche_bd.COLUMN_OP4, model.getOp4());
        contentValues.put(PGBeneficiarioLeche_bd.COLUMN_OP5, model.getOp5());
        contentValues.put(PGBeneficiarioLeche_bd.COLUMN_OP6, model.getOp6());
        contentValues.put(PGBeneficiarioLeche_bd.COLUMN_OP7, model.getOp7());
        contentValues.put(PGBeneficiarioLeche_bd.COLUMN_OP8, model.getOp8());
        contentValues.put(PGBeneficiarioLeche_bd.COLUMN_OP9, model.getOp9());
        contentValues.put(PGBeneficiarioLeche_bd.COLUMN_OP10, model.getOp10());
        contentValues.put(PGBeneficiarioLeche_bd.COLUMN_OP11, model.getOp11());
        contentValues.put(PGBeneficiarioLeche_bd.COLUMN_REA1, model.getRea1());
        contentValues.put(PGBeneficiarioLeche_bd.COLUMN_REA2, model.getRea2());
        contentValues.put(PGBeneficiarioLeche_bd.COLUMN_REA3, model.getRea3());
        contentValues.put(PGBeneficiarioLeche_bd.COLUMN_REA4, model.getRea4());
        contentValues.put(PGBeneficiarioLeche_bd.COLUMN_REA5, model.getRea5());
        contentValues.put(PGBeneficiarioLeche_bd.COLUMN_REA6, model.getRea6());
        contentValues.put(PGBeneficiarioLeche_bd.COLUMN_REA7, model.getRea7());
        contentValues.put(PGBeneficiarioLeche_bd.COLUMN_REA8A, model.getRea8a());
        contentValues.put(PGBeneficiarioLeche_bd.COLUMN_REA8B, model.getRea8b());
        contentValues.put(PGBeneficiarioLeche_bd.COLUMN_REA8C, model.getRea8c());
        contentValues.put(PGBeneficiarioLeche_bd.COLUMN_REA8D, model.getRea8d());
        contentValues.put(PGBeneficiarioLeche_bd.COLUMN_REA8E, model.getRea8e());
        contentValues.put(PGBeneficiarioLeche_bd.COLUMN_REA8F, model.getRea8f());
        contentValues.put(PGBeneficiarioLeche_bd.COLUMN_REA8G, model.getRea8g());
        contentValues.put(PGBeneficiarioLeche_bd.COLUMN_REA8H, model.getRea8h());
        contentValues.put(PGBeneficiarioLeche_bd.COLUMN_REA8I, model.getRea8gi());
        contentValues.put(PGBeneficiarioLeche_bd.COLUMN_REA8OTRO, model.getRea8otro());
        contentValues.put(PGBeneficiarioLeche_bd.COLUMN_REA9, model.getRea9());
        contentValues.put(PGBeneficiarioLeche_bd.COLUMN_REA10, model.getRea10());
        contentValues.put(PGBeneficiarioLeche_bd.COLUMN_REA11, model.getRea11());
        contentValues.put(PGBeneficiarioLeche_bd.COLUMN_REA12, model.getRea12());
        contentValues.put(PGBeneficiarioLeche_bd.COLUMN_FOTO1, model.getFoto1());
        contentValues.put(PGBeneficiarioLeche_bd.COLUMN_FOTO2, model.getFoto2());
        contentValues.put(PGBeneficiarioLeche_bd.COLUMN_LONGITUD, model.getLongitudGeo());
        contentValues.put(PGBeneficiarioLeche_bd.COLUMN_LATITUD, model.getLatitudGeo());

        long result = db.insert(PGBeneficiarioLeche_bd.TABLA_BD, null, contentValues);
        db.close();

        if(result == -1) {
            return false;
        }else{
            return true;
        }
    }

    public void deletePGBeneficiarioLeche(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DROP TABLE IF EXISTS "+ PGBeneficiarioLeche_bd.TABLA_BD);
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
