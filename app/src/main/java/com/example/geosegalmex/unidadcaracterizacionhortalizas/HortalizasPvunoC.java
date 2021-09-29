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

public class HortalizasPvunoC extends AppCompatActivity {
    EditText editPrecSc;
    EditText editCantSc;

    EditText editOtrPreProc;
    EditText editOtrCantProc;

    EditText editCertNm;
    EditText editCertPrec;
    EditText editCertCant;
    EditText editVarProduc;

    //Variablesforsave
    String  semillaCriolla =  null;
    String  semillaCriollaPrecio = null;
    String  semillaCriollaCantidad = null;

    String  semillaCriollaProced = null;
    String  semillaCriollaProcedPrec = null;
    String  semillaCriollaProcedCant = null;

    String  semillaCertProced = null;
    String  semillaCertProcedNm = null;
    String  semillaCertProcedPrec = null;
    String  semillaCertProcedCant = null;
    String  semillaCertProcedVar = null;

    String selecSemPropia = null;

    ExtendedFloatingActionButton btnEncuesta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hortalizas_pvuno_c);

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

        editPrecSc = findViewById(R.id.ed_cr_pro_pr);
        editCantSc = findViewById(R.id.ed_cr_pro_ca);

        editOtrPreProc = findViewById(R.id.ed_ot_pro_pr);
        editOtrCantProc = findViewById(R.id.ed_ot_pro_ca);

        editCertNm      = findViewById(R.id.ed_cer_pro_nm);
        editCertPrec    = findViewById(R.id.ed_cer_pro_pr);
        editCertCant    = findViewById(R.id.ed_cer_pro_ca);
        editVarProduc   = findViewById(R.id.ed_va_pro);

        btnEncuesta = findViewById(R.id.fab_next_pv_d);

        //Variables para guardar Bd
        /*

      semillaCriolla
      semillaCriollaPrecio
      semillaCriollaCantidad

      semillaCriollaProced
      semillaCriollaProcedPrec
      semillaCriollaProcedCant

      semillaCertProced
      semillaCertProcedNm
      semillaCertProcedPrec
      semillaCertProcedCant
      semillaCertProcedVar

     selecSemPropia

         */

        btnEncuesta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Boolean valorSemilla;
                Boolean veriTipoSemilla;
                veriTipoSemilla = valiTipoSemilla();
                valorSemilla = tipoSemillaRd(v);
                //if(valorSemilla && veriTipoSemilla) {
                if(valorSemilla) {
                    //Snackbar snackbar = Snackbar.make(v,semillaCriolla + "---" + semillaCriollaProced +"---" + semillaCertProced + "Semilla Propia" + selecSemPropia,Snackbar.LENGTH_SHORT);
                    //snackbar.show();
                    VariblesGlobalesHortalizas.TIPSEMPRO = semillaCriolla;
                    VariblesGlobalesHortalizas.PREKGPRO = semillaCriollaPrecio;
                    VariblesGlobalesHortalizas.CANTSEPRO= semillaCriollaCantidad;

                    VariblesGlobalesHortalizas.TIPSEMCROT = semillaCriollaProced;
                    VariblesGlobalesHortalizas.PREKGCROT = semillaCriollaProcedPrec;
                    VariblesGlobalesHortalizas.CANTSECROT = semillaCriollaProcedCant;

                    VariblesGlobalesHortalizas.TIPSEMCER = semillaCertProced;
                    VariblesGlobalesHortalizas.SEMCERNOM = semillaCertProcedNm;
                    VariblesGlobalesHortalizas.PREKGCER = semillaCertProcedPrec;
                    VariblesGlobalesHortalizas.CANTSECER = semillaCertProcedCant;
                    VariblesGlobalesHortalizas.VARSEHOOI = semillaCertProcedVar;

                    VariblesGlobalesHortalizas.SELSEOI = selecSemPropia;

                    startActivity(new Intent(getBaseContext(), HortalizasPvunoD.class));
                }else{
                    Snackbar snackbar = Snackbar.make(v,"Verifique los Campos Incompletos",Snackbar.LENGTH_SHORT);
                    snackbar.show();
                }
            }
        });
    }

    private Boolean valiTipoSemilla() {
        if(selecSemPropia != null){
            return true;
        }
        return false;
    }

    private Boolean tipoSemillaRd(View v) {
        String smCrCnt;
        String smCriProCnt;
        String smCertProCnt;

        if(semillaCriolla != null || semillaCriollaProced != null || semillaCertProced != null) {
            if (semillaCriolla == "Si" && !editPrecSc.getText().toString().isEmpty() && !editCantSc.getText().toString().isEmpty()) {
                semillaCriollaPrecio = editPrecSc.getText().toString();
                smCrCnt = editCantSc.getText().toString();
                semillaCriollaCantidad = smCrCnt;
                return true;
            } else if (semillaCriollaProced == "Si" && !editOtrPreProc.getText().toString().isEmpty() && !editOtrCantProc.getText().toString().isEmpty()) {
                semillaCriollaProcedPrec = editOtrPreProc.getText().toString();
                smCriProCnt = editOtrCantProc.getText().toString();
                semillaCriollaProcedCant = smCriProCnt;

                return true;
            } else if (semillaCertProced == "Si" && !editCertNm.getText().toString().isEmpty() && !editCertPrec.getText().toString().isEmpty() && !editCertCant.getText().toString().isEmpty() && !editVarProduc.getText().toString().isEmpty()) {
                semillaCertProcedNm = editCertNm.getText().toString();
                semillaCertProcedPrec = editCertPrec.getText().toString();
                smCertProCnt = editCertCant.getText().toString();
                semillaCertProcedCant = smCertProCnt;
                semillaCertProcedVar = editVarProduc.getText().toString();
                return true;
            }
            return false;
        }else{
            return false;
        }
    }

    public void tipoSemilla(View view) {
        boolean checkedTipoSemilla = ((RadioButton) view).isChecked();
        switch (view.getId()) {
            case R.id.ck_cr_pro:
                if (checkedTipoSemilla) {
                    semillaCriolla = "Si";
                    editPrecSc.setEnabled(true);
                    editCantSc.setEnabled(true);

                    //-------------------------
                    semillaCriollaProced = "No";
                    editOtrPreProc.setText("");
                    editOtrCantProc.setText("");
                    editOtrPreProc.setEnabled(false);
                    editOtrCantProc.setEnabled(false);

                    //--------------
                    semillaCertProced = "No";
                    editCertNm.setText("");
                    editCertPrec.setText("");
                    editCertCant.setText("");
                    editVarProduc.setText("");
                    editCertNm.setEnabled(false);
                    editCertPrec.setEnabled(false);
                    editCertCant.setEnabled(false);
                    editVarProduc.setEnabled(false);
                }
                break;
            case R.id.ck_ot_pro:
                if (checkedTipoSemilla) {
                    semillaCriollaProced = "Si";
                    editOtrPreProc.setEnabled(true);
                    editOtrCantProc.setEnabled(true);
                    //-------------------
                    semillaCriolla = "No";
                    editPrecSc.setText("");
                    editCantSc.setText("");
                    editPrecSc.setEnabled(false);
                    editCantSc.setEnabled(false);
                    //--------------
                    semillaCertProced = "No";
                    editCertNm.setText("");
                    editCertPrec.setText("");
                    editCertCant.setText("");
                    editVarProduc.setText("");
                    editCertNm.setEnabled(false);
                    editCertPrec.setEnabled(false);
                    editCertCant.setEnabled(false);
                    editVarProduc.setEnabled(false);
                }
                break;
            case R.id.ck_cer_pro:
                if (checkedTipoSemilla) {
                    semillaCertProced = "Si";
                    editCertNm.setEnabled(true);
                    editCertPrec.setEnabled(true);
                    editCertCant.setEnabled(true);
                    editVarProduc.setEnabled(true);
                    //-------------------
                    semillaCriolla = "No";
                    editPrecSc.setText("");
                    editCantSc.setText("");
                    editPrecSc.setEnabled(false);
                    editCantSc.setEnabled(false);
                    //-------------------
                    semillaCriollaProced = "No";
                    editOtrPreProc.setText("");
                    editOtrCantProc.setText("");
                    editOtrPreProc.setEnabled(false);
                    editOtrCantProc.setEnabled(false);

                }
                break;
        }
    }


    public void utilizarSemillaPropia(View view) {
        boolean checkedTipo = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.ck_sm_prop_vi:
                if (checkedTipo) {
                    selecSemPropia = "Vigor";
                }
                break;
            case R.id.ck_sm_prop_asp:
                if (checkedTipo) {
                    selecSemPropia = "Aspecto";
                }
                break;
            case R.id.ck_sm_prop_sn:
                if (checkedTipo) {
                    selecSemPropia = "Sanidad";
                }
                break;
            case R.id.ck_sm_prop_va:
                if (checkedTipo) {
                    selecSemPropia = "Valor económico";
                }
                break;
        }
    }

    @Override
    public void onBackPressed() {

    }

}
