package com.example.geosegalmex.LiconsaVentanilla;

public class pasl_operativo_bd {

    public static final String TABLA_BD = "TB_PASL_OPERATIVO";
    public static final String COLUMN_FOLIO = "FOLIO";
    public static final String COLUMN_FECHA = "FECHA";
    public static final String COLUMN_CVEESTADO = "CVEESTADO";
    public static final String COLUMN_ESTADO = "ESTADO";
    public static final String COLUMN_CVEMUNICIPIO = "CVEMUNICIPIO";
    public static final String COLUMN_MUNICIPIO = "MUNICIPIO";
    public static final String COLUMN_CVELOCALIDAD = "CVELOC";
    public static final String COLUMN_LOCALIDAD = "LOCALIDAD";
    public static final String COLUMN_NOMBRE = "NOMBRE";
    public static final String COLUMN_APATERNO = "APATERNO";
    public static final String COLUMN_AMATERNO = "AMATERNO";
    public static final String COLUMN_SEXO = "SEXO";
    public static final String COLUMN_EDAD = "EDAD";
    public static final String COLUMN_TIEMPO = "TIEMPO";
    public static final String COLUMN_UNO = "UNO";
    public static final String COLUMN_DOS = "DOS";
    public static final String COLUMN_TRES = "TRES";
    public static final String COLUMN_CUATRO = "CUATRO";
    public static final String COLUMN_CINCO = "CINCO";
    public static final String COLUMN_SEIS = "SEIS";
    public static final String COLUMN_SIETE = "SIETE";
    public static final String COLUMN_OCHO = "OCHO";
    public static final String COLUMN_NUEVE = "NUEVE";
    public static final String COLUMN_DIEZ= "DIEZ";
    public static final String COLUMN_ONCE = "ONCE";
    public static final String COLUMN_DOCE = "DOCE";
    public static final String COLUMN_TRECE = "TRECE";
    public static final String COLUMN_CATORCE = "CATORCE";
    public static final String COLUMN_QUINCE = "QUINCE";
    public static final String COLUMN_FOTO1 = "FOTO1";
    public static final String COLUMN_FOTO2 = "FOTO2";
    public static final String COLUMN_LONGITUD = "LONGITUD";
    public static final String COLUMN_LATITUD = "LATITUD";

    public static final String CREAR_TABLA_PASL_OPERATIVO= "CREATE TABLE " + TABLA_BD + "("
            + COLUMN_FOLIO + " VARCHAR PRIMARY KEY, "
            + COLUMN_FECHA + " VARCHAR, "
            + COLUMN_CVEESTADO + " VARCHAR, "
            + COLUMN_ESTADO + " VARCHAR, "
            + COLUMN_CVEMUNICIPIO + " VARCHAR, "
            + COLUMN_MUNICIPIO + " VARCHAR, "
            + COLUMN_CVELOCALIDAD + " VARCHAR, "
            + COLUMN_LOCALIDAD + " VARCHAR, "
            + COLUMN_NOMBRE + " VARCHAR, "
            + COLUMN_APATERNO + " VARCHAR, "
            + COLUMN_AMATERNO + " VARCHAR, "
            + COLUMN_SEXO + " VARCHAR, "
            + COLUMN_EDAD + " VARCHAR, "
            + COLUMN_TIEMPO + " VARCHAR, "
            + COLUMN_UNO + " VARCHAR, "
            + COLUMN_DOS + " VARCHAR, "
            + COLUMN_TRES + " VARCHAR, "
            + COLUMN_CUATRO + " VARCHAR, "
            + COLUMN_CINCO + " VARCHAR, "
            + COLUMN_SEIS + " VARCHAR, "
            + COLUMN_SIETE + " VARCHAR, "
            + COLUMN_OCHO + " VARCHAR, "
            + COLUMN_NUEVE + " VARCHAR, "
            + COLUMN_DIEZ + " VARCHAR, "
            + COLUMN_ONCE + " VARCHAR, "
            + COLUMN_DOCE + " VARCHAR, "
            + COLUMN_TRECE + " VARCHAR, "
            + COLUMN_CATORCE + " VARCHAR, "
            + COLUMN_QUINCE + " VARCHAR, "
            + COLUMN_FOTO1 + " VARCHAR, "
            + COLUMN_FOTO2 + " VARCHAR, "
            + COLUMN_LONGITUD + " VARCHAR, "
            + COLUMN_LATITUD + " VARCHAR); " ;
}
