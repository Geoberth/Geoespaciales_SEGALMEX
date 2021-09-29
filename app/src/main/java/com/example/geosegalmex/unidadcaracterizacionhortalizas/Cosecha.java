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
import android.widget.Toast;

import com.example.geosegalmex.R;
import com.example.geosegalmex.unidadcaracterizacionhortalizas.db.DatabaseHelper;
import com.example.geosegalmex.unidadcaracterizacionhortalizas.variables.VariblesGlobalesHortalizas;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class Cosecha extends AppCompatActivity {
    ExtendedFloatingActionButton fabCosecha;
    TextView txtCosh;

    EditText edtCorte;
    EditText edtRecoleccion;
    EditText edtSeleccion;
    EditText edtLavado;
    EditText edtTrataPostCorte;
    EditText edtEmpaque;
    EditText edtAcarreo;

    EditText edSiCntIno;

    //Variables
    //Seleccion de Actividad
    String txtCorte = null;
    String txtRecoleccion = null;;
    String txtSeleccion = null;;
    String txtLavado = null;;
    String txtTrataPostCorte = null;
    String txtEmpaque = null;
    String txtAcarreo = null;
    //Edittext Numero Jornales
    String edtTxtCorte = null;
    String edtTxtRecoleccion = null;
    String edtTxtSeleccion = null;
    String edtTxtLavado = null;
    String edtTxtTrataPostCorte  = null;
    String edtTxtEmpaque = null;
    String edtTxtAcarreo = null;

    //ControlInocuidad
    String txtCntrolInocuidad = null;
    String txtedSiCntIno = null;
    private DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cosecha);

        db = new DatabaseHelper(this);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

        fabCosecha = findViewById(R.id.fab_next_cos_c_fe);
        txtCosh    = findViewById(R.id.tx_tit_cos);

        edtCorte=  findViewById(R.id.edt_cor_cs_fe);
        edtRecoleccion=  findViewById(R.id.edt_rec_cs_fe);
        edtSeleccion=  findViewById(R.id.edt_sel_cs_fe);
        edtLavado=  findViewById(R.id.edt_lav_cs_fe);
        edtTrataPostCorte=  findViewById(R.id.edt_trp_cs_fe);
        edtEmpaque=  findViewById(R.id.edt_emp_cs_fe);
        edtAcarreo=  findViewById(R.id.edt_acrr_cs_fe);

        edSiCntIno = findViewById(R.id.edt_si_ci_cs_fe);

        if(hortalizas.valorTempCosPv == 1){
            txtCosh.setText(getString(R.string.name_mod_csh_pv));
        }else if(hortalizas.valorTempCosOi == 1){
            txtCosh.setText(getString(R.string.name_mod_csh_oi));
        }


        fabCosecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Boolean errorIno = false;
                Boolean valCosecha = validaCosecha();

                if (txtCntrolInocuidad != null) {
                    if(txtCntrolInocuidad == "No"){
                        errorIno = false;

                    }else if (txtCntrolInocuidad == "Si" && edSiCntIno.getText().toString().isEmpty()) {
                        errorIno = true;

                    } else if (txtCntrolInocuidad == "Si" && !edSiCntIno.getText().toString().isEmpty()) {
                        errorIno = false;
                        txtedSiCntIno = edSiCntIno.getText().toString();
                        VariblesGlobalesHortalizas.INOHOR = txtCntrolInocuidad;
                        VariblesGlobalesHortalizas.INOHORTIP= txtedSiCntIno;
                        //startActivity(new Intent(getBaseContext(), CosechaB.class));
                    }
                }


                if(valCosecha == false && errorIno == false && txtCntrolInocuidad != null){
                    VariblesGlobalesHortalizas.INOHORTIP= null;
                    VariblesGlobalesHortalizas.INOHOR = txtCntrolInocuidad;

                    if(txtCorte== "Corte"){
                        VariblesGlobalesHortalizas.ACTCOSECH = txtCorte ;
                        VariblesGlobalesHortalizas.JORCOSGR =edtTxtCorte;
                        aggCosecha();
                    }

                    if(txtRecoleccion == "Recolección"){
                        VariblesGlobalesHortalizas.ACTCOSECH = txtRecoleccion ;
                        VariblesGlobalesHortalizas.JORCOSGR =edtTxtRecoleccion;
                        aggCosecha();
                    }

                    if(txtSeleccion == "Selección"){
                        VariblesGlobalesHortalizas.ACTCOSECH = txtSeleccion ;
                        VariblesGlobalesHortalizas.JORCOSGR =edtTxtSeleccion;
                        aggCosecha();
                    }

                    if(txtLavado == "Lavado" ){
                        VariblesGlobalesHortalizas.ACTCOSECH = txtLavado ;
                        VariblesGlobalesHortalizas.JORCOSGR =edtTxtLavado;
                        aggCosecha();
                    }

                    if(txtTrataPostCorte == "Tratamiento de post corte"){
                        VariblesGlobalesHortalizas.ACTCOSECH = txtTrataPostCorte ;
                        VariblesGlobalesHortalizas.JORCOSGR =edtTxtTrataPostCorte;
                        aggCosecha();
                    }

                    if(txtEmpaque == "Empaque en campo"){
                        VariblesGlobalesHortalizas.ACTCOSECH = txtEmpaque;
                        VariblesGlobalesHortalizas.JORCOSGR =edtTxtEmpaque;
                        aggCosecha();
                    }

                    if(txtAcarreo== "Acarreo"){
                        VariblesGlobalesHortalizas.ACTCOSECH = txtAcarreo;
                        VariblesGlobalesHortalizas.JORCOSGR =edtTxtAcarreo;
                        aggCosecha();
                    }
                    startActivity(new Intent(getBaseContext(), CosechaB.class));

                }else if(valCosecha == true || errorIno == true || txtCntrolInocuidad == null){
                    Snackbar snackbar = Snackbar.make(v, "Verifique su informacion", Snackbar.LENGTH_SHORT);
                    snackbar.show();
                }

            }
        });
    }

    private void aggCosecha() {
        boolean insertarData = db.addCosecha();
        if(insertarData == true) {
            Toast.makeText(this, "Datos insertados correctamente", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Algo salio mal", Toast.LENGTH_LONG).show();
        }
    }

    private Boolean validaCosecha() {
        Boolean errorCorte = false;
        Boolean errorRecole = false;
        Boolean errorSelc = false;
        Boolean errorLav = false;
        Boolean errorTrCr = false;
        Boolean errorEmpCm = false;
        Boolean errorAcrr = false;



        if(txtCorte== "Corte" && edtCorte.getText().toString().isEmpty()){
            errorCorte = true;

        }else if(txtCorte== "Corte" && !edtCorte.getText().toString().isEmpty()){
            errorCorte = false;
            edtTxtCorte = edtCorte.getText().toString();
        }

        if(txtRecoleccion == "Recolección" && edtRecoleccion.getText().toString().isEmpty()){
            errorRecole = true;

        }else if(txtRecoleccion == "Recolección" && !edtRecoleccion.getText().toString().isEmpty()){
            errorRecole = false;
            edtTxtRecoleccion = edtRecoleccion.getText().toString();
        }


        if(txtSeleccion == "Selección" && edtSeleccion.getText().toString().isEmpty()){
            errorSelc = true;

        }else if(txtSeleccion == "Selección" && !edtSeleccion.getText().toString().isEmpty()){
            errorSelc = false;
            edtTxtCorte = edtSeleccion.getText().toString();
        }

        if(txtLavado == "Lavado" && edtLavado.getText().toString().isEmpty()){
            errorLav = true;

        }else if(txtLavado == "Lavado" && !edtLavado.getText().toString().isEmpty()){
            errorLav = false;
            edtTxtLavado = edtLavado.getText().toString();
        }

        if(txtTrataPostCorte == "Tratamiento de post corte" && edtTrataPostCorte.getText().toString().isEmpty()){
            errorTrCr = true;

        }else if(txtTrataPostCorte == "Tratamiento de post corte" && !edtTrataPostCorte.getText().toString().isEmpty()){
            errorTrCr = false;
            edtTxtTrataPostCorte = edtTrataPostCorte.getText().toString();
        }

        if(txtEmpaque == "Empaque en campo" && edtEmpaque.getText().toString().isEmpty()){
            errorEmpCm = true;

        }else if(txtEmpaque == "Empaque en campo" && !edtEmpaque.getText().toString().isEmpty()){
            errorEmpCm = false;
            edtTxtEmpaque = edtEmpaque.getText().toString();
        }

        if(txtAcarreo== "Acarreo" && edtAcarreo.getText().toString().isEmpty()){
            errorAcrr = true;

        }else if(txtAcarreo== "Acarreo" && !edtAcarreo.getText().toString().isEmpty()){
            errorAcrr = false;
            edtTxtAcarreo = edtAcarreo.getText().toString();
        }

        if(errorCorte ||  errorRecole || errorSelc || errorLav || errorTrCr || errorEmpCm ||  errorAcrr){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public void onBackPressed() {

    }

    public void cosechaActividad(View view) {
        boolean checkedTipo = ((CheckBox) view).isChecked();
        switch (view.getId()) {
            case R.id.ck_crt_cs_fe:
                if (checkedTipo) {
                    edtCorte.setEnabled(true);
                    txtCorte= "Corte";
                }else{
                    txtCorte= null;
                    edtCorte.setText("");
                    edtCorte.setEnabled(false);
                }
                break;
            case R.id.ck_rec_cs_fe:
                if (checkedTipo) {
                    txtRecoleccion= "Recolección";
                    edtRecoleccion.setEnabled(true);
                }else{
                    txtRecoleccion= null;
                    edtRecoleccion.setText("");
                    edtRecoleccion.setEnabled(false);
                }
                break;
            case R.id.ck_sel_cs_fe:
                if (checkedTipo) {
                    txtSeleccion= "Selección";
                    edtSeleccion.setEnabled(true);
                }else{
                    txtSeleccion= null;
                    edtSeleccion.setText("");
                    edtSeleccion.setEnabled(false);
                }
                break;
            case R.id.ck_lvd_cs_fe:
                if (checkedTipo) {
                    txtLavado= "Lavado";
                    edtLavado.setEnabled(true);
                }else{
                    txtLavado= null;
                    edtLavado.setText("");
                    edtLavado.setEnabled(false);
                }
                break;
            case R.id.ck_tpc_cs_fe:
                if (checkedTipo) {
                    txtTrataPostCorte= "Tratamiento de post corte";
                    edtTrataPostCorte.setEnabled(true);
                }else{
                    txtTrataPostCorte= null;
                    edtTrataPostCorte.setText("");
                    edtTrataPostCorte.setEnabled(false);
                }
                break;
            case R.id.ck_emc_cs_fe:
                if (checkedTipo) {
                    edtEmpaque.setEnabled(true);
                    txtEmpaque= "Empaque en campo";
                }else{
                    txtEmpaque= null;
                    edtEmpaque.setText("");
                    edtEmpaque.setEnabled(false);
                }
                break;
            case R.id.ck_acr_cs_fe:
                if (checkedTipo) {
                    txtAcarreo= "Acarreo";
                    edtAcarreo.setEnabled(true);
                }else{
                    txtAcarreo= null;
                    edtAcarreo.setText("");
                    edtAcarreo.setEnabled(false);
                }
                break;
        }
    }

    public void controlInocuidad(View view) {
        boolean checkedTipo = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.rd_si_ci_cs_fe:
                if (checkedTipo) {
                    txtCntrolInocuidad = "Si";
                    edSiCntIno.setEnabled(true);
                }
                break;
            case R.id.rd_no_ci_cs_fe:
                if (checkedTipo) {
                    txtCntrolInocuidad = "No";
                    edSiCntIno.setText("");
                    edSiCntIno.setEnabled(false);
                }
                break;
        }
    }
}

