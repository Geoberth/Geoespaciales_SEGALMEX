package com.example.geosegalmex.apicola;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.geosegalmex.IdentificacionCuestionario;
import com.example.geosegalmex.R;
import com.example.geosegalmex.apicola.variables_apicola.VariablesModuloSiete;
import com.example.geosegalmex.unidadcaracterizacionhortalizas.db.DatabaseHelper;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

public class AspectosProductivosApicola extends AppCompatActivity {

    ExtendedFloatingActionButton btnNext;

    //Apicola 9
    public static String	PROCOL = null;//	¿Actualmente tiene producción de sus colonias?
    public static String	FACLIMMI = null;//	¿Explique cuáles son los factores que limitan la producción de miel?
    public static String	FACLIMMIO	= null;//	Otro
    public static String	RAZNOPMI	= null;//	En caso de no producir la mayor parte de los productos, explique las razones?
    public static String	RAZNOPMIO	= null;//	Otro

    EditText edt1;
    EditText edt2;
    private DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aspectos_productivos_apicola);
        db = new DatabaseHelper(this);
        edt1 = findViewById(R.id.edtAspectprodfactoreslimprodmielotro);
        edt2 = findViewById(R.id.edtAspectprodnoproducirotro);
        btnNext = findViewById(R.id.pecu_next_pecuario_aspectproductivos);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                asignacionValores();
                aggApicola();
                startActivity(new Intent(getBaseContext(), IdentificacionCuestionario.class));
            }
        });
    }

    private void asignacionValores() {
        if(!edt1.getText().toString().isEmpty()){
            FACLIMMIO = edt1.getText().toString();
        }

        if(!edt2.getText().toString().isEmpty()){
            RAZNOPMIO = edt2.getText().toString();
        }

        VariablesModuloSiete.PROCOL = PROCOL;//	¿Actualmente tiene producción de sus colonias?
        VariablesModuloSiete.FACLIMMI = FACLIMMI;//	¿Explique cuáles son los factores que limitan la producción de miel?
        VariablesModuloSiete.FACLIMMIO	= FACLIMMIO;//	Otro
        VariablesModuloSiete.RAZNOPMI	= RAZNOPMI;//	En caso de no producir la mayor parte de los productos, explique las razones?
        VariablesModuloSiete.RAZNOPMIO	= RAZNOPMIO;//	Otro
    }

    private void aggApicola() {
        boolean insertarData = db.addDatosApicola();
        if(insertarData == true) {
            Toast.makeText(this, "Datos insertados correctamente", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Algo salio mal", Toast.LENGTH_LONG).show();
        }
    }

    public void actualProdColonias(View view) {
        boolean checkedTipo = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.radioAspectprodsimiel:
                if (checkedTipo) {
                    PROCOL = "Si";
                }
                break;
            case R.id.radioAspectprodnomiel:
                if (checkedTipo) {
                    PROCOL = "No";
                }
                break;
        }
    }

    public void factoresLimtMiel(View view) {
        boolean checkedTipo = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.radioAspectprodfactoreslimprodmielecon:
                if (checkedTipo) {
                    FACLIMMI = "Económicos";
                    edt1.setEnabled(false);
                    edt1.setText("");
                }
                break;
            case R.id.radioAspectprodfactoreslimprodmielclima:
                if (checkedTipo) {
                    FACLIMMI = "Climáticos";
                    edt1.setEnabled(false);
                    edt1.setText("");
                }
                break;
            case R.id.radioAspectprodfactoreslimprodmieltecnol:
                if (checkedTipo) {
                    FACLIMMI = "Técnicos/ Tecnologías";
                    edt1.setEnabled(false);
                    edt1.setText("");
                }
                break;
            case R.id.radioAspectprodfactoreslimprodmielotro:
                if (checkedTipo) {
                    FACLIMMI = "Otro";
                    edt1.setEnabled(true);
                }
                break;
        }
    }

    public void noproduceMiel(View view) {
        boolean checkedTipo = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.radioAspectprodnoproducirecon:
                if (checkedTipo) {
                    RAZNOPMI = "Económicos";
                    edt2.setEnabled(false);
                    edt2.setText("");
                }
                break;
            case R.id.radioAspectprodnoproducirdesconoc:
                if (checkedTipo) {
                    RAZNOPMI = "Desconocimiento";
                    edt2.setEnabled(false);
                    edt2.setText("");
                }
                break;
            case R.id.radioAspectprodnoproducirtecn:
                if (checkedTipo) {
                    RAZNOPMI = "Técnicos";
                    edt2.setEnabled(false);
                    edt2.setText("");
                }
                break;
            case R.id.radioAspectprodnoproducirotro:
                if (checkedTipo) {
                    RAZNOPMI = "Otro";
                    edt2.setEnabled(true);
                }
                break;
        }
    }

    @Override
    public void onBackPressed() {

    }
}
