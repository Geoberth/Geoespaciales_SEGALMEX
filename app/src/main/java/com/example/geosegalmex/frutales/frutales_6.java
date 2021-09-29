package com.example.geosegalmex.frutales;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.geosegalmex.R;
import com.example.geosegalmex.frutales.dbfrutales.VariablesFrutales;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

public class frutales_6 extends AppCompatActivity {
    ExtendedFloatingActionButton f6;

    EditText edtFoliarApliOtro;




    EditText edtCstRig;
    EditText edtCstJrn;

    RadioButton rddHora;
    RadioButton rdOtro;
    RadioGroup rgTmpOcpRig;
    RadioGroup rgCdRig;


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
    RadioButton rdTiempoOtro;


    EditText edt1;
    EditText edt2;
    EditText edt3;


    //Variables
    String txtApFoliarAplica = null;
    String txtApFoliarAplicaOtr = null;

    String txtRiegaSiNo = null;
    String txtTipoRiega = null;
    String txtedtTipoRiegoOtr = null;

    //Variables Cada cuando Riega
    String txtCuandoRiega = null;


    private String OTRFRERIE = null;
    private String COSTORF = null;
    private String JORNALESF = null;
    private String TIERIE = null;
    private String TIERIEO = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frutales_6);

        f6 = findViewById(R.id.fab_next_fol_rie_fe_frt);

        edtCstRig = findViewById(R.id.edt_cst_rig_frt);
        edtCstJrn = findViewById(R.id.edt_cst_jrn_frt);


        rddHora = findViewById(R.id.rd_tmp_rig_hrt_frt);
        rdOtro = findViewById(R.id.rd_tmp_rig_otr_frt);

        rdTiempoOtro = findViewById(R.id.ck_me_ri_fe_otr_frt);

        rgTmpOcpRig = findViewById(R.id.rd_tmp_ocp_rig_frt);
        rgCdRig = findViewById(R.id.rg_cnd_rig_frt);
        /*
        edtCstRig.setEnabled(true);
        edtCstJrn.setEnabled(true);
        edtOtroRig.setEnabled(true);
        rddHora.setEnabled(true);
        rdOtro.setEnabled(true);


         */
        edtFoliarApliOtro= findViewById(R.id.edt_otr_fr_fe_frt);


        rdRealRiegoSi = findViewById(R.id.rd_fr_fe_frt_1);
        rdRealRiegoNo = findViewById(R.id.rd_fr_fe_frt_2);

        rgTipoRiego = findViewById(R.id.rg_tip_rie_frt);
        rdTRGravedad = findViewById(R.id.ck_gv_r_fe_frt);
        rdTRGote = findViewById(R.id.ck_gt_r_fe_frt);
        rdTRAspercion = findViewById(R.id.ck_as_r_fe_frt);

        rdTRotro = findViewById(R.id.ck_ot_es_r_fe_frt);


        rdDiario = findViewById(R.id.ck_di_ri_fe_frt);
        rdDosTreSem = findViewById(R.id.ck_dt_ri_fe_frt);
        rdSemanal = findViewById(R.id.ck_se_ri_fe_frt);
        rdQuince = findViewById(R.id.ck_qi_ri_fe_frt);
        rdMensual = findViewById(R.id.ck_me_ri_fe_frt);


        edt1 = findViewById(R.id.edt_otr_1);
        edt2 = findViewById(R.id.edt_otr_2);
        edt3 = findViewById(R.id.edt_otr_3);

        f6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                asignacionValores();
                impresion();
                //startActivity(new Intent(getApplicationContext(), frutales_7.class));
                startActivity(new Intent(getApplicationContext(), frutales_8.class));
            }
        });
    }

    private void impresion() {
        System.out.println(VariablesFrutales.APFOLIAR);	//	¿Qué tipo de aplicación foliar aplica?	7
        System.out.println(VariablesFrutales.OTROTFOL);	//	Otro	7

        System.out.println(VariablesFrutales.RIEFRUT);	//	¿Realiza algún riego?	7

        System.out.println(VariablesFrutales.TIPSISFR);	//	¿Qué tipo de riego?	7
        System.out.println(VariablesFrutales.TIPSISFRO);	//	Otro	7

        System.out.println(VariablesFrutales.FRECRFR);	//	¿Cada cuando riega?	7
        System.out.println(OTRFRERIE);	//	Otra frecuencia de riego	7

        System.out.println(COSTORF);	//	¿Cuál es el costo de riego? ($/riego)	7	SERA TABLA UNICA
        System.out.println(JORNALESF); 	//	¿Cuántos jornales utiliza por riego?	7	RIEGO

        System.out.println(TIERIE);	//	¿Cuál es el tiempo que ocupa el riego?	7	RIEGO
        System.out.println(TIERIEO);	//	Otro	7
    }

    private void asignacionValores() {

        if(!edtFoliarApliOtro.getText().toString().isEmpty()){
            txtApFoliarAplicaOtr = edtFoliarApliOtro.getText().toString();
        }else{
            txtApFoliarAplicaOtr = null;
        }

        if(!edt1.getText().toString().isEmpty()){
            txtedtTipoRiegoOtr = edt1.getText().toString();
        }else {
            txtedtTipoRiegoOtr = null;
        }

        if(! edt2.getText().toString().isEmpty()){
            OTRFRERIE = edt2.getText().toString();
        } else{
            OTRFRERIE = null;
        }

        if(!edtCstRig.getText().toString().isEmpty()){
            COSTORF  = edtCstRig.getText().toString();
        }else{
            COSTORF  = null;
        }

        if(!edtCstJrn.getText().toString().isEmpty()){
            JORNALESF = edtCstJrn.getText().toString();
        }else{
            JORNALESF = null;
        }


        if(!edt3.getText().toString().isEmpty()){
            TIERIEO = edt3.getText().toString();
        }else {
            TIERIEO = null;
        }


        VariablesFrutales.APFOLIAR = txtApFoliarAplica;	//	¿Qué tipo de aplicación foliar aplica?	7
        VariablesFrutales.OTROTFOL = txtApFoliarAplicaOtr;	//	Otro	7

        VariablesFrutales.RIEFRUT = txtRiegaSiNo;	//	¿Realiza algún riego?	7

        VariablesFrutales.TIPSISFR = txtTipoRiega;	//	¿Qué tipo de riego?	7
        VariablesFrutales.TIPSISFRO = txtedtTipoRiegoOtr;	//	Otro	7

        VariablesFrutales.FRECRFR = txtCuandoRiega;	//	¿Cada cuando riega?	7
        VariablesFrutales.OTRFRERIE = OTRFRERIE;	//	Otra frecuencia de riego	7

        VariablesFrutales.COSTORF = COSTORF;	//	¿Cuál es el costo de riego? ($/riego)	7	SERA TABLA UNICA
        VariablesFrutales.JORNALESF = JORNALESF;	//	¿Cuántos jornales utiliza por riego?	7	RIEGO

        VariablesFrutales.TIERIE = TIERIE;	//	¿Cuál es el tiempo que ocupa el riego?	7	RIEGO
        VariablesFrutales.TIERIEO = TIERIEO;	//	Otro	7
    }




    public void tipoFoliarAplicafrt(View view) {
        boolean checkedTipo = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.ck_nut_fr_fe_frt:
                if (checkedTipo) {
                    txtApFoliarAplica = "Nutrición";
                    edtFoliarApliOtro.setText("");
                    edtFoliarApliOtro.setEnabled(false);
                }
                break;
            case R.id.ck_hor_fr_fe_frt:
                if (checkedTipo) {
                    txtApFoliarAplica = "Hormonal (manejo fisiológico)";
                    edtFoliarApliOtro.setText("");
                    edtFoliarApliOtro.setEnabled(false);
                }
                break;
            case R.id.ck_pro_fr_fe_frt:
                if (checkedTipo) {
                    txtApFoliarAplica = "Protección (radiación solar)";
                    edtFoliarApliOtro.setText("");
                    edtFoliarApliOtro.setEnabled(false);
                }
                break;
            case R.id.ck_otr_fr_fe_frt:
                if (checkedTipo) {
                    txtApFoliarAplica = "Otro";
                    edtFoliarApliOtro.setEnabled(true);
                }
                break;

        }
    }


    public void realizaRiegoSiNofrt(View view) {
        boolean checkedTipo = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.rd_fr_fe_frt_1:
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

                    edtCstRig.setEnabled(true);
                    edtCstJrn.setEnabled(true);

                    rddHora.setEnabled(true);
                    rdOtro.setEnabled(true);

                    rdTiempoOtro.setEnabled(true);



                }
                break;
            case R.id.rd_fr_fe_frt_2:
                if (checkedTipo) {
                    txtRiegaSiNo = "No";
                    rgTipoRiego.clearCheck();
                    rgTmpOcpRig.clearCheck();
                    rgCdRig.clearCheck();

                    rdTRGravedad.setEnabled(false);
                    rdTRGote.setEnabled(false);
                    rdTRAspercion.setEnabled(false);
                    rdTRotro.setEnabled(false);


                    rdDiario.setEnabled(false);
                    rdDosTreSem.setEnabled(false);
                    rdSemanal.setEnabled(false);
                    rdQuince.setEnabled(false);
                    rdMensual.setEnabled(false);


                    edtCstRig.setEnabled(false);
                    edtCstRig.setText("");
                    edtCstJrn.setEnabled(false);
                    edtCstJrn.setText("");
                    rddHora.setEnabled(false);
                    rdOtro.setEnabled(false);
                    rdTiempoOtro.setEnabled(false);


                    edt1.setEnabled(false);
                    edt1.setText("");
                    edt2.setEnabled(false);
                    edt2.setText("");
                    edt3.setEnabled(false);
                    edt3.setText("");

                }
                break;
        }
    }


    public void tipoRiegofrt(View view) {
        boolean checkedTipo = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.ck_gv_r_fe_frt:
                if (checkedTipo) {
                    txtTipoRiega = "Gravedad o rodado";
                    edt1.setText("");
                    edt1.setEnabled(false);
                }
                break;
            case R.id.ck_gt_r_fe_frt:
                if (checkedTipo) {
                    txtTipoRiega = "Goteo";
                    edt1.setText("");
                    edt1.setEnabled(false);
                }
                break;
            case R.id.ck_as_r_fe_frt:
                if (checkedTipo) {
                    txtTipoRiega = "Aspersión";
                    edt1.setText("");
                    edt1.setEnabled(false);
                }
                break;
            case R.id.ck_ot_es_r_fe_frt:
                if (checkedTipo) {
                    txtTipoRiega = "Otro";
                    edt1.setEnabled(true);
                }
                break;
        }

    }

    public void cuandoRiegafrt(View view) {
        boolean checkedTipo = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.ck_di_ri_fe_frt:
                if (checkedTipo) {
                    txtCuandoRiega = "Diario";
                    edt2.setText("");
                    edt2.setEnabled(false);
                }
                break;
            case R.id.ck_dt_ri_fe_frt:
                if (checkedTipo) {
                    txtCuandoRiega = "Dos o tres veces a la semana";
                    edt2.setText("");
                    edt2.setEnabled(false);
                }
                break;
            case R.id.ck_se_ri_fe_frt:
                if (checkedTipo) {
                    txtCuandoRiega = "Semanal";
                    edt2.setText("");
                    edt2.setEnabled(false);
                }
                break;
            case R.id.ck_qi_ri_fe_frt:
                if (checkedTipo) {
                    txtCuandoRiega = "Quincenal";
                    edt2.setText("");
                    edt2.setEnabled(false);
                }
                break;
            case R.id.ck_me_ri_fe_frt:
                if (checkedTipo) {
                    txtCuandoRiega = "Mensual";
                    edt2.setText("");
                    edt2.setEnabled(false);
                }
                break;
            case R.id.ck_me_ri_fe_otr_frt:
                if (checkedTipo) {
                    txtCuandoRiega = "Otro";
                    edt2.setEnabled(true);
                    //edtRiegoTmpOtro.setEnabled(true);
                }
                break;
        }

    }

    public void tiempoOcupaRiego(View view) {
        boolean checkedTipo = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.rd_tmp_rig_hrt_frt:
                if (checkedTipo) {
                    TIERIE = "Hora" ;
                    edt3.setEnabled(false);
                    edt3.setText("");
                }
                break;
            case R.id.rd_tmp_rig_otr_frt:
                if (checkedTipo) {
                    TIERIE = "Otro";
                    edt3.setEnabled(true);
                }
                break;
        }
    }

    @Override
    public void onBackPressed() {

    }
}
