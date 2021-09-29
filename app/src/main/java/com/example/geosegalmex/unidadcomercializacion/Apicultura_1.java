package com.example.geosegalmex.unidadcomercializacion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.geosegalmex.R;
import com.example.geosegalmex.unidadcaracterizacionhortalizas.db.DatabaseHelper;
import com.example.geosegalmex.unidadcomercializacion.bdcomercializacion.VariablesGlobalesCmrz;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

import java.util.ArrayList;

public class Apicultura_1 extends AppCompatActivity {
    Button btnOtro;
    ExtendedFloatingActionButton btnNexT;
    LinearLayout ln1;
    Boolean valBol;

    EditText edt1;
    EditText edt2;
    EditText edt3;
    EditText edt4;

    EditText edtOtroApic;

    private String txtApicola = null;
    ArrayList<String> mesSelecct;
    ArrayList<String> VentaSelecct;

    private String EDTOTROCANPROAPI = null;

    private String COMPROAPI = null;
    private String CANPROAPI = null;
    private String PORGENAUT = null;
    private String PORDESVEN = null;
    private String PREPROAPI = null;

    private String MESVENAPI = null;

    private String AQUVENAPI = null;

    private DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apicultura_1);

        mesSelecct = new ArrayList<>();
        VentaSelecct = new ArrayList<>();
        db = new DatabaseHelper(this);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

        btnOtro = findViewById(R.id.btn_otr_apic);
        btnNexT = findViewById(R.id.api_1);
        ln1 = findViewById(R.id.ln_api_1);

        edt1 = findViewById(R.id.edt_api_1);
        edt2 = findViewById(R.id.edt_api_2);
        edt3 = findViewById(R.id.edt_api_3);
        edt4 = findViewById(R.id.edt_api_4);

        edtOtroApic = findViewById(R.id.edt_otr_api);

        final Spinner spinner = (Spinner) findViewById(R.id.spn_pro_apic);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.producto_apicola, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Log.e("========>>", parent.getSelectedItem().toString());
                txtApicola = parent.getSelectedItem().toString();

                valorSeleccion(position, txtApicola);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {


            }
        });


        btnNexT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                asignacionValores();
                if(COMPROAPI != null) {
                    aggApicola();
                }
               // startActivity(new Intent(getApplicationContext(), IdentificacionCuestionario.class));
                startActivity(new Intent(getApplicationContext(), Apicultura_2.class));
            }
        });



        btnOtro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                asignacionValores();
                if(COMPROAPI != null) {
                    aggApicola();
                    startActivity(new Intent(getApplicationContext(), Apicultura_1.class));
                }

            }
        });




    }

    private void aggApicola() {
        boolean insertarData = db.addComercializacionApicola();
        if (insertarData == true) {
            Toast.makeText(this, "Datos insertados correctamente", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Algo salio mal", Toast.LENGTH_LONG).show();
        }
    }

    private void asignacionValores() {
        int i =0;


        if(!edtOtroApic.getText().toString().isEmpty()){
           EDTOTROCANPROAPI = edtOtroApic.getText().toString();
        }

        if(!edt1.getText().toString().isEmpty()){
            CANPROAPI = edt1.getText().toString();
        }

        if(!edt2.getText().toString().isEmpty()){
            PORGENAUT = edt2.getText().toString();
        }

        if(!edt3.getText().toString().isEmpty()){
            PORDESVEN = edt3.getText().toString();
        }

        if(!edt4.getText().toString().isEmpty()){
            PREPROAPI = edt4.getText().toString();
        }

        //+++++++++++++++++++Meses
        String mesList = null;
        if(mesSelecct.size() != 0) {
            for (i = 0; i < mesSelecct.size(); i++) {
                if (mesList == null) {
                    mesList = mesSelecct.get(i);
                } else if (mesList != null) {
                    mesList = mesList + "," + mesSelecct.get(i);
                }

            }
        }
        MESVENAPI = mesList;
        System.out.println(MESVENAPI);

        //+++++++++++++++++++Venta Apicola
        String ventaList = null;

        if(VentaSelecct.size() != 0) {
            for (i = 0; i < VentaSelecct.size(); i++) {
                if (ventaList == null) {
                    ventaList = VentaSelecct.get(i);
                } else if (ventaList != null) {
                    ventaList = ventaList + "," + VentaSelecct.get(i);
                }

            }
        }
        AQUVENAPI = ventaList;
        System.out.println(AQUVENAPI);

        //Asignar Valore a variables Globales
        VariablesGlobalesCmrz.COMPROAPI = COMPROAPI;
        VariablesGlobalesCmrz.EDTOTROCANPROAPI = EDTOTROCANPROAPI;
        VariablesGlobalesCmrz.CANPROAPI = CANPROAPI;
        VariablesGlobalesCmrz.PORGENAUT = PORGENAUT;
        VariablesGlobalesCmrz.PORDESVEN = PORDESVEN;
        VariablesGlobalesCmrz.PREPROAPI = PREPROAPI;

        VariablesGlobalesCmrz.MESVENAPI = MESVENAPI;

        VariablesGlobalesCmrz.AQUVENAPI = AQUVENAPI;

    }

    private void valorSeleccion(int position, String txtApicola) {
        if (position == 0) {
            valBol = false;
            COMPROAPI = null;
            enableDisableView(ln1, valBol);
            edtOtroApic.setText("");
            edtOtroApic.setVisibility(View.INVISIBLE);
        } else if (position != 0 && position < 8) {
            valBol = true;
            COMPROAPI = txtApicola;
            edtOtroApic.setText("");
            edtOtroApic.setVisibility(View.INVISIBLE);
            enableDisableView(ln1, valBol);
        }else if(position == 8){
            valBol = true;
            COMPROAPI = txtApicola;
            edtOtroApic.setVisibility(View.VISIBLE);
            enableDisableView(ln1, valBol);
        }
    }

    private void enableDisableView(View view, boolean enabled) {
        view.setEnabled(enabled);

        if (view instanceof ViewGroup) {
            ViewGroup group = (ViewGroup) view;

            for (int idx = 0; idx < group.getChildCount(); idx++) {
                enableDisableView(group.getChildAt(idx), enabled);
            }
        }
    }

    public void mesesVentaApic(View view) {
        boolean checkedTipo = ((CheckBox) view).isChecked();

        switch (view.getId()) {
            case R.id.ck_ms_api_1:
                if (checkedTipo) {
                    mesSelecct.add("Enero");
                } else {
                    mesSelecct.remove("Enero");
                }
                break;
            case R.id.ck_ms_api_2:
                if (checkedTipo) {
                    mesSelecct.add("Febrero");
                } else {
                    mesSelecct.remove("Febrero");
                }
                break;
            case R.id.ck_ms_api_3:
                if (checkedTipo) {
                    mesSelecct.add("Marzo");
                } else {
                    mesSelecct.remove("Marzo");
                }
                break;
            case R.id.ck_ms_api_4:
                if (checkedTipo) {
                    mesSelecct.add("Abril");
                } else {
                    mesSelecct.remove("Abril");
                }
                break;
            case R.id.ck_ms_api_5:
                if (checkedTipo) {
                    mesSelecct.add("Mayo");
                } else {
                    mesSelecct.remove("Mayo");
                }
                break;
            case R.id.ck_ms_api_6:
                if (checkedTipo) {
                    mesSelecct.add("Junio");
                } else {
                    mesSelecct.remove("Junio");
                }
                break;
            case R.id.ck_ms_api_7:
                if (checkedTipo) {
                    mesSelecct.add("Julio");
                } else {
                    mesSelecct.remove("Julio");
                }
                break;
            case R.id.ck_ms_api_8:
                if (checkedTipo) {
                    mesSelecct.add("Agosto");
                } else {
                    mesSelecct.remove("Agosto");
                }
                break;
            case R.id.ck_ms_api_9:
                if (checkedTipo) {
                    mesSelecct.add("Septiembre");
                } else {
                    mesSelecct.remove("Septiembre");
                }
                break;
            case R.id.ck_ms_api_10:
                if (checkedTipo) {
                    mesSelecct.add("Octubre");
                } else {
                    mesSelecct.remove("Octubre");
                }
                break;
            case R.id.ck_ms_api_11:
                if (checkedTipo) {
                    mesSelecct.add("Noviembre");
                } else {
                    mesSelecct.remove("Noviembre");
                }
                break;
            case R.id.ck_ms_api_12:
                if (checkedTipo) {
                    mesSelecct.add("Diciembre");
                } else {
                    mesSelecct.remove("Diciembre");
                }
                break;
        }
    }

    public void ventaApicola(View view) {
        boolean checkedTipo = ((CheckBox) view).isChecked();

        switch (view.getId()) {
            case R.id.ck_api_cm_1:
                if (checkedTipo) {
                    VentaSelecct.add("Consumidor");
                } else {
                    VentaSelecct.remove("Consumidor");
                }
                break;
            case R.id.ck_api_cm_2:
                if (checkedTipo) {
                    VentaSelecct.add("Revendedor");
                } else {
                    VentaSelecct.remove("Revendedor");
                }
                break;
            case R.id.ck_api_cm_3:
                if (checkedTipo) {
                    VentaSelecct.add("Industria");
                } else {
                    VentaSelecct.remove("Industria");
                }
                break;
        }
    }

    @Override
    public void onBackPressed() {

    }
}
