package com.example.geosegalmex.Liconsa2;

public class LiconsaVerificacion_bd {

    public static final String TABLA_BD = "TB_RNPL_EXPEDIENTE";
    public static final String COLUMN_FOLIO = "FOLIO";
    public static final String COLUMN_NOM        = "NOM";
    public static final String COLUMN_PATERNO    = "PATERNO";
    public static final String COLUMN_MATERNO    = "MATERNO";
    public static final String COLUMN_P21         = "_P21";
    public static final String COLUMN_P21CUAL = "_P21CUAL";
    public static final String COLUMN_P22RFC = "_P22RFC";
    public static final String COLUMN_P22CURP = "_P22CURP";
    public static final String COLUMN_P22CLABE = "_P22CLABE";
    public static final String COLUMN_CLABE = "_CLABE";
    public static final String COLUMN_P22DOM = "_P22DOM";
    public static final String COLUMN_DOM = "_DOM";
    public static final String COLUMN_P22ART50 = "_P22ART50";
    public static final String COLUMN_P22ART32 = "_P22ART32";
    public static final String COLUMN_P22CARTA = "_P22CARTA";
    public static final String COLUMN_P22COD = "_P22COD";
    public static final String COLUMN_COD = "_COD";
    public static final String COLUMN_P22GER = "_P22GER";
    public static final String COLUMN_GER = "_GER";
    public static final String COLUMN_PRODUCTOR = "TIPOPROD";
    public static final String COLUMN_NOMPROD = "_NOMASOC";
    public static final String COLUMN_TIPOPROD = "TIPOASOC";
    public static final String COLUMN_OBSERV     = "OBSERV";
    public static final String COLUMN_LONGITUD = "LONGITUD";
    public static final String COLUMN_LATITUD = "LATITUD";

    public static final String CREAR_TABLA_RNPL_EXPEDIENTE= "CREATE TABLE " + TABLA_BD + "("
            + COLUMN_FOLIO + " VARCHAR PRIMARY KEY, "
            + COLUMN_NOM       + " VARCHAR, "
            + COLUMN_PATERNO   + " VARCHAR, "
            + COLUMN_MATERNO   + " VARCHAR, "
            + COLUMN_P21       + " VARCHAR, "
            + COLUMN_P21CUAL   + " VARCHAR, "
            + COLUMN_P22RFC    + " VARCHAR, "
            + COLUMN_P22CURP   + " VARCHAR, "
            + COLUMN_P22CLABE  + " VARCHAR, "
            + COLUMN_CLABE     + " VARCHAR, "
            + COLUMN_P22DOM    + " VARCHAR, "
            + COLUMN_DOM    + " VARCHAR, "
            + COLUMN_P22ART50  + " VARCHAR, "
            + COLUMN_P22ART32  + " VARCHAR, "
            + COLUMN_P22CARTA  + " VARCHAR, "
            + COLUMN_P22COD    + " VARCHAR, "
            + COLUMN_COD       + " VARCHAR, "
            + COLUMN_P22GER    + " VARCHAR, "
            + COLUMN_GER       + " VARCHAR, "
            + COLUMN_PRODUCTOR + " VARCHAR, "
            + COLUMN_NOMPROD   + " VARCHAR, "
            + COLUMN_TIPOPROD  + " VARCHAR, "
            + COLUMN_OBSERV    + " VARCHAR, "
            + COLUMN_LONGITUD + " VARCHAR, "
            + COLUMN_LATITUD + " VARCHAR); " ;


}

