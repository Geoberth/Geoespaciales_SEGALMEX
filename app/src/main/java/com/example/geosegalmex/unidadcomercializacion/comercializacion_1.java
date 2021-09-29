package com.example.geosegalmex.unidadcomercializacion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.geosegalmex.R;
import com.example.geosegalmex.unidadcaracterizacionhortalizas.db.DatabaseHelper;
import com.example.geosegalmex.unidadcomercializacion.bdcomercializacion.VariablesGlobalesCmrz;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

public class comercializacion_1 extends AppCompatActivity {
    ExtendedFloatingActionButton co1;
    Button btnNexCom;
    Button btnOtrCom;

    EditText edtRndAPsd;
    EditText edtVolPrdPsd;
    EditText edtPrdDstVnt;
    EditText edtPrdDstAuto;
    EditText edtPrdDstGan;
    EditText edtPrdDstMerLoc;
    EditText edtPrdDstMerMun;
    EditText edtPrdDstMerGob;
    EditText edtPrdDstMerNac;
    EditText edtPrdVndCns;
    EditText edtPrdVndInd;
    EditText edtPrdVndDirGan;
    EditText edtProVndInt;

    private DatabaseHelper db;


    private	String	COMPROAGR = null;//	String	Aspectos de cultivos comercializados

    private	String	RTOCUL	= null;//	Integer	¿Qué rendimiento obtuvo en el año pasado? (ton/ha)
    private	String	VOLCUL	= null;//	Integer	¿Cuál fue el volumen de producción en el año pasado? (ton)
    private	String	PREMERUPA	= null;//	String	Precio medio rural ($/ton)
    private	String	VOLPROVEN	= null;//	Integer	¿Cuánto de su producción destinó a la venta? (ton)
    private	String	VOLPROCON	= null;//	Integer	¿Cuánto de su producción destinó para el autoconsumo? (ton)
    private	String	VOLPROGAN	= null;//	Integer	¿Cuánto de su producción destinó para el ganado? (ton)
    private	String	DEPROAGRLO	= null;//	Integer	¿Cuánto de su producción destinó para el mercado local? (ton)
    private	String	DEPROAGRMU	= null;//	Integer	¿Cuánto de su producción destinó para el mercado municipal? (ton)
    private	String	DEPROAGRES	= null;//	Integer	¿Cuánto de su producción destinó para el mercado estatal? (ton)
    private	String	DEPROAGRNA	= null;//	Integer	¿Cuánto de su producción destinó para el mercado nacional? (ton)
    private	String	TIVEPRAGCO	= null;//	Integer	¿Cuánto de su producción vendió directo al consumidor? (ton)
    private	String	TIVEPRAGIN	= null;//	Integer	¿Cuánto de su producción vendió directo a la industria? (ton)
    private	String	TIVEPRAGGA	= null;//	Integer	¿Cuánto de su producción vendió directo a los ganaderos? (ton)
    private	String	TIVEPRAGINAg = null;//	Integer	¿Cuánto de su producción vendió directo a los intermediarios? (ton)

    Boolean valChek;

    EditText edtPrcMdRl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comercializacion_1);
        co1 = findViewById(R.id.cr1);

        db  = new DatabaseHelper(this);



        btnNexCom = findViewById(R.id.btn_otr_cm_agr);
        edtRndAPsd= findViewById(R.id.edt_RndA_Psd_1);
        edtVolPrdPsd= findViewById(R.id.edt_RndA_Psd_2);
        edtPrdDstVnt= findViewById(R.id.edt_RndA_Psd_3);
        edtPrdDstAuto= findViewById(R.id.edt_RndA_Psd_4);
        edtPrdDstGan= findViewById(R.id.edt_RndA_Psd_5);
        edtPrdDstMerLoc= findViewById(R.id.edt_RndA_Psd_6);
        edtPrdDstMerMun= findViewById(R.id.edt_RndA_Psd_7);
        edtPrdDstMerGob= findViewById(R.id.edt_RndA_Psd_8);
        edtPrdDstMerNac= findViewById(R.id.edt_RndA_Psd_9);
        edtPrdVndCns= findViewById(R.id.edt_RndA_Psd_10);
        edtPrdVndInd= findViewById(R.id.edt_RndA_Psd_11);
        edtPrdVndDirGan= findViewById(R.id.edt_RndA_Psd_12);
        edtProVndInt= findViewById(R.id.edt_RndA_Psd_13);

        edtPrcMdRl = findViewById(R.id.edt_RndA_Psd_2_1);

        final Spinner spinner = (Spinner) findViewById(R.id.idSprelacupfint);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.COMERPROAGR, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Log.e("========>>", parent.getSelectedItem().toString());
                COMPROAGR = parent.getSelectedItem().toString();
                valorSeleccion(COMPROAGR);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                valChek = false;
            }
        });

        co1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                VariablesGlobalesCmrz.COMPROAGR = COMPROAGR;
                valoresAsignacion();
                if(valChek == true){
                    aggComercializacionAgricola();
                }
                startActivity(new Intent(getApplicationContext(), comercializacion_2.class));
            }
        });

        btnNexCom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                VariablesGlobalesCmrz.COMPROAGR = COMPROAGR;
                valoresAsignacion();
                if(valChek == true){
                    aggComercializacionAgricola();
                }
                startActivity(new Intent(getApplicationContext(), comercializacion_1.class));
            }
        });

    }

    private void aggComercializacionAgricola() {
        boolean insertarData = db.addComercializacionAgricola();
        if(insertarData == true) {
            Toast.makeText(this, "Datos insertados correctamente", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Algo salio mal", Toast.LENGTH_LONG).show();
        }
    }

    private void valorSeleccion(String comproagr) {
        switch(comproagr){
            case "Especifique producto":
                edtRndAPsd.setEnabled(false);
                edtVolPrdPsd.setEnabled(false);
                edtPrdDstVnt.setEnabled(false);
                edtPrdDstAuto.setEnabled(false);
                edtPrdDstGan.setEnabled(false);
                edtPrdDstMerLoc.setEnabled(false);
                edtPrdDstMerMun.setEnabled(false);
                edtPrdDstMerGob.setEnabled(false);
                edtPrdDstMerNac.setEnabled(false);
                edtPrdVndCns.setEnabled(false);
                edtPrdVndInd.setEnabled(false);
                edtPrdVndDirGan.setEnabled(false);
                edtProVndInt.setEnabled(false);
                edtPrcMdRl.setEnabled(false);
                edtRndAPsd.setText("");
                edtVolPrdPsd.setText("");
                edtPrdDstVnt.setText("");
                edtPrdDstAuto.setText("");
                edtPrdDstGan.setText("");
                edtPrdDstMerLoc.setText("");
                edtPrdDstMerMun.setText("");
                edtPrdDstMerGob.setText("");
                edtPrdDstMerNac.setText("");
                edtPrdVndCns.setText("");
                edtPrdVndInd.setText("");
                edtPrdVndDirGan.setText("");
                edtProVndInt.setText("");
                edtPrcMdRl.setText("");
                valChek = false;

                break;
            default:
                edtRndAPsd.setEnabled(true);
                edtVolPrdPsd.setEnabled(true);
                edtPrdDstVnt.setEnabled(true);
                edtPrdDstAuto.setEnabled(true);
                edtPrdDstGan.setEnabled(true);
                edtPrdDstMerLoc.setEnabled(true);
                edtPrdDstMerMun.setEnabled(true);
                edtPrdDstMerGob.setEnabled(true);
                edtPrdDstMerNac.setEnabled(true);
                edtPrdVndCns.setEnabled(true);
                edtPrdVndInd.setEnabled(true);
                edtPrdVndDirGan.setEnabled(true);
                edtProVndInt.setEnabled(true);
                edtPrcMdRl.setEnabled(true);
                valChek = true;
                break;

        }
    }

    private void valoresAsignacion() {

        if(!edtRndAPsd.getText().toString().isEmpty()) {
            RTOCUL = edtRndAPsd.getText().toString();
        }

        if(!edtVolPrdPsd.getText().toString().isEmpty()) {
            VOLCUL = edtVolPrdPsd.getText().toString();
        }

        if(!edtPrcMdRl.getText().toString().isEmpty()){
            PREMERUPA = edtPrcMdRl.getText().toString();
        }

        if(!edtPrdDstVnt.getText().toString().isEmpty()) {
            VOLPROVEN = edtPrdDstVnt.getText().toString();
        }

        if(!edtPrdDstAuto.getText().toString().isEmpty()) {
            VOLPROCON = edtPrdDstAuto.getText().toString();
        }

        if(!edtPrdDstGan.getText().toString().isEmpty()) {
            VOLPROGAN = edtPrdDstGan.getText().toString();
        }

        if(!edtPrdDstMerLoc.getText().toString().isEmpty()) {
            DEPROAGRLO = edtPrdDstMerLoc.getText().toString();
        }

        if(!edtPrdDstMerMun.getText().toString().isEmpty()) {
            DEPROAGRMU = edtPrdDstMerMun.getText().toString();
        }

        if(!edtPrdDstMerGob.getText().toString().isEmpty()) {
            DEPROAGRES = edtPrdDstMerGob.getText().toString();
        }

        if(!edtPrdDstMerNac.getText().toString().isEmpty()) {
            DEPROAGRNA = edtPrdDstMerNac.getText().toString();
        }

        if(!edtPrdVndCns.getText().toString().isEmpty()) {
            TIVEPRAGCO = edtPrdVndCns.getText().toString();
        }

        if(!edtPrdVndInd.getText().toString().isEmpty()) {
            TIVEPRAGIN = edtPrdVndInd.getText().toString();
        }

        if(!edtPrdVndDirGan.getText().toString().isEmpty()) {
            TIVEPRAGGA = edtPrdVndDirGan.getText().toString();
        }

        if(!edtProVndInt.getText().toString().isEmpty()) {
            TIVEPRAGINAg = edtProVndInt.getText().toString();
        }

        VariablesGlobalesCmrz.RTOCUL	=	RTOCUL;
        VariablesGlobalesCmrz.VOLCUL	=	VOLCUL;
        VariablesGlobalesCmrz.PREMERUPA	=	PREMERUPA;

        VariablesGlobalesCmrz.VOLPROVEN	=	VOLPROVEN;
        VariablesGlobalesCmrz.VOLPROCON	=	VOLPROCON;
        VariablesGlobalesCmrz.VOLPROGAN	=	VOLPROGAN;
        VariablesGlobalesCmrz.DEPROAGRLO	=	DEPROAGRLO;
        VariablesGlobalesCmrz.DEPROAGRMU	=	DEPROAGRMU;
        VariablesGlobalesCmrz.DEPROAGRES	=	DEPROAGRES;
        VariablesGlobalesCmrz.DEPROAGRNA	=	DEPROAGRNA;
        VariablesGlobalesCmrz.TIVEPRAGCO	=	TIVEPRAGCO;
        VariablesGlobalesCmrz.TIVEPRAGIN	=	TIVEPRAGIN;
        VariablesGlobalesCmrz.TIVEPRAGGA	=	TIVEPRAGGA;
        VariablesGlobalesCmrz.TIVEPRAGINAg	=	TIVEPRAGINAg;


    }

    @Override
    public void onBackPressed() {

    }

}
