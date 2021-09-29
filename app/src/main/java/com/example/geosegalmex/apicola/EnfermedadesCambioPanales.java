package com.example.geosegalmex.apicola;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.geosegalmex.R;
import com.example.geosegalmex.apicola.variables_apicola.VariablesModuloSiete;
import com.example.geosegalmex.unidadcaracterizacionhortalizas.db.DatabaseHelper;

public class EnfermedadesCambioPanales extends AppCompatActivity {
    Button btnApienfermpanales;
    Button btnOtro;

    private String ENFPAN = null;
    private String ENFPANO = null;
    private String ENFCON = null;
    private String ENFMED = null;
    private String ENFMEDOTR = null;
    private String COSMED = null;
    private String ENFPERAP = null;


    EditText edt1;
    EditText edt2;
    EditText edt3;
    EditText edt4;

    private DatabaseHelper db;
    //APICOLA 7
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enfermedades_cambio_panales);
        db  = new DatabaseHelper(this);
        btnApienfermpanales = (Button)findViewById(R.id.apicola_next_enfermedad_panales);
        btnOtro = findViewById(R.id.btn_otr_enf_api);

        edt1 = findViewById(R.id.edtEnfermedadescambpanalesotros);
        edt2 = findViewById(R.id.edtEnfermedadescambpanalesmedotro);
        edt3 = findViewById(R.id.edtEnfermedadescambpanalesmedcostos);
        edt4 = findViewById(R.id.edtEnfermedadescambpanalesmedperaplic);




        btnApienfermpanales.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                asignacionValores();
                aggEnfermedades();
                startActivity(new Intent(getBaseContext(), CosechaApicola.class));
            }
        });

        btnOtro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                asignacionValores();
                aggEnfermedades();
                startActivity(new Intent(getBaseContext(), EnfermedadesCambioPanales.class));
            }
        });
    }

    private void aggEnfermedades() {
        boolean insertarData = db.addDatosEnfermedades();
        if(insertarData == true) {
            Toast.makeText(this, "Datos insertados correctamente", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Algo salio mal", Toast.LENGTH_LONG).show();
        }
    }

    private void asignacionValores() {
        if(!edt1.getText().toString().isEmpty()){
            ENFPANO = edt1.getText().toString();
        }

        if(!edt2.getText().toString().isEmpty()){
            ENFMEDOTR = edt2.getText().toString();
        }

        if(!edt3.getText().toString().isEmpty()){
            COSMED = edt3.getText().toString();
        }

        if(!edt4.getText().toString().isEmpty()){
            ENFPERAP = edt4.getText().toString();
        }

        VariablesModuloSiete.ENFPAN = ENFPAN;
        VariablesModuloSiete.ENFPANO = ENFPANO;
        VariablesModuloSiete.ENFCON = ENFCON;
        VariablesModuloSiete.ENFMED = ENFMED;
        VariablesModuloSiete.ENFMEDOTR = ENFMEDOTR;
        VariablesModuloSiete.COSMED = COSMED;
        VariablesModuloSiete.ENFPERAP = ENFPERAP;
    }

    public void enfermCambioPanales(View view) {
        boolean checkedTipo = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.radioEnfermedadescambpanalesvarroa:
                if (checkedTipo) {
                    ENFPAN = "Varroa";
                    edt1.setEnabled(false);
                    edt1.setText("");
                }
                break;
            case R.id.radioEnfermedadescambpanalesloques:
                if (checkedTipo) {
                    ENFPAN = "Loques";
                    edt1.setEnabled(false);
                    edt1.setText("");
                }
                break;
            case R.id.radioEnfermedadescambpanalesotros:
                if (checkedTipo) {
                    ENFPAN = "Otro";
                    edt1.setEnabled(true);
                }
                break;
        }
    }

    public void consldProblemGrave(View view) {
        boolean checkedTipo = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.radioEnfcambpanalconsideracprobmatacolonia:
                if (checkedTipo) {
                    ENFCON = "Es un problema serio que mata a la colonia";
                }
                break;
            case R.id.radioEnfcambpanalconsideracdismproducmiel:
                if (checkedTipo) {
                    ENFCON = "Disminuye la producción de miel, pero no mata la colonia";
                }
                break;
        }
    }

    public void medicamentoAPicultura(View view) {
        boolean checkedTipo = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.radioEnfermedadescambpanalesmedapist:
                if (checkedTipo) {
                    ENFMED = "Apistan";
                    edt2.setEnabled(false);
                    edt2.setText("");
                }
                break;
            case R.id.radioEnfermedadescambpanalesmedbayv:
                if (checkedTipo) {
                    ENFMED = "Bayvarol";
                    edt2.setEnabled(false);
                    edt2.setText("");
                }
                break;

            case R.id.radioEnfermedadescambpanalesmedacform:
                if (checkedTipo) {
                    ENFMED = "Acido fórmico";
                    edt2.setEnabled(false);
                    edt2.setText("");
                }
                break;

            case R.id.radioEnfermedadescambpanalesmedelzang:
                if (checkedTipo) {
                    ENFMED = "Elimina la cría de zánganos";
                    edt2.setEnabled(false);
                    edt2.setText("");
                }
                break;

            case R.id.radioEnfermedadescambpanalesmedaphumos:
                if (checkedTipo) {
                    ENFMED = "Aplica humos";
                    edt2.setEnabled(false);
                    edt2.setText("");
                }
                break;

            case R.id.radioEnfermedadescambpanalesmedtabmed:
                if (checkedTipo) {
                    ENFMED = "Tablitas medicadas";
                    edt2.setEnabled(false);
                    edt2.setText("");
                }
                break;

            case R.id.radioEnfermedadescambpanalesmedcolmes:
                if (checkedTipo) {
                    ENFMED = "Colmesan";
                    edt2.setEnabled(false);
                    edt2.setText("");
                }
                break;

            case R.id.radioEnfermedadescambpanalesmedtimol:
                if (checkedTipo) {
                    ENFMED = "Timol";
                    edt2.setEnabled(false);
                    edt2.setText("");
                }
                break;
            case R.id.radioEnfermedadescambpanalesmedotro:
                if (checkedTipo) {
                    ENFMED = "Otro";
                    edt2.setEnabled(true);
                }
                break;
        }
    }

    @Override
    public void onBackPressed() {

    }
}
