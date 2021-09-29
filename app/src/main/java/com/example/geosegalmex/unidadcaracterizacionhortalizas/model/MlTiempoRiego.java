package com.example.geosegalmex.unidadcaracterizacionhortalizas.model;

public class MlTiempoRiego {
    private int numRiego;
    private float cstAgua;
    private int numJorn;

    public MlTiempoRiego(int numRiego, float cstAgua, int numJorn) {
        this.numRiego = numRiego;
        this.cstAgua = cstAgua;
        this.numJorn = numJorn;
    }

    public int getNumRiego() {
        return numRiego;
    }

    public void setNumRiego(int numRiego) {
        this.numRiego = numRiego;
    }

    public float getCstAgua() {
        return cstAgua;
    }

    public void setCstAgua(float cstAgua) {
        this.cstAgua = cstAgua;
    }

    public int getNumJorn() {
        return numJorn;
    }

    public void setNumJorn(int numJorn) {
        this.numJorn = numJorn;
    }
}
