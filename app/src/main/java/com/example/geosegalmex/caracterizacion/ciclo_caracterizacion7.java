package com.example.geosegalmex.caracterizacion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.geosegalmex.R;
import com.example.geosegalmex.caracterizacion.variables_caracterizacion.VariablesModuloCuatro;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

public class ciclo_caracterizacion7 extends AppCompatActivity {
    ExtendedFloatingActionButton siguiente7;
    private String RIEGOGR= null;// Integer¿Utiliza algún sistema de riego?

    String txtCuandoRiega = null;
    String txtTipoRiega = null;
    EditText edtOtrRiego;
    EditText edtCantRiego;


    RadioButton rdTRGravedad;
    RadioButton rdTRGote;
    RadioButton rdTRAspercion;
    RadioButton rdTRotro;

    RadioButton rdDiario;
    RadioButton rdDosTreSem;
    RadioButton rdSemanal;
    RadioButton rdQuince;
    RadioButton rdMensual;

    RadioGroup rgTipoRiego;
    RadioGroup rgTimeRiego;

    private String SISRIEGR = null;
    private String SISHORTPV = null;
    private String FRERIEGR = null;
    private String CANRIEGR = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ciclo_caracterizacion7);

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

        siguiente7 = findViewById(R.id.btn_sig7);
        edtOtrRiego = findViewById(R.id.edt_ot_es_r_fe_agr);
        edtCantRiego = findViewById(R.id.tiempo_riega_agr);

        rgTipoRiego = findViewById(R.id.rg_tip_rie_agr);
        rgTimeRiego = findViewById(R.id.rg_tmp_rig_agr);

        rdTRGravedad = findViewById(R.id.ck_gv_r_fe_agr);
        rdTRGote = findViewById(R.id.ck_gt_r_fe_agr);
        rdTRAspercion = findViewById(R.id.ck_as_r_fe_agr);
        rdTRotro = findViewById(R.id.ck_ot_es_r_fe_agr);


        rdDiario = findViewById(R.id.ck_di_ri_fe_agr);
        rdDosTreSem = findViewById(R.id.ck_dt_ri_fe_agr);
        rdSemanal = findViewById(R.id.ck_se_ri_fe_agr);
        rdQuince = findViewById(R.id.ck_qi_ri_fe_agr);
        rdMensual = findViewById(R.id.ck_me_ri_fe_agr);

        siguiente7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                VariablesModuloCuatro.RIEGOGR = RIEGOGR;

                SISRIEGR = txtTipoRiega;
                FRERIEGR = txtCuandoRiega;
                if(!edtOtrRiego.getText().toString().isEmpty()){
                    SISHORTPV  = edtOtrRiego.getText().toString();
                }

                if(!edtCantRiego.getText().toString().isEmpty()){
                    CANRIEGR = edtCantRiego.getText().toString();
                }

                VariablesModuloCuatro.SISRIEGR = SISRIEGR;
                VariablesModuloCuatro.SISHORTPV = SISHORTPV;
                VariablesModuloCuatro.FRERIEGR = FRERIEGR;
                VariablesModuloCuatro.CANRIEGR = CANRIEGR;


                startActivity(new Intent(getApplicationContext(), ciclo_caracterizacion8.class));
            }
        });
    }

    public void tipoRiegoAgri(View view) {
        boolean checkedTipo = ((RadioButton) view).isChecked();
        switch (view.getId()) {
            case R.id.si_tip_rie_agr:
                if (checkedTipo) {
                    RIEGOGR = "Si";
                    rdTRGravedad.setEnabled(true);
                    rdTRGote.setEnabled(true);
                    rdTRAspercion.setEnabled(true);
                    rdTRotro.setEnabled(true);
                    rdDiario.setEnabled(true);
                    rdDosTreSem.setEnabled(true);
                    rdSemanal.setEnabled(true);
                    rdQuince.setEnabled(true);
                    rdMensual.setEnabled(true);
                    edtCantRiego.setEnabled(true);
                }
                break;
            case R.id.no_tip_rie_agr:
                if (checkedTipo) {
                    RIEGOGR = "No";
                    rgTipoRiego.clearCheck();
                    rgTimeRiego.clearCheck();
                    rdTRGravedad.setEnabled(false);
                    rdTRGote.setEnabled(false);
                    rdTRAspercion.setEnabled(false);
                    rdTRotro.setEnabled(false);

                    rdDiario.setEnabled(false);
                    rdDosTreSem.setEnabled(false);
                    rdSemanal.setEnabled(false);
                    rdQuince.setEnabled(false);
                    rdMensual.setEnabled(false);
                    edtOtrRiego.setText("");
                    edtCantRiego.setText("");
                    edtCantRiego.setEnabled(false);
                    edtOtrRiego.setEnabled(false);
                }
                break;
        }
    }

    public void cuandoRiegaAgri(View view) {
        boolean checkedTipo = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.ck_di_ri_fe_agr:
                if (checkedTipo) {
                    txtCuandoRiega = "Diario";
                }
                break;
            case R.id.ck_dt_ri_fe_agr:
                if (checkedTipo) {
                    txtCuandoRiega = "Dos o tres veces a la semana";
                }
                break;
            case R.id.ck_se_ri_fe_agr:
                if (checkedTipo) {
                    txtCuandoRiega = "Semanal";
                }
                break;
            case R.id.ck_qi_ri_fe_agr:
                if (checkedTipo) {
                    txtCuandoRiega = "Quincenal";
                }
                break;
            case R.id.ck_me_ri_fe_agr:
                if (checkedTipo) {
                    txtCuandoRiega = "Mensual";
                }
                break;
        }
    }

    public void tipoRiegoAgri2(View view) {
        boolean checkedTipo = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.ck_gv_r_fe_agr:
                if (checkedTipo) {
                    txtTipoRiega = "Gravedad o rodado";
                    edtOtrRiego.setText("");
                    edtOtrRiego.setEnabled(false);
                }
                break;
            case R.id.ck_gt_r_fe_agr:
                if (checkedTipo) {
                    txtTipoRiega = "Goteo";
                    edtOtrRiego.setText("");
                    edtOtrRiego.setEnabled(false);
                }
                break;
            case R.id.ck_as_r_fe_agr:
                if (checkedTipo) {
                    txtTipoRiega = "Aspersión";
                    edtOtrRiego.setText("");
                    edtOtrRiego.setEnabled(false);
                }
                break;
            case R.id.ck_ot_es_r_fe_agr:
                if (checkedTipo) {
                    txtTipoRiega = "Otro";
                    edtOtrRiego.setEnabled(true);
                }
                break;
        }
    }

    @Override
    public void onBackPressed() {

    }
}
