package com.example.geosegalmex.LiconsaVentanilla;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;

import com.example.geosegalmex.General;
import com.example.geosegalmex.Gps.UtilidadesTrayectoria;

import java.util.ArrayList;
import java.util.List;

public class PASLoperativoBD extends SQLiteOpenHelper {

    public static final String DB_NAME  = "PASLOperativo";
    public static final int DB_VERSION = 12;

    public PASLoperativoBD(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(pasl_operativo_bd.CREAR_TABLA_PASL_OPERATIVO);
        db.execSQL(UtilidadesTrayectoria.CREAR_TABLA_TRAYECTORIA);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ pasl_operativo_bd.TABLA_BD);
        db.execSQL("DROP TABLE IF EXISTS "+ UtilidadesTrayectoria.TABLA_TRAYECTORIA);
        onCreate(db);
    }

    public boolean addPASLoperativo(Pasl_o_Model model){

        SQLiteDatabase db           = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(pasl_operativo_bd.COLUMN_FOLIO, model.getFolio());
        contentValues.put(pasl_operativo_bd.COLUMN_FECHA, model.getFecha());
        contentValues.put(pasl_operativo_bd.COLUMN_CVEESTADO, model.getCveestado());
        contentValues.put(pasl_operativo_bd.COLUMN_ESTADO, model.getEstado());
        contentValues.put(pasl_operativo_bd.COLUMN_CVEMUNICIPIO, model.getCvemunicipio());
        contentValues.put(pasl_operativo_bd.COLUMN_MUNICIPIO, model.getMunicipio());
        contentValues.put(pasl_operativo_bd.COLUMN_CVELOCALIDAD, model.getCvelocalidad());
        contentValues.put(pasl_operativo_bd.COLUMN_LOCALIDAD, model.getLocalidad());
        contentValues.put(pasl_operativo_bd.COLUMN_NOMBRE, model.getNombre());
        contentValues.put(pasl_operativo_bd.COLUMN_APATERNO, model.getApaterno());
        contentValues.put(pasl_operativo_bd.COLUMN_AMATERNO, model.getAmaterno());
        contentValues.put(pasl_operativo_bd.COLUMN_SEXO, model.getSexo());
        contentValues.put(pasl_operativo_bd.COLUMN_EDAD, model.getEdad());
        contentValues.put(pasl_operativo_bd.COLUMN_TIEMPO, model.getTiempo());
        contentValues.put(pasl_operativo_bd.COLUMN_UNO, model.getUno());
        contentValues.put(pasl_operativo_bd.COLUMN_DOS, model.getDos());
        contentValues.put(pasl_operativo_bd.COLUMN_TRES, model.getTres());
        contentValues.put(pasl_operativo_bd.COLUMN_CUATRO, model.getCuatro());
        contentValues.put(pasl_operativo_bd.COLUMN_CINCO, model.getCinco());
        contentValues.put(pasl_operativo_bd.COLUMN_SEIS, model.getSeis());
        contentValues.put(pasl_operativo_bd.COLUMN_SIETE, model.getSiete());
        contentValues.put(pasl_operativo_bd.COLUMN_OCHO, model.getOcho());
        contentValues.put(pasl_operativo_bd.COLUMN_NUEVE, model.getNueve());
        contentValues.put(pasl_operativo_bd.COLUMN_DIEZ, model.getDiez());
        contentValues.put(pasl_operativo_bd.COLUMN_ONCE, model.getOnce());
        contentValues.put(pasl_operativo_bd.COLUMN_DOCE, model.getDoce());
        contentValues.put(pasl_operativo_bd.COLUMN_TRECE, model.getTrece());
        contentValues.put(pasl_operativo_bd.COLUMN_CATORCE, model.getCatorce());
        contentValues.put(pasl_operativo_bd.COLUMN_QUINCE, model.getQuince());
        contentValues.put(pasl_operativo_bd.COLUMN_FOTO1, model.getFoto1());
        contentValues.put(pasl_operativo_bd.COLUMN_FOTO2, model.getFoto2());
        contentValues.put(pasl_operativo_bd.COLUMN_LONGITUD, model.getLongitudGeo());
        contentValues.put(pasl_operativo_bd.COLUMN_LATITUD, model.getLatitudGeo());

        long result = db.insert(pasl_operativo_bd.TABLA_BD, null, contentValues);
        db.close();

        if(result == -1) {
            return false;
        }else{
            return true;
        }

    }

    public void deletePASLoperativo(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DROP TABLE IF EXISTS "+ pasl_operativo_bd.TABLA_BD);
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


    public List<Pasl_o_Model> getEveryone2(){

        List<Pasl_o_Model> returnList2 = new ArrayList<>();

        String queryString = "SELECT * FROM " + pasl_operativo_bd.TABLA_BD;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(queryString, null);

        if(cursor.moveToFirst()){
            do{
                String folio = cursor.getString(0);
                String fecha = cursor.getString(1);
                String cveenti = cursor.getString(2);
                String entidad = cursor.getString(3);
                String cvemuni = cursor.getString(4);
                String muni = cursor.getString(5);
                String cveloca = cursor.getString(6);
                String locali = cursor.getString(7);
                String nom = cursor.getString(8);
                String ape = cursor.getString(9);
                String apem = cursor.getString(10);

                Pasl_o_Model newCustomer = new Pasl_o_Model(folio, fecha, cveenti, entidad, cvemuni, muni, cveloca, locali, nom, ape, apem, "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "");
                returnList2.add(newCustomer);

            }while(cursor.moveToNext());
        }
        else{

        }
        cursor.close();
        db.close();
        return returnList2;
    }



}
