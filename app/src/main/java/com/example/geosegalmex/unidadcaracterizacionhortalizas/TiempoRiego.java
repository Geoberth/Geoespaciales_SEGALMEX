package com.example.geosegalmex.unidadcaracterizacionhortalizas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.geosegalmex.unidadcaracterizacionhortalizas.db.DatabaseHelper;
import com.example.geosegalmex.unidadcaracterizacionhortalizas.model.MlTiempoRiego;
import com.example.geosegalmex.unidadcaracterizacionhortalizas.model.MlTiempoRiegoAdapter;
import com.example.geosegalmex.R;
import com.example.geosegalmex.unidadcaracterizacionhortalizas.variables.VariblesGlobalesHortalizas;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

public class TiempoRiego extends AppCompatActivity {
    ExtendedFloatingActionButton fabTiempoRiego;
    private MlTiempoRiegoAdapter tiempoRiegoAdapter;
    private ListView listViewTpRiego;
    private List<MlTiempoRiego> tiempoRiegoList;
    Button btnAddTmRg;
    Button btnClearTmRg;
    EditText edtCostAgua;
    EditText edtNumJor;
    private int cntNmRg = 0;

    //Variables
    String txtCuandoRiega = null;

    private String NUMRIEGR = null;
    private String RIECOSGR = null;
    private String JORGR = null;
    private DatabaseHelper db;
    /*
    NUMRIEGR;
    RIECOSGR;
    JORGR;
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tiempo_riego);

        db         = new DatabaseHelper(this);

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

        fabTiempoRiego  = findViewById(R.id.fab_next_tr_fe);

        btnAddTmRg      = findViewById(R.id.btn_add_tm_rg);
        edtCostAgua     = findViewById(R.id.edt_cs_aga);
        edtNumJor       = findViewById(R.id.edt_nm_jr);
        listViewTpRiego = findViewById(R.id.list_tmp_rig);
        btnClearTmRg      = findViewById(R.id.btn_cle_tm_rg);

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

        fabTiempoRiego.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!edtCostAgua.getText().toString().isEmpty() && !edtNumJor.getText().toString().isEmpty()) {
                    recorreListaRiego();
                    startActivity(new Intent(getBaseContext(), ControlMalezas.class));
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

            VariblesGlobalesHortalizas.NUMRIEGR = NUMRIEGR ;
            VariblesGlobalesHortalizas.RIECOSGR = RIECOSGR;
            VariblesGlobalesHortalizas.JORGR = JORGR;
            aggTiempoRiego();

        }

    }

    private void aggTiempoRiego() {
        boolean insertarData = db.addTiempoRiego();
        if(insertarData == true) {
            Toast.makeText(this, "Datos insertados correctamente", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Algo salio mal", Toast.LENGTH_LONG).show();
        }
    }

    private void listaTiempoRiego(int cntNmRg,String costoAgua, String numJorn) {
        //MlTiempoRiego mlTiempoRiego = new MlTiempoRiego(1, costoAgua, numJorn);

        //String agua = String.valueOf(actividadTiempoRiego.getCstAgua());
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
