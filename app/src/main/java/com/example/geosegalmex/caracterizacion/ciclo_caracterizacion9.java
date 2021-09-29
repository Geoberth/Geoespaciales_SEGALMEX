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

public class ciclo_caracterizacion9 extends AppCompatActivity {
    ExtendedFloatingActionButton siguiente9;

    private String MALGR= null;// IntegerMaleza
    //private String NCFRU= null;// IntegerNombre común
    private String CONQMGR= null;// IntegerControl: (1) químico o 2) manual
    private String HERGR= null;// IntegerHerbicida
    private String HERCANGR= null;// IntegerCantidad (l ó kg / ha)
    private String SUPAPFRU= null;// IntegerSuperficie de aplicación (ha)
    private String HJORGR= null;// IntegerJornales
    private String CHERGR= null;// IntegerCosto herbicida

    EditText edtHrbci;
    EditText edtCant;
    EditText edtJorn;
    EditText edtCstHerb;

    Button btnOtraMaleza;
    private DatabaseHelper db;

    TextView txtTitCs;
    TextView txtSubtTitCs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ciclo_caracterizacion9);

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        db = new DatabaseHelper(this);
        siguiente9 = findViewById(R.id.btn_sig9);

        edtHrbci = findViewById(R.id.edt_her_cm_fe_agr);
        edtCant = findViewById(R.id.edt_can_cm_fe_agr);
        edtJorn = findViewById(R.id.edt_jr_cm_fe_agr);
        edtCstHerb = findViewById(R.id.edt_ch_cm_fe_agr);
        btnOtraMaleza = findViewById(R.id.btn_oto_cm_fe_agr);
        txtTitCs = findViewById(R.id.tx_tit_cm_agr_ml);
        txtSubtTitCs = findViewById(R.id.tx_tit_cm_agr_cm);

        if(ciclo_carac.valorTempCosPvAgricola == 1){
            txtTitCs.setText(getString(R.string.name_mod_ctms_pv_cuatro));
            txtSubtTitCs.setText(getString(R.string.name_mod_ctm_pv_cuatro));
        }else if(ciclo_carac.valorTempCosOiAgricola == 1){
            txtTitCs.setText(getString(R.string.name_mod_ctms_oi_cuatro));
            txtSubtTitCs.setText(getString(R.string.name_mod_ctm_oi_cuatro));
        }

        btnOtraMaleza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(MALGR != null) {
                    asignacionValores();
                    startActivity(new Intent(getApplicationContext(), ciclo_caracterizacion9.class));
                }
            }
        });

        siguiente9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(MALGR != null) {
                    asignacionValores();
                }
                startActivity(new Intent(getApplicationContext(), ciclo_caracterizacion10.class));
            }
        });
    }

    private void asignacionValores() {
        if(!edtHrbci.getText().toString().isEmpty()){
            HERGR =  edtHrbci.getText().toString();
        }

        if(!edtCant.getText().toString().isEmpty()){
            HERCANGR = edtCant.getText().toString();
        }

        if(!edtJorn.getText().toString().isEmpty()){
            HJORGR = edtJorn.getText().toString();
        }

        if(!edtCstHerb.getText().toString().isEmpty()){
            CHERGR = edtCstHerb.getText().toString();
        }
        VariablesModuloCuatro.MALGR = MALGR;// IntegerMaleza
        //VariablesModuloCuatro.NCFRU = ;// IntegerNombre común
        VariablesModuloCuatro.CONQMGR = CONQMGR;// IntegerControl: (1) químico o 2) manual

        VariablesModuloCuatro.HERGR = HERGR;// IntegerHerbicida
        VariablesModuloCuatro.HERCANGR = HERCANGR;// IntegerCantidad (l ó kg / ha)
//                VariablesModuloCuatro.SUPAPFRU = SUPAPFRU;// IntegerSuperficie de aplicación (ha)
        VariablesModuloCuatro.HJORGR = HJORGR;// IntegerJornales
        VariablesModuloCuatro.CHERGR = CHERGR;// IntegerCosto herbicida

        if(MALGR != null){
            addMalezaAGricultura();
        }
    }

    private void addMalezaAGricultura() {
        boolean insertarData = db.addMalezaAgri();
        if(insertarData == true) {
            Toast.makeText(this, "Datos insertados correctamente", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Algo salio mal", Toast.LENGTH_LONG).show();
        }
    }

    public void tipoMalezagr(View view) {
        boolean checkedTipo = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.rd_hj_ach_agr:
                if (checkedTipo) {
                    MALGR = "Hoja ancha";
                }
                break;
            case R.id.rd_hj_dlg_agr:
                if (checkedTipo) {
                    MALGR = "Hoja delgada";
                }
                break;
        }
    }

    public void tipoControlagr(View view) {
        boolean checkedTipo = ((RadioButton) view).isChecked();
        switch (view.getId()) {
            case R.id.rd_cm_qui_agr:
                if (checkedTipo) {
                    CONQMGR = "Químico";
                }
                break;
            case R.id.rd_cm_mnl_agr:
                if (checkedTipo) {
                    CONQMGR = "Manual";
                }
                break;
        }
    }

    @Override
    public void onBackPressed() {

    }
}
