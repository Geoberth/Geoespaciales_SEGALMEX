package com.example.geosegalmex.frutales;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.geosegalmex.R;
import com.example.geosegalmex.frutales.dbfrutales.VariablesFrutales;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

public class frutales_4 extends AppCompatActivity {
    ExtendedFloatingActionButton f4;
    TextView txtNutTit;
    CheckBox ckAnlSuelo;
    CheckBox ckAnlFoliar;
    CheckBox ckAnlAgua;

    EditText edtASueloPre;
    EditText edtAFoliarPre;
    EditText edtAAguaPre;
    EditText edtTmpAnal;

    //Variablesforsave
    String txtReaAnalFert = null;

    String txtSueloAFrt = null;
    String txtFoliarAFrt = null;
    String txtAguaAFrt = null;

    String txtSueloPr = null;
    String txtFoliarPr = null;
    String txtAguaPr = null;
    String txtRealTipFerti = null;

    private String ANLISIFRT = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frutales_4);

        f4 = findViewById(R.id.fr4);


        ckAnlSuelo = findViewById(R.id.ck_sl_he_frt);
        ckAnlFoliar = findViewById(R.id.ck_fl_he_frt);
        ckAnlAgua = findViewById(R.id.ck_ag_he_frt);

        edtASueloPre = findViewById(R.id.edt_pr_he_frt);
        edtAFoliarPre = findViewById(R.id.edt_pr_fl_he_frt);
        edtAAguaPre = findViewById(R.id.edt_pr_ag_he_frt);
        edtTmpAnal = findViewById(R.id.edt_tmp_rea_ana_frt_1);

        f4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                asignacionValores();
                impresion();
                if(txtReaAnalFert == "Si") {
                    startActivity(new Intent(getApplicationContext(), frutales_5.class));
                }else if (txtReaAnalFert == "No"){
                    startActivity(new Intent(getApplicationContext(), frutales_6.class));
                }
            }
        });

    }

    private void impresion() {
        System.out.println(txtReaAnalFert);

        System.out.println(txtSueloAFrt);
        System.out.println(txtFoliarAFrt);
        System.out.println(txtAguaAFrt);

        System.out.println(txtSueloPr);
        System.out.println(txtFoliarPr);
        System.out.println(txtAguaPr);
        System.out.println(txtRealTipFerti);
    }

    private void asignacionValores() {
        if(!edtTmpAnal.getText().toString().isEmpty()){
            ANLISIFRT= edtTmpAnal.getText().toString();
        }

        if(!edtASueloPre.getText().toString().isEmpty()){
            txtSueloPr = edtASueloPre.getText().toString();
        }

        if(!edtAFoliarPre.getText().toString().isEmpty()){
            txtFoliarPr = edtAFoliarPre.getText().toString();
        }

        if(!edtAAguaPre.getText().toString().isEmpty()){
            txtAguaPr = edtAAguaPre.getText().toString();
        }

        VariablesFrutales.ANAFERHOFRT = txtReaAnalFert;
        VariablesFrutales.ANLISIFRT = ANLISIFRT;

        VariablesFrutales.SUELHOFRT = txtSueloAFrt;
        VariablesFrutales.PRESUELHOFRT = txtSueloPr;

        VariablesFrutales.FOLHOFRT = txtFoliarAFrt;
        VariablesFrutales.PREFOLHOFRT =txtFoliarPr;

        VariablesFrutales.AGUAHOFRT =txtAguaAFrt;
        VariablesFrutales.PREAGUAHOFRT =txtAguaPr;

        VariablesFrutales.TIPFERHORFRT =txtRealTipFerti;

    }

    public void analisisFertilizarfrt(View view) {
        boolean checkedTipo = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.rd_si_an_fer_frt:
                if (checkedTipo) {
                    txtRealTipFerti = "Si";
                }
                break;
            case R.id.rd_no_an_fer_frt:
                if (checkedTipo) {
                    txtRealTipFerti = "No";
                }
                break;
        }
    }

    public void tipoAnalisisFertfrt(View view) {
        boolean checkedTipo = ((CheckBox) view).isChecked();

        switch (view.getId()) {
            case R.id.ck_sl_he_frt:
                if (checkedTipo) {
                    txtSueloAFrt = "Suelo";
                    edtASueloPre.setEnabled(true);
                } else {
                    txtSueloAFrt = null;
                    edtASueloPre.setEnabled(false);
                    edtASueloPre.setText("");
                }
                break;
            case R.id.ck_fl_he_frt:
                if (checkedTipo) {
                    txtFoliarAFrt = "Foliar";
                    edtAFoliarPre.setEnabled(true);
                } else {
                    txtFoliarAFrt = null;
                    edtAFoliarPre.setText("");
                    edtAFoliarPre.setEnabled(false);
                }
                break;
            case R.id.ck_ag_he_frt:
                if (checkedTipo) {
                    txtAguaAFrt = "Agua";
                    edtAAguaPre.setEnabled(true);
                } else {
                    txtAguaAFrt = null;
                    edtAAguaPre.setText("");
                    edtAAguaPre.setEnabled(false);
                }
                break;
        }
    }

    public void tipoFertiActivityFrt(View view) {
        boolean checkedTipo = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.rd_fer_si_he_frt:
                if (checkedTipo) {
                    txtReaAnalFert = "Si";
                    ckAnlSuelo.setEnabled(true);
                    ckAnlFoliar.setEnabled(true);
                    ckAnlAgua.setEnabled(true);
                }
                break;
            case R.id.rd_fer_no_he_frt:
                if (checkedTipo) {
                    txtReaAnalFert = "No";
                    ckAnlSuelo.setEnabled(true);
                    ckAnlFoliar.setEnabled(true);
                    ckAnlAgua.setEnabled(true);
                }
                break;

        }
    }

    @Override
    public void onBackPressed() {

    }
}
