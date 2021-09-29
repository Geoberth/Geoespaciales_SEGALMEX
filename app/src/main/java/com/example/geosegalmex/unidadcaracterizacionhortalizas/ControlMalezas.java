package com.example.geosegalmex.unidadcaracterizacionhortalizas;

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
import com.example.geosegalmex.unidadcaracterizacionhortalizas.db.DatabaseHelper;
import com.example.geosegalmex.unidadcaracterizacionhortalizas.variables.VariblesGlobalesHortalizas;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.snackbar.Snackbar;


public class ControlMalezas extends AppCompatActivity {
    Button btnOtroCm;
    ExtendedFloatingActionButton fabCmNext;
    TextView txtCntMal;

    String txtTipoMaleza = null;
    String txtControl = null;
    String txtHerbicida = null;
    String txtCantidad = null;
    String txtJornales = null;
    String txtCostoH = null;

    EditText edtHerbicida;
    EditText edtCantidad;
    EditText edtJornales;
    EditText edtCostoH;


    private String MALGR = null;
    private String CONQMGR = null;
    private String HERGR = null;
    private String HERCANGR = null;
    private String HJORGR = null;
    private String CHERGR = null;
    /*
    MALGR;
    CONQMGR;
    HERGR;
    HERCANGR;
    HJORGR;
    CHERGR;
    */
    private DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_control_malezas);

        db = new DatabaseHelper(this);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

        btnOtroCm = findViewById(R.id.btn_oto_cm_fe);
        fabCmNext = findViewById(R.id.fab_next_mal_fe);

        edtHerbicida = findViewById(R.id.edt_her_cm_fe);
        edtCantidad = findViewById(R.id.edt_can_cm_fe);
        edtJornales = findViewById(R.id.edt_jr_cm_fe);
        edtCostoH = findViewById(R.id.edt_ch_cm_fe);

        txtCntMal = findViewById(R.id.tx_tit_cm);

        if (hortalizas.valorTempCosPv == 1) {
            txtCntMal.setText(getString(R.string.name_mod_ctm_pv));
        } else if (hortalizas.valorTempCosOi == 1) {
            txtCntMal.setText(getString(R.string.name_mod_ctm_oi));
        }

        btnOtroCm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Boolean valorFert = false;

                valorFert = validTabTipoMaleza();

                if (valorFert) {
                    aggControlMaleza();
                    startActivity(new Intent(getBaseContext(), ControlMalezas.class));
                } else {
                    Snackbar snackbar = Snackbar.make(v, "Ingrese el tipo de maleza", Snackbar.LENGTH_SHORT);
                    snackbar.show();
                }
            }
        });

        fabCmNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Boolean valorFert = false;

                valorFert = validTabTipoMaleza();

                if (valorFert) {
                    aggControlMaleza();
                    startActivity(new Intent(getBaseContext(), ControlPlagasEnferm.class));
                } else {
                    Snackbar snackbar = Snackbar.make(v, "Ingrese el tipo de maleza", Snackbar.LENGTH_SHORT);
                    snackbar.show();
                }
            }
        });

    }

    private Boolean validTabTipoMaleza() {
        if (txtTipoMaleza != null) {
            txtHerbicida = edtHerbicida.getText().toString();
            txtCantidad = edtCantidad.getText().toString();
            txtJornales = edtJornales.getText().toString();
            txtCostoH = edtCostoH.getText().toString();

            MALGR = txtTipoMaleza;
            CONQMGR = txtControl;
            HERGR = txtHerbicida;
            HERCANGR = txtCantidad;
            HJORGR = txtJornales;
            CHERGR = txtCostoH;

            VariblesGlobalesHortalizas.MALGR = MALGR;
            VariblesGlobalesHortalizas.CONQMGR = CONQMGR;
            VariblesGlobalesHortalizas.HERGR = HERGR;
            VariblesGlobalesHortalizas.HERCANGR = HERCANGR;
            VariblesGlobalesHortalizas.HJORGR = HJORGR;
            VariblesGlobalesHortalizas.CHERGR = CHERGR;

            return true;
        }
        return false;
    }

    private void aggControlMaleza() {
        boolean insertarData = db.addControlMaleza();
        if (insertarData == true) {
            Toast.makeText(this, "Datos insertados correctamente", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Algo salio mal", Toast.LENGTH_LONG).show();
        }
    }


    @Override
    public void onBackPressed() {

    }

    public void tipoMaleza(View view) {
        boolean checkedTipo = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.rd_hj_ach:
                if (checkedTipo) {
                    txtTipoMaleza = "Hoja ancha";
                }
                break;
            case R.id.rd_hj_dlg:
                if (checkedTipo) {
                    txtTipoMaleza = "Hoja delgada";
                }
                break;
        }

    }

    public void tipoControl(View view) {
        boolean checkedTipo = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.rd_cm_qui:
                if (checkedTipo) {
                    txtControl = "Químico";
                }
                break;
            case R.id.rd_cm_mnl:
                if (checkedTipo) {
                    txtControl = "Manual";
                }
                break;
        }
    }


}
