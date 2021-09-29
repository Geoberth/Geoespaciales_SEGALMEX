package com.example.geosegalmex.unidadcaracterizacionhortalizas;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.geosegalmex.caracterizacion.variables_caracterizacion.DatePickerFragment;
import com.example.geosegalmex.R;
import com.example.geosegalmex.unidadcaracterizacionhortalizas.variables.VariblesGlobalesHortalizas;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class HortalizasPvunob extends AppCompatActivity {
    EditText ediDate;
    EditText editSembrada;
    EditText editMecan;
    EditText editNomMeca;
    EditText editTipoInfra;
    ExtendedFloatingActionButton fabHortUnoB;

    //RadioButton _Superficies Siniestradas
    RadioButton enfermedades;
    RadioButton excesoHumedad;
    RadioButton granizo;
    RadioButton helada;
    RadioButton inundaciones;
    RadioButton sequia;
    RadioButton vientos;
    RadioButton plagas;
    RadioGroup grupoTipoEfectacion;

    //Variablesforsave
    String dateSiembra;
    String sSembrada = null;
    String sSembradaMec = null;
    String sSembradaNoMec = null;
    String supSembHa = null; //superficie sembrada Ha
    String supMecHa = null; //superfice mecanizada Ha
    String supNomMecHa = null; //Superfice no mecanizada Ha
    String tipoInfraest = null; // tipo infraestructura
    String otroTipoInfrastruc = null; //Otro tipo de infraestructura
    String tipoAfectacionesSiNo = null; //Afectaciones SI / No
    String tipoAfectaciones = null; // Tipo de Afectaciones

    //Variable ciclo cultivo
    String cicproB = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hortalizas_pvunob);

        ediDate = findViewById(R.id.id_date);
        editSembrada = findViewById(R.id.id_sem_edt);
        editMecan = findViewById(R.id.id_mec_edt);
        editNomMeca = findViewById(R.id.id_no_mec_edt);
        editTipoInfra = findViewById(R.id.ed_ot_esp);
        fabHortUnoB = findViewById(R.id.fab_next_pv_b);

        //--------- Rd tipo siniestro
        grupoTipoEfectacion = findViewById(R.id.rd_grp_tip_afe);
        enfermedades = findViewById(R.id.ck_css_enf);
        excesoHumedad = findViewById(R.id.ck_css_eh);
        granizo = findViewById(R.id.ck_css_gr);
        helada = findViewById(R.id.ck_css_hl);
        inundaciones = findViewById(R.id.ck_css_in);
        sequia = findViewById(R.id.ck_css_sq);
        vientos = findViewById(R.id.ck_css_vi);
        plagas = findViewById(R.id.ck_css_pl);

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

        /*
        ediDate.setInputType(InputType.TYPE_NULL);
        String annoFech = getIntent().getStringExtra("anno");
        String mesFech = getIntent().getStringExtra("mes");
        String diaFech = getIntent().getStringExtra("dia");
        if (annoFech != null && mesFech != null && diaFech != null) {
            ediDate.setText(diaFech + "/" + mesFech + "/" + annoFech);
            dateSiembra = String.valueOf(ediDate.getText());
        } */
        ediDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog(ediDate);
               // startActivity(new Intent(getBaseContext(), CalendarioActivity.class));
            }
        });


        cicproB = HortalizasPVuno.cicPro;
        //Variables para guardar Bd
        //cicproB,dateSiembra,sSembrada, supSembHa, sSembradaMec, supMecHa, sSembradaNoMec, supNomMecHa, tipoInfraest, otroTipoInfrastruc, tipoAfectacionesSiNo, tipoAfectaciones




        fabHortUnoB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Boolean valorSuperficie = superficieTiene(v);
                Boolean valorTipoInfraestructura = tipoInfrestructuraSelec(v);
                Boolean valorAfetaciones = afectacionesTipos(v);


                //Falta dateSiembra agregar a la validacion
                if (valorSuperficie && valorTipoInfraestructura && valorAfetaciones) {
                    VariblesGlobalesHortalizas.FECHOR = dateSiembra;
                    VariblesGlobalesHortalizas.SUPSEMHOstr =sSembrada;
                    VariblesGlobalesHortalizas.SUPSEMHO = supSembHa;

                    VariblesGlobalesHortalizas.SUPMECOIHOstr = sSembradaMec;
                    VariblesGlobalesHortalizas.SUPMECOIHO = supMecHa;

                    VariblesGlobalesHortalizas.SUPNMECHOstr =sSembradaNoMec;
                    VariblesGlobalesHortalizas.SUPNMECHO =supNomMecHa;

                    VariblesGlobalesHortalizas.INFRHORT =tipoInfraest;
                    VariblesGlobalesHortalizas.INFRHORTA =otroTipoInfrastruc;
                    VariblesGlobalesHortalizas.SINIHOR =tipoAfectacionesSiNo;
                    VariblesGlobalesHortalizas.CAUSINIH =tipoAfectaciones;

                    startActivity(new Intent(getBaseContext(), HortalizasPvunoC.class));
                    //Snackbar snackbar = Snackbar.make(v, "Save Congratulations..."+ cicproB, Snackbar.LENGTH_SHORT);
                    //snackbar.show();
                } else if (!valorSuperficie) {
                    Snackbar snackbar = Snackbar.make(v, "Verifique Superficie...", Snackbar.LENGTH_SHORT);
                    snackbar.show();
                } else if (!valorTipoInfraestructura) {
                    Snackbar snackbar = Snackbar.make(v, "Verifique Infraestructura...", Snackbar.LENGTH_SHORT);
                    snackbar.show();
                } else if (!valorAfetaciones) {
                    Snackbar snackbar = Snackbar.make(v, "Verifique Valor Afectaciones...", Snackbar.LENGTH_SHORT);
                    snackbar.show();
                }


            }
        });

    }

    private void showDatePickerDialog(final EditText editText) {
        DatePickerFragment newFragment = DatePickerFragment.newInstance(new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                // +1 because January is zero
                final String selectedDate = day + "/" + (month + 1) + "/" + year;
                editText.setText(selectedDate);
                dateSiembra = selectedDate;

            }
        });

        newFragment.show(getSupportFragmentManager(), "datePicker");
    }

    //Afectaciones
    private Boolean afectacionesTipos(View v) {
        if (tipoAfectacionesSiNo != null) {


            if (tipoAfectaciones != null && tipoAfectacionesSiNo == "Si") {

                //    Snackbar snackbar = Snackbar.make(v, tipoAfectacionesSiNo + tipoAfectaciones, Snackbar.LENGTH_SHORT);
                //    snackbar.show();
                return true;
            } else if (tipoAfectacionesSiNo == "No") {
                //  Snackbar snackbar = Snackbar.make(v, tipoAfectacionesSiNo + tipoAfectaciones, Snackbar.LENGTH_SHORT);
                //  snackbar.show();
                return true;
            } else {
                // Snackbar snackbar = Snackbar.make(v, "Verifique la causa de la superficie siniestrada", Snackbar.LENGTH_SHORT);
                // snackbar.show();
                return false;
            }
        } else {
            //Snackbar snackbar = Snackbar.make(v, "Seleccione Si o No tuvo alguna afectacion por siniestro", Snackbar.LENGTH_SHORT);
            //snackbar.show();
            return false;
        }

    }

    //Tipo de infrastructura
    private Boolean tipoInfrestructuraSelec(View v) {
        if (tipoInfraest != null) {

            if (tipoInfraest == "Otro" && !editTipoInfra.getText().toString().isEmpty()) {
                otroTipoInfrastruc = editTipoInfra.getText().toString();
                return true;
            } else if (tipoInfraest != "Otro") {
                return true;
            }
            //Snackbar snackbar = Snackbar.make(v, tipoInfraest + otroTipoInfrastruc, Snackbar.LENGTH_SHORT);
            //snackbar.show();

        }
        //Snackbar snackbar = Snackbar.make(v, "Ingrese la superficie...", Snackbar.LENGTH_SHORT);
        //snackbar.show();
        return false;

    }

    //Cuanta superficie tiene
    private Boolean superficieTiene(View v) {
        Boolean errorSuperficie = true;

        if (sSembrada == "Sembrada" && editSembrada.getText().toString().isEmpty()) {
            errorSuperficie = true;
        } else if (!editSembrada.getText().toString().isEmpty()) {
            //String sSembrada = String.valueOf(editSembrada.getText());
            sSembrada = String.valueOf(editSembrada.getText());
            supSembHa = sSembrada;
            errorSuperficie = false;
        } else {
            supSembHa = null;
        }

        if (sSembradaMec == "Mecanizada" && editMecan.getText().toString().isEmpty()) {
            errorSuperficie = true;
        } else if (!editMecan.getText().toString().isEmpty()) {
            //String sSembradaMec = String.valueOf(editMecan.getText());
            sSembradaMec = String.valueOf(editMecan.getText());
            supMecHa = sSembradaMec;
            errorSuperficie = false;
        } else {
            supMecHa = null;
        }

        if (sSembradaNoMec == "No Mecanizada" && editNomMeca.getText().toString().isEmpty()) {
            errorSuperficie = true;
        } else if (!editNomMeca.getText().toString().isEmpty()) {
            //String sSembradaNoMec = String.valueOf(editNomMeca.getText());
            sSembradaNoMec = String.valueOf(editNomMeca.getText());
            supNomMecHa = sSembradaNoMec;
            errorSuperficie = false;
        } else {
            supNomMecHa = null;
        }

        if ((supMecHa != null || supSembHa != null || supNomMecHa != null) && errorSuperficie == false) {
            //  Snackbar snackbar = Snackbar.make(v,supSembHa + "---" + supMecHa +"---" + supNomMecHa,Snackbar.LENGTH_SHORT);
            //  snackbar.show();
            return true;
        } else {
            // Snackbar snackbar = Snackbar.make(v,"Ingrese la superficie...",Snackbar.LENGTH_SHORT);
            // snackbar.show();
            return false;
        }
    }

    @Override
    public void onBackPressed() {

    }

    public void superficieHa(View view) {
        boolean checkedSup = ((CheckBox) view).isChecked();
        switch (view.getId()) {
            case R.id.id_sem:
                if (checkedSup) {
                    sSembrada = "Sembrada";
                    editSembrada.setEnabled(true);

                } else {
                    sSembrada = null;
                    supSembHa = null;
                    editSembrada.setText("");
                    editSembrada.setEnabled(false);

                }
                break;
            case R.id.id_mec:
                if (checkedSup) {
                    sSembradaMec = "Mecanizada";
                    editMecan.setEnabled(true);
                } else {
                    sSembradaMec = null;
                    supMecHa = null;
                    editMecan.setText("");
                    editMecan.setEnabled(false);

                }
                break;
            case R.id.id_no_mec:
                if (checkedSup) {
                    sSembradaNoMec = "No Mecanizada";
                    editNomMeca.setEnabled(true);
                } else {
                    sSembradaNoMec = null;
                    supNomMecHa = null;
                    editNomMeca.setText("");
                    editNomMeca.setEnabled(false);

                }
                break;
        }
    }

    public void tipoInfrestructura(View view) {
        boolean checkedTipo = ((RadioButton) view).isChecked();
        switch (view.getId()) {
            case R.id.ck_inv:
                if (checkedTipo) {
                    otroTipoInfrastruc = null;
                    tipoInfraest = "Invernadero";
                    editTipoInfra.setText("");
                    editTipoInfra.setEnabled(false);
                }
                break;
            case R.id.ck_ac_pl:
                if (checkedTipo) {
                    otroTipoInfrastruc = null;
                    tipoInfraest = "Acolchado plástico";
                    editTipoInfra.setText("");
                    editTipoInfra.setEnabled(false);
                }
                break;
            case R.id.ck_mc_tn:
                if (checkedTipo) {
                    otroTipoInfrastruc = null;
                    tipoInfraest = "Macro túnel";
                    editTipoInfra.setText("");
                    editTipoInfra.setEnabled(false);

                }
                break;
            case R.id.ck_ci_ab:
                if (checkedTipo) {
                    otroTipoInfrastruc = null;
                    tipoInfraest = "Cielo abierto";
                    editTipoInfra.setText("");
                    editTipoInfra.setEnabled(false);
                }
                break;
            case R.id.ck_bi_so:
                if (checkedTipo) {
                    otroTipoInfrastruc = null;
                    tipoInfraest = "Bioespacio o malla sombra";
                    editTipoInfra.setText("");
                    editTipoInfra.setEnabled(false);
                }
                break;
            case R.id.ck_ot_es:
                if (checkedTipo) {
                    tipoInfraest = "Otro";
                    editTipoInfra.setEnabled(true);
                }
                break;
        }
    }

    public void afectacionCultivo(View view) {
        boolean checkedTipo = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.rd_si_af_hor:
                if (checkedTipo) {
                    tipoAfectacionesSiNo = "Si";
                    enfermedades.setEnabled(true);
                    excesoHumedad.setEnabled(true);
                    granizo.setEnabled(true);
                    helada.setEnabled(true);
                    inundaciones.setEnabled(true);
                    sequia.setEnabled(true);
                    vientos.setEnabled(true);
                    plagas.setEnabled(true);
                }
                break;
            case R.id.rd_no_af_hor:
                if (checkedTipo) {
                    tipoAfectacionesSiNo = "No";
                    grupoTipoEfectacion.clearCheck();
                    tipoAfectaciones = null;
                    enfermedades.setEnabled(false);
                    excesoHumedad.setEnabled(false);
                    granizo.setEnabled(false);
                    helada.setEnabled(false);
                    inundaciones.setEnabled(false);
                    sequia.setEnabled(false);
                    vientos.setEnabled(false);
                    plagas.setEnabled(false);
                }
                break;
        }
    }


    public void tiposDeAfectaciones(View view) {
        boolean checkedTipo = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.ck_css_enf:
                if (checkedTipo) {
                    tipoAfectaciones = "Enfermedades";
                }
                break;
            case R.id.ck_css_eh:
                if (checkedTipo) {
                    tipoAfectaciones = "Exceso de humedad";
                }
                break;
            case R.id.ck_css_gr:
                if (checkedTipo) {
                    tipoAfectaciones = "Granizo";
                }
                break;
            case R.id.ck_css_hl:
                if (checkedTipo) {
                    tipoAfectaciones = "Helada";
                }
                break;
            case R.id.ck_css_in:
                if (checkedTipo) {
                    tipoAfectaciones = "Inundaciones";
                }
                break;
            case R.id.ck_css_sq:
                if (checkedTipo) {
                    tipoAfectaciones = "Sequía";
                }
                break;
            case R.id.ck_css_vi:
                if (checkedTipo) {
                    tipoAfectaciones = "Vientos";
                }
                break;
            case R.id.ck_css_pl:
                if (checkedTipo) {
                    tipoAfectaciones = "Plagas";
                }
                break;
        }
    }
}
