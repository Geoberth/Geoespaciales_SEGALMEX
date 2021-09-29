package com.example.geosegalmex.unidadcaracterizacionhortalizas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.geosegalmex.R;
import com.example.geosegalmex.unidadcaracterizacionhortalizas.variables.VariblesGlobalesHortalizas;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

public class ControlPlagasEnferm extends AppCompatActivity {
    ExtendedFloatingActionButton fabPlagasEnfer;
    TextView txtCntPlEnf;

    //Variables
    String txtTpPlagaEnfer = null;
    String txtNvPlagasEnfer = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_control_plagas_enferm);

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

        fabPlagasEnfer = findViewById(R.id.fab_next_cnp_fe);
        txtCntPlEnf = findViewById(R.id.tx_tit_ple);


        if(hortalizas.valorTempCosPv == 1){
            txtCntPlEnf.setText(getString(R.string.name_mod_cpe_pv));
        }else if(hortalizas.valorTempCosOi == 1){
            txtCntPlEnf.setText(getString(R.string.name_mod_cpe_oi));
        }

        fabPlagasEnfer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                VariblesGlobalesHortalizas.PLAENHPV = txtTpPlagaEnfer;
                VariblesGlobalesHortalizas.PLAGNUEVA = txtNvPlagasEnfer;

                startActivity(new Intent(getBaseContext(), ControlPlagasEnfermB.class));
            }
        });
    }

    @Override
    public void onBackPressed() {

    }

    public void nombPlagasEnferm(View view) {
        boolean checkedTipo = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.rd_si_cmp_fe:
                if (checkedTipo) {
                    txtTpPlagaEnfer = "Si";
                }
                break;
            case R.id.rd_no_cmp_fe:
                if (checkedTipo) {
                    txtTpPlagaEnfer = "No";
                }
                break;
        }
    }

    public void nuvPlagasEnfer(View view) {
        boolean checkedTipo = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.rd_si_pl_enf_fe:
                if (checkedTipo) {
                    txtNvPlagasEnfer = "Si";
                }
                break;
            case R.id.rd_no_pl_enf_fe:
                if (checkedTipo) {
                    txtNvPlagasEnfer = "No";
                }
                break;
        }
    }
}

