package com.example.geosegalmex.unidadcomercializacion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

import com.example.geosegalmex.R;
import com.example.geosegalmex.unidadcomercializacion.bdcomercializacion.VariablesGlobalesCmrz;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

public class Apicultura_2 extends AppCompatActivity {
    private String VENTPRO = null;
    private String COSTFLEA = null;
    private String COSTCONTR1 = null;
    private String COSTCONTR2 = null;
    private String COSTCONTR3 = null;
    private String COSTCONTR4 = null;

    EditText edt1;

    EditText edt2_1;
    EditText edt2_2;
    EditText edt2_3;
    EditText edt2_4;

    ExtendedFloatingActionButton btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apicultura_2);

        edt1 = findViewById(R.id.edt_api_2_1);
        edt2_1 = findViewById(R.id.edt_pro_ap_2_1);
        edt2_2 = findViewById(R.id.edt_pro_ap_2_2);
        edt2_3 = findViewById(R.id.edt_pro_ap_2_3);
        edt2_4 = findViewById(R.id.edt_pro_ap_2_4);

        btnNext = findViewById(R.id.api_2);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                asignacionValores();
                startActivity(new Intent(getApplicationContext(), Apicultura_3.class));
            }
        });



    }

    private void asignacionValores() {
        if(!edt1.getText().toString().isEmpty()){
            COSTFLEA  = edt1.getText().toString();
        }

        if(!edt2_1.getText().toString().isEmpty()){
            COSTCONTR1 = edt2_1.getText().toString();
        }

        if(!edt2_2.getText().toString().isEmpty()){
            COSTCONTR2 = edt2_2.getText().toString();
        }

        if(!edt2_3.getText().toString().isEmpty()){
            COSTCONTR3 = edt2_3.getText().toString();
        }

        if(!edt2_4.getText().toString().isEmpty()){
            COSTCONTR4 = edt2_4.getText().toString();
        }


        VariablesGlobalesCmrz.VENTPRO = VENTPRO;
        VariablesGlobalesCmrz.COSTFLEA = COSTFLEA;
        VariablesGlobalesCmrz.COSTCONTR1 = COSTCONTR1;
        VariablesGlobalesCmrz.COSTCONTR2 = COSTCONTR2;
        VariablesGlobalesCmrz.COSTCONTR3 = COSTCONTR3;
        VariablesGlobalesCmrz.COSTCONTR4 = COSTCONTR4;

    }

    public void ventaProductoApi(View view) {
        boolean checkedTipo = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.rd_vnt_prd_1:
                if (checkedTipo) {
                    VENTPRO = "En el apiario";
                }
                break;
            case R.id.rd_vnt_prd_2:
                if (checkedTipo) {
                    VENTPRO = "Usted lo lleva al mercado";
                }
                break;
        }
    }

    @Override
    public void onBackPressed() {

    }
}
