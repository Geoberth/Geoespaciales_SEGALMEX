package com.example.geosegalmex.dbstorage;

public class Georreferencia {
    private String idFolBriGeo;
    private String idFolProGeo;
    private String longitudGeo;
    private String latitudGeo;
    private int Status;

    public Georreferencia(String idFolBriGeo, String idFolProGeo, String longitudGeo, String latitudGeo, int status) {
        this.idFolBriGeo = idFolBriGeo;
        this.idFolProGeo = idFolProGeo;
        this.longitudGeo = longitudGeo;
        this.latitudGeo = latitudGeo;
        Status = status;

    }

    public String getIdFolBriGeo() {
        return idFolBriGeo;
    }

    public void setIdFolBriGeo(String idFolBriGeo) {
        this.idFolBriGeo = idFolBriGeo;
    }

    public String getIdFolProGeo() {
        return idFolProGeo;
    }

    public void setIdFolProGeo(String idFolProGeo) {
        this.idFolProGeo = idFolProGeo;
    }

    public String getLongitudGeo() {
        return longitudGeo;
    }

    public void setLongitudGeo(String longitudGeo) {
        this.longitudGeo = longitudGeo;
    }

    public String getLatitudGeo() {
        return latitudGeo;
    }

    public void setLatitudGeo(String latitudGeo) {
        this.latitudGeo = latitudGeo;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int status) {
        Status = status;
    }
}
