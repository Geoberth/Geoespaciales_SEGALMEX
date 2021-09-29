package com.example.geosegalmex;

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
import android.widget.Toast;

import com.example.geosegalmex.unidadcaracterizacionhortalizas.db.DatabaseHelper;
import com.example.geosegalmex.unidadcomercializacion.bdcomercializacion.VariablesGlobalesCmrz;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

public class infraestructura_1 extends AppCompatActivity {

    private String INMAEQUPF = null;
    private String INMAEQOTR = null;
    private String CAINMAEQ = null;
    private String CONINMAEQ = null;
    private String PROINMAEQ = null;
    private String COSTUNIME = null;

    EditText edt1;
    EditText edt2;
    EditText edt3;

    ExtendedFloatingActionButton siguienteinfra;
    Button btnOtro;

    private DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_infraestructura_1);

        db = new DatabaseHelper(this);

        siguienteinfra = findViewById(R.id.sig_infra);
        edt1 = findViewById(R.id.edt_inr_otr);
        edt2 = findViewById(R.id.edt_inf_can);
        edt3 = findViewById(R.id.edt_inf_cst);

        btnOtro = findViewById(R.id.btn_otr_inf);

        final Spinner spinner = (Spinner) findViewById(R.id.spn_inf_9);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.infraestructura, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Log.e("========>>", parent.getSelectedItem().toString());
                String infraest = null;
                infraest = parent.getSelectedItem().toString();

                valorSeleccion(position, infraest);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {


            }
        });

        final Spinner spinner2 = (Spinner) findViewById(R.id.spn_inf_9_2);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,
                R.array.infraestructura_condicion, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter2);
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Log.e("========>>", parent.getSelectedItem().toString());
                //  String condicion = null;
                //  condicion = parent.getSelectedItem().toString();
                CONINMAEQ = parent.getSelectedItem().toString();

                //valorSeleccionCondicion(position, condicion);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {


            }
        });


        btnOtro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                asignacionValores();
                if(INMAEQUPF != null) {
                    aggInfraestructura();
                    startActivity(new Intent(getApplicationContext(), infraestructura_1.class));
                }

            }
        });

        siguienteinfra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                asignacionValores();
                if(INMAEQUPF != null) {
                    aggInfraestructura();
                }
                startActivity(new Intent(getApplicationContext(), IdentificacionCuestionario.class));
            }
        });

    }

    private void aggInfraestructura() {
        boolean insertarData = db.addDatosInfraestructura();
        if (insertarData == true) {
            Toast.makeText(this, "Datos insertados correctamente", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Algo salio mal", Toast.LENGTH_LONG).show();
        }
    }

    private void asignacionValores() {
        if (!edt1.getText().toString().isEmpty()) {
            INMAEQOTR = edt1.getText().toString();
        }

        if (!edt2.getText().toString().isEmpty()) {
            CAINMAEQ = edt2.getText().toString();
        }

        if (!edt3.getText().toString().isEmpty()) {
            COSTUNIME = edt3.getText().toString();
        }

        VariablesGlobalesCmrz.INMAEQUPF = INMAEQUPF;
        VariablesGlobalesCmrz.INMAEQOTR = INMAEQOTR;
        VariablesGlobalesCmrz.CAINMAEQ = CAINMAEQ;
        VariablesGlobalesCmrz.CONINMAEQ = CONINMAEQ;
        VariablesGlobalesCmrz.PROINMAEQ = PROINMAEQ;
        VariablesGlobalesCmrz.COSTUNIME = COSTUNIME;
    }

    private void valorSeleccion(int position, String inmaequpf) {
        if (position == 0) {
            INMAEQUPF = null;
            edt1.setText("");
            edt1.setEnabled(false);
        } else if (position != 0 && position < 47) {
            INMAEQUPF = inmaequpf;
            edt1.setText("");
            edt1.setEnabled(false);
        } else if (position == 47) {
            INMAEQUPF = inmaequpf;
            edt1.setEnabled(true);
        }
    }

    public void tipoInfrestructura9(View view) {
        boolean checkedTipo = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.rd_inf_par:
                if (checkedTipo) {
                    PROINMAEQ = "Particular";
                }
                break;
            case R.id.rd_inf_cmn:
                if (checkedTipo) {
                    PROINMAEQ = "Comunitaria";
                }
                break;
        }
    }
}
