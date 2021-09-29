package com.example.geosegalmex.apicola;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;

import com.example.geosegalmex.R;
import com.example.geosegalmex.apicola.variables_apicola.VariablesModuloSiete;

public class ManejoApicola extends AppCompatActivity {
    Button btnApicolamanejo;
    //APICOLA 2

    private String APINUMCOL = null;//	¿Actualmente cuántas colonias tiene?
    private String APINUMAPI = null;//	¿Actualmente cuántos apiarios tiene?
    private String APILURA = null;//	¿Ha cambiado de lugar su (s) apiario(s)?
    private String APIMOTLUG = null;//	¿Usted por qué cambia de lugar su(s) apiario(s)?
    private String APIMOTLUGO = null;//	Otro (especifique)
    private String APIFRECCO = null;//	¿Cada cuándo revisa sus colonias?
    private String APICAMPAN = null;//	¿Cambia sus panales?
    private String APIFRECPAN = null;//	¿Cada cuánto tiempo cambia sus panales?
    private String APICONCOL = null;//	¿Cómo son las condiciones dónde se ubican sus colmenas?
    private String OTCOCOLAPI = null;//	Otro

    EditText edt1;
    EditText edt2;
    EditText edt3;
    EditText edt4;
    EditText edt5;
    EditText edt6;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manejo_apicola);


        btnApicolamanejo = (Button) findViewById(R.id.apicola_next_manejo);

        edt1 = findViewById(R.id.edtApicantcolonias);
        edt2 = findViewById(R.id.edtApicantapiarios);
        edt3 = findViewById(R.id.edtApicambdestapiariotro);
        edt4 = findViewById(R.id.edtApitiemporevcolon);
        edt5 = findViewById(R.id.edtApitiempocambpan);
        edt6 = findViewById(R.id.edtcondcotro);

        final Spinner spinnerDos = (Spinner) findViewById(R.id.idSpincondcolmenas);
        ArrayAdapter<CharSequence> adapterDos = ArrayAdapter.createFromResource(this,
                R.array.condicion_colmenas, android.R.layout.simple_spinner_item);
        adapterDos.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerDos.setAdapter(adapterDos);
        spinnerDos.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Log.e("========>>", parent.getSelectedItem().toString());
                String causaSiniestro;
                causaSiniestro = parent.getSelectedItem().toString();


                condicionColmenas(causaSiniestro, position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Log.e("========>>", parent.getSelectedItem().toString());
            }
        });


        btnApicolamanejo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                asignacionValores();
                //startActivity(new Intent(ManejoApicola.this, CapacitacionAsistenciaApicola.class));
                startActivity(new Intent(ManejoApicola.this, HerramientasProteccion.class));
            }
        });
    }



    private void asignacionValores() {
        if (!edt1.getText().toString().isEmpty()) {
            APINUMCOL = edt1.getText().toString();
        }

        if (!edt2.getText().toString().isEmpty()) {
            APINUMAPI = edt2.getText().toString();
        }

        if (!edt3.getText().toString().isEmpty()) {
            APIMOTLUGO = edt3.getText().toString();
        }

        if (!edt4.getText().toString().isEmpty()) {
            APIFRECCO = edt4.getText().toString();
        }

        if (!edt5.getText().toString().isEmpty()) {
            APIFRECPAN = edt5.getText().toString();
        }

        if (!edt6.getText().toString().isEmpty()) {
            OTCOCOLAPI = edt6.getText().toString();
        }


        VariablesModuloSiete.APINUMCOL = APINUMCOL;//	¿Actualmente cuántas colonias tiene?
        VariablesModuloSiete.APINUMAPI = APINUMAPI;//	¿Actualmente cuántos apiarios tiene?
        VariablesModuloSiete.APILURA = APILURA;//	¿Ha cambiado de lugar su (s) apiario(s)?
        VariablesModuloSiete.APIMOTLUG = APIMOTLUG;//	¿Usted por qué cambia de lugar su(s) apiario(s)?
        VariablesModuloSiete.APIMOTLUGO = APIMOTLUGO;//	Otro (especifique)
        VariablesModuloSiete.APIFRECCO = APIFRECCO;//	¿Cada cuándo revisa sus colonias?
        VariablesModuloSiete.APICAMPAN = APICAMPAN;//	¿Cambia sus panales?
        VariablesModuloSiete.APIFRECPAN = APIFRECPAN;//	¿Cada cuánto tiempo cambia sus panales?
        VariablesModuloSiete.APICONCOL = APICONCOL;//	¿Cómo son las condiciones dónde se ubican sus colmenas?
        VariablesModuloSiete.OTCOCOLAPI = OTCOCOLAPI;//	Otro

    }

    private void condicionColmenas(String causaSiniestro, int position) {
        if (position == 0) {
            APICONCOL = null;
            edt6.setEnabled(false);
            edt6.setText("");
        } else if (position != 0 && position < 6) {
            APICONCOL = causaSiniestro;
            edt6.setEnabled(false);
            edt6.setText("");
        } else if (position == 6) {
            APICONCOL = causaSiniestro;
            edt6.setEnabled(true);
        }
    }

    public void cambioApiarios(View view) {
        boolean checkedTipo = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.radioApisicambdest:
                if (checkedTipo) {
                    APILURA = "Si";
                }
                break;
            case R.id.radioApinocambdest:
                if (checkedTipo) {
                    APILURA = "No";
                }
                break;
        }
    }

    public void motivoCambioApiario(View view) {
        boolean checkedTipo = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.radioApicambdestprod:
                if (checkedTipo) {
                    APIMOTLUG = "Productividad";
                    edt3.setEnabled(false);
                    edt3.setText("");
                }
                break;
            case R.id.radioApicambdestfactclim:
                if (checkedTipo) {
                    APIMOTLUG = "Factores climatológicos";
                    edt3.setEnabled(false);
                    edt3.setText("");
                }
                break;
            case R.id.radioApicambdestservpol:
                if (checkedTipo) {
                    APIMOTLUG = "Servicio de polinización";
                    edt3.setEnabled(false);
                    edt3.setText("");
                }
                break;
            case R.id.radioApicambdestotro:
                if (checkedTipo) {
                    APIMOTLUG = "Otro";
                    edt3.setEnabled(true);
                }
                break;
        }
    }

    public void cambioPaneles(View view) {
        boolean checkedTipo = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.radioApisicambpan:
                if (checkedTipo) {
                    APICAMPAN = "Si";
                }
                break;
            case R.id.radioApinocambpan:
                if (checkedTipo) {
                    APICAMPAN = "No";
                }
                break;
        }
    }

    @Override
    public void onBackPressed() {

    }
}
