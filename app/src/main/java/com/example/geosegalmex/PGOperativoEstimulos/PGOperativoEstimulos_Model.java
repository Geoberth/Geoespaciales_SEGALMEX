package com.example.geosegalmex.PGOperativoEstimulos;

import java.io.Serializable;

public class PGOperativoEstimulos_Model implements Serializable {

    private String folio, fecha, ventanilla, cveestado, estado, cvemunicipio, municipio, cvelocalidad, localidad, calle, cp, uno, dos, tres, cuatro, cinco, seis, siete, ocho, foto1, foto2, longitudGeo, latitudGeo;

    public PGOperativoEstimulos_Model() {
    }

    public PGOperativoEstimulos_Model(String folio, String fecha, String ventanilla, String cveestado, String estado, String cvemunicipio, String municipio, String cvelocalidad, String localidad, String calle, String cp, String uno, String dos, String tres, String cuatro, String cinco, String seis, String siete, String ocho, String foto1, String foto2, String longitudGeo, String latitudGeo) {
        this.folio = folio;
        this.fecha = fecha;
        this.ventanilla = ventanilla;
        this.cveestado = cveestado;
        this.estado = estado;
        this.cvemunicipio = cvemunicipio;
        this.municipio = municipio;
        this.cvelocalidad = cvelocalidad;
        this.localidad = localidad;
        this.calle = calle;
        this.cp = cp;
        this.uno = uno;
        this.dos = dos;
        this.tres = tres;
        this.cuatro = cuatro;
        this.cinco = cinco;
        this.seis = seis;
        this.siete = siete;
        this.ocho = ocho;

        this.foto1 = foto1;
        this.foto2 = foto2;
        this.longitudGeo = longitudGeo;
        this.latitudGeo = latitudGeo;
    }

    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getVentanilla() {
        return ventanilla;
    }

    public void setVentanilla(String ventanilla) {
        this.ventanilla = ventanilla;
    }

    public String getCveestado() {
        return cveestado;
    }

    public void setCveestado(String cveestado) {
        this.cveestado = cveestado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCvemunicipio() {
        return cvemunicipio;
    }

    public void setCvemunicipio(String cvemunicipio) {
        this.cvemunicipio = cvemunicipio;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getCvelocalidad() {
        return cvelocalidad;
    }

    public void setCvelocalidad(String cvelocalidad) {
        this.cvelocalidad = cvelocalidad;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public String getUno() {
        return uno;
    }

    public void setUno(String uno) {
        this.uno = uno;
    }

    public String getDos() {
        return dos;
    }

    public void setDos(String dos) {
        this.dos = dos;
    }

    public String getTres() {
        return tres;
    }

    public void setTres(String tres) {
        this.tres = tres;
    }

    public String getCuatro() {
        return cuatro;
    }

    public void setCuatro(String cuatro) {
        this.cuatro = cuatro;
    }

    public String getCinco() {
        return cinco;
    }

    public void setCinco(String cinco) {
        this.cinco = cinco;
    }

    public String getSeis() {
        return seis;
    }

    public void setSeis(String seis) {
        this.seis = seis;
    }

    public String getSiete() {
        return siete;
    }

    public void setSiete(String siete) {
        this.siete = siete;
    }

    public String getOcho() {
        return ocho;
    }

    public void setOcho(String ocho) {
        this.ocho = ocho;
    }


    public String getFoto1() {
        return foto1;
    }

    public void setFoto1(String foto1) {
        this.foto1 = foto1;
    }

    public String getFoto2() {
        return foto2;
    }

    public void setFoto2(String foto2) {
        this.foto2 = foto2;
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
}
