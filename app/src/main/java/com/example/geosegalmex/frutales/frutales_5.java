package com.example.geosegalmex.frutales;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.geosegalmex.R;
import com.example.geosegalmex.caracterizacion.variables_caracterizacion.DatePickerFragment;
import com.example.geosegalmex.frutales.dbfrutales.VariablesFrutales;
import com.example.geosegalmex.unidadcaracterizacionhortalizas.db.DatabaseHelper;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

public class frutales_5 extends AppCompatActivity {
    ExtendedFloatingActionButton f5;

    EditText edtFerti;
    EditText edtFecha;
    EditText edtCnt;
    EditText edtCstoFer;
    EditText edtNmJorn;

    EditText edtEtpFnFrt;

    private String FERTGRA= null;// IntegerFertilizantes y/o abonos aplicados
    private String EFFRUTFRT= null;// IntegerEtapa fenológica
    private String FERAPPG= null;// IntegerFecha de aplicación
    private String FERCANG= null;// IntegerCantidad (l o kg / ha)
    private String FERCOSG= null;// IntegerCosto de fertilizante
    private String FERJORG= null;// IntegerNúm. de jornales
    private String METODOFRT= null;// METODO APLICACION

    private DatabaseHelper db;

    Button btnOtro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frutales_5);

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        db = new DatabaseHelper(this);

        f5 = findViewById(R.id.btn_sig6_frt);


        edtFerti = findViewById(R.id.edt_fer_agr_frt);
        edtFecha = findViewById(R.id.fecha_apli_agr_frt);
        edtCnt = findViewById(R.id.edt_cnt_agr_frt);
        edtCstoFer = findViewById(R.id.edt_cst_fer_frt);
        edtNmJorn = findViewById(R.id.edt_no_jrn_fer_frt);
        btnOtro = findViewById(R.id.btn_fer_otro_frt);

        edtEtpFnFrt = findViewById(R.id.edt_etp_fen_frt);


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
                impresion();
                if(FERTGRA != null){
                    aggFertilizantes();
                    startActivity(new Intent(getApplicationContext(), frutales_5.class));
                }
            }
        });

        f5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valoresAsignados();
                impresion();
                if(FERTGRA != null){
                    aggFertilizantes();
                }
                startActivity(new Intent(getApplicationContext(), frutales_6.class));
            }
        });

    }

    private void aggFertilizantes() {
        boolean insertarData = db.addDatosFrutalesFertilizante();
        if(insertarData == true) {
            Toast.makeText(this, "Datos insertados correctamente", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Algo salio mal", Toast.LENGTH_LONG).show();
        }
    }

    private void impresion() {
        System.out.println(FERTGRA);// IntegerFertilizantes y/o abonos aplicados
        System.out.println(FERAPPG);// IntegerFecha de aplicación
        System.out.println(FERCANG);// IntegerCantidad (l o kg / ha)
        System.out.println(FERCOSG);// IntegerCosto de fertilizante
        System.out.println(FERJORG);// IntegerNúm. de jornales

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

        if (!edtEtpFnFrt.getText().toString().isEmpty()){
            EFFRUTFRT = edtEtpFnFrt.getText().toString();
        }


        VariablesFrutales.FERTGRAFRT = FERTGRA;// IntegerFertilizantes y/o abonos aplicados
        VariablesFrutales.EFFRUTFRT = EFFRUTFRT;// IntegerEtapa fenológica
        VariablesFrutales.FERAPPGFRT = FERAPPG;// IntegerFecha de aplicación
        VariablesFrutales.FERCANGFRT = FERCANG;// IntegerCantidad (l o kg / ha)
        VariablesFrutales.FERCOSGFRT = FERCOSG;// IntegerCosto de fertilizante
        VariablesFrutales.FERJORGFRT = FERJORG;// IntegerNúm. de jornales
        VariablesFrutales.METODOFRT = METODOFRT;

        if(FERTGRA != null) {
            //aggFertilizanteAgri();
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

    public void metodoAplFrutales(View view) {
        boolean checkedTipo = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.rd_mt_apl_1:
                if (checkedTipo) {
                    METODOFRT = "Radicular" ;
                }
                break;
            case R.id.rd_mt_apl_2:
                if (checkedTipo) {
                    METODOFRT = "Fertirrigación";
                }
                break;
            case R.id.rd_mt_apl_3:
                if (checkedTipo) {
                    METODOFRT = "Al suelo";
                }
                break;
            case R.id.rd_mt_apl_4:
                if (checkedTipo) {
                    METODOFRT = "Foliar";
                }
                break;
        }

    }

    @Override
    public void onBackPressed() {

    }
}
