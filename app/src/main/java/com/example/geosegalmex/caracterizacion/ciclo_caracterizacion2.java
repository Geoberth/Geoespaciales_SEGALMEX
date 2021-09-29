package com.example.geosegalmex.caracterizacion;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;

import com.example.geosegalmex.R;
import com.example.geosegalmex.caracterizacion.variables_caracterizacion.DatePickerFragment;
import com.example.geosegalmex.caracterizacion.variables_caracterizacion.VariablesModuloCuatro;
import com.example.geosegalmex.unidadcaracterizacionhortalizas.db.DatabaseHelper;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

public class ciclo_caracterizacion2 extends AppCompatActivity {
    ExtendedFloatingActionButton siguiente2;

    // EditText fecha_carac, semha_carac, mecha_carac;

    String txtfecha_carac;
    String txtsemha_carac;
    String txtmecha_carac;

    private String FECHASIEM = null;
    private String SUPSEM = null;//
    private String SUPMEC = null;//
    private String SUPNOMEC = null;
    private String SUPSINI = null;
    private String CASUPSI = null;
    private String ASOC = null;
    private String ASOCUL = null;
    private String FESIEASO = null;

    private DatabaseHelper db;

    EditText edtFecha;
    EditText edtSup1;
    EditText edtSup2;
    EditText edtSup3;
    EditText edtSup4;

    EditText edtSup5;
    EditText edtFechaAsoci;

    int valorFecha = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ciclo_caracterizacion2);

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

        edtFecha = findViewById(R.id.fecha_siembra);
        edtSup1 = findViewById(R.id.ha_sembrada);
        edtSup2 = findViewById(R.id.ha_meca);
        edtSup3 = findViewById(R.id.ha_nomeca);
        edtSup4 = findViewById(R.id.ha_sinies);
        edtSup5 = findViewById(R.id.otro_cultivo);
        edtFechaAsoci = findViewById(R.id.fecha_otro_cultivo);
        siguiente2 = findViewById(R.id.btn_sig2);


        db = new DatabaseHelper(this);


        edtFecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valorFecha = 1;
                showDatePickerDialog(edtFecha);
                //startActivity(new Intent(getBaseContext(), CalendarioDate.class));
            }
        });


        edtFechaAsoci.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valorFecha = 2;
                showDatePickerDialog(edtFechaAsoci);
                //   Log.e("=====>", "fadafd",FESIEASO);
                // startActivity(new Intent(getBaseContext(), CalendarioDate.class));
            }
        });


        final Spinner spinnerDos = (Spinner) findViewById(R.id.spn_agr_ct);
        ArrayAdapter<CharSequence> adapterDos = ArrayAdapter.createFromResource(this,
                R.array.causa_sinies, android.R.layout.simple_spinner_item);
        adapterDos.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerDos.setAdapter(adapterDos);
        spinnerDos.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Log.e("========>>", parent.getSelectedItem().toString());
                String causaSiniestro;
                causaSiniestro = parent.getSelectedItem().toString();

              /*
                if(causaSiniestro == "Especifique la causa"){
                    Log.e("========>>", parent.getSelectedItem().toString());
                }

               */
                causaSiniestrada(causaSiniestro);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Log.e("========>>", parent.getSelectedItem().toString());
            }
        });

        siguiente2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                VariablesModuloCuatro.FECHASIEM = FECHASIEM;// Integer¿Cuál es la fecha de siembra?

                if (!edtSup1.getText().toString().isEmpty()) {
                    SUPSEM = edtSup1.getText().toString();
                }

                if (!edtSup2.getText().toString().isEmpty()) {
                    SUPMEC = edtSup2.getText().toString();
                }

                if (!edtSup3.getText().toString().isEmpty()) {
                    SUPNOMEC = edtSup3.getText().toString();
                }

                if (!edtSup4.getText().toString().isEmpty()) {
                    SUPSINI = edtSup4.getText().toString();
                }

                if(!edtSup5.getText().toString().isEmpty()){
                    ASOCUL = edtSup5.getText().toString();
                }
                VariablesModuloCuatro.SUPSEM = SUPSEM;// Integer¿Cuánta superficie (ha) sembrada tiene?
                VariablesModuloCuatro.SUPMEC = SUPMEC;// Integer¿Cuánta superficie (ha) mecanizada tiene?
                VariablesModuloCuatro.SUPNOMEC = SUPNOMEC;// Integer¿Cuánta superficie (ha) no mecanizada tiene?
                VariablesModuloCuatro.SUPSINI = SUPSINI;// Integer¿Cuánta superficie (ha) siniestrada tiene?

                VariablesModuloCuatro.CASUPSI = CASUPSI;// Integer¿Cuál fue la causa de la superficie siniestrada?

                VariablesModuloCuatro.ASOC = ASOC;// Integer¿Está asociado con otro cultivo?
                VariablesModuloCuatro.ASOCUL = ASOCUL;// Integer¿Cuál?

                VariablesModuloCuatro.FESIEASO = FESIEASO;// Integer¿Cuál es la fecha de siembra del cultivo asociado?

                startActivity(new Intent(getApplicationContext(), ciclo_caracterizacion4.class));
            }
        });
    }

    private void causaSiniestrada(String causaSiniestro) {
        switch (causaSiniestro) {
            case "Especifique la causa":
                CASUPSI = null;
             //   Log.e("========>>", causaSiniestro);
                break;
            default:
                CASUPSI = causaSiniestro;
              //  Log.e("========>>", causaSiniestro);
                break;
        }
    }

    private void showDatePickerDialog(final EditText editText) {
        DatePickerFragment newFragment = DatePickerFragment.newInstance(new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                // +1 because January is zero
                final String selectedDate = day + "/" + (month + 1) + "/" + year;
                //edtFechaAsoci.setText(selectedDate);
                if (valorFecha == 1) {
                    FECHASIEM = selectedDate;
                    Log.e("========>>", selectedDate);
                } else if (valorFecha == 2) {
                    FESIEASO = selectedDate;
                    Log.e("========>>", selectedDate);
                }
                editText.setText(selectedDate);
                valorFecha = 0;
            }
        });

        newFragment.show(getSupportFragmentManager(), "datePicker");
    }


    public void asociadoCultivoAgri(View view) {
        boolean checkedTipo = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.cacahua_v:
                if (checkedTipo) {
                    ASOC = "Si";
                }
                break;
            case R.id.cacahua_r:
                if (checkedTipo) {
                    ASOC = "No";
                }
                break;
        }
    }

    @Override
    public void onBackPressed() {

    }
}
