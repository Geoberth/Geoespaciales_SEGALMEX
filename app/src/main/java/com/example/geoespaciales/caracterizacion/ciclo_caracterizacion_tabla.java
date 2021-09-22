package com.example.geoespaciales.caracterizacion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.geoespaciales.R;
import com.example.geoespaciales.caracterizacion.variables_caracterizacion.VariablesModuloCuatro;
import com.example.geoespaciales.unidadcaracterizacionhortalizas.db.DatabaseHelper;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

public class ciclo_caracterizacion_tabla extends AppCompatActivity {
    ExtendedFloatingActionButton siguiente5;

    private String LABPRES= null;// IntegerActividad que realiza para la preparación del suelo
    private String NUMVL= null;// IntegerNúmero de veces
    private String EQUIPOL= null;// IntegerEquipo (propio/maquila)
    private String COSTOL= null;// IntegerCosto/ha
    private String NUMJORL= null;// IntegerNúm. de jornales

    TextView txtPrepaSuelo;
    EditText edtPrcNv;
    RadioButton rdPropio;
    RadioButton rdMaquila;
    EditText edtCostoAgr;
    EditText edtNoJorAgr;
    RadioGroup rgProMaq;

    Button btnOtroSuelo;
    private DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ciclo_caracterizacion_tabla);

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        db = new DatabaseHelper(this);
        siguiente5 = findViewById(R.id.btn_sig5);

        txtPrepaSuelo = findViewById(R.id.des_sue_agr);
        edtPrcNv = findViewById(R.id.precio_criop);
        rdPropio = findViewById(R.id.propio_agr);
        rdMaquila = findViewById(R.id.maquila_agr);
        edtCostoAgr = findViewById(R.id.costo_agr);
        edtNoJorAgr = findViewById(R.id.nojorna_agr);

        btnOtroSuelo = findViewById(R.id.btn_otr_prp_sue);
        rgProMaq = findViewById(R.id.rg_pro_maq);

        final Spinner spinner = (Spinner) findViewById(R.id.spn_prp_suelo);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.preparacion_suelo, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Log.e("========>>", parent.getSelectedItem().toString());
                String preparacionSuelo;
                preparacionSuelo = parent.getSelectedItem().toString();
                prepaSuelo(preparacionSuelo);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Log.e("========>>", parent.getSelectedItem().toString());
            }
        });


        btnOtroSuelo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                asignacionValores();
                if(LABPRES != null) {
                    aggPreparacionSuelo();
                    startActivity(new Intent(getApplicationContext(), ciclo_caracterizacion_tabla.class));
                }
            }
        });

        siguiente5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               asignacionValores();
                if(LABPRES != null) {
                    aggPreparacionSuelo();
                }
                startActivity(new Intent(getApplicationContext(), ciclo_caracterizacion5.class));
            }
        });

    }

    private void asignacionValores() {
        if(!edtPrcNv.getText().toString().isEmpty()){
            NUMVL = edtPrcNv.getText().toString();
        }

        if(!edtCostoAgr.getText().toString().isEmpty()){
            COSTOL = edtCostoAgr.getText().toString();
        }

        if(!edtNoJorAgr.getText().toString().isEmpty()){
            NUMJORL = edtNoJorAgr.getText().toString();
        }


        VariablesModuloCuatro.LABPRES = LABPRES;// IntegerActividad que realiza para la preparación del suelo
        VariablesModuloCuatro.NUMVL = NUMVL;// IntegerNúmero de veces
        VariablesModuloCuatro.EQUIPOL = EQUIPOL;// IntegerEquipo (propio/maquila)
        VariablesModuloCuatro.COSTOL = COSTOL;// IntegerCosto/ha
        VariablesModuloCuatro.NUMJORL = NUMJORL;// IntegerNúm. de jornales

    }

    private void aggPreparacionSuelo() {
        boolean insertarData = db.addPreparacionSueloAgri();
        if(insertarData == true) {
            Toast.makeText(this, "Datos insertados correctamente", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Algo salio mal", Toast.LENGTH_LONG).show();
        }
    }

    private void prepaSuelo(String preparacionSuelo) {
        switch (preparacionSuelo) {
            case "Especifique la preparacion de suelo":
                txtPrepaSuelo.setText("");
                LABPRES = null;
                edtPrcNv.setEnabled(false);
                rdPropio.setEnabled(false);
                rdMaquila.setEnabled(false);
                edtCostoAgr.setEnabled(false);
                edtNoJorAgr.setEnabled(false);
                edtPrcNv.setText("");
                rdPropio.setChecked(false);
                rdMaquila.setChecked(false);
                edtCostoAgr.setText("");
                edtNoJorAgr.setText("");


                break;
            default:
                txtPrepaSuelo.setText(preparacionSuelo);
                LABPRES = preparacionSuelo;
                edtPrcNv.setEnabled(true);
                rdPropio.setEnabled(true);
                rdMaquila.setEnabled(true);
                edtCostoAgr.setEnabled(true);
                edtNoJorAgr.setEnabled(true);

                edtPrcNv.setText("");
                rdPropio.setChecked(false);
                rdMaquila.setChecked(false);
                edtCostoAgr.setText("");
                edtNoJorAgr.setText("");

                Log.e("========>>", preparacionSuelo);
                break;
        }
    }

    public void tipoEquipoAgr(View view) {
        boolean checkedTipo = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.propio_agr:
                if (checkedTipo) {
                    EQUIPOL = "Propio";
                }
                break;
            case R.id.maquila_agr:
                if (checkedTipo) {
                    EQUIPOL = "Maquila";
                }
                break;
        }
    }

    @Override
    public void onBackPressed() {

    }
}
