package com.example.geosegalmex.dbstorage;

public class Coordenadas {
    private int folioproductor;
    private int foliotecnico;
    private String gps;
    private String latitud;
    private String longitud;
    private int status;

    public Coordenadas(int folioproductor, int foliotecnico, String gps, String latitud, String longitud, int status) {
        this.folioproductor = folioproductor;
        this.foliotecnico = foliotecnico;
        this.gps = gps;
        this.latitud = latitud;
        this.longitud = longitud;
        this.status = status;
    }

    public int getFolioproductor() {
        return folioproductor;
    }

    public void setFolioproductor(int folioproductor) {
        this.folioproductor = folioproductor;
    }

    public int getFoliotecnico() {
        return foliotecnico;
    }

    public void setFoliotecnico(int foliotecnico) {
        this.foliotecnico = foliotecnico;
    }

    public String getGps() {
        return gps;
    }

    public void setGps(String gps) {
        this.gps = gps;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
