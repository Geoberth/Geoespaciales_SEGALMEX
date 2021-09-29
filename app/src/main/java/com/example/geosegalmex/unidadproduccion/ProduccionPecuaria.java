package com.example.geosegalmex.unidadproduccion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.geosegalmex.R;
import com.example.geosegalmex.unidadcaracterizacionhortalizas.db.DatabaseHelper;
import com.example.geosegalmex.unidadproduccion.variables.VariablesGlobalesUpf;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

public class ProduccionPecuaria extends AppCompatActivity {
    LinearLayout lnBovino;
    LinearLayout lnPorcino;
    LinearLayout lnAve;
    LinearLayout lnCaprino;
    LinearLayout lnOvino;
    LinearLayout lnAbejas;
    LinearLayout lnConejo;
    ExtendedFloatingActionButton fabProPec;

    //Edittext
    EditText edtBovino;
    EditText edtPorcino;
    EditText edtAve;
    EditText edtCaprino;
    EditText edtOvino;
    EditText edtAbejas;
    EditText edtConejo;

    Button btnOtraEspPecuaria;
    private DatabaseHelper db;

    private String ESPECIEPEC = null; //Bovino, Porcino, Ave, Caprino, Ovino, Abeja, Conejo

    private String CABZCOL = null;  //Bovino, Porcino, Ave, Caprino, Ovino, Abeja, Conejo

    private String PRODCARNE = null; //Bovino, Porcino, Ave, Caprino, Ovino, Conejo
    private String PRODLECHE = null; //Bovino, Caprino
    private String PRODLECH = null; // Porcino

    private String PRODHUEVO = null; // Ave
    private String PRODLANA = null; // Ovino
    private String PRODPIEL = null; // Conejo
    private String PRODPIE = null; //  Bovino,Porcino ,Caprino ,Ovino,Conejo
    private String PRODPOLLIT = null; //Ave
    private String PRODMIEL = null; // Abeja
    private String PRODREINA = null; //Abeja
    private String PRODJALEA = null; // Abeja
    private String PRODCERA = null; // Abeja
    private String PRODPOLEN = null; // Abeja
    private String PRODNUCLEO = null; // Abeja
    private String PRODPROP = null; // Abeja

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produccion_pecuaria);
        lnBovino = findViewById(R.id.ln_bovino);
        lnPorcino = findViewById(R.id.ln_porcino);
        lnAve = findViewById(R.id.ln_ave);
        lnCaprino = findViewById(R.id.ln_caprino);
        lnOvino = findViewById(R.id.ln_ovino);
        lnAbejas = findViewById(R.id.ln_abejas);
        lnConejo = findViewById(R.id.ln_conejo);

        edtBovino = findViewById(R.id.bovino_edit_tresdos);
        edtPorcino = findViewById(R.id.porcino_edit_tresdos);
        edtAve = findViewById(R.id.ave_edit_tresdos);
        edtCaprino = findViewById(R.id.caprino_edit_tresdos);
        edtOvino = findViewById(R.id.ovino_edit_tresdos);
        edtAbejas = findViewById(R.id.abejas_edit_tresdos);
        edtConejo = findViewById(R.id.conejo_edit_tresdos);


        fabProPec = findViewById(R.id.fab_next_pro_pecua);
        btnOtraEspPecuaria = findViewById(R.id.btn_otr_esp_pec);

        db         = new DatabaseHelper(this);

        final Spinner spinner = (Spinner) findViewById(R.id.especie_pecuaria);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.especiepecuaria, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Log.e("========>>", parent.getSelectedItem().toString());
                ESPECIEPEC = parent.getSelectedItem().toString();

                valdiFunEsp(ESPECIEPEC);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        btnOtraEspPecuaria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                seleccionValor(ESPECIEPEC);
                startActivity(new Intent(getApplication(), ProduccionPecuaria.class));
            }
        });


        fabProPec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Log.e("========>>", ESPECIEPEC);
                seleccionValor(ESPECIEPEC);



                startActivity(new Intent(getApplication(), ProduccionForestal.class));
            }
        });
    }

    private void seleccionValor(String especiepec) {
        switch (especiepec) {
            case "Bovino":
                CABZCOL = edtBovino.getText().toString();
                VariablesGlobalesUpf.ESPECIEPEC = "Bovino"; //Bovino, Porcino, Ave, Caprino, Ovino, Abeja, Conejo
                VariablesGlobalesUpf.CABZCOL = CABZCOL;  //Bovino, Porcino, Ave, Caprino, Ovino, Abeja, Conejo
                VariablesGlobalesUpf.PRODCARNE = PRODCARNE; //Bovino, Porcino, Ave, Caprino, Ovino, Conejo
                VariablesGlobalesUpf.PRODLECHE = PRODLECHE; //Bovino, Caprino
                VariablesGlobalesUpf.PRODPIE = PRODPIE; //  Bovino,Porcino ,Caprino ,Ovino,Conejo
                aggActPecuaria();
                break;
            case "Porcino":
                CABZCOL = edtPorcino.getText().toString();
                VariablesGlobalesUpf.ESPECIEPEC = "Porcino"; //Bovino, Porcino, Ave, Caprino, Ovino, Abeja, Conejo
                VariablesGlobalesUpf.CABZCOL = CABZCOL;  //Bovino, Porcino, Ave, Caprino, Ovino, Abeja, Conejo
                VariablesGlobalesUpf.PRODCARNE = PRODCARNE; //Bovino, Porcino, Ave, Caprino, Ovino, Conejo
                VariablesGlobalesUpf.PRODLECH = PRODLECH; // Porcino
                VariablesGlobalesUpf.PRODPIE = PRODPIE; //  Bovino,Porcino ,Caprino ,Ovino,Conejo
                aggActPecuaria();
                break;
            case "Ave":
                CABZCOL = edtAve.getText().toString();
                VariablesGlobalesUpf.ESPECIEPEC = "Ave"; //Bovino, Porcino, Ave, Caprino, Ovino, Abeja, Conejo
                VariablesGlobalesUpf.CABZCOL = CABZCOL;  //Bovino, Porcino, Ave, Caprino, Ovino, Abeja, Conejo
                VariablesGlobalesUpf.PRODCARNE = PRODCARNE; //Bovino, Porcino, Ave, Caprino, Ovino, Conejo
                VariablesGlobalesUpf.PRODHUEVO = PRODHUEVO; // Ave
                VariablesGlobalesUpf.PRODPOLLIT = PRODPOLLIT; //Ave
                aggActPecuaria();
                break;
            case "Caprino":
                CABZCOL = edtCaprino.getText().toString();
                VariablesGlobalesUpf.ESPECIEPEC = "Caprino"; //Bovino, Porcino, Ave, Caprino, Ovino, Abeja, Conejo
                VariablesGlobalesUpf.CABZCOL = CABZCOL;  //Bovino, Porcino, Ave, Caprino, Ovino, Abeja, Conejo
                VariablesGlobalesUpf.PRODCARNE = PRODCARNE; //Bovino, Porcino, Ave, Caprino, Ovino, Conejo
                VariablesGlobalesUpf.PRODLECHE = PRODLECHE; //Bovino, Caprino
                VariablesGlobalesUpf.PRODPIE = PRODPIE; //  Bovino,Porcino ,Caprino ,Ovino,Conejo
                aggActPecuaria();
                break;
            case "Ovino":
                CABZCOL = edtOvino.getText().toString();
                VariablesGlobalesUpf.ESPECIEPEC = "Ovino"; //Bovino, Porcino, Ave, Caprino, Ovino, Abeja, Conejo
                VariablesGlobalesUpf.CABZCOL = CABZCOL;  //Bovino, Porcino, Ave, Caprino, Ovino, Abeja, Conejo
                VariablesGlobalesUpf.PRODCARNE = PRODCARNE; //Bovino, Porcino, Ave, Caprino, Ovino, Conejo
                VariablesGlobalesUpf.PRODLANA = PRODLANA; // Ovino
                VariablesGlobalesUpf.PRODPIE = PRODPIE; //  Bovino,Porcino ,Caprino ,Ovino,Conejo
                aggActPecuaria();
                break;
            case "Abeja":
                CABZCOL = edtAbejas.getText().toString();
                VariablesGlobalesUpf.ESPECIEPEC = "Abeja";
                VariablesGlobalesUpf.CABZCOL = CABZCOL;  //Bovino, Porcino, Ave, Caprino, Ovino, Abeja, Conejo
                VariablesGlobalesUpf.PRODMIEL = PRODMIEL; // Abeja
                VariablesGlobalesUpf.PRODREINA = PRODREINA; //Abeja
                VariablesGlobalesUpf.PRODJALEA = PRODJALEA; // Abeja
                VariablesGlobalesUpf.PRODCERA = PRODCERA; // Abeja
                VariablesGlobalesUpf.PRODPOLEN = PRODPOLEN; // Abeja
                VariablesGlobalesUpf.PRODNUCLEO = PRODNUCLEO; // Abeja
                VariablesGlobalesUpf.PRODPROP = PRODPROP; // Abeja
                aggActPecuaria();
                break;
            case "Conejo":
                CABZCOL = edtConejo.getText().toString();
                VariablesGlobalesUpf.ESPECIEPEC = "Conejo"; //Bovino, Porcino, Ave, Caprino, Ovino, Abeja, Conejo
                VariablesGlobalesUpf.CABZCOL = CABZCOL;  //Bovino, Porcino, Ave, Caprino, Ovino, Abeja, Conejo
                VariablesGlobalesUpf.PRODCARNE = PRODCARNE; //Bovino, Porcino, Ave, Caprino, Ovino, Conejo
                VariablesGlobalesUpf.PRODPIEL = PRODPIEL; // Conejo
                VariablesGlobalesUpf.PRODPIE = PRODPIE; //  Bovino,Porcino ,Caprino ,Ovino,Conejo
                aggActPecuaria();
                break;
        }
    }

    private void valdiFunEsp(String especiepec) {
        switch (especiepec) {
            case "Especifique una actividad pecuaria":
                lnBovino.setVisibility(LinearLayout.GONE);
                lnPorcino.setVisibility(LinearLayout.GONE);
                lnAve.setVisibility(LinearLayout.GONE);
                lnCaprino.setVisibility(LinearLayout.GONE);
                lnOvino.setVisibility(LinearLayout.GONE);
                lnAbejas.setVisibility(LinearLayout.GONE);
                lnConejo.setVisibility(LinearLayout.GONE);
                cleanInfoRdEdt();
                break;
            case "Bovino":
                lnBovino.setVisibility(LinearLayout.VISIBLE);
                lnPorcino.setVisibility(LinearLayout.GONE);
                lnAve.setVisibility(LinearLayout.GONE);
                lnCaprino.setVisibility(LinearLayout.GONE);
                lnOvino.setVisibility(LinearLayout.GONE);
                lnAbejas.setVisibility(LinearLayout.GONE);
                lnConejo.setVisibility(LinearLayout.GONE);
                cleanInfoRdEdt();
                break;
            case "Porcino":
                lnBovino.setVisibility(LinearLayout.GONE);
                lnPorcino.setVisibility(LinearLayout.VISIBLE);
                lnAve.setVisibility(LinearLayout.GONE);
                lnCaprino.setVisibility(LinearLayout.GONE);
                lnOvino.setVisibility(LinearLayout.GONE);
                lnAbejas.setVisibility(LinearLayout.GONE);
                lnConejo.setVisibility(LinearLayout.GONE);
                cleanInfoRdEdt();
                break;
            case "Ave":
                lnBovino.setVisibility(LinearLayout.GONE);
                lnPorcino.setVisibility(LinearLayout.GONE);
                lnAve.setVisibility(LinearLayout.VISIBLE);
                lnCaprino.setVisibility(LinearLayout.GONE);
                lnOvino.setVisibility(LinearLayout.GONE);
                lnAbejas.setVisibility(LinearLayout.GONE);
                lnConejo.setVisibility(LinearLayout.GONE);
                cleanInfoRdEdt();
                break;
            case "Caprino":
                lnBovino.setVisibility(LinearLayout.GONE);
                lnPorcino.setVisibility(LinearLayout.GONE);
                lnAve.setVisibility(LinearLayout.GONE);
                lnCaprino.setVisibility(LinearLayout.VISIBLE);
                lnOvino.setVisibility(LinearLayout.GONE);
                lnAbejas.setVisibility(LinearLayout.GONE);
                lnConejo.setVisibility(LinearLayout.GONE);
                cleanInfoRdEdt();
                break;
            case "Ovino":
                lnBovino.setVisibility(LinearLayout.GONE);
                lnPorcino.setVisibility(LinearLayout.GONE);
                lnAve.setVisibility(LinearLayout.GONE);
                lnCaprino.setVisibility(LinearLayout.GONE);
                lnOvino.setVisibility(LinearLayout.VISIBLE);
                lnAbejas.setVisibility(LinearLayout.GONE);
                lnConejo.setVisibility(LinearLayout.GONE);
                cleanInfoRdEdt();
                break;
            case "Abeja":
                lnBovino.setVisibility(LinearLayout.GONE);
                lnPorcino.setVisibility(LinearLayout.GONE);
                lnAve.setVisibility(LinearLayout.GONE);
                lnCaprino.setVisibility(LinearLayout.GONE);
                lnOvino.setVisibility(LinearLayout.GONE);
                lnAbejas.setVisibility(LinearLayout.VISIBLE);
                lnConejo.setVisibility(LinearLayout.GONE);
                cleanInfoRdEdt();
                break;
            case "Conejo":
                lnBovino.setVisibility(LinearLayout.GONE);
                lnPorcino.setVisibility(LinearLayout.GONE);
                lnAve.setVisibility(LinearLayout.GONE);
                lnCaprino.setVisibility(LinearLayout.GONE);
                lnOvino.setVisibility(LinearLayout.GONE);
                lnAbejas.setVisibility(LinearLayout.GONE);
                lnConejo.setVisibility(LinearLayout.VISIBLE);
                cleanInfoRdEdt();
                break;

        }
    }

    private void cleanInfoRdEdt() {
        //  ESPECIEPEC = null; //Bovino, Porcino, Ave, Caprino, Ovino, Abeja, Conejo

        CABZCOL = null;  //Bovino, Porcino, Ave, Caprino, Ovino, Abeja, Conejo

        PRODCARNE = null; //Bovino, Porcino, Ave, Caprino, Ovino, Conejo
        PRODLECHE = null; //Bovino, Caprino
        PRODLECH = null; // Porcino

        PRODHUEVO = null; // Ave
        PRODLANA = null; // Ovino
        PRODPIEL = null; // Conejo
        PRODPIE = null; //  Bovino,Porcino ,Caprino ,Ovino,Conejo
        PRODPOLLIT = null; //Ave
        PRODMIEL = null; // Abeja
        PRODREINA = null; //Abeja
        PRODJALEA = null; // Abeja
        PRODCERA = null; // Abeja
        PRODPOLEN = null; // Abeja
        PRODNUCLEO = null; // Abeja
        PRODPROP = null; // Abeja
    }

    private void aggActPecuaria() {
        boolean insertarData = db.addActividadPecuaria();
        if(insertarData == true) {
            Toast.makeText(this, "Datos insertados correctamente", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Algo salio mal", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onBackPressed() {

    }





    //+++++++++++++++++++++++++++++++++++++++++++++++Bovino+++++++++++++++++++++++++++++++++++++
    public void carneBovino(View view) {
        boolean checkedTipo = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.carne_bovino_si:
                if (checkedTipo) {
                    PRODCARNE = "Si";
                }
                break;
            case R.id.carne_bovino_no:
                if (checkedTipo) {
                    PRODCARNE = "No";
                }
                break;
        }

    }

    public void lecheBovino(View view) {
        boolean checkedTipo = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.leche_bovino_si:
                if (checkedTipo) {
                    PRODLECHE = "Si";
                }
                break;
            case R.id.leche_bovino_no:
                if (checkedTipo) {
                    PRODLECHE = "No";
                }
                break;
        }

    }

    public void pieCriaBovino(View view) {
        boolean checkedTipo = ((RadioButton) view).isChecked();
        switch (view.getId()) {
            case R.id.piecria_bovino_si:
                if (checkedTipo) {
                    PRODPIE = "Si";
                }
                break;
            case R.id.piecria_bovino_no:
                if (checkedTipo) {
                    PRODPIE = "No";
                }
                break;
        }
    }

    //+++++++++++++++++++++++++++++++++++++++++++++++Porcino+++++++++++++++++++++++++++++++++++++
    public void carnePorcino(View view) {
        boolean checkedTipo = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.carne_porcino_si:
                if (checkedTipo) {
                    PRODCARNE = "Si";
                }
                break;
            case R.id.carne_porcino_no:
                if (checkedTipo) {
                    PRODCARNE = "No";
                }
                break;
        }
    }

    public void lechonPorcino(View view) {
        boolean checkedTipo = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.lechon_porcino_si:
                if (checkedTipo) {
                    PRODLECH = "Si";
                }
                break;
            case R.id.lechon_porcino_no:
                if (checkedTipo) {
                    PRODLECH = "No";
                }
                break;
        }
    }

    public void pieCriaPorcino(View view) {
        boolean checkedTipo = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.piecria_porcino_si:
                if (checkedTipo) {
                    PRODPIE = "Si";
                }
                break;
            case R.id.piecria_porcino_no:
                if (checkedTipo) {
                    PRODPIE = "No";
                }
                break;
        }
    }


    //+++++++++++++++++++++++++++++++++++++++++++++++Ave+++++++++++++++++++++++++++++++++++++
    public void carneAve(View view) {
        boolean checkedTipo = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.carne_ave_si:
                if (checkedTipo) {
                    PRODCARNE = "Si";
                }
                break;
            case R.id.carne_ave_no:
                if (checkedTipo) {
                    PRODCARNE = "No";
                }
                break;
        }
    }


    public void huevoAve(View view) {
        boolean checkedTipo = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.huevo_ave_si:
                if (checkedTipo) {
                    PRODHUEVO = "Si";
                }
                break;
            case R.id.huevo_ave_no:
                if (checkedTipo) {
                    PRODHUEVO = "No";
                }
                break;
        }

    }

    public void pieCriaAve(View view) {
        boolean checkedTipo = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.piecria_ave_si:
                if (checkedTipo) {
                    PRODPOLLIT = "Si";
                }
                break;
            case R.id.piecria_ave_no:
                if (checkedTipo) {
                    PRODPOLLIT = "No";
                }
                break;
        }
    }



    //+++++++++++++++++++++++++++++++++++++++++++++++Caprino+++++++++++++++++++++++++++++++++++++
    public void carneCaprino(View view) {
        boolean checkedTipo = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.carne_caprino_si:
                if (checkedTipo) {
                    PRODCARNE = "Si";
                }
                break;
            case R.id.carne_caprino_no:
                if (checkedTipo) {
                    PRODCARNE = "No";
                }
                break;
        }
    }

    public void lecheCaprino(View view) {
        boolean checkedTipo = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.leche_caprino_si:
                if (checkedTipo) {
                    PRODLECHE = "Si";
                }
                break;
            case R.id.leche_caprino_no:
                if (checkedTipo) {
                    PRODLECHE = "No";
                }
                break;
        }
    }


    public void pieCriaCaprino(View view) {
        boolean checkedTipo = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.piecria_caprino_si:
                if (checkedTipo) {
                    PRODPIE = "Si";
                }
                break;
            case R.id.piecria_caprino_no:
                if (checkedTipo) {
                    PRODPIE = "No";
                }
                break;
        }
    }
    //+++++++++++++++++++++++++++++++++++++++++++++++Ovino+++++++++++++++++++++++++++++++++++++
    public void carneOvino(View view) {
        boolean checkedTipo = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.carne_ovino_si:
                if (checkedTipo) {
                    PRODCARNE = "Si";
                }
                break;
            case R.id.carne_ovino_no:
                if (checkedTipo) {
                    PRODCARNE = "No";
                }
                break;
        }
    }

    public void lanaOvino(View view) {
        boolean checkedTipo = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.lana_ovino_si:
                if (checkedTipo) {
                    PRODLANA = "Si";
                }
                break;
            case R.id.lana_ovino_no:
                if (checkedTipo) {
                    PRODLANA = "No";
                }
                break;
        }
    }

    public void pieCriaOvino(View view) {
        boolean checkedTipo = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.piecria_ovino_si:
                if (checkedTipo) {
                    PRODPIE = "Si";
                }
                break;
            case R.id.piecria_ovino_no:
                if (checkedTipo) {
                    PRODPIE = "No";
                }
                break;
        }

    }


    //+++++++++++++++++++++++++++++++++++++++++++++++Abeja+++++++++++++++++++++++++++++++++++++
    public void miel(View view) {
        boolean checkedTipo = ((RadioButton) view).isChecked();
        switch (view.getId()) {
            case R.id.miel_si:
                if (checkedTipo) {
                    PRODMIEL = "Si";
                }
                break;
            case R.id.miel_no:
                if (checkedTipo) {
                    PRODMIEL = "No";
                }
                break;
        }
    }

    public void reinas(View view) {
        boolean checkedTipo = ((RadioButton) view).isChecked();
        switch (view.getId()) {
            case R.id.reinas_si:
                if (checkedTipo) {
                    PRODREINA = "Si";
                }
                break;
            case R.id.reinas_no:
                if (checkedTipo) {
                    PRODREINA = "No";
                }
                break;
        }
    }

    public void jalea(View view) {
        boolean checkedTipo = ((RadioButton) view).isChecked();
        switch (view.getId()) {
            case R.id.jalea_si:
                if (checkedTipo) {
                    PRODJALEA = "Si";
                }
                break;
            case R.id.jalea_no:
                if (checkedTipo) {
                    PRODJALEA = "No";
                }
                break;
        }
    }

    public void cera(View view) {
        boolean checkedTipo = ((RadioButton) view).isChecked();
        switch (view.getId()) {
            case R.id.cera_si:
                if (checkedTipo) {
                    PRODCERA = "Si";
                }
                break;
            case R.id.cera_no:
                if (checkedTipo) {
                    PRODCERA = "No";
                }
                break;
        }

    }


    public void polen(View view) {
        boolean checkedTipo = ((RadioButton) view).isChecked();
        switch (view.getId()) {
            case R.id.polen_si:
                if (checkedTipo) {
                    PRODPOLEN = "Si";
                }
                break;
            case R.id.polen_no:
                if (checkedTipo) {
                    PRODPOLEN = "No";
                }
                break;
        }
    }

    public void propoleo(View view) {
        boolean checkedTipo = ((RadioButton) view).isChecked();
        switch (view.getId()) {
            case R.id.propoleo_si:
                if (checkedTipo) {
                    PRODPROP = "Si";
                }
                break;
            case R.id.propoleo_no:
                if (checkedTipo) {
                    PRODPROP = "No";
                }
                break;
        }
    }

    public void nucleo(View view) {
        boolean checkedTipo = ((RadioButton) view).isChecked();
        switch (view.getId()) {
            case R.id.nuc_si:
                if (checkedTipo) {
                    PRODNUCLEO = "Si";
                }
                break;
            case R.id.nuc_no:
                if (checkedTipo) {
                    PRODNUCLEO = "No";
                }
                break;
        }
    }

    //+++++++++++++++++++++++++++++++++++++++++++++++Conejo+++++++++++++++++++++++++++++++++++++
    public void carneConejo(View view) {
        boolean checkedTipo = ((RadioButton) view).isChecked();
        switch (view.getId()) {
            case R.id.carne_conejo_si:
                if (checkedTipo) {
                    PRODCARNE = "Si";
                }
                break;
            case R.id.carne_conejo_no:
                if (checkedTipo) {
                    PRODCARNE = "No";
                }
                break;
        }
    }

    public void pielConejo(View view) {

        boolean checkedTipo = ((RadioButton) view).isChecked();
        switch (view.getId()) {
            case R.id.piel_conejo_si:
                if (checkedTipo) {
                    PRODPIEL = "Si";
                }
                break;
            case R.id.piel_conejo_no:
                if (checkedTipo) {
                    PRODPIEL = "No";
                }
                break;
        }
    }

    public void pieCriaConejo(View view) {

        boolean checkedTipo = ((RadioButton) view).isChecked();
        switch (view.getId()) {
            case R.id.piecria_conejo_si:
                if (checkedTipo) {
                    PRODPIE = "Si";
                }
                break;
            case R.id.piecria_conejo_no:
                if (checkedTipo) {
                    PRODPIE = "No";
                }
                break;
        }

    }


}
