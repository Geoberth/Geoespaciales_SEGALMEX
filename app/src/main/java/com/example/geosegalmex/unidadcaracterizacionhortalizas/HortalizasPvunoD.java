package com.example.geosegalmex.unidadcaracterizacionhortalizas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.geosegalmex.R;
import com.example.geosegalmex.unidadcaracterizacionhortalizas.db.DatabaseHelper;
import com.example.geosegalmex.unidadcaracterizacionhortalizas.variables.VariblesGlobalesHortalizas;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class HortalizasPvunoD extends AppCompatActivity {

    private DatabaseHelper db;

    EditText densidadSiembra;
    EditText otroRealSiembra;
    EditText editManoObra;

    RadioButton rdAlmc;
    RadioButton rdSimbDir;
    RadioButton rdCharola;
    RadioButton rdOtroEspcSiem;


    RadioGroup rdgDesvareLimpia;
    RadioGroup rdgSubsoleo;
    RadioGroup rdgBarbecho;
    RadioGroup rdgRastra;
    RadioGroup rdgNivelacion;
    RadioGroup rdgSurcado;

    //+++++++++++++++++++++++
    EditText edtDsvLimpia;
    RadioButton rdEqiProDsvLimpia;
    RadioButton rdEqiMaqDsvLimpia;
    EditText edtChDsvLimpia;
    EditText edtNjDsvLimpia;

    EditText edtSubsoleo;
    RadioButton rdEqiProSubsoleo;
    RadioButton rdEqiMaqSubsoleo;
    EditText edtChSubsoleo;
    EditText edtNjSubsoleo;

    EditText edtBarbecho;
    RadioButton rdEqiProBarbecho;
    RadioButton rdEqiMaqBarbecho;
    EditText edtChBarbecho;
    EditText edtNjBarbecho;

    EditText edtRastra;
    RadioButton rdEqiProRastra;
    RadioButton rdEqiMaqRastra;
    EditText edtChRastra;
    EditText edtNjRastra;

    EditText edtNivelacion;
    RadioButton rdEqiProNivelacion;
    RadioButton rdEqiMaqNivelacion;
    EditText edtChNivelacion;
    EditText edtNjNivelacion;

    EditText edtSurAml;
    RadioButton rdEqiProSurAml;
    RadioButton rdEqiMaqSurAml;
    EditText edtChSurAml;
    EditText edtNjSurAml;


    //++++++++++++++++++++++++++++++++
    //Variablesforsave
    String txtDensidad = null;
    String txtRealizaSiembra = null;
    String txtRealizaSiembraOtro = null;
    String txtManoObra = null;
    String txtManoObraInt = null;

    //VariablesforsavePrepacion Suelo
    String txtDesvLimp = null;
    String txtedtDsvLimpia = null;
    String txtrdEqiProDsvLimpia = null;
    String txtrdEqiMaqDsvLimpia = null;
    String txtedtChDsvLimpia = null;
    String txtedtNjDsvLimpia = null;


    String txtSubSlo = null;
    String txtedtSubsoleo = null;
    String txtrdEqiProSubsoleo = null;
    String txtrdEqiMaqSubsoleo = null;
    String txtedtChSubsoleo = null;
    String txtedtNjSubsoleo = null;

    String txtBarbecho = null;
    String txtedtBarbecho = null;
    String txtrdEqiProBarbecho = null;
    String txtrdEqiMaqBarbecho = null;
    String txtedtChBarbecho = null;
    String txtedtNjBarbecho = null;

    String txtRastra = null;
    String txtedtRastra = null;
    String txtrdEqiProRastra = null;
    String txtrdEqiMaqRastra = null;
    String txtedtChRastra = null;
    String txtedtNjRastra = null;

    String txtNivelacion = null;
    String txtedtNivelacion = null;
    String txtrdEqiProNivelacion = null;
    String txtrdEqiMaqNivelacion = null;
    String txtedtChNivelacion = null;
    String txtedtNjNivelacion = null;

    String txtSurcado = null;
    String txtedtSurAml = null;
    String txtrdEqiProSurAml = null;
    String txtrdEqiMaqSurAml = null;
    String txtedtChSurAml = null;
    String txtedtNjSurAml = null;

    private Boolean desvareLimp = false;
    private Boolean subSoleo = false;
    private Boolean barbecho = false;
    private Boolean rastra = false;
    private Boolean nivelac = false;
    private Boolean surcAmel = false;

    ExtendedFloatingActionButton fabHortUnoD;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hortalizas_pvuno_d);

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        db = new DatabaseHelper(this);

        fabHortUnoD = findViewById(R.id.fab_next_pv_d);

        densidadSiembra = findViewById(R.id.edt_plan_ha);
        otroRealSiembra = findViewById(R.id.edt_otr_esp_sd);

        rdAlmc = findViewById(R.id.ck_alm);
        rdSimbDir = findViewById(R.id.ck_sie_dir);
        rdCharola = findViewById(R.id.ck_cha);
        rdOtroEspcSiem = findViewById(R.id.ck_otr_esp_sd);

        editManoObra = findViewById(R.id.edt_pr_jor);

        rdgDesvareLimpia = findViewById(R.id.rdg_ds_lim);
        rdgSubsoleo = findViewById(R.id.rdg_sub);
        rdgBarbecho = findViewById(R.id.rdg_barb_cc);
        rdgRastra = findViewById(R.id.rdg_rast);
        rdgNivelacion = findViewById(R.id.rdg_niv);
        rdgSurcado = findViewById(R.id.rdg_sur_aml);

        //++++++++++++++++++++Preparacion de Suelo+++++++++++
        edtDsvLimpia = findViewById(R.id.edt_des_lim_nv);
        rdEqiProDsvLimpia = findViewById(R.id.rd_eqi_pro_dv);
        rdEqiMaqDsvLimpia = findViewById(R.id.rd_eqi_maq_dv);
        edtChDsvLimpia = findViewById(R.id.edt_des_lim_ch);
        edtNjDsvLimpia = findViewById(R.id.edt_des_lim_nj);

        edtSubsoleo = findViewById(R.id.edt_sub_rps_nv);
        rdEqiProSubsoleo = findViewById(R.id.rd_eqi_pro_sb);
        rdEqiMaqSubsoleo = findViewById(R.id.rd_eqi_maq_sb);
        edtChSubsoleo = findViewById(R.id.edt_sub_rps_ch);
        edtNjSubsoleo = findViewById(R.id.edt_sub_rps_nj);

        edtBarbecho = findViewById(R.id.edt_barb_rps_nv_cc);
        rdEqiProBarbecho = findViewById(R.id.rd_eqi_pro_brc_cc);
        rdEqiMaqBarbecho = findViewById(R.id.rd_eqi_maq_brc_cc);
        edtChBarbecho = findViewById(R.id.edt_barb_rps_ch_cc);
        edtNjBarbecho = findViewById(R.id.edt_barb_rps_nj_cc);

        edtRastra = findViewById(R.id.edt_ras_rps_nv);
        rdEqiProRastra = findViewById(R.id.rd_eqi_pro_rs);
        rdEqiMaqRastra = findViewById(R.id.rd_eqi_maq_rs);
        edtChRastra = findViewById(R.id.edt_ras_rps_ch);
        edtNjRastra = findViewById(R.id.edt_ras_rps_nj);

        edtNivelacion = findViewById(R.id.edt_nv_rps_nv);
        rdEqiProNivelacion = findViewById(R.id.rd_eqi_pro_nv);
        rdEqiMaqNivelacion = findViewById(R.id.rd_eqi_maq_nv);
        edtChNivelacion = findViewById(R.id.edt_nv_rps_ch);
        edtNjNivelacion = findViewById(R.id.edt_nv_rps_nj);

        edtSurAml = findViewById(R.id.edt_amg_rps_nv);
        rdEqiProSurAml = findViewById(R.id.rd_eqi_pro_sra);
        rdEqiMaqSurAml = findViewById(R.id.rd_eqi_maq_sra);
        edtChSurAml = findViewById(R.id.edt_amg_rps_ch);
        edtNjSurAml = findViewById(R.id.edt_amg_rps_nj);

        //++++++++++++++++++++++++++++++++++++++++++++++++++++

        fabHortUnoD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Boolean vRealizaSiembre = valRealizaSiembra();
                int cont = 0;

                //++++++++++++++++++++++++++++++++
                //Variables  de estado boolean
                Boolean vPreSueloUno = false;
                Boolean vPreSueloDos = true;
                Boolean vPreSueloTres = true;
                Boolean vPreSueloCua = true;
                Boolean vPreSueloCinc = true;
                Boolean vPreSueloSeis = true;

                //++++++++++++++Mano de obra+++++++++++++++++++++++++

                if (!editManoObra.getText().toString().isEmpty()) {
                    txtManoObra = editManoObra.getText().toString();
                    txtManoObraInt = txtManoObra;
                }

                if (!densidadSiembra.getText().toString().isEmpty()) {
                    String strDensidad = densidadSiembra.getText().toString();
                    txtDensidad = strDensidad;
                }

                //Log.e("-->" + "Imprimir" ,txtDesvLimp);
                //validacion


                VariblesGlobalesHortalizas.DENSOI = txtDensidad;
                VariblesGlobalesHortalizas.SIEMOI = txtRealizaSiembra;
                VariblesGlobalesHortalizas.SIEMOOI = txtRealizaSiembraOtro;
                VariblesGlobalesHortalizas.PREJOROI = txtManoObraInt;


                Boolean vreturValor = valdvreturValor();
                if (vreturValor == false) {
                    startActivity(new Intent(getBaseContext(), Nutricion.class));
                    //Snackbar snackbar = Snackbar.make(v, "Great", Snackbar.LENGTH_SHORT);
                    //snackbar.show();
                } else {
                    Snackbar snackbar = Snackbar.make(v, "Verifique los Campos Incompletos" + vreturValor, Snackbar.LENGTH_SHORT);
                    snackbar.show();
                }
            }
        });
    }

    private Boolean valdvreturValor() {
        Boolean valoRtn = valrtnPreparacionSuelo();
        Boolean valoRtnDos = valrtnPreparacionSubsoleo();
        Boolean valoRtnTres = valrtPreparacionBarbecho();
        Boolean valoRtnCuat = valrtPreparacionRastra();
        Boolean valoRtnCnco = valrtPreparacionNivel();
        Boolean valoRtnSeis = valrtPreracionSurcado();
        Boolean errochek = true;

        if (desvareLimp && txtDesvLimp != null && valoRtn == false) {
            //VariblesGlobalesHortalizas.FOLIO = ;
            VariblesGlobalesHortalizas.TIPOCULTIV = "Hortaliza";
            VariblesGlobalesHortalizas.CICLOPROD = VariblesGlobalesHortalizas.CICPRO;
            VariblesGlobalesHortalizas.LABPRES = txtDesvLimp;
            VariblesGlobalesHortalizas.NUMVL = txtedtDsvLimpia;
            VariblesGlobalesHortalizas.EQUIPOL = txtrdEqiProDsvLimpia;
            VariblesGlobalesHortalizas.COSTOL = txtedtChDsvLimpia;
            VariblesGlobalesHortalizas.NUMJORL = txtedtNjDsvLimpia;
            errochek = false;
            agregarPreparacionSuelo();
        }else if(valoRtn == true) {
            return true;
        }

        if (subSoleo && txtSubSlo != null && valoRtnDos == false) {
            VariblesGlobalesHortalizas.TIPOCULTIV = "Hortaliza";
            VariblesGlobalesHortalizas.CICLOPROD = VariblesGlobalesHortalizas.CICPRO;
            VariblesGlobalesHortalizas.LABPRES = txtSubSlo;
            VariblesGlobalesHortalizas.NUMVL = txtedtSubsoleo;
            VariblesGlobalesHortalizas.EQUIPOL = txtrdEqiProSubsoleo;
            VariblesGlobalesHortalizas.COSTOL = txtedtChSubsoleo;
            VariblesGlobalesHortalizas.NUMJORL = txtedtNjSubsoleo;
            errochek = false;
            agregarPreparacionSuelo();
        }else if(valoRtnDos== true){
            return true;
        }

        if (barbecho && txtBarbecho != null && valoRtnTres == false) {
            VariblesGlobalesHortalizas.TIPOCULTIV = "Hortaliza";
            VariblesGlobalesHortalizas.CICLOPROD = VariblesGlobalesHortalizas.CICPRO;
            VariblesGlobalesHortalizas.LABPRES = txtBarbecho;
            VariblesGlobalesHortalizas.NUMVL = txtedtBarbecho;
            VariblesGlobalesHortalizas.EQUIPOL = txtrdEqiProBarbecho;
            VariblesGlobalesHortalizas.COSTOL = txtedtChBarbecho;
            VariblesGlobalesHortalizas.NUMJORL = txtedtNjBarbecho;
            errochek = false;
            agregarPreparacionSuelo();
        }else if(valoRtnTres== true){
            return true;
        }


        if (rastra && txtRastra != null && valoRtnCuat == false) {
            VariblesGlobalesHortalizas.TIPOCULTIV = "Hortaliza";
            VariblesGlobalesHortalizas.CICLOPROD = VariblesGlobalesHortalizas.CICPRO;
            VariblesGlobalesHortalizas.LABPRES = txtRastra;
            VariblesGlobalesHortalizas.NUMVL = txtedtRastra;
            VariblesGlobalesHortalizas.EQUIPOL = txtrdEqiProRastra;
            VariblesGlobalesHortalizas.COSTOL = txtedtChRastra;
            VariblesGlobalesHortalizas.NUMJORL = txtedtNjRastra;
            errochek = false;
            agregarPreparacionSuelo();
        }else if(valoRtnCuat== true){
            return true;
        }

        if (nivelac && txtNivelacion != null && valoRtnCnco == false) {
            VariblesGlobalesHortalizas.TIPOCULTIV = "Hortaliza";
            VariblesGlobalesHortalizas.CICLOPROD = VariblesGlobalesHortalizas.CICPRO;
            VariblesGlobalesHortalizas.LABPRES = txtNivelacion;
            VariblesGlobalesHortalizas.NUMVL = txtedtNivelacion;
            VariblesGlobalesHortalizas.EQUIPOL = txtrdEqiProNivelacion;
            VariblesGlobalesHortalizas.COSTOL = txtedtChNivelacion;
            VariblesGlobalesHortalizas.NUMJORL = txtedtNjNivelacion;
            errochek = false;
            agregarPreparacionSuelo();
        }else if(valoRtnCnco== true){
            return true;
        }

        if (surcAmel && txtSurcado != null && valoRtnSeis == false) {
            VariblesGlobalesHortalizas.TIPOCULTIV = "Hortaliza";
            VariblesGlobalesHortalizas.CICLOPROD = VariblesGlobalesHortalizas.CICPRO;
            VariblesGlobalesHortalizas.LABPRES = txtSurcado;
            VariblesGlobalesHortalizas.NUMVL = txtedtSurAml;
            VariblesGlobalesHortalizas.EQUIPOL = txtrdEqiProSurAml;
            VariblesGlobalesHortalizas.COSTOL = txtedtChSurAml;
            VariblesGlobalesHortalizas.NUMJORL = txtedtNjSurAml;
            errochek = false;
            agregarPreparacionSuelo();
        }else if(valoRtnSeis== true){
            return true;
        }


        return errochek;
    }


    private Boolean valrtnPreparacionSuelo() {

        if (txtDesvLimp != null && (edtDsvLimpia.getText().toString().isEmpty() || edtChDsvLimpia.getText().toString().isEmpty() || edtNjDsvLimpia.getText().toString().isEmpty() || txtrdEqiProDsvLimpia == null)) {
            return true;
        } else if (txtDesvLimp != null && !edtDsvLimpia.getText().toString().isEmpty() && !edtChDsvLimpia.getText().toString().isEmpty() && !edtNjDsvLimpia.getText().toString().isEmpty() && txtrdEqiProDsvLimpia != null) {
            txtedtChDsvLimpia = edtChDsvLimpia.getText().toString();
            txtedtNjDsvLimpia = edtNjDsvLimpia.getText().toString();
            txtedtDsvLimpia = edtDsvLimpia.getText().toString();
            desvareLimp = true;
            return false;
        }

        //return errochCheke;
        return false;
    }

    private Boolean valrtnPreparacionSubsoleo() {
        Boolean errochCheke = true;
        if (txtSubSlo != null && (edtSubsoleo.getText().toString().isEmpty() || edtChSubsoleo.getText().toString().isEmpty() || edtNjSubsoleo.getText().toString().isEmpty() || txtrdEqiProSubsoleo == null)) {
            errochCheke = true;
            return true;
        } else if (txtSubSlo != null && !edtSubsoleo.getText().toString().isEmpty() && !edtChSubsoleo.getText().toString().isEmpty() && !edtNjSubsoleo.getText().toString().isEmpty() && txtrdEqiProSubsoleo != null) {
            txtedtChSubsoleo = edtChSubsoleo.getText().toString();
            txtedtNjSubsoleo = edtNjSubsoleo.getText().toString();
            txtedtSubsoleo = edtSubsoleo.getText().toString();
            subSoleo = true;
            return false;
        }
        //return errochCheke;
        return false;
    }




    private Boolean valrtPreparacionBarbecho() {
        Boolean errochCheke = true;
        if (txtBarbecho != null && (edtBarbecho.getText().toString().isEmpty() || edtChBarbecho.getText().toString().isEmpty() || edtNjBarbecho.getText().toString().isEmpty() || txtrdEqiProBarbecho == null)) {
            errochCheke = true;
            return true;
        } else if (txtBarbecho != null && (!edtBarbecho.getText().toString().isEmpty() && !edtChBarbecho.getText().toString().isEmpty() && !edtNjBarbecho.getText().toString().isEmpty() && txtrdEqiProBarbecho != null)) {
            txtedtChBarbecho = edtChBarbecho.getText().toString();
            txtedtNjBarbecho = edtNjBarbecho.getText().toString();
            txtedtBarbecho = edtBarbecho.getText().toString();
            barbecho = true;
            return false;
        }
        //return errochCheke;
        return false;
    }

    private Boolean valrtPreparacionRastra() {
        Boolean errochCheke = true;
        if (txtRastra != null && (edtRastra.getText().toString().isEmpty() || edtChRastra.getText().toString().isEmpty() || edtNjRastra.getText().toString().isEmpty() || txtrdEqiProRastra == null)) {
            errochCheke = true;
            return true;
        } else if (txtRastra != null && (!edtRastra.getText().toString().isEmpty() && !edtChRastra.getText().toString().isEmpty() && !edtNjRastra.getText().toString().isEmpty() && txtrdEqiProRastra != null)) {
            txtedtChRastra = edtChRastra.getText().toString();
            txtedtNjRastra = edtNjRastra.getText().toString();
            txtedtRastra = edtRastra.getText().toString();
            rastra = true;
            return false;
        }
        //return errochCheke;
        return false;
    }

    private Boolean valrtPreparacionNivel() {
        //Boolean errochCheke = true;
        if (txtNivelacion != null && (edtNivelacion.getText().toString().isEmpty() || edtChNivelacion.getText().toString().isEmpty() || edtNjNivelacion.getText().toString().isEmpty() || txtrdEqiProNivelacion == null)) {
            //  errochCheke = true;
            return true;
        } else if (txtNivelacion != null && (!edtNivelacion.getText().toString().isEmpty() && !edtChNivelacion.getText().toString().isEmpty() && !edtNjNivelacion.getText().toString().isEmpty() && txtrdEqiProNivelacion != null)) {
            txtedtChNivelacion = edtChNivelacion.getText().toString();
            txtedtNjNivelacion = edtNjNivelacion.getText().toString();
            txtedtNivelacion = edtNivelacion.getText().toString();
            nivelac = true;
            return false;
        }
        //return errochCheke;
        return false;
    }


    private Boolean valrtPreracionSurcado() {
        //Boolean errochCheke = true;
        if (txtSurcado != null && (edtSurAml.getText().toString().isEmpty() || edtChSurAml.getText().toString().isEmpty() || edtNjSurAml.getText().toString().isEmpty() || txtrdEqiProSurAml == null)) {
            // errochCheke = true;
            return true;
        } else if (txtSurcado != null && (!edtSurAml.getText().toString().isEmpty() && !edtChSurAml.getText().toString().isEmpty() && !edtNjSurAml.getText().toString().isEmpty() && txtrdEqiProSurAml != null)) {
            txtedtChSurAml = edtChSurAml.getText().toString();
            txtedtNjSurAml = edtNjSurAml.getText().toString();
            txtedtSurAml = edtSurAml.getText().toString();
            surcAmel = true;
            //return true;
            return false;
        }
        //return errochCheke;
        return false;
    }

    private void agregarPreparacionSuelo() {
        boolean insertarData = db.addPreparacionSuelo();
        if (insertarData == true) {
            // Toast.makeText(this, "Datos insertados correctamente", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Algo salio mal", Toast.LENGTH_LONG).show();
        }
    }


    private Boolean valRealizaSiembra() {

        if (txtRealizaSiembra != null) {
            if (txtRealizaSiembra == "Otro" && !otroRealSiembra.getText().toString().isEmpty()) {
                txtRealizaSiembraOtro = otroRealSiembra.getText().toString();
                return true;
            } else if (txtRealizaSiembra != "Otro") {
                return true;
            }
        }
        return false;
    }


    public void howrealizaSiembra(View view) {
        boolean checkedTipo = ((RadioButton) view).isChecked();
        switch (view.getId()) {
            case R.id.ck_alm:
                if (checkedTipo) {
                    txtRealizaSiembra = "Almacigo";
                    otroRealSiembra.setText("");
                    otroRealSiembra.setEnabled(false);
                }
                break;
            case R.id.ck_sie_dir:
                if (checkedTipo) {
                    txtRealizaSiembra = "Siembra directa";
                    otroRealSiembra.setText("");
                    otroRealSiembra.setEnabled(false);
                }
                break;
            case R.id.ck_cha:
                if (checkedTipo) {
                    txtRealizaSiembra = "Charola";
                    otroRealSiembra.setText("");
                    otroRealSiembra.setEnabled(false);
                }
                break;
            case R.id.ck_otr_esp_sd:
                if (checkedTipo) {
                    txtRealizaSiembra = "Otro";
                    otroRealSiembra.setEnabled(true);
                }
                break;
        }
    }

    @Override
    public void onBackPressed() {

    }

    public void preparacionSuelo(View view) {
        boolean checkedTipo = ((CheckBox) view).isChecked();

        switch (view.getId()) {
            case R.id.ck_des_lim:
                if (checkedTipo) {
                    txtDesvLimp = "Desvare y limpia";
                    edtDsvLimpia.setEnabled(true);
                    rdEqiProDsvLimpia.setEnabled(true);
                    rdEqiMaqDsvLimpia.setEnabled(true);
                    edtChDsvLimpia.setEnabled(true);
                    edtNjDsvLimpia.setEnabled(true);

                } else {
                    rdgDesvareLimpia.clearCheck();
                    edtDsvLimpia.setEnabled(false);
                    rdEqiProDsvLimpia.setEnabled(false);
                    rdEqiMaqDsvLimpia.setEnabled(false);
                    edtChDsvLimpia.setEnabled(false);
                    edtNjDsvLimpia.setEnabled(false);

                    edtDsvLimpia.setText("");
                    edtChDsvLimpia.setText("");
                    edtNjDsvLimpia.setText("");

                    txtDesvLimp = null;
                    txtrdEqiProDsvLimpia = null;
                    txtrdEqiMaqDsvLimpia = null;
                    txtedtChDsvLimpia = null;
                    txtedtNjDsvLimpia = null;
                }
                break;
            case R.id.ck_sub_rps:
                if (checkedTipo) {
                    txtSubSlo = "Subsoleo";
                    edtSubsoleo.setEnabled(true);
                    rdEqiProSubsoleo.setEnabled(true);
                    rdEqiMaqSubsoleo.setEnabled(true);
                    edtChSubsoleo.setEnabled(true);
                    edtNjSubsoleo.setEnabled(true);

                } else {
                    edtSubsoleo.setEnabled(false);
                    rdEqiProSubsoleo.setEnabled(false);
                    rdEqiMaqSubsoleo.setEnabled(false);
                    edtChSubsoleo.setEnabled(false);
                    edtNjSubsoleo.setEnabled(false);
                    edtSubsoleo.setText("");
                    edtChSubsoleo.setText("");
                    edtNjSubsoleo.setText("");
                    txtSubSlo = null;
                    txtrdEqiProSubsoleo = null;
                    txtrdEqiMaqSubsoleo = null;
                    txtedtChSubsoleo = null;
                    txtedtNjSubsoleo = null;
                    rdgSubsoleo.clearCheck();
                }
                break;

            case R.id.ck_barb_rps_cc:
                if (checkedTipo) {
                    txtBarbecho = "Barbecho";
                    edtBarbecho.setEnabled(true);
                    rdEqiProBarbecho.setEnabled(true);
                    rdEqiMaqBarbecho.setEnabled(true);
                    edtChBarbecho.setEnabled(true);
                    edtNjBarbecho.setEnabled(true);
                } else {
                    edtBarbecho.setEnabled(false);
                    rdEqiProBarbecho.setEnabled(false);
                    rdEqiMaqBarbecho.setEnabled(false);
                    edtChBarbecho.setEnabled(false);
                    edtNjBarbecho.setEnabled(false);
                    edtBarbecho.setText("");
                    edtChBarbecho.setText("");
                    edtNjBarbecho.setText("");
                    txtBarbecho = null;
                    txtrdEqiProBarbecho = null;
                    txtrdEqiMaqBarbecho = null;
                    txtedtChBarbecho = null;
                    txtedtNjBarbecho = null;
                    rdgBarbecho.clearCheck();
                }
                break;
            case R.id.ck_ras_rps:
                if (checkedTipo) {
                    txtRastra = "Rastra";
                    edtRastra.setEnabled(true);
                    rdEqiProRastra.setEnabled(true);
                    rdEqiMaqRastra.setEnabled(true);
                    edtChRastra.setEnabled(true);
                    edtNjRastra.setEnabled(true);
                } else {
                    edtRastra.setEnabled(false);
                    rdEqiProRastra.setEnabled(false);
                    rdEqiMaqRastra.setEnabled(false);
                    edtChRastra.setEnabled(false);
                    edtNjRastra.setEnabled(false);
                    edtRastra.setText("");
                    edtChRastra.setText("");
                    edtNjRastra.setText("");
                    txtRastra = null;
                    txtrdEqiProRastra = null;
                    txtrdEqiMaqRastra = null;
                    txtedtChRastra = null;
                    txtedtNjRastra = null;
                    rdgRastra.clearCheck();
                }
                break;
            case R.id.ck_nv_rps:
                if (checkedTipo) {
                    txtNivelacion = "Nivelación";
                    edtNivelacion.setEnabled(true);
                    rdEqiProNivelacion.setEnabled(true);
                    rdEqiMaqNivelacion.setEnabled(true);
                    edtChNivelacion.setEnabled(true);
                    edtNjNivelacion.setEnabled(true);
                } else {
                    edtNivelacion.setEnabled(false);
                    rdEqiProNivelacion.setEnabled(false);
                    rdEqiMaqNivelacion.setEnabled(false);
                    edtChNivelacion.setEnabled(false);
                    edtNjNivelacion.setEnabled(false);
                    edtNivelacion.setText("");
                    edtChNivelacion.setText("");
                    edtNjNivelacion.setText("");
                    txtNivelacion = null;
                    txtrdEqiProNivelacion = null;
                    txtrdEqiMaqNivelacion = null;
                    txtedtChNivelacion = null;
                    txtedtNjNivelacion = null;
                    rdgNivelacion.clearCheck();
                }
                break;
            case R.id.ck_amg_rps:
                if (checkedTipo) {
                    txtSurcado = "Surcado o amelgado";
                    edtSurAml.setEnabled(true);
                    rdEqiProSurAml.setEnabled(true);
                    rdEqiMaqSurAml.setEnabled(true);
                    edtChSurAml.setEnabled(true);
                    edtNjSurAml.setEnabled(true);
                } else {
                    edtSurAml.setEnabled(false);
                    rdEqiProSurAml.setEnabled(false);
                    rdEqiMaqSurAml.setEnabled(false);
                    edtChSurAml.setEnabled(false);
                    edtNjSurAml.setEnabled(false);
                    edtSurAml.setText("");
                    edtChSurAml.setText("");
                    edtNjSurAml.setText("");
                    txtSurcado = null;
                    txtrdEqiProSurAml = null;
                    txtrdEqiMaqSurAml = null;
                    txtedtChSurAml = null;
                    txtedtNjSurAml = null;
                    rdgSurcado.clearCheck();
                }
                break;
        }
    }

    /*
    public void pmPropioMaquina(View view) {
        boolean checkedTipos = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.rd_eqi_pro_dv:
                if (checkedTipos) {
                    txtrdEqiProDsvLimpia = "Propio";
                }
                break;
            case R.id.rd_eqi_maq_dv:
                if (checkedTipos) {
                    txtrdEqiProDsvLimpia = "Maquila";
                }
                break;
        }
    }

    */
    public void pmPropioMaquina(View view) {
        boolean checkedTipo = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.rd_eqi_pro_dv:
                if (checkedTipo) {
                    txtrdEqiProDsvLimpia = "Propio";
                }
                break;
            case R.id.rd_eqi_maq_dv:
                if (checkedTipo) {
                    txtrdEqiProDsvLimpia = "Maquila";
                }
                break;
            case R.id.rd_eqi_pro_sb:
                if (checkedTipo) {
                    txtrdEqiProSubsoleo = "Propio";
                }
                break;
            case R.id.rd_eqi_maq_sb:
                if (checkedTipo) {
                    txtrdEqiProSubsoleo = "Maquila";
                }
                break;
            case R.id.rd_eqi_pro_brc_cc:
                if (checkedTipo) {
                    txtrdEqiProBarbecho = "Propio";
                }
                break;
            case R.id.rd_eqi_maq_brc_cc:
                if (checkedTipo) {
                    txtrdEqiProBarbecho = "Maquila";
                }
                break;
            case R.id.rd_eqi_pro_rs:
                if (checkedTipo) {
                    txtrdEqiProRastra = "Propio";
                }
                break;
            case R.id.rd_eqi_maq_rs:
                if (checkedTipo) {
                    txtrdEqiProRastra = "Maquila";
                }
                break;
            case R.id.rd_eqi_pro_nv:
                if (checkedTipo) {
                    txtrdEqiProNivelacion = "Propio";
                }
                break;
            case R.id.rd_eqi_maq_nv:
                if (checkedTipo) {
                    txtrdEqiProNivelacion = "Maquila";
                }
                break;
            case R.id.rd_eqi_pro_sra:
                if (checkedTipo) {
                    txtrdEqiProSurAml = "Propio";
                }
                break;
            case R.id.rd_eqi_maq_sra:
                if (checkedTipo) {
                    txtrdEqiProSurAml = "Maquila";
                }
                break;
        }
    }

}
