package com.example.geosegalmex.PAROperativo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;

import com.example.geosegalmex.General;
import com.example.geosegalmex.Gps.UtilidadesTrayectoria;
import com.example.geosegalmex.Liconsa2.LiconsaVerificacion_bd;
import com.example.geosegalmex.PGOperativoGranos.PGOperativoGranos_bd;

import java.util.ArrayList;
import java.util.List;

public class PARoperativoBD  extends SQLiteOpenHelper {

    public static final String DB_NAME = "PAROperativo";
    public static final int DB_VERSION = 13;

    public PARoperativoBD(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(PAR_operativo_bd.CREAR_TABLA_PAR_OPERATIVO);
        db.execSQL(UtilidadesTrayectoria.CREAR_TABLA_TRAYECTORIA);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + PAR_operativo_bd.TABLA_BD);
        db.execSQL("DROP TABLE IF EXISTS " + UtilidadesTrayectoria.TABLA_TRAYECTORIA);
        onCreate(db);
    }

    public boolean addPAR_Operativo(PAR_operativo_model model) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(PAR_operativo_bd.COLUMN_FOLIO, model.getFolio());
        contentValues.put(PAR_operativo_bd.COLUMN_FECHA, model.getFechaenc());
        contentValues.put(PAR_operativo_bd.COLUMN_NOMENT, model.getNoment());
        contentValues.put(PAR_operativo_bd.COLUMN_CVEEDO, model.getCveedo());
        contentValues.put(PAR_operativo_bd.COLUMN_NOMMUN, model.getNommun());
        contentValues.put(PAR_operativo_bd.COLUMN_CVEMUN, model.getCvemun());
        contentValues.put(PAR_operativo_bd.COLUMN_LOCALI, model.getLocali());
        contentValues.put(PAR_operativo_bd.COLUMN_CVELOCA, model.getCveloca());
        contentValues.put(PAR_operativo_bd.COLUMN_PARNOM, model.getParnom());
        contentValues.put(PAR_operativo_bd.COLUMN_PARAPE, model.getParape());
        contentValues.put(PAR_operativo_bd.COLUMN_PARAPEM, model.getParapem());
        contentValues.put(PAR_operativo_bd.COLUMN_PARRAD1, model.getParrad1());
        contentValues.put(PAR_operativo_bd.COLUMN_EDAD, model.getEdad());
        contentValues.put(PAR_operativo_bd.COLUMN_PARE6, model.getPare6());
        contentValues.put(PAR_operativo_bd.COLUMN_PARE7, model.getPare7());
        contentValues.put(PAR_operativo_bd.COLUMN_PARRAD2, model.getParrad2());
        contentValues.put(PAR_operativo_bd.COLUMN_PARRAD3, model.getParrad3());
        contentValues.put(PAR_operativo_bd.COLUMN_PARRAD4, model.getParrad4());
        contentValues.put(PAR_operativo_bd.COLUMN_PARRAD5, model.getParrad5());
        contentValues.put(PAR_operativo_bd.COLUMN_PARRAD6, model.getParrad6());
        contentValues.put(PAR_operativo_bd.COLUMN_PARRAD7, model.getParrad7());
        contentValues.put(PAR_operativo_bd.COLUMN_PARE8, model.getPare8());
        contentValues.put(PAR_operativo_bd.COLUMN_PARE9, model.getPare9());
        contentValues.put(PAR_operativo_bd.COLUMN_PARE10, model.getPare10());
        contentValues.put(PAR_operativo_bd.COLUMN_PARE11, model.getPare11());
        contentValues.put(PAR_operativo_bd.COLUMN_PARE12, model.getPare12());
        contentValues.put(PAR_operativo_bd.COLUMN_PARE13, model.getPare13());
        contentValues.put(PAR_operativo_bd.COLUMN_PARE14, model.getPare14());
        contentValues.put(PAR_operativo_bd.COLUMN_PARE15, model.getPare15());
        contentValues.put(PAR_operativo_bd.COLUMN_PAREO15, model.getPareo15());
        contentValues.put(PAR_operativo_bd.COLUMN_PARE16, model.getPare16());
        contentValues.put(PAR_operativo_bd.COLUMN_PARE17, model.getPare17());
        contentValues.put(PAR_operativo_bd.COLUMN_PAREO17, model.getPareo17());
        contentValues.put(PAR_operativo_bd.COLUMN_PARE18, model.getPare18());
        contentValues.put(PAR_operativo_bd.COLUMN_PARE19, model.getPare19());
        contentValues.put(PAR_operativo_bd.COLUMN_PARE20, model.getPare20());
        contentValues.put(PAR_operativo_bd.COLUMN_PARE21, model.getPare21());
        contentValues.put(PAR_operativo_bd.COLUMN_PARE22, model.getPare22());
        contentValues.put(PAR_operativo_bd.COLUMN_PARE23, model.getPare23());
        contentValues.put(PAR_operativo_bd.COLUMN_PARE24, model.getPare24());
        contentValues.put(PAR_operativo_bd.COLUMN_PARE25, model.getPare25());
        contentValues.put(PAR_operativo_bd.COLUMN_PARE26, model.getPare26());
        contentValues.put(PAR_operativo_bd.COLUMN_PARE27, model.getPare27());
        contentValues.put(PAR_operativo_bd.COLUMN_PARE28, model.getPare28());
        contentValues.put(PAR_operativo_bd.COLUMN_PARE29, model.getPare29());
        contentValues.put(PAR_operativo_bd.COLUMN_PARE30, model.getPare30());
        contentValues.put(PAR_operativo_bd.COLUMN_PARE31, model.getPare31());
        contentValues.put(PAR_operativo_bd.COLUMN_PARE32, model.getPare32());
        contentValues.put(PAR_operativo_bd.COLUMN_PARE33, model.getPare33());
        contentValues.put(PAR_operativo_bd.COLUMN_PARE34, model.getPare34());
        contentValues.put(PAR_operativo_bd.COLUMN_PARE35, model.getPare35());
        contentValues.put(PAR_operativo_bd.COLUMN_PARE36, model.getPare36());
        contentValues.put(PAR_operativo_bd.COLUMN_PARE37, model.getPare37());
        contentValues.put(PAR_operativo_bd.COLUMN_PARE38, model.getPare38());
        contentValues.put(PAR_operativo_bd.COLUMN_PARE39, model.getPare39());
        contentValues.put(PAR_operativo_bd.COLUMN_PARE40, model.getPare40());
        contentValues.put(PAR_operativo_bd.COLUMN_PARE41, model.getPare41());
        contentValues.put(PAR_operativo_bd.COLUMN_PARE42, model.getPare42());
        contentValues.put(PAR_operativo_bd.COLUMN_PARE43, model.getPare43());
        contentValues.put(PAR_operativo_bd.COLUMN_PARE44, model.getPare44());
        contentValues.put(PAR_operativo_bd.COLUMN_PARE45, model.getPare45());
        contentValues.put(PAR_operativo_bd.COLUMN_PARE46, model.getPare46());
        contentValues.put(PAR_operativo_bd.COLUMN_PARE47, model.getPare47());
        contentValues.put(PAR_operativo_bd.COLUMN_PARE48, model.getPare48());
        contentValues.put(PAR_operativo_bd.COLUMN_PARE49, model.getPare49());
        contentValues.put(PAR_operativo_bd.COLUMN_PARE50, model.getPare50());
        contentValues.put(PAR_operativo_bd.COLUMN_PARE51, model.getPare51());
        contentValues.put(PAR_operativo_bd.COLUMN_PARE52, model.getPare52());
        contentValues.put(PAR_operativo_bd.COLUMN_PARE53, model.getPare53());
        contentValues.put(PAR_operativo_bd.COLUMN_PARE54, model.getPare54());
        contentValues.put(PAR_operativo_bd.COLUMN_PARE55, model.getPare55());
        contentValues.put(PAR_operativo_bd.COLUMN_PARE56, model.getPare56());
        contentValues.put(PAR_operativo_bd.COLUMN_PARE57, model.getPare57());
        contentValues.put(PAR_operativo_bd.COLUMN_PARE58, model.getPare58());
        contentValues.put(PAR_operativo_bd.COLUMN_PARE59, model.getPare59());
        contentValues.put(PAR_operativo_bd.COLUMN_PARE60, model.getPare60());
        contentValues.put(PAR_operativo_bd.COLUMN_PARE61, model.getPare61());
        contentValues.put(PAR_operativo_bd.COLUMN_PARE62, model.getPare62());
        contentValues.put(PAR_operativo_bd.COLUMN_PARE63, model.getPare63());
        contentValues.put(PAR_operativo_bd.COLUMN_PARE64, model.getPare64());
        contentValues.put(PAR_operativo_bd.COLUMN_PARE65, model.getPare65());
        contentValues.put(PAR_operativo_bd.COLUMN_PARE66, model.getPare66());
        contentValues.put(PAR_operativo_bd.COLUMN_PARE67, model.getPare67());
        contentValues.put(PAR_operativo_bd.COLUMN_PARE68, model.getPare68());
        contentValues.put(PAR_operativo_bd.COLUMN_PARE69, model.getPare69());
        contentValues.put(PAR_operativo_bd.COLUMN_PARE70, model.getPare70());
        contentValues.put(PAR_operativo_bd.COLUMN_PARE71, model.getPare71());
        contentValues.put(PAR_operativo_bd.COLUMN_PARE72, model.getPare72());
        contentValues.put(PAR_operativo_bd.COLUMN_PARE73, model.getPare73());
        contentValues.put(PAR_operativo_bd.COLUMN_PARE74, model.getPare74());
        contentValues.put(PAR_operativo_bd.COLUMN_PARE75, model.getPare75());
        contentValues.put(PAR_operativo_bd.COLUMN_PARE76, model.getPare76());
        contentValues.put(PAR_operativo_bd.COLUMN_PARE77, model.getPare77());
        contentValues.put(PAR_operativo_bd.COLUMN_PARE78, model.getPare78());
        contentValues.put(PAR_operativo_bd.COLUMN_PARE79, model.getPare79());
        contentValues.put(PAR_operativo_bd.COLUMN_PARE80, model.getPare80());
        contentValues.put(PAR_operativo_bd.COLUMN_PARE81, model.getPare81());
        contentValues.put(PAR_operativo_bd.COLUMN_PARE82, model.getPare82());
        contentValues.put(PAR_operativo_bd.COLUMN_PARE84, model.getPare84());
        contentValues.put(PAR_operativo_bd.COLUMN_PARE85, model.getPare85());
        contentValues.put(PAR_operativo_bd.COLUMN_PARE86, model.getPare86());
        contentValues.put(PAR_operativo_bd.COLUMN_PARE87, model.getPare87());
        contentValues.put(PAR_operativo_bd.COLUMN_PARE88, model.getPare88());
        contentValues.put(PAR_operativo_bd.COLUMN_PARE89, model.getPare89());
        contentValues.put(PAR_operativo_bd.COLUMN_PARE90, model.getPare90());
        contentValues.put(PAR_operativo_bd.COLUMN_PARE91, model.getPare91());
        contentValues.put(PAR_operativo_bd.COLUMN_PARE92, model.getPare92());
        contentValues.put(PAR_operativo_bd.COLUMN_PARE93, model.getPare93());
        contentValues.put(PAR_operativo_bd.COLUMN_PARE94, model.getPare94());
        contentValues.put(PAR_operativo_bd.COLUMN_PARE95, model.getPare95());
        contentValues.put(PAR_operativo_bd.COLUMN_PARE96, model.getPare96());
        contentValues.put(PAR_operativo_bd.COLUMN_PARE97, model.getPare97());
        contentValues.put(PAR_operativo_bd.COLUMN_PARE98, model.getPare98());
        contentValues.put(PAR_operativo_bd.COLUMN_PARE99, model.getPare99());
        contentValues.put(PAR_operativo_bd.COLUMN_PARE100, model.getPare100());
        contentValues.put(PAR_operativo_bd.COLUMN_PARE101, model.getPare101());
        contentValues.put(PAR_operativo_bd.COLUMN_PARE102, model.getPare102());
        contentValues.put(PAR_operativo_bd.COLUMN_PARE103, model.getPare103());
        contentValues.put(PAR_operativo_bd.COLUMN_PARE104, model.getPare104());
        contentValues.put(PAR_operativo_bd.COLUMN_PARE105, model.getPare105());
        contentValues.put(PAR_operativo_bd.COLUMN_PARE106, model.getPare106());
        contentValues.put(PAR_operativo_bd.COLUMN_PARE107, model.getPare107());
        contentValues.put(PAR_operativo_bd.COLUMN_PARE108, model.getPare108());
        contentValues.put(PAR_operativo_bd.COLUMN_PARE109, model.getPare109());
        contentValues.put(PAR_operativo_bd.COLUMN_PARE110, model.getPare110());
        contentValues.put(PAR_operativo_bd.COLUMN_PARE111, model.getPare111());
        contentValues.put(PAR_operativo_bd.COLUMN_PARE112, model.getPare112());
        contentValues.put(PAR_operativo_bd.COLUMN_PARE113, model.getPare113());
        contentValues.put(PAR_operativo_bd.COLUMN_PARE114, model.getPare114());
        contentValues.put(PAR_operativo_bd.COLUMN_PARE115, model.getPare115());
        contentValues.put(PAR_operativo_bd.COLUMN_PARE116, model.getPare116());
        contentValues.put(PAR_operativo_bd.COLUMN_PARE117, model.getPare117());
        contentValues.put(PAR_operativo_bd.COLUMN_PARE118, model.getPare118());
        contentValues.put(PAR_operativo_bd.COLUMN_PARE119, model.getPare119());
        contentValues.put(PAR_operativo_bd.COLUMN_PARE120, model.getPare120());
        contentValues.put(PAR_operativo_bd.COLUMN_PARE121, model.getPare121());
        contentValues.put(PAR_operativo_bd.COLUMN_PARE122, model.getPare122());
        contentValues.put(PAR_operativo_bd.COLUMN_PARE123, model.getPare123());
        contentValues.put(PAR_operativo_bd.COLUMN_PARE124, model.getPare124());
        contentValues.put(PAR_operativo_bd.COLUMN_PARE125, model.getPare125());
        contentValues.put(PAR_operativo_bd.COLUMN_PARE126, model.getPare126());
        contentValues.put(PAR_operativo_bd.COLUMN_PARE127, model.getPare127());
        contentValues.put(PAR_operativo_bd.COLUMN_PARE128, model.getPare128());
        contentValues.put(PAR_operativo_bd.COLUMN_PARE129, model.getPare129());
        contentValues.put(PAR_operativo_bd.COLUMN_PARE130, model.getPare130());
        contentValues.put(PAR_operativo_bd.COLUMN_PARE131, model.getPare131());
        contentValues.put(PAR_operativo_bd.COLUMN_PARE132, model.getPare132());
        contentValues.put(PAR_operativo_bd.COLUMN_PARE133, model.getPare133());
        contentValues.put(PAR_operativo_bd.COLUMN_PARE134, model.getPare134());
        contentValues.put(PAR_operativo_bd.COLUMN_PARE135, model.getPare135());
        contentValues.put(PAR_operativo_bd.COLUMN_PARE136, model.getPare136());
        contentValues.put(PAR_operativo_bd.COLUMN_PARE137, model.getPare137());
        contentValues.put(PAR_operativo_bd.COLUMN_PARE138, model.getPare138());
        contentValues.put(PAR_operativo_bd.COLUMN_PARE139, model.getPare139());
        contentValues.put(PAR_operativo_bd.COLUMN_PARE140, model.getPare140());
        contentValues.put(PAR_operativo_bd.COLUMN_PARE141, model.getPare141());
        contentValues.put(PAR_operativo_bd.COLUMN_PARE142, model.getPare142());
        contentValues.put(PAR_operativo_bd.COLUMN_PARE143, model.getPare143());
        contentValues.put(PAR_operativo_bd.COLUMN_PARE144, model.getPare144());
        contentValues.put(PAR_operativo_bd.COLUMN_PARE145, model.getPare145());
        contentValues.put(PAR_operativo_bd.COLUMN_PARE146, model.getPare146());
        contentValues.put(PAR_operativo_bd.COLUMN_PARE147, model.getPare147());
        contentValues.put(PAR_operativo_bd.COLUMN_PARE148, model.getPare148());
        contentValues.put(PAR_operativo_bd.COLUMN_PARE149, model.getPare149());
        contentValues.put(PAR_operativo_bd.COLUMN_PARE150, model.getPare150());
        contentValues.put(PAR_operativo_bd.COLUMN_PARE151, model.getPare151());
        contentValues.put(PAR_operativo_bd.COLUMN_PARE152, model.getPare152());contentValues.put(PAR_operativo_bd.COLUMN_PARE95, model.getPare152());
        contentValues.put(PAR_operativo_bd.COLUMN_FOTO1, model.getF1());
        contentValues.put(PAR_operativo_bd.COLUMN_FOTO2, model.getF2());
        contentValues.put(PAR_operativo_bd.COLUMN_LONGITUD, model.getLongitudGeo());
        contentValues.put(PAR_operativo_bd.COLUMN_LATITUD, model.getLatitudGeo());

        long result = db.insert(PAR_operativo_bd.TABLA_BD, null, contentValues);
        db.close();

        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public void deleteaddPAR_Operativo(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DROP TABLE IF EXISTS " + PAR_operativo_bd.TABLA_BD);
        db.execSQL("DROP TABLE IF EXISTS " + UtilidadesTrayectoria.TABLA_TRAYECTORIA);
        onCreate(db);
        if (android.os.Build.VERSION.SDK_INT == Build.VERSION_CODES.P){
            db.close();
        }
    }

    public boolean addTrayectoriaS(String folioPro, String folioBrig, String longGpsSave, String latiGpsSave, String horaActl, String fechaActl) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        //contentValues.put(UtilidadesTrayectoria.COLUMN_FOLIO,folioPro);
        contentValues.put(UtilidadesTrayectoria.COLUMN_FOLIO, General.Foliocuestion);
        //contentValues.put(UtilidadesTrayectoria.COLUMN_FOLIO_TECNICO,Principal.userId);
        contentValues.put(UtilidadesTrayectoria.COLUMN_LONGITUD_TRAY, latiGpsSave);
        contentValues.put(UtilidadesTrayectoria.COLUMN_LATITUD_TRAY, longGpsSave);
        contentValues.put(UtilidadesTrayectoria.COLUMN_HRACTUAL_TRAY, horaActl);
        contentValues.put(UtilidadesTrayectoria.COLUMN_FCACTUAL_TRAY, fechaActl);

        long result = db.insert(UtilidadesTrayectoria.TABLA_TRAYECTORIA, null, contentValues);
        db.close();
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public List<PAR_operativo_model> getEveryone(){

        List<PAR_operativo_model> returnList = new ArrayList<>();

        String queryString = "SELECT * FROM " + PAR_operativo_bd.TABLA_BD;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(queryString, null);

        if(cursor.moveToFirst()){
            do{
                String folio = cursor.getString(0);
                String fecha = cursor.getString(1);
                String entidad = cursor.getString(2);
                String cveenti = cursor.getString(3);
                String muni = cursor.getString(4);
                String cvemuni = cursor.getString(5);
                String locali = cursor.getString(6);
                String cveloca = cursor.getString(7);
                String nom = cursor.getString(8);
                String ape = cursor.getString(9);
                String apem = cursor.getString(10);

                PAR_operativo_model newCuastomer = new PAR_operativo_model(folio, fecha, entidad, cveenti, muni, cvemuni, locali, cveloca, nom, ape, apem, "","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","" );
                returnList.add(newCuastomer);

            }while(cursor.moveToNext());
        }
        else{

        }
        cursor.close();
        db.close();
        return returnList;
    }


}