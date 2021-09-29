package com.example.geosegalmex.frutales;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.geosegalmex.R;
import com.example.geosegalmex.frutales.dbfrutales.VariablesFrutales;
import com.example.geosegalmex.unidadcaracterizacionhortalizas.db.DatabaseHelper;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

public class frutales_10 extends AppCompatActivity {
    ExtendedFloatingActionButton f10;
    private String PLAGA= null;// IntegerPlagas y/o enfermedades
    private String PLATIPCOT= null;// IntegerTipo de control.
    private String PLATCOGR= null;// IntegerOtro

    private String PLAPROGR= null;// IntegerInsecticida o producto
    private String PLACANTGR= null;// IntegerCantidad (l ó kg)/ha
  //  private String SUPHOR= null;// IntegerSuperficie de aplicación (ha)
    private String PEJORGR= null;// IntegerJornales
    private String INSPROGR= null;// IntegerCosto del insecticida o producto

    EditText edt1;
    EditText edt2;
    EditText edt3;
    EditText edt4;
    EditText edt5;
    EditText edt6;

    Button btnAgregar;
    private DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frutales_10);

        f10 = findViewById(R.id.fr10_frt);

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

        db = new DatabaseHelper(this);

        edt1 = findViewById(R.id.pl_agr_1_frt);
        edt2 = findViewById(R.id.pl_agr_2_frt);
        edt3 = findViewById(R.id.pl_agr_3_frt);
        edt4 = findViewById(R.id.pl_agr_4_frt);
        edt5 = findViewById(R.id.pl_agr_5_frt);
        edt6 = findViewById(R.id.pl_agr_6_frt);
        btnAgregar = findViewById(R.id.btn_pl_agr_frt);


        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                asignacionVariables();
                if(PLAGA != null){
                    aggPlaga();
                    startActivity(new Intent(getApplicationContext(), frutales_10.class));
                }
            }
        });


        f10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                asignacionVariables();
                if(PLAGA != null){
                    aggPlaga();
                }
                startActivity(new Intent(getApplicationContext(), frutales_11.class));
            }
        });
    }

    private void aggPlaga() {
        boolean insertarData = db.addDatosFrutalesPlagas();
        if(insertarData == true) {
            Toast.makeText(this, "Datos insertados correctamente", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Algo salio mal", Toast.LENGTH_LONG).show();
        }
    }

    private void asignacionVariables() {

        if(!edt1.getText().toString().isEmpty()){
            PLAGA = edt1.getText().toString();
        }else{
            PLAGA = null;
        }


        if(!edt2.getText().toString().isEmpty()){
            PLATCOGR = edt2.getText().toString();
        }else {
            PLATCOGR = null;
        }


        if(!edt3.getText().toString().isEmpty()){
            PLAPROGR = edt3.getText().toString();
        }else{
            PLAPROGR =null;
        }

        if(!edt4.getText().toString().isEmpty()){
            PLACANTGR = edt4.getText().toString();
        }else{
            PLACANTGR = null;
        }

        if(!edt5.getText().toString().isEmpty()){
            PEJORGR = edt5.getText().toString();
        }else{
            PEJORGR = null;
        }

        if(!edt6.getText().toString().isEmpty()){
            INSPROGR = edt6.getText().toString();
        }else{
            INSPROGR = null;
        }

        VariablesFrutales.PLAGAFRT= PLAGA;// IntegerPlagas y/o enfermedades
        VariablesFrutales.PLATIPCOTFRT= PLATIPCOT;// IntegerTipo de control.
        VariablesFrutales.PLATCOGRFRT= PLATCOGR;// IntegerOtro

        VariablesFrutales.PLAPROGRFRT= PLAPROGR;// IntegerInsecticida o producto
        VariablesFrutales.PLACANTGRFRT= PLACANTGR;// IntegerCantidad (l ó kg)/ha

        VariablesFrutales.PEJORGRFRT= PEJORGR;// IntegerJornales
        VariablesFrutales.INSPROGRFRT= INSPROGR;// IntegerCosto del insecticida o producto
    }

    public void tipoEnferAgrifrt(View view) {
        boolean checkedTipo = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.rd_tip_enf_1_frt:
                if (checkedTipo) {
                    edt2.setEnabled(false);
                    PLATIPCOT = "Químico";
                    edt2.setText("");
                }
                break;
            case R.id.rd_tip_enf_2_frt:
                if (checkedTipo) {
                    edt2.setEnabled(false);
                    PLATIPCOT = "Biológico";
                    edt2.setText("");
                }
                break;
            case R.id.rd_tip_enf_3_frt:
                if (checkedTipo) {
                    edt2.setEnabled(true);
                    PLATIPCOT = "Otro";
                }
                break;
        }
    }

    @Override
    public void onBackPressed() {

    }
}
