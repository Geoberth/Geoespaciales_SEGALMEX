package com.example.geosegalmex.caracterizacion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.geosegalmex.R;
import com.example.geosegalmex.caracterizacion.variables_caracterizacion.VariablesModuloCuatro;
import com.example.geosegalmex.unidadcaracterizacionhortalizas.db.DatabaseHelper;
import com.example.geosegalmex.unidadcaracterizacionhortalizas.model.MlTiempoRiego;
import com.example.geosegalmex.unidadcaracterizacionhortalizas.model.MlTiempoRiegoAdapter;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

public class ciclo_caracterizacion8 extends AppCompatActivity {
    ExtendedFloatingActionButton siguiente8;

    private MlTiempoRiegoAdapter tiempoRiegoAdapter;
    private ListView listViewTpRiego;
    private List<MlTiempoRiego> tiempoRiegoList;

    Button btnAddTmRg;
    Button btnClearTmRg;
    EditText edtCostAgua;
    EditText edtNumJor;
    private int cntNmRg = 0;

    private DatabaseHelper db;

    private String NUMRIEGR= null;// IntegerNúmero de riego
    private String RIECOSGR= null;// IntegerCosto del riego ($/riego)
    private String JORGR= null;// IntegerNúm. Jornales


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ciclo_caracterizacion8);

        db         = new DatabaseHelper(this);

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

        siguiente8 = findViewById(R.id.btn_sig8);

        btnAddTmRg      = findViewById(R.id.btn_add_tm_rg_agr);
        edtCostAgua     = findViewById(R.id.edt_cs_aga_agr);
        edtNumJor       = findViewById(R.id.edt_nm_jr_agr);
        listViewTpRiego = findViewById(R.id.list_tmp_rig_agr);
        btnClearTmRg      = findViewById(R.id.btn_cle_tm_rg_agr);

        tiempoRiegoList = new ArrayList<>();
        tiempoRiegoList.clear();

        btnAddTmRg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(!edtCostAgua.getText().toString().isEmpty() && !edtNumJor.getText().toString().isEmpty()){
                    String costoAgua    = edtCostAgua.getText().toString();
                    String numJorn     = edtNumJor.getText().toString();
                    cntNmRg = cntNmRg + 1;
                    listaTiempoRiego(cntNmRg, costoAgua, numJorn);
                }else{
                    Snackbar snackbar = Snackbar.make(v, "Agregue los datos", Snackbar.LENGTH_SHORT);
                    snackbar.show();
                }
            }
        });


        btnClearTmRg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtCostAgua.setText("");
                edtNumJor.setText("");
                cntNmRg = 0;
                tiempoRiegoList.clear();
                listViewTpRiego.setAdapter(null);
            }
        });

        siguiente8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!edtCostAgua.getText().toString().isEmpty() && !edtNumJor.getText().toString().isEmpty()) {
                    recorreListaRiego();
                //    startActivity(new Intent(getBaseContext(), ControlMalezas.class));
                    startActivity(new Intent(getApplicationContext(), ciclo_caracterizacion9.class));
                }else{
                    Snackbar snackbar = Snackbar.make(v, "Agregue los datos", Snackbar.LENGTH_SHORT);
                    snackbar.show();
                }

            }
        });
    }

    private void recorreListaRiego() {
        int i;
        for(i=0; i < tiempoRiegoList.size(); i++){
            NUMRIEGR= String.valueOf(tiempoRiegoList.get(i).getNumRiego());
            RIECOSGR= String.valueOf(tiempoRiegoList.get(i).getCstAgua());
            JORGR = String.valueOf(tiempoRiegoList.get(i).getNumJorn());

            VariablesModuloCuatro.NUMRIEGR = NUMRIEGR ;
            VariablesModuloCuatro.RIECOSGR = RIECOSGR;
            VariablesModuloCuatro.JORGR = JORGR;
            aggTiempoRiegoAgri();

        }
    }

    private void aggTiempoRiegoAgri() {
        boolean insertarData = db.addTiempoRiegoAgri();
        if(insertarData == true) {
            Toast.makeText(this, "Datos insertados correctamente", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Algo salio mal", Toast.LENGTH_LONG).show();
        }
    }

    private void listaTiempoRiego(int cntNmRg, String costoAgua, String numJorn) {
        float cstAgua  = Float.parseFloat(costoAgua);
        int   nmJornal = Integer.parseInt(numJorn);

        MlTiempoRiego mlTiempoRiego = new MlTiempoRiego(cntNmRg, cstAgua, nmJornal);
        tiempoRiegoList.add(mlTiempoRiego);

        tiempoRiegoAdapter = new MlTiempoRiegoAdapter(this, R.layout.lista_num_riego, tiempoRiegoList);
        listViewTpRiego.setAdapter(tiempoRiegoAdapter);
    }

    @Override
    public void onBackPressed() {

    }
}
