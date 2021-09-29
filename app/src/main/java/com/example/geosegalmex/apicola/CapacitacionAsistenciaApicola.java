package com.example.geosegalmex.apicola;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;

import com.example.geosegalmex.R;
import com.example.geosegalmex.apicola.variables_apicola.VariablesModuloSiete;

public class CapacitacionAsistenciaApicola extends AppCompatActivity {
    Button btnApicolacapacasistenc;
    //APICOLA 3
    private String	APICAP = null;//	¿Usted fue capacitado en apicultura el año pasado?
    private String	APICAPAC = null;//	¿En qué fue capacitado?
    private String	APICAPACO = null;//	Otro (especifique)
    private String	APIRESCAP = null;//	¿Quién le proporcionó la capacitación?
    private String	APIRESCAPO = null;//	Otro (especifique)
    private String	APINOCAP = null;//	¿En caso de no haberse capacitado mencione por qué razón?
    private String	APINOCAPO = null;//	Otro (especifique)
    private String	APIINSCAP = null;//	¿Explique de qué institución recibió asistencia técnica?
    private String	APIINSCAPO = null;//	Otro (especifique)
    private String	APITEMASE = null;//	¿En qué tema fue asesorado?
    private String	APITEMASEO = null;//	Otro (especifique)
    private String	APIFRECASI = null;//	¿Con qué frecuencia recibió asistencia técnica el año pasado?
    private String	APIFCASIO = null;//	Otro (especifique)

    EditText edt1;
    EditText edt2;
    EditText edt3;
    EditText edt4;
    EditText edt5;
    EditText edt6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_capacitacion_asistencia_apicola);
        btnApicolacapacasistenc = (Button)findViewById(R.id.apicola_next_capacitacion_asistencia);

        edt1 = findViewById(R.id.edtApicapacotro);
        edt2 = findViewById(R.id.edtProporccapotro);
        edt3 = findViewById(R.id.edtProporcnocapotro);
        edt4 = findViewById(R.id.edtInstotro);
        edt5 = findViewById(R.id.edtInstaseotro);
        edt6 = findViewById(R.id.edtFrecasistotro);


        final Spinner spinnerDos = (Spinner) findViewById(R.id.idSpinfrecasistenctecnica);
        ArrayAdapter<CharSequence> adapterDos = ArrayAdapter.createFromResource(this,
                R.array.frecuencia_asistencia, android.R.layout.simple_spinner_item);
        adapterDos.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerDos.setAdapter(adapterDos);
        spinnerDos.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Log.e("========>>", parent.getSelectedItem().toString());
                String causaSiniestro;
                causaSiniestro = parent.getSelectedItem().toString();


                condicionColmenas(causaSiniestro, position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Log.e("========>>", parent.getSelectedItem().toString());
            }
        });


        btnApicolacapacasistenc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                asignacionValores();
                startActivity(new Intent(CapacitacionAsistenciaApicola.this, AlimentacionApicola.class));
            }
        });
    }

    private void condicionColmenas(String causaSiniestro, int position) {
        if (position == 0) {
            APIFRECASI = null;
            edt6.setEnabled(false);
            edt6.setText("");
        } else if (position != 0 && position < 7) {
            APIFRECASI = causaSiniestro;
            edt6.setEnabled(false);
            edt6.setText("");
        } else if (position == 7) {
            APIFRECASI = causaSiniestro;
            edt6.setEnabled(true);
        }
    }

    private void asignacionValores() {
        if(!edt1.getText().toString().isEmpty()){
            APICAPACO = edt1.getText().toString();
        }

        if(!edt2.getText().toString().isEmpty()){
            APIRESCAPO = edt2.getText().toString();
        }

        if(!edt3.getText().toString().isEmpty()){
            APINOCAPO = edt3.getText().toString();
        }

        if(!edt4.getText().toString().isEmpty()){
            APIINSCAPO = edt4.getText().toString();
        }

        if(!edt5.getText().toString().isEmpty()){
            APITEMASEO = edt5.getText().toString();
        }

        if(!edt6.getText().toString().isEmpty()){
            APIFCASIO = edt6.getText().toString();
        }

        VariablesModuloSiete.APICAP = APICAP;//	¿Usted fue capacitado en apicultura el año pasado?
        VariablesModuloSiete.APICAPAC = APICAPAC;//	¿En qué fue capacitado?
        VariablesModuloSiete.APICAPACO = APICAPACO;//	Otro (especifique)
        VariablesModuloSiete.APIRESCAP = APIRESCAP;//	¿Quién le proporcionó la capacitación?
        VariablesModuloSiete.APIRESCAPO = APIRESCAPO;//	Otro (especifique)
        VariablesModuloSiete.APINOCAP = APINOCAP;//	¿En caso de no haberse capacitado mencione por qué razón?
        VariablesModuloSiete.APINOCAPO = APINOCAPO;//	Otro (especifique)
        VariablesModuloSiete.APIINSCAP = APIINSCAP;//	¿Explique de qué institución recibió asistencia técnica?
        VariablesModuloSiete.APIINSCAPO = APIINSCAPO;//	Otro (especifique)
        VariablesModuloSiete.APITEMASE = APITEMASE;//	¿En qué tema fue asesorado?
        VariablesModuloSiete.APITEMASEO = APITEMASEO;//	Otro (especifique)
        VariablesModuloSiete.APIFRECASI = APIFRECASI;//	¿Con qué frecuencia recibió asistencia técnica el año pasado?
        VariablesModuloSiete.APIFCASIO = APIFCASIO;//	Otro (especifique)

    }

    public void capacitacionApicultura(View view) {
        boolean checkedTipo = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.radioSicapactec:
                if (checkedTipo) {
                    APICAP = "Si";
                }
                break;
            case R.id.radioNocapactec:
                if (checkedTipo) {
                    APICAP = "No";
                }
                break;
        }
    }

    public void tipoCapacitacion(View view) {
        boolean checkedTipo = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.radioApiorggrupo:
                if (checkedTipo) {
                    APICAPAC = "Sobre organización del grupo";
                    edt1.setEnabled(false);
                    edt1.setText("");
                }
                break;
            case R.id.radioApiaprovapiario:
                if (checkedTipo) {
                    APICAPAC = "Sobre manejo, control y aprovechamientos de apiarios";
                    edt1.setEnabled(false);
                    edt1.setText("");
                }
                break;
            case R.id.radioApicomercializacion:
                if (checkedTipo) {
                    APICAPAC = "Sobre comercialización";
                    edt1.setEnabled(false);
                    edt1.setText("");
                }
                break;
            case R.id.radioApicapacotro:
                if (checkedTipo) {
                    APICAPAC = "Otro";
                    edt1.setEnabled(true);
                }
                break;
        }
    }

    public void proporcionaCapacitacion(View view) {
        boolean checkedTipo = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.radioProporccapprom:
                if (checkedTipo) {
                    APIRESCAP = "Productores – promotores (otros campesinos)";
                    edt2.setEnabled(false);
                    edt2.setText("");
                }
                break;
            case R.id.radioProporccaptec:
                if (checkedTipo) {
                    APIRESCAP = "Los técnicos y/o coordinadores de algún programa";
                    edt2.setEnabled(false);
                    edt2.setText("");
                }
                break;
            case R.id.radioProporcpersinst:
                if (checkedTipo) {
                    APIRESCAP = "Personal de instituciones educativas y de investigación";
                    edt2.setEnabled(false);
                    edt2.setText("");
                }
                break;
            case R.id.radioProporccapotro:
                if (checkedTipo) {
                    APIRESCAP = "Otro";
                    edt2.setEnabled(true);
                }
                break;
        }
    }

    public void noCapacitacion(View view) {
        boolean checkedTipo = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.radioProporcnocapdesc:
                if (checkedTipo) {
                    APINOCAP = "Desconocimiento";
                    edt3.setEnabled(false);
                    edt3.setText("");
                }
                break;
            case R.id.radioProporcnocapfaltatiemp:
                if (checkedTipo) {
                    APINOCAP = "Falta de tiempo";
                    edt3.setEnabled(false);
                    edt3.setText("");

                }
                break;
            case R.id.radioProporcnocapdist:
                if (checkedTipo) {
                    APINOCAP = "Agrupaciones de productores";
                    edt3.setEnabled(false);
                    edt3.setText("");
                }
                break;
            case R.id.radioProporcnocapnonec:
                if (checkedTipo) {
                    APINOCAP = "No lo considera necesario";
                    edt3.setEnabled(false);
                    edt3.setText("");
                }
                break;
            case R.id.radioProporcnocapotro:
                if (checkedTipo) {
                    APINOCAP = "Otro";
                    edt3.setEnabled(true);
                }
                break;
        }

    }

    public void institucionAsistencia(View view) {
        boolean checkedTipo = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.radioInstensinv:
                if (checkedTipo) {
                    APIINSCAP = "Institución, enseñanza e investigación";
                    edt4.setEnabled(false);
                    edt4.setText("");
                }
                break;
            case R.id.radioInstentgob:
                if (checkedTipo) {
                    APIINSCAP = "Entidades de gobierno";
                    edt4.setEnabled(false);
                    edt4.setText("");
                }
                break;
            case R.id.radioInstagrupacprod:
                if (checkedTipo) {
                    APIINSCAP = "Distancia";
                    edt4.setEnabled(false);
                    edt4.setText("");
                }
                break;
            case R.id.radioInstotro:
                if (checkedTipo) {
                    APIINSCAP = "Otro";
                    edt4.setEnabled(true);
                }
                break;
        }
    }

    public void temaAsesoramiento(View view) {
        boolean checkedTipo = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.radioInstasesogenetica:
                if (checkedTipo) {
                    APITEMASE = "Genética en apicultura (reproducción, desarrollo)";
                    edt5.setEnabled(false);
                    edt5.setText("");
                }
                break;
            case R.id.radioInstaseprodorganica:
                if (checkedTipo) {
                    APITEMASE = "Producción orgánica";
                    edt5.setEnabled(false);
                    edt5.setText("");
                }
                break;
            case R.id.radioInstasesomanejo:
                if (checkedTipo) {
                    APITEMASE = "Manejo";
                    edt5.setEnabled(false);
                    edt5.setText("");
                }
                break;
            case R.id.radioInstaseotro:
                if (checkedTipo) {
                    APITEMASE = "Otro";
                    edt5.setEnabled(true);
                }
                break;
        }
    }

    @Override
    public void onBackPressed() {

    }
}
