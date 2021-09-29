package com.example.geosegalmex.caracterizacion;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.example.geosegalmex.R;
import com.example.geosegalmex.caracterizacion.variables_caracterizacion.DatePickerFragment;
import com.example.geosegalmex.caracterizacion.variables_caracterizacion.VariablesModuloCuatro;
import com.example.geosegalmex.unidadcaracterizacionhortalizas.db.DatabaseHelper;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

public class ciclo_caracterizacion6 extends AppCompatActivity {
    ExtendedFloatingActionButton siguiente6;
    EditText edtFerti;
    EditText edtFecha;
    EditText edtCnt;
    EditText edtCstoFer;
    EditText edtNmJorn;

    private String FERTGRA= null;// IntegerFertilizantes y/o abonos aplicados
    //  private String EFFRUT= null;// IntegerEtapa fenológica
    private String FERAPPG= null;// IntegerFecha de aplicación
    private String FERCANG= null;// IntegerCantidad (l o kg / ha)
    private String FERCOSG= null;// IntegerCosto de fertilizante
    private String FERJORG= null;// IntegerNúm. de jornales

    private DatabaseHelper db;

    Button btnOtro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ciclo_caracterizacion6);

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        db = new DatabaseHelper(this);

        siguiente6 = findViewById(R.id.btn_sig6);

        edtFerti = findViewById(R.id.edt_fer_agr);
        edtFecha = findViewById(R.id.fecha_apli_agr);
        edtCnt = findViewById(R.id.edt_cnt_agr);
        edtCstoFer = findViewById(R.id.edt_cst_fer);
        edtNmJorn = findViewById(R.id.edt_no_jrn_fer);
        btnOtro = findViewById(R.id.btn_fer_otro);

        edtFecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog(edtFecha);

            }
        });

        btnOtro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valoresAsignados();
                if(FERTGRA != null){
                    startActivity(new Intent(getApplicationContext(), ciclo_caracterizacion6.class));
                }
            }
        });

        siguiente6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    valoresAsignados();
                startActivity(new Intent(getApplicationContext(), ciclo_caracterizacion7.class));
            }
        });
    }

    private void valoresAsignados() {
        if(!edtFerti.getText().toString().isEmpty()){
            FERTGRA = edtFerti.getText().toString();
        }

        if(!edtCnt.getText().toString().isEmpty()){
            FERCANG = edtCnt.getText().toString();
        }

        if(!edtCstoFer.getText().toString().isEmpty()){
            FERCOSG = edtCstoFer.getText().toString();
        }

        if(!edtNmJorn.getText().toString().isEmpty()){
            FERJORG = edtNmJorn.getText().toString();
        }
        VariablesModuloCuatro.FERTGRA = FERTGRA;// IntegerFertilizantes y/o abonos aplicados
        //VariablesModuloCuatro.EFFRUT = ;// IntegerEtapa fenológica
        VariablesModuloCuatro.FERAPPG = FERAPPG;// IntegerFecha de aplicación
        VariablesModuloCuatro.FERCANG = FERCANG;// IntegerCantidad (l o kg / ha)
        VariablesModuloCuatro.FERCOSG = FERCOSG;// IntegerCosto de fertilizante
        VariablesModuloCuatro.FERJORG = FERJORG;// IntegerNúm. de jornales

        if(FERTGRA != null) {
            aggFertilizanteAgri();
        }
    }

    private void aggFertilizanteAgri() {
        boolean insertarData = db.addFertilizanteAgri();
        if(insertarData == true) {
            Toast.makeText(this, "Datos insertados correctamente", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Algo salio mal", Toast.LENGTH_LONG).show();
        }
    }

    private void showDatePickerDialog(final EditText editText) {
        DatePickerFragment newFragment = DatePickerFragment.newInstance(new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                // +1 because January is zero
                final String selectedDate = day + "/" + (month + 1) + "/" + year;
                editText.setText(selectedDate);
                FERAPPG = selectedDate;

            }
        });

        newFragment.show(getSupportFragmentManager(), "datePicker");
    }

    @Override
    public void onBackPressed() {

    }
}
