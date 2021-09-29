package com.example.geosegalmex.Georeferencia;

public class Utilidades {


    //GEOREFERENCIA
    public static final String TABLA_GEORREFERENCIA             = "TbGeorreferencias";
    public static final String COLUMN_ID_GEORREFERENCIA         = "idGeorreferencia";
    //public static final String COLUMN_ID_FOLIO_BRIGADISTA_GEO   = "folBrigasdistaGeo";
    public static final String COLUMN_ID_FOLIO_PRODUCTOR_GEO    = "folProductorGeo";
    public static final String COLUMN_LONGITUD_GEO              = "longitudGeo";
    public static final String COLUMN_LATITUD_GEO               = "latitudGeo";
    public static final String COLUMN_HORA_GEO                  = "horaGeo";
    public static final String COLUMN_FECHA_GEO                  = "fechaGeo";
    public static final String COLUMN_STATUS_GEO                = "statusGeo";

    public static final String CREAR_TABLA_GEORREFERENCIA = "CREATE TABLE " + TABLA_GEORREFERENCIA +
            "(" +COLUMN_ID_GEORREFERENCIA +
            " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            //COLUMN_ID_FOLIO_BRIGADISTA_GEO +
            //" VARCHAR, " +
            COLUMN_ID_FOLIO_PRODUCTOR_GEO +
            " VARCHAR, "+ COLUMN_LONGITUD_GEO+
            " VARCHAR, "+ COLUMN_LATITUD_GEO +
            " VARCHAR, "+ COLUMN_HORA_GEO +
            " VARCHAR, "+ COLUMN_FECHA_GEO +
            " VARCHAR, "+ COLUMN_STATUS_GEO +
            " TINYINT);";


}
