package com.example.geosegalmex.unidadproduccion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;

import com.example.geosegalmex.R;
import com.example.geosegalmex.unidadproduccion.variables.VariablesGlobalesUpf;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class TiposAlimentosTres extends AppCompatActivity {
    ExtendedFloatingActionButton fabAliTres;

    private String	ALICOMP	= null;	//	Text
    private String	ALICOMPFrutas= null;	//	Text
    private String	ALICOMPHortalizas= null;	//	Text
    private String	ALICOMPGranos= null;	//	Text
    private String	ALICOMPCarne= null;	//	Text
    private String	ALICOMPLeche= null;	//	Text


    private String	DOCOMP	= null;	//	Text
    private String	DOCOMPDirectoPro = null;	//	Text
    private String	DOCOMPMercLocal	= null;	//	Text
    private String	DOCOMPMercMun	= null;	//	Text
    private String	DOCOMPInds	= null;	//	Text



    private String	ALICOMPNEC	= null;	//	Text



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tipos_alimentos_tres);

        fabAliTres = findViewById(R.id.fab_next_pro_altres);

        fabAliTres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*
                VariablesGlobalesUpf.ALICOMP=  ALICOMP;	//	Text
                	//	Text
                VariablesGlobalesUpf.DOCOMP= DOCOMP ;	//	Text
                */
                Boolean valCampos = validarCampos();

                if(valCampos) {
                    Snackbar snackbar = Snackbar.make(v, "Verique los campos incompletos", Snackbar.LENGTH_SHORT);
                    snackbar.show();

                }else{
                    VariablesGlobalesUpf.ALICOMPFrutas = ALICOMPFrutas;    //	Text
                    VariablesGlobalesUpf.ALICOMPHortalizas = ALICOMPHortalizas;    //	Text
                    VariablesGlobalesUpf.ALICOMPGranos = ALICOMPGranos;    //	Text
                    VariablesGlobalesUpf.ALICOMPCarne = ALICOMPCarne;    //	Text
                    VariablesGlobalesUpf.ALICOMPLeche = ALICOMPLeche;    //	Text

                    VariablesGlobalesUpf.DOCOMPDirectoPro = DOCOMPDirectoPro;    //	Text
                    VariablesGlobalesUpf.DOCOMPMercLocal = DOCOMPMercLocal;    //	Text
                    VariablesGlobalesUpf.DOCOMPMercMun = DOCOMPMercMun;    //	Text
                    VariablesGlobalesUpf.DOCOMPInds = DOCOMPInds;    //	Text

                    VariablesGlobalesUpf.ALICOMPNEC = ALICOMPNEC;
                    startActivity(new Intent(getApplication(), TenenciaTierra.class));
                }
            }
        });
    }

    private Boolean validarCampos() {
        Boolean alimeCompras = true;
        Boolean compProductos = true;

        if(ALICOMPFrutas != null || ALICOMPHortalizas != null  || ALICOMPGranos != null || ALICOMPCarne != null  || ALICOMPLeche != null  ){
            alimeCompras = false;
        }else{
            alimeCompras = true;
        }

        if(DOCOMPDirectoPro != null  || DOCOMPMercLocal != null  || DOCOMPMercMun != null  || DOCOMPInds != null ){
            compProductos = false;
        }else {
            compProductos = true;
        }

        if(alimeCompras == false && compProductos == false && ALICOMPNEC != null ){
            return false;
        }else {
            return true;
        }
    }

    @Override
    public void onBackPressed() {


    }

    public void cubreNecesidad(View view) {
        boolean checkedTipo = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.cubre_si:
                if (checkedTipo) {
                    ALICOMPNEC = "Si";
                }
                break;
            case R.id.cubre_no:
                if (checkedTipo) {
                    ALICOMPNEC = "No";
                }
                break;
        }
    }

    public void dondeCompraAli(View view) {
        boolean checkedTipo = ((CheckBox) view).isChecked();

        switch (view.getId()) {
            case R.id.directo_productor:
                if (checkedTipo) {
                    DOCOMPDirectoPro = "Directo al Productor";
                } else {
                    DOCOMPDirectoPro = null;
                }
                break;
            case R.id.mercado_local:
                if (checkedTipo) {
                    DOCOMPMercLocal = "Mercado local";
                } else {
                    DOCOMPMercLocal = null;
                }
                break;
            case R.id.mercado_municipal:
                if (checkedTipo) {
                    DOCOMPMercMun = "Mercado municipal";
                } else {
                    DOCOMPMercMun = null;
                }
                break;
            case R.id.industria:
                if (checkedTipo) {
                    DOCOMPInds = "Industria";
                } else {
                    DOCOMPInds = null;
                }
                break;
        }
    }

    public void compraAlimentos(View view) {
        boolean checkedTipo = ((CheckBox) view).isChecked();

        switch (view.getId()) {
            case R.id.frutas:
                if (checkedTipo) {
                    ALICOMPFrutas = "Frutas";
                } else {
                    ALICOMPFrutas = null;
                }
                break;
            case R.id.hortalizas:
                if (checkedTipo) {
                    ALICOMPHortalizas = "Hortalizas";
                } else {
                    ALICOMPHortalizas = null;
                }
                break;
            case R.id.granos:
                if (checkedTipo) {
                    ALICOMPGranos = "Granos";
                } else {
                    ALICOMPGranos = null;
                }
                break;
            case R.id.carne:
                if (checkedTipo) {
                    ALICOMPCarne = "Carne";
                } else {
                    ALICOMPCarne = null;
                }
                break;
            case R.id.leche:
                if (checkedTipo) {
                    ALICOMPLeche = "Leche";
                } else {
                    ALICOMPLeche = null;
                }
                break;
        }

    }
}
