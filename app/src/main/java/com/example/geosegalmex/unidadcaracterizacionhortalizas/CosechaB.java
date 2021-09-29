package com.example.geosegalmex.unidadcaracterizacionhortalizas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.geosegalmex.R;
import com.example.geosegalmex.unidadcaracterizacionhortalizas.db.DatabaseHelper;
import com.example.geosegalmex.unidadcaracterizacionhortalizas.variables.VariblesGlobalesHortalizas;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class CosechaB extends AppCompatActivity {
    ExtendedFloatingActionButton fabCoseB;

    EditText edtCajas;
    EditText edtCostales;
    EditText edtBolsas;
    EditText edtClampshell;
    EditText edtOtro;
    EditText edtOtroEspc;

    EditText edtCortesReal;

    //Variables
    String txtCajas = null;
    String txtCostales = null;
    String txtBolsas = null;
    String txtClampshell = null;
    String txtOtro = null;

    String txtedtCortesReal = null;

    ArrayList<String> listEmpaques;
    private DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cosecha_b);
        db = new DatabaseHelper(this);

        listEmpaques = new ArrayList<>();
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

        fabCoseB = findViewById(R.id.fab_next_cos_b_fe);

        edtCajas = findViewById(R.id.edt_cj_cs_fe);
        edtCostales = findViewById(R.id.edt_cos_cs_fe);
        edtBolsas = findViewById(R.id.edt_bol_cs_fe);
        edtClampshell = findViewById(R.id.edt_cla_cs_fe);
        edtOtro = findViewById(R.id.edt_ote_cs_fe);
        edtOtroEspc = findViewById(R.id.edt_otr_esp);

        edtCortesReal = findViewById(R.id.edt_can_cr_fe);

        fabCoseB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Boolean cathError = false;

                //cathError = validaCampos();
                validaCampos();

                if(cathError == false && !edtCortesReal.getText().toString().isEmpty()) {
                    if(!edtCortesReal.getText().toString().isEmpty()) {
                        txtedtCortesReal = edtCortesReal.getText().toString();
                        VariblesGlobalesHortalizas.NUMCHO = txtedtCortesReal;
                    }

                    startActivity(new Intent(getBaseContext(), PostCosecha.class));
                }else{
                    Snackbar snackbar = Snackbar.make(v, "Verifique su informacion", Snackbar.LENGTH_SHORT);
                    snackbar.show();
                }
            }
        });
    }

    private void validaCampos() {
        int i =0;
        String Empaque = null;
        String CstEmpaque = null;
        String valorTemp = null;
        if(!listEmpaques.isEmpty()) {
            for (i = 0; i < listEmpaques.size(); i++) {

                if(listEmpaques.get(i) == "Cajas") {
                    valorTemp = null;
                    if (!edtCajas.getText().toString().isEmpty()) {
                        CstEmpaque = edtCajas.getText().toString();
                        aggEmpaques(listEmpaques.get(i), CstEmpaque, valorTemp);
                    }
                }

                if(listEmpaques.get(i) == "Costales") {
                    valorTemp = null;
                    if (!edtCostales.getText().toString().isEmpty()) {
                        CstEmpaque = edtCostales.getText().toString();
                        aggEmpaques(listEmpaques.get(i), CstEmpaque, valorTemp);
                    }
                }

                if(listEmpaques.get(i) == "Bolsas") {
                    valorTemp = null;
                    if (!edtBolsas.getText().toString().isEmpty()) {
                        CstEmpaque = edtBolsas.getText().toString();
                        aggEmpaques(listEmpaques.get(i), CstEmpaque, valorTemp);
                    }
                }

                if(listEmpaques.get(i) == "Clampshell") {
                    valorTemp = null;
                    if (!edtClampshell.getText().toString().isEmpty()) {
                        CstEmpaque = edtClampshell.getText().toString();
                        aggEmpaques(listEmpaques.get(i), CstEmpaque, valorTemp);
                    }
                }

                if(listEmpaques.get(i) == "Otro") {
                    if (!edtOtro.getText().toString().isEmpty()) {
                        CstEmpaque = edtOtro.getText().toString();
                        if(!edtOtroEspc.getText().toString().isEmpty()){
                            valorTemp = edtOtroEspc.getText().toString();
                        } else{
                            valorTemp = null;
                        }
                        aggEmpaques(listEmpaques.get(i), CstEmpaque, valorTemp);
                    }
                }
            }
        }

    }

    private void aggEmpaques(String s, String cstEmpaque, String valorTemp) {
        boolean insertarData = db.addEmpaque(s, cstEmpaque, valorTemp);
        if(insertarData == true) {
            Toast.makeText(this, "Datos insertados correctamente", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Algo salio mal", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onBackPressed() {

    }

    public void empaqueCs(View view) {
        boolean checkedTipo = ((CheckBox) view).isChecked();

        switch (view.getId()) {
            case R.id.ck_cj_cs_fe:
                if (checkedTipo) {
                    listEmpaques.add("Cajas");
                    edtCajas.setEnabled(true);
                } else {
                    txtCajas = null;
                    listEmpaques.remove("Cajas");
                    edtCajas.setEnabled(false);
                    edtCajas.setText("");
                }
                break;
            case R.id.ck_cos_cs_fe:
                if (checkedTipo) {
                    listEmpaques.add("Costales");
                    edtCostales.setEnabled(true);
                } else {
                    txtCostales = null;
                    listEmpaques.remove("Costales");
                    edtCostales.setEnabled(false);
                    edtCostales.setText("");
                }
                break;
            case R.id.ck_bol_cs_fe:
                if (checkedTipo) {
                    listEmpaques.add("Bolsas");
                    edtBolsas.setEnabled(true);
                } else {
                    txtBolsas = null;
                    listEmpaques.remove("Bolsas");
                    edtBolsas.setEnabled(false);
                    edtBolsas.setText("");
                }
                break;
            case R.id.ck_cla_cs_fe:
                if (checkedTipo) {
                    listEmpaques.add("Clampshell");
                    edtClampshell.setEnabled(true);
                } else {
                    listEmpaques.remove("Clampshell");
                    txtClampshell = null;
                    edtClampshell.setText("");
                    edtClampshell.setEnabled(false);
                }
                break;
            case R.id.ck_ote_cs_fe:
                if (checkedTipo) {
                    listEmpaques.add("Otro");
                    edtOtro.setEnabled(true);
                    edtOtroEspc.setEnabled(true);
                } else {
                    txtOtro = null;
                    edtOtro.setText("");
                    listEmpaques.remove("Otro");
                    edtOtro.setEnabled(false);
                    edtOtroEspc.setText("");
                    edtOtroEspc.setEnabled(false);
                }
                break;
        }

    }
}