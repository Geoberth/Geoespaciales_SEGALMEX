package com.example.geosegalmex.apicola;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;

import com.example.geosegalmex.R;
import com.example.geosegalmex.apicola.variables_apicola.VariablesModuloSiete;

import java.util.ArrayList;

public class SanidadApicola extends AppCompatActivity {
    Button btnApisanidadenf;

    Button btnApisanidadenfcos;
    //APICOLA 6
    private String	APIENFCC = null;//	¿Ha encontrado enfermedades de la cría en sus colonias?
    private String	APICOLENF = null;//	¿Qué hace con las colonias enfermas?

    //Ir a hoja: 7.5 Enfermedades

    private String	MUNABE	= null;//	¿Actualmente se le mueren abejas adultas de su apiario?
    private String	MESMUNA	= null;//	¿En qué meses tiene el problema de muerte de abejas adultas?
    private String	TRATAM	= null;//	¿Qué tratamiento utiliza para el problema de muerte de abejas adultas?

    ArrayList<String> mesSelecct;

    EditText edt1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sanidad_apicola);
      //  btnApisanidadenf = (Button)findViewById(R.id.btnSigagregaenfermedad);


        mesSelecct = new ArrayList<>();

        btnApisanidadenfcos = (Button)findViewById(R.id.apicola_next_sanidad);
        edt1 = findViewById(R.id.edtSanidadtratabeadultas);




       // btnApisanidadenf.setOnClickListener(new View.OnClickListener() {
         //   @Override
         //   public void onClick(View view) {
               // asignacionValores();
               // startActivity(new Intent(SanidadApicola.this, EnfermedadesCambioPanales.class));
       //     }
        //});






        btnApisanidadenfcos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             //   startActivity(new Intent(SanidadApicola.this, CosechaApicola.class));
                asignacionValores();
                startActivity(new Intent(SanidadApicola.this, EnfermedadesCambioPanales.class));
            }
        });
    }

    private void asignacionValores() {
        int i;
        String mesList = null;
        if(mesSelecct.size() != 0) {
            for (i = 0; i < mesSelecct.size(); i++) {
                if (mesList == null) {
                    mesList = mesSelecct.get(i);
                } else if (mesList != null) {
                    mesList = mesList + "," + mesSelecct.get(i);
                }

            }
        }
        MESMUNA = mesList;

        if(!edt1.getText().toString().isEmpty()){
            TRATAM = edt1.getText().toString();
        }

        VariablesModuloSiete.APIENFCC = APIENFCC;//	¿Ha encontrado enfermedades de la cría en sus colonias?
        VariablesModuloSiete.APICOLENF = APICOLENF;//	¿Qué hace con las colonias enfermas?

        VariablesModuloSiete.MUNABE	= MUNABE;//	¿Actualmente se le mueren abejas adultas de su apiario?
        VariablesModuloSiete.MESMUNA = MESMUNA;//	¿En qué meses tiene el problema de muerte de abejas adultas?
        VariablesModuloSiete.TRATAM	= TRATAM;//	¿Qué tratamiento utiliza para el problema de muerte de abejas adultas?
    }

    public void enfermedadesColonias(View view) {
        boolean checkedTipo = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.radioSisanidadenfcriacol:
                if (checkedTipo) {
                    APIENFCC = "Si";
                }
                break;
            case R.id.radioNosanidadenfcriacol:
                if (checkedTipo) {
                    APIENFCC = "No";
                }
                break;
        }
    }

    public void coloniasEnfermas(View view) {
        boolean checkedTipo = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.radioSanidadtratarcriacolelim:
                if (checkedTipo) {
                    APICOLENF = "Las elimina";
                }
                break;
            case R.id.radioSanidadtratarcriacoltrata:
                if (checkedTipo) {
                    APICOLENF = "Las trata";
                }
                break;
            case R.id.radioSanidadtratarcriacolambas:
                if (checkedTipo) {
                    APICOLENF = "Ambas";
                }
                break;
        }
    }

    public void muerenAbejasAdultas(View view) {
        boolean checkedTipo = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.radioSisanidadenfabejaadultamuerte:
                if (checkedTipo) {
                    MUNABE = "Si";
                }
                break;
            case R.id.radioNosanidadenfabejaadultamuerte:
                if (checkedTipo) {
                    MUNABE = "No";
                }
                break;
        }
    }

    public void mesApicolaProblem(View view) {
        boolean checkedTipo = ((CheckBox) view).isChecked();

        switch (view.getId()) {
            case R.id.ck_ms_api_7_1:
                if (checkedTipo) {
                    mesSelecct.add("Enero");
                } else {
                    mesSelecct.remove("Enero");
                }
                break;
            case R.id.ck_ms_api_7_2:
                if (checkedTipo) {
                    mesSelecct.add("Febrero");
                } else {
                    mesSelecct.remove("Febrero");
                }
                break;
            case R.id.ck_ms_api_7_3:
                if (checkedTipo) {
                    mesSelecct.add("Marzo");
                } else {
                    mesSelecct.remove("Marzo");
                }
                break;
            case R.id.ck_ms_api_7_4:
                if (checkedTipo) {
                    mesSelecct.add("Abril");
                } else {
                    mesSelecct.remove("Abril");
                }
                break;
            case R.id.ck_ms_api_7_5:
                if (checkedTipo) {
                    mesSelecct.add("Mayo");
                } else {
                    mesSelecct.remove("Mayo");
                }
                break;
            case R.id.ck_ms_api_7_6:
                if (checkedTipo) {
                    mesSelecct.add("Junio");
                } else {
                    mesSelecct.remove("Junio");
                }
                break;
            case R.id.ck_ms_api_7_7:
                if (checkedTipo) {
                    mesSelecct.add("Julio");
                } else {
                    mesSelecct.remove("Julio");
                }
                break;
            case R.id.ck_ms_api_7_8:
                if (checkedTipo) {
                    mesSelecct.add("Agosto");
                } else {
                    mesSelecct.remove("Agosto");
                }
                break;
            case R.id.ck_ms_api_7_9:
                if (checkedTipo) {
                    mesSelecct.add("Septiembre");
                } else {
                    mesSelecct.remove("Septiembre");
                }
                break;
            case R.id.ck_ms_api_7_10:
                if (checkedTipo) {
                    mesSelecct.add("Octubre");
                } else {
                    mesSelecct.remove("Octubre");
                }
                break;
            case R.id.ck_ms_api_7_11:
                if (checkedTipo) {
                    mesSelecct.add("Noviembre");
                } else {
                    mesSelecct.remove("Noviembre");
                }
                break;
            case R.id.ck_ms_api_7_12:
                if (checkedTipo) {
                    mesSelecct.add("Diciembre");
                } else {
                    mesSelecct.remove("Diciembre");
                }
                break;
        }
    }

    @Override
    public void onBackPressed() {

    }
}
