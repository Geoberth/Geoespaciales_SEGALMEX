package com.example.geosegalmex.drawer.fragment_drawer.bdmunicipios;

public class ModelMunicipios {
    private int COLUMN_CVE_ENT;
    private int COLUMN_CVE_MUN;
    private int COLUMN_CVEGEO;
    private String COLUMN_NOM_ENT;
    private String NOM_MUN;

    public ModelMunicipios(int COLUMN_CVE_ENT, int COLUMN_CVE_MUN, int COLUMN_CVEGEO, String COLUMN_NOM_ENT, String NOM_MUN) {
        this.COLUMN_CVE_ENT = COLUMN_CVE_ENT;
        this.COLUMN_CVE_MUN = COLUMN_CVE_MUN;
        this.COLUMN_CVEGEO = COLUMN_CVEGEO;
        this.COLUMN_NOM_ENT = COLUMN_NOM_ENT;
        this.NOM_MUN = NOM_MUN;
    }

    public int getCOLUMN_CVE_ENT() {
        return COLUMN_CVE_ENT;
    }

    public void setCOLUMN_CVE_ENT(int COLUMN_CVE_ENT) {
        this.COLUMN_CVE_ENT = COLUMN_CVE_ENT;
    }

    public int getCOLUMN_CVE_MUN() {
        return COLUMN_CVE_MUN;
    }

    public void setCOLUMN_CVE_MUN(int COLUMN_CVE_MUN) {
        this.COLUMN_CVE_MUN = COLUMN_CVE_MUN;
    }

    public int getCOLUMN_CVEGEO() {
        return COLUMN_CVEGEO;
    }

    public void setCOLUMN_CVEGEO(int COLUMN_CVEGEO) {
        this.COLUMN_CVEGEO = COLUMN_CVEGEO;
    }

    public String getCOLUMN_NOM_ENT() {
        return COLUMN_NOM_ENT;
    }

    public void setCOLUMN_NOM_ENT(String COLUMN_NOM_ENT) {
        this.COLUMN_NOM_ENT = COLUMN_NOM_ENT;
    }

    public String getNOM_MUN() {
        return NOM_MUN;
    }

    public void setNOM_MUN(String NOM_MUN) {
        this.NOM_MUN = NOM_MUN;
    }
}
