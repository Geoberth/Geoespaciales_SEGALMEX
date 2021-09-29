package com.example.geosegalmex.unidadproduccion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.geosegalmex.IdentificacionCuestionario;
import com.example.geosegalmex.R;
import com.example.geosegalmex.unidadcaracterizacionhortalizas.db.DatabaseHelper;
import com.example.geosegalmex.unidadproduccion.variables.VariablesGlobalesUpf;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

public class FuenteAgua extends AppCompatActivity {
    LinearLayout rios;
    LinearLayout arroyos;
    LinearLayout manantial;
    LinearLayout presas;
    LinearLayout pozo;
    LinearLayout laguna;
    LinearLayout tomaDomicilio;
    LinearLayout ollaAgua;
    LinearLayout bordoAlm;
    LinearLayout trataAgua;

    TextView textViewTitulo;

    Button btnAggFunAg;
    ExtendedFloatingActionButton btnNxt;
    private DatabaseHelper db;


    private 	String	FDAGUA;
    private 	String	PAAGUA;
    private 	String	PAAGUAPA;
    private 	String	PAAGUACO;

    Boolean rtuFueAgua;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fuente_agua);
        db         = new DatabaseHelper(this);

        rios            = findViewById(R.id.ln_rios);
     /*   arroyos         = findViewById(R.id.ln_arroyos);
        manantial       = findViewById(R.id.ln_manantial);
        presas          = findViewById(R.id.ln_presas);
        pozo            = findViewById(R.id.ln_pozo);
        laguna          = findViewById(R.id.ln_laguna);
        tomaDomicilio   = findViewById(R.id.ln_toma_domicilio);
        ollaAgua        = findViewById(R.id.ln_olla_agua);
        bordoAlm        = findViewById(R.id.ln_bordo_alm);
        trataAgua       = findViewById(R.id.ln_trata_agua);
       */
        textViewTitulo  = findViewById(R.id.id_rios);

        btnAggFunAg = findViewById(R.id.btn_fun_agua);
        btnNxt      = findViewById(R.id.fab_next_pro_fue_agu);

        Spinner spinner = (Spinner) findViewById(R.id.fun_agua);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.fuenteagua, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);



        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Log.e("========>>", parent.getSelectedItem().toString());
                FDAGUA = parent.getSelectedItem().toString();

                Boolean funCAgua = valdiFunteAgua(FDAGUA);
                if (funCAgua == false){
                    btnAggFunAg.setEnabled(true);
                    rtuFueAgua = false;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btnAggFunAg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insrtFunAgua(FDAGUA);
                startActivity(new Intent(getApplication(), FuenteAgua.class));
            }
        });

        btnNxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // if (FDAGUA != "Especifique una fuente de agua"){}
                insrtFunAgua(FDAGUA);
                startActivity(new Intent(getApplication(), IdentificacionCuestionario.class));
            }
        });
    }

    private void aggActFuenteAgua() {
        boolean insertarData = db.addFuenteAgua();
        if(insertarData == true) {
            Toast.makeText(this, "Datos insertados correctamente", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Algo salio mal", Toast.LENGTH_LONG).show();
        }
    }

    private void insrtFunAgua(String fdagua) {
        if(rtuFueAgua == false) {
            VariablesGlobalesUpf.FDAGUA = fdagua;
            VariablesGlobalesUpf.PAAGUA = PAAGUA;
            VariablesGlobalesUpf.PAAGUAPA = PAAGUAPA;
            VariablesGlobalesUpf.PAAGUACO = PAAGUACO;
            aggActFuenteAgua();
        }

    }


    private Boolean valdiFunteAgua(String fdagua) {

        switch (fdagua) {
            case "Especifique una fuente de agua":
                textViewTitulo.setText("Especifique una fuente de agua");
                FDAGUA = null;
                btnAggFunAg.setEnabled(false);
                rtuFueAgua = true;
                cleanFuenteAgua();
                return true;
            //break;
        }

        return false;
    }


    private void cleanFuenteAgua() {
        PAAGUA = null;
        PAAGUAPA =null;
        PAAGUACO = null;
    }





    // ++++++++++++++++Rios ++++++++++++++++++++++++++++++++++++++++
    public void agriRios(View view) {
        boolean checkedTipo = ((RadioButton) view).isChecked();
        switch (view.getId()) {
            case R.id.rd_agr_ri_si:
                if (checkedTipo) {
                    PAAGUA = "Si";
                }
                break;
            case R.id.rd_agr_ri_no:
                if (checkedTipo) {
                    PAAGUA = "No";
                }
                break;
        }

    }

    public void ganaRios(View view) {
        boolean checkedTipo = ((RadioButton) view).isChecked();
        switch (view.getId()) {
            case R.id.rd_gn_ri_si:
                if (checkedTipo) {
                    PAAGUAPA = "Si";
                }
                break;
            case R.id.rd_gn_ri_no:
                if (checkedTipo) {
                    PAAGUAPA = "No";
                }
                break;
        }
    }


    public void corralRios(View view) {
        boolean checkedTipo = ((RadioButton) view).isChecked();
        switch (view.getId()) {
            case R.id.rd_cr_ri_si:
                if (checkedTipo) {
                    PAAGUACO = "Si";
                }
                break;
            case R.id.rd_cr_ri_no:
                if (checkedTipo) {
                    PAAGUACO = "No";
                }
                break;
        }
    }
    @Override
    public void onBackPressed() {

    }
}
