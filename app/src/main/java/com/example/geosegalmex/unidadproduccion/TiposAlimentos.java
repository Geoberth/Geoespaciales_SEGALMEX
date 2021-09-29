package com.example.geosegalmex.unidadproduccion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

import com.example.geosegalmex.R;
import com.example.geosegalmex.unidadproduccion.variables.VariablesGlobalesUpf;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class TiposAlimentos extends AppCompatActivity {


    ExtendedFloatingActionButton fabAliUno;

    private String	PCOMID	= null;	//	Text
    private String	PSINCOMID	= null;	//	Text
    private String	ALISAVA	= null;	//	Text


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tipos_alimentos);

        fabAliUno = findViewById(R.id.fab_next_pro_aluno);

        fabAliUno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(PCOMID == null || PSINCOMID == null || ALISAVA == null){
                    Snackbar snackbar = Snackbar.make(v, "Verique los campos incompletos", Snackbar.LENGTH_SHORT);
                    snackbar.show();
                }else {
                    VariablesGlobalesUpf.PCOMID = PCOMID;    //	Text
                    VariablesGlobalesUpf.PSINCOMID = PSINCOMID;    //	Text
                    VariablesGlobalesUpf.ALISAVA = ALISAVA;    //	Text
                    startActivity(new Intent(getApplication(), TiposAlimentosDos.class));
                }
            }
        });
    }

    @Override
    public void onBackPressed() {

    }

    public void mesesDineroFalta(View view) {
        boolean checkedTipo = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.rg_com_acabara_si:
                if (checkedTipo) {
                    PCOMID = "Si";
                }
                break;
            case R.id.rg_com_acabara_no:
                if (checkedTipo) {
                    PCOMID = "No";
                }
                break;
        }
    }


    public void sincomida(View view) {
        boolean checkedTipo = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.rg_sin_comida_si:
                if (checkedTipo) {
                    PSINCOMID = "Si";
                }
                break;
            case R.id.rg_sin_comida_no:
                if (checkedTipo) {
                    PSINCOMID = "No";
                }
                break;
        }
    }

    public void sinalimentacion(View view) {
        boolean checkedTipo = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.rg_sin_sana_si:
                if (checkedTipo) {
                    ALISAVA = "Si";
                }
                break;
            case R.id.rg_sin_sana_no:
                if (checkedTipo) {
                    ALISAVA = "No";
                }
                break;
        }
    }
}
