package com.example.geosegalmex.apicola;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.geosegalmex.R;
import com.example.geosegalmex.apicola.variables_apicola.VariablesModuloSiete;
import com.example.geosegalmex.unidadcaracterizacionhortalizas.db.DatabaseHelper;

import java.util.ArrayList;

public class AlimentacionApicola extends AppCompatActivity {
    Button btnApialimentacion;
    //APICOLA 4
    private String	APIALIM	= null;//	¿Alimenta a sus colonias?
    private String	APICONALI	= null;//	¿Explique cuándo o en qué condiciones alimenta las colonias?
    private String	APICONALIO	= null;//	Otro (especifique)

    private String	APINORAZ	= null;//	¿En caso de no alimentar las colonias explique las razones?
    private String	APINORAZO	= null;//	Otro


    EditText edt1;
    EditText edt2;

    //VALORES DE LA TABLA INGREDIENTES
    ArrayList<String> listaIngredientes;
    EditText edt1_1;
    EditText edt1_2;
    EditText edt2_1;
    EditText edt2_2;
    EditText edt3_1;
    EditText edt3_2;
    EditText edt4_1;
    EditText edt4_2;
    EditText edt5_1;
    EditText edt5_2;
    private DatabaseHelper db;
    //++++++++++++++++++++++++

    //VALORES DE LA ALIMENTACION
    private String APITIPALI = null;
    private String APIPER = null;
    private String APIFORA = null;
    private String APIFORAO = null;
    private String APIINGS = null;
    private String APIINGSO = null;
    private String APIINGE = null;
    private String APIINGEO = null;
    private String APICOSA = null;


    ArrayList<String> listaAlimentacion;

    ArrayList<String> listAlimentarSosteni;
    EditText edtMesAlimnSoste;
    EditText edtOtrAliSoste;
    EditText edtOtrIngreSoste;
    EditText edtCostoSoste;
    ArrayList<String> listIngrediSosteni;

    ArrayList<String> listAlimentarEstim;
    EditText edtMesAlimnEstim;
    EditText edtOtrAliEstim;
    EditText edtOtrIngreEstim;
    EditText edtCostoEstim;
    ArrayList<String> listIngrediEstim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alimentacion_apicola);
        btnApialimentacion = (Button)findViewById(R.id.apicola_next_alimentacion);
        db  = new DatabaseHelper(this);
        listaAlimentacion = new ArrayList<>();
        listaIngredientes = new ArrayList<>();
        listAlimentarSosteni = new ArrayList<>();
        listIngrediSosteni = new ArrayList<>();
        listAlimentarEstim = new ArrayList<>();
        listIngrediEstim = new ArrayList<>();

        edt1 = findViewById(R.id.edtAlimentotro);
        edt2 = findViewById(R.id.edtNoalimcolotro);

        edt1_1 = findViewById(R.id.edt_ing_api_1_1);
        edt1_2 = findViewById(R.id.edt_ing_api_1_2);
        edt2_1 = findViewById(R.id.edt_ing_api_2_1);
        edt2_2 = findViewById(R.id.edt_ing_api_2_2);
        edt3_1 = findViewById(R.id.edt_ing_api_3_1);
        edt3_2 = findViewById(R.id.edt_ing_api_3_2);
        edt4_1 = findViewById(R.id.edt_ing_api_4_1);
        edt4_2 = findViewById(R.id.edt_ing_api_4_2);
        edt5_1 = findViewById(R.id.edt_ing_api_5_1);
        edt5_2 = findViewById(R.id.edt_ing_api_5_2);


        // ++++++++++++++++ Sostenible
        edtOtrAliSoste = findViewById(R.id.edtFormassosteotro);
        edtMesAlimnSoste = findViewById(R.id.edtAlimsostenimientomeses);
        edtOtrIngreSoste = findViewById(R.id.edtAlimsostenimientoingredotro);
        edtCostoSoste = findViewById(R.id.edtAlimsostenimientocosto);

        // +++++++++++++++Estimulo
        edtMesAlimnEstim = findViewById(R.id.edtAlimestimulomeses);
        edtOtrAliEstim = findViewById(R.id.edtAlimestimulootro);
        edtOtrIngreEstim = findViewById(R.id.edtAlimestimuloingredotro);
        edtCostoEstim = findViewById(R.id.edtAlimestimulocosto);

        btnApialimentacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                asignacionValores();

                startActivity(new Intent(AlimentacionApicola.this, ReproduccionApicola.class));
            }
        });
    }

    private void asignacionValores() {
        if(!edt1.getText().toString().isEmpty()){
            APICONALIO  = edt1.getText().toString();
        }

        if(!edt2.getText().toString().isEmpty()){
            APINORAZO  = edt2.getText().toString();
        }

        VariablesModuloSiete.APIALIM =	APIALIM;//	¿Alimenta a sus colonias?
        VariablesModuloSiete.APICONALI = APICONALI;//	¿Explique cuándo o en qué condiciones alimenta las colonias?
        VariablesModuloSiete.APICONALIO = APICONALIO;//	Otro (especifique)

        VariablesModuloSiete.APINORAZ =	APINORAZ;//	¿En caso de no alimentar las colonias explique las razones?
        VariablesModuloSiete.APINORAZO = APINORAZO;//	Otro


        //Tabla ingredientes
        int i;
        String cantidad = null;
        String costo = null;
        if(listaIngredientes.size() !=0){
            for(i =0; i < listaIngredientes.size(); i++){

                cantidad = null;
                costo = null;

                if(listaIngredientes.get(i) == "Miel"){
                    if(!edt1_1.getText().toString().isEmpty()){
                        cantidad = edt1_1.getText().toString();
                    }
                    if(!edt1_2.getText().toString().isEmpty()){
                        costo = edt1_2.getText().toString();
                    }
                    aggIngredientes(listaIngredientes.get(i), cantidad, costo);
                }

                if(listaIngredientes.get(i) == "Azúcar en polvo"){
                    if(!edt2_1.getText().toString().isEmpty()){
                        cantidad = edt2_1.getText().toString();
                    }
                    if(!edt2_2.getText().toString().isEmpty()){
                        costo = edt2_2.getText().toString();
                    }
                    aggIngredientes(listaIngredientes.get(i), cantidad, costo);
                }

                if(listaIngredientes.get(i) == "Jarabe de azúcar"){
                    if(!edt3_1.getText().toString().isEmpty()){
                        cantidad = edt3_1.getText().toString();
                    }
                    if(!edt3_2.getText().toString().isEmpty()){
                        costo = edt3_2.getText().toString();
                    }
                    aggIngredientes(listaIngredientes.get(i), cantidad, costo);
                }

                if(listaIngredientes.get(i) == "Polen"){
                    if(!edt4_1.getText().toString().isEmpty()){
                        cantidad = edt4_1.getText().toString();
                    }
                    if(!edt4_2.getText().toString().isEmpty()){
                        costo = edt4_2.getText().toString();
                    }
                    aggIngredientes(listaIngredientes.get(i), cantidad, costo);
                }

                if(listaIngredientes.get(i) == "Harinas"){
                    if(!edt5_1.getText().toString().isEmpty()){
                        cantidad = edt5_1.getText().toString();
                    }
                    if(!edt5_2.getText().toString().isEmpty()){
                        costo = edt5_2.getText().toString();
                    }
                    aggIngredientes(listaIngredientes.get(i), cantidad, costo);
                }

            }
        }


        //Tabla Alimentos

        String txtMeseAlimentar;
        String txtFormasAlimentar;
        String txtOtroAlimentar;
        String txtOtroIngreAlimentar;
        String txtIngreAlimentar;
        String txtCostoIngreSoste;
        String valor1 = null;
        String valor2 = null;

        String valor3 = null;
        String valor4 = null;
        String comodin1 = null;
        String comodin2 = null;
        if(listaAlimentacion.size() != 0) {
         for(int j = 0; j < listaAlimentacion.size(); j++) {
             txtMeseAlimentar = null;
             txtFormasAlimentar = null;
             txtOtroAlimentar = null;
             txtOtroIngreAlimentar = null;
             txtIngreAlimentar = null;
             txtCostoIngreSoste = null;
             valor1 = null;
             valor2 = null;
             valor3 = null;
             valor4 = null;



             if(listaAlimentacion.get(j) == "De sostenimiento") {

                 if(!listAlimentarSosteni.isEmpty()) {
                     for (i = 0; i < listAlimentarSosteni.size(); i++) {
                         if (valor1 == null) {
                             valor1 =  listAlimentarSosteni.get(i);
                         } else if (valor1 != null) {
                             valor1 = valor1 + "," +  listAlimentarSosteni.get(i);
                         }
                     }
                 }

                 txtFormasAlimentar = valor1;

                 if(!listIngrediSosteni.isEmpty()) {
                     for (i = 0; i < listIngrediSosteni.size(); i++) {
                         if (valor2 == null) {
                             valor2 =  listIngrediSosteni.get(i);
                         } else if (valor2 != null) {
                             valor2 = valor2 + "," +  listIngrediSosteni.get(i);
                         }
                     }
                 }

                 txtIngreAlimentar = valor2;

                 if(!edtMesAlimnSoste.getText().toString().isEmpty()){
                     txtMeseAlimentar = edtMesAlimnSoste.getText().toString();
                 }

                 if (!edtOtrAliSoste.getText().toString().isEmpty()) {
                     txtOtroAlimentar = edtOtrAliSoste.getText().toString();
                 }

                 if (!edtOtrIngreSoste.getText().toString().isEmpty()) {
                     txtOtroIngreAlimentar = edtOtrIngreSoste.getText().toString();
                 }


                 if (!edtCostoSoste.getText().toString().isEmpty()) {
                     txtCostoIngreSoste = edtCostoSoste.getText().toString();
                 }
                aggAlimentacion(listaAlimentacion.get(j),txtMeseAlimentar,txtFormasAlimentar,txtOtroAlimentar, txtIngreAlimentar, txtOtroIngreAlimentar, comodin1, comodin2,txtCostoIngreSoste);
             }

             if(listaAlimentacion.get(j) == "De estimulo"){

                 if(!listAlimentarEstim.isEmpty()) {
                     for (i = 0; i < listAlimentarEstim.size(); i++) {
                         if (valor3 == null) {
                             valor3 =  listAlimentarEstim.get(i);
                         } else if (valor3 != null) {
                             valor3 = valor3 + "," +  listAlimentarEstim.get(i);
                         }
                     }
                 }

                 txtFormasAlimentar = valor3;


                 if(!listIngrediEstim.isEmpty()) {
                     for (i = 0; i < listIngrediEstim.size(); i++) {
                         if (valor4 == null) {
                             valor4 =  listIngrediEstim.get(i);
                         } else if (valor4 != null) {
                             valor2 = valor4 + "," +  listIngrediEstim.get(i);
                         }
                     }
                 }

                 txtIngreAlimentar = valor4;


                 if(!edtMesAlimnEstim.getText().toString().isEmpty()){
                     txtMeseAlimentar = edtMesAlimnEstim.getText().toString();
                 }

                 if(!edtOtrAliEstim.getText().toString().isEmpty()){
                     txtOtroAlimentar = edtOtrAliEstim.getText().toString();
                 }

                 if(!edtOtrIngreEstim.getText().toString().isEmpty()){
                     txtOtroIngreAlimentar   = edtOtrIngreEstim.getText().toString();
                 }

                 if(!edtCostoEstim.getText().toString().isEmpty()){
                     txtCostoIngreSoste = edtCostoEstim.getText().toString();
                 }

                 aggAlimentacion(listaAlimentacion.get(j),txtMeseAlimentar,txtFormasAlimentar,txtOtroAlimentar,comodin1, comodin2, txtIngreAlimentar, txtOtroIngreAlimentar, txtCostoIngreSoste);

             }

         }
        }
    }

    private void aggAlimentacion(String s, String txtMeseAlimentar, String txtFormasAlimentar, String txtOtroAlimentar, String comodin1, String comodin2, String comodin3, String comodin4, String txtCostoIngreSoste){
    // (s, txtMeseAlimentar, txtFormasAlimentar, txtOtroAlimentar, comodin1, comodin2, comodin3, comodin4, txtCostoIngreSoste)

        boolean insertarData = db.addDatosAlimentacion(s, txtMeseAlimentar, txtFormasAlimentar, txtOtroAlimentar, comodin1, comodin2, comodin3, comodin4, txtCostoIngreSoste);
        if(insertarData == true) {
            Toast.makeText(this, "Datos insertados correctamente", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Algo salio mal", Toast.LENGTH_LONG).show();
        }


    }


    private void aggIngredientes(String s, String cantidad, String costo) {
        boolean insertarData = db.addDatosApicolaIngredientes(s, cantidad, costo);
        if(insertarData == true) {
            Toast.makeText(this, "Datos insertados correctamente", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Algo salio mal", Toast.LENGTH_LONG).show();
        }
    }

    public void alimentaColonia(View view) {
        boolean checkedTipo = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.radioSialimcolonias:
                if (checkedTipo) {
                    APIALIM = "Si";
                }
                break;
            case R.id.radioNoalimcolonias:
                if (checkedTipo) {
                    APIALIM = "No";
                }
                break;
        }
    }

    public void condicionesColonias(View view) {
        boolean checkedTipo = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.radioAlimentepoccritica:
                if (checkedTipo) {
                    APICONALI = "Época crítica";
                    edt1.setEnabled(false);
                    edt1.setText("");
                }
                break;
            case R.id.radioAlimentestpostura:
                if (checkedTipo) {
                    APICONALI = "Estimular postura";
                    edt1.setEnabled(false);
                    edt1.setText("");
                }
                break;
            case R.id.radioAlimentprevflorac:
                if (checkedTipo) {
                    APICONALI = "Previo a la floración";
                    edt1.setEnabled(false);
                    edt1.setText("");
                }
                break;
            case R.id.radioAlimentotro:
                if (checkedTipo) {
                    APICONALI = "Otro";
                    edt1.setEnabled(true);
                }
                break;
        }
    }

    public void alimentarColonias(View view) {
        boolean checkedTipo = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.radioNoalimcoldesconocimiento:
                if (checkedTipo) {
                    APINORAZ = "Desconocimiento";
                    edt2.setEnabled(false);
                    edt2.setText("");
                }
                break;
            case R.id.radioNoalimcolcostos:
                if (checkedTipo) {
                    APINORAZ = "Costos";
                    edt2.setEnabled(false);
                    edt2.setText("");
                }
                break;
            case R.id.radioNoalimcoldisponibilidad:
                if (checkedTipo) {
                    APINORAZ = "Disponibilidad";
                    edt2.setEnabled(false);
                    edt2.setText("");
                }
                break;
            case R.id.radioNoalimcolotro:
                if (checkedTipo) {
                    APINORAZ = "Otro";
                    edt2.setEnabled(true);
                }
                break;
        }
    }

    public void cantidadesIngredientes(View view) {
        boolean checkedTipo = ((CheckBox) view).isChecked();

        switch (view.getId()) {
            case R.id.checkAlimingmiel:
                if (checkedTipo) {
                    listaIngredientes.add("Miel");
                    edt1_1.setEnabled(true);
                    edt1_2.setEnabled(true);
                } else {
                    listaIngredientes.remove("Miel");
                    edt1_1.setEnabled(false);
                    edt1_2.setEnabled(false);
                    edt1_1.setText("");
                    edt1_2.setText("");
                }
                break;
            case R.id.checkAlimingazucar:
                if (checkedTipo) {
                    listaIngredientes.add("Azúcar en polvo");
                    edt2_1.setEnabled(true);
                    edt2_2.setEnabled(true);
                } else {
                    listaIngredientes.remove("Azúcar en polvo");
                    edt2_1.setEnabled(false);
                    edt2_2.setEnabled(false);
                    edt2_1.setText("");
                    edt2_2.setText("");
                }
                break;
            case R.id.checkAlimingjarabe:
                if (checkedTipo) {
                    listaIngredientes.add("Jarabe de azúcar");
                    edt3_1.setEnabled(true);
                    edt3_2.setEnabled(true);
                } else {
                    listaIngredientes.remove("Jarabe de azúcar");
                    edt3_1.setEnabled(false);
                    edt3_2.setEnabled(false);
                    edt3_1.setText("");
                    edt3_2.setText("");
                }
                break;
            case R.id.checkAlimingpolen:
                if (checkedTipo) {
                    listaIngredientes.add("Polen");
                    edt4_1.setEnabled(true);
                    edt4_2.setEnabled(true);
                } else {
                    listaIngredientes.remove("Polen");
                    edt4_1.setEnabled(false);
                    edt4_2.setEnabled(false);
                    edt4_1.setText("");
                    edt4_2.setText("");
                }
                break;
            case R.id.checkAlimingharinas:
                if (checkedTipo) {
                    listaIngredientes.add("Harinas");
                    edt5_1.setEnabled(true);
                    edt5_2.setEnabled(true);
                } else {
                    listaIngredientes.remove("Harinas");
                    edt5_1.setEnabled(false);
                    edt5_2.setEnabled(false);
                    edt5_1.setText("");
                    edt5_2.setText("");
                }
                break;
        }
    }

    public void tipoAlimentacionAPi(View view) {
        boolean checkedTipo = ((CheckBox) view).isChecked();

        switch (view.getId()) {
            case R.id.checkAlimcaracsostenimiento:
                if (checkedTipo) {
                    listaAlimentacion.add("De sostenimiento");
                } else {
                    listaAlimentacion.remove("De sostenimiento");
                }
                break;
            case R.id.checkEstimulo:
                if (checkedTipo) {
                    listaAlimentacion.add("De estimulo");
                } else {
                    listaAlimentacion.remove("De estimulo");
                }
                break;
        }
    }

    public void alimentarSosteniiento(View view) {
        boolean checkedTipo = ((CheckBox) view).isChecked();

        switch (view.getId()) {
            case R.id.checkFormassostedirecto:
                if (checkedTipo) {
                    listAlimentarSosteni.add("Directo");
                } else {
                    listAlimentarSosteni.remove("Directo");
                }
                break;
            case R.id.checkFormassostelimentador:
                if (checkedTipo) {
                    listAlimentarSosteni.add("Con alimentador");
                } else {
                    listAlimentarSosteni.remove("Con alimentador");
                }
                break;
            case R.id.checkFormassostebolplastico:
                if (checkedTipo) {
                    listAlimentarSosteni.add("Bolsas de plástico");
                } else {
                    listAlimentarSosteni.remove("Bolsas de plástico");
                }
                break;
            case R.id.checkFormassosteotro:
                if (checkedTipo) {
                    listAlimentarSosteni.add("Otro");
                    edtOtrAliSoste.setEnabled(true);
                } else {
                    listAlimentarSosteni.remove("Otro");
                    edtOtrAliSoste.setText("");
                    edtOtrAliSoste.setEnabled(false);
                }
                break;
        }
    }

    public void ingredienteUtilizarSostenimi(View view) {
        boolean checkedTipo = ((CheckBox) view).isChecked();

        switch (view.getId()) {
            case R.id.checkAlimsostenimientoingredjarabe:
                if (checkedTipo) {
                    listIngrediSosteni.add("Jarabe de azúcar");
                } else {
                    listIngrediSosteni.remove("Jarabe de azúcar");
                }
                break;
            case R.id.checkAlimsostenimientoingredazucar:
                if (checkedTipo) {
                    listIngrediSosteni.add("Azúcar granulada");
                } else {
                    listIngrediSosteni.remove("Azúcar granulada");
                }
                break;
            case R.id.checkAlimsostenimientoingredmelazas:
                if (checkedTipo) {
                    listIngrediSosteni.add("Melazas");
                } else {
                    listIngrediSosteni.remove("Melazas");
                }
                break;
            case R.id.checkAlimsostenimientoingredotro:
                if (checkedTipo) {
                    listIngrediSosteni.add("Otra");
                    edtOtrIngreSoste.setEnabled(true);
                } else {
                    listIngrediSosteni.remove("Otra");
                    edtOtrIngreSoste.setText("");
                    edtOtrIngreSoste.setEnabled(false);
                }
                break;
        }
    }

    public void alimentarEstimulo(View view) {
        boolean checkedTipo = ((CheckBox) view).isChecked();

        switch (view.getId()) {
            case R.id.checkFormasestimulodirecto:
                if (checkedTipo) {
                    listAlimentarEstim.add("Directo");
                } else {
                    listAlimentarEstim.remove("Directo");
                }
                break;
            case R.id.checkFormasestimuloalimentador:
                if (checkedTipo) {
                    listAlimentarEstim.add("Con alimentador");
                } else {
                    listAlimentarEstim.remove("Con alimentador");
                }
                break;
            case R.id.checkFormasestimulobolplastico:
                if (checkedTipo) {
                    listAlimentarEstim.add("Bolsas de plástico");
                } else {
                    listAlimentarEstim.remove("Bolsas de plástico");
                }
                break;
            case R.id.checkFormasestimulootro:
                if (checkedTipo) {
                    edtOtrAliEstim.setEnabled(true);
                    listAlimentarEstim.add("Otro");
                } else {
                    listAlimentarEstim.remove("Otro");
                    edtOtrAliEstim.setEnabled(false);
                    edtOtrAliEstim.setText("");
                }
                break;
        }
    }

    public void ingredienteEstimulo(View view) {
        boolean checkedTipo = ((CheckBox) view).isChecked();

        switch (view.getId()) {
            case R.id.checkAlimestimuloingredpastcalabaza:
                if (checkedTipo) {
                    listIngrediEstim.add("Pasta de calabaza");
                } else {
                    listIngrediEstim.remove("Pasta de calabaza");
                }
                break;
            case R.id.checkAlimestimuloingredmiel:
                if (checkedTipo) {
                    listIngrediEstim.add("Miel");
                } else {
                    listIngrediEstim.remove("Miel");
                }
                break;

            case R.id.checkAlimestimuloingredpolen:
                if (checkedTipo) {
                    listIngrediEstim.add("Polen");
                } else {
                    listIngrediEstim.remove("Polen");
                }
                break;

            case R.id.checkAlimestimuloingredsoya:
                if (checkedTipo) {
                    listIngrediEstim.add("Pasta de soya");
                } else {
                    listIngrediEstim.remove("Pasta de soya");
                }
                break;
            case R.id.checkAlimestimuloingredotro:
                if (checkedTipo) {
                    listIngrediEstim.add("Otra");
                    edtOtrIngreEstim.setEnabled(true);
                } else {
                    listIngrediEstim.remove("Otra");
                    edtOtrIngreEstim.setText("");
                    edtOtrIngreEstim.setEnabled(false);
                }
                break;
        }
    }

    @Override
    public void onBackPressed() {

    }
}
