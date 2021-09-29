package com.example.geosegalmex.frutales;

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
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.geosegalmex.R;
import com.example.geosegalmex.frutales.dbfrutales.VariablesFrutales;
import com.example.geosegalmex.unidadcaracterizacionhortalizas.db.DatabaseHelper;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

public class frutales_3 extends AppCompatActivity {
    ExtendedFloatingActionButton f3;
    Button btnOtro;

    private String LABPRES = null;// IntegerActividad que realiza para la preparación del suelo
    private String NUMVL = null;// IntegerNúmero de veces
    private String EQUIPOL = null;// IntegerEquipo (propio/maquila)
    private String COSTOL = null;// IntegerCosto/ha
    private String NUMJORL = null;// IntegerNúm. de jornales

    TextView txtPrepaSuelo;
    EditText edtPrcNv;
    RadioButton rdPropio;
    RadioButton rdMaquila;
    EditText edtCostoAgr;
    EditText edtNoJorAgr;
    RadioGroup rgProMaq;

    private DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frutales_3);
        db         = new DatabaseHelper(this);
        f3 = findViewById(R.id.btn_next_frt);
        btnOtro = findViewById(R.id.btn_next_frt_otr);

        txtPrepaSuelo = findViewById(R.id.des_sue_agr_frt);
        edtPrcNv = findViewById(R.id.precio_criop_frt);
        rdPropio = findViewById(R.id.propio_agr_frt);
        rdMaquila = findViewById(R.id.maquila_agr_frt);
        edtCostoAgr = findViewById(R.id.costo_agr_frt);
        edtNoJorAgr = findViewById(R.id.nojorna_agr_frt);


        rgProMaq = findViewById(R.id.rg_pro_maq_frt);

        final Spinner spinner = (Spinner) findViewById(R.id.spn_prp_suelo_frt);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.preparacion_suelo_frutales, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Log.e("========>>", parent.getSelectedItem().toString());
                String preparacionSuelo;
                preparacionSuelo = parent.getSelectedItem().toString();
                prepaSueloFtr(preparacionSuelo);
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
                impresion();
                if (LABPRES != null) {
                    aggPreparacionSuelo();
                    startActivity(new Intent(getApplicationContext(), frutales_3.class));
                }

            }
        });

        f3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                asignacionValores();
                impresion();
                if (LABPRES != null) {
                    aggPreparacionSuelo();
                }
                startActivity(new Intent(getApplicationContext(), frutales_4_0.class));
            }
        });

    }

    private void aggPreparacionSuelo() {
        boolean insertarData = db.addDatosFrutalesSuelo();
        if(insertarData == true) {
            Toast.makeText(this, "Datos insertados correctamente", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Algo salio mal", Toast.LENGTH_LONG).show();
        }
    }

    private void impresion() {
        System.out.println(LABPRES);// IntegerActividad que realiza para la preparación del suelo
        System.out.println(NUMVL);// IntegerNúmero de veces
        System.out.println(EQUIPOL);// IntegerEquipo (propio/maquila)
        System.out.println(COSTOL);// IntegerCosto/ha
        System.out.println(NUMJORL);// IntegerNúm. de jornales
    }

    private void asignacionValores() {

        if (!edtPrcNv.getText().toString().isEmpty()) {
            NUMVL = edtPrcNv.getText().toString();
        }

        if (!edtCostoAgr.getText().toString().isEmpty()) {
            COSTOL = edtCostoAgr.getText().toString();
        }

        if (!edtNoJorAgr.getText().toString().isEmpty()) {
            NUMJORL = edtNoJorAgr.getText().toString();
        }


        VariablesFrutales.LABPRESFRT = LABPRES;// IntegerActividad que realiza para la preparación del suelo
        VariablesFrutales.NUMVLFRT = NUMVL;// IntegerNúmero de veces
        VariablesFrutales.EQUIPOLFRT = EQUIPOL;// IntegerEquipo (propio/maquila)
        VariablesFrutales.COSTOLFRT = COSTOL;// IntegerCosto/ha
        VariablesFrutales.NUMJORLFRT = NUMJORL;// IntegerNúm. de jornales

    }

    private void prepaSueloFtr(String preparacionSuelo) {
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

    public void tipoEquipoAgrfrt(View view) {
        boolean checkedTipo = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.propio_agr_frt:
                if (checkedTipo) {
                    EQUIPOL = "Propio";
                }
                break;
            case R.id.maquila_agr_frt:
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
