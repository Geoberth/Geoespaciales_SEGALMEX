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

public class CosechaApicola extends AppCompatActivity {
    Button btnApicosecha;
    //APICOLA 8
    private String	EPOCOSMI = null;//	¿Cuáles serían las épocas de cosecha de la miel?


    //	¿Con qué equipos cuenta para la cosecha?
//	Tabla de equipo para la cosecha
    private String	COSTEQAHUM	= null;//	Costo por unidad ($/unidad) del equipo de cosecha: AHUMADOR
    private String	COSTEQCUNA = null;//	Costo por unidad ($/unidad) del equipo de cosecha: cuña
    private String	COSTEQCOCA	= null;//	Costo por unidad ($/unidad) del equipo de cosecha: Cajas vacías
    private String	COSTEQCOCE	= null;//	Costo por unidad ($/unidad) del equipo de cosecha: Cepillos para barrer abejas
    private String	COSTEQCOCH	= null;//	Costo por unidad ($/unidad) del equipo de cosecha: Charolas salvamiel
    private String	COSTEQCOBA	= null;//	Costo por unidad ($/unidad) del equipo de cosecha: Balde para recoger la cera
    private String	COSTEQCOVE	= null;//	Costo por unidad ($/unidad) del equipo de cosecha: Vehículos
    private String	COSTEQCOCU	= null;//	Costo por unidad ($/unidad) del equipo de cosecha: Cuarto de extraccion


    private String	EXTMIEL	= null;//	¿Cómo realiza la extracción de la miel?
    private String	NJOREM	= null;//	Número de jornales utilizados
    private String	COSJOREM	= null;//	Costo del jornal ($)
    private String	EQUEM	= null;//	Propio / Rentado
    private String	COSTEM	= null;//	Costo ($)

    private String	PROCERA	= null;//	¿Cómo procesa la cera?

    ArrayList<String> mesSelecct;

    EditText edt1;
    EditText edt2;
    EditText edt3;
    EditText edt4;
    EditText edt5;
    EditText edt6;
    EditText edt7;
    EditText edt8;
    EditText edt9;
    EditText edt10;
    EditText edt11;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cosecha_apicola);
        btnApicosecha = (Button)findViewById(R.id.apicola_next_cosecha);


        mesSelecct = new ArrayList<>();
        edt1 = findViewById(R.id.edt_api_7_1);
        edt2 = findViewById(R.id.edt_api_7_2);
        edt3 = findViewById(R.id.edt_api_7_3);
        edt4 = findViewById(R.id.edt_api_7_4);
        edt5 = findViewById(R.id.edt_api_7_5);
        edt6 = findViewById(R.id.edt_api_7_6);
        edt7 = findViewById(R.id.edt_api_7_7);
        edt8 = findViewById(R.id.edt_api_7_8);

        edt9 = findViewById(R.id.edtCosechanumerojornaleros);
        edt10 = findViewById(R.id.edtCosechacostojornal);
        edt11 = findViewById(R.id.edtCosechacostototal);


        btnApicosecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                asignacionValores();
                startActivity(new Intent(CosechaApicola.this, AspectosProductivosApicola.class));
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
        EPOCOSMI = mesList;


        if(!edt1.getText().toString().isEmpty()){
            COSTEQAHUM = edt1.getText().toString();
        }

        if(!edt2.getText().toString().isEmpty()){
            COSTEQCUNA = edt2.getText().toString();
        }

        if(!edt3.getText().toString().isEmpty()){
            COSTEQCOCA = edt3.getText().toString();
        }

        if(!edt4.getText().toString().isEmpty()){
            COSTEQCOCE = edt4.getText().toString();
        }

        if(!edt5.getText().toString().isEmpty()){
            COSTEQCOCH = edt5.getText().toString();
        }

        if(!edt6.getText().toString().isEmpty()){
            COSTEQCOBA = edt6.getText().toString();
        }

        if(!edt7.getText().toString().isEmpty()){
            COSTEQCOVE = edt7.getText().toString();
        }

        if(!edt8.getText().toString().isEmpty()){
            COSTEQCOCU = edt8.getText().toString();
        }

        if(!edt9.getText().toString().isEmpty()){
            NJOREM = edt9.getText().toString();
        }

        if(!edt10.getText().toString().isEmpty()){
            COSJOREM = edt10.getText().toString();
        }

        if(!edt11.getText().toString().isEmpty()){
            COSTEM = edt11.getText().toString();
        }

        VariablesModuloSiete.EPOCOSMI = EPOCOSMI;//	¿Cuáles serían las épocas de cosecha de la miel?


        //	¿Con qué equipos cuenta para la cosecha?
//	Tabla de equipo para la cosecha
        VariablesModuloSiete.COSTEQAHUM	= COSTEQAHUM;//	Costo por unidad ($/unidad) del equipo de cosecha: AHUMADOR
        VariablesModuloSiete.COSTEQCUNA = COSTEQCUNA;//	Costo por unidad ($/unidad) del equipo de cosecha: cuña
        VariablesModuloSiete.COSTEQCOCA	= COSTEQCOCA;//	Costo por unidad ($/unidad) del equipo de cosecha: Cajas vacías
        VariablesModuloSiete.COSTEQCOCE	= COSTEQCOCE;//	Costo por unidad ($/unidad) del equipo de cosecha: Cepillos para barrer abejas
        VariablesModuloSiete.COSTEQCOCH	= COSTEQCOCH;//	Costo por unidad ($/unidad) del equipo de cosecha: Charolas salvamiel
        VariablesModuloSiete.COSTEQCOBA	= COSTEQCOBA;//	Costo por unidad ($/unidad) del equipo de cosecha: Balde para recoger la cera
        VariablesModuloSiete.COSTEQCOVE	= COSTEQCOVE;//	Costo por unidad ($/unidad) del equipo de cosecha: Vehículos
        VariablesModuloSiete.COSTEQCOCU	= COSTEQCOCU;//	Costo por unidad ($/unidad) del equipo de cosecha: Cuarto de extraccion


        VariablesModuloSiete.EXTMIEL	= EXTMIEL;//	¿Cómo realiza la extracción de la miel?
        VariablesModuloSiete.NJOREM	= NJOREM;//	Número de jornales utilizados
        VariablesModuloSiete.COSJOREM	= COSJOREM;//	Costo del jornal ($)
        VariablesModuloSiete.EQUEM	= EQUEM;//	Propio / Rentado
        VariablesModuloSiete.COSTEM	= COSTEM;//	Costo ($)

        VariablesModuloSiete.PROCERA	= PROCERA;//	¿Cómo procesa la cera?
    }

    public void mesCosechaMiela(View view) {
        boolean checkedTipo = ((CheckBox) view).isChecked();

        switch (view.getId()) {
            case R.id.ck_ms_api_7_2_1:
                if (checkedTipo) {
                    mesSelecct.add("Enero");
                } else {
                    mesSelecct.remove("Enero");
                }
                break;
            case R.id.ck_ms_api_7_2_2:
                if (checkedTipo) {
                    mesSelecct.add("Febrero");
                } else {
                    mesSelecct.remove("Febrero");
                }
                break;
            case R.id.ck_ms_api_7_2_3:
                if (checkedTipo) {
                    mesSelecct.add("Marzo");
                } else {
                    mesSelecct.remove("Marzo");
                }
                break;
            case R.id.ck_ms_api_7_2_4:
                if (checkedTipo) {
                    mesSelecct.add("Abril");
                } else {
                    mesSelecct.remove("Abril");
                }
                break;
            case R.id.ck_ms_api_7_2_5:
                if (checkedTipo) {
                    mesSelecct.add("Mayo");
                } else {
                    mesSelecct.remove("Mayo");
                }
                break;
            case R.id.ck_ms_api_7_2_6:
                if (checkedTipo) {
                    mesSelecct.add("Junio");
                } else {
                    mesSelecct.remove("Junio");
                }
                break;
            case R.id.ck_ms_api_7_2_7:
                if (checkedTipo) {
                    mesSelecct.add("Julio");
                } else {
                    mesSelecct.remove("Julio");
                }
                break;
            case R.id.ck_ms_api_7_2_8:
                if (checkedTipo) {
                    mesSelecct.add("Agosto");
                } else {
                    mesSelecct.remove("Agosto");
                }
                break;
            case R.id.ck_ms_api_7_2_9:
                if (checkedTipo) {
                    mesSelecct.add("Septiembre");
                } else {
                    mesSelecct.remove("Septiembre");
                }
                break;
            case R.id.ck_ms_api_7_2_10:
                if (checkedTipo) {
                    mesSelecct.add("Octubre");
                } else {
                    mesSelecct.remove("Octubre");
                }
                break;
            case R.id.ck_ms_api_7_2_11:
                if (checkedTipo) {
                    mesSelecct.add("Noviembre");
                } else {
                    mesSelecct.remove("Noviembre");
                }
                break;
            case R.id.ck_ms_api_7_2_12:
                if (checkedTipo) {
                    mesSelecct.add("Diciembre");
                } else {
                    mesSelecct.remove("Diciembre");
                }
                break;
        }
    }

    public void extraccionMiel(View view) {
        boolean checkedTipo = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.radioCosecharealextracmielformaman:
                if (checkedTipo) {
                    EXTMIEL = "De forma manual";
                }
                break;
            case R.id.radioCosecharealextracmielformamec:
                if (checkedTipo) {
                    EXTMIEL = "De forma mecánica";
                }
                break;
            case R.id.radioCosecharealextracmielformaambos:
                if (checkedTipo) {
                    EXTMIEL = "Ambos";
                }
                break;
        }
    }

    public void tipoMiel(View view) {
        boolean checkedTipo = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.radioCosechasipropio:
                if (checkedTipo) {
                    EQUEM = "Propio";
                }
                break;
            case R.id.radioCosechasirentado:
                if (checkedTipo) {
                    EQUEM = "Rentado";
                }
                break;
        }
    }

    public void procesoCera(View view) {
        boolean checkedTipo = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.radioCosechaprocesocerafundsolares:
                if (checkedTipo) {
                    PROCERA = "Con fundidores solares";
                }
                break;
            case R.id.radioCosechaprocesocerafundvapor:
                if (checkedTipo) {
                    PROCERA = "Con fundidores a vapor";
                }
                break;
            case R.id.radioCosechaprocesocerafundelect:
                if (checkedTipo) {
                    PROCERA = "Con fundidores eléctricos";
                }
                break;
            case R.id.radioCosechaprocesoceraporconoc:
                if (checkedTipo) {
                    PROCERA = "Por cocimiento";
                }
                break;
        }
    }

    @Override
    public void onBackPressed() {

    }
}
