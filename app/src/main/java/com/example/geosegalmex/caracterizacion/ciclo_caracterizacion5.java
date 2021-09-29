package com.example.geosegalmex.caracterizacion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.geosegalmex.R;
import com.example.geosegalmex.caracterizacion.variables_caracterizacion.VariablesModuloCuatro;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

public class ciclo_caracterizacion5 extends AppCompatActivity {
    ExtendedFloatingActionButton siguiente55;
    private String ANAFERG= null;// Integer¿Realiza algún análisis para fertilizar?
    private String TIPANAG= null;// Integer¿Qué tipo de análisis?
    private String PANAGR= null;// IntegerPrecio $
    private String TIPFERG= null;// Integer¿Realiza algún tipo de fertilización?

    EditText edtPrSuelo;
    EditText edtPrFoliar;

    TextView txtTituloNutri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ciclo_caracterizacion5);

        siguiente55 = findViewById(R.id.btn_sig55);
        edtPrSuelo = findViewById(R.id.suelo_precio_agr);
        edtPrFoliar = findViewById(R.id.foliar_precio_agr);
        txtTituloNutri = findViewById(R.id.txt_tit_mod_cua_2);

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

        if(ciclo_carac.valorTempCosPvAgricola == 1){

            txtTituloNutri.setText(getString(R.string.name_mod_nut_pv_cuatro));
        }else if(ciclo_carac.valorTempCosOiAgricola == 1){

            txtTituloNutri.setText(getString(R.string.name_mod_nut_oi_cuatro));
        }


        siguiente55.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!edtPrSuelo.getText().toString().isEmpty()){
                    PANAGR = edtPrSuelo.getText().toString();
                }

                if(!edtPrFoliar.getText().toString().isEmpty()){
                    PANAGR = edtPrFoliar.getText().toString();
                }

                VariablesModuloCuatro.ANAFERG = ANAFERG;// Integer¿Realiza algún análisis para fertilizar?
                VariablesModuloCuatro.TIPANAG = TIPANAG;// Integer¿Qué tipo de análisis?
                VariablesModuloCuatro.PANAGR = PANAGR;// IntegerPrecio $
                VariablesModuloCuatro.TIPFERG = TIPFERG;// Integer¿Realiza algún tipo de fertilización?
                startActivity(new Intent(getApplicationContext(), ciclo_caracterizacion6.class));
            }
        });
    }

    public void analisisFertiAgri(View view) {
        boolean checkedTipo = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.si_agr_fer:
                if (checkedTipo) {
                    ANAFERG = "Si";
                }
                break;
            case R.id.no_agr_fer:
                if (checkedTipo) {
                    ANAFERG = "No";
                }
                break;
        }
    }

    public void tipoAnalisisAgri(View view) {
        boolean checkedTipo = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.tip_sue_agr:
                if (checkedTipo) {
                    TIPANAG = "Suelo";
                    edtPrSuelo.setEnabled(true);
                    edtPrFoliar.setText("");
                }
                break;
            case R.id.tip_fol_agr:
                if (checkedTipo) {
                    TIPANAG = "Foliar";
                    edtPrFoliar.setEnabled(true);
                    edtPrSuelo.setText("");
                }
                break;
        }
    }

    public void tipoFeltilizacion(View view) {
        boolean checkedTipo = ((RadioButton) view).isChecked();
        switch (view.getId()) {
            case R.id.rd_si_af_hor:
                if (checkedTipo) {
                    TIPFERG = "Si";
                }
                break;
            case R.id.no_f_agr:
                if (checkedTipo) {
                    TIPFERG = "No";
                }
                break;
        }
    }

    @Override
    public void onBackPressed() {

    }
}
