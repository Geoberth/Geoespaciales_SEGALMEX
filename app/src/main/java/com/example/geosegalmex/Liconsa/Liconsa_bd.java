package com.example.geosegalmex.Liconsa;

public class Liconsa_bd {

    public static final String TABLA_BD = "TB_RNPL_PRODUCTOR";
    public static final String COLUMN_FOLIO = "FOLIO";
    public static final String COLUMN_NOM        = "NOM";
    public static final String COLUMN_PATERNO    = "PATERNO";
    public static final String COLUMN_MATERNO    = "MATERNO";
    public static final String COLUMN_NACIMIENTO = "NACIMIENTO";
    public static final String COLUMN_SEXO       = "SEXO";
    public static final String COLUMN_NACION     = "NACION";
    public static final String COLUMN_CURP       = "CURP";
    public static final String COLUMN_RFC        = "RFC";
    public static final String COLUMN_TIPOIDE    = "TIPOIDE";
    public static final String COLUMN_NUMIDE     = "NUMIDE";
    public static final String COLUMN_EMAIL      = "EMAIL";
    public static final String COLUMN_TEL        = "TEL";
    public static final String COLUMN_TIPOTEL    = "TIPOTEL";
    public static final String COLUMN_CALLE      = "CALLE";
    public static final String COLUMN_EXT        = "EXT";
    public static final String COLUMN_INT        = "INT";
    public static final String COLUMN_CP         = "CP";
    public static final String COLUMN_CVEEDO     = "CVEEDO";
    public static final String COLUMN_ENTIDAD    = "ENTIDAD";
    public static final String COLUMN_CVEMUN     = "CVEMUN";
    public static final String COLUMN_MUN        = "MUN";
    public static final String COLUMN_CVELOC     = "CVELOC";
    public static final String COLUMN_LOC        = "LOC";
    public static final String COLUMN_COL        = "COL";
    public static final String COLUMN_TIPOASEN   = "TIPOASEN";
    public static final String COLUMN_NOMASEN    = "NOMASEN";
    public static final String COLUMN_CVEASEN    = "CVEASEN";
    public static final String COLUMN_VIALIDAD   = "VIALIDAD";
    public static final String COLUMN_TIPOVIA    = "TIPOVIA";
    public static final String COLUMN_CALLEUP     ="CALLEUP";
    public static final String COLUMN_EXTUP       ="EXTUP";
    public static final String COLUMN_INTUP       ="INTUP";
    public static final String COLUMN_CVELOCUP    ="CVELOCUP";
    public static final String COLUMN_LOCUP    ="LOCUP";
    public static final String COLUMN_COLUP       ="COLUP";
    public static final String COLUMN_CPUP        ="CPUP";
    public static final String COLUMN_CVEEDOUP    ="CVEEDOUP ";
    public static final String COLUMN_ENTIDADUP   ="ENTIDADUP";
    public static final String COLUMN_CVEMUNUP    ="CVEMUNUP";
    public static final String COLUMN_MUNUP       ="MUNUP";
    public static final String COLUMN_ASOC       = "ASOC";
    public static final String COLUMN_NOMASOC    = "NOMASOC";
    public static final String COLUMN_REGIMEN    = "REGIMEN";
    public static final String COLUMN_DISC       = "DISC";
    public static final String COLUMN_NOMDISC    = "NOMDISC";
    public static final String COLUMN_INDI       = "INDI";
    public static final String COLUMN_DECINDI    = "DECINDI";
    public static final String COLUMN_ESTATUS    = "ESTATUS";
    public static final String COLUMN_UPP        = "UPP";
    public static final String COLUMN_P1         = "P1";
    public static final String COLUMN_P2         = "P2";
    public static final String COLUMN_P3         = "P3";
    public static final String COLUMN_P4         = "P4";
    public static final String COLUMN_P5         = "P5";
    public static final String COLUMN_P6         = "P6";
    public static final String COLUMN_P7         = "P7";
    public static final String COLUMN_P8         = "P8";
    public static final String COLUMN_P9         = "P9";
    public static final String COLUMN_P9_1       = "P9_1";
    public static final String COLUMN_P9_2       = "P9_2";
    public static final String COLUMN_P10        = "P10";
    public static final String COLUMN_P10_1      = "P10_1";
    public static final String COLUMN_P11        = "P11";
    public static final String COLUMN_P12_1      = "P12_1";
    public static final String COLUMN_P12_2      = "P12_2";
    public static final String COLUMN_P12_3      = "P12_3";
    public static final String COLUMN_P12_4      = "P12_4";
    public static final String COLUMN_P12_4OTROS = "P12_4OTROS";
    public static final String COLUMN_P13        = "P13";
    public static final String COLUMN_P13_1      = "P13_1";
    public static final String COLUMN_P13_2      = "P13_2";
    public static final String COLUMN_P13_3      = "P13_3";
    public static final String COLUMN_P13_4      = "P13_4";
    public static final String COLUMN_P13_5      = "P13_5";
    public static final String COLUMN_P14        = "P14";
    public static final String COLUMN_P14_1      = "P14_1";
    public static final String COLUMN_P14_2      = "P14_2";
    public static final String COLUMN_P14_3      = "P14_3";
    public static final String COLUMN_P14_4      = "P14_4";
    public static final String COLUMN_P14_5      = "P14_5";
    public static final String COLUMN_P15_1      = "P15_1";
    public static final String COLUMN_P15_2      = "P15_2";
    public static final String COLUMN_P15_3      = "P15_3";
    public static final String COLUMN_P15_4      = "P15_4";
    public static final String COLUMN_P15_4OTROS = "P15_4OTROS";
    public static final String COLUMN_P16        = "P16";
    public static final String COLUMN_P16REGIS   = "P16REGIS";
    public static final String COLUMN_P17        = "P17";
    public static final String COLUMN_P17REGIS   = "P17REGIS";
    public static final String COLUMN_P18        = "P18";
    public static final String COLUMN_P19        = "P19";
    public static final String COLUMN_P20        = "P20";
    public static final String COLUMN_OBSERV     = "OBSERV";
    public static final String COLUMN_FOTO1 = "FOTO1";
    public static final String COLUMN_FOTO2 = "FOTO2";
    public static final String COLUMN_FOTO3 = "FOTO3";
    public static final String COLUMN_LONGITUD = "LONGITUD";
    public static final String COLUMN_LATITUD = "LATITUD";

    public static final String CREAR_TABLA_RNPL_PRODUCTOR= "CREATE TABLE " + TABLA_BD + "("
            + COLUMN_FOLIO + " VARCHAR PRIMARY KEY, "
            + COLUMN_NOM       + " VARCHAR, "
            + COLUMN_PATERNO   + " VARCHAR, "
            + COLUMN_MATERNO   + " VARCHAR, "
            + COLUMN_NACIMIENTO+ " VARCHAR, "
            + COLUMN_SEXO      + " VARCHAR, "
            + COLUMN_NACION    + " VARCHAR, "
            + COLUMN_CURP      + " VARCHAR, "
            + COLUMN_RFC       + " VARCHAR, "
            + COLUMN_TIPOIDE   + " VARCHAR, "
            + COLUMN_NUMIDE    + " VARCHAR, "
            + COLUMN_EMAIL     + " VARCHAR, "
            + COLUMN_TEL       + " VARCHAR, "
            + COLUMN_TIPOTEL   + " VARCHAR, "
            + COLUMN_CALLE     + " VARCHAR, "
            + COLUMN_EXT       + " VARCHAR, "
            + COLUMN_INT       + " VARCHAR, "
            + COLUMN_CP        + " VARCHAR, "
            + COLUMN_CVEEDO    + " VARCHAR, "
            + COLUMN_ENTIDAD   + " VARCHAR, "
            + COLUMN_CVEMUN    + " VARCHAR, "
            + COLUMN_MUN       + " VARCHAR, "
            + COLUMN_CVELOC    + " VARCHAR, "
            + COLUMN_LOC       + " VARCHAR, "
            + COLUMN_COL       + " VARCHAR, "
            + COLUMN_TIPOASEN  + " VARCHAR, "
            + COLUMN_NOMASEN   + " VARCHAR, "
            + COLUMN_CVEASEN   + " VARCHAR, "
            + COLUMN_VIALIDAD  + " VARCHAR, "
            + COLUMN_TIPOVIA   + " VARCHAR, "
            + COLUMN_CALLEUP     + " VARCHAR, "
            + COLUMN_EXTUP     + " VARCHAR, "
            + COLUMN_INTUP     + " VARCHAR, "
            + COLUMN_CVELOCUP     + " VARCHAR, "
            + COLUMN_LOCUP     + " VARCHAR, "
            + COLUMN_COLUP     + " VARCHAR, "
            + COLUMN_CPUP     + " VARCHAR, "
            + COLUMN_CVEEDOUP     + " VARCHAR, "
            + COLUMN_ENTIDADUP     + " VARCHAR, "
            + COLUMN_CVEMUNUP     + " VARCHAR, "
            + COLUMN_MUNUP         + " VARCHAR, "
            + COLUMN_ASOC      + " VARCHAR, "
            + COLUMN_NOMASOC   + " VARCHAR, "
            + COLUMN_REGIMEN   + " VARCHAR, "
            + COLUMN_DISC      + " VARCHAR, "
            + COLUMN_NOMDISC   + " VARCHAR, "
            + COLUMN_INDI      + " VARCHAR, "
            + COLUMN_DECINDI   + " VARCHAR, "
            + COLUMN_ESTATUS   + " VARCHAR, "
            + COLUMN_UPP       + " VARCHAR, "
            + COLUMN_P1        + " VARCHAR, "
            + COLUMN_P2        + " VARCHAR, "
            + COLUMN_P3        + " VARCHAR, "
            + COLUMN_P4        + " VARCHAR, "
            + COLUMN_P5        + " VARCHAR, "
            + COLUMN_P6        + " VARCHAR, "
            + COLUMN_P7        + " VARCHAR, "
            + COLUMN_P8        + " VARCHAR, "
            + COLUMN_P9        + " VARCHAR, "
            + COLUMN_P9_1      + " VARCHAR, "
            + COLUMN_P9_2      + " VARCHAR, "
            + COLUMN_P10       + " VARCHAR, "
            + COLUMN_P10_1     + " VARCHAR, "
            + COLUMN_P11       + " VARCHAR, "
            + COLUMN_P12_1     + " VARCHAR, "
            + COLUMN_P12_2     + " VARCHAR, "
            + COLUMN_P12_3     + " VARCHAR, "
            + COLUMN_P12_4     + " VARCHAR, "
            + COLUMN_P12_4OTROS+ " VARCHAR, "
            + COLUMN_P13       + " VARCHAR, "
            + COLUMN_P13_1     + " VARCHAR, "
            + COLUMN_P13_2     + " VARCHAR, "
            + COLUMN_P13_3     + " VARCHAR, "
            + COLUMN_P13_4     + " VARCHAR, "
            + COLUMN_P13_5     + " VARCHAR, "
            + COLUMN_P14       + " VARCHAR, "
            + COLUMN_P14_1     + " VARCHAR, "
            + COLUMN_P14_2     + " VARCHAR, "
            + COLUMN_P14_3     + " VARCHAR, "
            + COLUMN_P14_4     + " VARCHAR, "
            + COLUMN_P14_5     + " VARCHAR, "
            + COLUMN_P15_1     + " VARCHAR, "
            + COLUMN_P15_2     + " VARCHAR, "
            + COLUMN_P15_3     + " VARCHAR, "
            + COLUMN_P15_4     + " VARCHAR, "
            + COLUMN_P15_4OTROS+ " VARCHAR, "
            + COLUMN_P16       + " VARCHAR, "
            + COLUMN_P16REGIS  + " VARCHAR, "
            + COLUMN_P17       + " VARCHAR, "
            + COLUMN_P17REGIS  + " VARCHAR, "
            + COLUMN_P18       + " VARCHAR, "
            + COLUMN_P19       + " VARCHAR, "
            + COLUMN_P20       + " VARCHAR, "
            + COLUMN_OBSERV    + " VARCHAR, "
            + COLUMN_FOTO1 + " VARCHAR, "
            + COLUMN_FOTO2 + " VARCHAR, "
            + COLUMN_FOTO3 + " VARCHAR, "
            + COLUMN_LONGITUD + " VARCHAR, "
            + COLUMN_LATITUD + " VARCHAR); " ;


}