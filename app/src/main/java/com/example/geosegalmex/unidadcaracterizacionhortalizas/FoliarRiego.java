package com.example.geosegalmex.unidadcaracterizacionhortalizas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.geosegalmex.R;
import com.example.geosegalmex.unidadcaracterizacionhortalizas.variables.VariblesGlobalesHortalizas;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class FoliarRiego extends AppCompatActivity {
    ExtendedFloatingActionButton fabFolRiego;

    EditText edtFoliarApliOtro;
    EditText edtRiegoOtro;


    RadioGroup rgTipoRiego;
    RadioButton rdRealRiegoSi;
    RadioButton rdRealRiegoNo;
    RadioButton rdTRGravedad;
    RadioButton rdTRGote;
    RadioButton rdTRAspercion;
    RadioButton rdTRotro;

    RadioButton rdDiario;
    RadioButton rdDosTreSem;
    RadioButton rdSemanal;
    RadioButton rdQuince;
    RadioButton rdMensual;




    //Variables
    String txtApFoliarAplica = null;
    String txtApFoliarAplicaOtr = null;
    String txtRiegaSiNo = null;
    String txtTipoRiega = null;
    String txtedtTipoRiegoOtr = null;

    //Variables Cada cuando Riega
    String txtCuandoRiega = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foliar_riego);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        fabFolRiego = findViewById(R.id.fab_next_fol_rie_fe);

        edtFoliarApliOtro= findViewById(R.id.edt_otr_fr_fe);
        edtRiegoOtro   = findViewById(R.id.edt_ot_es_r_fe);


        rdRealRiegoSi = findViewById(R.id.rd_si_fr_fe);
        rdRealRiegoNo = findViewById(R.id.rd_no_fr_fe);

        rgTipoRiego = findViewById(R.id.rg_tip_rie);
        rdTRGravedad = findViewById(R.id.ck_gv_r_fe);
        rdTRGote = findViewById(R.id.ck_gt_r_fe);
        rdTRAspercion = findViewById(R.id.ck_as_r_fe);
        rdTRotro = findViewById(R.id.ck_ot_es_r_fe);


        rdDiario = findViewById(R.id.ck_di_ri_fe);
        rdDosTreSem = findViewById(R.id.ck_dt_ri_fe);
        rdSemanal = findViewById(R.id.ck_se_ri_fe);
        rdQuince = findViewById(R.id.ck_qi_ri_fe);
        rdMensual = findViewById(R.id.ck_me_ri_fe);

        fabFolRiego.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Error
                Boolean bolTipoFoliar = false;
                Boolean bolTipoRiego = false;

                if( txtApFoliarAplica == "Otro" && edtFoliarApliOtro.getText().toString().isEmpty()) {
                    //txtApFoliarAplicaOtr = edtFoliarApliOtro.getText().toString();
                    bolTipoFoliar = true;
                }else if( txtApFoliarAplica == "Otro" && !edtFoliarApliOtro.getText().toString().isEmpty()){
                    txtApFoliarAplicaOtr = edtFoliarApliOtro.getText().toString();
                    bolTipoFoliar = false;
                }

                if(txtTipoRiega == "Otro" && edtRiegoOtro.getText().toString().isEmpty()){
                    ///txtedtTipoRiegoOtr = edtRiegoOtro.getText().toString();
                    bolTipoRiego = true;
                }else if(txtTipoRiega == "Otro" && !edtRiegoOtro.getText().toString().isEmpty()){
                    txtedtTipoRiegoOtr = edtRiegoOtro.getText().toString();
                    bolTipoRiego = false;
                }

                if(bolTipoFoliar == false && bolTipoRiego == false && txtRiegaSiNo == "Si" ){
                    VariblesGlobalesHortalizas.APPFOLH	= txtApFoliarAplica ;
                    VariblesGlobalesHortalizas.APPFOLHPV   = txtApFoliarAplicaOtr ;
                    VariblesGlobalesHortalizas.RIEHORT  = txtRiegaSiNo ;
                    VariblesGlobalesHortalizas.SISRIEGR    = txtTipoRiega ;
                    VariblesGlobalesHortalizas.SISHORTPV   = txtedtTipoRiegoOtr ;
                    //Variables Cada cuando Riega
                    VariblesGlobalesHortalizas.FRERIEGR = txtCuandoRiega ;
                    startActivity(new Intent(getBaseContext(), TiempoRiego.class));
                }else if(txtRiegaSiNo == "No"){
                    VariblesGlobalesHortalizas.APPFOLH	= txtApFoliarAplica ;
                    VariblesGlobalesHortalizas.APPFOLHPV   = txtApFoliarAplicaOtr ;
                    VariblesGlobalesHortalizas.RIEHORT  = txtRiegaSiNo ;
                    VariblesGlobalesHortalizas.SISRIEGR    = txtTipoRiega ;
                    VariblesGlobalesHortalizas.SISHORTPV   = txtedtTipoRiegoOtr ;
                    //Variables Cada cuando Riega
                    VariblesGlobalesHortalizas.FRERIEGR = txtCuandoRiega ;
                    startActivity(new Intent(getBaseContext(), ControlMalezas.class));
                }
                else{
                    Snackbar snackbar = Snackbar.make(v, "Verique el Campo otro", Snackbar.LENGTH_SHORT);
                    snackbar.show();
                }


                //startActivity(new Intent(getBaseContext(), TiempoRiego.class));
            }
        });
    }


    @Override
    public void onBackPressed() {

    }

    //Cada cuando Riega
    public void cuandoRiega(View view) {
        boolean checkedTipo = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.ck_di_ri_fe:
                if (checkedTipo) {
                    txtCuandoRiega = "Diario";
                }
                break;
            case R.id.ck_dt_ri_fe:
                if (checkedTipo) {
                    txtCuandoRiega = "Dos o tres veces a la semana";
                }
                break;
            case R.id.ck_se_ri_fe:
                if (checkedTipo) {
                    txtCuandoRiega = "Semanal";
                }
                break;
            case R.id.ck_qi_ri_fe:
                if (checkedTipo) {
                    txtCuandoRiega = "Quincenal";
                }
                break;
            case R.id.ck_me_ri_fe:
                if (checkedTipo) {
                    txtCuandoRiega = "Mensual";
                }
                break;
        }

    }


    public void tipoFoliarAplica(View view) {
        boolean checkedTipo = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.ck_nut_fr_fe:
                if (checkedTipo) {
                    txtApFoliarAplica = "Nutrición";
                    edtFoliarApliOtro.setText("");
                    edtFoliarApliOtro.setEnabled(false);
                }
                break;
            case R.id.ck_hor_fr_fe:
                if (checkedTipo) {
                    txtApFoliarAplica = "Hormonal (manejo fisiológico)";
                    edtFoliarApliOtro.setText("");
                    edtFoliarApliOtro.setEnabled(false);
                }
                break;
            case R.id.ck_pro_fr_fe:
                if (checkedTipo) {
                    txtApFoliarAplica = "Protección (radiación solar)";
                    edtFoliarApliOtro.setText("");
                    edtFoliarApliOtro.setEnabled(false);
                }
                break;
            case R.id.ck_otr_fr_fe:
                if (checkedTipo) {
                    txtApFoliarAplica = "Otro";
                    edtFoliarApliOtro.setEnabled(true);
                }
                break;

        }
    }

    public void realizaRiegoSiNo(View view) {
        boolean checkedTipo = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.rd_si_fr_fe:
                if (checkedTipo) {
                    txtRiegaSiNo = "Si";
                    rdTRGravedad.setEnabled(true);
                    rdTRGote.setEnabled(true);
                    rdTRAspercion.setEnabled(true);
                    rdTRotro.setEnabled(true);
                    rdDiario.setEnabled(true);
                    rdDosTreSem.setEnabled(true);
                    rdSemanal.setEnabled(true);
                    rdQuince.setEnabled(true);
                    rdMensual.setEnabled(true);
                }
                break;
            case R.id.rd_no_fr_fe:
                if (checkedTipo) {
                    txtRiegaSiNo = "No";
                    rgTipoRiego.clearCheck();
                    rdTRGravedad.setEnabled(false);
                    rdTRGote.setEnabled(false);
                    rdTRAspercion.setEnabled(false);
                    rdTRotro.setEnabled(false);
                    edtRiegoOtro.setEnabled(false);
                    rdDiario.setEnabled(false);
                    rdDosTreSem.setEnabled(false);
                    rdSemanal.setEnabled(false);
                    rdQuince.setEnabled(false);
                    rdMensual.setEnabled(false);
                    edtRiegoOtro.setText("");
                    edtRiegoOtro.setEnabled(false);
                }
                break;
        }
    }

    public void tipoRiego(View view) {
        boolean checkedTipo = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.ck_gv_r_fe:
                if (checkedTipo) {
                    txtTipoRiega = "Gravedad o rodado";
                    edtRiegoOtro.setText("");
                    edtRiegoOtro.setEnabled(false);
                }
                break;
            case R.id.ck_gt_r_fe:
                if (checkedTipo) {
                    txtTipoRiega = "Goteo";
                    edtRiegoOtro.setText("");
                    edtRiegoOtro.setEnabled(false);
                }
                break;
            case R.id.ck_as_r_fe:
                if (checkedTipo) {
                    txtTipoRiega = "Aspersión";
                    edtRiegoOtro.setText("");
                    edtRiegoOtro.setEnabled(false);
                }
                break;
            case R.id.ck_ot_es_r_fe:
                if (checkedTipo) {
                    txtTipoRiega = "Otro";
                    edtRiegoOtro.setEnabled(true);
                }
                break;
        }

    }
}