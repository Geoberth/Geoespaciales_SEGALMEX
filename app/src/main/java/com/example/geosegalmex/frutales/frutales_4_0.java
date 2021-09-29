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

public class frutales_4_0 extends AppCompatActivity {
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
        setContentView(R.layout.activity_frutales_4_0);

        db         = new DatabaseHelper(this);

        f3 = findViewById(R.id.btn_next_frt_dsp);
        btnOtro = findViewById(R.id.btn_next_frt_otr_dsp);

        txtPrepaSuelo = findViewById(R.id.des_sue_agr_frt_dsp);
        edtPrcNv = findViewById(R.id.precio_criop_frt_dsp);
        rdPropio = findViewById(R.id.propio_agr_frt_dsp);
        rdMaquila = findViewById(R.id.maquila_agr_frt_dsp);
        edtCostoAgr = findViewById(R.id.costo_agr_frt_dsp);
        edtNoJorAgr = findViewById(R.id.nojorna_agr_frt_dsp);


        rgProMaq = findViewById(R.id.rg_pro_maq_frt_dsp);

        final Spinner spinner = (Spinner) findViewById(R.id.spn_prp_suelo_frt_dsp);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.preparacion_suelo_post_frutales, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Log.e("========>>", parent.getSelectedItem().toString());
                String preparacionSuelo;
                preparacionSuelo = parent.getSelectedItem().toString();
                prepaSueloFtrPost(preparacionSuelo, position);
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
                    aggPreparacionSueloDsp();
                    startActivity(new Intent(getApplicationContext(), frutales_4_0.class));
                }

            }
        });

        f3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                asignacionValores();
                if (LABPRES != null) {
                    aggPreparacionSueloDsp();
                }
                startActivity(new Intent(getApplicationContext(), frutales_4.class));
            }
        });
    }

    private void aggPreparacionSueloDsp() {
        boolean insertarData = db.addDatosFrutalesSueloDsp();
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


        VariablesFrutales.LABPRESFRTDSP = LABPRES;// IntegerActividad que realiza para la preparación del suelo
        VariablesFrutales.NUMVLFRTDSP = NUMVL;// IntegerNúmero de veces
        VariablesFrutales.EQUIPOLFRTDSP = EQUIPOL;// IntegerEquipo (propio/maquila)
        VariablesFrutales.COSTOLFRTDSP = COSTOL;// IntegerCosto/ha
        VariablesFrutales.NUMJORLFRTDSP = NUMJORL;// IntegerNúm. de jornales

    }

    private void prepaSueloFtrPost(String preparacionSuelo, int position) {
        switch (position) {
            case 0:
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


    public void tipoEquipoAgrfrtdsp(View view) {
        boolean checkedTipo = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.propio_agr_frt_dsp:
                if (checkedTipo) {
                    EQUIPOL = "Propio";
                }
                break;
            case R.id.maquila_agr_frt_dsp:
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
