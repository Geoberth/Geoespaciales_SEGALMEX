package com.example.geosegalmex.caracterizacion.variables_caracterizacion;

public class UtilidadesModuloCuatro {

    //Tabla: cultivo_agricola
    public static final String TABLA_AGRICOLA	= "TbAGRICOLA"; //	Integer	ID Tipo de semilla
    public static final String COLUMN_IDCULAGRICOLA	= "IDAGRICOLA"; //	Integer	ID Tipo de semilla
    public static final String COLUMN_FOLIO	= "FOLIO"; //	Text	Folio encuesta (Folio encuesta)
    public static final String COLUMN_IDCAPTURISTA	= "IDCAPTURISTA"; //	Integer	Número del capturista
    public static final String COLUMN_CICLOPRO	= "CICLOPRO"; //	Text	En el año pasado, ¿En qué ciclo agrícola tuvo producción?
    public static final String COLUMN_MAIZ	= "MAIZ"; //	Text	¿Qué tipo de maíz es?
    public static final String COLUMN_OTROMAIZ	= "OTROMAIZ"; //	Text	¿Qué tipo de maíz es?
    public static final String COLUMN_MILPA	= "MILPA"; //	Text	¿Milpa?
    public static final String COLUMN_SORGO	= "SORGO"; //	Text	¿Qué tipo de sorgo es?
    public static final String COLUMN_FRIJOL	= "FRIJOL"; //	Text	¿Qué tipo de frijol es?
    public static final String COLUMN_TRIGO	= "TRIGO"; //	Text	¿Qué tipo de trigo es?
    public static final String COLUMN_AJONJOLI	= "AJONJOLI"; //	Text	¿Qué tipo de ajonjolí es?
    public static final String COLUMN_CACAHUATE	= "CACAHUATE"; //	Text	¿Qué tipo de cacahuate es?
    public static final String COLUMN_FECHASIEM	= "FECHASIEM"; //	Text	¿Cuál es la fecha de siembra?
    public static final String COLUMN_SUPSEM	= "SUPSEM"; //	Integer	¿Cuánta superficie (ha) sembrada tiene?
    public static final String COLUMN_SUPMEC	= "SUPMEC"; //	Integer	¿Cuánta superficie (ha) mecanizada tiene?
    public static final String COLUMN_SUPNOMEC	= "SUPNOMEC"; //	Integer	¿Cuánta superficie (ha) no mecanizada tiene?
    public static final String COLUMN_SUPSINI	= "SUPSINI"; //	Integer	¿Cuánta superficie (ha) siniestrada tiene?
    public static final String COLUMN_CASUPSI	= "CASUPSI"; //	Integer	¿Cuál fue la causa de la superficie siniestrada?
    public static final String COLUMN_ASOC	= "ASOC"; //	Text	¿Está asociado con otro cultivo?
    public static final String COLUMN_ASOCUL	= "ASOCUL"; //	Text	¿Cuál?
    public static final String COLUMN_FESIEASO	= "FESIEASO"; //	Text	¿Cuál es la fecha de siembra del cultivo asociado?
    public static final String COLUMN_ANAFERG	= "ANAFERG"; //	Text	¿Realiza algún análisis para fertilizar?
    public static final String COLUMN_TIPANAG	= "TIPANAG"; //	Text	¿Qué tipo de análisis?
    public static final String COLUMN_PANAGR	= "PANAGR"; //	Integer	Precio $
    public static final String COLUMN_TIPFERG	= "TIPFERG"; //	Text	¿Realiza algún tipo de fertilización?
    public static final String COLUMN_RIEGOGR	= "RIEGOGR"; //	Text	¿Utiliza algún sistema de riego?
    public static final String COLUMN_METDES	= "METDES"; //	Text	¿Qué método de desgrane utiliza?
    public static final String COLUMN_JORDESM	= "JORDESM"; //	Integer	Número de jornales
    public static final String COLUMN_SERMEN	= "SERMEN"; //	Integer	Precio ($) Servicio/ton

    //valor dependiente de la tabla granos
    public static final String COLUMN_SUBAPRO	= "SUBAPRO"; //	Text	¿Qué subproductos aprovecha?

    //tabla riego
    public static final String COLUMN_SISRIEGR	= "SISRIEGR"; //	Text	¿Qué tipo de riego?
    public static final String COLUMN_SISHORTPV	= "SISHORTPV"; //	Text	Otro
    public static final String COLUMN_CANRIEGR	= "CANRIEGR"; //	Integer	¿Cuántos riegos realiza?
    public static final String COLUMN_FRERIEGR	= "FRERIEGR"; //	Text	¿Cada cuánto tiempo riega?


    public static final String CREAR_TABLA_AGRICOLA = "CREATE TABLE " + TABLA_AGRICOLA +
            "(" + COLUMN_IDCULAGRICOLA +
            " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_FOLIO +
            " VARCHAR, " + COLUMN_IDCAPTURISTA	+ // IntegerNúmero del capturista
            " VARCHAR, " + COLUMN_CICLOPRO + // IntegerEn el año pasado, ¿En qué ciclo agrícola tuvo producción?
            " VARCHAR, " + COLUMN_MAIZ + // Integer¿Qué tipo de maíz es?
            " VARCHAR, " + COLUMN_OTROMAIZ + // Integer¿Qué tipo de maíz es?
            " VARCHAR, " + COLUMN_MILPA + // Integer¿Milpa?
            " VARCHAR, " + COLUMN_SORGO + // Integer¿Qué tipo de sorgo es?
            " VARCHAR, " + COLUMN_FRIJOL + // Integer¿Qué tipo de frijol es?
            " VARCHAR, " + COLUMN_TRIGO + // Integer¿Qué tipo de trigo es?
            " VARCHAR, " + COLUMN_AJONJOLI + // Integer¿Qué tipo de ajonjolí es?
            " VARCHAR, " + COLUMN_CACAHUATE + // Integer¿Qué tipo de cacahuate es?
            " VARCHAR, " + COLUMN_FECHASIEM + // Integer¿Cuál es la fecha de siembra?
            " VARCHAR, " + COLUMN_SUPSEM	+ // Integer¿Cuánta superficie (ha) sembrada tiene?
            " VARCHAR, " + COLUMN_SUPMEC	+ // Integer¿Cuánta superficie (ha) mecanizada tiene?
            " VARCHAR, " + COLUMN_SUPNOMEC	+ // Integer¿Cuánta superficie (ha) no mecanizada tiene?
            " VARCHAR, " + COLUMN_SUPSINI	+ // Integer¿Cuánta superficie (ha) siniestrada tiene?
            " VARCHAR, " + COLUMN_CASUPSI	+ // Integer¿Cuál fue la causa de la superficie siniestrada?
            " VARCHAR, " + COLUMN_ASOC + // Integer¿Está asociado con otro cultivo?
            " VARCHAR, " + COLUMN_ASOCUL + // Integer¿Cuál?
            " VARCHAR, " + COLUMN_FESIEASO + // Integer¿Cuál es la fecha de siembra del cultivo asociado?
            " VARCHAR, " + COLUMN_ANAFERG + // Integer¿Realiza algún análisis para fertilizar?
            " VARCHAR, " + COLUMN_TIPANAG + // Integer¿Qué tipo de análisis?
            " VARCHAR, " + COLUMN_PANAGR	+ // IntegerPrecio $
            " VARCHAR, " + COLUMN_TIPFERG + // Integer¿Realiza algún tipo de fertilización?
            " VARCHAR, " + COLUMN_RIEGOGR + // Integer¿Utiliza algún sistema de riego?
            " VARCHAR, " + COLUMN_METDES + // Integer¿Qué método de desgrane utiliza?
            " VARCHAR, " + COLUMN_JORDESM	+ // IntegerNúmero de jornales
            " VARCHAR, " + COLUMN_SERMEN	+ // IntegerPrecio ($) Servicio/ton
            " VARCHAR, " + COLUMN_SUBAPRO + // Integer¿Qué subproductos aprovecha?
            " VARCHAR, " + COLUMN_SISRIEGR + // Integer¿Qué tipo de riego?
            " VARCHAR, " + COLUMN_SISHORTPV + // IntegerOtro
            " VARCHAR, " + COLUMN_CANRIEGR	+ // Integer¿Cuántos riegos realiza?
            " VARCHAR, " + COLUMN_FRERIEGR + // Integer¿Cada cuánto tiempo riega?
            " VARCHAR);";

    //++++++++++++++++++++++++++++++++++++++++Tabla: semillas_cultivo
    public static final String TABLA_SEMILLA_CULTIVO	= "TbAGRISCLV"; //	Integer	ID Tipo de semilla
    public static final String COLUMN_IDSEMCUL	= "IDSEMCUL"; //	Integer	ID Tipo de semilla
    //public static final String COLUMN_FOLIO	= "FOLIO"; //	Text	Folio encuesta (Folio encuesta)
    //public static final String COLUMN_CICLOPRO	= "CICLOPRO"; //	Text	Ciclo agrícola
    public static final String COLUMN_TIPSEM	= "TIPSEM"; //	Text	¿Qué tipo de semilla?
    public static final String COLUMN_SEMCER	= "SEMCER"; //	Text	¿Cuál?
    public static final String COLUMN_PRECSEM	= "PRECSEM"; //	Integer	Precio ($/kg)
    public static final String COLUMN_CANTSEM	= "CANTSEM"; //	Integer	Cantidad (kg/ha)
    public static final String COLUMN_SEPROSEL	= "SEPROSEL"; //	Text	¿En caso de utilizar semilla propia como la seleccionó?
    public static final String COLUMN_OTRTISELSE	= "OTRTISELSE"; //	Text	¿Cuál?
    public static final String COLUMN_METSIEM	= "METSIEM"; //	Text	¿Qué método de siembra utiliza?
    public static final String COLUMN_TRATSEM	= "TRATSEM"; //	Text	¿Le da algún tratamiento a la semilla?
    public static final String COLUMN_SISTLAB	= "SISTLAB"; //	Text	¿Qué sistema de labranza utiliza?
    public static final String COLUMN_PJOR	= "PJOR"; //	Integer	Si contrata mano de obra, ¿Cuánto es el precio del jornal? $

    public static final String CREAR_TABLA_SEMILLAS_CULTIVO = "CREATE TABLE " + TABLA_SEMILLA_CULTIVO +
            "(" + COLUMN_IDSEMCUL +
            " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_FOLIO +
            " VARCHAR, " + COLUMN_IDCAPTURISTA	+ // IntegerNúmero del capturista
            " VARCHAR, " + COLUMN_CICLOPRO + // IntegerCiclo agrícola
            " VARCHAR, " + COLUMN_TIPSEM + // Integer¿Qué tipo de semilla?
            " VARCHAR, " + COLUMN_SEMCER + // Integer¿Cuál?
            " VARCHAR, " + COLUMN_PRECSEM	+ // IntegerPrecio ($/kg)
            " VARCHAR, " + COLUMN_CANTSEM	+ // IntegerCantidad (kg/ha)
            " VARCHAR, " + COLUMN_SEPROSEL + // Integer¿En caso de utilizar semilla propia como la seleccionó?
            " VARCHAR, " + COLUMN_OTRTISELSE + // Integer¿Cuál?
            " VARCHAR, " + COLUMN_METSIEM + // Integer¿Qué método de siembra utiliza?
            " VARCHAR, " + COLUMN_TRATSEM + // Integer¿Le da algún tratamiento a la semilla?
            " VARCHAR, " + COLUMN_SISTLAB + // Integer¿Qué sistema de labranza utiliza?
            " VARCHAR, " + COLUMN_PJOR	+ // IntegerSi contrata mano de obra, ¿Cuánto es el precio del jornal? $
            " VARCHAR);";

    //++++++++++++++++++++++++++++++++++++++++Tabla: preparacion_suelo
    public static final String TABLA_PREPARACION_SUELO	= "TbAGRISLO"; //	Integer	ID Preparación del suelo
    public static final String COLUMN_IDPREPSUEL	= "IDPREPSUEL"; //	Integer	ID Preparación del suelo
    //public static final String COLUMN_FOLIO	= "FOLIO"; //	Text	Folio encuesta (Folio encuesta)
    //public static final String COLUMN_CICLOPRO	= "CICLOPRO"; //	Text	Ciclo agrícola
    public static final String COLUMN_TIPOCULTIV	= "TIPOCULTIV"; //	Text	Cultivo Agrícola u Hortaliza
    public static final String COLUMN_CICLOPROD	= "CICLOPROD"; //	Text	En el año pasado, ¿En qué ciclo agrícola tuvo producción?
    public static final String COLUMN_LABPRES	= "LABPRES"; //	Text	Actividad que realiza para la preparación del suelo
    public static final String COLUMN_NUMVL	= "NUMVL"; //	Integer	Número de veces
    public static final String COLUMN_EQUIPOL	= "EQUIPOL"; //	Text	Equipo (propio/maquila)
    public static final String COLUMN_COSTOL	= "COSTOL"; //	Text	Costo/ha
    public static final String COLUMN_NUMJORL	= "NUMJORL"; //	Integer	Núm. de jornales

    public static final String CREAR_TABLA_PREPARACION_SUELO = "CREATE TABLE " + TABLA_PREPARACION_SUELO +
            "(" + COLUMN_IDPREPSUEL +
            " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_FOLIO +
            " VARCHAR, " + COLUMN_IDCAPTURISTA	+ // IntegerNúmero del capturista
            " VARCHAR, " + COLUMN_CICLOPRO + // IntegerCiclo agrícola
            " VARCHAR, " + COLUMN_TIPOCULTIV + // IntegerCultivo Agrícola u Hortaliza
            " VARCHAR, " + COLUMN_CICLOPROD + // IntegerEn el año pasado, ¿En qué ciclo agrícola tuvo producción?
            " VARCHAR, " + COLUMN_LABPRES + // IntegerActividad que realiza para la preparación del suelo
            " VARCHAR, " + COLUMN_NUMVL	+ // IntegerNúmero de veces
            " VARCHAR, " + COLUMN_EQUIPOL + // IntegerEquipo (propio/maquila)
            " VARCHAR, " + COLUMN_COSTOL + // IntegerCosto/ha
            " VARCHAR, " + COLUMN_NUMJORL	+ // IntegerNúm. de jornales
            " VARCHAR);";



    //++++++++++++++++++++++++++++++++++++++++Tabla: fertilizantes
    public static final String TABLA_FERTILIZANTE_AGRI	= "TbAGRIFERT"; //	Integer	ID Fertilizante
    public static final String COLUMN_IDFERTIL	= "IDFERTIL"; //	Integer	ID Fertilizante
    //public static final String COLUMN_FOLIO	= "FOLIO"; //	Text	Folio encuesta (Folio encuesta)
    //public static final String COLUMN_CICLOPRO	= "CICLOPRO"; //	Text	Ciclo agrícola
    //public static final String COLUMN_TIPOCULTIV	= "TIPOCULTIV"; //	Text	Cultivo Agrícola / Hortaliza / Frutales
    public static final String COLUMN_FERTGRA	= "FERTGRA"; //	Text	Fertilizantes y/o abonos aplicados
   // public static final String COLUMN_EFFRUT	= "EFFRUT"; //	Text	Etapa fenológica
    public static final String COLUMN_FERAPPG	= "FERAPPG"; //	Text	Fecha de aplicación
    public static final String COLUMN_FERCANG	= "FERCANG"; //	Integer	Cantidad (l o kg / ha)
    public static final String COLUMN_FERCOSG	= "FERCOSG"; //	Integer	Costo de fertilizante
    public static final String COLUMN_FERJORG	= "FERJORG"; //	Integer	Núm. de jornales

    public static final String CREAR_TABLA_FERTILIZANTE_AGRI = "CREATE TABLE " + TABLA_FERTILIZANTE_AGRI +
            "(" + COLUMN_IDFERTIL +
            " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_FOLIO +
            " VARCHAR, " + COLUMN_IDCAPTURISTA	+ // IntegerNúmero del capturista
            " VARCHAR, " + COLUMN_CICLOPRO + // IntegerCiclo agrícola
            " VARCHAR, " + COLUMN_TIPOCULTIV + // IntegerCultivo Agrícola / Hortaliza / Frutales
            " VARCHAR, " + COLUMN_FERTGRA + // IntegerFertilizantes y/o abonos aplicados
            " VARCHAR, " + COLUMN_FERAPPG + // IntegerFecha de aplicación
            " VARCHAR, " + COLUMN_FERCANG	+ // IntegerCantidad (l o kg / ha)
            " VARCHAR, " + COLUMN_FERCOSG	+ // IntegerCosto de fertilizante
            " VARCHAR, " + COLUMN_FERJORG	+ // IntegerNúm. de jornales
            " VARCHAR);";



    //++++++++++++++++++++++++++++++++++++++++Tabla: riego
    public static final String TABLA_RIEGO	= "TbAGRIRIGO"; //	Integer	ID Riego
    public static final String COLUMN_IDRIEGO	= "IDRIEGO"; //	Integer	ID Riego
    //public static final String COLUMN_FOLIO	= "FOLIO"; //	Text	Folio encuesta (Folio encuesta)
    //public static final String COLUMN_TIPOCULTIV	= "TIPOCULTIV"; //	Text	Cultivo Agrícola u Hortaliza
    //public static final String COLUMN_CICLOPRO	= "CICLOPRO"; //	Text	Ciclo agrícola
    public static final String COLUMN_NUMRIEGR	= "NUMRIEGR"; //	Integer	Número de riego
    public static final String COLUMN_RIECOSGR	= "RIECOSGR"; //	Text	Costo del riego ($/riego)
    public static final String COLUMN_JORGR	= "JORGR"; //	Integer	Núm. Jornales


    public static final String CREAR_TABLA_RIEGO = "CREATE TABLE " + TABLA_RIEGO +
            "(" + COLUMN_IDRIEGO +
            " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_FOLIO +
            " VARCHAR, " + COLUMN_IDCAPTURISTA	+ // IntegerNúmero del capturista
            " VARCHAR, " + COLUMN_TIPOCULTIV + // IntegerCultivo Agrícola u Hortaliza
            " VARCHAR, " + COLUMN_CICLOPRO + // IntegerCiclo agrícola
            " VARCHAR, " + COLUMN_NUMRIEGR	+ // IntegerNúmero de riego
            " VARCHAR, " + COLUMN_RIECOSGR + // IntegerCosto del riego ($/riego)
            " VARCHAR, " + COLUMN_JORGR	+ // IntegerNúm. Jornales
            " VARCHAR);";


    //++++++++++++++++++++++++++++++++++++++++Tabla: mala_hierba
    public static final String TABLA_MALA_HIERBA	= "TbAGRIMaHba"; //	Integer	ID Mala hierba
    public static final String COLUMN_IDHIERBA	= "IDHIERBA"; //	Integer	ID Mala hierba
    //public static final String COLUMN_FOLIO	= "FOLIO"; //	Text	Folio encuesta (Folio encuesta)
    //public static final String COLUMN_TIPOCULTIV	= "TIPOCULTIV"; //	Text	Cultivo Agrícola / Hortaliza / Frutales
    //public static final String COLUMN_CICLOPRO	= "CICLOPRO"; //	Text	Ciclo agrícola
    public static final String COLUMN_MALGR	= "MALGR"; //	Text	Maleza
    //public static final String COLUMN_NCFRU	= "NCFRU"; //	Text	Nombre común
    public static final String COLUMN_CONQMGR	= "CONQMGR"; //	Text	Control: (1) químico o 2) manual
    public static final String COLUMN_HERGR	= "HERGR"; //	Text	Herbicida
    public static final String COLUMN_HERCANGR	= "HERCANGR"; //	Integer	Cantidad (l ó kg / ha)
    //public static final String COLUMN_SUPAPFRU	= "SUPAPFRU"; //	Integer	Superficie de aplicación (ha)
    public static final String COLUMN_HJORGR	= "HJORGR"; //	Integer	Jornales
    public static final String COLUMN_CHERGR	= "CHERGR"; //	Text	Costo herbicida

    public static final String CREAR_TABLA_MALA_HIERBA = "CREATE TABLE " + TABLA_MALA_HIERBA +
            "(" + COLUMN_IDHIERBA +
            " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_FOLIO +
            " VARCHAR, " + COLUMN_IDCAPTURISTA	+ // IntegerNúmero del capturista
            " VARCHAR, " + COLUMN_TIPOCULTIV + // IntegerCultivo Agrícola / Hortaliza / Frutales
            " VARCHAR, " + COLUMN_CICLOPRO + // IntegerCiclo agrícola
            " VARCHAR, " + COLUMN_MALGR + // IntegerMaleza
            " VARCHAR, " + COLUMN_CONQMGR + // IntegerControl: (1) químico o 2) manual
            " VARCHAR, " + COLUMN_HERGR + // IntegerHerbicida
            " VARCHAR, " + COLUMN_HERCANGR	+ // IntegerCantidad (l ó kg / ha)
            " VARCHAR, " + COLUMN_HJORGR	+ // IntegerJornales
            " VARCHAR, " + COLUMN_CHERGR + // IntegerCosto herbicida
            " VARCHAR);";


    //++++++++++++++++++++++++++++++++++++++++Tabla: plagas_enfermedades
    public static final String TABLA_ENFERMEDADES	= "TbAGRIENFER"; //	Integer	ID Plaga
    public static final String COLUMN_IDPLAGA	= "IDPLAGA"; //	Integer	ID Plaga
    //public static final String COLUMN_FOLIO	= "FOLIO"; //	Text	Folio encuesta (Folio encuesta)
    //public static final String COLUMN_TIPOCULTIV	= "TIPOCULTIV"; //	Text	Cultivo Agrícola / Hortaliza / Frutales
    //public static final String COLUMN_CICLOPRO	= "CICLOPRO"; //	Text	Ciclo agrícola
    public static final String COLUMN_PLAGA	= "PLAGA"; //	Text	Plagas y/o enfermedades
    public static final String COLUMN_PLATIPCOT	= "PLATIPCOT"; //	Text	Tipo de control.
    public static final String COLUMN_PLATCOGR	= "PLATCOGR"; //	Text	Otro
    public static final String COLUMN_PLAPROGR	= "PLAPROGR"; //	Text	Insecticida o producto
    public static final String COLUMN_PLACANTGR	= "PLACANTGR"; //	Integer	Cantidad (l ó kg)/ha
  //  public static final String COLUMN_SUPHOR	= "SUPHOR"; //	Integer	Superficie de aplicación (ha) solo hortalizas
    public static final String COLUMN_PEJORGR	= "PEJORGR"; //	Integer	Jornales
    public static final String COLUMN_INSPROGR	= "INSPROGR"; //	Text	Costo del insecticida o producto

    public static final String CREAR_TABLA_PLAGA_ENFERMEDADES = "CREATE TABLE " + TABLA_ENFERMEDADES +
            "(" + COLUMN_IDPLAGA +
            " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_FOLIO +
            " VARCHAR, " + COLUMN_IDCAPTURISTA	+ // IntegerNúmero del capturista
            " VARCHAR, " + COLUMN_TIPOCULTIV + // IntegerCultivo Agrícola / Hortaliza / Frutales
            " VARCHAR, " + COLUMN_CICLOPRO + // IntegerCiclo agrícola
            " VARCHAR, " + COLUMN_PLAGA + // IntegerPlagas y/o enfermedades
            " VARCHAR, " + COLUMN_PLATIPCOT + // IntegerTipo de control.
            " VARCHAR, " + COLUMN_PLATCOGR + // IntegerOtro
            " VARCHAR, " + COLUMN_PLAPROGR + // IntegerInsecticida o producto
            " VARCHAR, " + COLUMN_PLACANTGR	+ // IntegerCantidad (l ó kg)/ha
            " VARCHAR, " + COLUMN_PEJORGR	+ // IntegerJornales
            " VARCHAR, " + COLUMN_INSPROGR + // IntegerCosto del insecticida o producto
            " VARCHAR);";



    //++++++++++++++++++++++++++++++++++++++++Tabla: cosecha
    public static final String TABLA_COSECHA	= "TbAGRICSCH"; //	Integer	ID Plaga
    public static final String COLUMN_IDCOSECHA	= "IDAGRICOSE"; //	Integer	ID Plaga
    //public static final String COLUMN_FOLIO	= "FOLIO"; //	Text	Folio encuesta (Folio encuesta)
    //public static final String COLUMN_TIPOCULTIV	= "TIPOCULTIV"; //	Text	Cultivo Agrícola / Hortaliza / Frutales
    //public static final String COLUMN_CICLOPRO	= "CICLOPRO"; //	Text	Ciclo agrícola
    public static final String COLUMN_ACTCOSECH	= "ACTCOSECH"; //	Text	¿Qué actividades realiza durante la cosecha?
    public static final String COLUMN_JORCOSGR	= "JORCOSGR"; //	Integer	Número de jornales

    public static final String CREAR_TABLA_COSECHA = "CREATE TABLE " + TABLA_COSECHA +
            "(" + COLUMN_IDCOSECHA +
            " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_FOLIO +
            " VARCHAR, " + COLUMN_IDCAPTURISTA	+ // IntegerNúmero del capturista
            " VARCHAR, " + COLUMN_TIPOCULTIV + // IntegerCultivo Agrícola / Hortaliza / Frutales
            " VARCHAR, " + COLUMN_CICLOPRO + // IntegerCiclo agrícola
            " VARCHAR, " + COLUMN_ACTCOSECH + // Integer¿Qué actividades realiza durante la cosecha?
            " VARCHAR, " + COLUMN_JORCOSGR	+ // IntegerNúmero de jornales
            " VARCHAR);";


    //++++++++++++++++++++++++++++++++++++++++Tabla: conserva_granos
    public static final String TABLA_GRANOS	= "TbAGRIGRNS"; //	Integer	ID Consercación granos
    public static final String COLUMN_IDCONGRANO	= "IDCONGRANO"; //	Integer	ID Consercación granos
    //public static final String COLUMN_FOLIO	= "FOLIO"; //	Text	Folio encuesta (Folio encuesta)
    public static final String COLUMN_CONGRALM	= "CONGRALM"; //	Text	¿Cómo conserva sus granos almacenados?
    public static final String COLUMN_CONGRALMO	= "CONGRALMO"; //	Text	Otro
    public static final String COLUMN_COSALMGR	= "COSALMGR"; //	Text	Costo ($)
    //public static final String COLUMN_SUBAPRO	= "SUBAPRO"; //	Text	¿Qué subproductos aprovecha?

    public static final String CREAR_TABLA_GRANO = "CREATE TABLE " + TABLA_GRANOS +
            "(" + COLUMN_IDCONGRANO +
            " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_FOLIO +
            " VARCHAR, " + COLUMN_IDCAPTURISTA	+ // IntegerNúmero del capturista
            " VARCHAR, " + COLUMN_TIPOCULTIV + // IntegerCultivo Agrícola / Hortaliza / Frutales
            " VARCHAR, " + COLUMN_CICLOPRO + // IntegerCiclo agrícola
            " VARCHAR, " + COLUMN_CONGRALM + // Integer¿Cómo conserva sus granos almacenados?
            " VARCHAR, " + COLUMN_CONGRALMO + // IntegerOtro
            " VARCHAR, " + COLUMN_COSALMGR + // IntegerCosto ($)
            " VARCHAR);";

    //" VARCHAR, " + COLUMN_SUBAPRO + // Integer¿Qué subproductos aprovecha?
}
