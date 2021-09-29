package com.example.geosegalmex.unidadcaracterizacionhortalizas;

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
import com.example.geosegalmex.unidadcaracterizacionhortalizas.db.DatabaseHelper;
import com.example.geosegalmex.unidadcaracterizacionhortalizas.variables.VariblesGlobalesHortalizas;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class ControlPlagasEnfermB extends AppCompatActivity {
    Button btnOtroPlagaEnf;
    ExtendedFloatingActionButton fabNextPlagaEnf;

    EditText edtPlagasNm;
    EditText edtOtroControl;
    EditText edtProducto;
    EditText edtCantidad;
    EditText edtSuperficie;
    EditText edtJornales;
    EditText edtCostoPrd;

    //Variables save
    String txtPlagasNm = null;
    String txtTipoControl = null;
    String txtOtroControl = null;
    String txtProducto = null;
    String txtCantidad = null;
    String txtSuperficie = null;
    String txtJornales = null;
    String txtCostoPrd = null;

    private String PLAGA = null;
    private String PLATIPCOT = null;
    private String  PLATCOGR = null;
    private String PLAPROGR = null;
    private String PLACANTGR = null;
    private String SUPHOR = null;
    private String PEJORGR = null;
    private String INSPROGR = null;
    private DatabaseHelper db;
/*

            PLAGA;
            PLATIPCOT;
            PLATCOGR;
            PLAPROGR;
            PLACANTGR;
            SUPHOR;
            PEJORGR;
            INSPROGR;

 */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_control_plagas_enferm_b);

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        db = new DatabaseHelper(this);

        btnOtroPlagaEnf = findViewById(R.id.btn_oto_plg_fe);
        fabNextPlagaEnf = findViewById(R.id.fab_next_enf_b_fe);

        edtPlagasNm= findViewById(R.id.edt_ps_pl_ls_fe);
        edtOtroControl= findViewById(R.id.edt_qbo_pl_ls_fe);

        edtProducto= findViewById(R.id.edt_pr_pl_ls_fe);
        edtCantidad= findViewById(R.id.edt_cn_pl_ls_fe);
        edtSuperficie= findViewById(R.id.edt_sup_pl_ls_fe);
        edtJornales= findViewById(R.id.edt_jr_pl_ls_fe);
        edtCostoPrd= findViewById(R.id.edt_cp_pl_ls_fe);


        btnOtroPlagaEnf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Boolean valorFert = false;
                Boolean errorPlagas = false;

                valorFert = validControlPlagas();

                if(valorFert) {
                    if(txtTipoControl == "otro" && edtOtroControl.getText().toString().isEmpty()){
                        errorPlagas = true;
                        Snackbar snackbar = Snackbar.make(v, "Ingrese el tipo de Plaga...Otro", Snackbar.LENGTH_SHORT);
                        snackbar.show();
                    }else if(errorPlagas == false) {
                        inserControlPlagas();
                        startActivity(new Intent(getBaseContext(), ControlPlagasEnfermB.class));
                    }
                }else{
                    Snackbar snackbar = Snackbar.make(v, "Ingrese el tipo de Plaga", Snackbar.LENGTH_SHORT);
                    snackbar.show();
                }
            }
        });

        fabNextPlagaEnf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Boolean valorFert = false;
                Boolean errorPlaga = false;

                valorFert = validControlPlagas();

                if(valorFert) {
                    if(txtTipoControl == "otro" && edtOtroControl.getText().toString().isEmpty()){
                        errorPlaga = true;
                        Snackbar snackbar = Snackbar.make(v, "Ingrese el tipo de Plaga...Otro", Snackbar.LENGTH_SHORT);
                        snackbar.show();
                    }else if(errorPlaga == false) {
                        inserControlPlagas();
                        startActivity(new Intent(getBaseContext(), ControlPlagasEnfermC.class));
                    }
                }else{
                    Snackbar snackbar = Snackbar.make(v, "Ingrese el tipo de Plaga", Snackbar.LENGTH_SHORT);
                    snackbar.show();
                }

            }
        });
    }

    private void inserControlPlagas() {
        //VariblesGlobalesHortalizas;
        PLAGA = txtPlagasNm;
        PLATIPCOT = txtTipoControl;
        PLATCOGR = txtOtroControl;
        PLAPROGR = txtProducto;
        PLACANTGR = txtCantidad;
        SUPHOR = txtSuperficie;
        PEJORGR = txtJornales;
        INSPROGR = txtCostoPrd;
        VariblesGlobalesHortalizas.PLAGA = PLAGA;
        VariblesGlobalesHortalizas.PLATIPCOT = PLATIPCOT;
        VariblesGlobalesHortalizas.PLATCOGR = PLATCOGR;
        VariblesGlobalesHortalizas.PLAPROGR = PLAPROGR;
        VariblesGlobalesHortalizas.PLACANTGR = PLACANTGR;
        VariblesGlobalesHortalizas.SUPHOR = SUPHOR;
        VariblesGlobalesHortalizas.PEJORGR = PEJORGR;
        VariblesGlobalesHortalizas.INSPROGR =INSPROGR;
        aggControlPlagas();

    }

    private void aggControlPlagas() {
        //addControlPlagas
        boolean insertarData = db.addControlPlagas();
        if(insertarData == true) {
            Toast.makeText(this, "Datos insertados correctamente", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Algo salio mal", Toast.LENGTH_LONG).show();
        }
    }

    private Boolean validControlPlagas() {
        if(!edtPlagasNm.getText().toString().isEmpty()){
            txtPlagasNm    = edtPlagasNm.getText().toString();
            txtOtroControl = edtOtroControl.getText().toString();
            txtProducto    = edtProducto.getText().toString();
            txtCantidad    = edtCantidad.getText().toString();
            txtSuperficie  = edtSuperficie.getText().toString();
            txtJornales    = edtJornales.getText().toString();
            txtCostoPrd    = edtCostoPrd.getText().toString();
            return true;
        }
        return false;
    }

    @Override
    public void onBackPressed() {

    }

    public void tipoControlPlaga(View view) {
        boolean checkedTipo = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.rd_qm_tp:
                if (checkedTipo) {
                    txtTipoControl = "Químico";
                    edtOtroControl.setText("");
                    edtOtroControl.setEnabled(false);
                }
                break;
            case R.id.rd_bg_tp:
                if (checkedTipo) {
                    txtTipoControl = "Biológico";
                    edtOtroControl.setText("");
                    edtOtroControl.setEnabled(false);
                }
                break;
            case R.id.rd_otr_tp:
                if (checkedTipo) {
                    txtTipoControl = "otro";
                    edtOtroControl.setEnabled(true);
                }
                break;
        }
    }
}
