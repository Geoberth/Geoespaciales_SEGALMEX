package com.example.geosegalmex.frutales;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.geosegalmex.R;
import com.example.geosegalmex.frutales.dbfrutales.VariablesFrutales;
import com.example.geosegalmex.unidadcaracterizacionhortalizas.db.DatabaseHelper;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

import java.util.ArrayList;

public class frutales_13 extends AppCompatActivity {
    ExtendedFloatingActionButton f13;


    private String	NUMCOFR;	//	¿Cuántas cortes realiza?	13
    private String	TRAEMPFRU;	//	¿Cómo realiza el transporte al empaque?	13
    private String	TRAEMPFRUO;	//	Otro	13
    private String	TRAEMPFRUOEDIT;	//	Otro	13

    EditText edtCortesRealiza;
    EditText edtContOtro;
    ArrayList<String> empaqueList;

    EditText edt1;
    EditText edt2;
    EditText edt3;
    EditText edt4;
    EditText edt5;
    EditText edtOtrEmpaque;

    private DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frutales_13);
        empaqueList = new ArrayList<>();

        db = new DatabaseHelper(this);


        f13 = findViewById(R.id.fr13);
        edtCortesRealiza = findViewById(R.id.edt_can_cr_fe_frt);
        edtContOtro = findViewById(R.id.edt_otro_cnt_frut);

        edt1 = findViewById(R.id.edt_cj_cs_fe_frt);
        edt2 = findViewById(R.id.edt_cos_cs_fe_frt);
        edt3 = findViewById(R.id.edt_bol_cs_fe_frt);
        edt4 = findViewById(R.id.edt_cla_cs_fe_frt);
        edt5 = findViewById(R.id.edt_ote_cs_fe_frt);

        edtOtrEmpaque = findViewById(R.id.edt_otr_emp);

        f13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                asignacionValores();
                asignacionEmpaque();
                startActivity(new Intent(getApplicationContext(), frutales_14.class));
            }
        });
    }

    private void asignacionEmpaque() {
        int i =0;
        String Empaque = null;
        String CstEmpaque = null;
        String valorTemp = null;

        if(!empaqueList.isEmpty()) {
            for (i = 0; i < empaqueList.size(); i++) {

                if(empaqueList.get(i) == "Cajas"){
                    valorTemp = null;
                    if(!edt1.getText().toString().isEmpty()){
                       CstEmpaque = edt1.getText().toString();
                        System.out.println(empaqueList.get(i) + CstEmpaque);
                        aggEmpaques(empaqueList.get(i), CstEmpaque, valorTemp);
                    }
                }

                if(empaqueList.get(i) == "Costales"){
                    if(!edt2.getText().toString().isEmpty()){
                        valorTemp = null;
                        CstEmpaque = edt2.getText().toString();
                        System.out.println(empaqueList.get(i) + CstEmpaque);
                        aggEmpaques(empaqueList.get(i), CstEmpaque, valorTemp);
                    }
                }

                if(empaqueList.get(i) == "Bolsas"){
                    if(!edt3.getText().toString().isEmpty()){
                        valorTemp = null;
                        CstEmpaque = edt3.getText().toString();
                        System.out.println(empaqueList.get(i) + CstEmpaque);
                        aggEmpaques(empaqueList.get(i), CstEmpaque, valorTemp);
                    }
                }

                if(empaqueList.get(i) == "Clampshell"){
                    if(!edt4.getText().toString().isEmpty()){
                        valorTemp = null;
                        CstEmpaque = edt4.getText().toString();
                        System.out.println(empaqueList.get(i) + CstEmpaque);
                        aggEmpaques(empaqueList.get(i), CstEmpaque, valorTemp);
                    }
                }

                if(empaqueList.get(i) == "Otro"){
                    if(!edt5.getText().toString().isEmpty()){
                        CstEmpaque = edt5.getText().toString();
                        System.out.println(empaqueList.get(i) + CstEmpaque);
                        if(!edtOtrEmpaque.getText().toString().isEmpty()){
                            TRAEMPFRUOEDIT = edtOtrEmpaque.getText().toString();
                        }else{
                            TRAEMPFRUOEDIT = null;
                        }
                        aggEmpaques(empaqueList.get(i), CstEmpaque, TRAEMPFRUOEDIT);
                    }
                }



             //   System.out.println( );
            }
        }
    }

    private void aggEmpaques(String valorEmpaque, String cstEmpaque, String otroEdit) {
        boolean insertarData = db.addDatosFrutalesEmpaque(valorEmpaque, cstEmpaque, otroEdit);
        if(insertarData == true) {
            Toast.makeText(this, "Datos insertados correctamente", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Algo salio mal", Toast.LENGTH_LONG).show();
        }
    }

    private void asignacionValores() {

        if(!edtCortesRealiza.getText().toString().isEmpty()) {
            NUMCOFR = edtCortesRealiza.getText().toString();
        }

        if(!edtContOtro.getText().toString().isEmpty()){
            TRAEMPFRUO = edtContOtro.getText().toString();
        }

        VariablesFrutales.NUMCOFR = NUMCOFR;	//	¿Cuántas cortes realiza?	13
        VariablesFrutales.TRAEMPFRU = TRAEMPFRU;	//	¿Cómo realiza el transporte al empaque?	13
        VariablesFrutales.TRAEMPFRUO = TRAEMPFRUO;
        VariablesFrutales.TRAEMPFRUOEDIT = TRAEMPFRUOEDIT;
    }

    public void cortesRealiza(View view) {
        boolean checkedTipo = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.rd_crt_1:
                if (checkedTipo) {
                    TRAEMPFRU = "A granel";
                    TRAEMPFRUO = null;
                    edtContOtro.setText("");
                    edtContOtro.setEnabled(false);
                }
                break;
            case R.id.rd_crt_2:
                if (checkedTipo) {
                    TRAEMPFRU = "En contenedores y vehículo al aire libre";
                    TRAEMPFRUO = null;
                    edtContOtro.setText("");
                    edtContOtro.setEnabled(false);
                }
                break;
            case R.id.rd_crt_3:
                if (checkedTipo) {
                    TRAEMPFRU = "En contendores y vehículo cerrado";
                    TRAEMPFRUO = null;
                    edtContOtro.setText("");
                    edtContOtro.setEnabled(false);
                }
                break;
            case R.id.rd_crt_4:
                if (checkedTipo) {
                    TRAEMPFRU = "En contendores y vehículo refrigerado";
                    TRAEMPFRUO = null;
                    edtContOtro.setText("");
                    edtContOtro.setEnabled(false);
                }
                break;
            case R.id.rd_crt_5:
                if (checkedTipo) {
                    TRAEMPFRU = "Otro";
                    edtContOtro.setEnabled(true);
                }
                break;
        }
    }

    public void empaquesFrt(View view) {
        boolean checkedTipo = ((CheckBox) view).isChecked();

        switch (view.getId()) {
            case R.id.ck_cj_cs_fe_frt:
                if (checkedTipo) {
                    empaqueList.add("Cajas");
                    edt1.setEnabled(true);
                } else {
                    empaqueList.remove("Cajas");
                    edt1.setEnabled(false);
                    edt1.setText("");
                }
                break;
            case R.id.ck_cos_cs_fe_frt:
                if (checkedTipo) {
                    empaqueList.add("Costales");
                    edt2.setEnabled(true);
                } else {
                    empaqueList.remove("Costales");
                    edt2.setEnabled(false);
                    edt2.setText("");
                }
                break;
            case R.id.ck_bol_cs_fe_frt:
                if (checkedTipo) {
                    empaqueList.add("Bolsas");
                    edt3.setEnabled(true);
                } else {
                    empaqueList.remove("Bolsas");
                    edt3.setEnabled(false);
                    edt3.setText("");
                }
                break;
            case R.id.ck_cla_cs_fe_frt:
                if (checkedTipo) {
                    empaqueList.add("Clampshell");
                    edt4.setEnabled(true);
                } else {
                    empaqueList.remove("Clampshell");
                    edt4.setEnabled(false);
                    edt4.setText("");
                }
                break;
            case R.id.ck_ote_cs_fe_frt:
                if (checkedTipo) {
                    empaqueList.add("Otro");
                    edt5.setEnabled(true);
                    edtOtrEmpaque.setEnabled(true);
                } else {
                    empaqueList.remove("Otro");
                    edt5.setEnabled(false);
                    edt5.setText("");
                    edtOtrEmpaque.setEnabled(false);
                    edtOtrEmpaque.setText("");
                }
                break;
        }
    }

    @Override
    public void onBackPressed() {

    }
}
