package com.example.geosegalmex.unidadproduccion.model;

public class ActividadAgricola {
    private String nombreActividad;
    private String superficie;
    private int Status;

    public ActividadAgricola(String nombreActividad, String superficie, int status) {
        this.nombreActividad = nombreActividad;
        this.superficie = superficie;
        Status = status;
    }

    public String getNombreActividad() {
        return nombreActividad;
    }

    public void setNombreActividad(String nombreActividad) {
        this.nombreActividad = nombreActividad;
    }

    public String getSuperficie() {
        return superficie;
    }

    public void setSuperficie(String superficie) {
        this.superficie = superficie;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int status) {
        Status = status;
    }
}
