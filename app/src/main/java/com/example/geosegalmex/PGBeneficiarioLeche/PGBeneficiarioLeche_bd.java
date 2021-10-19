package com.example.geosegalmex.PGBeneficiarioLeche;

public class PGBeneficiarioLeche_bd {

    public static final String TABLA_BD = "TB_PG_BENEFICIARIO_LECHE";
    public static final String COLUMN_FOLIO = "FOLIO";
    public static final String COLUMN_FECHA = "FECHA";
    public static final String COLUMN_NOMBRE = "NOMBRE";
    public static final String COLUMN_PATERNO = "PATERNO";
    public static final String COLUMN_MATERNO = "MATERNO";
    public static final String COLUMN_CURP = "CURP";
    public static final String COLUMN_CALLE = "CALLE";
    public static final String COLUMN_EXTERIOR = "EXT";
    public static final String COLUMN_INTERIOR = "INT";
    public static final String COLUMN_CVEESTADO = "CVEEDO";
    public static final String COLUMN_ESTADO = "ENTIDAD";
    public static final String COLUMN_CVEMUNICIPIO = "CVEMUN";
    public static final String COLUMN_MUNICIPIO = "MUNICIPIO";
    public static final String COLUMN_CVELOCALIDAD = "CVELOC";
    public static final String COLUMN_LOCALIDAD = "LOCALIDAD";
    public static final String COLUMN_CP = "CP";
    public static final String COLUMN_SEXO = "SEXO";
    public static final String COLUMN_EDAD = "EDAD";
    public static final String COLUMN_LYE = "LEY";
    public static final String COLUMN_NIVEL = "NIVEL";
    public static final String COLUMN_NIVELOTRO = "NIVELOTRO";
    public static final String COLUMN_PRODUCTO = "PRODUCTO";
    public static final String COLUMN_VOLUMEN = "VOLUMEN";
    public static final String COLUMN_CABEZAS = "CABEZAS";
    public static final String COLUMN_VACAS = "VACAS";
    public static final String COLUMN_APOYOA = "APOYOA";
    public static final String COLUMN_APOYOB = "APOYOB";
    public static final String COLUMN_APOYOC = "APOYOC";
    public static final String COLUMN_APOYOD = "APOYOD";
    public static final String COLUMN_APOYOE = "APOYOE";
    public static final String COLUMN_APOYOF = "APOYOF";
    public static final String COLUMN_APOYOG = "APOYOG";
    public static final String COLUMN_APOYOH = "APOYOH";
    public static final String COLUMN_DOCINE = "DOCINE";
    public static final String COLUMN_DOCCURP = "DOCCURP";
    public static final String COLUMN_DOCCLABE = "DOCCLABE";
    public static final String COLUMN_DOCFOLIO = "DOCFOLIO";
    public static final String COLUMN_OP1 = "OP1";
    public static final String COLUMN_OP2 = "OP2";
    public static final String COLUMN_OP3 = "OP3";
    public static final String COLUMN_OP4 = "OP4";
    public static final String COLUMN_OP5 = "OP5";
    public static final String COLUMN_OP6 = "OP6";
    public static final String COLUMN_OP7 = "OP7";
    public static final String COLUMN_OP8 = "OP8";
    public static final String COLUMN_OP9 = "OP9";
    public static final String COLUMN_OP10 = "OP10";
    public static final String COLUMN_OP11 = "OP11";
    public static final String COLUMN_REA1 = "REA1";
    public static final String COLUMN_REA2 = "REA2";
    public static final String COLUMN_REA3 = "REA3";
    public static final String COLUMN_REA4 = "REA4";
    public static final String COLUMN_REA5 = "REA5";
    public static final String COLUMN_REA6 = "REA6";
    public static final String COLUMN_REA7 = "REA7";
    public static final String COLUMN_REA8A = "REA8A";
    public static final String COLUMN_REA8B = "REA8B";
    public static final String COLUMN_REA8C = "REA8C";
    public static final String COLUMN_REA8D = "REA8D";
    public static final String COLUMN_REA8E = "REA8E";
    public static final String COLUMN_REA8F = "REA8F";
    public static final String COLUMN_REA8G = "REA8G";
    public static final String COLUMN_REA8H = "REA8H";
    public static final String COLUMN_REA8I = "REA8I";
    public static final String COLUMN_REA8OTRO = "REA8OTRO";
    public static final String COLUMN_REA9 = "REA9";
    public static final String COLUMN_REA10 = "REA10";
    public static final String COLUMN_REA11 = "REA11";
    public static final String COLUMN_REA12 = "REA12";
    public static final String COLUMN_FOTO1 = "FOTO1";
    public static final String COLUMN_FOTO2 = "FOTO2";
    public static final String COLUMN_LONGITUD = "LONGITUD";
    public static final String COLUMN_LATITUD = "LATITUD";

    public static final String CREAR_TABLA_PG_BENEFICIARIO_LECHE= "CREATE TABLE " + TABLA_BD + "("
            + COLUMN_FOLIO + " VARCHAR PRIMARY KEY, "
            + COLUMN_FECHA + " VARCHAR, "
            + COLUMN_NOMBRE       + " VARCHAR, "
            + COLUMN_PATERNO      + " VARCHAR, "
            + COLUMN_MATERNO      + " VARCHAR, "
            + COLUMN_CURP         + " VARCHAR, "
            + COLUMN_CALLE        + " VARCHAR, "
            + COLUMN_EXTERIOR     + " VARCHAR, "
            + COLUMN_INTERIOR     + " VARCHAR, "
            + COLUMN_CVEESTADO    + " VARCHAR, "
            + COLUMN_ESTADO       + " VARCHAR, "
            + COLUMN_CVEMUNICIPIO + " VARCHAR, "
            + COLUMN_MUNICIPIO    + " VARCHAR, "
            + COLUMN_CVELOCALIDAD + " VARCHAR, "
            + COLUMN_LOCALIDAD    + " VARCHAR, "
            + COLUMN_CP           + " VARCHAR, "
            + COLUMN_SEXO         + " VARCHAR, "
            + COLUMN_EDAD         + " VARCHAR, "
            + COLUMN_LYE          + " VARCHAR, "
            + COLUMN_NIVEL        + " VARCHAR, "
            + COLUMN_NIVELOTRO    + " VARCHAR, "
            + COLUMN_PRODUCTO     + " VARCHAR, "
            + COLUMN_VOLUMEN      + " VARCHAR, "
            + COLUMN_CABEZAS      + " VARCHAR, "
            + COLUMN_VACAS        + " VARCHAR, "
            + COLUMN_APOYOA       + " VARCHAR, "
            + COLUMN_APOYOB       + " VARCHAR, "
            + COLUMN_APOYOC       + " VARCHAR, "
            + COLUMN_APOYOD       + " VARCHAR, "
            + COLUMN_APOYOE       + " VARCHAR, "
            + COLUMN_APOYOF       + " VARCHAR, "
            + COLUMN_APOYOG       + " VARCHAR, "
            + COLUMN_APOYOH       + " VARCHAR, "
            + COLUMN_DOCINE       + " VARCHAR, "
            + COLUMN_DOCCURP      + " VARCHAR, "
            + COLUMN_DOCCLABE     + " VARCHAR, "
            + COLUMN_DOCFOLIO     + " VARCHAR, "
            + COLUMN_OP1          + " VARCHAR, "
            + COLUMN_OP2          + " VARCHAR, "
            + COLUMN_OP3          + " VARCHAR, "
            + COLUMN_OP4          + " VARCHAR, "
            + COLUMN_OP5          + " VARCHAR, "
            + COLUMN_OP6          + " VARCHAR, "
            + COLUMN_OP7          + " VARCHAR, "
            + COLUMN_OP8          + " VARCHAR, "
            + COLUMN_OP9          + " VARCHAR, "
            + COLUMN_OP10         + " VARCHAR, "
            + COLUMN_OP11         + " VARCHAR, "
            + COLUMN_REA1         + " VARCHAR, "
            + COLUMN_REA2         + " VARCHAR, "
            + COLUMN_REA3         + " VARCHAR, "
            + COLUMN_REA4         + " VARCHAR, "
            + COLUMN_REA5         + " VARCHAR, "
            + COLUMN_REA6         + " VARCHAR, "
            + COLUMN_REA7         + " VARCHAR, "
            + COLUMN_REA8A        + " VARCHAR, "
            + COLUMN_REA8B        + " VARCHAR, "
            + COLUMN_REA8C        + " VARCHAR, "
            + COLUMN_REA8D        + " VARCHAR, "
            + COLUMN_REA8E        + " VARCHAR, "
            + COLUMN_REA8F        + " VARCHAR, "
            + COLUMN_REA8G        + " VARCHAR, "
            + COLUMN_REA8H        + " VARCHAR, "
            + COLUMN_REA8I        + " VARCHAR, "
            + COLUMN_REA8OTRO     + " VARCHAR, "
            + COLUMN_REA9         + " VARCHAR, "
            + COLUMN_REA10        + " VARCHAR, "
            + COLUMN_REA11        + " VARCHAR, "
            + COLUMN_REA12        + " VARCHAR, "
            + COLUMN_FOTO1 + " VARCHAR, "
            + COLUMN_FOTO2 + " VARCHAR, "
            + COLUMN_LONGITUD + " VARCHAR, "
            + COLUMN_LATITUD + " VARCHAR); " ;
}
