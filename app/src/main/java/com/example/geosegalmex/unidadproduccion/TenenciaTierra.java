package com.example.geosegalmex.unidadproduccion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

import com.example.geosegalmex.R;
import com.example.geosegalmex.unidadproduccion.variables.VariablesGlobalesUpf;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class TenenciaTierra extends AppCompatActivity {
    EditText editTextOtro;
    EditText editTextOtroParcela;
    EditText edtTimAsiste;
    EditText    editTextOtroAsistencia;
    RadioButton rbEdjidal;
    ExtendedFloatingActionButton fabTenencia;

    private String	TENTIE	= null;	//	Text
    private String	TENTIEOT	= null;	//	Text
    private String	TIPPROP	= null;	//	Text
    private String	PENDPAR	= null;	//	Text
    private String	ASESORIA	= null;	//	Text
    private String	ASESORIAO	= null;	//	Text
    private String	DINACTPRO	= null;	//	Text
    private int	ASISTEC	= 0;	//	Integer
    private String	ASISTECDO	= null;	//	Text
    private String	ASISTECDOtro	= null;	//	Text
    private String	DIFMAQ	= null;	//	Text

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tenencia_tierra);
        editTextOtro = findViewById(R.id.otro_edit_propiedad);
        editTextOtroParcela = findViewById(R.id.otra_parcela_rancho_asesoria);
        editTextOtroAsistencia = findViewById(R.id.otro_edit_tiempo);
        edtTimAsiste = findViewById(R.id.asistencia_tiempo);
        // estadoEjidal = rbEdjidal.isChecked();

        fabTenencia = findViewById(R.id.fab_next_pro_tierra);

        fabTenencia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Boolean valTenencia = validTenencia();
                Boolean valAsesoria = validAsesoria();
                Boolean valAsisTecn = validAsisTecni();

                if(!edtTimAsiste.getText().toString().isEmpty()){
                    ASISTEC = Integer.parseInt(edtTimAsiste.getText().toString());
                }else {
                    ASISTEC = 0;
                }

               // if(valTenencia || valAsesoria || valAsisTecn || TIPPROP == null || PENDPAR == null || DINACTPRO == null || ASISTEC ==0 || DIFMAQ == null){
                if(valTenencia || valAsesoria || valAsisTecn || TIPPROP == null || PENDPAR == null || DINACTPRO == null || DIFMAQ == null){
                    Snackbar snackbar = Snackbar.make(v, "Verique los campos incompletos", Snackbar.LENGTH_SHORT);
                    snackbar.show();
                //}else if(valTenencia == false && valAsesoria == false && valAsisTecn == false && TIPPROP != null && PENDPAR != null && DINACTPRO != null && ASISTEC !=0 && DIFMAQ != null){
                }else if(valTenencia == false && valAsesoria == false && valAsisTecn == false && TIPPROP != null && PENDPAR != null && DINACTPRO != null && DIFMAQ != null){
                    VariablesGlobalesUpf.TENTIE = TENTIE;    //	Text
                    VariablesGlobalesUpf.TENTIEOT = TENTIEOT;    //	Text

                    VariablesGlobalesUpf.TIPPROP = TIPPROP;    //	Text

                    VariablesGlobalesUpf.PENDPAR = PENDPAR;    //	Text

                    VariablesGlobalesUpf.ASESORIA = ASESORIA;    //	Text
                    VariablesGlobalesUpf.ASESORIAO = ASESORIAO;    //	Text

                    VariablesGlobalesUpf.DINACTPRO = DINACTPRO;    //	Text

                    VariablesGlobalesUpf.ASISTEC = String.valueOf(ASISTEC);    //	Integer

                    VariablesGlobalesUpf.ASISTECDO = ASISTECDO;    //	Text
                    VariablesGlobalesUpf.ASISTECDOtro = ASISTECDOtro;    //	Text

                    VariablesGlobalesUpf.DIFMAQ = DIFMAQ;    //	Text
                    startActivity(new Intent(getApplication(), ModalidadHidrica.class));
                }
                //
            }
        });
    }

    private Boolean validAsisTecni() {
        Boolean errorCheck = false;

        if(ASISTECDO == "Otro" && editTextOtroAsistencia.getText().toString().isEmpty()){
            errorCheck = true;
        }else if(ASISTECDO == "Otro" && !editTextOtroAsistencia.getText().toString().isEmpty()){
            ASISTECDOtro = editTextOtroAsistencia.getText().toString();
            errorCheck = false;
        }

        if(ASISTECDO != null && errorCheck == false){
            return false;
        }else {
            return true;
        }
    }

    private Boolean validAsesoria() {
        Boolean errorCheck = false;

        if(ASESORIA == "Otro" && editTextOtroParcela.getText().toString().isEmpty()){
            errorCheck = true;
        }else if(ASESORIA == "Otro" && !editTextOtroParcela.getText().toString().isEmpty()){
            ASESORIAO = editTextOtroParcela.getText().toString();
            errorCheck = false;
        }

        if(ASESORIA != null && errorCheck == false){
            return false;
        }else {
            return true;
        }
    }

    private Boolean validTenencia() {
        Boolean errorCheck = false;

        if(TENTIE == "Otro" && editTextOtro.getText().toString().isEmpty()){
            errorCheck = true;
        }else if(TENTIE == "Otro" && !editTextOtro.getText().toString().isEmpty()){
            TENTIEOT = editTextOtro.getText().toString();
            errorCheck = false;
        }

        if(TENTIE != null && errorCheck == false){
            return false;
        }else {
            return true;
        }

    }


    public void clickTierra(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        // Check which checkbox was clicked
        switch(view.getId()) {
            case R.id.ejidal:
                if (checked){
                    editTextOtro.setText("");
                    TENTIE = "Ejidal";
                    editTextOtro.setEnabled(false);
                }
                break;
            case R.id.comunal:
                if (checked){
                    editTextOtro.setText("");
                    TENTIE = "Comunal";
                    editTextOtro.setEnabled(false);
                }

                break;

            case R.id.peque_propiedad:
                if (checked){
                    editTextOtro.setText("");
                    editTextOtro.setEnabled(false);
                    TENTIE = "Pequeña Propiedad";
                }

                break;
            case R.id.otro_propiedad:
                if (checked){
                    TENTIE = "Otro";
                    editTextOtro.setEnabled(true);
                }

                break;
            // TODO: Veggie sandwich
        }
    }

    public void aseroriaParcelaRancho(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        // Check which checkbox was clicked
        switch(view.getId()) {
            case R.id.de_otro_productor:
                if (checked){
                    ASESORIA = "De otro productor";
                    editTextOtroParcela.setEnabled(false);
                }
                break;
            case R.id.tienda_insumos:
                if (checked){
                    ASESORIA = "Tienda de insumos";
                    editTextOtroParcela.setEnabled(false);

                }
                break;
            case R.id.tecnico_investigador:
                if (checked){
                    ASESORIA = "Técnico o investigador";
                    editTextOtroParcela.setEnabled(false);
                }
                break;
            case R.id.otro_parcela_rancho:
                if (checked){
                    ASESORIA = "Otro";
                    editTextOtroParcela.setEnabled(true);
                }
                break;
            // TODO: Veggie sandwich
        }
    }

    public void asistenciaTiempo(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch(view.getId()) {
            case R.id.gobierno_tiempo:
                if (checked){
                    ASISTECDO = "Gobierno";
                    editTextOtroAsistencia.setText("");
                    editTextOtroAsistencia.setEnabled(false);
                }
                break;
            case R.id.privado_tiempo:
                if (checked){
                    ASISTECDO = "Privado";
                    editTextOtroAsistencia.setText("");
                    editTextOtroAsistencia.setEnabled(false);
                }
                break;
            case R.id.proveedor_tiempo:
                if (checked){
                    ASISTECDO = "Proveedor de insumos";
                    editTextOtroAsistencia.setText("");
                    editTextOtroAsistencia.setEnabled(false);
                }
                break;
            case R.id.otro_tiempo:
                if (checked){
                    ASISTECDO = "Otro";
                    editTextOtroAsistencia.setEnabled(true);
                }
                break;
            // TODO: Veggie sandwich
        }
    }

    public void tipoPropiedad(View view) {
        boolean checkedTipo = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.propia:
                if (checkedTipo) {
                    TIPPROP = "Propia";
                }
                break;
            case R.id.rentada:
                if (checkedTipo) {
                    TIPPROP = "Rentada";
                }
                break;
            case R.id.prestada:
                if (checkedTipo) {
                    TIPPROP = "Prestada";
                }
                break;
        }
    }

    public void pendienteParcela(View view) {
        boolean checkedTipo = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.plano_parcela:
                if (checkedTipo) {
                    PENDPAR = "Plano";
                }
                break;
            case R.id.ondulado_parcela:
                if (checkedTipo) {
                    PENDPAR = "Ondulado";
                }
                break;
            case R.id.ladera_parcela:
                if (checkedTipo) {
                    PENDPAR = "Ladera Suave";
                }
                break;
            case R.id.pendiente_parcela:
                if (checkedTipo) {
                    PENDPAR = "Pendiente Fuerte";
                }
                break;
        }
    }

    public void obtienDinero(View view) {
        boolean checkedTipo = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.din_prop:
                if (checkedTipo) {
                    DINACTPRO = "Dinero propio";
                }
                break;
            case R.id.din_pres:
                if (checkedTipo) {
                    DINACTPRO = "Prestamos";
                }
                break;
            case R.id.din_alg_org:
                if (checkedTipo) {
                    DINACTPRO = "Alguna organización";
                }
                break;
            case R.id.din_fam:
                if (checkedTipo) {
                    DINACTPRO = "Familiares";
                }
                break;
            case R.id.din_prg_gob:
                if (checkedTipo) {
                    DINACTPRO = "Programa de gobierno";
                }
                break;
            case R.id.din_rms:
                if (checkedTipo) {
                    DINACTPRO = "Remesas";
                }
                break;
        }

    }

    @Override
    public void onBackPressed() {

    }

    public void terrenoMecanizable(View view) {
        boolean checkedTipo = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.ter_mec_in_op:
                if (checkedTipo) {
                    DIFMAQ = "Informalidad de los operadores";
                }
                break;
            case R.id.ter_mec_cs_sr:
                if (checkedTipo) {
                    DIFMAQ = "Costo del servicio";
                }
                break;
            case R.id.ter_mec_obr_ml:
                if (checkedTipo) {
                    DIFMAQ = "Mano de obra mal calificada";
                }
                break;
            case R.id.ter_mec_cnd_maq:
                if (checkedTipo) {
                    DIFMAQ = "Condición de la maquinaria";
                }
                break;
            case R.id.ter_mec_esc_trac:
                if (checkedTipo) {
                    DIFMAQ = "Escases de tractores e implementos";
                }
                break;
            case R.id.ter_mec_no_dif:
                if (checkedTipo) {
                    DIFMAQ = "No tuve dificultad";
                }
                break;
            case R.id.ter_mec_no_maqi:
                if (checkedTipo) {
                    DIFMAQ = "No utilizo maquinaria";
                }
                break;
        }
    }
}
