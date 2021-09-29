package com.example.geosegalmex.unidadproduccion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.geosegalmex.R;
import com.example.geosegalmex.drawer.fragment_drawer.bdmunicipios.ModelMunicipios;
import com.example.geosegalmex.drawer.fragment_drawer.bdmunicipios.UtilidadesEdoMunicipios;
import com.example.geosegalmex.unidadcaracterizacionhortalizas.db.DatabaseHelper;
import com.example.geosegalmex.unidadproduccion.variables.VariablesGlobalesUpf;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class UnidadProduccion extends AppCompatActivity {
    ExtendedFloatingActionButton extProAgricola;
    EditText editarEstado;

    private String ESTADOUPF = null;
    private String CVEEDOUPF = null;
    private String MUNPRUPF = null;
    private String CVEMUNUPF = null;
    private String LOCPRUPF = null;
    private String NOMUPF = null;
    //private int SUPUPF = 0;
    private String SUPUPF = null;

    EditText edtESTADOUPF;
    EditText edtMUNPRUPF;
    EditText edtLOCPRUPF;
    EditText edtNOMUPF;
    EditText edtSUPUPF;

    EditText edtLocalidad;

    private DatabaseHelper baseBD;
    Cursor cursor;
    ArrayList<ModelMunicipios> datosAzureArrayList;
    ArrayList<String> listaTempMunicipio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unidad_produccion);

        extProAgricola = findViewById(R.id.fab_next_pro_tres);

        baseBD                  = new DatabaseHelper(this);
        datosAzureArrayList = new ArrayList<>();
        listaTempMunicipio = new ArrayList<>();
        //EditText
        edtESTADOUPF = findViewById(R.id.ent_fed_tres);
        edtMUNPRUPF = findViewById(R.id.ent_municipio_tres);
        edtLOCPRUPF = findViewById(R.id.ent_localidad_tres);
        edtNOMUPF = findViewById(R.id.nombre_upf_tres);
        edtSUPUPF = findViewById(R.id.superficie_upf_tres);
        edtLocalidad = findViewById(R.id.edt_loc_upf);

        //editarEstado = findViewById(R.id.ent_fed_tres);

        Spinner spinner = (Spinner) findViewById(R.id.spn_edo_upf);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.combo_Estados, android.R.layout.simple_spinner_item);

        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                String edoSelec = parent.getSelectedItem().toString();

                System.out.println(position);


                if(position !=0) {
                    ESTADOUPF = edoSelec;
                    getMunicipio(edoSelec);
                    listaSpinnerMunicipios();
                    baseBD.close();
                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        extProAgricola.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

             //   Boolean ventFederativa = enteFederativa();
             //   Boolean vMunicipio = municipio();
             //   Boolean vLocalidad = localidad();



                Boolean vNombUpf = nombUpf();

                Boolean vSuperUpf = superUpf();

                if(!edtLocalidad.getText().toString().isEmpty()){
                    LOCPRUPF = edtLocalidad.getText().toString();
                }

                //if(ventFederativa || vMunicipio || vLocalidad || vNombUpf ||  vSuperUpf ){
                if(vNombUpf ||  vSuperUpf){
                    Snackbar snackbar = Snackbar.make(v, "Verique los campos incompletos", Snackbar.LENGTH_SHORT);
                    snackbar.show();
                }else {
                    VariablesGlobalesUpf.ESTADOUPF = ESTADOUPF;    //	Text
                    VariablesGlobalesUpf.CVEEDOUPF = CVEEDOUPF;    //	Integer
                    VariablesGlobalesUpf.MUNPRUPF = MUNPRUPF;    //	Text
                    VariablesGlobalesUpf.CVEMUNUPF = CVEMUNUPF;    //	Integer
                    VariablesGlobalesUpf.LOCPRUPF = LOCPRUPF;    //	Text
                    VariablesGlobalesUpf.NOMUPF = NOMUPF;    //	Text
                    VariablesGlobalesUpf.SUPUPF = SUPUPF;    //	Integer
                    startActivity(new Intent(getApplicationContext(), ProduccionAgricola.class));
                }


            }
        });



    }


    private void getMunicipio(String getEdo){
        datosAzureArrayList.clear();
        //Cursor cursor = baseBD.getListaMunicipios(getEdo);
        //cursor.close();
        cursor = baseBD.getListaMunicipios(getEdo);
        if (cursor.moveToFirst()) {
            do {
                ModelMunicipios name = new ModelMunicipios(
                        cursor.getInt(cursor.getColumnIndex(UtilidadesEdoMunicipios.COLUMN_CVE_ENT)),
                        cursor.getInt(cursor.getColumnIndex(UtilidadesEdoMunicipios.COLUMN_CVE_MUN)),
                        cursor.getInt(cursor.getColumnIndex(UtilidadesEdoMunicipios.COLUMN_CVEGEO)),
                        cursor.getString(cursor.getColumnIndex(UtilidadesEdoMunicipios.COLUMN_NOM_ENT)),
                        cursor.getString(cursor.getColumnIndex(UtilidadesEdoMunicipios.COLUMN_NOM_MUN))

                );
                datosAzureArrayList.add(name);
            } while (cursor.moveToNext());
            // cursor.close();

        }
        obtenerListaMunicipio();

    }


    private void obtenerListaMunicipio() {
        listaTempMunicipio = new ArrayList<String>();
        listaTempMunicipio.add("Seleccione");

        for(int i= 0; i < datosAzureArrayList.size(); i++ ){
            //listaTempMunicipio.add(datosAzureArrayList.get(i).getCOLUMN_CVE_ENT()+ "-" + datosAzureArrayList.get(i).getFechaEspecta());
            //listaTempMunicipio.add(datosAzureArrayList.get(i).getCOLUMN_CVE_ENT()+ "-" + datosAzureArrayList.get(i).getFechaEspecta());
            //listaTempMunicipio.add(String.valueOf(datosAzureArrayList.get(i).getCOLUMN_CVE_ENT()));
            listaTempMunicipio.add(datosAzureArrayList.get(i).getNOM_MUN());
            System.out.println(datosAzureArrayList.get(i).getNOM_MUN());
        }

        //listaSpinnerMunicipios();
    }


    private void listaSpinnerMunicipios() {
        Spinner spinnermunS = (Spinner) findViewById(R.id.spn_mun_upf);
        ArrayAdapter<CharSequence> adapterMun = new ArrayAdapter(this,android.R.layout.simple_spinner_item, listaTempMunicipio);
        spinnermunS.setAdapter(adapterMun);

        spinnermunS.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long idl) {

                String munSelec = parent.getSelectedItem().toString();
                MUNPRUPF = munSelec;
                // System.out.println(munSelec);
              //  compararSeleccion(munSelec);

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void compararSeleccion(String munSelec) {
        for (int i = 0; i < datosAzureArrayList.size(); i++){
            if(datosAzureArrayList.get(i).getNOM_MUN() == munSelec){
                int claveMun = datosAzureArrayList.get(i).getCOLUMN_CVE_MUN();
                System.out.println(claveMun);
            }
        }

    }

    private Boolean superUpf() {
        if(edtSUPUPF.getText().toString().isEmpty()){
            return true;
        }else if(!edtSUPUPF.getText().toString().isEmpty()){
            //SUPUPF = Integer.parseInt(edtSUPUPF.getText().toString());
            SUPUPF = edtSUPUPF.getText().toString();
            return false;
        }
        return false;
    }


    private Boolean nombUpf() {
        if (edtNOMUPF.getText().toString().isEmpty()){
            return true;
        }else if(!edtNOMUPF.getText().toString().isEmpty()){
            NOMUPF = edtNOMUPF.getText().toString();
            return false;
        }
        return false;
    }

    private Boolean localidad() {
        if(edtLOCPRUPF.getText().toString().isEmpty()){
            return true;
        }else if(!edtLOCPRUPF.getText().toString().isEmpty()){
            LOCPRUPF = edtLOCPRUPF.getText().toString();
            return false;
        }
        return false;
    }

    private Boolean municipio() {
        if(edtMUNPRUPF.getText().toString().isEmpty()){
            return true;
        }else  if(!edtMUNPRUPF.getText().toString().isEmpty()){
            MUNPRUPF = edtMUNPRUPF.getText().toString();
            return false;
        }
        return false;
    }

    private Boolean enteFederativa() {
        if(edtESTADOUPF.getText().toString().isEmpty()){
            return true;
        }else if(!edtESTADOUPF.getText().toString().isEmpty()){
            ESTADOUPF = edtESTADOUPF.getText().toString();
            return false;
        }
        return false;
    }

    @Override
    public void onBackPressed() {

    }
}
