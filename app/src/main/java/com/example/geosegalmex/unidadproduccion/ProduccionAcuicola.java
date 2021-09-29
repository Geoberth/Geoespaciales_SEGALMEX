package com.example.geosegalmex.unidadproduccion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.geosegalmex.R;
import com.example.geosegalmex.unidadcaracterizacionhortalizas.db.DatabaseHelper;
import com.example.geosegalmex.unidadproduccion.variables.VariablesGlobalesUpf;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

public class ProduccionAcuicola extends AppCompatActivity {


    LinearLayout lnOtroAcuicola;
    ExtendedFloatingActionButton fabProAcui;
    Button btnActAcui;
    EditText superfiPeces;
    EditText estanquePeces;
    EditText volPeces;
    EditText superPesca;
    EditText estanqPesca;
    EditText volPesca;

    private	String	ESPECIEPECui = null;
    private	String	OTRACTIAC = null;
    private String	SUPACAC = null;
    private String	ACUNE = null;
    private String	ACUVT = null;

    TextView txtActividad;
    TextView txtNomActividad;
    EditText edtOtro;
    private DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produccion_acuicola);

        db         = new DatabaseHelper(this);
        lnOtroAcuicola  = findViewById(R.id.ln_otro_acuicola);


        txtNomActividad = findViewById(R.id.ck_otro);
        txtActividad = findViewById(R.id.txt_otr_act_acui);
        edtOtro = findViewById(R.id.actividad_otro);

        fabProAcui = findViewById(R.id.fab_next_pro_acuic);


        superfiPeces    = findViewById(R.id.superficie_otro);
        estanquePeces   = findViewById(R.id.stanques_otro);
        volPeces        = findViewById(R.id.volumen_otro);



        btnActAcui = findViewById(R.id.btn_pr_acui);

        final Spinner spinner = (Spinner) findViewById(R.id.spin_pro_acui);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.produccioacuicola, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Log.e("========>>", parent.getSelectedItem().toString());
                ESPECIEPECui = parent.getSelectedItem().toString();

                valdiFunAcuicola(ESPECIEPECui);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btnActAcui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inserAcuicola(ESPECIEPECui);
                startActivity(new Intent(getApplication(), ProduccionAcuicola.class));
            }
        });

        fabProAcui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ESPECIEPECui != null) {
                    inserAcuicola(ESPECIEPECui);
                }
                startActivity(new Intent(getApplication(), TiposAlimentos.class));

            }
        });

    }

    private void inserAcuicola(String especiepeCui) {
        switch (especiepeCui) {
            case "Especifique produccion acuicola":
                superfiPeces.setEnabled(false);
                estanquePeces.setEnabled(false);
                volPeces.setEnabled(false);
                cleanInfo();
                break;
            case "Otro":
                OTRACTIAC = edtOtro.getText().toString();
                SUPACAC = superfiPeces.getText().toString();
                ACUNE = estanquePeces.getText().toString();
                ACUVT= volPeces.getText().toString();

                VariablesGlobalesUpf.ESPECIEPECui = ESPECIEPECui ;
                VariablesGlobalesUpf.OTRACTIAC = OTRACTIAC;
                VariablesGlobalesUpf.SUPACAC = SUPACAC;
                VariablesGlobalesUpf.ACUNE = ACUNE;
                VariablesGlobalesUpf.ACUVT = ACUVT;
                aggActAcuicola();
                break;
            case "Cria de Peces":
                SUPACAC = superfiPeces.getText().toString();
                ACUNE = estanquePeces.getText().toString();
                ACUVT= volPeces.getText().toString();
                VariablesGlobalesUpf.ESPECIEPECui = "Cria de Peces";
                VariablesGlobalesUpf.OTRACTIAC = null;
                VariablesGlobalesUpf.SUPACAC = SUPACAC;
                VariablesGlobalesUpf.ACUNE = ACUNE;
                VariablesGlobalesUpf.ACUVT = ACUVT;
                aggActAcuicola();
                break;
            case "Pesca":
                SUPACAC = superfiPeces.getText().toString();
                ACUNE = estanquePeces.getText().toString();
                ACUVT= volPeces.getText().toString();
                VariablesGlobalesUpf.ESPECIEPECui = "Pesca";
                VariablesGlobalesUpf.OTRACTIAC = null;
                VariablesGlobalesUpf.SUPACAC = SUPACAC;
                VariablesGlobalesUpf.ACUNE = ACUNE;
                VariablesGlobalesUpf.ACUVT = ACUVT;
                aggActAcuicola();
                break;
        }
    }

    private void aggActAcuicola() {
        boolean insertarData = db.addAcuicola();
        if(insertarData == true) {
            Toast.makeText(this, "Datos insertados correctamente", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Algo salio mal", Toast.LENGTH_LONG).show();
        }
    }

    private void valdiFunAcuicola(String especiepeCui) {
        switch (especiepeCui) {
            case "Especifique produccion acuicola":
                txtNomActividad.setText("Especificar");
                ESPECIEPECui = null;
                btnActAcui.setEnabled(false);
                superfiPeces.setEnabled(false);
                estanquePeces.setEnabled(false);
                volPeces.setEnabled(false);
                cleanInfo();
                break;
            case "Otro":
                superfiPeces.setEnabled(true);
                estanquePeces.setEnabled(true);
                volPeces.setEnabled(true);
                txtNomActividad.setText("Especificar");
                //FDAGUA = null;
                txtActividad.setVisibility(View.VISIBLE);
                edtOtro.setVisibility(View.VISIBLE);
                btnActAcui.setEnabled(true);
                cleanInfo();
                break;
            case "Cria de Peces":
                superfiPeces.setEnabled(true);
                estanquePeces.setEnabled(true);
                volPeces.setEnabled(true);
                txtNomActividad.setText(especiepeCui);
                txtActividad.setVisibility(View.INVISIBLE);
                edtOtro.setVisibility(View.INVISIBLE);
                btnActAcui.setEnabled(true);
                cleanInfo();
                break;
            case "Pesca":
                superfiPeces.setEnabled(true);
                estanquePeces.setEnabled(true);
                volPeces.setEnabled(true);
                txtNomActividad.setText(especiepeCui);
                txtActividad.setVisibility(View.INVISIBLE);
                edtOtro.setVisibility(View.INVISIBLE);
                btnActAcui.setEnabled(true);
                cleanInfo();
                break;
        }
    }

    private void cleanInfo() {
        //  private	String	ESPECIEPECui = null;
        OTRACTIAC = null;
        SUPACAC = null;
        ACUNE = null;
        ACUVT = null;
    }



    @Override
    public void onBackPressed() {

    }
}
