package com.example.geosegalmex.caracterizacion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.geosegalmex.R;
import com.example.geosegalmex.caracterizacion.variables_caracterizacion.VariablesModuloCuatro;
import com.example.geosegalmex.unidadcaracterizacionhortalizas.db.DatabaseHelper;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

public class ciclo_caracterizacion10 extends AppCompatActivity {
    ExtendedFloatingActionButton siguiente10;

    private String PLAGA= null;// IntegerPlagas y/o enfermedades
    private String PLATIPCOT= null;// IntegerTipo de control.
    private String PLATCOGR= null;// IntegerOtro
    private String PLAPROGR= null;// IntegerInsecticida o producto
    private String PLACANTGR= null;// IntegerCantidad (l ó kg)/ha
    private String SUPHOR= null;// IntegerSuperficie de aplicación (ha)
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
    TextView txtCntPlgs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ciclo_caracterizacion10);

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

        db = new DatabaseHelper(this);

        edt1 = findViewById(R.id.pl_agr_1);
        edt2 = findViewById(R.id.pl_agr_2);
        edt3 = findViewById(R.id.pl_agr_3);
        edt4 = findViewById(R.id.pl_agr_4);
        edt5 = findViewById(R.id.pl_agr_5);
        edt6 = findViewById(R.id.pl_agr_6);
        btnAgregar = findViewById(R.id.btn_pl_agr);
        txtCntPlgs = findViewById(R.id.tx_tit_cm_agr_pl);


        siguiente10 = findViewById(R.id.btn_sig10);

        if(ciclo_carac.valorTempCosPvAgricola == 1){

            txtCntPlgs.setText(getString(R.string.name_mod_cpe_pv_cuatro));
        }else if(ciclo_carac.valorTempCosOiAgricola == 1){
            txtCntPlgs.setText(getString(R.string.name_mod_cpe_oi_cuatro));
        }


        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                asignacionValores();
                if (PLAGA != null) {
                    startActivity(new Intent(getApplicationContext(), ciclo_caracterizacion10.class));
                }
            }
        });

        siguiente10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                asignacionValores();
                startActivity(new Intent(getApplicationContext(), ciclo_caracterizacion11.class));
            }
        });
    }

    private void asignacionValores() {
        if(!edt1.getText().toString().isEmpty()){
            PLAGA = edt1.getText().toString();
        }

        if(!edt2.getText().toString().isEmpty()){
            PLATCOGR = edt2.getText().toString();
        }

        if(!edt3.getText().toString().isEmpty()){
            PLAPROGR = edt3.getText().toString();
        }

        if(!edt4.getText().toString().isEmpty()){
            PLACANTGR = edt4.getText().toString();
        }

        if(!edt5.getText().toString().isEmpty()){
            PEJORGR = edt5.getText().toString();
        }

        if(!edt6.getText().toString().isEmpty()){
            INSPROGR = edt6.getText().toString();
        }
        VariablesModuloCuatro.PLAGA = PLAGA;// IntegerPlagas y/o enfermedades

        VariablesModuloCuatro.PLATIPCOT = PLATIPCOT;// IntegerTipo de control.
        VariablesModuloCuatro.PLATCOGR = PLATCOGR;// IntegerOtro

        VariablesModuloCuatro.PLAPROGR = PLAPROGR;// IntegerInsecticida o producto
        VariablesModuloCuatro.PLACANTGR = PLACANTGR;// IntegerCantidad (l ó kg)/ha
    //    VariablesModuloCuatro.SUPHOR = SUPHOR;// IntegerSuperficie de aplicación (ha) solo hortalizas
        VariablesModuloCuatro.PEJORGR = PEJORGR;// IntegerJornales
        VariablesModuloCuatro.INSPROGR = INSPROGR;// IntegerCosto del insecticida o producto

        if(PLAGA != null){
            aggEnfermedadesAgri();
        }
    }

    private void aggEnfermedadesAgri() {
        boolean insertarData = db.addEnfermedades();
        if(insertarData == true) {
            Toast.makeText(this, "Datos insertados correctamente", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Algo salio mal", Toast.LENGTH_LONG).show();
        }
    }

    public void tipoEnferAgri(View view) {
        boolean checkedTipo = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.rd_tip_enf_1:
                if (checkedTipo) {
                    PLATIPCOT ="Químico";
                    PLATCOGR = null;
                    edt2.setEnabled(false);
                    edt2.setText("");
                }
                break;
            case R.id.rd_tip_enf_2:
                if (checkedTipo) {
                    PLATIPCOT ="Biológico";
                    PLATCOGR = null;
                    edt2.setEnabled(false);
                    edt2.setText("");
                }
                break;
            case R.id.rd_tip_enf_3:
                if (checkedTipo) {
                    PLATIPCOT ="Otro";
                    edt2.setEnabled(true);
                }
                break;
        }
    }

    @Override
    public void onBackPressed() {

    }
}
