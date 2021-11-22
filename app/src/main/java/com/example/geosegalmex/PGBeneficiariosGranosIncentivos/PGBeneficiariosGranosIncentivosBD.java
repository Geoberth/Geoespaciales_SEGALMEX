package com.example.geosegalmex.PGBeneficiariosGranosIncentivos;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;

import com.example.geosegalmex.General;
import com.example.geosegalmex.Gps.UtilidadesTrayectoria;

public class PGBeneficiariosGranosIncentivosBD extends SQLiteOpenHelper {

    public static final String DB_NAME  = "PGBeneficiarioEstimulos";
    public static final int DB_VERSION = 5;

    public PGBeneficiariosGranosIncentivosBD(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(PGBeneficiariosGranosIncentivos_bd.CREAR_TABLA_PG_BENEFICIARIO_GRANOS_INCENTIVOS);
        db.execSQL(UtilidadesTrayectoria.CREAR_TABLA_TRAYECTORIA);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ PGBeneficiariosGranosIncentivos_bd.TABLA_BD);
        db.execSQL("DROP TABLE IF EXISTS "+ UtilidadesTrayectoria.TABLA_TRAYECTORIA);
        onCreate(db);
    }

    public boolean addPGBeneficiarioGranosIncentivos(PGBeneficiariosGranosIncentivos_Model model){

        SQLiteDatabase db           = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(PGBeneficiariosGranosIncentivos_bd.COLUMN_FOLIO          , model.getFolio() );
        contentValues.put(PGBeneficiariosGranosIncentivos_bd.COLUMN_FECHA          , model.getFecha() );
        contentValues.put(PGBeneficiariosGranosIncentivos_bd.COLUMN_NOMBRE         , model.getNom() );
        contentValues.put(PGBeneficiariosGranosIncentivos_bd.COLUMN_PATERNO        , model.getApa() );
        contentValues.put(PGBeneficiariosGranosIncentivos_bd.COLUMN_MATERNO        , model.getAma() );
        contentValues.put(PGBeneficiariosGranosIncentivos_bd.COLUMN_CURP           , model.getCurp() );
        contentValues.put(PGBeneficiariosGranosIncentivos_bd.COLUMN_CALLE          , model.getCalle() );
        contentValues.put(PGBeneficiariosGranosIncentivos_bd.COLUMN_EXT            , model.getExt() );
        contentValues.put(PGBeneficiariosGranosIncentivos_bd.COLUMN_INT            , model.getInte() );
        contentValues.put(PGBeneficiariosGranosIncentivos_bd.COLUMN_LOCALIDAD      , model.getCol() );
        contentValues.put(PGBeneficiariosGranosIncentivos_bd.COLUMN_CP             , model.getCp() );
        contentValues.put(PGBeneficiariosGranosIncentivos_bd.COLUMN_CVEESTADO      , model.getClaveEdo() );
        contentValues.put(PGBeneficiariosGranosIncentivos_bd.COLUMN_ESTADO         , model.getNomEdo() );
        contentValues.put(PGBeneficiariosGranosIncentivos_bd.COLUMN_CVEMUNICIPIO   , model.getClaveMun() );
        contentValues.put(PGBeneficiariosGranosIncentivos_bd.COLUMN_MUNICIPIO      , model.getNomMun() );
        contentValues.put(PGBeneficiariosGranosIncentivos_bd.COLUMN_LOCALIDAD2     , model.getCol2() );
        contentValues.put(PGBeneficiariosGranosIncentivos_bd.COLUMN_CP2            , model.getCp2() );
        contentValues.put(PGBeneficiariosGranosIncentivos_bd.COLUMN_CVEESTADO2     , model.getClaveEdo2() );
        contentValues.put(PGBeneficiariosGranosIncentivos_bd.COLUMN_ESTADO2        , model.getNomEdo2() );
        contentValues.put(PGBeneficiariosGranosIncentivos_bd.COLUMN_CVEMUNICIPIO2  , model.getClaveMun2() );
        contentValues.put(PGBeneficiariosGranosIncentivos_bd.COLUMN_MUNICIPIO2     , model.getNomMun2() );
        contentValues.put(PGBeneficiariosGranosIncentivos_bd.COLUMN_ESTADO3        , model.getNomEdo3() );
        contentValues.put(PGBeneficiariosGranosIncentivos_bd.COLUMN_MUNICIPIO3     , model.getNomMun3() );
        contentValues.put(PGBeneficiariosGranosIncentivos_bd.COLUMN_ESTADO4        , model.getNomEdo4() );
        contentValues.put(PGBeneficiariosGranosIncentivos_bd.COLUMN_MUNICIPIO4     , model.getNomMun4() );
        contentValues.put(PGBeneficiariosGranosIncentivos_bd.COLUMN_ESTADO5        , model.getNomEdo5() );
        contentValues.put(PGBeneficiariosGranosIncentivos_bd.COLUMN_MUNICIPIO5     , model.getNomMun5() );
        contentValues.put(PGBeneficiariosGranosIncentivos_bd.COLUMN_ESTADO6        , model.getNomEdo6() );
        contentValues.put(PGBeneficiariosGranosIncentivos_bd.COLUMN_MUNICIPIO6     , model.getNomMun6() );
        contentValues.put(PGBeneficiariosGranosIncentivos_bd.COLUMN_SEXO           , model.getSexo() );
        contentValues.put(PGBeneficiariosGranosIncentivos_bd.COLUMN_EDAD           , model.getEdad() );
        contentValues.put(PGBeneficiariosGranosIncentivos_bd.COLUMN_LEER           , model.getLeer() );
        contentValues.put(PGBeneficiariosGranosIncentivos_bd.COLUMN_GRADO          , model.getUlt1() );
        contentValues.put(PGBeneficiariosGranosIncentivos_bd.COLUMN_GRADOOTRO      , model.getUltotro() );
        contentValues.put(PGBeneficiariosGranosIncentivos_bd.COLUMN_PRODUCTO       , model.getProd() );
        contentValues.put(PGBeneficiariosGranosIncentivos_bd.COLUMN_PESO           , model.getPeso() );
        contentValues.put(PGBeneficiariosGranosIncentivos_bd.COLUMN_CUATRO1        , model.getInf1() );
        contentValues.put(PGBeneficiariosGranosIncentivos_bd.COLUMN_CUATRO2        , model.getInf2() );
        contentValues.put(PGBeneficiariosGranosIncentivos_bd.COLUMN_CUATRO3        , model.getInf3() );
        contentValues.put(PGBeneficiariosGranosIncentivos_bd.COLUMN_CUATRO4        , model.getInf4() );
        contentValues.put(PGBeneficiariosGranosIncentivos_bd.COLUMN_CUATRO5        , model.getInf5() );
        contentValues.put(PGBeneficiariosGranosIncentivos_bd.COLUMN_CUATRO6        , model.getInf6() );
        contentValues.put(PGBeneficiariosGranosIncentivos_bd.COLUMN_CUATRO8        , model.getInf8() );
        contentValues.put(PGBeneficiariosGranosIncentivos_bd.COLUMN_CUATRO9        , model.getInf9() );
        contentValues.put(PGBeneficiariosGranosIncentivos_bd.COLUMN_CINCO1         , model.getDocine() );
        contentValues.put(PGBeneficiariosGranosIncentivos_bd.COLUMN_CINCO2         , model.getDoccurp() );
        contentValues.put(PGBeneficiariosGranosIncentivos_bd.COLUMN_CINCO3         , model.getDocclabe() );
        contentValues.put(PGBeneficiariosGranosIncentivos_bd.COLUMN_CINCO4         , model.getDocfol() );
        contentValues.put(PGBeneficiariosGranosIncentivos_bd.COLUMN_CINCO5         , model.getDocren() );
        contentValues.put(PGBeneficiariosGranosIncentivos_bd.COLUMN_SEIS1          , model.getSeis_1() );
        contentValues.put(PGBeneficiariosGranosIncentivos_bd.COLUMN_SEIS2          , model.getSeis_2() );
        contentValues.put(PGBeneficiariosGranosIncentivos_bd.COLUMN_SEIS3          , model.getSeis_3() );
        contentValues.put(PGBeneficiariosGranosIncentivos_bd.COLUMN_SEIS4          , model.getSeis_4() );
        contentValues.put(PGBeneficiariosGranosIncentivos_bd.COLUMN_SEIS5          , model.getSeis_5() );
        contentValues.put(PGBeneficiariosGranosIncentivos_bd.COLUMN_SEIS6          , model.getSeis_6() );
        contentValues.put(PGBeneficiariosGranosIncentivos_bd.COLUMN_SEIS7          , model.getSeis_7() );
        contentValues.put(PGBeneficiariosGranosIncentivos_bd.COLUMN_SEIS8          , model.getSeis_8() );
        contentValues.put(PGBeneficiariosGranosIncentivos_bd.COLUMN_SEIS9          , model.getSeis_9() );
        contentValues.put(PGBeneficiariosGranosIncentivos_bd.COLUMN_SIETE1         , model.getSiete_1() );
        contentValues.put(PGBeneficiariosGranosIncentivos_bd.COLUMN_SIETE2         , model.getSiete_2() );
        contentValues.put(PGBeneficiariosGranosIncentivos_bd.COLUMN_SIETE3         , model.getSiete_3() );
        contentValues.put(PGBeneficiariosGranosIncentivos_bd.COLUMN_SIETE4         , model.getSiete_4() );
        contentValues.put(PGBeneficiariosGranosIncentivos_bd.COLUMN_SIETE5         , model.getSiete_5() );
        contentValues.put(PGBeneficiariosGranosIncentivos_bd.COLUMN_OCHO1          , model.getOcho_1() );
        contentValues.put(PGBeneficiariosGranosIncentivos_bd.COLUMN_OCHO2          , model.getOcho_2() );
        contentValues.put(PGBeneficiariosGranosIncentivos_bd.COLUMN_OCHO3          , model.getOcho_3() );
        contentValues.put(PGBeneficiariosGranosIncentivos_bd.COLUMN_OCHO4          , model.getOcho_4() );
        contentValues.put(PGBeneficiariosGranosIncentivos_bd.COLUMN_OCHO5          , model.getOcho_5() );
        contentValues.put(PGBeneficiariosGranosIncentivos_bd.COLUMN_OCHO6          , model.getOcho_6() );
        contentValues.put(PGBeneficiariosGranosIncentivos_bd.COLUMN_OCHO7          , model.getOcho_7() );
        contentValues.put(PGBeneficiariosGranosIncentivos_bd.COLUMN_NUEVE1         , model.getNueve1() );
        contentValues.put(PGBeneficiariosGranosIncentivos_bd.COLUMN_NUEVE2         , model.getNueve2() );
        contentValues.put(PGBeneficiariosGranosIncentivos_bd.COLUMN_NUEVE3         , model.getNueve3() );
        contentValues.put(PGBeneficiariosGranosIncentivos_bd.COLUMN_NUEVE4         , model.getNueve4() );
        contentValues.put(PGBeneficiariosGranosIncentivos_bd.COLUMN_NUEVE5         , model.getNueve5() );
        contentValues.put(PGBeneficiariosGranosIncentivos_bd.COLUMN_NUEVE6         , model.getNueve6() );
        contentValues.put(PGBeneficiariosGranosIncentivos_bd.COLUMN_NUEVE7         , model.getNueve7() );
        contentValues.put(PGBeneficiariosGranosIncentivos_bd.COLUMN_NUEVE8         , model.getNueve8() );
        contentValues.put(PGBeneficiariosGranosIncentivos_bd.COLUMN_NUEVE9         , model.getNueve9() );
        contentValues.put(PGBeneficiariosGranosIncentivos_bd.COLUMN_NUEVE10         , model.getNueve10() );
        contentValues.put(PGBeneficiariosGranosIncentivos_bd.COLUMN_NUEVEOTRO      , model.getNueveotro() );
        contentValues.put(PGBeneficiariosGranosIncentivos_bd.COLUMN_DIEZ           , model.getDiez() );
        contentValues.put(PGBeneficiariosGranosIncentivos_bd.COLUMN_ONCE           , model.getOnce() );
        contentValues.put(PGBeneficiariosGranosIncentivos_bd.COLUMN_DOCE           , model.getDoce() );
        contentValues.put(PGBeneficiariosGranosIncentivos_bd.COLUMN_TRECE          , model.getTrece() );
        contentValues.put(PGBeneficiariosGranosIncentivos_bd.COLUMN_FOTO1          , model.getFoto1() );
        contentValues.put(PGBeneficiariosGranosIncentivos_bd.COLUMN_FOTO2          , model.getFoto2() );
        contentValues.put(PGBeneficiariosGranosIncentivos_bd.COLUMN_LONGITUD       , model.getLongitudGeo() );
        contentValues.put(PGBeneficiariosGranosIncentivos_bd.COLUMN_LATITUD        , model.getLatitudGeo() );

        long result = db.insert(PGBeneficiariosGranosIncentivos_bd.TABLA_BD, null, contentValues);
        db.close();

        if(result == -1) {
            return false;
        }else{
            return true;
        }
    }


    public void deletePGBeneficiarioGranosIncentivos(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DROP TABLE IF EXISTS "+ PGBeneficiariosGranosIncentivos_bd.TABLA_BD);
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
