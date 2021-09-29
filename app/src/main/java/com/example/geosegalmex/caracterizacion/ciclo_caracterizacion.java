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

public class ciclo_caracterizacion extends AppCompatActivity {
    private String CICLOPRO = null;
    private String MAIZ = null;
    private String OTROMAIZ = null;
    private String MILPA = null;
    private String SORGO = null;
    private String FRIJOL = null;
    private String TRIGO = null;
    private String AJONJOLI = null;
    private String CACAHUATE = null;

    EditText edtMaizOtro;


    ExtendedFloatingActionButton siguiente1;

    public static String cicProAgricola = null;
    TextView txtTitulo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ciclo_caracterizacion);

        siguiente1 = findViewById(R.id.btn_sig1);
        edtMaizOtro = findViewById(R.id.edt_maiz_otroo);
        txtTitulo = findViewById(R.id.txt_tit_mod_cua_1);


        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

        if(ciclo_carac.valorTempCosPvAgricola == 1){
            cicProAgricola = "P-V";
            txtTitulo.setText(getString(R.string.name_mod_cuatro_pv));
        }else if(ciclo_carac.valorTempCosOiAgricola == 1){
            cicProAgricola = "O-I";
            txtTitulo.setText(getString(R.string.name_mod_cuatro_oi));
        }

        siguiente1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(!edtMaizOtro.getText().toString().isEmpty()){
                    OTROMAIZ = edtMaizOtro.getText().toString();
                }
                //VariablesModuloCuatro.CICLOPRO = CICLOPRO;// IntegerEn el año pasado, ¿En qué ciclo agrícola tuvo producción?
                VariablesModuloCuatro.CICLOPRO = cicProAgricola;// IntegerEn el año pasado, ¿En qué ciclo agrícola tuvo producción?
                VariablesModuloCuatro.MAIZ = MAIZ;// Integer¿Qué tipo de maíz es?
                VariablesModuloCuatro.OTROMAIZ = OTROMAIZ;// Integer¿Qué tipo de maíz es?

                VariablesModuloCuatro.MILPA = MILPA;// Integer¿Milpa?
                VariablesModuloCuatro.SORGO = SORGO;// Integer¿Qué tipo de sorgo es?
                VariablesModuloCuatro.FRIJOL = FRIJOL;// Integer¿Qué tipo de frijol es?
                VariablesModuloCuatro.TRIGO = TRIGO;// Integer¿Qué tipo de trigo es?

                VariablesModuloCuatro.AJONJOLI = AJONJOLI;// Integer¿Qué tipo de ajonjolí es?
                VariablesModuloCuatro.CACAHUATE = CACAHUATE;// Integer¿Qué tipo de cacahuate es?
                startActivity(new Intent(getApplicationContext(), ciclo_caracterizacion2.class));
            }
        });
    }

    public void tipoMaiz(View view) {
        boolean checkedTipo = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.maiz_blanco:
                if (checkedTipo) {
                    MAIZ = "Blanco";
                    edtMaizOtro.setEnabled(false);
                    edtMaizOtro.setText("");
                }
                break;
            case R.id.maiz_amarillo:
                if (checkedTipo) {
                    MAIZ = "Amarillo";
                    edtMaizOtro.setEnabled(false);
                    edtMaizOtro.setText("");
                }
                break;
            case R.id.maiz_zul:
                if (checkedTipo) {
                    MAIZ = "Azul";
                    edtMaizOtro.setEnabled(false);
                    edtMaizOtro.setText("");
                }
                break;
            case R.id.maiz_otro:
                if (checkedTipo) {
                    MAIZ = "Otro";
                    edtMaizOtro.setEnabled(true);
                }
                break;
        }
    }

    public void tipoMilpa(View view) {
        boolean checkedTipo = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.propia:
                if (checkedTipo) {
                    MILPA = "Si";
                }
                break;
            case R.id.rentada:
                if (checkedTipo) {
                    MILPA = "No";
                }
                break;
        }
    }

    public void tipoSorgo(View view) {
        boolean checkedTipo = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.sorgo_b:
                if (checkedTipo) {
                    SORGO = "Blanco";
                }
                break;
            case R.id.sorgo_r:
                if (checkedTipo) {
                    SORGO = "Rojo";
                }
                break;
        }
    }

    public void tipoFrijol(View view) {
        boolean checkedTipo = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.frijol_r:
                if (checkedTipo) {
                    FRIJOL = "Rojo";
                }
            case R.id.frijol_n:
                if (checkedTipo) {
                    FRIJOL = "Negro";
                }
                break;
            case R.id.frijol_a:
                if (checkedTipo) {
                    FRIJOL = "Azufrado";
                }
                break;
            case R.id.frijol_p:
                if (checkedTipo) {
                    FRIJOL = "Pinto";
                }
                break;
            case R.id.frijol_b:
                if (checkedTipo) {
                    FRIJOL = "Blanco";
                }
                break;
        }
    }

    public void tipoTrigo(View view) {
        boolean checkedTipo = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.trigo_d:
                if (checkedTipo) {
                    TRIGO = "Duro";
                }
                break;
            case R.id.trigo_b:
                if (checkedTipo) {
                    TRIGO = "Blando";
                }
                break;
        }
    }

    public void tipoAjonjoli(View view) {
        boolean checkedTipo = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.ajonjoli_n:
                if (checkedTipo) {
                    AJONJOLI = "Negro";
                }
                break;
            case R.id.ajonjoli_c:
                if (checkedTipo) {
                    AJONJOLI = "Crema";
                }
                break;
            case R.id.ajonjoli_b:
                if (checkedTipo) {
                    AJONJOLI = "Blanco";
                }
                break;
        }
    }

    public void tipoCacahuate(View view) {
        boolean checkedTipo = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.cacahua_v:
                if (checkedTipo) {
                    CACAHUATE = "Virginia o piñatero arbustivo";
                }
                break;
            case R.id.cacahua_r:
                if (checkedTipo) {
                    CACAHUATE = "Virginia o piñatero rastrero";
                }
                break;
            case R.id.cacahua_c:
                if (checkedTipo) {
                    CACAHUATE = "Runner o para confite";
                }
                break;
        }
    }

    @Override
    public void onBackPressed() {

    }
}
