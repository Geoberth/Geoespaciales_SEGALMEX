package com.example.geosegalmex.unidadcomercializacion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.geosegalmex.R;
import com.example.geosegalmex.unidadcaracterizacionhortalizas.db.DatabaseHelper;
import com.example.geosegalmex.unidadcomercializacion.bdcomercializacion.VariablesGlobalesCmrz;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class comercializacion_5 extends AppCompatActivity {
    ExtendedFloatingActionButton co5;
    EditText edtOtrCmPrc;
    EditText edtProPrc1;
    EditText edtProPrc2;
    EditText edtProPrc3;
    EditText edtProPrc4;

    Button btnOtroPro;

    private String COMALPRO = null;    //	String	Comercialización de alimentos procesados
    private String COMALPROO = null;    //	String	Comercialización de alimentos procesados

    private String CUANPRO = null;    //	Integer	¿Cuánto se produce? (kg o l)
    private String CUADESAUT = null;    //	Integer	¿Cuánto se destina al autoconsumo? (kg o l)
    private String CUADESVEN = null;    //	Integer	¿Cuánto se vende? (kg o l)
    private String PRECIOAP = null;    //	String	Precio promedio ($/kg ó $/l)

    private String MESEQVEN = null;    //	String	Meses del año que vende
    private String AQUIVEN = null;    //	String	¿A quién le vende?

    List<String> listaMeses = new ArrayList<>();
    List<String> listaAlimentos = new ArrayList<>();
    private DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comercializacion_5);
        co5 = findViewById(R.id.cr5);
        edtOtrCmPrc = findViewById(R.id.edt_otr_cmr_prc);
        edtProPrc1 = findViewById(R.id.edt_pro_cm_1);
        edtProPrc2 = findViewById(R.id.edt_pro_cm_2);
        edtProPrc3 = findViewById(R.id.edt_pro_cm_3);
        edtProPrc4 = findViewById(R.id.edt_pro_cm_4);

        btnOtroPro = findViewById(R.id.btn_otr_alim_proce);

        db  = new DatabaseHelper(this);

        final Spinner spinnerTres = (Spinner) findViewById(R.id.spn_pro_proce);
        ArrayAdapter<CharSequence> adapterTres = ArrayAdapter.createFromResource(this,
                R.array.alimentos_procesados, android.R.layout.simple_spinner_item);
        adapterTres.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTres.setAdapter(adapterTres);
        spinnerTres.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Log.e("========>>", parent.getSelectedItem().toString());
                Log.e("========>>", String.valueOf(position));
                COMALPRO = parent.getSelectedItem().toString();

            /*
                if(position == 0){
                    COMALPRO = null;
                    edtOtrCmPrc.setVisibility(View.INVISIBLE);
                }

                if(position >= 1 || position < 5){
                    edtOtrCmPrc.setVisibility(View.INVISIBLE);
                    COMALPRO = parent.getSelectedItem().toString();
                }else if(position == 5){
                    edtOtrCmPrc.setVisibility(View.VISIBLE);
                }

             */
                valorSeleccionProductos(COMALPRO, position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        btnOtroPro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                asignarValores();
                mesesSeleccionados();
                alimentosProcesados();
                saveValorGlobal();
                if(COMALPRO != null) {
                    startActivity(new Intent(getApplicationContext(), comercializacion_5.class));
                }
            }
        });

        co5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                asignarValores();
                mesesSeleccionados();
                alimentosProcesados();
                saveValorGlobal();
                startActivity(new Intent(getApplicationContext(), comercializacion_6.class));
            }
        });
    }

    private void saveValorGlobal() {
        VariablesGlobalesCmrz.COMALPRO = COMALPRO;    //	String	Comercialización de alimentos procesados
        VariablesGlobalesCmrz.COMALPROO = COMALPROO;    //	String	Comercialización de alimentos procesados

        VariablesGlobalesCmrz.CUANPRO = CUANPRO;    //	Integer	¿Cuánto se produce? (kg o l)
        VariablesGlobalesCmrz.CUADESAUT = CUADESAUT;    //	Integer	¿Cuánto se destina al autoconsumo? (kg o l)
        VariablesGlobalesCmrz.CUADESVEN = CUADESVEN;    //	Integer	¿Cuánto se vende? (kg o l)
        VariablesGlobalesCmrz.PRECIOAP = PRECIOAP;    //	String	Precio promedio ($/kg ó $/l)

        VariablesGlobalesCmrz.MESEQVEN = MESEQVEN;    //	String	Meses del año que vende
        VariablesGlobalesCmrz.AQUIVEN = AQUIVEN;

        aggProductosProcesados();
    }

    private void aggProductosProcesados() {
        //addComercializacionProcesados
        boolean insertarData = db.addComercializacionProcesados();
        if(insertarData == true) {
            Toast.makeText(this, "Datos insertados correctamente", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Algo salio mal", Toast.LENGTH_LONG).show();
        }

    }

    private void alimentosProcesados() {
        String valirConca = null;
        for (int i = 0; i <= listaAlimentos.size() - 1; i++) {
            System.out.println(listaAlimentos.get(i));
            if (valirConca == null) {
                valirConca = listaAlimentos.get(i) + ",";
            } else {
                valirConca = valirConca + listaAlimentos.get(i) + ",";
            }
        }

        //  String r = listaMeses.stream().collect(Collectors.joining(""));
        if (valirConca != null) {
            AQUIVEN = valirConca;
            Log.e("=====>", valirConca);
        } else {
            AQUIVEN = null;
        }
    }

    private void mesesSeleccionados() {
        String valirConca = null;
        for (int i = 0; i <= listaMeses.size() - 1; i++) {
            System.out.println(listaMeses.get(i));
            if (valirConca == null) {
                valirConca = listaMeses.get(i) + ",";
            } else {
                valirConca = valirConca + listaMeses.get(i) + ",";
            }
        }

        //  String r = listaMeses.stream().collect(Collectors.joining(""));
        if (valirConca != null) {
            MESEQVEN = valirConca;
            Log.e("=====>", valirConca);
        } else {
            MESEQVEN = null;
        }
    }

    private void asignarValores() {
        if (!edtOtrCmPrc.getText().toString().isEmpty()) {
            COMALPROO = edtOtrCmPrc.getText().toString();
        }

        if (!edtProPrc1.getText().toString().isEmpty()) {
            CUANPRO = edtProPrc1.getText().toString();
        }

        if (!edtProPrc2.getText().toString().isEmpty()) {
            CUADESAUT = edtProPrc2.getText().toString();
        }

        if (!edtProPrc3.getText().toString().isEmpty()) {
            CUADESVEN = edtProPrc3.getText().toString();
        }

        if (!edtProPrc4.getText().toString().isEmpty()) {
            PRECIOAP = edtProPrc4.getText().toString();
        }


    }

    private void valorSeleccionProductos(String comalpro, int position) {
        switch (position) {
            case 0:
                COMALPRO = null;
                edtOtrCmPrc.setVisibility(View.INVISIBLE);
                break;
            case 5:
                edtOtrCmPrc.setVisibility(View.VISIBLE);
                COMALPRO = comalpro;
                System.out.println(COMALPRO);
                break;

            default:
                edtOtrCmPrc.setVisibility(View.INVISIBLE);
                COMALPRO = comalpro;
                System.out.println(COMALPRO);
                break;
            /*
                case "Leche Queso":
                break;
            case "Leche Yogurt":
                break;
            case "Caprino":
                break;
            case "Ovino":
                break;
            case "Otros":
                break;

             */
        }
    }

    public void mesVentaProcesados(View view) {
        boolean checkedTipo = ((CheckBox) view).isChecked();

        switch (view.getId()) {
            case R.id.ck_mes_prc_1:
                if (checkedTipo) {
                    listaMeses.add("Enero");
                } else {
                    listaMeses.remove("Enero");
                }
                break;
            case R.id.ck_mes_prc_2:
                if (checkedTipo) {
                    listaMeses.add("Febrero");
                } else {
                    listaMeses.remove("Febrero");
                }
                break;
            case R.id.ck_mes_prc_3:
                if (checkedTipo) {
                    listaMeses.add("Marzo");
                } else {
                    listaMeses.remove("Marzo");
                }
                break;
            case R.id.ck_mes_prc_4:
                if (checkedTipo) {
                    listaMeses.add("Abril");
                } else {
                    listaMeses.remove("Abril");
                }
                break;
            case R.id.ck_mes_prc_5:
                if (checkedTipo) {
                    listaMeses.add("Mayo");
                } else {
                    listaMeses.remove("Mayo");
                }
                break;
            case R.id.ck_mes_prc_6:
                if (checkedTipo) {
                    listaMeses.add("Junio");
                } else {
                    listaMeses.remove("Junio");
                }
                break;
            case R.id.ck_mes_prc_7:
                if (checkedTipo) {
                    listaMeses.add("Julio");
                } else {
                    listaMeses.remove("Julio");
                }
                break;
            case R.id.ck_mes_prc_8:
                if (checkedTipo) {
                    listaMeses.add("Agosto");
                } else {
                    listaMeses.remove("Agosto");
                }
                break;
            case R.id.ck_mes_prc_9:
                if (checkedTipo) {
                    listaMeses.add("Septiembre");
                } else {
                    listaMeses.remove("Septiembre");
                }
                break;
            case R.id.ck_mes_prc_10:
                if (checkedTipo) {
                    listaMeses.add("Octubre");
                } else {
                    listaMeses.remove("Octubre");
                }
                break;
            case R.id.ck_mes_prc_11:
                if (checkedTipo) {
                    listaMeses.add("Noviembre");
                } else {
                    listaMeses.remove("Noviembre");
                }
                break;
            case R.id.ck_mes_prc_12:
                if (checkedTipo) {
                    listaMeses.add("Diciembre");
                } else {
                    listaMeses.remove("Diciembre");
                }
                break;

        }
    }

    public void compradroProcesados(View view) {
        boolean checkedTipo = ((CheckBox) view).isChecked();

        switch (view.getId()) {
            case R.id.ck_aqi_vnt_1:
                if (checkedTipo) {
                    listaAlimentos.add("Consumidor");
                } else {
                    listaAlimentos.remove("Consumidor");
                }
                break;

            case R.id.ck_aqi_vnt_2:
                if (checkedTipo) {
                    listaAlimentos.add("Tiendas locales");
                } else {
                    listaAlimentos.remove("Tiendas locales");
                }
                break;

            case R.id.ck_aqi_vnt_3:
                if (checkedTipo) {
                    listaAlimentos.add("Revendedores");
                } else {
                    listaAlimentos.remove("Revendedores");
                }
                break;
        }
    }

    @Override
    public void onBackPressed() {

    }
}
