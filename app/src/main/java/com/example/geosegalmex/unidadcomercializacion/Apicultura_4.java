package com.example.geosegalmex.unidadcomercializacion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.geosegalmex.IdentificacionCuestionario;
import com.example.geosegalmex.R;
import com.example.geosegalmex.unidadcaracterizacionhortalizas.db.DatabaseHelper;
import com.example.geosegalmex.unidadcomercializacion.bdcomercializacion.VariablesGlobalesCmrz;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

import java.util.ArrayList;

public class Apicultura_4 extends AppCompatActivity {
    ArrayList <String> arrayList1;
    ArrayList <String> arrayList2;

    private String FALPROCM = null;
    private String PROPROMI = null;
    private String EMPIMTECM = null;

    ExtendedFloatingActionButton btnNext;

    private DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apicultura_4);

        arrayList1 = new ArrayList<>();
        arrayList2 = new ArrayList<>();

        db = new DatabaseHelper(this);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

        btnNext = findViewById(R.id.api_4);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                asignacionVariables();
                aggApicolaGral();
                startActivity(new Intent(getApplicationContext(), IdentificacionCuestionario.class));
            }
        });



    }

    private void aggApicolaGral() {
        boolean insertarData = db.addComercializacionApicolaGral();
        if (insertarData == true) {
            Toast.makeText(this, "Datos insertados correctamente", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Algo salio mal", Toast.LENGTH_LONG).show();
        }
    }

    private void asignacionVariables() {
        int i = 0;

        String valor1 = null;
        if(!arrayList1.isEmpty()) {
            for (i = 0; i < arrayList1.size(); i++) {
                if (valor1 == null) {
                    valor1 = arrayList1.get(i);
                } else if (valor1 != null) {
                    valor1 = valor1 + "," + arrayList1.get(i);
                }
            }
        }
        FALPROCM = valor1;

        String valor2 = null;
        if(!arrayList2.isEmpty()) {
            for (i = 0; i < arrayList2.size(); i++) {
                if (valor2 == null) {
                    valor2 = arrayList2.get(i);
                } else if (valor2 != null) {
                    valor2 = valor2 + "," + arrayList2.get(i);
                }
            }
        }
        EMPIMTECM = valor2;

        VariablesGlobalesCmrz.FALPROCM = FALPROCM;
        VariablesGlobalesCmrz.PROPROMI = PROPROMI;
        VariablesGlobalesCmrz.EMPIMTECM = EMPIMTECM;

    }

    public void faltaProdCmrAPi(View view) {
        boolean checkedTipo = ((CheckBox) view).isChecked();

        switch (view.getId()) {
            case R.id.ck_ap_3_4_1:
                if (checkedTipo) {
                    arrayList1.add("Calidad");
                } else {
                    arrayList1.remove("Calidad");
                }
                break;
            case R.id.ck_ap_3_4_2:
                if (checkedTipo) {
                    arrayList1.add("Presentación");
                } else {
                    arrayList1.remove("Presentación");
                }
                break;
            case R.id.ck_ap_3_4_3:
                if (checkedTipo) {
                    arrayList1.add("Difusión");
                } else {
                    arrayList1.remove("Difusión");
                }
                break;
            case R.id.ck_ap_3_4_4:
                if (checkedTipo) {
                    arrayList1.add("Valor agregado");
                } else {
                    arrayList1.remove("Valor agregado");
                }
                break;
            case R.id.ck_ap_3_4_5:
                if (checkedTipo) {
                    arrayList1.add("Procesos de conservación");
                } else {
                    arrayList1.remove("Procesos de conservación");
                }
                break;
        }
    }

    public void ultimasVentasAPicola(View view) {
        boolean checkedTipo = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.rd_cmr_4_1:
                if (checkedTipo) {
                    PROPROMI = "Excelente";
                }
                break;
            case R.id.rd_cmr_4_2:
                if (checkedTipo) {
                    PROPROMI = "Muy bueno";
                }
                break;
            case R.id.rd_cmr_4_3:
                if (checkedTipo) {
                    PROPROMI = "Bueno";
                }
                break;
            case R.id.rd_cmr_4_4:
                if (checkedTipo) {
                    PROPROMI = "Regular";
                }
                break;
            case R.id.rd_cmr_4_5:
                if (checkedTipo) {
                    PROPROMI = "Malo";
                }
                break;
            case R.id.rd_cmr_4_6:
                if (checkedTipo) {
                    PROPROMI = "Muy malo";
                }
                break;
        }
    }

    public void empresaApicola(View view) {
        boolean checkedTipo = ((CheckBox) view).isChecked();

        switch (view.getId()) {
            case R.id.ck_cmr_4_1:
                if (checkedTipo) {
                    arrayList2.add("Centro de acopio y comercialización de producto");
                } else {
                    arrayList2.remove("Centro de acopio y comercialización de producto");
                }
                break;
            case R.id.ck_cmr_4_2:
                if (checkedTipo) {
                    arrayList2.add("Central de maquinaria");
                } else {
                    arrayList2.remove("Central de maquinaria");
                }
                break;
            case R.id.ck_cmr_4_3:
                if (checkedTipo) {
                    arrayList2.add("Abastecimiento de insumos");
                } else {
                    arrayList2.remove("Abastecimiento de insumos");
                }
                break;
            case R.id.ck_cmr_4_4:
                if (checkedTipo) {
                    arrayList2.add("Manufactura de valor agregado");
                } else {
                    arrayList2.remove("Manufactura de valor agregado");
                }
                break;
        }
    }

    @Override
    public void onBackPressed() {

    }
}
