package com.example.geosegalmex.unidadcomercializacion;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
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
import java.util.List;

public class comercializacion_4 extends AppCompatActivity {
    ExtendedFloatingActionButton co4;
    Button btnOtro;

    private	String	LECPECCANT	= null;			//	int
    private	String	LECPECCONS	= null;			//	int
    private	String	LECPECPROC	= null;			//	int
    private	String	LECPECVENT	= null;			//	int
    private	String	LECPECCOST	= null;		//	String
    //  private	String	MESVENLE	= null;		//	String pregunta
    private	String	MESVENLENE	= null;		//	String

    private	String	VENLEBOLI	= null;			//	int
    private	String	VENLEBOIN	= null;			//	int
    private	String	VENLEBOQUE	= null;			//	int
    private	String	VENLEBOLIN	= null;			//	int
    private	String	VENLEBOCON	= null;			//	int
    private	String	VENLEBOOTR	= null;			//	int
    private	String	VENLEBOOTREDIT	= null;			//	int

    private	String	VENLECAQUE	= null;			//	int
    private	String	VENLECAIN	= null;			//	int
    private	String	VENLECACON	= null;			//	int
    private	String	VENLECAOTR	= null;			//	int
    private	String	VENLECAOTREDIT	= null;			//	int


    EditText edtLecheProduc;
    EditText edtLecheDesti;
    EditText edtLecheProsa;
    EditText edtLecheVnd;
    EditText edtLechePrePro;


    EditText edtCaprinoOtro;
    EditText edtCpr1;
    EditText edtCpr2;
    EditText edtCpr3;
    EditText edtCpr4;

    EditText edtBovinoOtro;
    EditText edtBov1;
    EditText edtBov2;
    EditText edtBov3;
    EditText edtBov4;
    EditText edtBov5;
    EditText edtBov6;

    List<String> listaMeses = new ArrayList<>();

    LinearLayout lnCaprino;
    LinearLayout lnBovino;

    //valor seleccionado por el productor ya sea bovino o caprino
    private String txtCaprinoBovino = null;
    private DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comercializacion_4);
        co4 = findViewById(R.id.cr4);
        btnOtro = findViewById(R.id.btn_otr_pro_lec);

        edtLecheProduc = findViewById(R.id.edt_lec_pro);
        edtLecheDesti = findViewById(R.id.edt_lec_dec);
        edtLecheProsa = findViewById(R.id.edt_lec_dest);
        edtLecheVnd = findViewById(R.id.edt_lec_vnd);
        edtLechePrePro = findViewById(R.id.edt_lec_prc_pro);

        edtCaprinoOtro = findViewById(R.id.edt_otr_lec_cari);
        edtBovinoOtro = findViewById(R.id.edt_otr_lec_bovi);

        //+++++++++++++++++++++++
        lnCaprino = findViewById(R.id.ln_caprino_cmr);
        edtCpr1 = findViewById(R.id.edt_cpr_1);
        edtCpr2 = findViewById(R.id.edt_cpr_2);
        edtCpr3 = findViewById(R.id.edt_cpr_3);
        edtCpr4 = findViewById(R.id.edt_cpr_4);

        //+++++++++++++++++++++++++
        lnBovino = findViewById(R.id.ln_bovino_cmr);
        edtBov1 = findViewById(R.id.edt_bov_1);
        edtBov2 = findViewById(R.id.edt_bov_2);
        edtBov3 = findViewById(R.id.edt_bov_3);
        edtBov4 = findViewById(R.id.edt_bov_4);
        edtBov5 = findViewById(R.id.edt_bov_5);
        edtBov6 = findViewById(R.id.edt_bov_6);


        db  = new DatabaseHelper(this);



        final Spinner spinner = (Spinner) findViewById(R.id.spn_prd_lec);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.produccion_leche, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Log.e("========>>", parent.getSelectedItem().toString());
                txtCaprinoBovino = parent.getSelectedItem().toString();
                valorSeleccion(position, txtCaprinoBovino);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {


            }
        });



        btnOtro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                asignacionValores();
                valoresObtenidos();
                if(txtCaprinoBovino != null) {
                    aggProductoLeche();
                    startActivity(new Intent(getApplicationContext(), comercializacion_4.class));
                }
            }
        });

        co4.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                asignacionValores();
                valoresObtenidos();
                if(txtCaprinoBovino != null) {
                    aggProductoLeche();
                }
                startActivity(new Intent(getApplicationContext(), comercializacion_5.class));

            }
        });
    }

    private void aggProductoLeche() {
        boolean insertarData = db.addComercializacionLechero();
        if(insertarData == true) {
            Toast.makeText(this, "Datos insertados correctamente", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Algo salio mal", Toast.LENGTH_LONG).show();
        }
    }

    private void valoresObtenidos() {


        VariablesGlobalesCmrz.LECHEBOVCAP = txtCaprinoBovino;
        VariablesGlobalesCmrz.LECPECCANT = LECPECCANT;	//	int
        VariablesGlobalesCmrz.LECPECCONS = LECPECCONS;	//	int
        VariablesGlobalesCmrz.LECPECPROC = LECPECPROC;	//	int
        VariablesGlobalesCmrz.LECPECVENT = LECPECVENT;	//	int
        VariablesGlobalesCmrz.LECPECCOST = LECPECCOST;	//	String


        String valirConca = null;
        for (int i = 0; i <= listaMeses.size() - 1; i++) {
            System.out.println(listaMeses.get(i));
            if(valirConca == null){
                valirConca = listaMeses.get(i) + ",";
            }else {
                valirConca = valirConca + listaMeses.get(i) + ",";
            }
        }

        //  String r = listaMeses.stream().collect(Collectors.joining(""));
        if(valirConca != null) {
            MESVENLENE = valirConca;
            Log.e("=====>", valirConca);
        }else {
            MESVENLENE = null;
        }



        VariablesGlobalesCmrz.MESVENLENE = MESVENLENE;	//	String


        VariablesGlobalesCmrz.VENLEBOLI = VENLEBOLI;	//	int
        VariablesGlobalesCmrz.VENLEBOIN = VENLEBOIN;	//	int
        VariablesGlobalesCmrz.VENLEBOQUE = VENLEBOQUE;	//	int
        VariablesGlobalesCmrz.VENLEBOLIN = VENLEBOLIN;	//	int
        VariablesGlobalesCmrz.VENLEBOCON = VENLEBOCON;	//	int
        VariablesGlobalesCmrz.VENLEBOOTR = VENLEBOOTR;	//	int
        VariablesGlobalesCmrz.VENLEBOOTREDIT = VENLEBOOTREDIT;	//	int



        VariablesGlobalesCmrz.VENLECAQUE = VENLECAQUE;	//	int
        VariablesGlobalesCmrz.VENLECAIN = VENLECAIN;	//	int
        VariablesGlobalesCmrz.VENLECACON = VENLECACON;	//	int
        VariablesGlobalesCmrz.VENLECAOTR = VENLECAOTR;	//	int
        VariablesGlobalesCmrz.VENLECAOTREDIT = VENLECAOTREDIT;	//	int

    }

    private void valorSeleccion(int position, String txtCaprinoBovinoSelc) {
        switch (position){
            case 0:
                txtCaprinoBovino = null;
                lnCaprino.setVisibility(View.GONE);
                lnBovino.setVisibility(View.GONE);
                break;
            case 1:
                txtCaprinoBovino = txtCaprinoBovinoSelc;
                lnCaprino.setVisibility(View.VISIBLE);
                lnBovino.setVisibility(View.GONE);
                break;
            case 2:
                txtCaprinoBovino = txtCaprinoBovinoSelc;
                lnCaprino.setVisibility(View.GONE);
                lnBovino.setVisibility(View.VISIBLE);
                break;
        }
    }

    private void asignacionValores() {
        LECPECCANT = edtLecheProduc.getText().toString();
        LECPECCONS = edtLecheDesti.getText().toString();
        LECPECPROC = edtLecheProsa.getText().toString();
        LECPECVENT = edtLecheVnd.getText().toString();
        LECPECCOST = edtLechePrePro.getText().toString();

        VENLECAOTREDIT = edtCaprinoOtro.getText().toString();
        VENLEBOOTREDIT = edtBovinoOtro.getText().toString();

        if(!edtCpr1.getText().toString().isEmpty()){
            VENLECAQUE = edtCpr1.getText().toString();
        }

        if(!edtCpr2.getText().toString().isEmpty()){
            VENLECAIN = edtCpr2.getText().toString();
        }

        if(!edtCpr3.getText().toString().isEmpty()){
            VENLECACON = edtCpr3.getText().toString();
        }

        if(!edtCpr4.getText().toString().isEmpty()){
            VENLECAOTR = edtCpr4.getText().toString();
        }

        if(!edtBov1.getText().toString().isEmpty()){
            VENLEBOLI = edtBov1.getText().toString();
        }

        if(!edtBov2.getText().toString().isEmpty()){
            VENLEBOIN = edtBov2.getText().toString();
        }

        if(!edtBov3.getText().toString().isEmpty()){
            VENLEBOQUE = edtBov3.getText().toString();
        }

        if(!edtBov4.getText().toString().isEmpty()){
            VENLEBOLIN = edtBov4.getText().toString();
        }

        if(!edtBov5.getText().toString().isEmpty()){
            VENLEBOCON = edtBov5.getText().toString();
        }

        if(!edtBov6.getText().toString().isEmpty()){
            VENLEBOOTR = edtBov6.getText().toString();
        }
    }


    public void ventaLechaCaprino(View view) {
        boolean checkedTipo = ((CheckBox) view).isChecked();

        switch (view.getId()) {
            case R.id.ck_vnt_lec_cap_0:
                if (checkedTipo) {
                    VENLECAQUE = "Queseros";
                } else {
                    VENLECAQUE = null;
                }
                break;
            case R.id.ck_vnt_lec_cap_1:
                if (checkedTipo) {
                    VENLECAIN = "Intermediarios";
                } else {
                    VENLECAIN = null;
                }
                break;
            case R.id.ck_vnt_lec_cap_2:
                if (checkedTipo) {
                    VENLECACON = "Consumidor";
                } else {
                    VENLECACON = null;
                }
                break;
            case R.id.ck_vnt_lec_cap_3:
                if (checkedTipo) {
                    VENLECAOTR = "Otro";
                    edtCaprinoOtro.setEnabled(true);
                } else {
                    VENLECAOTR = null;
                    edtCaprinoOtro.setEnabled(false);
                    edtCaprinoOtro.setText("");
                }
                break;
        }
    }

    public void ventaLecheBovino(View view) {
        boolean checkedTipo = ((CheckBox) view).isChecked();

        switch (view.getId()) {
            case R.id.ck_vnt_lec_bov_1:
                if (checkedTipo) {
                    VENLEBOLI = "Liconsa";
                } else {
                    VENLEBOLI = null;
                }
                break;
            case R.id.ck_vnt_lec_bov_2:
                if (checkedTipo) {
                    VENLEBOIN = "Industria";
                } else {
                    VENLEBOIN = null;
                }
                break;
            case R.id.ck_vnt_lec_bov_3:
                if (checkedTipo) {
                    VENLEBOQUE = "Queseros";
                } else {
                    VENLEBOQUE = null;
                }
                break;
            case R.id.ck_vnt_lec_bov_4:
                if (checkedTipo) {
                    VENLEBOLIN = "Intermediario";
                } else {
                    VENLEBOLIN = null;
                }
                break;
            case R.id.ck_vnt_lec_bov_5:
                if (checkedTipo) {
                    VENLEBOCON = "Consumidor";
                } else {
                    VENLEBOCON = null;
                }
                break;
            case R.id.ck_vnt_lec_bov_6:
                if (checkedTipo) {
                    VENLEBOOTR = "Otro";
                    edtBovinoOtro.setEnabled(true);
                } else {
                    VENLEBOOTR = null;
                    VENLEBOOTREDIT = null;
                    edtBovinoOtro.setText("");
                    edtBovinoOtro.setEnabled(false);
                }
                break;
        }
    }

    public void mesesVenta(View view) {
        boolean checkedTipo = ((CheckBox) view).isChecked();

        switch (view.getId()) {
            case R.id.ck_mes_1:
                if (checkedTipo) {
                    MESVENLENE = "Enero";
                    listaMeses.add(MESVENLENE);
                } else {
                    listaMeses.remove("Enero");
                }
                break;
            case R.id.ck_mes_2:
                if (checkedTipo) {
                    MESVENLENE = "Febrero";
                    listaMeses.add(MESVENLENE);
                } else {
                    listaMeses.remove("Febrero");
                }
                break;
            case R.id.ck_mes_3:
                if (checkedTipo) {
                    MESVENLENE = "Marzo";
                    listaMeses.add(MESVENLENE);
                } else {
                    listaMeses.remove("Marzo");
                }
                break;
            case R.id.ck_mes_4:
                if (checkedTipo) {
                    MESVENLENE = "Abril";
                    listaMeses.add(MESVENLENE);
                } else {
                    listaMeses.remove("Abril");
                }
                break;
            case R.id.ck_mes_5:
                if (checkedTipo) {
                    MESVENLENE = "Mayo";
                    listaMeses.add(MESVENLENE);
                } else {
                    listaMeses.remove("Mayo");
                }
                break;
            case R.id.ck_mes_6:
                if (checkedTipo) {
                    MESVENLENE = "Junio";
                    listaMeses.add(MESVENLENE);
                } else {
                    listaMeses.remove("Junio");
                }
                break;
            case R.id.ck_mes_7:
                if (checkedTipo) {
                    MESVENLENE = "Julio";
                    listaMeses.add(MESVENLENE);
                } else {
                    listaMeses.remove( "Julio");
                }
                break;
            case R.id.ck_mes_8:
                if (checkedTipo) {
                    MESVENLENE = "Agosto";
                    listaMeses.add(MESVENLENE);
                } else {
                    listaMeses.remove("Agosto");
                }
                break;
            case R.id.ck_mes_9:
                if (checkedTipo) {
                    MESVENLENE = "Septiembre";
                    listaMeses.add(MESVENLENE);
                } else {
                    listaMeses.remove("Septiembre");
                }
                break;
            case R.id.ck_mes_10:
                if (checkedTipo) {
                    MESVENLENE = "Octubre";
                    listaMeses.add(MESVENLENE);
                } else {
                    listaMeses.remove("Octubre");
                }
                break;
            case R.id.ck_mes_11:
                if (checkedTipo) {
                    MESVENLENE = "Noviembre";
                    listaMeses.add(MESVENLENE);
                } else {
                    listaMeses.remove("Noviembre");
                }
                break;
            case R.id.ck_mes_12:
                if (checkedTipo) {
                    MESVENLENE = "Diciembre";
                    listaMeses.add(MESVENLENE);
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
