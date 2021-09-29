package com.example.geosegalmex.unidadproduccion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.geosegalmex.R;
import com.example.geosegalmex.unidadcaracterizacionhortalizas.db.DatabaseHelper;
import com.example.geosegalmex.unidadproduccion.model.ActividadAgricola;
import com.example.geosegalmex.unidadproduccion.model.ActividadAgricolaAdapter;
import com.example.geosegalmex.unidadproduccion.variables.VariablesGlobalesUpf;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class ProduccionAgricola extends AppCompatActivity {
    private ActividadAgricolaAdapter adapterAgricola;
    private ListView listViewAgricola;
    private List<ActividadAgricola> actividadAgricolaList;
    AutoCompleteTextView editTextComplete;
    TextView seleccionValor;
    TextView seleccuinResult;
    TextView supHa;
    EditText edicionSup;
    Button addse;
    Button listaClean;
    String valorSel = null;
    String valorSup;
    ExtendedFloatingActionButton fabProAgricola;

    private DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produccion_agricola);
        String[] produccioAgricola = getResources().getStringArray(R.array.produccionagricola);

        seleccionValor      = findViewById(R.id.seleccion);
        seleccuinResult     = findViewById(R.id.seleccion_result);
        //supHa               = findViewById(R.id.sup_ha);
        addse               = findViewById(R.id.boton_add);
        listaClean          = findViewById(R.id.clean_list);
        edicionSup          = findViewById(R.id.text_produccion);
        listViewAgricola    = findViewById(R.id.listViewNames);

        fabProAgricola = findViewById(R.id.fab_next_pro_agricola);

        actividadAgricolaList = new ArrayList<>();
        db         = new DatabaseHelper(this);


        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, produccioAgricola);
        editTextComplete = findViewById(R.id.auto_complete);
        editTextComplete.setAdapter(adapter);

        editTextComplete.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                Log.e("========>>", editTextComplete.getText().toString());
                seleccionValor.setText(editTextComplete.getText().toString());
                valorSel = editTextComplete.getText().toString();
                //valorSel = parent.getSelectedItem().toString();
                funAgregar(valorSel);
            } });

        /*
        if(valorSel != null) {
            addse.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listaTemporal(valorSel);
                }
            });
        }

         */
        listaClean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                actividadAgricolaList.clear();
                listViewAgricola.setAdapter(null);
                //adapterAgricola.notifyDataSetChanged();
            }
        });

        fabProAgricola.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recorrerLista();
                startActivity(new Intent(getBaseContext(), ProduccionPecuaria.class));
            }
        });

    }

    private void funAgregar(final String valorSel) {
        if(valorSel != null) {
            addse.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listaTemporal(valorSel);
                }
            });
        }
    }

    private void recorrerLista() {
        VariablesGlobalesUpf.PRODUAGRI = "ss";
        VariablesGlobalesUpf.PRODSUPERF = null;
        //int vlSuperGet;
        int i;

        for (i=0; i < actividadAgricolaList.size(); i++){
            System.out.println(actividadAgricolaList.get(i).getNombreActividad());
            System.out.println(actividadAgricolaList.get(i).getSuperficie());
            VariablesGlobalesUpf.IDUPF = 1;
            VariablesGlobalesUpf.FOLIO = "PruebaFolio";
            VariablesGlobalesUpf.PRODUAGRI = actividadAgricolaList.get(i).getNombreActividad();
            VariablesGlobalesUpf.PRODSUPERF = actividadAgricolaList.get(i).getSuperficie();
            aggActAgricola();

        }
    }

    private void aggActAgricola() {
        boolean insertarData = db.addActividadAgricola();
        if(insertarData == true) {
            Toast.makeText(this, "Datos insertados correctamente", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Algo salio mal", Toast.LENGTH_LONG).show();
        }
    }

    private void listaTemporal(String valorSel) {
        //actividadAgricolaList.clear();

        seleccuinResult.setText(valorSel);

        //supHa.setText(valorSup);
        if(!edicionSup.getText().toString().isEmpty()) {
            valorSup = edicionSup.getText().toString();
            ActividadAgricola actividadAgricola = new ActividadAgricola(valorSel, valorSup, 1);
            actividadAgricolaList.add(actividadAgricola);

            adapterAgricola = new ActividadAgricolaAdapter(this, R.layout.lista_agricola, actividadAgricolaList);
            listViewAgricola.setAdapter(adapterAgricola);
        }

    }

    @Override
    public void onBackPressed() {

    }
}
