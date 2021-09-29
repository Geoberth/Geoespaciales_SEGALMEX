package com.example.geosegalmex.caracterizacion.variables_caracterizacion;

public class ConservaGranos {
    String nombGranosAlmc;
    String nombGranosAlmcOtro;
    String costoGranosAlmc;

    public ConservaGranos(String nombGranosAlmc, String nombGranosAlmcOtro, String costoGranosAlmc) {
        this.nombGranosAlmc = nombGranosAlmc;
        this.nombGranosAlmcOtro = nombGranosAlmcOtro;
        this.costoGranosAlmc = costoGranosAlmc;
    }


    public String getNombGranosAlmc() {
        return nombGranosAlmc;
    }

    public void setNombGranosAlmc(String nombGranosAlmc) {
        this.nombGranosAlmc = nombGranosAlmc;
    }

    public String getNombGranosAlmcOtro() {
        return nombGranosAlmcOtro;
    }

    public void setNombGranosAlmcOtro(String nombGranosAlmcOtro) {
        this.nombGranosAlmcOtro = nombGranosAlmcOtro;
    }

    public String getCostoGranosAlmc() {
        return costoGranosAlmc;
    }

    public void setCostoGranosAlmc(String costoGranosAlmc) {
        this.costoGranosAlmc = costoGranosAlmc;
    }
}
