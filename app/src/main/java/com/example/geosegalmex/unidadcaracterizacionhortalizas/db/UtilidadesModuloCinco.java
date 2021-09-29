package com.example.geosegalmex.unidadcaracterizacionhortalizas.db;

public class UtilidadesModuloCinco {

    public static final String TABLA_HORTALIZAS = "TbHORTALIZAS";
    public static final String COLUMN_IDHORTAL = "IDHORTAL";    //	Integer
    public static final String COLUMN_FOLIO = "FOLIO";    //	Text
    public static final String COLUMN_CICPRO = "CICPRO";    //	Text
    public static final String COLUMN_IDCAPTURISTA	= "IDCAPTURISTA";
    public static final String COLUMN_CUCHORT = "CUCHORT";    //	Text
    public static final String COLUMN_CUCHORTO = "CUCHORTO";    //	Text
    public static final String COLUMN_MOTSEMH = "MOTSEMH";    //	Text
    public static final String COLUMN_MOTSEMHO = "MOTSEMHO";    //	Text
    public static final String COLUMN_ASOCULT = "ASOCULT";    //	Text
    public static final String COLUMN_OTRCULT = "OTRCULT";    //	Text
    public static final String COLUMN_ASECULT = "ASECULT";    //	Text
    public static final String COLUMN_CUCULT = "CUCULT";    //	Text
    public static final String COLUMN_FECHOR = "FECHOR";    //	Text
    public static final String COLUMN_SUPSEMHOstr = "SUPSEMHOstr"; //Text Agregar a la base
    public static final String COLUMN_SUPSEMHO = "SUPSEMHO";    //	Integer
    public static final String COLUMN_SUPMECOIHOstr = "SUPMECOIHOstr";    //Text Agregar  la base
    public static final String COLUMN_SUPMECOIHO = "SUPMECOIHO";    //	Integer
    public static final String COLUMN_SUPNMECHOstr = "SUPNMECHOstr";    //	Integer
    public static final String COLUMN_SUPNMECHO = "SUPNMECHO";    //	Integer
    public static final String COLUMN_INFRHORT = "INFRHORT";    //	Text
    public static final String COLUMN_INFRHORTA = "INFRHORTA";    //	Text
    public static final String COLUMN_SINIHOR = "SINIHOR";    //	Text
    public static final String COLUMN_CAUSINIH = "CAUSINIH";    //	Text
    public static final String COLUMN_TIPSEMPRO = "TIPSEMPRO";    //	Text
    public static final String COLUMN_PREKGPRO = "PREKGPRO";    //	Text
    public static final String COLUMN_CANTSEPRO = "CANTSEPRO";    //	Integer
    public static final String COLUMN_TIPSEMCROT = "TIPSEMCROT";    //	Text
    public static final String COLUMN_PREKGCROT = "PREKGCROT";    //	Text
    public static final String COLUMN_CANTSECROT = "CANTSECROT";    //	Integer
    public static final String COLUMN_TIPSEMCER = "TIPSEMCER";    //	Text
    public static final String COLUMN_SEMCERNOM = "SEMCERNOM";    //	Text
    public static final String COLUMN_PREKGCER = "PREKGCER";    //	Text
    public static final String COLUMN_CANTSECER = "CANTSECER";    //	Integer
    public static final String COLUMN_VARSEHOOI = "VARSEHOOI";    //	Text
    public static final String COLUMN_SELSEOI = "SELSEOI";    //	Text
    public static final String COLUMN_DENSOI = "DENSOI";    //	Integer
    public static final String COLUMN_SIEMOI = "SIEMOI";    //	Text
    public static final String COLUMN_SIEMOOI = "SIEMOOI";    //	Text
    public static final String COLUMN_PREJOROI = "PREJOROI";    //	Integer
    public static final String COLUMN_ANAFERHO = "ANAFERHO";    //	Texto
    public static final String COLUMN_SUELHO = "SUELHO";    //	Texto
    public static final String COLUMN_PRESUELHO = "PRESUELHO";    //	Integer
    public static final String COLUMN_FOLHO = "FOLHO";    //	Texto
    public static final String COLUMN_PREFOLHO = "PREFOLHO";    //	Integer
    public static final String COLUMN_AGUAHO = "AGUAHO";    //	Texto
    public static final String COLUMN_PREAGUAHO = "PREAGUAHO";    //	Integer
    public static final String COLUMN_TIPFERHOR = "TIPFERHOR";    //	Text
    //public static final String	COLUMN_METHORT	="METHORT";	//	Text
    //public static final String	COLUMN_METHORTA	="METHORTA";	//	Text
    public static final String COLUMN_APPFOLH = "APPFOLH";    //	Text
    public static final String COLUMN_APPFOLHPV = "APPFOLHPV";    //	Text
    public static final String COLUMN_RIEHORT = "RIEHORT";    //	Text
    public static final String COLUMN_SISRIEGR = "SISRIEGR";    //	Text
    public static final String COLUMN_SISHORTPV = "SISHORTPV";    //	Text
    public static final String COLUMN_FRERIEGR = "FRERIEGR";    //	Text
    public static final String COLUMN_PLAENHPV = "PLAENHPV";    //	Text
    public static final String COLUMN_PLAGNUEVA = "PLAGNUEVA";    //	Text
    public static final String COLUMN_UMPQUIPV = "UMPQUIPV";    //	Text
    public static final String COLUMN_NIVCSH = "NIVCSH";    //	Text
    public static final String COLUMN_ORPLENPV = "ORPLENPV";    //	Text
    public static final String COLUMN_ORPLAOTRO = "ORPLAOTRO";    //	Text
    public static final String COLUMN_CBIOMPE = "CBIOMPE";    //	Text
    public static final String COLUMN_INOHOR = "INOHOR";    //	Text
    public static final String COLUMN_INOHORTIP = "INOHORTIP";    //	Texto
    public static final String COLUMN_NUMCHO = "NUMCHO";    //	Integer
    public static final String COLUMN_MPHORT = "MPHORT";    //	Texto
    public static final String COLUMN_MPHORTOTRO = "MPHORTOTRO";    //	Texto

    public static final String CREAR_TABLA_HORTALIZAS = "CREATE TABLE " + TABLA_HORTALIZAS +
            "(" + COLUMN_IDHORTAL +
            " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_FOLIO +
            " VARCHAR, " + COLUMN_IDCAPTURISTA	+ // IntegerNúmero del capturista
            " VARCHAR, " + COLUMN_CICPRO +
            " VARCHAR, " + COLUMN_CUCHORT +
            " VARCHAR, " + COLUMN_CUCHORTO +
            " VARCHAR, " + COLUMN_MOTSEMH +
            " VARCHAR, " + COLUMN_MOTSEMHO +
            " VARCHAR, " + COLUMN_ASOCULT +
            " VARCHAR, " + COLUMN_OTRCULT +
            " VARCHAR, " + COLUMN_ASECULT +
            " VARCHAR, " + COLUMN_CUCULT +
            " VARCHAR, " + COLUMN_FECHOR +
            " VARCHAR, " + COLUMN_SUPSEMHOstr +
            " VARCHAR, " + COLUMN_SUPSEMHO +
            " VARCHAR, " + COLUMN_SUPMECOIHOstr +
            " VARCHAR, " + COLUMN_SUPMECOIHO +
            " VARCHAR, " + COLUMN_SUPNMECHOstr +
            " VARCHAR, " + COLUMN_SUPNMECHO +
            " VARCHAR, " + COLUMN_INFRHORT +
            " VARCHAR, " + COLUMN_INFRHORTA +
            " VARCHAR, " + COLUMN_SINIHOR +
            " VARCHAR, " + COLUMN_CAUSINIH +
            " VARCHAR, " + COLUMN_TIPSEMPRO +
            " VARCHAR, " + COLUMN_PREKGPRO +
            " VARCHAR, " + COLUMN_CANTSEPRO +
            " VARCHAR, " + COLUMN_TIPSEMCROT +
            " VARCHAR, " + COLUMN_PREKGCROT +
            " VARCHAR, " + COLUMN_CANTSECROT +
            " VARCHAR, " + COLUMN_TIPSEMCER +
            " VARCHAR, " + COLUMN_SEMCERNOM +
            " VARCHAR, " + COLUMN_PREKGCER +
            " VARCHAR, " + COLUMN_CANTSECER +
            " VARCHAR, " + COLUMN_VARSEHOOI +
            " VARCHAR, " + COLUMN_SELSEOI +
            " VARCHAR, " + COLUMN_DENSOI +
            " VARCHAR, " + COLUMN_SIEMOI +
            " VARCHAR, " + COLUMN_SIEMOOI +
            " VARCHAR, " + COLUMN_PREJOROI +
            " VARCHAR, " + COLUMN_ANAFERHO +
            " VARCHAR, " + COLUMN_SUELHO +
            " VARCHAR, " + COLUMN_PRESUELHO +
            " VARCHAR, " + COLUMN_FOLHO +
            " VARCHAR, " + COLUMN_PREFOLHO +
            " VARCHAR, " + COLUMN_AGUAHO +
            " VARCHAR, " + COLUMN_PREAGUAHO +
            " VARCHAR, " + COLUMN_TIPFERHOR +
            " VARCHAR, " + COLUMN_APPFOLH +
            " VARCHAR, " + COLUMN_APPFOLHPV +
            " VARCHAR, " + COLUMN_RIEHORT +
            " VARCHAR, " + COLUMN_SISRIEGR +
            " VARCHAR, " + COLUMN_SISHORTPV +
            " VARCHAR, " + COLUMN_FRERIEGR +
            " VARCHAR, " + COLUMN_PLAENHPV +
            " VARCHAR, " + COLUMN_PLAGNUEVA +
            " VARCHAR, " + COLUMN_UMPQUIPV +
            " VARCHAR, " + COLUMN_NIVCSH +
            " VARCHAR, " + COLUMN_ORPLENPV +
            " VARCHAR, " + COLUMN_ORPLAOTRO +
            " VARCHAR, " + COLUMN_CBIOMPE +
            " VARCHAR, " + COLUMN_INOHOR +
            " VARCHAR, " + COLUMN_INOHORTIP +
            " VARCHAR, " + COLUMN_NUMCHO +
            " VARCHAR, " + COLUMN_MPHORT +
            " VARCHAR, " + COLUMN_MPHORTOTRO +
            " VARCHAR);";

    //TABLA PREPARACION DEL SUELO

    public static final String TABLA_PREPARACIONSUELO = "TbHORTALIZASSUELO";
    public static final String COLUMN_IDPREPSUEL = "IDPREPSUEL";
    //public static final String COLUMN_FOLIO = "FOLIO";
    public static final String COLUMN_TIPOCULTIV = "TIPOCULTIV";
    public static final String COLUMN_CICLOPROD = "CICLOPROD";
    public static final String COLUMN_LABPRES = "LABPRES";
    public static final String COLUMN_NUMVL = "NUMVL";
    public static final String COLUMN_EQUIPOL = "EQUIPOL";
    public static final String COLUMN_COSTOL = "COSTOL";
    public static final String COLUMN_NUMJORL = "NUMJORL";

    public static final String CREAR_TABLA_PREPARSUELO = "CREATE TABLE " + TABLA_PREPARACIONSUELO +
            "(" + COLUMN_IDPREPSUEL +
            " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_FOLIO +
            " VARCHAR, " + COLUMN_IDCAPTURISTA	+ // IntegerNúmero del capturista
            " VARCHAR, " + COLUMN_TIPOCULTIV +
            " VARCHAR, " + COLUMN_CICLOPROD +
            " VARCHAR, " + COLUMN_LABPRES +
            " VARCHAR, " + COLUMN_NUMVL +
            " VARCHAR, " + COLUMN_EQUIPOL +
            " VARCHAR, " + COLUMN_COSTOL +
            " VARCHAR, " + COLUMN_NUMJORL +
            " VARCHAR);";


    public static final String  TABLA_FERTILIZANTE= "TbHORTALIZASFERTIL";
    public static final String COLUMN_IDFERTIL	= "IDFERTIL"; //	Integer
    //public static final String COLUMN_FOLIO	=	"FOLIO"; //	Text
    //public static final String COLUMN_TIPOCULTIV	=	"TIPOCULTIV"; //	Text
    public static final String COLUMN_FERTGRA	= "FERTGRA"; //	Text
    public static final String COLUMN_EFFRUT	= "EFFRUT"; //	Text
    public static final String COLUMN_FERAPPG	= "FERAPPG"; //	Text
    public static final String COLUMN_FERCANG	= "FERCANG"; //	Integer
    public static final String COLUMN_FERCOSG	= "FERCOSG"; //	Integer
    public static final String COLUMN_FERJORG	= "FERJORG"; //	Integer
    public static final String COLUMN_METHORT	= "METHORT"; //	Text
    // public static final String COLUMN_METHORTA	= "METHORTA"; //	Text

    public static final String CREAR_TABLA_FERTIL = "CREATE TABLE " + TABLA_FERTILIZANTE +
            "(" + COLUMN_IDFERTIL +
            " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_FOLIO +
            " VARCHAR, " + COLUMN_IDCAPTURISTA	+ // IntegerNúmero del capturista
            " VARCHAR, " + COLUMN_CICPRO +
            " VARCHAR, " + COLUMN_TIPOCULTIV +
            " VARCHAR, " + COLUMN_FERTGRA +
            " VARCHAR, " + COLUMN_EFFRUT +
            " VARCHAR, " + COLUMN_FERAPPG +
            " VARCHAR, " + COLUMN_FERCANG +
            " VARCHAR, " + COLUMN_FERCOSG +
            " VARCHAR, " + COLUMN_FERJORG +
            " VARCHAR, " + COLUMN_METHORT +
            " VARCHAR);";


    //
    public static final String  TABLA_RIEGO= "TbHORTALIZASRIEGO";
    public static final String COLUMN_IDRIEGO	=	"IDRIEGO"; //	Integer
    //public static final String COLUMN_FOLIO	=	"FOLIO"; //	Text
    //public static final String COLUMN_TIPOCULTIV	=	"TIPOCULTIV"; //	Text
    public static final String COLUMN_NUMRIEGR	=	"NUMRIEGR"; //	Integer
    public static final String COLUMN_RIECOSGR	=	"RIECOSGR"; //	Text
    public static final String COLUMN_JORGR	=	"JORGR"; //	Integer
    // public static final String COLUMN_CANRIEGR	=	"CANRIEGR"; //	Integer Integer Campo abierto. Este campo es solo para Cultivo Agrícola

    public static final String CREAR_TABLA_RIEGO = "CREATE TABLE " + TABLA_RIEGO +
            "(" + COLUMN_IDRIEGO +
            " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_FOLIO +
            " VARCHAR, " + COLUMN_IDCAPTURISTA	+ // IntegerNúmero del capturista
            " VARCHAR, " + COLUMN_CICPRO +
            " VARCHAR, " + COLUMN_TIPOCULTIV +
            " VARCHAR, " + COLUMN_NUMRIEGR +
            " VARCHAR, " + COLUMN_RIECOSGR +
            " VARCHAR, " + COLUMN_JORGR +
            " VARCHAR);";
    //       " VARCHAR, " + COLUMN_CANRIEGR +
    //
    //
    //
    public static final String  TABLA_MALAHIERBA= "TbHORTALIZASMALAHIERBA";
    public static final String COLUMN_IDHIERBA	=	"IDHIERBA"; //	Integer
    // public static final String COLUMN_FOLIO	=	"FOLIO"; //	Text
    // public static final String COLUMN_TIPOCULTIV	=	"TIPOCULTIV"; //	Text
    public static final String COLUMN_MALGR	=	"MALGR"; //	Text
    // public static final String COLUMN_NCFRU	=	"NCFRU"; //	Text  Campo abierto. Campo sólo para Frutales.
    public static final String COLUMN_CONQMGR	=	"CONQMGR"; //	Text
    public static final String COLUMN_HERGR	=	"HERGR"; //	Text
    public static final String COLUMN_HERCANGR	=	"HERCANGR"; //	Integer
    // public static final String COLUMN_SUPAPFRU	=	"SUPAPFRU"; //	Integer Campo abierto. Campo sólo para Frutales.
    public static final String COLUMN_HJORGR	=	"HJORGR"; //	Integer
    public static final String COLUMN_CHERGR	=	"CHERGR"; //	Text


    public static final String CREAR_TABLA_MALAHIERBA = "CREATE TABLE " + TABLA_MALAHIERBA+
            "(" + COLUMN_IDHIERBA +
            " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_FOLIO +
            " VARCHAR, " + COLUMN_IDCAPTURISTA	+ // IntegerNúmero del capturista
            " VARCHAR, " + COLUMN_CICPRO +
            " VARCHAR, " + COLUMN_TIPOCULTIV +
            " VARCHAR, " + COLUMN_MALGR +
            " VARCHAR, " + COLUMN_CONQMGR +
            " VARCHAR, " + COLUMN_HERGR +
            " VARCHAR, " + COLUMN_HERCANGR +
            " VARCHAR, " + COLUMN_HJORGR +
            " VARCHAR, " + COLUMN_CHERGR +
            " VARCHAR);";

   /*
    public static final String CREAR_TABLA_MALAHIERBA = "CREATE TABLE " + TABLA_MALAHIERBA+
            "(" + COLUMN_IDHIERBA +
            " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_FOLIO +
            " VARCHAR, " + COLUMN_TIPOCULTIV +
            " VARCHAR, " + COLUMN_MALGR +
            " VARCHAR, " + COLUMN_NCFRU +   //Campo abierto. Campo sólo para Frutales.
            " VARCHAR, " + COLUMN_CONQMGR +
            " VARCHAR, " + COLUMN_HERGR +
            " VARCHAR, " + COLUMN_HERCANGR +
            " VARCHAR, " + COLUMN_SUPAPFRU + //Campo abierto. Campo sólo para Frutales.
            " VARCHAR, " + COLUMN_HJORGR +
            " VARCHAR, " + COLUMN_CHERGR +
            " VARCHAR);";


    */

    //
    //
    //
    //
    public static final String  TABLA_PLAGASENFER= "TbHORTALIZASPLAGASENFER";
    public static final String COLUMN_IDPLAGA	=	"IDPLAGA"; //	Integer
    //public static final String COLUMN_FOLIO	=	"FOLIO"; //	Text
    //public static final String COLUMN_TIPOCULTIV	=	"TIPOCULTIV"; //	Text
    public static final String COLUMN_PLAGA	=	"PLAGA"; //	Text
    public static final String COLUMN_PLATIPCOT	=	"PLATIPCOT"; //	Text
    public static final String COLUMN_PLATCOGR	=	"PLATCOGR"; //	Text
    public static final String COLUMN_PLAPROGR	=	"PLAPROGR"; //	Text
    public static final String COLUMN_PLACANTGR	=	"PLACANTGR"; //	Integer
    public static final String COLUMN_SUPHOR	=	"SUPHOR"; //	Integer
    public static final String COLUMN_PEJORGR	=	"PEJORGR"; //	Integer
    public static final String COLUMN_INSPROGR	=	"INSPROGR"; //	Text

    public static final String CREAR_TABLA_PLAGASENFERM = "CREATE TABLE " + TABLA_PLAGASENFER+
            "(" + COLUMN_IDPLAGA +
            " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_FOLIO +
            " VARCHAR, " + COLUMN_IDCAPTURISTA	+ // IntegerNúmero del capturista
            " VARCHAR, " + COLUMN_CICPRO +
            " VARCHAR, " + COLUMN_TIPOCULTIV +
            " VARCHAR, " + COLUMN_PLAGA +
            " VARCHAR, " + COLUMN_PLATIPCOT +
            " VARCHAR, " + COLUMN_PLATCOGR +
            " VARCHAR, " + COLUMN_PLAPROGR +
            " VARCHAR, " + COLUMN_PLACANTGR +
            " VARCHAR, " + COLUMN_SUPHOR +
            " VARCHAR, " + COLUMN_PEJORGR +
            " VARCHAR, " + COLUMN_INSPROGR +
            " VARCHAR);";
    //
    //
    //
    public static final String  TABLA_COSECHA= "TbHORTALIZASCOSECHA";
    public static final String COLUMN_IDCOSECHA	=	"IDCOSECHA"; //	Integer
    //public static final String COLUMN_FOLIO	=	"FOLIO"; //	Text
    //public static final String COLUMN_TIPOCULTIV	=	"TIPOCULTIV"; //	Text
    public static final String COLUMN_ACTCOSECH	=	"ACTCOSECH"; //	Text
    public static final String COLUMN_JORCOSGR	=	"JORCOSGR"; //	Integer

    public static final String CREAR_TABLA_COSECHA = "CREATE TABLE " + TABLA_COSECHA+
            "(" + COLUMN_IDCOSECHA +
            " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_FOLIO +
            " VARCHAR, " + COLUMN_IDCAPTURISTA	+ // IntegerNúmero del capturista
            " VARCHAR, " + COLUMN_CICPRO +
            " VARCHAR, " + COLUMN_TIPOCULTIV +
            " VARCHAR, " + COLUMN_ACTCOSECH +
            " VARCHAR, " + COLUMN_JORCOSGR +
            " VARCHAR);";

    //
    //
    //
    public static final String  TABLA_EMPAQUE = "TbHORTALIZASEMPAQUE";
    public static final String COLUMN_IDEMPAQ	=	"IDEMPAQ"; //	Integer
    //public static final String COLUMN_FOLIO	=	"FOLIO"; //	Text
    //public static final String COLUMN_TIPOCULTIV	=	"TIPOCULTIV"; //	Text
    public static final String COLUMN_EMPHOR	=	"EMPHOR"; //	Text
    public static final String COLUMN_EMPHORO	=	"EMPHORO"; //	Text
    public static final String COLUMN_COUNIHPV	=	"COUNIHPV"; //	Integer

    public static final String CREAR_TABLA_EMPAQUE = "CREATE TABLE " + TABLA_EMPAQUE+
            "(" + COLUMN_IDEMPAQ +
            " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_FOLIO +
            " VARCHAR, " + COLUMN_IDCAPTURISTA	+ // IntegerNúmero del capturista
            " VARCHAR, " + COLUMN_CICPRO +
            " VARCHAR, " + COLUMN_TIPOCULTIV +
            " VARCHAR, " + COLUMN_EMPHOR +
            " VARCHAR, " + COLUMN_EMPHORO +
            " VARCHAR, " + COLUMN_COUNIHPV +
            " VARCHAR);";

}
