package com.example.geosegalmex.PGBeneficiariosGranosIncentivos;

public class PGBeneficiariosGranosIncentivos_bd {

    public static final String TABLA_BD = "TB_PG_BENEFICIARIO_GRANOS_INCENTIVOS";
    public static final String COLUMN_FOLIO = "FOLIO";
    public static final String COLUMN_FECHA = "FECHA";
    public static final String COLUMN_NOMBRE = "NOMBRE";
    public static final String COLUMN_PATERNO = "PATERNO";
    public static final String COLUMN_MATERNO = "MATERNO";
    public static final String COLUMN_CURP = "CURP";
    public static final String COLUMN_CALLE = "CALLE";
    public static final String COLUMN_EXT = "EXT";
    public static final String COLUMN_INT = "INT";
    public static final String COLUMN_LOCALIDAD = "LOCALIDAD";
    public static final String COLUMN_CP = "CP";
    public static final String COLUMN_CVEESTADO = "CVEEDO";
    public static final String COLUMN_ESTADO = "ENTIDAD";
    public static final String COLUMN_CVEMUNICIPIO = "CVEMUN";
    public static final String COLUMN_MUNICIPIO = "MUNICIPIO";
    public static final String COLUMN_LOCALIDAD2 = "LOCALIDAD2";
    public static final String COLUMN_CP2 = "CP2";
    public static final String COLUMN_CVEESTADO2 = "CVEEDO2";
    public static final String COLUMN_ESTADO2 = "ENTIDAD2";
    public static final String COLUMN_CVEMUNICIPIO2 = "CVEMUN2";
    public static final String COLUMN_MUNICIPIO2 = "MUNICIPIO2";
    public static final String COLUMN_SEXO = "SEXO";
    public static final String COLUMN_EDAD = "EDAD";
    public static final String COLUMN_LEER = "LEER";
    public static final String COLUMN_GRADO = "GRADO";
    public static final String COLUMN_GRADOOTRO = "GRADOOTRO";
    public static final String COLUMN_PRODUCTO = "PRODUCTO";
    public static final String COLUMN_PESO = "PESO";
    public static final String COLUMN_CUATRO1 = "CUATRO1";
    public static final String COLUMN_CUATRO2 = "CUATRO2";
    public static final String COLUMN_CUATRO3 = "CUATRO3";
    public static final String COLUMN_CUATRO4 = "CUATRO4";
    public static final String COLUMN_CUATRO5 = "CUATRO5";
    public static final String COLUMN_CUATRO6 = "CUATRO6";
    public static final String COLUMN_CUATRO7 = "CUATRO7";
    public static final String COLUMN_CUATRO8 = "CUATRO8";
    public static final String COLUMN_CUATRO9 = "CUATRO9";
    public static final String COLUMN_CINCO1 = "CINCO1";
    public static final String COLUMN_CINCO2 = "CINCO2";
    public static final String COLUMN_CINCO3 = "CINCO3";
    public static final String COLUMN_CINCO4 = "CINCO4";
    public static final String COLUMN_CINCO5 = "CINCO5";
    public static final String COLUMN_SEIS1 = "SEIS1";
    public static final String COLUMN_SEIS2 = "SEIS2";
    public static final String COLUMN_SEIS3 = "SEIS3";
    public static final String COLUMN_SEIS4 = "SEIS4";
    public static final String COLUMN_SEIS5 = "SEIS5";
    public static final String COLUMN_SEIS6 = "SEIS6";
    public static final String COLUMN_SEIS7 = "SEIS7";
    public static final String COLUMN_SEIS8 = "SEIS8";
    public static final String COLUMN_SIETE1 = "SIETE1";
    public static final String COLUMN_SIETE2 = "SIETE2";
    public static final String COLUMN_SIETE3 = "SIETE3";
    public static final String COLUMN_SIETE4 = "SIETE4";
    public static final String COLUMN_SIETE5 = "SIETE5";
    public static final String COLUMN_SIETE6 = "SIETE6";
    public static final String COLUMN_OCHO1 = "OCHO1";
    public static final String COLUMN_OCHO2 = "OCHO2";
    public static final String COLUMN_OCHO3 = "OCHO3";
    public static final String COLUMN_OCHO4 = "OCHO4";
    public static final String COLUMN_OCHO5 = "OCHO5";
    public static final String COLUMN_OCHO6 = "OCHO6";
    public static final String COLUMN_OCHO7 = "OCHO7";
    public static final String COLUMN_NUEVE1 = "NUEVE1";
    public static final String COLUMN_NUEVE2 = "NUEVE2";
    public static final String COLUMN_NUEVE3 = "NUEVE3";
    public static final String COLUMN_NUEVE4 = "NUEVE4";
    public static final String COLUMN_NUEVE5 = "NUEVE5";
    public static final String COLUMN_NUEVE6 = "NUEVE6";
    public static final String COLUMN_NUEVE7 = "NUEVE7";
    public static final String COLUMN_NUEVE8 = "NUEVE8";
    public static final String COLUMN_NUEVE9 = "NUEVE9";
    public static final String COLUMN_NUEVEOTRO = "NUEVEOTRO";
    public static final String COLUMN_DIEZ = "DIEZ";
    public static final String COLUMN_ONCE = "ONCE";
    public static final String COLUMN_DOCE = "DOCE";
    public static final String COLUMN_TRECE = "TRECE";
    public static final String COLUMN_FOTO1 = "FOTO1";
    public static final String COLUMN_FOTO2 = "FOTO2";
    public static final String COLUMN_LONGITUD = "LONGITUD";
    public static final String COLUMN_LATITUD = "LATITUD";

    public static final String CREAR_TABLA_PG_BENEFICIARIO_GRANOS_INCENTIVOS= "CREATE TABLE " + TABLA_BD + "("
            + COLUMN_FOLIO + " VARCHAR PRIMARY KEY, "
            + COLUMN_FECHA             + " VARCHAR, "
            + COLUMN_NOMBRE            + " VARCHAR, "
            + COLUMN_PATERNO           + " VARCHAR, "
            + COLUMN_MATERNO           + " VARCHAR, "
            + COLUMN_CURP              + " VARCHAR, "
            + COLUMN_CALLE             + " VARCHAR, "
            + COLUMN_EXT               + " VARCHAR, "
            + COLUMN_INT               + " VARCHAR, "
            + COLUMN_LOCALIDAD         + " VARCHAR, "
            + COLUMN_CP                + " VARCHAR, "
            + COLUMN_CVEESTADO         + " VARCHAR, "
            + COLUMN_ESTADO            + " VARCHAR, "
            + COLUMN_CVEMUNICIPIO      + " VARCHAR, "
            + COLUMN_MUNICIPIO         + " VARCHAR, "
            + COLUMN_LOCALIDAD2        + " VARCHAR, "
            + COLUMN_CP2               + " VARCHAR, "
            + COLUMN_CVEESTADO2        + " VARCHAR, "
            + COLUMN_ESTADO2           + " VARCHAR, "
            + COLUMN_CVEMUNICIPIO2     + " VARCHAR, "
            + COLUMN_MUNICIPIO2        + " VARCHAR, "
            + COLUMN_SEXO              + " VARCHAR, "
            + COLUMN_EDAD              + " VARCHAR, "
            + COLUMN_LEER              + " VARCHAR, "
            + COLUMN_GRADO             + " VARCHAR, "
            + COLUMN_GRADOOTRO         + " VARCHAR, "
            + COLUMN_PRODUCTO          + " VARCHAR, "
            + COLUMN_PESO              + " VARCHAR, "
            + COLUMN_CUATRO1           + " VARCHAR, "
            + COLUMN_CUATRO2           + " VARCHAR, "
            + COLUMN_CUATRO3           + " VARCHAR, "
            + COLUMN_CUATRO4           + " VARCHAR, "
            + COLUMN_CUATRO5           + " VARCHAR, "
            + COLUMN_CUATRO6           + " VARCHAR, "
            + COLUMN_CUATRO7           + " VARCHAR, "
            + COLUMN_CUATRO8           + " VARCHAR, "
            + COLUMN_CUATRO9           + " VARCHAR, "
            + COLUMN_CINCO1            + " VARCHAR, "
            + COLUMN_CINCO2            + " VARCHAR, "
            + COLUMN_CINCO3            + " VARCHAR, "
            + COLUMN_CINCO4            + " VARCHAR, "
            + COLUMN_CINCO5            + " VARCHAR, "
            + COLUMN_SEIS1             + " VARCHAR, "
            + COLUMN_SEIS2             + " VARCHAR, "
            + COLUMN_SEIS3             + " VARCHAR, "
            + COLUMN_SEIS4             + " VARCHAR, "
            + COLUMN_SEIS5             + " VARCHAR, "
            + COLUMN_SEIS6             + " VARCHAR, "
            + COLUMN_SEIS7             + " VARCHAR, "
            + COLUMN_SEIS8             + " VARCHAR, "
            + COLUMN_SIETE1            + " VARCHAR, "
            + COLUMN_SIETE2            + " VARCHAR, "
            + COLUMN_SIETE3            + " VARCHAR, "
            + COLUMN_SIETE4            + " VARCHAR, "
            + COLUMN_SIETE5            + " VARCHAR, "
            + COLUMN_SIETE6            + " VARCHAR, "
            + COLUMN_OCHO1             + " VARCHAR, "
            + COLUMN_OCHO2             + " VARCHAR, "
            + COLUMN_OCHO3             + " VARCHAR, "
            + COLUMN_OCHO4             + " VARCHAR, "
            + COLUMN_OCHO5             + " VARCHAR, "
            + COLUMN_OCHO6             + " VARCHAR, "
            + COLUMN_OCHO7             + " VARCHAR, "
            + COLUMN_NUEVE1            + " VARCHAR, "
            + COLUMN_NUEVE2            + " VARCHAR, "
            + COLUMN_NUEVE3            + " VARCHAR, "
            + COLUMN_NUEVE4            + " VARCHAR, "
            + COLUMN_NUEVE5            + " VARCHAR, "
            + COLUMN_NUEVE6            + " VARCHAR, "
            + COLUMN_NUEVE7            + " VARCHAR, "
            + COLUMN_NUEVE8            + " VARCHAR, "
            + COLUMN_NUEVE9            + " VARCHAR, "
            + COLUMN_NUEVEOTRO         + " VARCHAR, "
            + COLUMN_DIEZ              + " VARCHAR, "
            + COLUMN_ONCE              + " VARCHAR, "
            + COLUMN_DOCE              + " VARCHAR, "
            + COLUMN_TRECE             + " VARCHAR, "
            + COLUMN_FOTO1             + " VARCHAR, "
            + COLUMN_FOTO2             + " VARCHAR, "
            + COLUMN_LONGITUD          + " VARCHAR, "
            + COLUMN_LATITUD + " VARCHAR); " ;


}
