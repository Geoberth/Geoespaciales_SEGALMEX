package com.example.geosegalmex.unidadcaracterizacionhortalizas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.RadioButton;

import com.example.geosegalmex.R;
import com.example.geosegalmex.unidadcaracterizacionhortalizas.variables.VariblesGlobalesHortalizas;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class ControlPlagasEnfermC extends AppCompatActivity {

    ExtendedFloatingActionButton fabConPlagEnfC;
    EditText edtOtroOrgPlgEnf;

    String txtOrntMan = null;
    String txtNvlCalFoti = null;
    String txtOrgPlgEnf = null;
    String txtOtroOrgPlgEnf = null;
    String txtCntrlBioPgEnf = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_control_plagas_enferm_c);
        edtOtroOrgPlgEnf = findViewById(R.id.edt_ot_pe_fe);

        fabConPlagEnfC = findViewById(R.id.fab_next_enf_c_fe);

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

        fabConPlagEnfC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Boolean errorPlgEnf = false;

                if(txtOrgPlgEnf == "Otro" && edtOtroOrgPlgEnf.getText().toString().isEmpty()){
                    errorPlgEnf = true;
                    Snackbar snackbar = Snackbar.make(v, "Ingrese el tipo de Plaga...Otro", Snackbar.LENGTH_SHORT);
                    snackbar.show();
                }else if(errorPlgEnf == false) {
                    txtOtroOrgPlgEnf = edtOtroOrgPlgEnf.getText().toString();
                    VariblesGlobalesHortalizas.UMPQUIPV = txtOrntMan;
                    VariblesGlobalesHortalizas.NIVCSH  = txtNvlCalFoti;
                    VariblesGlobalesHortalizas.ORPLENPV = txtOrgPlgEnf;
                    VariblesGlobalesHortalizas.ORPLAOTRO = txtOtroOrgPlgEnf;
                    VariblesGlobalesHortalizas.CBIOMPE = txtCntrlBioPgEnf;
                    startActivity(new Intent(getBaseContext(), Cosecha.class));
                }
            }
        });
    }

    @Override
    public void onBackPressed() {

    }

    public void tipoOrientacionMQi(View view) {
        boolean checkedTipo = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.rd_si_ori_pr_fe:
                if (checkedTipo) {
                    txtOrntMan = "Si";
                }
                break;
            case R.id.rd_no_ori_pr_fe:
                if (checkedTipo) {
                    txtOrntMan = "No";
                }
                break;
        }
    }

    public void nivelCalidadFito(View view) {
        boolean checkedTipo = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.rd_al_nv_fe:
                if (checkedTipo) {
                    txtNvlCalFoti = "Alta";
                }
                break;
            case R.id.rd_md_nv_fe:
                if (checkedTipo) {
                    txtNvlCalFoti = "Media";
                }
                break;

            case R.id.rd_bj_nv_fe:
                if (checkedTipo) {
                    txtNvlCalFoti = "Baja";
                }
                break;
        }
    }

    public void origenPlgsEnfer(View view) {
        boolean checkedTipo = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.ck_su_pe_fe:
                if (checkedTipo) {
                    txtOrgPlgEnf = "El suelo";
                    edtOtroOrgPlgEnf.setText("");
                    edtOtroOrgPlgEnf.setEnabled(false);
                }
                break;
            case R.id.ck_ag_pe_fe:
                if (checkedTipo) {
                    txtOrgPlgEnf = "El agua";
                    edtOtroOrgPlgEnf.setText("");
                    edtOtroOrgPlgEnf.setEnabled(false);
                }
                break;
            case R.id.ck_sm_pe_fe:
                if (checkedTipo) {
                    txtOrgPlgEnf = "La semilla o material vegetativo";
                    edtOtroOrgPlgEnf.setText("");
                    edtOtroOrgPlgEnf.setEnabled(false);
                }
                break;
            case R.id.ck_ut_pe_fe:
                if (checkedTipo) {
                    txtOrgPlgEnf = "Utensilios de trabajo ";
                    edtOtroOrgPlgEnf.setText("");
                    edtOtroOrgPlgEnf.setEnabled(false);
                }
                break;
            case R.id.ck_ot_pe_fe:
                if (checkedTipo) {
                    txtOrgPlgEnf = "Otro";
                    edtOtroOrgPlgEnf.setEnabled(true);
                }
                break;
        }
    }

    public void controBiolgPlgs(View view) {
        boolean checkedTipo = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.rd_si_cb_fe:
                if (checkedTipo) {
                    txtCntrlBioPgEnf = "Si";
                }
                break;
            case R.id.rd_no_cb_fe:
                if (checkedTipo) {
                    txtCntrlBioPgEnf = "No";
                }
                break;
        }
    }
}