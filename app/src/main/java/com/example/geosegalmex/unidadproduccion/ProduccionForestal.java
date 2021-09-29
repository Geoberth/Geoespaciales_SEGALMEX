package com.example.geosegalmex.unidadproduccion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

import com.example.geosegalmex.R;
import com.example.geosegalmex.unidadproduccion.variables.VariablesGlobalesUpf;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

public class ProduccionForestal extends AppCompatActivity {
    ExtendedFloatingActionButton fabProFore;
    private String PRODFORM = null;    //	Integer
    private String PRODFORNM = null;    //	Integer
    private String PRODFORPM = null;    //	Integer
    private String PRODFOROT = null;    //	Integer
    private String PRODFOROTACT = null;    //	Integer

    EditText edtPRODFORM;
    EditText edtPRODFORNM;
    EditText edtPRODFORPM;
    EditText edtPRODFOROT;
    EditText edtPRODFOROTACT;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produccion_forestal);

        fabProFore = findViewById(R.id.fab_next_pro_fores);

        edtPRODFORM = findViewById(R.id.ext_madera_edit);
        edtPRODFORNM = findViewById(R.id.ext_madera_nomaderables_edit);
        edtPRODFORPM = findViewById(R.id.recoleccion_medicinales_edit);
        edtPRODFOROT = findViewById(R.id.otro_forestal_edit);
        edtPRODFOROTACT = findViewById(R.id.otro_forestal_edit_nm);


        edtPRODFOROTACT.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                //System.out.println(s.toString() + "Texto Antes");
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                System.out.println(s.toString()+ "Texto Changed");
                if(s.length() == 0){
                  borraCotEdt();
                }else if(s.length() != 0){
                    activateEdit();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                //System.out.println(s.toString() + "Texto despues");

            }
        });
        fabProFore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Boolean vExtracMad = extracMad();
                Boolean vExtraNoMad = extraNoMad();
                Boolean vRecolMed = recolMed();
                Boolean vOtroMad = otroMad();

          //      if(!vExtracMad || !vExtraNoMad || !vRecolMed || !vOtroMad ){
                if(!edtPRODFOROTACT.getText().toString().isEmpty()){
                    PRODFOROTACT = edtPRODFOROTACT.getText().toString();
                }else{
                    PRODFOROTACT = null;
                }

                    VariablesGlobalesUpf.PRODFORM = PRODFORM;    //	Integer
                    VariablesGlobalesUpf.PRODFORNM = PRODFORNM;    //	Integer
                    VariablesGlobalesUpf.PRODFORPM = PRODFORPM;    //	Integer
                    VariablesGlobalesUpf.PRODFOROT = PRODFOROT;    //	Integer
                    VariablesGlobalesUpf.PRODFOROTACT = PRODFOROTACT;    //	Integer
                    startActivity(new Intent(getApplication(), ProduccionAcuicola.class));
            //    }else {
            //        Snackbar snackbar = Snackbar.make(v, "Verique los campos incompletos", Snackbar.LENGTH_SHORT);
            //        snackbar.show();
            //    }
            }
        });
    }

    private void borraCotEdt() {
        edtPRODFOROT.setEnabled(false);
        edtPRODFOROT.setText("");
    }

    private void activateEdit() {
        edtPRODFOROT.setEnabled(true);
    }

    private Boolean otroMad() {
        if(edtPRODFOROT.getText().toString().isEmpty()){
            return  true;
        }else if(!edtPRODFOROT.getText().toString().isEmpty()){
            //PRODFOROT = Integer.parseInt(edtPRODFOROT.getText().toString());
            PRODFOROT = edtPRODFOROT.getText().toString();
            return false;
        }
        return false;
    }

    private Boolean recolMed() {
        if(edtPRODFORPM.getText().toString().isEmpty()){
            return  true;
        }else if(!edtPRODFORPM.getText().toString().isEmpty()){
            //PRODFORPM = Integer.parseInt(edtPRODFORPM.getText().toString());
            PRODFORPM = edtPRODFORPM.getText().toString();
            return false;
        }
        return false;
    }


    private Boolean extraNoMad() {
        if(edtPRODFORNM.getText().toString().isEmpty()){
            return  true;
        }else if(!edtPRODFORNM.getText().toString().isEmpty()){
            //PRODFORNM = Integer.parseInt(edtPRODFORNM.getText().toString());
            PRODFORNM = edtPRODFORNM.getText().toString();
            return false;
        }
        return false;
    }

    private Boolean extracMad() {
        if(edtPRODFORM.getText().toString().isEmpty()){
            return  true;
        }else if(!edtPRODFORM.getText().toString().isEmpty()){
            //PRODFORM = Integer.parseInt(edtPRODFORM.getText().toString());
            PRODFORM = edtPRODFORM.getText().toString();
            return false;
        }
        return false;
    }

    @Override
    public void onBackPressed() {

    }
}
