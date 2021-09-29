package com.example.geosegalmex.apicola;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import com.example.geosegalmex.R;
import com.example.geosegalmex.apicola.variables_apicola.VariablesModuloSiete;

public class ApicolaInicio extends AppCompatActivity {

    //APICOLA 1
    Button btnApicolainicio;
    EditText edt1;
    EditText edt2;
    EditText edt3;


    private String	APIPER = null;//	¿Con cuantas personas trabajó la actividad de apicultura el año pasado?
    private String	APIACT = null;//	Apicultura
    private String	APIAYU = null;//	¿Quién lo ayudó para qué se integrará al grupo para realizar la actividad apícola?
    private String	APIAYUO = null;//	Otro (especifique)
    private String	APIFIGJ = null;//	¿Contaba con alguna figura jurídica el grupo al qué perteneció el año pasado?
    private String	APIFIGJG = null;//	¿Qué tipo de figura jurídica tenía el grupo?
    private String	APIFIGJGO = null;//	Otro (especifique)


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apicola_inicio);

        btnApicolainicio = (Button)findViewById(R.id.apicola_next_inicio);

        edt1 = findViewById(R.id.edtCantactividadapi);
        edt2 = findViewById(R.id.edtOtraayudaespec);
        edt3 = findViewById(R.id.edtFigjurotro);

        btnApicolainicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                asignacionVariables();
                startActivity(new Intent(ApicolaInicio.this, ManejoApicola.class));
            }
        });
    }

    private void asignacionVariables() {

        if(!edt1.getText().toString().isEmpty()){
            APIPER = edt1.getText().toString();
        }

        if(!edt2.getText().toString().isEmpty()){
            APIAYUO = edt2.getText().toString();
        }

        if(!edt3.getText().toString().isEmpty()){
            APIFIGJGO = edt3.getText().toString();
        }

        VariablesModuloSiete.APIPER = APIPER;//	¿Con cuantas personas trabajó la actividad de apicultura el año pasado?
        VariablesModuloSiete.APIACT = APIACT;//	Apicultura
        VariablesModuloSiete.APIAYU = APIAYU;//	¿Quién lo ayudó para qué se integrará al grupo para realizar la actividad apícola?
        VariablesModuloSiete.APIAYUO = APIAYUO;//	Otro (especifique)
        VariablesModuloSiete.APIFIGJ = APIFIGJ;//	¿Contaba con alguna figura jurídica el grupo al qué perteneció el año pasado?
        VariablesModuloSiete.APIFIGJG = APIFIGJG;//	¿Qué tipo de figura jurídica tenía el grupo?
        VariablesModuloSiete.APIFIGJGO = APIFIGJGO;//	Otro (especifique)
    }

    public void actividadApicultura(View view) {
        boolean checkedTipo = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.radioapindividual:
                if (checkedTipo) {
                    APIACT = "Individual";
                }
                break;
            case R.id.radioapifamilia:
                if (checkedTipo) {
                    APIACT = "Familiar";
                }
                break;
            case R.id.radioapisociedad:
                if (checkedTipo) {
                    APIACT = "En sociedad con otras personas";
                }
                break;
        }

    }

    public void ayudaApicola(View view) {
        boolean checkedTipo = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.radiotecnpretserv:
                if (checkedTipo) {
                    APIAYU = "Técnicos prestadores de servicio";
                    edt2.setEnabled(false);
                    edt2.setText("");
                }
                break;
            case R.id.radioautmunic:
                if (checkedTipo) {
                    APIAYU = "Autoridades municipales";
                    edt2.setEnabled(false);
                    edt2.setText("");
                }
                break;
            case R.id.radioinstgub:
                if (checkedTipo) {
                    APIAYU = "Instituciones gubernamentales";
                    edt2.setEnabled(false);
                    edt2.setText("");
                }
                break;
            case R.id.radioapiotroayuda:
                if (checkedTipo) {
                    APIAYU = "Otros";
                    edt2.setEnabled(true);
                }
                break;
        }
    }

    public void figuraJuridica(View view) {
        boolean checkedTipo = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.radiofigjursi:
                if (checkedTipo) {
                    APIFIGJ = "Si";
                }
                break;
            case R.id.radiofigjurno:
                if (checkedTipo) {
                    APIFIGJ = "No";
                }
                break;
        }

    }

    public void tipoJuridica(View view) {
        boolean checkedTipo = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.radioFigjurasociacion:
                if (checkedTipo) {
                    APIFIGJG = "Asociación civil";
                    edt3.setEnabled(false);
                }
                break;
            case R.id.radioFigjurunionejido:
                if (checkedTipo) {
                    APIFIGJG = "Unión de ejido";
                    edt3.setEnabled(false);
                }
                break;
            case R.id.radioFigjurunioncoope:
                if (checkedTipo) {
                    APIFIGJG = "Unidad Cooperativa";
                    edt3.setEnabled(false);
                }
                break;
            case R.id.radioFigjursocproduccion:
                if (checkedTipo) {
                    APIFIGJG = "Sociedad de producción rural";
                    edt3.setEnabled(false);
                }
                break;
            case R.id.radioFigjursocsolidsoc:
                if (checkedTipo) {
                    APIFIGJG = "Sociedad de Solidaridad Social (SSS)";
                    edt3.setEnabled(false);
                }
                break;
            case R.id.radioFigjurotro:
                if (checkedTipo) {
                    APIFIGJG = "Otro ";
                    edt3.setEnabled(true);
                }
                break;
        }
    }

    @Override
    public void onBackPressed() {

    }
}
