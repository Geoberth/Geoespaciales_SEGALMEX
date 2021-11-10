package com.example.geosegalmex.PGOperativoEstimulos;

public class PGOperativoEstimulos_bd {

        public static final String TABLA_BD = "TB_PG_OPERATIVO_ESTIMULOS";
        public static final String COLUMN_FOLIO = "FOLIO";
        public static final String COLUMN_FECHA = "FECHA";

        public static final String COLUMN_VENTANILLA = "VENTANILLA";
        public static final String COLUMN_CVEESTADO = "CVEESTADO";
        public static final String COLUMN_ESTADO = "ESTADO";
        public static final String COLUMN_CVEMUNICIPIO = "CVEMUNICIPIO";
        public static final String COLUMN_MUNICIPIO = "MUNICIPIO";
        public static final String COLUMN_CVELOCALIDAD = "CVELOC";
        public static final String COLUMN_LOCALIDAD = "LOCALIDAD";
        public static final String COLUMN_CALLE = "CALLE";
        public static final String COLUMN_CP = "CP";
        public static final String COLUMN_UNO = "UNO";
        public static final String COLUMN_DOS = "DOS";
        public static final String COLUMN_TRES = "TRES";
        public static final String COLUMN_CUATRO = "CUATRO";
        public static final String COLUMN_CINCO = "CINCO";
        public static final String COLUMN_SEIS = "SEIS";
        public static final String COLUMN_SIETE = "SIETE";
        public static final String COLUMN_OCHO = "OCHO";

        public static final String COLUMN_FOTO1 = "FOTO1";
        public static final String COLUMN_FOTO2 = "FOTO2";
        public static final String COLUMN_LONGITUD = "LONGITUD";
        public static final String COLUMN_LATITUD = "LATITUD";

        public static final String CREAR_TABLA_PG_OPERATIVO_ESTIMULOS= "CREATE TABLE " + TABLA_BD + "("
                + COLUMN_FOLIO + " VARCHAR PRIMARY KEY, "
                + COLUMN_FECHA + " VARCHAR, "

                + COLUMN_VENTANILLA + " VARCHAR, "
                + COLUMN_CVEESTADO + " VARCHAR, "
                + COLUMN_ESTADO + " VARCHAR, "
                + COLUMN_CVEMUNICIPIO + " VARCHAR, "
                + COLUMN_MUNICIPIO + " VARCHAR, "
                + COLUMN_CVELOCALIDAD + " VARCHAR, "
                + COLUMN_LOCALIDAD + " VARCHAR, "
                + COLUMN_CALLE + " VARCHAR, "
                + COLUMN_CP + " VARCHAR, "
                + COLUMN_UNO + " VARCHAR, "
                + COLUMN_DOS + " VARCHAR, "
                + COLUMN_TRES + " VARCHAR, "
                + COLUMN_CUATRO + " VARCHAR, "
                + COLUMN_CINCO + " VARCHAR, "
                + COLUMN_SEIS + " VARCHAR, "
                + COLUMN_SIETE + " VARCHAR, "
                + COLUMN_OCHO + " VARCHAR, "

                + COLUMN_FOTO1 + " VARCHAR, "
                + COLUMN_FOTO2 + " VARCHAR, "
                + COLUMN_LONGITUD + " VARCHAR, "
                + COLUMN_LATITUD + " VARCHAR); " ;

}
