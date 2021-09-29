package com.example.geosegalmex.Gps;

public class Trayectoria {
    private String folioproductor;
    private String foliotecnico;
    private String latitud;
    private String longitud;
    private String horaTrayectoria;
    private String fechaTrayectoria;

    public Trayectoria(String folioproductor, String foliotecnico, String latitud, String longitud, String horaTrayectoria, String fechaTrayectoria) {
        this.folioproductor = folioproductor;
        this.foliotecnico = foliotecnico;
        this.latitud = latitud;
        this.longitud = longitud;
        this.horaTrayectoria = horaTrayectoria;
        this.fechaTrayectoria = fechaTrayectoria;
    }

    public String getFolioproductor() {
        return folioproductor;
    }

    public void setFolioproductor(String folioproductor) {
        this.folioproductor = folioproductor;
    }

    public String getFoliotecnico() {
        return foliotecnico;
    }

    public void setFoliotecnico(String foliotecnico) {
        this.foliotecnico = foliotecnico;
    }

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    public String getHoraTrayectoria() {
        return horaTrayectoria;
    }

    public void setHoraTrayectoria(String horaTrayectoria) {
        this.horaTrayectoria = horaTrayectoria;
    }

    public String getFechaTrayectoria() {
        return fechaTrayectoria;
    }

    public void setFechaTrayectoria(String fechaTrayectoria) {
        this.fechaTrayectoria = fechaTrayectoria;
    }
}
