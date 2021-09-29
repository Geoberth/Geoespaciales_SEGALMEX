package com.example.geosegalmex.drawer.fragment_drawer.bdusers;

public class UtilidadesUsuarios {
    public static final String TABLA_USUARIOS = "TbUsers";
    public static final String COLUMN_ID_USER = "IdUsers";
    public static final String COLUMN_INVEST = "INVSTRESPON";
    public static final String COLUMN_USUARIO = "USUARIO";
    public static final String COLUMN_PASSWD = "PASSWORD";

    public static final String CREAR_TABLA_USUARIOS = "CREATE TABLE " + TABLA_USUARIOS +
            "(" + COLUMN_ID_USER +
            " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_INVEST +
            " VARCHAR, " + COLUMN_USUARIO +
            " VARCHAR, "+ COLUMN_PASSWD +
            " VARCHAR);";

}
