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
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.geosegalmex.R;
import com.example.geosegalmex.unidadcaracterizacionhortalizas.db.DatabaseHelper;
import com.example.geosegalmex.unidadcomercializacion.bdcomercializacion.VariablesGlobalesCmrz;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class comercializacion_3_1 extends AppCompatActivity {
    EditText edtVntGan1;
    EditText edtVntGan2;
    EditText edtVntGan3;
    EditText edtVntGan4;
    EditText edtVntGan5;
    ExtendedFloatingActionButton fabBtnNex;


    private String COMPROPEC = null;    //	String	ASPECTOS DE PRODUCTOS PECUARIOS COMERCIALIZADOS
    private String NUMCABVEN = null;    //	Stringeger	¿Cuántas cabezas vendió?
    private String NUMCABAUT = null;    //	Stringeger	¿Cuántas cabezas fueron de autoconsumo?
    private String PESO = null;    //	Stringeger	Peso promedio (kg)
    private String PREKG = null;    //	String	Precio promedio ($/kg)

    private String TIPVEN = null;    //	String	¿Vende su ganado en pie o lo sacrifica?

    private String LUGSACR = null;    //	String	¿Dónde sacrifica su ganado?
    private String PRECABZ = null;    //	String	Precio promedio ($/cabeza)
    private String MESVEN = null;    //	String	Mes de venta

    private String VENGANCON = null;    //	Stringeger	¿Vende su ganado al consumidor? (%)
    private String VENGANIN = null;    //	Stringeger	¿Vende su ganado a la industria?  (%)
    private String VENGANGA = null;    //	Stringeger	¿Vende su ganado a los ganaderos?  (%)
    private String VENGANINPc = null;    //	Stringeger	¿Vende su ganado a los Stringermediarios?  (%)

    private String DESTPRODLO = null;    //	Stringeger	Destino de la producción local (%)
    private String DESTPRODMU = null;    //	Stringeger	Destino de la producción municipal (%)
    private String DESTPRODES = null;    //	Stringeger	Destino de la producción estatal (%)
    private String DESTPRODNA = null;    //	Stringeger	Destino de la producción nacional (%)

    Boolean valChek;
    Button btnAggPntOtr;

    List<String> listaMeses;

    private DatabaseHelper db;

    //Edittext
    EditText edtCmr1;
    EditText edtCmr2;
    EditText edtCmr3;
    EditText edtCmr4;
    EditText edtCmr5;
    EditText edtCmr6;
    EditText edtCmr7;
    EditText edtCmr8;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comercializacion_3_1);

        db  = new DatabaseHelper(this);
        listaMeses = new ArrayList<>();

        fabBtnNex = findViewById(R.id.fab_nex_cm_pec);
        btnAggPntOtr = findViewById(R.id.fab_nex_otr_pro_vnt);

        edtVntGan1 = findViewById(R.id.edt_cab_ven_1);
        edtVntGan2 = findViewById(R.id.edt_cab_ven_2);
        edtVntGan3 = findViewById(R.id.edt_cab_ven_3);
        edtVntGan4 = findViewById(R.id.edt_cab_ven_4);
        edtVntGan5 = findViewById(R.id.edt_cab_ven_5);


        edtCmr1 = findViewById(R.id.edt_cmr_1);
        edtCmr2 = findViewById(R.id.edt_cmr_2);
        edtCmr3 = findViewById(R.id.edt_cmr_3);
        edtCmr4 = findViewById(R.id.edt_cmr_4);
        edtCmr5 = findViewById(R.id.edt_cmr_5);
        edtCmr6 = findViewById(R.id.edt_cmr_6);
        edtCmr7 = findViewById(R.id.edt_cmr_7);
        edtCmr8 = findViewById(R.id.edt_cmr_8);

        final Spinner spinner = (Spinner) findViewById(R.id.spn_vnt_cm_pec);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.COMPROPEC, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Log.e("========>>", parent.getSelectedItem().toString());
                COMPROPEC = parent.getSelectedItem().toString();
                valorSeleccion(COMPROPEC);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

                valChek = false;
            }
        });


        final Spinner spinnerDos = (Spinner) findViewById(R.id.spn_lgr_scr);
        ArrayAdapter<CharSequence> adapterDos = ArrayAdapter.createFromResource(this,
                R.array.LUGSACRIFICIO, android.R.layout.simple_spinner_item);
        adapterDos.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerDos.setAdapter(adapterDos);
        spinnerDos.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Log.e("========>>", parent.getSelectedItem().toString());
                LUGSACR = parent.getSelectedItem().toString();
                valorLugarSelSac(LUGSACR);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        /*
        final Spinner spinnerTres = (Spinner) findViewById(R.id.spi_mes_vnd);
        ArrayAdapter<CharSequence> adapterTres = ArrayAdapter.createFromResource(this,
                R.array.MESVEN, android.R.layout.simple_spinner_item);
        adapterTres.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTres.setAdapter(adapterTres);
        spinnerTres.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Log.e("========>>", parent.getSelectedItem().toString());
                MESVEN = parent.getSelectedItem().toString();
                valorSeleccionMes(MESVEN);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

*/


        btnAggPntOtr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valEditCmPecuaria();
                if(COMPROPEC != null) {
                    aggComercializacionPecuaria();
                    startActivity(new Intent(getApplicationContext(), comercializacion_3_1.class));
                }

            }
        });

        fabBtnNex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valEditCmPecuaria();
                if(COMPROPEC != null) {
                    aggComercializacionPecuaria();
                }
                startActivity(new Intent(getApplicationContext(), comercializacion_4.class));
            }
        });
    }

    private void aggComercializacionPecuaria() {
        boolean insertarData = db.addComercializacionPecuaria();
        if(insertarData == true) {
            Toast.makeText(this, "Datos insertados correctamente", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Algo salio mal", Toast.LENGTH_LONG).show();
        }
    }


    /*

    private void valorSeleccionMes(String mesven) {
        switch (mesven) {
            case "Seleccione mes":
                MESVEN = null;
                break;
            default:
                MESVEN = mesven;
                break;

        }
    }


     */
    private void valorLugarSelSac(String lugsacr) {
        switch (lugsacr) {
            case "Especifique el lugar":
                LUGSACR = null;
                break;
            default:
                LUGSACR = lugsacr;
                break;
        }
    }

    private void valorSeleccion(String compropec) {
        switch (compropec) {
            case "Especifique producto":
                COMPROPEC = null;
                NUMCABVEN = null;
                NUMCABAUT = null;
                PESO = null;
                PREKG = null;
                TIPVEN = null;
                LUGSACR = null;
                PRECABZ = null;
                MESVEN = null;
                VENGANCON = null;
                VENGANIN = null;
                VENGANGA = null;
                VENGANINPc = null;
                DESTPRODLO = null;
                DESTPRODMU = null;
                DESTPRODES = null;
                DESTPRODNA = null;
                valChek = false;
                break;
            default:
                COMPROPEC = compropec;
                valChek = true;
                break;

        }
    }

    private void valEditCmPecuaria() {

        if (!edtVntGan1.getText().toString().isEmpty()) {
            NUMCABVEN = edtVntGan1.getText().toString();
        }

        if (!edtVntGan2.getText().toString().isEmpty()) {
            NUMCABAUT = edtVntGan2.getText().toString();
        }

        if (!edtVntGan3.getText().toString().isEmpty()) {
            PESO = edtVntGan3.getText().toString();
        }

        if (!edtVntGan4.getText().toString().isEmpty()) {
            PREKG = edtVntGan4.getText().toString();
        }

        if (!edtVntGan5.getText().toString().isEmpty()) {
            PRECABZ = edtVntGan5.getText().toString();
        }


        String valirConca = null;
        int i = 0;
        if(listaMeses.size()!= 0) {
            for (i = 0; i < listaMeses.size(); i++) {
              //  System.out.println(listaMeses.get(i));
                if (valirConca == null) {
                    valirConca = listaMeses.get(i);
                } else if (valirConca != null) {
                    valirConca = valirConca + "," + listaMeses.get(i);
                }
            }

        }
        MESVEN = valirConca;

        if(!edtCmr1.getText().toString().isEmpty()){
            VENGANCON = edtCmr1.getText().toString();
        }

        if(!edtCmr2.getText().toString().isEmpty()){
            VENGANIN = edtCmr2.getText().toString();
        }

        if(!edtCmr3.getText().toString().isEmpty()){
            VENGANGA = edtCmr3.getText().toString();
        }

        if(!edtCmr4.getText().toString().isEmpty()){
            VENGANINPc = edtCmr4.getText().toString();
        }

        if(!edtCmr5.getText().toString().isEmpty()){
            DESTPRODLO = edtCmr5.getText().toString();
        }

        if(!edtCmr6.getText().toString().isEmpty()){
            DESTPRODMU = edtCmr6.getText().toString();
        }

        if(!edtCmr7.getText().toString().isEmpty()){
            DESTPRODES = edtCmr7.getText().toString();
        }

        if(!edtCmr8.getText().toString().isEmpty()){
            DESTPRODNA = edtCmr8.getText().toString();
        }


        VariablesGlobalesCmrz.COMPROPEC = COMPROPEC;    //	String

        VariablesGlobalesCmrz.NUMCABVEN = NUMCABVEN;    //	int
        VariablesGlobalesCmrz.NUMCABAUT = NUMCABAUT;    //	int
        VariablesGlobalesCmrz.PESO = PESO;    //	int
        VariablesGlobalesCmrz.PREKG = PREKG;    //	String

        VariablesGlobalesCmrz.TIPVEN = TIPVEN;    //	String
        VariablesGlobalesCmrz.LUGSACR = LUGSACR;    //	String

        VariablesGlobalesCmrz.PRECABZ = PRECABZ;    //	String

        VariablesGlobalesCmrz.MESVEN = MESVEN;    //	String
        VariablesGlobalesCmrz.VENGANCON = VENGANCON;    //	int
        VariablesGlobalesCmrz.VENGANIN = VENGANIN;    //	int
        VariablesGlobalesCmrz.VENGANGA = VENGANGA;    //	int
        VariablesGlobalesCmrz.VENGANIN = VENGANIN;    //	int
        VariablesGlobalesCmrz.DESTPRODLO = DESTPRODLO;    //	int
        VariablesGlobalesCmrz.DESTPRODMU = DESTPRODMU;    //	int
        VariablesGlobalesCmrz.DESTPRODES = DESTPRODES;    //	int
        VariablesGlobalesCmrz.DESTPRODNA = DESTPRODNA;    //	int


    }



    public void ventaGanadoQuien(View view) {
        boolean checkedTipo = ((CheckBox) view).isChecked();

        switch (view.getId()) {
            case R.id.ck_qi_vnt_gnd_1:
                if (checkedTipo) {
                    VENGANCON = "Consumidor";
                } else {
                    VENGANCON = null;
                }
                break;
            case R.id.ck_qi_vnt_gnd_2:
                if (checkedTipo) {
                    VENGANIN = "Industria";
                } else {
                    VENGANIN = null;
                }
                break;
            case R.id.ck_qi_vnt_gnd_3:
                if (checkedTipo) {
                    VENGANGA = "Ganaderos";
                } else {
                    VENGANGA = null;
                }
                break;
            case R.id.ck_qi_vnt_gnd_4:
                if (checkedTipo) {
                    VENGANINPc = "Intermediarios";
                } else {
                    VENGANINPc = null;
                }
                break;
        }

    }

    public void destinoProduccion(View view) {
        boolean checkedTipo = ((CheckBox) view).isChecked();

        switch (view.getId()) {
            case R.id.ck_des_pro_1:
                if (checkedTipo) {
                    DESTPRODLO = "Local";
                } else {
                    DESTPRODLO = null;
                }
                break;
            case R.id.ck_des_pro_2:
                if (checkedTipo) {
                    DESTPRODMU = "Municipal";
                } else {
                    DESTPRODMU = null;
                }
                break;
            case R.id.ck_des_pro_3:
                if (checkedTipo) {
                    DESTPRODES = "Estatal";
                } else {
                    DESTPRODES = null;
                }
                break;
            case R.id.ck_des_pro_4:
                if (checkedTipo) {
                    DESTPRODNA = "Nacional";
                } else {
                    DESTPRODNA = null;
                }
                break;
        }

    }

    public void ventaGanPieScr(View view) {
        boolean checkedTipo = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.ck_vnt_gan_scr_1:
                if (checkedTipo) {
                    TIPVEN = "En pie";
                }
                break;
            case R.id.ck_vnt_gan_scr_2:
                if (checkedTipo) {
                    TIPVEN = "Lo sacrifico";
                }
                break;
        }

    }

    public void mesesVenta31(View view) {
        boolean checkedTipo = ((CheckBox) view).isChecked();

        switch (view.getId()) {
            case R.id.ck_mes_1_1:
                if (checkedTipo) {
                    listaMeses.add("Enero");
                } else {
                    listaMeses.remove("Enero");
                }
                break;
            case R.id.ck_mes_1_2:
                if (checkedTipo) {
                    listaMeses.add("Febrero");
                } else {
                    listaMeses.remove("Febrero");
                }
                break;
            case R.id.ck_mes_1_3:
                if (checkedTipo) {
                    listaMeses.add("Marzo");
                } else {
                    listaMeses.remove("Marzo");
                }
                break;
            case R.id.ck_mes_1_4:
                if (checkedTipo) {
                    listaMeses.add("Abril");
                } else {
                    listaMeses.remove("Abril");
                }
                break;
            case R.id.ck_mes_1_5:
                if (checkedTipo) {
                    listaMeses.add("Mayo");
                } else {
                    listaMeses.remove("Mayo");
                }
                break;
            case R.id.ck_mes_1_6:
                if (checkedTipo) {
                    listaMeses.add("Junio");
                } else {
                    listaMeses.remove("Junio");
                }
                break;
            case R.id.ck_mes_1_7:
                if (checkedTipo) {
                    listaMeses.add("Julio");
                } else {
                    listaMeses.remove( "Julio");
                }
                break;
            case R.id.ck_mes_1_8:
                if (checkedTipo) {
                    listaMeses.add("Agosto");
                } else {
                    listaMeses.remove("Agosto");
                }
                break;
            case R.id.ck_mes_1_9:
                if (checkedTipo) {
                    listaMeses.add("Septiembre");
                } else {
                    listaMeses.remove("Septiembre");
                }
                break;
            case R.id.ck_mes_1_10:
                if (checkedTipo) {
                    listaMeses.add("Octubre");
                } else {
                    listaMeses.remove("Octubre");
                }
                break;
            case R.id.ck_mes_1_11:
                if (checkedTipo) {
                    listaMeses.add("Noviembre");
                } else {
                    listaMeses.remove("Noviembre");
                }
                break;
            case R.id.ck_mes_1_12:
                if (checkedTipo) {
                    listaMeses.add("Diciembre");
                } else {
                    listaMeses.remove("Diciembre");
                }
                break;
        }
    }

    @Override
    public void onBackPressed() {

    }
}
