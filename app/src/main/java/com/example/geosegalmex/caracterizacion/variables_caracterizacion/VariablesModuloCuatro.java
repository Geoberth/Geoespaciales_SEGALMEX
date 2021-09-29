package com.example.geosegalmex.caracterizacion.variables_caracterizacion;

public class VariablesModuloCuatro {

    //Tabla: cultivo_agricola
    public static String	IDCULAGRICOLA; //	Integer	ID Tipo de semilla
    public static String	FOLIO; //	Text	Folio encuesta (Folio encuesta)
    public static String	IDCAPTURISTA; //	Integer	Número del capturista
    public static String	CICLOPRO; //	Text	En el año pasado, ¿En qué ciclo agrícola tuvo producción?
    public static String	MAIZ; //	Text	¿Qué tipo de maíz es?
    public static String	OTROMAIZ; //	Text	¿Qué tipo de maíz es?
    public static String	MILPA; //	Text	¿Milpa?
    public static String	SORGO; //	Text	¿Qué tipo de sorgo es?
    public static String	FRIJOL; //	Text	¿Qué tipo de frijol es?
    public static String	TRIGO; //	Text	¿Qué tipo de trigo es?
    public static String	AJONJOLI; //	Text	¿Qué tipo de ajonjolí es?
    public static String	CACAHUATE; //	Text	¿Qué tipo de cacahuate es?
    public static String	FECHASIEM; //	Text	¿Cuál es la fecha de siembra?
    public static String	SUPSEM; //	Integer	¿Cuánta superficie (ha) sembrada tiene?
    public static String	SUPMEC; //	Integer	¿Cuánta superficie (ha) mecanizada tiene?
    public static String	SUPNOMEC; //	Integer	¿Cuánta superficie (ha) no mecanizada tiene?
    public static String	SUPSINI; //	Integer	¿Cuánta superficie (ha) siniestrada tiene?
    public static String	CASUPSI; //	Integer	¿Cuál fue la causa de la superficie siniestrada?
    public static String	ASOC; //	Text	¿Está asociado con otro cultivo?
    public static String	ASOCUL; //	Text	¿Cuál?
    public static String	FESIEASO; //	Text	¿Cuál es la fecha de siembra del cultivo asociado?
    public static String	ANAFERG; //	Text	¿Realiza algún análisis para fertilizar?
    public static String	TIPANAG; //	Text	¿Qué tipo de análisis?
    public static String	PANAGR; //	Integer	Precio $
    public static String	TIPFERG; //	Text	¿Realiza algún tipo de fertilización?
    public static String	RIEGOGR; //	Text	¿Utiliza algún sistema de riego?
    public static String	METDES; //	Text	¿Qué método de desgrane utiliza?
    public static String	JORDESM; //	Integer	Número de jornales
    public static String	SERMEN; //	Integer	Precio ($) Servicio/ton



    //Tabla: semillas_cultivo
    public static String	IDSEMCUL; //	Integer	ID Tipo de semilla
    //public static String	FOLIO; //	Text	Folio encuesta (Folio encuesta)
    //public static String	CICLOPRO; //	Text	Ciclo agrícola
    public static String	TIPSEM; //	Text	¿Qué tipo de semilla?
    public static String	SEMCER; //	Text	¿Cuál?
    public static String	PRECSEM; //	Integer	Precio ($/kg)
    public static String	CANTSEM; //	Integer	Cantidad (kg/ha)
    public static String	SEPROSEL; //	Text	¿En caso de utilizar semilla propia como la seleccionó?
    public static String	OTRTISELSE; //	Text	¿Cuál?
    public static String	METSIEM; //	Text	¿Qué método de siembra utiliza?
    public static String	TRATSEM; //	Text	¿Le da algún tratamiento a la semilla?
    public static String	SISTLAB; //	Text	¿Qué sistema de labranza utiliza?
    public static String	PJOR; //	Integer	Si contrata mano de obra, ¿Cuánto es el precio del jornal? $



    //    Tabla: preparacion_suelo
    public static String	IDPREPSUEL; //	Integer	ID Preparación del suelo
    //  public static String	FOLIO; //	Text	Folio encuesta (Folio encuesta)
    //public static String	CICLOPRO; //	Text	Ciclo agrícola
    public static String	TIPOCULTIV; //	Text	Cultivo Agrícola u Hortaliza
    public static String	CICLOPROD; //	Text	En el año pasado, ¿En qué ciclo agrícola tuvo producción?
    public static String	LABPRES; //	Text	Actividad que realiza para la preparación del suelo
    public static String	NUMVL; //	Integer	Número de veces
    public static String	EQUIPOL; //	Text	Equipo (propio/maquila)
    public static String	COSTOL; //	Text	Costo/ha
    public static String	NUMJORL; //	Integer	Núm. de jornales



    //Tabla: fertilizantes
    public static String	IDFERTIL; //	Integer	ID Fertilizante
    //   public static String	FOLIO; //	Text	Folio encuesta (Folio encuesta)
   // public static String	CICLOPRO; //	Text	Ciclo agrícola
    //public static String	TIPOCULTIV; //	Text	Cultivo Agrícola / Hortaliza / Frutales
    public static String	FERTGRA; //	Text	Fertilizantes y/o abonos aplicados
    public static String	EFFRUT; //	Text	Etapa fenológica
    public static String	FERAPPG; //	Text	Fecha de aplicación
    public static String	FERCANG; //	Integer	Cantidad (l o kg / ha)
    public static String	FERCOSG; //	Integer	Costo de fertilizante
    public static String	FERJORG; //	Integer	Núm. de jornales







    //Tabla: riego
    public static String	IDRIEGO; //	Integer	ID Riego
    //  public static String	FOLIO; //	Text	Folio encuesta (Folio encuesta)
    //public static String	TIPOCULTIV; //	Text	Cultivo Agrícola u Hortaliza
    //public static String	CICLOPRO; //	Text	Ciclo agrícola
    public static String	SISRIEGR; //	Text	¿Qué tipo de riego?
    public static String	SISHORTPV; //	Text	Otro
    public static String	NUMRIEGR; //	Integer	Número de riego
    public static String	RIECOSGR; //	Text	Costo del riego ($/riego)
    public static String	JORGR; //	Integer	Núm. Jornales
    public static String	CANRIEGR; //	Integer	¿Cuántos riegos realiza?
    public static String	FRERIEGR; //	Text	¿Cada cuánto tiempo riega?



    //Tabla: mala_hierba
    public static String	IDHIERBA; //	Integer	ID Mala hierba
    //   public static String	FOLIO; //	Text	Folio encuesta (Folio encuesta)
    //public static String	TIPOCULTIV; //	Text	Cultivo Agrícola / Hortaliza / Frutales
    //public static String	CICLOPRO; //	Text	Ciclo agrícola
    public static String	MALGR; //	Text	Maleza
    public static String	NCFRU; //	Text	Nombre común
    public static String	CONQMGR; //	Text	Control: (1) químico o 2) manual
    public static String	HERGR; //	Text	Herbicida
    public static String	HERCANGR; //	Integer	Cantidad (l ó kg / ha)
    public static String	SUPAPFRU; //	Integer	Superficie de aplicación (ha)
    public static String	HJORGR; //	Integer	Jornales
    public static String	CHERGR; //	Text	Costo herbicida



    //Tabla: plagas_enfermedades
    public static String	IDPLAGA; //	Integer	ID Plaga
    //  public static String	FOLIO; //	Text	Folio encuesta (Folio encuesta)
    //public static String	TIPOCULTIV; //	Text	Cultivo Agrícola / Hortaliza / Frutales
    //public static String	CICLOPRO; //	Text	Ciclo agrícola
    public static String	PLAGA; //	Text	Plagas y/o enfermedades
    public static String	PLATIPCOT; //	Text	Tipo de control.
    public static String	PLATCOGR; //	Text	Otro
    public static String	PLAPROGR; //	Text	Insecticida o producto
    public static String	PLACANTGR; //	Integer	Cantidad (l ó kg)/ha
    public static String	SUPHOR; //	Integer	Superficie de aplicación (ha)
    public static String	PEJORGR; //	Integer	Jornales
    public static String	INSPROGR; //	Text	Costo del insecticida o producto



    //Tabla: cosecha
    public static String	IDCOSECHA; //	Integer	ID Plaga
    //  public static String	FOLIO; //	Text	Folio encuesta (Folio encuesta)
    //public static String	TIPOCULTIV; //	Text	Cultivo Agrícola / Hortaliza / Frutales
    //public static String	CICLOPRO; //	Text	Ciclo agrícola
    public static String	ACTCOSECH; //	Text	¿Qué actividades realiza durante la cosecha?
    public static String	JORCOSGR; //	Integer	Número de jornales



    //Tabla: conserva_granos
    public static String	IDCONGRANO; //	Integer	ID Consercación granos
    //  public static String	FOLIO; //	Text	Folio encuesta (Folio encuesta)
    public static String	CONGRALM; //	Text	¿Cómo conserva sus granos almacenados?
    public static String	CONGRALMO; //	Text	Otro
    public static String	COSALMGR; //	Text	Costo ($)
    public static String	SUBAPRO; //	Text	¿Qué subproductos aprovecha?


}
