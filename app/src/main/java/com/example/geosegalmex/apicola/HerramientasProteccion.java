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
import android.widget.Spinner;
import android.widget.Toast;

import com.example.geosegalmex.R;
import com.example.geosegalmex.apicola.variables_apicola.VariablesModuloSiete;
import com.example.geosegalmex.unidadcaracterizacionhortalizas.db.DatabaseHelper;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

public class HerramientasProteccion extends AppCompatActivity {
    ExtendedFloatingActionButton btnNext;
    Button btnOtro;

    EditText edt1;
    EditText edt2;
    EditText edt3;

    private String APIHEREQUI = null;
    private String APIHEREQO = null;
    private String APITIEM = null;
    private String APICOST = null;

    private DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_herramientas_proteccion);

        btnNext = findViewById(R.id.apicola_next_eqi_hr);
        btnOtro = findViewById(R.id.btn_add_otr_eqi_api);
        edt1 = findViewById(R.id.edt_tmp_api_hr_1);
        edt2 = findViewById(R.id.edt_tmp_api_hr_2);
        edt3 = findViewById(R.id.edt_tmp_api_hr_3);

        db  = new DatabaseHelper(this);
        final Spinner spinnerDos = (Spinner) findViewById(R.id.spn_herr_api);
        ArrayAdapter<CharSequence> adapterDos = ArrayAdapter.createFromResource(this,
                R.array.proteccion_apicola, android.R.layout.simple_spinner_item);
        adapterDos.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerDos.setAdapter(adapterDos);
        spinnerDos.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Log.e("========>>", parent.getSelectedItem().toString());
                String herramientas;
                herramientas = parent.getSelectedItem().toString();


                condicionHerramientas(herramientas, position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Log.e("========>>", parent.getSelectedItem().toString());
            }
        });


        btnOtro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                asignacionValores();
                aggHerramientas();
                startActivity(new Intent(getBaseContext(), HerramientasProteccion.class));
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                asignacionValores();
                aggHerramientas();
                startActivity(new Intent(getBaseContext(), CapacitacionAsistenciaApicola.class));
            }
        });
    }

    private void aggHerramientas() {
        boolean insertarData = db.addDatosHerramientas();
        if(insertarData == true) {
            Toast.makeText(this, "Datos insertados correctamente", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Algo salio mal", Toast.LENGTH_LONG).show();
        }
    }

    private void asignacionValores() {
        if(!edt1.getText().toString().isEmpty()){
            APIHEREQO = edt1.getText().toString();
        }

        if(!edt2.getText().toString().isEmpty()){
            APITIEM = edt2.getText().toString();
        }

        if(!edt3.getText().toString().isEmpty()){
            APICOST = edt3.getText().toString();
        }

        VariablesModuloSiete.APIHEREQUI =APIHEREQUI;
        VariablesModuloSiete.APIHEREQO =APIHEREQO;
        VariablesModuloSiete.APITIEM =APITIEM;
        VariablesModuloSiete.APICOST =APICOST;
    }

    private void condicionHerramientas(String herramientas, int position) {
        if (position == 0) {
            APIHEREQUI = null;
            edt1.setEnabled(false);
            edt1.setText("");
            edt2.setEnabled(false);
            edt2.setText("");
            edt3.setEnabled(false);
            edt3.setText("");
        } else if (position != 0 && position < 15) {
            APIHEREQUI = herramientas;
            edt1.setEnabled(false);
            edt1.setText("");
            edt2.setEnabled(true);
            edt2.setText("");
            edt3.setEnabled(true);
            edt3.setText("");
        } else if (position == 15) {
            APIHEREQUI = herramientas;
            edt1.setEnabled(true);
            edt2.setEnabled(true);
            edt2.setText("");
            edt3.setEnabled(true);
            edt3.setText("");
        }
    }

    @Override
    public void onBackPressed() {

    }
}
