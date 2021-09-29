package com.example.geosegalmex.unidadproduccion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.geosegalmex.IdentificacionCuestionario;
import com.example.geosegalmex.R;
import com.example.geosegalmex.unidadcaracterizacionhortalizas.db.DatabaseHelper;
import com.example.geosegalmex.unidadproduccion.variables.VariablesGlobalesUpf;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class ModalidadHidrica extends AppCompatActivity {

    /*
    LinearLayout rios;
    LinearLayout arroyos;
    LinearLayout manantial;
    LinearLayout presas;
    LinearLayout pozo;
    LinearLayout laguna;
    LinearLayout tomaDomicilio;
    LinearLayout ollaAgua;
    LinearLayout bordoAlm;
    LinearLayout trataAgua;


     */
    EditText riegoAgricola;
    EditText riegoPecuaria;
    EditText temporalAgricola;
    EditText temporalPecuaria;
    ExtendedFloatingActionButton fabHidrica;
    LinearLayout lnAguaSi;

    //Superficie de la tierra
    private String	SACTAGRIRI	= null;	//	Integer
    private String	SACTPECRI	= null;	//	Integer
    private String	SACTAGRITE	= null;	//	Integer
    private String	SACTPECTE	= null;	//	Integer
    private String	SUPPAS	= null;	//	Text

    private DatabaseHelper db;

    //
    private Boolean fuentAgua;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modalidad_hidrica);

        db         = new DatabaseHelper(this);
        riegoAgricola = findViewById(R.id.riego_agricola);
        riegoPecuaria = findViewById(R.id.riego_pecuaria);

        temporalAgricola = findViewById(R.id.temporal_agricola);
        temporalPecuaria = findViewById(R.id.temporal_pecuaria);

        //LinearLayaut
        /*
        rios            = findViewById(R.id.ln_rios);
        arroyos         = findViewById(R.id.ln_arroyos);
        manantial       = findViewById(R.id.ln_manantial);
        presas          = findViewById(R.id.ln_presas);
        pozo            = findViewById(R.id.ln_pozo);
        laguna          = findViewById(R.id.ln_laguna);
        tomaDomicilio   = findViewById(R.id.ln_toma_domicilio);
        ollaAgua        = findViewById(R.id.ln_olla_agua);
        bordoAlm        = findViewById(R.id.ln_bordo_alm);
        trataAgua       = findViewById(R.id.ln_trata_agua);

         */
       // lnAguaSi        = findViewById(R.id.ln_agua_si);

        fabHidrica = findViewById(R.id.fab_next_pro_hidrica);
        fabHidrica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Variables superficie de la tierra
                Boolean valModalHidrica = validModalHidrica();

                if(valModalHidrica && SUPPAS != null && fuentAgua == true) {
                    VariablesGlobalesUpf.FOLIO = "PruebaFolio";
                    VariablesGlobalesUpf.SACTAGRIRI = SACTAGRIRI;    //	Integer
                    VariablesGlobalesUpf.SACTPECRI = SACTPECRI;    //	Integer
                    VariablesGlobalesUpf.SACTAGRITE = SACTAGRITE;    //	Integer
                    VariablesGlobalesUpf.SACTPECTE = SACTPECTE;    //	Integer
                    VariablesGlobalesUpf.SUPPAS = SUPPAS;    //	Text
                    aggTablaUpf();
                    startActivity(new Intent(getApplication(), FuenteAgua.class));
                }else if(valModalHidrica && SUPPAS != null && fuentAgua == false){
                    VariablesGlobalesUpf.FOLIO = "PruebaFolio";
                    VariablesGlobalesUpf.SACTAGRIRI = SACTAGRIRI;    //	Integer
                    VariablesGlobalesUpf.SACTPECRI = SACTPECRI;    //	Integer
                    VariablesGlobalesUpf.SACTAGRITE = SACTAGRITE;    //	Integer
                    VariablesGlobalesUpf.SACTPECTE = SACTPECTE;    //	Integer
                    VariablesGlobalesUpf.SUPPAS = SUPPAS;    //	Text
                    aggTablaUpf();
                    startActivity(new Intent(getApplication(), IdentificacionCuestionario.class));
                }
                else{
                    Snackbar snackbar = Snackbar.make(v, "Verique los campos incompletos", Snackbar.LENGTH_SHORT);
                    snackbar.show();
                }

            }
        });
    }

    private void aggTablaUpf() {
        boolean insertarData = db.addUpf();
        if(insertarData == true) {
            Toast.makeText(this, "Datos insertados correctamente", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Algo salio mal", Toast.LENGTH_LONG).show();
        }
    }

    private Boolean validModalHidrica() {

        if(!riegoAgricola.getText().toString().isEmpty()){
            SACTAGRIRI = riegoAgricola.getText().toString();
        }else {
            SACTAGRIRI = null;
        }

        if(!riegoPecuaria.getText().toString().isEmpty()){
            SACTPECRI = riegoPecuaria.getText().toString();
        }else {
            SACTPECRI = null;
        }

        if(!temporalAgricola.getText().toString().isEmpty()){
            SACTAGRITE = temporalAgricola.getText().toString();
        }else {
            SACTAGRITE = null;
        }

        if(!temporalPecuaria.getText().toString().isEmpty()){
            SACTPECTE = temporalPecuaria.getText().toString();
        }else {
            SACTPECTE = null;
        }

        return true;

    }

    public void clikSuperficieHidrica(View view) {
        boolean checked = ((CheckBox) view).isChecked();

        switch(view.getId()) {
            case R.id.ck_riego:
                if (checked){
                    riegoAgricola.setEnabled(true);
                    riegoPecuaria.setEnabled(true);
                }
                else{
                    riegoAgricola.setEnabled(false);
                    riegoPecuaria.setEnabled(false);
                    riegoAgricola.setText("");
                    riegoPecuaria.setText("");
                }
                break;
            case R.id.ck_temporal:
                if (checked){
                    temporalAgricola.setEnabled(true);
                    temporalPecuaria.setEnabled(true);
                }
                else{
                    temporalAgricola.setEnabled(false);
                    temporalPecuaria.setEnabled(false);
                    temporalAgricola.setText("");
                    temporalPecuaria.setText("");
                }
                break;

        }
    }



    public void accesoAgua(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        // Check which checkbox was clicked
        switch(view.getId()) {
            case R.id.acc_agua_si:
                if (checked){
                    fuentAgua = true;
                    //    lnAguaSi.setVisibility(View.VISIBLE);
                }

                else{
                    //  lnAguaSi.setVisibility(View.GONE);
                }
                // Remove the meat
                break;
            case R.id.acc_agua_no:
                if (checked){
                    fuentAgua = false;
                    //Toast.makeText(getApplicationContext(), "Radio Button", Toast.LENGTH_SHORT).show();
                    // lnAguaSi.setVisibility(View.GONE);
                    //lnPesca.setVisibility(View.VISIBLE);
                }

                break;


        }
    }

    @Override
    public void onBackPressed() {

    }

    public void superficePastoreo(View view) {
        boolean checkedTipo = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.rd_sup_pas_si:
                if (checkedTipo) {
                    SUPPAS = "Si";
                }
                break;
            case R.id.rd_sup_pas_no:
                if (checkedTipo) {
                    SUPPAS = "No";
                }
                break;
        }
    }

}
