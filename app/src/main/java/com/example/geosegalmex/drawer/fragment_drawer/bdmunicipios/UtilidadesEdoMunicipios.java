package com.example.geosegalmex.drawer.fragment_drawer.bdmunicipios;

public class UtilidadesEdoMunicipios {
    public static final String TABLA_MUNICIPIOS         = "TbMunicipios";
    public static final String COLUMN_ID_MUNICIPIO       = "idMunip";
    public static final String COLUMN_CVE_ENT    = "CVE_ENT";
    public static final String COLUMN_CVE_MUN = "CVE_MUN";
    public static final String COLUMN_CVEGEO    = "CVEGEO";
    public static final String COLUMN_NOM_ENT    = "NOM_ENT";
    public static final String COLUMN_NOM_MUN    = "NOM_MUN";


    public static final String CREAR_TABLA_WAZURE = "CREATE TABLE " + TABLA_MUNICIPIOS +
            "(" + COLUMN_ID_MUNICIPIO +
            " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_CVE_ENT +
            " INTEGER, " + COLUMN_CVE_MUN +
            " INTEGER, "+ COLUMN_CVEGEO +
            " INTEGER, "+ COLUMN_NOM_ENT +
            " VARCHAR, "+ COLUMN_NOM_MUN +
            " VARCHAR);";
}
