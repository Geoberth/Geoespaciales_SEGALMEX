package com.example.geosegalmex.caracterizacion.variables_caracterizacion;

public class ActividadesCosecha {
    String nombreCosecha;
    String numJorCosecha;

    public ActividadesCosecha(String nombreCosecha, String numJorCosecha) {
        this.nombreCosecha = nombreCosecha;
        this.numJorCosecha = numJorCosecha;
    }

    public String getNombreCosecha() {
        return nombreCosecha;
    }

    public void setNombreCosecha(String nombreCosecha) {
        this.nombreCosecha = nombreCosecha;
    }

    public String getNumJorCosecha() {
        return numJorCosecha;
    }

    public void setNumJorCosecha(String numJorCosecha) {
        this.numJorCosecha = numJorCosecha;
    }
}
