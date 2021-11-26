package com.example.geosegalmex.PARBeneficiario;

public class PARBeneficiario_bd {

    public static final String TABLA_BD = "TB_PAR_BENEFICIARIO";
    public static final String COLUMN_FOLIOPERA    ="FOLIOPERA";
    public static final String COLUMN_FOLIO    ="FOLIO";
    public static final String COLUMN_FECHA    ="FECHA";
    public static final String COLUMN_CVEEDO   ="CVEEDO";
    public static final String COLUMN_ENTIDAD  ="ENTIDAD";
    public static final String COLUMN_CVEMUN   ="CVEMUN";
    public static final String COLUMN_MUNICIPIO="MUNICIPIO";
    public static final String COLUMN_CVELOC   ="CVELOC";
    public static final String COLUMN_LOCALIDAD="LOCALIDAD";
    public static final String COLUMN_SEXO     ="SEXO";
    public static final String COLUMN_EDAD     ="EDAD";
    public static final String COLUMN_P1       ="P1";
    public static final String COLUMN_P2       ="P2";
    public static final String COLUMN_P3       ="P3";
    public static final String COLUMN_P4       ="P4";
    public static final String COLUMN_P5       ="P5";
    public static final String COLUMN_P5CUAL   ="P5CUAL";
    public static final String COLUMN_P6       ="P6";
    public static final String COLUMN_P7       ="P7";
    public static final String COLUMN_P7CUAL   ="P7CUAL";
    public static final String COLUMN_P8       ="P8";
    public static final String COLUMN_P9       ="P9";
    public static final String COLUMN_P10      ="P10";
    public static final String COLUMN_P11      ="P11";
    public static final String COLUMN_P12      ="P12";
    public static final String COLUMN_P13      ="P13";
    public static final String COLUMN_P13CUAL  ="P13CUAL";
    public static final String COLUMN_P14      ="P14";
    public static final String COLUMN_P15      ="P15";
    public static final String COLUMN_P16      ="P16";
    public static final String COLUMN_P17      ="P17";
    public static final String COLUMN_P17CUAL  ="P17CUAL";
    public static final String COLUMN_P18      ="P18";
    public static final String COLUMN_P19      ="P19";
    public static final String COLUMN_P19CUAL  ="P19CUAL";
    public static final String COLUMN_P20      ="P20";
    public static final String COLUMN_P21      ="P21";
    public static final String COLUMN_P22      ="P22";
    public static final String COLUMN_P23      ="P23";
    public static final String COLUMN_P23EXP   ="P23EXP";
    public static final String COLUMN_P24   ="P24";
    public static final String COLUMN_P25   ="P25";
    public static final String COLUMN_P25OTRO  ="P25OTRO";
    public static final String COLUMN_P26      ="P26";
    public static final String COLUMN_P26OTRO  ="P26OTRO";
    public static final String COLUMN_P27      ="P27";
    public static final String COLUMN_FOTO1 = "FOTO1";
    public static final String COLUMN_FOTO2 = "FOTO2";
    public static final String COLUMN_LONGITUD = "LONGITUD";
    public static final String COLUMN_LATITUD = "LATITUD";

    public static final String CREAR_TABLA_PAR_BENEFICIARIO= "CREATE TABLE " + TABLA_BD + "("
            + COLUMN_FOLIOPERA     + " VARCHAR, "
            + COLUMN_FOLIO + " VARCHAR PRIMARY KEY, "
            + COLUMN_FECHA     + " VARCHAR, "
            + COLUMN_CVEEDO    + " VARCHAR, "
            + COLUMN_ENTIDAD   + " VARCHAR, "
            + COLUMN_CVEMUN    + " VARCHAR, "
            + COLUMN_MUNICIPIO + " VARCHAR, "
            + COLUMN_CVELOC    + " VARCHAR, "
            + COLUMN_LOCALIDAD + " VARCHAR, "
            + COLUMN_SEXO      + " VARCHAR, "
            + COLUMN_EDAD      + " VARCHAR, "
            + COLUMN_P1        + " VARCHAR, "
            + COLUMN_P2        + " VARCHAR, "
            + COLUMN_P3        + " VARCHAR, "
            + COLUMN_P4        + " VARCHAR, "
            + COLUMN_P5        + " VARCHAR, "
            + COLUMN_P5CUAL    + " VARCHAR, "
            + COLUMN_P6        + " VARCHAR, "
            + COLUMN_P7        + " VARCHAR, "
            + COLUMN_P7CUAL    + " VARCHAR, "
            + COLUMN_P8        + " VARCHAR, "
            + COLUMN_P9        + " VARCHAR, "
            + COLUMN_P10       + " VARCHAR, "
            + COLUMN_P11       + " VARCHAR, "
            + COLUMN_P12       + " VARCHAR, "
            + COLUMN_P13       + " VARCHAR, "
            + COLUMN_P13CUAL   + " VARCHAR, "
            + COLUMN_P14       + " VARCHAR, "
            + COLUMN_P15       + " VARCHAR, "
            + COLUMN_P16       + " VARCHAR, "
            + COLUMN_P17       + " VARCHAR, "
            + COLUMN_P17CUAL       + " VARCHAR, "
            + COLUMN_P18       + " VARCHAR, "
            + COLUMN_P19       + " VARCHAR, "
            + COLUMN_P19CUAL   + " VARCHAR, "
            + COLUMN_P20       + " VARCHAR, "
            + COLUMN_P21       + " VARCHAR, "
            + COLUMN_P22       + " VARCHAR, "
            + COLUMN_P23       + " VARCHAR, "
            + COLUMN_P23EXP    + " VARCHAR, "
            + COLUMN_P24       + " VARCHAR, "
            + COLUMN_P25       + " VARCHAR, "
            + COLUMN_P25OTRO   + " VARCHAR, "
            + COLUMN_P26       + " VARCHAR, "
            + COLUMN_P26OTRO   + " VARCHAR, "
            + COLUMN_P27       + " VARCHAR, "
            + COLUMN_FOTO1 + " VARCHAR, "
            + COLUMN_FOTO2 + " VARCHAR, "
            + COLUMN_LONGITUD + " VARCHAR, "
            + COLUMN_LATITUD + " VARCHAR); " ;
}
