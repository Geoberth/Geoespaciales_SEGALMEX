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

import java.util.ArrayList;

public class Apicultura_3 extends AppCompatActivity {
    private String PRIPROAM = null;
    private String OTRPRAP = null;
    private String PROCOMMI = null;
    private String CANCOMMI = null;

    ArrayList<String> arrayList1;
    ArrayList<String> arrayList2;
   // ArrayList<String> arrayList3;

    EditText edtOtro;

    ExtendedFloatingActionButton btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apicultura_3);

        arrayList1 = new ArrayList<>();
        arrayList2 = new ArrayList<>();
       // arrayList3 = new ArrayList<>();

        edtOtro = findViewById(R.id.edt_otr_3_1);
        btnNext = findViewById(R.id.api_3);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                asignacionValores();
                startActivity(new Intent(getApplicationContext(), Apicultura_4.class));
            }
        });


    }

    private void asignacionValores() {
        int i = 0;

        //+++++++++++++++++++uno
        if (!edtOtro.getText().toString().isEmpty()) {
            OTRPRAP = edtOtro.getText().toString();
        }

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
        PRIPROAM = valor1;

        //+++++++++++++++++++++++++Dos
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
        PROCOMMI = valor2;



        VariablesGlobalesCmrz.PRIPROAM = PRIPROAM;
        VariablesGlobalesCmrz.OTRPRAP = OTRPRAP;
        VariablesGlobalesCmrz.PROCOMMI = PROCOMMI;
        VariablesGlobalesCmrz.CANCOMMI = CANCOMMI;
    }

    public void princpalesProductos(View view) {
        boolean checkedTipo = ((CheckBox) view).isChecked();

        switch (view.getId()) {
            case R.id.ck_apc_cm_3_1:
                if (checkedTipo) {
                    arrayList1.add("Shampoo");
                } else {
                    arrayList1.remove("Shampoo");
                }
                break;
            case R.id.ck_apc_cm_3_2:
                if (checkedTipo) {
                    arrayList1.add("Jabón");
                } else {
                    arrayList1.remove("Jabón");
                }
                break;
            case R.id.ck_apc_cm_3_3:
                if (checkedTipo) {
                    arrayList1.add("Cosméticos");
                } else {
                    arrayList1.remove("Cosméticos");
                }
                break;
            case R.id.ck_apc_cm_3_4:
                if (checkedTipo) {
                    arrayList1.add("Otro");
                    edtOtro.setEnabled(true);
                } else {
                    arrayList1.remove("Otro");
                    edtOtro.setEnabled(false);
                    edtOtro.setText("");
                    OTRPRAP = null;
                }
                break;
        }
    }

    public void principaresQuejasAPicola(View view) {
        boolean checkedTipo = ((CheckBox) view).isChecked();

        switch (view.getId()) {
            case R.id.ck_apc_3_1_1:
                if (checkedTipo) {
                    arrayList2.add("Precio bajo de venta");
                } else {
                    arrayList2.remove("Precio bajo de venta");
                }
                break;
            case R.id.ck_apc_3_1_2:
                if (checkedTipo) {
                    arrayList2.add("Intermediarios");
                } else {
                    arrayList2.remove("Intermediarios");
                }
                break;
            case R.id.ck_apc_3_1_3:
                if (checkedTipo) {
                    arrayList2.add("Se castigan precios por baja calidad");
                } else {
                    arrayList2.remove("Se castigan precios por baja calidad");
                }
                break;
            case R.id.ck_apc_3_1_4:
                if (checkedTipo) {
                    arrayList2.add("Baja producción");
                } else {
                    arrayList2.remove("Baja producción");
                }
                break;
            case R.id.ck_apc_3_1_5:
                if (checkedTipo) {
                    arrayList2.add("Oferta alta");
                } else {
                    arrayList2.remove("Oferta alta");
                }
                break;
            case R.id.ck_apc_3_1_6:
                if (checkedTipo) {
                    arrayList2.add("Distancia de las fuentes de comercialización");
                } else {
                    arrayList2.remove("Distancia de las fuentes de comercialización");
                }
                break;
            case R.id.ck_apc_3_1_7:
                if (checkedTipo) {
                    arrayList2.add("Pago impuntual de los compradores");
                } else {
                    arrayList2.remove("Pago impuntual de los compradores");
                }
                break;
        }
    }

    public void canalesAPicola(View view) {
        boolean checkedTipo = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.ck_apc_3_2_1:
                if (checkedTipo) {
                    CANCOMMI = "Directo al consumidor";
                }
                break;
            case R.id.ck_apc_3_2_2:
                if (checkedTipo) {
                    CANCOMMI ="Directo a la central de abastos";
                }
                break;
            case R.id.ck_apc_3_2_3:
                if (checkedTipo) {
                    CANCOMMI = "Contrato con la industria";
                }
                break;
            case R.id.ck_apc_3_2_4:
                if (checkedTipo) {
                    CANCOMMI = "Vender a organización de productores";
                }
                break;
            case R.id.ck_apc_3_2_5:
                if (checkedTipo) {
                    CANCOMMI = "A pie de parcela";
                }
                break;
        }
    }

    @Override
    public void onBackPressed() {

    }
}
