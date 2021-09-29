package com.example.geosegalmex.unidadcomercializacion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.geosegalmex.R;
import com.example.geosegalmex.unidadcaracterizacionhortalizas.db.DatabaseHelper;
import com.example.geosegalmex.unidadcomercializacion.bdcomercializacion.VariablesGlobalesCmrz;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

public class comercializacion_8 extends AppCompatActivity {
    ExtendedFloatingActionButton co8;

    private	String	CACOMPRPE	= null;		//	String
    // private	String	POCOMPRPE	= null;		//	String
    private	String	POCOMPRPECL	= null;		//	String
    private	String	POCOMPRPEPR	= null;		//	String
    private	String	POCOMPRPEDF	= null;		//	String
    private	String	POCOMPRPEVA	= null;		//	String
    private	String	POCOMPRPEPC	= null;		//	String

    private	String	CMPREPRPE	= null;		//	String
    private	String	EMINECPRP	= null;		//	String
    private	String	EMINECPRPCC	= null;		//	String
    private	String	EMINECPRPCM	= null;		//	String
    private	String	EMINECPRPAB	= null;		//	String
    private	String	EMINECPRPMF	= null;		//	String

    private DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comercializacion_8);
        co8 = findViewById(R.id.cr8);

        db         = new DatabaseHelper(this);

        co8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // VariablesGlobalesCmrz.PROVAAGPE = PROVAAGPE;	//	String repetida en el modulo 7
                VariablesGlobalesCmrz.CACOMPRPE = CACOMPRPE;	//	String

                //  VariablesGlobalesCmrz.POCOMPRPE = POCOMPRPE;	//	pregunta String
                VariablesGlobalesCmrz.POCOMPRPECL = POCOMPRPECL;	//	String
                VariablesGlobalesCmrz.POCOMPRPEPR = POCOMPRPEPR;	//	String
                VariablesGlobalesCmrz.POCOMPRPEDF = POCOMPRPEDF;	//	String
                VariablesGlobalesCmrz.POCOMPRPEVA = POCOMPRPEVA;	//	String
                VariablesGlobalesCmrz.POCOMPRPEPC = POCOMPRPEPC;	//	String

                VariablesGlobalesCmrz.CMPREPRPE = CMPREPRPE;	//	String
              //  VariablesGlobalesCmrz.EMINECPRP = EMINECPRP;	//	String

                VariablesGlobalesCmrz.EMINECPRPCC = EMINECPRPCC;	//	String
                VariablesGlobalesCmrz.EMINECPRPCM = EMINECPRPCM;	//	String
                VariablesGlobalesCmrz.EMINECPRPAB = EMINECPRPAB;	//	String
                VariablesGlobalesCmrz.EMINECPRPMF = EMINECPRPMF;	//	String

                aggComercializacion();
               // startActivity(new Intent(getApplicationContext(), IdentificacionCuestionario.class));
                startActivity(new Intent(getApplicationContext(), Apicultura_1.class));
            }
        });
    }

    private void aggComercializacion() {
        boolean insertarData = db.addComercializacion();
        if(insertarData == true) {
            Toast.makeText(this, "Datos insertados correctamente", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Algo salio mal", Toast.LENGTH_LONG).show();
        }
    }

    public void cmcanalComercializacion(View view) {
        boolean checkedTipo = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.ck_cm_can_cm_1:
                if (checkedTipo) {
                    CACOMPRPE = "Directo al consumidor";
                }
                break;
            case R.id.ck_cm_can_cm_2:
                if (checkedTipo) {
                    CACOMPRPE = "Directo a la central de abastos";
                }
                break;
            case R.id.ck_cm_can_cm_3:
                if (checkedTipo) {
                    CACOMPRPE = "Contrato con la industria";
                }
                break;
        }
    }

    public void faltaproComercializar(View view) {
        boolean checkedTipo = ((CheckBox) view).isChecked();

        switch (view.getId()) {
            case R.id.ck_pro_pdr_cm_0:
                if (checkedTipo) {
                    POCOMPRPECL = "Calidad";
                } else {
                    POCOMPRPECL =  null;
                }
                break;
            case R.id.ck_pro_pdr_cm_1:
                if (checkedTipo) {
                    POCOMPRPEPR = "Presentación";
                } else {
                    POCOMPRPEPR = null;
                }
                break;
            case R.id.ck_pro_pdr_cm_2:
                if (checkedTipo) {
                    POCOMPRPEDF = "Difusión";
                } else {
                    POCOMPRPEDF = null;
                }
                break;
            case R.id.ck_pro_pdr_cm_3:
                if (checkedTipo) {
                    POCOMPRPEVA = "Valor agregado";
                } else {
                    POCOMPRPEVA = null;
                }
                break;
            case R.id.ck_pro_pdr_cm_4:
                if (checkedTipo) {
                    POCOMPRPEPC = "Procesos de conservación";
                } else {
                    POCOMPRPEPC = null;
                }
                break;
        }
    }

    public void ventasUltimas(View view) {
        boolean checkedTipo = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.ck_vnt_ult_1:
                if (checkedTipo) {
                    CMPREPRPE = "Excelente";
                }
                break;
            case R.id.ck_vnt_ult_2:
                if (checkedTipo) {
                    CMPREPRPE = "Muy bueno";
                }
                break;
            case R.id.ck_vnt_ult_3:
                if (checkedTipo) {
                    CMPREPRPE = "Bueno";
                }
                break;
            case R.id.ck_vnt_ult_4:
                if (checkedTipo) {
                    CMPREPRPE = "Regular";
                }
                break;
            case R.id.ck_vnt_ult_5:
                if (checkedTipo) {
                    CMPREPRPE = "Malo";
                }
                break;
            case R.id.ck_vnt_ult_6:
                if (checkedTipo) {
                    CMPREPRPE = "Muy malo";
                }
                break;
        }
    }

    public void empresaIntEcon(View view) {
        boolean checkedTipo = ((CheckBox) view).isChecked();

        switch (view.getId()) {
            case R.id.ck_emp_int_cs_1:
                if (checkedTipo) {
                    EMINECPRPCC = "Centro de acopio y comercialización de producto";
                } else {
                    EMINECPRPCC = null;
                }
                break;
            case R.id.ck_emp_int_cs_2:
                if (checkedTipo) {
                    EMINECPRPCM = "Central de maquinaria";
                } else {
                    EMINECPRPCM = null;
                }
                break;
            case R.id.ck_emp_int_cs_3:
                if (checkedTipo) {
                    EMINECPRPAB = "Abastecimiento de insumos";
                } else {
                    EMINECPRPAB = null;
                }
                break;
            case R.id.ck_emp_int_cs_4:
                if (checkedTipo) {
                    EMINECPRPMF = "Manufactura de valor agregado";
                } else {
                    EMINECPRPMF = null;
                }
                break;
        }
    }

    @Override
    public void onBackPressed() {

    }
}
