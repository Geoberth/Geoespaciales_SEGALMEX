package com.example.geosegalmex.unidadcaracterizacionhortalizas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.geosegalmex.R;
import com.example.geosegalmex.unidadcaracterizacionhortalizas.variables.VariblesGlobalesHortalizas;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class HortalizasPVuno extends AppCompatActivity {
    ExtendedFloatingActionButton fabNextPv2;
    EditText editotroCh;
    EditText edtotroSh;
    EditText edtCultAsoc;
    EditText edtAsesoTroCult;
    TextView txcaracteTipo;

    String  cultHortalTiene = null; //Variable Tipo Cultivo Hortalizas tiene
    String  cultHortalTieneOtro = null; //Variable Otro Tipo Cultivo Hortalizas tiene
    String  pDscHort = null; //¿Por qué decidió sembrar esa hortaliza?
    String  pDscHortOtro = null; //¿Por qué Otro decidió sembrar esa hortaliza?
    int otrCult = 0; //Edit text otro cultivo
    int otrDscsHort = 0; //Otro desicion sembrar cultivo hortalizas

    String  asociCultSiNo = null;//¿Está asociado con otro cultivo?
    String  asociCultSiEspc = null;//¿Está asociado con otro cultivo?

    String  asesoCultSiNo = null;//¿Asesoria?
    String  asesoCultSiEspc = null;//¿Asesoria?
    int asociCultVal = 0;//¿Está asociado con otro cultivo?

    //Variables Globales
    int     idHortal; //incremnt
    public String folio = null;
    public static String cicPro = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hortalizas_pvuno);

        fabNextPv2 = findViewById(R.id.fab_next_pv2);
        editotroCh = findViewById(R.id.ed_ch_otr);
        edtotroSh = findViewById(R.id.ed_smb_hor_otr);
        edtCultAsoc = findViewById(R.id.ed_aso_cul_si);
        edtAsesoTroCult = findViewById(R.id.ed_ase_cult_si);

        txcaracteTipo = findViewById(R.id.tx_tit_hvu);

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

        if(hortalizas.valorTempCosPv == 1){
            cicPro = "P-V";
            txcaracteTipo.setText(getString(R.string.name_mod_cinco_pv));
        }else if(hortalizas.valorTempCosOi == 1){
            cicPro = "O-I";
            txcaracteTipo.setText(getString(R.string.name_mod_cinco_oi));
        }

        //Variable ciclo de cultivo
        //cicPro = txcaracteTipo.getText().toString();

        fabNextPv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Boolean vretRd = true;
                Boolean vretRdAse = true;

                //RadioButton
                if(otrCult == 1 && !editotroCh.getText().toString().isEmpty()){
                    cultHortalTieneOtro = editotroCh.getText().toString();
                }
                if(otrDscsHort == 1 && !edtotroSh.getText().toString().isEmpty()){
                    pDscHortOtro = edtotroSh.getText().toString();
                }


                vretRd = validarRetrRd();
                vretRdAse = valRetRdAseso();

                if(pDscHort != null && cultHortalTiene != null && vretRd == false && vretRdAse == false){


                    // Variables que se almacenaran en la base de datos
                    //folio, cicPro, cultHortalTiene, cultHortalTieneOtro, pDscHort, pDscHortOtro, asociCultSiNo, asociCultSiEspc, asesoCultSiNo, asesoCultSiEspc
                    VariblesGlobalesHortalizas.FOLIO = "folioPrueba";
                    VariblesGlobalesHortalizas.CICPRO = cicPro;
                    VariblesGlobalesHortalizas.CUCHORT = cultHortalTiene;
                    VariblesGlobalesHortalizas.CUCHORTO = cultHortalTieneOtro;
                    VariblesGlobalesHortalizas.MOTSEMH = pDscHort;
                    VariblesGlobalesHortalizas.MOTSEMHO = pDscHortOtro;
                    VariblesGlobalesHortalizas.ASOCULT = asociCultSiNo;
                    VariblesGlobalesHortalizas.OTRCULT = asociCultSiEspc;
                    VariblesGlobalesHortalizas.ASECULT = asesoCultSiNo;
                    VariblesGlobalesHortalizas.CUCULT = asesoCultSiEspc;

                    startActivity(new Intent(getBaseContext(), HortalizasPvunob.class));
                }else{
                    Snackbar snackbar = Snackbar.make(v,"Ingrese los datos...",Snackbar.LENGTH_SHORT);
                    snackbar.show();
                }

            }
        });
    }

    private Boolean valRetRdAseso() {
        if(asesoCultSiNo != null){
            if(asesoCultSiNo == "Si" && edtAsesoTroCult.getText().toString().isEmpty()){
                return true;
            } else if(asesoCultSiNo == "Si" && !edtAsesoTroCult.getText().toString().isEmpty()){
                asesoCultSiEspc = edtAsesoTroCult.getText().toString();
                return false;
            }else{
                return false;
            }
        }
        return true;
    }

    private Boolean validarRetrRd() {
        if(asociCultSiNo != null){
            if(asociCultSiNo == "Si" && edtCultAsoc.getText().toString().isEmpty()){
                return true;
            } else if(asociCultSiNo == "Si" && !edtCultAsoc.getText().toString().isEmpty()){
                asociCultSiEspc = edtCultAsoc.getText().toString();
                return false;
            }else{
                return false;
            }
        }
        return true;
    }

    @Override
    public void onBackPressed() {

    }

    public void cultivoHortaliza(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()){
            case R.id.ck_ch_ji:
                if(checked){
                    otrCult = 0;
                    editotroCh.setText("");
                    cultHortalTiene = "jitomate";
                    editotroCh.setEnabled(false);
                }else{
                    cultHortalTiene = null;
                }
                break;
            case R.id.ck_ch_chi:
                if(checked){
                    otrCult = 0;
                    editotroCh.setText("");
                    cultHortalTiene = "chile";
                    editotroCh.setEnabled(false);
                }else{
                    cultHortalTiene = null;
                }
                break;
            case R.id.ck_ch_crc:
                if(checked){
                    otrCult = 0;
                    editotroCh.setText("");
                    cultHortalTiene = "coles";
                    editotroCh.setEnabled(false);
                }else{
                    cultHortalTiene = null;
                }
                break;
            case R.id.ck_ch_otr:
                if(checked){
                    cultHortalTiene = "Otro";
                    otrCult = 1;
                    editotroCh.setEnabled(true);

                }
                break;
        }
    }

    public void sembreHortalizas(View view) {
        boolean checkedSeH = ((RadioButton) view).isChecked();
        switch (view.getId()){
            case R.id.ck_smb_hor_ren:
                if(checkedSeH){
                    otrDscsHort = 0;
                    pDscHort = "Rentabilidad";
                    edtotroSh.setText("");
                    edtotroSh.setEnabled(false);
                }
                else {
                    pDscHort = null;
                }
                break;
            case R.id.ck_smb_hor_man:
                if(checkedSeH){
                    otrDscsHort = 0;
                    pDscHort = "Conoce el manejo";
                    edtotroSh.setText("");
                    edtotroSh.setEnabled(false);
                }
                else {
                    pDscHort = null;
                }
                break;
            case R.id.ck_smb_hor_dp:
                if(checkedSeH){
                    otrDscsHort = 0;
                    edtotroSh.setText("");
                    pDscHort = "Demanda del producto";
                    edtotroSh.setEnabled(false);
                }
                else {
                    pDscHort = null;
                }
                break;
            case R.id.ck_smb_hor_adp_cul:
                if(checkedSeH){
                    otrDscsHort = 0;
                    edtotroSh.setText("");
                    pDscHort = "Adaptabilidad del cultivo";
                    edtotroSh.setEnabled(false);
                }
                else {
                    pDscHort = null;
                }
                break;
            case R.id.ck_smb_hor_cp_cs:
                if(checkedSeH){
                    otrDscsHort = 0;
                    edtotroSh.setText("");
                    pDscHort = "Contrato de compra de la cosecha";
                    edtotroSh.setEnabled(false);
                }
                else {
                    pDscHort = null;
                }
                break;
            case R.id.ck_smb_hor_otr:
                if(checkedSeH){

                    pDscHort = "Otro";
                    otrDscsHort = 1;
                    edtotroSh.setEnabled(true);
                }
                else {
                    otrDscsHort = 0;
                    pDscHort = null;
                    edtotroSh.setText("");
                    edtotroSh.setEnabled(false);

                }
                break;
        }
    }

    public void asociadoCultivo(View view) {
        boolean radioAsocCult = ((RadioButton) view).isChecked();
        switch (view.getId()) {
            case R.id.rd_aso_cul_si:
                if (radioAsocCult) {
                    asociCultVal = 1;
                    asociCultSiNo = "Si";
                    edtCultAsoc.setEnabled(true);
                }
                break;
            case R.id.rd_aso_cul_no:
                if (radioAsocCult) {
                    asociCultSiNo = "No";
                    edtCultAsoc.setText("");
                    asociCultSiEspc = null;
                    asociCultVal = 0;
                    edtCultAsoc.setEnabled(false);
                }
                break;

        }
    }

    public void asesoriaOtroCultivo(View view) {
        boolean radioAsocCult = ((RadioButton) view).isChecked();
        switch (view.getId()) {
            case R.id.rd_ase_cult_si:
                if (radioAsocCult) {
                    asesoCultSiNo = "Si";
                    edtAsesoTroCult.setEnabled(true);
                }
                break;
            case R.id.rd_ase_cult_no:
                if (radioAsocCult) {
                    asesoCultSiNo = "No";
                    asesoCultSiEspc = null;
                    edtAsesoTroCult.setText("");
                    edtAsesoTroCult.setEnabled(false);
                }
                break;

        }
    }
}
