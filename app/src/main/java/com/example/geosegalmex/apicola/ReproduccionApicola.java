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

public class ReproduccionApicola extends AppCompatActivity {
    Button btnApireproduccion;

    //APICOLA 5
    private String APIENJ = null;//	¿Ha habido enjambrazón en su apiario?
    private String APIMESENJ = null;//	¿En qué mes ha habido enjambrazón en su apiario?
    private String APIDIVCOL = null;//	¿Ha realizado la división de sus colonias?
    private String APICARDC = null;//	¿Usted qué características considera, para realizar la división de colonias?
    private String OTRAPICARC = null;//	Otra característica de división de colonias
    private String APICAPENJ = null;//	¿Actualmente captura enjambres?
    private String APIRAZCE = null;//	¿Explique la razón para capturar enjambres?
    private String APIRAZCEO = null;//	Otro
    private String APIPROENJ = null;//	¿Qué aprovecha de la captura del enjambre?
    private String APIPROENJO = null;//	Otro
    private String APIUNICOL = null;//	¿Usted ha unido colmenas?
    private String APIACTUC = null;//	¿Explique qué actividades realiza para unir colmenas?
    private String APIACTUCO = null;//	Otro
    private String APICREI = null;//	¿Actualmente cambia sus reinas?
    private String APIOBJREI = null;//	¿Explique cuál es el objetivo de cambiar las reinas?
    private String APIOBJREIO = null;//	Otro
    private String APICAMR = null;//	¿Cada cuándo acostumbra cambiarlas?
    private String APIOBTREI = null;//	¿De dónde obtiene las reinas que utiliza en su apiario?
    private String APICOSABE = null;//	¿Si las compra cual es el costo?

    EditText edt1;
    EditText edt2;
    EditText edt3;
    EditText edt4;
    EditText edt5;
    EditText edt6;
    EditText edt7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reproduccion_apicola);
        btnApireproduccion = (Button) findViewById(R.id.apicola_next_reproduccion);

        edt1 = findViewById(R.id.edtRepdivisionotro);
        edt2 = findViewById(R.id.edtReprodactcaptotros);
        edt3 = findViewById(R.id.edtReprodactcaptenjaprovotro);
        edt4 = findViewById(R.id.edtReprodunioncolmactivotra);
        edt5 = findViewById(R.id.edtReprodobjcambioreinaotra);
        edt6 = findViewById(R.id.edtReptiempocambioreinas);
        edt7 = findViewById(R.id.edtReprodobtienereinasapicosto);

        final Spinner spinnerDos = (Spinner) findViewById(R.id.idSpinfrecasistenctecnica);
        ArrayAdapter<CharSequence> adapterDos = ArrayAdapter.createFromResource(this,
                R.array.combo_meses, android.R.layout.simple_spinner_item);
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


        btnApireproduccion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                asignacionValores();
                startActivity(new Intent(ReproduccionApicola.this, SanidadApicola.class));
            }
        });
    }

    private void asignacionValores() {
        if(!edt1.getText().toString().isEmpty()){
            OTRAPICARC = edt1.getText().toString();
        }

        if(!edt2.getText().toString().isEmpty()){
            APIRAZCEO = edt2.getText().toString();
        }

        if(!edt3.getText().toString().isEmpty()){
            APIPROENJO = edt3.getText().toString();
        }

        if(!edt4.getText().toString().isEmpty()){
            APIACTUCO = edt4.getText().toString();
        }

        if(!edt5.getText().toString().isEmpty()){
            APIOBJREIO = edt5.getText().toString();
        }
        if(!edt6.getText().toString().isEmpty()){
            APICAMR = edt6.getText().toString();
        }

        if(!edt7.getText().toString().isEmpty()){
            APICOSABE = edt7.getText().toString();
        }

        VariablesModuloSiete.APIENJ = APIENJ;//	¿Ha habido enjambrazón en su apiario?
        VariablesModuloSiete.APIMESENJ = APIMESENJ;//	¿En qué mes ha habido enjambrazón en su apiario?
        VariablesModuloSiete.APIDIVCOL = APIDIVCOL;//	¿Ha realizado la división de sus colonias?
        VariablesModuloSiete.APICARDC = APICARDC;//	¿Usted qué características considera, para realizar la división de colonias?
        VariablesModuloSiete.OTRAPICARC = OTRAPICARC;//	Otra característica de división de colonias
        VariablesModuloSiete.APICAPENJ = APICAPENJ;//	¿Actualmente captura enjambres?
        VariablesModuloSiete.APIRAZCE = APIRAZCE;//	¿Explique la razón para capturar enjambres?
        VariablesModuloSiete.APIRAZCEO = APIRAZCEO;//	Otro
        VariablesModuloSiete.APIPROENJ = APIPROENJ;//	¿Qué aprovecha de la captura del enjambre?
        VariablesModuloSiete.APIPROENJO = APIPROENJO;//	Otro
        VariablesModuloSiete.APIUNICOL = APIUNICOL;//	¿Usted ha unido colmenas?
        VariablesModuloSiete.APIACTUC = APIACTUC;//	¿Explique qué actividades realiza para unir colmenas?
        VariablesModuloSiete.APIACTUCO = APIACTUCO;//	Otro
        VariablesModuloSiete.APICREI = APICREI;//	¿Actualmente cambia sus reinas?
        VariablesModuloSiete.APIOBJREI = APIOBJREI;//	¿Explique cuál es el objetivo de cambiar las reinas?
        VariablesModuloSiete.APIOBJREIO = APIOBJREIO;//	Otro
        VariablesModuloSiete.APICAMR = APICAMR;//	¿Cada cuándo acostumbra cambiarlas?
        VariablesModuloSiete.APIOBTREI = APIOBTREI;//	¿De dónde obtiene las reinas que utiliza en su apiario?
        VariablesModuloSiete.APICOSABE = APICOSABE;//	¿Si las compra cual es el costo?

    }

    private void condicionColmenas(String causaSiniestro, int position) {
        if (position == 0) {
            APIMESENJ = null;
        } else if (position != 0) {
            APIMESENJ = causaSiniestro;
        }
    }

    public void enjmbraApiario(View view) {
        boolean checkedTipo = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.radioSienjambrazon:
                if (checkedTipo) {
                    APIENJ = "Si";
                }
                break;
            case R.id.radioNoenjambrazon:
                if (checkedTipo) {
                    APIENJ = "No";
                }
                break;
        }
    }

    public void revisionColonias(View view) {
        boolean checkedTipo = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.radioSidivisioncolonias:
                if (checkedTipo) {
                    APIDIVCOL = "Si";
                }
                break;
            case R.id.radioNodivisioncolonias:
                if (checkedTipo) {
                    APIDIVCOL = "No";
                }
                break;
        }
    }

    public void caracteristicasDivColonias(View view) {
        boolean checkedTipo = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.radioRepdivisionbuenareina:
                if (checkedTipo) {
                    APICARDC = "Buena reina";
                    edt1.setEnabled(false);
                    edt1.setText("");
                }
                break;
            case R.id.radioRepdivisionpobabundante:
                if (checkedTipo) {
                    APICARDC = "Población abundante";
                    edt1.setEnabled(false);
                    edt1.setText("");
                }
                break;
            case R.id.radioRepdivisionexistprovmiel:
                if (checkedTipo) {
                    APICARDC = "Existencia de provisiones abundantes de miel";
                    edt1.setEnabled(false);
                    edt1.setText("");
                }
                break;

            case R.id.radioRepdivisionconepoca:
                if (checkedTipo) {
                    APICARDC = "Conocer la época según la región";
                    edt1.setEnabled(false);
                    edt1.setText("");
                }
                break;

            case R.id.radioRepdivisionotro:
                if (checkedTipo) {
                    APICARDC = "Otros";
                    edt1.setEnabled(true);
                }
                break;
        }
    }

    public void capturaEnjambres(View view) {
        boolean checkedTipo = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.radioSirepcaptenjambres:
                if (checkedTipo) {
                    APICAPENJ = "Si";
                }
                break;
            case R.id.radioNorepcaptenjambres:
                if (checkedTipo) {
                    APICAPENJ = "No";
                }
                break;
        }
    }

    public void razonCapturaEnjambre(View view) {
        boolean checkedTipo = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.radioReprodactcaptcreccolmena:
                if (checkedTipo) {
                    APIRAZCE = "Crecimiento de la colmena";
                    edt2.setEnabled(false);
                    edt2.setText("");
                }
                break;
            case R.id.radioReprodactcapteconomica:
                if (checkedTipo) {
                    APIRAZCE = "Económicos";
                    edt2.setEnabled(false);
                    edt2.setText("");
                }
                break;
            case R.id.radioReprodactcaptotros:
                if (checkedTipo) {
                    APIRAZCE = "Otros";
                    edt2.setEnabled(true);
                }
                break;
        }
    }

    public void aprovechamientoEjambre(View view) {
        boolean checkedTipo = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.radioReprodactcaptenjaprovmiel:
                if (checkedTipo) {
                    APIPROENJ = "La miel";
                    edt3.setEnabled(false);
                    edt3.setText("");
                }
                break;
            case R.id.radioReprodactcaptenjaprovcera:
                if (checkedTipo) {
                    APIPROENJ = "La cera";
                    edt3.setEnabled(false);
                    edt3.setText("");
                }
                break;
            case R.id.radioReprodactcaptenjaprovnucabe:
                if (checkedTipo) {
                    APIPROENJ = "Núcleo de abejas";
                    edt3.setEnabled(false);
                    edt3.setText("");
                }
                break;
            case R.id.radioReprodactcaptenjaprovotro:
                if (checkedTipo) {
                    APIPROENJ = "Otros";
                    edt3.setEnabled(true);
                }
                break;
        }
    }

    public void unionColmenas(View view) {
        boolean checkedTipo = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.radioSireprodunioncolm:
                if (checkedTipo) {
                    APIUNICOL = "Si";
                }
                break;
            case R.id.radioNoreprodunioncolm:
                if (checkedTipo) {
                    APIUNICOL = "No";
                }
                break;
        }
    }

    public void actividadesUnirColmenas(View view) {
        boolean checkedTipo = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.radioReprodunioncolmactivcolmdeb:
                if (checkedTipo) {
                    APIACTUC = "Colmenas débiles";
                    edt4.setEnabled(false);
                    edt4.setText("");
                }
                break;
            case R.id.radioReprodunioncolmactivperdreina:
                if (checkedTipo) {
                    APIACTUC = "Perdida de reina";
                    edt4.setEnabled(false);
                    edt4.setText("");
                }
                break;
            case R.id.radioReprodunioncolmactivotra:
                if (checkedTipo) {
                    APIACTUC = "Otra";
                    edt4.setEnabled(true);
                }
                break;

        }
    }

    public void actualmenteReinas(View view) {
        boolean checkedTipo = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.radioSireprodcambioreina:
                if (checkedTipo) {
                    APICREI = "Si";
                }
                break;
            case R.id.radioNoreprodcambioreina:
                if (checkedTipo) {
                    APICREI = "No";
                }
                break;
        }
    }

    public void objetivoCambioReinas(View view) {
        boolean checkedTipo = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.radioReprodobjcambioreinarencolm:
                if (checkedTipo) {
                    APIOBJREI = "Renovar la colmena";
                    edt5.setEnabled(false);
                    edt5.setText("");
                }
                break;
            case R.id.radioReprodobjcambioreinaevitcons:
                if (checkedTipo) {
                    APIOBJREI = "Evitar consanguineidad";
                    edt5.setEnabled(false);
                    edt5.setText("");
                }
                break;
            case R.id.radioReprodobjcambioreinaotra:
                if (checkedTipo) {
                    APIOBJREI = "Otra";
                    edt5.setEnabled(true);
                }
                break;
        }
    }

    public void obtieneReinas(View view) {
        boolean checkedTipo = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.radioReprodobtienereinasproduceapi:
                if (checkedTipo) {
                    APIOBTREI = "Las produce en su apiario";
                }
                break;
            case R.id.radioReprodobtienereinascompnocertifapi:
                if (checkedTipo) {
                    APIOBTREI = "Las compras en apiarios no certificados";
                }
                break;
            case R.id.radioReprodobtienereinascompcertifapi:
                if (checkedTipo) {
                    APIOBTREI = "Las compras en apiarios certificados";
                }
                break;
            case R.id.radioReprodobtienereinasprodcompapi:
                if (checkedTipo) {
                    APIOBTREI = "Parte produce parte compra";
                }
                break;
        }
    }

    @Override
    public void onBackPressed() {

    }
}
