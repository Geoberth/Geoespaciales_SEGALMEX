package com.example.geosegalmex.unidadcaracterizacionhortalizas.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.geosegalmex.General;
import com.example.geosegalmex.Georeferencia.Utilidades;
import com.example.geosegalmex.Gps.UtilidadesTrayectoria;
import com.example.geosegalmex.LiconsaVentanilla.Pasl_o_Model;
import com.example.geosegalmex.LiconsaVentanilla.pasl_operativo_bd;
import com.example.geosegalmex.Pecuario.GlobalPecuario.GlobalPecuario;
import com.example.geosegalmex.Pecuario.UtilidadesPecuario.UtilidadesPecuario;
import com.example.geosegalmex.Principal;
import com.example.geosegalmex.Productor.bd_prod.UtilidadesProductor;
import com.example.geosegalmex.apicola.variables_apicola.UtilidadesModuloSiete;
import com.example.geosegalmex.apicola.variables_apicola.VariablesModuloSiete;
import com.example.geosegalmex.caracterizacion.variables_caracterizacion.UtilidadesModuloCuatro;
import com.example.geosegalmex.caracterizacion.variables_caracterizacion.VariablesModuloCuatro;
import com.example.geosegalmex.drawer.fragment_drawer.bdmunicipios.UtilidadesEdoMunicipios;
import com.example.geosegalmex.drawer.fragment_drawer.bdusers.UtilidadesUsuarios;
import com.example.geosegalmex.frutales.dbfrutales.UtilidadesModuloSeis;
import com.example.geosegalmex.frutales.dbfrutales.VariablesFrutales;
import com.example.geosegalmex.unidadcaracterizacionhortalizas.variables.VariblesGlobalesHortalizas;
import com.example.geosegalmex.unidadcomercializacion.bdcomercializacion.UtilidadesModuloDiez;
import com.example.geosegalmex.unidadcomercializacion.bdcomercializacion.VariablesGlobalesCmrz;
import com.example.geosegalmex.unidadproduccion.variables.UtilidadesModuloTres;
import com.example.geosegalmex.unidadproduccion.variables.VariablesGlobalesUpf;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DB_NAME  = "BDENCUESTA";
    public static final int DB_VERSION = 28;

    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        //SEGALMEX
        db.execSQL(pasl_operativo_bd.CREAR_TABLA_PASL_OPERATIVO);




        //Usuarios
        //db.execSQL(UtilidadesUsuarios.CREAR_TABLA_USUARIOS);

        //Municipios
        db.execSQL(UtilidadesEdoMunicipios.CREAR_TABLA_WAZURE);

/*
        //Unidad 7 Apicola
        db.execSQL(UtilidadesModuloSiete.CREAR_TABLA_APICOLA);
        db.execSQL(UtilidadesModuloSiete.CREAR_TABLA_APICOLA_INGREDIENTES);
        db.execSQL(UtilidadesModuloSiete.CREAR_TABLA_APICOLA_ENFERMEDADES);
        db.execSQL(UtilidadesModuloSiete.CREAR_TABLA_APICOLA_HERRAMIENTAS);
        db.execSQL(UtilidadesModuloSiete.CREAR_TABLA_APICOLA_ALIMENTACION);

        //Unidad 9 Infraestructura
        db.execSQL(UtilidadesModuloDiez.CREAR_TABLA_INFRAESTRUCTURA);

        //Unidad 6 Frutales
        db.execSQL(UtilidadesModuloSeis.CREAR_TABLA_FRUTALES);
        db.execSQL(UtilidadesModuloSeis.CREAR_TABLA_FRUTALES_SUELO);
        db.execSQL(UtilidadesModuloSeis.CREAR_TABLA_FRUTALES_SUELO_DSP);
        db.execSQL(UtilidadesModuloSeis.CREAR_TABLA_FRUTALES_FERTILIZANTE);
        db.execSQL(UtilidadesModuloSeis.CREAR_TABLA_FRUTALES_MALEZA);
        db.execSQL(UtilidadesModuloSeis.CREAR_TABLA_FRUTALES_PLAGA);
        db.execSQL(UtilidadesModuloSeis.CREAR_TABLA_FRUTALES_COSECHA);
        db.execSQL(UtilidadesModuloSeis.CREAR_TABLA_FRUTALES_EMPAQUE);
*/
/*
        //Unidad 10 Comercializacion
        db.execSQL(UtilidadesModuloDiez.CREAR_TABLA_COMERCIALIZACION);
        db.execSQL(UtilidadesModuloDiez.CREAR_TABLA_COMERCIALIZACION_AGRICOLA);
        db.execSQL(UtilidadesModuloDiez.CREAR_TABLA_COMERCIALIZACION_PECUARIA);
        db.execSQL(UtilidadesModuloDiez.CREAR_TABLA_COMERCIALIZACION_PRODUCTOS_PROCESADOS);
        db.execSQL(UtilidadesModuloDiez.CREAR_TABLA_COMERCIALIZACION_LECHERO);
        db.execSQL(UtilidadesModuloDiez.CREAR_TABLA_COMERCIALIZACION_APICOLA);
        db.execSQL(UtilidadesModuloDiez.CREAR_TABLA_COMERCIALIZACION_APICOLAGRAL);


        //Unidad 4 Agricola
        db.execSQL(UtilidadesModuloCuatro.CREAR_TABLA_AGRICOLA);
        db.execSQL(UtilidadesModuloCuatro.CREAR_TABLA_SEMILLAS_CULTIVO);
        db.execSQL(UtilidadesModuloCuatro.CREAR_TABLA_PREPARACION_SUELO);
        db.execSQL(UtilidadesModuloCuatro.CREAR_TABLA_FERTILIZANTE_AGRI);
        db.execSQL(UtilidadesModuloCuatro.CREAR_TABLA_MALA_HIERBA);
        db.execSQL(UtilidadesModuloCuatro.CREAR_TABLA_PLAGA_ENFERMEDADES);
        db.execSQL(UtilidadesModuloCuatro.CREAR_TABLA_COSECHA);
        db.execSQL(UtilidadesModuloCuatro.CREAR_TABLA_GRANO);
        db.execSQL(UtilidadesModuloCuatro.CREAR_TABLA_RIEGO);
*/

        //Georreferencia
        db.execSQL(Utilidades.CREAR_TABLA_GEORREFERENCIA);
        //Trayectoria
        db.execSQL(UtilidadesTrayectoria.CREAR_TABLA_TRAYECTORIA);
/*
        //Unidad 5 Caracterizacion Hortalizas
        db.execSQL(UtilidadesModuloCinco.CREAR_TABLA_HORTALIZAS);
        db.execSQL(UtilidadesModuloCinco.CREAR_TABLA_PREPARSUELO);
        db.execSQL(UtilidadesModuloCinco.CREAR_TABLA_FERTIL);
        db.execSQL(UtilidadesModuloCinco.CREAR_TABLA_RIEGO);
        db.execSQL(UtilidadesModuloCinco.CREAR_TABLA_MALAHIERBA);
        db.execSQL(UtilidadesModuloCinco.CREAR_TABLA_PLAGASENFERM);
        db.execSQL(UtilidadesModuloCinco.CREAR_TABLA_COSECHA);
        db.execSQL(UtilidadesModuloCinco.CREAR_TABLA_EMPAQUE);

        //Unidad 3 de Produccion
        db.execSQL(UtilidadesModuloTres.CREAR_TABLA_UPF);
        db.execSQL(UtilidadesModuloTres.CREAR_TABLA_AGRICOLA);
        db.execSQL(UtilidadesModuloTres.CREAR_TABLA_PECUARIA);
        db.execSQL(UtilidadesModuloTres.CREAR_TABLA_FUENTEAGUA);
        db.execSQL(UtilidadesModuloTres.CREAR_TABLA_ACUICOLA);
*/
        //Unidad 1 IdentificacionCuestionario
        //db.execSQL(UtilidadesProductor.CREAR_TABLA_CUESTIONARIO2);
/*
        //Unidad 2 Productor
        db.execSQL(UtilidadesProductor.CREAR_TABLA_PRODUCTOR);

        //Integrante familia
        db.execSQL(UtilidadesProductor.CREAR_TABLA_INTEGRANTE_FAMILIA);
*/

/*
        //UNIDAD 8 PECUARIO
        db.execSQL(UtilidadesPecuario.CREAR_TABLA_PECUARIOBOVINOS);
        db.execSQL(UtilidadesPecuario.CREAR_TABLA_PECUARIOOVINOS);
        db.execSQL(UtilidadesPecuario.CREAR_TABLA_PECUARIOCAPRINOS);
        db.execSQL(UtilidadesPecuario.CREAR_TABLA_PECUESTRUCTURAHATO);
        db.execSQL(UtilidadesPecuario.CREAR_TABLA_PECUBOVINOLECHE);
        db.execSQL(UtilidadesPecuario.CREAR_TABLA_PECUINVGANOVINO);
        db.execSQL(UtilidadesPecuario.CREAR_TABLA_PECUINVGANCPARINO);
        db.execSQL(UtilidadesPecuario.CREAR_TABLA_PECUARIO_BOVPASTOREO);
        db.execSQL(UtilidadesPecuario.CREAR_TABLA_PECUARIO_BOVALIMGANADO);
        db.execSQL(UtilidadesPecuario.CREAR_TABLA_PECUARIO_DIETAOVICAPRI);
        db.execSQL(UtilidadesPecuario.CREAR_TABLA_PECUARIO_EVEUNPRO);
        db.execSQL(UtilidadesPecuario.CREAR_TABLA_PECUARIO_AGREALPEC);
        db.execSQL(UtilidadesPecuario.CREAR_TABLA_PECUARIO_MANEAGOSTAD);
        db.execSQL(UtilidadesPecuario.CREAR_TABLA_PECUARIO_REPRODGENETICA);
        db.execSQL(UtilidadesPecuario.CREAR_TABLA_PECUARIO_MANEJSANGAN);
        db.execSQL(UtilidadesPecuario.CREAR_TABLA_PECUARIO_MANSANOR);
*/
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //SEGALMEX
        db.execSQL("DROP TABLE IF EXISTS "+ pasl_operativo_bd.TABLA_BD);


        //Usuarios
        db.execSQL("DROP TABLE IF EXISTS "+ UtilidadesUsuarios.TABLA_USUARIOS);

        //Municipios
        db.execSQL("DROP TABLE IF EXISTS "+ UtilidadesEdoMunicipios.TABLA_MUNICIPIOS);

        //Apicola
        db.execSQL("DROP TABLE IF EXISTS " + UtilidadesModuloSiete.TABLA_APICOLA);
        db.execSQL("DROP TABLE IF EXISTS " + UtilidadesModuloSiete.TABLA_APICOLA_INGREDIENTES);
        db.execSQL("DROP TABLE IF EXISTS " + UtilidadesModuloSiete.TABLA_APICOLA_ENFERMEDADES);
        db.execSQL("DROP TABLE IF EXISTS " + UtilidadesModuloSiete.TABLA_APICOLA_HERRAMIENTAS);
        db.execSQL("DROP TABLE IF EXISTS " + UtilidadesModuloSiete.TABLA_APICOLA_ALIMENTACION);

        //Infraestructura
        db.execSQL("DROP TABLE IF EXISTS " + UtilidadesModuloDiez.TABLA_INFRAESTRUCTURA);

        //Frutales
        db.execSQL("DROP TABLE IF EXISTS " + UtilidadesModuloSeis.TABLA_FRUTALES);
        db.execSQL("DROP TABLE IF EXISTS " + UtilidadesModuloSeis.TABLA_FRUTALES_SUELO);
        db.execSQL("DROP TABLE IF EXISTS " + UtilidadesModuloSeis.TABLA_FRUTALES_SUELO_DESP);
        db.execSQL("DROP TABLE IF EXISTS " + UtilidadesModuloSeis.TABLA_FRUTALES_FERTILIZANTE);
        db.execSQL("DROP TABLE IF EXISTS " + UtilidadesModuloSeis.TABLA_FRUTALES_MALEZA);
        db.execSQL("DROP TABLE IF EXISTS " + UtilidadesModuloSeis.TABLA_FRUTALES_PLAGAS);
        db.execSQL("DROP TABLE IF EXISTS " + UtilidadesModuloSeis.TABLA_FRUTALES_COSECHA);
        db.execSQL("DROP TABLE IF EXISTS " + UtilidadesModuloSeis.TABLA_FRUTALES_EMPAQUE);

        //Comercializacion
        db.execSQL("DROP TABLE IF EXISTS " + UtilidadesModuloDiez.TABLA_COMERCIALIZACION);
        db.execSQL("DROP TABLE IF EXISTS " + UtilidadesModuloDiez.TABLA_COMERCIALIZACION_AGRICOLA);
        db.execSQL("DROP TABLE IF EXISTS " + UtilidadesModuloDiez.TABLA_COMERCIALIZACION_PECUARIA);
        db.execSQL("DROP TABLE IF EXISTS " + UtilidadesModuloDiez.TABLA_PRODUCTOS_PROCESADOS);
        db.execSQL("DROP TABLE IF EXISTS " + UtilidadesModuloDiez.TABLA_COMERCIALIZACION_APICOLA);
        db.execSQL("DROP TABLE IF EXISTS " + UtilidadesModuloDiez.TABLA_COMERCIALIZACION_APICOLAGRAL);

        //Agricola
        db.execSQL("DROP TABLE IF EXISTS "+ UtilidadesModuloCuatro.TABLA_AGRICOLA);
        db.execSQL("DROP TABLE IF EXISTS "+ UtilidadesModuloCuatro.TABLA_SEMILLA_CULTIVO);
        db.execSQL("DROP TABLE IF EXISTS "+ UtilidadesModuloCuatro.TABLA_PREPARACION_SUELO);
        db.execSQL("DROP TABLE IF EXISTS "+ UtilidadesModuloCuatro.TABLA_FERTILIZANTE_AGRI);
        db.execSQL("DROP TABLE IF EXISTS "+ UtilidadesModuloCuatro.TABLA_MALA_HIERBA);
        db.execSQL("DROP TABLE IF EXISTS "+ UtilidadesModuloCuatro.TABLA_ENFERMEDADES);
        db.execSQL("DROP TABLE IF EXISTS "+ UtilidadesModuloCuatro.TABLA_COSECHA);
        db.execSQL("DROP TABLE IF EXISTS "+ UtilidadesModuloCuatro.TABLA_GRANOS);
        db.execSQL("DROP TABLE IF EXISTS "+ UtilidadesModuloCuatro.TABLA_RIEGO);


        //Georreferencia
        db.execSQL("DROP TABLE IF EXISTS "+ Utilidades.TABLA_GEORREFERENCIA);

        //Trayectoria
        db.execSQL("DROP TABLE IF EXISTS "+ UtilidadesTrayectoria.TABLA_TRAYECTORIA);


        //Hortalizas
        db.execSQL("DROP TABLE IF EXISTS "+ UtilidadesModuloCinco.TABLA_HORTALIZAS);
        db.execSQL("DROP TABLE IF EXISTS "+ UtilidadesModuloCinco.TABLA_PREPARACIONSUELO);
        db.execSQL("DROP TABLE IF EXISTS "+ UtilidadesModuloCinco.TABLA_FERTILIZANTE);
        db.execSQL("DROP TABLE IF EXISTS "+ UtilidadesModuloCinco.TABLA_RIEGO);
        db.execSQL("DROP TABLE IF EXISTS "+ UtilidadesModuloCinco.TABLA_MALAHIERBA);
        db.execSQL("DROP TABLE IF EXISTS "+ UtilidadesModuloCinco.TABLA_PLAGASENFER);
        db.execSQL("DROP TABLE IF EXISTS "+ UtilidadesModuloCinco.TABLA_COSECHA);
        db.execSQL("DROP TABLE IF EXISTS "+ UtilidadesModuloCinco.TABLA_EMPAQUE);


        //Unidad 3 de Produccion
        db.execSQL("DROP TABLE IF EXISTS "+ UtilidadesModuloTres.TABLA_UPF);
        db.execSQL("DROP TABLE IF EXISTS "+ UtilidadesModuloTres.TABLA_PROD_AGRICOLA);
        db.execSQL("DROP TABLE IF EXISTS "+ UtilidadesModuloTres.TABLA_PROD_PECUARIA);
        db.execSQL("DROP TABLE IF EXISTS "+ UtilidadesModuloTres.TABLA_FUENTE_AGUA);
        db.execSQL("DROP TABLE IF EXISTS "+ UtilidadesModuloTres.TABLA_PROD_ACUICOLA);


        //Unidad 1 IdentificacionCuestionario
        db.execSQL("DROP TABLE IF EXISTS "+ UtilidadesProductor.TABLA_CUESTIONARIO);
        //Unidad 2 Productor
        db.execSQL("DROP TABLE IF EXISTS " + UtilidadesProductor.TABLA_PRODUCTOR);

        //Unidad 2 Integrante de familia
        db.execSQL("DROP TABLE IF EXISTS " + UtilidadesProductor.TABLA_INTEGRANTE_FAMILIA);

        //UNIDAD 8 PECUARIO
        db.execSQL("DROP TABLE IF EXISTS "+ UtilidadesPecuario.TABLA_PECUARIO_BOVINOS);
        db.execSQL("DROP TABLE IF EXISTS "+ UtilidadesPecuario.TABLA_PECUARIO_OVINOS);
        db.execSQL("DROP TABLE IF EXISTS "+ UtilidadesPecuario.TABLA_PECUARIO_CAPRINOS);
        db.execSQL("DROP TABLE IF EXISTS "+ UtilidadesPecuario.TABLA_PECUARIO_ESTRUCTURAHATO);
        db.execSQL("DROP TABLE IF EXISTS "+ UtilidadesPecuario.TABLA_PECUARIO_BOVINOLECHE);
        db.execSQL("DROP TABLE IF EXISTS "+ UtilidadesPecuario.TABLA_PECUARIO_INVENTARIOGANOVINO);
        db.execSQL("DROP TABLE IF EXISTS "+ UtilidadesPecuario.TABLA_PECUARIO_INVENTARIOGANCAPRI);
        db.execSQL("DROP TABLE IF EXISTS "+ UtilidadesPecuario.TABLA_PECUARIO_BOVPASTOREO);
        db.execSQL("DROP TABLE IF EXISTS "+ UtilidadesPecuario.TABLA_PECUARIO_BOVALIMGANADO);
        db.execSQL("DROP TABLE IF EXISTS "+ UtilidadesPecuario.TABLA_PECUARIO_DIETAOVICAPRI);
        db.execSQL("DROP TABLE IF EXISTS "+ UtilidadesPecuario.TABLA_PECUARIO_EVEUNPRO);
        db.execSQL("DROP TABLE IF EXISTS "+ UtilidadesPecuario.TABLA_PECUARIO_AGREALPEC);
        db.execSQL("DROP TABLE IF EXISTS "+ UtilidadesPecuario.TABLA_PECUARIO_MANEAGOSTAD);
        db.execSQL("DROP TABLE IF EXISTS "+ UtilidadesPecuario.TABLA_PECUARIO_REPRODGENETICA);
        db.execSQL("DROP TABLE IF EXISTS "+ UtilidadesPecuario.TABLA_PECUARIO_MANEJSANGAN);
        db.execSQL("DROP TABLE IF EXISTS "+ UtilidadesPecuario.TABLA_PECUARIO_MANSANOR);
        onCreate(db);


    }

    //++++++++++++++++++++++++++++++++++ADD Apicola +++++++++++++++++++++++++++++++++++++++++++++++
    public boolean addDatosAlimentacion(String s, String txtMeseAlimentar, String txtFormasAlimentar, String txtOtroAlimentar, String comodin1, String comodin2, String comodin3, String comodin4, String txtCostoIngreSoste){
        SQLiteDatabase db               = this.getWritableDatabase();
        ContentValues contentValues    = new ContentValues();

        contentValues.put(UtilidadesModuloSiete.COLUMN_FOLIO,General.Foliocuestion);
        contentValues.put(UtilidadesModuloSiete.COLUMN_IDCAPTURISTA, Principal.userId);
        contentValues.put(UtilidadesModuloSiete.COLUMN_APITIPALI,s );
        contentValues.put(UtilidadesModuloSiete.COLUMN_APIPERR,txtMeseAlimentar);
        contentValues.put(UtilidadesModuloSiete.COLUMN_APIFORA,txtFormasAlimentar);
        contentValues.put(UtilidadesModuloSiete.COLUMN_APIFORAO,txtOtroAlimentar);
        contentValues.put(UtilidadesModuloSiete.COLUMN_APIINGS, comodin1);
        contentValues.put(UtilidadesModuloSiete.COLUMN_APIINGSO,comodin2);
        contentValues.put(UtilidadesModuloSiete.COLUMN_APIINGE , comodin3);
        contentValues.put(UtilidadesModuloSiete.COLUMN_APIINGEO, comodin4);
        contentValues.put(UtilidadesModuloSiete.COLUMN_APICOSA , txtCostoIngreSoste);


        //contentValues.put(UtilidadesModuloSiete.COLUMN_APIHEREQUI, VariablesModuloSiete.APIHEREQUI );


        long result = db.insert(UtilidadesModuloSiete.TABLA_APICOLA_ALIMENTACION, null, contentValues);
        db.close();
        if(result == -1) {
            return false;
        }else{
            return true;
        }
    }


    public boolean addDatosHerramientas(){
        SQLiteDatabase db               = this.getWritableDatabase();
        ContentValues contentValues    = new ContentValues();

        contentValues.put(UtilidadesModuloSiete.COLUMN_FOLIO,General.Foliocuestion);
        contentValues.put(UtilidadesModuloSiete.COLUMN_IDCAPTURISTA, Principal.userId);

        contentValues.put(UtilidadesModuloSiete.COLUMN_APIHEREQUI, VariablesModuloSiete.APIHEREQUI );
        contentValues.put(UtilidadesModuloSiete.COLUMN_APIHEREQO, VariablesModuloSiete.APIHEREQO );
        contentValues.put(UtilidadesModuloSiete.COLUMN_APITIEM, VariablesModuloSiete.APITIEM);
        contentValues.put(UtilidadesModuloSiete.COLUMN_APICOST, VariablesModuloSiete.APICOST );


        long result = db.insert(UtilidadesModuloSiete.TABLA_APICOLA_HERRAMIENTAS, null, contentValues);
        db.close();
        if(result == -1) {
            return false;
        }else{
            return true;
        }
    }


    public boolean addDatosEnfermedades(){
        SQLiteDatabase db               = this.getWritableDatabase();
        ContentValues contentValues    = new ContentValues();

        contentValues.put(UtilidadesModuloSiete.COLUMN_FOLIO,General.Foliocuestion);
        contentValues.put(UtilidadesModuloSiete.COLUMN_IDCAPTURISTA, Principal.userId);
        contentValues.put(UtilidadesModuloSiete.COLUMN_ENFPAN, VariablesModuloSiete.ENFPAN);
        contentValues.put(UtilidadesModuloSiete.COLUMN_ENFPANO, VariablesModuloSiete.ENFPANO);
        contentValues.put(UtilidadesModuloSiete.COLUMN_ENFCON, VariablesModuloSiete.ENFCON);
        contentValues.put(UtilidadesModuloSiete.COLUMN_ENFMED, VariablesModuloSiete.ENFMED);
        contentValues.put(UtilidadesModuloSiete.COLUMN_ENFMEDOTR, VariablesModuloSiete.ENFMEDOTR);
        contentValues.put(UtilidadesModuloSiete.COLUMN_COSMED, VariablesModuloSiete.COSMED);
        contentValues.put(UtilidadesModuloSiete.COLUMN_ENFPERAP, VariablesModuloSiete.ENFPERAP);



        long result = db.insert(UtilidadesModuloSiete.TABLA_APICOLA_ENFERMEDADES, null, contentValues);
        db.close();
        if(result == -1) {
            return false;
        }else{
            return true;
        }
    }

    public boolean addDatosApicolaIngredientes(String s, String cantidad, String costo){
        SQLiteDatabase db               = this.getWritableDatabase();
        ContentValues contentValues    = new ContentValues();

        contentValues.put(UtilidadesModuloSiete.COLUMN_FOLIO,General.Foliocuestion);
        contentValues.put(UtilidadesModuloSiete.COLUMN_IDCAPTURISTA, Principal.userId);
        contentValues.put(UtilidadesModuloSiete.COLUMN_INGAPIT, s);
        contentValues.put(UtilidadesModuloSiete.COLUMN_CANTCOL, cantidad);
        contentValues.put(UtilidadesModuloSiete.COLUMN_COSCOL, costo);



        long result = db.insert(UtilidadesModuloSiete.TABLA_APICOLA_INGREDIENTES, null, contentValues);
        db.close();
        if(result == -1) {
            return false;
        }else{
            return true;
        }
    }


    public boolean addDatosApicola(){
        SQLiteDatabase db               = this.getWritableDatabase();
        ContentValues contentValues    = new ContentValues();

        contentValues.put(UtilidadesModuloSiete.COLUMN_FOLIO,General.Foliocuestion);
        contentValues.put(UtilidadesModuloSiete.COLUMN_IDCAPTURISTA, Principal.userId);


//	7. ACTIVIDAD APÍCOLA
        contentValues.put(UtilidadesModuloSiete.COLUMN_APIPER, VariablesModuloSiete.APIPER);
        contentValues.put(UtilidadesModuloSiete.COLUMN_APIACT, VariablesModuloSiete.APIACT);
        contentValues.put(UtilidadesModuloSiete.COLUMN_APIAYU, VariablesModuloSiete.APIAYU);
        contentValues.put(UtilidadesModuloSiete.COLUMN_APIAYUO, VariablesModuloSiete.APIAYUO);
        contentValues.put(UtilidadesModuloSiete.COLUMN_APIFIGJ, VariablesModuloSiete.APIFIGJ);
        contentValues.put(UtilidadesModuloSiete.COLUMN_APIFIGJG, VariablesModuloSiete.APIFIGJG);
        contentValues.put(UtilidadesModuloSiete.COLUMN_APIFIGJGO, VariablesModuloSiete.APIFIGJGO);

//	7.1 MANEJO, VariablesModuloSiete.  );
        contentValues.put(UtilidadesModuloSiete.COLUMN_APINUMCOL, VariablesModuloSiete.APINUMCOL);
        contentValues.put(UtilidadesModuloSiete.COLUMN_APINUMAPI, VariablesModuloSiete.APINUMAPI);
        contentValues.put(UtilidadesModuloSiete.COLUMN_APILURA, VariablesModuloSiete.APILURA);
        contentValues.put(UtilidadesModuloSiete.COLUMN_APIMOTLUG, VariablesModuloSiete.APIMOTLUG);
        contentValues.put(UtilidadesModuloSiete.COLUMN_APIMOTLUGO, VariablesModuloSiete.APIMOTLUGO);
        contentValues.put(UtilidadesModuloSiete.COLUMN_APIFRECCO, VariablesModuloSiete.APIFRECCO);
        contentValues.put(UtilidadesModuloSiete.COLUMN_APICAMPAN, VariablesModuloSiete.APICAMPAN);
        contentValues.put(UtilidadesModuloSiete.COLUMN_APIFRECPAN, VariablesModuloSiete.APIFRECPAN);
        contentValues.put(UtilidadesModuloSiete.COLUMN_APICONCOL, VariablesModuloSiete.APICONCOL);
        contentValues.put(UtilidadesModuloSiete.COLUMN_OTCOCOLAPI, VariablesModuloSiete.OTCOCOLAPI);

//	Ir a hoja: 7.1 Herramientas

//	7.2. CAPACITACIÓN Y ASISTENCIA TÉCNICA
        contentValues.put(UtilidadesModuloSiete.COLUMN_APICAP, VariablesModuloSiete.APICAP  );
        contentValues.put(UtilidadesModuloSiete.COLUMN_APICAPAC, VariablesModuloSiete.APICAPAC  );
        contentValues.put(UtilidadesModuloSiete.COLUMN_APICAPACO, VariablesModuloSiete.APICAPACO  );
        contentValues.put(UtilidadesModuloSiete.COLUMN_APIRESCAP, VariablesModuloSiete.APIRESCAP  );
        contentValues.put(UtilidadesModuloSiete.COLUMN_APIRESCAPO, VariablesModuloSiete.APIRESCAPO  );
        contentValues.put(UtilidadesModuloSiete.COLUMN_APINOCAP, VariablesModuloSiete.APINOCAP  );
        contentValues.put(UtilidadesModuloSiete.COLUMN_APINOCAPO, VariablesModuloSiete.APINOCAPO  );
        contentValues.put(UtilidadesModuloSiete.COLUMN_APIINSCAP, VariablesModuloSiete.APIINSCAP  );
        contentValues.put(UtilidadesModuloSiete.COLUMN_APIINSCAPO, VariablesModuloSiete.APIINSCAPO  );
        contentValues.put(UtilidadesModuloSiete.COLUMN_APITEMASE, VariablesModuloSiete.APITEMASE  );
        contentValues.put(UtilidadesModuloSiete.COLUMN_APITEMASEO, VariablesModuloSiete.APITEMASEO );
        contentValues.put(UtilidadesModuloSiete.COLUMN_APIFRECASI, VariablesModuloSiete.APIFRECASI  );
        contentValues.put(UtilidadesModuloSiete.COLUMN_APIFCASIO, VariablesModuloSiete.APIFCASIO  );

//	7.3. ALIMENTACION
        contentValues.put(UtilidadesModuloSiete.COLUMN_APIALIM, VariablesModuloSiete.APIALIM);
        contentValues.put(UtilidadesModuloSiete.COLUMN_APICONALI, VariablesModuloSiete.APICONALI);
        contentValues.put(UtilidadesModuloSiete.COLUMN_APICONALIO, VariablesModuloSiete.APICONALIO);

//	Ir a hoja: 7.3 Tipo de alimentación

//	Ir a hoja: 7.3 Cantidad ingredientes

        contentValues.put(UtilidadesModuloSiete.COLUMN_APINORAZ, VariablesModuloSiete.APINORAZ);
        contentValues.put(UtilidadesModuloSiete.COLUMN_APINORAZO, VariablesModuloSiete.APINORAZO);

//	7.4 REPRODUCCIÓN
        contentValues.put(UtilidadesModuloSiete.COLUMN_APIENJ, VariablesModuloSiete.APIENJ  );
        contentValues.put(UtilidadesModuloSiete.COLUMN_APIMESENJ, VariablesModuloSiete.APIMESENJ  );
        contentValues.put(UtilidadesModuloSiete.COLUMN_APIDIVCOL, VariablesModuloSiete.APIDIVCOL  );
        contentValues.put(UtilidadesModuloSiete.COLUMN_APICARDC, VariablesModuloSiete.APICARDC  );
        contentValues.put(UtilidadesModuloSiete.COLUMN_OTRAPICARC, VariablesModuloSiete.OTRAPICARC  );
        contentValues.put(UtilidadesModuloSiete.COLUMN_APICAPENJ, VariablesModuloSiete.APICAPENJ  );
        contentValues.put(UtilidadesModuloSiete.COLUMN_APIRAZCE, VariablesModuloSiete.APIRAZCE  );
        contentValues.put(UtilidadesModuloSiete.COLUMN_APIRAZCEO, VariablesModuloSiete.APIRAZCEO  );
        contentValues.put(UtilidadesModuloSiete.COLUMN_APIPROENJ, VariablesModuloSiete.APIPROENJ  );
        contentValues.put(UtilidadesModuloSiete.COLUMN_APIPROENJO, VariablesModuloSiete.APIPROENJO  );
        contentValues.put(UtilidadesModuloSiete.COLUMN_APIUNICOL, VariablesModuloSiete.APIUNICOL  );
        contentValues.put(UtilidadesModuloSiete.COLUMN_APIACTUC, VariablesModuloSiete.APIACTUC  );
        contentValues.put(UtilidadesModuloSiete.COLUMN_APIACTUCO, VariablesModuloSiete.APIACTUCO  );
        contentValues.put(UtilidadesModuloSiete.COLUMN_APICREI, VariablesModuloSiete.APICREI  );
        contentValues.put(UtilidadesModuloSiete.COLUMN_APIOBJREI, VariablesModuloSiete.APIOBJREI  );
        contentValues.put(UtilidadesModuloSiete.COLUMN_APIOBJREIO, VariablesModuloSiete.APIOBJREIO  );
        contentValues.put(UtilidadesModuloSiete.COLUMN_APICAMR, VariablesModuloSiete.APICAMR  );
        contentValues.put(UtilidadesModuloSiete.COLUMN_APIOBTREI, VariablesModuloSiete.APIOBTREI  );
        contentValues.put(UtilidadesModuloSiete.COLUMN_APICOSABE, VariablesModuloSiete.APICOSABE  );

//	7.5 SANIDAD
        contentValues.put(UtilidadesModuloSiete.COLUMN_APIENFCC, VariablesModuloSiete.APIENFCC );
        contentValues.put(UtilidadesModuloSiete.COLUMN_APICOLENF, VariablesModuloSiete.APICOLENF  );

        contentValues.put(UtilidadesModuloSiete.COLUMN_MUNABE, VariablesModuloSiete.MUNABE  );
        contentValues.put(UtilidadesModuloSiete.COLUMN_MESMUNA, VariablesModuloSiete.MESMUNA  );
        contentValues.put(UtilidadesModuloSiete.COLUMN_TRATAM, VariablesModuloSiete.TRATAM  );


//	7.6 COSECHA
        contentValues.put(UtilidadesModuloSiete.COLUMN_EPOCOSMI, VariablesModuloSiete.EPOCOSMI  );


//	¿Con qué equipos cuenta para la cosecha?
//	Tabla de equipo para la cosecha
        contentValues.put(UtilidadesModuloSiete.COLUMN_COSTEQAHUM, VariablesModuloSiete.COSTEQAHUM);
        contentValues.put(UtilidadesModuloSiete.COLUMN_COSTEQCUNA, VariablesModuloSiete.COSTEQCUNA);
        contentValues.put(UtilidadesModuloSiete.COLUMN_COSTEQCOCA, VariablesModuloSiete.COSTEQCOCA);
        contentValues.put(UtilidadesModuloSiete.COLUMN_COSTEQCOCE, VariablesModuloSiete.COSTEQCOCE);
        contentValues.put(UtilidadesModuloSiete.COLUMN_COSTEQCOCH, VariablesModuloSiete.COSTEQCOCH);
        contentValues.put(UtilidadesModuloSiete.COLUMN_COSTEQCOBA, VariablesModuloSiete.COSTEQCOBA);
        contentValues.put(UtilidadesModuloSiete.COLUMN_COSTEQCOVE, VariablesModuloSiete.COSTEQCOVE);
        contentValues.put(UtilidadesModuloSiete.COLUMN_COSTEQCOCU, VariablesModuloSiete.COSTEQCOCU);


        contentValues.put(UtilidadesModuloSiete.COLUMN_EXTMIEL, VariablesModuloSiete.EXTMIEL);
        contentValues.put(UtilidadesModuloSiete.COLUMN_NJOREM, VariablesModuloSiete.NJOREM);
        contentValues.put(UtilidadesModuloSiete.COLUMN_COSJOREM, VariablesModuloSiete.COSJOREM);
        contentValues.put(UtilidadesModuloSiete.COLUMN_EQUEM, VariablesModuloSiete.EQUEM);
        contentValues.put(UtilidadesModuloSiete.COLUMN_COSTEM, VariablesModuloSiete.COSTEM);

        contentValues.put(UtilidadesModuloSiete.COLUMN_PROCERA, VariablesModuloSiete.PROCERA);

//	7.7 ASPECTOS PRODUCTIVOS
        contentValues.put(UtilidadesModuloSiete.COLUMN_PROCOL, VariablesModuloSiete.PROCOL );
        contentValues.put(UtilidadesModuloSiete.COLUMN_FACLIMMI, VariablesModuloSiete.FACLIMMI);
        contentValues.put(UtilidadesModuloSiete.COLUMN_FACLIMMIO, VariablesModuloSiete.FACLIMMIO);
        contentValues.put(UtilidadesModuloSiete.COLUMN_RAZNOPMI, VariablesModuloSiete.RAZNOPMI);
        contentValues.put(UtilidadesModuloSiete.COLUMN_RAZNOPMIO, VariablesModuloSiete.RAZNOPMIO);



        long result = db.insert(UtilidadesModuloSiete.TABLA_APICOLA, null, contentValues);
        db.close();
        if(result == -1) {
            return false;
        }else{
            return true;
        }
    }


    //++++++++++++++++++++++++++++++++++ADD INFRAESTRUCTURA +++++++++++++++++++++++++++++++++++++++++++++++
    public boolean addDatosInfraestructura(){
        SQLiteDatabase db               = this.getWritableDatabase();
        ContentValues contentValues    = new ContentValues();

        contentValues.put(UtilidadesModuloDiez.COLUMN_FOLIO,General.Foliocuestion);
        contentValues.put(UtilidadesModuloDiez.COLUMN_IDCAPTURIS, Principal.userId);
        contentValues.put(UtilidadesModuloDiez.COLUMN_INMAEQUPF,  VariablesGlobalesCmrz.INMAEQUPF);
        contentValues.put(UtilidadesModuloDiez.COLUMN_INMAEQOTR,  VariablesGlobalesCmrz.INMAEQOTR);
        contentValues.put(UtilidadesModuloDiez.COLUMN_CAINMAEQ, VariablesGlobalesCmrz.CAINMAEQ);
        contentValues.put(UtilidadesModuloDiez.COLUMN_CONINMAEQ, VariablesGlobalesCmrz.CONINMAEQ);
        contentValues.put(UtilidadesModuloDiez.COLUMN_PROINMAEQ,VariablesGlobalesCmrz.PROINMAEQ);
        contentValues.put(UtilidadesModuloDiez.COLUMN_COSTUNIME, VariablesGlobalesCmrz.COSTUNIME);


        long result = db.insert(UtilidadesModuloDiez.TABLA_INFRAESTRUCTURA, null, contentValues);
        db.close();
        if(result == -1) {
            return false;
        }else{
            return true;
        }
    }



    //++++++++++++++++++++++++++++++++++ADD FRUTALES +++++++++++++++++++++++++++++++++++++++++++++++
    public boolean addDatosFrutalesEmpaque(String valorStr, String valorCrt, String otroEdit){
        SQLiteDatabase db               = this.getWritableDatabase();
        ContentValues contentValues    = new ContentValues();

        contentValues.put(UtilidadesModuloSeis.COLUMN_FOLIO,General.Foliocuestion);
        contentValues.put(UtilidadesModuloSeis.COLUMN_IDCAPTURIS, Principal.userId );
        contentValues.put(UtilidadesModuloSeis.COLUMN_TIPOFRUTAL, VariablesFrutales.TIPOFRUTAL);	//	Tipo de frutal
        contentValues.put(UtilidadesModuloSeis.COLUMN_EMPAQFRT, valorStr);
        contentValues.put(UtilidadesModuloSeis.COLUMN_JOREMPAQFRT, valorCrt);
        contentValues.put(UtilidadesModuloSeis.COLUMN_TRAEMPFRUOEDIT, otroEdit);



        long result = db.insert(UtilidadesModuloSeis.TABLA_FRUTALES_EMPAQUE, null, contentValues);
        db.close();
        if(result == -1) {
            return false;
        }else{
            return true;
        }
    }

    public boolean addDatosFrutalesCosecha(String valorStr, String valorCrt){
        SQLiteDatabase db               = this.getWritableDatabase();
        ContentValues contentValues    = new ContentValues();

        contentValues.put(UtilidadesModuloSeis.COLUMN_FOLIO,General.Foliocuestion);
        contentValues.put(UtilidadesModuloSeis.COLUMN_IDCAPTURIS, Principal.userId );
        contentValues.put(UtilidadesModuloSeis.COLUMN_TIPOFRUTAL, VariablesFrutales.TIPOFRUTAL);	//	Tipo de frutal
        contentValues.put(UtilidadesModuloSeis.COLUMN_ACTCOSECHFRT, valorStr);
        contentValues.put(UtilidadesModuloSeis.COLUMN_JORCOSGRFRT, valorCrt);


        long result = db.insert(UtilidadesModuloSeis.TABLA_FRUTALES_COSECHA, null, contentValues);
        db.close();
        if(result == -1) {
            return false;
        }else{
            return true;
        }
    }


    public boolean addDatosFrutalesPlagas(){
        SQLiteDatabase db               = this.getWritableDatabase();
        ContentValues contentValues    = new ContentValues();

        contentValues.put(UtilidadesModuloSeis.COLUMN_FOLIO,General.Foliocuestion);
        contentValues.put(UtilidadesModuloSeis.COLUMN_IDCAPTURIS, Principal.userId );
        contentValues.put(UtilidadesModuloSeis.COLUMN_TIPOFRUTAL, VariablesFrutales.TIPOFRUTAL);	//	Tipo de frutal
        contentValues.put(UtilidadesModuloSeis.COLUMN_PLAGAFRT,VariablesFrutales.PLAGAFRT); //	Text	Plagas y/o enfermedades
        contentValues.put(UtilidadesModuloSeis.COLUMN_PLATIPCOTFRT,VariablesFrutales.PLATIPCOTFRT); //	Text	Tipo de control.
        contentValues.put(UtilidadesModuloSeis.COLUMN_PLATCOGRFRT,VariablesFrutales.PLATCOGRFRT); //	Text	Otro
        contentValues.put(UtilidadesModuloSeis.COLUMN_PLAPROGRFRT,VariablesFrutales.PLAPROGRFRT); //	Text	Insecticida o producto
        contentValues.put(UtilidadesModuloSeis.COLUMN_PLACANTGRFRT,VariablesFrutales.PLACANTGRFRT); //	Integer	Cantidad (l ó kg)/ha

        contentValues.put(UtilidadesModuloSeis.COLUMN_PEJORGRFRT,VariablesFrutales.PEJORGRFRT); //	Integer	Jornales
        contentValues.put(UtilidadesModuloSeis.COLUMN_INSPROGRFRT,VariablesFrutales.INSPROGRFRT); //	Text	Costo del insecticida o producto

        long result = db.insert(UtilidadesModuloSeis.TABLA_FRUTALES_PLAGAS, null, contentValues);
        db.close();
        if(result == -1) {
            return false;
        }else{
            return true;
        }
    }

    public boolean addDatosFrutalesMaleza(){
        SQLiteDatabase db               = this.getWritableDatabase();
        ContentValues contentValues    = new ContentValues();

        contentValues.put(UtilidadesModuloSeis.COLUMN_FOLIO,General.Foliocuestion);
        contentValues.put(UtilidadesModuloSeis.COLUMN_IDCAPTURIS, Principal.userId );
        contentValues.put(UtilidadesModuloSeis.COLUMN_TIPOFRUTAL, VariablesFrutales.TIPOFRUTAL);	//	Tipo de frutal
        contentValues.put(UtilidadesModuloSeis.COLUMN_MALGRFRT,VariablesFrutales.MALGRFRT); //	Text	Maleza
        contentValues.put(UtilidadesModuloSeis.COLUMN_NCFRUFRT,VariablesFrutales.NCFRUFRT); //	Text	Nombre común
        contentValues.put(UtilidadesModuloSeis.COLUMN_CONQMGRFRT,VariablesFrutales.CONQMGRFRT); //	Text	Control: (1) químico o 2) manual
        contentValues.put(UtilidadesModuloSeis.COLUMN_HERGRFRT,VariablesFrutales.HERGRFRT); //	Text	Herbicida
        contentValues.put(UtilidadesModuloSeis.COLUMN_HERCANGRFRT,VariablesFrutales.HERCANGRFRT); //	Integer	Cantidad (l ó kg / ha)
        contentValues.put(UtilidadesModuloSeis.COLUMN_HJORGRFRT,VariablesFrutales.HJORGRFRT); //	Integer	Jornales
        contentValues.put(UtilidadesModuloSeis.COLUMN_CHERGRFRT,VariablesFrutales.CHERGRFRT); //	Text	Costo herbicida

        long result = db.insert(UtilidadesModuloSeis.TABLA_FRUTALES_MALEZA, null, contentValues);
        db.close();
        if(result == -1) {
            return false;
        }else{
            return true;
        }
    }


    public boolean addDatosFrutalesFertilizante(){
        SQLiteDatabase db               = this.getWritableDatabase();
        ContentValues contentValues    = new ContentValues();

        contentValues.put(UtilidadesModuloSeis.COLUMN_FOLIO,General.Foliocuestion);
        contentValues.put(UtilidadesModuloSeis.COLUMN_IDCAPTURIS, Principal.userId );
        contentValues.put(UtilidadesModuloSeis.COLUMN_TIPOFRUTAL, VariablesFrutales.TIPOFRUTAL);	//	Tipo de frutal
        contentValues.put(UtilidadesModuloSeis.COLUMN_FERTGRAFRT,VariablesFrutales.FERTGRAFRT); //	Text	Fertilizantes y/o abonos aplicados
        contentValues.put(UtilidadesModuloSeis.COLUMN_EFFRUTFRT,VariablesFrutales.EFFRUTFRT); //	Text	Etapa fenológica
        contentValues.put(UtilidadesModuloSeis.COLUMN_FERAPPGFRT,VariablesFrutales.FERAPPGFRT); //	Text	Fecha de aplicación
        contentValues.put(UtilidadesModuloSeis.COLUMN_FERCANGFRT,VariablesFrutales.FERCANGFRT); //	Integer	Cantidad (l o kg / ha)
        contentValues.put(UtilidadesModuloSeis.COLUMN_FERCOSGFRT,VariablesFrutales.FERCOSGFRT); //	Integer	Costo de fertilizante
        contentValues.put(UtilidadesModuloSeis.COLUMN_FERJORGFRT,VariablesFrutales.FERJORGFRT); //	Integer	Núm. de jornales
        contentValues.put(UtilidadesModuloSeis.COLUMN_METODOFRT,VariablesFrutales.METODOFRT); //	METODO DE APLICACION


        long result = db.insert(UtilidadesModuloSeis.TABLA_FRUTALES_FERTILIZANTE, null, contentValues);
        db.close();
        if(result == -1) {
            return false;
        }else{
            return true;
        }
    }


    public boolean addDatosFrutalesSueloDsp(){
        SQLiteDatabase db               = this.getWritableDatabase();
        ContentValues contentValues    = new ContentValues();

        contentValues.put(UtilidadesModuloSeis.COLUMN_FOLIO,General.Foliocuestion);
        contentValues.put(UtilidadesModuloSeis.COLUMN_IDCAPTURIS, Principal.userId );
        contentValues.put(UtilidadesModuloSeis.COLUMN_TIPOFRUTAL, VariablesFrutales.TIPOFRUTAL);	//	Tipo de frutal
        contentValues.put(UtilidadesModuloSeis.COLUMN_LABPRESFRTDSP, VariablesFrutales.LABPRESFRTDSP); //	Text	Actividad que realiza para la preparación del suelo
        contentValues.put(UtilidadesModuloSeis.COLUMN_NUMVLFRTDSP, VariablesFrutales.NUMVLFRTDSP); //	Integer	Número de veces
        contentValues.put(UtilidadesModuloSeis.COLUMN_EQUIPOLFRTDSP,VariablesFrutales.EQUIPOLFRTDSP); //	Text	Equipo (propio/maquila)
        contentValues.put(UtilidadesModuloSeis.COLUMN_COSTOLFRTDSP, VariablesFrutales.COSTOLFRTDSP); //	Text	Costo/ha
        contentValues.put(UtilidadesModuloSeis.COLUMN_NUMJORLFRTDSP, VariablesFrutales.NUMJORLFRTDSP); //	Integer	Núm. de


        long result = db.insert(UtilidadesModuloSeis.TABLA_FRUTALES_SUELO_DESP, null, contentValues);
        db.close();
        if(result == -1) {
            return false;
        }else{
            return true;
        }
    }

        public boolean addDatosFrutalesSuelo(){
        SQLiteDatabase db               = this.getWritableDatabase();
        ContentValues contentValues    = new ContentValues();

        contentValues.put(UtilidadesModuloSeis.COLUMN_FOLIO,General.Foliocuestion);
        contentValues.put(UtilidadesModuloSeis.COLUMN_IDCAPTURIS, Principal.userId );
            contentValues.put(UtilidadesModuloSeis.COLUMN_TIPOFRUTAL, VariablesFrutales.TIPOFRUTAL);	//	Tipo de frutal
        contentValues.put(UtilidadesModuloSeis.COLUMN_LABPRESFRT, VariablesFrutales.LABPRESFRT); //	Text	Actividad que realiza para la preparación del suelo
        contentValues.put(UtilidadesModuloSeis.COLUMN_NUMVLFRT, VariablesFrutales.NUMVLFRT); //	Integer	Número de veces
        contentValues.put(UtilidadesModuloSeis.COLUMN_EQUIPOLFRT, VariablesFrutales.EQUIPOLFRT); //	Text	Equipo (propio/maquila)
        contentValues.put(UtilidadesModuloSeis.COLUMN_COSTOLFRT, VariablesFrutales.COSTOLFRT); //	Text	Costo/ha
        contentValues.put(UtilidadesModuloSeis.COLUMN_NUMJORLFRT, VariablesFrutales.NUMJORLFRT); //	Integer	Núm. de jornales

        long result = db.insert(UtilidadesModuloSeis.TABLA_FRUTALES_SUELO, null, contentValues);
        db.close();
        if(result == -1) {
            return false;
        }else{
            return true;
        }
    }



    public boolean addDatosFrutales(){
        SQLiteDatabase db               = this.getWritableDatabase();
        ContentValues contentValues    = new ContentValues();

        contentValues.put(UtilidadesModuloSeis.COLUMN_FOLIO,General.Foliocuestion);
        contentValues.put(UtilidadesModuloSeis.COLUMN_IDCAPTURIS, Principal.userId );	//	Número del capturista
        contentValues.put(UtilidadesModuloSeis.COLUMN_TIPOFRUTAL, VariablesFrutales.TIPOFRUTAL);	//	Tipo de frutal
        contentValues.put(UtilidadesModuloSeis.COLUMN_OTROTIPOFRUTAL, VariablesFrutales.OTROTIPOFRUTAL);	//	¿Año de establecimiento del frutal? 	1
        contentValues.put(UtilidadesModuloSeis.COLUMN_ESTFRU, VariablesFrutales.ESTFRU);	//	¿Año de establecimiento del frutal? 	1
        contentValues.put(UtilidadesModuloSeis.COLUMN_ESTABIPLA, VariablesFrutales.ESTABIPLA);	//	¿Año de estabilización de la plantación?	1
        contentValues.put(UtilidadesModuloSeis.COLUMN_SUPPLANT, VariablesFrutales.SUPPLANT);	//	¿cuál es la superficie (ha) plantada total? 	1
        contentValues.put(UtilidadesModuloSeis.COLUMN_CONSUPNU, VariablesFrutales.CONSUPNU);	//	Superficie nueva (ha)	1
        contentValues.put(UtilidadesModuloSeis.COLUMN_CONSUPDE, VariablesFrutales.CONSUPDE);	//	Superficie en desarrollo (ha)	1
        contentValues.put(UtilidadesModuloSeis.COLUMN_CONSUPPRO, VariablesFrutales.CONSUPPRO);	//	Superficie en producción (ha)	1
        contentValues.put(UtilidadesModuloSeis.COLUMN_DECFRU, VariablesFrutales.DECFRU);	//	¿Por qué decidió plantar este frutal?	1
        contentValues.put(UtilidadesModuloSeis.COLUMN_INFFRU, VariablesFrutales.INFFRU);	//	¿Qué tipo de infraestructura utiliza?	1
        contentValues.put(UtilidadesModuloSeis.COLUMN_OTINFFRU, VariablesFrutales.OTINFFRU);	//	Otro tipo de infraestructura utilizada	1
        contentValues.put(UtilidadesModuloSeis.COLUMN_AFESINI, VariablesFrutales.AFESINI);	//	¿Su plantación tuvo alguna afectación por siniestro?	1
        contentValues.put(UtilidadesModuloSeis.COLUMN_CAUSINF, VariablesFrutales.CAUSINF);	//	¿Cuál fue la causa de la superficie siniestrada?	1
        contentValues.put(UtilidadesModuloSeis.COLUMN_ASOFRU, VariablesFrutales.ASOFRU);	//	¿Está asociado con otro cultivo?	1
        contentValues.put(UtilidadesModuloSeis.COLUMN_ASOFRUCUL, VariablesFrutales.ASOFRUCUL);	//	¿Con cuál cultivo está asociado?	1
        contentValues.put(UtilidadesModuloSeis.COLUMN_FECHSICUL, VariablesFrutales.FECHSICUL);	//	¿Cuál es la fecha de siembra del cultivo asociado?	1
        contentValues.put(UtilidadesModuloSeis.COLUMN_ASOCULT, VariablesFrutales.ASOCULT);	//	¿Ha recibido alguna asesoría para establecer otro cultivo? 	1
        contentValues.put(UtilidadesModuloSeis.COLUMN_OTROFRU, VariablesFrutales.OTROFRU);	//	¿Cuál cultivo?	1

        contentValues.put(UtilidadesModuloSeis.COLUMN_PROPLANT, VariablesFrutales.PROPLANT);	//	¿Cuál es la procedencia de su plantación?	2
        contentValues.put(UtilidadesModuloSeis.COLUMN_PROPLANTOTRO, VariablesFrutales.PROPLANTOTRO);	//	¿Cuál es la procedencia de su plantación? OTRO	2
        contentValues.put(UtilidadesModuloSeis.COLUMN_TIPVIVFRU, VariablesFrutales.TIPVIVFRU);	//	¿El vivero es?	2
        contentValues.put(UtilidadesModuloSeis.COLUMN_PROPLANTD, VariablesFrutales.PROPLANTD);	//	¿De dónde procede su plantación?	2
        contentValues.put(UtilidadesModuloSeis.COLUMN_PROPLANTDOTRO, VariablesFrutales.PROPLANTDOTRO);			//¿De dónde procede su plantación? OTRO
        contentValues.put(UtilidadesModuloSeis.COLUMN_VARFRU, VariablesFrutales.VARFRU);	//	¿Qué variedad tiene?	2
        contentValues.put(UtilidadesModuloSeis.COLUMN_VARFRUC, VariablesFrutales.VARFRUC);	//	¿Cuál? CERTIFICADA Y OTRO	2
        contentValues.put(UtilidadesModuloSeis.COLUMN_MODSELVF, VariablesFrutales.MODSELVF);	//	¿Por qué selecciono dicha variedad?	2
        contentValues.put(UtilidadesModuloSeis.COLUMN_MODSELVFO, VariablesFrutales.MODSELVFO);	//	¿Por qué selecciono dicha variedad? OTRO	2
        contentValues.put(UtilidadesModuloSeis.COLUMN_DENDFRU, VariablesFrutales.DENDFRU);	//	¿Cuál es la densidad de plantación por hectárea? 	2
        contentValues.put(UtilidadesModuloSeis.COLUMN_COSPLANFRU, VariablesFrutales.COSPLANFRU);	//	¿Cuál es el costo por planta? $/planta	2
        contentValues.put(UtilidadesModuloSeis.COLUMN_DISTFRUT, VariablesFrutales.DISTFRUT);	//	¿Cuál es la distancia entre hileras y entre plantas?	2

        contentValues.put(UtilidadesModuloSeis.COLUMN_ANAFERHOFRT, VariablesFrutales.ANAFERHOFRT);
        contentValues.put(UtilidadesModuloSeis.COLUMN_ANLISIFRT, VariablesFrutales.ANLISIFRT);
        contentValues.put(UtilidadesModuloSeis.COLUMN_SUELHOFRT, VariablesFrutales.SUELHOFRT);
        contentValues.put(UtilidadesModuloSeis.COLUMN_PRESUELHOFRT, VariablesFrutales.PRESUELHOFRT);
        contentValues.put(UtilidadesModuloSeis.COLUMN_FOLHOFRT, VariablesFrutales.FOLHOFRT);
        contentValues.put(UtilidadesModuloSeis.COLUMN_PREFOLHOFRT, VariablesFrutales.PREFOLHOFRT);
        contentValues.put(UtilidadesModuloSeis.COLUMN_AGUAHOFRT, VariablesFrutales.AGUAHOFRT);
        contentValues.put(UtilidadesModuloSeis.COLUMN_PREAGUAHOFRT, VariablesFrutales.PREAGUAHOFRT);
        contentValues.put(UtilidadesModuloSeis.COLUMN_TIPFERHORFRT, VariablesFrutales.TIPFERHORFRT);

        contentValues.put(UtilidadesModuloSeis.COLUMN_OTRFRERIE, VariablesFrutales.OTRFRERIE);	//	Otra frecuencia de riego	7
        contentValues.put(UtilidadesModuloSeis.COLUMN_APFOLIAR, VariablesFrutales.APFOLIAR);	//	¿Qué tipo de aplicación foliar aplica?	7
        contentValues.put(UtilidadesModuloSeis.COLUMN_OTROTFOL, VariablesFrutales.OTROTFOL);	//	Otro	7
        contentValues.put(UtilidadesModuloSeis.COLUMN_RIEFRUT, VariablesFrutales.RIEFRUT);	//	¿Realiza algún riego?	7
        contentValues.put(UtilidadesModuloSeis.COLUMN_TIPSISFR, VariablesFrutales.TIPSISFR);	//	¿Qué tipo de riego?	7
        contentValues.put(UtilidadesModuloSeis.COLUMN_TIPSISFRO, VariablesFrutales.TIPSISFRO);	//	Otro	7
        contentValues.put(UtilidadesModuloSeis.COLUMN_FRECRFR, VariablesFrutales.FRECRFR);	//	¿Cada cuando riega?
        contentValues.put(UtilidadesModuloSeis.COLUMN_COSTORF, VariablesFrutales.COSTORF);	//	¿Cuál es el costo de riego? ($/riego)	7
        contentValues.put(UtilidadesModuloSeis.COLUMN_JORNALESF, VariablesFrutales.JORNALESF);	//	¿Cuántos jornales utiliza por riego?	7
        contentValues.put(UtilidadesModuloSeis.COLUMN_TIERIE, VariablesFrutales.TIERIE);	//	¿Cuál es el tiempo que ocupa el riego?	7
        contentValues.put(UtilidadesModuloSeis.COLUMN_TIERIEO, VariablesFrutales.TIERIEO);	//	Otro	7

        contentValues.put(UtilidadesModuloSeis.COLUMN_PCFRU, VariablesFrutales.PCFRU);	//	¿Ha detectado alguna plaga cuarentenaria? 	9
        contentValues.put(UtilidadesModuloSeis.COLUMN_PLACUA, VariablesFrutales.PLACUA);	//	¿Cuál?	9
        contentValues.put(UtilidadesModuloSeis.COLUMN_PLACUAO, VariablesFrutales.PLACUAO);	//	Otra	9

        contentValues.put(UtilidadesModuloSeis.COLUMN_ACCOSFR, VariablesFrutales.ACCOSFR);	//	¿Qué accesorios utiliza para la cosecha?	11
        contentValues.put(UtilidadesModuloSeis.COLUMN_ACCOSFRO, VariablesFrutales.ACCOSFRO);	//	Otro	11
        contentValues.put(UtilidadesModuloSeis.COLUMN_CINOFRU, VariablesFrutales.CINOFRU);	//	¿Realiza algún control de inocuidad?	11
        contentValues.put(UtilidadesModuloSeis.COLUMN_INOFRUT, VariablesFrutales.INOFRUT);	//	¿Cuál?	11

        contentValues.put(UtilidadesModuloSeis.COLUMN_NUMCOFR, VariablesFrutales.NUMCOFR);	//	¿Cuántas cortes realiza?	13
        contentValues.put(UtilidadesModuloSeis.COLUMN_TRAEMPFRU, VariablesFrutales.TRAEMPFRU);	//	¿Cómo realiza el transporte al empaque?	13
        contentValues.put(UtilidadesModuloSeis.COLUMN_TRAEMPFRUO, VariablesFrutales.TRAEMPFRUO);	//	Otro	13

        contentValues.put(UtilidadesModuloSeis.COLUMN_MPFRUT, VariablesFrutales.MPFRUT);	//	¿Realiza algún manejo postcosecha? 	14
        contentValues.put(UtilidadesModuloSeis.COLUMN_MPFRUTCUAL, VariablesFrutales.MPFRUTCUAL);	//	¿Realiza algún manejo postcosecha? 	14
        contentValues.put(UtilidadesModuloSeis.COLUMN_MPFRUTCUALOTRO, VariablesFrutales.MPFRUTCUALOTRO);	//	¿Realiza algún manejo postcosecha? 	14


        long result = db.insert(UtilidadesModuloSeis.TABLA_FRUTALES, null, contentValues);
        db.close();
        if(result == -1) {
            return false;
        }else{
            return true;
        }
    }



    //+++++++++++++++++++++++++++++++++++ADD USUARIOS +++++++++++++++++++++++++++++++++++++++++++++++
    public boolean addDatosUsers(String INVSTRESPON, String USUARIO, String PASSWORD){
        SQLiteDatabase db               = this.getWritableDatabase();
        ContentValues contentValues    = new ContentValues();

        contentValues.put(UtilidadesUsuarios.COLUMN_INVEST, INVSTRESPON);
        contentValues.put(UtilidadesUsuarios.COLUMN_USUARIO, USUARIO);
        contentValues.put(UtilidadesUsuarios.COLUMN_PASSWD, PASSWORD);

        long result = db.insert(UtilidadesUsuarios.TABLA_USUARIOS, null, contentValues);
        db.close();
        if(result == -1) {
            return false;
        }else{
            return true;
        }
    }

    public String getUser(String usario, String password){
        String valorAsign = null;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor c = db.rawQuery("select USUARIO, PASSWORD from " + UtilidadesUsuarios.TABLA_USUARIOS + " where " + UtilidadesUsuarios.COLUMN_USUARIO + " = ? AND " + UtilidadesUsuarios.COLUMN_PASSWD + "= ?", new String[]{usario, password});
        //long result = db.rawQuery("select USUARIO, PASSWORD from " + UtilidadesUsuarios.TABLA_USUARIOS + " where " + UtilidadesUsuarios.COLUMN_USUARIO + " = ? AND " + UtilidadesUsuarios.COLUMN_PASSWD + "= ?", new String[]{usario, password});



        if(c.getCount() > 0){
            if(c.moveToFirst()){
                valorAsign = c.getString(c.getColumnIndex(UtilidadesUsuarios.COLUMN_USUARIO));
            }

            c.close();
            db.close();
            return valorAsign;
        }else{
            c.close();
            db.close();
            return null;
        }

    }


    //+++++++++++++++++++++++++++++++++++ADD MUNICIPIOS+++++++++++++++++++++++++++++++++++++++++++++++
    public boolean addDatosAzure(int cvent, int cvemun, int cvegeo, String noment, String nommun){
        SQLiteDatabase db               = this.getWritableDatabase();
        ContentValues contentValues    = new ContentValues();

        contentValues.put(UtilidadesEdoMunicipios.COLUMN_CVE_ENT, cvent);
        contentValues.put(UtilidadesEdoMunicipios.COLUMN_CVE_MUN, cvemun);
        contentValues.put(UtilidadesEdoMunicipios.COLUMN_CVEGEO, cvegeo);
        contentValues.put(UtilidadesEdoMunicipios.COLUMN_NOM_ENT, noment);
        contentValues.put(UtilidadesEdoMunicipios.COLUMN_NOM_MUN, nommun);

        long result = db.insert(UtilidadesEdoMunicipios.TABLA_MUNICIPIOS, null, contentValues);
        db.close();
        if(result == -1) {
            return false;
        }else{
            return true;
        }
    }

    public Cursor getListaMunicipios(String getEdo) {
        SQLiteDatabase db = this.getReadableDatabase();
      //  String sql = "SELECT * FROM " + UtilidadesEdoMunicipios.TABLA_MUNICIPIOS + " WHERE " + UtilidadesEdoMunicipios.COLUMN_NOM_ENT + "==" + " ASC;";
        String selection = UtilidadesEdoMunicipios.COLUMN_NOM_ENT + " = ?";
       // String[] selectionArgs = { "Aguascalientes" };
        String[] selectionArgs = { getEdo };

        //Cursor c = db.rawQuery(sql, null);
        Cursor c = db.query(UtilidadesEdoMunicipios.TABLA_MUNICIPIOS,
                null,
                selection,
                selectionArgs,
                null,
                null,
                null);
        return c;
    }



    //++++++++++++++++++++++++++++++++++ ADD COMERCIALIZACION MODULO 10 ++++++++++++++++++++++++++++++++
    public boolean addComercializacionApicolaGral() {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        //contentValues.put(UtilidadesModuloDiez.COLUMN_FOLIO,VariablesGlobalesCmrz.FOLIO);
        contentValues.put(UtilidadesModuloDiez.COLUMN_FOLIO,General.Foliocuestion);
        contentValues.put(UtilidadesModuloDiez.COLUMN_IDCAPTURIS, Principal.userId);

        contentValues.put(UtilidadesModuloDiez.COLUMN_VENTPRO,VariablesGlobalesCmrz.VENTPRO);
        contentValues.put(UtilidadesModuloDiez.COLUMN_COSTFLEA ,VariablesGlobalesCmrz.COSTFLEA);
        contentValues.put(UtilidadesModuloDiez.COLUMN_COSTCONTR1 ,VariablesGlobalesCmrz.COSTCONTR1);
        contentValues.put(UtilidadesModuloDiez.COLUMN_COSTCONTR2 ,VariablesGlobalesCmrz.COSTCONTR2);
        contentValues.put(UtilidadesModuloDiez.COLUMN_COSTCONTR3 ,VariablesGlobalesCmrz.COSTCONTR3);
        contentValues.put(UtilidadesModuloDiez.COLUMN_COSTCONTR4 ,VariablesGlobalesCmrz.COSTCONTR4);

        contentValues.put(UtilidadesModuloDiez.COLUMN_PRIPROAM ,VariablesGlobalesCmrz.PRIPROAM);
        contentValues.put(UtilidadesModuloDiez.COLUMN_OTRPRAP ,VariablesGlobalesCmrz.OTRPRAP);
        contentValues.put(UtilidadesModuloDiez.COLUMN_PROCOMMI ,VariablesGlobalesCmrz.PROCOMMI);
        contentValues.put(UtilidadesModuloDiez.COLUMN_CANCOMMI ,VariablesGlobalesCmrz.CANCOMMI);

        contentValues.put(UtilidadesModuloDiez.COLUMN_FALPROCM ,VariablesGlobalesCmrz.FALPROCM);
        contentValues.put(UtilidadesModuloDiez.COLUMN_PROPROMI ,VariablesGlobalesCmrz.PROPROMI);
        contentValues.put(UtilidadesModuloDiez.COLUMN_EMPIMTECM ,VariablesGlobalesCmrz.EMPIMTECM);

        long result = db.insert(UtilidadesModuloDiez.TABLA_COMERCIALIZACION_APICOLAGRAL, null, contentValues);
        db.close();
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public boolean addComercializacionApicola() {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        //contentValues.put(UtilidadesModuloDiez.COLUMN_FOLIO,VariablesGlobalesCmrz.FOLIO);
        contentValues.put(UtilidadesModuloDiez.COLUMN_FOLIO,General.Foliocuestion);
        contentValues.put(UtilidadesModuloDiez.COLUMN_IDCAPTURIS, Principal.userId);
        contentValues.put(UtilidadesModuloDiez.COLUMN_COMPROAPI,VariablesGlobalesCmrz.COMPROAPI);
        contentValues.put(UtilidadesModuloDiez.COLUMN_EDTOTROCANPROAPI,VariablesGlobalesCmrz.EDTOTROCANPROAPI);
        contentValues.put(UtilidadesModuloDiez.COLUMN_CANPROAPI,VariablesGlobalesCmrz.CANPROAPI);
        contentValues.put(UtilidadesModuloDiez.COLUMN_PORGENAUT,VariablesGlobalesCmrz.PORGENAUT);
        contentValues.put(UtilidadesModuloDiez.COLUMN_PORDESVEN,VariablesGlobalesCmrz.PORDESVEN);
        contentValues.put(UtilidadesModuloDiez.COLUMN_PREPROAPI,VariablesGlobalesCmrz.PREPROAPI);
        contentValues.put(UtilidadesModuloDiez.COLUMN_MESVENAPI,VariablesGlobalesCmrz.MESVENAPI);
        contentValues.put(UtilidadesModuloDiez.COLUMN_AQUVENAPI,VariablesGlobalesCmrz.AQUVENAPI);

        long result = db.insert(UtilidadesModuloDiez.TABLA_COMERCIALIZACION_APICOLA, null, contentValues);
        db.close();
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public boolean addComercializacionProcesados() {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        //contentValues.put(UtilidadesModuloDiez.COLUMN_FOLIO,VariablesGlobalesCmrz.FOLIO);
        contentValues.put(UtilidadesModuloDiez.COLUMN_FOLIO,General.Foliocuestion);
        contentValues.put(UtilidadesModuloDiez.COLUMN_IDCAPTURIS, Principal.userId);
        contentValues.put(UtilidadesModuloDiez.COLUMN_COMALPRO,VariablesGlobalesCmrz.COMALPRO);
        contentValues.put(UtilidadesModuloDiez.COLUMN_COMALPROO,VariablesGlobalesCmrz.COMALPROO);
        contentValues.put(UtilidadesModuloDiez.COLUMN_CUANPRO,VariablesGlobalesCmrz.CUANPRO);
        contentValues.put(UtilidadesModuloDiez.COLUMN_CUADESAUT,VariablesGlobalesCmrz.CUADESAUT);
        contentValues.put(UtilidadesModuloDiez.COLUMN_CUADESVEN,VariablesGlobalesCmrz.CUADESVEN);
        contentValues.put(UtilidadesModuloDiez.COLUMN_PRECIOAP,VariablesGlobalesCmrz.PRECIOAP);
        contentValues.put(UtilidadesModuloDiez.COLUMN_MESEQVEN,VariablesGlobalesCmrz.MESEQVEN);
        contentValues.put(UtilidadesModuloDiez.COLUMN_AQUIVEN,VariablesGlobalesCmrz.AQUIVEN);


        long result = db.insert(UtilidadesModuloDiez.TABLA_PRODUCTOS_PROCESADOS, null, contentValues);
        db.close();
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }


    public boolean addComercializacionPecuaria() {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        //contentValues.put(UtilidadesModuloDiez.COLUMN_FOLIO,VariablesGlobalesCmrz.FOLIO);
        contentValues.put(UtilidadesModuloDiez.COLUMN_FOLIO,General.Foliocuestion);
        contentValues.put(UtilidadesModuloDiez.COLUMN_IDCAPTURIS,Principal.userId);
        contentValues.put(UtilidadesModuloDiez.COLUMN_COMPROPEC,VariablesGlobalesCmrz.COMPROPEC);
        contentValues.put(UtilidadesModuloDiez.COLUMN_NUMCABVEN,VariablesGlobalesCmrz.NUMCABVEN);
        contentValues.put(UtilidadesModuloDiez.COLUMN_NUMCABAUT,VariablesGlobalesCmrz.NUMCABAUT);
        contentValues.put(UtilidadesModuloDiez.COLUMN_PESO,VariablesGlobalesCmrz.PESO);
        contentValues.put(UtilidadesModuloDiez.COLUMN_PREKG,VariablesGlobalesCmrz.PREKG);
        contentValues.put(UtilidadesModuloDiez.COLUMN_TIPVEN,VariablesGlobalesCmrz.TIPVEN);
        contentValues.put(UtilidadesModuloDiez.COLUMN_LUGSACR,VariablesGlobalesCmrz.LUGSACR);
        contentValues.put(UtilidadesModuloDiez.COLUMN_PRECABZ,VariablesGlobalesCmrz.PRECABZ);
        contentValues.put(UtilidadesModuloDiez.COLUMN_MESVEN,VariablesGlobalesCmrz.MESVEN);
        contentValues.put(UtilidadesModuloDiez.COLUMN_VENGANCON,VariablesGlobalesCmrz.VENGANCON);
        contentValues.put(UtilidadesModuloDiez.COLUMN_VENGANIN,VariablesGlobalesCmrz.VENGANIN);
        contentValues.put(UtilidadesModuloDiez.COLUMN_VENGANGA,VariablesGlobalesCmrz.VENGANGA);
        contentValues.put(UtilidadesModuloDiez.COLUMN_VENGANINPc,VariablesGlobalesCmrz.VENGANINPc);
        contentValues.put(UtilidadesModuloDiez.COLUMN_DESTPRODLO,VariablesGlobalesCmrz.DESTPRODLO);
        contentValues.put(UtilidadesModuloDiez.COLUMN_DESTPRODMU,VariablesGlobalesCmrz.DESTPRODMU);
        contentValues.put(UtilidadesModuloDiez.COLUMN_DESTPRODES,VariablesGlobalesCmrz.DESTPRODES);
        contentValues.put(UtilidadesModuloDiez.COLUMN_DESTPRODNA,VariablesGlobalesCmrz.DESTPRODNA);



        long result = db.insert(UtilidadesModuloDiez.TABLA_COMERCIALIZACION_PECUARIA, null, contentValues);
        db.close();
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }


    public boolean addComercializacionAgricola() {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        //contentValues.put(UtilidadesModuloDiez.COLUMN_FOLIO,VariablesGlobalesCmrz.FOLIO);
        contentValues.put(UtilidadesModuloDiez.COLUMN_FOLIO,General.Foliocuestion);
        contentValues.put(UtilidadesModuloDiez.COLUMN_IDCAPTURIS,Principal.userId);
        contentValues.put(UtilidadesModuloDiez.COLUMN_COMPROAGR,VariablesGlobalesCmrz.COMPROAGR);
        contentValues.put(UtilidadesModuloDiez.COLUMN_RTOCUL,VariablesGlobalesCmrz.RTOCUL);
        contentValues.put(UtilidadesModuloDiez.COLUMN_VOLCUL,VariablesGlobalesCmrz.VOLCUL);
        contentValues.put(UtilidadesModuloDiez.COLUMN_PREMERUPA,VariablesGlobalesCmrz.PREMERUPA);
        contentValues.put(UtilidadesModuloDiez.COLUMN_VOLPROVEN,VariablesGlobalesCmrz.VOLPROVEN);
        contentValues.put(UtilidadesModuloDiez.COLUMN_VOLPROCON,VariablesGlobalesCmrz.VOLPROCON);
        contentValues.put(UtilidadesModuloDiez.COLUMN_VOLPROGAN,VariablesGlobalesCmrz.VOLPROGAN);
        contentValues.put(UtilidadesModuloDiez.COLUMN_DEPROAGRLO,VariablesGlobalesCmrz.DEPROAGRLO);
        contentValues.put(UtilidadesModuloDiez.COLUMN_DEPROAGRMU,VariablesGlobalesCmrz.DEPROAGRMU);
        contentValues.put(UtilidadesModuloDiez.COLUMN_DEPROAGRES,VariablesGlobalesCmrz.DEPROAGRES);
        contentValues.put(UtilidadesModuloDiez.COLUMN_DEPROAGRNA,VariablesGlobalesCmrz.DEPROAGRNA);
        contentValues.put(UtilidadesModuloDiez.COLUMN_TIVEPRAGCO,VariablesGlobalesCmrz.TIVEPRAGCO);
        contentValues.put(UtilidadesModuloDiez.COLUMN_TIVEPRAGIN,VariablesGlobalesCmrz.TIVEPRAGIN);
        contentValues.put(UtilidadesModuloDiez.COLUMN_TIVEPRAGGA,VariablesGlobalesCmrz.TIVEPRAGGA);
        contentValues.put(UtilidadesModuloDiez.COLUMN_TIVEPRAGINAg,VariablesGlobalesCmrz.TIVEPRAGINAg);


        long result = db.insert(UtilidadesModuloDiez.TABLA_COMERCIALIZACION_AGRICOLA, null, contentValues);
        db.close();
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }



    public boolean addComercializacionLechero() {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();


        contentValues.put(UtilidadesModuloDiez.COLUMN_FOLIO,General.Foliocuestion);
        contentValues.put(UtilidadesModuloDiez.COLUMN_IDCAPTURIS,Principal.userId);
        contentValues.put(UtilidadesModuloDiez.COLUMN_LECPECCANT, VariablesGlobalesCmrz.LECPECCANT);
        contentValues.put(UtilidadesModuloDiez.COLUMN_LECPECCONS, VariablesGlobalesCmrz.LECPECCONS);
        contentValues.put(UtilidadesModuloDiez.COLUMN_LECPECPROC, VariablesGlobalesCmrz.LECPECPROC);
        contentValues.put(UtilidadesModuloDiez.COLUMN_LECPECVENT, VariablesGlobalesCmrz.LECPECVENT);
        contentValues.put(UtilidadesModuloDiez.COLUMN_LECPECCOST, VariablesGlobalesCmrz.LECPECCOST);
        contentValues.put(UtilidadesModuloDiez.COLUMN_MESVENLENE, VariablesGlobalesCmrz.MESVENLENE);
        contentValues.put(UtilidadesModuloDiez.COLUMN_VENLEBOLI, VariablesGlobalesCmrz.VENLEBOLI);
        contentValues.put(UtilidadesModuloDiez.COLUMN_VENLEBOIN, VariablesGlobalesCmrz.VENLEBOIN);
        contentValues.put(UtilidadesModuloDiez.COLUMN_VENLEBOQUE, VariablesGlobalesCmrz.VENLEBOQUE);
        contentValues.put(UtilidadesModuloDiez.COLUMN_VENLEBOLIN, VariablesGlobalesCmrz.VENLEBOLIN);
        contentValues.put(UtilidadesModuloDiez.COLUMN_VENLEBOCON, VariablesGlobalesCmrz.VENLEBOCON);
        contentValues.put(UtilidadesModuloDiez.COLUMN_VENLEBOOTR, VariablesGlobalesCmrz.VENLEBOOTR);
        contentValues.put(UtilidadesModuloDiez.COLUMN_VENLEBOOTREDIT, VariablesGlobalesCmrz.VENLEBOOTREDIT);
        contentValues.put(UtilidadesModuloDiez.COLUMN_VENLECAQUE, VariablesGlobalesCmrz.VENLECAQUE);
        contentValues.put(UtilidadesModuloDiez.COLUMN_VENLECAIN, VariablesGlobalesCmrz.VENLECAIN);
        contentValues.put(UtilidadesModuloDiez.COLUMN_VENLECACON, VariablesGlobalesCmrz.VENLECACON);
        contentValues.put(UtilidadesModuloDiez.COLUMN_VENLECAOTR, VariablesGlobalesCmrz.VENLECAOTR);
        contentValues.put(UtilidadesModuloDiez.COLUMN_VENLECAOTREDIT, VariablesGlobalesCmrz.VENLECAOTREDIT);



        long result = db.insert(UtilidadesModuloDiez.TABLA_COMERCIALIZACION_LECHERO, null, contentValues);
        db.close();
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }


    public boolean addComercializacion() {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        //contentValues.put(UtilidadesModuloDiez.COLUMN_FOLIO, VariablesGlobalesCmrz.FOLIO);
        contentValues.put(UtilidadesModuloDiez.COLUMN_FOLIO, General.Foliocuestion);
        contentValues.put(UtilidadesModuloDiez.COLUMN_IDCAPTURIS, Principal.userId);
        contentValues.put(UtilidadesModuloDiez.COLUMN_VENPROAGR, VariablesGlobalesCmrz.VENPROAGR);
        contentValues.put(UtilidadesModuloDiez.COLUMN_COSTFLETE, VariablesGlobalesCmrz.COSTFLETE);
        contentValues.put(UtilidadesModuloDiez.COLUMN_PRPRAGRAL, VariablesGlobalesCmrz.PRPRAGRAL);
        contentValues.put(UtilidadesModuloDiez.COLUMN_PRPRAGRLI, VariablesGlobalesCmrz.PRPRAGRLI);
        contentValues.put(UtilidadesModuloDiez.COLUMN_PRPRAGRRE, VariablesGlobalesCmrz.PRPRAGRRE);
        contentValues.put(UtilidadesModuloDiez.COLUMN_PRPRAGRCON, VariablesGlobalesCmrz.PRPRAGRCON);
        contentValues.put(UtilidadesModuloDiez.COLUMN_PRPRAGRLCO, VariablesGlobalesCmrz.PRPRAGRLCO);
        contentValues.put(UtilidadesModuloDiez.COLUMN_PRPRAGRLEM, VariablesGlobalesCmrz.PRPRAGRLEM);
        contentValues.put(UtilidadesModuloDiez.COLUMN_PRPRAGRLEN, VariablesGlobalesCmrz.PRPRAGRLEN);
        contentValues.put(UtilidadesModuloDiez.COLUMN_PRPRAGRLSE, VariablesGlobalesCmrz.PRPRAGRLSE);
        contentValues.put(UtilidadesModuloDiez.COLUMN_PROVAAGAGAts, VariablesGlobalesCmrz.PROVAAGAGAts);
        contentValues.put(UtilidadesModuloDiez.COLUMN_PROVAAGAGMerm, VariablesGlobalesCmrz.PROVAAGAGMerm);
        contentValues.put(UtilidadesModuloDiez.COLUMN_PROVAAGAGSalv, VariablesGlobalesCmrz.PROVAAGAGSalv);
        contentValues.put(UtilidadesModuloDiez.COLUMN_PROVAAGAGAAfr, VariablesGlobalesCmrz.PROVAAGAGAAfr);
        contentValues.put(UtilidadesModuloDiez.COLUMN_PROVAAGAGHar, VariablesGlobalesCmrz.PROVAAGAGHar);
        contentValues.put(UtilidadesModuloDiez.COLUMN_PROVAAGAGCpr, VariablesGlobalesCmrz.PROVAAGAGCpr);
        contentValues.put(UtilidadesModuloDiez.COLUMN_PROVAAGAGPilon, VariablesGlobalesCmrz.PROVAAGAGPilon);
        contentValues.put(UtilidadesModuloDiez.COLUMN_PROVAAGAGMezc, VariablesGlobalesCmrz.PROVAAGAGMezc);
        contentValues.put(UtilidadesModuloDiez.COLUMN_PROVAAGAGOtr, VariablesGlobalesCmrz.PROVAAGAGOtr);
        contentValues.put(UtilidadesModuloDiez.COLUMN_PROVAAGAGOtrEdt, VariablesGlobalesCmrz.PROVAAGAGOtrEdt);
        contentValues.put(UtilidadesModuloDiez.COLUMN_PROCOMPRAGPB, VariablesGlobalesCmrz.PROCOMPRAGPB);
        contentValues.put(UtilidadesModuloDiez.COLUMN_PROCOMPRAGINT, VariablesGlobalesCmrz.PROCOMPRAGINT);
        contentValues.put(UtilidadesModuloDiez.COLUMN_PROCOMPRAGSCB, VariablesGlobalesCmrz.PROCOMPRAGSCB);
        contentValues.put(UtilidadesModuloDiez.COLUMN_PROCOMPRAGBP, VariablesGlobalesCmrz.PROCOMPRAGBP);
        contentValues.put(UtilidadesModuloDiez.COLUMN_PROCOMPRAGOA, VariablesGlobalesCmrz.PROCOMPRAGOA);
        contentValues.put(UtilidadesModuloDiez.COLUMN_PROCOMPRAGDFC, VariablesGlobalesCmrz.PROCOMPRAGDFC);
        contentValues.put(UtilidadesModuloDiez.COLUMN_PROCOMPRAGPIC, VariablesGlobalesCmrz.PROCOMPRAGPIC);
        contentValues.put(UtilidadesModuloDiez.COLUMN_CACOMPRAG, VariablesGlobalesCmrz.CACOMPRAG);
        contentValues.put(UtilidadesModuloDiez.COLUMN_POCOMPRAGCL, VariablesGlobalesCmrz.POCOMPRAGCL);
        contentValues.put(UtilidadesModuloDiez.COLUMN_POCOMPRAGPRS, VariablesGlobalesCmrz.POCOMPRAGPRS);
        contentValues.put(UtilidadesModuloDiez.COLUMN_POCOMPRAGDF, VariablesGlobalesCmrz.POCOMPRAGDF);
        contentValues.put(UtilidadesModuloDiez.COLUMN_POCOMPRAGVA, VariablesGlobalesCmrz.POCOMPRAGVA);
        contentValues.put(UtilidadesModuloDiez.COLUMN_POCOMPRAGCNV, VariablesGlobalesCmrz.POCOMPRAGCNV);
        contentValues.put(UtilidadesModuloDiez.COLUMN_CMPREPRAG, VariablesGlobalesCmrz.CMPREPRAG);
        contentValues.put(UtilidadesModuloDiez.COLUMN_EMINECPRACNT, VariablesGlobalesCmrz.EMINECPRACNT);
        contentValues.put(UtilidadesModuloDiez.COLUMN_EMINECPRACM, VariablesGlobalesCmrz.EMINECPRACM);
        contentValues.put(UtilidadesModuloDiez.COLUMN_EMINECPRAABI, VariablesGlobalesCmrz.EMINECPRAABI);
        contentValues.put(UtilidadesModuloDiez.COLUMN_EMINECPRAMA, VariablesGlobalesCmrz.EMINECPRAMA);
       /*Campor para la tabla lechero
        contentValues.put(UtilidadesModuloDiez.COLUMN_LECPECCANT, VariablesGlobalesCmrz.LECPECCANT);
        contentValues.put(UtilidadesModuloDiez.COLUMN_LECPECCONS, VariablesGlobalesCmrz.LECPECCONS);
        contentValues.put(UtilidadesModuloDiez.COLUMN_LECPECPROC, VariablesGlobalesCmrz.LECPECPROC);
        contentValues.put(UtilidadesModuloDiez.COLUMN_LECPECVENT, VariablesGlobalesCmrz.LECPECVENT);
        contentValues.put(UtilidadesModuloDiez.COLUMN_LECPECCOST, VariablesGlobalesCmrz.LECPECCOST);
        contentValues.put(UtilidadesModuloDiez.COLUMN_MESVENLENE, VariablesGlobalesCmrz.MESVENLENE);
        contentValues.put(UtilidadesModuloDiez.COLUMN_VENLEBOLI, VariablesGlobalesCmrz.VENLEBOLI);
        contentValues.put(UtilidadesModuloDiez.COLUMN_VENLEBOIN, VariablesGlobalesCmrz.VENLEBOIN);
        contentValues.put(UtilidadesModuloDiez.COLUMN_VENLEBOQUE, VariablesGlobalesCmrz.VENLEBOQUE);
        contentValues.put(UtilidadesModuloDiez.COLUMN_VENLEBOLIN, VariablesGlobalesCmrz.VENLEBOLIN);
        contentValues.put(UtilidadesModuloDiez.COLUMN_VENLEBOCON, VariablesGlobalesCmrz.VENLEBOCON);
        contentValues.put(UtilidadesModuloDiez.COLUMN_VENLEBOOTR, VariablesGlobalesCmrz.VENLEBOOTR);
        contentValues.put(UtilidadesModuloDiez.COLUMN_VENLECAQUE, VariablesGlobalesCmrz.VENLECAQUE);
        contentValues.put(UtilidadesModuloDiez.COLUMN_VENLECAIN, VariablesGlobalesCmrz.VENLECAIN);
        contentValues.put(UtilidadesModuloDiez.COLUMN_VENLECACON, VariablesGlobalesCmrz.VENLECACON);
        contentValues.put(UtilidadesModuloDiez.COLUMN_VENLECAOTR, VariablesGlobalesCmrz.VENLECAOTR);


        */
        contentValues.put(UtilidadesModuloDiez.COLUMN_PROVELE, VariablesGlobalesCmrz.PROVELE);
        contentValues.put(UtilidadesModuloDiez.COLUMN_PROVECA, VariablesGlobalesCmrz.PROVECA);
        contentValues.put(UtilidadesModuloDiez.COLUMN_PROSOCIAL, VariablesGlobalesCmrz.PROSOCIAL);
        contentValues.put(UtilidadesModuloDiez.COLUMN_PROPOLIT, VariablesGlobalesCmrz.PROPOLIT);
        contentValues.put(UtilidadesModuloDiez.COLUMN_PROMERCA, VariablesGlobalesCmrz.PROMERCA);
        contentValues.put(UtilidadesModuloDiez.COLUMN_PRORENACC, VariablesGlobalesCmrz.PRORENACC);
        contentValues.put(UtilidadesModuloDiez.COLUMN_PROVELEEDIT, VariablesGlobalesCmrz.PROVELEEDIT);


        contentValues.put(UtilidadesModuloDiez.COLUMN_COSPROCAL, VariablesGlobalesCmrz.COSPROCAL);
        contentValues.put(UtilidadesModuloDiez.COLUMN_COSPROCLI, VariablesGlobalesCmrz.COSPROCLI);
        contentValues.put(UtilidadesModuloDiez.COLUMN_COSPROCRE, VariablesGlobalesCmrz.COSPROCRE);
        contentValues.put(UtilidadesModuloDiez.COLUMN_COSPROCCO, VariablesGlobalesCmrz.COSPROCCO);
        contentValues.put(UtilidadesModuloDiez.COLUMN_COSPROCCC, VariablesGlobalesCmrz.COSPROCCC);
        contentValues.put(UtilidadesModuloDiez.COLUMN_COSPROCEM, VariablesGlobalesCmrz.COSPROCEM);
        contentValues.put(UtilidadesModuloDiez.COLUMN_COSPROCCU, VariablesGlobalesCmrz.COSPROCCU);
        contentValues.put(UtilidadesModuloDiez.COLUMN_COSPROCSE, VariablesGlobalesCmrz.COSPROCSE);
        contentValues.put(UtilidadesModuloDiez.COLUMN_PROVAAGPEEMB, VariablesGlobalesCmrz.PROVAAGPEEMB);
        contentValues.put(UtilidadesModuloDiez.COLUMN_PROVAAGPECRE, VariablesGlobalesCmrz.PROVAAGPECRE);
        contentValues.put(UtilidadesModuloDiez.COLUMN_PROVAAGPEQUE, VariablesGlobalesCmrz.PROVAAGPEQUE);
        contentValues.put(UtilidadesModuloDiez.COLUMN_PROVAAGPEYOG, VariablesGlobalesCmrz.PROVAAGPEYOG);
        contentValues.put(UtilidadesModuloDiez.COLUMN_PROVAAGPEHAR, VariablesGlobalesCmrz.PROVAAGPEHAR);
        contentValues.put(UtilidadesModuloDiez.COLUMN_PROVAAGPEOTR, VariablesGlobalesCmrz.PROVAAGPEOTR);
        contentValues.put(UtilidadesModuloDiez.COLUMN_PROVAAGPEOTREP, VariablesGlobalesCmrz.PROVAAGPEOTREP);
        contentValues.put(UtilidadesModuloDiez.COLUMN_CACOMPRPE, VariablesGlobalesCmrz.CACOMPRPE);
        contentValues.put(UtilidadesModuloDiez.COLUMN_POCOMPRPECL, VariablesGlobalesCmrz.POCOMPRPECL);
        contentValues.put(UtilidadesModuloDiez.COLUMN_POCOMPRPEPR, VariablesGlobalesCmrz.POCOMPRPEPR);
        contentValues.put(UtilidadesModuloDiez.COLUMN_POCOMPRPEDF, VariablesGlobalesCmrz.POCOMPRPEDF);
        contentValues.put(UtilidadesModuloDiez.COLUMN_POCOMPRPEVA, VariablesGlobalesCmrz.POCOMPRPEVA);
        contentValues.put(UtilidadesModuloDiez.COLUMN_POCOMPRPEPC, VariablesGlobalesCmrz.POCOMPRPEPC);
        contentValues.put(UtilidadesModuloDiez.COLUMN_CMPREPRPE, VariablesGlobalesCmrz.CMPREPRPE);
       // contentValues.put(UtilidadesModuloDiez.COLUMN_EMINECPRP, VariablesGlobalesCmrz.EMINECPRP);
        contentValues.put(UtilidadesModuloDiez.COLUMN_EMINECPRPCC, VariablesGlobalesCmrz.EMINECPRPCC);
        contentValues.put(UtilidadesModuloDiez.COLUMN_EMINECPRPCM, VariablesGlobalesCmrz.EMINECPRPCM);
        contentValues.put(UtilidadesModuloDiez.COLUMN_EMINECPRPAB, VariablesGlobalesCmrz.EMINECPRPAB);
        contentValues.put(UtilidadesModuloDiez.COLUMN_EMINECPRPMF, VariablesGlobalesCmrz.EMINECPRPMF);


        long result = db.insert(UtilidadesModuloDiez.TABLA_COMERCIALIZACION, null, contentValues);
        db.close();
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }






    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

    //++++++++++++++++++++++++++++++++++ ADD AGRICOLA MODULO 4 ++++++++++++++++++++++++++++++++
    public boolean addTiempoRiegoAgri() {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

//        contentValues.put(Utilidades.COLUMN_ID_FOLIO_BRIGADISTA_GEO, foliobrigadistageo);
        contentValues.put(UtilidadesModuloCuatro.COLUMN_FOLIO, General.Foliocuestion);
        contentValues.put(UtilidadesModuloCuatro.COLUMN_IDCAPTURISTA, Principal.userId);
        contentValues.put(UtilidadesModuloCuatro.COLUMN_TIPOCULTIV, "Agricola");
        contentValues.put(UtilidadesModuloCuatro.COLUMN_CICLOPRO, VariablesModuloCuatro.CICLOPRO);

        contentValues.put(UtilidadesModuloCuatro.COLUMN_NUMRIEGR,VariablesModuloCuatro.NUMRIEGR);
        contentValues.put(UtilidadesModuloCuatro.COLUMN_RIECOSGR,VariablesModuloCuatro.RIECOSGR);
        contentValues.put(UtilidadesModuloCuatro.COLUMN_JORGR,VariablesModuloCuatro.JORGR);

        //contentValues.put(UtilidadesModuloCuatro. ,VariablesModuloCuatro. );


        long result = db.insert(UtilidadesModuloCuatro.TABLA_RIEGO, null, contentValues);
        db.close();
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }


    public boolean addGranoAgri() {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

//        contentValues.put(Utilidades.COLUMN_ID_FOLIO_BRIGADISTA_GEO, foliobrigadistageo);
        contentValues.put(UtilidadesModuloCuatro.COLUMN_FOLIO, General.Foliocuestion);
        contentValues.put(UtilidadesModuloCuatro.COLUMN_IDCAPTURISTA, Principal.userId);
        contentValues.put(UtilidadesModuloCuatro.COLUMN_TIPOCULTIV, "Agricola");
        contentValues.put(UtilidadesModuloCuatro.COLUMN_CICLOPRO, VariablesModuloCuatro.CICLOPRO);

        contentValues.put(UtilidadesModuloCuatro.COLUMN_CONGRALM,VariablesModuloCuatro.CONGRALM);
        contentValues.put(UtilidadesModuloCuatro.COLUMN_CONGRALMO,VariablesModuloCuatro.CONGRALMO);
        contentValues.put(UtilidadesModuloCuatro.COLUMN_COSALMGR,VariablesModuloCuatro.COSALMGR);

        //contentValues.put(UtilidadesModuloCuatro. ,VariablesModuloCuatro. );


        long result = db.insert(UtilidadesModuloCuatro.TABLA_GRANOS, null, contentValues);
        db.close();
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }


    public boolean addCosechaAgri() {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

//        contentValues.put(Utilidades.COLUMN_ID_FOLIO_BRIGADISTA_GEO, foliobrigadistageo);
        contentValues.put(UtilidadesModuloCuatro.COLUMN_FOLIO, General.Foliocuestion);
        contentValues.put(UtilidadesModuloCuatro.COLUMN_IDCAPTURISTA, Principal.userId);
        contentValues.put(UtilidadesModuloCuatro.COLUMN_TIPOCULTIV, "Agricola");
        contentValues.put(UtilidadesModuloCuatro.COLUMN_CICLOPRO, VariablesModuloCuatro.CICLOPRO);
        contentValues.put(UtilidadesModuloCuatro.COLUMN_ACTCOSECH ,VariablesModuloCuatro.ACTCOSECH);
        contentValues.put(UtilidadesModuloCuatro.COLUMN_JORCOSGR ,VariablesModuloCuatro.JORCOSGR);

        //contentValues.put(UtilidadesModuloCuatro. ,VariablesModuloCuatro. );


        long result = db.insert(UtilidadesModuloCuatro.TABLA_COSECHA, null, contentValues);
        db.close();
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }


    public boolean addEnfermedades() {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

//        contentValues.put(Utilidades.COLUMN_ID_FOLIO_BRIGADISTA_GEO, foliobrigadistageo);
        contentValues.put(UtilidadesModuloCuatro.COLUMN_FOLIO, General.Foliocuestion);
        contentValues.put(UtilidadesModuloCuatro.COLUMN_IDCAPTURISTA, Principal.userId);
        contentValues.put(UtilidadesModuloCuatro.COLUMN_TIPOCULTIV, "Agricola");
        contentValues.put(UtilidadesModuloCuatro.COLUMN_CICLOPRO, VariablesModuloCuatro.CICLOPRO);
        contentValues.put(UtilidadesModuloCuatro.COLUMN_PLAGA ,VariablesModuloCuatro.PLAGA);
        contentValues.put(UtilidadesModuloCuatro.COLUMN_PLATIPCOT ,VariablesModuloCuatro.PLATIPCOT);
        contentValues.put(UtilidadesModuloCuatro.COLUMN_PLATCOGR ,VariablesModuloCuatro.PLATCOGR);
        contentValues.put(UtilidadesModuloCuatro.COLUMN_PLAPROGR ,VariablesModuloCuatro.PLAPROGR);
        contentValues.put(UtilidadesModuloCuatro.COLUMN_PLACANTGR ,VariablesModuloCuatro.PLACANTGR);
        contentValues.put(UtilidadesModuloCuatro.COLUMN_PEJORGR ,VariablesModuloCuatro.PEJORGR);
        contentValues.put(UtilidadesModuloCuatro.COLUMN_INSPROGR ,VariablesModuloCuatro.INSPROGR);

        //contentValues.put(UtilidadesModuloCuatro. ,VariablesModuloCuatro. );


        long result = db.insert(UtilidadesModuloCuatro.TABLA_ENFERMEDADES, null, contentValues);
        db.close();
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }


    public boolean addMalezaAgri() {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

//        contentValues.put(Utilidades.COLUMN_ID_FOLIO_BRIGADISTA_GEO, foliobrigadistageo);
        contentValues.put(UtilidadesModuloCuatro.COLUMN_FOLIO, General.Foliocuestion);
        contentValues.put(UtilidadesModuloCuatro.COLUMN_IDCAPTURISTA, Principal.userId);
        contentValues.put(UtilidadesModuloCuatro.COLUMN_CICLOPRO, VariablesModuloCuatro.CICLOPRO);
        contentValues.put(UtilidadesModuloCuatro.COLUMN_TIPOCULTIV, "Agricola");

        contentValues.put(UtilidadesModuloCuatro.COLUMN_MALGR ,VariablesModuloCuatro.MALGR);
        contentValues.put(UtilidadesModuloCuatro.COLUMN_CONQMGR ,VariablesModuloCuatro.CONQMGR);
        contentValues.put(UtilidadesModuloCuatro.COLUMN_HERGR ,VariablesModuloCuatro.HERGR);
        contentValues.put(UtilidadesModuloCuatro.COLUMN_HERCANGR ,VariablesModuloCuatro.HERCANGR);
        contentValues.put(UtilidadesModuloCuatro.COLUMN_HJORGR ,VariablesModuloCuatro.HJORGR);
        contentValues.put(UtilidadesModuloCuatro.COLUMN_CHERGR ,VariablesModuloCuatro.CHERGR);

        //contentValues.put(UtilidadesModuloCuatro. ,VariablesModuloCuatro. );


        long result = db.insert(UtilidadesModuloCuatro.TABLA_MALA_HIERBA, null, contentValues);
        db.close();
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public boolean addFertilizanteAgri() {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

//        contentValues.put(Utilidades.COLUMN_ID_FOLIO_BRIGADISTA_GEO, foliobrigadistageo);
        contentValues.put(UtilidadesModuloCuatro.COLUMN_FOLIO, General.Foliocuestion);
        contentValues.put(UtilidadesModuloCuatro.COLUMN_IDCAPTURISTA, Principal.userId);
        contentValues.put(UtilidadesModuloCuatro.COLUMN_CICLOPRO, VariablesModuloCuatro.CICLOPRO);
        contentValues.put(UtilidadesModuloCuatro.COLUMN_TIPOCULTIV, "Agricola");
        contentValues.put(UtilidadesModuloCuatro.COLUMN_FERTGRA ,VariablesModuloCuatro.FERTGRA);
        contentValues.put(UtilidadesModuloCuatro.COLUMN_FERAPPG ,VariablesModuloCuatro.FERAPPG);
        contentValues.put(UtilidadesModuloCuatro.COLUMN_FERCANG ,VariablesModuloCuatro.FERCANG);
        contentValues.put(UtilidadesModuloCuatro.COLUMN_FERCOSG ,VariablesModuloCuatro.FERCOSG);
        contentValues.put(UtilidadesModuloCuatro.COLUMN_FERJORG ,VariablesModuloCuatro.FERJORG);


        //contentValues.put(UtilidadesModuloCuatro. ,VariablesModuloCuatro. );

        long result = db.insert(UtilidadesModuloCuatro.TABLA_FERTILIZANTE_AGRI, null, contentValues);
        db.close();
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }



    public boolean addPreparacionSueloAgri() {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

//        contentValues.put(Utilidades.COLUMN_ID_FOLIO_BRIGADISTA_GEO, foliobrigadistageo);
        contentValues.put(UtilidadesModuloCuatro.COLUMN_FOLIO, General.Foliocuestion);
        contentValues.put(UtilidadesModuloCuatro.COLUMN_IDCAPTURISTA, Principal.userId);
        contentValues.put(UtilidadesModuloCuatro.COLUMN_CICLOPRO, VariablesModuloCuatro.CICLOPRO);
        contentValues.put(UtilidadesModuloCuatro.COLUMN_TIPOCULTIV, "Agricola");
        contentValues.put(UtilidadesModuloCuatro.COLUMN_CICLOPROD ,VariablesModuloCuatro.CICLOPROD);
        contentValues.put(UtilidadesModuloCuatro.COLUMN_LABPRES ,VariablesModuloCuatro.LABPRES);
        contentValues.put(UtilidadesModuloCuatro.COLUMN_NUMVL ,VariablesModuloCuatro.NUMVL);
        contentValues.put(UtilidadesModuloCuatro.COLUMN_EQUIPOL ,VariablesModuloCuatro.EQUIPOL);
        contentValues.put(UtilidadesModuloCuatro.COLUMN_COSTOL ,VariablesModuloCuatro.COSTOL);
        contentValues.put(UtilidadesModuloCuatro.COLUMN_NUMJORL ,VariablesModuloCuatro.NUMJORL);


        //contentValues.put(UtilidadesModuloCuatro. ,VariablesModuloCuatro. );

        long result = db.insert(UtilidadesModuloCuatro.TABLA_PREPARACION_SUELO, null, contentValues);
        db.close();
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }



    public boolean addSemillaCultivo() {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

//        contentValues.put(Utilidades.COLUMN_ID_FOLIO_BRIGADISTA_GEO, foliobrigadistageo);
        contentValues.put(UtilidadesModuloCuatro.COLUMN_FOLIO, General.Foliocuestion);
        contentValues.put(UtilidadesModuloCuatro.COLUMN_IDCAPTURISTA, Principal.userId);
        contentValues.put(UtilidadesModuloCuatro.COLUMN_CICLOPRO, VariablesModuloCuatro.CICLOPRO);
        contentValues.put(UtilidadesModuloCuatro.COLUMN_TIPSEM, VariablesModuloCuatro.TIPSEM);
        contentValues.put(UtilidadesModuloCuatro.COLUMN_SEMCER, VariablesModuloCuatro.SEMCER);
        contentValues.put(UtilidadesModuloCuatro.COLUMN_PRECSEM, VariablesModuloCuatro.PRECSEM);
        contentValues.put(UtilidadesModuloCuatro.COLUMN_CANTSEM, VariablesModuloCuatro.CANTSEM);
        contentValues.put(UtilidadesModuloCuatro.COLUMN_SEPROSEL, VariablesModuloCuatro.SEPROSEL);
        contentValues.put(UtilidadesModuloCuatro.COLUMN_OTRTISELSE, VariablesModuloCuatro.OTRTISELSE);
        contentValues.put(UtilidadesModuloCuatro.COLUMN_METSIEM, VariablesModuloCuatro.METSIEM);
        contentValues.put(UtilidadesModuloCuatro.COLUMN_TRATSEM, VariablesModuloCuatro.TRATSEM);
        contentValues.put(UtilidadesModuloCuatro.COLUMN_SISTLAB, VariablesModuloCuatro.SISTLAB);
        contentValues.put(UtilidadesModuloCuatro.COLUMN_PJOR, VariablesModuloCuatro.PJOR);
        //contentValues.put(UtilidadesModuloCuatro. ,VariablesModuloCuatro. );

        long result = db.insert(UtilidadesModuloCuatro.TABLA_SEMILLA_CULTIVO, null, contentValues);
        db.close();
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public boolean addAgricola(){
        SQLiteDatabase db           = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();


        //contentValues.put(UtilidadesModuloCuatro.COLUMN_ID_FOLIO_BRIGADISTA_GEO, VariablesModuloCuatro.foliobrigadistageo);
        contentValues.put(UtilidadesModuloCuatro.COLUMN_FOLIO, General.Foliocuestion  );
        contentValues.put(UtilidadesModuloCuatro.COLUMN_IDCAPTURISTA, Principal.userId);// IntegerNúmero del capturista
        contentValues.put(UtilidadesModuloCuatro.COLUMN_CICLOPRO, VariablesModuloCuatro.CICLOPRO);
        contentValues.put(UtilidadesModuloCuatro.COLUMN_MAIZ, VariablesModuloCuatro.MAIZ); // Integer¿Qué tipo de maíz es?
        contentValues.put(UtilidadesModuloCuatro.COLUMN_OTROMAIZ, VariablesModuloCuatro.OTROMAIZ); // Integer¿Qué tipo de maíz es?
        contentValues.put(UtilidadesModuloCuatro.COLUMN_MILPA, VariablesModuloCuatro.MILPA); // Integer¿Milpa?
        contentValues.put(UtilidadesModuloCuatro.COLUMN_SORGO, VariablesModuloCuatro.SORGO); // Integer¿Qué tipo de sorgo es?
        contentValues.put(UtilidadesModuloCuatro.COLUMN_FRIJOL, VariablesModuloCuatro.FRIJOL); // Integer¿Qué tipo de frijol es?
        contentValues.put(UtilidadesModuloCuatro.COLUMN_TRIGO, VariablesModuloCuatro.TRIGO); // Integer¿Qué tipo de trigo es?
        contentValues.put(UtilidadesModuloCuatro.COLUMN_AJONJOLI, VariablesModuloCuatro.AJONJOLI); // Integer¿Qué tipo de ajonjolí es?
        contentValues.put(UtilidadesModuloCuatro.COLUMN_CACAHUATE, VariablesModuloCuatro.CACAHUATE); // Integer¿Qué tipo de cacahuate es?
        contentValues.put(UtilidadesModuloCuatro.COLUMN_FECHASIEM, VariablesModuloCuatro.FECHASIEM); // Integer¿Cuál es la fecha de siembra?
        contentValues.put(UtilidadesModuloCuatro.COLUMN_SUPSEM, VariablesModuloCuatro.SUPSEM);// Integer¿Cuánta superficie (ha) sembrada tiene?
        contentValues.put(UtilidadesModuloCuatro.COLUMN_SUPMEC, VariablesModuloCuatro.SUPMEC);// Integer¿Cuánta superficie (ha) mecanizada tiene?
        contentValues.put(UtilidadesModuloCuatro.COLUMN_SUPNOMEC, VariablesModuloCuatro.SUPNOMEC);// Integer¿Cuánta superficie (ha) no mecanizada tiene?
        contentValues.put(UtilidadesModuloCuatro.COLUMN_SUPSINI, VariablesModuloCuatro.SUPSINI);// Integer¿Cuánta superficie (ha) siniestrada tiene?
        contentValues.put(UtilidadesModuloCuatro.COLUMN_CASUPSI, VariablesModuloCuatro.CASUPSI);// Integer¿Cuál fue la causa de la superficie siniestrada?
        contentValues.put(UtilidadesModuloCuatro.COLUMN_ASOC, VariablesModuloCuatro.ASOC); // Integer¿Está asociado con otro cultivo?
        contentValues.put(UtilidadesModuloCuatro.COLUMN_ASOCUL, VariablesModuloCuatro.ASOCUL); // Integer¿Cuál?
        contentValues.put(UtilidadesModuloCuatro.COLUMN_FESIEASO, VariablesModuloCuatro.FESIEASO); // Integer¿Cuál es la fecha de siembra del cultivo asociado?
        contentValues.put(UtilidadesModuloCuatro.COLUMN_ANAFERG, VariablesModuloCuatro.ANAFERG); // Integer¿Realiza algún análisis para fertilizar?
        contentValues.put(UtilidadesModuloCuatro.COLUMN_TIPANAG, VariablesModuloCuatro.TIPANAG); // Integer¿Qué tipo de análisis?
        contentValues.put(UtilidadesModuloCuatro.COLUMN_PANAGR, VariablesModuloCuatro.PANAGR);// IntegerPrecio $
        contentValues.put(UtilidadesModuloCuatro.COLUMN_TIPFERG, VariablesModuloCuatro.TIPFERG); // Integer¿Realiza algún tipo de fertilización?
        contentValues.put(UtilidadesModuloCuatro.COLUMN_RIEGOGR, VariablesModuloCuatro.RIEGOGR); // Integer¿Utiliza algún sistema de riego?
        contentValues.put(UtilidadesModuloCuatro.COLUMN_METDES, VariablesModuloCuatro.METDES); // Integer¿Qué método de desgrane utiliza?
        contentValues.put(UtilidadesModuloCuatro.COLUMN_JORDESM, VariablesModuloCuatro.JORDESM);// IntegerNúmero de jornales
        contentValues.put(UtilidadesModuloCuatro.COLUMN_SERMEN, VariablesModuloCuatro.SERMEN);// IntegerPrecio ($) Servicio/ton
        contentValues.put(UtilidadesModuloCuatro.COLUMN_SUBAPRO, VariablesModuloCuatro.SUBAPRO);// IntegerPrecio ($) Servicio/ton
        contentValues.put(UtilidadesModuloCuatro.COLUMN_SISRIEGR, VariablesModuloCuatro.SISRIEGR);// IntegerPrecio ($) Servicio/ton
        contentValues.put(UtilidadesModuloCuatro.COLUMN_SISHORTPV, VariablesModuloCuatro.SISHORTPV);// IntegerPrecio ($) Servicio/ton
        contentValues.put(UtilidadesModuloCuatro.COLUMN_CANRIEGR, VariablesModuloCuatro.CANRIEGR);// IntegerPrecio ($) Servicio/ton
        contentValues.put(UtilidadesModuloCuatro.COLUMN_FRERIEGR, VariablesModuloCuatro.FRERIEGR);// IntegerPrecio ($) Servicio/ton

        long result = db.insert(UtilidadesModuloCuatro.TABLA_AGRICOLA, null, contentValues);
        db.close();
        if(result == -1) {
            return false;
        }else{
            return true;
        }

    }


    //++++++++++++++++++++++++++++++++++ ADD GEORREFERENCIA ++++++++++++++++++++++++++++++++
    public boolean addGoerreferenciaDos(String foliobrigadistageo, String folioproductorgeo, String longitudgeo, String latitudgeo, String horaActual, String fechaActual, int statusgeo){
        SQLiteDatabase db           = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

//        contentValues.put(Utilidades.COLUMN_ID_FOLIO_BRIGADISTA_GEO, foliobrigadistageo);
//      contentValues.put(Utilidades.COLUMN_ID_FOLIO_BRIGADISTA_GEO, Principal.userId);
        contentValues.put(Utilidades.COLUMN_ID_FOLIO_PRODUCTOR_GEO, General.Foliocuestion);
        contentValues.put(Utilidades.COLUMN_LONGITUD_GEO, longitudgeo);
        contentValues.put(Utilidades.COLUMN_LATITUD_GEO,latitudgeo);
        contentValues.put(Utilidades.COLUMN_HORA_GEO, horaActual);
        contentValues.put(Utilidades.COLUMN_FECHA_GEO, fechaActual);
        contentValues.put(Utilidades.COLUMN_STATUS_GEO, statusgeo);

        long result = db.insert(Utilidades.TABLA_GEORREFERENCIA, null, contentValues);
        db.close();
        if(result == -1) {
            return false;
        }else{
            return true;
        }

    }


    //++++++++++++++++++++++++++++++++++Trayectorias +++++++++++++++++++++++++++++

    public boolean addTrayectoriaS(String folioPro, String folioBrig, String longGpsSave, String latiGpsSave, String horaActl, String fechaActl){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        //contentValues.put(UtilidadesTrayectoria.COLUMN_FOLIO,folioPro);
        contentValues.put(UtilidadesTrayectoria.COLUMN_FOLIO,General.Foliocuestion);
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

    //+++++++++++++++++++++++++++++++++++++++++Unidad 3 de Produccion++++++++++++++++++++++++++++++++++++++++++
    public boolean addAcuicola(){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        //contentValues.put(UtilidadesModuloTres.COLUMN_FOLIO,VariablesGlobalesUpf.FOLIO);
        contentValues.put(UtilidadesModuloTres.COLUMN_FOLIO,General.Foliocuestion);
        contentValues.put(UtilidadesModuloTres.COLUMN_IDCAPTURIS,Principal.userId);
        contentValues.put(UtilidadesModuloTres.COLUMN_ESPECIEPECui,VariablesGlobalesUpf.ESPECIEPECui);
        contentValues.put(UtilidadesModuloTres.COLUMN_OTRACTIAC,VariablesGlobalesUpf.OTRACTIAC);
        contentValues.put(UtilidadesModuloTres.COLUMN_SUPACAC,VariablesGlobalesUpf.SUPACAC);
        contentValues.put(UtilidadesModuloTres.COLUMN_ACUNE,VariablesGlobalesUpf.ACUNE);
        contentValues.put(UtilidadesModuloTres.COLUMN_ACUVT,VariablesGlobalesUpf.ACUVT);

        long result = db.insert(UtilidadesModuloTres.TABLA_PROD_ACUICOLA, null, contentValues);
        db.close();
        if(result == -1) {
            return false;
        }else{
            return true;
        }
    }


    public boolean addFuenteAgua(){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        //contentValues.put(UtilidadesModuloTres.COLUMN_FOLIO,VariablesGlobalesUpf.FOLIO);
        contentValues.put(UtilidadesModuloTres.COLUMN_FOLIO,General.Foliocuestion);
        contentValues.put(UtilidadesModuloTres.COLUMN_IDCAPTURIS,Principal.userId);
        contentValues.put(UtilidadesModuloTres.COLUMN_FDAGUA,VariablesGlobalesUpf.FDAGUA);
        contentValues.put(UtilidadesModuloTres.COLUMN_PAAGUA,VariablesGlobalesUpf.PAAGUA);
        contentValues.put(UtilidadesModuloTres.COLUMN_PAAGUAPA,VariablesGlobalesUpf.PAAGUAPA);
        contentValues.put(UtilidadesModuloTres.COLUMN_PAAGUACO,VariablesGlobalesUpf.PAAGUACO);

        long result = db.insert(UtilidadesModuloTres.TABLA_FUENTE_AGUA, null, contentValues);
        db.close();
        if(result == -1) {
            return false;
        }else{
            return true;
        }
    }

    public boolean addActividadPecuaria() {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(UtilidadesModuloTres.COLUMN_FOLIO,General.Foliocuestion);
        contentValues.put(UtilidadesModuloTres.COLUMN_IDCAPTURIS,Principal.userId);
        contentValues.put(UtilidadesModuloTres.COLUMN_ESPECIEPEC, VariablesGlobalesUpf.ESPECIEPEC); //Bovino, Porcino, Ave, Caprino, Ovino, Abeja, Conejo

        contentValues.put(UtilidadesModuloTres.COLUMN_CABZCOL,VariablesGlobalesUpf.CABZCOL);  //Bovino, Porcino, Ave, Caprino, Ovino, Abeja, Conejo

        contentValues.put(UtilidadesModuloTres.COLUMN_PRODCARNE,VariablesGlobalesUpf.PRODCARNE); //Bovino, Porcino, Ave, Caprino, Ovino, Conejo
        contentValues.put(UtilidadesModuloTres.COLUMN_PRODLECHE,VariablesGlobalesUpf.PRODLECHE); //Bovino, Caprino
        contentValues.put(UtilidadesModuloTres.COLUMN_PRODLECH,VariablesGlobalesUpf.PRODLECH); // Porcino

        contentValues.put(UtilidadesModuloTres.COLUMN_PRODHUEVO,VariablesGlobalesUpf.PRODHUEVO); // Ave
        contentValues.put(UtilidadesModuloTres.COLUMN_PRODLANA,VariablesGlobalesUpf.PRODLANA); // Ovino
        contentValues.put(UtilidadesModuloTres.COLUMN_PRODPIEL,VariablesGlobalesUpf.PRODPIEL); // Conejo
        contentValues.put(UtilidadesModuloTres.COLUMN_PRODPIE,VariablesGlobalesUpf.PRODPIE); //  Bovino,Porcino ,Caprino ,Ovino,Conejo
        contentValues.put(UtilidadesModuloTres.COLUMN_PRODPOLLIT,VariablesGlobalesUpf.PRODPOLLIT); //Ave
        contentValues.put(UtilidadesModuloTres.COLUMN_PRODMIEL,VariablesGlobalesUpf.PRODMIEL); // Abeja
        contentValues.put(UtilidadesModuloTres.COLUMN_PRODREINA,VariablesGlobalesUpf.PRODREINA); //Abeja
        contentValues.put(UtilidadesModuloTres.COLUMN_PRODJALEA,VariablesGlobalesUpf.PRODJALEA); // Abeja
        contentValues.put(UtilidadesModuloTres.COLUMN_PRODCERA,VariablesGlobalesUpf.PRODCERA); // Abeja
        contentValues.put(UtilidadesModuloTres.COLUMN_PRODPOLEN,VariablesGlobalesUpf.PRODPOLEN); // Abeja
        contentValues.put(UtilidadesModuloTres.COLUMN_PRODNUCLEO,VariablesGlobalesUpf.PRODNUCLEO); // Abeja
        contentValues.put(UtilidadesModuloTres.COLUMN_PRODPROP,VariablesGlobalesUpf.PRODPROP); // Abeja


        long result = db.insert(UtilidadesModuloTres.TABLA_PROD_PECUARIA, null, contentValues);
        db.close();
        if(result == -1) {
            return false;
        }else{
            return true;
        }

    }


    public boolean addActividadAgricola() {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(UtilidadesModuloTres.COLUMN_IDUPF,VariablesGlobalesUpf.IDUPF);
        contentValues.put(UtilidadesModuloTres.COLUMN_FOLIO,General.Foliocuestion);
        contentValues.put(UtilidadesModuloTres.COLUMN_IDCAPTURIS,Principal.userId);
        contentValues.put(UtilidadesModuloTres.COLUMN_PRODUAGRI,VariablesGlobalesUpf.PRODUAGRI);
        contentValues.put(UtilidadesModuloTres.COLUMN_PRODSUPERF,VariablesGlobalesUpf.PRODSUPERF);

        long result = db.insert(UtilidadesModuloTres.TABLA_PROD_AGRICOLA, null, contentValues);
        db.close();
        if(result == -1) {
            return false;
        }else{
            return true;
        }

    }

    public boolean addUpf() {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();


        contentValues.put(UtilidadesModuloTres.COLUMN_FOLIO,General.Foliocuestion);	//	String
        contentValues.put(UtilidadesModuloTres.COLUMN_IDCAPTURIS,Principal.userId);	//	int
        contentValues.put(UtilidadesModuloTres.COLUMN_ESTADOUPF,VariablesGlobalesUpf.ESTADOUPF);	//	String
        contentValues.put(UtilidadesModuloTres.COLUMN_CVEEDOUPF,VariablesGlobalesUpf.CVEEDOUPF);	//	int
        contentValues.put(UtilidadesModuloTres.COLUMN_MUNPRUPF,VariablesGlobalesUpf.MUNPRUPF);	//	String
        contentValues.put(UtilidadesModuloTres.COLUMN_CVEMUNUPF,VariablesGlobalesUpf.CVEMUNUPF);	//	int
        contentValues.put(UtilidadesModuloTres.COLUMN_LOCPRUPF,VariablesGlobalesUpf.LOCPRUPF);	//	String
        contentValues.put(UtilidadesModuloTres.COLUMN_NOMUPF,VariablesGlobalesUpf.NOMUPF);	//	String
        contentValues.put(UtilidadesModuloTres.COLUMN_SUPUPF,VariablesGlobalesUpf.SUPUPF);	//	int
        contentValues.put(UtilidadesModuloTres.COLUMN_PRODFORM,VariablesGlobalesUpf.PRODFORM);	//	int
        contentValues.put(UtilidadesModuloTres.COLUMN_PRODFORNM,VariablesGlobalesUpf.PRODFORNM);	//	int
        contentValues.put(UtilidadesModuloTres.COLUMN_PRODFORPM,VariablesGlobalesUpf.PRODFORPM);	//	int
        contentValues.put(UtilidadesModuloTres.COLUMN_PRODFOROT,VariablesGlobalesUpf.PRODFOROT);	//	int
        contentValues.put(UtilidadesModuloTres.COLUMN_PRODFOROTACT,VariablesGlobalesUpf.PRODFOROTACT);	//	int otra actividad forestal
        contentValues.put(UtilidadesModuloTres.COLUMN_PCOMID,VariablesGlobalesUpf.PCOMID);	//	String
        contentValues.put(UtilidadesModuloTres.COLUMN_PSINCOMID,VariablesGlobalesUpf.PSINCOMID);	//	String
        contentValues.put(UtilidadesModuloTres.COLUMN_ALISAVA,VariablesGlobalesUpf.ALISAVA);	//	String
        contentValues.put(UtilidadesModuloTres.COLUMN_ALITOR,VariablesGlobalesUpf.ALITOR);	//	int
        contentValues.put(UtilidadesModuloTres.COLUMN_ALIPAP,VariablesGlobalesUpf.ALIPAP);	//	int
        contentValues.put(UtilidadesModuloTres.COLUMN_ALIVER,VariablesGlobalesUpf.ALIVER);	//	int
        contentValues.put(UtilidadesModuloTres.COLUMN_ALIFRU,VariablesGlobalesUpf.ALIFRU);	//	int
        contentValues.put(UtilidadesModuloTres.COLUMN_ALICAR,VariablesGlobalesUpf.ALICAR);	//	int
        contentValues.put(UtilidadesModuloTres.COLUMN_ALIHUE,VariablesGlobalesUpf.ALIHUE);	//	int
        contentValues.put(UtilidadesModuloTres.COLUMN_ALIPES,VariablesGlobalesUpf.ALIPES);	//	int
        contentValues.put(UtilidadesModuloTres.COLUMN_ALIFLH,VariablesGlobalesUpf.ALIFLH);	//	int
        contentValues.put(UtilidadesModuloTres.COLUMN_ALIQUE,VariablesGlobalesUpf.ALIQUE);	//	int
        contentValues.put(UtilidadesModuloTres.COLUMN_ALIACE,VariablesGlobalesUpf.ALIACE);	//	int
        contentValues.put(UtilidadesModuloTres.COLUMN_ALIAZU,VariablesGlobalesUpf.ALIAZU);	//	int
        contentValues.put(UtilidadesModuloTres.COLUMN_ALICON,VariablesGlobalesUpf.ALICON);	//	int

        contentValues.put(UtilidadesModuloTres.COLUMN_ALICOMPFrutas,VariablesGlobalesUpf.ALICOMPFrutas);	//	Text add bd
        contentValues.put(UtilidadesModuloTres.COLUMN_ALICOMPHortalizas,VariablesGlobalesUpf.ALICOMPHortalizas);	//	Text add bd
        contentValues.put(UtilidadesModuloTres.COLUMN_ALICOMPGranos,VariablesGlobalesUpf.ALICOMPGranos);	//	Text add bd
        contentValues.put(UtilidadesModuloTres.COLUMN_ALICOMPCarne,VariablesGlobalesUpf.ALICOMPCarne);	//	Text add bd
        contentValues.put(UtilidadesModuloTres.COLUMN_ALICOMPLeche,VariablesGlobalesUpf.ALICOMPLeche);	//	Text add bd


        contentValues.put(UtilidadesModuloTres.COLUMN_ALICOMPNEC,VariablesGlobalesUpf.ALICOMPNEC);	//	String

        contentValues.put(UtilidadesModuloTres.COLUMN_DOCOMPDirectoPro ,VariablesGlobalesUpf.DOCOMPDirectoPro);	//	Text add bd
        contentValues.put(UtilidadesModuloTres.COLUMN_DOCOMPMercLocal,VariablesGlobalesUpf.DOCOMPMercLocal);	//	Text add bd
        contentValues.put(UtilidadesModuloTres.COLUMN_DOCOMPMercMun,VariablesGlobalesUpf.DOCOMPMercMun);	//	Text add bd
        contentValues.put(UtilidadesModuloTres.COLUMN_DOCOMPInds,VariablesGlobalesUpf.DOCOMPInds);	//	Text add bd


        contentValues.put(UtilidadesModuloTres.COLUMN_TENTIE,VariablesGlobalesUpf.TENTIE);	//	String
        contentValues.put(UtilidadesModuloTres.COLUMN_TENTIEOT,VariablesGlobalesUpf.TENTIEOT);	//	String
        contentValues.put(UtilidadesModuloTres.COLUMN_TIPPROP,VariablesGlobalesUpf.TIPPROP);	//	String
        contentValues.put(UtilidadesModuloTres.COLUMN_PENDPAR,VariablesGlobalesUpf.PENDPAR);	//	String
        contentValues.put(UtilidadesModuloTres.COLUMN_ASESORIA,VariablesGlobalesUpf.ASESORIA);	//	String
        contentValues.put(UtilidadesModuloTres.COLUMN_ASESORIAO,VariablesGlobalesUpf.ASESORIAO);	//	String
        contentValues.put(UtilidadesModuloTres.COLUMN_DINACTPRO,VariablesGlobalesUpf.DINACTPRO);	//	String
        contentValues.put(UtilidadesModuloTres.COLUMN_ASISTEC,VariablesGlobalesUpf.ASISTEC);	//	int

        contentValues.put(UtilidadesModuloTres.COLUMN_ASISTECDO,VariablesGlobalesUpf.ASISTECDO);	//	String
        contentValues.put(UtilidadesModuloTres.COLUMN_ASISTECDOtro,VariablesGlobalesUpf.ASISTECDOtro);	//	String


        contentValues.put(UtilidadesModuloTres.COLUMN_DIFMAQ,VariablesGlobalesUpf.DIFMAQ);	//	String
        contentValues.put(UtilidadesModuloTres.COLUMN_SACTAGRIRI,VariablesGlobalesUpf.SACTAGRIRI);	//	int
        contentValues.put(UtilidadesModuloTres.COLUMN_SACTPECRI,VariablesGlobalesUpf.SACTPECRI);	//	int
        contentValues.put(UtilidadesModuloTres.COLUMN_SACTAGRITE,VariablesGlobalesUpf.SACTAGRITE);	//	int
        contentValues.put(UtilidadesModuloTres.COLUMN_SACTPECTE,VariablesGlobalesUpf.SACTPECTE);	//	int
        contentValues.put(UtilidadesModuloTres.COLUMN_SUPPAS,VariablesGlobalesUpf.SUPPAS);	//	String

        long result = db.insert(UtilidadesModuloTres.TABLA_UPF, null, contentValues);
        db.close();
        if(result == -1) {
            return false;
        }else{
            return true;
        }
    }


    //++++++++++++++++++++++++++++++++++++++++ Unidad 5 Caracterizacion de Hortalizas ++++++++++++++++++++++++++
    public  boolean addEmpaque(String s, String cstEmpaque, String valorTemp){
        SQLiteDatabase db           = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        //contentValues.put(UtilidadesModuloCinco.COLUMN_FOLIO, VariblesGlobalesHortalizas.FOLIO);
        contentValues.put(UtilidadesModuloCinco.COLUMN_FOLIO, General.Foliocuestion);
        contentValues.put(UtilidadesModuloCinco.COLUMN_IDCAPTURISTA, Principal.userId);
        contentValues.put(UtilidadesModuloCinco.COLUMN_CICPRO,VariblesGlobalesHortalizas.CICPRO);
        contentValues.put(UtilidadesModuloCinco.COLUMN_TIPOCULTIV, VariblesGlobalesHortalizas.TIPOCULTIV);
        contentValues.put(UtilidadesModuloCinco.COLUMN_EMPHOR, s);	//	Text
        contentValues.put(UtilidadesModuloCinco.COLUMN_EMPHORO, valorTemp);	//	Text
        contentValues.put(UtilidadesModuloCinco.COLUMN_COUNIHPV,cstEmpaque);	//	Text



        long result = db.insert(UtilidadesModuloCinco.TABLA_EMPAQUE, null, contentValues);
        db.close();
        if(result == -1) {
            return false;
        }else{
            return true;
        }
    }

    public  boolean addCosecha(){
        SQLiteDatabase db           = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        //contentValues.put(UtilidadesModuloCinco.COLUMN_FOLIO, VariblesGlobalesHortalizas.FOLIO);
        contentValues.put(UtilidadesModuloCinco.COLUMN_FOLIO, General.Foliocuestion);
        contentValues.put(UtilidadesModuloCinco.COLUMN_IDCAPTURISTA, Principal.userId);
        contentValues.put(UtilidadesModuloCinco.COLUMN_CICPRO,VariblesGlobalesHortalizas.CICPRO);
        contentValues.put(UtilidadesModuloCinco.COLUMN_TIPOCULTIV, VariblesGlobalesHortalizas.TIPOCULTIV);
        contentValues.put(UtilidadesModuloCinco.COLUMN_ACTCOSECH, VariblesGlobalesHortalizas.ACTCOSECH);	//	Text
        contentValues.put(UtilidadesModuloCinco.COLUMN_JORCOSGR, VariblesGlobalesHortalizas.JORCOSGR);	//	Text



        long result = db.insert(UtilidadesModuloCinco.TABLA_COSECHA, null, contentValues);
        db.close();
        if(result == -1) {
            return false;
        }else{
            return true;
        }
    }


    public  boolean addControlPlagas(){
        SQLiteDatabase db           = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        //contentValues.put(UtilidadesModuloCinco.COLUMN_FOLIO, VariblesGlobalesHortalizas.FOLIO);
        contentValues.put(UtilidadesModuloCinco.COLUMN_FOLIO, General.Foliocuestion);
        contentValues.put(UtilidadesModuloCinco.COLUMN_IDCAPTURISTA, Principal.userId);
        contentValues.put(UtilidadesModuloCinco.COLUMN_CICPRO,VariblesGlobalesHortalizas.CICPRO);
        contentValues.put(UtilidadesModuloCinco.COLUMN_TIPOCULTIV, VariblesGlobalesHortalizas.TIPOCULTIV);
        contentValues.put(UtilidadesModuloCinco.COLUMN_PLAGA, VariblesGlobalesHortalizas.PLAGA);	//	Text
        contentValues.put(UtilidadesModuloCinco.COLUMN_PLATIPCOT, VariblesGlobalesHortalizas.PLATIPCOT);	//	Text
        contentValues.put(UtilidadesModuloCinco.COLUMN_PLATCOGR, VariblesGlobalesHortalizas.PLATCOGR);	//	Text
        contentValues.put(UtilidadesModuloCinco.COLUMN_PLAPROGR, VariblesGlobalesHortalizas.PLAPROGR);	//	Text
        contentValues.put(UtilidadesModuloCinco.COLUMN_PLACANTGR, VariblesGlobalesHortalizas.PLACANTGR);	//	Text
        contentValues.put(UtilidadesModuloCinco.COLUMN_SUPHOR, VariblesGlobalesHortalizas.SUPHOR);	//	Text
        contentValues.put(UtilidadesModuloCinco.COLUMN_PEJORGR, VariblesGlobalesHortalizas.PEJORGR);	//	Text
        contentValues.put(UtilidadesModuloCinco.COLUMN_INSPROGR, VariblesGlobalesHortalizas.INSPROGR);	//	Text


        long result = db.insert(UtilidadesModuloCinco.TABLA_PLAGASENFER, null, contentValues);
        db.close();
        if(result == -1) {
            return false;
        }else{
            return true;
        }
    }


    public  boolean addControlMaleza(){
        SQLiteDatabase db           = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        //contentValues.put(UtilidadesModuloCinco.COLUMN_FOLIO, VariblesGlobalesHortalizas.FOLIO);
        contentValues.put(UtilidadesModuloCinco.COLUMN_FOLIO, General.Foliocuestion);
        contentValues.put(UtilidadesModuloCinco.COLUMN_IDCAPTURISTA, Principal.userId);
        contentValues.put(UtilidadesModuloCinco.COLUMN_CICPRO,VariblesGlobalesHortalizas.CICPRO);
        contentValues.put(UtilidadesModuloCinco.COLUMN_TIPOCULTIV, VariblesGlobalesHortalizas.TIPOCULTIV);
        contentValues.put(UtilidadesModuloCinco.COLUMN_MALGR, VariblesGlobalesHortalizas.MALGR);	//	Text
        contentValues.put(UtilidadesModuloCinco.COLUMN_CONQMGR, VariblesGlobalesHortalizas.CONQMGR);	//	Text
        contentValues.put(UtilidadesModuloCinco.COLUMN_HERGR, VariblesGlobalesHortalizas.HERGR);	//	Text
        contentValues.put(UtilidadesModuloCinco.COLUMN_HERCANGR, VariblesGlobalesHortalizas.HERCANGR);	//	Text
        contentValues.put(UtilidadesModuloCinco.COLUMN_HJORGR, VariblesGlobalesHortalizas.HJORGR);	//	Text
        contentValues.put(UtilidadesModuloCinco.COLUMN_CHERGR, VariblesGlobalesHortalizas.CHERGR);	//	Text


        long result = db.insert(UtilidadesModuloCinco.TABLA_MALAHIERBA, null, contentValues);
        db.close();
        if(result == -1) {
            return false;
        }else{
            return true;
        }
    }


    public  boolean addTiempoRiego(){
        SQLiteDatabase db           = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        //contentValues.put(UtilidadesModuloCinco.COLUMN_FOLIO, VariblesGlobalesHortalizas.FOLIO);
        contentValues.put(UtilidadesModuloCinco.COLUMN_FOLIO, General.Foliocuestion);
        contentValues.put(UtilidadesModuloCinco.COLUMN_IDCAPTURISTA, Principal.userId);
        contentValues.put(UtilidadesModuloCinco.COLUMN_CICPRO,VariblesGlobalesHortalizas.CICPRO);
        contentValues.put(UtilidadesModuloCinco.COLUMN_TIPOCULTIV, VariblesGlobalesHortalizas.TIPOCULTIV);
        contentValues.put(UtilidadesModuloCinco.COLUMN_NUMRIEGR, VariblesGlobalesHortalizas.NUMRIEGR);	//	Text
        contentValues.put(UtilidadesModuloCinco.COLUMN_RIECOSGR, VariblesGlobalesHortalizas.RIECOSGR);	//	Text
        contentValues.put(UtilidadesModuloCinco.COLUMN_JORGR, VariblesGlobalesHortalizas.JORGR);	//	Text


        long result = db.insert(UtilidadesModuloCinco.TABLA_RIEGO, null, contentValues);
        db.close();
        if(result == -1) {
            return false;
        }else{
            return true;
        }
    }


    public  boolean addFertilizante(){
        SQLiteDatabase db           = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        //contentValues.put(UtilidadesModuloCinco.COLUMN_FOLIO, VariblesGlobalesHortalizas.FOLIO);
        contentValues.put(UtilidadesModuloCinco.COLUMN_FOLIO, General.Foliocuestion);
        contentValues.put(UtilidadesModuloCinco.COLUMN_IDCAPTURISTA, Principal.userId);
        contentValues.put(UtilidadesModuloCinco.COLUMN_CICPRO,VariblesGlobalesHortalizas.CICPRO);
        contentValues.put(UtilidadesModuloCinco.COLUMN_TIPOCULTIV, VariblesGlobalesHortalizas.TIPOCULTIV);
        contentValues.put(UtilidadesModuloCinco.COLUMN_FERTGRA, VariblesGlobalesHortalizas.FERTGRA);	//	Text
        contentValues.put(UtilidadesModuloCinco.COLUMN_EFFRUT, VariblesGlobalesHortalizas.EFFRUT);	//	Text
        contentValues.put(UtilidadesModuloCinco.COLUMN_FERAPPG, VariblesGlobalesHortalizas.FERAPPG);	//	Text
        contentValues.put(UtilidadesModuloCinco.COLUMN_FERCANG, VariblesGlobalesHortalizas.FERCANG);	//	Integer
        contentValues.put(UtilidadesModuloCinco.COLUMN_FERCOSG, VariblesGlobalesHortalizas.FERCOSG);	//	Integer
        contentValues.put(UtilidadesModuloCinco.COLUMN_FERJORG, VariblesGlobalesHortalizas.FERJORG);	//	Integer
        contentValues.put(UtilidadesModuloCinco.COLUMN_METHORT, VariblesGlobalesHortalizas.METHORT);	//	Text
        //contentValues.put(UtilidadesModuloCinco.COLUMN_METHORTA,VariblesGlobalesHortalizas.METHORTA);	//	Text

        long result = db.insert(UtilidadesModuloCinco.TABLA_FERTILIZANTE, null, contentValues);
        db.close();
        if(result == -1) {
            return false;
        }else{
            return true;
        }
    }

    public  boolean addPreparacionSuelo(){
        SQLiteDatabase db           = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        //contentValues.put(UtilidadesModuloCinco.COLUMN_FOLIO, VariblesGlobalesHortalizas.FOLIO);
        contentValues.put(UtilidadesModuloCinco.COLUMN_FOLIO, General.Foliocuestion);
        contentValues.put(UtilidadesModuloCinco.COLUMN_IDCAPTURISTA, Principal.userId);
        contentValues.put(UtilidadesModuloCinco.COLUMN_TIPOCULTIV, VariblesGlobalesHortalizas.TIPOCULTIV);
        contentValues.put(UtilidadesModuloCinco.COLUMN_CICLOPROD, VariblesGlobalesHortalizas.CICLOPROD );
        contentValues.put(UtilidadesModuloCinco.COLUMN_LABPRES,VariblesGlobalesHortalizas.LABPRES );
        contentValues.put(UtilidadesModuloCinco.COLUMN_NUMVL, VariblesGlobalesHortalizas.NUMVL );
        contentValues.put(UtilidadesModuloCinco.COLUMN_EQUIPOL, VariblesGlobalesHortalizas.EQUIPOL );
        contentValues.put(UtilidadesModuloCinco.COLUMN_COSTOL, VariblesGlobalesHortalizas.COSTOL);
        contentValues.put(UtilidadesModuloCinco.COLUMN_NUMJORL,VariblesGlobalesHortalizas.NUMJORL );

        long result = db.insert(UtilidadesModuloCinco.TABLA_PREPARACIONSUELO, null, contentValues);
        db.close();
        if(result == -1) {
            return false;
        }else{
            return true;
        }
    }


    public boolean addHortalizas(){
        SQLiteDatabase db           = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(UtilidadesModuloCinco.COLUMN_FOLIO, General.Foliocuestion);
        contentValues.put(UtilidadesModuloCinco.COLUMN_IDCAPTURISTA, Principal.userId);

        contentValues.put(UtilidadesModuloCinco.COLUMN_CICPRO,VariblesGlobalesHortalizas.CICPRO);
        contentValues.put(UtilidadesModuloCinco.COLUMN_CUCHORT,VariblesGlobalesHortalizas.CUCHORT);
        contentValues.put(UtilidadesModuloCinco.COLUMN_CUCHORTO,VariblesGlobalesHortalizas.CUCHORTO);
        contentValues.put(UtilidadesModuloCinco.COLUMN_MOTSEMH,VariblesGlobalesHortalizas.MOTSEMH);
        contentValues.put(UtilidadesModuloCinco.COLUMN_MOTSEMHO,VariblesGlobalesHortalizas.MOTSEMHO);
        contentValues.put(UtilidadesModuloCinco.COLUMN_ASOCULT,VariblesGlobalesHortalizas.ASOCULT);
        contentValues.put(UtilidadesModuloCinco.COLUMN_OTRCULT,VariblesGlobalesHortalizas.OTRCULT);
        contentValues.put(UtilidadesModuloCinco.COLUMN_ASECULT,VariblesGlobalesHortalizas.ASECULT);
        contentValues.put(UtilidadesModuloCinco.COLUMN_CUCULT,VariblesGlobalesHortalizas.CUCULT);
        contentValues.put(UtilidadesModuloCinco.COLUMN_FECHOR,VariblesGlobalesHortalizas.FECHOR);
        contentValues.put(UtilidadesModuloCinco.COLUMN_SUPSEMHOstr,VariblesGlobalesHortalizas.SUPSEMHOstr); //falta agregar a la base de datos
        contentValues.put(UtilidadesModuloCinco.COLUMN_SUPSEMHO,VariblesGlobalesHortalizas.SUPSEMHO);
        contentValues.put(UtilidadesModuloCinco.COLUMN_SUPMECOIHOstr,VariblesGlobalesHortalizas.SUPMECOIHOstr); //falta agregar a la base de datos
        contentValues.put(UtilidadesModuloCinco.COLUMN_SUPMECOIHO,VariblesGlobalesHortalizas.SUPMECOIHO);
        contentValues.put(UtilidadesModuloCinco.COLUMN_SUPNMECHOstr,VariblesGlobalesHortalizas.SUPNMECHOstr); //falta agregar a la base de datos
        contentValues.put(UtilidadesModuloCinco.COLUMN_SUPNMECHO,VariblesGlobalesHortalizas.SUPNMECHO);
        contentValues.put(UtilidadesModuloCinco.COLUMN_INFRHORT,VariblesGlobalesHortalizas.INFRHORT);
        contentValues.put(UtilidadesModuloCinco.COLUMN_INFRHORTA,VariblesGlobalesHortalizas.INFRHORTA);
        contentValues.put(UtilidadesModuloCinco.COLUMN_SINIHOR,VariblesGlobalesHortalizas.SINIHOR);
        contentValues.put(UtilidadesModuloCinco.COLUMN_CAUSINIH,VariblesGlobalesHortalizas.CAUSINIH);
        contentValues.put(UtilidadesModuloCinco.COLUMN_TIPSEMPRO,VariblesGlobalesHortalizas.TIPSEMPRO);
        contentValues.put(UtilidadesModuloCinco.COLUMN_PREKGPRO,VariblesGlobalesHortalizas.PREKGPRO);
        contentValues.put(UtilidadesModuloCinco.COLUMN_CANTSEPRO,VariblesGlobalesHortalizas.CANTSEPRO);
        contentValues.put(UtilidadesModuloCinco.COLUMN_TIPSEMCROT,VariblesGlobalesHortalizas.TIPSEMCROT);
        contentValues.put(UtilidadesModuloCinco.COLUMN_PREKGCROT,VariblesGlobalesHortalizas.PREKGCROT);
        contentValues.put(UtilidadesModuloCinco.COLUMN_CANTSECROT,VariblesGlobalesHortalizas.CANTSECROT);
        contentValues.put(UtilidadesModuloCinco.COLUMN_TIPSEMCER,VariblesGlobalesHortalizas.TIPSEMCER);
        contentValues.put(UtilidadesModuloCinco.COLUMN_SEMCERNOM,VariblesGlobalesHortalizas.SEMCERNOM);
        contentValues.put(UtilidadesModuloCinco.COLUMN_PREKGCER,VariblesGlobalesHortalizas.PREKGCER);
        contentValues.put(UtilidadesModuloCinco.COLUMN_CANTSECER,VariblesGlobalesHortalizas.CANTSECER);
        contentValues.put(UtilidadesModuloCinco.COLUMN_VARSEHOOI,VariblesGlobalesHortalizas.VARSEHOOI);
        contentValues.put(UtilidadesModuloCinco.COLUMN_SELSEOI,VariblesGlobalesHortalizas.SELSEOI);
        contentValues.put(UtilidadesModuloCinco.COLUMN_DENSOI,VariblesGlobalesHortalizas.DENSOI);
        contentValues.put(UtilidadesModuloCinco.COLUMN_SIEMOI,VariblesGlobalesHortalizas.SIEMOI);
        contentValues.put(UtilidadesModuloCinco.COLUMN_SIEMOOI,VariblesGlobalesHortalizas.SIEMOOI);
        contentValues.put(UtilidadesModuloCinco.COLUMN_PREJOROI,VariblesGlobalesHortalizas.PREJOROI);
        contentValues.put(UtilidadesModuloCinco.COLUMN_ANAFERHO,VariblesGlobalesHortalizas.ANAFERHO);
        contentValues.put(UtilidadesModuloCinco.COLUMN_SUELHO,VariblesGlobalesHortalizas.SUELHO);
        contentValues.put(UtilidadesModuloCinco.COLUMN_PRESUELHO,VariblesGlobalesHortalizas.PRESUELHO);
        contentValues.put(UtilidadesModuloCinco.COLUMN_FOLHO,VariblesGlobalesHortalizas.FOLHO);
        contentValues.put(UtilidadesModuloCinco.COLUMN_PREFOLHO,VariblesGlobalesHortalizas.PREFOLHO);
        contentValues.put(UtilidadesModuloCinco.COLUMN_AGUAHO,VariblesGlobalesHortalizas.AGUAHO);
        contentValues.put(UtilidadesModuloCinco.COLUMN_PREAGUAHO,VariblesGlobalesHortalizas.PREAGUAHO);
        contentValues.put(UtilidadesModuloCinco.COLUMN_TIPFERHOR,VariblesGlobalesHortalizas.TIPFERHOR);
        contentValues.put(UtilidadesModuloCinco.COLUMN_APPFOLH,VariblesGlobalesHortalizas.APPFOLH);
        contentValues.put(UtilidadesModuloCinco.COLUMN_APPFOLHPV,VariblesGlobalesHortalizas.APPFOLHPV);
        contentValues.put(UtilidadesModuloCinco.COLUMN_RIEHORT,VariblesGlobalesHortalizas.RIEHORT);
        contentValues.put(UtilidadesModuloCinco.COLUMN_SISRIEGR,VariblesGlobalesHortalizas.SISRIEGR);
        contentValues.put(UtilidadesModuloCinco.COLUMN_SISHORTPV,VariblesGlobalesHortalizas.SISHORTPV);
        contentValues.put(UtilidadesModuloCinco.COLUMN_FRERIEGR,VariblesGlobalesHortalizas.FRERIEGR);
        contentValues.put(UtilidadesModuloCinco.COLUMN_PLAENHPV,VariblesGlobalesHortalizas.PLAENHPV);
        contentValues.put(UtilidadesModuloCinco.COLUMN_PLAGNUEVA,VariblesGlobalesHortalizas.PLAGNUEVA);
        contentValues.put(UtilidadesModuloCinco.COLUMN_UMPQUIPV, VariblesGlobalesHortalizas.UMPQUIPV);
        contentValues.put(UtilidadesModuloCinco.COLUMN_NIVCSH,VariblesGlobalesHortalizas.NIVCSH);
        contentValues.put(UtilidadesModuloCinco.COLUMN_ORPLENPV,VariblesGlobalesHortalizas.ORPLENPV);
        contentValues.put(UtilidadesModuloCinco.COLUMN_ORPLAOTRO,VariblesGlobalesHortalizas.ORPLAOTRO);
        contentValues.put(UtilidadesModuloCinco.COLUMN_CBIOMPE,VariblesGlobalesHortalizas.CBIOMPE);
        contentValues.put(UtilidadesModuloCinco.COLUMN_INOHOR,VariblesGlobalesHortalizas.INOHOR);
        contentValues.put(UtilidadesModuloCinco.COLUMN_INOHORTIP,VariblesGlobalesHortalizas.INOHORTIP);
        contentValues.put(UtilidadesModuloCinco.COLUMN_NUMCHO,VariblesGlobalesHortalizas.NUMCHO);
        contentValues.put(UtilidadesModuloCinco.COLUMN_MPHORT,VariblesGlobalesHortalizas.MPHORT);
        contentValues.put(UtilidadesModuloCinco.COLUMN_MPHORTOTRO,VariblesGlobalesHortalizas.MPHORTOTRO);

        long result = db.insert(UtilidadesModuloCinco.TABLA_HORTALIZAS, null, contentValues);
        db.close();
        if(result == -1) {
            return false;
        }else{
            return true;
        }

    }





    /////////////////////////////////////////////////////////////////////////////7
    //Metodo para guardar identificacion del cuestionario
    public boolean addCuestionario(){

        SQLiteDatabase db           = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(UtilidadesProductor.COLUMN_FOLIO_ENCUESTA, General.Foliocuestion);
        contentValues.put(UtilidadesProductor.COLUMN_FECHA_ENCUESTA, General.fechaenc);
        contentValues.put(UtilidadesProductor.COLUMN_HORA_ENCUESTA, General.horaenc);
        contentValues.put(UtilidadesProductor.COLUMN_PROYECTO, General.Proyecto);
        contentValues.put(UtilidadesProductor.COLUMN_ESTATUS, General.statusenc);
        contentValues.put(UtilidadesProductor.COLUMN_MOD_USO, General.mod_uso);
        contentValues.put(UtilidadesProductor.COLUMN_COBERTURA, General.Cobertura);
        contentValues.put(UtilidadesProductor.COLUMN_MODALIDAD, General.Modalidad);
        contentValues.put(UtilidadesProductor.COLUMN_CULTIVO_ESTI, General.cultivo_esti);
        contentValues.put(UtilidadesProductor.COLUMN_MODALIDAD_ESTI, General.modalidad_esti);
        contentValues.put(UtilidadesProductor.COLUMN_ALTURA_ESTI, General.altura_esti);
        contentValues.put(UtilidadesProductor.COLUMN_SINIESTRO_ESTI, General.siniestro_esti);
        contentValues.put(UtilidadesProductor.COLUMN_FENO_ESTI, General.feno_esti);
        contentValues.put(UtilidadesProductor.COLUMN_SUELO_ESTI, General.suelo_esti);
        contentValues.put(UtilidadesProductor.COLUMN_PREDIO_ESTI, General.predio_esti);
        contentValues.put(UtilidadesProductor.COLUMN_VARIEDAD_ESTI, General.variedad_esti);
        contentValues.put(UtilidadesProductor.COLUMN_MALEZA_ESTI, General.maleza_esti);
        contentValues.put(UtilidadesProductor.COLUMN_CULT_ESTI, General.cult_esti);
        contentValues.put(UtilidadesProductor.COLUMN_ASOCIA_ESTI, General.asocia_esti);
        contentValues.put(UtilidadesProductor.COLUMN_NORTE_ESTI, General.norte_esti);
        contentValues.put(UtilidadesProductor.COLUMN_SUR_ESTI, General.sur_esti);
        contentValues.put(UtilidadesProductor.COLUMN_ESTE_ESTI, General.este_esti);
        contentValues.put(UtilidadesProductor.COLUMN_OESTE_ESTI, General.oeste_esti);
        contentValues.put(UtilidadesProductor.COLUMN_OBSERVACIONES, General.Observa);

        long result = db.insert(UtilidadesProductor.TABLA_CUESTIONARIO, null, contentValues);
        db.close();
        //General.Foliocuestion="";//1
        General.fechaenc="";//2
        General.horaenc="";//3
        General.Proyecto="";//4
        General.Observa="";//24
        General.statusenc="";//5
        General.mod_uso="";//6
        General.Cobertura="";//7
        General.Modalidad="";//8
        General.cultivo_esti="";//9
        General.modalidad_esti="";//1
        General.altura_esti="";//11
        General.siniestro_esti="";//1
        General.feno_esti="";//13
        General.suelo_esti="";//14
        General.predio_esti="";//15
        General.variedad_esti="";//16
        General.maleza_esti="";//17
        General.cult_esti="";//18
        General.asocia_esti="";
        General.norte_esti="";
        General.sur_esti="";
        General.este_esti="";
        General.oeste_esti="";

        if(result == -1) {
            return false;
        }else{
            return true;
        }

    }


    //////////////////////////////////////////////////////////////////////////////////////////////////
    // Agregar Productor (metodo base de datos)
    public boolean addProductorInformac() {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        //Primera vista de productor
        contentValues.put(UtilidadesProductor.COLUMN_FOLIO_ENC, General.Foliocuestion);
        contentValues.put(UtilidadesProductor.COLUMN_NUMERO_CAPTURISTA, General.IdCapturista);
        contentValues.put(UtilidadesProductor.COLUMN_RESPONSABLEUPF_PRODUCTOR, General.Productorresponsableupf);
        contentValues.put(UtilidadesProductor.COLUMN_PRODUCTOR_RELACION_UPF, General.ProductorRelacionUpf);
        contentValues.put(UtilidadesProductor.COLUMN_NOMBRE_PRODUCTOR, General.NombreProductor);
        contentValues.put(UtilidadesProductor.COLUMN_APELLIDO_PATERNO_PROD, General.AppaternoProductor);
        contentValues.put(UtilidadesProductor.COLUMN_APELLIDO_MATERNO_PROD, General.ApmaternoProductor);
        contentValues.put(UtilidadesProductor.COLUMN_SEXO_PROD, General.ProductorSexo);
        contentValues.put(UtilidadesProductor.COLUMN_EDAD_PROD, General.ProductorEdad);
        contentValues.put(UtilidadesProductor.COLUMN_LEER_PROD, General.ProductorLeer);
        contentValues.put(UtilidadesProductor.COLUMN_ESCRIBIR_PROD, General.ProductorEscribir);
        contentValues.put(UtilidadesProductor.COLUMN_ESTUDIOS_PROD, General.GradoEstudios);
        contentValues.put(UtilidadesProductor.COLUMN_SITUACION_ESTUDIOS_PROD, General.SituacionEstudios);
        contentValues.put(UtilidadesProductor.COLUMN_PUEBLO_ORIGINARIO_PROD, General.PuebloOriginario);
        contentValues.put(UtilidadesProductor.COLUMN_CUAL_PUEBLO_PROD, General.CualPuebloOriginario);
        contentValues.put(UtilidadesProductor.COLUMN_LENGUA_ORIGINARIA_PROD, General.LenguaOriginaria);
        contentValues.put(UtilidadesProductor.COLUMN_CUAL_LENGUA_PROD, General.CualLenguaOriginaria);

        //Segunda vista de productor
        contentValues.put(UtilidadesProductor.COLUMN_ACTCOMERCIO, General.ACTCOMERCIO);
        contentValues.put(UtilidadesProductor.COLUMN_ACTTRANSFORMACION, General.ACTTRANSFORMACION);
        contentValues.put(UtilidadesProductor.COLUMN_ACTAGRICULTURA, General.ACTAGRICULTURA);
        contentValues.put(UtilidadesProductor.COLUMN_ACTGANADERIA, General.ACTGANADERIA);

        contentValues.put(UtilidadesProductor.COLUMN_ACTPESCA, General.ACTPESCA);
        contentValues.put(UtilidadesProductor.COLUMN_ACTMINERIA, General.ACTMINERIA);
        contentValues.put(UtilidadesProductor.COLUMN_ACTAPICULTURA, General.ACTAPICULTURA);
        contentValues.put(UtilidadesProductor.COLUMN_ACTMANUFACTURARTE, General.ACTMANUFACTURARTE);

        contentValues.put(UtilidadesProductor.COLUMN_ACTSERVPERSONALES, General.ACTSERVPERSONALES);
        contentValues.put(UtilidadesProductor.COLUMN_ACTCONSTRUCCION, General.ACTCONSTRUCCION);
        contentValues.put(UtilidadesProductor.COLUMN_ACTEDUCACION, General.ACTEDUCACION);
        contentValues.put(UtilidadesProductor.COLUMN_ACTTURISMO, General.ACTTURISMO);

        contentValues.put(UtilidadesProductor.COLUMN_ACTSERVPROF, General.ACTSERVPROF);
        contentValues.put(UtilidadesProductor.COLUMN_ACTTRANSPORTE, General.ACTTRANSPORTE);
        contentValues.put(UtilidadesProductor.COLUMN_ACTGOBIERNO, General.ACTGOBIERNO);
        contentValues.put(UtilidadesProductor.COLUMN_ACTOTRO, General.ACTOTRO);
        contentValues.put(UtilidadesProductor.COLUMN_ACTEDTOTRO, General.ACTEDTOTRO);


        contentValues.put(UtilidadesProductor.COLUMN_MATERIAL_VIVIENDA_PAREDES, General.MaterialViviendaPared);
        contentValues.put(UtilidadesProductor.COLUMN_MATERIAL_VIVIENDA_PAREDES_OTRO, General.MaterialViviendaParedOtro);
        contentValues.put(UtilidadesProductor.COLUMN_MATERIAL_VIVIENDA_TECHO, General.MaterialViviendaTecho);
        contentValues.put(UtilidadesProductor.COLUMN_MATERIAL_VIVIENDA_TECHO_OTRO, General.MaterialViviendaTechootro);
        contentValues.put(UtilidadesProductor.COLUMN_MATERIAL_VIVIENDA_PISO, General.MaterialViviendaPiso);
        contentValues.put(UtilidadesProductor.COLUMN_MATERIAL_VIVIENDA_PISO_OTRO, General.MaterialViviendaPisootro);
        contentValues.put(UtilidadesProductor.COLUMN_VIVIENDA_COCINA, General.ViviendaCocina);
        contentValues.put(UtilidadesProductor.COLUMN_VIVIENDA_CANTIDAD_CUARTOS, General.CantidadCuartos);
        contentValues.put(UtilidadesProductor.COLUMN_VIVIENDA_CONTAR_BANIO, General.CuentaBanio);
        contentValues.put(UtilidadesProductor.COLUMN_VIVIENDA_SERVICIO_DRENAJE, General.ViviendaServicioDrenaje);
        contentValues.put(UtilidadesProductor.COLUMN_VIVIENDA_SERVICIO_TELEFONO, General.ViviendaServicioTelefono);
        contentValues.put(UtilidadesProductor.COLUMN_VIVIENDA_SERVICIO_AGUA, General.ViviendaServicioAgua);
        contentValues.put(UtilidadesProductor.COLUMN_VIVIENDA_SERVICIO_INTERNET, General.ViviendaServicioInternet);
        contentValues.put(UtilidadesProductor.COLUMN_VIVIENDA_SERVICIO_ELECTRICIDAD, General.ViviendaServicioElectricidad);
        contentValues.put(UtilidadesProductor.COLUMN_CANTIDAD_INTEGRANTES_UPF, General.CantidadIntegrantesUpf);
        contentValues.put(UtilidadesProductor.COLUMN_PERTENECE_ORGANIZACION, General.PerteneceOrganizacion);

        contentValues.put(UtilidadesProductor.COLUMN_APOYO_ORGANIZACION_INSUMOS, General.ApoyoOrganizins);
        contentValues.put(UtilidadesProductor.COLUMN_APOYO_ORGANIZACION_ASESORIA, General.ApoyoOrganizase);
        contentValues.put(UtilidadesProductor.COLUMN_APOYO_ORGANIZACION_FINANCIAMIENTO, General.ApoyoOrganizfin);
        contentValues.put(UtilidadesProductor.COLUMN_APOYO_ORGANIZACION_COMERCIALIZACION, General.ApoyoOrganizcom);
        contentValues.put(UtilidadesProductor.COLUMN_APOYO_ORGANIZACION_GESTION, General.ApoyoOrganizgest);

        contentValues.put(UtilidadesProductor.COLUMN_ORGANIZACION_FINANCIAMIENTO, General.FinanciamientoOrganizacion);

        contentValues.put(UtilidadesProductor.COLUMN_FINANCIAMIENTO_OTORGABANCO, General.OTORGABANCO);
        contentValues.put(UtilidadesProductor.COLUMN_FINANCIAMIENTO_OTORGAGOBIERNO, General.OTORGAGOBIERNO);
        contentValues.put(UtilidadesProductor.COLUMN_FINANCIAMIENTO_OTORGAFINNAC, General.OTORGAFINNAC);
        contentValues.put(UtilidadesProductor.COLUMN_FINANCIAMIENTO_OTORGAFINRUR, General.OTORGAFINRUR);
        contentValues.put(UtilidadesProductor.COLUMN_FINANCIAMIENTO_OTORGAFINOTRO, General.OTORGAFINOTRO);
        contentValues.put(UtilidadesProductor.COLUMN_FINANCIAMIENTO_EDTOTORGFINOTRO, General.EDTOTORGFINOTRO);

        contentValues.put(UtilidadesProductor.COLUMN_MONTO_FINANCIAMIENTO, General.MontoFinanciamiento);
        contentValues.put(UtilidadesProductor.COLUMN_TIPO_SERVICIO_SECTSALUD, General.ServicioSectorSalud);
        contentValues.put(UtilidadesProductor.COLUMN_TIPO_SERVICIO_SECSOC, General.ServicioSectorSocial);

        contentValues.put(UtilidadesProductor.COLUMN_TIPO_SERVICIO_OTROSSEC, General.ServicioOtroSector);
        contentValues.put(UtilidadesProductor.COLUMN_TIPO_SERVICIO_PRIVFINLUC, General.PrivadoFinLucro);
        contentValues.put(UtilidadesProductor.COLUMN_TIPO_SERVICIO_PRIVSFINLUCRO, General.PrivadoSinFinLucro);
        contentValues.put(UtilidadesProductor.COLUMN_TIPO_SUFICIENTE_PERSONAL, General.SuficientePersonal);
        contentValues.put(UtilidadesProductor.COLUMN_SATISFACCION_SERVICIO, General.SatisfaccionServicio);



        long result = db.insert(UtilidadesProductor.TABLA_PRODUCTOR, null, contentValues);
        db.close();
        if(result == -1) {
            return false;
        }else{
            return true;
        }

    }






    //////////////////////////////////////////////////////////////////////////////////////////////////
    //Metodo para guardar integrante familia
    public boolean addIntegranteFamilia(){

        SQLiteDatabase db           = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(UtilidadesProductor.COLUMN_ID_PRODUCTOR_FAM, General.Idproductor);
        contentValues.put(UtilidadesProductor.COLUMN_FOLIO_ENC_INTEGRANTE, General.Foliocuestion);
        contentValues.put(UtilidadesProductor.COLUMN_SEXO_INTEGRANTE, General.SEXOINTEGRANTE);
        contentValues.put(UtilidadesProductor.COLUMN_EDAD_INTEGRANTE, General.EDADINTEGRANTE);
        contentValues.put(UtilidadesProductor.COLUMN_LEER_ESCRIBIRINT, General.LEESCRIBIRINT);
        contentValues.put(UtilidadesProductor.COLUMN_NIVEL_ESTUDIOSINT, General.NIVESTUDIOSINT);
        contentValues.put(UtilidadesProductor.COLUMN_SITUACION_ESTUDIOSINT, General.SITESTUDIOINT);
        contentValues.put(UtilidadesProductor.COLUMN_HABLA_LENGUA_ORIGINARIAINT, General.HABLALENGORIG);
        contentValues.put(UtilidadesProductor.COLUMN_LENGUA_HABLA_INTEGRANTE, General.CUALLENGORIG);
        contentValues.put(UtilidadesProductor.COLUMN_PARTICIPA_UPF, General.PARTICIPAUPF);
        contentValues.put(UtilidadesProductor.COLUMN_DEDICA_INTEGRANTE, General.DEDICAINTEGRANTE);
        contentValues.put(UtilidadesProductor.COLUMN_INGRESO_MENSUAL_INT, General.INGRESOINTEGRANTE);
        contentValues.put(UtilidadesProductor.COLUMN_OTRO_INGRESO_INT, General.OTROINGRESOINT);

        long result = db.insert(UtilidadesProductor.TABLA_INTEGRANTE_FAMILIA, null, contentValues);
        db.close();
        if(result == -1) {
            return false;
        }else{
            return true;

        }

    }








    //Inicia Pecuario ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Metodo para almacenar tipo de raza bovinos
    public boolean addRazabovinos(){

        SQLiteDatabase db           = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(UtilidadesPecuario.COLUMN_FOLIOENCUESTA_PECU, General.Foliocuestion);
        contentValues.put(UtilidadesPecuario.COLUMN_TIPORAZA_BOVINO, GlobalPecuario.TIPORAZABOVINO);
        contentValues.put(UtilidadesPecuario.COLUMN_RAZAPURA_UPF, GlobalPecuario.RAZAPURA);
        contentValues.put(UtilidadesPecuario.COLUMN_OTRARAZAPURA_UPF, GlobalPecuario.RAZAPURAOTRO);
        contentValues.put(UtilidadesPecuario.COLUMN_RAZACRUZA_UPF, GlobalPecuario.RAZACRUZA);
        contentValues.put(UtilidadesPecuario.COLUMN_OTRARAZACRUZA_UPF, GlobalPecuario.RAZACRUZAOTRO);

        long result = db.insert(UtilidadesPecuario.TABLA_PECUARIO_BOVINOS, null, contentValues);
        db.close();
        if(result == -1) {
            return false;
        }else{
            return true;

        }

    }


    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Metodo para almacenar tipo de raza ovinos
    public boolean addRazaovinos(){

        SQLiteDatabase db           = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(UtilidadesPecuario.COLUMN_FOLIOENC_PECU, General.Foliocuestion);
        contentValues.put(UtilidadesPecuario.COLUMN_TIPORAZA_OVINO_PRED, GlobalPecuario.TIPORAZAOVINO);
        contentValues.put(UtilidadesPecuario.COLUMN_TIPORAZA_OVINO_PRED_OTRO, GlobalPecuario.OTROTIPORAZAOVINO);

        long result = db.insert(UtilidadesPecuario.TABLA_PECUARIO_OVINOS, null, contentValues);
        db.close();
        if(result == -1) {
            return false;
        }else{
            return true;

        }

    }



    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Metodo para almacenar tipo de raza caprinos
    public boolean addRazacaprinos(){

        SQLiteDatabase db           = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(UtilidadesPecuario.COLUMN_FOLIOENC_PECUCAPRI, General.Foliocuestion);
        contentValues.put(UtilidadesPecuario.COLUMN_TIPORAZA_CAPRINO_PRED, GlobalPecuario.TIPORAZACAPRINO);
        contentValues.put(UtilidadesPecuario.COLUMN_TIPORAZA_CAPRINO_PRED_OTRO, GlobalPecuario.OTROTIPORAZACAPRINO);

        long result = db.insert(UtilidadesPecuario.TABLA_PECUARIO_CAPRINOS, null, contentValues);
        db.close();
        if(result == -1) {
            return false;
        }else{
            return true;

        }

    }






    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Metodo para almacenar Estructura del Hato
    public boolean addEstructurahato(){

        SQLiteDatabase db           = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(UtilidadesPecuario.COLUMN_FOLIOENCUESTA_HATO, General.Foliocuestion);
        contentValues.put(UtilidadesPecuario.COLUMN_BOVSEMENTALES, GlobalPecuario.BOVSEMENTALES);
        contentValues.put(UtilidadesPecuario.COLUMN_BOVSEMCANTIDADCAB, GlobalPecuario.BOVSEMCANTIDADCAB);
        contentValues.put(UtilidadesPecuario.COLUMN_BOVSEMPRECIOCAB, GlobalPecuario.BOVSEMPRECIOCAB);

        contentValues.put(UtilidadesPecuario.COLUMN_BOVVIENTADULTAS, GlobalPecuario.BOVVIENTADULTAS);
        contentValues.put(UtilidadesPecuario.COLUMN_BOVVIENTADULTACANTCAB, GlobalPecuario.BOVVIENTADULTACANTCAB);
        contentValues.put(UtilidadesPecuario.COLUMN_BOVVIENTADULTAPRECIO, GlobalPecuario.BOVVIENTADULTAPRECIO);

        contentValues.put(UtilidadesPecuario.COLUMN_BOVVAQUILLAS, GlobalPecuario.BOVVAQUILLAS);
        contentValues.put(UtilidadesPecuario.COLUMN_BOVVAQUILLASCANTCAB, GlobalPecuario.BOVVAQUILLASCANTCAB);
        contentValues.put(UtilidadesPecuario.COLUMN_BOVVAQUILLASPRECIO, GlobalPecuario.BOVVAQUILLASPRECIO);

        contentValues.put(UtilidadesPecuario.COLUMN_BOVVIENTDESARROLLO, GlobalPecuario.BOVVIENTDESARROLLO);
        contentValues.put(UtilidadesPecuario.COLUMN_BOVVIENTDESARROLLOCANTCAB, GlobalPecuario.BOVVIENTDESARROLLOCANTCAB);
        contentValues.put(UtilidadesPecuario.COLUMN_BOVVIENTDESARROLLOPRECIO, GlobalPecuario.BOVVIENTDESARROLLOPRECIO);

        contentValues.put(UtilidadesPecuario.COLUMN_BOVBECERROS, GlobalPecuario.BOVBECERROS);
        contentValues.put(UtilidadesPecuario.COLUMN_BOVBECERROSCANTCAB, GlobalPecuario.BOVBECERROSCANTCAB);
        contentValues.put(UtilidadesPecuario.COLUMN_BOVBECERROSPRECIO, GlobalPecuario.BOVBECERROSPRECIO);

        contentValues.put(UtilidadesPecuario.COLUMN_BOVTORETESDES, GlobalPecuario.BOVTORETESDES);
        contentValues.put(UtilidadesPecuario.COLUMN_BOVTORETESDESCANTCAB, GlobalPecuario.BOVTORETESDESCANTCAB);
        contentValues.put(UtilidadesPecuario.COLUMN_BOVTORETESDESPRECIO, GlobalPecuario.BOVTORETESDESPRECIO);

        contentValues.put(UtilidadesPecuario.COLUMN_BOVTORETESFINAL, GlobalPecuario.BOVTORETESFINAL);
        contentValues.put(UtilidadesPecuario.COLUMN_BOVTORETESFINALCANTCAB, GlobalPecuario.BOVTORETESFINALCANTCAB);
        contentValues.put(UtilidadesPecuario.COLUMN_BOVTORETESFINALPRECIO, GlobalPecuario.BOVTORETESFINALPRECIO);

        long result = db.insert(UtilidadesPecuario.TABLA_PECUARIO_ESTRUCTURAHATO, null, contentValues);
        db.close();
        if(result == -1) {
            return false;
        }else{
            return true;

        }

    }



    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Metodo para almacenar inventario bovino leche
    public boolean addInvbovinoleche(){

        SQLiteDatabase db           = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(UtilidadesPecuario.COLUMN_FOLIOENCUESTA_BOVLEC, General.Foliocuestion);
        contentValues.put(UtilidadesPecuario.COLUMN_BOVSEMENTALLEC, GlobalPecuario.BOVSEMENTALLEC);
        contentValues.put(UtilidadesPecuario.COLUMN_BOVSEMCANTIDADCABLEC, GlobalPecuario.BOVSEMCANTIDADCABLEC);
        contentValues.put(UtilidadesPecuario.COLUMN_BOVSEMPRECIOCABLEC, GlobalPecuario.BOVSEMPRECIOCABLEC);

        contentValues.put(UtilidadesPecuario.COLUMN_BOVVACAPRODLEC, GlobalPecuario.BOVVACAPRODLEC);
        contentValues.put(UtilidadesPecuario.COLUMN_BOVVACACANTIDADCABLEC, GlobalPecuario.BOVVACACANTIDADCABLEC);
        contentValues.put(UtilidadesPecuario.COLUMN_BOVVACAPRECIOCABLEC, GlobalPecuario.BOVVACAPRECIOCABLEC);

        contentValues.put(UtilidadesPecuario.COLUMN_BOVVASEPRODLEC, GlobalPecuario.BOVVASEPRODLEC);
        contentValues.put(UtilidadesPecuario.COLUMN_BOVVASECANTIDADCABLEC, GlobalPecuario.BOVVASECANTIDADCABLEC);
        contentValues.put(UtilidadesPecuario.COLUMN_BOVVASEPRECIOCABLEC, GlobalPecuario.BOVVASEPRECIOCABLEC);

        contentValues.put(UtilidadesPecuario.COLUMN_BOVVAQPRODLEC, GlobalPecuario.BOVVAQPRODLEC);
        contentValues.put(UtilidadesPecuario.COLUMN_BOVVAQCANTIDADCABLEC, GlobalPecuario.BOVVAQCANTIDADCABLEC);
        contentValues.put(UtilidadesPecuario.COLUMN_BOVVAQPRECIOCABLEC, GlobalPecuario.BOVVAQPRECIOCABLEC);

        contentValues.put(UtilidadesPecuario.COLUMN_BOVHEMDESPRODLEC, GlobalPecuario.BOVHEMDESPRODLEC);
        contentValues.put(UtilidadesPecuario.COLUMN_BOVHEMDESCANTIDADCABLEC, GlobalPecuario.BOVHEMDESCANTIDADCABLEC);
        contentValues.put(UtilidadesPecuario.COLUMN_BOVHEMDESPRECIOCABLEC, GlobalPecuario.BOVHEMDESPRECIOCABLEC);

        contentValues.put(UtilidadesPecuario.COLUMN_BOVBECPRODLEC, GlobalPecuario.BOVBECPRODLEC);
        contentValues.put(UtilidadesPecuario.COLUMN_BOVBECCANTIDADCABLEC, GlobalPecuario.BOVBECCANTIDADCABLEC);
        contentValues.put(UtilidadesPecuario.COLUMN_BOVBECPRECIOCABLEC, GlobalPecuario.BOVBECPRECIOCABLEC);

        contentValues.put(UtilidadesPecuario.COLUMN_BOVBECERRASPRODLEC, GlobalPecuario.BOVBECERRASPRODLEC);
        contentValues.put(UtilidadesPecuario.COLUMN_BOVBECERRASCANTIDADCABLEC, GlobalPecuario.BOVBECERRASCANTIDADCABLEC);
        contentValues.put(UtilidadesPecuario.COLUMN_BOVBECERRASPRECIOCABLEC, GlobalPecuario.BOVBECERRASPRECIOCABLEC);

        contentValues.put(UtilidadesPecuario.COLUMN_BOVTORETESPRODLEC, GlobalPecuario.BOVTORETESPRODLEC);
        contentValues.put(UtilidadesPecuario.COLUMN_BOVTORETESCANTIDADCABLEC, GlobalPecuario.BOVTORETESCANTIDADCABLEC);
        contentValues.put(UtilidadesPecuario.COLUMN_BOVTORETESPRECIOCABLEC, GlobalPecuario.BOVTORETESPRECIOCABLEC);

        long result = db.insert(UtilidadesPecuario.TABLA_PECUARIO_BOVINOLECHE, null, contentValues);
        db.close();
        if(result == -1) {
            return false;
        }else{
            return true;

        }

    }






    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Metodo para almacenar inventario ganado ovino
    public boolean addInvovino(){

        SQLiteDatabase db           = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(UtilidadesPecuario.COLUMN_FOLIOENCUESTA_PECUOVI, General.Foliocuestion);
        contentValues.put(UtilidadesPecuario.COLUMN_OVINOSEMENTAL, GlobalPecuario.OVINOSEMENTAL);
        contentValues.put(UtilidadesPecuario.COLUMN_OVISEMCANTIDAD, GlobalPecuario.OVISEMCANTIDAD);
        contentValues.put(UtilidadesPecuario.COLUMN_OVISEMEPRECIO, GlobalPecuario.OVISEMEPRECIO);

        contentValues.put(UtilidadesPecuario.COLUMN_OVIBORREGADUL, GlobalPecuario.OVIBORREGADUL);
        contentValues.put(UtilidadesPecuario.COLUMN_OVIBORREGADULCANTIDAD, GlobalPecuario.OVIBORREGADULCANTIDAD);
        contentValues.put(UtilidadesPecuario.COLUMN_OVIBORREGADULPRECIO, GlobalPecuario.OVIBORREGADULPRECIO);

        contentValues.put(UtilidadesPecuario.COLUMN_OVIPRIMALASPROD, GlobalPecuario.OVIPRIMALASPROD);
        contentValues.put(UtilidadesPecuario.COLUMN_OVIPRIMALASCANTIDAD, GlobalPecuario.OVIPRIMALASCANTIDAD);
        contentValues.put(UtilidadesPecuario.COLUMN_OVIPRIMALASPRECIO, GlobalPecuario.OVIPRIMALASPRECIO);

        contentValues.put(UtilidadesPecuario.COLUMN_OVICORDERAS, GlobalPecuario.OVICORDERAS);
        contentValues.put(UtilidadesPecuario.COLUMN_OVICORDERASCANTIDAD, GlobalPecuario.OVICORDERASCANTIDAD);
        contentValues.put(UtilidadesPecuario.COLUMN_OVICORDERASPRECIO, GlobalPecuario.OVICORDERASPRECIO);

        contentValues.put(UtilidadesPecuario.COLUMN_OVICORDEROSLACT, GlobalPecuario.OVICORDEROSLACT);
        contentValues.put(UtilidadesPecuario.COLUMN_OVICORDEROSLACTCANTIDAD, GlobalPecuario.OVICORDEROSLACTCANTIDAD);
        contentValues.put(UtilidadesPecuario.COLUMN_OVICORDEROSLACTPRECIO, GlobalPecuario.OVICORDEROSLACTPRECIO);

        contentValues.put(UtilidadesPecuario.COLUMN_OVICORDEROSENG, GlobalPecuario.OVICORDEROSENG);
        contentValues.put(UtilidadesPecuario.COLUMN_OVICORDEROSENGCANTIDAD, GlobalPecuario.OVICORDEROSENGCANTIDAD);
        contentValues.put(UtilidadesPecuario.COLUMN_OVICORDEROSENGPRECIO, GlobalPecuario.OVICORDEROSENGPRECIO);

        long result = db.insert(UtilidadesPecuario.TABLA_PECUARIO_INVENTARIOGANOVINO, null, contentValues);
        db.close();
        if(result == -1) {
            return false;
        }else{
            return true;

        }

    }



    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Metodo para almacenar inventario ganado caprino
    public boolean addInvgancaprino(){

        SQLiteDatabase db           = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(UtilidadesPecuario.COLUMN_FOLIOENCUESTA_PECUCAPRI, General.Foliocuestion);
        contentValues.put(UtilidadesPecuario.COLUMN_CAPRINOSEMENTAL, GlobalPecuario.CAPRINOSEMENTAL);
        contentValues.put(UtilidadesPecuario.COLUMN_CAPRISEMCANTIDAD, GlobalPecuario.CAPRISEMCANTIDAD);
        contentValues.put(UtilidadesPecuario.COLUMN_CAPRISEMEPRECIO, GlobalPecuario.CAPRISEMEPRECIO);

    //    contentValues.put(UtilidadesPecuario.COLUMN_CAPRINOSCABRASLACTACION, GlobalPecuario.CAPRINOSCABRASLACTACION);
    //    contentValues.put(UtilidadesPecuario.COLUMN_CAPRICABRASLACTCANTIDAD, GlobalPecuario.CAPRICABRASLACTCANTIDAD);
    //    contentValues.put(UtilidadesPecuario.COLUMN_CAPRICABRASLACTPRECIO, GlobalPecuario.CAPRICABRASLACTPRECIO);

        contentValues.put(UtilidadesPecuario.COLUMN_CAPRINOCABRASSECAS, GlobalPecuario.CAPRINOCABRASSECAS);
        contentValues.put(UtilidadesPecuario.COLUMN_CAPRICABRASSECCANTIDAD, GlobalPecuario.CAPRICABRASSECCANTIDAD);
        contentValues.put(UtilidadesPecuario.COLUMN_CAPRICABRASSECPRECIO, GlobalPecuario.CAPRICABRASSECPRECIO);

        contentValues.put(UtilidadesPecuario.COLUMN_CAPRINOCABRASSERVPRIMERPARTO, GlobalPecuario.CAPRINOCABRASSERVPRIMERPARTO);
        contentValues.put(UtilidadesPecuario.COLUMN_CAPRICABRASPRIMERPARTOCANTIDAD, GlobalPecuario.CAPRICABRASPRIMERPARTOCANTIDAD);
        contentValues.put(UtilidadesPecuario.COLUMN_CAPRICABRASPRIMPARTOPRECIO, GlobalPecuario.CAPRICABRASPRIMPARTOPRECIO);

        contentValues.put(UtilidadesPecuario.COLUMN_CAPRINOCABRASDESAR, GlobalPecuario.CAPRINOCABRASDESAR);
        contentValues.put(UtilidadesPecuario.COLUMN_CAPRINOCABRASDESCANTIDAD, GlobalPecuario.CAPRINOCABRASDESCANTIDAD);
        contentValues.put(UtilidadesPecuario.COLUMN_CAPRINOCABRASDESPRECIO, GlobalPecuario.CAPRINOCABRASDESPRECIO);

        contentValues.put(UtilidadesPecuario.COLUMN_CAPRICABRASLACTANTES, GlobalPecuario.CAPRICABRASLACTANTES);
        contentValues.put(UtilidadesPecuario.COLUMN_CAPRICABRASLATCANTIDAD, GlobalPecuario.CAPRICABRASLATCANTIDAD);
        contentValues.put(UtilidadesPecuario.COLUMN_CAPRICABRASLACPRECIO, GlobalPecuario.CAPRICABRASLACPRECIO);

        contentValues.put(UtilidadesPecuario.COLUMN_CAPRICABRITOLACTANTES, GlobalPecuario.CAPRICABRITOLACTANTES);
        contentValues.put(UtilidadesPecuario.COLUMN_CAPRICABLACTCANTIDAD, GlobalPecuario.CAPRICABLACTCANTIDAD);
        contentValues.put(UtilidadesPecuario.COLUMN_CAPRICABLACTPRECIO, GlobalPecuario.CAPRICABLACTPRECIO);

        contentValues.put(UtilidadesPecuario.COLUMN_CAPRICABRITOENGORDA, GlobalPecuario.CAPRICABRITOENGORDA);
        contentValues.put(UtilidadesPecuario.COLUMN_CAPRICABENGCANTIDAD, GlobalPecuario.CAPRICABENGCANTIDAD);
        contentValues.put(UtilidadesPecuario.COLUMN_CAPRICABENGPRECIO, GlobalPecuario.CAPRICABENGPRECIO);

        contentValues.put(UtilidadesPecuario.COLUMN_EXPLOTACCAPRINO, GlobalPecuario.EXPLOTACCAPRINO);

        long result = db.insert(UtilidadesPecuario.TABLA_PECUARIO_INVENTARIOGANCAPRI, null, contentValues);
        db.close();
        if(result == -1) {
            return false;
        }else{
            return true;

        }

    }


    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Metodo para almacenar Pecuario alimentacionaddGoerreferenciaDos
    public boolean addPecuariopastoreobov(){

        SQLiteDatabase db           = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(UtilidadesPecuario.COLUMN_FOLIOENC_PECUBOVPASTOR, General.Foliocuestion);
        contentValues.put(UtilidadesPecuario.COLUMN_DIEBOVFOPAAGPCRIA, GlobalPecuario.DIEBOVFOPAAGPCRIA);
        contentValues.put(UtilidadesPecuario.COLUMN_DIEBOVFOPAAGBEC, GlobalPecuario.DIEBOVFOPAAGBEC);
        contentValues.put(UtilidadesPecuario.COLUMN_DIEBOVFOPAAGDES, GlobalPecuario.DIEBOVFOPAAGDES);
        contentValues.put(UtilidadesPecuario.COLUMN_DIEBOVFOPAAGFIN, GlobalPecuario.DIEBOVFOPAAGFIN);
        contentValues.put(UtilidadesPecuario.COLUMN_DIEBOVFOPAAGCOSTO, GlobalPecuario.DIEBOVFOPAAGCOSTO);

        contentValues.put(UtilidadesPecuario.COLUMN_DIEBOVFOPAPRAPCRIA, GlobalPecuario.DIEBOVFOPAPRAPCRIA);
        contentValues.put(UtilidadesPecuario.COLUMN_DIEBOVFOPAPRABEC, GlobalPecuario.DIEBOVFOPAPRABEC);
        contentValues.put(UtilidadesPecuario.COLUMN_DIEBOVFOPAPRADES, GlobalPecuario.DIEBOVFOPAPRADES);
        contentValues.put(UtilidadesPecuario.COLUMN_DIEBOVFOPAPRAFIN, GlobalPecuario.DIEBOVFOPAPRAFIN);
        contentValues.put(UtilidadesPecuario.COLUMN_DIEBOVFOPAPRACOSTO, GlobalPecuario.DIEBOVFOPAPRACOSTO);

        long result = db.insert(UtilidadesPecuario.TABLA_PECUARIO_BOVPASTOREO, null, contentValues);
        db.close();
        if(result == -1) {
            return false;
        }else{
            return true;

        }

    }


    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Metodo para almacenar Pecuario alimentacion pastoreo dieta
    public boolean addPecuariopastoreodietabov(){

        SQLiteDatabase db           = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(UtilidadesPecuario.COLUMN_FOLIOENC_PECUBOVALIMGANADO, General.Foliocuestion);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_DIEFORENSPCRIA, GlobalPecuario.DIEFORENSPCRIA);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_DIEFORENSBEC, GlobalPecuario.DIEFORENSBEC);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_DIEFORENSDES, GlobalPecuario.DIEFORENSDES);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_DIEFORENSFIN, GlobalPecuario.DIEFORENSFIN);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_DIEFORENSCOSTO, GlobalPecuario.DIEFORENSCOSTO);

        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_DIEFORHENPCRIA, GlobalPecuario.DIEFORHENPCRIA);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_DIEFORHENBEC, GlobalPecuario.DIEFORHENBEC);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_DIEFORHENDES, GlobalPecuario.DIEFORHENDES);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_DIEFORHENFIN, GlobalPecuario.DIEFORHENFIN);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_DIEFORHENCOSTO, GlobalPecuario.DIEFORHENCOSTO);

        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_DIEFORPACALFPCRIA, GlobalPecuario.DIEFORPACALFPCRIA);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_DIEFORPACALFBEC, GlobalPecuario.DIEFORPACALFBEC);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_DIEFORPACALFDES, GlobalPecuario.DIEFORPACALFDES);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_DIEFORPACALFFIN, GlobalPecuario.DIEFORPACALFFIN);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_DIEFORPACALFCOSTO, GlobalPecuario.DIEFORPACALFCOSTO);

        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_DIECONCOMPCRIA, GlobalPecuario.DIECONCOMPCRIA);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_DIECONCOMBEC, GlobalPecuario.DIECONCOMBEC);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_DIECONCOMDES, GlobalPecuario.DIECONCOMDES);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_DIECONCOMFIN, GlobalPecuario.DIECONCOMFIN);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_DIECONCOMCOSTO, GlobalPecuario.DIECONCOMCOSTO);

        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_DIECONMAIZPCRIA, GlobalPecuario.DIECONMAIZPCRIA);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_DIECONMAIZBEC, GlobalPecuario.DIECONMAIZBEC);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_DIECONMAIZDES, GlobalPecuario.DIECONMAIZDES);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_DIECONMAIZFIN, GlobalPecuario.DIECONMAIZFIN);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_DIECONMAIZCOSTO, GlobalPecuario.DIECONMAIZCOSTO);

        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_DIECONPASTAPCRIA, GlobalPecuario.DIECONPASTAPCRIA);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_DIECONPASTABEC, GlobalPecuario.DIECONPASTABEC);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_DIECONPASTADES, GlobalPecuario.DIECONPASTADES);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_DIECONPASTAFIN, GlobalPecuario.DIECONPASTAFIN);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_DIECONPASTACOSTO, GlobalPecuario.DIECONPASTACOSTO);

        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_DIECONBLOQMINPCRIA, GlobalPecuario.DIECONBLOQMINPCRIA);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_DIECONBLOQMINBEC, GlobalPecuario.DIECONBLOQMINBEC);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_DIECONBLOQMINDES, GlobalPecuario.DIECONBLOQMINDES);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_DIECONBLOQMINFIN, GlobalPecuario.DIECONBLOQMINFIN);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_DIECONBLOQMINCOSTO, GlobalPecuario.DIECONBLOQMINCOSTO);

        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_DIECONMELPCRIA, GlobalPecuario.DIECONMELPCRIA);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_DIECONMELBEC, GlobalPecuario.DIECONMELBEC);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_DIECONMELDES, GlobalPecuario.DIECONMELDES);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_DIECONMELFIN, GlobalPecuario.DIECONMELFIN);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_DIECONMELCOSTO, GlobalPecuario.DIECONMELCOSTO);

        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_DIECONUREAPCRIA, GlobalPecuario.DIECONUREAPCRIA);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_DIECONUREABEC, GlobalPecuario.DIECONUREABEC);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_DIECONUREADES, GlobalPecuario.DIECONUREADES);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_DIECONUREAFIN, GlobalPecuario.DIECONUREAFIN);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_DIECONUREACOSTO, GlobalPecuario.DIECONUREACOSTO);

        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_DIECONVITAMPCRIA, GlobalPecuario.DIECONVITAMPCRIA);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_DIECONVITAMBEC, GlobalPecuario.DIECONVITAMBEC);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_DIECONVITAMDES, GlobalPecuario.DIECONVITAMDES);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_DIECONVITAMFIN, GlobalPecuario.DIECONVITAMFIN);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_DIECONVITAMCOSTO, GlobalPecuario.DIECONVITAMCOSTO);

        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_DIECONSUBPPCRIA, GlobalPecuario.DIECONSUBPPCRIA);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_DIECONSUBPBEC, GlobalPecuario.DIECONSUBPBEC);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_DIECONSUBPDES, GlobalPecuario.DIECONSUBPDES);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_DIECONSUBPFIN, GlobalPecuario.DIECONSUBPFIN);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_DIECONSUBPCOSTO, GlobalPecuario.DIECONSUBPCOSTO);

        long result = db.insert(UtilidadesPecuario.TABLA_PECUARIO_BOVALIMGANADO, null, contentValues);
        db.close();
        if(result == -1) {
            return false;
        }else{
            return true;

        }

    }





    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Metodo para almacenar Pecuario composicion dieta ovinos caprinos
    public boolean addPecuariocompdietaovicapri(){

        SQLiteDatabase db           = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(UtilidadesPecuario.COLUMN_FOLIOENC_PECUDIETAOVICAPRI, General.Foliocuestion);

        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTAGOSTENE, GlobalPecuario.PASTAGOSTENE);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTAGOSTFEB, GlobalPecuario.PASTAGOSTFEB);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTAGOSTMAR, GlobalPecuario.PASTAGOSTMAR);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTAGOSTABR, GlobalPecuario.PASTAGOSTABR);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTAGOSTMAY, GlobalPecuario.PASTAGOSTMAY);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTAGOSTJUN, GlobalPecuario.PASTAGOSTJUN);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTAGOSTJUL, GlobalPecuario.PASTAGOSTJUL);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTAGOSTAGO, GlobalPecuario.PASTAGOSTAGO);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTAGOSTSEP, GlobalPecuario.PASTAGOSTSEP);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTAGOSTOCT, GlobalPecuario.PASTAGOSTOCT);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTAGOSTNOV, GlobalPecuario.PASTAGOSTNOV);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTAGOSTDIC, GlobalPecuario.PASTAGOSTDIC);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTAGOSTCOS, GlobalPecuario.PASTAGOSTCOS);

        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTPRADENE, GlobalPecuario.PASTPRADENE);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTPRADFEB, GlobalPecuario.PASTPRADFEB);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTPRADMAR, GlobalPecuario.PASTPRADMAR);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTPRADABR, GlobalPecuario.PASTPRADABR);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTPRADMAY, GlobalPecuario.PASTPRADMAY);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTPRADJUN, GlobalPecuario.PASTPRADJUN);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTPRADJUL, GlobalPecuario.PASTPRADJUL);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTPRADAGO, GlobalPecuario.PASTPRADAGO);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTPRADSEP, GlobalPecuario.PASTPRADSEP);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTPRADOCT, GlobalPecuario.PASTPRADOCT);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTPRADNOV, GlobalPecuario.PASTPRADNOV);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTPRADDIC, GlobalPecuario.PASTPRADDIC);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTPRADCOS, GlobalPecuario.PASTPRADCOS);


        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTRASTROENE, GlobalPecuario.PASTRASTROENE);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTRASTROFEB, GlobalPecuario.PASTRASTROFEB);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTRASTROMAR, GlobalPecuario.PASTRASTROMAR);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTRASTROABR, GlobalPecuario.PASTRASTROABR);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTRASTROMAY, GlobalPecuario.PASTRASTROMAY);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTRASTROJUN, GlobalPecuario.PASTRASTROJUN);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTRASTROJUL, GlobalPecuario.PASTRASTROJUL);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTRASTROAGO, GlobalPecuario.PASTRASTROAGO);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTRASTROSEP, GlobalPecuario.PASTRASTROSEP);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTRASTROOCT, GlobalPecuario.PASTRASTROOCT);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTRASTRONOV, GlobalPecuario.PASTRASTRONOV);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTRASTRODIC, GlobalPecuario.PASTRASTRODIC);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTRASTROCOS, GlobalPecuario.PASTRASTROCOS);


        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTCORVERENE, GlobalPecuario.PASTCORVERENE);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTCORVERFEB, GlobalPecuario.PASTCORVERFEB);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTCORVERMAR, GlobalPecuario.PASTCORVERMAR);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTCORVERABR, GlobalPecuario.PASTCORVERABR);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTCORVERMAY, GlobalPecuario.PASTCORVERMAY);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTCORVERJUN, GlobalPecuario.PASTCORVERJUN);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTCORVERJUL, GlobalPecuario.PASTCORVERJUL);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTCORVERAGO, GlobalPecuario.PASTCORVERAGO);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTCORVERSEP, GlobalPecuario.PASTCORVERSEP);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTCORVEROCT, GlobalPecuario.PASTCORVEROCT);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTCORVERNOV, GlobalPecuario.PASTCORVERNOV);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTCORVERDIC, GlobalPecuario.PASTCORVERDIC);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTCORVERCOS, GlobalPecuario.PASTCORVERCOS);


        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTMAIZENE, GlobalPecuario.PASTMAIZENE);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTMAIZFEB, GlobalPecuario.PASTMAIZFEB);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTMAIZMAR, GlobalPecuario.PASTMAIZMAR);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTMAIZABR, GlobalPecuario.PASTMAIZABR);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTMAIZMAY, GlobalPecuario.PASTMAIZMAY);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTMAIZJUN, GlobalPecuario.PASTMAIZJUN);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTMAIZJUL, GlobalPecuario.PASTMAIZJUL);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTMAIZAGO, GlobalPecuario.PASTMAIZAGO);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTMAIZSEP, GlobalPecuario.PASTMAIZSEP);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTMAIZOCT, GlobalPecuario.PASTMAIZOCT);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTMAIZNOV, GlobalPecuario.PASTMAIZNOV);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTMAIZDIC, GlobalPecuario.PASTMAIZDIC);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTMAIZCOS, GlobalPecuario.PASTMAIZCOS);


        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTHENOSENE, GlobalPecuario.PASTHENOSENE);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTHENOSFEB, GlobalPecuario.PASTHENOSFEB);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTHENOSMAR, GlobalPecuario.PASTHENOSMAR);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTHENOSABR, GlobalPecuario.PASTHENOSABR);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTHENOSMAY, GlobalPecuario.PASTHENOSMAY);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTHENOSJUN, GlobalPecuario.PASTHENOSJUN);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTHENOSJUL, GlobalPecuario.PASTHENOSJUL);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTHENOSAGO, GlobalPecuario.PASTHENOSAGO);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTHENOSSEP, GlobalPecuario.PASTHENOSSEP);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTHENOSOCT, GlobalPecuario.PASTHENOSOCT);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTHENOSNOV, GlobalPecuario.PASTHENOSNOV);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTHENOSDIC, GlobalPecuario.PASTHENOSDIC);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTHENOSCOS, GlobalPecuario.PASTHENOSCOS);


        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTCONCOMENE, GlobalPecuario.PASTCONCOMENE);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTCONCOMFEB, GlobalPecuario.PASTCONCOMFEB);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTCONCOMMAR, GlobalPecuario.PASTCONCOMMAR);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTCONCOMABR, GlobalPecuario.PASTCONCOMABR);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTCONCOMMAY, GlobalPecuario.PASTCONCOMMAY);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTCONCOMJUN, GlobalPecuario.PASTCONCOMJUN);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTCONCOMJUL, GlobalPecuario.PASTCONCOMJUL);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTCONCOMAGO, GlobalPecuario.PASTCONCOMAGO);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTCONCOMSEP, GlobalPecuario.PASTCONCOMSEP);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTCONCOMOCT, GlobalPecuario.PASTCONCOMOCT);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTCONCOMNOV, GlobalPecuario.PASTCONCOMNOV);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTCONCOMDIC, GlobalPecuario.PASTCONCOMDIC);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTCONCOMCOS, GlobalPecuario.PASTCONCOMCOS);


        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTELPROPENE, GlobalPecuario.PASTELPROPENE);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTELPROPFEB, GlobalPecuario.PASTELPROPFEB);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTELPROPMAR, GlobalPecuario.PASTELPROPMAR);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTELPROPABR, GlobalPecuario.PASTELPROPABR);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTELPROPMAY, GlobalPecuario.PASTELPROPMAY);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTELPROPJUN, GlobalPecuario.PASTELPROPJUN);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTELPROPJUL, GlobalPecuario.PASTELPROPJUL);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTELPROPAGO, GlobalPecuario.PASTELPROPAGO);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTELPROPSEP, GlobalPecuario.PASTELPROPSEP);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTELPROPOCT, GlobalPecuario.PASTELPROPOCT);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTELPROPNOV, GlobalPecuario.PASTELPROPNOV);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTELPROPDIC, GlobalPecuario.PASTELPROPDIC);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTELPROPCOS, GlobalPecuario.PASTELPROPCOS);




        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTBLOQCOMENE, GlobalPecuario.PASTBLOQCOMENE);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTBLOQCOMFEB, GlobalPecuario.PASTBLOQCOMFEB);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTBLOQCOMMAR, GlobalPecuario.PASTBLOQCOMMAR);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTBLOQCOMABR, GlobalPecuario.PASTBLOQCOMABR);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTBLOQCOMMAY, GlobalPecuario.PASTBLOQCOMMAY);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTBLOQCOMJUN, GlobalPecuario.PASTBLOQCOMJUN);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTBLOQCOMJUL, GlobalPecuario.PASTBLOQCOMJUL);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTBLOQCOMAGO, GlobalPecuario.PASTBLOQCOMAGO);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTBLOQCOMSEP, GlobalPecuario.PASTBLOQCOMSEP);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTBLOQCOMOCT, GlobalPecuario.PASTBLOQCOMOCT);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTBLOQCOMNOV, GlobalPecuario.PASTBLOQCOMNOV);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTBLOQCOMDIC, GlobalPecuario.PASTBLOQCOMDIC);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTBLOQCOMCOS, GlobalPecuario.PASTBLOQCOMCOS);


        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTBLOQELPRENE, GlobalPecuario.PASTBLOQELPRENE);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTBLOQELPRFEB, GlobalPecuario.PASTBLOQELPRFEB);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTBLOQELPRMAR, GlobalPecuario.PASTBLOQELPRMAR);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTBLOQELPRABR, GlobalPecuario.PASTBLOQELPRABR);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTBLOQELPRMAY, GlobalPecuario.PASTBLOQELPRMAY);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTBLOQELPRJUN, GlobalPecuario.PASTBLOQELPRJUN);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTBLOQELPRJUL, GlobalPecuario.PASTBLOQELPRJUL);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTBLOQELPRAGO, GlobalPecuario.PASTBLOQELPRAGO);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTBLOQELPRSEP, GlobalPecuario.PASTBLOQELPRSEP);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTBLOQELPROCT, GlobalPecuario.PASTBLOQELPROCT);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTBLOQELPRNOV, GlobalPecuario.PASTBLOQELPRNOV);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASBLOQELPRDIC, GlobalPecuario.PASBLOQELPRDIC);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTBLOQELPRCOS, GlobalPecuario.PASTBLOQELPRCOS);





        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTMELUREAENE, GlobalPecuario.PASTMELUREAENE);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTMELUREAFEB, GlobalPecuario.PASTMELUREAFEB);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTMELUREAMAR, GlobalPecuario.PASTMELUREAMAR);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTMELUREAABR, GlobalPecuario.PASTMELUREAABR);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTMELUREAMAY, GlobalPecuario.PASTMELUREAMAY);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTMELUREAJUN, GlobalPecuario.PASTMELUREAJUN);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTMELUREAJUL, GlobalPecuario.PASTMELUREAJUL);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTMELUREAAGO, GlobalPecuario.PASTMELUREAAGO);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTMELUREASEP, GlobalPecuario.PASTMELUREASEP);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTMELUREAOCT, GlobalPecuario.PASTBLOQCOMOCT);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTMELUREANOV, GlobalPecuario.PASTMELUREANOV);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASMELUREADIC, GlobalPecuario.PASMELUREADIC);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTMELUREACOS, GlobalPecuario.PASTMELUREACOS);


        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTGRANOLEENE, GlobalPecuario.PASTGRANOLEENE);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTGRANOLEFEB, GlobalPecuario.PASTGRANOLEFEB);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTGRANOLEMAR, GlobalPecuario.PASTGRANOLEMAR);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTGRANOLEABR, GlobalPecuario.PASTGRANOLEABR);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTGRANOLEMAY, GlobalPecuario.PASTGRANOLEMAY);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTGRANOLEJUN, GlobalPecuario.PASTGRANOLEJUN);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTGRANOLEJUL, GlobalPecuario.PASTGRANOLEJUL);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTGRANOLEAGO, GlobalPecuario.PASTGRANOLEAGO);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTGRANOLESEP, GlobalPecuario.PASTGRANOLESEP);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTGRANOLEOCT, GlobalPecuario.PASTGRANOLEOCT);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTGRANOLENOV, GlobalPecuario.PASTGRANOLENOV);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASGRANOLEDIC, GlobalPecuario.PASGRANOLEDIC);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTGRANOLECOS, GlobalPecuario.PASTGRANOLECOS);




        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTSALCOMENE, GlobalPecuario.PASTSALCOMENE);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTSALCOMFEB, GlobalPecuario.PASTSALCOMFEB);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTSALCOMMAR, GlobalPecuario.PASTSALCOMMAR);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTSALCOMABR, GlobalPecuario.PASTSALCOMABR);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTSALCOMMAY, GlobalPecuario.PASTSALCOMMAY);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTSALCOMJUN, GlobalPecuario.PASTSALCOMJUN);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTSALCOMJUL, GlobalPecuario.PASTSALCOMJUL);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTSALCOMAGO, GlobalPecuario.PASTSALCOMAGO);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTSALCOMSEP, GlobalPecuario.PASTSALCOMSEP);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTSALCOMOCT, GlobalPecuario.PASTSALCOMOCT);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTSALCOMNOV, GlobalPecuario.PASTSALCOMNOV);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASSALCOMDIC, GlobalPecuario.PASSALCOMDIC);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTSALCOMCOS, GlobalPecuario.PASTSALCOMCOS);


        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTSALMINENE, GlobalPecuario.PASTSALMINENE);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTSALMINFEB, GlobalPecuario.PASTSALMINFEB);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTSALMINMAR, GlobalPecuario.PASTSALMINMAR);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTSALMINABR, GlobalPecuario.PASTSALMINABR);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTSALMINMAY, GlobalPecuario.PASTSALMINMAY);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTSALMINJUN, GlobalPecuario.PASTSALMINJUN);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTSALMINJUL, GlobalPecuario.PASTSALMINJUL);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTSALMINAGO, GlobalPecuario.PASTSALMINAGO);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTSALMINSEP, GlobalPecuario.PASTSALMINSEP);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTSALMINOCT, GlobalPecuario.PASTSALMINOCT);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTSALMINNOV, GlobalPecuario.PASTSALMINNOV);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASSALMINDIC, GlobalPecuario.PASSALMINDIC);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTSALMINCOS, GlobalPecuario.PASTSALMINCOS);





        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTBLOQMINENE, GlobalPecuario.PASTBLOQMINENE);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTBLOQMINFEB, GlobalPecuario.PASTBLOQMINFEB);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTBLOQMINMAR, GlobalPecuario.PASTBLOQMINMAR);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTBLOQMINABR, GlobalPecuario.PASTBLOQMINABR);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTBLOQMINMAY, GlobalPecuario.PASTBLOQMINMAY);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTBLOQMINJUN, GlobalPecuario.PASTBLOQMINJUN);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTBLOQMINJUL, GlobalPecuario.PASTBLOQMINJUL);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTBLOQMINAGO, GlobalPecuario.PASTBLOQMINAGO);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTBLOQMINSEP, GlobalPecuario.PASTBLOQMINSEP);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTBLOQMINOCT, GlobalPecuario.PASTBLOQMINOCT);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTBLOQMINNOV, GlobalPecuario.PASTBLOQMINNOV);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASBLOQMINDIC, GlobalPecuario.PASBLOQMINDIC);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTBLOQMINCOS, GlobalPecuario.PASTBLOQMINCOS);


        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTVITAMINENE, GlobalPecuario.PASTVITAMINENE);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTVITAMINFEB, GlobalPecuario.PASTVITAMINFEB);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTVITAMINMAR, GlobalPecuario.PASTVITAMINMAR);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTVITAMINABR, GlobalPecuario.PASTVITAMINABR);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTVITAMINMAY, GlobalPecuario.PASTVITAMINMAY);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTVITAMINJUN, GlobalPecuario.PASTVITAMINJUN);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTVITAMINJUL, GlobalPecuario.PASTVITAMINJUL);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTVITAMINAGO, GlobalPecuario.PASTVITAMINAGO);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTVITAMINSEP, GlobalPecuario.PASTVITAMINSEP);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTVITAMINOCT, GlobalPecuario.PASTVITAMINOCT);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTVITAMINNOV, GlobalPecuario.PASTVITAMINNOV);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASVITAMINDIC, GlobalPecuario.PASVITAMINDIC);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTVITAMINCOS, GlobalPecuario.PASTVITAMINCOS);





        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTSELENIOENE, GlobalPecuario.PASTSELENIOENE);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTSELENIOFEB, GlobalPecuario.PASTSELENIOFEB);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTSELENIOMAR, GlobalPecuario.PASTSELENIOMAR);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTSELENIOABR, GlobalPecuario.PASTSELENIOABR);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTSELENIOMAY, GlobalPecuario.PASTSELENIOMAY);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTSELENIOJUN, GlobalPecuario.PASTSELENIOJUN);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTSELENIOJUL, GlobalPecuario.PASTSELENIOJUL);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTSELENIOAGO, GlobalPecuario.PASTSELENIOAGO);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTSELENIOSEP, GlobalPecuario.PASTSELENIOSEP);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTSELENIOOCT, GlobalPecuario.PASTSELENIOOCT);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTSELENIONOV, GlobalPecuario.PASTSELENIONOV);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASSELENIODIC, GlobalPecuario.PASSELENIODIC);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTSELENIOCOS, GlobalPecuario.PASTSELENIOCOS);


        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTOTROTIPOENE, GlobalPecuario.PASTOTROTIPOENE);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTOTROTIPOFEB, GlobalPecuario.PASTOTROTIPOFEB);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTOTROTIPOMAR, GlobalPecuario.PASTOTROTIPOMAR);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTOTROTIPOABR, GlobalPecuario.PASTOTROTIPOABR);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTOTROTIPOMAY, GlobalPecuario.PASTOTROTIPOMAY);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTOTROTIPOJUN, GlobalPecuario.PASTOTROTIPOJUN);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTOTROTIPOJUL, GlobalPecuario.PASTOTROTIPOJUL);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTOTROTIPOAGO, GlobalPecuario.PASTOTROTIPOAGO);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTOTROTIPOSEP, GlobalPecuario.PASTOTROTIPOSEP);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTOTROTIPOOCT, GlobalPecuario.PASTOTROTIPOOCT);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTOTROTIPONOV, GlobalPecuario.PASTOTROTIPONOV);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASOTROTIPODIC, GlobalPecuario.PASOTROTIPODIC);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PASTOTROTIPOCOS, GlobalPecuario.PASTOTROTIPOCOS);



        long result = db.insert(UtilidadesPecuario.TABLA_PECUARIO_DIETAOVICAPRI, null, contentValues);
        db.close();
        if(result == -1) {
            return false;
        }else{
            return true;

        }

    }




    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Metodo para almacenar eventos unidad de produccion - pecuario
    public boolean addPecuarioevunidprod(){

        SQLiteDatabase db           = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(UtilidadesPecuario.COLUMN_FOLIOENC_PECUEVEUNPRO, General.Foliocuestion);

        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_EVEESCAFORENE, GlobalPecuario.EVEESCAFORENE);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_EVEESCAFORFEB, GlobalPecuario.EVEESCAFORFEB);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_EVEESCAFORMAR, GlobalPecuario.EVEESCAFORMAR);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_EVEESCAFORABR, GlobalPecuario.EVEESCAFORABR);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_EVEESCAFORMAY, GlobalPecuario.EVEESCAFORMAY);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_EVEESCAFORJUN, GlobalPecuario.EVEESCAFORJUN);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_EVEESCAFORJUL, GlobalPecuario.EVEESCAFORJUL);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_EVEESCAFORAGO, GlobalPecuario.EVEESCAFORAGO);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_EVEESCAFORSEP, GlobalPecuario.EVEESCAFORSEP);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_EVEESCAFOROCT, GlobalPecuario.EVEESCAFOROCT);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_EVEESCAFORNOV, GlobalPecuario.EVEESCAFORNOV);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_EVEESCAFORDIC, GlobalPecuario.EVEESCAFORDIC);

        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_EVECOMPFORENE, GlobalPecuario.EVECOMPFORENE);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_EVECOMPFORFEB, GlobalPecuario.EVECOMPFORFEB);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_EVECOMPFORMAR, GlobalPecuario.EVECOMPFORMAR);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_EVECOMPFORABR, GlobalPecuario.EVECOMPFORABR);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_EVECOMPFORMAY, GlobalPecuario.EVECOMPFORMAY);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_EVECOMPFORJUN, GlobalPecuario.EVECOMPFORJUN);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_EVECOMPFORJUL, GlobalPecuario.EVECOMPFORJUL);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_EVECOMPFORAGO, GlobalPecuario.EVECOMPFORAGO);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_EVECOMPFORSEP, GlobalPecuario.EVECOMPFORSEP);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_EVECOMPFOROCT, GlobalPecuario.EVECOMPFOROCT);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_EVECOMPFORNOV, GlobalPecuario.EVECOMPFORNOV);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_EVECOMPFORDIC, GlobalPecuario.EVECOMPFORDIC);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_EVECOMPFORCOST, GlobalPecuario.EVECOMPFORCOST);


        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_EVEMANTPRADENE, GlobalPecuario.EVEMANTPRADENE);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_EVEMANTPRADFEB, GlobalPecuario.EVEMANTPRADFEB);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_EVEMANTPRADMAR, GlobalPecuario.EVEMANTPRADMAR);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_EVEMANTPRADABR, GlobalPecuario.EVEMANTPRADABR);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_EVEMANTPRADMAY, GlobalPecuario.EVEMANTPRADMAY);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_EVEMANTPRADJUN, GlobalPecuario.EVEMANTPRADJUN);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_EVEMANTPRADJUL, GlobalPecuario.EVEMANTPRADJUL);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_EVEMANTPRADAGO, GlobalPecuario.EVEMANTPRADAGO);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_EVEMANTPRADSEP, GlobalPecuario.EVEMANTPRADSEP);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_EVEMANTPRADOCT, GlobalPecuario.EVEMANTPRADOCT);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_EVEMANTPRADNOV, GlobalPecuario.EVEMANTPRADNOV);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_EVEMANTPRADDIC, GlobalPecuario.EVEMANTPRADDIC);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_EVEMANTPRADCOST, GlobalPecuario.EVEMANTPRADCOST);


        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_EVEALIMAGOSENE, GlobalPecuario.EVEALIMAGOSENE);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_EVEALIMAGOSFEB, GlobalPecuario.EVEALIMAGOSFEB);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_EVEALIMAGOSMAR, GlobalPecuario.EVEALIMAGOSMAR);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_EVEALIMAGOSABR, GlobalPecuario.EVEALIMAGOSABR);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_EVEALIMAGOSMAY, GlobalPecuario.EVEALIMAGOSMAY);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_EVEALIMAGOSJUN, GlobalPecuario.EVEALIMAGOSJUN);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_EVEALIMAGOSJUL, GlobalPecuario.EVEALIMAGOSJUL);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_EVEALIMAGOSAGO, GlobalPecuario.EVEALIMAGOSAGO);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_EVEALIMAGOSSEP, GlobalPecuario.EVEALIMAGOSSEP);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_EVEALIMAGOSOCT, GlobalPecuario.EVEALIMAGOSOCT);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_EVEALIMAGOSNOV, GlobalPecuario.EVEMANTPRADNOV);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_EVEALIMAGOSDIC, GlobalPecuario.EVEALIMAGOSDIC);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_EVEALIMAGOSCOST, GlobalPecuario.EVEALIMAGOSCOST);


        long result = db.insert(UtilidadesPecuario.TABLA_PECUARIO_EVEUNPRO, null, contentValues);
        db.close();
        if(result == -1) {
            return false;
        }else{
            return true;

        }

    }




    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Metodo para almacenar agregar alimentos pecuario
    public boolean addPecuagregalimcomp(){

        SQLiteDatabase db           = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(UtilidadesPecuario.COLUMN_FOLIOENC_PECAGREALPEC, General.Foliocuestion);

        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PECUALIMENTOCOM, GlobalPecuario.PECUALIMENTOCOM);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PECUALIMENTOCOTRO, GlobalPecuario.PECUALIMENTOCOTRO);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PECUALIMLUGCOMP, GlobalPecuario.PECUALIMLUGCOMP);
        contentValues.put(UtilidadesPecuario.COLUMN_ALIMGANADO_PECUALIMPRECCOMP, GlobalPecuario.PECUALIMPRECCOMP);


        long result = db.insert(UtilidadesPecuario.TABLA_PECUARIO_AGREALPEC, null, contentValues);
        db.close();
        if(result == -1) {
            return false;
        }else{
            return true;

        }

    }







    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Metodo para almacenar manejo de agostadero
    public boolean addPecumanejoagostadero(){

        SQLiteDatabase db           = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(UtilidadesPecuario.COLUMN_FOLIOENC_PECUMANAGOST, General.Foliocuestion);

        contentValues.put(UtilidadesPecuario.COLUMN_MANAGOSTADERO_PECUDIVPOTRERO, GlobalPecuario.PECUDIVPOTRERO);
        contentValues.put(UtilidadesPecuario.COLUMN_MANAGOSTADERO_PECUCERCOELECT, GlobalPecuario.PECUCERCOELECT);
        contentValues.put(UtilidadesPecuario.COLUMN_MANAGOSTADERO_PECUAJUSTCARGA, GlobalPecuario.PECUAJUSTCARGA);
        contentValues.put(UtilidadesPecuario.COLUMN_MANAGOSTADERO_PECUPASTROTACI, GlobalPecuario.PECUPASTROTACI);
        contentValues.put(UtilidadesPecuario.COLUMN_MANAGOSTADERO_PECUMANEJOEXTE, GlobalPecuario.PECUMANEJOEXTE);
        contentValues.put(UtilidadesPecuario.COLUMN_MANAGOSTADERO_PECUCONTABREVAD, GlobalPecuario.PECUCONTABREVAD);
        contentValues.put(UtilidadesPecuario.COLUMN_MANAGOSTADERO_PECUCANTIDABREV, GlobalPecuario.PECUCANTIDABREV);


        contentValues.put(UtilidadesPecuario.COLUMN_MANAGOSTADERO_PECUPRODFORREJ, GlobalPecuario.PECUPRODFORREJ);
        contentValues.put(UtilidadesPecuario.COLUMN_MANAGOSTADERO_PECUPRODCONCOM, GlobalPecuario.PECUPRODCONCOM);
        contentValues.put(UtilidadesPecuario.COLUMN_MANAGOSTADERO_PECUPRODENSILA, GlobalPecuario.PECUPRODENSILA);
        contentValues.put(UtilidadesPecuario.COLUMN_MANAGOSTADERO_PECUPRODMINERAL, GlobalPecuario.PECUPRODMINERAL);
        contentValues.put(UtilidadesPecuario.COLUMN_MANAGOSTADERO_PECUPRODGRANOS, GlobalPecuario.PECUPRODGRANOS);
        contentValues.put(UtilidadesPecuario.COLUMN_MANAGOSTADERO_PECUPRODUCOTROS, GlobalPecuario.PECUPRODUCOTROS);
        contentValues.put(UtilidadesPecuario.COLUMN_MANAGOSTADERO_PECUPRODUEDTOTR, GlobalPecuario.PECUPRODUEDTOTR);
        contentValues.put(UtilidadesPecuario.COLUMN_MANAGOSTADERO_PECUPRODUCNINGUN, GlobalPecuario.PECUPRODUCNINGUN);


        contentValues.put(UtilidadesPecuario.COLUMN_MANAGOSTADERO_PECUSEQPROLONG, GlobalPecuario.PECUSEQPROLONG);
        contentValues.put(UtilidadesPecuario.COLUMN_MANAGOSTADERO_PECUPOCADISPON, GlobalPecuario.PECUPOCADISPON);
        contentValues.put(UtilidadesPecuario.COLUMN_MANAGOSTADERO_PECUMUYCAROSADQ, GlobalPecuario.PECUMUYCAROSADQ);
        contentValues.put(UtilidadesPecuario.COLUMN_MANAGOSTADERO_PECUPOCOTERRENO, GlobalPecuario.PECUPOCOTERRENO);
        contentValues.put(UtilidadesPecuario.COLUMN_MANAGOSTADERO_PECUNOCONTRECUR, GlobalPecuario.PECUNOCONTRECUR);
        contentValues.put(UtilidadesPecuario.COLUMN_MANAGOSTADERO_PECUNOTENERCAPAC, GlobalPecuario.PECUNOTENERCAPAC);
        contentValues.put(UtilidadesPecuario.COLUMN_MANAGOSTADERO_PECUINSUFICMANOB, GlobalPecuario.PECUINSUFICMANOB);
        contentValues.put(UtilidadesPecuario.COLUMN_MANAGOSTADERO_PECUTIERRAPOCVAL, GlobalPecuario.PECUTIERRAPOCVAL);
        contentValues.put(UtilidadesPecuario.COLUMN_MANAGOSTADERO_PECUOTROPROBLEMF, GlobalPecuario.PECUOTROPROBLEMF);
        contentValues.put(UtilidadesPecuario.COLUMN_MANAGOSTADERO_PECUEDTOTPROBLEMF, GlobalPecuario.PECUEDTOTPROBLEMF);


        contentValues.put(UtilidadesPecuario.COLUMN_MANAGOSTADERO_PECUSUPLCOSTOCONC, GlobalPecuario.PECUSUPLCOSTOCONC);
        contentValues.put(UtilidadesPecuario.COLUMN_MANAGOSTADERO_PECUSUPLPOCDISPON, GlobalPecuario.PECUSUPLPOCDISPON);
        contentValues.put(UtilidadesPecuario.COLUMN_MANAGOSTADERO_PECUSUPLDIETNOBAL, GlobalPecuario.PECUSUPLDIETNOBAL);
        contentValues.put(UtilidadesPecuario.COLUMN_MANAGOSTADERO_PECUSUPLNOTENCONOC, GlobalPecuario.PECUSUPLNOTENCONOC);
        contentValues.put(UtilidadesPecuario.COLUMN_MANAGOSTADERO_PECUSUPLMUSCBLANCO, GlobalPecuario.PECUSUPLMUSCBLANCO);
        contentValues.put(UtilidadesPecuario.COLUMN_MANAGOSTADERO_PECUSUPLEMOTRO, GlobalPecuario.PECUSUPLEMOTRO);
        contentValues.put(UtilidadesPecuario.COLUMN_MANAGOSTADERO_PECUEDTSUPLOTROESP, GlobalPecuario.PECUEDTSUPLOTROESP);


        long result = db.insert(UtilidadesPecuario.TABLA_PECUARIO_MANEAGOSTAD, null, contentValues);
        db.close();
        if(result == -1) {
            return false;
        }else{
            return true;

        }

    }




    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Metodo para almacenar REPRODUCCION Y GENETICA
    public boolean addPecureproducgenetica(){

        SQLiteDatabase db           = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(UtilidadesPecuario.COLUMN_FOLIOENC_PECUREPRODGEN, General.Foliocuestion);

        contentValues.put(UtilidadesPecuario.COLUMN_REPRODGENETICA_REPRODMONTLIBRE, GlobalPecuario.REPRODMONTLIBRE);
        contentValues.put(UtilidadesPecuario.COLUMN_REPRODGENETICA_REPRODMONTCONTRL, GlobalPecuario.REPRODMONTCONTRL);
        contentValues.put(UtilidadesPecuario.COLUMN_REPRODGENETICA_REPRODMONTAINSEM, GlobalPecuario.REPRODMONTAINSEM);
        contentValues.put(UtilidadesPecuario.COLUMN_REPRODGENETICA_REPRODMONTAINSART, GlobalPecuario.REPRODMONTAINSART);
        contentValues.put(UtilidadesPecuario.COLUMN_REPRODGENETICA_REPRODSINCRHEMBR, GlobalPecuario.REPRODSINCRHEMBR);
        contentValues.put(UtilidadesPecuario.COLUMN_REPRODGENETICA_REPRODDIAGNGESTAC, GlobalPecuario.REPRODDIAGNGESTAC);
        contentValues.put(UtilidadesPecuario.COLUMN_REPRODGENETICA_REPRODFERTSEMENT, GlobalPecuario.REPRODFERTSEMENT);
        contentValues.put(UtilidadesPecuario.COLUMN_REPRODGENETICA_REPRODINSEMINPROD, GlobalPecuario.REPRODINSEMINPROD);
        contentValues.put(UtilidadesPecuario.COLUMN_REPRODGENETICA_REPRODOTROESPECIF, GlobalPecuario.REPRODOTROESPECIF);
        contentValues.put(UtilidadesPecuario.COLUMN_REPRODGENETICA_REPRODEDTOTROESPEC, GlobalPecuario.REPRODEDTOTROESPEC);

        contentValues.put(UtilidadesPecuario.COLUMN_REPRODGENETICA_REPRPROBPOCPART, GlobalPecuario.REPRPROBPOCPART);
        contentValues.put(UtilidadesPecuario.COLUMN_REPRODGENETICA_REPRPROBHEMBTCAR, GlobalPecuario.REPRPROBHEMBTCAR);
        contentValues.put(UtilidadesPecuario.COLUMN_REPRODGENETICA_REPRPROBABORTOS, GlobalPecuario.REPRPROBABORTOS);
        contentValues.put(UtilidadesPecuario.COLUMN_REPRODGENETICA_REPRPROBCOSTOTEC, GlobalPecuario.REPRPROBCOSTOTEC);
        contentValues.put(UtilidadesPecuario.COLUMN_REPRODGENETICA_REPRPROBCAPACINO, GlobalPecuario.REPRPROBCAPACINO);
        contentValues.put(UtilidadesPecuario.COLUMN_REPRODGENETICA_REPRPROBPOCADISP, GlobalPecuario.REPRPROBPOCADISP);
        contentValues.put(UtilidadesPecuario.COLUMN_REPRODGENETICA_REPRPROBOTROESPC, GlobalPecuario.REPRPROBOTROESPC);
        contentValues.put(UtilidadesPecuario.COLUMN_REPRODGENETICA_REPRPROBOTROEDTESP, GlobalPecuario.REPRPROBOTROEDTESP);

        contentValues.put(UtilidadesPecuario.COLUMN_REPRODGENETICA_REPRGENEVALSEM, GlobalPecuario.REPRGENEVALSEM);
        contentValues.put(UtilidadesPecuario.COLUMN_REPRODGENETICA_REPRGENADAPGAN, GlobalPecuario.REPRGENADAPGAN);
        contentValues.put(UtilidadesPecuario.COLUMN_REPRODGENETICA_REPRGENCAPCRUZ, GlobalPecuario.REPRGENCAPCRUZ);
        contentValues.put(UtilidadesPecuario.COLUMN_REPRODGENETICA_REPRGENDISPSEM, GlobalPecuario.REPRGENDISPSEM);
        contentValues.put(UtilidadesPecuario.COLUMN_REPRODGENETICA_REPRGENOTROPRO, GlobalPecuario.REPRGENOTROPRO);
        contentValues.put(UtilidadesPecuario.COLUMN_REPRODGENETICA_REPRGENEDTOTRO, GlobalPecuario.REPRGENEDTOTRO);

        contentValues.put(UtilidadesPecuario.COLUMN_REPRODGENETICA_PARAMHEMBPARIDO, GlobalPecuario.PARAMHEMBPARIDO);
        contentValues.put(UtilidadesPecuario.COLUMN_REPRODGENETICA_PARAMTIEMPOPART, GlobalPecuario.PARAMTIEMPOPART);
        contentValues.put(UtilidadesPecuario.COLUMN_REPRODGENETICA_PARAMEDADPPARTO, GlobalPecuario.PARAMEDADPPARTO);
        contentValues.put(UtilidadesPecuario.COLUMN_REPRODGENETICA_PARAMEDADDHEMBR, GlobalPecuario.PARAMEDADDHEMBR);
        contentValues.put(UtilidadesPecuario.COLUMN_REPRODGENETICA_PARAMNUMCRPPART, GlobalPecuario.PARAMNUMCRPPART);
        contentValues.put(UtilidadesPecuario.COLUMN_REPRODGENETICA_PARAMNUMPALANIO, GlobalPecuario.PARAMNUMPALANIO);
        contentValues.put(UtilidadesPecuario.COLUMN_REPRODGENETICA_PARAMPESONACERC, GlobalPecuario.PARAMPESONACERC);
        contentValues.put(UtilidadesPecuario.COLUMN_REPRODGENETICA_PARAMPESODESTET, GlobalPecuario.PARAMPESODESTET);
        contentValues.put(UtilidadesPecuario.COLUMN_REPRODGENETICA_PARAMEDADDESTET, GlobalPecuario.PARAMEDADDESTET);
        contentValues.put(UtilidadesPecuario.COLUMN_REPRODGENETICA_PARAMMORTDESTET, GlobalPecuario.PARAMMORTDESTET);
        contentValues.put(UtilidadesPecuario.COLUMN_REPRODGENETICA_PARAMPESOVENTAA, GlobalPecuario.PARAMPESOVENTAA);
        contentValues.put(UtilidadesPecuario.COLUMN_REPRODGENETICA_PARAMEDADVENTAA, GlobalPecuario.PARAMEDADVENTAA);
        contentValues.put(UtilidadesPecuario.COLUMN_REPRODGENETICA_PARAMNUMVIENTRE, GlobalPecuario.PARAMNUMVIENTRE);
        contentValues.put(UtilidadesPecuario.COLUMN_REPRODGENETICA_PARAMVOLLECHEDI, GlobalPecuario.PARAMVOLLECHEDI);
        contentValues.put(UtilidadesPecuario.COLUMN_REPRODGENETICA_PARAMNUMDORDENI, GlobalPecuario.PARAMNUMDORDENI);
        contentValues.put(UtilidadesPecuario.COLUMN_REPRODGENETICA_PARAMVOLPLECHEV, GlobalPecuario.PARAMVOLPLECHEV);
        contentValues.put(UtilidadesPecuario.COLUMN_REPRODGENETICA_PARAMNUMCRIASAN, GlobalPecuario.PARAMNUMCRIASAN);
        contentValues.put(UtilidadesPecuario.COLUMN_REPRODGENETICA_PARAMNUMHEMRANI, GlobalPecuario.PARAMNUMHEMRANI);


        long result = db.insert(UtilidadesPecuario.TABLA_PECUARIO_REPRODGENETICA, null, contentValues);
        db.close();
        if(result == -1) {
            return false;
        }else{
            return true;

        }

    }










    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Metodo para almacenar MANEJO SANITARIO GANADO
    public boolean addPecumanejosanganado(){

        SQLiteDatabase db           = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(UtilidadesPecuario.COLUMN_FOLIOENC_PECUMANEJSANGAN, General.Foliocuestion);

        contentValues.put(UtilidadesPecuario.COLUMN_MANEJSANGAN_MANEJOSANCAMZOO, GlobalPecuario.MANEJOSANCAMZOO);
        contentValues.put(UtilidadesPecuario.COLUMN_MANEJSANGAN_MANEJOSANTUBERC, GlobalPecuario.MANEJOSANTUBERC);
        contentValues.put(UtilidadesPecuario.COLUMN_MANEJSANGAN_MANEJOSANRABIAP, GlobalPecuario.MANEJOSANRABIAP);
        contentValues.put(UtilidadesPecuario.COLUMN_MANEJSANGAN_MANEJOSANGARRAP, GlobalPecuario.MANEJOSANGARRAP);
        contentValues.put(UtilidadesPecuario.COLUMN_MANEJSANGAN_MANEJOSANBRUCEL, GlobalPecuario.MANEJOSANBRUCEL);
        contentValues.put(UtilidadesPecuario.COLUMN_MANEJSANGAN_MANEJOSANOTROCA, GlobalPecuario.MANEJOSANOTROCA);
        contentValues.put(UtilidadesPecuario.COLUMN_MANEJSANGAN_MANEJOSANEDTOTR, GlobalPecuario.MANEJOSANEDTOTR);


        contentValues.put(UtilidadesPecuario.COLUMN_MANEJSANGAN_MANEJOSANPROVAC, GlobalPecuario.MANEJOSANPROVAC);
        contentValues.put(UtilidadesPecuario.COLUMN_MANEJSANGAN_MANEJOSANNEUMON, GlobalPecuario.MANEJOSANNEUMON);
        contentValues.put(UtilidadesPecuario.COLUMN_MANEJSANGAN_MANEJOSANDOBLEV, GlobalPecuario.MANEJOSANDOBLEV);
        contentValues.put(UtilidadesPecuario.COLUMN_MANEJSANGAN_MANEJOSANTRIPLE, GlobalPecuario.MANEJOSANTRIPLE);
        contentValues.put(UtilidadesPecuario.COLUMN_MANEJSANGAN_MANEJOSANCLOSTR, GlobalPecuario.MANEJOSANCLOSTR);
        contentValues.put(UtilidadesPecuario.COLUMN_MANEJSANGAN_MANEJOSANDERRIE, GlobalPecuario.MANEJOSANDERRIE);
        contentValues.put(UtilidadesPecuario.COLUMN_MANEJSANGAN_MANEJOSANLEPTOS, GlobalPecuario.MANEJOSANLEPTOS);
        contentValues.put(UtilidadesPecuario.COLUMN_MANEJSANGAN_MANEJOSANOTRAVA, GlobalPecuario.MANEJOSANOTRAVA);
        contentValues.put(UtilidadesPecuario.COLUMN_MANEJSANGAN_MANEJOSANEDTOTV, GlobalPecuario.MANEJOSANEDTOTV);


        contentValues.put(UtilidadesPecuario.COLUMN_MANEJSANGAN_MANEJOSANCGARRA, GlobalPecuario.MANEJOSANCGARRA);
        contentValues.put(UtilidadesPecuario.COLUMN_MANEJSANGAN_MANEJOSANCONGAR, GlobalPecuario.MANEJOSANCONGAR);
        contentValues.put(UtilidadesPecuario.COLUMN_MANEJSANGAN_MANEJOSANGAREOT, GlobalPecuario.MANEJOSANGAREOT);
        contentValues.put(UtilidadesPecuario.COLUMN_MANEJSANGAN_MANEJOSANGARCOS, GlobalPecuario.MANEJOSANGARCOS);


        contentValues.put(UtilidadesPecuario.COLUMN_MANEJSANGAN_MANEJOSANANAPAR, GlobalPecuario.MANEJOSANANAPAR);
        contentValues.put(UtilidadesPecuario.COLUMN_MANEJSANGAN_MANEJOSANFREDES, GlobalPecuario.MANEJOSANFREDES);
        contentValues.put(UtilidadesPecuario.COLUMN_MANEJSANGAN_MANEJOSANFREOTR, GlobalPecuario.MANEJOSANFREOTR);


        contentValues.put(UtilidadesPecuario.COLUMN_MANEJSANGAN_MANEJOSANPERPAR, GlobalPecuario.MANEJOSANPERPAR);
        contentValues.put(UtilidadesPecuario.COLUMN_MANEJSANGAN_MANEJOSANABORTO, GlobalPecuario.MANEJOSANABORTO);
        contentValues.put(UtilidadesPecuario.COLUMN_MANEJSANGAN_MANEJOSANDIARRE, GlobalPecuario.MANEJOSANDIARRE);
        contentValues.put(UtilidadesPecuario.COLUMN_MANEJSANGAN_MANEJOSANSEPTIC, GlobalPecuario.MANEJOSANSEPTIC);
        contentValues.put(UtilidadesPecuario.COLUMN_MANEJSANGAN_MANEJOSANENFRES, GlobalPecuario.MANEJOSANENFRES);
        contentValues.put(UtilidadesPecuario.COLUMN_MANEJSANGAN_MANEJOSANMASTIT, GlobalPecuario.MANEJOSANMASTIT);
        contentValues.put(UtilidadesPecuario.COLUMN_MANEJSANGAN_MANEJOSANRABIAD, GlobalPecuario.MANEJOSANRABIAD);
        contentValues.put(UtilidadesPecuario.COLUMN_MANEJSANGAN_MANEJOSANOCULAR, GlobalPecuario.MANEJOSANOCULAR);
        contentValues.put(UtilidadesPecuario.COLUMN_MANEJSANGAN_MANEJOSANGABARR, GlobalPecuario.MANEJOSANGABARR);
        contentValues.put(UtilidadesPecuario.COLUMN_MANEJSANGAN_MANEJOSANECTIMA, GlobalPecuario.MANEJOSANECTIMA);
        contentValues.put(UtilidadesPecuario.COLUMN_MANEJSANGAN_MANEJOSANPARASA, GlobalPecuario.MANEJOSANPARASA);
        contentValues.put(UtilidadesPecuario.COLUMN_MANEJSANGAN_MANEJOSANOTROPR, GlobalPecuario.MANEJOSANOTROPR);
        contentValues.put(UtilidadesPecuario.COLUMN_MANEJSANGAN_MANEJOSANPREDTO, GlobalPecuario.MANEJOSANPREDTO);


        contentValues.put(UtilidadesPecuario.COLUMN_MANEJSANGAN_MANEJOSANBAJFER, GlobalPecuario.MANEJOSANBAJFER);
        contentValues.put(UtilidadesPecuario.COLUMN_MANEJSANGAN_MANEJOSANEDADDE, GlobalPecuario.MANEJOSANEDADDE);
        contentValues.put(UtilidadesPecuario.COLUMN_MANEJSANGAN_MANEJOSANBAJPRO, GlobalPecuario.MANEJOSANBAJPRO);
        contentValues.put(UtilidadesPecuario.COLUMN_MANEJSANGAN_MANEJOSANENFERM, GlobalPecuario.MANEJOSANENFERM);
        contentValues.put(UtilidadesPecuario.COLUMN_MANEJSANGAN_MANEJOSANTEMPER, GlobalPecuario.MANEJOSANTEMPER);
        contentValues.put(UtilidadesPecuario.COLUMN_MANEJSANGAN_MANEJOSANPROPAT, GlobalPecuario.MANEJOSANPROPAT);
        contentValues.put(UtilidadesPecuario.COLUMN_MANEJSANGAN_MANEJOSANOTRODE, GlobalPecuario.MANEJOSANOTRODE);
        contentValues.put(UtilidadesPecuario.COLUMN_MANEJSANGAN_MANEJOSANEDTODE, GlobalPecuario.MANEJOSANEDTODE);


        contentValues.put(UtilidadesPecuario.COLUMN_MANEJSANGAN_MANEJOSANCOSTME, GlobalPecuario.MANEJOSANCOSTME);
        contentValues.put(UtilidadesPecuario.COLUMN_MANEJSANGAN_MANEJOSANCAPCEN, GlobalPecuario.MANEJOSANCAPCEN);
        contentValues.put(UtilidadesPecuario.COLUMN_MANEJSANGAN_MANEJOSANREGINF, GlobalPecuario.MANEJOSANREGINF);
        contentValues.put(UtilidadesPecuario.COLUMN_MANEJSANGAN_MANEJOSANDISVET, GlobalPecuario.MANEJOSANDISVET);
        contentValues.put(UtilidadesPecuario.COLUMN_MANEJSANGAN_MANEJOSANCOSVET, GlobalPecuario.MANEJOSANCOSVET);
        contentValues.put(UtilidadesPecuario.COLUMN_MANEJSANGAN_MANEJOSANDIAGSI, GlobalPecuario.MANEJOSANDIAGSI);
        contentValues.put(UtilidadesPecuario.COLUMN_MANEJSANGAN_MANEJOSANOTROSA, GlobalPecuario.MANEJOSANOTROSA);
        contentValues.put(UtilidadesPecuario.COLUMN_MANEJSANGAN_MANEJOSANEDTOSA, GlobalPecuario.MANEJOSANEDTOSA);


        long result = db.insert(UtilidadesPecuario.TABLA_PECUARIO_MANEJSANGAN, null, contentValues);
        db.close();
        if(result == -1) {
            return false;
        }else{
            return true;

        }

    }



    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Metodo para almacenar Pecuario MANEJO SANITARIO ORDEÑA
    public boolean addPecumanejordenia(){

        SQLiteDatabase db           = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(UtilidadesPecuario.COLUMN_FOLIOENC_PECMANSANOR, General.Foliocuestion);

        contentValues.put(UtilidadesPecuario.COLUMN_MANSANOR_MANEJOSANDIAMAS, GlobalPecuario.MANEJOSANDIAMAS);
        contentValues.put(UtilidadesPecuario.COLUMN_MANSANOR_MANEJOSANEDTMAS, GlobalPecuario.MANEJOSANEDTMAS);
        contentValues.put(UtilidadesPecuario.COLUMN_MANSANOR_MANEJOSANCOSTPR, GlobalPecuario.MANEJOSANCOSTPR);

        contentValues.put(UtilidadesPecuario.COLUMN_MANSANOR_MANEJOSANLAVUBR, GlobalPecuario.MANEJOSANLAVUBR);
        contentValues.put(UtilidadesPecuario.COLUMN_MANSANOR_MANEJOSANSECDES, GlobalPecuario.MANEJOSANSECDES);
        contentValues.put(UtilidadesPecuario.COLUMN_MANSANOR_MANEJOSANDESPUN, GlobalPecuario.MANEJOSANDESPUN);
        contentValues.put(UtilidadesPecuario.COLUMN_MANSANOR_MANEJOSANUSOSEL, GlobalPecuario.MANEJOSANUSOSEL);
        contentValues.put(UtilidadesPecuario.COLUMN_MANSANOR_MANEJOSANAPLANT, GlobalPecuario.MANEJOSANAPLANT);
        contentValues.put(UtilidadesPecuario.COLUMN_MANSANOR_MANEJOSANOTRORD, GlobalPecuario.MANEJOSANOTRORD);
        contentValues.put(UtilidadesPecuario.COLUMN_MANSANOR_MANEJOSANEDTOOR, GlobalPecuario.MANEJOSANEDTOOR);
        contentValues.put(UtilidadesPecuario.COLUMN_MANSANOR_MANEJOSANNINORD, GlobalPecuario.MANEJOSANNINORD);
        contentValues.put(UtilidadesPecuario.COLUMN_MANSANOR_MANEJOSANCOSTOR, GlobalPecuario.MANEJOSANCOSTOR);

        long result = db.insert(UtilidadesPecuario.TABLA_PECUARIO_MANSANOR, null, contentValues);
        db.close();
        if(result == -1) {
            return false;
        }else{
            return true;

        }

    }

    public boolean addPasl_operativo(Pasl_o_Model model){

        SQLiteDatabase db           = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(pasl_operativo_bd.COLUMN_FOLIO, model.getFolio());
        contentValues.put(pasl_operativo_bd.COLUMN_FECHA, model.getFecha());
        contentValues.put(pasl_operativo_bd.COLUMN_ESTADO, model.getEstado());
        contentValues.put(pasl_operativo_bd.COLUMN_MUNICIPIO, model.getMunicipio());
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
        //contentValues.put(pasl_operativo_bd.COLUMN_DOCEOBSERVACIONES, model.getDoce_bservaciones());
        contentValues.put(pasl_operativo_bd.COLUMN_TRECE, model.getTrece());

        long result = db.insert(pasl_operativo_bd.TABLA_BD, null, contentValues);
        db.close();

        if(result == -1) {
            return false;
        }else{
            return true;
        }

    }






    public Cursor getListaModulosFaltantes(){
        SQLiteDatabase db = this.getReadableDatabase();

        String sql = "SELECT * FROM " + Utilidades.TABLA_GEORREFERENCIA + ";";
        Cursor c = db.rawQuery(sql, null);
        return c;
    }

}
