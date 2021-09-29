package com.example.geosegalmex.Gps;

public class UtilidadesTrayectoria {
    public static final String TABLA_TRAYECTORIA = "TBTrayectoria";
    public static final String COLUMN_IDTRAYECTORIA = "IDTRAYECTORIA";
    public static final String COLUMN_FOLIO = "FOLIO";
    //public static final String COLUMN_FOLIO_TECNICO= "FOLIOTECNICO";
    public static final String COLUMN_LONGITUD_TRAY = "LONGITUD";
    public static final String COLUMN_LATITUD_TRAY = "LATITUD";
    public static final String COLUMN_HRACTUAL_TRAY = "HRACTUAL";
    public static final String COLUMN_FCACTUAL_TRAY = "FCACTUAL";

    public static final String CREAR_TABLA_TRAYECTORIA = "CREATE TABLE " + TABLA_TRAYECTORIA +
            "(" + COLUMN_IDTRAYECTORIA +
            " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_FOLIO +
            //" VARCHAR, " + COLUMN_FOLIO_TECNICO +
            " VARCHAR, " + COLUMN_LONGITUD_TRAY +
            " VARCHAR, " + COLUMN_LATITUD_TRAY +
            " VARCHAR, " + COLUMN_HRACTUAL_TRAY +
            " VARCHAR, " + COLUMN_FCACTUAL_TRAY +
            " VARCHAR);";

}
