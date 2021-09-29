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

public class frutales_12 extends AppCompatActivity {
    ExtendedFloatingActionButton f12;
    ArrayList<String> cosecha;

    EditText edtCsa1;
    EditText edtCsa2;
    EditText edtCsa3;
    EditText edtCsa4;
    EditText edtCsa5;
    EditText edtCsa6;
    EditText edtCsa7;
    EditText edtOtrFrt;
    EditText edtCualFrt;

    String txtTrata = null;
    String txtEmpaque = null;

    private String	ACCOSFR	= null;	//	¿Qué accesorios utiliza para la cosecha?	11
    private String	ACCOSFRO = null;	//	Otro	11
    private String	CINOFRU	= null;	//	¿Realiza algún control de inocuidad?	11
    private String	INOFRUT	= null;	//	¿Cuál?	11

    private String ACTCOSECHFRT = null;
    private String JORCOSGRFRT = null;
    private DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frutales_12);

        cosecha = new ArrayList<>();
        db = new DatabaseHelper(this);
        f12 = findViewById(R.id.fr12);

        edtCsa1 = findViewById(R.id.edt_cor_cs_fe_frt_1);
        edtCsa2 = findViewById(R.id.edt_cor_cs_fe_frt_2);
        edtCsa3 = findViewById(R.id.edt_cor_cs_fe_frt_3);
        edtCsa4 = findViewById(R.id.edt_cor_cs_fe_frt_4);
        edtCsa5 = findViewById(R.id.edt_cor_cs_fe_frt_5);
        edtCsa6 = findViewById(R.id.edt_cor_cs_fe_frt_6);
        edtCsa7 = findViewById(R.id.edt_cor_cs_fe_frt_7);

        edtOtrFrt = findViewById(R.id.edt_otr_cs_frt);
        edtCualFrt = findViewById(R.id.edt_si_ci_cs_fe_frt);

        f12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validarListaCosecha();
                startActivity(new Intent(getApplicationContext(), frutales_13.class));
            }
        });
    }

    private void validarListaCosecha() {
        int i =0;
        String valorStr;
        String valorCrt;


        if(!cosecha.isEmpty()) {
            System.out.println(cosecha.isEmpty());
            for (i = 0; i < cosecha.size(); i++) {
                valorStr = cosecha.get(i);
                System.out.println(cosecha.get(i));

                if (valorStr == "Corte") {
                    if (!edtCsa1.getText().toString().isEmpty()) {
                        valorCrt = edtCsa1.getText().toString();
                        System.out.println(cosecha.get(i) + valorCrt);
                        aggCosecha(valorStr, valorCrt);
                    }
                }

                if (valorStr == "Recolección") {
                    if (!edtCsa2.getText().toString().isEmpty()) {
                        valorCrt = edtCsa2.getText().toString();
                        System.out.println(cosecha.get(i) + valorCrt);
                        aggCosecha(valorStr, valorCrt);
                    }
                }

                if (valorStr == "Selección") {
                    if (!edtCsa3.getText().toString().isEmpty()) {
                        valorCrt = edtCsa3.getText().toString();
                        System.out.println(cosecha.get(i) + valorCrt);
                        aggCosecha(valorStr, valorCrt);
                    }
                }

                if (valorStr == "Lavado") {
                    if (!edtCsa4.getText().toString().isEmpty()) {
                        valorCrt = edtCsa4.getText().toString();
                        System.out.println(cosecha.get(i) + valorCrt);
                        aggCosecha(valorStr, valorCrt);
                    }
                }

                if (valorStr == "Tratamiento") {
                    if (!edtCsa5.getText().toString().isEmpty()) {
                        //System.out.println(cosecha.get(i) + valorStr);
                        valorCrt = edtCsa5.getText().toString();
                        System.out.println(txtTrata + valorCrt);
                        aggCosecha(valorStr, valorCrt);
                    }
                }

                if (valorStr == "Empaque") {
                    if (!edtCsa6.getText().toString().isEmpty()) {
                        //System.out.println(cosecha.get(i) + valorStr);
                        valorCrt = edtCsa6.getText().toString();
                        System.out.println(txtEmpaque + valorCrt);
                        aggCosecha(valorStr, valorCrt);
                    }
                }

                if (valorStr == "Acarreo") {
                    if (!edtCsa7.getText().toString().isEmpty()) {
                        //System.out.println(cosecha.get(i) + valorStr);
                        valorCrt = edtCsa7.getText().toString();
                        System.out.println(cosecha.get(i) + valorCrt);
                        aggCosecha(valorStr, valorCrt);
                    }
                }
            }
        }
        if(!edtOtrFrt.getText().toString().isEmpty()){
            ACCOSFRO = edtOtrFrt.getText().toString();
        }

        if(!edtCualFrt.getText().toString().isEmpty()){
            INOFRUT = edtCualFrt.getText().toString();
        }

        VariablesFrutales.ACCOSFR	= ACCOSFR;	//	¿Qué accesorios utiliza para la cosecha?	11
        VariablesFrutales.ACCOSFRO = ACCOSFRO;	//	Otro	11
        VariablesFrutales.CINOFRU	= CINOFRU;	//	¿Realiza algún control de inocuidad?	11
        VariablesFrutales.INOFRUT	= INOFRUT;

    }

    private void aggCosecha(String valorStr, String valorCrt) {
        boolean insertarData = db.addDatosFrutalesCosecha(valorStr, valorCrt);
        if(insertarData == true) {
            Toast.makeText(this, "Datos insertados correctamente", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Algo salio mal", Toast.LENGTH_LONG).show();
        }
    }

    public void cosechaActividadfrt(View view) {
        boolean checkedTipo = ((CheckBox) view).isChecked();

        switch (view.getId()) {
            case R.id.ck_crt_cs_fe__frt:
                if (checkedTipo) {
                    cosecha.add("Corte");
                    edtCsa1.setEnabled(true);

                } else {
                    cosecha.remove("Corte");
                    edtCsa1.setText("");
                    edtCsa1.setEnabled(false);
                }
                break;
            case R.id.ck_rec_cs_fe_frt:
                if (checkedTipo) {
                    cosecha.add("Recolección");
                    edtCsa2.setEnabled(true);

                } else {
                    cosecha.remove("Recolección");
                    edtCsa2.setText("");
                    edtCsa2.setEnabled(false);
                }
                break;

            case R.id.ck_sel_cs_fe_frt:
                if (checkedTipo) {
                    cosecha.add("Selección");
                    edtCsa3.setEnabled(true);

                } else {
                    cosecha.remove("Selección");
                    edtCsa3.setText("");
                    edtCsa3.setEnabled(false);
                }
                break;

            case R.id.ck_lvd_cs_fe_frt:
                if (checkedTipo) {
                    cosecha.add("Lavado");
                    edtCsa4.setEnabled(true);

                } else {
                    cosecha.remove("Lavado");
                    edtCsa4.setText("");
                    edtCsa4.setEnabled(false);
                }
                break;

            case R.id.ck_tpc_cs_fe_frt:
                if (checkedTipo) {
                    cosecha.add("Tratamiento");
                    txtTrata = "Tratamiento de post corte";
                    edtCsa5.setEnabled(true);

                } else {
                    cosecha.remove("Tratamiento");
                    txtTrata = null;
                    edtCsa5.setEnabled(false);
                    edtCsa5.setText("");
                }
                break;

            case R.id.ck_emc_cs_fe_frt:
                if (checkedTipo) {
                    cosecha.add("Empaque");
                    txtEmpaque = "Empaque en campo";
                    edtCsa6.setEnabled(true);

                } else {
                    cosecha.remove("Empaque en campo");
                    txtEmpaque = null;
                    edtCsa6.setEnabled(false);
                    edtCsa6.setText("");
                }
                break;


            case R.id.ck_acr_cs_fe_frt:
                if (checkedTipo) {
                    cosecha.add("Acarreo");
                    edtCsa7.setEnabled(true);

                } else {
                    cosecha.remove("Acarreo");
                    edtCsa7.setEnabled(false);
                    edtCsa7.setText("");
                }
                break;
        }


    }

    public void controlInocuidadfrt(View view) {
        boolean checkedTipo = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.rd_si_ci_cs_fe_frt:
                if (checkedTipo) {
                    CINOFRU = "Si";
                    edtCualFrt.setEnabled(true);
                }
                break;
            case R.id.rd_no_ci_cs_fe_frt:
                if (checkedTipo) {
                    CINOFRU = "No";
                    edtCualFrt.setEnabled(false);
                    INOFRUT = null;
                    edtCualFrt.setText("");
                }
                break;
        }
    }

    public void accesorioCosecha(View view) {
        boolean checkedTipo = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.rd_acs_cos_1:
                if (checkedTipo) {
                    ACCOSFR = "Pinzas o tijeras";
                    edtOtrFrt.setEnabled(false);
                    edtOtrFrt.setText("");
                    ACCOSFRO = null;
                }
                break;
            case R.id.rd_acs_cos_2:
                if (checkedTipo) {
                    ACCOSFR = "Bolsas especiales";
                    edtOtrFrt.setEnabled(false);
                    edtOtrFrt.setText("");
                    ACCOSFRO = null;
                }
                break;
            case R.id.rd_acs_cos_3:
                if (checkedTipo) {
                    ACCOSFR = "Recipientes";
                    edtOtrFrt.setEnabled(false);
                    edtOtrFrt.setText("");
                    ACCOSFRO = null;
                }
                break;
            case R.id.rd_acs_cos_4:
                if (checkedTipo) {
                    ACCOSFR = "Gancho especial";
                    edtOtrFrt.setEnabled(false);
                    edtOtrFrt.setText("");
                    ACCOSFRO = null;
                }
                break;
            case R.id.rd_acs_cos_5:
                if (checkedTipo) {
                    ACCOSFR = "Otro";
                    edtOtrFrt.setEnabled(true);
                }
                break;
        }
    }

    @Override
    public void onBackPressed() {

    }
}
