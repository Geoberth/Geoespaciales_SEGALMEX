package com.example.geosegalmex.PGBeneficiariosGranosIncentivos;

public class PGBeneficiariosGranosIncentivos_bd {

    public static final String TABLA_BD = "TB_PG_BENEFICIARIO_ESTIMULOS";
    public static final String COLUMN_FOLIO = "FOLIO";
    public static final String COLUMN_FECHA = "FECHA";
    public static final String COLUMN_NOMBRE = "NOMBRE";
    public static final String COLUMN_PATERNO = "PATERNO";
    public static final String COLUMN_MATERNO = "MATERNO";
    public static final String COLUMN_CURP = "CURP";
    public static final String COLUMN_CALLE = "CALLE";
    public static final String COLUMN_EXT = "EXT";
    public static final String COLUMN_INT = "INT";
    public static final String COLUMN_LOCALIDAD = "LOCALIDADB";
    public static final String COLUMN_CP = "CPBE";
    public static final String COLUMN_CVEESTADO = "CLAVEEDOBE";
    public static final String COLUMN_ESTADO = "ENTIDADBE";
    public static final String COLUMN_CVEMUNICIPIO = "CLAVEMUNBE";
    public static final String COLUMN_MUNICIPIO = "MUNICIPIOB";
    public static final String COLUMN_LOCALIDAD2 = "LOCALIDAD";
    public static final String COLUMN_CP2 = "CP";
    public static final String COLUMN_CVEESTADO2 = "CLAVEEDO";
    public static final String COLUMN_ESTADO2 = "ENTIDAD";
    public static final String COLUMN_CVEMUNICIPIO2 = "CLAVEMUN";
    public static final String COLUMN_MUNICIPIO2 = "MUNICIPIO";
    public static final String COLUMN_ESTADO3 = "ENTIDAD2";
    public static final String COLUMN_MUNICIPIO3 = "MUNICIPIO2";
    public static final String COLUMN_ESTADO4 = "ENTIDAD3";
    public static final String COLUMN_MUNICIPIO4 = "MUNICIPIO3";
    public static final String COLUMN_ESTADO5 = "ENTIDAD4";
    public static final String COLUMN_MUNICIPIO5 = "MUNICIPIO4";
    public static final String COLUMN_ESTADO6 = "ENTIDAD5";
    public static final String COLUMN_MUNICIPIO6 = "MUNICIPIO5";
    public static final String COLUMN_SEXO = "SEXO";
    public static final String COLUMN_EDAD = "EDAD";
    public static final String COLUMN_LEER = "LEER";
    public static final String COLUMN_GRADO = "GRADO";
    public static final String COLUMN_GRADOOTRO = "GRADOOTRO";
    public static final String COLUMN_PRODUCTO = "PRODUCTO";
    public static final String COLUMN_PESO = "PESO";
    public static final String COLUMN_CUATRO1 = "INFORM1";
    public static final String COLUMN_CUATRO2 = "INFORM2";
    public static final String COLUMN_CUATRO3 = "INFORM3";
    public static final String COLUMN_CUATRO4 = "INFORM4";
    public static final String COLUMN_CUATRO5 = "INFORM5";
    public static final String COLUMN_CUATRO6 = "INFORM6";
    public static final String COLUMN_CUATRO8 = "INFORM7";
    public static final String COLUMN_CUATRO9 = "INFORM8";
    public static final String COLUMN_CINCO1 = "P1";
    public static final String COLUMN_CINCO2 = "P2";
    public static final String COLUMN_CINCO3 = "P3";
    public static final String COLUMN_CINCO4 = "P4";
    public static final String COLUMN_CINCO5 = "P5";
    public static final String COLUMN_SEIS1 = "P6";
    public static final String COLUMN_SEIS2 = "P7";
    public static final String COLUMN_SEIS3 = "P8";
    public static final String COLUMN_SEIS4 = "P9";
    public static final String COLUMN_SEIS5 = "P10";
    public static final String COLUMN_SEIS6 = "P11";
    public static final String COLUMN_SEIS7 = "P12";
    public static final String COLUMN_SEIS8 = "P13";
    public static final String COLUMN_SEIS9 = "P14";
    public static final String COLUMN_SIETE1 = "P15";
    public static final String COLUMN_SIETE2 = "P16";
    public static final String COLUMN_SIETE3 = "P17";
    public static final String COLUMN_SIETE4 = "P18";
    public static final String COLUMN_SIETE5 = "P19";
    public static final String COLUMN_OCHO1 = "P20";
    public static final String COLUMN_OCHO2 = "P21";
    public static final String COLUMN_OCHO3 = "P22";
    public static final String COLUMN_OCHO4 = "P23";
    public static final String COLUMN_OCHO5 = "P24";
    public static final String COLUMN_OCHO6 = "P25";
    public static final String COLUMN_OCHO7 = "P26";
    public static final String COLUMN_NUEVE1 = "P27A";
    public static final String COLUMN_NUEVE2 = "P27B";
    public static final String COLUMN_NUEVE3 = "P27C";
    public static final String COLUMN_NUEVE4 = "P27D";
    public static final String COLUMN_NUEVE5 = "P27E";
    public static final String COLUMN_NUEVE6 = "P27F";
    public static final String COLUMN_NUEVE7 = "P27G";
    public static final String COLUMN_NUEVE8 = "P27H";
    public static final String COLUMN_NUEVE9 = "P27I";
    public static final String COLUMN_NUEVE10 = "P27J";
    public static final String COLUMN_NUEVEOTRO = "P27OTRO";
    public static final String COLUMN_DIEZ = "P28";
    public static final String COLUMN_ONCE = "P29";
    public static final String COLUMN_DOCE = "P30";
    public static final String COLUMN_TRECE = "P31";
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
            + COLUMN_ESTADO3 + " VARCHAR, "
            + COLUMN_MUNICIPIO3+ " VARCHAR, "
            + COLUMN_ESTADO4 + " VARCHAR, "
            + COLUMN_MUNICIPIO4+ " VARCHAR, "
            + COLUMN_ESTADO5 + " VARCHAR, "
            + COLUMN_MUNICIPIO5+ " VARCHAR, "
            + COLUMN_ESTADO6 + " VARCHAR, "
            + COLUMN_MUNICIPIO6+ " VARCHAR, "
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
            + COLUMN_SEIS9             + " VARCHAR, "
            + COLUMN_SIETE1            + " VARCHAR, "
            + COLUMN_SIETE2            + " VARCHAR, "
            + COLUMN_SIETE3            + " VARCHAR, "
            + COLUMN_SIETE4            + " VARCHAR, "
            + COLUMN_SIETE5            + " VARCHAR, "
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
            + COLUMN_NUEVE10            + " VARCHAR, "
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
