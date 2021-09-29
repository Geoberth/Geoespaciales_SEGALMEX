package com.example.geosegalmex.unidadcaracterizacionhortalizas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.geosegalmex.R;
import com.example.geosegalmex.unidadcaracterizacionhortalizas.variables.VariblesGlobalesHortalizas;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class Nutricion extends AppCompatActivity {
    ExtendedFloatingActionButton fabNutFe;
    TextView txtNutTit;
    CheckBox ckAnlSuelo;
    CheckBox ckAnlFoliar;
    CheckBox ckAnlAgua;

    EditText edtASueloPre;
    EditText edtAFoliarPre;
    EditText edtAAguaPre;

    //Variablesforsave
    String txtReaAnalFert = null;
    String txtSueloAFrt = null;
    String txtFoliarAFrt = null;
    String txtAguaAFrt = null;
    String txtSueloPr = null;
    String txtFoliarPr = null;
    String txtAguaPr = null;
    String txtRealTipFerti = null;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nutricion);

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

        fabNutFe = findViewById(R.id.fab_next_nut);
        txtNutTit = findViewById(R.id.tx_tit_nut);

        ckAnlSuelo = findViewById(R.id.ck_sl_he);
        ckAnlFoliar = findViewById(R.id.ck_fl_he);
        ckAnlAgua = findViewById(R.id.ck_ag_he);

        edtASueloPre = findViewById(R.id.edt_pr_he);
        edtAFoliarPre = findViewById(R.id.edt_pr_fl_he);
        edtAAguaPre = findViewById(R.id.edt_pr_ag_he);

        if (hortalizas.valorTempCosPv == 1) {
            txtNutTit.setText(getString(R.string.name_mod_nut_pv));
        } else if (hortalizas.valorTempCosOi == 1) {
            txtNutTit.setText(getString(R.string.name_mod_nut_oi));
        }

        fabNutFe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Boolean bandaVer = false;

                if (txtReaAnalFert == null) {
                    Snackbar snackbar = Snackbar.make(v, "Seleccione si realiza algun análisis para fertilizar", Snackbar.LENGTH_SHORT);
                    snackbar.show();
                } else if (txtReaAnalFert != null) {


                    //   if (txtSueloAFrt != null || txtFoliarAFrt != null || txtAguaAFrt != null) {


                    if (txtSueloAFrt != null && edtASueloPre.getText().toString().isEmpty()) {
                        bandaVer = false;
                        Snackbar snackbar = Snackbar.make(v, "Verifique el Precio del Suelo", Snackbar.LENGTH_SHORT);
                        snackbar.show();
                    } else if (txtSueloAFrt != null && !edtASueloPre.getText().toString().isEmpty()) {
                        txtSueloPr = edtASueloPre.getText().toString();
                        bandaVer = true;
                        // Snackbar snackbar = Snackbar.make(v,"Great" + txtSueloAFrt,Snackbar.LENGTH_SHORT);
                        // snackbar.show();
                    }
                    if (txtFoliarAFrt != null && edtAFoliarPre.getText().toString().isEmpty()) {
                        bandaVer = false;
                        Snackbar snackbar = Snackbar.make(v, "Verifique el Precio de Foliar ", Snackbar.LENGTH_SHORT);
                        snackbar.show();
                    } else if (txtFoliarAFrt != null && !edtAFoliarPre.getText().toString().isEmpty()) {
                        txtFoliarPr = edtAFoliarPre.getText().toString();
                        bandaVer = true;
                        // Snackbar snackbar = Snackbar.make(v,"Great" + txtFoliarAFrt,Snackbar.LENGTH_SHORT);
                        // snackbar.show();
                    }
                    if (txtAguaAFrt != null && edtAAguaPre.getText().toString().isEmpty()) {
                        bandaVer = false;
                        Snackbar snackbar = Snackbar.make(v, "Verifique el Precio del Agua", Snackbar.LENGTH_SHORT);
                        snackbar.show();
                    } else if (txtAguaAFrt != null && !edtAAguaPre.getText().toString().isEmpty()) {
                        txtAguaPr = edtAAguaPre.getText().toString();
                        bandaVer = true;
                        // Snackbar snackbar = Snackbar.make(v,"Great" + txtSueloAFrt,Snackbar.LENGTH_SHORT);
                        // snackbar.show();
                    }
                    // } //else if(txtReaAnalFert == "Si"){
                    // Snackbar snackbar = Snackbar.make(v, "Seleccione una opcion", Snackbar.LENGTH_SHORT);
                    // snackbar.show();
                    //}


                    //  if ((bandaVer && txtRealTipFerti == "Si") || (txtRealTipFerti == "Si" && txtReaAnalFert == "No" )){
                    if ((txtRealTipFerti == "Si") && (txtReaAnalFert == "No" || txtReaAnalFert == "Si")){

                        //Variables Globales Save
                        VariblesGlobalesHortalizas.ANAFERHO = txtReaAnalFert;
                        VariblesGlobalesHortalizas.SUELHO =  txtSueloAFrt;

                        if(txtSueloPr != null) {
                            VariblesGlobalesHortalizas.PRESUELHO = txtSueloPr;
                        }

                        VariblesGlobalesHortalizas.FOLHO = txtFoliarAFrt;
                        if(txtFoliarPr != null) {
                            VariblesGlobalesHortalizas.PREFOLHO = txtFoliarPr;
                        }
                        VariblesGlobalesHortalizas.AGUAHO=  txtAguaAFrt;

                        if(txtAguaPr != null) {
                            VariblesGlobalesHortalizas.PREAGUAHO = txtAguaPr;
                        }
                        VariblesGlobalesHortalizas.TIPFERHOR =  txtRealTipFerti;


                        startActivity(new Intent(getBaseContext(), FertilizanteSi.class));
                        //Snackbar snackbar = Snackbar.make(v,"Congratulations......",Snackbar.LENGTH_SHORT);
                        //snackbar.show();
                        //} else if ((bandaVer && txtRealTipFerti == "No") && txtReaAnalFert == "No"){
                    } else if (bandaVer && txtRealTipFerti == "No"){
                        startActivity(new Intent(getBaseContext(), FoliarRiego.class));
                    } else if(bandaVer) {
                        Snackbar snackbar = Snackbar.make(v, "Seleccione si realiza algun tipo de fertilización", Snackbar.LENGTH_SHORT);
                        snackbar.show();
                    }else if(txtRealTipFerti == "No" && txtReaAnalFert == "No"){
                        startActivity(new Intent(getBaseContext(), FoliarRiego.class));
                    }

                }

                /*
                else{
                    Snackbar snackbar = Snackbar.make(v,"Seleccione si realiza algun análisis para fertilizar",Snackbar.LENGTH_SHORT);
                    snackbar.show();
                }

                 */

                /*
                if(bandaVer && txtRealTipFerti == "Si"){
                    startActivity(new Intent(getBaseContext(), FertilizanteSi.class));
                    //Snackbar snackbar = Snackbar.make(v,"Congratulations......",Snackbar.LENGTH_SHORT);
                    //snackbar.show();
                }else if(bandaVer && txtRealTipFerti == "No"){
                    startActivity(new Intent(getBaseContext(), FoliarRiego.class));
                }else {
                    Snackbar snackbar = Snackbar.make(v,"Seleccione si realiza algun tipo de fertilización",Snackbar.LENGTH_SHORT);
                    snackbar.show();
                }


                 */

                //startActivity(new Intent(getBaseContext(), FertilizanteSi.class));
            }
        });
    }

    @Override
    public void onBackPressed() {

    }


    public void analisisFertilizar(View view) {
        boolean checkedTipo = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.rd_si_an_fer:
                if (checkedTipo) {
                    txtReaAnalFert = "Si";
                    ckAnlSuelo.setEnabled(true);
                    ckAnlFoliar.setEnabled(true);
                    ckAnlAgua.setEnabled(true);
                }
                break;
            case R.id.rd_no_an_fer:
                if (checkedTipo) {
                    txtReaAnalFert = "No";
                    ckAnlSuelo.setEnabled(true);
                    ckAnlFoliar.setEnabled(true);
                    ckAnlAgua.setEnabled(true);
                }
                break;
        }

    }

    public void tipoAnalisisFert(View view) {
        boolean checkedTipo = ((CheckBox) view).isChecked();

        switch (view.getId()) {
            case R.id.ck_sl_he:
                if (checkedTipo) {
                    txtSueloAFrt = "Suelo";
                    edtASueloPre.setEnabled(true);
                } else {
                    txtSueloAFrt = null;
                    edtASueloPre.setEnabled(false);
                    edtASueloPre.setText("");
                }
                break;
            case R.id.ck_fl_he:
                if (checkedTipo) {
                    txtFoliarAFrt = "Foliar";
                    edtAFoliarPre.setEnabled(true);
                } else {
                    txtFoliarAFrt = null;
                    edtAFoliarPre.setText("");
                    edtAFoliarPre.setEnabled(false);
                }
                break;
            case R.id.ck_ag_he:
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

    public void tipoFertiActivity(View view) {
        boolean checkedTipo = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.rd_fer_si_he:
                if (checkedTipo) {
                    txtRealTipFerti = "Si";
                }
                break;
            case R.id.rd_fer_no_he:
                if (checkedTipo) {
                    txtRealTipFerti = "No";
                }
                break;
        }

    }
}
