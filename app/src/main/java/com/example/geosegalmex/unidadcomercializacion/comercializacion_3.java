package com.example.geosegalmex.unidadcomercializacion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;

import com.example.geosegalmex.R;
import com.example.geosegalmex.unidadcomercializacion.bdcomercializacion.VariablesGlobalesCmrz;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

public class comercializacion_3 extends AppCompatActivity {
    ExtendedFloatingActionButton co3;

    private	String	CMPREPRAG	= null;		//	String
    //  private	String	EMINECPRA	= null;		//	String pregunta
    private	String	EMINECPRACNT	= null;		//	String
    private	String	EMINECPRACM	= null;		//	String
    private	String	EMINECPRAABI	= null;		//	String
    private	String	EMINECPRAMA	= null;		//	String

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comercializacion_3);
        co3 = findViewById(R.id.cr3);

        co3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                VariablesGlobalesCmrz.CMPREPRAG = CMPREPRAG;	//	String

                //       VariablesGlobalesCmrz.EMINECPRA = EMINECPRA;	//	String pregunta
                VariablesGlobalesCmrz.EMINECPRACNT = EMINECPRACNT;	//	String
                VariablesGlobalesCmrz.EMINECPRACM = EMINECPRACM;	//	String
                VariablesGlobalesCmrz.EMINECPRAABI = EMINECPRAABI;	//	String
                VariablesGlobalesCmrz.EMINECPRAMA = EMINECPRAMA;	//	String
                startActivity(new Intent(getApplicationContext(), comercializacion_3_1.class));
            }
        });
    }

    public void ultimasVentas(View view) {
        boolean checkedTipo = ((RadioButton) view).isChecked();
        switch (view.getId()) {
            case R.id.ck_ult_vnt_1:
                if (checkedTipo) {
                    CMPREPRAG = "Excelente";
                }
                break;
            case R.id.ck_ult_vnt_2:
                if (checkedTipo) {
                    CMPREPRAG = "Muy bueno";
                }
                break;
            case R.id.ck_ult_vnt_3:
                if (checkedTipo) {
                    CMPREPRAG = "Bueno";
                }
                break;
            case R.id.ck_ult_vnt_4:
                if (checkedTipo) {
                    CMPREPRAG = "Regular";
                }
                break;
            case R.id.ck_ult_vnt_5:
                if (checkedTipo) {
                    CMPREPRAG = "Malo";
                }
                break;
        }
    }

    public void integracionEconomica(View view) {
        boolean checkedTipo = ((CheckBox) view).isChecked();

        switch (view.getId()) {
            case R.id.ck_emp_int_1:
                if (checkedTipo) {
                    EMINECPRACNT = "Centro de acopio y comercialización de producto";
                }else{
                    EMINECPRACNT = null;
                }
                break;
            case R.id.ck_emp_int_2:
                if (checkedTipo) {
                    EMINECPRACM = "Central de maquinaria";
                }else {
                    EMINECPRACM = null;
                }
                break;
            case R.id.ck_emp_int_3:
                if (checkedTipo) {
                    EMINECPRAABI = "Abastecimiento de insumos";
                }else {
                    EMINECPRAABI = null;
                }
                break;
            case R.id.ck_emp_int_4:
                if (checkedTipo) {
                    EMINECPRAMA = "Manufactura de valor agregado";
                }else {
                    EMINECPRAMA = null;
                }
                break;
        }
    }

    @Override
    public void onBackPressed() {

    }
}
