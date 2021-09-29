package com.example.geosegalmex.drawer.fragment_drawer.bdusers;

public class ModelUsuarios {
    String INVSTRESPON;
    String USUARIO;
    String PASSWORD;

    public ModelUsuarios(String INVSTRESPON, String USUARIO, String PASSWORD) {
        this.INVSTRESPON = INVSTRESPON;
        this.USUARIO = USUARIO;
        this.PASSWORD = PASSWORD;
    }

    public String getINVSTRESPON() {
        return INVSTRESPON;
    }

    public void setINVSTRESPON(String INVSTRESPON) {
        this.INVSTRESPON = INVSTRESPON;
    }

    public String getUSUARIO() {
        return USUARIO;
    }

    public void setUSUARIO(String USUARIO) {
        this.USUARIO = USUARIO;
    }

    public String getPASSWORD() {
        return PASSWORD;
    }

    public void setPASSWORD(String PASSWORD) {
        this.PASSWORD = PASSWORD;
    }
}
