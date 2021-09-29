package com.example.geosegalmex.unidadcomercializacion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;

import com.example.geosegalmex.R;
import com.example.geosegalmex.unidadcomercializacion.bdcomercializacion.VariablesGlobalesCmrz;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

public class comercializacion_2 extends AppCompatActivity {
    ExtendedFloatingActionButton co2;

    private String VENPROAGR = null;    //	¿Dónde realiza la venta de su producto?
    private String COSTFLETE = null;    //	¿Cuál es el costo del flete?
    private String PRPRAGRAL = null;    //	Almacenamiento Costo ($/kg)
    private String PRPRAGRLI = null;    //	Limpieza Costo ($/kg)
    private String PRPRAGRRE = null;    //	Refrigeración Costo ($/kg)
    private String PRPRAGRCON = null;    //	Congelación Costo ($/kg)
    private String PRPRAGRLCO = null;    //	Cocción Costo ($/kg)
    private String PRPRAGRLEM = null;    //	Empaquetado Costo ($/kg)
    private String PRPRAGRLEN = null;    //	Ensilado Costo ($/kg)
    private String PRPRAGRLSE = null;    //	Secado Costo ($/kg)

    //   private String PROVAAGAG = null;    //	¿Cuáles son los principales productos con valor agregado que cree que le incrementarían sus ingresos?
    private String PROVAAGAGAts = null;    //	Ates
    private String PROVAAGAGMerm = null;    //	Mermeladas
    private String PROVAAGAGSalv = null;    //	Salvado
    private String PROVAAGAGAAfr = null;    //	Afrecho
    private String PROVAAGAGHar = null;    //	Harina
    private String PROVAAGAGCpr = null;    //	Copra
    private String PROVAAGAGPilon = null;    //	Piloncillo
    private String PROVAAGAGMezc = null;    //	Mezcal
    private String PROVAAGAGOtr = null;    //	Otro
    private String PROVAAGAGOtrEdt = null; //OtroEdittext

    //  private String PROVAAGAGO = null;    //	¿Cuáles son los principales productos con valor agregado que cree que le incrementarían sus ingresos?

    //  private String PROCOMPRAG = null;    //	pregunta Señale los principales problemas que le aquejan en el área de comercialización:
    private String PROCOMPRAGPB = null;    //	Precio bajo de venta
    private String PROCOMPRAGINT = null;    //	Intermediarios
    private String PROCOMPRAGSCB = null;    //	Se castigan precios por baja calidad
    private String PROCOMPRAGBP = null;    //	Baja producción
    private String PROCOMPRAGOA = null;    //	Oferta alta
    private String PROCOMPRAGDFC = null;    //	Distancia de las fuentes de comercialización
    private String PROCOMPRAGPIC = null;    //	Pago impuntual de los compradores

    private String CACOMPRAG = null;    //	¿Cómo le gustaría que fueran los canales de comercialización de sus productos?

    //private String POCOMPRAG = null;    //	¿Qué le hace falta a su producto para poderlo comercializar?
    private String POCOMPRAGCL = null;    //	Calidad
    private String POCOMPRAGPRS = null;    //	Presentación
    private String POCOMPRAGDF = null;    //	Difusión
    private String POCOMPRAGVA = null;    //	Valor agregado
    private String POCOMPRAGCNV = null;    //	Procesos de conversacion


    //EditText
    EditText edtCosFlete;
    EditText edtAlmace;
    EditText edtLimpieza;
    EditText edtRefrigeracion;
    EditText edtCongelacion;
    EditText edtCoccion;
    EditText edtEmpaque;
    EditText edtEnsilado;
    EditText edtSecado;

    EditText edtOtroProducto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comercializacion_2);
        co2 = findViewById(R.id.cr2);

        edtCosFlete = findViewById(R.id.edt_cst_fle);
        edtAlmace = findViewById(R.id.edt_con_alm);
        edtLimpieza = findViewById(R.id.edt_lim_d);
        edtRefrigeracion = findViewById(R.id.edt_rfi_d);
        edtCongelacion = findViewById(R.id.edt_cng_d);
        edtCoccion = findViewById(R.id.edt_cnc_d);
        edtEmpaque = findViewById(R.id.edt_emp_d);
        edtEnsilado = findViewById(R.id.edt_ens_d);
        edtSecado = findViewById(R.id.edt_scd_d);

        edtOtroProducto = findViewById(R.id.edt_otr_10_2);
        //++++++++++++

        co2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //  obtValEditext();

                asignacionValores();

                startActivity(new Intent(getApplicationContext(), comercializacion_3.class));
            }
        });
    }

    private void asignacionValores() {

        //++++++++EditText+++++++++++++++
        if(!edtCosFlete.getText().toString().isEmpty()) {
            COSTFLETE = edtCosFlete.getText().toString();
        }

        if(!edtAlmace.getText().toString().isEmpty()) {
            PRPRAGRAL = edtAlmace.getText().toString();
        }

        if(!edtLimpieza.getText().toString().isEmpty()) {
            PRPRAGRLI = edtLimpieza.getText().toString();
        }

        if(!edtRefrigeracion.getText().toString().isEmpty()) {
            PRPRAGRRE = edtRefrigeracion.getText().toString();
        }

        if(!edtCongelacion.getText().toString().isEmpty()) {
            PRPRAGRCON = edtCongelacion.getText().toString();
        }

        if(!edtCoccion.getText().toString().isEmpty()) {
            PRPRAGRLCO = edtCoccion.getText().toString();
        }

        if(!edtEmpaque.getText().toString().isEmpty()) {
            PRPRAGRLEM = edtEmpaque.getText().toString();
        }

        if(!edtEnsilado.getText().toString().isEmpty()) {
            PRPRAGRLEN = edtEnsilado.getText().toString();
        }

        if(!edtSecado.getText().toString().isEmpty()) {
            PRPRAGRLSE = edtSecado.getText().toString();
        }
        //+++++++++++++++++++

        if (!edtOtroProducto.getText().toString().isEmpty()){
            PROVAAGAGOtrEdt = edtOtroProducto.getText().toString();
        }



        VariablesGlobalesCmrz.VENPROAGR = VENPROAGR;    //	int
        VariablesGlobalesCmrz.COSTFLETE = COSTFLETE;    //	String
        VariablesGlobalesCmrz.PRPRAGRAL = PRPRAGRAL;    //	String
        VariablesGlobalesCmrz.PRPRAGRLI = PRPRAGRLI;    //	String
        VariablesGlobalesCmrz.PRPRAGRRE = PRPRAGRRE;    //	String
        VariablesGlobalesCmrz.PRPRAGRCON = PRPRAGRCON;    //	String
        VariablesGlobalesCmrz.PRPRAGRLCO = PRPRAGRLCO;    //	String
        VariablesGlobalesCmrz.PRPRAGRLEM = PRPRAGRLEM;    //	String
        VariablesGlobalesCmrz.PRPRAGRLEN = PRPRAGRLEN;    //	String
        VariablesGlobalesCmrz.PRPRAGRLSE = PRPRAGRLSE;    //	String


        // VariablesGlobalesCmrz.PROVAAGAG = PROVAAGAG;    //	String Pregunta
        VariablesGlobalesCmrz.PROVAAGAGAts = PROVAAGAGAts;    //	String
        VariablesGlobalesCmrz.PROVAAGAGMerm = PROVAAGAGMerm;    //	String
        VariablesGlobalesCmrz.PROVAAGAGSalv = PROVAAGAGSalv;    //	String
        VariablesGlobalesCmrz.PROVAAGAGAAfr = PROVAAGAGAAfr;    //	String
        VariablesGlobalesCmrz.PROVAAGAGHar = PROVAAGAGHar;    //	String
        VariablesGlobalesCmrz.PROVAAGAGCpr = PROVAAGAGCpr;    //	String
        VariablesGlobalesCmrz.PROVAAGAGPilon = PROVAAGAGPilon;    //	String
        VariablesGlobalesCmrz.PROVAAGAGMezc = PROVAAGAGMezc;    //	String
        VariablesGlobalesCmrz.PROVAAGAGOtr = PROVAAGAGOtr;    //	String
        VariablesGlobalesCmrz.PROVAAGAGOtrEdt = PROVAAGAGOtrEdt;    //	String
        //     VariablesGlobalesCmrz.PROVAAGAGO = PROVAAGAGO;    //	String eliminacion de otro

        //     VariablesGlobalesCmrz.PROCOMPRAG = PROCOMPRAG;    //	String Pregunta
        VariablesGlobalesCmrz.PROCOMPRAGPB = PROCOMPRAGPB;    //	String
        VariablesGlobalesCmrz.PROCOMPRAGINT = PROCOMPRAGINT;    //	String
        VariablesGlobalesCmrz.PROCOMPRAGSCB = PROCOMPRAGSCB;    //	String
        VariablesGlobalesCmrz.PROCOMPRAGBP = PROCOMPRAGBP;    //	String
        VariablesGlobalesCmrz.PROCOMPRAGOA = PROCOMPRAGOA;    //	String
        VariablesGlobalesCmrz.PROCOMPRAGDFC = PROCOMPRAGDFC;    //	String
        VariablesGlobalesCmrz.PROCOMPRAGPIC = PROCOMPRAGPIC;    //	String



        VariablesGlobalesCmrz.CACOMPRAG = CACOMPRAG;    //	String

        //       VariablesGlobalesCmrz.POCOMPRAG = POCOMPRAG;    //	String pregunta
        VariablesGlobalesCmrz.POCOMPRAGCL = POCOMPRAGCL;    //	String
        VariablesGlobalesCmrz.POCOMPRAGPRS = POCOMPRAGPRS;    //	String
        VariablesGlobalesCmrz.POCOMPRAGDF = POCOMPRAGDF;    //	String
        VariablesGlobalesCmrz.POCOMPRAGVA = POCOMPRAGVA;    //	String
        VariablesGlobalesCmrz.POCOMPRAGCNV = POCOMPRAGCNV;    //	String

    }


    public void ventaProducto(View view) {
        boolean checkedTipo = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.ck_pie_parcela:
                if (checkedTipo) {
                    VENPROAGR = "A pie de parcela";
                }
                break;
            case R.id.ck_mercado:
                if (checkedTipo) {
                    VENPROAGR = "Usted lo lleva al mercado";
                }
                break;
        }
    }

    public void valorAgregadoPrinc(View view) {
        boolean checkedTipo = ((CheckBox) view).isChecked();

        switch (view.getId()) {
            case R.id.ck_pro_vag_1:
                if (checkedTipo) {
                    PROVAAGAGAts = "Ates";
                } else {
                    PROVAAGAGAts = null;
                }
                break;
            case R.id.ck_pro_vag_2:
                if (checkedTipo) {
                    PROVAAGAGMerm = "Mermeladas";

                } else {
                    PROVAAGAGMerm = null;
                }
                break;
            case R.id.ck_pro_vag_3:
                if (checkedTipo) {
                    PROVAAGAGSalv= "Salvado";

                } else {
                    PROVAAGAGSalv = null;
                }
                break;
            case R.id.ck_pro_vag_4:
                if (checkedTipo) {
                    PROVAAGAGAAfr= "Afrecho";

                } else {
                    PROVAAGAGAAfr = null;
                }
                break;
            case R.id.ck_pro_vag_5:
                if (checkedTipo) {
                    PROVAAGAGHar= "Harina";

                } else {
                    PROVAAGAGHar = null;
                }
                break;
            case R.id.ck_pro_vag_6:
                if (checkedTipo) {
                    PROVAAGAGCpr= "Copra";

                } else {
                    PROVAAGAGCpr =null;
                }
                break;
            case R.id.ck_pro_vag_7:
                if (checkedTipo) {
                    PROVAAGAGPilon= "Piloncillo";

                } else {
                    PROVAAGAGPilon = null;
                }
                break;
            case R.id.ck_pro_vag_8:
                if (checkedTipo) {
                    PROVAAGAGMezc= "Mezcal";

                } else {
                    PROVAAGAGMezc = null;
                }
                break;
            case R.id.ck_pro_vag_9:
                if (checkedTipo) {
                    PROVAAGAGOtr= "Otro";
                    edtOtroProducto.setEnabled(true);
                } else {
                    PROVAAGAGOtr = null;
                    PROVAAGAGOtrEdt = null;
                    edtOtroProducto.setText("");
                    edtOtroProducto.setEnabled(false);
                }
                break;

        }
    }

    public void principalesProblemsAqueja(View view) {
        boolean checkedTipo = ((CheckBox) view).isChecked();

        switch (view.getId()) {
            case R.id.ck_pro_pag_1:
                if (checkedTipo) {
                    PROCOMPRAGPB = "Precio bajo de venta";
                } else {
                    PROCOMPRAGPB = null;
                }
                break;
            case R.id.ck_pro_pag_2:
                if (checkedTipo) {
                    PROCOMPRAGINT= "Intermediarios";
                } else {
                    PROCOMPRAGINT= null;
                }
                break;
            case R.id.ck_pro_pag_3:
                if (checkedTipo) {
                    PROCOMPRAGSCB= "Se castigan precios por baja calidad";
                } else {
                    PROCOMPRAGSCB= null;
                }
                break;
            case R.id.ck_pro_pag_4:
                if (checkedTipo) {
                    PROCOMPRAGBP= "Baja producción";
                } else {
                    PROCOMPRAGBP= null;
                }
                break;
            case R.id.ck_pro_pag_5:
                if (checkedTipo) {
                    PROCOMPRAGOA= "Oferta alta";
                } else {
                    PROCOMPRAGOA= null;

                }
                break;
            case R.id.ck_pro_pag_6:
                if (checkedTipo) {
                    PROCOMPRAGDFC= "Distancia de las fuentes de comercialización";
                } else {
                    PROCOMPRAGDFC= null;
                }
                break;
            case R.id.ck_pro_pag_7:
                if (checkedTipo) {
                    PROCOMPRAGPIC= "Pago impuntual de los compradores";
                } else {
                    PROCOMPRAGPIC= null;
                }
                break;
        }
    }

    public void canalesComercializacion(View view) {
        boolean checkedTipo = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.ck_com_fu_cn_1:
                if (checkedTipo) {
                    CACOMPRAG = "Directo al consumidor";
                }
                break;
            case R.id.ck_com_fu_cn_2:
                if (checkedTipo) {
                    CACOMPRAG = "Directo a la central de abastos";
                }
                break;
            case R.id.ck_com_fu_cn_3:
                if (checkedTipo) {
                    CACOMPRAG = "Contrato con la industria";
                }
                break;
            case R.id.ck_com_fu_cn_4:
                if (checkedTipo) {
                    CACOMPRAG = "Vender a organización de productores";
                }
                break;
            case R.id.ck_com_fu_cn_5:
                if (checkedTipo) {
                    CACOMPRAG = "A pie de parcela";
                }
                break;
        }
    }

    public void faltaComercializar(View view) {
        boolean checkedTipo = ((CheckBox) view).isChecked();

        switch (view.getId()) {
            case R.id.ck_fl_pro_cm_1:
                if (checkedTipo) {
                    POCOMPRAGCL = "Calidad";

                }else {
                    POCOMPRAGCL = null;
                }
                break;
            case R.id.ck_fl_pro_cm_2:
                if (checkedTipo) {
                    POCOMPRAGPRS = "Presentación";

                }else {
                    POCOMPRAGPRS = null;
                }
                break;
            case R.id.ck_fl_pro_cm_3:
                if (checkedTipo) {
                    POCOMPRAGDF = "Difusión";

                }else {
                    POCOMPRAGDF = null;
                }
                break;
            case R.id.ck_fl_pro_cm_4:
                if (checkedTipo) {
                    POCOMPRAGVA = "Valor agregado";

                }else {
                    POCOMPRAGVA = null;
                }
                break;
            case R.id.ck_fl_pro_cm_5:
                if (checkedTipo) {
                    POCOMPRAGCNV = "Procesos de conservación";

                }else {
                    POCOMPRAGCNV = null;
                }
                break;
        }
    }

    @Override
    public void onBackPressed() {

    }

}
